// Created by Iacon1 on 01/07/2024.
// Syntax Error Exception

package Compiler.Exceptions;

public class SyntaxErrorException extends TokenException
{

	public SyntaxErrorException(String message, int line, int charPositionInLine)
	{
		super(message, line, charPositionInLine);
	}

}
