// Created by Iacon1 on 11/09/2023.
// A pointer to predefined location.

package Compiler.Utils;

import Compiler.ComponentNodes.LValues.VariableNode;

public class PropPointer
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
	public String apply(Integer i, Boolean is16Bit)
	{
		String address = null;
		if (offset != 0) address = node.getFullName() + " + " + offset;
		else if (offset == 0) address = node.getFullName();
		return "#" + (is16Bit ? ".loWord(" : ".bankByte(") + address + ")";
	}
}
