// Created by Iacon1 on 2/7/2022.
// Compiler

package Compiler;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

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
		assignment,
		argList,
		functionCall,
		rVal,
		returnStm,
		ifStm,
		forStm;
	}
	private static class RuleNameGen implements Supplier<String>
	{
		String curr;
		
		public RuleNameGen(String seed) {curr = seed;}
		public RuleNameGen() {curr = "FFFFFFFF";}
		@Override
		public String get()
		{
			curr = String.format("%08x", curr.hashCode());
			return curr;
		}
	}
	
	public static ComponentType getType(String name)
	{
		for (ComponentType type : ComponentType.values())
			if (type.name().equals(name)) return type;
		return null;
	}
	private static void printInfo(Object... info)
	{
		for (int i = 0; i < info.length; ++i) System.out.print(info[i].toString() + (i == info.length - 1 ? "" : ", ")); System.out.println();
	}
	private static void printError(String... error)
	{
		for (int i = 0; i < error.length; ++i) System.err.print(error[i] + (i == error.length - 1 ? "" : ", ")); System.err.println();
	}
	
	private static List<String> lex(String source)
	{
		String whitespacePattern = "[\\s]+";
		String[] articles = new String[]{"+", "-", "=", "<", ">", "/", "\\", ";", ",", "(", ")"};
		
		for (String article : articles) source = source.replaceAll("\\" + article, " " + article + " ");
		return Arrays.asList(source.split(whitespacePattern));
	}
	
	private static void initGrammar(GeneralGrammar<String, String> grammar)
	{
		grammar.markPrimary(ComponentType.varDeclaration.name());
		grammar.getBuilder(ComponentType.varDeclaration.name()).addT(CompConfig.tokenPattern).addT(CompConfig.tokenPattern).build();				// [type name] [variable name]
		grammar.getBuilder(ComponentType.varDeclaration.name()).addT(CompConfig.tokenPattern).addT("\\*").addT(CompConfig.tokenPattern).build();	// [type name]* [variable name]
		grammar.getBuilder(ComponentType.varDeclaration.name()).addNT(ComponentType.varDeclaration.name()).addT("\\,").
		addNT(ComponentType.varDeclaration.name()).build();																							// [var dec], [var dec]
		
		grammar.markPrimary(ComponentType.rVal.name());
		grammar.getBuilder(ComponentType.rVal.name());
		grammar.markPrimary(ComponentType.statement.name());
		grammar.getBuilder(ComponentType.statement.name()).addNT(ComponentType.varDeclaration.name()).addT(";").build();							// [var dec]
		grammar.getBuilder(ComponentType.statement.name()).addNT(ComponentType.statement.name()).addNT(ComponentType.statement.name()).build();		// [statement] [statement]

		grammar.markPrimary(ComponentType.expression.name());
		grammar.getBuilder(ComponentType.expression.name()).addT(CompConfig.tokenPattern).addT(CompConfig.operatorPattern).
		addT(CompConfig.tokenPattern).build();																										// [var name] [op] [var name]
		grammar.getBuilder(ComponentType.expression.name()).addT(CompConfig.tokenPattern).addT(CompConfig.operatorPattern).
		addT(CompConfig.literalPattern).build();																									// [var name] [op] [literal]
		grammar.getBuilder(ComponentType.expression.name()).addT(CompConfig.literalPattern).addT(CompConfig.operatorPattern).
		addT(CompConfig.tokenPattern).build();																										// [literal] [op] [var name]
		grammar.getBuilder(ComponentType.expression.name()).addT(CompConfig.literalPattern).addT(CompConfig.operatorPattern).
		addT(CompConfig.literalPattern).build();																									// [literal] [op] [literal]
		grammar.getBuilder(ComponentType.expression.name()).addNT(ComponentType.expression.name()).addT(CompConfig.operatorPattern).
		addT(CompConfig.tokenPattern).build();																										// [expression] [op] [var name]
		grammar.getBuilder(ComponentType.expression.name()).addNT(ComponentType.expression.name()).addT(CompConfig.operatorPattern).
		addT(CompConfig.literalPattern).build();																									// [expression] [op] [literal]
		grammar.getBuilder(ComponentType.expression.name()).addT(CompConfig.tokenPattern).addT(CompConfig.operatorPattern).
		addNT(ComponentType.expression.name()).build();																								// [var name] [op] [expression]
		grammar.getBuilder(ComponentType.expression.name()).addT(CompConfig.literalPattern).addT(CompConfig.operatorPattern).
		addNT(ComponentType.expression.name()).build();																								// [literal] [op] [expression]
		grammar.getBuilder(ComponentType.expression.name()).addNT(ComponentType.expression.name()).addT(CompConfig.operatorPattern).
		addNT(ComponentType.expression.name()).build();																								// [expression] [op] [expression]
		grammar.getBuilder(ComponentType.expression.name()).addT("\\(").addT(CompConfig.tokenPattern).addT("\\)").build();							// ([var name])
		grammar.getBuilder(ComponentType.expression.name()).addT("\\(").addNT(ComponentType.expression.name()).addT("\\)").build();					// ([expression])														// expression!
		
		grammar.markPrimary(ComponentType.codeBlock.name());
		grammar.getBuilder(ComponentType.codeBlock.name()).addT("\\{").addNT(ComponentType.statement.name()).addT("\\}").build();					// {[statement]}
		grammar.getBuilder(ComponentType.codeBlock.name()).addT("\\{").addT("\\}").build();															// {}														// code block!
		
		grammar.markPrimary(ComponentType.function.name());
		grammar.getBuilder(ComponentType.function.name()).addT(CompConfig.tokenPattern).addT(CompConfig.tokenPattern).addT("\\(").
				addNT(ComponentType.varDeclaration.name()).addT("\\)").addNT(ComponentType.codeBlock.name()).build();								// [type name] [func name]([var list]) [code block]
		grammar.getBuilder(ComponentType.function.name()).addT(CompConfig.tokenPattern).addT(CompConfig.tokenPattern).addT("\\(").addT("\\)").
		addNT(ComponentType.codeBlock.name()).build();																								// [type name] [func name]() [code block]
				
		grammar.markPrimary(ComponentType.functionCall.name());
		grammar.getBuilder(ComponentType.functionCall.name()).addT(CompConfig.tokenPattern).addT("\\(").addT("\\)").build();						// [func name]()
		
		grammar.getBuilder(ComponentType.expression.name()).addNT(ComponentType.functionCall.name()).
		addT(CompConfig.operatorPattern).addT(CompConfig.literalPattern).build();																	// expression: [func call] [op] [literal]
		grammar.getBuilder(ComponentType.expression.name()).addT(CompConfig.tokenPattern).
		addT(CompConfig.operatorPattern).addNT(ComponentType.functionCall.name()).build();															// expression: [var name] [op] [func call]
		grammar.getBuilder(ComponentType.expression.name()).addT(CompConfig.literalPattern).
		addT(CompConfig.operatorPattern).addNT(ComponentType.functionCall.name()).build();															// expression: [literal] [op] [func call]
		grammar.getBuilder(ComponentType.expression.name()).addNT(ComponentType.expression.name()).
		addT(CompConfig.operatorPattern).addNT(ComponentType.functionCall.name()).build();															// expression: [expression] [op] [func call]
		grammar.getBuilder(ComponentType.expression.name()).addNT(ComponentType.functionCall.name()).
		addT(CompConfig.operatorPattern).addNT(ComponentType.expression.name()).build();															// expression: [func call] [op] [expression]
		grammar.getBuilder(ComponentType.expression.name()).addNT(ComponentType.functionCall.name()).
		addT(CompConfig.operatorPattern).addNT(ComponentType.functionCall.name()).build();															// expression: [func call] [op] [func call]
		grammar.getBuilder(ComponentType.expression.name()).addT("\\(").
		addNT(ComponentType.functionCall.name()).addT("\\)").build();																				// expression: ([func call])
		
		grammar.markPrimary(ComponentType.argList.name());
		grammar.getBuilder(ComponentType.argList.name()).addT(CompConfig.tokenPattern).build();														// [variable name]
		grammar.getBuilder(ComponentType.argList.name()).addT(CompConfig.literalPattern).build();													// [literal]
		grammar.getBuilder(ComponentType.argList.name()).addNT(ComponentType.expression.name()).build();											// [expression]
		grammar.getBuilder(ComponentType.argList.name()).addNT(ComponentType.functionCall.name()).build();											// [function call]
		grammar.getBuilder(ComponentType.argList.name()).addNT(ComponentType.argList.name()).addT("\\,").
		addNT(ComponentType.argList.name()).build();																								// [arg List], [arg List]

		grammar.getBuilder(ComponentType.functionCall.name()).addT(CompConfig.tokenPattern).addT("\\(").addNT(ComponentType.argList.name()).
		addT("\\)").build();																														// function call: [func name]([var list])
		
		grammar.markPrimary(ComponentType.assignment.name());
		grammar.getBuilder(ComponentType.assignment.name()).addT(CompConfig.tokenPattern).addT("=").addT(CompConfig.tokenPattern).
		addT(";").build();																															// [var name] = [var name];
		grammar.getBuilder(ComponentType.assignment.name()).addT(CompConfig.tokenPattern).addT("=").addT(CompConfig.literalPattern).
		addT(";").build();																															// [var name] = [literal];
		grammar.getBuilder(ComponentType.assignment.name()).addT(CompConfig.tokenPattern).addT("=").addNT(ComponentType.expression.name()).
		addT(";").build();																															// [var name] = [expression];
		grammar.getBuilder(ComponentType.assignment.name()).addT(CompConfig.tokenPattern).addT("=").addNT(ComponentType.functionCall.name())
		.addT(";").build();																															// [var name] = [function call];

		grammar.markPrimary(ComponentType.returnStm.name());
		grammar.getBuilder(ComponentType.returnStm.name()).addT("return").addT(CompConfig.tokenPattern).addT(";").build();							// return [var name];
		grammar.getBuilder(ComponentType.returnStm.name()).addT("return").addT(CompConfig.literalPattern).addT(";").build();						// return [literal];
		grammar.getBuilder(ComponentType.returnStm.name()).addT("return").addNT(ComponentType.expression.name()).addT(";").build();					// return [expression];
		grammar.getBuilder(ComponentType.returnStm.name()).addT("return").addNT(ComponentType.functionCall.name()).addT(";").build();				// return [function call];
		
		grammar.markPrimary(ComponentType.ifStm.name());
		grammar.getBuilder(ComponentType.ifStm.name()).addT("if").addT("\\(").addT(CompConfig.tokenPattern).addT("\\)").
		addNT(ComponentType.codeBlock.name()).build();																								// if ([var name]) {code}
		grammar.getBuilder(ComponentType.ifStm.name()).addT("if").addT("\\(").addT(CompConfig.literalPattern).addT("\\)").
		addNT(ComponentType.codeBlock.name()).build();																								// if ([literal]) {code}
		grammar.getBuilder(ComponentType.ifStm.name()).addT("if").addT("\\(").addNT(ComponentType.expression.name()).addT("\\)").
		addNT(ComponentType.codeBlock.name()).build();																								// if ([expression]) {code}
		
		grammar.markPrimary(ComponentType.forStm.name());
		grammar.getBuilder(ComponentType.forStm.name()).addT("for").addT("\\(").addNT(ComponentType.assignment.name()).
		addT(";").addNT(ComponentType.expression.name()).addT(";").addNT(ComponentType.assignment.name()).addT("\\)").
		addNT(ComponentType.codeBlock.name());																										// for ([assignment]; [expression]; [assignment]) {[code]}
		
		grammar.getBuilder(ComponentType.statement.name()).addNT(ComponentType.function.name()).build();											// statement: [function]
		grammar.getBuilder(ComponentType.statement.name()).addNT(ComponentType.assignment.name()).build();											// statement: [assignment]
		grammar.getBuilder(ComponentType.statement.name()).addNT(ComponentType.functionCall.name()).build();										// statement: [function call]
		grammar.getBuilder(ComponentType.statement.name()).addNT(ComponentType.returnStm.name()).build();											// statement: [return statement]
		grammar.getBuilder(ComponentType.statement.name()).addNT(ComponentType.ifStm.name()).build();												// statement: [return statement]
		
		grammar.getBuilder(ComponentType.program.name()).addNT(ComponentType.statement.name()).build(); 											// [statement]
	}
	
	private static GeneralNode<String, String> parse(List<String> tokens, GeneralGrammar<String, String> grammar, String program)
	{
		return REGEXParser.parseTree(tokens, grammar, program);
	}
	private static String emit(GeneralNode<String, String> tree)
	{
		ProgramNode program = new ProgramNode();
		
		try {program.interpret(tree);}
		catch (Exception e) {e.printStackTrace(); return null;}

		try {return program.getAssembly();}
		catch (Exception e) {e.printStackTrace(); return null;}
	}

	public static String precompile(String main)
	{
		return main; // TODO
	}
	public static String compile(String source) 
	{ 
		
		GeneralGrammar<String, String> grammar = new GeneralGrammar<String, String>(new RuleNameGen());

		long t = System.currentTimeMillis();
		initGrammar(grammar);
		printInfo("grammar initialized in " + (System.currentTimeMillis() - t) + " ms.");
		t = System.currentTimeMillis();
		
		List<String> tokens = lex(source);
		printInfo(tokens.toArray());
		printInfo("Lexed in " + (System.currentTimeMillis() - t) + " ms.");
		t = System.currentTimeMillis();

		GeneralParser.GeneralNode<String, String> tree = parse(tokens, grammar, ComponentType.program.name());
		printInfo("Parsed in " + (System.currentTimeMillis() - t) + " ms.");
		printInfo(tree.dumpTree(0));
		t = System.currentTimeMillis();

		String assembly = emit(tree);
		printInfo("Emitted in " + (System.currentTimeMillis() - t) + " ms. Assembly length: " + assembly.length() + ".");
		t = System.currentTimeMillis();
		
		return assembly;
	}
}
