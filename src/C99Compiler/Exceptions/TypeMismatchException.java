// By Iacon1
// Created 10/01/2023
//
package C99Compiler.Exceptions;

import C99Compiler.CompilerNodes.Definitions.Type;

@SuppressWarnings("serial")
public class TypeMismatchException extends CompilerException
{
	public TypeMismatchException(String t1, String t2)
	{
		super("The type \"" + t1 + "\" can not be cast to \"" + t2 + "\"");
	}
	public TypeMismatchException(Type t1, Type t2)
	{
		super("The type \"" + t1.getSignature() + "\" can not be cast to \"" + t2.getSignature() + "\"");
	}
}
