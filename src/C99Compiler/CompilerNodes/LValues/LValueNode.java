// Created by Iacon1 on 10/19/2023.
// Variable node
package C99Compiler.CompilerNodes.LValues;

import java.util.HashSet;
import java.util.Set;

import C99Compiler.CompConfig;
import C99Compiler.CompConfig.OptimizationLevel;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.ValueNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyValueNode;
import C99Compiler.CompilerNodes.Interfaces.AddressableNode;
import C99Compiler.CompilerNodes.Interfaces.NamedNode;
import C99Compiler.CompilerNodes.Interfaces.TypedNode;
import C99Compiler.Utils.PropPointer;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;

public abstract class LValueNode<C extends LValueNode<C>> extends ValueNode<C>
{

	public LValueNode(ComponentNode<?> parent, Type type) {super(parent, type);}
	
	@Override
	public boolean isLValue() {return true;}
}
