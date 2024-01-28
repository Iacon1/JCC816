// Created by Iacon1 on 11/05/2023.
//
package C99Compiler.Utils.OperandSources;

import java.util.Arrays;

import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.PropPointer;

public class ConstantSource extends ConstantByteSource
{
	private PropPointer<?> pointer;
	private Object constant;
	
	private static int[] asBytes(Object obj, int size)
	{
		int[] bytes = new int[size];
		
		if (Number.class.isAssignableFrom(obj.getClass()))
		{
			String s = new StringBuilder().append(String.format("%0" + 2*size + "x", obj)).reverse().toString(); // Reverse for proper byte order
			String s2 = "";
			for (int i = 0; i < s.length(); i += 2) // Fix reversed bytes
			{
				char a = s.charAt(i);
				char b = s.charAt(i + 1);
				s2 += "" + b + "" + a;
			}
			s = s2;
			for (int i = 0; i < size; ++i)
			{
				bytes[i] = Integer.valueOf(s.substring(2 * i, 2 * (i + 1)), 16);
			}
				
		}
		else if (String.class.isAssignableFrom(obj.getClass()))
		{
			String str = (String) obj;
			// Fix escape sequences
			str = CompUtils.processEscapes(str);
			for (int i = 0; i < size; ++i)
			{
				if (i < str.length())
					bytes[i] = (int) str.charAt(i);
				else bytes[i] = 0x00;
			}
		}
		else if (Boolean.class.isAssignableFrom(obj.getClass()))
			bytes[0] = (Boolean) obj ? 0xFF : 0x00;
		
		return bytes;
	}
	public ConstantSource(Object constant, int offset, int size)
	{
		super(asBytes(constant, size), offset, size);
		if (PropPointer.class.isAssignableFrom(constant.getClass()))
			pointer = (PropPointer<?>) constant;
	}
	
	public ConstantSource(Object constant, int size)
	{
		super(asBytes(constant, size), size);
		if (PropPointer.class.isAssignableFrom(constant.getClass()))
			pointer = (PropPointer<?>) constant;
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
		else return super.getBase(i, ticket);
	}
}
