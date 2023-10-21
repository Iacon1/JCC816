// Created by Iacon1 on 2/7/2022.
// Compiler

package Compiler;

import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;

import Compiler.ComponentNodes.ProgramNode;
import Compiler.Utils.CompUtils;
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
	private static void viewParseTree(Parser parser, ParseTree tree)
	{
		JFrame frame = new JFrame("Antlr");
		JPanel panel = new JPanel();
		TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
		viewer.setScale(1.0);
		panel.add(viewer);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	private static CommonTokenStream lex(String source)
	{
		C99Lexer lexer = new C99Lexer(CharStreams.fromString(source));
		
		return new CommonTokenStream(lexer);
	}

	
	private static ParseDouble parse(CommonTokenStream tokens)
	{
		ParseDouble parseDouble = new ParseDouble();
		parseDouble.parser = new C99Parser(tokens);
		parseDouble.tree = parseDouble.parser.program();
		
		return parseDouble;
	}
	
	private static String emit(ParseDouble parseDouble) throws Exception
	{
		ProgramNode program = new ProgramNode().interpret((ProgramContext) parseDouble.tree);
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
				
			if (line.contains(CompUtils.setAXY8))
			{
				if (aMode == 0 && xyMode == 0) lines.set(i, line.replace(CompUtils.setAXY8, ""));
				else if (aMode == 0) lines.set(i, line.replace(CompUtils.setAXY8, CompUtils.setXY8));
				else if (xyMode == 0) lines.set(i, line.replace(CompUtils.setAXY8, CompUtils.setA8));
				
				aMode = 0;
				xyMode = 0;
			}
			else if (line.contains(CompUtils.setAXY16))
			{
				if (aMode == 1 && xyMode == 1) lines.set(i, line.replace(CompUtils.setAXY16, ""));
				else if (aMode == 1) lines.set(i, line.replace(CompUtils.setAXY16, CompUtils.setXY16));
				else if (xyMode == 1) lines.set(i, line.replace(CompUtils.setAXY16, CompUtils.setA16));
				
				aMode = 1;
				xyMode = 1;
			}
			else if (line.contains(CompUtils.setA8))
			{
				if (aMode == 0) lines.set(i, line.replace(CompUtils.setA8, ""));
				aMode = 0;
			}
			else if (line.contains(CompUtils.setA16))
			{
				if (aMode == 1) lines.set(i, line.replace(CompUtils.setA16, ""));
				aMode = 1;
			}
			else if (line.contains(CompUtils.setXY8))
			{
				if (xyMode == 0) lines.set(i, line.replace(CompUtils.setXY8, ""));
				xyMode = 0;
			}
			else if (line.contains(CompUtils.setXY16))
			{
				if (xyMode == 1) lines.set(i, line.replace(CompUtils.setXY16, ""));
				xyMode = 1;
			}
		}
		
		return lines;
	}
	private  static String postprocess(String assembly)
	{
		List<String> lines = Arrays.asList(assembly.split("\n"));

		lines = minimizeModeSwitches(lines);
		
		assembly = "";
		for (String line : lines) if (!line.matches("\s*")) assembly += line + "\n";
		return assembly;
	}
		
	
	public static String compile(String mainFile) throws Exception
	{ 
		String assembly = "";

		long t = System.currentTimeMillis();

		String source = precompile(mainFile);
		Logging.logNotice(source);
		CommonTokenStream tokens = lex(source);
		printInfo("Lexed in " + (System.currentTimeMillis() - t) + " ms.");
		
		t = System.currentTimeMillis();

		ParseDouble parseDouble = parse(tokens);
		printInfo("Parsed in " + (System.currentTimeMillis() - t) + " ms.");
		viewParseTree(parseDouble.parser, parseDouble.tree);
		t = System.currentTimeMillis();

		assembly = emit(parseDouble);
		printInfo("Emitted in " + (System.currentTimeMillis() - t) + " ms. Assembly length: " + assembly.length() + ".");
		t = System.currentTimeMillis();
		
		//assembly = postprocess(assembly);
		printInfo("Postprocessed in " + (System.currentTimeMillis() - t) + " ms. New assembly length: " + assembly.length() + ".");
		t = System.currentTimeMillis();
		
		return assembly;
	}
	
}
