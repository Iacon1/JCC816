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
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyType;

public final class CompUtils
{
	public static final String setA8 = "SEP\t#$20", setA16 = "REP\t#$20";
	public static final String setXY8 = "SEP\t#$10", setXY16 = "REP\t#$10";
	public static final String setAXY8 = "SEP\t#$30", setAXY16 = "REP\t#$30";

	public static final String headerTag = "__HEADER_HERE";
	
	public static Type getTypeForSize(int size, boolean isSigned)
	{
		List<String> specifiers = new ArrayList<String>();
		specifiers.add(isSigned ? "signed" : "unsigned");
		String[] options = new String[] {"char", "short", "int", "long", "long long"};
		for (String option : options)
			if (size <= CompConfig.sizeOf(option.split(" ")))
			{
				for (String subOption : option.split(" "))
					specifiers.add(subOption);
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
		else
			specifiers.add("unsigned");
		String[] options = new String[] {"char", "short", "int", "long", "long long"};
		for (String option : options)
			if (value < Math.pow(2, 8 * CompConfig.sizeOf(option.split(" "))))
			{
				specifiers.add(option);
				break;
			}
		return new DummyType(specifiers);
	}
	public static Type getSmallestSignedType(long value) {return getSmallestType(-1 * Math.abs(value));}
	public static Type getSmallestType(Number value)
	{
		return getSmallestType(value.longValue());
	}
	public static boolean fitsInType(long value, Type type)
	{
		if (type.isSigned())
		{
			long min = -(long) Math.pow(2, 8 * type.getSize()) / 2;
			long max = -min - 1;
			return (min <= value) && (value <= max);
		}
		else
		{
			long max = (long) Math.pow(2, 8 * type.getSize()) - 1;
			if (value < 0) value = 2 * -value;
			return value <= max;
		}
	}
	public static Type getLiteralType(String literal)
	{
		if (literal.contains("'")) // Character constant
			return new DummyType("char");
		
		literal = literal.toLowerCase();
		List<Type> typeList = new LinkedList<Type>();
		long value = parseLiteral(literal).longValue();
		int signedMode = 0; // 0 - only signed 1 - only unsigned 2 - both
		
		if (literal.startsWith("0x") || literal.startsWith("0") || literal.startsWith("0b")) // Hex or octal or binary
			signedMode = 2;
		
		String suffix = "";
		while (true)
		{
			if (literal.endsWith("u"))
				suffix = suffix + "u";
			else if (literal.endsWith("h"))
				suffix = suffix + "h";
			else if (literal.endsWith("l"))
				suffix = suffix + "l";
			else
				break;
			
			literal = literal.substring(0, literal.length() - 1);
		}
		
		if (suffix.contains("u"))
		{
			signedMode = 1;
			suffix = suffix.replace("u", "");
		}
		switch (suffix)
		{
		case "hh":
			if (signedMode != 1) typeList.add(new DummyType("char"));
			if (signedMode != 0) typeList.add(new DummyType("unsigned", "char"));
		case "h":
			if (signedMode != 1) typeList.add(new DummyType("short"));
			if (signedMode != 0) typeList.add(new DummyType("unsigned", "short"));
		default:
			if (signedMode != 1) typeList.add(new DummyType("int"));
			if (signedMode != 0) typeList.add(new DummyType("unsigned", "int"));
		case "l":
			if (signedMode != 1) typeList.add(new DummyType("long"));
			if (signedMode != 0) typeList.add(new DummyType("unsigned", "long"));
		case "ll":
			if (signedMode != 1) typeList.add(new DummyType("long", "long"));
			if (signedMode != 0) typeList.add(new DummyType("unsigned", "long", "long"));
		}
		for (Type type : typeList)
		{
			if (fitsInType(value, type))
				return type;
		}
		return new DummyType("int");
	}
	public static Number parseLiteral(String literal)
	{
		literal = literal.toLowerCase();
		if (literal.contains("'")) // Character constant
			return Long.valueOf((int) processEscapes(literal.substring(1, literal.length() - 1)).charAt(0));
		literal = literal.replace("h", "");
		literal = literal.replace("l", "");
		literal = literal.replace("u", "");
		if (literal.startsWith("0x")) // Hex;
			return Long.valueOf(literal.substring(2), 16);
		if (literal.startsWith("0b")) // Binary;
			return Long.valueOf(literal.substring(2), 2);
		else if (literal.startsWith("0")) // Octal
			return Long.valueOf(literal, 8);
		else // Decimal
			return Long.valueOf(literal);	
	}
	
	
	public static final boolean isInZeroPage(String label)
	{
		for (SimpleEntry<String, Integer> entry : CompConfig.reservedRAM())
			if (label.equals(entry.getKey()))
				return true;
		return false;
	}
	
	public static final String getSafeUUID()
	{
		return UUID.randomUUID().toString().replace("-", "_");
	}
	public static final String getMiscLabel()
	{
		return "__mLabel" + UUID.randomUUID().toString().replace("-", "_");
	}
	public static final String processEscapes(String s)
	{
		Pattern pattern = Pattern.compile("(\\\\x[0-9A-Fa-f]{0,2}+)|(\\\\[0-7]{0,3}+)");
		Matcher matcher = pattern.matcher(s);
		List<MatchResult> results = new ArrayList<MatchResult>();
		while (matcher.find())
			results.add(matcher.toMatchResult());
		for (int i = results.size() - 1; i >= 0; --i)	 // In reverse order to avoid string indexing problems
		{
			MatchResult result = results.get(i);
			if (result.group().length() < 2) continue;
			if (result.group().charAt(1) == 'x') // Hex
			{
				char b = (char) Integer.valueOf(result.group().substring(2), 16).intValue(); // Get byte
				s = s.substring(0, result.start()) + Character.valueOf(b) + s.substring(result.end());
			}
			else // Octal
			{
				char b = (char) Integer.valueOf(result.group().substring(1), 8).intValue(); // Get byte
				s = s.substring(0, result.start()) + Character.valueOf(b) + s.substring(result.end());
			}
		}
		return s;
	}
	public static int estimateLength(String statement)
	{
		return statement.split("\n").length * 4; // Assumes generous estimate of 4 bytes per instruction
	}
	public static Type getPointerType()
	{
		return getTypeForSize(CompConfig.pointerSize, false);
	}
}
