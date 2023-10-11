// By Iacon1
// Created 05/11/2023
// A type
package Compiler.ComponentNodes;

import java.util.LinkedList;
import java.util.List;

import Compiler.ComponentNodes.Interfaces.NamedNode;
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
	public TypeNode interpret(GeneralNode<String, String> node)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getName() {return name;}

	public int getSize() {return 0;} // TODO
	public List<VarDeclarationNode> getMembers()
	{
		return members;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (!obj.getClass().equals(this.getClass())) return false;
		
		TypeNode node = (TypeNode) obj;
		
		return node.name.equals(name) && node.members.equals(members) &&
				node.getScopePrefix().equals(getScopePrefix()) && node.getSize() == getSize();
	}
}
