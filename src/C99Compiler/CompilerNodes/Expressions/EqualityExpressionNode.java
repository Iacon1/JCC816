// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.CompilerNodes.Dummies.DummyType;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.AssemblyUtils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.BytewiseOperator;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Equality_expressionContext;
import Grammar.C99.C99Parser.Relational_expressionContext;

public class EqualityExpressionNode extends BinaryExpressionNode
<Equality_expressionContext, Relational_expressionContext, Relational_expressionContext, Equality_expressionContext>
{
	private static class EqualityOperator extends BytewiseOperator
	{
		private OperandSource sourceX, sourceY;
		
		protected EqualityOperator(OperandSource sourceX, OperandSource sourceY)
		{
			super(sourceX.getSize(), sourceX.getSize(), false);
			this.sourceX = sourceX;
			this.sourceY = sourceY;
		}


		@Override
		protected AssemblyStatePair getAssemblyAndState(ProgramState state, int i) throws Exception
		{
			AssemblyStatePair tmpPair;
			String assembly = "";
			tmpPair = sourceX.getLDA(state, i);					// Get X
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			
			tmpPair = sourceY.getInstruction(state, "CMP", i); 	// Cmp X & Y?
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			
			assembly += state.getWhitespace() + "BNE\t:+\n";			// if [not op] then no
			return new AssemblyStatePair(assembly, state);
		}
		
	}
	public EqualityExpressionNode(ComponentNode<?> parent) {super(parent);}
	public EqualityExpressionNode(ComponentNode<?> parent, BaseExpressionNode<?> x, BaseExpressionNode<?> y)
	{
		super(parent);
		this.x = x;
		this.y = y;
	}
	public EqualityExpressionNode(ComponentNode<?> parent, BaseExpressionNode<?> x)
	{
		super(parent);
		this.x = x;
		this.y = new DummyExpressionNode(this, x.getType(), 0);
		this.operator = "==";
	}

	@Override
	protected BaseExpressionNode<Equality_expressionContext> getC1Node(Equality_expressionContext node) throws Exception
	{return new EqualityExpressionNode(this).interpret(node.equality_expression());}

	@Override
	protected BaseExpressionNode<Relational_expressionContext> getC2Node(Equality_expressionContext node) throws Exception
	{return new RelationalExpressionNode(this).interpret(node.relational_expression());}

	@Override
	protected BaseExpressionNode<Relational_expressionContext> getPCNode(Equality_expressionContext node) throws Exception
	{return new RelationalExpressionNode(this).interpret(node.relational_expression());}

	@Override
	public Type getType()
	{
		return new DummyType("char");
	}
	@Override
	public Object getPropValue(ProgramState state)
	{
		switch (operator)
		{
		case "==":
			return x.getPropValue(state).equals(y.getPropValue(state));
		case "!=":
			return x.getPropValue(state).equals(y.getPropValue(state));
		default: return null;
		}
	}
	
	@Override public CastContext getCastContext() {return CastContext.equality;}
	
	@Override
	protected AssemblyStatePair getAssemblyAndState(ProgramState state, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		String assembly = "";

		assembly += AssemblyUtils.store(state, (byte) (ProgramState.PreserveFlag.A | ProgramState.PreserveFlag.X));
		byte flags = state.getPreserveFlags();
		state = state.clearPreserveFlags((byte) (ProgramState.PreserveFlag.A | ProgramState.PreserveFlag.X));
		
		assembly += state.getWhitespace() + CompUtils.setXY8 + "\n";
		if (operator.equals("==")) assembly += state.getWhitespace() + "LDX\t#$00\n";
		else if (operator.equals("!=")) assembly += state.getWhitespace() + "LDX\t#$01\n";
		
		EqualityOperator op = new EqualityOperator(sourceX, sourceY);
		assembly += op.getAssembly(state);
		state = op.getStateAfter(state);
		if (operator.equals("==")) assembly += state.getWhitespace() + "INX\n";
		else if (operator.equals("!=")) assembly += state.getWhitespace() + "DEX\n";
		if (state.getWhitespace().length() >= 2)
			assembly += ":" + state.getWhitespace().substring(1) + "TXA\n";
		else
			assembly += ":TXA\n";
		assembly += state.getWhitespace() + CompUtils.setA8 + "\n";
		if (state.destSource() != null)
		{
			AssemblyStatePair tmpPair = state.destSource().getSTA(state, 0);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
		}
		
		state = state.addPreserveFlags(flags);
		assembly += AssemblyUtils.restore(state, (byte) (ProgramState.PreserveFlag.A | ProgramState.PreserveFlag.X));
		
		return new AssemblyStatePair(assembly, state);
	}
}
