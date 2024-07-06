// Created by Iacon1 on 01/15/2024.
// Links TranslationUnitNodes into one asm file.
package AsmBuilder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;

import Assembler.MemorySize;
import C99Compiler.CartConfig;
import C99Compiler.CompConfig;
import C99Compiler.CompConfig.DebugLevel;
import C99Compiler.CompConfig.DefinableInterrupt;
import C99Compiler.CompConfig.OptimizationLevel;
import C99Compiler.CompConfig.VerbosityLevel;

import java.util.ArrayList;
import java.util.Arrays;

import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.TranslationUnitNode;
import C99Compiler.CompilerNodes.Declarations.InitializerNode;
import C99Compiler.CompilerNodes.Definitions.EnumDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.StructUnionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.EnumeratorNode;
import C99Compiler.CompilerNodes.Interfaces.Catalogger;
import C99Compiler.CompilerNodes.Interfaces.TranslationUnit;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.Exceptions.BuilderException;
import C99Compiler.Exceptions.BuilderMultipleDefinitionException;
import C99Compiler.Exceptions.UndefinedFunctionException;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.SNESRegisters;
import Logging.Logging;

public final class AsmBuilder implements Catalogger
{
	private static void printInfo(Object... info)
	{
		for (int i = 0; i < info.length; ++i) Logging.logNotice(info[i].toString() + (i == info.length - 1 ? "" : ", ") + "\n");
	}
	
	private List<TranslationUnit> translationUnits;
	
	private List<Exception> storedExceptions;
	@Override
	public LinkedHashMap<String, VariableNode> getVariables()
	{
		LinkedHashMap<String, VariableNode> variables = new LinkedHashMap<String, VariableNode>();
		for (TranslationUnit translationUnit : translationUnits)
			for (VariableNode variable : translationUnit.getVariables().values()) // Have to check one-by-one for name problems
			{
				if (variables.get(variable.getFullName()) != null) // Two variables cannot have same full name
					storedExceptions.add(new BuilderMultipleDefinitionException(variable)); 
				else if (variable.getType().isExtern()) continue; // Extern, hopefully defined elsewhere
				else variables.put(variable.getFullName(), variable);
			}
		
		return variables;
	}
	public LinkedHashMap<String, VariableNode> getGlobalVariables()
	{
		LinkedHashMap<String, VariableNode> variables = new LinkedHashMap<String, VariableNode>();
		for (TranslationUnit translationUnit : translationUnits)
			variables.putAll(translationUnit.getGlobalVariables());
		
		return variables;
	}
	@Override
	public LinkedHashMap<String, StructUnionDefinitionNode> getStructs()
	{
		LinkedHashMap<String, StructUnionDefinitionNode> structs = new LinkedHashMap<String, StructUnionDefinitionNode>();
		for (TranslationUnit translationUnit : translationUnits)
			structs.putAll(translationUnit.getStructs());
		
		return structs;
	}
	@Override
	public LinkedHashMap<String, EnumDefinitionNode> getEnums()
	{
		LinkedHashMap<String, EnumDefinitionNode> enums = new LinkedHashMap<String, EnumDefinitionNode>();
		for (TranslationUnit translationUnit : translationUnits)
			enums.putAll(translationUnit.getEnums());
		
		return enums;
	}
	@Override
	public LinkedHashMap<String, EnumeratorNode> getEnumerators()
	{
		LinkedHashMap<String, EnumeratorNode> enumerators = new LinkedHashMap<String, EnumeratorNode>();
		for (TranslationUnit translationUnit : translationUnits)
			enumerators.putAll(translationUnit.getEnumerators());
		
		return enumerators;
	}
	@Override
	public LinkedHashMap<String, FunctionDefinitionNode> getFunctions()
	{
		LinkedHashMap<String, FunctionDefinitionNode> functions = new LinkedHashMap<String, FunctionDefinitionNode>();
		for (TranslationUnit translationUnit : translationUnits)
			for (FunctionDefinitionNode function : translationUnit.getFunctions().values()) // Have to check one-by-one for name problems
			{
				FunctionDefinitionNode oldFunction = functions.get(function.getFullName());
				if (oldFunction != null && oldFunction.isImplemented() && function.isImplemented()) // Two implemented functions cannot have same full name
					storedExceptions.add(new BuilderMultipleDefinitionException(function));
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
		for (TranslationUnit translationUnit : translationUnits)
			typedefs.putAll(translationUnit.getTypedefs());
		
		return typedefs;
	}
	@Override
	public LinkedHashMap<String, String> getRequiredSubs()
	{
		LinkedHashMap<String, String> requiredSubs = new LinkedHashMap<String, String>();
		for (TranslationUnit translationUnit : translationUnits)
			requiredSubs.putAll(translationUnit.getRequiredSubs());
		
		return requiredSubs;
	}
	public LinkedHashMap<DefinableInterrupt, String> getInterrupts()
	{
		LinkedHashMap<DefinableInterrupt, String> interrupts = new LinkedHashMap<DefinableInterrupt, String>();
		for (TranslationUnit translationUnit : translationUnits)
			interrupts.putAll(translationUnit.getInterrupts());
		
		return interrupts;
	}
	
	private boolean isPreassembled(FunctionDefinitionNode function)
	{
		TranslationUnit targetUnit = function.getTranslationUnit();
		for (TranslationUnit unit : translationUnits)
			if (unit.getFilename().equals(targetUnit.getFilename()))
			{
				if (ModuleAssemblyUnit.class.isAssignableFrom(unit.getClass()))
					return true;
				else
					return false;
			}
		return false;
	}
	private Map<String, Integer> mapVariables(CartConfig cartConfig, MemorySize memorySize)
	{
		int offset = CompConfig.stackSize;
		List<VariableNode> WRAMVars = new LinkedList<VariableNode>(), SRAMVars = new LinkedList<VariableNode>();
		for (VariableNode var : getVariables().values())
		{
			if (var.getType().isSRAM())
				SRAMVars.add(var);
			else if (var.getType().isWRAM())
				WRAMVars.add(var);
			else if (var.getType().isROM() && !var.getScope().isRoot()) // Non-global const
				WRAMVars.add(var);
		}
		List<Integer> WRAMPoses = null, SRAMPoses = null;
		if (WRAMVars.size() > 0) WRAMPoses = cartConfig.getType().mapWRAM(WRAMVars, offset, memorySize);
		if (SRAMVars.size() > 0) SRAMPoses = cartConfig.getType().mapSRAM(SRAMVars, 0, memorySize);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < WRAMVars.size(); ++i)
			map.put(WRAMVars.get(i).getFullName(), WRAMPoses.get(i));
		for (int i = 0; i < SRAMVars.size(); ++i)
			map.put(SRAMVars.get(i).getFullName(), SRAMPoses.get(i));
		
		return map;
	}
	private String mapGlobalRAM(CartConfig cartConfig, Map<String, Integer> varPoses)
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
		
		for (VariableNode var : getVariables().values())
		{
			if (var.getScope().isRoot() && var.getType().isROM()) continue; // These are mapped elsewhere
			
			String fullName = var.getFullName();
			assembly += AssemblyUtils.applyFiller(fullName, maxLength) + " = $" + String.format("%06x", varPoses.get(var.getFullName()));
			if (DebugLevel.isAtLeast(DebugLevel.medium))
				assembly += "\t; " + var.getType().getSignature() + " (" + var.getSize() + " bytes)";
			assembly += "\n";
			if (DebugLevel.isAtLeast(DebugLevel.low)) // Output variable symbol for variable
				assembly += ".dbg sym, \"" + var.getName() + "\", \"00\", EXTERN, \"" + fullName + "\"\n";
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
		assembly += ".word\tRESET\n"; 						// Unused
		assembly +=  ".word\tRESET\n"; 						// Unused
		for (DefinableInterrupt interrupt : DefinableInterrupt.values())
			assembly +=  ".word\t" + interrupt.longLabel + "\n";
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
	private String getAssemblyPreface(CartConfig cartConfig, Map<String, Integer> varPoses) throws Exception
	{
		String assembly = "";

		assembly += ".p816\n" +  ".smart\t+\n";
		if (CompConfig.scopeDelimiterPermissor != null)
			assembly +=  ".feature " + CompConfig.scopeDelimiterPermissor + "\n";
		for (TranslationUnit unit : translationUnits)
			if (DebugLevel.isAtLeast(DebugLevel.low))
				assembly += ".dbg file, \"" + unit.getDBGFilename() + "\", 0, 0\n";
		assembly += generateVectorTable(); // Vector table
		
		assembly += ".segment \"HEADER\"\n"; // Declare header
		assembly += ".res\t48, 0;\tHEADER_HERE\n";
		assembly += mapGlobalRAM(cartConfig, varPoses);
		assembly += ".segment \"" + CompConfig.codeBankName(0) + "\"\n"; // Begins runnable code
		assembly += "RESET:\n";
		assembly +=
				 "SEI\n" +
				 "CLC\n" +
				 "XCE\n" +
				 "REP\t#$08\n";
		if (CompConfig.wordAddresses)
			assembly +=
				"LDA\t#$7E\n" +
				"PHA\n" +
				"PLB\n";
		
		assembly +=	CompUtils.setA16 + "\n";
		assembly += "LDA\t#$" + String.format("%04x", CompConfig.stackSize - 1) + "\n";
		assembly += "TCS\n";
		if (cartConfig.isFast()) // Activate FastROM
		{
			assembly += "LDA\t#$FFFF\n";
			assembly += "STA\t$00420D\n";
		}
		assembly += "PHK\n"; // Set return address to RESET so that when main ends it restarts
		assembly += "PEA\tRESET\n";
		// Load initialized globals
		for (TranslationUnit unit : translationUnits)
			for (InitializerNode init : unit.getGlobalInitializers())
				if (!init.isROM()) // Only RAM ones up here, to save space in 0 bank
					assembly += init.getAssembly();
		assembly += "JML\tmain\n";
		
		// Long interrupt tables TODO optimize this if they're in zero bank
		for (DefinableInterrupt interrupt : DefinableInterrupt.values())
			if (interrupt != DefinableInterrupt.RESET)
				assembly +=  interrupt.longLabel + ":JML\t" + getInterrupt(interrupt) + "\n";
		// Required special subs
		for (String sub : getRequiredSubs().values())
		{	
			assembly += sub;
		}
		
		return assembly;
	}

	public AsmBuilder()
	{
		translationUnits = new LinkedList<TranslationUnit>();
		storedExceptions = new LinkedList<Exception>();
	}
	
	public void addUnit(TranslationUnit unit)
	{
		translationUnits.add(unit);
	}
	public void addUnits(TranslationUnit... units)
	{
		translationUnits.addAll(Arrays.asList(units));
	}
	public void addUnits(List<? extends TranslationUnit> units)
	{
		translationUnits.addAll(units);
	}
	
	private String getAssembly(CartConfig cartConfig, MemorySize memorySize, boolean isModule) throws Exception
	{
		String assembly = "";

		// Get assembly from functions
		for (FunctionDefinitionNode funcNode : getFunctions().values())
		{
			if (funcNode.isImplemented() && funcNode.isInline()) continue;
			else if (funcNode.getType().isExtern()) continue;
			else if (!funcNode.isImplemented())
			{
				if (!isModule)
					throw new UndefinedFunctionException(funcNode);
				else continue;
			}
			else if (isPreassembled(funcNode)) continue;
			
			assembly += funcNode.getAssembly();
		}
		
		// Get raw assembly
		for (TranslationUnit unit : translationUnits)
			if (AssemblyUnit.class.isAssignableFrom(unit.getClass()))
				assembly += ((AssemblyUnit) unit).getAssembly();
		
		if (!isModule)
		{	
			// Get ROM data
			for (TranslationUnit unit : translationUnits)
				for (InitializerNode init : unit.getGlobalInitializers())
					if (!init.getType().isExtern() && init.isROM()) // Rom ones go last
						assembly += init.getAssembly();
		
			Map<String, Integer> varPoses = mapVariables(cartConfig, memorySize);
			if (CompConfig.wordAddresses && memorySize.WRAMSize > 0xFFFF)
				throw new BuilderException("Cannot use 16-bit addressing, more than 64 KB RAM required.");
			if (resolveFunction("main") == null)
				throw new BuilderException("Program must have \"" + CompConfig.mainName + "\" function.");
			return getAssemblyPreface(cartConfig, varPoses) + assembly;
		}
		else return assembly;
	}
	private  static String postprocess(String assembly, MemorySize memorySize) throws Exception
	{
		ArrayList<String> lines = new ArrayList<String>(Arrays.asList(assembly.split("\n")));

		if (OptimizationLevel.isAtLeast(OptimizationLevel.low))
			lines = (ArrayList<String>) AssemblyOptimizer.optimizeAssembly((List<String>) lines);
		memorySize.ROMSize = Banker.splitBanks(new CartConfig(), lines);
		
		assembly = "";
		for (String line : lines) if (!line.matches("\s*")) assembly += line + "\n";
		return assembly;
	}
	
	public String build(CartConfig cartConfig, MemorySize memorySize) throws Exception
	{
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Linking...");	
		
		long t = System.currentTimeMillis();
		String assembly = getAssembly(cartConfig, memorySize, false);
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Emitted in " + (System.currentTimeMillis() - t) + " ms. Assembly length: " + assembly.length() + ".");
		t = System.currentTimeMillis();
		assembly = postprocess(assembly, memorySize);
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Postprocessed in " + (System.currentTimeMillis() - t) + " ms. Assembly length: " + assembly.length() + ".");
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Linking done.");
		return assembly;
	}
	
	public ModuleAssemblyUnit buildModule(CartConfig cartConfig, MemorySize memorySize) throws Exception
	{
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Linking...");	
		
		long t = System.currentTimeMillis();
		String assembly = getAssembly(cartConfig, memorySize, true);
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
		{
			printInfo("Emitted in " + (System.currentTimeMillis() - t) + " ms. Assembly length: " + assembly.length() + ".");
			printInfo("Linking done.");
		}
		return new ModuleAssemblyUnit(translationUnits.get(0), assembly);
	}
}
