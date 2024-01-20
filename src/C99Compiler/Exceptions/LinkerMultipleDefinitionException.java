// Created by Iacon1 on 01/17/2024.
// For when two of an item have been defined at once on the linker level.
package C99Compiler.Exceptions;

import C99Compiler.CompilerNodes.Interfaces.NamedNode;

public class LinkerMultipleDefinitionException extends LinkerException
{

	public <T extends NamedNode> LinkerMultipleDefinitionException(T item)
	{
		super("Item defined at least twice: " + item.getFullName());
	}
	
}
