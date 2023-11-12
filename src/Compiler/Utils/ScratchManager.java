// Created by Iacon1 on 10/26/2023.
// Keeps track of scratch memory.
package Compiler.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.OperandSources.OperandSource;
import Logging.Logging;

import java.util.AbstractMap.SimpleEntry;

public class ScratchManager
{
	private List<SimpleEntry<Boolean, Integer>> blockList;
	private static Map<OperandSource, ScratchSource> reservedPointers = new HashMap<OperandSource, ScratchSource>();
	
	private int totalSize()
	{
		int size = 0;
		for (SimpleEntry<Boolean, Integer> block : blockList)
			size += block.getValue();
		return size;
	}
	public ScratchManager() throws Exception
	{
		blockList = new ArrayList<SimpleEntry<Boolean, Integer>>();
		blockList.add(new SimpleEntry<Boolean, Integer>(false, CompConfig.scratchSize));

		for (ScratchSource pointer : reservedPointers.values())
			reserveScratchBlock(pointer.getSize(), pointer.getOffset());

		assert totalSize() == CompConfig.scratchSize;
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
		public String apply(Integer i, DetailsTicket ticket)
		{
			if (i >= size) return (ticket.is16Bit() ? "#$0000" : "#$00");
			else return CompConfig.scratchBase + " + " + (offset + i);
		}
		public int getOffset() {return offset;}
		public String getAddress(int mod) {return apply(mod, new DetailsTicket());}
		public String getAddress() {return apply(0, new DetailsTicket());}
	}
	
	public ScratchSource reserveScratchBlock(int size, int offset) throws Exception
	{
		int currOffset = 0;
		for (int i = 0; i < blockList.size(); ++i) // Get each block
		{
			if (currOffset + blockList.get(i).getValue() <= offset) {currOffset += blockList.get(i).getValue(); continue;} // This block's not got the right location
			else if (blockList.get(i).getKey()) throw new Exception(); // This block's used! TODO new exception
			else if (currOffset == offset && blockList.get(i).getValue() == size) // Found a block that's just the right size in just the right spot
			{
				blockList.set(i, new SimpleEntry<Boolean, Integer>(true, size));
				
				assert totalSize() == CompConfig.scratchSize;
				return new ScratchSource(offset, size);
			}
			else if (currOffset == offset) // Found a block that's too big but in the right spot
			{
				int oldSize = blockList.get(i).getValue();
				blockList.set(i, new SimpleEntry<Boolean, Integer>(true, size));
				blockList.add(i + 1, new SimpleEntry<Boolean, Integer>(false, oldSize));
				
				assert totalSize() == CompConfig.scratchSize;
				return new ScratchSource(offset, size);
			}
			else // Found a block that's too big
			{
				int oldSize = blockList.get(i).getValue();
				int j = i;
				if (offset - currOffset > 0) blockList.set(j++, new SimpleEntry<Boolean, Integer>(false, offset - currOffset));
				blockList.add(j++, new SimpleEntry<Boolean, Integer>(true, size));
				if (currOffset + oldSize > offset + size) blockList.add(j++, new SimpleEntry<Boolean, Integer>(false, (currOffset + oldSize) - (offset + size)));
				
				assert totalSize() == CompConfig.scratchSize;
				return new ScratchSource(offset, size);
			}
		}
		
		// Found no block
		throw new Exception(); // TODO new exception
	}
	public ScratchSource reserveScratchBlock(int size) throws Exception
	{
		int offset = 0;
		for (int i = 0; i < blockList.size(); ++i) // Get each block
		{
			if (blockList.get(i).getKey()) {offset += blockList.get(i).getValue(); continue;} // This block's in use
			else if (blockList.get(i).getValue() < size) {offset += blockList.get(i).getValue(); continue;} // This block's too small
			else if (blockList.get(i).getValue() == size) // Found a block that's just the right size
			{
				blockList.set(i, new SimpleEntry<Boolean, Integer>(true, size));
				
				assert totalSize() == CompConfig.scratchSize;
				return new ScratchSource(offset, size);
			}
			else // Found a block that's too big, must be split
			{
				int oldSize = blockList.get(i).getValue();
				blockList.set(i, new SimpleEntry<Boolean, Integer>(true, size));
				blockList.add(i + 1, new SimpleEntry<Boolean, Integer>(false, oldSize));
				
				assert totalSize() == CompConfig.scratchSize;
				return new ScratchSource(offset, size);
			}
		}
		
		// Found no block
		throw new Exception(); // TODO new exception
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
		
		assert totalSize() == CompConfig.scratchSize;
	}
	public ScratchSource reservePointer(OperandSource sourceFrom) throws Exception
	{
		ScratchSource s = reserveScratchBlock(CompConfig.pointerSize);
		reservedPointers.put(sourceFrom, s);
		return s;
	}
	public static boolean hasPointer(OperandSource sourceFrom)
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
	public static void promoteToPointer(OperandSource sourceFrom, ScratchSource source)
	{
		reservedPointers.put(sourceFrom, source);
	}
	public static void demotePointer(OperandSource sourceFrom)
	{
		if (reservedPointers.containsKey(sourceFrom))
			reservedPointers.remove(sourceFrom);
	}
	public void releasePointers()
	{
		for (OperandSource key : reservedPointers.keySet())
			releaseScratchBlock(reservedPointers.get(key));
	}
	public static void clearPointers()
	{
		reservedPointers.clear();
	}
}
