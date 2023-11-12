// Created by Iacon1 on 11/02/2023.
// A generic pointer IVal.

package Compiler.ComponentNodes.LValues;

import java.util.Set;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.OperandSources.OperandSource;

public class IndirectLValueNode extends LValueNode<IndirectLValueNode>
{
	private class IndirectOperandSource extends OperandSource
	{
		private int lastI = -1;
		private String lastWhitespace;
		
		public IndirectOperandSource()
		{
			super(type.getSize(), addrSource.isLiteral());
			lastWhitespace = "";
		}

		@Override
		public String apply(Integer i, DetailsTicket ticket)
		{
			return "[" + addrSource.apply(0, ticket) + "],y" + ((ticket.flags & DetailsTicket.saveY) != 0 ? "\n" + lastWhitespace + "PLY" : "");
		}
	
		@Override
		public String prefaceAssembly(String whitespace, Integer i, DetailsTicket ticket)
		{
			String assembly = "";
			lastWhitespace = whitespace;
			if (i != lastI)
			{
				if ((ticket.flags & DetailsTicket.saveY) != 0) assembly += "PHY\n" + whitespace;
				assembly += "LDY\t#$" + String.format(ticket.is16Bit() ? "%04x" : "%02x", i) + "\n";
				lastI = i;
			}

			return assembly;
		}
	}
	private IndirectOperandSource source;
	
	private LValueNode<?> destination; // Just here for const-prop purposes
	private OperandSource addrSource; // Not the same as destination.getSource(), since pointers must be copied to the DP.
	public IndirectLValueNode(ComponentNode<?> parent, LValueNode<?> destination, OperandSource addrSource, Type type)
	{
		super(parent, type);
		this.destination = destination;
		this.addrSource = addrSource;
		if (addrSource != null) source = new IndirectOperandSource();
		this.type = type;
	}
	public IndirectLValueNode(ComponentNode<?> parent, OperandSource addrSource, Type type)
	{
		super(parent, type);
		this.destination = null;
		this.addrSource = addrSource;
		if (addrSource != null) source = new IndirectOperandSource();
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
		if (addrSource != null) return source;
		else return null;
	}
	
	@Override
	public boolean hasPossibleValues()
	{
		if (destination != null) return destination.hasPossibleValues();
		else return super.hasPossibleValues();
	}
	@Override
	public Set<Object> getPossibleValues()
	{
		if (destination != null) return destination.getPossibleValues();
		else return super.getPossibleValues();
	}
	@Override
	public void clearPossibleValues()
	{
		if (destination != null) destination.clearPossibleValues();
		else super.clearPossibleValues();
	}
	@Override
	public void setPossibleValues(Set<Object> possibleValues)
	{
		if (destination != null) destination.setPossibleValues(possibleValues);
		else super.setPossibleValues(possibleValues);
	}
	@Override
	public void addPossibleValue(Object value)
	{
		if (destination != null) destination.addPossibleValue(value);
		else super.addPossibleValue(value);
	}
}
