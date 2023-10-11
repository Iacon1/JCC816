// By Iacon1
// Created 10/01/2023
// Typed Node
package Compiler.ComponentNodes.Interfaces;

import Compiler.ComponentNodes.TypeNode;

public interface TypedNode
{
	public TypeNode getType();
	public default String getTypeName() {return getType().getName();}
}
