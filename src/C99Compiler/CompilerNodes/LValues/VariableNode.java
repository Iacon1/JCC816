// Created by Iacon1 on 10/19/2023.
// Variable node
package C99Compiler.CompilerNodes.LValues;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyLValueNode;
import C99Compiler.CompilerNodes.Interfaces.NamedNode;
import C99Compiler.Utils.PropPointer;
import C99Compiler.Utils.OperandSources.AddressSource;
import C99Compiler.Utils.OperandSources.StationaryAddressSource;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;

public class VariableNode extends LValueNode<VariableNode> implements NamedNode
{
	protected String name;
	private AddressSource source;

	public VariableNode(ComponentNode<?> parent, String name, Type type)
	{
		super(parent, type);
		this.name = name;
	}
	@Override
	public String getName() {return name;}
	@Override
	public String getFullName() {return NamedNode.super.getFullName() + (type.isStatic() ? "@" + getTranslationUnit().getStaticUUID() : "");}
	
	@Override
	public OperandSource getSource()
	{
		if (source == null)
		{
			if (getType().isTwice())
				source = new StationaryAddressSource(this.getFullName(), this.getSize()); // We can't find our name and size until assembly time
			else
				source = new AddressSource(this.getFullName(), this.getSize()); // We can't find our name and size until assembly time
			
		}
		return source;
	}
	@Override
	public LValueNode<?> castTo(Type type)
	{
		if (this.type.isArray() && type.isPointer() && !type.isArray()) // Decay array into pointer
			return new DummyLValueNode(this, type, new ConstantSource(new PropPointer<VariableNode>(this, 0), CompConfig.pointerSize));
		else return new DummyLValueNode(this, type, getSource()); // TODO
	}	
	
}
