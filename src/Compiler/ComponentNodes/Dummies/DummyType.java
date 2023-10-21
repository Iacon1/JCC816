// By Iacon1
// Created 05/11/2023
// A type
package Compiler.ComponentNodes.Dummies;

import java.util.Arrays;
import java.util.List;

import Compiler.ComponentNodes.Definitions.Type;

public class DummyType extends Type
{
	public DummyType(List<String> typeSpecifiers)
	{
		super();
		this.typeSpecifiers = typeSpecifiers;
	}
	public DummyType(String... typeSpecifiers)
	{
		super();
		this.typeSpecifiers = Arrays.asList(typeSpecifiers);
	}
}
