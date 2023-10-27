// Created by Iacon1 on 10/22/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.Exceptions.ConstraintException;
import Grammar.C99.C99Parser.Constant_expressionContext;

public class ConstantExpressionNode extends BaseExpressionNode<Constant_expressionContext>
{

	public ConstantExpressionNode(ComponentNode<?> parent) {super(parent);}
	
	public BaseExpressionNode<Constant_expressionContext> interpret(Constant_expressionContext node) throws Exception
	{
		BaseExpressionNode<?> expr = new ConditionalExpressionNode(this).interpret(node.conditional_expression());
		if (!expr.hasPropValue())
			throw new ConstraintException("6.6", 4, node.start);
		return (BaseExpressionNode) expr;
	}

	// These will all *never* be called, since we always delegate to a conditional expression
	@Override
	public boolean canCall(FunctionDefinitionNode function) {return false;}
	@Override
	public Type getType() {return null;}
	@Override
	public boolean hasPropValue() {return false;}
	@Override
	public Object getPropValue() {return null;}
	@Override
	protected String getAssembly(int leadingWhitespace, String writeAddr, boolean useB) throws Exception {return null;}
}
