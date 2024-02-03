// Created by Iacon1 on 10/17/2023.
//
package C99Compiler.CompilerNodes.Declarations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import Grammar.C99.C99Parser.Abstract_declaratorContext;
import Grammar.C99.C99Parser.DeclaratorContext;
import Grammar.C99.C99Parser.Init_declaratorContext;
import Grammar.C99.C99Parser.Type_qualifierContext;
import Grammar.C99.C99Parser.Type_qualifier_listContext;

public class DeclaratorNode extends InterpretingNode<DeclaratorNode, DeclaratorContext>
{
	public static enum DeclaratorType
	{
		identifier,
		declarator,
		array,
		varLenArray,
		funcParam,
		
		pointer;
	}
	public static class DeclaratorInfo implements Serializable
	{
		public final DeclaratorType type;
		
		public DeclaratorInfo(DeclaratorType type)
		{
			this.type = type;
		}
		
		public Set<String> pointerQualifiers;
		public String[] typeQualifiers;
		public BaseExpressionNode<?> assignExpr;
		public ParameterDeclarationNode[] paramDecls;
		public String[] idens;
	}
	
	private List<Set<String>> pointerQualifiers;
	private DirectDeclaratorNode directDeclarator;
	private String scopeOverride;
	
	/**
	 * 
	 * @param parent
	 * @param scopeOverride If any parameters are defined in this, this determines what scope to give them (in addition to this node's scope)
	 */
	public DeclaratorNode(ComponentNode<?> parent, String scopeOverride)
	{
		super(parent);
		pointerQualifiers = new LinkedList<Set<String>>();
		this.scopeOverride = scopeOverride;
	}
	public DeclaratorNode(ComponentNode<?> parent)
	{
		super(parent);
		pointerQualifiers = new LinkedList<Set<String>>();
		this.scopeOverride = null;
	}
	
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
		
		directDeclarator = new DirectDeclaratorNode(this, scopeOverride).interpret(node.direct_declarator());
		
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
			if (pointerQualifiers.isEmpty()) // Blank pointer
				pointerQualifiers.add(new HashSet<String>());
		}
		
		if (node.direct_abstract_declarator() != null)
			directDeclarator = new DirectDeclaratorNode(this, scopeOverride).interpret(node.direct_abstract_declarator());
		
		return this;
	}
	public String getIdentifier()
	{
		if (directDeclarator != null)
			return directDeclarator.getIdentifier();
		else return null;
	}

	public List<Set<String>> pointerQualifiers()
	{
		if (pointerQualifiers == null) return null;
		List<Set<String>> qualifiers = new ArrayList<Set<String>>();
		for (Set<String> qualSet : pointerQualifiers)
			qualifiers.add(new HashSet<String>(qualSet));
		return qualifiers;
	}
	public List<DeclaratorInfo> getInfo()
	{
		List<DeclaratorInfo> info;
		if (directDeclarator != null)
			info = directDeclarator.getInfo();
		else  info = new LinkedList<DeclaratorInfo>();
		for (Set<String> set : pointerQualifiers)
		{
			DeclaratorInfo newInfo = new DeclaratorInfo(DeclaratorType.pointer);
			newInfo.pointerQualifiers = new HashSet<String>();
			newInfo.pointerQualifiers.addAll(set);
			info.add(0, newInfo);
		}
		
		return info;
	}

}
