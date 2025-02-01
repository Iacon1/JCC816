// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import Grammar.C99.C99Parser.And_expressionContext;
import Grammar.C99.C99Parser.Xor_expressionContext;

public class XOrExpressionNode extends ArithmeticBinaryExpressionNode
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

	@Override public CastContext getCastContext() {return CastContext.bitwise;}

	@Override
	protected long doOperation(long x, long y)
	{
		return x ^ y;
	}

	@Override
	protected String getPreface()
	{
		return "";
	}

	@Override
	protected String getInstruction()
	{
		return "EOR";
	}

	@Override
	protected boolean isReversed()
	{
		return false;
	}
}
