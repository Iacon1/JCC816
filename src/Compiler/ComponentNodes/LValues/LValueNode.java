// Created by Iacon1 on 10/19/2023.
// Variable node
package Compiler.ComponentNodes.LValues;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.Interfaces.TypedNode;
import Compiler.Utils.OperandSource;

public abstract class LValueNode<C extends LValueNode<C>> extends ComponentNode<C> implements TypedNode
{
	protected Type type;
	
	public LValueNode(ComponentNode<?> parent, Type type)
	{
		super(parent);
		this.type = type;
	}
	@Override
	public Type getType()
	{
		return type;
	}
	
	public int getSize()
	{
		return type.getSize();
	}
	
	public abstract OperandSource getSource();
}
