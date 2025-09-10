// Created by Iacon1 on 11/05/2023.
// Array
package C99Compiler.CompilerNodes.Definitions;

import java.util.HashSet;
import java.util.Set;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.CompilerNodes.LValues.WrapperLValueNode;
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
	public ArrayType(Type base, Type type, Set<String> qualifiers, int length)
	{
		super(base, type, qualifiers);
		this.length = length;
	}
	
	public PointerType decay()
	{
		return new PointerType(type);
	}
	@Override
	public int getSizeBits() {return 8 * getSize();}
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
