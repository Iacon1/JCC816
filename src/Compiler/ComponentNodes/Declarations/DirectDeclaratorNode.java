// Created by Iacon1 on 10/17/2023.
//
package Compiler.ComponentNodes.Declarations;

import java.util.ArrayList;
import java.util.List;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.InterpretingNode;
import Compiler.ComponentNodes.Expressions.AssignmentExpressionNode;
import Compiler.ComponentNodes.Expressions.BaseExpressionNode;
import Compiler.Exceptions.UnsupportedFeatureException;
import Grammar.C99.C99Parser.Direct_abstract_declaratorContext;
import Grammar.C99.C99Parser.Direct_declaratorContext;
import Grammar.C99.C99Parser.Parameter_declarationContext;
import Grammar.C99.C99Parser.Type_qualifierContext;

public class DirectDeclaratorNode extends InterpretingNode<DirectDeclaratorNode, Direct_declaratorContext>
{
	public static enum Type
	{
		identifier,
		declarator,
		array,
		varLenArray,
		funcParam,
		idList,
	}
	public static class DirDeclaratorInfo
	{
		public final Type type;
		
		public DirDeclaratorInfo(Type type)
		{
			this.type = type;
		}
		
		public String[] typeQualifiers;
		public BaseExpressionNode<?> assignExpr;
		public DeclarationNode[] paramDecls;
		public String[] idens;
	}
	
	private Type type;
	private DirDeclaratorInfo info;
	private DirectDeclaratorNode subDirDec;
	private DeclaratorNode subDec;
	
	private String identifier;
	
	public DirectDeclaratorNode(ComponentNode<?> parent) {super(parent);}
	public DirectDeclaratorNode() {super();}
	
	@Override
	public DirectDeclaratorNode interpret(Direct_declaratorContext node) throws Exception
	{
		if (node.Identifier() != null) // id
		{
			type = Type.identifier;
			identifier = node.Identifier().getText();
		}
		else if (node.declarator() != null) // dec
		{
			type = Type.declarator;
			subDec = new DeclaratorNode(this).interpret(node.declarator());
		}
		else if (node.parameter_type_list() != null) // Parameter list
		{
			type = Type.funcParam;
			info = new DirDeclaratorInfo(type);
			List<DeclarationNode> parameters = new ArrayList<DeclarationNode>();
			if (node.parameter_type_list() != null && node.parameter_type_list().parameter_list() != null)
			{
				for (Parameter_declarationContext paramDecl : node.parameter_type_list().parameter_list().parameter_declaration())
					parameters.add(new DeclarationNode(this).interpret(paramDecl));
			}
			info.paramDecls = parameters.toArray(new DeclarationNode[] {});
			subDirDec = new DirectDeclaratorNode(this).interpret(node.direct_declarator());
		}
		else if (node.identifier_list() != null) // Parameter list
		{
			type = Type.idList;
			subDirDec = new DirectDeclaratorNode(this).interpret(node.direct_declarator());
		}
		else // Array
		{
			type = Type.array;
			
			if ((node.getChild(node.getChildCount() - 2).getText() + node.getChild(node.getChildCount() - 1).getText()).equals("*]")) // VLA
				type = Type.varLenArray;
			info = new DirDeclaratorInfo(type);
			if (node.type_qualifier_list() != null)
			{
				List<String> typeQualifiers = new ArrayList<String>();
				for (Type_qualifierContext typeQualifier: node.type_qualifier_list().type_qualifier())
					typeQualifiers.add(typeQualifier.getText());
				info.typeQualifiers = typeQualifiers.toArray(new String[] {});
			}
			if (node.assignment_expression() != null)
				info.assignExpr = (BaseExpressionNode<?>) new AssignmentExpressionNode(this).interpret(node.assignment_expression());
			subDirDec = new DirectDeclaratorNode(this).interpret(node.direct_declarator());
			if (type == Type.varLenArray) // VLA not supported
				throw new UnsupportedFeatureException("Variable length arrays", false, node.start);
			if (info.assignExpr != null && !info.assignExpr.hasPropValue()) // Static allocation can't handle arrays whose size is unknown at compile time
				throw new UnsupportedFeatureException("Arrays of non-constant length", false, node.start);
		}
		return this;
	}
	public DirectDeclaratorNode interpret(Direct_abstract_declaratorContext node) throws Exception
	{
		if (node.declarator() != null) // dec
		{
			type = Type.declarator;
			subDec = new DeclaratorNode(this).interpret(node.declarator());
		}
		else if (node.parameter_type_list() != null) // Parameter list
		{
			type = Type.funcParam;
			info = new DirDeclaratorInfo(type);
			List<DeclarationNode> parameters = new ArrayList<DeclarationNode>();
			if (node.parameter_type_list() != null && node.parameter_type_list().parameter_list() != null)
			{
				for (Parameter_declarationContext paramDecl : node.parameter_type_list().parameter_list().parameter_declaration())
					parameters.add(new DeclarationNode(this).interpret(paramDecl));
			}
			info.paramDecls = parameters.toArray(new DeclarationNode[] {});
			subDirDec = new DirectDeclaratorNode(this).interpret(node.direct_abstract_declarator());
		}
		else if (node.identifier_list() != null) // Parameter list
		{
			type = Type.idList;
			subDirDec = new DirectDeclaratorNode(this).interpret(node.direct_abstract_declarator());
		}
		else // Array
		{
			type = Type.array;
			
			if ((node.getChild(node.getChildCount() - 2).getText() + node.getChild(node.getChildCount() - 1).getText()).equals("*]")) // VLA
				type = Type.varLenArray;
			info = new DirDeclaratorInfo(type);
			if (node.type_qualifier_list() != null)
			{
				List<String> typeQualifiers = new ArrayList<String>();
				for (Type_qualifierContext typeQualifier: node.type_qualifier_list().type_qualifier())
					typeQualifiers.add(typeQualifier.getText());
				info.typeQualifiers = typeQualifiers.toArray(new String[] {});
			}
			if (node.assignment_expression() != null)
				info.assignExpr = new AssignmentExpressionNode(this).interpret(node.assignment_expression());
			subDirDec = new DirectDeclaratorNode(this).interpret(node.direct_abstract_declarator());
			if (type == Type.varLenArray) // VLA not supported
				throw new UnsupportedFeatureException("Variable length arrays", false, node.start);
			if (info.assignExpr != null && !info.assignExpr.hasPropValue()) // Static allocation can't handle arrays whose size is unknown at compile time
				throw new UnsupportedFeatureException("Arrays of non-constant length", false, node.start);
		}
		return this;
	}
	public String getIdentifier()
	{
		if (subDirDec != null) return subDirDec.getIdentifier();
		else if (subDec != null) return subDec.getIdentifier();
		else return identifier;
	}
	
	public List<DirDeclaratorInfo> getInfo()
	{
		List<DirDeclaratorInfo> infoList = null;
		if (subDirDec != null)
			infoList = subDirDec.getInfo();
		else if (subDec != null)
			infoList = subDec.getInfo();
		else
			infoList = new ArrayList<DirDeclaratorInfo>();
		infoList.add(info);
		return infoList;
	}

}
