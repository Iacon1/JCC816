// Created by Iacon1 on 11/02/2023.
// A generic pointer IVal.

package Compiler.ComponentNodes.LValues;

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
	private OperandSource addrSource;
	public IndirectLValueNode(ComponentNode<?> parent, OperandSource addrSource, Type type)
	{
		super(parent, type);
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
}
