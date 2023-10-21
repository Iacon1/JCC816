// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.CompUtils;
import Grammar.C99.C99Parser.Land_expressionContext;
import Grammar.C99.C99Parser.Lor_expressionContext;
import Grammar.C99.C99Parser.Or_expressionContext;
import Grammar.C99.C99Parser.Relational_expressionContext;
import Grammar.C99.C99Parser.Shift_expressionContext;
import Grammar.C99.C99Parser.Xor_expressionContext;

public class RelationalExpressionNode extends BinaryExpressionNode
<Relational_expressionContext, Shift_expressionContext, Shift_expressionContext, Relational_expressionContext>
{

	public RelationalExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Relational_expressionContext> getC1Node(Relational_expressionContext node) throws Exception
	{return new RelationalExpressionNode(this).interpret(node.relational_expression());}

	@Override
	protected BaseExpressionNode<Shift_expressionContext> getC2Node(Relational_expressionContext node) throws Exception
	{return new ShiftExpressionNode(this).interpret(node.shift_expression());}

	@Override
	protected BaseExpressionNode<Shift_expressionContext> getPCNode(Relational_expressionContext node) throws Exception
	{return new ShiftExpressionNode(this).interpret(node.shift_expression());}

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
		
		switch (operator)
		{
		case "<": case ">": case "<=": case ">=":
			final String jumpOne; // Condition to jump to true
			final String jumpTwo; // Condition to jump to false
			
			final boolean propX = x.hasPropValue(), propY = y.hasPropValue();
			
			switch (operator)
			{
			case "<": case "<=": jumpOne = "BCC"; jumpTwo = "BNE"; break;
			case ">": case ">=": jumpOne = "BCS"; jumpTwo = "BNE"; break;
			default: jumpOne = ""; jumpTwo = ""; break;
			}
			assembly += whitespace + CompUtils.setXY8 + "\n";
			assembly += whitespace + "LDX\t#$00\n";
			
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
						if (jumpOne.equals("BCC")) lines.add("BCS");
						else if (jumpOne.equals("BCS")) lines.add("BCC");			// Invert operation for this one, since we did opposite comparison
					}
					else
					{
						lines.add("LDA\t" + sourceY.apply(xSize - 2 - i));			// Get Y
						lines.add("EOR\t" + toXOR);									// Flip sign
						lines.add("STA\t" + destOperand);							// Place Y in destAddr
						lines.add("LDA\t" + sourceX.apply(xSize - 2 - i));			// Get X
						lines.add("EOR\t" + toXOR);									// Flip sign
						lines.add("CMP\t" + destOperand);							// Cmp Y & X?
					}
				}
				else
				{
					lines.add("LDA\t" + sourceX.apply(xSize - 2 - i));				// Get X
					lines.add("CMP\t" + sourceY.apply(xSize - 2 - i));				// Cmp X & Y?
				}
				if ((i != 0 || !propX) && !jumpOne.isEmpty())
					lines.add(jumpOne + "\t:+");									// If X [op] Y then yes
				if (!jumpTwo.isEmpty() && !jumpOne.isEmpty())
					lines.add(jumpTwo + "\t:++");									// If X [anti-op] Y then no
				else if (!jumpTwo.isEmpty())
					lines.add(jumpTwo + "\t:+");									// If X [anti-op] Y then no
				// else maybe
				return lines.toArray(new String[] {});
			});
			if (operator.equals("<") || operator.equals(">")) // equals is not good enough
				assembly += whitespace + "INX\n";
			assembly += (!jumpOne.isEmpty() ? ":" : " ") + whitespace.substring(1) + "DEX\n";
			assembly += ":" + whitespace.substring(1) + CompUtils.setXY8 + "\n";
			assembly += whitespace + "STX\t" + destAddr + "\n";
			break;
		}
		return assembly;
	}
}