// Created by Iacon1 on 01/07/2024.
// Collects syntax errors from compiler

package Compiler;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import Compiler.Exceptions.SyntaxErrorException;
import Compiler.Exceptions.TokenException;


public class SyntaxErrorCollector implements ANTLRErrorListener
{
	private List<Exception> exceptions;
	
	public SyntaxErrorCollector()
	{
		exceptions = new ArrayList<Exception>();
	}
	@Override
	public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg,
			RecognitionException e)
	{
		exceptions.add(new SyntaxErrorException(msg, line, charPositionInLine));
	}

	public Exception getException()
	{
		if (exceptions.isEmpty()) return null;
		
		Exception e = exceptions.get(0);
		
		for (int i = 1; i < exceptions.size(); ++i)
			e.addSuppressed(exceptions.get(i));
		
		return e;
	}
}
