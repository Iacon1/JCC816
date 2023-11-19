// Created by Iacon1 on 11/09/2023.
// A type of pointer to another type.

package Compiler.ComponentNodes.Definitions;

import java.util.ArrayList;
import java.util.List;

import Compiler.CompConfig;
import Compiler.ComponentNodes.Interfaces.TypedNode;

public class FunctionType extends Type
{
	private Type type;
	private List<Type> parameterTypes;
	
	public FunctionType(List<Type> parameterTypes, Type type)
	{
		this.type = type;
		this.parameterTypes = new ArrayList<Type>();
		this.parameterTypes.addAll(parameterTypes);
	}
	public FunctionType(Type type, List<? extends TypedNode> parameters) // Annoyingly, these have to be in a different order
	{
		this.type = type;
		parameterTypes = new ArrayList<Type>();
		for (TypedNode node : parameters) parameterTypes.add(node.getType());
	}
	
	@Override
	public int getSize()
	{
		return type.getSize();
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
		String signature = type.getSignature();
		signature += "(";
		for (Type parameterType : parameterTypes) signature += parameterType.getSignature() + ", ";
		if (parameterTypes.size() != 0) signature = signature.substring(0, signature.length() - 2);
		signature += ")";
		return signature;
	}
}
