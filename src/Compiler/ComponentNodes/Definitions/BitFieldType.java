// Created by Iacon1 on 11/08/2023.
// A bitefield-specified type

package Compiler.ComponentNodes.Definitions;

public class BitFieldType extends Type
{
	private long sizeBits;
	public BitFieldType(Type type, long sizeBits)
	{
		super(type);
		
		this.sizeBits = sizeBits;
	}
	
	@Override
	public int getSize()
	{
		return (int) Math.ceil(getSizeBits() / 8);
	}
	
	@Override
	public int getSizeBits()
	{
		return (int) sizeBits;
	}
}
