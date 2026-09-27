// Created by Iacon1 on 09/25/2026.
// An exception that we want to print nicely and doesn't necessarily imply the compiler
// is broken, as compared to an "internal" exception which we want the full trace for.

package C99Compiler.Exceptions;

public abstract class SoftException extends Exception
{
	public SoftException(String message)
	{
		super(message);
	}
}
