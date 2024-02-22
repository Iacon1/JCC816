// Created by Iacon1 on 11/09/2023.
// A pointer to predefined location.

package C99Compiler.Utils;

import java.util.function.BiFunction;

import C99Compiler.CompilerNodes.Interfaces.AddressableNode;
import C99Compiler.CompilerNodes.Interfaces.NamedNode;
import C99Compiler.CompilerNodes.Interfaces.TypedNode;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;

public class PropPointer<T extends AddressableNode & TypedNode> implements BiFunction<Integer, DetailsTicket, String>
{
	private T node;
	private int offset;

	public PropPointer(T node, int offset)
	{
		this.node = node;
		this.offset = offset * node.getType().getSize();
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
	
	public String apply(Integer i, DetailsTicket ticket)
	{
		String address = node.getAddress(offset);
		if (i == 0)
			return "#" + (ticket.is16Bit() ? ".loWord(" : ".loByte(") + address + ")";
		else return "#.bankByte(" + address + ")";
	}
}
