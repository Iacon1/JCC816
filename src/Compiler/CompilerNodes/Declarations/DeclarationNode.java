// Created by Iacon1 on 10/290/2023.
//
package Compiler.CompilerNodes.Declarations;

import java.util.ArrayList;
import java.util.List;

import Compiler.CompilerNodes.Expressions.AssignmentExpressionNode;
import Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import Compiler.CompilerNodes.ComponentNode;
import Compiler.CompilerNodes.FunctionDefinitionNode;
import Compiler.CompilerNodes.Globals;
import Compiler.CompilerNodes.InterpretingNode;
import Compiler.CompilerNodes.Definitions.Type;
import Compiler.CompilerNodes.Interfaces.AssemblableNode;
import Compiler.CompilerNodes.LValues.VariableNode;
import Compiler.Exceptions.ConstraintException;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.OperandSources.ConstantSource;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.DeclarationContext;
import Grammar.C99.C99Parser.Assignment_expressionContext;
import Grammar.C99.C99Parser.Init_declaratorContext;
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
				
				if (specifiers.isTypedef())
				{
					Globals.registerTypedef(getScope().getPrefix() + declaratorNode.getIdentifier(), type);
				}
				else
				{
					VariableNode variable = new VariableNode(this, declaratorNode.getIdentifier(), type);
					Globals.registerVariable(variable);
					variables.add(variable);
				}
				
			}
		else
		{
			Type type = new Type(specifiers.getSpecifiers(), this, node.start);
			if (type.getSUEName() == null) // No tag
				throw new ConstraintException("6.7", 2, node.start);
		}
		return this;
	}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		for (BaseExpressionNode<?> expr : expressions) if (expr != null && expr.canCall(function)) return true;
		return false;
	}
	@Override
	public boolean hasAssembly()
	{
		for (BaseExpressionNode<?> expr : expressions) if (expr != null) return true;
		return false;
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String assembly = "";
		for (int i = 0; i < variables.size(); ++i)
			if (expressions.get(i) != null)
			{
				if (expressions.get(i).hasAssembly())
					assembly += expressions.get(i).getAssembly(leadingWhitespace, variables.get(i).getSource(), new DetailsTicket());
				else if (expressions.get(i).hasLValue())
					assembly += AssemblyUtils.byteCopier(AssemblyUtils.getWhitespace(leadingWhitespace), variables.get(i).getSize(), variables.get(i).getSource(), expressions.get(i).getLValue().getSource());
				else if (expressions.get(i).hasPropValue())
				{	
					OperandSource sourceN = new ConstantSource(expressions.get(i).getPropValue(), expressions.get(i).getSize());
					assembly += AssemblyUtils.byteCopier(AssemblyUtils.getWhitespace(leadingWhitespace), variables.get(i).getSize(), variables.get(i).getSource(), sourceN);
				}
				AssignmentExpressionNode.equateLValue(variables.get(i), expressions.get(i));
			}
				
		return assembly;
	}
}
