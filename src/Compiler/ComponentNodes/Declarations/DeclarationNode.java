// Created by Iacon1 on 10/290/2023.
//
package Compiler.ComponentNodes.Declarations;

import java.util.ArrayList;
import java.util.List;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.Expressions.AssignmentExpressionNode;
import Compiler.ComponentNodes.Expressions.BaseExpressionNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.InterpretingNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Compiler.ComponentNodes.LValues.VariableNode;
import Compiler.Exceptions.ConstraintException;
import Compiler.Utils.AssemblyUtils;
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

public class DeclarationNode extends InterpretingNode<DeclarationNode, DeclarationContext> implements AssemblableNode
{
	private List<VariableNode> variables;
	private List<BaseExpressionNode<?>> expressions;
	
	public DeclarationNode(ComponentNode<?> parent)
	{
		super(parent);
		variables = new ArrayList<VariableNode>();
		expressions = new ArrayList<BaseExpressionNode<?>>();
	}

	@Override
	public DeclarationNode interpret(DeclarationContext node) throws Exception
	{
		DeclarationSpecifiersNode specifiers = new DeclarationSpecifiersNode(this).interpret(node.declaration_specifiers());
		if (node.init_declarator_list() != null)
			for (Init_declaratorContext initDeclarator : node.init_declarator_list().init_declarator())
			{
				if (initDeclarator.initializer() != null)
				{
					Assignment_expressionContext expr = (Assignment_expressionContext) initDeclarator.initializer().assignment_expression();
					expressions.add((BaseExpressionNode<?>) new AssignmentExpressionNode(this).interpret(expr));
				}
				else expressions.add(null);
				DeclaratorNode declaratorNode = new DeclaratorNode(this).interpret(initDeclarator);
				Type type = Type.manufacture(specifiers.getSpecifiers(), declaratorNode, initDeclarator.start);
				VariableNode variable = new VariableNode(this, declaratorNode.getIdentifier(), type);
				registerVariable(variable);
				variables.add(variable);
			}
		else throw new ConstraintException("6.7", 2, node.start);
		return this;
	}
	public DeclarationNode interpret(Parameter_declarationContext node) throws Exception
	{
		DeclarationSpecifiersNode specifiers = new DeclarationSpecifiersNode(this).interpret(node.declaration_specifiers());
		DeclaratorContext declarator = node.declarator();
		Abstract_declaratorContext absDeclarator = node.abstract_declarator();
		if (declarator != null)
		{
			DeclaratorNode declaratorNode = new DeclaratorNode(this).interpret(declarator);
			Type type = Type.manufacture(specifiers.getSpecifiers(), declaratorNode, declarator.start);
			VariableNode variable = new VariableNode(this, declaratorNode.getIdentifier(), type);
			registerVariable(variable);
			variables.add(variable);
		}
		else if (absDeclarator != null)
		{
			DeclaratorNode declaratorNode = new DeclaratorNode(this).interpret(absDeclarator);
			Type type = Type.manufacture(specifiers.getSpecifiers(), declaratorNode, absDeclarator.start);
			VariableNode variable = new VariableNode(this, declaratorNode.getIdentifier(), type);
			registerVariable(variable);
			variables.add(variable);
		}
		return this;
	}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		for (BaseExpressionNode<?> expr : expressions) if (expr.canCall(function)) return true;
		return false;
	}
	@Override
	public boolean hasAssembly()
	{
		return expressions.size() != 0;
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String assembly = "";
		for (int i = 0; i < variables.size(); ++i)
			if (expressions.get(i) != null)
			{
				if (!expressions.get(i).hasPropValue()) assembly += expressions.get(i).getAssembly(leadingWhitespace, variables.get(i).getSource());
				else
				{	
					OperandSource sourceN = new ConstantSource(expressions.get(i).getPropValue(), expressions.get(i).getSize());
					assembly += AssemblyUtils.byteCopier(AssemblyUtils.getWhitespace(leadingWhitespace), variables.get(i).getSize(), variables.get(i).getSource(), sourceN);
					
				}
			}
				
		return assembly;
	}
}