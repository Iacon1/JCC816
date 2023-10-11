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
import java.util.function.Function;

import Compiler.CompConfig;

public class ExpressionNode extends ComponentNode<ExpressionNode> implements TypedNode, AssemblableNode
{
	private enum ExpressionType
	{
		litOpLit,
		litOpVar,
		varOpLit,
		varOpVar,
		
		litOpExp, litOpCall,
		varOpExp, varOpCall,
		expOpLit, callOpLit,
		expOpVar, callOpVar,
		
		expOpExp,
		expOpCall,
		callOpExp,
		callOpCall,
		
		loneVar,
		loneExp,
		loneLit,
		loneCall,
	}
	private ExpressionType expressionType;
	
	private String x, operator, y;
	
	private Object literalX, literalY;
	private Class<?> literalXClass, literalYClass;
	
	private ExpressionNode expNodeX, expNodeY;
	private FunctionCallNode callNodeX, callNodeY;
	
	public static Object determineLiteral(String a)
	{
		if (a.matches("[0-9]+")) // Number
			return Integer.valueOf(a);
		else if (a.endsWith("\"")) // Quote
			return a.substring(1, a.length() - 2);
		else if (a.endsWith("\'")) // Character
			return Character.valueOf(a.charAt(1));
		else if (a.equals("false")) // False boolean
			return Boolean.FALSE;
		else if (a.equals("true")) // False boolean
			return Boolean.TRUE;
		else return null;
	}
	
	public ExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	public ExpressionNode interpret(GeneralNode<String, String> node) throws Exception
	{
		switch (node.childrenNodes.size()) // How many non-terminals?
		{
		case 0: // Possible forms: ([variable]), ([literal]), [var] [op] [var], [var] [op] [lit], [lit] [op] [lit]
			if (node.getT(0).equals("(")) // Parentheses
			{
				x = node.getT(1);
				literalX = determineLiteral(x);
				if (literalX != null) // First was literal, second was variable
				{
					expressionType = ExpressionType.loneLit;
					literalXClass = literalX.getClass();
				}
				else expressionType = ExpressionType.loneVar;
			}
			else // Other things
			{
				x = node.getT(0);
				operator = node.getT(1);
				y = node.getT(2);
				
				literalX = determineLiteral(x);
				literalY = determineLiteral(y);
				if (literalX != null && literalY != null) // Both literals
				{
					expressionType = ExpressionType.litOpLit;
					literalXClass = literalX.getClass();
					literalYClass = literalY.getClass();
				}
				else if (literalX != null) // First was literal, second was variable
				{
					expressionType = ExpressionType.litOpVar;
					literalXClass = literalX.getClass();
				}
				else if (literalY != null) // First was variable, second was literal
				{
					expressionType = ExpressionType.varOpLit;
					literalYClass = literalY.getClass();
				}
				else // Both variable
				{
					expressionType = ExpressionType.varOpVar;
				}
			}
			
			break;
		case 1: // Possible forms: ([function call]), ([expression]), [var] op [expression], [lit] op [expression], [expression] op [var], [expression] op [lit],
				//	[var] op [function call], [lit] op [function call], [function call] op [var], [function call] op [lit]
			
			boolean isFunctionCall = (Compiler.getType(node.getNode(0).ruleName) == Compiler.ComponentType.functionCall);

			if (node.getT(0).equals("(")) // Parenthseses
			{
				if (!isFunctionCall)
				{
					expNodeX = new ExpressionNode(this.parent).interpret(node.getNode(0));
					expressionType = ExpressionType.loneExp;
					
					this.parent.children.remove(this); // Optimization! replace ourselves with this sub-expression
					return expNodeX;
				}
				else
				{
					callNodeX = new FunctionCallNode(this).interpret(node.getNode(0));
					expressionType = ExpressionType.loneCall;
				}
			}
			else if (!node.getT(0).matches(CompConfig.operatorPattern)) // [...] op or op [...]?
			{
				x = node.getT(0);
				operator = node.getT(1);
				
				literalX = determineLiteral(x);
				if (literalX != null)
				{
					expressionType = isFunctionCall ? ExpressionType.litOpCall : ExpressionType.litOpExp;
					literalXClass = literalX.getClass();
				}
				else expressionType = isFunctionCall ? ExpressionType.varOpCall : ExpressionType.varOpExp;
			}
			else
			{
				operator = node.getT(0);
				y = node.getT(1);
				
				literalY = determineLiteral(y);
				if (literalY != null)
				{
					expressionType = isFunctionCall ? ExpressionType.callOpLit : ExpressionType.expOpLit;
					literalYClass = literalY.getClass();
				}
				else expressionType = isFunctionCall ? ExpressionType.callOpVar : ExpressionType.expOpVar;
			}
			
			switch (expressionType)
			{
			case litOpExp: case varOpExp:
				expNodeY = new ExpressionNode(this).interpret(node.getNode(0));
				break;
			case litOpCall: case varOpCall:
				callNodeY = new FunctionCallNode(this).interpret(node.getNode(0));
				break;
			case expOpLit: case expOpVar:
				expNodeX = new ExpressionNode(this).interpret(node.getNode(0));
				break;
			case callOpLit: case callOpVar:
				callNodeX = new FunctionCallNode(this).interpret(node.getNode(0));
				break;
			default: // ???
				break;
			}
			break;
		case 2: // Possible forms: [expression] op [expression], [expression] op [function call], [function call] op [expression], [function call] op [function call]
			operator = node.getT(0);
			boolean firstExp = true, secondExp = true;
			
			switch (Compiler.getType(node.getNode(0).ruleName))
			{
			case expression: // [expression] op ...
				firstExp = true;
				expNodeX = new ExpressionNode(this).interpret(node.getNode(0));
				break;
			case functionCall:
				firstExp = false;
				callNodeX = new FunctionCallNode(this).interpret(node.getNode(0));
				break;	
			default: // ???
				break;
			}
			
			switch (Compiler.getType(node.getNode(1).ruleName))
			{
			case expression: // [expression] op ...
				secondExp = true;
				expNodeY = new ExpressionNode(this).interpret(node.getNode(1));
				break;
			case functionCall:
				secondExp = false;
				callNodeY = new FunctionCallNode(this).interpret(node.getNode(1));
				break;	
			default: // ???
				break;
			}
			
			expressionType = firstExp ? (secondExp ? ExpressionType.expOpExp : ExpressionType.expOpCall) : (secondExp ? ExpressionType.callOpExp : ExpressionType.callOpCall);
			break;
		}
		
		return this;
	}

	private TypeNode getTypeX(boolean assumeFirst) throws Exception
	{
		TypeNode typeX = null;
		switch (expressionType) // Get X's typename
		{
		case litOpLit: case litOpVar: case litOpExp: case litOpCall: // X is literal
			typeX = CompConfig.BasicType.getType(literalXClass).getType();
			break;
		case varOpLit: case varOpVar: case varOpExp: case varOpCall: // X is a variable
			typeX = resolveVariable(x).getType();
			break;
		case expOpLit: case expOpVar: case expOpExp: case expOpCall: case loneExp: // X is an expression
			typeX = expNodeX.getType(assumeFirst);
			break;
		case callOpLit: case callOpVar: case callOpExp: case callOpCall: case loneCall: // X is a call
			typeX = callNodeX.getType();
			break;
		}
		
		return typeX;
	}
	private TypeNode getTypeX()
	{
		try {return getTypeX(true);}
		catch (Exception e) {return null;}
	}
	private TypeNode getTypeY()
	{
		try {return getTypeY(true);}
		catch (Exception e) {return null;}
	}
	
	private TypeNode getTypeY(boolean assumeFirst) throws Exception
	{
		TypeNode typeY = null;
		switch (expressionType) // get Y's typename
		{
		case litOpLit: case varOpLit: case expOpLit: case callOpLit: // Y is literal
			typeY = CompConfig.BasicType.getType(literalYClass).getType();
			break;
		case litOpVar: case varOpVar: case expOpVar: case callOpVar: // Y is a variable
			typeY = resolveVariable(y).getType();
			break;
		case litOpExp: case varOpExp: case expOpExp: case callOpExp: // Y is an expression
			typeY = expNodeY.getType(assumeFirst);
			break;
		case litOpCall: case varOpCall: case expOpCall: case callOpCall: // Y is a call
			typeY = callNodeY.getType();
			break;
		}
		
		return typeY;
	}
	
	public String getTypeName(boolean assumeFirst) throws Exception // TODO custom exception
	{
		String nameX = null, nameY = null;
		nameX = getTypeX(assumeFirst).getName();
		nameY = getTypeY(assumeFirst).getName();
		
		if (nameX.equals(nameY) || assumeFirst)
		{
			if (operator.matches("\\<|\\<\\=|\\>|\\>\\=|\\=\\=|\\!\\=")) return CompConfig.BasicType.t_bool.getName();
			else return nameX;
		}
		else throw new TypeMismatchException(nameX, nameY); // If we can't assume X is correct then they must agree
	}
	@Override
	public String getTypeName()
	{
		try {return getTypeName(true);}
		catch (Exception e) {return null;}
	}
	public TypeNode getType(boolean assumeFirst) throws Exception // TODO custom exception
	{
		return resolveType(getTypeName(assumeFirst));
	}
	@Override
	public TypeNode getType()
	{
		try {return getType(true);}
		catch (Exception e) {return null;}
	}

	public String getAssembly(int leadingWhitespace, String destAddr, boolean useOperandB) throws Exception
	{
		String whitespace = getWhitespace(leadingWhitespace);
		final String destOperand = useOperandB ? CompConfig.operandB : CompConfig.operandA;
		final String otherOperand = useOperandB ? CompConfig.operandA : CompConfig.operandB;
		final Function<Integer, String> sourceX, sourceY;
		String assembly = "";

		if (!CompConfig.BasicType.isBasic(getType(false))) // TODO custom operators
			throw new UndefinedOpException(getType(false).getFullName(), operator);
		
		final int size = getTypeX().getSize();
		
		// Figure out Y first, make sure it gets put in otherOperand
		switch (expressionType)
		{
		case litOpLit: case varOpLit: case expOpLit: case callOpLit: // Y is literal
			if (literalYClass.equals(Integer.class)) // Integer literal TODO use CompConfig.BasicType.getType
				sourceY = integerSource((Integer) literalY);
			else if (literalYClass.equals(String.class))
				sourceY = byteStreamSource(((String) literalY).getBytes());
			else if (literalYClass.equals(Character.class))
				sourceY = byteStreamSource(new byte[] {(byte) ((Character) literalY).charValue()});
			else if (literalYClass.equals(Boolean.class))
				sourceY = byteStreamSource(new byte[] {(byte) (((Boolean) literalY) ? 0xFF : 0x00)});
			else
				sourceY = null;
			break;
		case litOpVar: case varOpVar: case expOpVar: case callOpVar: // Y is a variable
			sourceY = addressSource(resolveVariable(y).getFullName(), getTypeX(false).getSize());
			break;
		case litOpExp: case varOpExp: case expOpExp: case callOpExp: // Y is an expression
			assembly += expNodeY.getAssembly(leadingWhitespace, otherOperand, useOperandB); // TODO should be !useOperandB but this causes an error for some reason
			sourceY = (Integer i) -> {return otherOperand + " + " + Math.min(size - 1, 2 * i);};
			break;
		case litOpCall: case varOpCall: case expOpCall: case callOpCall: // Y is a call
			assembly += callNodeY.getAssembly(leadingWhitespace);
			if (!CompConfig.callResult.equals(otherOperand)) // Move it into other operand if it's not already there
				assembly += byteCopier(whitespace, callNodeY.getType().getSize(), otherOperand, CompConfig.callResult);
			sourceY = (Integer i) -> {return otherOperand + " + " + Math.min(size - 1, 2 * i);};
			break;
		case loneLit: case loneVar: case loneExp: case loneCall:
			sourceY = null;
			break;
		default:
			sourceY = null;
			break;
		}
		// Now we figure out X
		switch (expressionType)
		{
		case litOpLit: case litOpVar: case litOpExp: case litOpCall: case loneLit: // X is literal
			if (literalXClass.equals(Integer.class)) // Integer literal
				sourceX = integerSource((Integer) literalX);
			else if (literalXClass.equals(String.class))
				sourceX = byteStreamSource(((String) literalX).getBytes());
			else if (literalXClass.equals(Character.class))
				sourceX = byteStreamSource(new byte[] {(byte) ((Character) literalX).charValue()});
			else if (literalXClass.equals(Boolean.class))
				sourceX = byteStreamSource(new byte[] {(byte) (((Boolean) literalX) ? 0xFF : 0x00)});
			else
				sourceX = null;
			break;
		case varOpLit: case varOpVar: case varOpExp: case varOpCall: case loneVar: // X is a variable
			sourceX = addressSource(resolveVariable(x).getFullName(), getTypeX(false).getSize());
			break;
		case expOpLit: case expOpVar: case expOpExp: case expOpCall: case loneExp: // X is an expression
			assembly += expNodeX.getAssembly(leadingWhitespace, destOperand, useOperandB);
			sourceX = addressSource(destOperand, expNodeX.getType(false).getSize());
			break;
		case callOpLit: case callOpVar: case callOpExp: case callOpCall: case loneCall: // X is a call
			assembly += callNodeX.getAssembly(leadingWhitespace);
			if (!CompConfig.callResult.equals(destOperand)) // Move it into dest operand if it's not already there
				assembly += byteCopier(whitespace, callNodeX.getType().getSize(), destOperand, CompConfig.callResult);
			sourceX = (Integer i) -> {return CompConfig.callResult + " + " + Math.min(size - 1, 2 * i);};
			break;
		default:
			sourceX = null;
			break;
		}
		
		if (operator != null)
		{
			switch (operator)
			{
			case "+":
				assembly += bytewiseOperation(whitespace, getType(false).getSize(), (Integer i) -> 
				{return new String[]
					{
						"LDA\t" + sourceX.apply(i),
						"ADC\t" + sourceY.apply(i),
						"STA\t" + destAddr + " + " + Math.min(size - 1, 2 * i),
					};
				});
				break;
			case "-":
				assembly += bytewiseOperation(whitespace, getType(false).getSize(), (Integer i) -> 
				{return new String[]
					{
						"LDA\t" + sourceX.apply(i),
						"SBC\t" + sourceY.apply(i),
						"STA\t" + destAddr + " + " + Math.min(size - 1, 2 * i),
					};
				});
				break;
			case "<":
				assembly += whitespace + CompConfig.setXY8 + "\n";
				assembly += whitespace + "LDX\t#$00\n";
				
				assembly += bytewiseOperation(whitespace, getTypeX(false).getSize(), (Integer i) -> 
				{
					// Are we at the last byte of an odd-size number, i. e. in 8-bit mode?
					if (i == 0)
					{
						String toXOR = "#$80" + ((2 * i < getTypeX().getSize() - 1) ? "00" : "");
						// Start at MSB
						return new String[]
						{
							"LDA\t" + sourceY.apply((int) Math.floor(getTypeX().getSize() / 2) - 1 - i),	// Get Y
							"EOR\t" + toXOR,																// Flip sign
							"STA\t" + destOperand,															// Place Y in destAddr
							"LDA\t" + sourceX.apply((int) Math.floor(getTypeX().getSize() / 2) - 1 - i),	// Get X
							"EOR\t" + toXOR,																// Flip sign
							"CMP\t" + destOperand,															// Cmp X & Y?
							"BCC\t+",													// If X < Y then yes
							"BNE\t++",													// If X > Y then no
							// else maybe
						};
					}
					else return new String[]
						{
							"LDA\t" + sourceX.apply((int) Math.floor(getTypeX().getSize() / 2) - 1 - i),	// Get X
							"CMP\t" + sourceY.apply((int) Math.floor(getTypeX().getSize() / 2) - 1 - i),	// Cmp X & Y?	
							"BCC\t+",													// If X < Y then yes
							"BNE\t++",													// If X > Y then no
							// else maybe
						};
						
					
					
				});
				assembly += ":" + whitespace.substring(1) + CompConfig.setXY8 + "\n";
				assembly += whitespace + "LDX\t#$FF\n";
				assembly += ":" + whitespace.substring(1) + CompConfig.setXY8 + "\n";
				assembly += whitespace + "STX\t" + destAddr + "\n";
				break;
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
