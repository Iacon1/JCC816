// Created by Iacon1 on 01/14/2024.
// Splits the code into banks
package Compiler;

import java.util.ArrayList;

import Compiler.ASMGrapher.ASMGraphBuilder;
import Compiler.Exceptions.UnsupportedFeatureException;
import Logging.Logging;

public final class Banker
{
	private final static int bankSize = 0x8000; // Size of a bank TODO account for layout
	private static final int bankSizeKB()
	{
		return bankSize / 1024;
	}
	public static final int splitBanks(ArrayList<String> lines) throws Exception // Returns # of banks
	{
		int banks = 1;
		long lastBank = 0; // Distance in bytes to the last bank
		String blockAssembly = ""; // Assembly of current subroutine
		
		boolean inFunc = false; // Whether we're in a function
		int i = 0;
		int blockStart = 0;
		String line, prevLine;
//		do {line = lines.get(++i);}
//		while (!line.equals("RESET:"));
		
		while (i <= lines.size())
		{
			line = (i == lines.size() ? "" : lines.get(i ));
			prevLine = (i == 0 ? "" : lines.get(i - 1));
			
			if (inFunc ? prevLine.contains("RTL") : line.contains("; " + CompConfig.functionTag)) // Code between functions shouldn't cross banks and code in functions shouldn't cross banks
			{
				if (!blockAssembly.isEmpty())
				{
					long blockSize = new ASMGraphBuilder(blockAssembly).getSize();
//					Logging.logNotice(String.valueOf(blockSize));
					if (blockSize >= bankSize)
						throw new UnsupportedFeatureException("Functions larger than " + bankSizeKB() + " KB", false, i, 0);
					if (lastBank + blockSize >= bankSize) // Need to make new bank
					{
						banks += 1;
						lines.add(blockStart, ".SEGMENT\t\"" + CompConfig.bankName(banks - 1) + "\"");
						lastBank = 0;
						
						i += 1;
					}
					else
						lastBank += blockSize;
					blockStart = i;
					blockAssembly = "";
				}
				inFunc = line.contains("; " + CompConfig.functionTag);
			}
			blockAssembly += line + "\n";
			
			++i;
		}
		
		return banks;
	}
}
