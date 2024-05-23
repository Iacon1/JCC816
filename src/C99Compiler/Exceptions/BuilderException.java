// Created by Iacon1 on 01/16/2024.
// An exception from the compiler
package C99Compiler.Exceptions;

public class BuilderException extends Exception
{
	public BuilderException(String message)
	{
		super("[Linker] " + message);
	}
}
