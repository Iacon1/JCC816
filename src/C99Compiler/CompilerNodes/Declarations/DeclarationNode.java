// Created by Iacon1 on 10/290/2023.
//
package C99Compiler.CompilerNodes.Declarations;

import java.util.ArrayList;
import java.util.List;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Interfaces.UnvaluedAssemblableNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.Exceptions.CompilerMultipleDefinitionException;
import C99Compiler.Exceptions.ConstraintException;
import C99Compiler.Utils.ProgramState;
import Grammar.C99.C99Parser.DeclarationContext;
import Grammar.C99.C99Parser.Init_declaratorContext;

public class DeclarationNode extends InterpretingNode<DeclarationNode, DeclarationContext> implements UnvaluedAssemblableNode
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
				else if (type.isFunction()) // Function definition
				{
					Exception innerException = new Exception();
					FunctionDefinitionNode oldFunction = checkRepeatFunctions((ComponentNode<?> c) -> {
						try {return new FunctionDefinitionNode(c).interpret(node.attributes_declaration(), node.declaration_specifiers(), initDeclarator.declarator());}
						catch (Exception e) {innerException.addSuppressed(e); return null;}});
					if (innerException.getSuppressed().length > 0) throw (Exception) innerException.getSuppressed()[0]; // Weird hack I know

					if (oldFunction == null) // Ignore subsequent identical declarations without definitions
					{
						removeChild(declaratorNode);
						new FunctionDefinitionNode(this).interpret(node.attributes_declaration(), node.declaration_specifiers(), initDeclarator.declarator());
					}
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
			Type type = Type.manufactureCtxt(specifiers.getSpecifiers(), this, node.start);
			if (type.getSUEName() == null) // No tag
				throw new ConstraintException("6.7", 2, node.start);
		}
		return this;
	}
	
	@Override
	public boolean canCall(ProgramState state, FunctionDefinitionNode function)
	{
		for (InitializerNode initializer : initializers) if (
				initializer != null &&
				initializer.hasAssembly(state) &&
				initializer.canCall(state, function)) return true;
		return false;
	}
	@Override
	public boolean hasAssembly(ProgramState state)
	{
		for (InitializerNode initializer : initializers) if (
				initializer != null &&
				initializer.hasAssembly(state)) return true;
		return false;
	}
	
	@Override
	public ProgramState getStateBefore(ProgramState state, ComponentNode<?> child) throws Exception
	{
		if (!children.contains(child))
			throw new IllegalArgumentException();

		for (InitializerNode initializer : initializers)
		{
			if (child == initializer)
				break;
			state = initializer.getStateAfter(state);
		}
		return state;
	}
	
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		AssemblyStatePair tmpPair;
		
		String assembly = "";
		for (InitializerNode initializer : initializers)
		{
			tmpPair = initializer.getAssemblyAndState(state);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
		}
				
		return new AssemblyStatePair(assembly, state);
	}
}
