// Created by Iacon1 on 10/19/2023.
// Variable node
package Compiler.CompilerNodes.Dummies;

import Compiler.CompilerNodes.ComponentNode;
import Compiler.CompilerNodes.Definitions.Type;
import Compiler.CompilerNodes.LValues.VariableNode;
import Compiler.Utils.OperandSources.OperandSource;

public class DummyVariableNode extends VariableNode
{
	public DummyVariableNode(ComponentNode<?> parent, Type type)
	{
		super(parent, null, type);
	}

	@Override
	public OperandSource getSource()
	{
		return null;
	}
}
