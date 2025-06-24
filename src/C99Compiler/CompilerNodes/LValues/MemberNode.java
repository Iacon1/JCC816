// Created by Iacon1 on 10/19/2023.
// Variable node
package C99Compiler.CompilerNodes.LValues;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.StructUnionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.Utils.OperandSources.OperandSource;
import C99Compiler.Utils.OperandSources.StationaryAddressSource;

public class MemberNode extends VariableNode
{
	private StructUnionDefinitionNode owner;
	
	private class MemberInstanceNode extends LValueNode<MemberInstanceNode>
	{
		private OperandSource source;
		public MemberInstanceNode(LValueNode<?> parent)
		{
			super(parent, MemberNode.this.getType());
			if (parent.getSource() == null)
				source = null;
			source = parent.getSource().getShifted(owner.getOffset(name)).respec(MemberNode.this.getType().getSize());
			if (owner.getMember(name).getType().isTwice())
				source = new StationaryAddressSource(source.getBase(), 0, source.getSize());
		}

		@Override
		public OperandSource getSource()
		{
			return source;
		}
		
		@Override
		public String getAddress(int offset)
		{
			return ((LValueNode<?>) parent).getAddress(owner.getOffset(name));
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
