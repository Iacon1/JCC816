// Created by Iacon1 on 01/17/2024.
// Reveals none of its subnodes.
package C99Compiler.CompilerNodes;

import java.util.LinkedHashMap;

import C99Compiler.CompilerNodes.Definitions.EnumDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.StructUnionDefinitionNode;
import C99Compiler.CompilerNodes.Dummies.EnumeratorNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;

class HiddenNode extends ComponentNode<HiddenNode>
{
	private byte mask;
	
	public static final byte
		noVars		= 0b00000001,
		noRVars		= 0b00000010,
		noStructs	= 0b00000100,
		noEnums		= 0b00001000,
		noEnumers	= 0b00010000,
		noFuncs		= 0b00100000;
	
	public HiddenNode(byte mask, ComponentNode<?> parent)
	{
		super(parent);
		this.mask = mask;
	}
	
	@Override
	public LinkedHashMap<String, VariableNode> getChildVariables(boolean strict)
	{
		if ((mask & noVars) != 0)
			return new LinkedHashMap<String, VariableNode>();
		else return super.getChildVariables(strict); 
	}
	@Override
	public LinkedHashMap<String, VariableNode> getReferencedVariables(boolean strict)
	{
		if ((mask & noRVars) != 0)
			return new LinkedHashMap<String, VariableNode>();
		else return super.getReferencedVariables(strict); 
	}
	@Override
	public LinkedHashMap<String, StructUnionDefinitionNode> getChildStructs()
	{
		if ((mask & noStructs) != 0)
			return new LinkedHashMap<String, StructUnionDefinitionNode>();
		else return super.getChildStructs();
	}
	@Override
	public LinkedHashMap<String, EnumDefinitionNode> getChildEnums()
	{
		if ((mask & noEnums) != 0)
			return new LinkedHashMap<String, EnumDefinitionNode>();
		else return super.getChildEnums(); 
	}
	@Override
	public LinkedHashMap<String, EnumeratorNode> getChildEnumerators()
	{
		if ((mask & noEnumers) != 0)
			return new LinkedHashMap<String, EnumeratorNode>();
		else return super.getChildEnumerators(); 
	}
	@Override
	public LinkedHashMap<String, FunctionDefinitionNode> getChildFunctions()
	{
		if ((mask & noFuncs) != 0)
			return new LinkedHashMap<String, FunctionDefinitionNode>();
		else return super.getChildFunctions(); 
	}
}
