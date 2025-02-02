// By Iacon1
// Created 09/30/2023
//
package Shared;

import C99Compiler.Utils.ProgramState;

public interface Assemblable
{
	public static class AssemblyStatePair
	{
		public final String assembly;
		public final ProgramState state;
		
		public AssemblyStatePair(String assembly, ProgramState state)
		{
			this.assembly = assembly;
			this.state = state;
		}
		
		public AssemblyStatePair addAssembly(String assembly)
		{
			return new AssemblyStatePair(this.assembly + assembly, this.state);
		}
		
		public AssemblyStatePair replaceState(ProgramState state)
		{
			return new AssemblyStatePair(this.assembly, state);
		}
	}
	public class MutableAssemblyStatePair
	{
		public String assembly;
		public ProgramState state;
		
		public MutableAssemblyStatePair(String assembly, ProgramState state)
		{
			this.assembly = assembly;
			this.state = state;
		}
		
		public AssemblyStatePair getImmutable()
		{
			return new AssemblyStatePair(assembly, state);
		}
	}
	
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception;
	public default AssemblyStatePair apply(AssemblyStatePair pair) throws Exception
	{
		AssemblyStatePair myPair = getAssemblyAndState(pair.state);
		return new AssemblyStatePair(pair.assembly + myPair.assembly, myPair.state);
	}
	public default MutableAssemblyStatePair apply(MutableAssemblyStatePair pair) throws Exception
	{
		AssemblyStatePair myPair = getAssemblyAndState(pair.state);
		pair.assembly += myPair.assembly;
		pair.state = myPair.state;
		return pair;
	}
	public default ProgramState getStateAfter(ProgramState state) throws Exception
	{
		return getAssemblyAndState(state).state;
	}
	public default String getAssembly(ProgramState state) throws Exception
	{
		return getAssemblyAndState(state).assembly;
	}
	public default String getAssembly() throws Exception
	{
		return getAssembly(new ProgramState());
	}
}
