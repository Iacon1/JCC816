// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes;

import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Grammar.GeneralParser.GeneralNode;

public class AssignmentNode extends ComponentNode<AssignmentNode> implements AssemblableNode
{
	private String x;
	private RValNode y;
	
	public AssignmentNode(ComponentNode<?> parent) {super(parent);}
	
	@Override
	public AssignmentNode interpret(GeneralNode<String, String> node) throws Exception
	{
		switch (node.childrenNodes.size()) // How many non-terminals?
		{
		case 1: // Possible forms: [var] = [rVal]
			x = node.getT(0);
			y = new RValNode(this).interpret(node.getNode(0));
			break;
		default:
			break;
		}

		return this;
	}
	
	@Override
	public boolean canCall(FunctionNode function)
	{
		return y.canCall(function);
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String whitespace = getWhitespace(leadingWhitespace);
		String assembly = "";
		VarDeclarationNode xNode;
		
		xNode = resolveVariable(x);	
		if (!xNode.canCastFrom(y.getType()))
		{
			//throw TypeMismatchException();
		}
		if (y.hasAssembly())
			assembly += y.getAssembly(leadingWhitespace, xNode.getFullName());
		else assembly += byteCopier(whitespace, xNode.getType().getSize(), xNode.getFullName(), y.getByteSource(xNode.getType().getSize()));
		
		return assembly;
	}

}
