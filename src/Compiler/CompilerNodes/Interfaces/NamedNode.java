// By Iacon1
// Created 05/17/2023
//
package Compiler.CompilerNodes.Interfaces;

import Compiler.CompilerNodes.Definitions.Scope;

public interface NamedNode
{
	public Scope getScope();
	public String getName();
	
	public default String getFullName()
	{
		String fullName = null;
		if (getScope() != null) fullName = getScope().getPrefix() + getName();
		else fullName = getName();
		return (fullName.length() == 1 ? "__" : "") + fullName;
	}
}
