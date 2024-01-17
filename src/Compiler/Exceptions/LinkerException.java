// Created by Iacon1 on 01/16/2024.
// An exception from the compiler
package Compiler.Exceptions;

public class LinkerException extends Exception
{
	public LinkerException(String message)
	{
		super("[Linker] " + message);
	}
}
