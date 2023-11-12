// Created by Iacon1 on 11/05/2023.
// Source with adjustable size
package Compiler.Utils.OperandSources;

import Compiler.Utils.AssemblyUtils.DetailsTicket;

/**
 * 
 */
public class WrapperSource extends OperandSource
{
	private OperandSource source;
	
	public WrapperSource(OperandSource source, int size)
	{
		super(size, source.isLiteral());
		this.source = source;
	}

	@Override
	public String apply(Integer i, DetailsTicket ticket)
	{
		return source.apply(i, ticket);
	}

}
