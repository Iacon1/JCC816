// By Iacon1
// Created 05/17/2023
// Stores data used by other parts of the compiler.
package Compiler.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.Dummies.DummyType;

public final class CompUtils
{
	public static final String setA8 = "SEP\t#$20", setA16 = "REP\t#$20";
	public static final String setXY8 = "SEP\t#$10", setXY16 = "REP\t#$10";
	public static final String setAXY8 = "SEP\t#$30", setAXY16 = "REP\t#$30";

	public static final class Attributes
	{
		public static final String interrupt = "interrupt";
		public static final String noISR = "no_isr";
	}

	public static final String headerTag = "__HEADER_HERE";
	
	private static final int charSize = 1;
	private static final int shortSize = 2;
	private static final int intSize = 3;
	private static final int longSize = 4;
	private static final int longLongSize = 8;
	public static final int pointerSize = 3;
	public static int sizeOf(List<String> typeSpecifiers)
	{
		if (typeSpecifiers.contains("char")) return charSize;
		else if (typeSpecifiers.contains("int") || typeSpecifiers.contains("short") || typeSpecifiers.contains("long"))
		{
			int shortCount = 0, longCount = 0;
			for (String specifier : typeSpecifiers) if (specifier.equals("short")) return shortSize;
			if (shortCount == 1) return shortSize;
			for (String specifier : typeSpecifiers) if (specifier.equals("long")) longCount += 1;
			if (longCount == 1) return longSize;
			else if (longCount == 2) return longLongSize;
			return intSize;
		}
		else return 0;
	}
	public static int sizeOf(String... typeSpecifiers)
	{
		return sizeOf(Arrays.asList(typeSpecifiers));
	}
	public static Type getSmallestType(long value)
	{
		List<String> specifiers = new ArrayList<String>();
		if (value < 0)
		{
			specifiers.add("signed");
			value = 2 * Math.abs(value);
		}
		if (value < Math.pow(2, 8)) specifiers.add("char");
		else
		{
			int s = intSize;
			// How many long must we add?
			while (value > Math.pow(2, 8 * s))
			{
				s *= 2;
				specifiers.add("long");
			}
			// How many short can we add?
			while (value < Math.pow(2, 8 * s) / 2)
			{
				s /= 2;
				specifiers.add("short");
				if (s == 0) break;
			}
			if (s == 0) specifiers.add("int");
		}
		return new DummyType(specifiers);
	}
	public static Type getSmallestType(Number value)
	{
		return getSmallestType(value.longValue());
	}
	public static Object parseLiteral(String literal)
	{
		return Long.valueOf(literal); // TODO
		
	}
	
	public static int stackSize = 0x2000;
	/** Maps a byte offset from the start of RAM to a memory address the CPU can understand.
	 *  @param offset The offset from the start of RAM.
	 */
	public static final String mapOffset(int offset, int size)
	{
		offset += size;
		if (offset / 0x10000 <= (0x7F - 0x7E))
		{
			String bank = String.format("%02x", 0x7F - offset / 0x10000);
			String addr = String.format("%04x", 0xFFFF - (offset % 0x10000));
			return "$" + bank + addr;
		}
		else return null;
	}
}
