// Created by Iacon1 on 11/04/2023.
// IVal that returns an immediate version of the IVal provided to it.

package Compiler.ComponentNodes.LVals;

import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.Expressions.BaseExpressionNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.OperandSource;

public class ImmediateLValNode extends LValueNode<ImmediateLValNode>
{
	private LValueNode<?> destination;
	public ImmediateLValNode(LValueNode<?> destination)
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
		final OperandSource destSource;
		destSource = destination.getSource();
		
		return new OperandSource((Integer i, Boolean use16) ->
		{
			return "#" + destSource.apply(i, use16);
		}, getSize(), false);
	}
}
