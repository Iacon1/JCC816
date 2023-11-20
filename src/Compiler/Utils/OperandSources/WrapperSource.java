// Created by Iacon1 on 11/05/2023.
// Allows re-specifying a source's size
package Compiler.Utils.OperandSources;

import Compiler.Utils.AssemblyUtils.DetailsTicket;

public class WrapperSource extends OperandSource
{
	private OperandSource source;
	
	public WrapperSource(OperandSource source, int size)
	{
		super(size, source.isLiteral());
		this.source = source;
	}

	@Override
	public String getBase()
	{
		return source.getBase();
	}
	
	@Override
	public String getInstruction(String whitespace, String operation, Integer i, DetailsTicket ticket)
	{
		return source.getInstruction(whitespace, operation, i, ticket);
	}
}
