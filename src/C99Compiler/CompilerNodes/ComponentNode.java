// By Iacon1
// Created 05/11/2023
// A component node

package C99Compiler.CompilerNodes;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import C99Compiler.CompilerNodes.Definitions.EnumDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Scope;
import C99Compiler.CompilerNodes.Definitions.StructUnionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.EnumeratorNode;
import C99Compiler.CompilerNodes.Interfaces.NamedNode;
import C99Compiler.CompilerNodes.Interfaces.TypedNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.CompilerNodes.Statements.IterationStatementNode;
import C99Compiler.CompilerNodes.Statements.SelectionStatementNode;

public class ComponentNode<C extends ComponentNode<C>> implements Serializable
{
	protected ComponentNode<?> parent;
	protected List<ComponentNode<?>> children;
	
	public ComponentNode(ComponentNode<?> parent)
	{
		this.children = new LinkedList<ComponentNode<?>>();
		this.parent = parent;
		if (parent != null)
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
	public void swap(ComponentNode<?> replacement)
	{
		if (this.parent != null)
		{
			int i = parent.children.indexOf(this);
			parent.children.set(i, replacement);
			parent = null;
		}
		else if (replacement.parent != null)
		{
			replacement.parent.removeChild(replacement);
			replacement.parent = null;
		}
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
	private <T extends ComponentNode<?> & NamedNode> LinkedHashMap<String, T> getChildTs(Class<T> tClass, boolean strict)
	{
		LinkedHashMap<String, T> childTs = new LinkedHashMap<String, T>();
		for (ComponentNode<?> node : children)
		{
			if (tClass.equals(node.getClass()))
				childTs.put(((T) node).getFullName(), (T) node);
			else if (!strict && tClass.isAssignableFrom(node.getClass()))
				childTs.put(((T) node).getFullName(), (T) node);
			childTs.putAll(node.getChildTs(tClass, strict));
		}
		return childTs;
	}
	/** Gets the list of variables defined in this node or its subnodes.
	 * 
	 * @param strict Whether to only get variables, or subclasses of variables.
	 * @return The list of variables defined in this node or its subnodes.
	 */
	public LinkedHashMap<String, VariableNode> getChildVariables(boolean strict)
	{return getChildTs(VariableNode.class, strict);}
	/** Gets the list of variables defined in this node or its subnodes.
	 * 
	 * @return The list of variables defined in this node or its subnodes.
	 */
	public LinkedHashMap<String, VariableNode> getChildVariables()
	{return getChildVariables(true);}
	/** Gets the list of variables referenced in this node or its subnodes.
	 * 
	 * @param strict Whether to only get variables, or subclasses of variables.
	 * @return The list of variables referenced in this node or its subnodes.
	 */
	public LinkedHashMap<String, VariableNode> getReferencedVariables(boolean strict)
	{
		LinkedHashMap<String, VariableNode> referencedVariables = new LinkedHashMap<String, VariableNode>();
		for (ComponentNode<?> node : children)
		{
			if (VariableNode.class.equals(node.getClass()))
				referencedVariables.put(((VariableNode) node).getFullName(), (VariableNode) node);
			else if (!strict && VariableNode.class.isAssignableFrom(node.getClass()))
				referencedVariables.put(((VariableNode) node).getFullName(), (VariableNode) node);
			referencedVariables.putAll(node.getReferencedVariables(strict));
		}
		return referencedVariables;
	}
	/** Gets the list of variables referenced in this node or its subnodes.
	 * 
	 * @return The list of variables referenced in this node or its subnodes.
	 */
	public LinkedHashMap<String, VariableNode> getReferencedVariables()
	{return getReferencedVariables(true);}
	/** Gets the list of structs or unions defined in this node or its subnodes.
	 * 
	 * @return The list of structs or unions referenced in this node or its subnodes.
	 */
	public LinkedHashMap<String, StructUnionDefinitionNode> getChildStructs()
	{return getChildTs(StructUnionDefinitionNode.class, true);}
	/** Gets the list of enums defined in this node or its subnodes.
	 * 
	 * @return The list of enums referenced in this node or its subnodes.
	 */
	public LinkedHashMap<String, EnumDefinitionNode> getChildEnums()
	{return getChildTs(EnumDefinitionNode.class, true);}
	/** Gets the list of enumerators defined in this node or its subnodes.
	 * 
	 * @return The list of enumerators referenced in this node or its subnodes.
	 */
	public LinkedHashMap<String, EnumeratorNode> getChildEnumerators()
	{return getChildTs(EnumeratorNode.class, true);}
	/** Gets the list of functions defined in this node or its subnodes.
	 * 
	 * @return The list of functions referenced in this node or its subnodes.
	 */
	public LinkedHashMap<String, FunctionDefinitionNode> getChildFunctions()
	{return getChildTs(FunctionDefinitionNode.class, true);}
	
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
		else
		{
			fullName += "@" + getTranslationUnit().getStaticUUID();
			if (getTranslationUnit().resolveVariable(fullName) != null)
				return getTranslationUnit().resolveVariable(fullName);
		}
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
		else
		{
			fullName += "@" + getTranslationUnit().getStaticUUID();
			if (getTranslationUnit().resolveVariable(fullName) != null)
				return getTranslationUnit().resolveFunction(fullName);
		}
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
	
	/** Gets a T node that would have the same full name as the one generated by adder, if any.
	 * @param adder A function that adds a T node to a given node.
	 * @return The matching T node, if any.
	 */
	private <T extends ComponentNode<?> & NamedNode> T checkRepeatTs(byte mask, LinkedHashMap<String, T> map, Function<ComponentNode<?>, T> adder)
	{
		HiddenNode testHolder = new HiddenNode(mask, this);
		T testValue = adder.apply(testHolder);
		if (testValue == null) return null;
		T result = map.get(testValue.getFullName());
		removeChild(testHolder);
		return result;
	}
	/** Gets a variable node that would have the same full name as the one generated by adder, if any exist below this node.
	 * @param adder A function that adds a variable node to a given node.
	 * @return The matching variable node, if any, or null if none were found.
	 */
	protected VariableNode checkRepeatVariables(Function<ComponentNode<?>, VariableNode> adder)
	{return checkRepeatTs(HiddenNode.noVars, getChildVariables(), adder);}
	/** Gets a struct / union node that would have the same full name as the one generated by adder, if any exist below this node.
	 * @param adder A function that adds a struct / union node to a given node.
	 * @return The matching struct / union node, if any, or null if none were found.
	 */
	protected StructUnionDefinitionNode checkRepeatStructs(Function<ComponentNode<?>, StructUnionDefinitionNode> adder)
	{return checkRepeatTs(HiddenNode.noStructs, getChildStructs(), adder);}
	/** Gets a enum node that would have the same full name as the one generated by adder, if any exist below this node.
	 * @param adder A function that adds a enum node to a given node.
	 * @return The matching enum node, if any, or null if none were found.
	 */
	protected EnumDefinitionNode checkRepeatEnums(Function<ComponentNode<?>, EnumDefinitionNode> adder)
	{return checkRepeatTs(HiddenNode.noEnums, getChildEnums(), adder);}
	/** Gets a enumerator node that would have the same full name as the one generated by adder, if any exist below this node.
	 * @param adder A function that adds a enumerator node to a given node.
	 * @return The matching enumerator node, if any, or null if none were found.
	 */
	protected EnumeratorNode checkRepeatEnumerators(Function<ComponentNode<?>, EnumeratorNode> adder)
	{return checkRepeatTs(HiddenNode.noEnumers, getChildEnumerators(), adder);}
	/** Tests whether a typedef with the same full name provided is already registered.
	 * @param fullName The full name of the typedef.
	 * @return true if a matching typedef is found, false if not.
	 */
	protected boolean checkRepeatEnumerators(String fullName)
	{return getTranslationUnit().resolveTypedef(fullName) != null;}
	/** Gets a function node that would have the same full name *and* erasure as the one generated by adder, if any exist below this node.
	 * @param adder A function that adds a function node to a given node.
	 * @return The matching function node, if any, or null if none were found.
	 */
	protected FunctionDefinitionNode checkRepeatFunctions(Function<ComponentNode<?>, FunctionDefinitionNode> adder)
	{return checkRepeatTs(HiddenNode.noFuncs, getChildFunctions(), adder);}
	
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
