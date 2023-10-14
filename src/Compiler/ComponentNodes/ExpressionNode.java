// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes;

import Grammar.GeneralParser.GeneralNode;
import Compiler.Compiler;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Compiler.ComponentNodes.Interfaces.TypedNode;
import Compiler.ComponentNodes.Exceptions.TypeMismatchException;
import Compiler.ComponentNodes.Exceptions.UndefinedOpException;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import Compiler.CompConfig;

public class ExpressionNode extends ComponentNode<ExpressionNode> implements TypedNode, AssemblableNode
{
	private String operator;

	private RValNode x;
	private RValNode y;
	
	public ExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	public ExpressionNode interpret(GeneralNode<String, String> node) throws Exception
	{
		switch (node.childrenNodes.size()) // How many non-terminals?
		{
		case 1: // ([rVal]), -[rVal], ![rVal]
			operator = node.getT(0);
			x = new RValNode(this).interpret(node.getNode(0));
			break;
		case 2: // [rVal] op [rVal], [rVal] long-op [rVal]
			operator = node.getT(0);
			if (node.childrenT.size() == 2) operator += node.getT(1);
			x = new RValNode(this).interpret(node.getNode(0));
			y = new RValNode(this).interpret(node.getNode(1));
			break;
		}

		return this;
	}

	public TypeNode getType(boolean assumeFirst) throws Exception
	{
		TypeNode xType, yType = null;
		xType = x.getType();
		if (y != null) yType = y.getType();
		if (assumeFirst || yType == null || xType.equals(yType) || x.canCastFrom(yType))
		{
			if (operator.matches("\\<|\\<\\=|\\>|\\>\\=|\\=\\=|\\!\\=")) return CompConfig.Primitive.t_bool.getType();
			else return xType;
		}
		else throw new TypeMismatchException(xType, yType); // If we can't assume X is correct then they must agree
	}
	@Override
	public TypeNode getType()
	{
		try {return getType(true);}
		catch (Exception e) {return null;}
	}
	
	public String getTypeName(boolean assumeFirst) throws Exception
	{
		return getType(assumeFirst).getName();
	}
	@Override
	public String getTypeName()
	{
		try {return getTypeName(true);}
		catch (Exception e) {return null;}
	}

	@Override
	public boolean canCall(FunctionNode function)
	{
		return x.canCall(function) || (y != null && y.canCall(function));
	}
	
	@Override
	public Object getPropagatedValue()
	{
		switch (operator)
		{
		case "(": return x.getPropagatedValue();
		case "-": case "!": // Subtraction or negation
			if (y != null) // Subtraction
				return (Integer) x.getPropagatedValue() - (Integer) y.getPropagatedValue();
			else // Negation
				return 0 - (Integer) x.getPropagatedValue();
		case "<": return (Boolean) ((Integer) x.getPropagatedValue() < (Integer) y.getPropagatedValue());
		case "<=": return (Boolean) ((Integer) x.getPropagatedValue() <= (Integer) y.getPropagatedValue());
		case ">": return (Boolean) ((Integer) x.getPropagatedValue() > (Integer) y.getPropagatedValue());
		case ">=": return (Boolean) ((Integer) x.getPropagatedValue() >= (Integer) y.getPropagatedValue());
		case "==": return (Boolean) ((Integer) x.getPropagatedValue() == (Integer) y.getPropagatedValue());
		case "!=": return (Boolean) ((Integer) x.getPropagatedValue() != (Integer) y.getPropagatedValue());
		default:
			return null;
		}
	}
	@Override
	public boolean hasPropValue()
	{
		if (y == null) return x.hasPropValue();
		return x.hasPropValue() && y.hasPropValue();
	}
	public String getAssembly(int leadingWhitespace, String destAddr, boolean useOperandB) throws Exception
	{
		String whitespace = getWhitespace(leadingWhitespace);
		final String destOperand = useOperandB ? CompConfig.operandB : CompConfig.operandA;
		final String otherOperand = useOperandB ? CompConfig.operandA : CompConfig.operandB;
		final Function<Integer, String> sourceX, sourceY;
		String assembly = "";

		if (!CompConfig.Primitive.isBasic(getType(false))) // TODO custom operators
			throw new UndefinedOpException(getType(false).getFullName(), operator);
		
		final int xSize = x.getType().getSize();
		
		if (y == null) // Mono-operator
		{
			sourceX = x.getByteSource(destOperand, xSize);
			if (x.hasAssembly()) assembly += x.getAssembly(leadingWhitespace, destAddr, useOperandB);
			
			switch (operator)
			{
			case "-": case "!": // Both types of negation are the same under the hood
				assembly += bytewiseOperation(whitespace, xSize, (Integer i) ->
				{
					String toXOR = (i < xSize - 1) ? "#$FF" : "#$FFFF";
					return new String[]
					{
						"LDA\t" + sourceX.apply(i),
						"EOR\t" + toXOR,
						"STA\t" + destAddr + " + " + i,
					};
				});
				break;
			default:
				break;
			}
		}
		else
		{
			sourceY = y.getByteSource(otherOperand, xSize);
			if (y.hasAssembly()) assembly += y.getAssembly(leadingWhitespace, otherOperand, useOperandB);
			// Now we figure out X
			sourceX = x.getByteSource(destOperand, xSize);
			if (x.hasAssembly()) assembly += x.getAssembly(leadingWhitespace, destOperand, useOperandB);
			
			if (operator != null)
			{
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
				case "<": case ">": case "<=": case ">=": case "==": case "!=":
					final String jumpOne; // Condition to jump to true
					final String jumpTwo; // Condition to jump to false
					
					final boolean propX = x.hasPropValue(), propY = y.hasPropValue();
					
					switch (operator)
					{
					case "<": case "<=": jumpOne = "BCC"; jumpTwo = "BNE"; break;
					case ">": case ">=": jumpOne = "BCS"; jumpTwo = "BNE"; break;
					case "==": jumpOne = ""; jumpTwo = "BNE"; break;
					default: jumpOne = ""; jumpTwo = ""; break;
					}
					assembly += whitespace + CompConfig.setXY8 + "\n";
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
					assembly += ":" + whitespace.substring(1) + CompConfig.setXY8 + "\n";
					assembly += whitespace + "STX\t" + destAddr + "\n";
					break;
				}
			}
		}
		return assembly;
	}

	public String getAssembly(int leadingWhitespace, String destAddr) throws Exception
	{
		return getAssembly(leadingWhitespace, destAddr, false);
	}
	
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		return getAssembly(leadingWhitespace, CompConfig.operandA, false);
	}
	
}
