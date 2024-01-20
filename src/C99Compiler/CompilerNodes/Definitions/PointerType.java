// Created by Iacon1 on 11/04/2023.
// A type of pointer to another type.

package C99Compiler.CompilerNodes.Definitions;

import java.util.HashSet;
import java.util.Set;

import C99Compiler.CompConfig;

public class PointerType extends Type
{
	protected Type type;
	private Set<String> pointerQualifiers;
	
	public PointerType(Type type, Set<String> pointerQualifiers)
	{
		this.type = type;
		this.pointerQualifiers = new HashSet<String>();
		this.pointerQualifiers.addAll(pointerQualifiers);
	}
	public PointerType(Type type)
	{
		this.type = type;
		this.pointerQualifiers = new HashSet<String>();
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
	public boolean isPointer() {return true;}
	
	@Override
	public String getSignature()
	{
		String signature = "(" + type.getSignature() + ")";
		signature += "* ";
		for (String qualifier : pointerQualifiers) signature += qualifier + " ";
		
		return signature.substring(0, signature.length() - 1);
	}
}
