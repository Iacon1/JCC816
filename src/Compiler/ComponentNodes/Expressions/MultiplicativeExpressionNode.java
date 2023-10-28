// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import java.util.function.Function;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompConfig;
import Compiler.Utils.CompUtils;
import Compiler.Utils.OperandSource;
import Compiler.Utils.SNESRegisters;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.ScratchManager.ScratchSource;
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
	private static String divisionHeader(String whitespace, ScratchManager scratchManager, ScratchSource sourceX, ScratchSource sourceY) throws Exception
	{
		String assembly = "";
		
		// First, check negative for X
		assembly += whitespace + CompUtils.setAXY8 + "\n";
		assembly += whitespace + "LDY\t#$00\n";
		assembly += whitespace + "LDA\t" + sourceX.apply(sourceX.getSize() - 1) + "\n";
		assembly += whitespace + "BPL\t:+\n";
		// If it was negative we add one to the flag and then make it positive.
		assembly += whitespace + "INY\n";
		assembly += XOrExpressionNode.getExclOr(whitespace, sourceX.getAddress(), sourceX, AssemblyUtils.numericSource(-1, sourceX.getSize()));
		
		// Then for Y
		assembly += whitespace + CompUtils.setA8 + "\n";
		assembly += whitespace + "LDA\t" + sourceY.apply(sourceY.getSize() - 1) + "\n";
		assembly += whitespace + "BPL\t:+\n";
		// If it was negative we subtract one from the previous flag (making it not zero if it was zero and making it zero if it wasn't)
		// and then make it positive.
		assembly += whitespace + "DEY\n";
		assembly += XOrExpressionNode.getExclOr(whitespace, sourceY.getAddress(), sourceY, AssemblyUtils.numericSource(-1, sourceY.getSize()));
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
	public static String getShortDivider(String whitespace, String destAddr, ScratchManager scratchManager, ScratchSource sourceX, ScratchSource sourceY) throws Exception
	{
		final OperandSource sourceZ = AssemblyUtils.addressSource(destAddr, sourceX.getSize());
		
		String assembly = divisionHeader(whitespace, scratchManager, sourceX, sourceY);
		
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
	public static String getLongDivider(String whitespace, String destAddr, ScratchManager scratchManager, ScratchSource sourceX, ScratchSource sourceY) throws Exception
	{
		ScratchSource sourceI = scratchManager.reserveScratchBlock(sourceX.getSize());
		OperandSource sourceZ = AssemblyUtils.addressSource(destAddr, sourceX.getSize());
		ScratchSource sourceT = scratchManager.reserveScratchBlock(2);
		
		String assembly = divisionHeader(whitespace, scratchManager, sourceX, sourceY);

		scratchManager.releaseScratchBlock(sourceY);
		ScratchSource sourceB = scratchManager.reserveScratchBlock(sourceX.getSize() + sourceY.getSize());								//[x+y]sized B
		OperandSource sourceN = AssemblyUtils.numericSource(0, sourceX.getSize());
		assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), sourceB.getAddress(), sourceN);								// B = ????...0000
		assembly += AssemblyUtils.byteCopier(whitespace, sourceY.getSize(), sourceB.getAddress(sourceX.getSize()), sourceY); 			// B = Y << [sox]
		
		sourceN = AssemblyUtils.numericSource(1, sourceB.getSize());
		assembly += ShiftExpressionNode.getShift(whitespace, sourceB.getAddress(), scratchManager, sourceB, ">>", sourceN);				// B = Y << [sox]-1
		
		sourceN = AssemblyUtils.numericSource(0x80 * (int) Math.pow(0x10, sourceX.getSize()), sourceI.getSize());						
		assembly += AssemblyUtils.byteCopier(whitespace, sourceI.getSize(), sourceI.getAddress(), sourceN);								// I = 0x80...0
		
		assembly += "@reiterate:\n";																									// Start of loop
		
		assembly += RelationalExpressionNode.getComparison(whitespace, sourceT.getAddress(), scratchManager, sourceX, ">=", sourceB);	// X >= B?
		assembly += whitespace + "BEQ\t:+\n"; 																							// If not, skip next two.
		
		assembly += AdditiveExpressionNode.getSubtractor(whitespace, sourceX.getAddress(), sourceX, sourceB); 							// X = X - B
		assembly += AdditiveExpressionNode.getAdder(whitespace, destAddr, sourceZ, sourceI);											// Z += I
		assembly += ":\n";
		sourceN = AssemblyUtils.numericSource(1, sourceY.getSize());
		assembly += ShiftExpressionNode.getShift(whitespace, sourceB.getAddress(), scratchManager, sourceB, ">>", sourceN);				// B /= 2
		assembly += ShiftExpressionNode.getShift(whitespace, sourceI.getAddress(), scratchManager, sourceI, ">>", sourceN);				// I /= 2
		assembly += EqualityExpressionNode.getIsZero(whitespace, sourceT.getAddress(), scratchManager, sourceI);						// I = 0?
		assembly += whitespace + "BEQ\t:+\n"; 																							// If so, end loop
		assembly += whitespace + "JMP\t@reiterate\n";																					// Go back to start of loop
		assembly += whitespace + ":\n";
		assembly += divisionFooter(whitespace, destAddr, sourceZ);
		
		scratchManager.releaseScratchBlock(sourceI);
		scratchManager.releaseScratchBlock(sourceT);
		return assembly;
	}

	@Override
	protected String getAssembly(String whitespace, String destAddr, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		String assembly = "";
		scratchManager = new ScratchManager(); // Since we're about to call a sub we need a blank scratch manager.
		switch (operator)
		{
		case "*":
			if (sourceX.getSize() > 2 || sourceY.getSize() > 2) // Too big to inline
			{
				
				assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), scratchManager.reserveScratchBlock(sourceX.getSize()).getAddress(), sourceX);
				assembly += AssemblyUtils.byteCopier(whitespace, sourceY.getSize(), scratchManager.reserveScratchBlock(sourceY.getSize()).getAddress(), sourceY);
				assembly += whitespace + "JSL\t" + ComponentNode.registerMult(sourceX.getSize(), sourceY.getSize());
				assembly += AssemblyUtils.byteCopierAddr(whitespace, sourceX.getSize(), destAddr, CompConfig.callResult);
			}
			else assembly += MultiplicativeExpressionNode.getMultiplier(whitespace, destAddr, sourceX, sourceY);
			break;
		case "/": // Never inline
			assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), scratchManager.reserveScratchBlock(sourceX.getSize()).getAddress(), sourceX);
			assembly += AssemblyUtils.byteCopier(whitespace, sourceY.getSize(), scratchManager.reserveScratchBlock(sourceY.getSize()).getAddress(), sourceY);
			assembly += whitespace + "JSL\t" + ComponentNode.registerDiv(sourceX.getSize(), sourceY.getSize()) + "\n";
			assembly += AssemblyUtils.byteCopierAddr(whitespace, sourceX.getSize(), destAddr, CompConfig.callResult);
			break;
		}
		
		return assembly;
	}
}
