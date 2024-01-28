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
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;

public class LongDividerModulator
{
	private LongDividerModulator() {}
	
	public static String generate(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, boolean isModulo, DetailsTicket ticket) throws Exception
	{
		// X = size of x
		int xSize = sourceX.getSize();
		Type xType = CompUtils.getTypeForSize(xSize, false);
		// Y = size of y
		int ySize = sourceY.getSize();
		Type yType = CompUtils.getTypeForSize(ySize, false);
		// Z = X + Y
		int zSize = xSize + ySize;
		Type zType = CompUtils.getTypeForSize(zSize, false);
		
		String LDivIter = "__LU" + (isModulo ? "Mod" : "Div") + xSize + "_U" + ySize + "Iter";
		String LDivSkip = "__LU" + (isModulo ? "Mod" : "Div") + xSize + "_U" + ySize + "Skip";
		String LDivNSkip = "__LU" + (isModulo ? "Mod" : "Div") + xSize + "_U" + ySize + "NSkip";
		
		ScratchManager scratchManager = new ScratchManager();
		scratchManager.reserveScratchBlock(CompConfig.scratchSize - zSize - xSize); // Minimum size needed
		String assembly = "";
		
		assembly += ticket.save(whitespace, DetailsTicket.saveA | DetailsTicket.saveX); // All three modified hereafter
		DetailsTicket innerTicket = new DetailsTicket(ticket, DetailsTicket.saveY, DetailsTicket.saveA); // "Please don't break these"

		// uintX_t ret = 0;
		OperandSource ret = destSource.respec(xSize);
		assembly += AssemblyUtils.byteCopier(whitespace, xSize, ret, new ConstantSource(0, xSize));
		// uintZ_t big_div = (uintZ_t)y << (X - 1);
		ScratchSource bigDiv = scratchManager.reserveScratchBlock(zSize);
		assembly += AssemblyUtils.byteCopier(whitespace, ySize, bigDiv.getShifted(xSize), sourceY);
		assembly += AssemblyUtils.bytewiseOperation(whitespace, zSize, (Integer i, DetailsTicket ticket2) -> 
			{return new String[]
				{
					bigDiv.getLDA(i, ticket2),
					(i >= bigDiv.getSize() - 2) ? "LSR" : "ROR",
					bigDiv.getSTA(i, ticket2),
				};
			}, true, true);
		//uintX_t i = 0x8...[X bytes]
		ScratchSource iS = scratchManager.reserveScratchBlock(xSize);
		assembly += AssemblyUtils.byteCopier(whitespace, xSize, iS, new ConstantSource(0x80 * Math.pow(0x100, xSize - 1), xSize));
		// For...
		assembly += whitespace + LDivIter + ":\n";
			// If (x >= big_div)
			assembly += new RelationalExpressionNode(null, ">=", new DummyExpressionNode(null, xType, sourceX), new DummyExpressionNode(null, zType, bigDiv))
					.getAssembly(whitespace.length(), LDivNSkip, LDivSkip, scratchManager, innerTicket);
			assembly += whitespace + LDivNSkip + ":\n";
				// x -= big_div;
				assembly += whitespace + "SEC" + "\n";
				assembly += AssemblyUtils.bytewiseOperation(whitespace, xSize, (Integer i, DetailsTicket ticket2) -> 
				{return new String[]
					{
						sourceX.getLDA(i, ticket2),
						bigDiv.getInstruction("SBC", i, ticket2),
						sourceX.getSTA(i, ticket2)
					};
				}, true, true, innerTicket);
				// ret += i;
				assembly += whitespace + "CLC" + "\n";
				assembly += AssemblyUtils.bytewiseOperation(whitespace, xSize, (Integer i, DetailsTicket ticket2) -> 
				{return new String[]
					{
						ret.getLDA(i, ticket2),
						iS.getInstruction("ADC", i, ticket2),
						ret.getSTA(i, ticket2)
					};
				}, true, false, innerTicket);
			assembly += whitespace + LDivSkip + ":\n";
			// big_div >>= 1;
			assembly += AssemblyUtils.bytewiseOperation(whitespace, zSize, (Integer i, DetailsTicket ticket2) -> 
			{return new String[]
					{
						bigDiv.getLDA(i, ticket2),
						(i >= bigDiv.getSize() - 2) ? "LSR" : "ROR",
						bigDiv.getSTA(i, ticket2),
					};
				}, true, true);
			// i >>= 1
			assembly += AssemblyUtils.bytewiseOperation(whitespace, xSize, (Integer i, DetailsTicket ticket2) -> 
			{return new String[]
					{
						iS.getLDA(i, ticket2),
						(i >= iS.getSize() - 2) ? "LSR" : "ROR",
						iS.getSTA(i, ticket2),
					};
				}, true, true);
			// i != 0
			assembly += EqualityExpressionNode.getIsZero(whitespace, null, scratchManager, iS, innerTicket);
			assembly += whitespace + "BEQ\t:+\n";
			assembly += whitespace + "JMP\t" + LDivIter + "\n";
			assembly += whitespace + ":\n";
		// [if modulo] ret = x;
		if (isModulo)
			assembly += AssemblyUtils.byteCopier(whitespace, xSize, ret, sourceX, innerTicket);
		
		assembly += ticket.restore(whitespace, DetailsTicket.saveA | DetailsTicket.saveX);
		return assembly;
	}
}
