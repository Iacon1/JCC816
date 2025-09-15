// Created by Iacon1 on 01/07/2024.
// Syntax Error Exception

package C99Compiler.Exceptions;

import org.antlr.v4.runtime.Token;

public class SyntaxErrorException extends TokenException
{

	public SyntaxErrorException(String message, int line, int charPositionInLine)
	{
		super(message, line, charPositionInLine);
	}
	public SyntaxErrorException(String message, Token token)
	{
		super(message, token);
	}

}
