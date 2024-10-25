// Created by Iacon1 on 01/23/2024.
//
package C99Compiler.MapModes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;

import Assembler.MemorySize;
import Assembler.Configurer;
import C99Compiler.CompConfig;
import C99Compiler.CompConfig.VerbosityLevel;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.Utils.OverlaySolver;
import Logging.Logging;

public interface MapModeInterface extends Configurer
{
	public static class VariableOverlayable implements OverlaySolver.Overlayable<VariableOverlayable>
	{
		private VariableNode variable;
		// Dynamic programming
		private static Map<SimpleEntry<FunctionDefinitionNode, FunctionDefinitionNode>, Boolean> dynamicMap = new HashMap<SimpleEntry<FunctionDefinitionNode, FunctionDefinitionNode>, Boolean>();
		public VariableOverlayable(VariableNode variable)
		{
			this.variable = variable;
		}

		@Override
		public boolean isOverlayableWith(VariableOverlayable b)
		{
			FunctionDefinitionNode aFunc = variable.getEnclosingFunction();
			FunctionDefinitionNode bFunc = b.variable.getEnclosingFunction();
			if (aFunc == null || bFunc == null) return false; // If either are root-level then no overlaying
			if (variable.getType().isStatic() || b.variable.getType().isStatic()) return false; // If either are static then no overlaying
			
			SimpleEntry<FunctionDefinitionNode, FunctionDefinitionNode> entry =
					new SimpleEntry<FunctionDefinitionNode, FunctionDefinitionNode>(aFunc, bFunc);

			if (dynamicMap.get(entry) != null)
			{
				// Found value in map, no need to recalculate
				return dynamicMap.get(entry);
			}
			else
			{
				// If either func can call the other then no overlaying
				boolean value = aFunc.canCall(bFunc) || bFunc.canCall(aFunc);
				dynamicMap.put(entry, !value);
				return !value;
			}
		}

		@Override
		public int getLength() {return variable.getSize();}
	}
	public byte getCode();
	public int getHeaderPosition(boolean longHeader);
	
	public int getWRAMBankLength();
	public int getSRAMBankLength();
	public int getROMBankLength(boolean isFast, int i); // ExHiROM has two banks with different sizes
	
	public int getMaxWRAMBanks();
	public int getMaxSRAMBanks();
	public int getMinROMBanks(); // Because HiROM and ExHiROM have to have enough memory to fill the first half of bank 40 / C0.
	public int getMaxROMBanks(boolean isFast);
	
	public int getWRAMBankStart(int i);
	public int getSRAMBankStart(int i);
	public int getROMBankStart(boolean isFast, int i);
	public int getROMBankAlign(int i);
	public int getHeaderAddress(boolean isFast);
	public int getVectorAddress(boolean isFast);
	
	/**
	 * @param i The current bank
	 * @return Whether the next bank is contiguous.
	 */
	public boolean isContiguous(int i);
	
	public default List<Integer> mapWRAM(List<VariableNode> variables, int offset, MemorySize memorySize)
	{
		List<VariableOverlayable> variableOverlayables = new ArrayList<VariableOverlayable>();
		for (VariableNode variable : variables)
			variableOverlayables.add(new VariableOverlayable(variable));
		SimpleEntry<List<Integer>, Integer> solution = OverlaySolver.solveOverlay(variableOverlayables, getWRAMBankLength(), getMaxWRAMBanks(), (Integer i) ->
		{
			if (i == 0) return getWRAMBankStart(i) + offset;
			else return getWRAMBankStart(i);
		});
		memorySize.WRAMSize = solution.getValue();
		return solution.getKey();
	}
	public default List<Integer> mapSRAM(List<VariableNode> variables, int offset, MemorySize memorySize)
	{
		List<VariableOverlayable> variableOverlayables = new ArrayList<VariableOverlayable>();
		for (VariableNode variable : variables)
			variableOverlayables.add(new VariableOverlayable(variable));
		SimpleEntry<List<Integer>, Integer> solution = OverlaySolver.solveOverlay(variableOverlayables, getSRAMBankLength(), getMaxSRAMBanks(), (Integer i) ->
		{
			if (i == 0) return getSRAMBankStart(i) + offset;
			else return getSRAMBankStart(i);
		});
		memorySize.SRAMSize = solution.getValue();
		return solution.getKey();
	}
	
	@Override
	public default String getRegions(MemorySize memorySize) // init size in bytes
	{
		int WRAMBanks, SRAMBanks, ROMBanks = 0;
		WRAMBanks = (int) Math.ceil((double) memorySize.WRAMSize / (double) getWRAMBankLength());
		SRAMBanks = (int) Math.ceil((double) memorySize.SRAMSize / (double) getSRAMBankLength());
		int ROMSize = memorySize.ROMSize;
		while (ROMSize > 0)
			ROMSize -= getROMBankLength(memorySize.isFast, ROMBanks++); // For ExHIROM
		ROMBanks = Math.max(ROMBanks, getMinROMBanks()); // Minimum 32 KB (LoROM), 64 KB (HiROM, ExHiROM)
		
		String regions = "";
		regions += (whitespace + "ZEROPAGE: start = $000000, size = $000100 ;\n").replace(" ", "\t");
		regions += (whitespace + "STACK: start = $000000, size = $" + String.format("%06x", CompConfig.stackSize) + ";\n").replace(" ", "\t");
		
		String regionLength = String.format("%06x", getWRAMBankLength() - CompConfig.stackSize);
		for (int i = 0; i < WRAMBanks; ++i)
		{
			String regionStart = String.format("%06x",  (i == 0 ? CompConfig.stackSize : 0) + getWRAMBankStart(i));
			regions += (whitespace + "WRAM" + String.format("%03d",i) + ": start = $" + regionStart + ", size = $" + regionLength + ";\n").replace(" ", "\t");
			if (i == 0) regionLength = String.format("%06x",  getWRAMBankLength());
		}
		regionLength = String.format("%06x",  getSRAMBankLength());
		for (int i = 0; i < SRAMBanks; ++i)
		{
			String regionStart = String.format("%06x",  getSRAMBankStart(i));
			regions += (whitespace + "SRAM" + String.format("%03d",i) + ": start = $" + regionStart + ", size = $" + regionLength + ";\n").replace(" ", "\t");
		}

		for (int i = 0; i < ROMBanks; ++i)
		{
			String regionStart = String.format("%06x",  getROMBankStart(memorySize.isFast, i));
			regionLength = String.format("%06x",  getROMBankLength(memorySize.isFast, i));
			regions += (whitespace + "ROM" + String.format("%03d",i) + ": start = $" + regionStart + ", size = $" + regionLength + ", type = ro, fill = yes;\n").replace(" ", "\t");
		}
		
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
		{
			float ROMSizeKB = (float) memorySize.ROMSize / 1024f;
			float WRAMSizeKB = (float) memorySize.WRAMSize / 1024f;
			float SRAMSizeKB = (float) memorySize.WRAMSize / 1024f;
			Logging.logNotice("\n" +
					"ROM size:  " + memorySize.ROMSize + " B (" + String.format("%.02f", ROMSizeKB) + " KB)\n" +
					"WRAM size: " + memorySize.WRAMSize + " B (" + String.format("%.02f", WRAMSizeKB) + " KB)\n" +
					"SRAM size: " + memorySize.SRAMSize + " B (" + String.format("%.02f", SRAMSizeKB) + " KB)\n");
		}
			
		return regions;
	}

	@Override
	public default String getSegments(MemorySize memorySize)
	{
		int ROMBanks = 0;
		int ROMSize = memorySize.ROMSize;
		while (ROMSize > 0) ROMSize -= getROMBankLength(memorySize.isFast, ROMBanks++); // For ExHIROM
		
		String segments = "";
		segments += (whitespace + "ZEROPAGE: load = ZEROPAGE, type=zp;\n").replace(" ", "\t");
		
		
		for (int i = 0; i < ROMBanks; ++i)
		{
			String align = String.format("%06x", getROMBankAlign(i));
			segments += (whitespace + CompConfig.codeBankName(i) + ":  load = ROM" + String.format("%03d",i) + ", type = ro, align = $" + align + ";\n").replace(" ", "\t");
		}
		segments += (whitespace + "HEADER:  load = ROM000, type = ro, start = $" + String.format("%06x", getHeaderAddress(memorySize.isFast)) + ";\n").replace(" ", "\t");
		segments += (whitespace + "VECTORS: load = ROM000, type = ro, start = $" + String.format("%06x", getVectorAddress(memorySize.isFast)) + ";\n").replace(" ", "\t");
		
		return segments;
	}
}
