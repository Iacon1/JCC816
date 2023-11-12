// Created by Iacon1 on 11/09/2023.
// A pointer to predefined location.

package Compiler.Utils;

import java.util.function.BiFunction;

import Compiler.ComponentNodes.LValues.VariableNode;
import Compiler.Utils.AssemblyUtils.DetailsTicket;

public class PropPointer implements BiFunction<Integer, DetailsTicket, String>
{
	private VariableNode node;
	private long offset;

	public PropPointer(VariableNode node, int offset)
	{
		this.node = node;
		this.offset = offset * node.getType().getSize();
	}
	
	public PropPointer addOffset(int offset)
	{
		PropPointer p = new PropPointer(node, offset);
		p.offset += this.offset;
		return p;
	}
	
	public VariableNode getNode()
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
