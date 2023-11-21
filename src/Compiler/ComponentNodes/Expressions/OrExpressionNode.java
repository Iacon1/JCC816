// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Or_expressionContext;
import Grammar.C99.C99Parser.Xor_expressionContext;

public class OrExpressionNode extends ArithmeticBinaryExpressionNode
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
	protected long doOperation(long x, long y)
	{
		return x | y;
	}

	@Override
	protected String getPreface()
	{
		return "";
	}

	@Override
	protected String getInstruction()
	{
		return "ORA";
	}

	@Override
	protected boolean isReversed()
	{
		return false;
	}

}
