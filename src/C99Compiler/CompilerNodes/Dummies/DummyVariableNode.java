// Created by Iacon1 on 10/19/2023.
// Variable node
package C99Compiler.CompilerNodes.Dummies;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.Utils.OperandSources.OperandSource;

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
