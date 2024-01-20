// Created by Iacon1 on 12/12/2023.
//
package C99Compiler.CompilerNodes.Expressions.Snippets;

import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.SNESRegisters;
import C99Compiler.Utils.OperandSources.OperandSource;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;


//Uses hardware div registers, but only for 8-bit divisor
public class Multiplier
{
	protected Multiplier() {}
	
	public static String generate(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, DetailsTicket ticket) throws Exception
	{
		String assembly = "";
		
		assembly += ticket.save(whitespace, DetailsTicket.saveA | DetailsTicket.saveX);
		DetailsTicket innerTicket = new DetailsTicket(ticket, DetailsTicket.saveX, DetailsTicket.saveA); // "Please don't break these"
		
		for (int i = 0; i < sourceX.getSize(); ++i)
		{
			final int ii = i;
			assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize() - i, (Integer j, DetailsTicket ticket2) ->
			{
				if (j != 0)
					if (ii != 0)
						return new String[]
						{
							"LDA\t" + SNESRegisters.RDMPYH, 			// Load previous high byte as carryover
							"TAX",										// Store in X
							sourceX.getLDA(ii, ticket2),				// Load X-the-variable
							"STA\t" + SNESRegisters.WRMPYA,				// Place in reg
							sourceY.getLDA(ii + j, ticket2),			// Load Y-the-variable
							"STA\t" + SNESRegisters.WRMPYB, 			// Place in reg, begin 8-cycle calc
							"TXA",										// 2 cycles - 2
							destSource.getLDA(ii + j, ticket2),			// >=5 cycles - 7, add previous value of result
							"ADC\t" + SNESRegisters.RDMPYL,				// 5 cycles - 12, get result and add carryover
							destSource.getSTA(ii + j, ticket2), 		// Store result
						};
					else
						return new String[]
						{
							"LDA\t" + SNESRegisters.RDMPYH, 			// Load previous high byte as carryover
							"TAX",										// Store in X
							sourceX.getLDA(ii, ticket2),				// Load X-the-variable
							"STA\t" + SNESRegisters.WRMPYA,				// Place in reg
							sourceY.getLDA(ii + j, ticket2),			// Load Y-the-variable
							"STA\t" + SNESRegisters.WRMPYB, 			// Place in reg, begin 8-cycle calc
							"TXA",										// 2 cycles - 2
							"NOP",										// 2 cycles - 4
							"LDA\t" + SNESRegisters.RDMPYL,				// 5 cycles - 9, get result and add carryover
							destSource.getSTA(ii + j, ticket2),			// Store result
						};
				else
					if (ii != 0)
						return new String[]
						{
							sourceX.getLDA(ii, ticket2),				// Load X-the-variable
							"STA\t" + SNESRegisters.WRMPYA,				// Place in reg
							sourceY.getLDA(ii + j, ticket2),	// Load Y-the-variable
							"STA\t" + SNESRegisters.WRMPYB, 			// Place in reg, begin 8-cycle calc
							"CLC",										// 2 cycles - 2
							destSource.getLDA(ii + j, ticket2),			// >=5 cycles - 7, add previous value of result
							"ADC\t" + SNESRegisters.RDMPYL,				// 5 cycles - 12, get result
							destSource.getSTA(ii + j, ticket2),// Store result
						};
					else
						return new String[]
						{
							sourceX.getLDA(ii, ticket2),		// Load X-the-variable
							"STA\t" + SNESRegisters.WRMPYA,		// Place in reg
							sourceY.getLDA(ii + j, ticket2),	// Load Y-the-variable
							"STA\t" + SNESRegisters.WRMPYB, 	// Place in reg, begin 8-cycle calc
							"NOP",								// 2 cycles - 2
							"NOP",								// 2 cycles - 4
							"LDA\t" + SNESRegisters.RDMPYL,		// 5 cycles - 9, get result
							destSource.getSTA(ii + j, ticket2),	// Store result
						};
			}, false, false, innerTicket);
		}
		return assembly;
	}

}
