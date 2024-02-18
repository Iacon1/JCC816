// Created by Iacon1 on 02/18/2024.
// Address source that doesn't actually move
package C99Compiler.Utils.OperandSources;

import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.CompUtils;

public class StationaryAddressSource extends AddressSource
{
	public StationaryAddressSource(String address, int offset, int size)
	{
		super(address, offset, size);
	}
	public StationaryAddressSource(String address, int size)
	{
		super(address, size);
	}
	
	@Override
	public String getLDA(String whitespace, Integer i, DetailsTicket ticket)
	{
		if (ticket.is16Bit())
		{
			
			String assembly = whitespace + CompUtils.setA8 + "\n";
			assembly += getInstruction(whitespace, "LDA", 0, ticket);
			assembly += whitespace + "XBA\n";
			assembly += getInstruction(whitespace, "LDA", 0, ticket);
			assembly += whitespace + "XBA\n";
			assembly += whitespace + CompUtils.setA16 + "\n";
			return assembly;
		}
		else return getInstruction(whitespace, "LDA", 0, ticket);
	}
	
	@Override
	public String getSTA(String whitespace, Integer i, DetailsTicket ticket)
	{
		if (ticket.is16Bit())
		{
			
			String assembly = whitespace + CompUtils.setA8 + "\n";
			assembly += getInstruction(whitespace, "STA", 0, ticket);
			assembly += whitespace + "XBA\n";
			assembly += getInstruction(whitespace, "STA", 0, ticket);
			assembly += whitespace + "XBA\n";
			assembly += whitespace + CompUtils.setA16 + "\n";
			return assembly;
		}
		else return getInstruction(whitespace, "STA", 0, ticket);
	}
}
