// Created by Iacon1 on 10/18/2023.
//
package C99Compiler.Exceptions;

import org.antlr.v4.runtime.Token;

import C99Compiler.CompilerNodes.ComponentNode;

import C99Compiler.Utils.LineInfo;

public class TokenException extends CompilerException
{
	private static String getMessage(String message, int line, int pos, String text, LineInfo info)
	{
		String filename;
		if (info == null)
		{
			filename = C99Compiler.C99Compiler.getCurrFilename();
		}
		else
		{
			filename = info.filename;
			line = info.line;
		}
		return "At " + filename + " " + line + ":" + pos + "\n" +
		message + "\n" + text;
	}
	private static String getMessage(String message, Token location, LineInfo info)
	{
		return getMessage(message, location.getLine(), location.getCharPositionInLine(), location.getText(), info);
	}
	
	public TokenException(String message, Token location, LineInfo info)
	{
		super(getMessage(message, location, info));	
	}
	public TokenException(String message, int line, int pos, String text, LineInfo info)
	{
		super(getMessage(message, line, pos, text, info));	
	}

	public TokenException(String message, Token location, ComponentNode<?> context)
	{
		super(getMessage(message, location, (context.getTranslationUnit() == null ? null : context.getTranslationUnit().getInfo(location.getLine()))));	
	}
	public TokenException(String message, int line, int pos, String text, ComponentNode<?> context)
	{
		super(getMessage(message, line, pos, text, (context.getTranslationUnit() == null ? null : context.getTranslationUnit().getInfo(line))));
	}
	
	
}
