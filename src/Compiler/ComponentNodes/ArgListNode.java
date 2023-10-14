// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes;

import Grammar.GeneralParser.GeneralNode;

import java.util.ArrayList;
import java.util.List;

import Compiler.Compiler;

public class ArgListNode extends ComponentNode<ArgListNode>
{
	private List<RValNode> parameters;
	
	public ArgListNode(ComponentNode<?> parent) {super(parent);}

	@Override
	public ArgListNode interpret(GeneralNode<String, String> node) throws Exception
	{
		parameters = new ArrayList<RValNode>();
		if (node.childrenT.size() > 0 && node.getT(0).equals(",")) // Split
		{
			ArgListNode x = new ArgListNode(this).interpret(node.getNode(0));
			ArgListNode y = new ArgListNode(this).interpret(node.getNode(1));
			
			parameters.addAll(x.parameters);
			parameters.addAll(y.parameters);
		}
		else // Only an r-val node
			parameters.add(new RValNode(this).interpret(node.getNode(0)));

		return this;
	}
	
	public List<RValNode> getArguments()
	{
		return parameters;
	}
}
