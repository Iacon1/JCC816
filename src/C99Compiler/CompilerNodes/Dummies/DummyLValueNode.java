// Created by Iacon1 on 10/19/2023.
// Variable node
package C99Compiler.CompilerNodes.Dummies;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.Utils.OperandSources.OperandSource;

public class DummyLValueNode extends LValueNode<DummyLValueNode>
{
	private OperandSource source;

	public DummyLValueNode(ComponentNode<?> parent, Type type, OperandSource source)
	{
		super(parent, type);
		this.source = source;
	}

	public OperandSource getSource() {return source;}
}
