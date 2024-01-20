// Created by Iacon1 on 01/15/2024.
// Group of preprocessing parts

package C99Compiler.PreprocNodes;

import java.util.LinkedList;
import java.util.List;

import Grammar.C99A3.C99A3Parser.GroupContext;
import Grammar.C99A3.C99A3Parser.Group_partContext;

public class GroupNode extends InterpretingNode<GroupNode, GroupContext> implements GeneratingNode
{
	private List<GeneratingNode> parts;
	
	public GroupNode(PreProcComponentNode<?> parent)
	{
		super(parent);
		parts = new LinkedList<GeneratingNode>();
	}
	public GroupNode()
	{
		super();
		parts = new LinkedList<GeneratingNode>();
	}
	
	@Override
	public GroupNode interpret(GroupContext node) throws Exception
	{
		for (Group_partContext part : node.group_part())
		{
			if (part.if_section() != null)
				parts.add(new IfNode(this).interpret(part.if_section()));
			else if (part.control_line() != null)
				parts.add(new ControlNode(this).interpret(part.control_line()));
			else if (part.text_line() != null)
				parts.add(new TextNode(this).interpret(part.text_line()));
			else if (part.non_directive() != null)
			{
				incrLineNo();
				continue; // Does nothing
			}
		}
		
		return this;
	}

	@Override
	public boolean hasText()
	{
		for (GeneratingNode part : parts)
			if (part.hasText()) return true;
		return false;
	}
	
	@Override
	public String getText() throws Exception
	{
		String text = "";
		for (GeneratingNode part : parts)
			if (part.hasText()) text += part.getText();
		
		return text;
	}
}
