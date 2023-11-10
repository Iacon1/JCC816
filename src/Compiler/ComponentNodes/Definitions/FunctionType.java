// Created by Iacon1 on 11/09/2023.
// A type of pointer to another type.

package Compiler.ComponentNodes.Definitions;

import Compiler.Utils.CompConfig;

public class FunctionType extends Type
{
	protected Type type;
	
	public FunctionType(Type type)
	{
		this.type = type;
	}
	
	@Override
	public int getSize()
	{
		return CompConfig.pointerSize;
	}
	
	public Type getType()
	{
		return type;
	}
	
	@Override
	public boolean isFunction() {return true;}
	
	@Override
	public String getSignature()
	{
		String signature = "(" + type.getSignature() + ")";
		signature += "()";
		return signature;
	}
}
