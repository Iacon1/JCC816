// Created by Iacon1 on 10/19/2023.
// Variable node
package C99Compiler.CompilerNodes.LValues;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Interfaces.NamedNode;
import C99Compiler.Utils.OperandSources.AddressSource;
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
	public OperandSource getSource()
	{
		if (source == null) source = new AddressSource(this.getFullName(), this.getSize()); // We can't find our name and size until assembly time
		return source;
	}
	
	
	
}
