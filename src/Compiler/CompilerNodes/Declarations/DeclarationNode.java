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
import Compiler.CompilerNodes.Definitions.Type;
import Compiler.CompilerNodes.Interfaces.AssemblableNode;
import Compiler.CompilerNodes.LValues.VariableNode;
import Compiler.Exceptions.CompilerMultipleDefinitionException;
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
	private List<InitializerNode> initializers;
	
	public DeclarationNode(ComponentNode<?> parent)
	{
		super(parent);
		variables = new ArrayList<VariableNode>();
		initializers = new ArrayList<InitializerNode>();
	}

	@Override
	public DeclarationNode interpret(DeclarationContext node) throws Exception
	{
		DeclarationSpecifiersNode specifiers = new DeclarationSpecifiersNode(this).interpret(node.declaration_specifiers());
		if (node.init_declarator_list() != null)
			for (Init_declaratorContext initDeclarator : node.init_declarator_list().init_declarator())
			{
				DeclaratorNode declaratorNode = new DeclaratorNode(this).interpret(initDeclarator);
				
				Type type = Type.manufacture(specifiers.getSpecifiers(), declaratorNode, initDeclarator.start);
				
				if (specifiers.isTypedef())
				{
					getTranslationUnit().registerTypedef(getScope().getPrefix() + declaratorNode.getIdentifier(), type);
				}
				if (type.isFunction()) // Function definition
				{
					Exception innerException = new Exception();
					FunctionDefinitionNode oldFunction = checkRepeatFunctions((ComponentNode<?> c) -> {
						try {return new FunctionDefinitionNode(c).interpret(node.declaration_specifiers(), initDeclarator.declarator());}
						catch (Exception e) {innerException.addSuppressed(e); return null;}});
					if (innerException.getSuppressed().length > 0) throw (Exception) innerException.getSuppressed()[0]; // Weird hack I know

					if (oldFunction == null) // Ignore subsequent identical declarations without definitions
						new FunctionDefinitionNode(this).interpret(node.declaration_specifiers(), initDeclarator.declarator());
				}
				else
				{
					if (checkRepeatVariables((ComponentNode<?> c) -> new VariableNode(c, declaratorNode.getIdentifier(), type)) != null)
						throw new CompilerMultipleDefinitionException(declaratorNode.getIdentifier(), initDeclarator.start); // Two variables cannot have same full name
					VariableNode variable = new VariableNode(this, declaratorNode.getIdentifier(), type);
					variables.add(variable);
					if (initDeclarator.initializer() != null)
						initializers.add(new InitializerNode(this, variable).interpret(initDeclarator.initializer()));
					else initializers.add(new InitializerNode(this, variable));
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
		for (InitializerNode initializer : initializers) if (
				initializer != null &&
				initializer.hasAssembly() &&
				initializer.canCall(function)) return true;
		return false;
	}
	@Override
	public boolean hasAssembly()
	{
		for (InitializerNode initializer : initializers) if (
				initializer != null &&
				initializer.hasAssembly()) return true;
		return false;
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String assembly = "";
		for (InitializerNode initializer : initializers)
			if (initializer.hasAssembly()) assembly += initializer.getAssembly(leadingWhitespace);
				
		return assembly;
	}
}
