// By Iacon1
// Created 05/11/2023
// A type
package C99Compiler.CompilerNodes.Dummies;

import java.util.Arrays;
import java.util.List;

import C99Compiler.CompilerNodes.Definitions.Type;

public class DummyType extends Type
{
	private int sizeBits = -1;
	public DummyType(int sizeBits, List<String> typeSpecifiers)
	{
		super();
		this.sizeBits = sizeBits;
		this.typeSpecifiers = typeSpecifiers;
	}
	public DummyType(List<String> typeSpecifiers)
	{
		super();
		this.sizeBits = -1;
		this.typeSpecifiers = typeSpecifiers;
	}
	public DummyType(int sizeBits, String... typeSpecifiers)
	{
		super();
		this.sizeBits = sizeBits;
		this.typeSpecifiers = Arrays.asList(typeSpecifiers);
	}
	public DummyType(String... typeSpecifiers)
	{
		super();
		this.sizeBits = -1;
		this.typeSpecifiers = Arrays.asList(typeSpecifiers);
	}
	
	@Override
	public int getSizeBits()
	{
		if (sizeBits == -1) return super.getSizeBits();
		else return sizeBits;
	}
	
	@Override
	public int getSize()
	{
		if (sizeBits == -1) return super.getSize();
		else return sizeBits / 8;
	}
}
