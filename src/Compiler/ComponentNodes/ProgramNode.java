// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes;

import java.util.ArrayList;
import java.util.List;

import Compiler.CompConfig;
import Compiler.ComponentNodes.Dummies.DummyVarDecl;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;

public class ProgramNode extends ComponentNode<ProgramNode> implements AssemblableNode
{
	String assembly = "";
	
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String whitespace = getWhitespace(leadingWhitespace);
		String assembly = "";

		List<VarDeclarationNode> variables = new ArrayList<VarDeclarationNode>(variables().values());
		variables.add(0, new DummyVarDecl(CompConfig.operandA, CompConfig.operandSize));
		variables.add(1, new DummyVarDecl(CompConfig.operandB, CompConfig.operandSize));
		assembly += getVariableBlock(whitespace, variables);
		
		for (FunctionNode funcNode : functions().values())
		{
			assembly += funcNode.getAssembly(leadingWhitespace);
		}
		
		return assembly;
	}
	
}
