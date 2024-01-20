// Created by Iacon1 on 01/15/2024.
// Catalogs types, variables, and functions

package C99Compiler.CompilerNodes.Interfaces;

import java.util.LinkedHashMap;

import C99Compiler.CompConfig.DefinableInterrupt;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.EnumeratorNode;
import C99Compiler.CompilerNodes.Definitions.EnumDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.StructUnionDefinitionNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;

public interface Catalogger
{
	public LinkedHashMap<String, VariableNode> getVariables();
	public LinkedHashMap<String, StructUnionDefinitionNode> getStructs();
	public LinkedHashMap<String ,EnumDefinitionNode> getEnums();
	public LinkedHashMap<String, EnumeratorNode> getEnumerators();
	public LinkedHashMap<String, FunctionDefinitionNode> getFunctions();
	public LinkedHashMap<String, Type> getTypedefs();
	public LinkedHashMap<String, String> getRequiredSubs();
	public LinkedHashMap<DefinableInterrupt, String> getInterrupts();
	
	/** Gets a T's node using its full name.
	 * @param name The full name to look for.
	 * @return The T node in question, if present.
	 */
	private <T> T resolveT(String fullName, LinkedHashMap<String, T> map)
	{
		T t = map.get(fullName);
		if (t != null) return t;
		else return null;
	}
	/** Gets a variable's node using its full name.
	 * @param name The full name to look for.
	 * @return The variable node in question, if present.
	 */
	public default VariableNode resolveVariable(String fullName)
	{return resolveT(fullName, getVariables());}
	/** Gets a struct/union's node using its full name.
	 * @param name The full name to look for.
	 * @return The struct/union node in question, if present.
	 */
	public default StructUnionDefinitionNode resolveStructOrUnion(String fullName)
	{return resolveT(fullName, getStructs());}
	/** Gets a enum's node using its full name.
	 * @param name The full name to look for.
	 * @return The enum node in question, if present.
	 */
	public default EnumDefinitionNode resolveEnum(String fullName)
	{return resolveT(fullName, getEnums());}
	/** Gets a enumerator's node using its full name.
	 * @param name The full name to look for.
	 * @return The enum node in question, if present.
	 */
	public default EnumeratorNode resolveEnumerator(String fullName)
	{return resolveT(fullName, getEnumerators());}
	/** Gets a function's node using its full name.
	 * @param name The full name to look for.
	 * @return The variable node in question, if present.
	 */
	public default FunctionDefinitionNode resolveFunction(String fullName)
	{return resolveT(fullName, getFunctions());}
	/** Gets a Typedef's true type using its full name.
	 * @param name The full name to look for.
	 * @return The variable node in question, if present.
	 */
	public default Type resolveTypedef(String fullName)
	{return resolveT(fullName, getTypedefs());}
	
	/** Gets an interrupt label, defaulting to RESET if none is found.
	 * @param interrupt the interrupt to look for.
	 * @return The label if present, or RESET if not.
	 */
	public default String getInterrupt(DefinableInterrupt interrupt)
	{
		String label = getInterrupts().get(interrupt);
		if (label != null) return label;
		else return "RESET";
	}
}