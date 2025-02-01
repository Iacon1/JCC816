// By Iacon1
// Created 10/01/2023
// Typed Node
package C99Compiler.CompilerNodes.Interfaces;

import C99Compiler.Utils.ProgramState;

public interface UnvaluedAssemblableNode extends AssemblableNode
{
	@Override public default boolean hasPropValue(ProgramState state) {return false;}
	@Override public default Object getPropValue(ProgramState state) {return null;}
}
