// Created by Iacon1 on 01/28/2024.
// A node that has a Sequence Point in it
package C99Compiler.CompilerNodes.Interfaces;

import C99Compiler.CompilerNodes.Interfaces.Assemblable.AssemblyStatePair;
import C99Compiler.Utils.ProgramState;

public interface SequencePointNode
{
	void registerAssemblable(Assemblable assemblable);
	void clearAssemblables();
	AssemblyStatePair getRegisteredAssemblyAndState(ProgramState state) throws Exception;
	default AssemblyStatePair applyRegistered(AssemblyStatePair pair) throws Exception
	{
		AssemblyStatePair reg = getRegisteredAssemblyAndState(pair.state);
		return new AssemblyStatePair(pair.assembly + reg. assembly, reg.state);
	}
}
