// Created by Iacon1 on 11/05/2023.
//
package C99Compiler.Utils.OperandSources;

import C99Compiler.Utils.AssemblyUtils.DetailsTicket;

public class AddressSource extends OperandSource
{
	private String address;
	
	public AddressSource(String address, int offset, int size)
	{
		super(size, offset, false);
		this.address = address;
	}
	public AddressSource(String address, int size)
	{
		super(size, false);
		this.address = address;
	}
	
	@Override
	public OperandSource getShifted(int offset, int size)
	{
		return new AddressSource(address, this.offset + offset, this.size + size);
	}
	@Override
	public OperandSource getRespecified(int offset, int size)
	{
		return new AddressSource(address, offset, size);
	}
	
	@Override
	public String getInstruction(String whitespace, String operation, Integer i, DetailsTicket ticket)
	{
		if (i >= size)
			return whitespace + operation + "\t" + (ticket.is16Bit() ? "#$0000" : "#$00") + "\n";
		return whitespace + operation + "\t" + address + " + " + (i + offset) + "\n";
	}
	
	@Override
	public String getBase()
	{
		return address;
	}
}
