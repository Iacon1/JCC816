// Created by Iacon1 on 11/05/2023.
//
package Compiler.Utils.OperandSources;

import Compiler.Utils.AssemblyUtils.DetailsTicket;

public class AddressSource extends OperandSource
{
	private String address;
	
	public AddressSource(String address, int size)
	{
		super(size, false);
		this.address = address;
	}

	@Override
	public String getInstruction(String whitespace, String operation, Integer i, DetailsTicket ticket)
	{
		if (i >= size)
			return whitespace + operation + "\t" + (ticket.is16Bit() ? "#$0000" : "#$00") + "\n";
		return whitespace + operation + "\t" + address + " + " + i + "\n";
	}
	
	@Override
	public String getBase()
	{
		return address;
	}
}
