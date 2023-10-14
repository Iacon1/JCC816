// By Iacon1
// Created 10/01/2023
// Typed Node
package Compiler.ComponentNodes.Interfaces;

import Compiler.ComponentNodes.TypeNode;
import Compiler.CompConfig;

public interface TypedNode
{
	public TypeNode getType();
	public default boolean canCastTo(TypeNode type)
	{
		return  CompConfig.Primitive.getType(getType()).isNumeric() &&
				CompConfig.Primitive.getType(type).isNumeric() &&
				getType().getSize() <= type.getSize();
	}
	public default boolean canCastFrom(TypeNode type)
	{
		return  CompConfig.Primitive.getType(getType()).isNumeric() &&
				CompConfig.Primitive.getType(type).isNumeric() &&
				getType().getSize() >= type.getSize();
	}
	public default String getTypeName() {return getType().getName();}
}
