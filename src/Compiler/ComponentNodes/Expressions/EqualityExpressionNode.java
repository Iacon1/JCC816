// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.CompUtils;
import Grammar.C99.C99Parser.Equality_expressionContext;
import Grammar.C99.C99Parser.Land_expressionContext;
import Grammar.C99.C99Parser.Lor_expressionContext;
import Grammar.C99.C99Parser.Or_expressionContext;
import Grammar.C99.C99Parser.Relational_expressionContext;
import Grammar.C99.C99Parser.Xor_expressionContext;

public class EqualityExpressionNode extends BinaryExpressionNode
<Equality_expressionContext, Relational_expressionContext, Relational_expressionContext, Equality_expressionContext>
{

	public EqualityExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Equality_expressionContext> getC1Node(Equality_expressionContext node) throws Exception
	{return new EqualityExpressionNode(this).interpret(node.equality_expression());}

	@Override
	protected BaseExpressionNode<Relational_expressionContext> getC2Node(Equality_expressionContext node) throws Exception
	{return new RelationalExpressionNode(this).interpret(node.relational_expression());}

	@Override
	protected BaseExpressionNode<Relational_expressionContext> getPCNode(Equality_expressionContext node) throws Exception
	{return new RelationalExpressionNode(this).interpret(node.relational_expression());}

	@Override
	public Object getPropValue() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String getAssembly(String whitespace, String destAddr, boolean useB, Function<Integer, String> sourceX, Function<Integer, String> sourceY, int xSize) throws Exception
	{
		String assembly = "";
		final String destOperand = useB ? CompUtils.operandB : CompUtils.operandA;
		final String otherOperand = useB ? CompUtils.operandA : CompUtils.operandB;
		final String jumpOn;
		
		switch (operator)
		{
		case "==": case "!=": jumpOn = "BNE"; break;
		default: jumpOn = null; break;
		}
		final boolean propX = x.hasPropValue(), propY = y.hasPropValue();
		
		assembly += whitespace + CompUtils.setXY8 + "\n";
		if (operator.equals("==")) assembly += whitespace + "LDX\t#$00\n";
		else if (operator.equals("!=")) assembly += whitespace + "LDX\t#$FF\n";
		assembly += bytewiseOperation(whitespace, xSize, (Integer i) -> 
		{	
			List<String> lines = new LinkedList<String>();
			if (i == 0)
			{
				// Are we at the last byte of an odd-size number, i. e. in 8-bit mode?
				String toXOR = (i < xSize - 1) ? "#$8000" : "#$80";
				// Start at MSB
				if (propY)
				{
					String oldY = sourceY.apply(xSize - 2 - i).substring(2);
					int yVal = Integer.valueOf(oldY, 16);
					String newY = "#$" + String.format("%0" + oldY.length() + "x", yVal ^ (oldY.length() == 2 ? 0x80 : 0x8000));
					lines.add("LDA\t" + sourceX.apply(xSize - 2 - i));			// Get X
					lines.add("EOR\t" + toXOR);									// Flip sign
					lines.add("CMP\t" + newY);									// Cmp X & Y?
				}
				else if (propX)
				{
					String oldX = sourceX.apply(xSize - 2 - i).substring(2);
					int xVal = Integer.valueOf(oldX, 16);
					String newX = "#$" + String.format("%0" + oldX.length() + "x", xVal ^ (oldX.length() == 2 ? 0x80 : 0x8000));
					lines.add("LDA\t" + sourceY.apply(xSize - 2 - i));			// Get Y
					lines.add("EOR\t" + toXOR);									// Flip sign
					lines.add("CMP\t" + newX);									// Cmp Y & X?
				}
				else
				{
					lines.add("LDA\t" + sourceY.apply(xSize - 2 - i));			// Get Y
					lines.add("EOR\t" + toXOR);									// Flip sign
					lines.add("STA\t" + destOperand);							// Place Y in destAddr
					lines.add("LDA\t" + sourceX.apply(xSize - 2 - i));			// Get X
					lines.add("EOR\t" + toXOR);									// Flip sign
				}
			}
			else
			{
				lines.add("LDA\t" + sourceX.apply(xSize - 2 - i));				// Get X
				lines.add("CMP\t" + sourceY.apply(xSize - 2 - i));				// Cmp X & Y?
			}
			lines.add(jumpOn + "\t:+");
			// else maybe
			return lines.toArray(new String[] {});
		});
		if (operator.equals("==")) assembly += whitespace + "DEX\n";
		else if (operator.equals("!=")) assembly += whitespace + "INX\n";
		assembly += ":" + whitespace.substring(1) + CompUtils.setXY8 + "\n";
		assembly += whitespace + "STX\t" + destAddr + "\n";
		
		return assembly;
	}
}
