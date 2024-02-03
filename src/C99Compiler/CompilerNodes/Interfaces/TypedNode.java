// By Iacon1
// Created 10/01/2023
// Typed Node
package C99Compiler.CompilerNodes.Interfaces;

import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;

public interface TypedNode
{
	public Type getType();
	public default int getSize() {return getType().getSize();}
	public default int getSizeBits() {return getType().getSizeBits();}
	public default boolean canCastTo(Type type, CastContext context) {return getType().canCastTo(type, context);}
	public default boolean canCastFrom(Type type, CastContext context) {return getType().canCastFrom(type, context);}
	public default boolean canCastTo(TypedNode node, CastContext context) {return getType().canCastTo(node.getType(), context);}
	public default boolean canCastFrom(TypedNode node, CastContext context) {return getType().canCastFrom(node.getType(), context);}
}
