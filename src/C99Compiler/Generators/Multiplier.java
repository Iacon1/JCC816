// Created by Iacon1 on 12/12/2023.
// Uses hardware multiplication registers
/*
 * Suppose a series of N bytes A1, A2, A3, ...
 * M bytes B1, B2, B3, ...
 * And K bytes C1, C2, C3, ...
 * We can calculate Ax * By = Z1Z2
 */
package C99Compiler.Generators;

import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.SNESRegisters;
import C99Compiler.Utils.AssemblyUtils.BytewiseOperator;
import C99Compiler.Utils.AssemblyUtils.EightBitBytewiseOperator;
import C99Compiler.Utils.OperandSources.OperandSource;
import Shared.Assemblable;

//Uses hardware multiplication registers
public class Multiplier implements Assemblable
{
	private static class MultiplierOperator extends EightBitBytewiseOperator
	{
		private final int offset;
		private final OperandSource sourceX, sourceY, destSource;
		
		public MultiplierOperator(int offset, OperandSource destSource, OperandSource sourceX, OperandSource sourceY)
		{
			super(sourceY.getSize(), false);
			this.offset = offset;
			this.destSource = destSource;
			this.sourceX = sourceX;
			this.sourceY = sourceY;
		}

		@Override
		protected AssemblyStatePair getAssemblyAndState(ProgramState state, int i) throws Exception
		{
			MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
			String whitespace = pair.state.getWhitespace();
			
			if (i == 0) // First mult of the set
			{
				sourceX.applyLDA(pair, offset);
				pair.assembly += whitespace + "STA\t" + SNESRegisters.WRMPYA + "\n";
			}
			else
			{
				pair.assembly += whitespace + "LDA\t" + SNESRegisters.RDMPYH + "\n";
				pair.assembly += whitespace + "TAX\n";
			}
			sourceY.applyLDA(pair, offset);
			pair.assembly += whitespace + "STA\t" + SNESRegisters.WRMPYB + "\n";
			if (i == 0) // First mult of the set
			{
				pair.assembly += whitespace + "NOP\n";
				pair.assembly += whitespace + "NOP\n";
				pair.assembly += whitespace + "LDA\tf:" + SNESRegisters.RDMPYL + "\n";
			}
			else // Not first mult of the set
			{
				pair.assembly += whitespace + "NOP\n";
				pair.assembly += whitespace + "TXA\n";
				pair.assembly += whitespace + "ADC\tf:" + SNESRegisters.RDMPYL + "\n";
			}
			if (offset != 0 && i < n - 1) // Not first set and not furthest byte of output
			{
				pair.assembly += whitespace + "CLC\n";
				destSource.applyInstruction(pair, "ADC", offset + i);
			}
			destSource.applySTA(pair, offset + i);
			
			return pair.getImmutable();
		}
	}
	
	private OperandSource sourceX, sourceY;
	
	public Multiplier(OperandSource sourceX, OperandSource sourceY)
	{
		this.sourceX = sourceX;
		this.sourceY = sourceY;
	}

	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception {
		MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);

		OperandSource destSource = pair.state.destSource();
		pair.assembly += pair.state.getWhitespace() + "CLC\n";
		for (int i = 0; i < sourceX.getSize(); ++i)
			new MultiplierOperator(i, destSource, sourceX, sourceY).apply(pair);
		
		// High byte
		pair.assembly += pair.state.getWhitespace() + "LDA\t" + SNESRegisters.RDMPYH + "\n";
		pair.assembly += pair.state.getWhitespace() + "ADC\t#$00\n";
		destSource.applySTA(pair, sourceX.getSize() + sourceY.getSize() - 1);
		
		return pair.getImmutable();
	}

}
