// Created by Iacon1 on 10/22/2023.
//
package Compiler.Utils;

import java.util.function.BiFunction;

import Compiler.Utils.OperandSources.OperandSource;

public final class AssemblyUtils
{
	
	public static class DetailsTicket
	{
		public static final byte isA16Bit = 0b00000001;	// Assume A starts in 16-bit mode
		public static final byte saveABit = 0b00000010;	// Don't change A's bit mode without restoring it
		public static final byte isXY16Bit = 0b00000100;// Assume XY starts in 16-bit mode
		public static final byte saveXYBit = 0b00001000;// Don't change XY's bit mode without restoring it
		public static final byte saveA = 0b00010000;	// Don't use A without restoring it
		public static final byte saveX = 0b00100000;	// Don't use X without restoring it
		public static final byte saveY = 0b01000000;	// Don't use Y without restoring it
		
		public byte flags;
		
		public DetailsTicket(int flags)
		{
			this.flags = (byte) flags;
		}
		public DetailsTicket(DetailsTicket ticket)
		{
			this.flags = ticket.flags;
		}
		public DetailsTicket(DetailsTicket baseTicket, int add, int remove)
		{
			this.flags = (byte) ((baseTicket.flags | add) & ~remove);
		}
		public DetailsTicket(Boolean is16Bit)
		{
			this.flags = isA16Bit | isXY16Bit;
		}
		public DetailsTicket()
		{
			this.flags = 0;
		}
		public boolean is16Bit()
		{
			return (flags & (isA16Bit | isXY16Bit)) == (isA16Bit | isXY16Bit);
		}
		
		/** Produces assembly that preserves any attribute present in both the ticket and the flags provided.
		 * 
		 * @param whitespace
		 * @param usageFlags
		 * @return
		 */
		public String save(String whitespace, int usageFlags)
		{
			String assembly = "";
			if ((flags & usageFlags & saveA) == saveA) assembly += whitespace + "PHA\n";
			if ((flags & usageFlags & saveX) == saveX) assembly += whitespace + "PHX\n";
			if ((flags & usageFlags & saveY) == saveY) assembly += whitespace + "PHY\n";
			
			return assembly;
		}
		public String restore(String whitespace, int usageFlags)
		{
			String assembly = "";
			if ((flags & (saveABit | isA16Bit | saveXYBit | isXY16Bit)) == (saveABit | isA16Bit | saveXYBit | isXY16Bit))
				assembly += whitespace + CompUtils.setAXY16 + "\n";
			else if ((flags & (saveABit | isA16Bit | saveXYBit | isXY16Bit)) == (saveABit | saveXYBit)) // Both need preserving but were 8 bits
				assembly += whitespace + CompUtils.setAXY8 + "\n";
			else
			{
				if ((flags & (saveABit | isA16Bit)) == (saveABit | isA16Bit))
					assembly += whitespace + CompUtils.setA16 + "\n";
				else if ((flags & saveABit) == saveABit)
					assembly += whitespace + CompUtils.setA8 + "\n";
				
				if ((flags & (saveXYBit | isXY16Bit)) == (saveXYBit | isXY16Bit))
					assembly += whitespace + CompUtils.setXY16 + "\n";
				else if ((flags & saveXYBit) == saveXYBit)
					assembly += whitespace + CompUtils.setXY8 + "\n";
			}
			if ((flags & usageFlags & saveA) == saveA) assembly += whitespace + "PLA\n";
			if ((flags & usageFlags & saveX) == saveX) assembly += whitespace + "PLX\n";
			if ((flags & usageFlags & saveY) == saveY) assembly += whitespace + "PLY\n";
			
			return assembly;
		}
	}
	
	public static String applyFiller(String string, int desiredLength)
	{
		String filler = new String(new char[desiredLength - string.length()]).replace('\0', ' ');
		
		return string + filler;
	}
	public static String getWhitespace(int leadingWhitespace) {return new String(new char[leadingWhitespace]).replace('\0', ' ');}
	public static String bytewiseOperation(String whitespace, int nBytes, BiFunction<Integer, DetailsTicket, String[]> perIteration, boolean set16, boolean reverse, DetailsTicket ticket)
	{
		String assembly = "";

		DetailsTicket innerTicket = new DetailsTicket(ticket.flags | DetailsTicket.saveABit | DetailsTicket.saveXYBit);
		if (nBytes >= 2 && set16) assembly += whitespace + CompUtils.setAXY16 + "\n";
		else if (!set16) assembly += whitespace + CompUtils.setAXY8 + "\n";
		for (int i = 0; i < nBytes - (set16 ? 1 : 0); i += (set16? 2 : 1))
		{
			if (set16)
			{
				innerTicket.flags |= DetailsTicket.isA16Bit;
				innerTicket.flags |= DetailsTicket.isXY16Bit;
			}
			else
			{
				innerTicket.flags &= ~DetailsTicket.isA16Bit;
				innerTicket.flags &= ~DetailsTicket.isXY16Bit;
			}
			int j = i;
			if (reverse)
				j = (nBytes % 2 == 1) ? nBytes - 1 - i : nBytes - 2 - i;
			for (String opLine : perIteration.apply(j, innerTicket))
				assembly += whitespace + opLine + "\n";
		}
		if (nBytes % 2 == 1 && set16)
		{
			innerTicket.flags &= ~DetailsTicket.isA16Bit;
			innerTicket.flags &= ~DetailsTicket.isXY16Bit;
			assembly += whitespace + CompUtils.setAXY8 + "\n";
			for (String opLine : perIteration.apply(reverse? 0 : nBytes - 1, innerTicket))
				assembly += whitespace + opLine + "\n";
		}
		assembly += ticket.restore(whitespace, DetailsTicket.saveABit | DetailsTicket.saveXYBit);
		return assembly;
	}
	public static String bytewiseOperation(String whitespace, int nBytes, BiFunction<Integer, DetailsTicket, String[]> perIteration, boolean set16, boolean reverse)
	{
		return bytewiseOperation(whitespace, nBytes, perIteration, set16, reverse, new DetailsTicket());
	}
	public static String bytewiseOperation(String whitespace, int nBytes, BiFunction<Integer, DetailsTicket, String[]> perIteration, DetailsTicket ticket)
	{
		return bytewiseOperation(whitespace, nBytes, perIteration, true, false, ticket);
	}
	public static String bytewiseOperation(String whitespace, int nBytes, BiFunction<Integer, DetailsTicket, String[]> perIteration)
	{
		return bytewiseOperation(whitespace, nBytes, perIteration, new DetailsTicket());
	}
	public static String byteCopier(String whitespace, int nBytes, OperandSource writeSource, OperandSource readSource, DetailsTicket ticket)
	{
		String assembly = "";
		assembly += ticket.save(whitespace, DetailsTicket.saveA);
		DetailsTicket innerTicket = new DetailsTicket(ticket, 0, DetailsTicket.saveA);
		assembly += bytewiseOperation(whitespace, nBytes, (Integer i, DetailsTicket ticket2) -> 
			{
				return new String[]
						{
						readSource.prefaceAssembly(whitespace, i, ticket2),
						"LDA\t" + readSource.apply(i, ticket2),
						writeSource.prefaceAssembly(whitespace, i, ticket2),
						"STA\t" + writeSource.apply(i, ticket2),
						};
			}, innerTicket);
		assembly += ticket.save(whitespace, DetailsTicket.saveA);
		return assembly;
	}
	public static String byteCopier(String whitespace, int nBytes, OperandSource writeSource, OperandSource readSource)
	{
		return byteCopier(whitespace, nBytes, writeSource, readSource, new DetailsTicket());
	}
	public static String stackPusher(String whitespace, int nBytes, OperandSource readSource, DetailsTicket ticket)
	{
		String assembly = "";
		assembly += ticket.save(whitespace, DetailsTicket.saveA);
		DetailsTicket innerTicket = new DetailsTicket(ticket, 0, DetailsTicket.saveA);
		assembly += bytewiseOperation(whitespace, nBytes, (Integer i, DetailsTicket ticket2) -> 
			{
				return new String[]
						{
						readSource.prefaceAssembly(whitespace, i, ticket2),
						"LDA\t" + readSource.apply(i, ticket2),
						"PHA"
						};
			}, true, false, innerTicket);
		assembly += ticket.save(whitespace, DetailsTicket.saveA);
		return assembly;
	}
	public static String stackPusher(String whitespace, int nBytes, OperandSource readSource)
	{
		return stackPusher(whitespace, nBytes, readSource, new DetailsTicket());
	}
	public static String stackLoader(String whitespace, int nBytes, OperandSource writeSource, DetailsTicket ticket)
	{
		String assembly = "";
		assembly += ticket.save(whitespace, DetailsTicket.saveA);
		DetailsTicket innerTicket = new DetailsTicket(ticket, 0, DetailsTicket.saveA);
		assembly += bytewiseOperation(whitespace, nBytes, (Integer i, DetailsTicket ticket2) -> 
			{
				return new String[]
						{
						"PLA",
						writeSource.prefaceAssembly(whitespace, i, ticket2),
						"STA\t" + writeSource.apply(i, ticket2),
						};
			}, true, true, innerTicket);
		assembly += ticket.save(whitespace, DetailsTicket.saveA);
		return assembly;
	}
	public static String stackLoader(String whitespace, int nBytes, OperandSource writeSource)
	{
		return stackLoader(whitespace, nBytes, writeSource, new DetailsTicket());
	}
}
