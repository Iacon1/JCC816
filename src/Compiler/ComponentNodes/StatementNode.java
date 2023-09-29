// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes;

import Grammar.GeneralParser;
import Grammar.GeneralParser.GeneralNode;

public class StatementNode extends ComponentNode<StatementNode>
{
	public StatementNode(ComponentNode<?> parent) {super(parent);}
	
	@Override
	public <P extends GeneralParser> StatementNode interpret(GeneralNode<String> node)
	{
		switch (node.subRule)
		{
		case 0: // Variable
			new VariableNode(this).interpret(node);
			break;
		case 1: // Two statements
			new StatementNode(this).interpret(node.getNode(0));
			new StatementNode(this).interpret(node.getNode(1));
			break;
		}
		
		return this;
	}
	
}
