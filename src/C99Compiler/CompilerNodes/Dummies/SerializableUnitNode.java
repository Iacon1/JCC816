// Created by Iacon1 on 05/23/2024.
// Fake translation unit node that replicates other ones and can be serialized
package C99Compiler.CompilerNodes.Dummies;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import C99Compiler.CompConfig.DefinableInterrupt;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Declarations.InitializerNode;
import C99Compiler.CompilerNodes.Definitions.EnumDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.StructUnionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Interfaces.TranslationUnit;
import C99Compiler.CompilerNodes.LValues.VariableNode;

public class SerializableUnitNode implements TranslationUnit, Serializable
{
	private static final long serialVersionUID = 1L;
	
	private class TypeData implements Serializable
	{
		private static final long serialVersionUID = 1L;
		
		private String signature;
		private int sizeBits = 0;
		
		public TypeData(Type type)
		{
			signature = type.getSignature();
			sizeBits = type.getSizeBits();
		}
		
		public String getSignature() {return signature;}
		public int getSizeBits() {return sizeBits;}
		public int getSize() {return sizeBits / 8;}
	}
	private class VarData implements Serializable
	{
		private static final long serialVersionUID = 1L;
		
		private String fullName;
		private TypeData type;
		
		public VarData(VariableNode var)
		{
			fullName = var.getFullName();
			type = new TypeData(var.getType());
		}
		
		public String getFullName() {return fullName;}
		public TypeData getType() {return type;}
	}
	private class FunData implements Serializable
	{
		private static final long serialVersionUID = 1L;
		
		private String fullName;
		
		public FunData(FunctionDefinitionNode fun)
		{
			fullName = fun.getFullName();
		}
		
		public String getFullName() {return fullName;}
	}
	
	private List<VarData> variables;
	private List<FunData> functions;
	private String filename;
	private int ROMSize;
	
	public SerializableUnitNode(TranslationUnit unit, int ROMSize)
	{
		super();
		variables = new LinkedList<VarData>();
		functions = new LinkedList<FunData>();
		filename = unit.getFilename();
		for (VariableNode var : unit.getVariables().values())
			variables.add(new VarData(var));
		for (FunctionDefinitionNode fun : unit.getFunctions().values())
			functions.add(new FunData(fun));
		this.ROMSize = ROMSize;
	}

	@Override
	public LinkedHashMap<String, VariableNode> getVariables()
	{
		LinkedHashMap<String, VariableNode> map = new LinkedHashMap<String, VariableNode>();
		for (VarData var : variables)
		{
			VariableNode v = new DummyVariableNode(null,
					var.getFullName(),
					new DummyType(
							var.getType().getSizeBits(),
							var.getType().getSignature()), null);
			map.put(v.getFullName(), v);
		}
		return map;
	}

	@Override public LinkedHashMap<String, StructUnionDefinitionNode> getStructs() {return new LinkedHashMap<String, StructUnionDefinitionNode>();}
	@Override public LinkedHashMap<String, EnumDefinitionNode> getEnums() {return new LinkedHashMap<String, EnumDefinitionNode>();}
	@Override public LinkedHashMap<String, EnumeratorNode> getEnumerators() {return new LinkedHashMap<String, EnumeratorNode>();}
	@Override public LinkedHashMap<String, FunctionDefinitionNode> getFunctions()
	{
		LinkedHashMap<String, FunctionDefinitionNode> map = new LinkedHashMap<String, FunctionDefinitionNode>();
		for (FunData fun : functions)
		{
			FunctionDefinitionNode f = new DummyFunctionNode(fun.getFullName(), false);
			map.put(f.getFullName(), f);
		}
		return map;
	}
	@Override public LinkedHashMap<String, Type> getTypedefs() {return new LinkedHashMap<String, Type>();}
	@Override public LinkedHashMap<String, String> getRequiredSubs() {return new LinkedHashMap<String, String>();}
	@Override public LinkedHashMap<DefinableInterrupt, String> getInterrupts() {return new LinkedHashMap<DefinableInterrupt, String>();}
	@Override public LinkedHashMap<String, VariableNode> getGlobalVariables() {return new LinkedHashMap<String, VariableNode>();}
	@Override public List<InitializerNode> getGlobalInitializers() {return new LinkedList<InitializerNode>();}
	@Override public String getFilename() {return filename;}
	public void setFilename(String filename) {this.filename = filename;}
	@Override public Set<String> getIncludedStdLibs() {return new HashSet<String>();}
	@Override public Set<String> getIncludedOtherLibs() {return new HashSet<String>();}
	
	public int getROMSize()
	{
		return ROMSize;
	}
}
