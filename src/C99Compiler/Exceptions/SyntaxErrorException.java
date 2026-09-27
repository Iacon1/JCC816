// Created by Iacon1 on 01/07/2024.
// Syntax Error Exception

package C99Compiler.Exceptions;

import org.antlr.v4.runtime.Token;

import C99Compiler.Utils.LineInfo;

public class SyntaxErrorException extends TokenException
{
	public SyntaxErrorException(Token location, LineInfo info)
	{
		super("Syntax error", location, info);	
	}
	public SyntaxErrorException(int line, int pos, String text, LineInfo info)
	{
		super("Syntax error", line, pos, text, info);
	}
}
