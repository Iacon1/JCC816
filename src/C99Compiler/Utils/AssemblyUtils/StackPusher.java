// Created by Iacon1 on 01/30/2025.
//
package C99Compiler.Utils.AssemblyUtils;

import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.OperandSources.OperandSource;

public class StackPusher extends EightBitBytewiseOperator
{
	OperandSource source;
	
	public StackPusher(int n, OperandSource source)
	{
		super(n, false);
		this.source = source;
	}

	@Override
	protected AssemblyStatePair getAssemblyAndState(ProgramState state, int i) throws Exception
	{
		MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
		source.applyLDA(pair, i);
		pair.assembly += pair.state.getWhitespace() + "PHA\n";
		return pair.getImmutable();
	}
}
