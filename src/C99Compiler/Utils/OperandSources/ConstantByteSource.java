// Created by Iacon1 on 11/05/2023.
//
package C99Compiler.Utils.OperandSources;

import C99Compiler.Utils.ProgramState;
import Shared.Assemblable.AssemblyStatePair;

public class ConstantByteSource extends OperandSource
{
	private int[] bytes; // Not really bytes, I know

	public ConstantByteSource(int[] source, int offset, int size)
	{
		super(size, offset, true);
		bytes = source;
	}
	public ConstantByteSource(int[] source, int size)
	{
		super(size, true);
		bytes = source;
	}
	@Override
	public OperandSource getShifted(int offset, int size)
	{
		return new ConstantByteSource(bytes, this.offset + offset, this.size + size);
	}
	@Override
	public OperandSource getRespecified(int offset, int size)
	{
		return new ConstantByteSource(bytes, offset, size);
	}
	
	public int getBaseValue(ProgramState state, int i)
	{
		int signExtend = (bytes[bytes.length - 1] & 0x80) != 0 ? 0xFF : 0x00;
		if (bytes.length <= i) return signExtend * (state.testProcessorFlag(ProgramState.ProcessorFlag.M) ? 0x0101 : 0x01);
		if (state.testProcessorFlag(ProgramState.ProcessorFlag.M))
		{
			if (bytes.length - 1 == i) return signExtend * 0x100 + bytes[i];
			else return bytes[i + 1] * 0x100 + bytes[i];
		}
		else return bytes[i];
	}
	public String getBase(ProgramState state, int i)
	{
		if (state.testProcessorFlag(ProgramState.ProcessorFlag.M))
			return "#$" + String.format("%04x", getBaseValue(state, i));
		else
			return "#$" + String.format("%02x", getBaseValue(state, i));
	}
	@Override
	public String getBase()
	{
		return getBase(new ProgramState(), 0);
	}
	
	@Override
	public AssemblyStatePair getInstruction(ProgramState state, String operation, Integer i)
	{
		if (operation.equals("LDA"))
		{
			int baseValue = getBaseValue(state, i);
			if (state.testKnownFlag(ProgramState.PreserveFlag.A) && state.getA() == baseValue)
				return new AssemblyStatePair("", state);
			else
				state = state.fixAReg(baseValue);
		}
		String assembly = state.getWhitespace() + operation + "\t" + getBase(state, i) + "\n";
		return new AssemblyStatePair(assembly, state);
	}
	
	@Override
	public String getSpec()
	{
		String s = "#$";
		for (int b : bytes) s += String.format("%02x", b);
		return s;
	}
}
