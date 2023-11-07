// Created by Iacon1 on 10/17/2023.
//
package Compiler.ComponentNodes.Declarations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.InterpretingNode;
import Compiler.ComponentNodes.Declarations.DirectDeclaratorNode.DirDeclaratorInfo;
import Grammar.C99.C99Parser.Abstract_declaratorContext;
import Grammar.C99.C99Parser.DeclaratorContext;
import Grammar.C99.C99Parser.Init_declaratorContext;
import Grammar.C99.C99Parser.Type_qualifierContext;
import Grammar.C99.C99Parser.Type_qualifier_listContext;

public class DeclaratorNode extends InterpretingNode<DeclaratorNode, DeclaratorContext>
{
	private List<Set<String>> pointerQualifiers;
	private DirectDeclaratorNode directDeclarator;
	
	public DeclaratorNode(ComponentNode<?> parent) {super(parent); pointerQualifiers = new LinkedList<Set<String>>();}
	public DeclaratorNode() {super(); pointerQualifiers = new LinkedList<Set<String>>();}
	
	@Override
	public DeclaratorNode interpret(DeclaratorContext node) throws Exception
	{
		// Get pointer(s)
		if (node.pointer() != null)
			for (int i = 0; i < node.pointer().getChildCount(); ++i)
				if (node.pointer().getChild(i).getText().equals("*")) // Start of a pointer level
					if (i < node.pointer().getChildCount() - 1) // Another after this
						if (!node.pointer().getChild(i + 1).getText().equals("*")) // Next one's not start of a pointer level
						{
							List<String> qualifiers = new LinkedList<String>();
							for (Type_qualifierContext qualifier : ((Type_qualifier_listContext) node.pointer().getChild(i + 1)).type_qualifier())
								qualifiers.add(qualifier.getText());
							pointerQualifiers.add(new HashSet<String>(qualifiers));
						}
						else pointerQualifiers.add(new HashSet<String>());
					else pointerQualifiers.add(new HashSet<String>());	
		
		directDeclarator = new DirectDeclaratorNode(this).interpret(node.direct_declarator());
		
		return this;
	}
	public DeclaratorNode interpret(Init_declaratorContext node) throws Exception
	{
		return interpret(node.declarator());
	}
	public DeclaratorNode interpret(Abstract_declaratorContext node) throws Exception
	{
		// Get pointer(s)
		if (node.pointer() != null)
		{
			for (Type_qualifier_listContext qualList : node.pointer().type_qualifier_list())
			{
				List<String> qualifiers = new LinkedList<String>();
				for (Type_qualifierContext qualifier : qualList.type_qualifier())
					qualifiers.add(qualifier.getText());
				pointerQualifiers.add(new HashSet<String>(qualifiers));
			}
		}
		
		directDeclarator = new DirectDeclaratorNode(this).interpret(node.direct_abstract_declarator());
		
		return this;
	}
	public String getIdentifier()
	{
		return directDeclarator.getIdentifier();
	}

	public List<Set<String>> pointerQualifiers()
	{
		if (pointerQualifiers == null) return null;
		List<Set<String>> qualifiers = new ArrayList<Set<String>>();
		for (Set<String> qualSet : pointerQualifiers)
			qualifiers.add(new HashSet<String>(qualSet));
		return qualifiers;
	}
	public List<DirDeclaratorInfo> getInfo()
	{
		return directDeclarator.getInfo();
	}

}
