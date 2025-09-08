// By Iacon1
// Created 05/06/2023
// Assign one variable to another, more or less.
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.ArrayType;
import C99Compiler.CompilerNodes.Definitions.PointerType;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.Exceptions.ConstraintException;
import C99Compiler.Exceptions.ScratchOverflowException;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.ScratchSource;
import C99Compiler.Utils.AssemblyUtils.ByteCopier;
import C99Compiler.Utils.AssemblyUtils.SignExtender;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Assignment_expressionContext;
import Grammar.C99.C99Parser.Conditional_expressionContext;
import Grammar.C99.C99Parser.Unary_expressionContext;

public class AssignmentExpressionNode extends BinaryExpressionNode
<Unary_expressionContext, Assignment_expressionContext, Conditional_expressionContext, Assignment_expressionContext>
{
	@Override
	protected BaseExpressionNode<Unary_expressionContext> getC1Node(Assignment_expressionContext node) throws Exception
	{return new UnaryExpressionNode(this).interpret(node.unary_expression());}
	@Override
	protected BaseExpressionNode<Assignment_expressionContext> getC2Node(Assignment_expressionContext node) throws Exception
	{return new AssignmentExpressionNode(this).interpret(node.assignment_expression());}
	@Override
	protected BaseExpressionNode<Conditional_expressionContext> getPCNode(Assignment_expressionContext node) throws Exception
	{return new ConditionalExpressionNode(this).interpret(node.conditional_expression());}
	
	public AssignmentExpressionNode(ComponentNode<?> parent) {super(parent);}
	
	public AssignmentExpressionNode(ComponentNode<?> parent,
			BaseExpressionNode<?> x, BaseExpressionNode<?> y)
	{
		this.x = x;
		this.y = y;
	}
	@Override
	public BaseExpressionNode<Assignment_expressionContext> interpret(Assignment_expressionContext node) throws Exception
	{
		BaseExpressionNode sInt = super.interpret(node);
		if (sInt != this) return sInt;
		
		if (!x.hasLValue(new ProgramState()) || x.getType().isConstant())
			throw new ConstraintException("6.5.16", 2, node.getStart());
		
		if (y.getType().isArray()) // Decay array
			y = new CastExpressionNode(this, ((ArrayType) y.getType()).decay(), y);
		// Test as per 6.5.16.1.1
		Type xType = x.getType();
		Type yType = y.getType();
		
		if (!operator.startsWith("+") && !operator.startsWith("-"))
		{
			if (!xType.canCastTo(yType, CastContext.assignment))
				throw new ConstraintException("6.5.16.1", 1, node.getStart());
		}
		else
		{
			if (!xType.canCastFrom(yType, CastContext.add_assignment))
				throw new ConstraintException("6.5.16.2", 1, node.getStart());
		}
		
		BinaryExpressionNode<?,?,?,?> newY = null;
		switch (operator)
		{
		case "*=":
			newY = new MultiplicativeExpressionNode(this, "*", x, y);
			break;
		case "/=":
			newY = new MultiplicativeExpressionNode(this, "/", x, y);
			break;
		case "%=":
			newY = new MultiplicativeExpressionNode(this, "%", x, y);
			break;
		case "+=":
			newY = new AdditiveExpressionNode(this, "+", x, y);
			break;
		case "-=":
			newY = new AdditiveExpressionNode(this, "-", x, y);
			break;
		case "<<=":
			newY = new ShiftExpressionNode(this);
			newY.x = x;
			newY.operator = "<<";
			newY.y = y;
			break;
		case ">>=":
			newY = new ShiftExpressionNode(this);
			newY.x = x;
			newY.operator = ">>";
			newY.y = y;
			break;
		case "&=":
			newY = new AndExpressionNode(this);
			newY.x = x;
			newY.operator = "&";
			newY.y = y;
			break;
		case "^=":
			newY = new XOrExpressionNode(this);
			newY.x = x;
			newY.operator = "^";
			newY.y = y;
			break;
		case "|=":
			newY = new OrExpressionNode(this);
			newY.x = x;
			newY.operator = "|";
			newY.y = y;
			break;
		case "=": return this;
		}
		newY.interpret(null);
		y.swapParent(newY);
		y = newY;
		
		return this;
	}
	
	@Override public CastContext getCastContext() {return CastContext.assignment;}
	@Override public Type getType() {return x.getType();}
	@Override
	public boolean hasPropValue(ProgramState state) {return y.hasPropValue(state);}
	@Override
	public Object getPropValue(ProgramState state) {return y.getPropValue(state);}
	
	@Override
	public boolean hasLValue(ProgramState state)
	{
		return true;
	}
	@Override
	public LValueNode<?> getLValue(ProgramState state)
	{
		return x.getLValue(state);
	}
	
	@Override
	public boolean hasAssembly(ProgramState state)
	{
		if (x.hasPropValue(state) && y.hasPropValue(state))
		{
			if (x.getPropValue(state).equals(y.getPropValue(state)))
				return false;
		}
		return true;
	}
	
	@Override
	protected AssemblyStatePair getAssemblyAndState(ProgramState state, OperandSource sourceX, OperandSource sourceY) throws Exception {return null;}
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		AssemblyStatePair tmpPair;
		final OperandSource sourceY;
		OperandSource destSource;
		String assembly = "";
		
		if (x.hasAssembly(state))
		{
			tmpPair = x.getAssemblyAndState(state);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
		}
		
		destSource = x.getLValue(state).getSource();
		state = state.setDestSource(destSource);
//		if (!y.getType().canCastTo(x.getType()))
//			throw new TypeMismatchException(y.getType(), x.getType());
		if (y.hasAssembly(state))
		{
			sourceY = destSource;
			tmpPair = y.getAssemblyAndState(state);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
		}
		else
		{
			if (y.hasPropValue(state))
				sourceY = new ConstantSource(y.getPropValue(state), x.getType().getSize());
			else if (y.hasLValue(state))
				sourceY = y.getLValue(state).castTo(x.getType()).getSource();
			else sourceY = null;
			
			Logging.Logging.logNotice(y.getClass().getCanonicalName());
			tmpPair = new SignExtender(x.getLValue(state).getSource(), sourceY, x.getType().isSigned(), y.getType().isSigned()).getAssemblyAndState(state);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			
			ByteCopier copier = new ByteCopier(x.getLValue(state).getSource(), sourceY);
			tmpPair = copier.getAssemblyAndState(state);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
		}
		
		if (y.hasPropValue(state) && !x.isIndirect() && !x.getType().isVolatile() && !x.getLValue(state).getScope().isRoot())
		{
			if (x.getType().isArithmetic())
				state = state.setPossibleValue(x.getLValue(state), y.getPropLong(state, x.getType()));
			else
				state = state.setPossibleValue(x.getLValue(state), y.getPropValue(state));
		}

		return new AssemblyStatePair(assembly, state);
	}
}
