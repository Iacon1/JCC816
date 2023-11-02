// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Compiler.ComponentNodes.Expressions.MultiplicativeExpressionNode;
import Compiler.ComponentNodes.Declarations.DeclarationNode;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompConfig;
import Compiler.Utils.CompUtils;
import Compiler.Utils.SNESRegisters;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.ScratchManager.ScratchSource;
import Grammar.C99.C99Parser.External_declarationContext;
import Grammar.C99.C99Parser.ProgramContext;

public class ProgramNode extends InterpretingNode<ProgramNode, ProgramContext> implements AssemblableNode
{
	private String mapMemory(int leadingWhitespace)
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
		
		Set<String> fullNames = new HashSet<String>();
		for (VariableNode variable : variables)
			fullNames.add(variable.getFullName());
		
		// Get longest variable name
		int maxLength = Math.max(CompConfig.scratchBase.length(), CompConfig.callResult.length());
		for (String fullName: fullNames)
			maxLength = Math.max(maxLength, fullName.length());
		for (SNESRegisters register : SNESRegisters.values())
			maxLength = Math.max(maxLength, register.toString().length());
		
		int basePosition = 0;
		assembly += whitespace + AssemblyUtils.applyFiller(CompConfig.scratchBase, maxLength) + " := " +
				CompUtils.mapOffset(basePosition, CompConfig.scratchSize) + "\n";
		basePosition += CompConfig.scratchSize;
		assembly += whitespace + AssemblyUtils.applyFiller(CompConfig.callResult, maxLength) + " := " +
				CompUtils.mapOffset(basePosition, CompConfig.callResultSize) + "\n";
		basePosition += CompConfig.callResultSize;
		
		// Declare variable locations
		Map<String, Integer> positions = new HashMap<String, Integer>();
		// Using dynamic programming to make sure two variables whose functions share the stack don't overlap in memory
		for (String fullName: fullNames) positions.put(fullName, basePosition);
		for (String fullName: fullNames)
		{
			assembly += whitespace + AssemblyUtils.applyFiller(fullName, maxLength) + " := " + CompUtils.mapOffset(positions.get(fullName), resolveVariable(fullName).getSize()) + "\n";
			FunctionDefinitionNode owner = resolveVariable(fullName).getEnclosingFunction();
			for (String otherFullName: fullNames)
			{
				if (otherFullName.equals(fullName) || positions.get(otherFullName) == -1) continue;
				FunctionDefinitionNode otherOwner = resolveVariable(otherFullName).getEnclosingFunction();
				if ((owner == null && otherOwner == null) || owner.canCall(otherOwner) || otherOwner.isInterruptHandler())
				{
					int offset = positions.get(fullName) + resolveVariable(fullName).getSize();
					positions.put(otherFullName, Math.max(positions.get(otherFullName), offset));
				}
			}
			positions.put(fullName, -1); // Tags this as not being one we need to look at again.
		}
		
		for (SNESRegisters register : SNESRegisters.values())
			assembly += whitespace + AssemblyUtils.applyFiller(register.toString(), maxLength) + " := $" + String.format("%06x", register.address()) + "\n";
		return assembly;
	}
	private String generateVectorTable(int leadingWhitespace)
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
		assembly += whitespace + ".segment \"VECTORS\"\n";
		// Native
		assembly += whitespace + ".word\tRESET\n"; // Unused
		assembly += whitespace + ".word\tRESET\n"; // Unused
		assembly += whitespace + ".word\tRESET\n"; // COP
		assembly += whitespace + ".word\tRESET\n"; // BRK
		assembly += whitespace + ".word\tRESET\n"; // ABORT
		assembly += whitespace + ".word\tRESET\n"; // NMI
		assembly += whitespace + ".word\tRESET\n"; // RESET
		assembly += whitespace + ".word\tRESET\n"; // IRQ
		// Emulation
		assembly += whitespace + ".word\tRESET\n"; // Unused
		assembly += whitespace + ".word\tRESET\n"; // Unused
		assembly += whitespace + ".word\tRESET\n"; // COP
		assembly += whitespace + ".word\tRESET\n"; // Unused
		assembly += whitespace + ".word\tRESET\n"; // ABORT
		assembly += whitespace + ".word\tRESET\n"; // RESET
		assembly += whitespace + ".word\tRESET\n"; // IRQ/BRK

		return assembly;
	}
	
	public ProgramNode(ComponentNode<?> parent) {super(parent);}
	public ProgramNode() {super();}
	
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
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return true;
	}
	
	private String getAssemblyPreface(int leadingWhitespace) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";

		assembly += whitespace + ".p816\n" + ".smart\t+\n";
		
		assembly += generateVectorTable(leadingWhitespace); // Vector table
		
		assembly += whitespace + ".segment \"HEADER\"\n"; // Declare header
		assembly += whitespace + ".res\t48, 0;\tHEADER_HERE\n";
		assembly += mapMemory(leadingWhitespace);
		
		assembly += ".segment \"CODE\"\n"; // Begins runnable code
		assembly += whitespace + "RESET:\n";
		assembly +=
				whitespace + "SEI\n" +
				whitespace + "CLC\n" +
				whitespace + "XCE\n" +
				whitespace + "REP\t#$08\n";
		assembly += whitespace + CompUtils.setA16 + "\n";
		assembly += whitespace + "LDA\t#$" + String.format("%04x", CompUtils.stackSize - 1) + "\n";
		assembly += whitespace + "TCS\n";
		assembly += whitespace + "JML\tmain\n";
		
		// Required multiplier subs
		for (SimpleEntry<Integer, Integer> mult : reqMultSubs)
		{
			assembly += whitespace + "__MULT_" + mult.getKey() + "_" + mult.getValue() + ":CLC\n";
			ScratchManager scratchManager = new ScratchManager();
			ScratchSource sourceX = scratchManager.reserveScratchBlock(mult.getKey());
			ScratchSource sourceY = scratchManager.reserveScratchBlock(mult.getValue());

			assembly += MultiplicativeExpressionNode.getMultiplier(
					AssemblyUtils.getWhitespace(leadingWhitespace + CompConfig.indentSize),
					CompConfig.callResult,
					sourceX,
					sourceY);
			assembly += whitespace + "RTL\n";
		}
		
		// Required divison subs
		for (SimpleEntry<Integer, Integer> div : reqDivSubs)
		{	
			assembly += whitespace + "__DIV_" + div.getKey() + "_" + div.getValue() + ":CLC\n";
			ScratchManager scratchManager = new ScratchManager();
			ScratchSource sourceX = scratchManager.reserveScratchBlock(div.getKey());
			ScratchSource sourceY = scratchManager.reserveScratchBlock(div.getValue());
			assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), CompConfig.callResult, 0);
			if (div.getValue() == 1) // Can use short divider
				assembly += MultiplicativeExpressionNode.getShortDivider(
					AssemblyUtils.getWhitespace(leadingWhitespace + CompConfig.indentSize),
					CompConfig.callResult, scratchManager, sourceX, sourceY);
			else // Must use long divider
				assembly += MultiplicativeExpressionNode.getLongDivider(
					AssemblyUtils.getWhitespace(leadingWhitespace + CompConfig.indentSize),
					CompConfig.callResult, scratchManager, sourceX, sourceY);
			assembly += whitespace + "RTL\n";
		}
		
		return assembly;
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
		
		// Get assembly from functions
		for (FunctionDefinitionNode funcNode : functions)
		{
			assembly += funcNode.getAssembly(leadingWhitespace);
		}
		
		return getAssemblyPreface(leadingWhitespace) + assembly;
	}	
}
