// Created by Iacon1 on 11/09/2023.
// A pointer to predefined location.

package C99Compiler.Utils;

import java.io.Serializable;
import java.util.function.BiFunction;

import C99Compiler.CompilerNodes.Interfaces.AddressableNode;
import C99Compiler.CompilerNodes.Interfaces.TypedNode;

public class PropPointer<T extends AddressableNode & TypedNode> implements BiFunction<ProgramState, Integer, String>, Serializable
{
	private T node;
	private int offset;

	public PropPointer(T node, int offsetBytes)
	{
		this.node = node;
		this.offset = offsetBytes;
	}
	
	public PropPointer<T> addOffset(int offset)
	{
		PropPointer<T> p = new PropPointer<T>(node, offset);
		p.offset += this.offset;
		return p;
	}
	
	public T getNode()
	{
		return node;
	}
	
	public String apply(ProgramState state, Integer i)
	{
		String address = node.getAddress(offset);
		if (i == 0)
			return "#" + (state.testProcessorFlag(ProgramState.ProcessorFlag.M) ? ".loWord(" : ".loByte(") + address + ")";
		else if (i == 1)
			return "#" + (state.testProcessorFlag(ProgramState.ProcessorFlag.M) ? ".hiWord((" : ".hiByte((") + address + ") << 8)";
		else if (i == 2)
			return "#.bankByte(" + address + ")";
		else return "#$00";
	}
	
	public String getSpec()
	{
		return "ptr:" + node.getAddress(offset);
	}
}
