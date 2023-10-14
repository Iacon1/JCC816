// By Iacon1
// Created 05/11/2023
//
package Compiler.ComponentNodes;

import Grammar.GeneralParser.GeneralNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Compiler.CompConfig;
import Compiler.Compiler;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Compiler.ComponentNodes.Interfaces.NamedNode;
import Compiler.ComponentNodes.Interfaces.TypedNode;

public class FunctionNode extends ComponentNode<FunctionNode> implements NamedNode, TypedNode, AssemblableNode
{
	private String returnType;
	private String name;
	private StatementNode code;
	private Set<String> attributes;
	
	public FunctionNode(ComponentNode<?> parent) {super(parent); attributes = new HashSet<String>();}

	@Override
	public FunctionNode interpret(GeneralNode<String, String> node) throws Exception
	{
		returnType = node.getT(0);
		name = node.getT(1);
		
		int statementIndex = 0; // Where's the statement?
		switch (Compiler.getType(node.getNode(0).ruleName))
		{
		case varDeclaration: // We have parameters
			statementIndex = 1;
			break;
		default: // ???
			break;
		}
		code = new StatementNode(this).interpret(node.getNode(statementIndex));
		return this;
	}
	
	@Override
	public Map<String, FunctionNode> functions()
	{
		Map<String, FunctionNode> functions = super.functions();
		if (name != null) functions.put(getFullName(), this);
		
		return functions;
	}
	public String[] getScope()
	{
		if (parent != null && parent.getScope() != null)
		{
			String[] scope = Arrays.copyOf(parent.getScope(), parent.getScope().length + 1);
			scope[scope.length - 1] = name;
			return scope;
		}
		else return new String[] {name};
	}

	@Override
	public String getName() {return name;}
	
	@Override
	public String getFullName() {return parent.getScopePrefix() + getName();}

	@Override
	public String getTypeName()
	{
		return returnType;
	}

	@Override
	public TypeNode getType()
	{
		return resolveType(returnType);
	}
	
	public List<VarDeclarationNode> getParameters()
	{
		return null;
	}
	
	public String getEndLabel()
	{
		return "__" + getFullName() + "_END";
	}

	public void addAttribute(String attribute)
	{
		attributes.add(attribute);
	}
	public boolean isInterruptHandler()
	{
		return attributes.contains(CompConfig.Attributes.interrupt);
	}

	@Override
	public boolean canCall(FunctionNode function)
	{
		return code.canCall(function) || (function == this);
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String whitespace = getWhitespace(leadingWhitespace);
		String assembly = "";
	
		assembly += whitespace + getFullName() + ": \n";
		if (code != null) assembly += code.getAssembly(leadingWhitespace + CompConfig.indentSize);
		assembly += whitespace + getEndLabel() + (isInterruptHandler() && attributes.contains(CompConfig.Attributes.noISR) ? ": RTI\n" : ": RTL\n");
		return assembly;
	}
}
