// Created by Iacon1 on 11/09/2024.
//
package C99Compiler.Utils.AssemblyUtils;

import C99Compiler.CompilerNodes.Interfaces.Assemblable;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;

public abstract class BytewiseOperator implements Assemblable
{
	protected final int n1, n2; // n2 should be smaller than n1
	protected final boolean reversed;
	
	protected BytewiseOperator(int n1, int n2, boolean reversed)
	{
		this.n1 = n1;
		this.n2 = n2;
		assert n1 >= n2;
		this.reversed = reversed;
	}
	
	protected abstract AssemblyStatePair getAssemblyAndState(ProgramState state, int i) throws Exception;
	private AssemblyStatePair apply(AssemblyStatePair pair, int i) throws Exception
	{
		AssemblyStatePair myPair = getAssemblyAndState(pair.state, i);
		return new AssemblyStatePair(myPair.assembly + pair.assembly, myPair.state);
	}
	private MutableAssemblyStatePair apply(MutableAssemblyStatePair pair, int i) throws Exception
	{
		AssemblyStatePair myPair = getAssemblyAndState(pair.state, i);
		pair.assembly += myPair.assembly;
		pair.state = myPair.state;
		return pair;
	}
	
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);

		byte flags = pair.state.getPreserveFlags();
		pair.assembly += AssemblyUtils.store(pair.state, ProgramState.PreserveFlag.A);
		pair.state = pair.state.clearPreserveFlags(ProgramState.PreserveFlag.A);
		
		if (n1 == 1 || n1 == 2) // Only one operation needed
		{
			if (n1 == 1) // One byte to operate on
			{
				if (!(state.testKnownFlag(ProgramState.PreserveFlag.M) && !pair.state.testProcessorFlag(ProgramState.ProcessorFlag.M))) // Not already in 8-bit mode
				{
					pair.assembly += pair.state.getWhitespace() + CompUtils.setA8 + "\n";
					pair.state = pair.state.clearProcessorFlags(ProgramState.ProcessorFlag.M);
				}
			}
			else // Two bytes to operate on
			{
				if (!(pair.state.testKnownFlag(ProgramState.PreserveFlag.M) && pair.state.testProcessorFlag(ProgramState.ProcessorFlag.M))) // Not already in 16-bit mode
				{
					pair.assembly += pair.state.getWhitespace() + CompUtils.setA16 + "\n";
					pair.state = pair.state.setProcessorFlags(ProgramState.ProcessorFlag.M);
				}
			}
			apply(pair, 0);
		}
		else // 2 or more operations needed
		{
			if (!(state.testKnownFlag(ProgramState.PreserveFlag.M) && state.testProcessorFlag(ProgramState.ProcessorFlag.M))) // Not already in 16-bit mode
			{
				pair.assembly += pair.state.getWhitespace() + CompUtils.setA16 + "\n";
				pair.state = pair.state.setProcessorFlags(ProgramState.ProcessorFlag.M);
			}
			if (!reversed) // Go from offset 0 up
			{
				for (int i = 0; i < n1 - (n1 % 2); i += 2)
				{
					if (i == n2 - 1) // Halfway between in n2 and not
					{
						pair.assembly += pair.state.getWhitespace() + CompUtils.setA8 + "\n";
						pair.state = pair.state.clearProcessorFlags(ProgramState.ProcessorFlag.M);
						apply(pair, i);
						apply(pair, i + 1);
						pair.assembly += pair.state.getWhitespace() + CompUtils.setA16 + "\n";
						pair.state = pair.state.setProcessorFlags(ProgramState.ProcessorFlag.M);
					}
					else
						apply(pair, i);
				}
				if (n1 % 2 != 0) // One more
				{
					pair.assembly += pair.state.getWhitespace() + CompUtils.setA8 + "\n";
					pair.state = pair.state.clearProcessorFlags(ProgramState.ProcessorFlag.M);
					apply(pair, n1 - 1);
				}
			}
			else // Go from offset n - 2 down
			{
				for (int i = n1 - 2; i >= (n1 % 2); i -= 2)
				{
					if (i == n2 - 1) // Halfway between in n2 and not
					{
						pair.assembly += pair.state.getWhitespace() + CompUtils.setA8 + "\n";
						pair.state = pair.state.clearProcessorFlags(ProgramState.ProcessorFlag.M);
						apply(pair, i + 1);
						apply(pair, i);
						pair.assembly += pair.state.getWhitespace() + CompUtils.setA16 + "\n";
						pair.state = pair.state.setProcessorFlags(ProgramState.ProcessorFlag.M);
					}
					else
						apply(pair, i);
				}
				if (n1 % 2 != 0) // One more
				{
					pair.assembly += pair.state.getWhitespace() + CompUtils.setA8 + "\n";
					pair.state = pair.state.clearProcessorFlags(ProgramState.ProcessorFlag.M);
					apply(pair, 0);
				}
			}
		}
		
		state = state.setPreserveFlags(flags);
		pair.assembly += AssemblyUtils.restore(state, ProgramState.PreserveFlag.A);
		
		return pair.getImmutable();
	}
}
