// Created by Iacon1 on 11/02/2023.
// A generic pointer IVal.

package C99Compiler.CompilerNodes.LValues;

import java.util.Set;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.OperandSources.OperandSource;

public class IndirectLValueNode extends LValueNode<IndirectLValueNode>
{
	private class IndirectOperandSource extends OperandSource
	{
		public IndirectOperandSource()
		{
			super(type.getSize(), addrSource.isLiteral());
		}

		@Override
		public OperandSource getShifted(int offset, int size) {return this;}
		@Override
		public String getBase()
		{
			return "[" + addrSource.getBase() + "]";
		}
		
		@Override
		public String getInstruction(String whitespace, String operation, Integer i, DetailsTicket ticket)
		{
			String assembly = "";

			if ((ticket.flags & DetailsTicket.saveY) != 0)
				assembly += whitespace + "PHY\n";
			assembly += whitespace + "LDY\t#$" + String.format(ticket.is16Bit() ? "%04x" : "%02x", i) + "\n";

			assembly += whitespace + operation + "[" + addrSource.getBase() + "],y" + "\n";
			if ((ticket.flags & DetailsTicket.saveY) != 0)
				assembly += whitespace + "PLY\n";

			return assembly;
		}

		@Override
		public OperandSource getRespecified(int offset, int size) {return this;}
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
