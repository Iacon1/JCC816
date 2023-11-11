// Created by Iacon1 on 10/26/2023.
// Keeps track of scratch memory.
package Compiler.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Compiler.Utils.OperandSources.OperandSource;

import java.util.AbstractMap.SimpleEntry;

public class ScratchManager
{
	private List<SimpleEntry<Boolean, Integer>> blockList;
	private static Map<OperandSource, ScratchSource> reservedPointers = new HashMap<OperandSource, ScratchSource>();
	
	public ScratchManager()
	{
		blockList = new ArrayList<SimpleEntry<Boolean, Integer>>();
		blockList.add(new SimpleEntry<Boolean, Integer>(false, CompConfig.scratchSize));
		
		for (ScratchSource pointer : reservedPointers.values())
			try {reserveScratchBlock(pointer.getSize(), pointer.getOffset());}
			catch (Exception e) {} // Impossible
	}
	
	public static class ScratchSource extends OperandSource
	{
		private int offset;
		public ScratchSource(int offset, int size)
		{
			super(size, false);
			this.offset = offset;
		}
		
		@Override
		public String apply(Integer i, Boolean is16Bit)
		{
			if (i >= size) return (is16Bit? "#$0000" : "#$00");
			else return CompConfig.scratchBase + " + " + (offset + i);
		}
		public int getOffset() {return offset;}
		public String getAddress(int mod) {return apply(mod, true);}
		public String getAddress() {return apply(0, true);}
	}
	
	private ScratchSource reserveScratchBlock(int size, int initOffset) throws Exception
	{
		int offset = 0;
		for (int i = 0; i < blockList.size(); ++i) // Get each block
		{
			if (blockList.get(i).getKey() || offset < initOffset) {offset += blockList.get(i).getValue(); continue;} // This block's in use or it's not where we want it
			else if (blockList.get(i).getValue() < size) {offset += blockList.get(i).getValue(); continue;} // This block's too small
			else if (blockList.get(i).getValue() == size) // Found a block that's just the right size
			{
				blockList.set(i, new SimpleEntry<Boolean, Integer>(true, size));
				return new ScratchSource(offset, size);
			}
			else // Found a block that's too big, must be split
			{
				int oldSize = blockList.get(i).getValue();
				blockList.set(i, new SimpleEntry<Boolean, Integer>(true, size));
				blockList.add(i + 1, new SimpleEntry<Boolean, Integer>(false, oldSize));
				return new ScratchSource(offset, size);
			}
		}
		
		// Found no block
		throw new Exception(); // TODO new exception
	}
	public ScratchSource reserveScratchBlock(int size) throws Exception
	{
		return reserveScratchBlock(size, 0);
	}
	public void releaseScratchBlock(ScratchSource s)
	{
		int i = -1;
		// Remove from reserved pointers if it was one
		for (OperandSource key : reservedPointers.keySet())
			if (reservedPointers.get(key).equals(s)) reservedPointers.remove(key);
		// Find the block
		int offset = 0;
		for (int j = 0; j < blockList.size(); ++j)
		{
			if (s.getOffset() == offset)
			{
				i = j;
				break;
			}
			offset += blockList.get(j).getValue();
		}
		if (i == -1) return;
		
		int size = blockList.get(i).getValue();
		if (i < blockList.size() - 1 && !blockList.get(i + 1).getKey()) // Can merge with next block
		{
			size += blockList.get(i + 1).getValue();
			blockList.remove(i);
		}
		if (i > 0 && !blockList.get(i - 1).getKey()) // Can merge with prior block
		{
			size += blockList.get(i - 1).getValue();
			blockList.remove(i - 1);
			i -= 1;
		}
			
		blockList.set(i, new SimpleEntry<Boolean, Integer>(false, size));
	}
	public ScratchSource reservePointer(OperandSource sourceFrom) throws Exception
	{
		ScratchSource s = reserveScratchBlock(CompConfig.pointerSize);
		reservedPointers.put(sourceFrom, s);
		return s;
	}
	public boolean hasPointer(OperandSource sourceFrom)
	{
		return reservedPointers.containsKey(sourceFrom);
	}
	public ScratchSource getPointer(OperandSource sourceFrom) throws Exception
	{
		if (reservedPointers.containsKey(sourceFrom))
			return reservedPointers.get(sourceFrom);
		else return reservePointer(sourceFrom);
	}
	public void releasePointer(OperandSource sourceFrom)
	{
		if (reservedPointers.containsKey(sourceFrom))
			releaseScratchBlock(reservedPointers.get(sourceFrom));
	}
	public void demotePointer(OperandSource sourceFrom)
	{
		if (reservedPointers.containsKey(sourceFrom))
			reservedPointers.remove(sourceFrom);
	}
	public void releasePointers()
	{
		for (OperandSource key : reservedPointers.keySet())
			releaseScratchBlock(reservedPointers.get(key));
	}
}
