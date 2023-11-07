// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.ConstantSource;
import Compiler.Utils.OperandSources.OperandSource;
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
		Long a = x.getPropLong();
		Long b = y.getPropLong();
		switch (operator)
		{
		case "+": return Long.valueOf(a + b);
		case "-": return Long.valueOf(a - b);
		default: return null;
		}
	}
	public static String getAdder(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY)
	{
		return whitespace + "CLC\n" + AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, Boolean is16Bit) -> 
		{return new String[]
			{
				sourceX.prefaceAssembly(whitespace, i, is16Bit),
				"LDA\t" + sourceX.apply(i, is16Bit),
				sourceY.prefaceAssembly(whitespace, i, is16Bit),
				"ADC\t" + sourceY.apply(i, is16Bit),
				destSource.prefaceAssembly(whitespace, i, is16Bit),
				"STA\t" + destSource.apply(i, is16Bit),
			};
		});
	}
	public static String getIncrementer(String whitespace, OperandSource destSource, OperandSource sourceX)
	{
		OperandSource sourceY = new ConstantSource(1, sourceX.getSize());
		return getAdder(whitespace, destSource, sourceX, sourceY);
	}
	public static String getSubtractor(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY)
	{
		return whitespace + "SEC\n" + AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, Boolean is16Bit) -> 
		{return new String[]
			{
				sourceX.prefaceAssembly(whitespace, i, is16Bit),
				"LDA\t" + sourceX.apply(i, is16Bit),
				sourceY.prefaceAssembly(whitespace, i, is16Bit),
				"SBC\t" + sourceY.apply(i, is16Bit),
				destSource.prefaceAssembly(whitespace, i, is16Bit),
				"STA\t" + destSource.apply(i, is16Bit),
			};
		}, true, true);
	}
	public static String getDecrementer(String whitespace, OperandSource destSource, OperandSource sourceX)
	{
		OperandSource sourceY = new ConstantSource(1, sourceX.getSize());
		return getSubtractor(whitespace, destSource, sourceX, sourceY);
	}
	
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		String assembly = "";
		
		switch (operator)
		{
		case "+":
			assembly += getAdder(whitespace, destSource, sourceX, sourceY);
			break;
		case "-":
			assembly += getSubtractor(whitespace, destSource, sourceX, sourceY);
			break;
		}
		return assembly;
	}
}
