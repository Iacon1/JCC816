// Created by Iacon1 on 10/17/2023.
//
package C99Compiler.CompilerNodes.Declarations;

import java.util.ArrayList;
import java.util.List;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Declarations.DeclaratorNode.DeclaratorInfo;
import C99Compiler.CompilerNodes.Declarations.DeclaratorNode.DeclaratorType;
import C99Compiler.CompilerNodes.Expressions.AssignmentExpressionNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.Exceptions.UnsupportedFeatureException;
import Grammar.C99.C99Parser.Direct_abstract_declaratorContext;
import Grammar.C99.C99Parser.Direct_declaratorContext;
import Grammar.C99.C99Parser.Parameter_declarationContext;
import Grammar.C99.C99Parser.Type_qualifierContext;

public class DirectDeclaratorNode extends InterpretingNode<DirectDeclaratorNode, Direct_declaratorContext>
{	
	private DeclaratorType type;
	private DeclaratorInfo info;
	private DirectDeclaratorNode subDirDec;
	private DeclaratorNode subDec;
	
	private String identifier;
	private String scopeOverride;
	
	/**
	 * 
	 * @param parent
	 * @param scopeOverride If any parameters are defined in this, this determines what scope to give them (in addition to this node's scope)
	 */
	public DirectDeclaratorNode(ComponentNode<?> parent, String scopeOverride)
	{
		super(parent);
		this.scopeOverride = scopeOverride;
	}

	@Override
	public DirectDeclaratorNode interpret(Direct_declaratorContext node) throws Exception
	{
		if (node.Identifier() != null) // id
		{
			type = DeclaratorType.identifier;
			identifier = node.Identifier().getText();
		}
		else if (node.declarator() != null) // dec
		{
			type = DeclaratorType.declarator;
			subDec = new DeclaratorNode(this, scopeOverride).interpret(node.declarator());
		}
		else if (node.getChild(1).getText().equals("(")) // Parameter list
		{
			type = DeclaratorType.funcParam;
			info = new DeclaratorInfo(type);
			List<ParameterDeclarationNode> parameters = new ArrayList<ParameterDeclarationNode>();
			if (node.parameter_type_list() != null && node.parameter_type_list().parameter_list() != null)
			{
				for (Parameter_declarationContext paramDecl : node.parameter_type_list().parameter_list().parameter_declaration())
					parameters.add(new ParameterDeclarationNode(this, scopeOverride).interpret(paramDecl));
			}
			info.paramDecls = parameters.toArray(new ParameterDeclarationNode[] {});
			subDirDec = new DirectDeclaratorNode(this, scopeOverride).interpret(node.direct_declarator());
		}
		else if (node.getChild(1).getText().equals("["))// Array
		{
			type = DeclaratorType.array;
			
			if (node.getText().endsWith("*]")) // VLA
			
			if ((node.getChild(node.getChildCount() - 2).getText() + node.getChild(node.getChildCount() - 1).getText()).equals("*]")) // VLA
				type = DeclaratorType.varLenArray;
			info = new DeclaratorInfo(type);
			if (node.type_qualifier_list() != null)
			{
				List<String> typeQualifiers = new ArrayList<String>();
				for (Type_qualifierContext typeQualifier: node.type_qualifier_list().type_qualifier())
					typeQualifiers.add(typeQualifier.getText());
				info.typeQualifiers = typeQualifiers.toArray(new String[] {});
			}
			if (node.assignment_expression() != null)
				info.assignExpr = (BaseExpressionNode<?>) new AssignmentExpressionNode(this).interpret(node.assignment_expression());
			subDirDec = new DirectDeclaratorNode(this, scopeOverride).interpret(node.direct_declarator());
			if (type == DeclaratorType.varLenArray) // VLA not supported
				throw new UnsupportedFeatureException("Variable length arrays", false, node.start);
			if (info.assignExpr != null && !info.assignExpr.hasPropValue()) // Static allocation can't handle arrays whose size is unknown at compile time
				throw new UnsupportedFeatureException("Arrays of non-constant length", false, node.start);
		}
		return this;
	}
	public DirectDeclaratorNode interpret(Direct_abstract_declaratorContext node) throws Exception
	{
		if (node.abstract_declarator() != null) // dec
		{
			type = DeclaratorType.declarator;
			subDec = new DeclaratorNode(this, scopeOverride).interpret(node.abstract_declarator());
		}
		else
		{
			if (node.getChild(1).getText().equals("(")) // Parameter list
			{
				type = DeclaratorType.funcParam;
				info = new DeclaratorInfo(type);
				List<ParameterDeclarationNode> parameters = new ArrayList<ParameterDeclarationNode>();
				if (node.parameter_type_list() != null && node.parameter_type_list().parameter_list() != null)
				{
					for (Parameter_declarationContext paramDecl : node.parameter_type_list().parameter_list().parameter_declaration())
						parameters.add(new ParameterDeclarationNode(this, scopeOverride).interpret(paramDecl));
				}
				info.paramDecls = parameters.toArray(new ParameterDeclarationNode[] {});
			}
			else if (node.getChild(1).getText().equals("["))// Array
			{
				type = DeclaratorType.array;
				
				if (node.getText().endsWith("*]")) // VLA
					type = DeclaratorType.varLenArray;
				info = new DeclaratorInfo(type);
				if (node.type_qualifier_list() != null)
				{
					List<String> typeQualifiers = new ArrayList<String>();
					for (Type_qualifierContext typeQualifier: node.type_qualifier_list().type_qualifier())
						typeQualifiers.add(typeQualifier.getText());
					info.typeQualifiers = typeQualifiers.toArray(new String[] {});
				}
				if (node.assignment_expression() != null)
					info.assignExpr = new AssignmentExpressionNode(this).interpret(node.assignment_expression());
				subDirDec = new DirectDeclaratorNode(this, scopeOverride).interpret(node.direct_abstract_declarator());
				if (type == DeclaratorType.varLenArray) // VLA not supported
					throw new UnsupportedFeatureException("Variable length arrays", false, node.start);
				if (info.assignExpr != null && !info.assignExpr.hasPropValue()) // Static allocation can't handle arrays whose size is unknown at compile time
					throw new UnsupportedFeatureException("Arrays of non-constant length", false, node.start);
			}
			if (node.direct_abstract_declarator() != null)
				subDirDec = new DirectDeclaratorNode(this, scopeOverride).interpret(node.direct_abstract_declarator());
		}
		return this;
	}
	public String getIdentifier()
	{
		if (subDirDec != null) return subDirDec.getIdentifier();
		else if (subDec != null) return subDec.getIdentifier();
		else return identifier;
	}
	
	public List<DeclaratorInfo> getInfo()
	{
		List<DeclaratorInfo> infoList = new ArrayList<DeclaratorInfo>();
		if (subDirDec != null)
			infoList.addAll(subDirDec.getInfo());
		if (subDec != null)
			infoList.addAll(subDec.getInfo());
		if (info != null) infoList.add(0, info);
		
		return infoList;
	}

}
