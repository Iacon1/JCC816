// Created by Iacon1 on 01/15/2024.
// Links TranslationUnitNodes into one asm file.
package Compiler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;

import org.antlr.v4.runtime.CommonTokenStream;

import java.util.ArrayList;
import java.util.Arrays;

import Compiler.CompConfig.DebugLevel;
import Compiler.CompConfig.DefinableInterrupt;
import Compiler.CompConfig.VerbosityLevel;
import Compiler.CompilerNodes.FunctionDefinitionNode;
import Compiler.CompilerNodes.TranslationUnitNode;
import Compiler.CompilerNodes.Definitions.EnumDefinitionNode;
import Compiler.CompilerNodes.Definitions.StructUnionDefinitionNode;
import Compiler.CompilerNodes.Definitions.Type;
import Compiler.CompilerNodes.Dummies.EnumeratorNode;
import Compiler.CompilerNodes.Interfaces.Catalogger;
import Compiler.CompilerNodes.LValues.VariableNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompUtils;
import Compiler.Utils.SNESRegisters;
import Logging.Logging;

public final class Linker implements Catalogger
{
	private static void printInfo(Object... info)
	{
		for (int i = 0; i < info.length; ++i) Logging.logNotice(info[i].toString() + (i == info.length - 1 ? "" : ", ") + "\n");
	}
	
	private List<TranslationUnitNode> translationUnits;
	
	public List<VariableNode> getVariables()
	{
		List<VariableNode> variables = new LinkedList<VariableNode>();
		for (TranslationUnitNode translationUnit : translationUnits)
			variables.addAll(translationUnit.getVariables());
		
		return variables;
	}
	@Override
	public List<StructUnionDefinitionNode> getStructs()
	{
		List<StructUnionDefinitionNode> structs = new LinkedList<StructUnionDefinitionNode>();
		for (TranslationUnitNode translationUnit : translationUnits)
			structs.addAll(translationUnit.getStructs());
		
		return structs;
	}
	@Override
	public List<EnumDefinitionNode> getEnums()
	{
		List<EnumDefinitionNode> enums = new LinkedList<EnumDefinitionNode>();
		for (TranslationUnitNode translationUnit : translationUnits)
			enums.addAll(translationUnit.getEnums());
		
		return enums;
	}
	@Override
	public List<EnumeratorNode> getEnumerators()
	{
		List<EnumeratorNode> enumerators = new LinkedList<EnumeratorNode>();
		for (TranslationUnitNode translationUnit : translationUnits)
			enumerators.addAll(translationUnit.getEnumerators());
		
		return enumerators;
	}
	@Override
	public List<FunctionDefinitionNode> getFunctions()
	{
		List<FunctionDefinitionNode> functions = new LinkedList<FunctionDefinitionNode>();
		for (TranslationUnitNode translationUnit : translationUnits)
			functions.addAll(translationUnit.getFunctions());
		
		return functions;
	}
	@Override
	public Map<String, Type> getTypedefs()
	{
		Map<String, Type> typedefs = new HashMap<String, Type>();
		for (TranslationUnitNode translationUnit : translationUnits)
			typedefs.putAll(translationUnit.getTypedefs());
		
		return typedefs;
	}
	@Override
	public Map<String, String> getRequiredSubs()
	{
		Map<String, String> requiredSubs = new HashMap<String, String>();
		for (TranslationUnitNode translationUnit : translationUnits)
			requiredSubs.putAll(translationUnit.getRequiredSubs());
		
		return requiredSubs;
	}
	public Map<DefinableInterrupt, String> getInterrupts()
	{
		Map<DefinableInterrupt, String> interrupts = new HashMap<DefinableInterrupt, String>();
		for (TranslationUnitNode translationUnit : translationUnits)
			interrupts.putAll(translationUnit.getInterrupts());
		
		return interrupts;
	}
	
	private String mapMemory()
	{
		String assembly = "";
		
		Set<String> fullNames = new HashSet<String>();
		for (VariableNode variable : getVariables())
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
			assembly +=  AssemblyUtils.applyFiller(entry.getKey(), maxLength) + " = $" +
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
					 AssemblyUtils.applyFiller(fullName, maxLength) +
					" = " + // (DebugLevel.isAtLeast(DebugLevel.low) ? " := " : " = ") + 
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
			assembly +=  AssemblyUtils.applyFiller(register.toString(), maxLength) + " = $" + String.format("%06x", register.address()) + "\n";
		return assembly;
	}
	private String generateVectorTable()
	{
		String assembly = "";
		assembly += ".segment \"VECTORS\"\n";
		// Native
		assembly += ".word\tRESET\n"; // Unused
		assembly +=  ".word\tRESET\n"; // Unused
		assembly +=  ".word\t" + getInterrupt(DefinableInterrupt.COP) + "\n";	// COP
		assembly +=  ".word\t" + getInterrupt(DefinableInterrupt.BRK) + "\n"; 	// BRK
		assembly +=  ".word\t" + getInterrupt(DefinableInterrupt.ABORT) + "\n"; 	// ABORT
		assembly +=  ".word\t" + getInterrupt(DefinableInterrupt.NMI) + "\n"; 	// NMI
		assembly +=  ".word\tRESET\n"; 													// RESET
		assembly +=  ".word\t" + getInterrupt(DefinableInterrupt.IRQ) + "\n"; 	// IRQ
		// Emulation
		assembly +=  ".word\tRESET\n"; // Unused
		assembly +=  ".word\tRESET\n"; // Unused
		assembly +=  ".word\tRESET\n"; // COP
		assembly +=  ".word\tRESET\n"; // Unused
		assembly +=  ".word\tRESET\n"; // ABORT
		assembly +=  ".word\tRESET\n"; // RESET
		assembly +=  ".word\tRESET\n"; // IRQ/BRK

		return assembly;
	}
	private String getAssemblyPreface() throws Exception
	{
		String assembly = "";

		assembly += ".p816\n" +  ".smart\t+\n";
		if (CompConfig.scopeDelimiterPermissor != null)
			assembly +=  ".feature " + CompConfig.scopeDelimiterPermissor + "\n";
		assembly += generateVectorTable(); // Vector table
		
		assembly += ".segment \"HEADER\"\n"; // Declare header
		assembly += ".res\t48, 0;\tHEADER_HERE\n";
		assembly += mapMemory();
		
		assembly += ".segment \"" + CompConfig.bankName(0) + "\"\n"; // Begins runnable code
		assembly +=  "RESET:\n";
		assembly +=
				 "SEI\n" +
				 "CLC\n" +
				 "XCE\n" +
				 "REP\t#$08\n" + 
				 CompUtils.setA16 + "\n";
		assembly += "LDA\t#$" + String.format("%04x", CompConfig.stackSize - 1) + "\n";
		assembly += "TCS\n";
		assembly += "JML\tmain\n";

		// Required special subs
		for (String sub : getRequiredSubs().values())
		{	
			assembly += sub;
		}
		
		return assembly;
	}

	public Linker()
	{
		translationUnits = new LinkedList<TranslationUnitNode>();
	}
	
	public void addUnit(TranslationUnitNode unit)
	{
		translationUnits.add(unit);
	}
	public void addUnits(TranslationUnitNode... units)
	{
		translationUnits.addAll(Arrays.asList(units));
	}
	public void addUnits(List<TranslationUnitNode> units)
	{
		translationUnits.addAll(units);
	}
	
	public String getAssemblyRaw() throws Exception
	{
		String assembly = "";
		
		// Get assembly from functions
		for (FunctionDefinitionNode funcNode : getFunctions())
		{
			assembly += funcNode.getAssembly();
		}
		
		if (resolveFunction("main") == null)
			throw new Exception("Program must have \"" + CompConfig.mainName + "\" function.");
		return getAssemblyPreface() + assembly;
	}
	private  static String postprocess(String assembly) throws Exception
	{
		ArrayList<String> lines = new ArrayList<String>(Arrays.asList(assembly.split("\n")));

		lines = (ArrayList<String>) AssemblyOptimizer.optimizeAssembly((List<String>) lines);
		int banks = Banker.splitBanks(lines);
		
		assembly = "";
		for (String line : lines) if (!line.matches("\s*")) assembly += line + "\n";
		return assembly;
	}
	
	public String link() throws Exception
	{
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Linking...");
		
		long t = System.currentTimeMillis();
		String assembly = getAssemblyRaw();
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Emitted in " + (System.currentTimeMillis() - t) + " ms. Assembly length: " + assembly.length() + ".");
		t = System.currentTimeMillis();
		assembly = postprocess(assembly);
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Postprocessed in " + (System.currentTimeMillis() - t) + " ms. Assembly length: " + assembly.length() + ".");
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Linking done.");
		return assembly;
	}
}
