// By Iacon1
// Created 05/11/2023
//
package Compiler.ComponentNodes;

import Grammar.C99.C99Parser.Attributes_declarationContext;
import Grammar.C99.C99Parser.Function_definitionContext;
import Logging.Logging;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.tree.TerminalNode;

import Compiler.ComponentNodes.Declarations.DeclarationNode;
import Compiler.ComponentNodes.Declarations.DeclarationSpecifiersNode;
import Compiler.ComponentNodes.Declarations.DeclaratorNode;
import Compiler.ComponentNodes.Definitions.FunctionType;
import Compiler.ComponentNodes.Definitions.Scope;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Compiler.ComponentNodes.Interfaces.NamedNode;
import Compiler.ComponentNodes.Interfaces.TypedNode;
import Compiler.ComponentNodes.LValues.VariableNode;
import Compiler.ComponentNodes.Statements.CompoundStatementNode;
import Compiler.ComponentNodes.Statements.StatementNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompConfig;
import Compiler.Utils.CompUtils;

public class FunctionDefinitionNode extends InterpretingNode<FunctionDefinitionNode, Function_definitionContext> implements NamedNode, TypedNode, AssemblableNode
{
	private Set<String> attributes;
	private DeclarationSpecifiersNode.DeclSpecifiers specifiers;
	private Type type;
	private DeclaratorNode signature;
	
	private StatementNode<?> code;
	
	public FunctionDefinitionNode(ComponentNode<?> parent)
	{
		super(parent);
		attributes = new HashSet<String>();
	}

	@Override
	public FunctionDefinitionNode interpret(Function_definitionContext node) throws Exception
	{
		for (Attributes_declarationContext attributes_declaration : node.attributes_declaration())
			for (TerminalNode attribute : attributes_declaration.identifier_list().Identifier())
				attributes.add(attribute.toString());

		specifiers = new DeclarationSpecifiersNode(this).interpret(node.declaration_specifiers()).getSpecifiers();
		signature = new DeclaratorNode(this).interpret(node.declarator());

		type = Type.manufacture(specifiers, signature, node.declaration_specifiers().start);
		Logging.logNotice(signature.getIdentifier());

		if (node.compound_statement() != null) code = new CompoundStatementNode(this).interpret(node.compound_statement());
		registerFunction(this);
		return this;
	}

	@Override
	public String getName() {return signature.getIdentifier();}
	@Override
	public Scope getScope()
	{
		return super.getScope().append(getName());
	}
	@Override
	public String getFullName()
	{
		return super.getScope().getPrefix() + getName();
	}

	public List<VariableNode> getParameters()
	{
		return signature.getChildVariables();
	}
	public String getLabel(String gotoLabel)
	{
		return "__" + getFullName() + CompConfig.scopeDelimiter + gotoLabel;
	}
	public String getEndLabel()
	{
		return "__" + getFullName() + "_END";
	}

	public boolean isInterruptHandler()
	{
		return attributes.contains(CompUtils.Attributes.interrupt);
	}

	@Override
	public FunctionType getType()
	{
		return new FunctionType(type);
	}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return code.canCall(function) || (function == this);
	}
	
	@Override
	public boolean hasAssembly()
	{
		return true; // Always there as a label
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
	
		assembly += whitespace + getFullName() + ":\n";
		if (code != null) assembly += code.getAssembly(leadingWhitespace + CompConfig.indentSize);
		assembly += whitespace + getEndLabel() + ": " + (isInterruptHandler() && attributes.contains(CompUtils.Attributes.noISR) ? "RTI\n" : "RTL") + "\n";
		return assembly;
	}

	
}
