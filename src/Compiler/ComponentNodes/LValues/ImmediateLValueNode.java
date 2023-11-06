// Created by Iacon1 on 11/04/2023.
// IVal that returns an immediate version of the IVal provided to it.

package Compiler.ComponentNodes.LValues;

import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.Expressions.BaseExpressionNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.ConstantSource;
import Compiler.Utils.OperandSources.OperandSource;

public class ImmediateLValueNode extends LValueNode<ImmediateLValueNode>
{
	private class ImmediateOperandSource extends OperandSource
	{
		public ImmediateOperandSource()
		{
			super(destination.getSource().getSize(), destination.getSource().isLiteral());
		}

		@Override
		public String apply(Integer i, Boolean is16Bit)
		{
			return "#" + destination.getSource().apply(i, is16Bit);
		}
	}
	
	private LValueNode<?> destination;
	public ImmediateLValueNode(LValueNode<?> destination)
	{
		super(destination, destination.getType());
	}
	@Override
	public Type getType()
	{
		return type;
	}

	@Override
	public OperandSource getSource()
	{
		return new ImmediateOperandSource();
	}
}
