// By Iacon1
// Created 05/17/2023
//
package C99Compiler.CompilerNodes.Interfaces;

import C99Compiler.CompilerNodes.Definitions.Scope;

public interface NamedNode extends AddressableNode
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
	@Override public default String getAddress(int offset) {return getFullName() + (offset != 0 ? " + " + offset : "");}
}
