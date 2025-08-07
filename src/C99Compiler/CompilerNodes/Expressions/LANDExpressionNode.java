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
import C99Compiler.Utils.ProgramState.PreserveFlag;
import C99Compiler.Utils.ProgramState.ProcessorFlag;
import Grammar.C99.C99Parser.Land_expressionContext;
import Grammar.C99.C99Parser.Or_expressionContext;

public class LANDExpressionNode extends LogicalBinaryExpressionNode
<Land_expressionContext, Or_expressionContext, Or_expressionContext, Land_expressionContext>
{
	public LANDExpressionNode(ComponentNode<?> parent) {super(parent, false);}

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
		MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
		
		if (!pair.state.testKnownFlag(PreserveFlag.M) || pair.state.testProcessorFlag(ProcessorFlag.M))
		{
			pair.assembly += pair.state.getWhitespace() + "SEP\t#$20\n";
			pair.state = pair.state.clearProcessorFlags(ProcessorFlag.M);
		}
		
		sourceX.applyLDA(pair, 0);
		sourceY.applyInstruction(pair, "AND", 0);
		
		return pair.getImmutable();
	}
}
