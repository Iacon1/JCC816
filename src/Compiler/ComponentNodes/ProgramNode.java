// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Compiler.CompConfig;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;

public class ProgramNode extends ComponentNode<ProgramNode> implements AssemblableNode
{
	@Override
	public boolean canCall(FunctionNode function)
	{
		return true;
	}
	
	private static String applyFiller(String string, int desiredLength)
	{
		String filler = new String(new char[desiredLength - string.length()]).replace('\0', ' ');
		
		return string + filler;
	}
	private String mapMemory(int leadingWhitespace)
	{
		String whitespace = getWhitespace(leadingWhitespace);
		String assembly = "";
		
		Set<String> fullNames = new HashSet<String>(variables().keySet());

		// Get longest variable name
		int maxLength = Math.max(CompConfig.operandA.length(), CompConfig.operandB.length());
		for (String fullName: fullNames)
			maxLength = Math.max(maxLength, fullName.length() + 1);

		assembly += whitespace + applyFiller(CompConfig.operandA, maxLength) + "= " + CompConfig.mapOffset(CompConfig.stackSize) + "\n";
		assembly += whitespace + applyFiller(CompConfig.operandB, maxLength) + "= " + CompConfig.mapOffset(CompConfig.stackSize + CompConfig.operandSize) + "\n";
		
		// Declare variable locations
		Map<String, Integer> positions = new HashMap<String, Integer>();
		// Using dynamic programming to make sure two variables whose functions share the stack don't overlap in memory
		for (String fullName: fullNames) positions.put(fullName, CompConfig.stackSize + 2 * CompConfig.operandSize);
		for (String fullName: fullNames)
		{
			assembly += whitespace + applyFiller(fullName, maxLength) + "= " + CompConfig.mapOffset(positions.get(fullName)) + "\n";
			FunctionNode owner = resolveVariable(fullName).getFunction();
			for (String otherFullName: fullNames)
			{
				if (otherFullName.equals(fullName) || positions.get(otherFullName) == -1) continue;
				FunctionNode otherOwner = resolveVariable(otherFullName).getFunction();
				if ((owner == null && otherOwner == null) || owner.canCall(otherOwner) || otherOwner.isInterruptHandler())
				{
					int offset = positions.get(fullName) + resolveVariable(fullName).size();
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
		
		assembly += whitespace + CompConfig.setA16 + "\n";
		assembly += whitespace + "LDA\t#$" + String.format("%04x", CompConfig.stackSize) + "\n";
		assembly += whitespace + "TCS\n";
		assembly += whitespace + "JML\tmain\n";
		// Get assembly from functions
		for (FunctionNode funcNode : functions().values())
		{
			assembly += funcNode.getAssembly(leadingWhitespace);
		}
		
		return assembly;
	}
	
}
