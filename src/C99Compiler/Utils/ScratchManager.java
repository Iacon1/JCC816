// Created by Iacon1 on 10/26/2023.
// Keeps track of scratch memory.
package C99Compiler.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.OperandSources.AddressSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import Logging.Logging;

import java.util.AbstractMap.SimpleEntry;

import C99Compiler.CompConfig;
import C99Compiler.Exceptions.ScratchOverflowException;

public class ScratchManager
{
	private List<SimpleEntry<Boolean, Integer>> blockList;
	private static List<ScratchSource> pointerList = new ArrayList<ScratchSource>(Arrays.asList(new ScratchSource[CompConfig.generalPointers]));
	private static LinkedHashMap<OperandSource, ScratchSource> pointerMap = new LinkedHashMap<OperandSource, ScratchSource>(CompConfig.generalPointers);
	
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

		assert totalSize() == CompConfig.scratchSize;
	}
	
	public static class ScratchSource extends AddressSource
	{
		public ScratchSource(int offset, int size)
		{
			super(CompConfig.scratchBase, offset, size);
		}
		public ScratchSource(int index)
		{
			super(CompConfig.pointerBase, index * CompConfig.pointerSize, CompConfig.pointerSize);
		}
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
		throw new ScratchOverflowException();
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
		throw new ScratchOverflowException();
	}
	public void releaseScratchBlock(ScratchSource s)
	{
		int i = -1;
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
	public static ScratchSource reservePointer(OperandSource sourceFrom) throws Exception
	{
		if (pointerMap.get(sourceFrom) != null)
			return pointerMap.get(sourceFrom);
		
		for (int i = 0; i < CompConfig.generalPointers; ++i)
		{
			if (pointerList.get(i) == null)
			{
				ScratchSource s = new ScratchSource(i);
				pointerMap.put(sourceFrom, s);
				pointerList.set(i, s);
				return s;
			}
		}
		throw new ScratchOverflowException();
	}
	public static boolean hasPointer(OperandSource sourceFrom)
	{
		return pointerMap.containsKey(sourceFrom);
	}
	public static ScratchSource getPointer(OperandSource sourceFrom) throws Exception
	{
		if (pointerMap.containsKey(sourceFrom))
			return pointerMap.get(sourceFrom);
		else return reservePointer(sourceFrom);
	}
	public static void releasePointer(OperandSource sourceFrom)
	{
		if (pointerMap.containsKey(sourceFrom))
		{
			ScratchSource s = pointerMap.remove(sourceFrom);
			int i = pointerList.indexOf(s);
			pointerList.set(i, null);
		}
	}
	public static void releasePointers()
	{
		for (int i = 0; i < CompConfig.generalPointers; ++i)
			pointerList.set(i, null);
		pointerMap.clear();
	}
	public static void popPointer()
	{
		pointerMap.remove(pointerList.get(0));
		pointerList.set(0,  null);
	}
}
