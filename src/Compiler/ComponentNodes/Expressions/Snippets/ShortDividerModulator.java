// Created by Iacon1 on 12/12/2023.
//
package Compiler.ComponentNodes.Expressions.Snippets;

import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompUtils;
import Compiler.Utils.SNESRegisters;
import Compiler.Utils.OperandSources.OperandSource;
import Compiler.Utils.AssemblyUtils.DetailsTicket;


//Uses hardware div registers, but only for 8-bit divisor
public class ShortDividerModulator
{
	protected ShortDividerModulator() {}
	// Handles negative numbers for division, stores 0, 1, or 2 in Y-register
	protected static String divisionHeader(String whitespace, OperandSource sourceX, OperandSource sourceY, DetailsTicket ticket) throws Exception
	{
		String assembly = "";
		
		// First, check negative for X
		assembly += whitespace + CompUtils.setAXY8 + "\n";
		assembly += whitespace + "LDY\t#$00\n";
		assembly += sourceX.getLDA(whitespace, sourceX.getSize() - 1, ticket);
		assembly += whitespace + "BPL\t:+\n";
		// If it was negative we add one to the flag and then make it positive.
		assembly += whitespace + "INY\n";
//		assembly += XOrExpressionNode.getExclOr(whitespace, sourceX, sourceX, new ConstantSource(-1, sourceX.getSize())); // TODO this is wrong, not how you negative it
		
		// Then for Y
		assembly += whitespace + CompUtils.setA8 + "\n";
		assembly += sourceY.getLDA(whitespace, sourceY.getSize() - 1, ticket);
		assembly += whitespace + "BPL\t:+\n";
		// If it was negative we subtract one from the previous flag (making it not zero if it was zero and making it zero if it wasn't)
		// and then make it positive.
		assembly += whitespace + "DEY\n";
//		assembly += XOrExpressionNode.getExclOr(whitespace, sourceY, sourceY, new ConstantSource(-1, sourceY.getSize())); // TODO this is wrong, not how you negative it
		assembly += ":\n";
		
		return assembly;
	}
	protected static String divisionFooter(String whitespace, OperandSource destSource, OperandSource source, DetailsTicket ticket)
	{
		String assembly = "";
		// First, check flag from header
		assembly += whitespace + "TYA\n";
		assembly += whitespace + "BEQ\t:+\n";
		// If it was positive then only one of the operands was negative so the result is negative too.
//		assembly += XOrExpressionNode.getExclOr(whitespace, destSource, source, new ConstantSource(-0, source.getSize())); // TODO this is wrong
		assembly += ":\n";
		
		return assembly;
	}
	
	public static String generate(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, boolean isModulo, DetailsTicket ticket) throws Exception
	{
		String assembly = "";
		SNESRegisters RRegL = isModulo? SNESRegisters.RDMPYL : SNESRegisters.RDDIVL;
		SNESRegisters RRegH = isModulo? SNESRegisters.RDMPYH : SNESRegisters.RDDIVH;
		assembly += ticket.save(whitespace, DetailsTicket.saveA | DetailsTicket.saveX | DetailsTicket.saveY); // All three modified hereafter
		DetailsTicket innerTicket = new DetailsTicket(ticket, DetailsTicket.saveA | DetailsTicket.saveX | DetailsTicket.saveY, 0); // "Please don't break these"

		divisionHeader(whitespace, sourceX, sourceY, innerTicket);
		assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, DetailsTicket ticket2) ->
		{
			if (i < sourceX.getSize() - 1 || sourceX.getSize() % 2 == 0) // We start in 16-bit mode
			{
				if (i == 0) // First iteration
					return new String[]
					{
						sourceX.getLDA(i, ticket2),		// Load X-the-variable
						"STA\t" + SNESRegisters.WRDIVL,	// Place in reg
						CompUtils.setA8,
						sourceY.getLDA(0, ticket2),		// Load Y-the-variable
						"STA\t" + SNESRegisters.WRDIVB, // Place in reg, begin 16-cycle calc
						sourceX.getLDA(i, ticket2),		// 6 cycles,- 6 Load X-the-variable for next iteration
						"TAX",							// 2 cycles - 8
						CompUtils.setA16,				// 3 cycles - 11
						"LDA\t" + RRegL,				// 6 cycles - 17, get result
						destSource.getSTA(i, ticket2),	// Store result
						"TXA",							// Swap X-the-variable back in
					};
				if (i != sourceX.getSize() - 1) // Not the last iteration
					return new String[]
					{
						"STA\t" + SNESRegisters.WRDIVL,			// Place in reg
						CompUtils.setA8,
						"CLC",									// For addition later
						sourceY.getLDA(0, ticket2),				// Load Y-the-variable
						"STA\t" + SNESRegisters.WRDIVB, 		// Place in reg, begin 16-cycle calc
						CompUtils.setA16,						// 3 cycles - 3
						"LDA\t" + RRegH,						// 6 cycles - 9, Get high byte of previous iteration
						"NOP",									// 2 cycles - 11
						"ADC\t" + RRegL,						// 6 cycles - 17, Add result
						destSource.getSTA(i, ticket2),			// Store result
						sourceX.getLDA(i, ticket2),				// 6 cycles,- 8 Load X-the-variable for next iteration
					};
				else // Last iteration
					return new String[]
					{
						"TXA",									// Recover X-the-variable from last iteration.
						"STA\t" + SNESRegisters.WRDIVL,			// Place in reg
						CompUtils.setA8,
						"CLC",									// For addition later
						sourceY.getLDA(0, ticket2),				// Load Y-the-variable
						"STA\t" + SNESRegisters.WRDIVB, 		// Place in reg, begin 16-cycle calc
						"NOP",									// 2 cycles - 2
						"LDA\t" + RRegH,						// 6 cycles - 10, get high byte of previous iteration
						CompUtils.setA16,						// 3 cycles - 13
						"ADC\t" + RRegL,						// 6 cycles - 17, add new result
						destSource.getSTA(i, ticket2),			// Store result
					};
			}
			else // We start in 8-bit mode
				return new String[]
				{
					sourceX.getLDA(i, ticket2),	// Load X-the-variable
					"STA\t" + SNESRegisters.WRDIVL,			// Place in reg
					sourceY.getLDA(0, ticket2),				// Load Y-the-variable
					"STA\t" + SNESRegisters.WRDIVB, 		// Place in reg, begin 16-cycle calc
					"NOP",									// 2 cycles - 2
					"NOP",									// 2 cycles - 4
					"NOP",									// 2 cycles - 6
					"NOP",									// 2 cycles - 8
					"NOP",									// 2 cycles - 10
					"NOP",									// 2 cycles - 11
					"NOP",									// 2 cycles - 12
					"LDA\t" + RRegL,						// 5 cycles - 17, get result
					destSource.getSTA(i, ticket2),			// Store result
				};
		}, innerTicket);
		assembly += divisionFooter(whitespace, destSource, destSource, ticket);
		assembly += ticket.restore(whitespace, DetailsTicket.saveA | DetailsTicket.saveX | DetailsTicket.saveY);
		
		return assembly;
	}

}
