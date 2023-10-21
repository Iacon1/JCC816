// By Iacon1
// Created 09/30/2023
//
package Compiler.ComponentNodes.Interfaces;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;

import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.VariableNode;
import Compiler.Utils.CompUtils;

public interface AssemblableNode
{
	// Assembly utils
	public default String applyFiller(String string, int desiredLength)
	{
		String filler = new String(new char[desiredLength - string.length()]).replace('\0', ' ');
		
		return string + filler;
	}
	public default String getWhitespace(int leadingWhitespace) {return new String(new char[leadingWhitespace]).replace('\0', ' ');}
	public default String getVariableBlock(String whitespace, Collection<VariableNode> vars)
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
	public default String bytewiseOperation(String whitespace, int nBytes, Function<Integer, String[]> perBytePair, String[] finalByte)
	{
		String assembly = "";
		
		if (nBytes >= 2)
		{
			assembly += whitespace + CompUtils.setAXY16 + "\n";
			for (int i = 0; i < nBytes; i += 2)
			{
				for (String opLine : perBytePair.apply(i))
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
	public default String bytewiseOperation(String whitespace, int nBytes, Function<Integer, String[]> perIteration)
	{
		String assembly = "";
		
		if (nBytes >= 2) assembly += whitespace + CompUtils.setAXY16 + "\n";
		for (int i = 0; i < nBytes; i += 2)
		{
			for (String opLine : perIteration.apply(i))
				assembly += whitespace + opLine + "\n";
		}
		if (nBytes % 2 == 1)
		{
			assembly += whitespace + CompUtils.setAXY8 + "\n";
			for (String opLine : perIteration.apply(nBytes - 1))
				assembly += whitespace + opLine + "\n";
		}
		
		return assembly;
	}
	public default String byteCopier(String whitespace, int nBytes, String writeAddr, Function<Integer, String> readSource)
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
	public default String byteCopierAddr(String whitespace, int nBytes, String writeAddr, String readAddr)
	{
		return byteCopier(whitespace, nBytes, writeAddr, (Integer i) ->
			{
				return readAddr + " + " + i;
			});
	}
	public default Function<Integer, String> byteStreamSource(byte[] bytes)
	{
		return (Integer i) ->
		{
			if (i < bytes.length - 1) return "#$" + String.format("%02x%02x", bytes[Math.min(bytes.length - 2, i)], bytes[Math.min(bytes.length - 1, i + 1)]);
			// Only odd if at end
			return "#$" + String.format("%02x", bytes[Math.min(bytes.length - 1, i)]);
		};
	}
	public default Function<Integer, String> numericSource(long s, int size)
	{
		byte[] bytes = Arrays.copyOfRange(ByteBuffer.allocate(Long.BYTES).putLong(s).array(), Long.BYTES - size, Long.BYTES);
		// little-endian WRT words
		if (bytes.length >= 4)
			for (int i = 0; i < Math.floor(bytes.length / 2); ++i)
			{
				byte x = bytes[i];
				byte y = bytes[i + 1];
				bytes[i] = bytes[bytes.length - 2 - i]; bytes[bytes.length - 2 - i] = x;
				bytes[i + 1] = bytes[bytes.length - 1 - i]; bytes[bytes.length - 1 - i] = y;
			}
		return byteStreamSource(bytes);
	}
	public default Function<Integer, String> stringSource(String s)
	{
		return byteStreamSource(s.getBytes());
	}
	public default Function<Integer, String> addressSource(String s, int size)
	{
		if (size == 1) return (Integer i) -> {return s;};
		else return (Integer i) -> {return s + " + " + Math.min(size - 1, i);};
	}
	public default Function<Integer, String> constantSource(Object constant, int size)
	{
		if (Boolean.class.isAssignableFrom(constant.getClass()))
			return byteStreamSource(new byte[] {(byte) ((Boolean) constant ? 0xFF : 0x00)});
		else if (String.class.isAssignableFrom(constant.getClass()))
			return stringSource((String) constant);
		else if (Number.class.isAssignableFrom(constant.getClass()))
			return numericSource(((Number) constant).longValue(), size);
		else return null;
	}
	public default String byteCopier(String whitespace, String writeAddr, byte[] bytes)
	{
		return byteCopier(whitespace, bytes.length, writeAddr, byteStreamSource(bytes));
	}
	public default String byteCopier(String whitespace, int nBytes, String writeAddr, Object constant)
	{
		Function<Integer, String> source = constantSource(constant, nBytes);
		return byteCopier(whitespace, nBytes, writeAddr, source);
	}
	
	public boolean canCall(FunctionDefinitionNode function);
	
	public default boolean hasPropValue() {return true;}
	public default boolean hasAssembly() {return !hasPropValue();}
	public default Object getPropValue() {return null;}
	public String getAssembly(int leadingWhitespace) throws Exception;
	public default String getAssembly() throws Exception {return getAssembly(0);}
}
