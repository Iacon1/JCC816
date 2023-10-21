// By Iacon1
// Created 10/01/2023
//
package Compiler.Exceptions;

import org.antlr.v4.runtime.Token;

import Compiler.Utils.CompUtils;

@SuppressWarnings("serial")
public class UnsupportedSyntaxException extends TokenException
{
	public UnsupportedSyntaxException(String syntax, Token location)
	{
		super("The syntax \"" + syntax + "\" is not supported on version " + CompUtils.version + ".", location);
	}
}
