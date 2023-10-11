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
	private List<Object> parameters;
	
	public ArgListNode(ComponentNode<?> parent) {super(parent);}

	@Override
	public ArgListNode interpret(GeneralNode<String, String> node) throws Exception
	{
		parameters = new ArrayList<Object>();
		if (node.childrenT.size() > 0 && node.getT(0).equals(",")) // Split
		{
			ArgListNode x = new ArgListNode(this).interpret(node.getNode(0));
			ArgListNode y = new ArgListNode(this).interpret(node.getNode(1));
			
			parameters.addAll(x.parameters);
			parameters.addAll(y.parameters);
		}
		else if (node.childrenT.size() > 0) // A literal or variable
			parameters.add(node.getT(0)); // We'll figure out which during assembly
		else // Expression or call
		{
			switch (Compiler.getType(node.getNode(0).ruleName))
			{
			case expression:
				parameters.add(new ExpressionNode(this).interpret(node.getNode(0)));
				break;
			case functionCall:
				parameters.add(new FunctionCallNode(this).interpret(node.getNode(0)));
				break;
			default:
				break;
			}
		}

		return this;
	}
	
	public List<Object> getArguments()
	{
		return parameters;
	}
}
