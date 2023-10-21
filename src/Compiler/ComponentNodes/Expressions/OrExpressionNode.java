// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Grammar.C99.C99Parser.Land_expressionContext;
import Grammar.C99.C99Parser.Lor_expressionContext;
import Grammar.C99.C99Parser.Or_expressionContext;
import Grammar.C99.C99Parser.Xor_expressionContext;

public class OrExpressionNode extends BinaryExpressionNode
<Xor_expressionContext, Or_expressionContext, Xor_expressionContext, Or_expressionContext>
{

	public OrExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Xor_expressionContext> getC1Node(Or_expressionContext node) throws Exception
	{return new XOrExpressionNode(this).interpret(node.xor_expression());}

	@Override
	protected BaseExpressionNode<Or_expressionContext> getC2Node(Or_expressionContext node) throws Exception
	{return new OrExpressionNode(this).interpret(node.or_expression());}

	@Override
	protected BaseExpressionNode<Xor_expressionContext> getPCNode(Or_expressionContext node) throws Exception
	{return new XOrExpressionNode(this).interpret(node.xor_expression());}

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
