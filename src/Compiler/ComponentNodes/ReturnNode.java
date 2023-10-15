// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes;

import Grammar.GeneralParser.GeneralNode;
import Compiler.CompConfig;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;

public class ReturnNode extends ComponentNode<ReturnNode> implements AssemblableNode
{
	private RValNode rValNode;
	
	public ReturnNode(ComponentNode<?> parent) {super(parent);}

	@Override
	public ReturnNode interpret(GeneralNode<String, String> node) throws Exception
	{
		rValNode = new RValNode(this).interpret(node.getNode(0));
		return this;
	}
	
	@Override
	public boolean canCall(FunctionNode function)
	{
		return rValNode.canCall(function);
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String whitespace = getWhitespace(leadingWhitespace);
		String assembly = "";
		
		if (rValNode.hasAssembly()) assembly += rValNode.getAssembly(leadingWhitespace);
		
		assembly += byteCopier(whitespace, rValNode.getType().getSize(), CompConfig.callResult, rValNode.getByteSource(rValNode.getType().getSize()));
		
		assembly += whitespace + "JML\t" + getFunction().getEndLabel() + "\n";
		
		return assembly;
		
	}

}
