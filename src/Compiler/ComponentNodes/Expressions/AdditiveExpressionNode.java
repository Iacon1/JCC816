// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import java.util.function.Function;

import Compiler.ComponentNodes.ComponentNode;
import Grammar.C99.C99Parser.Additive_expressionContext;
import Grammar.C99.C99Parser.Multiplicative_expressionContext;
import Grammar.C99.C99Parser.Or_expressionContext;
import Grammar.C99.C99Parser.Shift_expressionContext;
import Grammar.C99.C99Parser.Xor_expressionContext;

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
	public Object getPropValue() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String getAssembly(String whitespace, String destAddr, boolean useB, Function<Integer, String> sourceX, Function<Integer, String> sourceY, int xSize) throws Exception
	{
		String assembly = "";
		
		switch (operator)
		{
		case "+":
			assembly += bytewiseOperation(whitespace, xSize, (Integer i) ->
			{
				return new String[]
				{
					"LDA\t" + sourceX.apply(i),
					"ADC\t" + sourceY.apply(i),
					"STA\t" + destAddr + " + " + i,
				};
			});
			break;
		case "-":
			assembly += bytewiseOperation(whitespace, xSize, (Integer i) -> 
			{return new String[]
				{
					"LDA\t" + sourceX.apply(i),
					"SBC\t" + sourceY.apply(i),
					"STA\t" + destAddr + " + " + i,
				};
			});
			break;
		}
		return assembly;
	}
}
