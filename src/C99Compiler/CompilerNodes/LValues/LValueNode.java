// Created by Iacon1 on 10/19/2023.
// Variable node
package C99Compiler.CompilerNodes.LValues;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.ValueNode;
import C99Compiler.CompilerNodes.Definitions.Type;

public abstract class LValueNode<C extends LValueNode<C>> extends ValueNode<C>
{

	public LValueNode(ComponentNode<?> parent, Type type) {super(parent, type);}
	
	@Override
	public boolean isLValue() {return true;}
}
