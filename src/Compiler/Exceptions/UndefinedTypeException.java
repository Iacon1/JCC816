// Created by Iacon1 on 11/12/2023.
// When something's declared with a type that doesn't exist.

package Compiler.Exceptions;

import org.antlr.v4.runtime.Token;

public class UndefinedTypeException extends TokenException
{

	public UndefinedTypeException(String type, Token location)
	{
		super("The type " + type + " is not defined.", location);
	}

}
