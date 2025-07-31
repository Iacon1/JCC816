// Created by Iacon1 on 12/12/2023.
//
package C99Compiler.Generators;

import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.ProcessorFlag;
import Shared.Assemblable;
import C99Compiler.Utils.SNESRegisters;
import C99Compiler.Utils.AssemblyUtils.BytewiseOperator;
import C99Compiler.Utils.AssemblyUtils.EightBitBytewiseOperator;
import C99Compiler.Utils.AssemblyUtils.ZeroCopier;
import C99Compiler.Utils.OperandSources.OperandSource;

//Uses hardware div registers, but only for 8-bit divisor
public class ShortDividerModulator implements Assemblable
{
	private static class ShortDividerModulatorOperator extends EightBitBytewiseOperator
	{
		private final OperandSource sourceX, sourceY, destSource;
		SNESRegisters RRegL;
		SNESRegisters RRegH;
		
		ShortDividerModulatorOperator(OperandSource destSource, OperandSource sourceX, OperandSource sourceY, boolean isModulo)
		{
			super(sourceX.getSize(), true);
			this.sourceX = sourceX;
			this.sourceY = sourceY;
			this.destSource = destSource;
			
			if (isModulo)
			{
				RRegL = SNESRegisters.RDMPYL;
				RRegH = SNESRegisters.RDMPYH;
			}
			else
			{
				RRegL = SNESRegisters.RDDIVL;
				RRegH = SNESRegisters.RDDIVH;
			}
		}
		@Override
		protected AssemblyStatePair getAssemblyAndState(ProgramState state, int i) throws Exception
		{
			MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
			if (i == 0 && n > 1) return pair.getImmutable(); // Last byte done by second-to-last op
			
			pair = sourceX.applyLDA(pair, i - 1);
			pair.assembly += pair.state.getWhitespace() + "STA\t" + SNESRegisters.WRDIVL + "\n";
			if (n > 1)
			{
				pair = sourceX.applyLDA(pair, i);
				pair.assembly += pair.state.getWhitespace() + "STA\t" + SNESRegisters.WRDIVH + "\n";
			}
			else
				pair.assembly += pair.state.getWhitespace() + "STZ\t" + SNESRegisters.WRDIVH + "\n";
			pair = sourceY.applyLDA(pair, 0);
			pair.assembly += pair.state.getWhitespace() + "STA\t" + SNESRegisters.WRDIVB + "\n";
		
			pair.assembly += pair.state.getWhitespace() + "NOP\n"; // 2 cycles
			pair.assembly += pair.state.getWhitespace() + "NOP\n"; // 4 cycles
			pair.assembly += pair.state.getWhitespace() + "NOP\n"; // 6 cycles
			pair.assembly += pair.state.getWhitespace() + "NOP\n"; // 8 cycles
			pair.assembly += pair.state.getWhitespace() + "NOP\n"; // 10 cycles
			pair.assembly += pair.state.getWhitespace() + "NOP\n"; // 12 cycles
			pair.assembly += pair.state.getWhitespace() + "NOP\n"; // 14 cycles

			if (RRegL == SNESRegisters.RDDIVL) // Division
			{
				pair.assembly += pair.state.getWhitespace() + "REP\t#$21\n";
				pair = destSource.applyLDA(pair, i - 1);
				pair.assembly += pair.state.getWhitespace() + "ADC\t" + RRegL + "\n";
				pair = destSource.applySTA(pair, i - 1);
				int j;
				for (j = i + 1; j < n - 1; j += 2) // Carry forward
				{
					pair = destSource.applyLDA(pair, j);
					pair.assembly += pair.state.getWhitespace() + "ADC\t#$0000\n";
					pair = destSource.applySTA(pair, i);
				}
				pair.assembly += pair.state.getWhitespace() + "SEP\t#$20\n";
				if (j == n - 1) // Odd
				{
					pair = destSource.applyLDA(pair, j);
					pair.assembly += pair.state.getWhitespace() + "ADC\t#$00\n";
					pair = destSource.applySTA(pair, i);
				}
			}
			else // Modulation
			{
				pair.assembly += pair.state.getWhitespace() + "REP\t#$20\n";
				pair.assembly += pair.state.getWhitespace() + "LDA\t" + RRegL + "\n";
				pair = destSource.applySTA(pair, i);
				pair.assembly += pair.state.getWhitespace() + "SEP\t#$20\n";
			}

			if (i > 1) // Not last operation, replace segment of X with mod
			{
				pair.assembly += pair.state.getWhitespace() + "LDA\t" + SNESRegisters.RDMPYL + "\n";
				pair = sourceX.applySTA(pair, i - 1);
				pair.assembly += pair.state.getWhitespace() + "LDA\t" + SNESRegisters.RDMPYH + "\n";
				pair = sourceX.applySTA(pair, i);
			}
			return pair.getImmutable();
		}	
	}
	private OperandSource sourceX, sourceY;
	private boolean isModulo;
	public ShortDividerModulator(OperandSource sourceX, OperandSource sourceY, boolean isModulo)
	{
		this.sourceX = sourceX;
		this.sourceY = sourceY;
		this.isModulo = isModulo;
	}
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		OperandSource destSource = state.destSource();
		AssemblyStatePair pair = new ZeroCopier(destSource.getSize(), destSource).getAssemblyAndState(state);
		pair = new ShortDividerModulatorOperator(destSource, sourceX, sourceY, isModulo).apply(pair);
		return pair;
	}

}
