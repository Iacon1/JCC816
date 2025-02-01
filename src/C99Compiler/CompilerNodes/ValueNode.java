// Created by Iacon1 on 4/27/2024.
// Value node.

package C99Compiler.CompilerNodes;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyValueNode;
import C99Compiler.CompilerNodes.Interfaces.AddressableNode;
import C99Compiler.CompilerNodes.Interfaces.TypedNode;
import C99Compiler.Utils.PropPointer;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;

public abstract class ValueNode<C extends ValueNode<C>> extends ComponentNode<C> implements AddressableNode, TypedNode
{
	protected Type type;

	public ValueNode(ComponentNode<?> parent, Type type)
	{
		super(parent);
		this.type = type;
	}
	@Override
	public Type getType()
	{
		return type;
	}

	
	public boolean isLValue() {return false;} // To be overridden
	public ValueNode<?> castTo(Type type)
	{
		if (this.type.isArray() && type.isPointer() && !type.isArray()) // Decay array into pointer
			return new DummyValueNode(this, type, new ConstantSource(new PropPointer<C>((C) this, 0), CompConfig.pointerSize));
		else return new DummyValueNode(this, type, getSource()); // TODO
	}	
	
	public int getSize()
	{
		return type.getSize();
	}
	
	public abstract OperandSource getSource();
}
