// Created by Iacon1 on 10/19/2023.
// Variable node
package Compiler.ComponentNodes.LValues;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.Interfaces.NamedNode;
import Compiler.Utils.OperandSources.AddressSource;
import Compiler.Utils.OperandSources.OperandSource;

public class VariableNode extends LValueNode<VariableNode> implements NamedNode
{
	protected String name;
	private AddressSource source;
	public VariableNode(ComponentNode<?> parent, String name, Type type)
	{
		super(parent, type);
		this.name = name;
		source = new AddressSource(this.getFullName(), this.getSize());
	}
	@Override
	public String getName() {return name;}
	
	@Override
	public OperandSource getSource()
	{
		return source;
	}
	
	
	
}
