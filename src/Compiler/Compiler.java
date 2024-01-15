// Created by Iacon1 on 2/7/2022.
// Compiler

package Compiler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;

import Compiler.CompilerNodes.Globals;
import Compiler.CompilerNodes.ProgramNode;
import Grammar.C99.C99Lexer;
import Grammar.C99.C99Parser;
import Grammar.C99.C99Parser.ProgramContext;
import Logging.Logging;

public class Compiler
{
	private static class ParseDouble
	{
		public C99Parser parser;
		public ParseTree tree;
	}
	private static void printInfo(Object... info)
	{
		for (int i = 0; i < info.length; ++i) Logging.logNotice(info[i].toString() + (i == info.length - 1 ? "" : ", ") + "\n");
	}
	
	private static CommonTokenStream lex(String source)
	{
		C99Lexer lexer = new C99Lexer(CharStreams.fromString(source));
		
		return new CommonTokenStream(lexer);
	}

	
	private static ParseDouble parse(CommonTokenStream tokens) throws Exception
	{
		SyntaxErrorCollector collector = new SyntaxErrorCollector();
		ParseDouble parseDouble = new ParseDouble();
		parseDouble.parser = new C99Parser(tokens);
		parseDouble.parser.removeErrorListeners(); // Removes default error listener
		parseDouble.parser.addErrorListener(collector);
		parseDouble.tree = parseDouble.parser.program();
		
		if (collector.getException() != null) throw collector.getException();
		return parseDouble;
	}
	
	private static String emit(ParseDouble parseDouble) throws Exception
	{
		Globals.reset();
		ProgramNode program = new ProgramNode().interpret((ProgramContext) parseDouble.tree);
		program.getAssembly();
		return program.getAssembly();

	}
	private static String precompile(String mainFile)
	{
		// Not using a language-based approach because ANTLR doesn't like the one they had in the C docs for preprocessing
		String[] lines = mainFile.split("\n");
		String source = "";
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
			if (line.contains("/*")) bigComment = true;
			if (!line.isEmpty()) source += line + "\n";
		}
		
		return source;
	}
	
	
	private  static String postprocess(String assembly) throws Exception
	{
		ArrayList<String> lines = new ArrayList<String>(Arrays.asList(assembly.split("\n")));

		lines = (ArrayList<String>) AssemblyOptimizer.optimizeAssembly((List<String>) lines);
		int banks = Banker.splitBanks(lines);
		
		assembly = "";
		for (String line : lines) if (!line.matches("\s*")) assembly += line + "\n";
		return assembly;
	}
		
	
	public static String compile(String mainFile, boolean debug) throws Exception
	{ 
		String assembly = "";

		long t = System.currentTimeMillis();

		String source = precompile(mainFile);
		printInfo("Precompiled in " + (System.currentTimeMillis() - t) + " ms. Source length: " + source.length() + ".");
		t = System.currentTimeMillis();
//		Logging.logNotice(source);
		CommonTokenStream tokens = lex(source);
		printInfo("Lexed in " + (System.currentTimeMillis() - t) + " ms. Tokens: " + tokens.getNumberOfOnChannelTokens() + ".");
		t = System.currentTimeMillis();

		ParseDouble parseDouble = parse(tokens);
		printInfo("Parsed in " + (System.currentTimeMillis() - t) + " ms.");
		if (debug) Logging.viewParseTree(parseDouble.parser, parseDouble.tree);
		t = System.currentTimeMillis();

		assembly = emit(parseDouble);
		printInfo("Emitted in " + (System.currentTimeMillis() - t) + " ms. Assembly length: " + assembly.length() + ".");
		t = System.currentTimeMillis();

		assembly = postprocess(assembly);
		printInfo("Postprocessed in " + (System.currentTimeMillis() - t) + " ms. New assembly length: " + assembly.length() + ".");
		t = System.currentTimeMillis();
		
		return assembly;
	}
	
}
