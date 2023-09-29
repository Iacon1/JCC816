// Created by Iacon1 on 2/7/2022.
// Compiler

package Compiler;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import Compiler.ComponentNodes.ProgramNode;
import Grammar.GeneralGrammar;
import Grammar.GeneralParser;
import Grammar.GeneralParser.GeneralNode;

public class Compiler
{
	
	// Component rule-number declarations
	public static enum ComponentType
	{
		program,
		varDeclaration, // Variable declaration
		expression,
		function,
		statement,
		codeBlock,
	}
	private static EnumMap<ComponentType, Integer> componentMap;
	public static Integer getComponentIndex(ComponentType type)
	{
		return componentMap.get(type);
	}
	public static ComponentType getType(Integer index)
	{
		for (ComponentType type : ComponentType.values())
		{
			if (getComponentIndex(type) == index) return type;
		}
		return null;
	}
	private static void dumpMap()
	{
		for (ComponentType type : ComponentType.values())
		{
			printInfo(type.name() + ": " + getComponentIndex(type));
		}
	}
	
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
		String whitespacePattern = "[\\s]+";
		String[] articles = new String[]{"+", "-", "*", "/", "\\", ";", ",", "(", ")"};
		
		for (String article : articles) source = source.replaceAll("\\" + article, " " + article + " ");
		return Arrays.asList(source.split(whitespacePattern));
	}
	
	private static void initGrammar(GeneralGrammar<String> grammar)
	{
		int tmp;
		componentMap = new EnumMap<ComponentType, Integer>(ComponentType.class);
		
		String tokenPattern = "[a-zA-Z]+";
		String operatorPattern = "[\\+\\*\\-/=]";
		tmp = 	grammar.getBuilder().addT(tokenPattern).addT(tokenPattern).build();								// [type name] [variable name]
				grammar.getBuilder(tmp).addT(tokenPattern).addT("\\*").addT(tokenPattern).build();				// [type name]* [variable name]
				grammar.getBuilder(tmp).addNT(tmp).addT("\\,").addNT(tmp).build();								// [var dec], [var dec]
		componentMap.put(ComponentType.varDeclaration, tmp);													// variable!
		
		tmp = 	grammar.getBuilder().addNT(getComponentIndex(ComponentType.varDeclaration)).addT(";").build();	// [var dec]
				grammar.getBuilder(tmp).addNT(tmp).addNT(tmp).build();											// [statement] [statement]
		componentMap.put(ComponentType.statement, tmp);															// statement!
		
		tmp =	grammar.getBuilder().addT(tokenPattern).addT(operatorPattern).addT(tokenPattern).build();		// [var name] [op] [var name]
				grammar.getBuilder(tmp).addNT(tmp).addT(operatorPattern).addT(tokenPattern).build();			// [expression] [op] [var name]
				grammar.getBuilder(tmp).addT(tokenPattern).addT(operatorPattern).addNT(tmp).build();			// [var name] [op] [expression]
				grammar.getBuilder(tmp).addNT(tmp).addT(operatorPattern).addNT(tmp).build();					// [expression] [op] [expression]
				grammar.getBuilder(tmp).addT("\\(").addT(tokenPattern).addT("\\)").build();						// ([var name])
				grammar.getBuilder(tmp).addT("\\(").addNT(tmp).addT("\\)").build();								// ([expression])
		componentMap.put(ComponentType.expression, tmp);														// expression!
		
		tmp =	grammar.getBuilder().addT("\\{").addNT(getComponentIndex(ComponentType.statement))
				.addT("\\}").build();																			// {[statement]}
		tmp =	grammar.getBuilder().addT("\\{").addT("\\}").build();											// {}
		componentMap.put(ComponentType.codeBlock, tmp);															// code block!
		
		tmp =	grammar.getBuilder().addT(tokenPattern).addT(tokenPattern).addT("\\(").
				addNT(getComponentIndex(ComponentType.varDeclaration)).addT("\\)").
				addNT(getComponentIndex(ComponentType.codeBlock)).build();										// [type name] [var name]([var list]) [code block]
		tmp =	grammar.getBuilder().addT(tokenPattern).addT(tokenPattern).addT("\\(").addT("\\)").
		addNT(getComponentIndex(ComponentType.codeBlock)).build();												// [type name] [var name]() [code block]
		componentMap.put(ComponentType.function, tmp);
				
		grammar.getBuilder(getComponentIndex(ComponentType.statement)).
			addNT(getComponentIndex(ComponentType.function)).build();											// Statement can contain functions
		
		tmp = 	grammar.getBuilder().addNT(getComponentIndex(ComponentType.statement)).build(); 				// [statement]
		componentMap.put(ComponentType.program, tmp);															// program!
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
		initGrammar(grammar);
//		dumpMap();
		List<String> tokens = lex(source);
		printInfo("Lexed. Number of tokens: " + tokens.size() + ".");
		printInfo(tokens.toArray(new String[] {}));
		GeneralParser.GeneralNode<String> tree = parse(tokens, grammar, getComponentIndex(ComponentType.program));
		printInfo("Parsed.");
		printInfo(tree.dumpTree(0));
		String assembly = emit(tree);
		printInfo("Emitted. Assembly length: " + assembly.length() + ".");
		
		return assembly;
	}
}
