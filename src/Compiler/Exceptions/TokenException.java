// Created by Iacon1 on 10/18/2023.
//
package Compiler.Exceptions;

import org.antlr.v4.runtime.Token;

@SuppressWarnings("serial")
public class TokenException extends Exception
{
	public TokenException(String message, Token location)
	{
		super("At " + location.getLine() + ":" + location.getCharPositionInLine() + "\n" +
				message);
	}
}