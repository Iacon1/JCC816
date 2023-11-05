// Created by Iacon1 on 10/26/2023.
// Constants for the compiler.
package Compiler.Utils;

import java.util.Arrays;
import java.util.List;

public final class CompConfig
{
	public static final String version = "0.X";
	
	public static final String scopeDelimiter = "__";
	public static final int indentSize = 2;
	
	public static final int scratchSize = 192;
	public static final String scratchBase = "__ScratchBase";
	public static final int callResultSize = 64; // Just large enough to be a ZP!
	public static final String callResult = "__callResult";
	public static final OperandSource callResultSource(int size)
	{
		if (size <= callResultSize) return AssemblyUtils.addressSource(callResult, size);
		else return null;
	}
	public static final OperandSource callResultSource()
	{
		return callResultSource(callResultSize);
	}
	
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
