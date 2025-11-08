// Created by Iacon1 on 01/14/2024.
// Splits the code into banks
package AsmBuilder;

import java.util.ArrayList;
import java.util.List;

import C99Compiler.CompConfig;
import C99Compiler.ASMGrapher.ASMGraphBuilder;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.Exceptions.CompilerException;
import C99Compiler.Exceptions.UnsupportedFeatureException;
import C99Compiler.Utils.FileIO;
import Logging.Logging;
import Shared.CartConfig;

public final class Banker
{
	// Revise size estimate to be at least within one bank of accuracy
	// Specifically, if any bank is used that the estimate wouldn't reach then return the sum of banks up to that one. Otherwise return original estimate
	private static final int reviseEstimate(CartConfig cartConfig, List<Boolean> bankUsed, int sizeEstimate)
	{
		int maxSize = 0;
		for (int i = 0; i < bankUsed.size(); ++i)
			maxSize += cartConfig.getType().getROMBankLength(cartConfig.isFast(), i);
		
		for (int i = bankUsed.size() - 1; i >= 0; --i)
		{
			int bankSize = cartConfig.getType().getROMBankLength(cartConfig.isFast(), i);
			if (bankUsed.get(i))
			{
				if (maxSize - bankSize < sizeEstimate) // This estimate is good enough for the config generator already
					return sizeEstimate;
				else return maxSize; // This estimate needs to be replaced
			}
			maxSize -= bankSize; // This bank wasn't important
		}
		
		return sizeEstimate;
	}
	public static final int splitBanks(CartConfig cartConfig, ArrayList<String> lines) throws Exception // Returns ROM size estimate
	{
		int sizeEstimate = 0; // Estimated ROM size

		boolean inBlock = false; // Whether we're in a block of code
		boolean leftBlock = false; // whether we just left a block and
		boolean startedBlock = false;  // whether we just entered a block
		boolean inData = false; // Whether the block we're in is data
		boolean inAsm = false; // In embedded ASM file, make no assumptions about freedom of organization
		int blockStart = 0; // Which line did the block start with?
		String blockBuffer = ""; // Current block buffer
		
		int lineSize = 0; // Current line's size
		int lineNo = 0;
		String line, prevLine;

		// Empty space left in each bank
		List<Integer> emptySpace = new ArrayList<Integer>();
		List<Boolean> bankUsed = new ArrayList<Boolean>(emptySpace.size());
		for (int i = 0; i < cartConfig.getType().getMaxROMBanks(cartConfig.isFast()); ++i)
		{
			emptySpace.add(cartConfig.getType().getROMBankLength(cartConfig.isFast(), i));
			bankUsed.add(false);
		}
		int currBank = 0;
		
		while (!lines.get(++lineNo).equals("RESET:"));
		emptySpace.set(currBank, emptySpace.get(currBank) - 104); // Header and vectors and long vectors
		bankUsed.set(currBank, true);
		sizeEstimate += 104;
		
		blockStart = lineNo;
		blockBuffer = "";
		inBlock = false;
		startedBlock = true;
		inData = true; // In data specifically
		leftBlock = false;
		while (lineNo <= lines.size())
		{
			line = (lineNo == lines.size() ? "" : lines.get(lineNo));
			prevLine = (lineNo == 0 ? "" : lines.get(lineNo - 1));

			if (inAsm && line.contains("; " + CompConfig.eAsmTag))
			{
				inBlock = false;
				leftBlock = true;
				inAsm = false;
			}
			else if (line.contains("; " + CompConfig.asmTag))
			{
				inBlock = true;
				startedBlock = true;
				leftBlock = true;
				inAsm = true;
			}
			else if (line.trim().startsWith(";")) // Comment
			{
				lineNo += 1;
				continue;
			}
			
			
			if (!inAsm)
			{
				if (prevLine.contains("; " + CompConfig.eFunctionTag) || line.contains("; " + CompConfig.functionTag))
				{
					if (prevLine.contains("; " + CompConfig.eFunctionTag))
					{
						inBlock = false;
						leftBlock = true;
					}
					if (line.contains("; " + CompConfig.functionTag))
					{
						inBlock = true;
						startedBlock = true;
						inData = false;
						leftBlock = true;
					}
				}
				else if (isLabel(line))
				{
					if ((!inBlock || inData))
					{
						if (inBlock)
							leftBlock = true;
						startedBlock = true;
						inData = true;
						inBlock = true;
					}
				}
				else if (!line.toLowerCase().contains(".byte"))
					inData = false;
				
				if (lineNo == lines.size())
					leftBlock = true;
			}
			
			if (leftBlock) // A block has ended
			{
				int blockSize = 0;
				if (blockBuffer.length() != 0)
					blockSize = new ASMGraphBuilder(blockBuffer).getSize();
				
				if (blockSize > emptySpace.get(currBank)) // We don't have this much space in the bank
				{
					boolean foundSpace = false;
					for (int i = 0; i < emptySpace.size(); ++i)
						if (blockSize <= emptySpace.get(i))
						{
							lines.add(blockStart, ".SEGMENT\t\"" + CompConfig.codeBankName(i) + "\"");
							lineNo += 1;
							emptySpace.set(i, emptySpace.get(i) - blockSize);
							bankUsed.set(i, true);
							sizeEstimate += blockSize;
							foundSpace = true;
			
							if (emptySpace.get(currBank) > 0) // Empty space remains here
							{
								lines.add(lineNo, ".SEGMENT\t\"" + CompConfig.codeBankName(currBank) + "\"");
								lineNo += 1;
							}
							else
								currBank = i;
							break;
						}
					if (!foundSpace)
					{
						FileIO.writeFile("badBlock.txt", blockBuffer.getBytes());
						throw new CompilerException("Couldn't find anywhere to put segment of size " + blockSize + "B in " + cartConfig.getType().getName() + " mapping mode");
					}
				}
				else
				{
					emptySpace.set(currBank, emptySpace.get(currBank) - blockSize);
					sizeEstimate += blockSize;
				}
				blockBuffer = "";
			}

			if (startedBlock)
			{
				blockStart = lineNo;
				blockBuffer = "";
				startedBlock = false;
			}
			leftBlock = false;
			
			if (!inBlock)
			{
				if (line.contains("=") || line.replace(";.*", "").trim().endsWith(":"))
					lineSize = 0;
				else
					lineSize = new ASMGraphBuilder(line + "\n").getSize();

				if (lineSize > emptySpace.get(currBank)) // We don't have this much space in the bank
				{
					boolean foundSpace = false;
					for (int i = 0; i < emptySpace.size(); ++i)
						if (lineSize <= emptySpace.get(i))
						{
							lines.add(blockStart, ".SEGMENT\t\"" + CompConfig.codeBankName(i) + "\"");
							lineNo += 1;
							emptySpace.set(i, emptySpace.get(i) - lineSize);
							bankUsed.set(i, true);
							sizeEstimate += lineSize;
							foundSpace = true;
			
							if (emptySpace.get(currBank) > 0) // Empty space remains here
							{
								lines.add(blockStart, ".SEGMENT\t\"" + CompConfig.codeBankName(currBank) + "\"");
								lineNo += 1;
							}
							else
								currBank = i;
							break;
						}
					if (!foundSpace)
					{
						FileIO.writeFile("badBlock.txt", blockBuffer.getBytes());
						throw new UnsupportedFeatureException("Couldn't find anywhere to put segment of size " + lineSize + "B in " + cartConfig.getType().getName() + " mapping mode", false, lineNo, 0);
					}
				}
				else
				{
					emptySpace.set(currBank, emptySpace.get(currBank) - lineSize);
					sizeEstimate += lineSize;
				}
			}
			else
				blockBuffer += line + "\n";
			
			lineNo += 1;
		}

		return reviseEstimate(cartConfig, bankUsed, sizeEstimate);
	}
	
	private static boolean isLabel(String line)
	{
		line = line.replaceAll("::", "").trim();
		return line.startsWith(".proc") || line.replaceFirst("[^\s:]*", "").startsWith(":");
	}
}
