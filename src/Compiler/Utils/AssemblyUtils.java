// Created by Iacon1 on 10/22/2023.
//
package Compiler.Utils;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;

import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.VariableNode;

public final class AssemblyUtils
{
	public static String applyFiller(String string, int desiredLength)
	{
		String filler = new String(new char[desiredLength - string.length()]).replace('\0', ' ');
		
		return string + filler;
	}
	public static String getWhitespace(int leadingWhitespace) {return new String(new char[leadingWhitespace]).replace('\0', ' ');}
	public static String getVariableBlock(String whitespace, Collection<VariableNode> vars)
	{
		String assembly = "";
		int maxLength = 0;
		for (VariableNode variable: vars)
			maxLength = Math.max(maxLength, variable.getFullName().length()); // 4 because we're assume nothing is more than 9999 bytes long
		
		for (VariableNode variable: vars)
		{
			String suffix = null;
				
			if (variable.getTypeName() == null && variable.getType() != null)	// Dummy type
				suffix = ".res " + String.format("%04d", variable.getType().getSize()) + ", $00";
			else
			{
				if (CompUtils.Primitive.isBasic(variable.getTypeName()))
					suffix = ".res " + String.format("%04d", variable.getType().getSize()) + ", $00";
				else if (variable.getTypeName().endsWith("*"))
					suffix = ".res " + String.format("%04d", CompConfig.CompUtils.t_pointer.getSize()) + ", $00";
				else suffix = ".tag " + variable.getType().getFullName();
			}
			String filler = new String(new char[maxLength - variable.getFullName().length()]).replace('\0', ' ');
			assembly += whitespace + variable.getFullName() + ": " + filler + suffix + "\n";
		}
		
		return assembly;
	}
	public static String bytewiseOperation(String whitespace, int nBytes, Function<Integer, String[]> perIteration, String[] finalByte)
	{
		String assembly = "";
		
		if (nBytes >= 2)
		{
			assembly += whitespace + CompUtils.setAXY16 + "\n";
			for (int i = 0; i < nBytes; i += 2)
			{
				for (String opLine : perIteration.apply(i))
					assembly += whitespace + opLine + "\n";
			}
		}
		if (nBytes % 2 == 1)
		{
			assembly += whitespace + CompUtils.setAXY8 + "\n";
			for (String opLine : finalByte)
				assembly += whitespace + opLine + "\n";
		}
		
		return assembly;
	}
	public static String bytewiseOperation(String whitespace, int nBytes, Function<Integer, String[]> perIteration, boolean set16, boolean reverse)
	{
		String assembly = "";
		
		if (nBytes >= 2 && set16) assembly += whitespace + CompUtils.setAXY16 + "\n";
		else if (!set16) assembly += whitespace + CompUtils.setAXY8 + "\n";
		for (int i = 0; i < nBytes; i += (set16? 2 : 1))
		{
			int j = i;
			if (reverse)
				j = (nBytes % 2 == 1) ? nBytes - 1 - i : nBytes - 2 - i;
			for (String opLine : perIteration.apply(j))
				assembly += whitespace + opLine + "\n";
		}
		if (nBytes % 2 == 1 && set16)
		{
			assembly += whitespace + CompUtils.setAXY8 + "\n";
			for (String opLine : perIteration.apply(reverse? 0 : nBytes - 1))
				assembly += whitespace + opLine + "\n";
		}
		
		return assembly;
	}
	public static String bytewiseOperation(String whitespace, int nBytes, Function<Integer, String[]> perIteration)
	{
		return bytewiseOperation(whitespace, nBytes, perIteration, true, false);
	}
	public static String byteCopier(String whitespace, int nBytes, String writeAddr, Function<Integer, String> readSource)
	{
		return bytewiseOperation(whitespace, nBytes, (Integer i) -> 
			{
				return new String[] {
						"LDA\t" + readSource.apply(i),
						"STA\t" + writeAddr + " + " + (nBytes == 1? "" : i)};
			},
			new String[] {
					"LDA\t" + readSource.apply(nBytes - 1),
					"STA\t" + writeAddr + (nBytes == 1? "" : " + " + (nBytes - 1))}
		);
	}
	public static String byteCopierAddr(String whitespace, int nBytes, String writeAddr, String readAddr)
	{
		return byteCopier(whitespace, nBytes, writeAddr, (Integer i) ->
			{
				return readAddr + " + " + i;
			});
	}
	public static OperandSource byteStreamSource(byte[] bytes)
	{
		return new OperandSource((Integer i) ->
		{
			if (i < bytes.length - 1) return "#$" + String.format("%02x%02x", bytes[Math.min(bytes.length - 2, i)], bytes[Math.min(bytes.length - 1, i + 1)]);
			// Only odd if at end
			return "#$" + String.format("%02x", bytes[Math.min(bytes.length - 1, i)]);
		}, bytes.length, true);
	}
	public static OperandSource numericSource(long s, int size)
	{
		byte[] bytes = Arrays.copyOfRange(ByteBuffer.allocate(Long.BYTES).putLong(s).array(), Long.BYTES - size, Long.BYTES);
		// little-endian WRT words
		if (bytes.length >= 4)
			for (int i = 0; i < Math.floor(bytes.length / 2); i += 2)
			{
				byte x = bytes[i];
				byte y = bytes[i + 1];
				bytes[i] = bytes[bytes.length - 2 - i]; bytes[bytes.length - 2 - i] = x;
				bytes[i + 1] = bytes[bytes.length - 1 - i]; bytes[bytes.length - 1 - i] = y;
			}
		return byteStreamSource(bytes);
	}
	public static OperandSource stringSource(String s)
	{
		return byteStreamSource(s.getBytes());
	}
	public static OperandSource addressSource(String s, int size)
	{
		if (size == 1) return new OperandSource((Integer i) -> {return s;}, size, false);
		else return new OperandSource((Integer i) -> {return s + " + " + Math.min(size - 1, i);}, size, false);
	}
	public static OperandSource constantSource(Object constant, int size)
	{
		if (Boolean.class.isAssignableFrom(constant.getClass()))
			return byteStreamSource(new byte[] {(byte) ((Boolean) constant ? 0xFF : 0x00)});
		else if (String.class.isAssignableFrom(constant.getClass()))
			return stringSource((String) constant);
		else if (Number.class.isAssignableFrom(constant.getClass()))
			return numericSource(((Number) constant).longValue(), size);
		else return null;
	}
	public static String byteCopier(String whitespace, String writeAddr, byte[] bytes)
	{
		return byteCopier(whitespace, bytes.length, writeAddr, byteStreamSource(bytes));
	}
	public static String byteCopier(String whitespace, int nBytes, String writeAddr, Object constant)
	{
		Function<Integer, String> source = constantSource(constant, nBytes);
		return byteCopier(whitespace, nBytes, writeAddr, source);
	}
}
