// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Grammar.C99.C99Parser.And_expressionContext;
import Grammar.C99.C99Parser.Land_expressionContext;
import Grammar.C99.C99Parser.Lor_expressionContext;
import Grammar.C99.C99Parser.Or_expressionContext;
import Grammar.C99.C99Parser.Xor_expressionContext;

public class XOrExpressionNode extends BinaryExpressionNode
<And_expressionContext, Xor_expressionContext, And_expressionContext, Xor_expressionContext>
{

	public XOrExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<And_expressionContext> getC1Node(Xor_expressionContext node) throws Exception
	{return new AndExpressionNode(this).interpret(node.and_expression());}

	@Override
	protected BaseExpressionNode<Xor_expressionContext> getC2Node(Xor_expressionContext node) throws Exception
	{return new XOrExpressionNode(this).interpret(node.xor_expression());}

	@Override
	protected BaseExpressionNode<And_expressionContext> getPCNode(Xor_expressionContext node) throws Exception
	{return new AndExpressionNode(this).interpret(node.and_expression());}

	@Override
	public Object getPropValue()
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String getAssembly(int leadingWhitespace, String writeAddr, boolean useB) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
}
