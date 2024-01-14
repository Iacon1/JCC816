// Created by Iacon1 on 11/12/2023.
// When something's declared with a type that doesn't exist.

package Compiler.Exceptions;

import org.antlr.v4.runtime.Token;

@SuppressWarnings("serial")
public class UndefinedVariableException extends TokenException
{

	public UndefinedVariableException(String type, Token location)
	{
		super("The variable " + type + " is not defined.", location);
	}

}
