// Created by Iacon1 on 10/22/2023.
//
package C99Compiler.Utils;

import java.util.function.BiFunction;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.LValues.LValueNode;import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.OperandSources.OperandSource;
import C99Compiler.Utils.OperandSources.StationaryAddressSource;

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
				j = (nBytes != 1) ? nBytes - 2 - i : 0;
			for (String opLine : perIteration.apply(j, innerTicket))
				for (String subLine : opLine.split("\n"))
						assembly += whitespace + subLine + "\n";
		}
		if (nBytes % 2 == 1 && set16)
		{
			innerTicket.flags &= ~DetailsTicket.isA16Bit;
			innerTicket.flags &= ~DetailsTicket.isXY16Bit;
			assembly += whitespace + CompUtils.setAXY8 + "\n";
			for (String opLine : perIteration.apply(reverse? 0 : nBytes - 1, innerTicket))
				for (String subLine : opLine.split("\n"))
					assembly += whitespace + subLine + "\n";
		}
		assembly += ticket.restore(whitespace, DetailsTicket.saveABit | DetailsTicket.saveXYBit);
		return assembly;
	}
	public static String bytewiseOperation(String whitespace, int nBytes1, int nBytes2, BiFunction<Integer, DetailsTicket, String[]> perIteration, boolean set16, boolean reverse, DetailsTicket ticket)
	{
		String assembly = "";

		DetailsTicket innerTicket = new DetailsTicket(ticket.flags | DetailsTicket.saveABit | DetailsTicket.saveXYBit);
		if (reverse)
		{
			assembly += bytewiseOperation(whitespace, nBytes2, (Integer i, DetailsTicket innerTicket2) -> {return perIteration.apply(i + nBytes1, innerTicket2);}, set16, reverse, innerTicket);
			assembly += bytewiseOperation(whitespace, nBytes1, perIteration, set16, reverse, innerTicket);
		}
		else
		{
			assembly += bytewiseOperation(whitespace, nBytes1, perIteration, set16, reverse, innerTicket);
			assembly += bytewiseOperation(whitespace, nBytes2, (Integer i, DetailsTicket innerTicket2) -> {return perIteration.apply(i + nBytes1, innerTicket2);}, set16, reverse, innerTicket);
		}
		
		assembly += ticket.restore(whitespace, DetailsTicket.saveABit | DetailsTicket.saveXYBit);
		return assembly;
	}
	public static String bytewiseOperation(String whitespace, int nBytes, BiFunction<Integer, DetailsTicket, String[]> perIteration, boolean set16, boolean reverse)
	{
		return bytewiseOperation(whitespace, nBytes, perIteration, set16, reverse, new DetailsTicket());
	}
	public static String bytewiseOperation(String whitespace, int nBytes1, int nBytes2, BiFunction<Integer, DetailsTicket, String[]> perIteration, boolean set16, boolean reverse)
	{
		return bytewiseOperation(whitespace, nBytes1, nBytes2, perIteration, set16, reverse, new DetailsTicket());
	}
	public static String bytewiseOperation(String whitespace, int nBytes, BiFunction<Integer, DetailsTicket, String[]> perIteration, DetailsTicket ticket)
	{
		return bytewiseOperation(whitespace, nBytes, perIteration, true, false, ticket);
	}
	public static String bytewiseOperation(String whitespace, int nBytes1, int nBytes2, BiFunction<Integer, DetailsTicket, String[]> perIteration, DetailsTicket ticket)
	{
		return bytewiseOperation(whitespace, nBytes1, perIteration, true, false, ticket);
	}
	public static String bytewiseOperation(String whitespace, int nBytes, BiFunction<Integer, DetailsTicket, String[]> perIteration)
	{
		return bytewiseOperation(whitespace, nBytes, perIteration, new DetailsTicket());
	}
	public static String bytewiseOperation(String whitespace, int nBytes1, int nBytes2, BiFunction<Integer, DetailsTicket, String[]> perIteration)
	{
		return bytewiseOperation(whitespace, nBytes1, nBytes2, perIteration, new DetailsTicket());
	}
	public static String byteCopier(String whitespace, int nBytes, OperandSource writeSource, OperandSource readSource, DetailsTicket ticket)
	{
		String assembly = "";
		assembly += ticket.save(whitespace, DetailsTicket.saveA);
		boolean force8 = writeSource.isStationary() || readSource.isStationary();
		// If one or both is stationary only do 8-bit
		DetailsTicket innerTicket = new DetailsTicket(ticket, 0, DetailsTicket.saveA);
		assembly += bytewiseOperation(whitespace, Math.min(readSource.getSize(), nBytes), (Integer i, DetailsTicket ticket2) -> 
			{
				return new String[]
						{
						readSource.getLDA(i, ticket2),
						writeSource.getSTA(i, ticket2)
						};
			}, !force8, false, innerTicket);
		if (readSource.getSize() < nBytes)
		{
			assembly += bytewiseOperation(whitespace, nBytes - readSource.getSize(), (Integer i, DetailsTicket ticket2) -> 
			{
				return new String[]
						{
						readSource.getLDA(i + readSource.getSize(), ticket2),
						writeSource.getSTA(i + readSource.getSize(), ticket2)
						};
			}, !force8, false, innerTicket);
		}
		assembly += ticket.restore(whitespace, DetailsTicket.saveA);
		return assembly;
	}
	public static String zeroCopier(String whitespace, int nBytes, OperandSource writeSource, DetailsTicket ticket)
	{
		String assembly = "";
		assembly += ticket.save(whitespace, DetailsTicket.saveA);
		boolean force8 = false;
		// If one or both is stationary only do 8-bit
		DetailsTicket innerTicket = new DetailsTicket(ticket, 0, DetailsTicket.saveA);
		assembly += bytewiseOperation(whitespace, nBytes, (Integer i, DetailsTicket ticket2) -> 
			{
				return new String[]
						{
						"LDA\t" + (ticket2.is16Bit() ? "#$0000" : "#$00"),
						writeSource.getInstruction("STA", i, ticket2)
						};
			}, !force8, false, innerTicket);
		assembly += ticket.restore(whitespace, DetailsTicket.saveA);
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
						readSource.getLDA(i, ticket2),
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
						writeSource.getSTA(i, ticket2),
						};
			}, true, true, innerTicket);
		assembly += ticket.save(whitespace, DetailsTicket.saveA);
		return assembly;
	}
	public static String stackLoader(String whitespace, int nBytes, OperandSource writeSource)
	{
		return stackLoader(whitespace, nBytes, writeSource, new DetailsTicket());
	}
	
	public static OperandSource getShrinkWrapped(LValueNode<?> x)
	{
		if (x.hasPossibleValues())
		{
			Type fittedTypeX = CompUtils.getSmallestType(Math.max(-x.getSmallestPossibleLong(), x.getLargestPossibleLong()));
			if (x.getSize() > fittedTypeX.getSize())
				return x.getSource().getShifted(0, fittedTypeX.getSize() - x.getSize());
		}
		return x.getSource();
	}
	
	public static String setSignExtend(String whitespace, OperandSource x, OperandSource y, boolean signedX, boolean signedY, DetailsTicket ticket)
	{
		String assembly = "";
		if (x.getSize() == y.getSize()) return ""; // Sign extension not needed.
		assembly += whitespace + CompUtils.setA8 + "\n";
		if (x.getSize() < y.getSize() && !x.isLiteral()) // x will need the sign extension.
		{
			if (!signedX)
			{
				assembly += whitespace + "LDA\t#$00\n";
				assembly += whitespace + "STA\t" + CompConfig.signExtend + "\n";
				return assembly;
			}
			assembly += x.getLDA(whitespace, x.getSize() - 1, ticket) + "\n";
		}
		else if (x.getSize() < y.getSize() && x.isLiteral()) // Literals account for this, so not needed.
			return "";
		else if (!y.isLiteral()) // y will need the sign extension.
		{
			if (!signedY)
			{
				assembly += whitespace + "LDA\t#$00\n";
				assembly += whitespace + "STA\t" + CompConfig.signExtend + "\n";
				return assembly;
			}
			assembly += y.getLDA(whitespace, y.getSize() - 1, ticket) + "\n";
		}
		else if (y.isLiteral()) // Literals account for this, so not needed.
			return "";
		
		assembly += whitespace + "BPL\t:+\n";
		assembly += whitespace + "LDA\t#$FF\n";
		assembly += whitespace + "BRA\t:++\n";
		assembly += whitespace + ":\n";
		assembly += whitespace + "LDA\t#$00\n";
		assembly += whitespace + ":\n";
		assembly += whitespace + "STA\t" + CompConfig.signExtend + "\n";
		
		return assembly;		
	}
	
	public static String getCompJump(String whitespace, String jumpTo, String statement, boolean skipOnZero, String jumpAfter, String dbgLine)
	{
		String assembly = "";
		if (CompUtils.estimateLength(statement) <= 127)
			assembly += whitespace + (skipOnZero ? "BEQ\t" : "BNE\t") + jumpTo + "\n";
		else
		{
			assembly += whitespace + (skipOnZero ? "BNE\t" : "BEQ\t") + ":+\n";
			assembly += whitespace + "JMP\t" + jumpTo + "\n";
			assembly += whitespace + ":\n";
		}
		if (dbgLine != null) assembly += dbgLine;
		assembly += statement;
		if (jumpAfter != null)
			assembly += whitespace + "JMP\t" + jumpAfter + "\n";
		assembly += whitespace + jumpTo + ":\n";
		return assembly;
	}
}
