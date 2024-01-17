// Created by Iacon1 on 01/16/2024.
// An exception from the compiler
package Compiler.Exceptions;

public class CompilerException extends Exception
{
	public CompilerException(String message)
	{
		super("[Compiler] " + message);
	}
}
