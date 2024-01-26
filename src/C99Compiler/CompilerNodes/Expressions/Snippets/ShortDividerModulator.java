// Created by Iacon1 on 12/12/2023.
//
package C99Compiler.CompilerNodes.Expressions.Snippets;

import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.SNESRegisters;
import C99Compiler.Utils.OperandSources.OperandSource;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;


//Uses hardware div registers, but only for 8-bit divisor
public class ShortDividerModulator
{
	private ShortDividerModulator() {}
	public static String generate(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, boolean isModulo, DetailsTicket ticket) throws Exception
	{
		String assembly = "";
		SNESRegisters RRegL;
		SNESRegisters RRegH;
		if (isModulo)
		{
			RRegL = SNESRegisters.RDMPYL;
			RRegH = SNESRegisters.RDMPYH;
		}
		else
		{
			RRegL = SNESRegisters.RDDIVL;
			RRegH = SNESRegisters.RDDIVH;
		}
		
		assembly += ticket.save(whitespace, DetailsTicket.saveA | DetailsTicket.saveX); // Both modified hereafter
		DetailsTicket innerTicket = new DetailsTicket(ticket, DetailsTicket.saveA | DetailsTicket.saveX | DetailsTicket.saveY, 0); // "Please don't break these"

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
						CompUtils.setA16,				// 3 cycles - 3
						sourceX.getLDA(i, ticket2),		// 4-6 cycles - 7-9 Load X-the-variable for next iteration
						"TAX",							// 2 cycles - 9-11
						"NOP",							// 2 cycles - 11-13
						"NOP",							// 2 cycles - 13-15
						"LDA\t" + RRegL,				// 4-6 cycles - 17-21, get result
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
						"LDA\t" + RRegH,						// 4-6 cycles - 7-9, Get high byte of previous iteration
						"NOP",									// 2 cycles - 9-11
						"NOP",									// 2 cycles - 11-13
						"NOP",									// 2 cycles - 13-15
						"ADC\t" + RRegL,						// 4-6 cycles - 17-21, Add result
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
						"LDA\t" + RRegH,						// 4-6 cycles - 6-8, get high byte of previous iteration
						CompUtils.setA16,						// 3 cycles - 9-11
						"NOP",									// 2 cycles - 11-13
						"NOP",									// 2 cycles - 13-15
						"ADC\t" + RRegL,						// 4-6 cycles - 17-21, add new result
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
		assembly += ticket.restore(whitespace, DetailsTicket.saveA | DetailsTicket.saveX);
		
		return assembly;
	}

}
