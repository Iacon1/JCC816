// Created by Iacon1 on 1/13/2024.
// Enumerator node
package Compiler.ComponentNodes.Dummies;

import Compiler.ComponentNodes.Definitions.EnumDefinitionNode;

import Compiler.ComponentNodes.LValues.VariableNode;
import Compiler.Utils.OperandSources.OperandSource;

public class EnumeratorNode extends VariableNode
{
	private int value;
	
	public EnumeratorNode(EnumDefinitionNode parent, String name, int value)
	{
		super(parent, name, new DummyType("enum", parent.getName()));
		this.value = value;
	}

	@Override
	public OperandSource getSource()
	{
		return null;
	}
	
	public int getValue()
	{
		return value;
	}
}
