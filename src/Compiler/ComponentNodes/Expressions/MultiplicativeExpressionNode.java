// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import java.util.function.Function;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompUtils;
import Compiler.Utils.OperandSource;
import Compiler.Utils.SNESRegisters;
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
	public BaseExpressionNode<Multiplicative_expressionContext> interpret(Multiplicative_expressionContext node) throws Exception
	{
		BaseExpressionNode ret = super.interpret(node);
		if (operator == null) return ret; // We've clearly delegated
		switch (operator)
		{
		case "*":
			if (x.getType().getSize() + y.getType().getSize() > 4) // Too big to reasonably inline
				ComponentNode.registerMult(x.getType().getSize(), y.getType().getSize());
			break;
		case "/": // Never inline
			ComponentNode.registerDiv(x.getType().getSize(), y.getType().getSize());
			break;
		}
		
		return ret;
	}
	@Override
	public Object getPropValue()
	{
		Long a = ((Number) x.getPropValue()).longValue();
		Long b = ((Number) y.getPropValue()).longValue();
		switch (operator)
		{
		case "*": return Long.valueOf(a * b);
		case "/": return Long.valueOf(a / b);
		default: return null;
		}
	}
	// Uses hardware mult registers
	public static String getMultiplier(String whitespace, String destAddr, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		String assembly = "";
		for (int i = 0; i < sourceX.getSize(); ++i)
		{
			final int ii = i;
			assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize() - i, (Integer j) ->
			{
				if (j != 0) return new String[]
				{
					"LDA\t" + SNESRegisters.RDMPYH, 	// Load previous high byte as carryover
					"TAX",								// Store in X
					"LDA\t" + sourceX.apply(ii),		// Load X-the-variable
					"STA\t" + SNESRegisters.WRMPYA,		// Place in reg
					"LDA\t" + sourceY.apply(ii + j),	// Load Y-the-variable
					"STA\t" + SNESRegisters.WRMPYB, 	// Place in reg, begin 8-cycle calc
					"TXA",								// 2 cycles - 2
					"NOP",								// 2 cycles - 4
					"ADC\t" + SNESRegisters.RDMPYL,		// 5 cycles - 9, get result and add carryover 
					"STA\t" + destAddr + " + " + (ii + j),	// Store result
				};
				else return new String[]
				{
					"LDA\t" + sourceX.apply(ii),		// Load X-the-variable
					"STA\t" + SNESRegisters.WRMPYA,		// Place in reg
					"LDA\t" + sourceY.apply(ii + j),	// Load Y-the-variable
					"STA\t" + SNESRegisters.WRMPYB, 	// Place in reg, begin 8-cycle calc
					"NOP",								// 2 cycles - 2
					"NOP",								// 2 cycles - 4
					"LDA\t" + SNESRegisters.RDMPYL,		// 5 cycles - 9, get result
					"STA\t" + destAddr + " + " + (ii + j),	// Store result
				};
			}, false, false);
		}
		return assembly;
	}
	// Handles negative numbers for division, stores 0, 1, or 2 in Y-register
	private static String divisionHeader(String whitespace, boolean useB, OperandSource sourceX, OperandSource sourceY)
	{
		String assembly = "";
		final String destOperand = useB ? CompUtils.operandB : CompUtils.operandA;
		final String otherOperand = useB ? CompUtils.operandA : CompUtils.operandB;
		
		// First, check negative for X
		assembly += whitespace + CompUtils.setAXY8 + "\n";
		assembly += whitespace + "LDY\t#$00\n";
		assembly += whitespace + "LDA\t" + sourceX.apply(sourceX.getSize() - 1) + "\n";
		assembly += whitespace + "BPL\t:+\n";
		// If it was negative we add one to the flag and then make it positive.
		assembly += whitespace + "INY\n";
		assembly += XOrExpressionNode.getExclOr(whitespace, destOperand, sourceX, AssemblyUtils.numericSource(-1, sourceX.getSize()));
		
		// Then for Y
		assembly += whitespace + CompUtils.setA8 + "\n";
		assembly += whitespace + "LDA\t" + sourceY.apply(sourceY.getSize() - 1) + "\n";
		assembly += whitespace + "BPL\t:+\n";
		// If it was negative we subtract one from the previous flag (making it not zero if it was zero and making it zero if it wasn't)
		// and then make it positive.
		assembly += whitespace + "DEY\n";
		assembly += XOrExpressionNode.getExclOr(whitespace, otherOperand, sourceY, AssemblyUtils.numericSource(-1, sourceY.getSize()));
		assembly += ":\n";
		
		return assembly;
	}
	private static String divisionFooter(String whitespace, String destAddr, OperandSource source)
	{
		String assembly = "";
		// First, check flag from header
		assembly += whitespace + "TYA\n";
		assembly += whitespace + "BEQ\t:+\n";
		// If it was positive then only one of the operands was negative so the result is negative too.
		assembly += XOrExpressionNode.getExclOr(whitespace, destAddr, source, AssemblyUtils.numericSource(-0, source.getSize()));
		assembly += ":\n";
		
		return assembly;
	}
	
	// Uses hardware div registers, but only for 8-bit divisor
	public static String getShortDivider(String whitespace, String destAddr, boolean useB, int sizeX, int sizeY)
	{
		final String destOperand = useB ? CompUtils.operandB : CompUtils.operandA;
		final String otherOperand = useB ? CompUtils.operandA : CompUtils.operandB;
		
		final OperandSource sourceX = AssemblyUtils.addressSource(destOperand, sizeX);
		final OperandSource sourceY = AssemblyUtils.addressSource(otherOperand, sizeY);
		final OperandSource sourceZ = AssemblyUtils.addressSource(destAddr, sizeX);
		
		String assembly = divisionHeader(whitespace, useB, sourceX, sourceY);
		
		assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i) ->
		{
			if (i < sourceX.getSize() - 1 || sourceX.getSize() % 2 == 0) // We start in 16-bit mode
			{
				if (i == 0) // First iteration
					return new String[]
					{
						"LDA\t" + sourceX.apply(i),			// Load X-the-variable
						"STA\t" + SNESRegisters.WRDIVL,		// Place in reg
						CompUtils.setA8,
						"LDA\t" + sourceY.apply(0),			// Load Y-the-variable
						"STA\t" + SNESRegisters.WRDIVB, 	// Place in reg, begin 16-cycle calc
						"LDA\t" + sourceX.apply(i),			// 6 cycles,- 6 Load X-the-variable for next iteration
						"TAX",								// 2 cycles - 8
						"NOP",								// 2 cycles - 10
						CompUtils.setA16,					// 3 cycles - 13
						"LDA\t" + SNESRegisters.RDDIVL,		// 6 cycles - 17, get result
						"STA\t" + destAddr + " + " + i,		// Store result
					};
				if (i != sourceX.getSize() - 1) // Not the last iteration
					return new String[]
					{
						"TXA",								// Recover X-the-variable from last iteration.
						"STA\t" + SNESRegisters.WRDIVL,		// Place in reg
						CompUtils.setA8,
						"LDA\t" + sourceY.apply(0),			// Load Y-the-variable
						"STA\t" + SNESRegisters.WRDIVB, 	// Place in reg, begin 16-cycle calc
						"LDA\t" + sourceX.apply(i),			// 6 cycles,- 6 Load X-the-variable for next iteration
						"TAX",								// 2 cycles - 8
						"NOP",								// 2 cycles - 10
						CompUtils.setA16,					// 3 cycles - 13
						"LDA\t" + SNESRegisters.RDDIVL,		// 6 cycles - 17, get result
						"STA\t" + destAddr + " + " + i,		// Store result
					};
				else // Last iteration
					return new String[]
					{
						"TXA",								// Recover X-the-variable from last iteration.
						"STA\t" + SNESRegisters.WRDIVL,		// Place in reg
						CompUtils.setA8,
						"LDA\t" + sourceY.apply(0),			// Load Y-the-variable
						"STA\t" + SNESRegisters.WRDIVB, 	// Place in reg, begin 16-cycle calc
						"NOP",								// 2 cycles - 2
						"NOP",								// 2 cycles - 4
						"NOP",								// 2 cycles - 6
						"NOP",								// 2 cycles - 8
						"NOP",								// 2 cycles - 10
						CompUtils.setA16,					// 3 cycles - 13
						"LDA\t" + SNESRegisters.RDDIVL,		// 6 cycles - 17, get result
						"STA\t" + destAddr + " + " + i,		// Store result
					};
			}
			else // We start in 8-bit mode
				return new String[]
				{
					"LDA\t" + sourceX.apply(i),			// Load X-the-variable
					"STA\t" + SNESRegisters.WRDIVL,		// Place in reg
					"LDA\t" + sourceY.apply(0),			// Load Y-the-variable
					"STA\t" + SNESRegisters.WRDIVB, 	// Place in reg, begin 16-cycle calc
					"NOP",								// 2 cycles - 2
					"NOP",								// 2 cycles - 4
					"NOP",								// 2 cycles - 6
					"NOP",								// 2 cycles - 8
					"NOP",								// 2 cycles - 10
					"NOP",								// 2 cycles - 11
					"NOP",								// 2 cycles - 12
					"LDA\t" + SNESRegisters.RDDIVL,		// 5 cycles - 17, get result
					"STA\t" + destAddr + " + " + i,		// Store result
				};
		});
		
		assembly += divisionFooter(whitespace, destAddr, sourceZ);
		return assembly;
	}
	// Does not use hardware div registers
	// https://godbolt.org/z/Y8aM3o8eY
	public static String getLongDivider(String whitespace, String destAddr, boolean useB, int sizeX, int sizeY)
	{
		final String destOperand = useB ? CompUtils.operandB : CompUtils.operandA;
		final String otherOperand = useB ? CompUtils.operandA : CompUtils.operandB;
		
		OperandSource sourceX = AssemblyUtils.addressSource(destOperand, sizeX);
		OperandSource sourceY = AssemblyUtils.addressSource(otherOperand, sizeY);
		OperandSource sourceI = AssemblyUtils.addressSource(CompUtils.operandC, sizeY);
		OperandSource sourceZ = AssemblyUtils.addressSource(destAddr, sizeX);
		String assembly = divisionHeader(whitespace, useB, sourceX, sourceY);

		assembly += AssemblyUtils.byteCopier(whitespace, sizeY, otherOperand + " + " + sizeX, sourceY); // Y << sizeX
		sourceY = AssemblyUtils.addressSource(otherOperand, sizeX + sizeY); // double y's size
		OperandSource sourceN = AssemblyUtils.numericSource(1, sizeX + sizeY);
		assembly += ShiftExpressionNode.getShift(whitespace, otherOperand, useB, sourceY, ">>", sourceN);
		// ^ y <<= (sizeX - 1) overall
		
		sourceN = AssemblyUtils.numericSource(0x80 * (int) Math.pow(0x10, sizeX), sizeX);
		assembly += AssemblyUtils.byteCopier(whitespace, sourceI.getSize(), CompUtils.operandC, sourceN);
		
		assembly += "@reiterate:\n";
		assembly += RelationalExpressionNode.getComparison(whitespace, destOperand + " + " + sizeX, useB, sourceX, ">=", sourceY);
		// Creates a secret fifth scratch, hoping the size of X wasn't the size of the operand
		assembly += whitespace + "BEQ\t:+\n"; // If x < y skip this next bit. 
		assembly += AdditiveExpressionNode.getSubtractor(whitespace, destOperand, sourceX, sourceY); 
		assembly += AdditiveExpressionNode.getAdder(whitespace, destAddr, sourceZ, sourceI);
		assembly += ":\n";
		sourceN = AssemblyUtils.numericSource(1, sizeX);
		assembly += ShiftExpressionNode.getShift(whitespace, otherOperand, useB, sourceY, ">>", sourceN); // Contains one label
		assembly += ShiftExpressionNode.getShift(whitespace, CompUtils.operandC, useB, sourceI, ">>", sourceN); // Contains one label
		assembly += whitespace + "BEQ\t:+\n"; // Continue until i is 0.
		assembly += whitespace + "JMP\t@reiterate\n";
		assembly += whitespace + ":\n";
		assembly += divisionFooter(whitespace, destAddr, sourceZ);
		return assembly;
	}

	@Override
	protected String getAssembly(String whitespace, String destAddr, boolean useB, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		String assembly = "";
		switch (operator)
		{
		case "*":
			if (sourceX.getSize() > 2 || sourceY.getSize() > 2) // Too big to inline
			{
				assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), CompUtils.operandA, sourceX);
				assembly += AssemblyUtils.byteCopier(whitespace, sourceY.getSize(), CompUtils.operandB, sourceY);
				assembly += whitespace + "JSL\t" + ComponentNode.registerMult(sourceX.getSize(), sourceY.getSize());
				assembly += AssemblyUtils.byteCopierAddr(whitespace, sourceX.getSize(), destAddr, CompUtils.callResult);
			}
			else assembly += MultiplicativeExpressionNode.getMultiplier(whitespace, destAddr, sourceX, sourceY);
			break;
		case "/": // Never inline
			assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), CompUtils.operandA, sourceX);
			assembly += AssemblyUtils.byteCopier(whitespace, sourceY.getSize(), CompUtils.operandB, sourceY);
			assembly += whitespace + "JSL\t" + ComponentNode.registerDiv(sourceX.getSize(), sourceY.getSize()) + "\n";
			assembly += AssemblyUtils.byteCopierAddr(whitespace, sourceX.getSize(), destAddr, CompUtils.callResult);
			break;
		}
		
		return assembly;
	}
}
