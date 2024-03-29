// By Iacon1
// Created 05/06/2023
// The program itself.
package C99Compiler.CompilerNodes;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import C99Compiler.CompConfig.DefinableInterrupt;
import C99Compiler.CompilerNodes.Declarations.DeclarationNode;
import C99Compiler.CompilerNodes.Declarations.InitializerNode;
import C99Compiler.CompilerNodes.Definitions.EnumDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.StructUnionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.EnumeratorNode;
import C99Compiler.CompilerNodes.Interfaces.TranslationUnit;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.Exceptions.CompilerMultipleDefinitionException;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.LineInfo;
import Grammar.C99.C99Parser.External_declarationContext;
import Grammar.C99.C99Parser.Translation_unitContext;

public class TranslationUnitNode extends InterpretingNode<TranslationUnitNode, Translation_unitContext> implements TranslationUnit
{	
	private LinkedHashMap<DefinableInterrupt, String> interrupts;
	private LinkedHashMap<String, Type> typedefs;
	private LinkedHashMap<String, String> requiredSubs;
	private List<LineInfo> lineInfo;
	private Set<String> includedStdLibs;
	private Set<String> includedOtherLibs;
	private List<InitializerNode> globalInitializers;
	private String filename;
	private String staticUUID;
	
	public TranslationUnitNode(ComponentNode<?> parent, String filename, List<LineInfo> lineInfo)
	{
		super(parent);
		interrupts = new LinkedHashMap<DefinableInterrupt, String>();
		typedefs = new LinkedHashMap<String, Type>();
		requiredSubs = new LinkedHashMap<String, String>();
		globalInitializers = new LinkedList<InitializerNode>();
		this.filename = filename;
		this.lineInfo = lineInfo;
		staticUUID = CompUtils.getSafeUUID();
	}
	public TranslationUnitNode(String filename, List<LineInfo> lineInfo)
	{
		super();
		interrupts = new LinkedHashMap<DefinableInterrupt, String>();
		typedefs = new LinkedHashMap<String, Type>();
		requiredSubs = new LinkedHashMap<String, String>();
		globalInitializers = new LinkedList<InitializerNode>();
		this.filename = filename;
		this.lineInfo = lineInfo;
		staticUUID = CompUtils.getSafeUUID();
	}
	
	@Override public LinkedHashMap<String, VariableNode> getVariables() {return getChildVariables();}
	@Override public LinkedHashMap<String, StructUnionDefinitionNode> getStructs() {return getChildStructs();}
	@Override public LinkedHashMap<String, EnumDefinitionNode> getEnums() {return getChildEnums();}
	@Override public LinkedHashMap<String, EnumeratorNode> getEnumerators() {return getChildEnumerators();}
	@Override public LinkedHashMap<String, FunctionDefinitionNode> getFunctions() {return getChildFunctions();}
	@Override public LinkedHashMap<String, Type> getTypedefs() {return typedefs;}
	@Override public LinkedHashMap<String, String> getRequiredSubs() {return requiredSubs;}
	@Override public LinkedHashMap<DefinableInterrupt, String> getInterrupts() {return interrupts;}
	@Override
	public List<InitializerNode> getGlobalInitializers()
	{
		return globalInitializers;
	}
	public void registerTypedef(String name, Type type)
	{
		typedefs.put(name, type);
	}
	
	public void requireSub(String name, String assembly)
	{
		requiredSubs.put(name, assembly);
	}
	public void registerInterrupt(DefinableInterrupt interrupt, String funcName)
	{
		interrupts.put(interrupt, funcName);
	}
	
	@Override
	public TranslationUnitNode interpret(Translation_unitContext node) throws Exception
	{
		for (External_declarationContext extDec : node.external_declaration())
		{
			Exception innerException = new Exception();
			if (extDec.declaration() != null)
			{
				DeclarationNode declNode = new DeclarationNode(this).interpret(extDec.declaration());
				for (ComponentNode<?> child : declNode.children)
					if ((InitializerNode.class.isAssignableFrom(child.getClass())))
						globalInitializers.add((InitializerNode) child);
			}
			else
			{
				FunctionDefinitionNode oldFunction = checkRepeatFunctions((ComponentNode<?> c) -> {
							try {return new FunctionDefinitionNode(c).interpret(extDec.function_definition());}
							catch (Exception e) {innerException.addSuppressed(e); return null;}});
				if (innerException.getSuppressed().length > 0) throw (Exception) innerException.getSuppressed()[0]; // Weird hack I know

				if (oldFunction != null && oldFunction.isImplemented()) // Two implemented functions cannot have same erasure and name
					throw new CompilerMultipleDefinitionException(oldFunction.getName(), extDec.start); 
				else if (oldFunction != null) // Function definition found but not signature
					oldFunction.implement(extDec.function_definition().compound_statement());
				else // No preceeding function found
					new FunctionDefinitionNode(this).interpret(extDec.function_definition());
			}
		}

		return this;
	}
	public void includeStdLibs(Set<String> includedStdLibs)
	{
		this.includedStdLibs = includedStdLibs;
	}
	public void includeOtherLibs(Set<String> includedOtherLibs)
	{
		this.includedOtherLibs = includedOtherLibs;
	}
	@Override
	public Set<String> getIncludedStdLibs()
	{
		return includedStdLibs;
	}
	@Override
	public Set<String> getIncludedOtherLibs()
	{
		return includedOtherLibs;
	}
	@Override
	public String getFilename() {return filename;}
	public LinkedHashMap<String, VariableNode> getGlobalVariables()
	{
		LinkedHashMap<String, VariableNode> globals = new LinkedHashMap<String, VariableNode>();
		for (ComponentNode<?> node : children)
		{
			if (VariableNode.class.isAssignableFrom(node.getClass()))
				globals.put(((VariableNode) node).getFullName(), (VariableNode) node);
		}
		return globals;
	}
	public String getStaticUUID() {return staticUUID;}
	
	public LineInfo getInfo(int i) {return lineInfo.get(i);}
}
