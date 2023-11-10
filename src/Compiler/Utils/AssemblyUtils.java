// Created by Iacon1 on 10/22/2023.
//
package Compiler.Utils;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Function;

import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.LValues.VariableNode;
import Compiler.Utils.OperandSources.OperandSource;

public final class AssemblyUtils
{
	public static String applyFiller(String string, int desiredLength)
	{
		String filler = new String(new char[desiredLength - string.length()]).replace('\0', ' ');
		
		return string + filler;
	}
	public static String getWhitespace(int leadingWhitespace) {return new String(new char[leadingWhitespace]).replace('\0', ' ');}
	public static String bytewiseOperation(String whitespace, int nBytes, BiFunction<Integer, Boolean, String[]> perIteration, boolean set16, boolean reverse)
	{
		String assembly = "";
		
		if (nBytes >= 2 && set16) assembly += whitespace + CompUtils.setAXY16 + "\n";
		else if (!set16) assembly += whitespace + CompUtils.setAXY8 + "\n";
		for (int i = 0; i < nBytes - 1; i += (set16? 2 : 1))
		{
			int j = i;
			if (reverse)
				j = (nBytes % 2 == 1) ? nBytes - 1 - i : nBytes - 2 - i;
			for (String opLine : perIteration.apply(j, set16))
				assembly += whitespace + opLine + "\n";
		}
		if (nBytes % 2 == 1 && set16)
		{
			assembly += whitespace + CompUtils.setAXY8 + "\n";
			for (String opLine : perIteration.apply(reverse? 0 : nBytes - 1, false))
				assembly += whitespace + opLine + "\n";
		}
		
		return assembly;
	}
	public static String bytewiseOperation(String whitespace, int nBytes, BiFunction<Integer, Boolean, String[]> perIteration)
	{
		return bytewiseOperation(whitespace, nBytes, perIteration, true, false);
	}
	public static String byteCopier(String whitespace, int nBytes, OperandSource writeSource, OperandSource readSource)
	{
		return bytewiseOperation(whitespace, nBytes, (Integer i, Boolean is16Bit) -> 
			{
				return new String[]
						{
						readSource.prefaceAssembly(whitespace, i, is16Bit),
						"LDA\t" + readSource.apply(i, is16Bit),
						writeSource.prefaceAssembly(whitespace, i, is16Bit),
						"STA\t" + writeSource.apply(i, is16Bit),
						};
			});
	}
}
