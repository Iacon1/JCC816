// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Grammar.C99.C99Parser.Land_expressionContext;
import Grammar.C99.C99Parser.Lor_expressionContext;
import Grammar.C99.C99Parser.Or_expressionContext;

/**
 * 
 */
public class LANDExpressionNode extends BinaryExpressionNode
<Or_expressionContext, Land_expressionContext, Or_expressionContext, Land_expressionContext>
{

	public LANDExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Or_expressionContext> getC1Node(Land_expressionContext node) throws Exception
	{return new OrExpressionNode(this).interpret(node.or_expression());}

	@Override
	protected BaseExpressionNode<Land_expressionContext> getC2Node(Land_expressionContext node) throws Exception
	{return new LANDExpressionNode(this).interpret(node.land_expression());}

	@Override
	protected BaseExpressionNode<Or_expressionContext> getPCNode(Land_expressionContext node) throws Exception
	{return new OrExpressionNode(this).interpret(node.or_expression());}

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
