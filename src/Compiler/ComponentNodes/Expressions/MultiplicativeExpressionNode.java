// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompConfig;
import Compiler.Utils.CompUtils;
import Compiler.Utils.SNESRegisters;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.ConstantSource;
import Compiler.Utils.OperandSources.OperandSource;
import Compiler.Utils.ScratchManager.ScratchSource;
import Grammar.C99.C99Parser.Cast_expressionContext;
import Grammar.C99.C99Parser.Multiplicative_expressionContext;

public class MultiplicativeExpressionNode extends BinaryExpressionNode
<Multiplicative_expressionContext, Cast_expressionContext, Cast_expressionContext, Multiplicative_expressionContext>
{
	private static int multThreshold = 0; // How many bytes can the two operands be before the multiplier isn't inlined?
	
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
	public Object getPropValue()
	{
		Long a = x.getPropLong();
		Long b = y.getPropLong();
		switch (operator)
		{
		case "*": return Long.valueOf(a * b);
		case "/": return Long.valueOf(a / b);
		default: return null;
		}
	}
	// Uses hardware mult registers
	public static String getMultiplier(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		String assembly = "";
		for (int i = 0; i < sourceX.getSize(); ++i)
		{
			final int ii = i;
			assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize() - i, (Integer j, Boolean is16Bit) ->
			{
				if (j != 0) return new String[]
				{
					"LDA\t" + SNESRegisters.RDMPYH, 			// Load previous high byte as carryover
					"TAX",										// Store in X
					sourceX.prefaceAssembly(whitespace, ii, is16Bit),
					"LDA\t" + sourceX.apply(ii, is16Bit),		// Load X-the-variable
					"STA\t" + SNESRegisters.WRMPYA,				// Place in reg
					sourceY.prefaceAssembly(whitespace, ii + j, is16Bit),
					"LDA\t" + sourceY.apply(ii + j, is16Bit),	// Load Y-the-variable
					"STA\t" + SNESRegisters.WRMPYB, 			// Place in reg, begin 8-cycle calc
					"TXA",										// 2 cycles - 2
					"NOP",										// 2 cycles - 4
					"ADC\t" + SNESRegisters.RDMPYL,				// 5 cycles - 9, get result and add carryover 
					"STA\t" + destSource.apply(ii + j, is16Bit),// Store result
				};
				else return new String[]
				{
					sourceX.prefaceAssembly(whitespace, ii, is16Bit),
					"LDA\t" + sourceX.apply(ii, is16Bit),		// Load X-the-variable
					"STA\t" + SNESRegisters.WRMPYA,				// Place in reg
					sourceY.prefaceAssembly(whitespace, ii + j, is16Bit),
					"LDA\t" + sourceY.apply(ii + j, is16Bit),	// Load Y-the-variable
					"STA\t" + SNESRegisters.WRMPYB, 			// Place in reg, begin 8-cycle calc
					"NOP",										// 2 cycles - 2
					"NOP",										// 2 cycles - 4
					"LDA\t" + SNESRegisters.RDMPYL,				// 5 cycles - 9, get result
					"STA\t" + destSource.apply(ii + j, is16Bit),// Store result
				};
			}, false, false);
		}
		return assembly;
	}
	// Handles negative numbers for division, stores 0, 1, or 2 in Y-register
	private static String divisionHeader(String whitespace, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		String assembly = "";
		
		// First, check negative for X
		assembly += whitespace + CompUtils.setAXY8 + "\n";
		assembly += whitespace + "LDY\t#$00\n";
		assembly += whitespace + "LDA\t" + sourceX.apply(sourceX.getSize() - 1, false) + "\n";
		assembly += whitespace + "BPL\t:+\n";
		// If it was negative we add one to the flag and then make it positive.
		assembly += whitespace + "INY\n";
		assembly += XOrExpressionNode.getExclOr(whitespace, sourceX, sourceX, new ConstantSource(-1, sourceX.getSize()));
		
		// Then for Y
		assembly += whitespace + CompUtils.setA8 + "\n";
		assembly += whitespace + "LDA\t" + sourceY.apply(sourceY.getSize() - 1, false) + "\n";
		assembly += whitespace + "BPL\t:+\n";
		// If it was negative we subtract one from the previous flag (making it not zero if it was zero and making it zero if it wasn't)
		// and then make it positive.
		assembly += whitespace + "DEY\n";
		assembly += XOrExpressionNode.getExclOr(whitespace, sourceY, sourceY, new ConstantSource(-1, sourceY.getSize()));
		assembly += ":\n";
		
		return assembly;
	}
	private static String divisionFooter(String whitespace, OperandSource destSource, OperandSource source)
	{
		String assembly = "";
		// First, check flag from header
		assembly += whitespace + "TYA\n";
		assembly += whitespace + "BEQ\t:+\n";
		// If it was positive then only one of the operands was negative so the result is negative too.
		assembly += XOrExpressionNode.getExclOr(whitespace, destSource, source, new ConstantSource(-0, source.getSize()));
		assembly += ":\n";
		
		return assembly;
	}
	
	// Uses hardware div registers, but only for 8-bit divisor
	public static String getShortDivider(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		String assembly = divisionHeader(whitespace, sourceX, sourceY);
		
		assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, Boolean is16Bit) ->
		{
			if (i < sourceX.getSize() - 1 || sourceX.getSize() % 2 == 0) // We start in 16-bit mode
			{
				if (i == 0) // First iteration
					return new String[]
					{
						"LDA\t" + sourceX.apply(i, is16Bit),	// Load X-the-variable
						"STA\t" + SNESRegisters.WRDIVL,			// Place in reg
						CompUtils.setA8,
						"LDA\t" + sourceY.apply(0, is16Bit),	// Load Y-the-variable
						"STA\t" + SNESRegisters.WRDIVB, 		// Place in reg, begin 16-cycle calc
						"LDA\t" + sourceX.apply(i, is16Bit),	// 6 cycles,- 6 Load X-the-variable for next iteration
						"TAX",									// 2 cycles - 8
						"NOP",									// 2 cycles - 10
						CompUtils.setA16,						// 3 cycles - 13
						"LDA\t" + SNESRegisters.RDDIVL,			// 6 cycles - 17, get result
						"STA\t" + destSource.apply(i, is16Bit),	// Store result
					};
				if (i != sourceX.getSize() - 1) // Not the last iteration
					return new String[]
					{
						"TXA",									// Recover X-the-variable from last iteration.
						"STA\t" + SNESRegisters.WRDIVL,			// Place in reg
						CompUtils.setA8,
						"LDA\t" + sourceY.apply(0, is16Bit),	// Load Y-the-variable
						"STA\t" + SNESRegisters.WRDIVB, 		// Place in reg, begin 16-cycle calc
						"LDA\t" + sourceX.apply(i, is16Bit),	// 6 cycles,- 6 Load X-the-variable for next iteration
						"TAX",									// 2 cycles - 8
						"NOP",									// 2 cycles - 10
						CompUtils.setA16,						// 3 cycles - 13
						"LDA\t" + SNESRegisters.RDDIVL,			// 6 cycles - 17, get result
						"STA\t" + destSource.apply(i, is16Bit),	// Store result
					};
				else // Last iteration
					return new String[]
					{
						"TXA",									// Recover X-the-variable from last iteration.
						"STA\t" + SNESRegisters.WRDIVL,			// Place in reg
						CompUtils.setA8,
						"LDA\t" + sourceY.apply(0, is16Bit),	// Load Y-the-variable
						"STA\t" + SNESRegisters.WRDIVB, 		// Place in reg, begin 16-cycle calc
						"NOP",									// 2 cycles - 2
						"NOP",									// 2 cycles - 4
						"NOP",									// 2 cycles - 6
						"NOP",									// 2 cycles - 8
						"NOP",									// 2 cycles - 10
						CompUtils.setA16,						// 3 cycles - 13
						"LDA\t" + SNESRegisters.RDDIVL,			// 6 cycles - 17, get result
						"STA\t" + destSource.apply(i, is16Bit),	// Store result
					};
			}
			else // We start in 8-bit mode
				return new String[]
				{
					"LDA\t" + sourceX.apply(i, is16Bit),	// Load X-the-variable
					"STA\t" + SNESRegisters.WRDIVL,			// Place in reg
					"LDA\t" + sourceY.apply(0, is16Bit),	// Load Y-the-variable
					"STA\t" + SNESRegisters.WRDIVB, 		// Place in reg, begin 16-cycle calc
					"NOP",									// 2 cycles - 2
					"NOP",									// 2 cycles - 4
					"NOP",									// 2 cycles - 6
					"NOP",									// 2 cycles - 8
					"NOP",									// 2 cycles - 10
					"NOP",									// 2 cycles - 11
					"NOP",									// 2 cycles - 12
					"LDA\t" + SNESRegisters.RDDIVL,			// 5 cycles - 17, get result
					"STA\t" + destSource.apply(i, is16Bit),	// Store result
				};
		});
		
		assembly += divisionFooter(whitespace, destSource, destSource);
		return assembly;
	}
	// Does not use hardware div registers
	// https://godbolt.org/z/Y8aM3o8eY
	public static String getLongDivider(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		ScratchSource sourceI = scratchManager.reserveScratchBlock(sourceX.getSize());
		ScratchSource sourceT = scratchManager.reserveScratchBlock(2);
		
		String assembly = divisionHeader(whitespace, sourceX, sourceY);

		ScratchSource sourceB = scratchManager.reserveScratchBlock(sourceX.getSize() + sourceY.getSize());								//[x+y]sized B
		OperandSource sourceN = new ConstantSource(0, sourceX.getSize());
		assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), sourceB, sourceN);			// B = ????...0000
		assembly += AssemblyUtils.byteCopier(whitespace, sourceY.getSize(), sourceB, sourceY); 			// B = Y << [sox]
		
		sourceN = new ConstantSource(1, sourceB.getSize());
		assembly += ShiftExpressionNode.getShift(whitespace, sourceB, scratchManager, sourceB, ">>", sourceN);				// B = Y << [sox]-1
		
		sourceN = new ConstantSource(0x80 * (int) Math.pow(0x10, sourceX.getSize()), sourceI.getSize());						
		assembly += AssemblyUtils.byteCopier(whitespace, sourceI.getSize(), sourceI, sourceN);								// I = 0x80...0
		
		assembly += "@reiterate:\n";																									// Start of loop
		
		assembly += RelationalExpressionNode.getComparison(whitespace, sourceT, scratchManager, sourceX, ">=", sourceB);	// X >= B?
		assembly += whitespace + "BEQ\t:+\n"; 																							// If not, skip next two.
		
		assembly += AdditiveExpressionNode.getSubtractor(whitespace, sourceX, sourceX, sourceB); 							// X = X - B
		assembly += AdditiveExpressionNode.getAdder(whitespace, destSource, destSource, sourceI);											// Z += I
		assembly += ":\n";
		sourceN = new ConstantSource(1, sourceY.getSize());
		assembly += ShiftExpressionNode.getShift(whitespace, sourceB, scratchManager, sourceB, ">>", sourceN);				// B /= 2
		assembly += ShiftExpressionNode.getShift(whitespace, sourceI, scratchManager, sourceI, ">>", sourceN);				// I /= 2
		assembly += EqualityExpressionNode.getIsZero(whitespace, sourceT, scratchManager, sourceI);							// I = 0?
		assembly += whitespace + "BEQ\t:+\n"; 																							// If so, end loop
		assembly += whitespace + "JMP\t@reiterate\n";																					// Go back to start of loop
		assembly += whitespace + ":\n";
		assembly += divisionFooter(whitespace, destSource, destSource);
		
		scratchManager.releaseScratchBlock(sourceI);
		scratchManager.releaseScratchBlock(sourceT);
		return assembly;
	}

	public static String getMultCall(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		String assembly = "";
		if (sourceX.getSize() + sourceY.getSize() > multThreshold) // Set these to a different number to inline certain multipliers.
		{	
			assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), CompConfig.multDivSource(true, sourceX.getSize()), sourceX);
			assembly += AssemblyUtils.byteCopier(whitespace, sourceY.getSize(), CompConfig.multDivSource(true, sourceX.getSize()), sourceY);
			assembly += whitespace + "JSL\t" + ComponentNode.registerMult(sourceX.getSize(), sourceY.getSize()) + "\n";
			assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), destSource, CompConfig.callResultSource(sourceX.getSize()));
		}
		else assembly += MultiplicativeExpressionNode.getMultiplier(whitespace, destSource, sourceX, sourceY);
		return assembly;
	}
	public static String getDivCall(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		String assembly = "";
		assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), CompConfig.multDivSource(true, sourceX.getSize()), sourceX);
		assembly += AssemblyUtils.byteCopier(whitespace, sourceY.getSize(), CompConfig.multDivSource(true, sourceX.getSize()), sourceY);
		assembly += whitespace + "JSL\t" + ComponentNode.registerDiv(sourceX.getSize(), sourceY.getSize()) + "\n";
		assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), destSource, CompConfig.callResultSource(sourceX.getSize()));
		return assembly;
	}
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		switch (operator)
		{
		case "*": return getMultCall(whitespace, destSource, scratchManager, sourceX, sourceY);
		case "/": return getDivCall(whitespace, destSource, scratchManager, sourceX, sourceY);
		default: return "";
		}
	}
}
