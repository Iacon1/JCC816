// Created by Iacon1 on 02/02/2024.
// Node with an address

package C99Compiler.CompilerNodes.Interfaces;

public interface AddressableNode
{
	public String getAddress(int offset);
	public default String getAddress() {return getAddress(0);}
}
