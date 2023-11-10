// Created by Iacon1 on 11/02/2023.
// A generic pointer IVal.

package Compiler.ComponentNodes.LValues;

import java.util.Set;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.Expressions.AdditiveExpressionNode;
import Compiler.ComponentNodes.Expressions.BaseExpressionNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompConfig;
import Compiler.Utils.CompUtils;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.ConstantSource;
import Compiler.Utils.OperandSources.OperandSource;

public class IndirectLValueNode extends LValueNode<IndirectLValueNode>
{
	private class IndirectOperandSource extends OperandSource
	{
		private int lastI = -1;
		private String lastWhitespace;
		
		public IndirectOperandSource()
		{
			super(addrSource.getSize(), addrSource.isLiteral());
			lastWhitespace = "";
		}

		@Override
		public String apply(Integer i, Boolean is16Bit)
		{
			return "[" + addrSource.apply(0, is16Bit) + "],y\n" + lastWhitespace + "PLY";
		}
	
		@Override
		public String prefaceAssembly(String whitespace, Integer i, Boolean is16Bit)
		{
			String assembly = "";
			lastWhitespace = whitespace;
			if (i != lastI)
			{
				assembly += "PHY\n";
				assembly += whitespace + "LDY\t#" + String.format(is16Bit? "%04x" : "%02x", i) + "\n";
				lastI = i;
			}

			return assembly;
		}
	}
	private LValueNode<?> destination; // Just here for const-prop purposes
	private OperandSource addrSource; // Not the same as destination.getSource(), since pointers must be copied to the DP.
	public IndirectLValueNode(ComponentNode<?> parent, LValueNode<?> destination, OperandSource addrSource, Type type)
	{
		super(parent, type);
		this.destination = destination;
		this.addrSource = addrSource;
	}
	public IndirectLValueNode(ComponentNode<?> parent, OperandSource addrSource, Type type)
	{
		super(parent, type);
		this.destination = null;
		this.addrSource = addrSource;
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
		if (addrSource != null) return new IndirectOperandSource();
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
