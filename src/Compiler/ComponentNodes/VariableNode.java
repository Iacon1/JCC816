// By Iacon1
// Created 05/11/2023
//
package Compiler.ComponentNodes;

import java.util.List;
import java.util.Map;

import Grammar.GeneralParser;
import Grammar.GeneralParser.GeneralNode;

public class VariableNode extends ComponentNode<VariableNode> implements NamedNode
{
	private String name;
	private String type;
	
	public VariableNode(ComponentNode<?> parent)
	{
		super(parent);
		name = null;
		type = null;
	}
	public VariableNode()
	{
		super();
		name = null;
		type = null;
	}
	
	@Override
	public String getName() {return name;}
	
	@Override
	public Map<String, VariableNode> variables()
	{
		Map<String, VariableNode> variables = super.variables();
		variables.put(getFullName(), this);
		
		return variables;
	}
	@Override
	public <P extends GeneralParser> VariableNode interpret(GeneralNode<String> node)
	{
		type = node.childrenT.get(0);
		name = node.childrenT.get(1);
		
		return this;
	}
	public String getTypeName()
	{
		return type;
	}
	public TypeNode getType()
	{
		try {return resolveType(type);}
		catch (TypeNotPresentException e) {return new TypeNode(type);}
	}
	/**
	 * 
	 * @return Size of the variable in bytes.
	 */
	public int size() {return name.length();}
}
