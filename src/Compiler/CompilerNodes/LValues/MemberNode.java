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
		private class MemberSource extends OperandSource
		{
			public MemberSource()
			{
				super(MemberInstanceNode.this.getSize(), false);
			}
			
			private LValueNode<?> getParent()
			{
				return (LValueNode<?>) MemberInstanceNode.this.parent;
			}

			@Override
			public String getInstruction(String whitespace, String operation, Integer i, DetailsTicket ticket)
			{
				return getParent().getSource().getInstruction(whitespace, operation, i + owner.getOffset(name), ticket);
			}

			@Override
			public String getBase()
			{
				return getParent().getSource().getBase() + " + " + owner.getOffset(name);
			}
		}
		private MemberSource source = new MemberSource();
		public MemberInstanceNode(LValueNode<?> parent)
		{
			super(parent, MemberNode.this.getType());
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
