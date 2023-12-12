// Created by Iacon1 on 12/01/2023.
// The name of a byte in RAM

package Compiler.ASMGrapher;

public class Address
{
	private String name;
	private int offset;
	private boolean usesOffset;
	private int address;
	
	public Address(int address)
	{
		this.address = address;
	}
	public Address(String name)
	{
		this.name = name;
		usesOffset = false;
		this.offset = 0;
	}
	public Address(String name, int offset)
	{
		this.name = name;
		usesOffset = true;
		this.offset = offset;
	}
	
	public Address increment()
	{
		if (name != null) return new Address(name, offset + 1);
		else return new Address(address + 1);
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (other == null) return false;
		if (Address.class.isAssignableFrom(other.getClass()))
		{
			Address addr = (Address) other;
			if (this.name != null && addr.name != null)
				return this.name.equals(addr.name) && this.usesOffset == addr.usesOffset && this.offset == addr.offset;
			else if (this.name == null && addr.name == null)
				return this.address == addr.address;
			else return false;
		}
		else return false;
	}
	
	@Override
	public String toString()
	{
		if (this.name != null)
			if (usesOffset)
				return this.name + " + " + offset;
			else return this.name;
		else
			return Integer.toString(address, 16);
	}
	
	@Override
	public int hashCode()
	{
		if (this.name != null)
			return this.name.hashCode() + offset;
		else
			return address;
	}
}
