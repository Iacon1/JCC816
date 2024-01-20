// Created by Iacon1 on 10/19/2023.
// Variable node
package Compiler.CompilerNodes.LValues;

import Compiler.CompilerNodes.ComponentNode;
import Compiler.CompilerNodes.Definitions.StructUnionDefinitionNode;
import Compiler.CompilerNodes.Definitions.Type;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.OperandSources.OperandSource;

public class MemberNode extends VariableNode
{
	private StructUnionDefinitionNode owner;
	
	private class MemberInstanceNode extends LValueNode<MemberInstanceNode>
	{
		private OperandSource source;
		public MemberInstanceNode(LValueNode<?> parent)
		{
			super(parent, MemberNode.this.getType());
			source = parent.getSource().getShifted(owner.getOffset(name)).respec(MemberNode.this.getType().getSize());
		}

		@Override
		public OperandSource getSource()
		{
			return source;
		}
		
	}
	
	
	public MemberNode(ComponentNode<?> parent, StructUnionDefinitionNode owner, String name, Type type)
	{
		super(parent, name, type);
		this.owner = owner;
	}

	@Override
	public OperandSource getSource()
	{
		return null;
	}

	public MemberInstanceNode getInstance(LValueNode<?> instanceOwner)
	{
		return new MemberInstanceNode(instanceOwner);
	}
	
}
