// By Iacon1
// Created 05/11/2023
// A component node

package Compiler.ComponentNodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Compiler.ComponentNodes.Definitions.Scope;
import Compiler.ComponentNodes.Definitions.StructUnionDefinitionNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.LValues.VariableNode;
import Compiler.ComponentNodes.Statements.IterationStatementNode;
import Compiler.ComponentNodes.Statements.SelectionStatementNode;

public class ComponentNode<T extends ComponentNode<T>>
{
	protected ComponentNode<?> parent;
	protected List<ComponentNode<?>> children;
	
	public ComponentNode(ComponentNode<?> parent)
	{
		this.children = new LinkedList<ComponentNode<?>>();
		this.parent = parent;
		this.parent.children.add(this);
	}
	public ComponentNode()
	{
		this.children = new LinkedList<ComponentNode<?>>();
		this.parent = null;
	}
	public void removeChild(ComponentNode<?> child)
	{
		children.remove(child);
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
		for (VariableNode variable : Globals.variables)
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
		for (StructUnionDefinitionNode definition : Globals.structs)
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
		for (FunctionDefinitionNode definition : Globals.functions)
			if (definition.getFullName().equals(fullName))
				return definition;
		return null;
	}
	/** Gets a variable's node using a partial name.
	 * @param name The partial name to look for.
	 * @return The variable node in question, if present.
	 */
	public VariableNode resolveVariableRelative(String name)
	{
		String fullName = getScope().getPrefix() + name;
		if (fullName.length() == 1) fullName = "__" + fullName;
		for (VariableNode variable : Globals.variables)
			if (variable.getFullName().equals(fullName))
				return variable;
		if (parent != null) return parent.resolveVariableRelative(name);
		return null;
	}
	/** Gets a struct or union's node using a partial name.
	 * @param name The partial name to look for.
	 * @return The struct or union node in question, if present.
	 */
	public StructUnionDefinitionNode resolveStructOrUnionRelative(String name)
	{
		String fullName = getScope().getPrefix() + name;
		if (fullName.length() == 1) fullName = "__" + fullName;
		for (StructUnionDefinitionNode definition : Globals.structs)
			if (definition.getFullName().equals(fullName))
				return definition;
		if (parent != null) return parent.resolveStructOrUnionRelative(name);
		return null;
	}
	/** Gets a function's node using a partial name.
	 * @param name The partial name to look for.
	 * @return The function node in question, if present.
	 */
	public FunctionDefinitionNode resolveFunctionRelative(String name)
	{
		String fullName = getScope().getPrefix() + name;
		if (fullName.length() == 1) fullName = "__" + fullName;
		for (FunctionDefinitionNode definition : Globals.functions)
			if (definition.getFullName().equals(fullName))
				return definition;
		if (parent != null) return parent.resolveFunctionRelative(name);
		return null;
	}
	/** Gets a Typedef's true type using its full name.
	 * @param name The full name to look for.
	 * @return The variable node in question, if present.
	 */
	public static Type resolveTypedef(String fullName)
	{
		return Globals.typedefs.get(fullName);
	}
	/** Gets a Typedef's true type using a partial name.
	 * @param name The partial name to look for.
	 * @return The function node in question, if present.
	 */
	public Type resolveTypedefRelative(String name)
	{
		String fullName = getScope().getPrefix() + name;
		if (fullName.length() == 1) fullName = "__" + fullName;
		if (Globals.typedefs.get(fullName) != null)
			return Globals.typedefs.get(fullName);
		if (parent != null) return parent.resolveTypedefRelative(name);
		return null;
	}
	
	/** Gets the list of variables defined in this node or its subnodes.
	 * 
	 * @param strict Whether to only get variables, or subclasses of variables.
	 * @return The list of variables defined in this node or its subnodes.
	 */
	public List<VariableNode> getChildVariables(boolean strict)
	{
		List<VariableNode> childVariables = new ArrayList<VariableNode>();
		for (ComponentNode<?> node : children)
		{
			if (VariableNode.class.equals(node.getClass())) childVariables.add((VariableNode) node);
			else if (!strict && VariableNode.class.isAssignableFrom(node.getClass())) childVariables.add((VariableNode) node);
			childVariables.addAll(node.getChildVariables(strict));
		}
		return childVariables;
	}
	/** Gets the list of variables defined in this node or its subnodes.
	 * 
	 * @return The list of variables defined in this node or its subnodes.
	 */
	public List<VariableNode> getChildVariables()
	{
		return getChildVariables(true);
	}
	/** Gets the list of variables referenced in this node or its subnodes.
	 * 
	 * @param strict Whether to only get variables, or subclasses of variables.
	 * @return The list of variables referenced in this node or its subnodes.
	 */
	public List<VariableNode> getReferencedVariables(boolean strict)
	{
		List<VariableNode> referencedVariables = new ArrayList<VariableNode>();
		for (ComponentNode<?> node : children)
		{
			if (VariableNode.class.equals(node.getClass())) referencedVariables.add((VariableNode) node);
			else if (!strict && VariableNode.class.isAssignableFrom(node.getClass())) referencedVariables.add((VariableNode) node);
			referencedVariables.addAll(node.getChildVariables(strict));
		}
		return referencedVariables;
	}
	/** Gets the list of variables referenced in this node or its subnodes.
	 * 
	 * @return The list of variables referenced in this node or its subnodes.
	 */
	public List<VariableNode> getReferencedVariables()
	{
		return getChildVariables(true);
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
	
}
