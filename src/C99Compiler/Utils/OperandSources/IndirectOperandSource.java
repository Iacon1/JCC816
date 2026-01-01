package C99Compiler.Utils.OperandSources;

import C99Compiler.CompConfig;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.PreserveFlag;
import C99Compiler.Utils.ProgramState.ProcessorFlag;
import Shared.Assemblable.AssemblyStatePair;

public class IndirectOperandSource extends OperandSource
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
	
	public OperandSource getSource() {return source;}
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