// Created by Iacon1 on 11/05/2023.
//
package C99Compiler.Utils.OperandSources;

import java.nio.ByteBuffer;
import java.util.Arrays;

import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.PropPointer;

public class ConstantByteSource extends OperandSource
{
	private int[] bytes; // Not really bytes, I know

	public ConstantByteSource(int[] source, int offset, int size)
	{
		super(size, offset, true);
		bytes = source;
	}
	public ConstantByteSource(int[] source, int size)
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
		int signExtend = (bytes[bytes.length - 1] & 0x80) != 0 ? 0xFF : 0x00;
		if (bytes.length <= i) return "#$" + String.format("%02x", signExtend).repeat(ticket.is16Bit() ?  2 : 1);
		if (ticket.is16Bit())
		{
			if (bytes.length - 1 == i) return "#$" + String.format("%02x%02x", signExtend, bytes[i]);
			else return "#$" + String.format("%02x%02x", bytes[i + 1], bytes[i]);
		}
		else return "#$" + String.format("%02x", bytes[i]);
	}
	public String getBase(DetailsTicket ticket)
	{
		return getBase(0, ticket);
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
