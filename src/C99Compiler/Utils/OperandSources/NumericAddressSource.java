// Created by Iacon1 on 11/05/2023.
//
package C99Compiler.Utils.OperandSources;

import C99Compiler.CompConfig;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;

public class NumericAddressSource extends OperandSource
{
	private int address;
	
	public NumericAddressSource(int address, int offset, int size)
	{
		super(size, offset, false);
		this.address = address;
	}
	public NumericAddressSource(int address, int size)
	{
		super(size, false);
		this.address = address;
	}
	
	@Override
	public OperandSource getShifted(int offset, int size)
	{
		return new NumericAddressSource(address, this.offset + offset, this.size + size);
	}
	@Override
	public OperandSource getRespecified(int offset, int size)
	{
		return new NumericAddressSource(address, offset, size);
	}
	
	@Override
	public String getInstruction(String whitespace, String operation, Integer i, DetailsTicket ticket)
	{
		if (i >= size)
			return whitespace + operation + "\t" + CompConfig.signExtend + "\n";
		return whitespace + operation + "\t$" + String.format("%06x", address + i + offset) + "\n";
	}
	
	@Override
	public String getBase()
	{
		return "\t$" + String.format("%06x", address + offset);
	}
}
