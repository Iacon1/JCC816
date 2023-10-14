// By Iacon1
// Created 09/30/2023
//
package Compiler.ComponentNodes.Interfaces;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;

import Compiler.CompConfig;
import Compiler.ComponentNodes.FunctionNode;
import Compiler.ComponentNodes.VarDeclarationNode;

public interface AssemblableNode
{
	// Assembly utils
	public default String getWhitespace(int leadingWhitespace) {return new String(new char[leadingWhitespace]).replace('\0', ' ');}
	public default String getVariableBlock(String whitespace, Collection<VarDeclarationNode> varDecls)
	{
		String assembly = "";
		int maxLength = 0;
		for (VarDeclarationNode declaration: varDecls)
			maxLength = Math.max(maxLength, declaration.getFullName().length()); // 4 because we're assume nothing is more than 9999 bytes long
		
		for (VarDeclarationNode declaration: varDecls)
		{
			String suffix = null;
				
			if (declaration.getTypeName() == null && declaration.getType() != null)	// Dummy type
				suffix = ".res " + String.format("%04d", declaration.getType().getSize()) + ", $00";
			else
			{
				if (CompConfig.Primitive.isBasic(declaration.getTypeName()))
					suffix = ".res " + String.format("%04d", declaration.getType().getSize()) + ", $00";
				else if (declaration.getTypeName().endsWith("*"))
					suffix = ".res " + String.format("%04d", CompConfig.Primitive.t_pointer.getSize()) + ", $00";
				else suffix = ".tag " + declaration.getType().getFullName();
			}
			String filler = new String(new char[maxLength - declaration.getFullName().length()]).replace('\0', ' ');
			assembly += whitespace + declaration.getFullName() + ": " + filler + suffix + "\n";
		}
		
		return assembly;
	}
	public default String bytewiseOperation(String whitespace, int nBytes, Function<Integer, String[]> perBytePair, String[] finalByte)
	{
		String assembly = "";
		
		if (nBytes >= 2)
		{
			assembly += whitespace + CompConfig.setAXY16 + "\n";
			for (int i = 0; i < nBytes; i += 2)
			{
				for (String opLine : perBytePair.apply(i))
					assembly += whitespace + opLine + "\n";
			}
		}
		if (nBytes % 2 == 1)
		{
			assembly += whitespace + CompConfig.setAXY8 + "\n";
			for (String opLine : finalByte)
				assembly += whitespace + opLine + "\n";
		}
		
		return assembly;
	}
	public default String bytewiseOperation(String whitespace, int nBytes, Function<Integer, String[]> perIteration)
	{
		String assembly = "";
		
		if (nBytes >= 2) assembly += whitespace + CompConfig.setAXY16 + "\n";
		for (int i = 0; i < nBytes; i += 2)
		{
			for (String opLine : perIteration.apply(i))
				assembly += whitespace + opLine + "\n";
		}
		if (nBytes % 2 == 1)
		{
			assembly += whitespace + CompConfig.setAXY8 + "\n";
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
	public default String byteCopier(String whitespace, int nBytes, String writeAddr, String readAddr)
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
	public default String byteCopier(String whitespace, String writeAddr, byte[] bytes)
	{
		return byteCopier(whitespace, bytes.length, writeAddr, byteStreamSource(bytes));
	}
	public default String byteCopier(String whitespace, String writeAddr, int x)
	{
		return byteCopier(whitespace, CompConfig.Primitive.t_int.getSize(), writeAddr, numericSource(x, CompConfig.Primitive.t_int.getSize()));
	}
	public default String byteCopier(String whitespace, String writeAddr, String x)
	{
		return byteCopier(whitespace, CompConfig.Primitive.t_int.getSize(), writeAddr, stringSource(x));
	}
	public default String byteCopier(String whitespace, String writeAddr, char x)
	{
		return byteCopier(whitespace, CompConfig.Primitive.t_int.getSize(), writeAddr, byteStreamSource(new byte[] {(byte) x}));
	}
	public default String byteCopier(String whitespace, String writeAddr, boolean x)
	{
		return byteCopier(whitespace, CompConfig.Primitive.t_int.getSize(), writeAddr, byteStreamSource(new byte[] {(byte) (x ? 0xFF : 0x00)}));
	}
	
	public boolean canCall(FunctionNode function);
	
	public default boolean hasPropValue() {return true;}
	public default Object getPropagatedValue() {return null;}
	public String getAssembly(int leadingWhitespace) throws Exception;
	public default String getAssembly() throws Exception {return getAssembly(0);}
}
