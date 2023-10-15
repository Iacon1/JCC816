// Created by Iacon1 on 2/7/2022.
// Compiler

package Compiler;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import Compiler.ComponentNodes.ProgramNode;
import Logging.Logging;
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
		for (int i = 0; i < info.length; ++i) Logging.logNotice(info[i].toString() + (i == info.length - 1 ? "" : ", ") + "\n");
	}
	
	private static List<String> lex(String source)
	{
		String whitespacePattern = "[\\s]+";
		String[] articles = new String[]{"+", "-", "=", "<", ">", "/", "\\", ";", ",", "(", ")", "{", "}", "&"};
		
		for (String article : articles) source = source.replaceAll("\\" + article, " " + article + " ");
		return Arrays.asList(source.split(whitespacePattern));
	}
	
	private static GeneralNode<String, String> parse(List<String> tokens, GeneralGrammar<String, String> grammar, String program)
	{
		return REGEXParser.parseTree(tokens, grammar, program);
	}
	private static String emit(GeneralNode<String, String> tree) throws Exception
	{
		ProgramNode program = new ProgramNode();
		
		program.interpret(tree);

		return program.getAssembly();
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
	public static String compile(String source) throws Exception
	{ 
		String assembly = "";
		GeneralGrammar<String, String> grammar = new GeneralGrammar<String, String>(new RuleNameGen());

		long t = System.currentTimeMillis();
		C99.initGrammar(grammar);
		printInfo("grammar initialized in " + (System.currentTimeMillis() - t) + " ms. Rules: " + grammar.size() + ".");
		t = System.currentTimeMillis();
		
		List<String> tokens = lex(source);
		printInfo("Lexed in " + (System.currentTimeMillis() - t) + " ms.");
		printInfo(tokens);
		t = System.currentTimeMillis();

		GeneralParser.GeneralNode<String, String> tree = parse(tokens, grammar, "expression");
		printInfo("Parsed in " + (System.currentTimeMillis() - t) + " ms.");
		printInfo(tree.dumpTree(0));
		t = System.currentTimeMillis();

		//assembly = emit(tree);
		printInfo("Emitted in " + (System.currentTimeMillis() - t) + " ms. Assembly length: " + assembly.length() + ".");
		t = System.currentTimeMillis();
		
		//assembly = postprocess(assembly);
		printInfo("Postprocessed in " + (System.currentTimeMillis() - t) + " ms. New assembly length: " + assembly.length() + ".");
		t = System.currentTimeMillis();
		
		return assembly;
	}
	
}
