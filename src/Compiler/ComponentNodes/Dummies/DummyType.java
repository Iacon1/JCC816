// By Iacon1
// Created 05/11/2023
// A type
package Compiler.ComponentNodes.Dummies;

import Compiler.ComponentNodes.TypeNode;

public class DummyType extends TypeNode
{
	private int size;
	
	public DummyType(String name, int size)
	{
		super(name);
		this.size = size;
	}

	@Override
	public int getSize() {return size;}
}
