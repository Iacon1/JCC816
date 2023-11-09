// By Iacon1
// Created 05/11/2023
// An interpreted component node

package Compiler.ComponentNodes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;

import Compiler.ComponentNodes.Definitions.EnumDefinition;
import Compiler.ComponentNodes.Definitions.Scope;
import Compiler.ComponentNodes.Definitions.StructUnionDefinitionNode;
import Compiler.ComponentNodes.LValues.VariableNode;
import Compiler.ComponentNodes.Statements.IterationStatementNode;
import Compiler.ComponentNodes.Statements.SelectionStatementNode;

public class ComponentNode<T extends ComponentNode<T>>
{
	protected ComponentNode<?> parent;
	protected List<ComponentNode<?>> children;
	
	protected static List<VariableNode> variables;
	protected static List<FunctionDefinitionNode> functions;
	protected static List<StructUnionDefinitionNode> structs;
	protected static List<EnumDefinition> enums;
	
	protected static Set<SimpleEntry<Integer, Integer>> reqMultSubs;
	protected static Set<SimpleEntry<Integer, Integer>> reqDivSubs;
	
	private void resetReferences()
	{
		variables = new LinkedList<VariableNode>();
		functions = new LinkedList<FunctionDefinitionNode>();
		structs = new LinkedList<StructUnionDefinitionNode>();
		enums = new LinkedList<EnumDefinition>();
		reqMultSubs = new HashSet<SimpleEntry<Integer, Integer>>();
		reqDivSubs = new HashSet<SimpleEntry<Integer, Integer>>();
	}
	protected static void registerVariable(VariableNode variable) {variables.add(variable);}
	protected static void registerFunction(FunctionDefinitionNode function) {functions.add(function);}
	protected static void registerStructUnion(StructUnionDefinitionNode struct) {structs.add(struct);}
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
		reqMultSubs = new HashSet<SimpleEntry<Integer, Integer>>();
		reqDivSubs = new HashSet<SimpleEntry<Integer, Integer>>();
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
	public static StructUnionDefinitionNode resolveStructOrUnion(String fullName)
	{
		for (StructUnionDefinitionNode definition : structs)
			if (definition.getFullName().equals(fullName))
				return definition;
		return null;
	}
	/** Gets a function's node using its full name.
	 * @param name The full name to look for.
	 * @return The variable node in question, if present.
	 */
	public static FunctionDefinitionNode resolveFunction(String fullName)
	{
		for (FunctionDefinitionNode definition : functions)
			if (definition.getFullName().equals(fullName))
				return definition;
		return null;
	}
	
	/** Gets the enclosing function, if any.
	 * @return The variable node in question, if present.
	 */
	public FunctionDefinitionNode getEnclosingFunction()
	{
		if (FunctionDefinitionNode.class.isAssignableFrom(getClass()))
			return (FunctionDefinitionNode) this;
		else if (parent != null) return parent.getEnclosingFunction();
		else return null;
	}
	
	/** Gets the enclosing selection, if any.
	 * @return The variable node in question, if present.
	 */
	public SelectionStatementNode getEnclosingSelection()
	{
		if (SelectionStatementNode.class.isAssignableFrom(getClass()))
			return (SelectionStatementNode) this;
		else if (parent != null) return parent.getEnclosingSelection();
		else return null;
	}
	/** Gets the enclosing loop, if any.
	 * @return The variable node in question, if present.
	 */
	public IterationStatementNode getEnclosingIteration()
	{
		if (IterationStatementNode.class.isAssignableFrom(getClass()))
			return (IterationStatementNode) this;
		else if (parent != null) return parent.getEnclosingIteration();
		else return null;
	}
	/** Registers a multiplier combination as needed.
	 * @return The name of the multiplier.
	 */
	public static String registerMult(int xSize, int ySize)
	{
		reqMultSubs.add(new SimpleEntry<Integer, Integer>(xSize, ySize));
		return "__MULT_" + xSize + "_" + ySize;
	}
	/** Registers a multiplier combination as needed.
	 * @return The name of the multiplier.
	 */
	public static String registerDiv(int xSize, int ySize)
	{
		reqDivSubs.add(new SimpleEntry<Integer, Integer>(xSize, ySize));
		return "__DIV_" + xSize + "_" + ySize;
	}
}
