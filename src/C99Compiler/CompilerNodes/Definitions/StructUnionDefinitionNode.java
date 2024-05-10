// Created by Iacon1 on 10/19/2023.
//
package C99Compiler.CompilerNodes.Definitions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Declarations.StructDeclarationNode;
import C99Compiler.CompilerNodes.Interfaces.NamedNode;
import C99Compiler.CompilerNodes.LValues.MemberNode;
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
		
		if (node.Identifier() != null) name = node.Identifier().getText();
		else
			name = "__" + UUID.randomUUID() + "struct";
		for (Struct_declarationContext decl : node.struct_declaration_list().struct_declaration())
			members.addAll(new StructDeclarationNode(this).interpret(decl).getMembers());

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
	public int getOffsetBits(String memberName)
	{
		if (isUnion) return 0;
		int offset = 0;
		for (int i = 0; i < members.size(); ++i)
			if (members.get(i).getName().equals(memberName))
				return offset;
			else
			{
				if (members.get(i).getType().isTwice()) offset += 8;
				else offset += members.get(i).getSizeBits();
			}
		return 0;
	}
	public int getOffset(String memberName)
	{
		return (int) Math.floor( getOffsetBits(memberName) / 8);
	}
	public List<String> getMemberNames()
	{
		List<String> memberNames = new ArrayList<String>();
		for (int i = 0; i < members.size(); ++i)
			memberNames.add(members.get(i).getName());
		
		return memberNames;
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
