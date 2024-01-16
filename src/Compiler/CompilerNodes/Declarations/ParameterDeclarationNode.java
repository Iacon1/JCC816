// Created by Iacon1 on 10/290/2023.
//
package Compiler.CompilerNodes.Declarations;

import java.util.ArrayList;
import java.util.List;

import Compiler.CompilerNodes.Expressions.AssignmentExpressionNode;
import Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import Compiler.CompilerNodes.ComponentNode;
import Compiler.CompilerNodes.FunctionDefinitionNode;
import Compiler.CompilerNodes.InterpretingNode;
import Compiler.CompilerNodes.Definitions.Scope;
import Compiler.CompilerNodes.Definitions.Type;
import Compiler.CompilerNodes.Dummies.DummyVariableNode;
import Compiler.CompilerNodes.Interfaces.AssemblableNode;
import Compiler.CompilerNodes.LValues.VariableNode;
import Compiler.Exceptions.ConstraintException;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.OperandSources.ConstantSource;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Abstract_declaratorContext;
import Grammar.C99.C99Parser.DeclarationContext;
import Grammar.C99.C99Parser.DeclaratorContext;
import Grammar.C99.C99Parser.Assignment_expressionContext;
import Grammar.C99.C99Parser.Init_declaratorContext;
import Grammar.C99.C99Parser.Parameter_declarationContext;
import Grammar.C99.C99Parser.Struct_declarationContext;
import Grammar.C99.C99Parser.Struct_declaratorContext;

public class ParameterDeclarationNode extends InterpretingNode<ParameterDeclarationNode, Parameter_declarationContext>
{
	private List<VariableNode> variables;
	private String scope;
	
	public ParameterDeclarationNode(ComponentNode<?> parent, String scope)
	{
		super(parent);
		variables = new ArrayList<VariableNode>();
		this.scope = scope;
	}
	public ParameterDeclarationNode(ComponentNode<?> parent)
	{
		super(parent);
		variables = new ArrayList<VariableNode>();
	}
	
	public ParameterDeclarationNode interpret(Parameter_declarationContext node) throws Exception
	{
		DeclarationSpecifiersNode specifiers = new DeclarationSpecifiersNode(this).interpret(node.declaration_specifiers());
		DeclaratorContext declarator = node.declarator();
		Abstract_declaratorContext absDeclarator = node.abstract_declarator();
		if (declarator != null)
		{
			DeclaratorNode declaratorNode = new DeclaratorNode(this).interpret(declarator);
			Type type = Type.manufacture(specifiers.getSpecifiers(), declaratorNode, declarator.start);
			VariableNode variable = new VariableNode(this, declaratorNode.getIdentifier(), type);
			variables.add(variable);
		}
		else if (absDeclarator != null)
		{
			DeclaratorNode declaratorNode = new DeclaratorNode(this).interpret(absDeclarator);
			Type type = Type.manufacture(specifiers.getSpecifiers(), declaratorNode, absDeclarator.start);
			VariableNode variable = new VariableNode(this, declaratorNode.getIdentifier(), type);
//			registerVariable(variable);
			variables.add(variable);
		}
		else // No actual variables
		{
			Type type = new Type(specifiers.getSpecifiers(), this, node.start);
			DummyVariableNode variable = new DummyVariableNode(this, type);
			variables.add(variable);
		}
		return this;
	}
	
	@Override
	public Scope getScope()
	{
		if (scope != null && parent != null) return parent.getScope().append(scope);
		else if (scope != null) return new Scope().append(scope);
		else return super.getScope();
	}
}