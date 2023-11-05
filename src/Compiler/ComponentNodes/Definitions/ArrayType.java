// Created by Iacon1 on 11/05/2023.
// Array
package Compiler.ComponentNodes.Definitions;

public class ArrayType extends Type
{
	private Type type;
	private int length;
	
	public ArrayType(Type type, int length)
	{
		this.type = type;
		this.length = length;
	}
	
	@Override
	public int getSize()
	{
		return type.getSize() * length;
	}
	
	public Type getType()
	{
		return type;
	}
	
	@Override
	public boolean isArray() {return true;}
	
	@Override
	public String getSignature()
	{
		return type.getSignature() + "[" + length + "]";
	}
}
