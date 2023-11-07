// Created by Iacon1 on 11/05/2023.
//
package Compiler.Utils.OperandSources;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class ConstantSource extends OperandSource
{
	private byte[] bytes;
	
	public ConstantSource(Object constant, int size)
	{
		super(size, true);
		if (Number.class.isAssignableFrom(constant.getClass()))
		{
			bytes = Arrays.copyOfRange(ByteBuffer.allocate(Long.BYTES).putLong(((Number) constant).longValue()).array(), Long.BYTES - size, Long.BYTES);
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
	}
	
	@Override
	public String apply(Integer i, Boolean is16Bit)
	{
		if (bytes.length <= i) return "#$" + String.format(is16Bit ? "%04x" : "%02x", 0);
		if (is16Bit)
			if (bytes.length == 1) return "#$" + String.format("%02x%02x", 0, bytes[0]);
			else return "#$" + String.format("%02x%02x", bytes[i], bytes[i + 1]);
		else return "#$" + String.format("%02x", bytes[i]);
	}
}
