// By Iacon1
// Created 05/11/2023
// An interpreted component node

package Compiler.ComponentNodes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Grammar.GeneralParser.GeneralInterpreter;
import Compiler.CompConfig;

public abstract class ComponentNode<T extends ComponentNode<T>> implements GeneralInterpreter<String, T>
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
	
	/**
	 * 
	 * @return The current node's scope, with [n - 1] being the most local and [0] being the most global provided.
	 */
	public String[] getScope()
	{
		if (parent == null) return null;
		else return parent.getScope();
	}
	public String getScopePrefix()
	{
		if (getScope() == null) return "";
		
		String prefix = "";
		for (int i = 0; i < getScope().length; ++i)
			prefix += getScope()[i] + CompConfig.scopeDelimiter();
		
		return prefix;
	}
	
	/** Resolves a partially-scoped name into a node.
	 * 
	 * @param name The name (and some scope parts) to look for.
	 * @return
	 */
	private static <T> T resolveT(Map<String, T> map, String name)
	{
		for (String key : map.keySet())
			if (key.regionMatches(key.length() - name.length(), name, 0, name.length()))
					return map.get(key);
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
	/**
	 * 
	 * @return The variables visible to this node (i. e. in this node or in one below it).
	 */
	public Map<String, VariableNode> variables()
	{
		Map<String, VariableNode> variables = new HashMap<String, VariableNode>();
		for (ComponentNode<?> child : children) variables.putAll(child.variables());
		return variables;
	}
	public VariableNode resolveVariable(String name)
	{
		if (resolveT(variables(), name) != null) return resolveT(variables(), name);
		else if (parent != null) return parent.resolveVariable(name);
		else return null;
	}
	public Map<String, TypeNode> types()
	{
		Map<String, TypeNode> types = new HashMap<String, TypeNode>();
		for (ComponentNode<?> child : children) types.putAll(child.types());
		return types;
	}
	public TypeNode resolveType(String name) throws TypeNotPresentException
	{
		if (resolveT(types(), name) != null) return resolveT(types(), name);
		else if (parent != null) return parent.resolveType(name);
		else throw new TypeNotPresentException(name, null);
	}
	public Map<String, FunctionNode> functions()
	{
		Map<String, FunctionNode> functions = new HashMap<String, FunctionNode>();
		for (ComponentNode<?> child : children) functions.putAll(child.functions());
		return functions;
	}
	public FunctionNode resolveFunctions(String name)
	{
		if (resolveT(functions(), name) != null) return resolveT(functions(), name);
		else if (parent != null) return parent.resolveFunctions(name);
		else return null;
	}
	
}
