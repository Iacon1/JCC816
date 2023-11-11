// Created by Iacon1 on 10/19/2023.
// Variable node
package Compiler.ComponentNodes.LValues;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.Definitions.StructUnionDefinitionNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.Utils.OperandSources.AddressSource;
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
			public String prefaceAssembly(String whitespace, Integer i, Boolean is16Bit)
			{
				return getParent().getSource().prefaceAssembly(whitespace, i + owner.getOffset(name), is16Bit);
			}
			@Override
			public String apply(Integer i, Boolean is16Bit)
			{
				return getParent().getSource().apply(i + owner.getOffset(name), is16Bit);
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
