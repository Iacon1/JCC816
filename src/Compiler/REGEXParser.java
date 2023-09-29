// Created by Iacon1 on 2/14/2022.
// Parser that can match via REGEX instead of via plain equation.

package Compiler;

import java.util.List;

import Grammar.GeneralGrammar;
import Grammar.GeneralParser;
import Grammar.GeneralParser.GeneralNode;

public class REGEXParser extends GeneralParser
{
	private static class REGEXSuite extends GeneralSuite<String>
	{
		public REGEXSuite(GeneralGrammar<String> grammar) {super(grammar);}

		@Override
		public boolean matchTerminal(String listed, String given) {return given.matches(listed);}
	}

	public static <T1> GeneralNode<T1> parseTree(List<T1> sequence, GeneralGrammar<T1> grammar, Integer startSymbol)
	{
		if (sequence.isEmpty() || !String.class.isAssignableFrom(sequence.get(0).getClass())) return null;
		ParseSuite<String, Integer, GeneralNode<String>> suite = new REGEXSuite((GeneralGrammar<String>) grammar);
		return (GeneralNode<T1>) parseTree((List<String>) sequence, (GeneralGrammar<String>) grammar, suite, startSymbol);
	}
}
