// Created by Iacon1 on 10/26/2023.
// Constants for the compiler.
package Compiler.Utils;

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
}
