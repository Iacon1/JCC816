// By Iacon1
// Created 05/11/2023
// An interpreted component node

package Compiler.ComponentNodes;

import java.util.LinkedList;
import java.util.List;

import Compiler.ComponentNodes.Definitions.EnumDefinition;
import Compiler.ComponentNodes.Definitions.Scope;
import Compiler.ComponentNodes.Definitions.StructDefinition;
import Compiler.ComponentNodes.Definitions.UnionDefinition;

public class ComponentNode<T extends ComponentNode<T>>
{
	protected ComponentNode<?> parent;
	protected List<ComponentNode<?>> children;
	
	protected static List<VariableNode> variables;
	protected static List<FunctionDefinitionNode> functions;
	protected static List<StructDefinition> structs;
	protected static List<UnionDefinition> unions;
	protected static List<EnumDefinition> enums;
	
	private void resetReferences()
	{
		variables = new LinkedList<VariableNode>();
		functions = new LinkedList<FunctionDefinitionNode>();
		structs = new LinkedList<StructDefinition>();
		unions = new LinkedList<UnionDefinition>();
		enums = new LinkedList<EnumDefinition>();
	}
	protected static void registerVariable(VariableNode variable) {variables.add(variable);}
	protected static void registerFunction(FunctionDefinitionNode function) {functions.add(function);}
	protected static void registerStruct(StructDefinition struct) {structs.add(struct);}
	protected static void registerUnion(UnionDefinition union) {unions.add(union);}
	protected static void registerEnum(EnumDefinition enum_) {enums.add(enum_);}
	
	public ComponentNode(ComponentNode<?> parent)
	{
		if (variables == null) resetReferences();
		this.children = new LinkedList<ComponentNode<?>>();
		this.parent = parent;
		this.parent.children.add(this);
	}
	public ComponentNode()
	{
		this.children = new LinkedList<ComponentNode<?>>();
		this.parent = null;
	}
	
	/**
	 * @return The current node's scope.
	 */
	public Scope getScope()
	{
		if (parent == null) return new Scope();
		else return parent.getScope();
	}
	
	/** Gets a variable's node using its full name.
	 * @param name The full name to look for.
	 * @return The variable node in question, if present.
	 */
	public static VariableNode resolveVariable(String fullName)
	{
		for (VariableNode variable : variables)
			if (variable.getFullName().equals(fullName))
				return variable;
		return null;
	}
	/** Gets a variable's node using its full name.
	 * @param name The full name to look for.
	 * @return The variable node in question, if present.
	 */
	public static StructDefinition resolveStruct(String fullName)
	{
		for (StructDefinition definition : structs)
			if (definition.getFullName().equals(fullName))
				return definition;
		return null;
	}
	/** Gets a variable's node using its full name.
	 * @param name The full name to look for.
	 * @return The variable node in question, if present.
	 */
	public static UnionDefinition resolveUnion(String fullName)
	{
		for (UnionDefinition definition : unions)
			if (definition.getFullName().equals(fullName))
				return definition;
		return null;
	}
	/**
	 * 
	 * @return Whether this node is in a function or not.
	 */
	public boolean isGlobal()
	{
		if (parent == null) return true;
		return parent.isGlobal();
	}
	
}
