// Created by Iacon1 on 01/15/2024.
// Catalogs types, variables, and functions

package Compiler.CompilerNodes.Interfaces;

import java.util.List;
import java.util.Map;

import Compiler.CompConfig.DefinableInterrupt;
import Compiler.CompilerNodes.FunctionDefinitionNode;
import Compiler.CompilerNodes.Definitions.Type;
import Compiler.CompilerNodes.Dummies.EnumeratorNode;
import Compiler.CompilerNodes.Definitions.EnumDefinitionNode;
import Compiler.CompilerNodes.Definitions.StructUnionDefinitionNode;
import Compiler.CompilerNodes.LValues.VariableNode;

public interface Catalogger
{
	public List<VariableNode> getVariables();
	public List<StructUnionDefinitionNode> getStructs();
	public List<EnumDefinitionNode> getEnums();
	public List<EnumeratorNode> getEnumerators();
	public List<FunctionDefinitionNode> getFunctions();
	public Map<String, Type> getTypedefs();
	public Map<String, String> getRequiredSubs();
	public Map<DefinableInterrupt, String> getInterrupts();
	
	/** Gets a variable's node using its full name.
	 * @param name The full name to look for.
	 * @return The variable node in question, if present.
	 */
	public default VariableNode resolveVariable(String fullName)
	{
		for (VariableNode variable : getVariables())
			if (variable.getFullName().equals(fullName))
				return variable;
		return null;
	}
	/** Gets a struct/union's node using its full name.
	 * @param name The full name to look for.
	 * @return The struct/union node in question, if present.
	 */
	public default StructUnionDefinitionNode resolveStructOrUnion(String fullName)
	{
		for (StructUnionDefinitionNode definition : getStructs())
			if (definition.getFullName().equals(fullName))
				return definition;
		return null;
	}
	/** Gets a enum's node using its full name.
	 * @param name The full name to look for.
	 * @return The enum node in question, if present.
	 */
	public default EnumDefinitionNode resolveEnum(String fullName)
	{
		for (EnumDefinitionNode definition : getEnums())
			if (definition.getFullName().equals(fullName))
				return definition;
		return null;
	}
	/** Gets a enumerator's node using its full name.
	 * @param name The full name to look for.
	 * @return The enum node in question, if present.
	 */
	public default EnumeratorNode resolveEnumerator(String fullName)
	{
		for (EnumeratorNode enumerator : getEnumerators())
			if (enumerator.getFullName().equals(fullName))
				return enumerator;
		return null;
	}
	/** Gets a function's node using its full name.
	 * @param name The full name to look for.
	 * @return The variable node in question, if present.
	 */
	public default FunctionDefinitionNode resolveFunction(String fullName)
	{
		for (FunctionDefinitionNode definition : getFunctions())
			if (definition.getFullName().equals(fullName))
				return definition;
		return null;
	}
	/** Gets a Typedef's true type using its full name.
	 * @param name The full name to look for.
	 * @return The variable node in question, if present.
	 */
	public default Type resolveTypedef(String fullName)
	{
		return getTypedefs().get(fullName);
	}
	
	/** Gets an interrupt label, defaulting to RESET if none is found.
	 * @param interrupt the interrupt to look for.
	 * @return The label if present, or RESET if not.
	 */
	public default String getInterrupt(DefinableInterrupt interrupt)
	{
		if (getInterrupts().get(interrupt) != null)
			return getInterrupts().get(interrupt);
		else return "RESET";
	}
}