// Created by Iacon1 on 10/17/2023.

package Compiler.Exceptions;

import org.antlr.v4.runtime.Token;

@SuppressWarnings("serial")
public class ConstraintException extends TokenException
{
	private static String getDesc(String section, int number)
	{
		switch (section + "." + number)
		{
		case "6.7.1.2": return
				"At most, one storage-class specifier may be given in the declaration specifiers in a declaration.";
		case "6.6.4": return
				"Each constant expression shall evaluate to a constant that is in the range of representable values for its type.";
		default:
			return "";
		}
	}
	
	public ConstraintException(String section, int constraintNumber, Token location)
	{
		super(getDesc(section, constraintNumber), location);
	}
}
