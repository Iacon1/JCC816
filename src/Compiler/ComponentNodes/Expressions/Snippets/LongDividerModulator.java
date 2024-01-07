// Created by Iacon1 on 12/12/2023.
// Software divider / modulator
// https://godbolt.org/z/Y8aM3o8eY
package Compiler.ComponentNodes.Expressions.Snippets;

import Compiler.ComponentNodes.Expressions.AdditiveExpressionNode;
import Compiler.ComponentNodes.Expressions.EqualityExpressionNode;
import Compiler.ComponentNodes.Expressions.RelationalExpressionNode;
import Compiler.ComponentNodes.Expressions.ShiftExpressionNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompUtils;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.OperandSources.ConstantSource;
import Compiler.Utils.OperandSources.OperandSource;
import Compiler.Utils.ScratchManager.ScratchSource;

public class LongDividerModulator
{
	private LongDividerModulator() {}
	
	protected static String divisionHeader(String whitespace, OperandSource sourceX, OperandSource sourceY, DetailsTicket ticket) throws Exception
	{
		String assembly = "";
		
		// First, check negative for X
		assembly += whitespace + CompUtils.setAXY8 + "\n";
		assembly += whitespace + "LDY\t#$00\n";
		assembly += sourceX.getLDA(whitespace, sourceX.getSize() - 1, ticket);
		assembly += whitespace + "BPL\t:+\n";
		// If it was negative we add one to the flag and then make it positive.
		assembly += whitespace + "INY\n";
//		assembly += XOrExpressionNode.getExclOr(whitespace, sourceX, sourceX, new ConstantSource(-1, sourceX.getSize())); // TODO this is wrong, not how you negative it
		
		// Then for Y
		assembly += whitespace + CompUtils.setA8 + "\n";
		assembly += sourceY.getLDA(whitespace, sourceY.getSize() - 1, ticket);
		assembly += whitespace + "BPL\t:+\n";
		// If it was negative we subtract one from the previous flag (making it not zero if it was zero and making it zero if it wasn't)
		// and then make it positive.
		assembly += whitespace + "DEY\n";
//		assembly += XOrExpressionNode.getExclOr(whitespace, sourceY, sourceY, new ConstantSource(-1, sourceY.getSize())); // TODO this is wrong, not how you negative it
		assembly += ":\n";
		
		return assembly;
	}
	protected static String divisionFooter(String whitespace, OperandSource destSource, OperandSource source, DetailsTicket ticket)
	{
		String assembly = "";
		// First, check flag from header
		assembly += whitespace + "TYA\n";
		assembly += whitespace + "BEQ\t:+\n";
		// If it was positive then only one of the operands was negative so the result is negative too.
//		assembly += XOrExpressionNode.getExclOr(whitespace, destSource, source, new ConstantSource(-0, source.getSize())); // TODO this is wrong
		assembly += ":\n";
		
		return assembly;
	}
	
	public static String generate(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, boolean isModulo, DetailsTicket ticket) throws Exception
	{
		ScratchManager scratchManager = new ScratchManager();
		
		String assembly = "";
		assembly += ticket.save(whitespace, DetailsTicket.saveA | DetailsTicket.saveX | DetailsTicket.saveY); // All three modified hereafter
		DetailsTicket innerTicket = new DetailsTicket(ticket, DetailsTicket.saveY, DetailsTicket.saveA); // "Please don't break these"

		assembly += divisionHeader(whitespace, sourceX, sourceY, innerTicket);

		ScratchSource sourceI = scratchManager.reserveScratchBlock(sourceX.getSize());
		ScratchSource sourceT = scratchManager.reserveScratchBlock(2);
		
		ScratchSource sourceB = scratchManager.reserveScratchBlock(sourceX.getSize() + sourceY.getSize());								//[x+y]sized B
		OperandSource sourceN = new ConstantSource(0, sourceX.getSize());
		assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), sourceB, sourceN);											// B = ????...0000
		assembly += AssemblyUtils.byteCopier(whitespace, sourceY.getSize(), sourceB, sourceY); 											// B = Y << [sox]
		
		sourceN = new ConstantSource(1, sourceB.getSize());
		assembly += ShiftExpressionNode.getShift(whitespace, sourceB, scratchManager, sourceB, ">>", sourceN, ticket);					// B = Y << [sox]-1
		
		sourceN = new ConstantSource(0x80 * (int) Math.pow(0x10, sourceX.getSize()), sourceI.getSize());						
		assembly += AssemblyUtils.byteCopier(whitespace, sourceI.getSize(), sourceI, sourceN);											// I = 0x80...0
		
		assembly += "@reiterate:\n";																									// Start of loop
		
		assembly += RelationalExpressionNode.getComparison(whitespace, sourceT, scratchManager, sourceX, ">=", sourceB, innerTicket);	// X >= B?
		assembly += whitespace + "BEQ\t:+\n"; 																							// If not, skip next two.
		
		assembly += AdditiveExpressionNode.getSubtractor(whitespace, sourceX, sourceX, sourceB, ticket); 								// X = X - B
		if (!isModulo) assembly += AdditiveExpressionNode.getAdder(whitespace, destSource, destSource, sourceI, ticket);				// Z += I
		assembly += ":\n";
		sourceN = new ConstantSource(1, sourceY.getSize());
		assembly += ShiftExpressionNode.getShift(whitespace, sourceB, scratchManager, sourceB, ">>", sourceN, ticket);					// B /= 2
		assembly += ShiftExpressionNode.getShift(whitespace, sourceI, scratchManager, sourceI, ">>", sourceN, ticket);					// I /= 2
		assembly += EqualityExpressionNode.getIsZero(whitespace, sourceT, scratchManager, sourceI, ticket);								// I = 0?
		assembly += whitespace + "BEQ\t:+\n"; 																							// If so, end loop
		assembly += whitespace + "JMP\t@reiterate\n";																					// Go back to start of loop
		assembly += whitespace + ":\n";

		scratchManager.releaseScratchBlock(sourceI);
		scratchManager.releaseScratchBlock(sourceT);
		assembly += divisionFooter(whitespace, destSource, isModulo? sourceX : destSource, innerTicket);								// return X if modulo, Z if division

		assembly += divisionFooter(whitespace, destSource, destSource, ticket);
		assembly += ticket.restore(whitespace, DetailsTicket.saveA | DetailsTicket.saveX | DetailsTicket.saveY);
		
		return assembly;
	}
}
