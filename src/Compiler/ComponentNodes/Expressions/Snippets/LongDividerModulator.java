// Created by Iacon1 on 12/12/2023.
// Software divider / modulator
// https://godbolt.org/z/Y8aM3o8eY
package Compiler.ComponentNodes.Expressions.Snippets;

import Compiler.ComponentNodes.Expressions.AdditiveExpressionNode;
import Compiler.ComponentNodes.Expressions.EqualityExpressionNode;
import Compiler.ComponentNodes.Expressions.RelationalExpressionNode;
import Compiler.ComponentNodes.Expressions.ShiftExpressionNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.OperandSources.ConstantSource;
import Compiler.Utils.OperandSources.OperandSource;
import Compiler.Utils.ScratchManager.ScratchSource;

public class LongDividerModulator extends ShortDividerModulator
{
	private LongDividerModulator() {super();}
	
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
