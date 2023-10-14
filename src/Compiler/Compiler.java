// Created by Iacon1 on 2/7/2022.
// Compiler

package Compiler;

import java.util.Arrays;
import java.util.List;
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
		rVal, // Convienent wrapper for expressions, function calls, variables, and literals
		returnStm,
		ifStm, ifElseStm,
		forStm,
		attributeStm,
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
		boolean doAgain = grammar.isEmpty();

		grammar.markPrimary(ComponentType.varDeclaration.name());
		grammar.getBuilder(ComponentType.varDeclaration.name()).addT(CompConfig.tokenPattern).addT(CompConfig.tokenPattern).build();				// [type name] [variable name]
		grammar.getBuilder(ComponentType.varDeclaration.name()).addT(CompConfig.tokenPattern).addT("\\*").addT(CompConfig.tokenPattern).build();	// [type name]* [variable name]
		grammar.getBuilder(ComponentType.varDeclaration.name()).addNT(ComponentType.varDeclaration.name()).addT("\\,").
		addNT(ComponentType.varDeclaration.name()).build();																							// [var dec], [var dec]
		
		grammar.markPrimary(ComponentType.rVal.name());
		grammar.getBuilder(ComponentType.rVal.name()).addT(CompConfig.tokenPattern).build();														// [variable declaration]
		grammar.getBuilder(ComponentType.rVal.name()).addT(CompConfig.literalPattern).build();														// [literal declaration]
		
		grammar.markPrimary(ComponentType.statement.name());
		grammar.getBuilder(ComponentType.statement.name()).addNT(ComponentType.varDeclaration.name()).addT(";").build();							// [var dec]
		grammar.getBuilder(ComponentType.statement.name()).addNT(ComponentType.statement.name()).addNT(ComponentType.statement.name()).build();		// [statement] [statement]

		grammar.markPrimary(ComponentType.expression.name());
		
		grammar.markPrimary(ComponentType.expression.name());
		grammar.getBuilder(ComponentType.expression.name()).addNT(ComponentType.rVal.name()).addT(CompConfig.operatorPattern).
		addNT(ComponentType.rVal.name()).build();																									// [rval] [op] [rval]																			// [expression] [op] [expression]
		grammar.getBuilder(ComponentType.expression.name()).addNT(ComponentType.rVal.name()).addT("<").addT("=").
		addNT(ComponentType.rVal.name()).build();																									// [rval] <= [rval]	
		grammar.getBuilder(ComponentType.expression.name()).addNT(ComponentType.rVal.name()).addT(">").addT("=").
		addNT(ComponentType.rVal.name()).build();																									// [rval] >= [rval]	
		grammar.getBuilder(ComponentType.expression.name()).addNT(ComponentType.rVal.name()).addT("=").addT("=").
		addNT(ComponentType.rVal.name()).build();																									// [rval] == [rval]	
		grammar.getBuilder(ComponentType.expression.name()).addNT(ComponentType.rVal.name()).addT("!").addT("=").
		addNT(ComponentType.rVal.name()).build();																									// [rval] != [rval]	
		grammar.getBuilder(ComponentType.expression.name()).addT("\\(").addNT(ComponentType.rVal.name()).addT("\\)").build();						// ([rval])
		grammar.getBuilder(ComponentType.expression.name()).addT("\\-").addNT(ComponentType.rVal.name()).build();									// -[rval]
		grammar.getBuilder(ComponentType.expression.name()).addT("\\!").addNT(ComponentType.rVal.name()).build();									// ![rval]
		
		grammar.getBuilder(ComponentType.rVal.name()).addNT(ComponentType.expression.name()).build();												// rVal: expression
		
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
		
		grammar.getBuilder(ComponentType.rVal.name()).addNT(ComponentType.functionCall.name()).build();												// rVal: function call
		
		grammar.markPrimary(ComponentType.argList.name());
		grammar.getBuilder(ComponentType.argList.name()).addNT(ComponentType.rVal.name()).build();													// [rVal]
		grammar.getBuilder(ComponentType.argList.name()).addNT(ComponentType.argList.name()).addT("\\,").
		addNT(ComponentType.argList.name()).build();																								// [arg List], [arg List]

		grammar.getBuilder(ComponentType.functionCall.name()).addT(CompConfig.tokenPattern).addT("\\(").addNT(ComponentType.argList.name()).
		addT("\\)").build();																														// function call: [func name]([arg list])
		
		grammar.markPrimary(ComponentType.assignment.name());
		grammar.getBuilder(ComponentType.assignment.name()).addT(CompConfig.tokenPattern).addT("=").addNT(ComponentType.rVal.name()).
		addT(";").build();																															// [var name] = [rVal];

		grammar.markPrimary(ComponentType.returnStm.name());
		grammar.getBuilder(ComponentType.returnStm.name()).addT(CompConfig.Keywords.returnKW).addNT(ComponentType.rVal.name()).addT(";").build();	// return [rVal];
		
		grammar.markPrimary(ComponentType.attributeStm.name());
		grammar.getBuilder(ComponentType.attributeStm.name()).addT(CompConfig.Keywords.attributeKW).addT("\\(").
		addT(CompConfig.tokenPattern).addT("\\)").addT(";").build();																				// __attribute__([rVal]);
		
		grammar.markPrimary(ComponentType.ifStm.name()); grammar.markPrimary(ComponentType.ifElseStm.name());
		grammar.getBuilder(ComponentType.ifStm.name()).addT(CompConfig.Keywords.ifKW).addT("\\(").addNT(ComponentType.rVal.name()).addT("\\)").
		addNT(ComponentType.codeBlock.name()).build();																								// if ([rVal]) {code}
		grammar.getBuilder(ComponentType.ifStm.name()).addNT(ComponentType.ifStm.name()).addT(CompConfig.Keywords.elseKW).
		addT(CompConfig.Keywords.ifKW).addT("\\(").addNT(ComponentType.rVal.name()).addT("\\)").addNT(ComponentType.codeBlock.name()).build();		// [if stm] else if {code}
		grammar.getBuilder(ComponentType.ifElseStm.name()).addNT(ComponentType.ifStm.name()).addT(CompConfig.Keywords.elseKW).
		addNT(ComponentType.codeBlock.name()).build();																								// [if stm] else {code}
		
		
		grammar.markPrimary(ComponentType.forStm.name());
		grammar.getBuilder(ComponentType.forStm.name()).addT("for").addT("\\(").addNT(ComponentType.assignment.name()).
		addT(";").addNT(ComponentType.expression.name()).addT(";").addNT(ComponentType.assignment.name()).addT("\\)").
		addNT(ComponentType.codeBlock.name());																										// for ([assignment]; [expression]; [assignment]) {[code]}
		
		grammar.getBuilder(ComponentType.statement.name()).addNT(ComponentType.function.name()).build();											// statement: [function]
		grammar.getBuilder(ComponentType.statement.name()).addNT(ComponentType.assignment.name()).build();											// statement: [assignment]
		grammar.getBuilder(ComponentType.statement.name()).addNT(ComponentType.functionCall.name()).addT(";").build();								// statement: [function call]
		grammar.getBuilder(ComponentType.statement.name()).addNT(ComponentType.returnStm.name()).build();											// statement: [return statement]
		grammar.getBuilder(ComponentType.statement.name()).addNT(ComponentType.ifStm.name()).build();												// statement: [if statement]
		grammar.getBuilder(ComponentType.statement.name()).addNT(ComponentType.ifElseStm.name()).build();											// statement: [if-else statement]

		grammar.getBuilder(ComponentType.statement.name()).addNonTerminal(ComponentType.attributeStm.name()).build();								// statement: [attribute statement]
		
		grammar.getBuilder(ComponentType.program.name()).addNT(ComponentType.statement.name()).build(); 											// [statement]
		
		
		if (doAgain) initGrammar(grammar); // Yes, we do it again to resolve any loops
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

	private static List<String> minimizeModeSwitches(List<String> lines)
	{
		int aMode = 0, xyMode = 0; // 0 = 8-bit, 1 = 16-bit, -1 = unknown
		for (int i = 0; i < lines.size(); ++i)
		{
			String line = lines.get(i);
			if (line.matches("[^:\s]*:.*")) // At a label, lose all assumptions of mode
			{
				aMode = -1;
				xyMode = -1;
			}
				
			if (line.contains(CompConfig.setAXY8))
			{
				if (aMode == 0 && xyMode == 0) lines.set(i, line.replace(CompConfig.setAXY8, ""));
				else if (aMode == 0) lines.set(i, line.replace(CompConfig.setAXY8, CompConfig.setXY8));
				else if (xyMode == 0) lines.set(i, line.replace(CompConfig.setAXY8, CompConfig.setA8));
				
				aMode = 0;
				xyMode = 0;
			}
			else if (line.contains(CompConfig.setAXY16))
			{
				if (aMode == 1 && xyMode == 1) lines.set(i, line.replace(CompConfig.setAXY16, ""));
				else if (aMode == 1) lines.set(i, line.replace(CompConfig.setAXY16, CompConfig.setXY16));
				else if (xyMode == 1) lines.set(i, line.replace(CompConfig.setAXY16, CompConfig.setA16));
				
				aMode = 1;
				xyMode = 1;
			}
			else if (line.contains(CompConfig.setA8))
			{
				if (aMode == 0) lines.set(i, line.replace(CompConfig.setA8, ""));
				aMode = 0;
			}
			else if (line.contains(CompConfig.setA16))
			{
				if (aMode == 1) lines.set(i, line.replace(CompConfig.setA16, ""));
				aMode = 1;
			}
			else if (line.contains(CompConfig.setXY8))
			{
				if (xyMode == 0) lines.set(i, line.replace(CompConfig.setXY8, ""));
				xyMode = 0;
			}
			else if (line.contains(CompConfig.setXY16))
			{
				if (xyMode == 1) lines.set(i, line.replace(CompConfig.setXY16, ""));
				xyMode = 1;
			}
		}
		
		return lines;
	}

	public static String postprocess(String assembly)
	{
		List<String> lines = Arrays.asList(assembly.split("\n"));

		lines = minimizeModeSwitches(lines);
		
		assembly = "";
		for (String line : lines) if (!line.matches("\s*")) assembly += line + "\n";
		return assembly;
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
		printInfo("grammar initialized in " + (System.currentTimeMillis() - t) + " ms. Rules: " + grammar.size() + ".");
		t = System.currentTimeMillis();
		
		List<String> tokens = lex(source);
		printInfo("Lexed in " + (System.currentTimeMillis() - t) + " ms.");
		t = System.currentTimeMillis();

		GeneralParser.GeneralNode<String, String> tree = parse(tokens, grammar, ComponentType.program.name());
		printInfo("Parsed in " + (System.currentTimeMillis() - t) + " ms.");
		//printInfo(tree.dumpTree(0));
		t = System.currentTimeMillis();

		String assembly = emit(tree);
		printInfo("Emitted in " + (System.currentTimeMillis() - t) + " ms. Assembly length: " + assembly.length() + ".");
		t = System.currentTimeMillis();
		
		assembly = postprocess(assembly);
		printInfo("Postprocessed in " + (System.currentTimeMillis() - t) + " ms. New assembly length: " + assembly.length() + ".");
		t = System.currentTimeMillis();
		
		return assembly;
	}
	
}
