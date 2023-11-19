// Created by Iacon1 on 11/05/2023.
// Array
package Compiler.ComponentNodes.Definitions;

import Compiler.CompConfig;

public class ArrayType extends PointerType
{
	private int length; // -1 marks incomplete
	
	public ArrayType(Type type, int length)
	{
		super(type);
		this.length = length;
	}
	
	public ArrayType(Type type)
	{
		super(type);
		this.length = -1;
	}

	@Override
	public int getSize()
	{
		if (length == -1) return CompConfig.pointerSize;
		return type.getSize() * length;
	}

	@Override
	public boolean isIncomplete() {return length == -1;}

	@Override
	public boolean isArray() {return true;}

	@Override
	public String getSignature()
	{
		if (length != -1) return type.getSignature() + "[" + length + "]";
		else return type.getSignature() + "[]";
	}
}
