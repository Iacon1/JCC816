// Created by Iacon1 on 11/05/2023.
//
package Compiler.Utils.OperandSources;

import java.nio.ByteBuffer;
import java.util.Arrays;

import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.PropPointer;

public class ConstantSource extends OperandSource
{
	private byte[] bytes;
	private PropPointer<?> pointer;
	private Object constant;
	
	public ConstantSource(Object constant, int offset, int size)
	{
		super(size, offset, true);
		if (Number.class.isAssignableFrom(constant.getClass()))
		{
			bytes = Arrays.copyOfRange(
					ByteBuffer.allocate(Math.max(size, Long.BYTES)).
					putLong(Math.max(size - Long.BYTES, 0), ((Number) constant).longValue()).
					array(), Math.max(Long.BYTES - size, 0), Long.BYTES);
			// little-endian WRT words
			if (bytes.length >= 4)
				for (int i = 0; i < bytes.length - 1; i += 2)
				{
					byte x = bytes[i];
					byte y = bytes[i + 1];
					bytes[i] = bytes[bytes.length - 2 - i]; bytes[bytes.length - 2 - i] = x;
					bytes[i + 1] = bytes[bytes.length - 1 - i]; bytes[bytes.length - 1 - i] = y;
				}
			else if (bytes.length == 3)
			{
				byte x = bytes[2];
				bytes[2] = bytes[1];
				bytes[1] = x;
			}
		}
		else if (String.class.isAssignableFrom(constant.getClass()))
		{
			bytes = ((String) constant).getBytes();
		}
		else if (Boolean.class.isAssignableFrom(constant.getClass()))
		{
			bytes = new byte[] {(byte) ((Boolean) constant ? 0xFF : 0x00)};
		}
		else if (PropPointer.class.isAssignableFrom(constant.getClass()))
		{
			pointer = (PropPointer<?>) constant;
		}
	}
	public ConstantSource(Object constant, int size)
	{
		super(size, true);
		if (Number.class.isAssignableFrom(constant.getClass()))
		{
			bytes = Arrays.copyOfRange(
					ByteBuffer.allocate(Math.max(size, Long.BYTES)).
					putLong(Math.max(size - Long.BYTES, 0), ((Number) constant).longValue()).
					array(), Math.max(Long.BYTES - size, 0), Long.BYTES);
			// little-endian WRT words
			if (bytes.length >= 4)
				for (int i = 0; i < bytes.length - 1; i += 2)
				{
					byte x = bytes[i];
					byte y = bytes[i + 1];
					bytes[i] = bytes[bytes.length - 2 - i]; bytes[bytes.length - 2 - i] = x;
					bytes[i + 1] = bytes[bytes.length - 1 - i]; bytes[bytes.length - 1 - i] = y;
				}
			else if (bytes.length == 3)
			{
				byte x = bytes[2];
				bytes[2] = bytes[1];
				bytes[1] = x;
			}
		}
		else if (String.class.isAssignableFrom(constant.getClass()))
		{
			bytes = ((String) constant).getBytes();
		}
		else if (Boolean.class.isAssignableFrom(constant.getClass()))
		{
			bytes = new byte[] {(byte) ((Boolean) constant ? 0xFF : 0x00)};
		}
		else if (PropPointer.class.isAssignableFrom(constant.getClass()))
		{
			pointer = (PropPointer<?>) constant;
		}
	}
	@Override
	public OperandSource getShifted(int offset, int size)
	{
		return new ConstantSource(constant, this.offset + offset, this.size + size);
	}
	@Override
	public OperandSource getRespecified(int offset, int size)
	{
		return new ConstantSource(constant, offset, size);
	}
	
	public String getBase(int i, DetailsTicket ticket)
	{
		if (pointer != null) return pointer.apply(i, ticket);
		if (bytes.length <= i) return "#$" + String.format(ticket.is16Bit() ? "%04x" : "%02x", 0);
		if (ticket.is16Bit())
			if (bytes.length == 1) return "#$" + String.format("%02x%02x", 0, bytes[0]);
			else return "#$" + String.format("%02x%02x", bytes[i], bytes[i + 1]);
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
