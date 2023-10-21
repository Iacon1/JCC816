// By Iacon1
// Created 10/01/2023
// Typed Node
package Compiler.ComponentNodes.Interfaces;

import Compiler.ComponentNodes.Definitions.Type;

public interface TypedNode
{
	public Type getType();
	public default boolean canCastTo(Type type) {return getType().canCastTo(type);}
	public default boolean canCastFrom(Type type) {return getType().canCastFrom(type);}
	public default boolean canCastTo(TypedNode node) {return getType().canCastTo(node.getType());}
	public default boolean canCastFrom(TypedNode node) {return getType().canCastFrom(node.getType());}
}
