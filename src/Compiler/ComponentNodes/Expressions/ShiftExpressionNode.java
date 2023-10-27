// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompUtils;
import Compiler.Utils.OperandSource;
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
	public Object getPropValue()
	{
		Long a = ((Number) x.getPropValue()).longValue();
		Long b = ((Number) y.getPropValue()).longValue();
		switch (operator)
		{
		case "<<": return Long.valueOf(a << b);
		case ">>": return Long.valueOf(a >> b);
		default: return null;
		}
	}
	public static String getShift(String whitespace, String destAddr, boolean useB, OperandSource sourceX, String operator, OperandSource sourceY)
	{
		String assembly = "";

		final String destOperand = useB ? CompUtils.operandB : CompUtils.operandA;
		final String otherOperand = useB ? CompUtils.operandA : CompUtils.operandB;
		
		assembly += whitespace + AssemblyUtils.byteCopier(whitespace, sourceY.getSize(), otherOperand, sourceY);
		sourceY = AssemblyUtils.addressSource(otherOperand, sourceY.getSize());
		assembly += ":\n"; // A loop
		switch (operator)
		{
		case "<<":
			assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i) ->
			{
				return new String[]
				{
					"LDA\t" + sourceX.apply(i),
					"ASL",
					"STA\t" + destAddr + " + " + i,
				};
			});
			break;
		case ">>":
			assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i) -> 
			{return new String[]
				{
					"LDA\t" + sourceX.apply(i),
					"LSR",
					"STA\t" + destAddr + " + " + i,
				};
			}, true, true);
			break;
		}
		assembly += AdditiveExpressionNode.getDecrementer(whitespace, otherOperand, sourceY);
		assembly += whitespace + "BNE\t:-\n";
		return assembly;
	}
	@Override
	protected String getAssembly(String whitespace, String destAddr, boolean useB, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		return getShift(whitespace, destAddr, useB, sourceX, operator, sourceY);
	}
}
