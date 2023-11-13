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
import Compiler.ComponentNodes.LValues.VariableNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.CompConfig.DebugLevel;
import Compiler.Utils.CompConfig;
import Compiler.Utils.CompUtils;
import Compiler.Utils.SNESRegisters;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.ConstantSource;
import Compiler.Utils.OperandSources.OperandSource;
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
		for (VariableNode variable : variables)
			fullNames.add(variable.getFullName());
		
		// Get longest variable name
		int maxLength = 0;
		for (SimpleEntry<String, Integer> entry : CompConfig.reservedRAM())
			maxLength = Math.max(entry.getKey().length(), maxLength);
		for (String fullName: fullNames)
			maxLength = Math.max(maxLength, fullName.length());
		for (SNESRegisters register : SNESRegisters.values())
			maxLength = Math.max(maxLength, register.toString().length());
		
		int offset = 0;
		for (SimpleEntry<String, Integer> entry : CompConfig.reservedRAM())
		{
			assembly += whitespace + AssemblyUtils.applyFiller(entry.getKey(), maxLength) + " := $" +
					String.format("%06x", offset) + "\n";
			offset += entry.getValue();
		}
		
		// Declare variable locations
		Map<String, Integer> positions = new HashMap<String, Integer>();
		// Using dynamic programming to make sure two variables whose functions share the stack don't overlap in memory
		for (String fullName: fullNames) positions.put(fullName, 0);
		for (String fullName: fullNames)
		{
			VariableNode var = resolveVariable(fullName);
			assembly +=
					whitespace + AssemblyUtils.applyFiller(fullName, maxLength) +
					(DebugLevel.isAtLeast(DebugLevel.low) ? " := " : " = ") + 
					CompUtils.mapOffset(positions.get(fullName), var.getSize()) +
					(DebugLevel.isAtLeast(DebugLevel.medium) ? "\t; " + var.getType().getSignature() + " (" + var.getSize() + " bytes)": "") + 
					"\n";
			FunctionDefinitionNode owner = var.getEnclosingFunction();
			for (String otherFullName: fullNames)
			{
				if (otherFullName.equals(fullName) || positions.get(otherFullName) == -1) continue;
				FunctionDefinitionNode otherOwner = var.getEnclosingFunction();
				if ((owner == null && otherOwner == null) || owner.canCall(otherOwner) || otherOwner.isInterruptHandler())
				{
					offset = positions.get(fullName) + var.getSize();
					positions.put(otherFullName, Math.max(positions.get(otherFullName), offset));
				}
			}
			positions.put(fullName, -1); // Tags this as not being one we need to look at again.
		}
		
		for (SNESRegisters register : SNESRegisters.values())
			assembly += whitespace + AssemblyUtils.applyFiller(register.toString(), maxLength) + " = $" + String.format("%06x", register.address()) + "\n";
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

		assembly += whitespace + ".p816\n" + whitespace + ".smart\t+\n";
		if (CompConfig.scopeDelimiterPermissor != null)
			assembly += whitespace + ".feature " + CompConfig.scopeDelimiterPermissor + "\n";
		assembly += generateVectorTable(leadingWhitespace); // Vector table
		
		assembly += whitespace + ".segment \"HEADER\"\n"; // Declare header
		assembly += whitespace + ".res\t48, 0;\tHEADER_HERE\n";
		assembly += mapMemory(leadingWhitespace);
		
		assembly += ".segment \"CODE\"\n"; // Begins runnable code
		assembly += whitespace + "RESET:\n";
		assembly +=
				whitespace + "SEI\n" +
				whitespace + "CLC\n" +
				whitespace + "REP\t#$08\n" + 
				whitespace + CompUtils.setA16 + "\n" +
				whitespace + "XCE\n";
		assembly += whitespace + "LDA\t#$" + String.format("%04x", CompConfig.stackSize - 1) + "\n";
		assembly += whitespace + "TCS\n";
		assembly += whitespace + "JML\tmain\n";
		
		// Required multiplier subs
		for (SimpleEntry<Integer, Integer> mult : reqMultSubs)
		{
			assembly += whitespace + "__MULT_" + mult.getKey() + "_" + mult.getValue() + ":CLC\n";
			OperandSource sourceX = CompConfig.multDivSource(true, mult.getKey());
			OperandSource sourceY = CompConfig.multDivSource(false, mult.getValue());

			assembly += MultiplicativeExpressionNode.getMultiplier(
					AssemblyUtils.getWhitespace(leadingWhitespace + CompConfig.indentSize),
					CompConfig.callResultSource(sourceX.getSize()),
					sourceX,
					sourceY, new DetailsTicket());
			assembly += whitespace + "RTL\n";
		}
		
		// Required divison subs
		for (SimpleEntry<Integer, Integer> div : reqDivSubs)
		{	
			assembly += whitespace + "__DIV_" + div.getKey() + "_" + div.getValue() + ":CLC\n";
			OperandSource sourceX = CompConfig.multDivSource(true, div.getKey());
			OperandSource sourceY = CompConfig.multDivSource(true, div.getValue());
			OperandSource sourceN = new ConstantSource(0, sourceX.getSize());
			assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), CompConfig.callResultSource(sourceX.getSize()), sourceN);
			if (div.getValue() == 1) // Can use short divider
				assembly += MultiplicativeExpressionNode.getShortDivider(
					AssemblyUtils.getWhitespace(leadingWhitespace + CompConfig.indentSize),
					CompConfig.callResultSource(sourceX.getSize()), sourceX, sourceY, new DetailsTicket());
			else // Must use long divider
			{
				ScratchManager scratchManager = new ScratchManager();
				scratchManager.reserveScratchBlock(CompConfig.scratchSize - 2 * div.getKey() - div.getValue() - 2); // Assume as little memory available as possible
				assembly += MultiplicativeExpressionNode.getLongDivider(
					AssemblyUtils.getWhitespace(leadingWhitespace + CompConfig.indentSize),
					CompConfig.callResultSource(sourceX.getSize()), scratchManager, sourceX, sourceY, new DetailsTicket());
			}
			assembly += whitespace + "RTL\n";
		}
		
		return assembly;
	}
	@Override
	public boolean hasAssembly()
	{
		return true;
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
