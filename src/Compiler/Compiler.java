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

import Grammar.C99.C99Lexer;
import Grammar.C99.C99Parser;
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

	private static void viewParseTree(Parser parser, ParseTree tree)
	{
		JFrame frame = new JFrame("Antlr");
		JPanel panel = new JPanel();
		TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
		viewer.setScale(1.5);
		panel.add(viewer);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	private static ParseTree parse(CommonTokenStream tokens)
	{
		C99Parser parser = new C99Parser(tokens);
		ParseTree tree = parser.translation_unit();
		viewParseTree(parser, tree);
		return tree;
	}
	
	private static String emit(ParseTree tree) throws Exception
	{
		return null;

	}
	private static String precompile(String main)
	{
		return main; // TODO
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
	private  static String postprocess(String assembly)
	{
		List<String> lines = Arrays.asList(assembly.split("\n"));

		lines = minimizeModeSwitches(lines);
		
		assembly = "";
		for (String line : lines) if (!line.matches("\s*")) assembly += line + "\n";
		return assembly;
	}
		
	
	public static String compile(String source) throws Exception
	{ 
		String assembly = "";

		long t = System.currentTimeMillis();

		CommonTokenStream tokens = lex(source);
		printInfo("Lexed in " + (System.currentTimeMillis() - t) + " ms.");
		
		t = System.currentTimeMillis();

		ParseTree tree = parse(tokens);
		printInfo("Parsed in " + (System.currentTimeMillis() - t) + " ms.");
		t = System.currentTimeMillis();

		assembly = emit(tree);
		printInfo("Emitted in " + (System.currentTimeMillis() - t) + " ms. Assembly length: " + assembly.length() + ".");
		t = System.currentTimeMillis();
		
		//assembly = postprocess(assembly);
		printInfo("Postprocessed in " + (System.currentTimeMillis() - t) + " ms. New assembly length: " + assembly.length() + ".");
		t = System.currentTimeMillis();
		
		return assembly;
	}
	
}
