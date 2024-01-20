// Created by Iacon1 on 01/15/2024.
// Links TranslationUnitNodes into one asm file.
package C99Compiler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;

import org.antlr.v4.runtime.CommonTokenStream;

import C99Compiler.CompConfig.DebugLevel;
import C99Compiler.CompConfig.DefinableInterrupt;
import C99Compiler.CompConfig.VerbosityLevel;

import java.util.ArrayList;
import java.util.Arrays;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.TranslationUnitNode;
import C99Compiler.CompilerNodes.Definitions.EnumDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.StructUnionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.EnumeratorNode;
import C99Compiler.CompilerNodes.Interfaces.Catalogger;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.Exceptions.CompilerMultipleDefinitionException;
import C99Compiler.Exceptions.LinkerMultipleDefinitionException;
import C99Compiler.Exceptions.UndefinedFunctionException;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.SNESRegisters;
import Logging.Logging;

public final class Linker implements Catalogger
{
	private static void printInfo(Object... info)
	{
		for (int i = 0; i < info.length; ++i) Logging.logNotice(info[i].toString() + (i == info.length - 1 ? "" : ", ") + "\n");
	}
	
	private List<TranslationUnitNode> translationUnits;
	private List<Exception> storedExceptions;
	public LinkedHashMap<String, VariableNode> getVariables()
	{
		LinkedHashMap<String, VariableNode> variables = new LinkedHashMap<String, VariableNode>();
		for (TranslationUnitNode translationUnit : translationUnits)
			for (VariableNode variable : translationUnit.getVariables().values()) // Have to check one-by-one for name problems
			{
				if (variable.getScope().isRoot() && variables.get(variable.getFullName()) != null) // Two root-level variables cannot have same full name
					storedExceptions.add(new LinkerMultipleDefinitionException(variable)); 
				else variables.put(variable.getFullName(), variable);
			}
		
		return variables;
	}
	@Override
	public LinkedHashMap<String, StructUnionDefinitionNode> getStructs()
	{
		LinkedHashMap<String, StructUnionDefinitionNode> structs = new LinkedHashMap<String, StructUnionDefinitionNode>();
		for (TranslationUnitNode translationUnit : translationUnits)
			structs.putAll(translationUnit.getStructs());
		
		return structs;
	}
	@Override
	public LinkedHashMap<String, EnumDefinitionNode> getEnums()
	{
		LinkedHashMap<String, EnumDefinitionNode> enums = new LinkedHashMap<String, EnumDefinitionNode>();
		for (TranslationUnitNode translationUnit : translationUnits)
			enums.putAll(translationUnit.getEnums());
		
		return enums;
	}
	@Override
	public LinkedHashMap<String, EnumeratorNode> getEnumerators()
	{
		LinkedHashMap<String, EnumeratorNode> enumerators = new LinkedHashMap<String, EnumeratorNode>();
		for (TranslationUnitNode translationUnit : translationUnits)
			enumerators.putAll(translationUnit.getEnumerators());
		
		return enumerators;
	}
	@Override
	public LinkedHashMap<String, FunctionDefinitionNode> getFunctions()
	{
		LinkedHashMap<String, FunctionDefinitionNode> functions = new LinkedHashMap<String, FunctionDefinitionNode>();
		for (TranslationUnitNode translationUnit : translationUnits)
			for (FunctionDefinitionNode function : translationUnit.getFunctions().values()) // Have to check one-by-one for name problems
			{
				FunctionDefinitionNode oldFunction = functions.get(function.getFullName());
				if (oldFunction != null && oldFunction.isImplemented() && function.isImplemented()) // Two implemented functions cannot have same full name
					storedExceptions.add(new LinkerMultipleDefinitionException(function));
				else if (oldFunction != null && oldFunction.isImplemented()) // Don't replace the implemented one!
					function.implement(oldFunction); // Instead set this one as a reference to it
				else
				{
					if (oldFunction != null) oldFunction.implement(function); // Otherwise do the opposite
					functions.put(function.getFullName(), function);
				}
				
			}
		return functions;
	}
	@Override
	public LinkedHashMap<String, Type> getTypedefs()
	{
		LinkedHashMap<String, Type> typedefs = new LinkedHashMap<String, Type>();
		for (TranslationUnitNode translationUnit : translationUnits)
			typedefs.putAll(translationUnit.getTypedefs());
		
		return typedefs;
	}
	@Override
	public LinkedHashMap<String, String> getRequiredSubs()
	{
		LinkedHashMap<String, String> requiredSubs = new LinkedHashMap<String, String>();
		for (TranslationUnitNode translationUnit : translationUnits)
			requiredSubs.putAll(translationUnit.getRequiredSubs());
		
		return requiredSubs;
	}
	public LinkedHashMap<DefinableInterrupt, String> getInterrupts()
	{
		LinkedHashMap<DefinableInterrupt, String> interrupts = new LinkedHashMap<DefinableInterrupt, String>();
		for (TranslationUnitNode translationUnit : translationUnits)
			interrupts.putAll(translationUnit.getInterrupts());
		
		return interrupts;
	}
	
	private String mapMemory()
	{
		String assembly = "";
		
		Set<String> fullNames = new HashSet<String>();
		for (VariableNode variable : getVariables().values())
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
		storedExceptions = new LinkedList<Exception>();
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
		for (FunctionDefinitionNode funcNode : getFunctions().values())
		{
			if (!funcNode.isImplemented())
				throw new UndefinedFunctionException(funcNode);
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
