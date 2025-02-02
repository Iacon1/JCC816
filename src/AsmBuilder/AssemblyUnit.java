// Created by Iacon1 on 02/14/2024.
// Assembly file translation unit

package AsmBuilder;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import C99Compiler.CompConfig;
import C99Compiler.CompConfig.DefinableInterrupt;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Declarations.InitializerNode;
import C99Compiler.CompilerNodes.Definitions.EnumDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.StructUnionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyFunctionNode;
import C99Compiler.CompilerNodes.Dummies.EnumeratorNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import Shared.TranslationUnit;

public class AssemblyUnit implements TranslationUnit {

	private String filename;
	protected String assembly;
	
	public AssemblyUnit(String filename, String assembly)
	{
		this.filename = filename;
		this.assembly = assembly;
	}
	public AssemblyUnit()
	{
		this.filename = null;
		this.assembly = null;
	}
	@Override public LinkedHashMap<String, VariableNode> getVariables() {return new LinkedHashMap<String, VariableNode>();}
	@Override public LinkedHashMap<String, StructUnionDefinitionNode> getStructs() {return new LinkedHashMap<String, StructUnionDefinitionNode>();}
	@Override public LinkedHashMap<String, EnumDefinitionNode> getEnums() {return new LinkedHashMap<String, EnumDefinitionNode>();}
	@Override public LinkedHashMap<String, EnumeratorNode> getEnumerators() {return new LinkedHashMap<String, EnumeratorNode>();}
	@Override public LinkedHashMap<String, FunctionDefinitionNode> getFunctions()
	{/*
		LinkedHashMap<String, FunctionDefinitionNode> functions = new LinkedHashMap<String, FunctionDefinitionNode>();
		for (String line : assembly.split("\n"))
			if (line.contains("; " + CompConfig.functionTag)) // Function declaration
			{
				String funcName = line.replaceAll(":.*", "").trim();
				functions.put(funcName, new DummyFunctionNode(funcName));
			}
		return functions;
		*/ return new LinkedHashMap<String, FunctionDefinitionNode>();
	}
	@Override public LinkedHashMap<String, Type> getTypedefs() {return new LinkedHashMap<String, Type>();}
	@Override public LinkedHashMap<String, String> getRequiredSubs() {return new LinkedHashMap<String, String>();}
	@Override public LinkedHashMap<DefinableInterrupt, String> getInterrupts() {return new LinkedHashMap<DefinableInterrupt, String>();}
	@Override public LinkedHashMap<String, VariableNode> getGlobalVariables() {return new LinkedHashMap<String, VariableNode>();}
	@Override public List<InitializerNode> getGlobalInitializers() {return new LinkedList<InitializerNode>();}
	@Override public String getFilename() {return filename;}
	@Override public Set<String> getIncludedStdLibs() {return new HashSet<String>();}
	@Override public Set<String> getIncludedOtherLibs() {return new HashSet<String>();}
	
	public String getAssembly()
	{
		return assembly;
	}
}
