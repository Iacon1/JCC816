// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes;

import Grammar.GeneralParser.GeneralNode;
import Compiler.CompConfig;
import Compiler.Compiler;
import Compiler.ComponentNodes.Exceptions.TypeMismatchException;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Compiler.ComponentNodes.Interfaces.TypedNode;

public class AttributeNode extends ComponentNode<AttributeNode>
{
	public AttributeNode(ComponentNode<?> parent) {super(parent);}

	@Override
	public AttributeNode interpret(GeneralNode<String, String> node) throws Exception
	{
		if (getFunction() != null) getFunction().addAttribute(node.getT(2));
		return this;
	}
}
