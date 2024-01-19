// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.CompilerNodes;

import java.util.LinkedHashMap;
import java.util.function.Function;

import Compiler.CompConfig.DefinableInterrupt;
import Compiler.CompilerNodes.Declarations.DeclarationNode;
import Compiler.CompilerNodes.Definitions.EnumDefinitionNode;
import Compiler.CompilerNodes.Definitions.StructUnionDefinitionNode;
import Compiler.CompilerNodes.Definitions.Type;
import Compiler.CompilerNodes.Dummies.EnumeratorNode;
import Compiler.CompilerNodes.Interfaces.Catalogger;
import Compiler.CompilerNodes.LValues.VariableNode;
import Compiler.Exceptions.CompilerMultipleDefinitionException;
import Grammar.C99.C99Parser.External_declarationContext;
import Grammar.C99.C99Parser.Translation_unitContext;

public class TranslationUnitNode extends InterpretingNode<TranslationUnitNode, Translation_unitContext> implements Catalogger
{	
	private LinkedHashMap<DefinableInterrupt, String> interrupts;
	private LinkedHashMap<String, Type> typedefs;
	private LinkedHashMap<String, String> requiredSubs;
	
	public TranslationUnitNode(ComponentNode<?> parent)
	{
		super(parent);
		interrupts = new LinkedHashMap<DefinableInterrupt, String>();
		typedefs = new LinkedHashMap<String, Type>();
		requiredSubs = new LinkedHashMap<String, String>();
	}
	public TranslationUnitNode()
	{
		super();
		interrupts = new LinkedHashMap<DefinableInterrupt, String>();
		typedefs = new LinkedHashMap<String, Type>();
		requiredSubs = new LinkedHashMap<String, String>();
	}
	
	@Override public LinkedHashMap<String, VariableNode> getVariables() {return getChildVariables();}
	@Override public LinkedHashMap<String, StructUnionDefinitionNode> getStructs() {return getChildStructs();}
	@Override public LinkedHashMap<String, EnumDefinitionNode> getEnums() {return getChildEnums();}
	@Override public LinkedHashMap<String, EnumeratorNode> getEnumerators() {return getChildEnumerators();}
	@Override public LinkedHashMap<String, FunctionDefinitionNode> getFunctions() {return getChildFunctions();}
	@Override public LinkedHashMap<String, Type> getTypedefs() {return typedefs;}
	@Override public LinkedHashMap<String, String> getRequiredSubs() {return requiredSubs;}
	@Override public LinkedHashMap<DefinableInterrupt, String> getInterrupts() {return interrupts;}

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
			if (extDec.declaration() != null) new DeclarationNode(this).interpret(extDec.declaration());
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
}