// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import java.util.function.Function;

import Compiler.ComponentNodes.ComponentNode;
import Grammar.C99.C99Parser.Additive_expressionContext;
import Grammar.C99.C99Parser.Cast_expressionContext;
import Grammar.C99.C99Parser.Multiplicative_expressionContext;
import Grammar.C99.C99Parser.Or_expressionContext;
import Grammar.C99.C99Parser.Shift_expressionContext;
import Grammar.C99.C99Parser.Xor_expressionContext;

public class MultiplicativeExpressionNode extends BinaryExpressionNode
<Multiplicative_expressionContext, Cast_expressionContext, Cast_expressionContext, Multiplicative_expressionContext>
{

	public MultiplicativeExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Multiplicative_expressionContext> getC1Node(Multiplicative_expressionContext node) throws Exception
	{return new MultiplicativeExpressionNode(this).interpret(node.multiplicative_expression());}

	@Override
	protected BaseExpressionNode<Cast_expressionContext> getC2Node(Multiplicative_expressionContext node) throws Exception
	{return new CastExpressionNode(this).interpret(node.cast_expression());}

	@Override
	protected BaseExpressionNode<Cast_expressionContext> getPCNode(Multiplicative_expressionContext node) throws Exception
	{return new CastExpressionNode(this).interpret(node.cast_expression());}

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
