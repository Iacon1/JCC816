// Created by Iacon1 on 01/14/2024.
// Splits the code into banks
package Linker;

import java.util.ArrayList;

import C99Compiler.CartConfig;
import C99Compiler.CompConfig;
import C99Compiler.ASMGrapher.ASMGraphBuilder;
import C99Compiler.Exceptions.UnsupportedFeatureException;

public final class Banker
{
	public static final int splitBanks(CartConfig cartConfig, ArrayList<String> lines) throws Exception // Returns # of banks
	{
		int banks = 1;
		int sizeEstimate = 0;
		int lastBank = 0; // Distance in bytes to the last bank
		String blockAssembly = ""; // Assembly of current subroutine
		
		boolean inFunc = false; // Whether we're in a function
		int i = 0;
		int blockStart = 0;
		String line, prevLine;
//		do {line = lines.get(++i);}
//		while (!line.equals("RESET:"));
		
		while (i <= lines.size())
		{
			line = (i == lines.size() ? "" : lines.get(i));
			prevLine = (i == 0 ? "" : lines.get(i - 1));
			
			if (line.trim().startsWith(".") || line.contains("=") || line.replace(";.*", "").trim().endsWith(":")) // Skip preprocessor ones
			{
				i++;
				continue;
			}
				
			if (inFunc ? prevLine.contains("RTL") : line.contains("; " + CompConfig.functionTag)) // Code between functions shouldn't cross banks and code in functions shouldn't cross banks
			{
				if (!blockAssembly.isEmpty())
				{
					int bankSize = cartConfig.getType().getROMBankLength(cartConfig.isFast(), banks - 1);
					int blockSize = new ASMGraphBuilder(blockAssembly).getSize();
//					Logging.logNotice(String.valueOf(blockSize));
					if (blockSize >= bankSize)
						throw new UnsupportedFeatureException("Functions larger than " + bankSize / 1024 + " KB in bank " + (banks - 1) + " in " + cartConfig.getType().getName() + " mapping mode", false, i, 0);
					if (lastBank + blockSize >= bankSize) // Need to make new bank
					{
						banks += 1;
						lines.add(blockStart, ".SEGMENT\t\"" + CompConfig.codeBankName(banks - 1) + "\"");
						lastBank = blockSize;
						
						i += 1;
					}
					else
						lastBank += blockSize;
					blockStart = i;
					blockAssembly = "";
					sizeEstimate += blockSize;
				}
				inFunc = line.contains("; " + CompConfig.functionTag);
			}
			blockAssembly += line + "\n";
			
			++i;
		}
		
		return sizeEstimate;
	}
}
