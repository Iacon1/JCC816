// Created by Iacon1 on 10/26/2023.
// Constants for the compiler.
package Compiler.Utils;

import java.util.AbstractMap.SimpleEntry;

import Compiler.Utils.OperandSources.AddressSource;
import Compiler.Utils.OperandSources.OperandSource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public final class CompConfig
{
	public static final String version = "0.X";
	
	public static final String scopeDelimiter = "__";
	public static final int indentSize = 2;
	
	public static final int scratchBank = 0x7F;
	public static final int scratchPage = 0xFF;
	public static final int multDivSize = 16;
	public static final String multDivX = "__multDivX";
	public static final String multDivY = "__multDivY";
	public static final int scratchSize = 160;
	public static final String scratchBase = "__ScratchBase";
	public static final int callResultSize = 64;
	// 16 + 16 + 160 + 64 = 256 = Just large enough to be a ZP!
	public static final String callResult = "__callResult";
	
	public static final OperandSource callResultSource(int size)
	{
		if (size <= callResultSize) return new AddressSource(callResult, size);
		else return null;
	}
	public static final OperandSource multDivSource(boolean isX, int size)
	{
		if (size <= multDivSize) return new AddressSource((isX ? multDivX : multDivY), size);
		else return null;
	}
	public static final OperandSource callResultSource()
	{
		return callResultSource(callResultSize);
	}
	
	public static List<SimpleEntry<String, Integer>> reservedRAM() 
	{
		List<SimpleEntry<String, Integer>> list = new LinkedList<SimpleEntry<String, Integer>>();
		list.add(new SimpleEntry<String, Integer>(callResult, callResultSize));
		list.add(new SimpleEntry<String, Integer>(multDivY, multDivSize));
		list.add(new SimpleEntry<String, Integer>(multDivX, multDivSize));
		list.add(new SimpleEntry<String, Integer>(scratchBase, scratchSize));
		return list;
	};
	
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
	
	public static final int stackSize = 0x2000;
}