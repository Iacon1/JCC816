// Created by Iacon1 on 01/17/2024.
// For when two of an item have been defined at once on the per-unit level.
package Compiler.Exceptions;

import org.antlr.v4.runtime.Token;

public class CompilerMultipleDefinitionException extends TokenException
{

	public CompilerMultipleDefinitionException(String name, Token start)
	{
		super("Item defined at least twice in scope: " + name, start);
	}
	
}
