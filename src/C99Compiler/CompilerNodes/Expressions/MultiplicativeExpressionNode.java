// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.Exceptions.UnsupportedFeatureException;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.PreserveFlag;
import C99Compiler.Utils.ProgramState.ProcessorFlag;
import C99Compiler.Utils.AssemblyUtils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.ByteCopier;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Cast_expressionContext;
import Grammar.C99.C99Parser.Multiplicative_expressionContext;

public class MultiplicativeExpressionNode extends BinaryExpressionNode
<Multiplicative_expressionContext, Cast_expressionContext, Cast_expressionContext, Multiplicative_expressionContext>
{
	private PostfixExpressionNode callExpr;
	
	private String getCallName()
	{
		String name = null;
		switch (operator)
		{
		case "*":
		{
			name = "__mul";
			if (y.getSize() > x.getSize()) // Halve needed mul calls by always putting largest operand first
			{
				BaseExpressionNode<?> tX = x;
				this.x = y;
				this.y = tX;
			}
			break;
		}
		case "/": name = "__div"; break;
		case "%": name = "__mod"; break;
		}
		
		name += (8 * this.x.getSize()) + "by" + (8 * this.y.getSize());
		return name;
	}
	
	public MultiplicativeExpressionNode(ComponentNode<?> parent)
	{
		super(parent);
		callExpr = null;
	}
	public MultiplicativeExpressionNode(ComponentNode<?> parent, String operator, BaseExpressionNode<?> x, BaseExpressionNode<?> y)
	{
		super(parent, operator, x, y);
		x.swapParent(this);
		y.swapParent(this);
		
		callExpr = new PostfixExpressionNode(this, getCallName(), x, y);
	}
	
	@Override
	protected BaseExpressionNode<Multiplicative_expressionContext> getC1Node(Multiplicative_expressionContext node) throws Exception
	{return new MultiplicativeExpressionNode(this).interpret(node.multiplicative_expression());}

	@Override
	protected BaseExpressionNode<Cast_expressionContext> getC2Node(Multiplicative_expressionContext node) throws Exception
	{return new CastExpressionNode(this).interpret(node.cast_expression());}

	@Override
	protected BaseExpressionNode<Cast_expressionContext> getPCNode(Multiplicative_expressionContext node) throws Exception
	{return new CastExpressionNode(this).interpret(node.cast_expression());}

	@Override
	public BaseExpressionNode<Multiplicative_expressionContext> interpret(Multiplicative_expressionContext node) throws Exception
	{
		BaseExpressionNode<Multiplicative_expressionContext> result = super.interpret(node);
		if (result != this) return result;
		if (operator.equals("/") && y.hasPropValue(new ProgramState()) && y.getPropLong(new ProgramState()) == 0) // Divide by zero
			throw new UnsupportedFeatureException("Division by zero", true, node.start);
		
		callExpr = new PostfixExpressionNode(this, getCallName(), x, y);
		
		return result;
	}
	
	@Override
	public boolean hasAssembly(ProgramState state)
	{
		return super.hasAssembly(state) || (!hasPropValue(state) && callExpr.hasAssembly(state));
	}
	@Override
	public boolean canCall(ProgramState state, FunctionDefinitionNode function)
	{
		return super.canCall(state, function) || (hasAssembly(state) && callExpr.canCall(state, function));
	}
	
	@Override
	public CastContext getCastContext()
	{
		switch (operator)
		{
		case "*": case "/": return CastContext.multiplicative;
		case "%": return CastContext.modulative;
		default: return CastContext.multiplicative;
		}
	}

	@Override
	public Object getPropValue(ProgramState state)
	{
		switch (operator)
		{
		case "*": return x.getPropLong(state) * y.getPropLong(state);
		case "/": return x.getPropLong(state) / y.getPropLong(state);
		case "%": return x.getPropLong(state) % y.getPropLong(state);
		default: return 0;
		}
	}

	@Override
	public Type getType()
	{
		int size = Math.max(Math.max(x.getSize(), y.getSize()), CompConfig.sizeOf("int"));
		boolean signed = x.getType().isSigned() || y.getType().isSigned();
		return CompUtils.getTypeForSize(size, signed);
	}

	// For when sign-handling wrapper is needed
	@Override
	protected AssemblyStatePair getAssemblyAndState(ProgramState state, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
		OperandSource destSource = state.destSource();
		ProgramState oldState = state;
		
		OperandSource sSourceX = CompConfig.specSubSource(true, sourceX.getSize());
		OperandSource sSourceY = CompConfig.specSubSource(false, sourceY.getSize());
		
		DummyExpressionNode dummyX, dummyY, dummyTemp;
		PostfixExpressionNode dummyCall;
		UnaryExpressionNode negation;
		
		dummyX = new DummyExpressionNode(this, x.getType(), sSourceX);
		dummyY = new DummyExpressionNode(this, y.getType(), sSourceY);
		dummyCall = new PostfixExpressionNode(this, getCallName()); // We use the above two to write to the parameters another way
		dummyTemp = new DummyExpressionNode(this, CompUtils.getTypeForSize(state.destSource().getSize(), true), state.destSource());

		pair.assembly += AssemblyUtils.store(pair.state, (byte) (PreserveFlag.A | PreserveFlag.Y));
		pair.state = pair.state.addPreserveFlags(PreserveFlag.Y); // We need the Y register for this
		pair.state = pair.state.clearPreserveFlags(PreserveFlag.A);
		
		// We need XY registers in 8-bit mode
		if (!pair.state.testKnownFlag(PreserveFlag.I) || pair.state.testProcessorFlag(ProcessorFlag.I)) // XY might be 16-bit
		{
			pair.assembly += pair.state.getWhitespace() + "SEP\t#$10\n";
			pair.state = pair.state.clearProcessorFlags(ProcessorFlag.I);
		}

		new ByteCopier(sSourceX, sourceX).apply(pair);
		new ByteCopier(sSourceY, sourceY).apply(pair);
		pair.assembly += pair.state.getWhitespace() + "LDY\t#$00\n"; // Set Y to 0
		pair.state = pair.state.fixYReg(0);
		// If one operand is negative: Y = 1 or -1. If neither or both: Y = 0.
		// Check X
		sourceX.applyLDA(pair, sourceX.getSize() - 1);
		pair.assembly += pair.state.getWhitespace() + "AND\t#$80\n";
		pair.state = pair.state.clearKnownFlags(ProgramState.PreserveFlag.A);
		pair.assembly += pair.state.getWhitespace() + "BEQ\t:+\n";
		pair.assembly += pair.state.getWhitespace() + "INY\n";
		pair.state = pair.state.setDestSource(sSourceX);
		negation = new UnaryExpressionNode(this, "-", dummyX);
		negation.apply(pair);
		removeChild(negation);
		pair.assembly += pair.state.getWhitespace() + ":\n";
		pair.state = pair.state.clearKnownFlags((byte) (ProgramState.PreserveFlag.Y | ProgramState.PreserveFlag.M | ProgramState.PreserveFlag.I));
		AssemblyUtils.forceFlags(pair, (byte) (PreserveFlag.M | PreserveFlag.I), false);
		// If one operand is negative: Y = 1 or -1. If neither or both: Y = 0.
		// Check Y
		sourceY.applyLDA(pair, sourceY.getSize() - 1);
		pair.assembly += pair.state.getWhitespace() + "AND\t#$80\n";
		pair.assembly += pair.state.getWhitespace() + "BEQ\t:+\n";
		pair.assembly += pair.state.getWhitespace() + "DEY\n";
		pair.state = pair.state.setDestSource(sSourceY);
		negation = new UnaryExpressionNode(this, "-", dummyY);
		negation.apply(pair);
		removeChild(negation);
		pair.assembly += pair.state.getWhitespace() + ":\n";
		pair.state = pair.state.clearKnownFlags((byte) (ProgramState.PreserveFlag.Y | ProgramState.PreserveFlag.M | ProgramState.PreserveFlag.I));
		AssemblyUtils.forceFlags(pair, (byte) (PreserveFlag.M | PreserveFlag.I), false);
		
		// Do math
		pair.state = pair.state.setDestSource(destSource);
		dummyCall.apply(pair);
		removeChild(dummyX);
		removeChild(dummyY);
		removeChild(dummyCall);
		
		pair.assembly += pair.state.getWhitespace() + "CPY\t#$00\n"; // Skip if neither or both are negative.
		pair.assembly += pair.state.getWhitespace() + "BEQ\t:+\n";
		// Do negation math from destSource  into itself
		// Choose signed int type no bgiger than we're writing to
		
		negation = new UnaryExpressionNode(this, "-", dummyTemp);
		negation.apply(pair);
		removeChild(dummyTemp);
		removeChild(negation);
		pair.assembly += pair.state.getWhitespace() + ":\n";
		pair.state = pair.state.clearKnownFlags((byte) (ProgramState.PreserveFlag.Y | ProgramState.PreserveFlag.M | ProgramState.PreserveFlag.I));
		
		// Cleanup
		pair.state = pair.state.setPreserveFlags(oldState.getPreserveFlags());
		pair.assembly += AssemblyUtils.restore(pair.state, (byte) (PreserveFlag.A | PreserveFlag.Y));
		
		return pair.getImmutable();
	}
	
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		if (getType().isSigned())
			return super.getAssemblyAndState(state);
		else
			return callExpr.getAssemblyAndState(state);
	}
}
