// Created by Iacon1 on 1/19/2024.
// Wrapper for offset / resized LValues
package Compiler.CompilerNodes.LValues;

import Compiler.CompilerNodes.ComponentNode;
import Compiler.CompilerNodes.Definitions.Type;
import Compiler.Utils.OperandSources.OperandSource;

public class WrapperLValueNode extends LValueNode<WrapperLValueNode>
{
	private LValueNode<?> original;
	private int offset;
	public WrapperLValueNode(ComponentNode<?> parent, Type type, LValueNode<?> original, int offset)
	{
		super(parent, type);
		
		this.original = original;
		this.offset = offset;
	}
	
	public OperandSource getSource()
	{
		return original.getSource().getShifted(offset).respec(type.getSize());
	}
}
