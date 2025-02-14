// Created by Iacon1 on 11/09/2024.
//
package C99Compiler.Utils.AssemblyUtils;

import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import Shared.Assemblable;

public abstract class EightBitBytewiseOperator implements Assemblable
{
	protected final int n;
	protected final boolean reversed;
	
	protected EightBitBytewiseOperator(int n, boolean reversed)
	{
		this.n = n;
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

		{
			if (!pair.state.testKnownFlag(ProgramState.PreserveFlag.M) || pair.state.testProcessorFlag(ProgramState.ProcessorFlag.M)) // Not already in 8-bit mode
			{
				pair.assembly += pair.state.getWhitespace() + CompUtils.setA8 + "\n";
				pair.state = pair.state.clearProcessorFlags(ProgramState.ProcessorFlag.M);
			}
			if (!reversed) // Go from offset 0 up
				for (int i = 0; i < n; ++i)
					apply(pair, i);
			else // Go from offset n - 2 down
				for (int i = n - 1; i >= 0; ++i)
					apply(pair, i);
		}
		
		pair.state = pair.state.setPreserveFlags(flags);
		pair.assembly += AssemblyUtils.restore(pair.state, ProgramState.PreserveFlag.A);
		
		return pair.getImmutable();
	}
}
