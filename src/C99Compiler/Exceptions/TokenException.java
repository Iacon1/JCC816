// Created by Iacon1 on 10/18/2023.
//
package C99Compiler.Exceptions;

import org.antlr.v4.runtime.Token;

import C99Compiler.C99Compiler;

public class TokenException extends CompilerException
{
	public TokenException(String message, Token location)
	{
		super("At " + C99Compiler.getCurrFilename() + " " + location.getLine() + ":" + location.getCharPositionInLine() + "\n" +
				message + "\n" + location.getText());
	}
	public TokenException(String message, int line, int charPositionInLine)
	{
		super("At " + C99Compiler.getCurrFilename() + " " + line + ":" + charPositionInLine + "\n" +
				message);
	}
}
