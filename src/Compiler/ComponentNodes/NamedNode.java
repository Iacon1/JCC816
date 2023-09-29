// By Iacon1
// Created 05/17/2023
//
package Compiler.ComponentNodes;

public interface NamedNode
{
	public String getScopePrefix();
	public String getName();
	
	public default String getFullName()
	{
		return getScopePrefix() + getName();
	}
}
