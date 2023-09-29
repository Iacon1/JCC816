// Created by Iacon1 on 2/7/2022.
// Compiler

package Compiler;

import java.util.Arrays;
import java.util.List;

import Compiler.ComponentNodes.ProgramNode;
import Grammar.GeneralGrammar;
import Grammar.GeneralParser;
import Grammar.GeneralParser.GeneralNode;

public class Compiler
{
	private static void printInfo(String... info)
	{
		for (int i = 0; i < info.length; ++i) System.out.print(info[i] + (i == info.length - 1 ? "" : ", ")); System.out.println();
	}
	private static void printError(String... error)
	{
		for (int i = 0; i < error.length; ++i) System.err.print(error[i] + (i == error.length - 1 ? "" : ", ")); System.err.println();
	}
	
	private static List<String> lex(String source)
	{
		String whitespacePattern = "[ ]+";
		String[] articles = new String[]{"+", "-", "*", "/", "\\", ";"};

		for (String article : articles) source = source.replaceAll("\\" + article, " " + article + " ");
		
		return Arrays.asList(source.split(whitespacePattern));
	}
	
	private static Integer initGrammar(GeneralGrammar<String> grammar)
	{
		Integer program, statement, block, functionDeclaration, function, variable, loc;
		
		variable = grammar.getBuilder().addT("[a-zA-Z_]+").addT("[a-zA-Z_]+").addT(";").build();	// TypeName variableName;
		statement = grammar.getBuilder().addNT(variable).build();
					grammar.getBuilder(statement).addNT(statement).addNT(statement).build();		// [statement] [statement]
					
		program = grammar.getBuilder().addNT(statement).build(); 									// [statement]
		loc = null;
		
//		statement = grammar.getBuilder().addNT(loc).build();
//		statement = grammar.getBuilder(statement).addNT(statement).addNT(statement).build();
		
//		block = grammar.getBuilder().addT("{").addNT(statement).addT("}").build();
		
//		functionDeclaration = null;
		
//		function = grammar.getBuilder().addNT(functionDeclaration).addNT(block).build();
		return program;
	}
	
	private static GeneralNode<String> parse(List<String> tokens, GeneralGrammar<String> grammar, Integer program)
	{
		return REGEXParser.parseTree(tokens, grammar, program);
	}
	private static String emit(GeneralNode<String> tree)
	{
		ProgramNode program = new ProgramNode();
		program.interpret(tree);

		return program.getAssembly();
	}

	public static String precompile(String main)
	{
		return main; // TODO
	}
	public static String compile(String source) 
	{ 
		GeneralGrammar<String> grammar = new GeneralGrammar<String>();
		Integer program = initGrammar(grammar);
		
		List<String> tokens = lex(source);
		printInfo("Lexed. Number of tokens: " + tokens.size() + ".");
		printInfo(tokens.toArray(new String[] {}));
		GeneralParser.GeneralNode<String> tree = parse(tokens, grammar, program);
		printInfo("Parsed.");
		printInfo(tree.dumpTree(0));
		String assembly = emit(tree);
		printInfo("Emitted. Assembly length: " + assembly.length() + ".");
		
		return assembly;
	}
}
