// Created by Iacon1 on 10/19/2023.
// Variable node
package Compiler.ComponentNodes;

import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.Interfaces.NamedNode;
import Compiler.ComponentNodes.Interfaces.TypedNode;

public class VariableNode extends ComponentNode<VariableNode> implements NamedNode, TypedNode
{
	private String name;
	private Type type;
	
	public VariableNode(ComponentNode<?> parent, String name, Type type)
	{
		super(parent);
		this.name = name;
		this.type = type;
	}
	@Override
	public String getName() {return name;}
	@Override
	public Type getType()
	{
		return type;
	}
	
	public int getSize()
	{
		return type.getSize();
	}
}
