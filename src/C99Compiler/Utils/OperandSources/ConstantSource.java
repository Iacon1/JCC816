// Created by Iacon1 on 11/05/2023.
//
package C99Compiler.Utils.OperandSources;

import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;

import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.PropPointer;
import C99Compiler.Utils.ProgramState.PreserveFlag;
import Shared.Assemblable.AssemblyStatePair;

public class ConstantSource extends ConstantByteSource
{
	private PropPointer<?> pointer;
	private Object constant;
	
	public static class ConstList extends LinkedList<SimpleEntry<Integer, Object>> {};
	private static int[] asBytes(Object obj, int size)
	{
		int[] bytes = new int[size];
		
		if (Float.class.isAssignableFrom(obj.getClass()) || Double.class.isAssignableFrom(obj.getClass()))
		{
			double d;
			if (Float.class.isAssignableFrom(obj.getClass()))
				d = ((Float) obj).doubleValue();
			else
				d = ((Double) obj).doubleValue();
			int exponent = Math.getExponent(d);
			long mantissa = (long) (Math.abs(d) * Math.pow(2, (size == 8 ? 52 : 23) - exponent));

			bytes = asBytes(mantissa, size);
			switch (size)
			{
			default:
			case 4:
				exponent += 127; // Bias

				bytes[2] &= 0x7F;
				bytes[2] |= (exponent & 0x01) << 7;
				bytes[3] = exponent >> 1;
				break;
			case 8:
				exponent += 1023; // Bias

				bytes[6] &= 0x0F;
				bytes[6] |= (exponent & 0x0F) << 4;
				bytes[7] = exponent >> 4;
				break;
			}
			if (d < 0)
				bytes[size - 1] |= 0x80;
		}
		else if (Integer.class.isAssignableFrom(obj.getClass()) || Long.class.isAssignableFrom(obj.getClass()))
		{
			String s = new StringBuilder().append(String.format("%0" + 2*size + "x", obj)).reverse().toString(); // Reverse for proper byte order
			String s2 = "";
			for (int i = 0; i < s.length(); i += 2) // Fix reversed bytes
			{
				char a = s.charAt(i);
				if (i < s.length() - 1)
				{
					char b = s.charAt(i + 1);
					s2 += "" + b + "" + a;
				}
				else
					s2 += a;
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
		else if (ConstList.class.isAssignableFrom(obj.getClass())) // Const list
		{
			ConstList list = (ConstList) obj;
			int i = 0;
			for (SimpleEntry<Integer, Object> entry : list)
			{
				int[] subBytes = asBytes(entry.getValue(), entry.getKey());
				for (int j = 0; j < entry.getKey(); ++j)
					bytes[i++] = subBytes[j];
			}
		}
		else if (Object[].class.isAssignableFrom(obj.getClass())) // Array
		{
			Object[] array = (Object[]) obj;
			int sizePer = size / array.length;
			for (int i = 0; i < array.length; ++i)
			{
				int[] subBytes = asBytes(array[i], sizePer);
				for (int j = 0; j < sizePer; ++j)
					bytes[sizePer * i + j] = subBytes[j];
			}
		}
		return bytes;
	}
	public ConstantSource(Object constant, int offset, int size)
	{
		super(asBytes(constant, size), offset, size);
		if (PropPointer.class.isAssignableFrom(constant.getClass()))
			pointer = (PropPointer<?>) constant;
		this.constant = constant;
	}
	
	public ConstantSource(Object constant, int size)
	{
		super(asBytes(constant, size), size);
		if (PropPointer.class.isAssignableFrom(constant.getClass()))
			pointer = (PropPointer<?>) constant;
		this.constant = constant;
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
	
	public String getBase(ProgramState state, int i)
	{
		if (pointer != null)
			return pointer.apply(state, i);
		else return super.getBase(state, i);
	}
	
	@Override
	public AssemblyStatePair getInstruction(ProgramState state, String operation, Integer i)
	{
		AssemblyStatePair pair;
		if (pointer != null && operation == "LDA")
		{
			pair = new AssemblyStatePair("", state.clearKnownFlags(PreserveFlag.A));
			pair = super.getInstruction(pair.state, operation, i);
			pair = new AssemblyStatePair(pair.assembly, pair.state.clearKnownFlags(PreserveFlag.A));
			return pair;
		}
		else
			return super.getInstruction(state, operation, i);
	}
	
	@Override
	public String getSpec()
	{
		if (pointer != null)
			return pointer.getSpec();
		else return super.getSpec();
	}
}
