// Created by Iacon1 on 11/12/2023.
// When something's declared with a type that doesn't exist.

package C99Compiler.Exceptions;

import org.antlr.v4.runtime.Token;

import C99Compiler.CompilerNodes.ComponentNode;

public class UndefinedTypeException extends TokenException
{

	public UndefinedTypeException(String type, Token location, ComponentNode<?> context)
	{
		super("The type " + type + " is not defined.", location, context);
	}

}
