// By Iacon1
// Created 09/30/2023
//
package C99Compiler.CompilerNodes.Interfaces;

import C99Compiler.CompilerNodes.FunctionDefinitionNode;

public interface AssemblableNode
{
	public default boolean canCall(FunctionDefinitionNode function) {return false;}
	public default boolean hasPropValue() {return true;}
	public boolean hasAssembly();
	public default Object getPropValue() {return null;}
	public String getAssembly(int leadingWhitespace) throws Exception;
	public default String getAssembly() throws Exception {return getAssembly(0);}
}
