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

	private BlockList(List<SimpleEntry<Boolean, Integer>> blockList)
	{
		this.blockList = new ArrayList<SimpleEntry<Boolean, Integer>>();
		for (SimpleEntry<Boolean, Integer> i : blockList)
			this.blockList.add(new SimpleEntry<Boolean, Integer>(i));
	}
	
	public BlockList(int capacity)
	{
		this.blockList = new ArrayList<SimpleEntry<Boolean, Integer>>();
		blockList.add(new SimpleEntry<Boolean, Integer>(false, capacity));
	}
	
	public int getReservedOffset(int size, int offset) throws Exception
	{
		int currOffset = 0;
		for (int i = 0; i < blockList.size(); ++i) // Get each block
		{
			if (currOffset + blockList.get(i).getValue() <= offset) {currOffset += blockList.get(i).getValue(); continue;} // This block's not got the right location
			else if (blockList.get(i).getKey()) throw new Exception(); // This block's used! TODO new exception
			else if (currOffset == offset && blockList.get(i).getValue() == size) // Found a block that's just the right size in just the right spot
				return offset;
			else if (currOffset == offset) // Found a block that's too big but in the right spot
				return offset;
			else // Found a block that's too big
				return offset;
		}
		
		throw new Exception(); // No usable blocks
	}
	
	public int getReservedOffset(int size) throws Exception
	{
		int offset = 0;
		for (int i = 0; i < blockList.size(); ++i) // Get each block
		{
			if (blockList.get(i).getKey()) {offset += blockList.get(i).getValue(); continue;} // This block's in use
			else if (blockList.get(i).getValue() < size) {offset += blockList.get(i).getValue(); continue;} // This block's too small
			else if (blockList.get(i).getValue() == size) // Found a block that's just the right size
				return offset;
			else // Found a block that's too big, must be split
				return offset;
		}
		
		throw new Exception(); // No usable blocks
	}
	
	public BlockList reserve(int size, int offset) throws Exception
	{
		List<SimpleEntry<Boolean, Integer>> blockList = new ArrayList<SimpleEntry<Boolean, Integer>>();
		for (SimpleEntry<Boolean, Integer> i : this.blockList)
			blockList.add(new SimpleEntry<Boolean, Integer>(i));
		
		int currOffset = 0;
		for (int i = 0; i < blockList.size(); ++i) // Get each block
		{
			if (currOffset + blockList.get(i).getValue() <= offset) {currOffset += blockList.get(i).getValue(); continue;} // This block's not got the right location
			else if (blockList.get(i).getKey()) throw new Exception(); // This block's used! TODO new exception
			else if (currOffset == offset && blockList.get(i).getValue() == size) // Found a block that's just the right size in just the right spot
			{
				blockList.set(i, new SimpleEntry<Boolean, Integer>(true, size));
				
				return new BlockList(blockList);
			}
			else if (currOffset == offset) // Found a block that's too big but in the right spot
			{
				int oldSize = blockList.get(i).getValue();
				blockList.set(i, new SimpleEntry<Boolean, Integer>(true, size));
				blockList.add(i + 1, new SimpleEntry<Boolean, Integer>(false, oldSize));

				return new BlockList(blockList);
			}
			else // Found a block that's too big
			{
				int oldSize = blockList.get(i).getValue();
				int j = i;
				if (offset - currOffset > 0) blockList.set(j++, new SimpleEntry<Boolean, Integer>(false, offset - currOffset));
				blockList.add(j++, new SimpleEntry<Boolean, Integer>(true, size));
				if (currOffset + oldSize > offset + size) blockList.add(j++, new SimpleEntry<Boolean, Integer>(false, (currOffset + oldSize) - (offset + size)));
				return new BlockList(blockList);
			}
		}
		
		throw new Exception();
	}
		
	public BlockList reserve(int size) throws Exception
	{
		List<SimpleEntry<Boolean, Integer>> blockList = new ArrayList<SimpleEntry<Boolean, Integer>>();
		for (SimpleEntry<Boolean, Integer> i : this.blockList)
			blockList.add(new SimpleEntry<Boolean, Integer>(i));
		
		int offset = 0;
		for (int i = 0; i < blockList.size(); ++i) // Get each block
		{
			if (blockList.get(i).getKey()) {offset += blockList.get(i).getValue(); continue;} // This block's in use
			else if (blockList.get(i).getValue() < size) {offset += blockList.get(i).getValue(); continue;} // This block's too small
			else if (blockList.get(i).getValue() == size) // Found a block that's just the right size
			{
				blockList.set(i, new SimpleEntry<Boolean, Integer>(true, size));

				return new BlockList(blockList);
			}
			else // Found a block that's too big, must be split
			{
				int oldSize = blockList.get(i).getValue();
				blockList.set(i, new SimpleEntry<Boolean, Integer>(true, size));
				blockList.add(i + 1, new SimpleEntry<Boolean, Integer>(false, oldSize - 1));

				return new BlockList(blockList);
			}
		}

		throw new Exception(); // No usable blocks
	}
	
	public BlockList release(int offset)
	{
		List<SimpleEntry<Boolean, Integer>> blockList = new ArrayList<SimpleEntry<Boolean, Integer>>();
		for (SimpleEntry<Boolean, Integer> i : this.blockList)
			blockList.add(new SimpleEntry<Boolean, Integer>(i));
		
		int i = -1;
		// Find the block
		int currOffset = 0;
		for (int j = 0; j < blockList.size(); ++j)
		{
			if (offset == currOffset)
			{
				i = j;
				break;
			}
			currOffset += blockList.get(j).getValue();
		}
		if (i == -1) return this;
		
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
		
		return new BlockList(blockList);
	}
	
	
}
