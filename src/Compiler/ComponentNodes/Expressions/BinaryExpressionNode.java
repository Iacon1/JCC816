// By Iacon1
// Created 10/14/2023
// A general expression node.
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Grammar.GeneralParser.GeneralNode;

public abstract class BinaryExpressionNode<P extends ExpressionNode, C extends BinaryExpressionNode<P, C>> extends ExpressionNode
{
	protected abstract P getPrevKind(ComponentNode<?> parent); // Get an instance of the previous node type
	protected abstract C getCurrKind(ComponentNode<?> parent); // Get an instance of the current node type
	
	ExpressionNode x, y;
	
	protected String operator;
	
	public BinaryExpressionNode(ComponentNode<?> parent) {super(parent);}
	
	@Override
	public ExpressionNode interpret(GeneralNode<String, String> node) throws Exception
	{
		if (node.childrenNodes.size() == 1) // Only one, just propagate it
		{
			return getPrevKind(this.parent).interpret(node.getNode(0));
		}
		else // Two
		{
			x = getCurrKind(this).interpret(node.getNode(0));
			y = getPrevKind(this).interpret(node.getNode(1));
			
			operator = "";
			for (String s : node.childrenT) operator += s;
		}
		return this;
	}
}
