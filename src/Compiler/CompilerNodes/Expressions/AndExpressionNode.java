// Created by Iacon1 on 10/20/2023.
//
package Compiler.CompilerNodes.Expressions;

import Compiler.CompilerNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.And_expressionContext;
import Grammar.C99.C99Parser.Equality_expressionContext;

public class AndExpressionNode extends ArithmeticBinaryExpressionNode
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
	protected long doOperation(long x, long y)
	{
		return x & y;
	}

	@Override
	protected String getPreface()
	{
		return "";
	}

	@Override
	protected String getInstruction()
	{
		return "AND";
	}

	@Override
	protected boolean isReversed()
	{
		return false;
	}
}
