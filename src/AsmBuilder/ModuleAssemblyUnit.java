// Created by Iacon1 on 02/14/2024.
// Assembly file translation unit

package AsmBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import C99Compiler.CompConfig.DefinableInterrupt;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Declarations.InitializerNode;
import C99Compiler.CompilerNodes.Definitions.EnumDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.StructUnionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.EnumeratorNode;
import C99Compiler.CompilerNodes.Interfaces.TranslationUnit;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.Utils.FileIO;

public class ModuleAssemblyUnit extends AssemblyUnit
{
	private static final String header = "JCC precompiled module";
	
	public static String getPrefix()
	{
		return "; " + header + ": ";
	}
	private TranslationUnit unit;
	
	public ModuleAssemblyUnit(TranslationUnit unit, String assembly)
	{
		super(null, assembly);
		this.unit = unit;
	}
	public ModuleAssemblyUnit(String input) throws ClassNotFoundException, IOException
	{
		String unitString = input.split("\n")[0].replace("; " + header + ": ", "");
		byte[] unitBytes = new byte[unitString.length() / 2];
		int i = 0;
		while (!unitString.isEmpty())
		{
			unitBytes[i++] = (byte) (int) Integer.valueOf(unitString.substring(0, 2), 16);
			unitString = unitString.substring(2);
		}
		unit = FileIO.deserialize(unitBytes);
		assembly = input.replaceFirst("[^\n]*\n", "");
	}
	@Override public LinkedHashMap<String, VariableNode> getVariables() {return unit.getVariables();}
	@Override public LinkedHashMap<String, StructUnionDefinitionNode> getStructs() {return unit.getStructs();}
	@Override public LinkedHashMap<String, EnumDefinitionNode> getEnums() {return unit.getEnums();}
	@Override public LinkedHashMap<String, EnumeratorNode> getEnumerators() {return unit.getEnumerators();}
	@Override public LinkedHashMap<String, FunctionDefinitionNode> getFunctions()
	{
		return unit.getFunctions();
	}
	@Override public LinkedHashMap<String, Type> getTypedefs() {return unit.getTypedefs();}
	@Override public LinkedHashMap<String, String> getRequiredSubs() {return unit.getRequiredSubs();}
	@Override public LinkedHashMap<DefinableInterrupt, String> getInterrupts() {return unit.getInterrupts();}
	@Override public LinkedHashMap<String, VariableNode> getGlobalVariables() {return unit.getGlobalVariables();}
	@Override public List<InitializerNode> getGlobalInitializers() {return unit.getGlobalInitializers();}
	@Override public String getFilename() {return unit.getFilename();}
	@Override public Set<String> getIncludedStdLibs() {return unit.getIncludedStdLibs();}
	@Override public Set<String> getIncludedOtherLibs() {return unit.getIncludedOtherLibs();}
	
	public byte[] save() throws IOException
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		if (unit != null && Serializable.class.isAssignableFrom(unit.getClass()))
		{
			byte[] unitBytes = FileIO.serialize((Serializable) unit);

			out.write(getPrefix().getBytes());
			for (byte b: unitBytes)
				out.write("%02x".formatted(b).getBytes());
			out.write('\n');
			out.write(assembly.getBytes());
		}
		else
			out.write(assembly.getBytes());
		
		return out.toByteArray();
	}
	
	public TranslationUnit getUnit() {return unit;}
}
