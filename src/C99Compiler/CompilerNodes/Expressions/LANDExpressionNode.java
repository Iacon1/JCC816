// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.AssemblyUtils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.BytewiseOperator;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Land_expressionContext;
import Grammar.C99.C99Parser.Or_expressionContext;

public class LANDExpressionNode extends LogicalBinaryExpressionNode
<Land_expressionContext, Or_expressionContext, Or_expressionContext, Land_expressionContext>
{
	private static class LANDOperator extends BytewiseOperator
	{
		private OperandSource source;

		protected LANDOperator(OperandSource source)
		{
			super(source.getSize(), source.getSize(), false);
			this.source = source;
		}

		@Override
		protected AssemblyStatePair getAssemblyAndState(ProgramState state, int i) throws Exception
		{
			AssemblyStatePair tmpPair;
			String assembly = "";
			tmpPair = source.getLDA(state, i);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			assembly += state.getWhitespace() + "BNE\t:+\n";
			return new AssemblyStatePair(assembly, state);
		}
		
	}

	public LANDExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Land_expressionContext> getC1Node(Land_expressionContext node) throws Exception
	{return new LANDExpressionNode(this).interpret(node.land_expression());}

	@Override
	protected BaseExpressionNode<Or_expressionContext> getC2Node(Land_expressionContext node) throws Exception
	{return new OrExpressionNode(this).interpret(node.or_expression());}

	@Override
	protected BaseExpressionNode<Or_expressionContext> getPCNode(Land_expressionContext node) throws Exception
	{return new OrExpressionNode(this).interpret(node.or_expression());}

	@Override public CastContext getCastContext() {return CastContext.logical;}
	
	@Override
	public Object getPropValue(ProgramState state)
	{
		boolean a = x.getPropBool(state);
		boolean b = y.getPropBool(state);
		return a && b;
	}
	@Override
	protected AssemblyStatePair getAssemblyAndState(ProgramState state, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		AssemblyStatePair tmpPair;
		String assembly = "";
		String whitespace = state.getWhitespace();
		assembly += AssemblyUtils.store(state, (byte) (ProgramState.PreserveFlag.A | ProgramState.PreserveFlag.X));
		byte flags = state.getPreserveFlags();
		state = state.clearPreserveFlags((byte) (ProgramState.PreserveFlag.A | ProgramState.PreserveFlag.X));

		assembly += whitespace + "LDX\t#$01\n";

		tmpPair = new LANDOperator(sourceX).getAssemblyAndState(state);
		assembly += tmpPair.assembly;
		state = tmpPair.state;
		
		assembly += whitespace + "DEX\n";
		assembly += whitespace + "BRA\t:++\n"; // If above never jumped, we're done here
		assembly += (whitespace.length() > 1? whitespace.substring(1) : whitespace) + ":\n";
		
		tmpPair = new LANDOperator(sourceY).getAssemblyAndState(state);
		assembly += tmpPair.assembly;
		state = tmpPair.state;
		
		assembly += whitespace + "DEX\n";
		assembly += ":" + (whitespace.length() > 1? whitespace.substring(1) : whitespace) + "TXA\n";
		assembly += whitespace + CompUtils.setA8 + "\n";

		if(state.destSource() != null)
		{
			tmpPair = state.destSource().getSTA(state, 0);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
		}
		
		state = state.addPreserveFlags(flags);
		assembly += AssemblyUtils.restore(state, (byte) (ProgramState.PreserveFlag.A | ProgramState.PreserveFlag.X));
		
		return new AssemblyStatePair(assembly, state);
	}
}
