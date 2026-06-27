// Created by Iacon1 on 11/05/2024.
// The state of the program as it enters a node
// This object should be immutable, i. e. no function in it should modify its own state.

package C99Compiler.ProgramState;

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
	}
	
	// Whitespace
	private final int whitespaceLevel;
	public String getWhitespace() { return " ".repeat(CompConfig.indentSize * whitespaceLevel);}
	
	// Scratch memory
	private final BlockList blockList;
	private final ScratchSource lastScratchSource; // Last scratch source reserved

	// Pointers
	private final DisqualifyingMap<ScratchSource> pointerMap;
	
	public ScratchSource lastScratchSource() {return lastScratchSource;}
	
	public boolean hasPointer(String name)
	{
		return pointerMap.get(name) != null;
	}
	public ScratchSource getPointer(String name)
	{
		return pointerMap.get(name);
	}
	
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
			BlockList blockList, ScratchSource lastScratchSource,
			DisqualifyingMap<ScratchSource> pointerMap,
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
		this.blockList = new BlockList(CompConfig.scratchSize);
		this.lastScratchSource = null;
		this.pointerMap = new DisqualifyingMap<ScratchSource>();
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
	 * @return A copy of the state with the block reserved.
	 * @throws ScratchOverflowException if the block could not be reserved.
	 */
	public ProgramState reserveScratchBlock(int size) throws ScratchOverflowException
	{
		BlockList blockList;
		int effOffset;
		try
		{
			effOffset = this.blockList.getReservedOffset(size, false);
			blockList = this.blockList.reserve(size, false);
		}
		catch (Exception e)
		{
			throw new ScratchOverflowException();
		}
		ScratchSource source = new ScratchSource(effOffset, size);
		
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
	/** Reserves a block of scratch memory, starting at the end of scratch and looking backwards.
	 * 
	 * @param size The size of the block to reserve.
	 * @return A copy of the state with the block reserved.
	 * @throws ScratchOverflowException if the block could not be reserved.
	 */
	public ProgramState reverseReserveScratchBlock(int size) throws ScratchOverflowException
	{
		BlockList blockList;
		int effOffset;
		try
		{
			effOffset = this.blockList.getReservedOffset(size, true);
			blockList = this.blockList.reserve(size, true);
		}
		catch (Exception e)
		{
			throw new ScratchOverflowException();
		}
		ScratchSource source = new ScratchSource(effOffset, size);
		
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
		BlockList blockList;
		DisqualifyingMap<ScratchSource> pointerMap;
		blockList = this.blockList.release(source.getOffset());
		pointerMap = this.pointerMap.remove(source);

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
	/** Reserves a section of scratch memory as a pointer.
	 * 
	 * @param name The name to reserve the pointer under.
	 * @param disqualifiers The disqualifers that can disqualify the pointer if invoked.
	 * @return A copy of the state with the pointer reserved.
	 */
	public ProgramState reservePointer(String name, String... disqualifiers) throws ScratchOverflowException
	{
		BlockList blockList = this.blockList;
		ScratchSource lastScratchSource = this.lastScratchSource;
		DisqualifyingMap<ScratchSource> pointerMap = this.pointerMap;
		
		if (this.pointerMap.get(name) != null) // Already reserved
			pointerMap = pointerMap.register(pointerMap.get(name), name, disqualifiers); // Refresh disqualifiers
		else // Not yet reserved, reserve
		{
			try
			{
				lastScratchSource = new ScratchSource(blockList.getReservedOffset(CompConfig.pointerSize, false), CompConfig.pointerSize);
				blockList = blockList.reserve(CompConfig.pointerSize, false);
			}
			catch (Exception e)
			{
				throw new ScratchOverflowException();
			}
			pointerMap = pointerMap.register(lastScratchSource, name, disqualifiers);
		}
		
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
	/** Marks a scratch source as a pointer-usable copy of a source.
	 * 
	 * @param source Source to reserve a pointer for.
	 * @return A copy of the state with the pointer reserved.
	 */
	public ProgramState markPointer(ScratchSource scratchSource, String name, String... disqualifiers) throws ScratchOverflowException
	{
		DisqualifyingMap<ScratchSource> pointerMap = this.pointerMap;

		pointerMap = this.pointerMap.register(scratchSource, name, disqualifiers); // Refresh disqualifiers
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, pointerMap.get(name),
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
	public ProgramState disqualifyPointers(String... disqualifiers) throws ScratchOverflowException
	{
		boolean foundLSS = false;
		List<String> disqualifiedNames = this.pointerMap.getDisqualifiedItemNames(disqualifiers);
		BlockList blockList = this.blockList;
		DisqualifyingMap<ScratchSource> pointerMap = this.pointerMap;
		for (String name : disqualifiedNames)
		{
			if (pointerMap.get(name).equals(lastScratchSource))
				foundLSS = true;
			
			blockList = blockList.release(pointerMap.get(name).getOffset());
		}
		pointerMap = this.pointerMap.disqualify(disqualifiers);

		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, foundLSS ? null : lastScratchSource ,
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
		boolean foundLSS = false;
		BlockList blockList = this.blockList;
		DisqualifyingMap<ScratchSource> pointerMap = this.pointerMap;
		for (ScratchSource source : pointerMap.getAll())
		{
			if (source.equals(lastScratchSource))
				foundLSS = true;
			
			blockList = blockList.release(source.getOffset());
		}
		
		ProgramState s = new ProgramState(
				whitespaceLevel,
				blockList, foundLSS ? null : lastScratchSource ,
				new DisqualifyingMap<ScratchSource>(),
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
		int a = this.a, x = this.x, y = this.y;
		if ((flags & ProcessorFlag.M) != 0)
		{
			knownFlags |= PreserveFlag.M;
			a &= 0xFF; // A's gotten smaller
		}
		if ((flags & ProcessorFlag.I) != 0)
		{
			knownFlags |= PreserveFlag.I;
			x &= 0xFF; // X's gotten smaller
			y &= 0xFF; // Y's gotten smaller
		}
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
		{
			knownFlags |= PreserveFlag.M;
			knownFlags &= ~PreserveFlag.A; // A's gotten bigger
		}
		if ((flags & ProcessorFlag.I) != 0)
		{
			knownFlags |= PreserveFlag.I;
			knownFlags &= ~PreserveFlag.X; // X's gotten bigger
			knownFlags &= ~PreserveFlag.Y; // Y's gotten bigger
		}
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
				blockList, lastScratchSource,
				pointerMap,
				newPossibleValues(),
				destSource,
				exitFuncLabel,
				processorFlags,
				preserveFlags,
				(byte) 0,
				a, x, y,
				isSA1);
		try {s = s.releasePointers();}
		catch (ScratchOverflowException e) {}
		return s;
	}
	/** Wipes the scratch state if too much memory (per CompConfig.healthyScratchSize) is used.
	 * 
	 * @return A copy of the state with the processor and memory states wiped.
	 */
	public ProgramState checkScratch()
	{
		BlockList blockList = this.blockList;
		ScratchSource lastScratchSource = this.lastScratchSource;
		DisqualifyingMap<ScratchSource> pointerMap = this.pointerMap;
		if (blockList.getUsedSize() >= CompConfig.healthyScratchSize)
		{
			blockList = new BlockList(CompConfig.scratchSize);
			lastScratchSource = null;
			pointerMap = new DisqualifyingMap<ScratchSource>();
			
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
		else
			return this;
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
				new BlockList(CompConfig.scratchSize), null,
				new DisqualifyingMap<ScratchSource>(),
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
