// Created by Iacon1 on 01/30/2025.
//
package C99Compiler.Utils.AssemblyUtils;

import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.OperandSources.OperandSource;

public class StackLoader extends BytewiseOperator
{
	OperandSource source;
	
	public StackLoader(int n, OperandSource source)
	{
		super(n, n, true);
		this.source = source;
	}

	@Override
	protected AssemblyStatePair getAssemblyAndState(ProgramState state, int i) throws Exception
	{
		MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
		pair.assembly += pair.state.getWhitespace() + "PLA\n";
		source.applySTA(pair, i);
		return pair.getImmutable();
	}
}