// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.Definitions.Type;
import Grammar.C99.C99Parser.Postfix_expressionContext;

public class PostfixExpressionNode extends BaseExpressionNode<Postfix_expressionContext>
{
	private BaseExpressionNode<?> node;
	
	public PostfixExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return node.canCall(function);
	}

	@Override
	public BaseExpressionNode<Postfix_expressionContext> interpret(Postfix_expressionContext node) throws Exception
	{
		return (BaseExpressionNode) new PrimaryExpressionNode(this).interpret(node.primary_expression()); // TODO
	}
	
	@Override
	public Type getType()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasPropValue()
	{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object getPropValue() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String getAssembly(int leadingWhitespace, String writeAddr, boolean useB) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
