// Created by Iacon1 on 10/22/2023.
// A way of accessing and operating on a value or region of memory.
package C99Compiler.Utils.OperandSources;

import java.io.Serializable;

import C99Compiler.Utils.ProgramState;
import Shared.Assemblable.AssemblyStatePair;
import Shared.Assemblable.MutableAssemblyStatePair;

public abstract class OperandSource implements Serializable
{
	private boolean isLiteral;
	protected int size, offset;
	
	public OperandSource(int size, int offset, boolean isLiteral)
	{
		this.size = size;
		this.offset = offset;
		this.isLiteral = isLiteral;
	}
	public OperandSource(int size, boolean isLiteral)
	{
		this.size = size;
		this.offset = 0;
		this.isLiteral = isLiteral;
	}
	public OperandSource()
	{
		this.size = 0;
		this.offset = 0;
		this.isLiteral = false;
	}
	public boolean isLiteral() {return isLiteral;}
	public int getSize() {return size;}
	public int getOffset() {return offset;}
	public abstract OperandSource getShifted(int offset, int size);
	public OperandSource getShifted(int offset) {return getShifted(offset, 0);}
	public abstract OperandSource getRespecified(int offset, int size);
	public OperandSource respec(int size) {return getRespecified(offset, size);}
	/** Returns the "base" value of the source, i. e. what would come after the operation if the byte offset is 0.
	 * 
	 * @return The "base" value of the source, e. g. a variable's address
	 */
	public abstract String getBase();
	
	public abstract AssemblyStatePair getInstruction(ProgramState state, String operation, Integer i);
	public AssemblyStatePair applyInstruction(AssemblyStatePair pair, String operation, Integer i)
	{
		AssemblyStatePair myPair = getInstruction(pair.state, operation, i);
		return new AssemblyStatePair(pair.assembly + myPair.assembly, myPair.state);
	}
	public MutableAssemblyStatePair applyInstruction(MutableAssemblyStatePair pair, String operation, Integer i)
	{
		AssemblyStatePair myPair = getInstruction(pair.state, operation, i);
		pair.assembly += myPair.assembly;
		pair.state = myPair.state;
		return pair;
	}
	/** Returns assembly to load the the value or region represented by the source into the A register.
	 * 
	 * @param state The program state to start at
	 * @param i	The byte offset from the first byte of the source
	 * @return The assembly to perform the specified operation on the value or region represented by the source and the state of the program afterwards
	 */
	public AssemblyStatePair getLDA(ProgramState state, Integer i)
	{
		assert !state.testPreserveFlag(ProgramState.PreserveFlag.A); // We can't do this if we need to save A
		return getInstruction(state, "LDA", i);
	}
	public AssemblyStatePair applyLDA(AssemblyStatePair pair, Integer i)
	{
		assert !pair.state.testPreserveFlag(ProgramState.PreserveFlag.A); // We can't do this if we need to save A
		return applyInstruction(pair, "LDA", i);
	}
	public MutableAssemblyStatePair applyLDA(MutableAssemblyStatePair pair, Integer i)
	{
		assert !isLiteral; // Can't store into numbers
		return applyInstruction(pair, "LDA", i);
	}
	/** Returns assembly to store the value of the A register into the region represented by the source and the state of the program afterwards
	 * 
	 * @param state The program state to start at
	 * @param i	The byte offset from the first byte of the source
	 * @param ticket The details on what registers must be preserved by the access
	 * @return The assembly to perform the specified operation on the value or region represented by the source and the state of the program afterwards
	 */
	public AssemblyStatePair getSTA(ProgramState state, Integer i)
	{
		assert !isLiteral; // Can't store into numbers
		return getInstruction(state, "STA", i);
	}
	public AssemblyStatePair applySTA(AssemblyStatePair pair, Integer i)
	{
		assert !isLiteral; // Can't store into numbers
		return applyInstruction(pair, "STA", i);
	}
	public MutableAssemblyStatePair applySTA(MutableAssemblyStatePair pair, Integer i)
	{
		assert !isLiteral; // Can't store into numbers
		return applyInstruction(pair, "STA", i);
	}
	public boolean isStationary()
	{
		return false;
	}
	
	public abstract String getSpec();
	public boolean equals(Object other)
	{
		if (!OperandSource.class.isAssignableFrom(other.getClass()))
			return false;
		return getSpec().equals(((OperandSource) other).getSpec());
	}
}
