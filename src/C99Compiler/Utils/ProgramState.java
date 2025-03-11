// Created by Iacon1 on 11/05/2024.
// The state of the program as it enters a node
// This object should be immutable, i. e. no function in it should modify its own state.

package C99Compiler.Utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.Exceptions.ScratchOverflowException;
import C99Compiler.Utils.OperandSources.AddressSource;
import C99Compiler.Utils.OperandSources.OperandSource;

public class ProgramState
{	
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
	
	// Whitespace
	private final int whitespaceLevel;
	public String getWhitespace() { return " ".repeat(CompConfig.indentSize * whitespaceLevel);}
	
	// Scratch memory
	private final List<SimpleEntry<Boolean, Integer>> blockList;
	private final ScratchSource lastScratchSource; // Last scratch source reserved
	private static List<SimpleEntry<Boolean, Integer>> newBlockList()
	{
		List<SimpleEntry<Boolean, Integer>> blockList = new ArrayList<SimpleEntry<Boolean, Integer>>();
		blockList.add(new SimpleEntry<Boolean, Integer>(false, CompConfig.scratchSize));
		
		return blockList;
	}
	private static List<SimpleEntry<Boolean, Integer>> cloneBlockList(List<SimpleEntry<Boolean, Integer>> other)
	{
		List<SimpleEntry<Boolean, Integer>> blockList = new ArrayList<SimpleEntry<Boolean, Integer>>();
		for (SimpleEntry<Boolean, Integer> i : other)
			blockList.add(new SimpleEntry<Boolean, Integer>(i));
		
		return blockList;
	}
 	private static ScratchSource reserveScratchBlock(List<SimpleEntry<Boolean, Integer>> blockList, int size, int offset) throws ScratchOverflowException
	{
		int currOffset = 0;
		for (int i = 0; i < blockList.size(); ++i) // Get each block
		{
			if (currOffset + blockList.get(i).getValue() <= offset) {currOffset += blockList.get(i).getValue(); continue;} // This block's not got the right location
			else if (blockList.get(i).getKey()) throw new ScratchOverflowException(); // This block's used! TODO new exception
			else if (currOffset == offset && blockList.get(i).getValue() == size) // Found a block that's just the right size in just the right spot
			{
				blockList.set(i, new SimpleEntry<Boolean, Integer>(true, size));

				return new ScratchSource(offset, size);
			}
			else if (currOffset == offset) // Found a block that's too big but in the right spot
			{
				int oldSize = blockList.get(i).getValue();
				blockList.set(i, new SimpleEntry<Boolean, Integer>(true, size));
				blockList.add(i + 1, new SimpleEntry<Boolean, Integer>(false, oldSize));

				return new ScratchSource(offset, size);
			}
			else // Found a block that's too big
			{
				int oldSize = blockList.get(i).getValue();
				int j = i;
				if (offset - currOffset > 0) blockList.set(j++, new SimpleEntry<Boolean, Integer>(false, offset - currOffset));
				blockList.add(j++, new SimpleEntry<Boolean, Integer>(true, size));
				if (currOffset + oldSize > offset + size) blockList.add(j++, new SimpleEntry<Boolean, Integer>(false, (currOffset + oldSize) - (offset + size)));
				return new ScratchSource(offset, size);
			}
		}
		
		// Found no block
		throw new ScratchOverflowException();
	}
	private static ScratchSource reserveScratchBlock(List<SimpleEntry<Boolean, Integer>> blockList, int size) throws ScratchOverflowException
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
				int oldSize = blockList.get(i).getValue();
				blockList.set(i, new SimpleEntry<Boolean, Integer>(true, size));
				blockList.add(i + 1, new SimpleEntry<Boolean, Integer>(false, oldSize - 1));

				return new ScratchSource(offset, size);
			}
		}
		
		// Found no block
		throw new ScratchOverflowException();
	}
	private static void releaseScratchBlock(List<SimpleEntry<Boolean, Integer>> blockList, LinkedHashMap<OperandSource, ScratchSource> pointerMap, ScratchSource s)
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
		List<OperandSource> toRemove = new LinkedList<OperandSource>();
		for (OperandSource o : pointerMap.keySet())
			if (pointerMap.get(o).equals(s))
				toRemove.add(o);
		for (OperandSource o : toRemove)
			pointerMap.remove(o);
		
		blockList.set(i, new SimpleEntry<Boolean, Integer>(false, size));
	}
	// Pointers
	private final LinkedHashMap<OperandSource, ScratchSource> pointerMap;
	private static LinkedHashMap<OperandSource, ScratchSource> newPointerMap()
	{
		return new LinkedHashMap<OperandSource, ScratchSource>();
	}
	private static LinkedHashMap<OperandSource, ScratchSource> clonePointerMap(LinkedHashMap<OperandSource, ScratchSource> other)
	{
		LinkedHashMap<OperandSource, ScratchSource> pointerMap = new LinkedHashMap<OperandSource, ScratchSource>();
		for (Map.Entry<OperandSource, ScratchSource> i : other.entrySet())
		{
			pointerMap.put(i.getKey(), i.getValue());
		}
		
		return pointerMap;
	}
	private static ScratchSource reservePointer(List<SimpleEntry<Boolean, Integer>> blockList, LinkedHashMap<OperandSource, ScratchSource> pointerMap, OperandSource s) throws ScratchOverflowException
	{
		if (pointerMap.containsKey(s))
			return pointerMap.get(s);
		
		ScratchSource scratchSource = reserveScratchBlock(blockList, CompConfig.pointerSize);
		pointerMap.put(s, scratchSource);
		return scratchSource;
	}
	private static ScratchSource markPointer(List<SimpleEntry<Boolean, Integer>> blockList, LinkedHashMap<OperandSource, ScratchSource> pointerMap, OperandSource s, ScratchSource scratchSource) throws ScratchOverflowException
	{
		if (pointerMap.containsKey(s))
			return pointerMap.get(s);
		
		pointerMap.put(s, scratchSource);
		return scratchSource;
	}
	private static void releasePointer(List<SimpleEntry<Boolean, Integer>> blockList, LinkedHashMap<OperandSource, ScratchSource> pointerMap, OperandSource s) throws ScratchOverflowException
	{
		if (!pointerMap.containsKey(s))
			return;
		
		releaseScratchBlock(blockList, pointerMap, pointerMap.get(s));
		pointerMap.remove(s);
	}
	public boolean hasPointer(OperandSource s)
	{
		return pointerMap.containsKey(s);
	}
	public ScratchSource getPointer(OperandSource s)
	{
		return pointerMap.get(s);
	}
	public ScratchSource lastScratchSource() {return lastScratchSource;}
	
	// Destination source
	private final OperandSource destSource;
	public OperandSource destSource() {return destSource;}
	
	// Function's exit label
	private final String exitFuncLabel;
	public String exitFuncLabel() {return exitFuncLabel;}
	
	// Processor flags
	public static class ProcessorFlag
	{
		private ProcessorFlag() {}
		public static final byte M = 0b00100000; // Is A register 16-bit?
		public static final byte I = 0b00010000; // Are XY registers 16-bit?
	}
	private final byte processorFlags;
	public boolean testProcessorFlag(byte flag)
	{
		return (processorFlags & flag) != 0;
	}
	
	// Flag / register preservation
	public static class PreserveFlag
	{
		private PreserveFlag() {}
		public static final byte M = 0b00000001; // Preserve whether A register is 16-bit
		public static final byte I = 0b00000010; // Preserve whether XY registers are 16-bit
		public static final byte A = 0b00000101; // Preserve value of A register (implies M as well)
		public static final byte X = 0b00001010; // Preserve value of X register (implies I as well)
		public static final byte Y = 0b00010010; // Preserve value of Y register (implies I as well) 
	}
	private final byte preserveFlags;
	// Flag / register confidence (whether we actually know what the flags / registers are)
	private final byte knownFlags;
	private int a, x, y; // Last known values of a, x, and y.
	
	public boolean testPreserveFlag(byte flag)
	{
		return (preserveFlags & flag) != 0;
	}
	public boolean testKnownFlag(byte flag) // Is this flag / register known?
	{
		return (knownFlags & flag) == flag;
	}
	public int getA()
	{
		return a;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	
	// Possible L-Value values
	private final Map<LValueNode<?>, List<Object>> possibleValues; // Not-set = unknown value
	private static Map<LValueNode<?>, List<Object>> newPossibleValues()
	{
		return new LinkedHashMap<LValueNode<?>, List<Object>>();
	}
	private static Map<LValueNode<?>, List<Object>> clonePossibleValues(Map<LValueNode<?>, List<Object>> other)
	{
		Map<LValueNode<?>, List<Object>> map = new LinkedHashMap<LValueNode<?>, List<Object>>();
		for (Map.Entry<LValueNode<?>, List<Object>> i : other.entrySet())
		{
			List<Object> list = new ArrayList<Object>();
			list.addAll(i.getValue());
			map.put(i.getKey(), list);
		}
		
		return map;
	}
	private void clearPossibleValues(Map<LValueNode<?>, List<Object>> map, LValueNode<?> lValue)
	{
		map.remove(lValue);
	}
	private void setPossibleValues(Map<LValueNode<?>, List<Object>> map, LValueNode<?> lValue, List<Object> values)
	{
		map.put(lValue, values);
	}
	private void setPossibleValue(Map<LValueNode<?>, List<Object>> map, LValueNode<?> lValue, Object value)
	{
		List<Object> list = new ArrayList<Object>();
		list.add(value);
		map.put(lValue, list);
	}
	public Object getOnlyValue(LValueNode<?> lValue)
	{
		if (possibleValues.containsKey(lValue) && possibleValues.get(lValue).size() == 1)
			return possibleValues.get(lValue).get(0);
		else
			return null;
	}
	public Long getSmallestValue(LValueNode<?> lValue)
	{
		if (possibleValues.containsKey(lValue))
		{
			Long l = Long.MAX_VALUE;
			for (Object i : possibleValues.get(lValue))
			{
				if (!Long.class.isAssignableFrom(i.getClass()))
					return null;
				Long il = (Long) i;
				if (l > il)
					l = il;
			}
			return l;
		}
		else
			return null;
	}
	public Long getLargestValue(LValueNode<?> lValue)
	{
		if (possibleValues.containsKey(lValue))
		{
			Long l = Long.MIN_VALUE;
			for (Object i : possibleValues.get(lValue))
			{
				if (!Long.class.isAssignableFrom(i.getClass()))
					return null;
				Long il = (Long) i;
				if (l < il)
					l = il;
			}
			return l;
		}
		else
			return null;
	}
	
	private final boolean isSA1;
	
	// Constructors
	private ProgramState(
			int whitespaceLevel,
			List<SimpleEntry<Boolean, Integer>> blockList, ScratchSource lastScratchSource,
			LinkedHashMap<OperandSource, ScratchSource> pointerMap,
			Map<LValueNode<?>, List<Object>> possibleValues,
			OperandSource destSource,
			String exitFuncLabel,
			byte processorFlags,
			byte preserveFlags,
			byte knownFlags,
			int a, int x, int y,
			boolean isSA1
			)
	{
		this.whitespaceLevel = whitespaceLevel;
		this.blockList = blockList;
		this.lastScratchSource = lastScratchSource;
		this.pointerMap = pointerMap;
		this.possibleValues = possibleValues;
		this.destSource = destSource;
		this.exitFuncLabel = exitFuncLabel;
		this.processorFlags = processorFlags;
		this.preserveFlags = preserveFlags;
		this.knownFlags = knownFlags;
		this.a = a;
		this.x = x;
		this.y = y;
		this.isSA1 = isSA1;
	}
	public ProgramState()
	{
		this.whitespaceLevel = 0;
		this.blockList = newBlockList();
		this.lastScratchSource = null;
		this.pointerMap = newPointerMap();
		this.possibleValues = newPossibleValues();
		this.destSource = null;
		this.exitFuncLabel = null;
		this.processorFlags = 0;
		this.preserveFlags = 0;
		this.knownFlags = 0;
		this.a = 0;
		this.x = 0;
		this.y = 0;
		this.isSA1 = false;
	}
	
	// Transformations
	/** Raises the indentation by 1 level.
	 * 
	 * @return A copy of the state with the indentation raised by 1 level.
	 */
	public ProgramState indent()
	{
		ProgramState s = new ProgramState(
				whitespaceLevel + 1,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	public ProgramState undent()
	{
		ProgramState s = new ProgramState(
				whitespaceLevel - 1,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	/** Reserves a block of scratch memory.
	 * 
	 * @param size The size of the block to reserve.
	 * @param offset The offset to begin looking at.
	 * @return A copy of the state with the block reserved.
	 * @throws ScratchOverflowException if the block could not be reserved.
	 */
	public ProgramState reserveScratchBlock(int size, int offset) throws ScratchOverflowException
	{
		List<SimpleEntry<Boolean, Integer>> blockList = new ArrayList<SimpleEntry<Boolean, Integer>>();
		for (SimpleEntry<Boolean, Integer> i : this.blockList)
			blockList.add(new SimpleEntry<Boolean, Integer>(i));
		ScratchSource source = reserveScratchBlock(blockList, size, offset);
		
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, source,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	/** Reserves a block of scratch memory.
	 * 
	 * @param size The size of the block to reserve.
	 * @return A copy of the state with the block reserved.
	 * @throws ScratchOverflowException if the block could not be reserved.
	 */
	public ProgramState reserveScratchBlock(int size) throws ScratchOverflowException
	{
		List<SimpleEntry<Boolean, Integer>> blockList = cloneBlockList(this.blockList);
		ScratchSource source = reserveScratchBlock(blockList, size);
		
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, source,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	/** Releases a block of scratch memory.
	 * 
	 * @param source Source to release.
	 * @return A copy of the state with the block released.
	 */
	public ProgramState releaseScratchBlock(ScratchSource source)
	{
		List<SimpleEntry<Boolean, Integer>> blockList = cloneBlockList(this.blockList);
		LinkedHashMap<OperandSource, ScratchSource> pointerMap = clonePointerMap(this.pointerMap);
		releaseScratchBlock(blockList, pointerMap, source);
		
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	/** Reserves a pointer-usable copy of a source.
	 * 
	 * @param source Source to reserve a pointer for.
	 * @return A copy of the state with the pointer reserved.
	 */
	public ProgramState reservePointer(OperandSource source) throws ScratchOverflowException
	{
		if (pointerMap.containsKey(source))
		{
			ProgramState s = new ProgramState(
					whitespaceLevel,
					blockList, getPointer(source),
					pointerMap,
					possibleValues,
					destSource,
					exitFuncLabel,
					processorFlags,
					preserveFlags,
					knownFlags,
					a, x, y,
					isSA1);
			return s;
		}
		List<SimpleEntry<Boolean, Integer>> blockList = cloneBlockList(this.blockList);
		LinkedHashMap<OperandSource, ScratchSource> pointerMap = clonePointerMap(this.pointerMap);
		ScratchSource scratchSource = reservePointer(blockList, pointerMap, source);
		
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, scratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	/** Marks a scratch source as a pointer-usable copy of a source.
	 * 
	 * @param source Source to reserve a pointer for.
	 * @return A copy of the state with the pointer reserved.
	 */
	public ProgramState markPointer(OperandSource source, ScratchSource scratchSource) throws ScratchOverflowException
	{
		if (pointerMap.containsKey(source))
		{
			ProgramState s = new ProgramState(
					whitespaceLevel,
					blockList, getPointer(source),
					pointerMap,
					possibleValues,
					destSource,
					exitFuncLabel,
					processorFlags,
					preserveFlags,
					knownFlags,
					a, x, y,
					isSA1);
			return s;
		}
		List<SimpleEntry<Boolean, Integer>> blockList = cloneBlockList(this.blockList);
		LinkedHashMap<OperandSource, ScratchSource> pointerMap = clonePointerMap(this.pointerMap);
		scratchSource = markPointer(blockList, pointerMap, source, scratchSource);
		
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, scratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	/** Releases a pointer-usable copy of a source, if it exists.
	 * 
	 * @param source Source to release any pointer to.
	 * @return A copy of the state with the pointer released.
	 */
	public ProgramState releasePointer(OperandSource source) throws ScratchOverflowException
	{
		if (!pointerMap.containsKey(source)) return this;
		
		ScratchSource pointer = getPointer(source);
 		List<SimpleEntry<Boolean, Integer>> blockList = cloneBlockList(this.blockList);
		LinkedHashMap<OperandSource, ScratchSource> pointerMap = clonePointerMap(this.pointerMap);
		releasePointer(blockList, pointerMap, source);
		
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource == pointer ? null : lastScratchSource ,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	/** Releases all pointers
	 * 
	 * @return A copy of the state with the pointer released.
	 */
	public ProgramState releasePointers() throws ScratchOverflowException
	{
		boolean wasLastPointer = pointerMap.containsValue(lastScratchSource);
 		List<SimpleEntry<Boolean, Integer>> blockList = cloneBlockList(this.blockList);
		LinkedHashMap<OperandSource, ScratchSource> pointerMap = clonePointerMap(this.pointerMap);
		List<OperandSource> toRemove = new LinkedList<OperandSource>();
		for (OperandSource p : pointerMap.keySet())
			toRemove.add(p);
		for (OperandSource p : toRemove)
			releasePointer(blockList, pointerMap, p);
		
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, wasLastPointer ? null : lastScratchSource ,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	/** Sets the destination source for subsequent writes.
	 * 
	 * @param source Source to set as the destination source.
	 * @return A copy of the state with the pointer released.
	 */
	public ProgramState setDestSource(OperandSource destSource)
	{
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	public ProgramState clearProcessorFlags(byte flags)
	{
		byte knownFlags = this.knownFlags;
		if ((flags & ProcessorFlag.M) != 0)
			knownFlags |= PreserveFlag.M;
		if ((flags & ProcessorFlag.I) != 0)
			knownFlags |= PreserveFlag.I;
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				(byte) (processorFlags & ~flags),
				preserveFlags,
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	public ProgramState setProcessorFlags(byte flags)
	{
		byte knownFlags = this.knownFlags;
		if ((flags & ProcessorFlag.M) != 0)
			knownFlags |= PreserveFlag.M;
		if ((flags & ProcessorFlag.I) != 0)
			knownFlags |= PreserveFlag.I;
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				(byte) (processorFlags | flags),
				preserveFlags,
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	public ProgramState clearPreserveFlags(byte flags)
	{
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				(byte) (preserveFlags & ~flags),
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	public ProgramState clearPreserveFlags()
	{
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				(byte) 0,
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	public byte getPreserveFlags()
	{
		return preserveFlags;
	}
	public ProgramState addPreserveFlags(byte flags)
	{
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				(byte) (preserveFlags | flags),
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	public ProgramState setPreserveFlags(byte flags)
	{
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				flags,
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	public ProgramState clearKnownFlags(byte flags)
	{
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				(byte) (knownFlags & ~flags),
				a, x, y,
				isSA1);
		return s;
	}
	public ProgramState clearKnownFlags()
	{
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				(byte) 0,
				a, x, y,
				isSA1);
		return s;
	}
	public ProgramState fixAReg(int a)
	{
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				(byte) (knownFlags | PreserveFlag.A),
				a, x, y,
				isSA1);
		return s;
	}
	public ProgramState fixXReg(int x)
	{
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				(byte) (knownFlags | PreserveFlag.X),
				a, x, y,
				isSA1);
		return s;
	}
	public ProgramState fixYReg(int y)
	{
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				(byte) (knownFlags | PreserveFlag.Y),
				a, x, y,
				isSA1);
		return s;
	}
	/** Clears the list of possible values for a LValue.
	 * 
	 * @param lValue The LValue to clear.
	 * @return A copy of the state with the LValue's list released.
	 */
	public ProgramState clearPossibleValues(LValueNode<?> lValue)
	{
		Map<LValueNode<?>, List<Object>> possibleValues = clonePossibleValues(this.possibleValues);
		clearPossibleValues(possibleValues, lValue);
		
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	/** Sets the list of possible values for a LValue.
	 * 
	 * @param lValue The LValue to set.
	 * @param values The list of possible values.
	 * @return A copy of the state with the LValue's list set.
	 */
	public ProgramState setPossibleValues(LValueNode<?> lValue, List<Object> values)
	{
		Map<LValueNode<?>, List<Object>> possibleValues = clonePossibleValues(this.possibleValues);
		setPossibleValues(possibleValues, lValue, values);
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	/** Sets one known value for a LValue.
	 * 
	 * @param lValue The LValue to set.
	 * @param values The value that LValue must have.
	 * @return A copy of the state with the LValue's value set.
	 */
	public ProgramState setPossibleValue(LValueNode<?> lValue, Object value)
	{
		Map<LValueNode<?>, List<Object>> possibleValues = clonePossibleValues(this.possibleValues);
		setPossibleValue(possibleValues, lValue, value);
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	public ProgramState setExitFuncLabel(String exitFuncLabel)
	{
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	
	/** Wipes the processor and memory states.
	 * 
	 * @return A copy of the state with the processor and memory states wiped.
	 */
	public ProgramState wipe()
	{
		ProgramState s = new ProgramState(
				whitespaceLevel,
				newBlockList(), null,
				newPointerMap(),
				newPossibleValues(),
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				(byte) 0,
				a, x, y,
				isSA1);
		return s;
	}
	public ProgramState combine(ProgramState other)
	{
		byte processorFlags = (byte) (this.processorFlags & other.processorFlags); // TODO
		byte preserveFlags = (byte) (this.preserveFlags | other.preserveFlags);
		byte knownFlags = (byte) (this.knownFlags & other.knownFlags);

		if (this.a != other.a)
			knownFlags &= ~PreserveFlag.A;
		if (this.x != other.x)
			knownFlags &= ~PreserveFlag.X;
		if (this.y != other.y)
			knownFlags &= ~PreserveFlag.Y;
		
		ProgramState s = new ProgramState(
				whitespaceLevel,
				newBlockList(), null,
				newPointerMap(),
				newPossibleValues(),
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				knownFlags,
				a, x, y,
				isSA1);
		return s;
	}
	
	public ProgramState as5a22()
	{
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				knownFlags,
				a, x, y,
				false);
		return s;
	}
	public ProgramState asSA1()
	{
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, lastScratchSource,
				pointerMap,
				possibleValues,
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				knownFlags,
				a, x, y,
				true);
		return s;
	}
}
