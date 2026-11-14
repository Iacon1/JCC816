// Created by Iacon1 on 10/29/2023.
//
package C99Compiler.CompilerNodes.Declarations;

import java.util.ArrayList;
import java.util.List;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Interfaces.UnvaluedAssemblableNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.Exceptions.CompilerMultipleDefinitionException;
import C99Compiler.Exceptions.ConstraintException;
import C99Compiler.ProgramState.ProgramState;
import C99Compiler.Utils.OperandSources.ConstantSource;
import Grammar.C99.C99Parser.DeclarationContext;
import Grammar.C99.C99Parser.Init_declaratorContext;

public class DeclarationNode extends InterpretingNode<DeclarationNode, DeclarationContext> implements UnvaluedAssemblableNode
{
	public static class InitDeclaratorPair
	{
		public final VariableNode var;
		public final InitializerNode init;
		
		public InitDeclaratorPair(VariableNode var, InitializerNode init)
		{
			this.var = var;
			this.init = init;
		}
		
		public boolean isROM(ProgramState state)
		{
			if (this.init == null) return false;
			
			if (!this.var.getType().isROM()) return false;
			
			if (!this.init.hasPropValue(state)) return false;
			
			return true;
		}

		public String getROMAssembly(ProgramState state)
		{
			String whitespace = state.getWhitespace();
			int size = var.getSize();
			if (init.checkStringLiteral() &&
					var.getType().isPointer() && (
						!var.getType().isArray() ||
						var.getType().isIncomplete()
					))
				size = init.checkStringLiteralSize();
			
			ConstantSource source = new ConstantSource(init.getPropValue(state), size);
			String assembly = whitespace + var.getFullName() + ":";
			whitespace = state.indent().getWhitespace();
			for (int i = 0; i < source.getSize(); ++i)
			{
				if (i % CompConfig.bytesPerDataLine == 0) // New line needed
					assembly += "\n" + whitespace + ".byte\t";
				assembly += source.getBase(state, i).replace("#", "");
				if (i != source.getSize() - 1 && (i + 1) % CompConfig.bytesPerDataLine != 0)
					assembly += ", "; // There will be another and on the same line
			}
			assembly += "\n";
			return assembly;
		}
	}
	private List<InitDeclaratorPair> initDeclPairs;
	public DeclarationNode(ComponentNode<?> parent)
	{
		super(parent);
		initDeclPairs = new ArrayList<InitDeclaratorPair>();
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
						throw new CompilerMultipleDefinitionException(declaratorNode.getIdentifier(), initDeclarator.start, this); // Two variables cannot have same full name
					VariableNode variable = new VariableNode(this, declaratorNode.getIdentifier(), type);
					InitializerNode initializer = null;
					if (initDeclarator.initializer() != null)
						initializer = new InitializerNode(this, variable.getType()).interpret(initDeclarator.initializer());

					initDeclPairs.add(new InitDeclaratorPair(variable, initializer));
				}
				
			}
		else
		{
			Type type = Type.manufactureCtxt(specifiers.getSpecifiers(), this, node.start);
			if (type.getSUEName() == null) // No tag
				throw new ConstraintException("6.7", 2, node.start, this);
		}
		return this;
	}
	
	@Override
	public boolean canCall(ProgramState state, FunctionDefinitionNode function)
	{
		for (InitDeclaratorPair initDeclPair : initDeclPairs)
		{
			InitializerNode initializer = initDeclPair.init;
			if (
				initializer != null &&
				initializer.hasAssembly(state) &&
				initializer.canCall(state, function)) return true;
		}
		return false;
	}
	@Override
	public boolean hasAssembly(ProgramState state)
	{
		for (InitDeclaratorPair initDeclPair : initDeclPairs)
		{
			if (
					initDeclPair.init != null) return true;
		}
		return false;
	}
	
	@Override
	public ProgramState getStateBefore(ProgramState state, ComponentNode<?> child) throws Exception
	{
		if (!children.contains(child))
			throw new IllegalArgumentException();

		for (InitDeclaratorPair initDeclPair : initDeclPairs)
		{
			if (child == initDeclPair.init)
				break;
			state = initDeclPair.init.getStateAfter(state);
		}
		return state;
	}
	
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		AssemblyStatePair tmpPair;
		
		String assembly = "";
		
		for (InitDeclaratorPair initDeclPair : initDeclPairs)
		{
			if (initDeclPair.init == null) continue;
			
			state = state.setDestSource(initDeclPair.var.getSource());
			tmpPair = initDeclPair.init.getAssemblyAndState(state);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
		}
				
		return new AssemblyStatePair(assembly, state);
	}
	
	public List<InitDeclaratorPair> getInitDeclarators()
	{
		return new ArrayList<InitDeclaratorPair>(initDeclPairs);
	}
}
