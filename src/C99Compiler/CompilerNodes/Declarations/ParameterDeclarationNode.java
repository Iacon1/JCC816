// Created by Iacon1 on 10/290/2023.
//
package C99Compiler.CompilerNodes.Declarations;

import java.util.ArrayList;
import java.util.List;

import C99Compiler.CompilerNodes.Expressions.AssignmentExpressionNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Definitions.Scope;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyVariableNode;
import C99Compiler.CompilerNodes.Interfaces.AssemblableNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.Exceptions.CompilerMultipleDefinitionException;
import C99Compiler.Exceptions.ConstraintException;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
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
			if (checkRepeatVariables((ComponentNode<?> c) -> new VariableNode(c, declaratorNode.getIdentifier(), type)) != null)
				throw new CompilerMultipleDefinitionException(declaratorNode.getIdentifier(), declarator.start); // Two variables cannot have same full name
			VariableNode variable = new VariableNode(this, declaratorNode.getIdentifier(), type);
			variables.add(variable);
		}
		else if (absDeclarator != null)
		{
			DeclaratorNode declaratorNode = new DeclaratorNode(this).interpret(absDeclarator);
			Type type = Type.manufacture(specifiers.getSpecifiers(), declaratorNode, absDeclarator.start);
			if (checkRepeatVariables((ComponentNode<?> c) -> new VariableNode(c, declaratorNode.getIdentifier(), type)) != null)
				throw new CompilerMultipleDefinitionException(declaratorNode.getIdentifier(), absDeclarator.start); // Two variables cannot have same full name
			VariableNode variable = new VariableNode(this, declaratorNode.getIdentifier(), type);
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
