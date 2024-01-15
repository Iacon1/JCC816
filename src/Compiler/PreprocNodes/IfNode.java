// Created by Iacon1 on 01/15/2024.
// Control-line node
package Compiler.PreprocNodes;

import Grammar.C99.C99Lexer;
import Grammar.C99.C99Parser;
import Grammar.C99.C99Parser.Constant_expressionContext;
import Grammar.C99A3.C99A3Lexer;
import Grammar.C99A3.C99A3Parser;
import Grammar.C99A3.C99A3Parser.Elif_groupContext;
import Grammar.C99A3.C99A3Parser.GroupContext;
import Grammar.C99A3.C99A3Parser.If_sectionContext;
import Grammar.C99A3.C99A3Parser.Pp_tokenContext;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import Compiler.SyntaxErrorCollector;
import Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import Compiler.CompilerNodes.Expressions.ConstantExpressionNode;

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

	@Override
	public IfNode interpret(If_sectionContext node) throws Exception
	{
		boolean foundGroup = false;
		// If group
		if (node.if_group().getChild(1).getText().equals("ifdef")) // ifdef
		{
			incrLineNo(); // If's newline
			if (defines.containsKey(node.if_group().Identifier().getText()))
			{
				setGroup(node.if_group().group());
				foundGroup = true;
			}
		}
		else if (node.if_group().getChild(1).getText().equals("ifndef")) // ifndef
		{
			incrLineNo(); // If's newline
			if (!defines.containsKey(node.if_group().Identifier().getText()))
			{
				setGroup(node.if_group().group());
				foundGroup = true;
			}
		}
		else // if
		{
			List<String> tokens = new ArrayList<String>();
			if (node.if_group().pp_token().size() > 0)
				for (Pp_tokenContext token : node.if_group().pp_token())
					tokens.add(token.getText());
			
			BaseExpressionNode<?> expr = new ConstantExpressionNode().interpret // Process macros before trying to parse
			(
				convert(resolveDefines(tokens.toArray(new String[] {})))
			);
			if (expr.getPropLong() != 0 || expr.getPropBool())
			{
				incrLineNo(); // If's newline
				setGroup(node.if_group().group());
				foundGroup = true;
			}
			else incrLineNo(); // If's newline
		}
		// Elif groups
		if (!foundGroup)
			for (Elif_groupContext elif : node.elif_group()) 
			{
				
				List<String> tokens = new ArrayList<String>();
				if (elif.pp_token().size() > 0)
					for (Pp_tokenContext token : elif.pp_token())
						tokens.add(token.getText());
				
				BaseExpressionNode<?> expr = new ConstantExpressionNode().interpret // Process macros before trying to parse
				(
					convert(resolveDefines(tokens.toArray(new String[] {})))
				);
				if (expr.getPropLong() != 0 || expr.getPropBool())
				{
					incrLineNo(); // Elif's newline
					setGroup(elif.group());
					foundGroup = true;
				}
				else incrLineNo(); // Elif's newline
			}
		
		// Else
		if (!foundGroup & node.else_group() != null)
		{
			incrLineNo(); // Else's newline
			setGroup(node.else_group().group());
			foundGroup = true;
		}
		incrLineNo(); // Endif's newline
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
