// Created by Iacon1 on 01/28/2024.
// A node that has a Sequence Point in it
package C99Compiler.CompilerNodes.Interfaces;

import C99Compiler.Utils.ProgramState;
import Shared.Assemblable;
import Shared.Assemblable.AssemblyStatePair;
import Shared.Assemblable.MutableAssemblyStatePair;

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
	default MutableAssemblyStatePair applyRegistered(MutableAssemblyStatePair pair) throws Exception
	{
		AssemblyStatePair reg = getRegisteredAssemblyAndState(pair.state);
		pair.assembly += reg.assembly;
		pair.state = reg.state;
		return pair;
	}
}
