// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.CompilerNodes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Compiler.CompConfig.DefinableInterrupt;
import Compiler.CompilerNodes.Declarations.DeclarationNode;
import Compiler.CompilerNodes.Definitions.EnumDefinitionNode;
import Compiler.CompilerNodes.Definitions.StructUnionDefinitionNode;
import Compiler.CompilerNodes.Definitions.Type;
import Compiler.CompilerNodes.Dummies.EnumeratorNode;
import Compiler.CompilerNodes.Interfaces.Catalogger;
import Compiler.CompilerNodes.LValues.VariableNode;
import Grammar.C99.C99Parser.External_declarationContext;
import Grammar.C99.C99Parser.Translation_unitContext;

public class TranslationUnitNode extends InterpretingNode<TranslationUnitNode, Translation_unitContext> implements Catalogger
{	
	private Map<DefinableInterrupt, String> interrupts;
	private Map<String, Type> typedefs;
	private Map<String, String> requiredSubs;
	
	public TranslationUnitNode(ComponentNode<?> parent)
	{
		super(parent);
		interrupts = new HashMap<DefinableInterrupt, String>();
		typedefs = new HashMap<String, Type>();
		requiredSubs = new HashMap<String, String>();
	}
	public TranslationUnitNode()
	{
		super();
		interrupts = new HashMap<DefinableInterrupt, String>();
		typedefs = new HashMap<String, Type>();
		requiredSubs = new HashMap<String, String>();
	}
	
	@Override public List<VariableNode> getVariables() {return getChildVariables();}
	@Override public List<StructUnionDefinitionNode> getStructs() {return getChildStructs();}
	@Override public List<EnumDefinitionNode> getEnums() {return getChildEnums();}
	@Override public List<EnumeratorNode> getEnumerators() {return getChildEnumerators();}
	@Override public List<FunctionDefinitionNode> getFunctions() {return getChildFunctions();}
	@Override public Map<String, Type> getTypedefs() {return typedefs;}
	@Override public Map<String, String> getRequiredSubs() {return requiredSubs;}
	@Override public Map<DefinableInterrupt, String> getInterrupts() {return interrupts;}

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
			if (extDec.declaration() != null) new DeclarationNode(this).interpret(extDec.declaration());
			else new FunctionDefinitionNode(this).interpret(extDec.function_definition());
		}

		return this;
	}	
}
