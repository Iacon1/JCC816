// Created by Iacon1 on 11/02/2023.
// A generic pointer IVal.

package C99Compiler.CompilerNodes.LValues;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.ValueNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.Utils.OperandSources.IndirectOperandSource;
import C99Compiler.Utils.OperandSources.OperandSource;

public class IndirectLValueNode extends LValueNode<IndirectLValueNode>
{
	private IndirectOperandSource source;
	
	private LValueNode<?> destination; // Just here for const-prop purposes
	private OperandSource addrSource; // Not the same as destination.getSource(), since pointers must be copied to the DP.
	public IndirectLValueNode(ComponentNode<?> parent, LValueNode<?> destination, OperandSource addrSource, Type type)
	{
		super(parent, type);
		this.destination = destination;
		this.addrSource = addrSource;
		if (addrSource != null) source = new IndirectOperandSource(type.getSize(), addrSource);
		this.type = type;
	}
	public IndirectLValueNode(ComponentNode<?> parent, OperandSource addrSource, Type type)
	{
		super(parent, type);
		this.destination = null;
		this.addrSource = addrSource;
		if (addrSource != null) source = new IndirectOperandSource(type.getSize(), addrSource);
		this.type = type;
	}
	@Override
	public Type getType()
	{
		return type;
	}
	
	public int getSize()
	{
		return type.getSize();
	}
	@Override
	public OperandSource getSource()
	{
		if (addrSource != null && source == null) source = new IndirectOperandSource(type.getSize(), addrSource);
		if (addrSource != null) return source;
		else return null;
	}
	
	@Override
	public String getAddress(int offset)
	{
		return addrSource.getShifted(offset).getBase();
	}
	@Override
	public ValueNode<?> castTo(Type type)
	{
		if (destination != null) return destination.castTo(type);
		else return super.castTo(type);
	}
}
