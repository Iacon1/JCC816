// Created by Iacon1 on 11/02/2023.
// A generic pointer IVal.

package Compiler.ComponentNodes.LVals;

import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.Expressions.BaseExpressionNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.OperandSource;

public class IndirectLValNode extends LValNode<IndirectLValNode>
{
	private BaseExpressionNode<?> address;
	public IndirectLValNode(BaseExpressionNode<?> address)
	{
		super(address, address.getType());
	}
	@Override
	public Type getType()
	{
		return type;
	}
	
	public int getSize()
	{
		return type.getSize();
	}
	@Override
	public OperandSource getSource()
	{
		final OperandSource addrSource;
		if (address.hasPropValue()) addrSource = AssemblyUtils.numericSource(((Number) address.getPropValue()).longValue(), getSize());
		else addrSource = address.getLVal().getSource();
		
		return new OperandSource((Integer i, Boolean use16) ->
		{
			return "(" + addrSource.apply(i, use16) + ")";
		}, getSize(), false);
	}
}
