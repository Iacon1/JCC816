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
import C99Compiler.Utils.AssemblyUtils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.ByteCopier;
import C99Compiler.Utils.AssemblyUtils.BytewiseOperator;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.FileIO;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.ScratchSource;
import Shared.Assemblable;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.Dummies.DummyValueNode;

public class LongDividerModulator implements Assemblable
{
	private OperandSource sourceX, sourceY;
	private boolean isModulo;
	
	public LongDividerModulator(OperandSource sourceX, OperandSource sourceY, boolean isModulo)
	{
		this.sourceX = sourceX;
		this.sourceY = sourceY;
		this.isModulo = isModulo;
	}
	
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
		OperandSource destSource = pair.state.destSource();

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

		// uintX_t ret = 0;
		OperandSource ret = destSource.respec(xSize);
		new ByteCopier(xSize, ret, new ConstantSource(0, xSize)).apply(pair);
		
		// uintZ_t big_div = (uintZ_t)y << (X - 1);
		pair.state = pair.state.reserveScratchBlock(zSize);
		ScratchSource bigDiv = pair.state.lastScratchSource();
		new ByteCopier(ySize, bigDiv.getShifted(xSize), sourceY).apply(pair);
		pair.state = pair.state.setDestSource(bigDiv);
		new ShiftExpressionNode(null, ">>",
				new DummyExpressionNode(null, zType, bigDiv),
				new DummyExpressionNode(null, zType, 1)).apply(pair);
		
		//uintX_t i = 0x8...[X bytes]
		pair.state = pair.state.reserveScratchBlock(xSize);
		ScratchSource iS = pair.state.lastScratchSource();
		new ByteCopier(xSize, iS, new ConstantSource(0x80 * (long) Math.pow(0x100, xSize - 1), xSize)).apply(pair);
		
		// For...
		pair.assembly += pair.state.getWhitespace() + LDivIter + ":\n";
			
		// If (x >= big_div)
		new RelationalExpressionNode(null, ">=",
				new DummyExpressionNode(null, xType, sourceX),
				new DummyExpressionNode(null, zType, bigDiv), LDivNSkip, LDivSkip, false).apply(pair);
		pair.assembly += pair.state.getWhitespace() + LDivNSkip + ":\n";
		
		// x -= big_div;
		pair.state = pair.state.setDestSource(sourceX);
		new AdditiveExpressionNode(null, "-",
				new DummyExpressionNode(null, xType, sourceX),
				new DummyExpressionNode(null, zType, bigDiv)).apply(pair);
		
		// ret += i;
		pair.state = pair.state.setDestSource(destSource);
		new AdditiveExpressionNode(null, "+",
				new DummyExpressionNode(null, zType, destSource),
				new DummyExpressionNode(null, xType, iS)).apply(pair);
		
		pair.assembly += pair.state.getWhitespace() + LDivSkip + ":\n";
		
		// big_div >>= 1;
		pair.state = pair.state.setDestSource(bigDiv);
		new ShiftExpressionNode(null, ">>",
				new DummyExpressionNode(null, zType, bigDiv),
				new DummyExpressionNode(null, zType, 1)).apply(pair);
		
		// i >>= 1
		pair.state = pair.state.setDestSource(iS);
		new ShiftExpressionNode(null, ">>",
				new DummyExpressionNode(null, xType, iS),
				new DummyExpressionNode(null, xType, 1)).apply(pair);
		
		// i != 0
		new EqualityExpressionNode(null, new DummyExpressionNode(null, xType, iS)).apply(pair);
		pair.assembly += pair.state.getWhitespace() + "BEQ\t:+\n";
		pair.assembly += pair.state.getWhitespace() + "JMP\t" + LDivIter + "\n";
		pair.assembly += pair.state.getWhitespace() + ":\n";
		
		// [if modulo] ret = x;
		if (isModulo)
			new ByteCopier(xSize, ret, sourceX).apply(pair);
		
		return pair.getImmutable();
	}
}
