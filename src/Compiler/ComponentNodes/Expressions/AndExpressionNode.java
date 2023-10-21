// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Grammar.C99.C99Parser.And_expressionContext;
import Grammar.C99.C99Parser.Equality_expressionContext;
import Grammar.C99.C99Parser.Land_expressionContext;
import Grammar.C99.C99Parser.Lor_expressionContext;
import Grammar.C99.C99Parser.Or_expressionContext;
import Grammar.C99.C99Parser.Xor_expressionContext;

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
	public Object getPropValue() {
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
