// Created by Iacon1 on 02/18/2024.
// Address source that doesn't actually move
package C99Compiler.Utils.OperandSources;

import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import Shared.Assemblable.AssemblyStatePair;

public class StationaryAddressSource extends AddressSource
{
	public StationaryAddressSource(String address, int offset, int size)
	{
		super(address, offset, size);
	}
	public StationaryAddressSource(String address, int size)
	{
		super(address, size);
	}
	
	@Override
	public AssemblyStatePair getLDA(ProgramState state, Integer i)
	{
		AssemblyStatePair tmpPair;
		String whitespace = state.getWhitespace();
		if (state.testProcessorFlag(ProgramState.ProcessorFlag.M))
		{
			String assembly = whitespace + CompUtils.setA8 + "\n";
			
			tmpPair = getInstruction(state, "LDA", 0);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			
			assembly += whitespace + "XBA\n";
			
			tmpPair = getInstruction(state, "LDA", 0);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			
			assembly += whitespace + "XBA\n";
			assembly += whitespace + CompUtils.setA16 + "\n";
			return new AssemblyStatePair(assembly, state);
		}
		else return getInstruction(state, "LDA", 0);
	}
	
	@Override
	public AssemblyStatePair getSTA(ProgramState state, Integer i)
	{
		AssemblyStatePair tmpPair;
		String whitespace = state.getWhitespace();
		if (state.testProcessorFlag(ProgramState.ProcessorFlag.M))
		{
			String assembly = whitespace + CompUtils.setA8 + "\n";
			
			tmpPair = getInstruction(state, "STA", 0);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			
			assembly += whitespace + "XBA\n";
			
			tmpPair = getInstruction(state, "STA", 0);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			
			assembly += whitespace + "XBA\n";
			assembly += whitespace + CompUtils.setA16 + "\n";
			return new AssemblyStatePair(assembly, state);
		}
		else return getInstruction(state, "STA", 0);
	}
	
	@Override
	public boolean isStationary()
	{
		return true;
	}
}
