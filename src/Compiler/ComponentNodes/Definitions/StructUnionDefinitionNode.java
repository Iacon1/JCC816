// Created by Iacon1 on 10/19/2023.
//
package Compiler.ComponentNodes.Definitions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.InterpretingNode;
import Compiler.ComponentNodes.Declarations.DeclarationNode;
import Compiler.ComponentNodes.Declarations.StructDeclarationNode;
import Compiler.ComponentNodes.Interfaces.NamedNode;
import Compiler.ComponentNodes.Interfaces.TypedNode;
import Compiler.ComponentNodes.LValues.LValueNode;
import Compiler.ComponentNodes.LValues.MemberNode;
import Compiler.ComponentNodes.LValues.VariableNode;
import Grammar.C99.C99Parser.Struct_declarationContext;
import Grammar.C99.C99Parser.Struct_or_union_specifierContext;

public class StructUnionDefinitionNode extends InterpretingNode<StructUnionDefinitionNode, Struct_or_union_specifierContext> implements NamedNode
{
	private boolean isUnion;
	private String name;
	private List<MemberNode> members;
	
	public StructUnionDefinitionNode(ComponentNode<?> parent)
	{
		super(parent);
		isUnion = false;
		name = null;
		members = new LinkedList<MemberNode>();
	}
	@Override
	public StructUnionDefinitionNode interpret(Struct_or_union_specifierContext node) throws Exception
	{
		if (node.getChild(0).getText().equals("union")) isUnion = true;
		else isUnion = false;
		
		name = node.Identifier().getText();
		
		for (Struct_declarationContext decl : node.struct_declaration_list().struct_declaration())
			members.addAll(new StructDeclarationNode(this).interpret(decl).getMembers());
		
		ComponentNode.registerStructUnion(this);
		return this;
	}

	public int getSize()
	{
		return (int) Math.ceil(getSizeBits() / 8);
	}
	public int getSizeBits()
	{
		int sizeBits = 0;
		for (int i = 0; i < members.size(); ++i)
			if (isUnion) sizeBits = Math.max(sizeBits, members.get(i).getSizeBits());
			else sizeBits += members.get(i).getSizeBits();
		return sizeBits;
	}
	public boolean isUnion()
	{
		return isUnion;
	}
	public int getOffset(String memberName)
	{
		if (isUnion) return 0;
		int offset = 0;
		for (int i = 0; i < members.size(); ++i)
			if (members.get(i).getName().equals(memberName))
				return offset;
			else offset += members.get(i).getSizeBits();
		return 0;
	}
	public MemberNode getMember(String memberName)
	{
		for (int i = 0; i < members.size(); ++i)
			if (members.get(i).getName().equals(memberName)) return members.get(i);
		return null;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
}
