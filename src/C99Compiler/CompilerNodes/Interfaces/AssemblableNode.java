// By Iacon1
// Created 09/30/2023
//
package C99Compiler.CompilerNodes.Interfaces;

import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.Utils.ProgramState;

public interface AssemblableNode extends Assemblable
{
	public boolean canCall(ProgramState state, FunctionDefinitionNode function);
	@Deprecated
	public default boolean canCall(FunctionDefinitionNode function) {return canCall(new ProgramState(), function);}
	
	public boolean hasPropValue(ProgramState state);
	@Deprecated
	public default boolean hasPropValue() {return hasPropValue(new ProgramState());}
	
	public Object getPropValue(ProgramState state);
	@Deprecated
	public default Object getPropValue() {return getPropValue(new ProgramState());}
	
	public boolean hasAssembly(ProgramState state);
	@Deprecated
	public default boolean hasAssembly() {return hasAssembly(new ProgramState());}
}
