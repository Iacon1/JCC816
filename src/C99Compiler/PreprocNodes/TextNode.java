// Created by Iacon1 on 01/15/2024.
// Text node
package C99Compiler.PreprocNodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import C99Compiler.Utils.LineInfo;
import Grammar.C99A3.C99A3Parser.Pp_tokenContext;
import Grammar.C99A3.C99A3Parser.Text_lineContext;

public class TextNode extends InterpretingNode<TextNode, Text_lineContext> implements GeneratingNode
{
	private List<String> words;
	private List<LineInfo> lineInfo;
	public TextNode(PreProcComponentNode<?> parent)
	{
		super(parent);
		words = new LinkedList<String>();
		lineInfo = new LinkedList<LineInfo>();
	}
	public TextNode()
	{
		super();
		words = new LinkedList<String>();
	}
	
	@Override
	public TextNode interpret(Text_lineContext node) throws Exception
	{
		List<String> tokens = new ArrayList<String>();
		if (node.pp_token().size() > 0) for (Pp_tokenContext token : node.pp_token()) tokens.add(token.getText());
		tokens = resolveDefines(tokens.toArray(new String[] {}));
		if (tokens != null && tokens.size() > 0) words.addAll(tokens);
		try
		{
			for (int i = 0; i < getText().split("\n").length; ++i)
				lineInfo.add(new LineInfo(file, line + i, isStd));
		}
		catch (Exception e) {}
		incrLineNo();
		return this;
	}
	@Override
	public boolean hasText() {return !words.isEmpty();}
	
	@Override
	public String getText() throws Exception
	{
		String text = "";
		for (String word : words) text += word + " ";
		return text.stripTrailing() + "\n";
	}
	
	@Override
	public List<LineInfo> getLineInfo(int offset)
	{
		List<LineInfo> list = new LinkedList<LineInfo>();
		for (LineInfo info : lineInfo)
		{
			LineInfo newInfo = new LineInfo(info);
			newInfo.line += offset;
			list.add(newInfo);
		}
		return list;
	}
}
