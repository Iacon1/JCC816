// Created by Iacon1 on 04/22/2026.
// List of blocks marked either used or unused with different sizes
// Unused blocks can be split into smaller used blocks via reserve and used blocks can be remerged into unused blocks via release

package C99Compiler.ProgramState;

import java.util.List;
import java.util.AbstractMap.SimpleEntry;

import java.util.ArrayList;

class BlockList
{
	private final List<SimpleEntry<Boolean, Integer>> blockList; // Underlying data
	private final int capacity;
	
	private BlockList(List<SimpleEntry<Boolean, Integer>> blockList, int capacity)
	{
		this.blockList = new ArrayList<SimpleEntry<Boolean, Integer>>();
		this.capacity = capacity;
		for (SimpleEntry<Boolean, Integer> i : blockList)
			this.blockList.add(new SimpleEntry<Boolean, Integer>(i));
	}
	
	public BlockList(int capacity)
	{
		this.blockList = new ArrayList<SimpleEntry<Boolean, Integer>>();
		this.capacity = capacity;
		blockList.add(new SimpleEntry<Boolean, Integer>(false, capacity));
	}
	
	private int getTargetBlock(int size, boolean reverse) throws Exception
	{
		if (!reverse)
		{
			for (int i = 0; i < blockList.size(); ++i) // Get each block
			{
				if (blockList.get(i).getKey()) // Block used
					continue;
				else if (blockList.get(i).getValue() < size) // Block too small
					continue;
				else
					return i;
			}
		}
		else
		{
			for (int i = blockList.size() - 1; i >= 0; --i) // Get each block
			{
				if (blockList.get(i).getKey()) // Block used
					continue;
				else if (blockList.get(i).getValue() < size) // Block too small
					continue;
				else
					return i;
			}
		}
		throw new Exception(); // No usable blocks
	}
	private int getTargetBlock(int offset) throws Exception
	{
		int currOffset = 0;
		for (int i = 0; i < blockList.size(); ++i)
		{
			if (currOffset == offset)
				return i;
			currOffset += blockList.get(i).getValue();
		}

		throw new Exception(); // No usable blocks
	}
	
	private int getOffsetOf(int blockID)
	{
		int currOffset = 0;
		for (int i = 0; i < blockID; ++i)
			currOffset += blockList.get(i).getValue();
		
		return currOffset;
	}
	
	public int getReservedOffset(int size, boolean reverse) throws Exception
	{
		int i = getTargetBlock(size, reverse);
		int offset = getOffsetOf(i);
		if (reverse)
			offset += (blockList.get(i).getValue() - size);
		
		return offset;
	}
	
	public BlockList reserve(int size, boolean reverse) throws Exception
	{
		List<SimpleEntry<Boolean, Integer>> blockList = new ArrayList<SimpleEntry<Boolean, Integer>>();
		for (SimpleEntry<Boolean, Integer> i : this.blockList)
			blockList.add(new SimpleEntry<Boolean, Integer>(i));

		int i = getTargetBlock(size, reverse);
		if (reverse)
		{
			blockList.set(i, new SimpleEntry<Boolean, Integer>(false, blockList.get(i).getValue() - size));
			blockList.add(i + 1, new SimpleEntry<Boolean, Integer>(true, size));
		}
		else
		{
			blockList.add(i + 1, new SimpleEntry<Boolean, Integer>(false, blockList.get(i).getValue() - size));
			blockList.set(i, new SimpleEntry<Boolean, Integer>(true, size));
		}
		return new BlockList(blockList, capacity);
	}
	
	public BlockList release(int offset)
	{
		List<SimpleEntry<Boolean, Integer>> blockList = new ArrayList<SimpleEntry<Boolean, Integer>>();
		for (SimpleEntry<Boolean, Integer> i : this.blockList)
			blockList.add(new SimpleEntry<Boolean, Integer>(i));
		
		int i;
		// Find the block
		try
		{
			i = getTargetBlock(offset);
		}
		catch (Exception e)
		{
			return this;
		}
		
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
		
		return new BlockList(blockList, capacity);
	}
	
	public int getUsedSize()
	{
		int size = 0;
		for (int i = 0; i < blockList.size(); ++i) // Get each block
		{
			if (blockList.get(i).getKey()) // Block used
				size += blockList.get(i).getValue();
		}
		
		return size;
	}
	
	
}
