// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Compiler.ComponentNodes.Declarations.DeclarationNode;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Compiler.Utils.CompUtils;
import Grammar.C99.C99Parser.External_declarationContext;
import Grammar.C99.C99Parser.ProgramContext;

public class ProgramNode extends InterpretingNode<ProgramNode, ProgramContext> implements AssemblableNode
{
	public ProgramNode(ComponentNode<?> parent) {super(parent);}
	public ProgramNode() {super();}
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return true;
	}
	
	@Override
	public ProgramNode interpret(ProgramContext node) throws Exception
	{
		for (External_declarationContext extDec : node.translation_unit().external_declaration())
		{
			if (extDec.declaration() != null) new DeclarationNode(this).interpret(extDec.declaration());
			else new FunctionDefinitionNode(this).interpret(extDec.function_definition());
		}	

		return this;
	}
	
	private String mapMemory(int leadingWhitespace)
	{
		String whitespace = getWhitespace(leadingWhitespace);
		String assembly = "";
		
		Set<String> fullNames = new HashSet<String>();
		for (VariableNode variable : variables)
			fullNames.add(variable.getFullName());
		
		// Get longest variable name
		int maxLength = Math.max(CompUtils.operandA.length(), CompUtils.operandB.length());
		for (String fullName: fullNames)
			maxLength = Math.max(maxLength, fullName.length() + 1);

		assembly += whitespace + applyFiller(CompUtils.operandA, maxLength) + "= " + CompUtils.mapOffset(CompUtils.stackSize, CompUtils.operandSize) + "\n";
		assembly += whitespace + applyFiller(CompUtils.operandB, maxLength) + "= " + CompUtils.mapOffset(CompUtils.stackSize + CompUtils.operandSize, CompUtils.operandSize) + "\n";
		
		// Declare variable locations
		Map<String, Integer> positions = new HashMap<String, Integer>();
		// Using dynamic programming to make sure two variables whose functions share the stack don't overlap in memory
		for (String fullName: fullNames) positions.put(fullName, CompUtils.stackSize + 2 * CompUtils.operandSize);
		for (String fullName: fullNames)
		{
			assembly += whitespace + applyFiller(fullName, maxLength) + "= " + CompUtils.mapOffset(positions.get(fullName), resolveVariable(fullName).getSize()) + "\n";
//			FunctionNode owner = resolveVariable(fullName).getFunction();
			for (String otherFullName: fullNames)
			{
				if (otherFullName.equals(fullName) || positions.get(otherFullName) == -1) continue;
//				FunctionNode otherOwner = resolveVariable(otherFullName).getFunction();
//				if ((owner == null && otherOwner == null) || owner.canCall(otherOwner) || otherOwner.isInterruptHandler())
				{
					int offset = positions.get(fullName) + resolveVariable(fullName).getSize();
					positions.put(otherFullName, Math.max(positions.get(otherFullName), offset));
				}
			}
			positions.put(fullName, -1); // Tags this as not being one we need to look at again.
		}
		
		return assembly;
	}
	
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String whitespace = getWhitespace(leadingWhitespace);
		String assembly = "";

		assembly += mapMemory(leadingWhitespace);
		
		assembly += whitespace + CompUtils.setA16 + "\n";
		assembly += whitespace + "LDA\t#$" + String.format("%04x", CompUtils.stackSize) + "\n";
		assembly += whitespace + "TCS\n";
		assembly += whitespace + "JML\tmain\n";
		// Get assembly from functions
		for (FunctionDefinitionNode funcNode : functions)
		{
			assembly += funcNode.getAssembly(leadingWhitespace);
		}
		
		return assembly;
	}	
}
