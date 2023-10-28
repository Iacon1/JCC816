// Created by Iacon1 on 10/26/2023.
// Keeps track of scratch memory.
package Compiler.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.AbstractMap.SimpleEntry;

public class ScratchManager
{
	private List<SimpleEntry<Boolean, Integer>> blockList;
	
	public ScratchManager()
	{
		blockList = new ArrayList<SimpleEntry<Boolean, Integer>>();
		blockList.add(new SimpleEntry<Boolean, Integer>(false, CompConfig.scratchSize));
	}
	
	public static class ScratchSource extends OperandSource
	{
		private int offset;
		public ScratchSource(int offset, int size)
		{
			super((Integer i) ->
			{
				if (i >= size) return "#0";
				else return CompConfig.scratchBase + " + " + (offset + i);
			}, size, false);
			this.offset = offset;
		}
		
		public int getOffset() {return offset;}
		public String getAddress(int mod) {return apply(mod);}
		public String getAddress() {return apply(0);}
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
				return new ScratchSource(offset, size);
			}
			else // Found a block that's too big, must be split
			{
				blockList.set(i, new SimpleEntry<Boolean, Integer>(false, blockList.get(i).getValue() - size));
				offset += blockList.get(i).getValue();
				blockList.add(i + 1, new SimpleEntry<Boolean, Integer>(true, size));
				return new ScratchSource(offset, size);
			}
		}
		
		// Found no block
		throw new Exception(); // TODO new exception
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
	}
}
