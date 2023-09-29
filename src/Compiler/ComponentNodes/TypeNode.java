// By Iacon1
// Created 05/11/2023
// A type
package Compiler.ComponentNodes;

import java.util.LinkedList;
import java.util.List;

import Grammar.GeneralParser;
import Grammar.GeneralParser.GeneralNode;

public class TypeNode extends ComponentNode<TypeNode> implements NamedNode
{
	protected String name;
	
	private List<VarDeclarationNode> members;
	
	public TypeNode(String name, ComponentNode<?> parent)
	{
		super(parent);
		this.name = name;
		this.members = new LinkedList<VarDeclarationNode>();
	}
	public TypeNode(String name)
	{
		super();
		this.name = name;
		this.members = new LinkedList<VarDeclarationNode>();
	}
	
	@Override
	public TypeNode interpret(GeneralNode<String> node)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getName() {return name;}

	public List<VarDeclarationNode> getMembers()
	{
		return members;
	}
}
