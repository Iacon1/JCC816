// Created by Iacon1 on 2/7/2022.
// Compiler

package Compiler;

import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import Compiler.CompConfig.VerbosityLevel;
import Compiler.CompilerNodes.TranslationUnitNode;
import Grammar.C99.C99Lexer;
import Grammar.C99.C99Parser;
import Grammar.C99.C99Parser.Translation_unitContext;
import Logging.Logging;

public class Compiler
{
	private static void printInfo(Object... info)
	{
		for (int i = 0; i < info.length; ++i) Logging.logNotice(info[i].toString() + (i == info.length - 1 ? "" : ", ") + "\n");
	}
	
	private static CommonTokenStream lex(String source)
	{
		C99Lexer lexer = new C99Lexer(CharStreams.fromString(source));
		
		return new CommonTokenStream(lexer);
	}
	private static TranslationUnitNode parse(CommonTokenStream tokens) throws Exception
	{
		SyntaxErrorCollector collector = new SyntaxErrorCollector();
		C99Parser parser = new C99Parser(tokens);
		parser.removeErrorListeners(); // Removes default error listener
		parser.addErrorListener(collector);
		
		Translation_unitContext tree = parser.translation_unit();
//		Logging.viewParseTree(parser, tree);
		if (collector.getException() != null) throw collector.getException();
		return new TranslationUnitNode().interpret(tree);
	}

	private static String precompile(String filename, String mainFile) throws Exception
	{
		return Preprocessor.preprocess(filename, mainFile);
	}
	
	
		
	public static void procPragma(List<String> parameters)
	{
		// TODO
	}
	public static TranslationUnitNode compile(String filename, String file) throws Exception
	{ 
		long t = System.currentTimeMillis();

		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Compiling " + filename + "...");
		
		String source = precompile(filename, file);
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Precompiled in " + (System.currentTimeMillis() - t) + " ms. Source length: " + source.length() + ".");
		t = System.currentTimeMillis();
		Logging.logNotice(source);
		
		CommonTokenStream tokens = lex(source);
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Lexed in " + (System.currentTimeMillis() - t) + " ms. Tokens: " + tokens.getNumberOfOnChannelTokens() + ".");
		t = System.currentTimeMillis();

		TranslationUnitNode unit = parse(tokens);
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Parsed in " + (System.currentTimeMillis() - t) + " ms.");
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Compilation done.");

		return unit;
	}
	
}
