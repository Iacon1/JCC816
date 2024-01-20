// Created by Iacon1 on 12/12/2023.
// Software divider / modulator
// https://godbolt.org/z/Y8aM3o8eY
package C99Compiler.CompilerNodes.Expressions.Snippets;

import C99Compiler.CompConfig;
import C99Compiler.C99Compiler;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Expressions.AdditiveExpressionNode;
import C99Compiler.CompilerNodes.Expressions.EqualityExpressionNode;
import C99Compiler.CompilerNodes.Expressions.RelationalExpressionNode;
import C99Compiler.CompilerNodes.Expressions.ShiftExpressionNode;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.FileIO;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import C99Compiler.Utils.ScratchManager.ScratchSource;

public class LongDividerModulator
{
	private LongDividerModulator() {}
	
	public static String generate(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, boolean isModulo, DetailsTicket ticket) throws Exception
	{
		ScratchManager scratchManager = new ScratchManager();
		
		String assembly = "";
		assembly += ticket.save(whitespace, DetailsTicket.saveA | DetailsTicket.saveX | DetailsTicket.saveY); // All three modified hereafter
		DetailsTicket innerTicket = new DetailsTicket(ticket, DetailsTicket.saveY, DetailsTicket.saveA); // "Please don't break these"

		int size = Math.max(sourceX.getSize(), sourceY.getSize());
		Type t1 = CompUtils.getTypeForSize(size);
		Type t2 = CompUtils.getTypeForSize(2 * size);
		
		ScratchSource sourceI = scratchManager.reserveScratchBlock(t1.getSize());
		ScratchSource sourceB = scratchManager.reserveScratchBlock(t2.getSize());	

		String source = FileIO.readResource("Compiler/CompilerNodes/Expressions/Snippets/LongDivider.c");
		assembly += C99Compiler.compileSnippet(whitespace.length(), source, t1.getSignature(),
				t2.getSignature(),
				String.valueOf(8*size - 1),
				"0x8" + "0".repeat(4 * size - 1));

		scratchManager.releaseScratchBlock(sourceI);
		scratchManager.releaseScratchBlock(sourceB);

		assembly += ticket.restore(whitespace, DetailsTicket.saveA | DetailsTicket.saveX | DetailsTicket.saveY);
		
		return assembly;
	}
}
