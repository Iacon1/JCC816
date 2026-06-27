// Created by Iacon1 on 11/23/2025.
//
package C99Compiler.Utils.OperandSources;

import C99Compiler.ProgramState.ProgramState;
import C99Compiler.ProgramState.ProgramState.PreserveFlag;
import C99Compiler.ProgramState.ProgramState.ProcessorFlag;
import Shared.Assemblable.AssemblyStatePair;

public class IndexOperandSource extends OperandSource
{
	private OperandSource source;
	private OperandSource indexSource;
	public IndexOperandSource(int size, OperandSource source, OperandSource indexSource)
	{
		super(size, source.isLiteral());
		this.source = source;
		this.indexSource = indexSource;
	}
	@Override
	public OperandSource getShifted(int offset, int size)
	{
		return new IndexOperandSource(this.size + size, source.getShifted(offset, source.size), indexSource);
	}
	public OperandSource getShifted(int offset) {return getShifted(offset, 0);}
	
	@Override
	public OperandSource getRespecified(int offset, int size)
	{
		return new IndexOperandSource(size, source.getRespecified(offset, source.size), indexSource);
	}
	public OperandSource respec(int size) {return getRespecified(source.offset, size);}

	@Override
	public String getBase()
	{
		return source.getBase();
	}

	@Override
	public AssemblyStatePair getInstruction(ProgramState state, String operation, Integer i)
	{
		String assembly = "";
		if (indexSource.getSize() >= 2 && (!state.testKnownFlag(PreserveFlag.I) || !state.testProcessorFlag(ProcessorFlag.I)))
		{
			assembly += state.getWhitespace() + "REP\t#$10\n";
			state = state.setProcessorFlags(ProcessorFlag.I);
		}
		else if (indexSource.getSize() == 1 && (!state.testKnownFlag(PreserveFlag.I) || state.testProcessorFlag(ProcessorFlag.I)))
		{
			assembly += state.getWhitespace() + "SEP\t#$10\n";
			state = state.setProcessorFlags(ProcessorFlag.I);
		}
		AssemblyStatePair p = indexSource.getInstruction(state, "LDX", 0);
		assembly += p.assembly;
		state = p.state;
		
		p = source.getInstruction(state, operation, i);
		assembly += p.assembly.substring(0, p.assembly.length() - 1) + ",X\n";
		state = p.state;
		return new AssemblyStatePair(assembly, state);
	}

	@Override
	public String getSpec()
	{
		return source.getSpec() + ",X";
	}
	
}
