// Created by Iacon1 on 11/02/2023.
// A generic pointer IVal.

package C99Compiler.CompilerNodes.LValues;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.ValueNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.PreserveFlag;
import C99Compiler.Utils.ProgramState.ProcessorFlag;
import Shared.Assemblable.AssemblyStatePair;
import C99Compiler.Utils.OperandSources.OperandSource;

public class IndirectLValueNode extends LValueNode<IndirectLValueNode>
{
	private static class IndirectOperandSource extends OperandSource
	{
		private OperandSource source;

		public IndirectOperandSource(int size, OperandSource source)
		{
			super(size, source.isLiteral());
			this.source = source;
		}
		public IndirectOperandSource(int size, int offset, OperandSource source)
		{
			super(size,  offset, source.isLiteral());
			this.source = source;
		}
		@Override
		public OperandSource getShifted(int offset, int size) {return new IndirectOperandSource(this.size + size, this.offset + offset, source);}
		@Override
		public String getBase()
		{
			return "[" + source.getBase() + "]";
		}
		@Override
		public String getSpec()
		{
			return "[" + source.getSpec() + "]";
		}
		
		@Override
		public AssemblyStatePair getInstruction(ProgramState state, String operation, Integer i)
		{
			String whitespace = state.getWhitespace();
			String assembly = "";

			if (i >= size)
				assembly = whitespace + operation + "\t" + CompConfig.signExtend + "\n";
			else
			{
				if (state.testPreserveFlag(PreserveFlag.Y))
					assembly += whitespace + "PHY\n";
				if (state.testKnownFlag(PreserveFlag.I))
				{
					if (Math.abs(i + offset) >= 128 && !state.testProcessorFlag(ProcessorFlag.I))
					{
						assembly += whitespace + "REP\t#$10\n";
						state = state.setProcessorFlags(ProcessorFlag.I);
					}
					else if (Math.abs(i + offset) < 128 && state.testProcessorFlag(ProcessorFlag.I))
					{
						assembly += whitespace + "SEP\t#$10\n";
						state = state.clearProcessorFlags(ProcessorFlag.I);
					}
				}
				else
				{
					if (Math.abs(i + offset) >= 128)
					{
						assembly += whitespace + "REP\t#$10\n";
						state = state.setProcessorFlags(ProcessorFlag.I);
					}
					else if (Math.abs(i + offset) < 128)
					{
						assembly += whitespace + "SEP\t#$10\n";
						state = state.clearProcessorFlags(ProcessorFlag.I);
					}
				}
				
				if (!(state.testKnownFlag(PreserveFlag.Y) && state.getY() == i + offset))
					assembly += whitespace + "LDY\t#$" + String.format(state.testProcessorFlag(ProcessorFlag.M) ? "%04x" : "%02x", i + offset) + "\n";
				assembly += whitespace + operation + "\t[" + source.getBase() + "],y" + "\n";
				if (Math.abs(i + offset) >= 128 && !state.testProcessorFlag(ProcessorFlag.I) && state.testPreserveFlag(PreserveFlag.I))
					assembly += whitespace + "SEP\t#$10\n";
				if (state.testPreserveFlag(PreserveFlag.Y))
					assembly += whitespace + "PLY\n";
				else
					state = state.fixYReg(i + offset);
			}
			return new AssemblyStatePair(assembly, state);
		}

		@Override
		public OperandSource getRespecified(int offset, int size) {return new IndirectOperandSource(size, offset, source);}
	
		@Override
		public boolean isStationary()
		{
			return source.isStationary();
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
