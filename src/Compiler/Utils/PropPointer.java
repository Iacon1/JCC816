// Created by Iacon1 on 11/09/2023.
// A pointer to predefined location.

package Compiler.Utils;

import java.util.function.BiFunction;

import Compiler.CompilerNodes.Interfaces.NamedNode;
import Compiler.CompilerNodes.Interfaces.TypedNode;
import Compiler.Utils.AssemblyUtils.DetailsTicket;

public class PropPointer<T extends NamedNode & TypedNode> implements BiFunction<Integer, DetailsTicket, String>
{
	private T node;
	private long offset;

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
		String address = null;
		if (offset != 0) address = node.getFullName() + " + " + offset;
		else if (offset == 0) address = node.getFullName();
		return "#" + (ticket.is16Bit() ? ".loWord(" : ".bankByte(") + address + ")";
	}
}
