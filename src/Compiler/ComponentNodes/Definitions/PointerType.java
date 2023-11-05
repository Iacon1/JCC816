// Created by Iacon1 on 11/04/2023.
// A type of pointer to another type.

package Compiler.ComponentNodes.Definitions;

import java.util.HashSet;
import java.util.Set;

import Compiler.Utils.CompUtils;

public class PointerType extends Type
{
	private Type type;
	private Set<String> pointerQualifiers;
	
	public PointerType(Type type, Set<String> pointerQualifiers)
	{
		this.type = type;
		this.pointerQualifiers = new HashSet<String>();
		this.pointerQualifiers.addAll(pointerQualifiers);
	}
	
	@Override
	public int getBaseSize()
	{
		return CompUtils.pointerSize;
	}
	
	public Type getType()
	{
		return type;
	}
	
	@Override
	public String getSignature()
	{
		String signature = "(" + type.getSignature() + ")";
		signature += "* ";
		for (String qualifier : pointerQualifiers) signature += qualifier + " ";
		
		return signature.substring(0, signature.length());
	}
}
