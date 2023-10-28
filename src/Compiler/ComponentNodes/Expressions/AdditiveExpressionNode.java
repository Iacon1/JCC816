// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import java.util.function.Function;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.OperandSource;
import Compiler.Utils.ScratchManager;
import Grammar.C99.C99Parser.Additive_expressionContext;
import Grammar.C99.C99Parser.Multiplicative_expressionContext;

public class AdditiveExpressionNode extends BinaryExpressionNode
<Additive_expressionContext, Multiplicative_expressionContext, Multiplicative_expressionContext, Additive_expressionContext>
{

	public AdditiveExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Additive_expressionContext> getC1Node(Additive_expressionContext node) throws Exception
	{return new AdditiveExpressionNode(this).interpret(node.additive_expression());}

	@Override
	protected BaseExpressionNode<Multiplicative_expressionContext> getC2Node(Additive_expressionContext node) throws Exception
	{return new MultiplicativeExpressionNode(this).interpret(node.multiplicative_expression());}

	@Override
	protected BaseExpressionNode<Multiplicative_expressionContext> getPCNode(Additive_expressionContext node) throws Exception
	{return new MultiplicativeExpressionNode(this).interpret(node.multiplicative_expression());}

	@Override
	public Object getPropValue()
	{
		Long a = ((Number) x.getPropValue()).longValue();
		Long b = ((Number) y.getPropValue()).longValue();
		switch (operator)
		{
		case "+": return Long.valueOf(a + b);
		case "-": return Long.valueOf(a - b);
		default: return null;
		}
	}
	public static String getAdder(String whitespace, String destAddr, OperandSource sourceX, OperandSource sourceY)
	{
		return whitespace + "CLC\n" + AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i) -> 
		{return new String[]
			{
				"LDA\t" + sourceX.apply(i),
				"ADC\t" + sourceY.apply(i),
				"STA\t" + destAddr + " + " + i,
			};
		});
	}
	public static String getIncrementer(String whitespace, String destAddr, OperandSource sourceX)
	{
		OperandSource sourceY = AssemblyUtils.numericSource(1, sourceX.getSize());
		return getAdder(whitespace, destAddr, sourceX, sourceY);
	}
	public static String getSubtractor(String whitespace, String destAddr, OperandSource sourceX, OperandSource sourceY)
	{
		return whitespace + "SEC\n" + AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i) -> 
		{return new String[]
			{
				"LDA\t" + sourceX.apply(i),
				"SBC\t" + sourceY.apply(i),
				"STA\t" + destAddr + " + " + (i),
			};
		}, true, true);
	}
	public static String getDecrementer(String whitespace, String destAddr, OperandSource sourceX)
	{
		OperandSource sourceY = AssemblyUtils.numericSource(1, sourceX.getSize());
		return getSubtractor(whitespace, destAddr, sourceX, sourceY);
	}
	
	@Override
	protected String getAssembly(String whitespace, String destAddr, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		String assembly = "";
		
		switch (operator)
		{
		case "+":
			assembly += getAdder(whitespace, destAddr, sourceX, sourceY);
			break;
		case "-":
			assembly += getSubtractor(whitespace, destAddr, sourceX, sourceY);
			break;
		}
		return assembly;
	}
}
