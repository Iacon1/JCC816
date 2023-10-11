// Created by Iacon1 on 2/14/2022.
// Parser that can match via REGEX instead of via plain equation.

package Compiler;

import java.util.List;

import Grammar.GeneralGrammar;
import Grammar.GeneralParser;
import Grammar.GeneralParser.GeneralNode;

public class REGEXParser extends GeneralParser
{
	private static class REGEXSuite<T> extends GeneralSuite<String, T>
	{
		public REGEXSuite(GeneralGrammar<String, T> grammar) {super(grammar);}

		@Override
		public boolean matchTerminal(String listed, String given) {return given.matches(listed);}
	}

	public static <T1, T2> GeneralNode<T1, T2> parseTree(List<T1> sequence, GeneralGrammar<T1, T2> grammar, T2 startSymbol)
	{
		if (sequence.isEmpty() || !String.class.isAssignableFrom(sequence.get(0).getClass())) return null;
		ParseSuite<String, T2, GeneralNode<String, T2>> suite = new REGEXSuite((GeneralGrammar<String, T2>) grammar);
		return (GeneralNode<T1, T2>) parseTree((List<String>) sequence, (GeneralGrammar<String, T2>) grammar, suite, startSymbol);
	}
}
