// Created by Iacon1 on 01/15/2024.
// A define.

package C99Compiler.PreprocNodes;

import java.util.LinkedList;
import java.util.List;

import C99Compiler.CompConfig;
import C99Compiler.Utils.LineInfo;

public class DefineNode extends PreProcComponentNode<DefineNode> implements GeneratingNode
{
	private String[] parameters, replacements;

	public DefineNode(PreProcComponentNode<?> parent, String[] replacements)
	{
		super(parent);
		this.parameters = null;
		this.replacements = replacements;
	}
	public DefineNode(String... replacements)
	{
		super();
		this.parameters = null;
		this.replacements = replacements;
	}
	public DefineNode(PreProcComponentNode<?> parent, String[] parameters, String[] replacements)
	{
		super(parent);
		this.parameters = parameters;
		this.replacements = replacements;
	}
	public DefineNode(String[] parameters, String[] replacements)
	{
		super();
		this.parameters = parameters;
		this.replacements = replacements;
	}
	
	public boolean hasParameters()
	{
		return parameters != null && parameters.length > 0;
	}
	
	@Override
	public boolean hasText()
	{
		return replacements.length > 0;
	}

	private int indexOfParam(String parameter)
	{
		for (int i = 0; i < parameters.length; ++i)
			if (parameters[i].equals(parameter)) return i;
		return -1;
	}
	public String getText(String... parameters) throws Exception
	{
		String text = "";
		if (parameters.length != this.parameters.length) throw new Exception("Bad macro"); // TODO
		for (String word : replacements)
		{
			int i = indexOfParam(word);
			if (i != -1) word = parameters[i];
			text += word + " ";
		}
		return text.stripTrailing();
	}
	@Override
	public String getText() throws Exception
	{
		String text = "";
		for (String word : replacements) text += word + " ";
		return text.stripTrailing();
	}
}
