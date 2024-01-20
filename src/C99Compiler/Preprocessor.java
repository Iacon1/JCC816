// Created by Iacon1 on 01/14/2024.
// C Preprocessor
package C99Compiler;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import org.antlr.v4.runtime.Token;

import C99Compiler.PreprocNodes.GroupNode;
import C99Compiler.PreprocNodes.PreProcComponentNode;
import Grammar.C99A3.C99A3Lexer;
import Grammar.C99A3.C99A3Parser;
import Grammar.C99A3.C99A3Parser.GroupContext;
import Logging.Logging;

public final class Preprocessor
{
	private static void debugLexer(C99A3Lexer lexer)
	{
		Map<Integer, String> invMap = new HashMap<Integer, String>();
		for (Entry<String, Integer> entry : lexer.getTokenTypeMap().entrySet())
			invMap.put(entry.getValue(), entry.getKey());
		for (Token token : lexer.getAllTokens())
			Logging.logNotice(invMap.get(token.getType()) + " " + token.getText());
		lexer.reset();
	}
	public static final String removeComments(String source)
	{
		String[] lines = source.split("\n");
		source = "";
		boolean bigComment = false;
		for (String line : lines)
		{
			if (bigComment && line.contains("*/"))
			{
				line = line.replaceFirst(".*\\*/", "");
				bigComment = false;
			}
			else if (bigComment) continue;
			line = line.replaceFirst("//.*", "");
			if (line.contains("/*"))
			{
				bigComment = true;
				line = line.replaceFirst("/\\*.*", "");
			}
			if (!line.isEmpty()) source += line + "\n";
		}
		
		return source;
	}

	public static final GroupContext parsePreprocess(String source) throws Exception
	{
		source = removeComments(source);

		SyntaxErrorCollector collector = new SyntaxErrorCollector();
		
		C99A3Lexer lexer = new C99A3Lexer(CharStreams.fromString(source));
//		lexer.removeErrorListeners();
		lexer.addErrorListener(collector);

		CommonTokenStream tokens = new CommonTokenStream(lexer);
//		debugLexer(lexer);
		C99A3Parser parser = new C99A3Parser(tokens);
//		parser.removeErrorListeners(); // Removes default error listener
		parser.addErrorListener(collector);
		
		if (collector.getException() != null) throw collector.getException();

		GroupContext group = parser.group();
//		Logging.viewParseTree(parser, group);
		return group;
	}
	
	public static final String preprocess(String filename, String source) throws Exception
	{
		Grammar.GrammarFlags.isPreproc = true;
		PreProcComponentNode.loadPredefs();
		PreProcComponentNode.resetLineNo(filename, 1);
		source = new GroupNode().interpret(parsePreprocess(source)).getText();

		Grammar.GrammarFlags.isPreproc = false;
		return source;
	}
}
