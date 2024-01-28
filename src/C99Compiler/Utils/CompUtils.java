// By Iacon1
// Created 05/17/2023
// Stores data used by other parts of the compiler.
package C99Compiler.Utils;

import java.util.AbstractMap.SimpleEntry;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public static Number parseLiteral(String literal)
	{
		if (literal.startsWith("0x")) // Hex;
			return Long.valueOf(literal.substring(2), 16);
		else if (literal.startsWith("0")) // Octal???
			return Long.valueOf(literal, 8);
		else if (literal.contains("'")) // Character constant
			return Long.valueOf(literal.getBytes()[1]);
		else // TODO, assume decimal for now
			return Long.valueOf(literal);	
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
	
	public static final String processEscapes(String s)
	{
		Pattern pattern = Pattern.compile("\\\\x[0-9A-Fa-f][0-9A-Fa-f]");
		Matcher matcher = pattern.matcher(s);
		List<MatchResult> results = new ArrayList<MatchResult>();
		while (matcher.find())
			results.add(matcher.toMatchResult());
		for (int i = results.size() - 1; i >= 0; --i)	 // In reverse order to avoid string indexing problems
		{
			MatchResult result = results.get(i);
			char b = (char) Integer.valueOf(result.group().substring(2), 16).intValue(); // Get byte
			s = s.substring(0, result.start()) + Character.valueOf(b) + s.substring(result.end());
		}
		return s;
	}
}
