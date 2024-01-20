// Created by Iacon1 on 11/05/2023.
// Array
package Compiler.CompilerNodes.Definitions;

import Compiler.CompConfig;
import Compiler.CompilerNodes.LValues.LValueNode;
import Compiler.CompilerNodes.LValues.WrapperLValueNode;
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

	public int getLength()
	{
		return length;
	}
	public void setLength(int length)
	{
		this.length = length;
	}
	public LValueNode<?> getAtIndex(LValueNode<?> owner, int index)
	{
		return new WrapperLValueNode(owner, type, owner, index * type.getSize());
	}
	@Override
	public String getSignature()
	{
		if (length != -1) return type.getSignature() + "[" + length + "]";
		else return type.getSignature() + "[]";
	}
}
