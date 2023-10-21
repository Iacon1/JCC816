// By Iacon1
// Created 05/17/2023
//
package Compiler.ComponentNodes.Interfaces;

import Compiler.ComponentNodes.Definitions.Scope;

public interface NamedNode
{
	public Scope getScope();
	public String getName();
	
	public default String getFullName()
	{
		if (getScope() != null) return getScope().getPrefix() + getName();
		else return getName();
	}
}
