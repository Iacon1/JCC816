// Created by Iacon1 on 11/05/2023.
//
package Compiler.Utils.OperandSources;

public class AddressSource extends OperandSource
{
	private String address;
	
	public AddressSource(String address, int size)
	{
		super(size, false);
		this.address = address;
	}

	@Override
	public String apply(Integer i, Boolean is16Bit)
	{
		return address + " + " + i;
	}
}
