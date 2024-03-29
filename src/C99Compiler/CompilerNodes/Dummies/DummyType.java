// By Iacon1
// Created 05/11/2023
// A type
package C99Compiler.CompilerNodes.Dummies;

import java.util.Arrays;
import java.util.List;

import C99Compiler.CompilerNodes.Definitions.Type;

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
