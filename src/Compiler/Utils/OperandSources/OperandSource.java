// Created by Iacon1 on 10/22/2023.
//
package Compiler.Utils.OperandSources;

import java.util.function.BiFunction;

import Compiler.Utils.AssemblyUtils.DetailsTicket;

public abstract class OperandSource implements BiFunction<Integer, DetailsTicket, String>
{
	private boolean isLiteral;
	protected int size;
	
	public OperandSource(int size, boolean isLiteral)
	{
		this.size = size;
		this.isLiteral = isLiteral;
	}
	public boolean isLiteral() {return isLiteral;}
	public int getSize() {return size;}
	
	@Override
	public abstract String apply(Integer i, DetailsTicket ticket);
	
	/** An assembly preface that must be run before the source can be applied. 
	 * Usually not needed.
	 * @param whitespace The whitespace to put before each line.
	 * @param scratchManager The current scratch manager.
	 * @return The assembly required before the source can be applied.
	 */
	public String prefaceAssembly(String whitespace, Integer i, DetailsTicket ticket)
	{
		return "";
	}
}
