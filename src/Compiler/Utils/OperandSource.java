// Created by Iacon1 on 10/22/2023.
//
package Compiler.Utils;

import java.util.function.BiFunction;

public class OperandSource implements BiFunction<Integer, Boolean, String>
{
	BiFunction<Integer, Boolean, String> f;
	private boolean isLiteral;
	private int size;
	
	public OperandSource(BiFunction<Integer, Boolean, String> f, int size, boolean isLiteral)
	{
		this.f = f;
		this.size = size;
		this.isLiteral = isLiteral;
	}
	public boolean isLiteral() {return isLiteral;}
	public int getSize() {return size;}
	
	@Override
	public String apply(Integer i, Boolean is16Bit)
	{
		return f.apply(i, is16Bit);
	}
}
