// Created by Iacon1 on 11/09/2024.
//
package C99Compiler.Utils.AssemblyUtils;

import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;

public class ByteCopier extends BytewiseOperator
{
	private OperandSource sourceFrom, sourceTo;
	
	public ByteCopier(int n, OperandSource sourceTo, OperandSource sourceFrom, boolean reversed)
	{
		super(n, n, reversed);
		this.sourceFrom = sourceFrom;
		this.sourceTo = sourceTo;
	}
	public ByteCopier(int n, OperandSource sourceTo, OperandSource sourceFrom)
	{
		super(n, n, false);
		this.sourceFrom = sourceFrom;
		this.sourceTo = sourceTo;
	}

	public ByteCopier(int n, OperandSource sourceTo, Object constValue)
	{
		super(n, n, false);
		this.sourceFrom = new ConstantSource(constValue, n);
		this.sourceTo = sourceTo;
	}
	@Override
	protected AssemblyStatePair getAssemblyAndState(ProgramState state, int i) throws Exception
	{
		AssemblyStatePair tmpPair;
		String assembly = "";
		
		tmpPair = sourceFrom.getLDA(state, i);
		assembly += tmpPair.assembly;
		state = tmpPair.state;
		
		tmpPair = sourceTo.getSTA(state, i);
		assembly += tmpPair.assembly;
		state = tmpPair.state;
		
		return new AssemblyStatePair(assembly, state);
	}
	
}
