// Created by Iacon1 on 11/09/2023.
// A type of pointer to another type.

package C99Compiler.CompilerNodes.Definitions;

import java.util.ArrayList;
import java.util.List;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.Interfaces.TypedNode;

public class FunctionType extends StorageWrapperType
{
	private List<Type> parameterTypes;
	
	public FunctionType(List<Type> parameterTypes, Type type)
	{
		super(type);
		this.parameterTypes = new ArrayList<Type>();
		this.parameterTypes.addAll(parameterTypes);
	}
	public FunctionType(Type type, List<? extends TypedNode> parameters) // Annoyingly, these have to be in a different order
	{
		super(type);
		parameterTypes = new ArrayList<Type>();
		for (TypedNode node : parameters) parameterTypes.add(node.getType());
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
