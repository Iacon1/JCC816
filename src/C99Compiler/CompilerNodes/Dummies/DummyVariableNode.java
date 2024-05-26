// Created by Iacon1 on 10/19/2023.
// Variable node
package C99Compiler.CompilerNodes.Dummies;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.Utils.OperandSources.OperandSource;

public class DummyVariableNode extends VariableNode
{
	private OperandSource source;
	
	public DummyVariableNode(ComponentNode<?> parent, String name, Type type, OperandSource source)
	{
		super(parent, name, type);
		this.source = source;
	}
	@Override
	public String getAddress(int offset)
	{
		return source.getShifted(offset).getBase();
	}
	@Override
	public OperandSource getSource()
	{
		return source;
	}
}
