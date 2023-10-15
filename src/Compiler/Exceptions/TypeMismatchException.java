// By Iacon1
// Created 10/01/2023
//
package Compiler.Exceptions;

import Compiler.ComponentNodes.TypeNode;

@SuppressWarnings("serial")
public class TypeMismatchException extends Exception
{
	public TypeMismatchException(String t1, String t2)
	{
		super("The type \"" + t1 + "\" is not equivalent to " + t2);
	}
	public TypeMismatchException(TypeNode t1, TypeNode t2)
	{
		super("The type \"" + t1.getFullName() + "\" is not equivalent to " + t2.getFullName());
	}
}
