// Created by Iacon1 on 10/20/2023.
//
package Compiler.CompilerNodes.Expressions;

import Compiler.CompilerNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.OperandSources.ConstantSource;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.And_expressionContext;
import Grammar.C99.C99Parser.Land_expressionContext;
import Grammar.C99.C99Parser.Lor_expressionContext;
import Grammar.C99.C99Parser.Or_expressionContext;
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

	public static String getExclOr(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, DetailsTicket ticket) throws Exception
	{
		return new XOrExpressionNode(null).getAssembly(whitespace, destSource, sourceX, sourceY, ticket);
	}
	public static String getComplementer(String whitespace, OperandSource destSource, OperandSource sourceX, DetailsTicket ticket) throws Exception
	{
		OperandSource sourceY = new ConstantSource(Long.valueOf("FF".repeat(sourceX.getSize())), sourceX.getSize()); // 0xFF...FF
		
		return new XOrExpressionNode(null).getAssembly(whitespace, destSource, sourceX, sourceY, ticket);
	}
	public static String getNegator(String whitespace, OperandSource destSource, OperandSource sourceX, DetailsTicket ticket) throws Exception
	{
		String assembly = "";
		assembly += getComplementer(whitespace, destSource, sourceX, ticket);
		assembly += AdditiveExpressionNode.getDecrementer(whitespace, destSource, ticket);
		return assembly;
	}

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
		return "XOR";
	}

	@Override
	protected boolean isReversed()
	{
		return false;
	}
}