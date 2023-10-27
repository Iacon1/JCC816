// Created by Iacon1 on 10/22/2023.
//
package Compiler.Utils;

import java.util.function.Function;

public class OperandSource implements Function<Integer, String>
{
	Function<Integer, String> f;
	private boolean isLiteral;
	private int size;
	
	public OperandSource(Function<Integer, String> f, int size, boolean isLiteral)
	{
		this.f = f;
		this.size = size;
		this.isLiteral = isLiteral;
	}
	public boolean isLiteral() {return isLiteral;}
	public int getSize() {return size;}
	
	@Override
	public String apply(Integer i)
	{
		return f.apply(i);
	}
}
