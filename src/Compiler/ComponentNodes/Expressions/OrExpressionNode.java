// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.OperandSource;
import Compiler.Utils.ScratchManager;
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
	public Object getPropValue()
	{
		Long a = ((Number) x.getPropValue()).longValue();
		Long b = ((Number) y.getPropValue()).longValue();
		return Long.valueOf(a | b);
	}
	@Override
	protected String getAssembly(String whitespace, String destAddr, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		String assembly = AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, Boolean is16Bit) ->
		{
			return new String[]
			{
				"LDA\t" + sourceX.apply(i, is16Bit),
				"ORA\t" + sourceY.apply(i, is16Bit),
				"STA\t" + destAddr + " + " + i,
			};
		});
		return assembly;
	}
}
