// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Grammar.C99.C99Parser.Additive_expressionContext;
import Grammar.C99.C99Parser.Or_expressionContext;
import Grammar.C99.C99Parser.Shift_expressionContext;
import Grammar.C99.C99Parser.Xor_expressionContext;

public class ShiftExpressionNode extends BinaryExpressionNode
<Shift_expressionContext, Additive_expressionContext, Additive_expressionContext, Shift_expressionContext>
{

	public ShiftExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Shift_expressionContext> getC1Node(Shift_expressionContext node) throws Exception
	{return new ShiftExpressionNode(this).interpret(node.shift_expression());}

	@Override
	protected BaseExpressionNode<Additive_expressionContext> getC2Node(Shift_expressionContext node) throws Exception
	{return new AdditiveExpressionNode(this).interpret(node.additive_expression());}

	@Override
	protected BaseExpressionNode<Additive_expressionContext> getPCNode(Shift_expressionContext node) throws Exception
	{return new AdditiveExpressionNode(this).interpret(node.additive_expression());}

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
