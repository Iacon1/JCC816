// Created by Iacon1 on 2/7/2022.
// Test rig.
// https://en.wikipedia.org/wiki/CYK_algorithm

package Executables;

import java.util.Arrays;
import java.util.List;

import Grammar.CYKParser;
import Grammar.CNFGrammar;

public class Test
{
	private static void print(String toPrint)
	{
		System.out.println(toPrint);
	}
	public static void main(String[] args)
	{
		CNFGrammar<String, String> grammar = new CNFGrammar<String, String>();
		grammar.addRule("A", "A", "A");
		grammar.addRule("A", "A");
		grammar.addRule("A", "B");
		grammar.addRule("A", "C");
		String string = "A A A B A C B B B C C C";
		List<String> sequence = Arrays.asList(string.split(" "));
		
		print(CYKParser.parseTree(sequence, grammar).dumpTree(0));
	}
}
