// By Iacon1
// Created 10/01/2023
//
package Compiler.ComponentNodes.Exceptions;

@SuppressWarnings("serial")
public class UndefinedOpException extends Exception
{
	public UndefinedOpException(String fullTypeName, String operation)
	{
		super("The operation \"" + operation + "\" is not defined for the type " + fullTypeName);
	}
}
