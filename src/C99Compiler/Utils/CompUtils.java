// By Iacon1
// Created 05/17/2023
// Stores data used by other parts of the compiler.
package C99Compiler.Utils;

import java.util.AbstractMap.SimpleEntry;

import C99Compiler.CompConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyType;

public final class CompUtils
{
	public static final String setA8 = "SEP\t#$20", setA16 = "REP\t#$20";
	public static final String setXY8 = "SEP\t#$10", setXY16 = "REP\t#$10";
	public static final String setAXY8 = "SEP\t#$30", setAXY16 = "REP\t#$30";

	public static final class Attributes
	{
		public static final String interrupt = "interrupt";
		public static final String noISR1 = "no_isr1"; // Level 1 noISR - removes normal stack pushers / loaders from interrupt handler
		public static final String noISR2 = "no_isr2"; // Level 2 noISR - like level 1, but replaces RTI with RTL
		public static final String SA1 = "sa1";	// Specifies that a function can only be called on the SA1 coprocessor
	}

	public static final String headerTag = "__HEADER_HERE";
	
	public static Type getTypeForSize(int size, boolean isSigned)
	{
		List<String> specifiers = new ArrayList<String>();
		specifiers.add(isSigned ? "signed" : "unsigned");
		String[] options = new String[] {"char", "short", "int", "long", "long long"};
		for (String option : options)
			if (size <= CompConfig.sizeOf(option.split(" ")))
			{
				specifiers.add(option);
				break;
			}
		return new DummyType(specifiers);
	}
	public static Type getSmallestType(long value)
	{
		List<String> specifiers = new ArrayList<String>();
		if (value < 0)
		{
			specifiers.add("signed");
			value = 2 * Math.abs(value);
		}
		String[] options = new String[] {"char", "short", "int", "long", "long long"};
		for (String option : options)
			if (value < Math.pow(2, 8 * CompConfig.sizeOf(option.split(" "))))
			{
				specifiers.add(option);
				break;
			}
		return new DummyType(specifiers);
	}
	public static Type getSmallestType(Number value)
	{
		return getSmallestType(value.longValue());
	}
	public static Object parseLiteral(String literal)
	{
		if (literal.startsWith("0x")) // Hex;
			return Long.valueOf(literal.substring(2), 16);
		else
			return Long.valueOf(literal); // TODO
		
	}
	
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
	
	public static final boolean isInZeroPage(String label)
	{
		for (SimpleEntry<String, Integer> entry : CompConfig.reservedRAM())
			if (label.equals(entry))
				return true;
		return false;
	}
	
	public static final String getSafeUUID()
	{
		return UUID.randomUUID().toString().replace("-", "_");
	}
}
