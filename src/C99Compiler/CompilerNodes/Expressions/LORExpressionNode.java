// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.PreserveFlag;
import C99Compiler.Utils.ProgramState.ProcessorFlag;
import C99Compiler.Utils.AssemblyUtils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.BytewiseOperator;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Land_expressionContext;
import Grammar.C99.C99Parser.Lor_expressionContext;

public class LORExpressionNode extends LogicalBinaryExpressionNode
<Lor_expressionContext, Land_expressionContext, Land_expressionContext, Lor_expressionContext>
{
	private static class LOROperator extends BytewiseOperator
	{
		private OperandSource sourceX, sourceY;
		
		protected LOROperator(int size, OperandSource sourceX, OperandSource sourceY)
		{
			super(Math.max(sourceX.getSize(), sourceY.getSize()), Math.min(sourceX.getSize(), sourceY.getSize()), false);
			this.sourceX = sourceX;
			this.sourceY = sourceY;
		}

		@Override
		protected AssemblyStatePair getAssemblyAndState(ProgramState state, int i) throws Exception
		{
			AssemblyStatePair tmpPair;
			String assembly = "";
			
			tmpPair = sourceX.getLDA(state, i);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			
			tmpPair = sourceY.getInstruction(state, "ORA", i);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			
			assembly += state.getWhitespace() + "BNE\t:+\n";
			
			return new AssemblyStatePair(assembly, state);
		}
	}
	
	public LORExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Lor_expressionContext> getC1Node(Lor_expressionContext node) throws Exception
	{return new LORExpressionNode(this).interpret(node.lor_expression());}
	
	@Override
	protected BaseExpressionNode<Land_expressionContext> getC2Node(Lor_expressionContext node) throws Exception
	{return new LANDExpressionNode(this).interpret(node.land_expression());}

	@Override
	protected BaseExpressionNode<Land_expressionContext> getPCNode(Lor_expressionContext node) throws Exception
	{return new LANDExpressionNode(this).interpret(node.land_expression());}
	
	@Override public CastContext getCastContext() {return CastContext.logical;}
	
	@Override
	public Object getPropValue(ProgramState state)
	{
		boolean a = x.getPropBool(state);
		boolean b = y.getPropBool(state);
		return a || b;
	}
	
	@Override
	protected AssemblyStatePair getAssemblyAndState(ProgramState state, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		AssemblyStatePair tmpPair;
		String assembly = "";
		String whitespace = state.getWhitespace();
		
		byte flags = state.getPreserveFlags();
		assembly += AssemblyUtils.store(state, (byte) (PreserveFlag.A | PreserveFlag.X));
		state = state.clearPreserveFlags((byte) (PreserveFlag.A | PreserveFlag.X));

		assembly += whitespace + CompUtils.setXY8 + "\n";
		if (operator.equals("==")) assembly += whitespace + "LDX\t#$00\n";
		else if (operator.equals("!=")) assembly += whitespace + "LDX\t#$01\n";
		state = state.addPreserveFlags(PreserveFlag.X);

		assembly += whitespace + "LDX\t#$01\n";
		
		AssemblyStatePair pair = new LOROperator(sourceX.getSize(), sourceX, sourceY).getAssemblyAndState(state);
		assembly += pair.assembly;
		state = pair.state;
		
		assembly += whitespace + "DEX\n";
		assembly += ":" + whitespace.substring(1) + "TXA\n";
		assembly += whitespace + CompUtils.setA8 + "\n";
		state = state.setProcessorFlags(ProcessorFlag.M);
		if(state.destSource() != null)
		{
			tmpPair = state.destSource().getSTA(state, 0);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
		}
		assembly += AssemblyUtils.restore(state, (byte) (PreserveFlag.A | PreserveFlag.X));
		state = state.setPreserveFlags(flags);
		
		return new AssemblyStatePair(assembly, state);
	}
}
