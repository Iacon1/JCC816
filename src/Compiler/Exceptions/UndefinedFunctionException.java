// Created by Iacon1 on 11/12/2023.
// When something's declared with a type that doesn't exist.

package Compiler.Exceptions;

import Compiler.CompilerNodes.FunctionDefinitionNode;

@SuppressWarnings("serial")
public class UndefinedFunctionException extends LinkerException
{

	public UndefinedFunctionException(FunctionDefinitionNode function)
	{
		super("Function " + function.getFullName() + " is declared but never defined.");
	}

}
