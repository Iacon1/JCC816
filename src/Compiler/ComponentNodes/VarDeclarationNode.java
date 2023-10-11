// By Iacon1
// Created 05/11/2023
//
package Compiler.ComponentNodes;

import java.util.Map;

import Compiler.ComponentNodes.Interfaces.NamedNode;
import Compiler.ComponentNodes.Interfaces.TypedNode;
import Grammar.GeneralParser.GeneralNode;

public class VarDeclarationNode extends ComponentNode<VarDeclarationNode> implements NamedNode, TypedNode
{
	protected String name;
	private String type;
	
	public VarDeclarationNode(ComponentNode<?> parent)
	{
		super(parent);
		name = null;
		type = null;
	}
	public VarDeclarationNode()
	{
		super();
		name = null;
		type = null;
	}
	
	@Override
	public String getName() {return name;}
	
	@Override
	public Map<String, VarDeclarationNode> variables()
	{
		Map<String, VarDeclarationNode> variables = super.variables();
		if (name != null) variables.put(getFullName(), this);
		
		return variables;
	}
	@Override
	public VarDeclarationNode interpret(GeneralNode<String, String> node)
	{
		if (node.childrenNodes.size() == 0)
		{
			type = node.childrenT.get(0);
			if (node.childrenT.get(1).equals("*"))
			{
				type += "*";
				name = node.childrenT.get(2);
			}
			else name = node.childrenT.get(1);
		}
		else // Splits into multiple declarations
		{
			new VarDeclarationNode(this).interpret(node.getNode(0));
			new VarDeclarationNode(this).interpret(node.getNode(1));
		}
		return this;
	}
	@Override
	public String getTypeName()
	{
		return type;
	}
	@Override
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
