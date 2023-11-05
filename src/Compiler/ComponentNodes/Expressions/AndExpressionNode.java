// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.OperandSource;
import Compiler.Utils.ScratchManager;
import Grammar.C99.C99Parser.And_expressionContext;
import Grammar.C99.C99Parser.Equality_expressionContext;

public class AndExpressionNode extends BinaryExpressionNode
<Equality_expressionContext, And_expressionContext, Equality_expressionContext, And_expressionContext>
{

	public AndExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Equality_expressionContext> getC1Node(And_expressionContext node) throws Exception
	{return new EqualityExpressionNode(this).interpret(node.equality_expression());}

	@Override
	protected BaseExpressionNode<And_expressionContext> getC2Node(And_expressionContext node) throws Exception
	{return new AndExpressionNode(this).interpret(node.and_expression());}

	@Override
	protected BaseExpressionNode<Equality_expressionContext> getPCNode(And_expressionContext node) throws Exception
	{return new EqualityExpressionNode(this).interpret(node.equality_expression());}

	@Override
	public Object getPropValue()
	{
		Long a = x.getPropLong();
		Long b = y.getPropLong();
		return Long.valueOf(a & b);
	}
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		String assembly = AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, Boolean is16Bit) ->
		{
			return new String[]
			{
				"LDA\t" + sourceX.apply(i, is16Bit),
				"AND\t" + sourceY.apply(i, is16Bit),
				"STA\t" + destSource + " + " + i,
			};
		});
		return assembly;
	}
}
