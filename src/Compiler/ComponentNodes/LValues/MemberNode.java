// Created by Iacon1 on 10/19/2023.
// Variable node
package Compiler.ComponentNodes.LValues;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.Definitions.StructUnionDefinitionNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.Utils.OperandSources.AddressSource;
import Compiler.Utils.OperandSources.OperandSource;

public class MemberNode extends LValueNode<MemberNode>
{
	private StructUnionDefinitionNode owner;
	private String name;
	
	public MemberNode(ComponentNode<?> parent, StructUnionDefinitionNode owner, String name, Type type)
	{
		super(parent, type);
		this.owner = owner;
		this.name = name;
	}
	@Override
	public Type getType()
	{
		return type;
	}
	public String getName()
	{
		return name;
	}
	@Override
	public int getSize()
	{
		return type.getSize();
	}
	@Override
	public OperandSource getSource()
	{
		return new AddressSource(owner.getFullName() + " + " + owner.getOffset(name), this.getSize());
	}
}
