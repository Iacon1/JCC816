// Created by Iacon1 on 11/05/2023.
//
package C99Compiler.Utils.OperandSources;

import C99Compiler.CompConfig;
import C99Compiler.Utils.ProgramState;
import Shared.Assemblable.AssemblyStatePair;

public class NumericAddressSource extends OperandSource
{
	private int address;
	
	public NumericAddressSource(int address, int offset, int size)
	{
		super(size, offset, false);
		this.address = address;
	}
	public NumericAddressSource(int address, int size)
	{
		super(size, false);
		this.address = address;
	}
	
	@Override
	public OperandSource getShifted(int offset, int size)
	{
		return new NumericAddressSource(address, this.offset + offset, this.size + size);
	}
	@Override
	public OperandSource getRespecified(int offset, int size)
	{
		return new NumericAddressSource(address, offset, size);
	}

	@Override
	public AssemblyStatePair getInstruction(ProgramState state, String operation, Integer i)
	{
		if (operation.equals("LDA"))
			state = state.clearKnownFlags(ProgramState.PreserveFlag.A);
		String assembly;
		if (i >= size)
			assembly = state.getWhitespace() + operation + "\t" + CompConfig.signExtend + "\n";
		assembly = state.getWhitespace() + operation + "\t$" + String.format("%06x", address + i + offset) + "\n";
		return new AssemblyStatePair(assembly, state);
	}
	
	@Override
	public String getBase()
	{
		return "\t$" + String.format("%06x", address + offset);
	}
	
	@Override
	public String getSpec()
	{
		return getBase();
	}
}
