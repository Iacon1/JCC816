// By Iacon1
// Created 05/11/2023
//
package Compiler.ComponentNodes;

import Grammar.GeneralParser.GeneralNode;

import java.util.Arrays;

import Compiler.Compiler;

public class FunctionNode extends ComponentNode<FunctionNode> implements NamedNode
{
	private String returnType;
	private String name;
	
	@Override
	public FunctionNode interpret(GeneralNode<String> node)
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
		new StatementNode(this).interpret(node.getNode(statementIndex));
		return this;
	}
	
	@Override
	public String[] getScope()
	{
		if (parent != null)
		{
			String[] scope = Arrays.copyOf(parent.getScope(), parent.getScope().length + 1);
			scope[scope.length - 1] = name;
			return scope;
		}
		else return new String[] {name};
	}

	@Override
	public String getName() {return name;}
}
