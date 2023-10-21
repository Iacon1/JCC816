// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Grammar.C99.C99Parser.Land_expressionContext;
import Grammar.C99.C99Parser.Lor_expressionContext;

/**
 * 
 */
public class LORExpressionNode extends BinaryExpressionNode
<Land_expressionContext, Lor_expressionContext, Land_expressionContext, Lor_expressionContext>
{

	public LORExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Land_expressionContext> getC1Node(Lor_expressionContext node) throws Exception
	{return new LANDExpressionNode(this).interpret(node.land_expression());}

	@Override
	protected BaseExpressionNode<Lor_expressionContext> getC2Node(Lor_expressionContext node) throws Exception
	{return new LORExpressionNode(this).interpret(node.lor_expression());}

	@Override
	protected BaseExpressionNode<Land_expressionContext> getPCNode(Lor_expressionContext node) throws Exception
	{return new LANDExpressionNode(this).interpret(node.land_expression());}

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
