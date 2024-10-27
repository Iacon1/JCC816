// Created by Iacon1 on 01/14/2024.
// Splits the code into banks
package AsmBuilder;

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
		int sizeEstimate = 0; // Estimated ROM size
		int remainingBank = 0; // How much space is left in the current bank
		
		boolean inBlock = false, leftBlock = false; // Whether we're in a block of code and whether we just left a block
		int blockStart = 0; // Which line did the block start with?
		String blockBuffer = ""; // Current block buffer
		
		int lineSize = 0; // Current line's size
		int i = 0;
		String line, prevLine;

		remainingBank = cartConfig.getType().getROMBankLength(cartConfig.isFast(), banks - 1);

		while (!lines.get(++i).equals("RESET:"));
		remainingBank -= 104; // Header and vectors and long vectors
		sizeEstimate += 104;
		
		blockStart = i;
		blockBuffer = "";
		inBlock = true; 
		leftBlock = false;
		while (i <= lines.size())
		{
			line = (i == lines.size() ? "" : lines.get(i));
			prevLine = (i == 0 ? "" : lines.get(i - 1));

			if (prevLine.contains("RTL"))
			{
				inBlock = false;
				leftBlock = true;
			}
			if (
					line.contains("; " + CompConfig.functionTag) ||
					(!inBlock && line.contains(":") && !cartConfig.getType().isContiguous(banks - 1)) // Data segment beginning and in a non-contiguous bank
				)
			{
				inBlock = true;
				leftBlock = true;
			}
			if (i == lines.size())
				leftBlock = true;
			
			if (leftBlock)
			{
				int blockSize = new ASMGraphBuilder(blockBuffer).getSize();
				if (blockSize > remainingBank)
				{
					banks += 1;
					lines.add(blockStart, ".SEGMENT\t\"" + CompConfig.codeBankName(banks - 1) + "\"");
					remainingBank = cartConfig.getType().getROMBankLength(cartConfig.isFast(), banks - 1);
					
					if (blockSize > remainingBank)
					{
						if (!cartConfig.getType().isContiguous(banks - 2))
							throw new UnsupportedFeatureException("Data segments cannot cross out of bank " + (banks - 2) + " in " + cartConfig.getType().getName() + " mapping mode", false, i, 0);
						else
							throw new UnsupportedFeatureException("Functions larger than " + remainingBank / 1024 + " KB in bank " + (banks - 2) + " in " + cartConfig.getType().getName() + " mapping mode", false, i, 0);
					}
						
					i += 1;
				}
				remainingBank -= blockSize;
				sizeEstimate += blockSize;
			}
			leftBlock = false;
			
			if (line.contains("; " + CompConfig.functionTag))
			{
				blockStart = i;
				blockBuffer = "";
			}
			
			if (!inBlock)
			{
				if (line.contains("=") || line.replace(";.*", "").trim().endsWith(":"))
					lineSize = 0;
				else
					lineSize = new ASMGraphBuilder(line + "\n").getSize();
				
				if (lineSize > remainingBank) // Need to make a new bank
				{
					banks += 1;
					lines.add(i, ".SEGMENT\t\"" + CompConfig.codeBankName(banks - 1) + "\"");
					remainingBank = cartConfig.getType().getROMBankLength(cartConfig.isFast(), banks - 1);
					i += 1;
				}
				remainingBank -= lineSize;
				sizeEstimate += lineSize;
			}
			else
				blockBuffer += line + "\n";
			
			i += 1;
		}
		
		
		return sizeEstimate;
	}
}
