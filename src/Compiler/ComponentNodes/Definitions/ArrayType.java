// Created by Iacon1 on 11/05/2023.
// Array
package Compiler.ComponentNodes.Definitions;

import Compiler.Utils.CompConfig;

public class ArrayType extends Type
{
	private Type type;
	private int length; // -1 marks incomplete
	
	public ArrayType(Type type, int length)
	{
		this.type = type;
		this.length = length;
	}
	
	public ArrayType(Type type)
	{
		this.type = type;
		this.length = -1;
	}

	@Override
	public int getSize()
	{
		if (length == -1) return CompConfig.pointerSize;
		return type.getSize() * length;
	}
	
	public Type getType()
	{
		return type;
	}
	
	@Override
	public boolean isIncomplete() {return length == -1;}

	@Override
	public boolean isArray() {return true;}
	@Override
	public boolean isPointer() {return true;}
	
	@Override
	public String getSignature()
	{
		if (length != -1) return type.getSignature() + "[" + length + "]";
		else return type.getSignature() + "[]";
	}
}
