// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes;

import Compiler.ComponentNodes.Interfaces.AssemblableNode;

public class StatementNode extends ComponentNode<StatementNode> implements AssemblableNode
{
	public StatementNode(ComponentNode<?> parent) {super(parent);}
	
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String assembly = "";
		
		for (ComponentNode<?> child : children)
			if (AssemblableNode.class.isAssignableFrom(child.getClass())) // Child assemblable
				assembly += ((AssemblableNode) child).getAssembly(leadingWhitespace);
		return assembly;
	}
}
