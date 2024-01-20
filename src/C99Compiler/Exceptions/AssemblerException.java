// Created by Iacon1 on 01/16/2024.
// An exception from the compiler
package C99Compiler.Exceptions;

public class AssemblerException extends Exception
{
	public AssemblerException(String message)
	{
		super("[Assembler] " + message);
	}
}
