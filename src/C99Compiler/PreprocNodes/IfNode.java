// Created by Iacon1 on 01/15/2024.
// Control-line node
package C99Compiler.PreprocNodes;

import Grammar.C99.C99Lexer;
import Grammar.C99.C99Parser;
import Grammar.C99A3.C99A3Parser.Elif_groupContext;
import Grammar.C99A3.C99A3Parser.GroupContext;
import Grammar.C99A3.C99A3Parser.If_sectionContext;
import Grammar.C99A3.C99A3Parser.Pp_tokenContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import C99Compiler.SyntaxErrorCollector;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.ConstantExpressionNode;
import C99Compiler.Utils.ProgramState;

public class IfNode extends InterpretingNode<IfNode, If_sectionContext> implements GeneratingNode
{
	private GroupNode group;
	
	public IfNode(PreProcComponentNode<?> parent)
	{
		super(parent);
		group = null;
	}
	public IfNode()
	{
		super();
		group = null;
	}
	
	private void setGroup(GroupContext c) throws Exception
	{
		if (c != null)
			group = new GroupNode(this).interpret(c);
	}
	private static C99Parser.Constant_expressionContext convert(String text) throws Exception
	{
		SyntaxErrorCollector collector = new SyntaxErrorCollector();
		
		C99Lexer lexer = new C99Lexer(CharStreams.fromString(text));
		//lexer.removeErrorListeners();
		lexer.addErrorListener(collector);

		CommonTokenStream tokens = new CommonTokenStream(lexer);
		//debugLexer(lexer);
		C99Parser parser = new C99Parser(tokens);
		//parser.removeErrorListeners(); // Removes default error listener
		parser.addErrorListener(collector);
		
		if (collector.getException() != null) throw collector.getException();
		return parser.constant_expression();
	}
	private static C99Parser.Constant_expressionContext convert(List<String> words) throws Exception
	{
		String text = "";
		for (String word : words) text += word + " ";
		return convert(text.stripTrailing());
	}

	private static class IfEntry
	{
		int startLine;
		GroupContext context;
		long nLines;
		boolean used;
	}
	@Override
	public IfNode interpret(If_sectionContext node) throws Exception
	{
		List<IfEntry> entries = new LinkedList<IfEntry>();
		int startLine = getCurrLineInfo().line;
		// If group
		if (node.if_group().getChild(1).getText().equals("ifdef")) // ifdef
		{
			IfEntry e = new IfEntry();
			e.startLine = startLine + 1;
			e.context = node.if_group().group();
			e.nLines = 1 + e.context.getText().lines().count();
			e.used = defines.containsKey(node.if_group().Identifier().getText());
			entries.add(e);
			startLine += e.nLines;
		}
		else if (node.if_group().getChild(1).getText().equals("ifndef")) // ifndef
		{
			IfEntry e = new IfEntry();
			e.startLine = startLine + 1;
			e.context = node.if_group().group();
			e.nLines = 1 + e.context.getText().lines().count();
			e.used = !defines.containsKey(node.if_group().Identifier().getText());
			entries.add(e);
			startLine += e.nLines;
		}
		else // if
		{
			List<String> tokens = new ArrayList<String>();
			if (node.if_group().pp_token().size() > 0)
				for (Pp_tokenContext token : node.if_group().pp_token())
					tokens.add(token.getText());
			
			//Resolve defined first
			List<String> wordList = new ArrayList<String>(Arrays.asList(tokens.toArray(new String[] {})));
			int i = 0;
			while (i < (wordList.size()-3)) {
				String word = wordList.get(i);
				
				
				if ( word.equals("defined") ) {
					boolean isDef1 = (i+3 < wordList.size()) && wordList.get(i + 1).equals("(") && wordList.get(i + 3).equals(")");
					boolean isDef2 = (i+1 < wordList.size()) && (Character.isLetter(wordList.get(i+1).charAt(0)) || (wordList.get(i+1).charAt(0) == '_'));
					
					if (isDef1) {
						if (defines.containsKey(wordList.get(i+2))) {
							wordList.set(i,"1");
						}
						else {
							wordList.set(i,"0");
						}						
						wordList.remove(i+3);						
						wordList.remove(i+2);
						wordList.remove(i+1);
						//wordList.remove(i); Already overwritten
					}
					else if (isDef2) {
						if (defines.containsKey(wordList.get(i+2))) {
							wordList.set(i,"1");
						}
						else {
							wordList.set(i,"0");
						}
						wordList.remove(i+1);												
					}
					else {
						throw new Exception("error malformed defined macro call");
					}
				}
				i++;
			}
			
			
			BaseExpressionNode<?> expr = new ConstantExpressionNode().interpret // Process macros before trying to parse
			(
				convert(clearIdentifiers(resolveDefines(wordList.toArray(new String[] {}))))
			);
			
			IfEntry e = new IfEntry();
			e.startLine = startLine + 1;
			e.context = node.if_group().group();
			if (e.context != null)
			{
				e.nLines = 1 + e.context.getText().lines().count();
				e.used = expr.getPropLong(new ProgramState()) != 0 || expr.getPropBool(new ProgramState());
			}
			else
			{
				e.nLines = 0;
				e.used = false;
			}
			entries.add(e);
			startLine += e.nLines;
		}
		// Elif groups
		for (Elif_groupContext elif : node.elif_group()) 
		{
			List<String> tokens = new ArrayList<String>();
			if (elif.pp_token().size() > 0)
				for (Pp_tokenContext token : elif.pp_token())
					tokens.add(token.getText());
			
			BaseExpressionNode<?> expr = new ConstantExpressionNode().interpret // Process macros before trying to parse
			(
				convert(clearIdentifiers(resolveDefines(tokens.toArray(new String[] {}))))
			);

			IfEntry e = new IfEntry();
			e.startLine = startLine + 1;
			e.context = elif.group();
			e.nLines = 1 + e.context.getText().lines().count();
			e.used = expr.getPropLong(new ProgramState()) != 0 || expr.getPropBool(new ProgramState());
			entries.add(e);
			startLine += e.nLines;
		}
		
		// Else
		if (node.else_group() != null)
		{
			IfEntry e = new IfEntry();
			e.startLine = startLine + 1;
			e.context = node.else_group().group();
			e.nLines = 1 + e.context.getText().lines().count();
			e.used = true;
			entries.add(e);
			startLine += e.nLines;
		}
		resetLineNo(startLine);
		boolean foundGroup = false;
		for (IfEntry e : entries)
		{
			if (foundGroup)
				addLines((int) e.nLines);
			else if (e.used)
			{
				resetLineNo(e.startLine);
				setGroup(e.context);
				foundGroup = true;
			}
		}
		incrLineNo(); // #endif
		return this;
	}
	
	@Override
	public boolean hasText()
	{
		return group != null && group.hasText();
	}
	
	@Override
	public String getText() throws Exception
	{
		return group.getText();
	}
}
