// Created by Iacon1 on 01/24/2024.
// Pragma exception

package C99Compiler.Exceptions;

public class ErrorException extends CompilerException
{

	public ErrorException(String message, String file, int line)
	{
		super("Error directive called on file \"" + file + "\" line " + line + ". Reason: " + message);
	}

}
