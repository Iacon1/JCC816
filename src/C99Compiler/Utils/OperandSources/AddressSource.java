// Created by Iacon1 on 11/05/2023.
//
package C99Compiler.Utils.OperandSources;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.Interfaces.Assemblable.AssemblyStatePair;
import C99Compiler.Utils.ProgramState;

public class AddressSource extends OperandSource
{
	private String address;
	
	public AddressSource(String address, int offset, int size)
	{
		super(size, offset, false);
		this.address = address;
	}
	public AddressSource(String address, int size)
	{
		super(size, false);
		this.address = address;
	}
	
	@Override
	public OperandSource getShifted(int offset, int size)
	{
		return new AddressSource(address, this.offset + offset, this.size + size);
	}
	@Override
	public OperandSource getRespecified(int offset, int size)
	{
		return new AddressSource(address, offset, size);
	}
	
	@Override
	public AssemblyStatePair getInstruction(ProgramState state, String operation, Integer i)
	{
		String assembly = "";
		if (operation.equals("LDA"))
			state = state.clearKnownFlags(ProgramState.PreserveFlag.A);
		if (i >= size)
			assembly = state.getWhitespace() + operation + "\t" + CompConfig.signExtend + "\n";
		else if (CompConfig.wordAddresses)
			assembly = state.getWhitespace() + operation + "\t.loWord(" + address + ") + " + (i + offset) + "\n";
		else
			assembly = state.getWhitespace() + operation + "\t" + address + " + " + (i + offset) + "\n";
		
		return new AssemblyStatePair(assembly, state);
	}
	
	@Override
	public String getBase()
	{
		return address + (offset != 0? " + " + offset : "");
	}
}
