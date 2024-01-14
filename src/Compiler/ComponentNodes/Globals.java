// Created by Iacon1 on 12/12/2023.
// Globals for component nodes

package Compiler.ComponentNodes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Compiler.CompConfig.DefinableInterrupt;
import Compiler.ComponentNodes.Definitions.EnumDefinitionNode;
import Compiler.ComponentNodes.Definitions.StructUnionDefinitionNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.Dummies.EnumeratorNode;
import Compiler.ComponentNodes.LValues.VariableNode;

public class Globals
{
	static List<VariableNode> variables = new LinkedList<VariableNode>();
	
	static List<FunctionDefinitionNode> functions = new LinkedList<FunctionDefinitionNode>();
	
	static List<StructUnionDefinitionNode> structs = new LinkedList<StructUnionDefinitionNode>();
	
	static Map<String, Type> typedefs = new HashMap<String, Type>();
	
	static List<EnumDefinitionNode> enums = new LinkedList<EnumDefinitionNode>();
	static List<EnumeratorNode> enumerators = new LinkedList<EnumeratorNode>();
	
	static Map<String, String> requiredSubs = new HashMap<String, String>(); // Special subroutines, like multipliers and dividers
	
	static Map<DefinableInterrupt, String> interrupts = new HashMap<DefinableInterrupt, String>();
	
	private Globals() {}
	
	public static void reset()
	{
		variables = new LinkedList<VariableNode>();
		functions = new LinkedList<FunctionDefinitionNode>();
		structs = new LinkedList<StructUnionDefinitionNode>();
		enums = new LinkedList<EnumDefinitionNode>();
		typedefs = new HashMap<String, Type>();
		
		requiredSubs = new HashMap<String, String>();
		interrupts = new HashMap<DefinableInterrupt, String>();
		
		for (DefinableInterrupt definableInterrupt : DefinableInterrupt.values())
			interrupts.put(definableInterrupt, "RESET");
	}
	
	public static void registerVariable(VariableNode variable) {variables.add(variable);}
	public static void registerFunction(FunctionDefinitionNode function) {functions.add(function);}
	public static void registerStructUnion(StructUnionDefinitionNode struct) {structs.add(struct);}
	public static void registerInterrupt(DefinableInterrupt interrupt, FunctionDefinitionNode function)
	{
		interrupts.put(interrupt, function.getFullName());
	}
	public static void registerTypedef(String identifier, Type type)
	{
		typedefs.put(identifier, type);
	}
	
	public static void registerEnum(EnumDefinitionNode enum_) {enums.add(enum_);}
	public static void registerEnumerator(EnumeratorNode enumerator) {enumerators.add(enumerator);}
	
	public static void requireSub(String subName, String subAssembly)
	{
		requiredSubs.put(subName, subAssembly);
	}
}
