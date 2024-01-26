// Created by Iacon1 on 11/05/2023.
//
package C99Compiler.Utils.OperandSources;

import java.nio.ByteBuffer;
import java.util.Arrays;

import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.PropPointer;

public class ConstantByteSource extends OperandSource
{
	private byte[] bytes;

	public ConstantByteSource(byte[] source, int offset, int size)
	{
		super(size, offset, true);
		bytes = source;
	}
	public ConstantByteSource(byte[] source, int size)
	{
		super(size, true);
		bytes = source;
	}
	@Override
	public OperandSource getShifted(int offset, int size)
	{
		return new ConstantByteSource(bytes, this.offset + offset, this.size + size);
	}
	@Override
	public OperandSource getRespecified(int offset, int size)
	{
		return new ConstantByteSource(bytes, offset, size);
	}
	
	public String getBase(int i, DetailsTicket ticket)
	{
		if (bytes.length <= i) return "#$" + String.format(ticket.is16Bit() ? "%04x" : "%02x", 0);
		if (ticket.is16Bit())
			if (bytes.length == 1) return "#$" + String.format("%02x%02x", 0, bytes[0]);
			else return "#$" + String.format("%02x%02x", bytes[i + 1], bytes[i]);
		else return "#$" + String.format("%02x", bytes[i]);
	}
	@Override
	public String getBase()
	{
		return getBase(0, new DetailsTicket());
	}
	
	@Override
	public String getInstruction(String whitespace, String operation, Integer i, DetailsTicket ticket)
	{
		return whitespace + operation + "\t" + getBase(i, ticket) + "\n";
	}
}
