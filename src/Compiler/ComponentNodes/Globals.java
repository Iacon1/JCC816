// Created by Iacon1 on 12/12/2023.
// Globals for component nodes

package Compiler.ComponentNodes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Compiler.CompConfig.DefinableInterrupt;
import Compiler.ComponentNodes.Definitions.EnumDefinition;
import Compiler.ComponentNodes.Definitions.StructUnionDefinitionNode;
import Compiler.ComponentNodes.LValues.VariableNode;

public class Globals
{
	static List<VariableNode> variables = new LinkedList<VariableNode>();
	static List<FunctionDefinitionNode> functions = new LinkedList<FunctionDefinitionNode>();
	static List<StructUnionDefinitionNode> structs = new LinkedList<StructUnionDefinitionNode>();
	static List<EnumDefinition> enums = new LinkedList<EnumDefinition>();
	
	static Map<String, String> requiredSubs = new HashMap<String, String>(); // Special subroutines, like multipliers and dividers
	
	static Map<DefinableInterrupt, String> interrupts = new HashMap<DefinableInterrupt, String>();
	
	private Globals() {}
	
	public static void reset()
	{
		variables = new LinkedList<VariableNode>();
		functions = new LinkedList<FunctionDefinitionNode>();
		structs = new LinkedList<StructUnionDefinitionNode>();
		enums = new LinkedList<EnumDefinition>();
		requiredSubs = new HashMap<String, String>();
		interrupts = new HashMap<DefinableInterrupt, String>();
		
		for (DefinableInterrupt definableInterrupt : DefinableInterrupt.values())
			interrupts.put(definableInterrupt, "RESET");
	}
	
	public static void registerVariable(VariableNode variable) {variables.add(variable);}
	public static void registerFunction(FunctionDefinitionNode function) {functions.add(function);}
	public static void registerStructUnion(StructUnionDefinitionNode struct) {structs.add(struct);}
	public static void registerEnum(EnumDefinition enum_) {enums.add(enum_);}
	public static void registerInterrupt(DefinableInterrupt interrupt, FunctionDefinitionNode function)
	{
		interrupts.put(interrupt, function.getFullName());
	}

	public static void requireSub(String subName, String subAssembly)
	{
		requiredSubs.put(subName, subAssembly);
	}
}
