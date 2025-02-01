// Created by Iacon1 on 12/12/2023.
//
package C99Compiler.CompilerNodes.Expressions.Snippets;

import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.OperandSources.OperandSource;
import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.Expressions.UnaryExpressionNode;
import C99Compiler.CompilerNodes.Interfaces.Assemblable;
import C99Compiler.CompilerNodes.Interfaces.Assemblable.AssemblyStatePair;
import C99Compiler.CompilerNodes.Interfaces.Assemblable.MutableAssemblyStatePair;

//Uses hardware div registers, but only for 8-bit divisor
public class DivisionMultiplicationHeader implements Assemblable
{
	private OperandSource sourceX, sourceY;
	
	public DivisionMultiplicationHeader(OperandSource sourceX, OperandSource sourceY)
	{
		this.sourceX = sourceX;
		this.sourceY = sourceY;
	}
	
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
		Type xType = CompUtils.getTypeForSize(sourceX.getSize(), true);
		Type yType = CompUtils.getTypeForSize(sourceY.getSize(), true);
		
		if (sourceX.getSize() != sourceY.getSize()) // Will we need sign extend?
			pair.assembly += pair.state.getWhitespace() + "STZ\t" + CompConfig.signExtend + "\n";		
		
		// First, check negative for X
		pair.assembly += pair.state.getWhitespace() + CompUtils.setAXY8 + "\n";
		pair.assembly += pair.state.getWhitespace() + "LDY\t#$00\n";
		sourceX.applyLDA(pair, sourceX.getSize() - 1);
		String label1 = "__L1_" + sourceX.getSize() + "_" + sourceY.getSize() + "_header";
		pair.assembly += pair.state.getWhitespace() + "BPL\t" + label1 + "\n";
		
		// If it was negative we add one to the flag and then make it positive.
		pair.assembly += pair.state.getWhitespace() + "INY\n";
		pair.state = pair.state.setDestSource(sourceX);
		new UnaryExpressionNode(null, "-", new DummyExpressionNode(null, xType, sourceX)).apply(pair);
		
		// If x is smaller than y we also set sign extend to 0xFF
		if (sourceX.getSize() < sourceY.getSize())
		{
			pair.assembly += pair.state.getWhitespace() + "LDA\t#$FF\n";
			pair.assembly += pair.state.getWhitespace() + "STA\t" + CompConfig.signExtend + "\n";
		}
		pair.assembly += pair.state.getWhitespace() + label1 + ":" + "\n";
		
		// Then for Y
		pair.assembly += pair.state.getWhitespace() + CompUtils.setA8 + "\n";
		sourceY.applyLDA(pair, sourceY.getSize() - 1);
		String label2 = "__L2_" + sourceX.getSize() + "_" + sourceY.getSize() + "_header";
		pair.assembly += pair.state.getWhitespace() + "BPL\t" + label2 + "\n";
		
		// If it was negative we subtract one from the previous flag (making it not zero if it was zero and making it zero if it wasn't)
		// and then make it positive.
		pair.assembly += pair.state.getWhitespace() + "DEY\n";
		pair.state = pair.state.setDestSource(sourceY);
		new UnaryExpressionNode(null, "-", new DummyExpressionNode(null, yType, sourceY)).apply(pair);
		
		// If y is smaller than x we also set sign extend to 0xFF
		if (sourceY.getSize() < sourceX.getSize())
		{
			pair.assembly += pair.state.getWhitespace() + "LDA\t#$FF\n";
			pair.assembly += pair.state.getWhitespace() + "STA\t" + CompConfig.signExtend + "\n";
		}
		pair.assembly += label2 + ":\n";
		
		return pair.getImmutable();
	}
}
