// By Iacon1
// Created 10/01/2023
//
package Compiler.Exceptions;

import Compiler.CompConfig;

@SuppressWarnings("serial")
public class UnsupportedSyntaxException extends Exception
{
	public UnsupportedSyntaxException(String syntax)
	{
		
		super("The operation \"" + syntax + "\" is not supported on version " + CompConfig.version + ".");
	}
}
