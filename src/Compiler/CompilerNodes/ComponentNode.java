// By Iacon1
// Created 05/11/2023
// A component node

package Compiler.CompilerNodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Compiler.CompilerNodes.Definitions.EnumDefinitionNode;
import Compiler.CompilerNodes.Definitions.Scope;
import Compiler.CompilerNodes.Definitions.StructUnionDefinitionNode;
import Compiler.CompilerNodes.Definitions.Type;
import Compiler.CompilerNodes.Dummies.EnumeratorNode;
import Compiler.CompilerNodes.LValues.VariableNode;
import Compiler.CompilerNodes.Statements.IterationStatementNode;
import Compiler.CompilerNodes.Statements.SelectionStatementNode;

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
	
	/** Gets the list of Ts defined in this node or its subnodes.
	 * 
	 * @param tClass The class of T.
	 * @param strict Whether to only get Ts, or subclasses of Ts.
	 * @return The list of Ts defined in this node or its subnodes.
	 */
	@SuppressWarnings("unchecked")
	private <T extends ComponentNode<?>> List<T> getChildTs(Class<T> tClass, boolean strict)
	{
		List<T> childTs = new ArrayList<T>();
		for (ComponentNode<?> node : children)
		{
			if (tClass.equals(node.getClass())) childTs.add((T) node);
			else if (!strict && VariableNode.class.isAssignableFrom(node.getClass())) childTs.add((T) node);
			childTs.addAll(node.getChildTs(tClass, strict));
		}
		return childTs;
	}
	/** Gets the list of variables defined in this node or its subnodes.
	 * 
	 * @param strict Whether to only get variables, or subclasses of variables.
	 * @return The list of variables defined in this node or its subnodes.
	 */
	public List<VariableNode> getChildVariables(boolean strict)
	{
		return getChildTs(VariableNode.class, strict);
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
			referencedVariables.addAll(node.getReferencedVariables(strict));
		}
		return referencedVariables;
	}
	/** Gets the list of variables referenced in this node or its subnodes.
	 * 
	 * @return The list of variables referenced in this node or its subnodes.
	 */
	public List<VariableNode> getReferencedVariables()
	{
		return getReferencedVariables(true);
	}
	/** Gets the list of structs or unions defined in this node or its subnodes.
	 * 
	 * @return The list of structs or unions referenced in this node or its subnodes.
	 */
	public List<StructUnionDefinitionNode> getChildStructs()
	{
		return getChildTs(StructUnionDefinitionNode.class, true);
	}
	/** Gets the list of enums defined in this node or its subnodes.
	 * 
	 * @return The list of enums referenced in this node or its subnodes.
	 */
	public List<EnumDefinitionNode> getChildEnums()
	{
		return getChildTs(EnumDefinitionNode.class, true);
	}
	/** Gets the list of enumerators defined in this node or its subnodes.
	 * 
	 * @return The list of enumerators referenced in this node or its subnodes.
	 */
	public List<EnumeratorNode> getChildEnumerators()
	{
		return getChildTs(EnumeratorNode.class, true);
	}
	/** Gets the list of functions defined in this node or its subnodes.
	 * 
	 * @return The list of functions referenced in this node or its subnodes.
	 */
	public List<FunctionDefinitionNode> getChildFunctions()
	{
		return getChildTs(FunctionDefinitionNode.class, true);
	}
	
	/** Gets a variable's node using a partial name.
	 * @param name The partial name to look for.
	 * @return The variable node in question, if present.
	 */
	public VariableNode resolveVariableRelative(String name)
	{
		String fullName = getScope().getPrefix() + name;
		if (fullName.length() == 1) fullName = "__" + fullName;
		if (getTranslationUnit().resolveVariable(fullName) != null)
			return getTranslationUnit().resolveVariable(fullName);
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
		if (getTranslationUnit().resolveStructOrUnion(fullName) != null)
			return getTranslationUnit().resolveStructOrUnion(fullName);
		if (parent != null) return parent.resolveStructOrUnionRelative(name);
		return null;
	}
	/** Gets a enum's node using a partial name.
	 * @param name The full name to look for.
	 * @return The enum node in question, if present.
	 */
	public EnumDefinitionNode resolveEnumRelative(String name)
	{
		String fullName = getScope().getPrefix() + name;
		if (fullName.length() == 1) fullName = "__" + fullName;
		if (getTranslationUnit().resolveEnum(fullName) != null)
			return getTranslationUnit().resolveEnum(fullName);
		if (parent != null) return parent.resolveEnumRelative(name);
		return null;
	}
	/** Gets a enumerator's node using a partial name.
	 * @param name The full name to look for.
	 * @return The enum node in question, if present.
	 */
	public EnumeratorNode resolveEnumeratorRelative(String name)
	{
		String fullName = getScope().getPrefix() + name;
		if (fullName.length() == 1) fullName = "__" + fullName;
		if (getTranslationUnit().resolveEnumerator(fullName) != null)
			return getTranslationUnit().resolveEnumerator(fullName);
		if (parent != null) return parent.resolveEnumeratorRelative(name);
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
		if (getTranslationUnit().resolveFunction(fullName) != null)
			return getTranslationUnit().resolveFunction(fullName);
		if (parent != null) return parent.resolveFunctionRelative(name);
		return null;
	}
	/** Gets a Typedef's true type using a partial name.
	 * @param name The partial name to look for.
	 * @return The function node in question, if present.
	 */
	public Type resolveTypedefRelative(String name)
	{
		String fullName = getScope().getPrefix() + name;
		if (fullName.length() == 1) fullName = "__" + fullName;
		if (getTranslationUnit().resolveTypedef(fullName) != null)
			return getTranslationUnit().resolveTypedef(fullName);
		if (parent != null) return parent.resolveTypedefRelative(name);
		return null;
	}
	
	/** Gets the enclosing translation unit, if any.
	 * @return The translation unit node in question, if present.
	 */
	public TranslationUnitNode getTranslationUnit()
	{
		if (TranslationUnitNode.class.isAssignableFrom(getClass()))
			return (TranslationUnitNode) this;
		else if (parent != null) return parent.getTranslationUnit();
		else return null;
	}
	/** Gets the enclosing function, if any.
	 * @return The function node in question, if present.
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
