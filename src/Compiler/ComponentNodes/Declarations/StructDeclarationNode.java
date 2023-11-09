// Created by Iacon1 on 10/290/2023.
//
package Compiler.ComponentNodes.Declarations;

import java.util.LinkedList;
import java.util.List;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.Expressions.ConstantExpressionNode;
import Compiler.ComponentNodes.InterpretingNode;
import Compiler.ComponentNodes.Definitions.BitFieldType;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.LValues.MemberNode;
import Compiler.ComponentNodes.Definitions.StructUnionDefinitionNode;
import Compiler.Exceptions.ConstraintException;
import Grammar.C99.C99Parser.Struct_declarationContext;
import Grammar.C99.C99Parser.Struct_declaratorContext;

public class StructDeclarationNode extends InterpretingNode<StructDeclarationNode, Struct_declarationContext>
{
	private List<MemberNode> members;
	
	public StructDeclarationNode(ComponentNode<?> parent)
	{
		super(parent);
		members = new LinkedList<MemberNode>();
	}

	@Override
	public StructDeclarationNode interpret(Struct_declarationContext node) throws Exception
	{
		DeclarationSpecifiersNode specifiers = new DeclarationSpecifiersNode(this).interpret(node.specifier_qualifier_list());
		if (node.struct_declarator_list() != null)
			for (Struct_declaratorContext structDeclarator : node.struct_declarator_list().struct_declarator())
			{
				DeclaratorNode declaratorNode = new DeclaratorNode(this).interpret(structDeclarator.declarator());
				Type type = Type.manufacture(specifiers.getSpecifiers(), declaratorNode, structDeclarator.start);
				if (structDeclarator.constant_expression() != null) // Bitfield
				{
					long fieldBits = new ConstantExpressionNode(this).interpret(structDeclarator.constant_expression()).getPropLong();
					if (type.isInteger() || type.containsSpecifier("_Bool"))
						type = new BitFieldType(type, fieldBits);
					else throw new ConstraintException("6.7.2.1", 4, structDeclarator.start);
				}
				MemberNode member = new MemberNode(this, (StructUnionDefinitionNode) parent, declaratorNode.getIdentifier(), type);
				members.add(member);
			}
		else throw new ConstraintException("6.7", 2, node.start);
		return this;
	}
	
	public List<MemberNode> getMembers()
	{
		return members;
	}
}
