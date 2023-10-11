// By Iacon1
// Created 05/11/2023
//
package Compiler.ComponentNodes.Dummies;

import Compiler.ComponentNodes.TypeNode;
import Compiler.ComponentNodes.VarDeclarationNode;

public class DummyVarDecl extends VarDeclarationNode
{
	private int size;
	
	public DummyVarDecl(String name, int size)
	{
		super();
		this.name = name;
		this.size = size;
	}

	@Override
	public String getTypeName()
	{
		return getType().getName();
	}
	@Override
	public TypeNode getType()
	{
		return new DummyType(null, size);
	}
}
