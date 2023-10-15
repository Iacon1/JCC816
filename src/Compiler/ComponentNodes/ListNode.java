// By Iacon1
// Created 10/14/2023
// A node whose grammar is a list of a different type of a node, generally like so:
// I: ...
// L: I
// L: L [maybe some terminals here] I
package Compiler.ComponentNodes;

import java.util.ArrayList;
import java.util.List;

import Grammar.GeneralParser.GeneralNode;
public abstract class ListNode<I extends ComponentNode<I>, L extends ListNode<I, L>> extends ComponentNode<L>
{
	protected List<I> items;
	protected abstract I getItem(ComponentNode<?> parent); // Get another list node
	protected abstract L getSubList(ComponentNode<?> parent); // Get another list node
	
	public ListNode(ComponentNode<?> parent)
	{
		super(parent);
		items = new ArrayList<I>();
	}
	@Override
	public L interpret(GeneralNode<String, String> node) throws Exception
	{
		if (node.childrenNodes.size() == 2)
		{
			items = getSubList(this).interpret(node.getNode(0)).items;
			items.add(getItem(this).interpret(node.getNode(1)));
		}
		else items.add(getItem(this).interpret(node.getNode(0)));
		
		return (L) this;
	}
}
