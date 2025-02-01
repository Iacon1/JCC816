// Created by Iacon1 on 12/12/2023.
//
package C99Compiler.CompilerNodes.Expressions.Snippets;

import C99Compiler.CompilerNodes.Interfaces.Assemblable;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.SNESRegisters;
import C99Compiler.Utils.AssemblyUtils.BytewiseOperator;
import C99Compiler.Utils.OperandSources.OperandSource;

//Uses hardware div registers, but only for 8-bit divisor
public class Multiplier implements Assemblable
{
	private static class MultiplierOperator extends BytewiseOperator
	{
		private final int offset;
		private final OperandSource sourceX, sourceY, destSource;
		
		public MultiplierOperator(int offset, OperandSource destSource, OperandSource sourceX, OperandSource sourceY)
		{
			super(sourceX.getSize() - 1, sourceX.getSize() - 1, false);
			this.offset = offset;
			this.destSource = destSource;
			this.sourceX = sourceX;
			this.sourceY = sourceY;
		}

		@Override
		protected AssemblyStatePair getAssemblyAndState(ProgramState state, int i) throws Exception
		{
			AssemblyStatePair tmpPair;
			String assembly = "";
			if (i != 0)
			{
				if (offset != 0)
				{
					assembly += state.getWhitespace() + "LDA\t" + SNESRegisters.RDMPYH + "\n";	// Load previous high byte as carryover
					assembly += state.getWhitespace() + "TAX\n";								// Store in X
					tmpPair = sourceX.getLDA(state, offset);									// Load X-the-variable
					assembly += tmpPair.assembly;
					state = tmpPair.state;
					assembly += state.getWhitespace() + "STA\t" + SNESRegisters.WRMPYA + "\n";	// Place in reg
					tmpPair = sourceY.getLDA(state, offset + i);								// Load Y-the-variable
					assembly += tmpPair.assembly;
					state = tmpPair.state;
					assembly += state.getWhitespace() + "STA\t" + SNESRegisters.WRMPYB + "\n";	// Place in reg, begin 8-cycle calc
					assembly += state.getWhitespace() + "TXA\n";								// 2 cycles - 2
					tmpPair = destSource.getLDA(state, offset + i);								// >=5 cycles - 7, add previous value of result
					assembly += tmpPair.assembly;
					state = tmpPair.state;
					assembly += state.getWhitespace() + "ADC\t" + SNESRegisters.RDMPYL + "\n";	// 5 cycles - 12, get result and add carryover
					tmpPair = destSource.getSTA(state, offset + i); 							// Store result
					assembly += tmpPair.assembly;
					state = tmpPair.state;
				}
				else
				{
					assembly += state.getWhitespace() + "LDA\t" + SNESRegisters.RDMPYH + "\n";	// Load previous high byte as carryover
					assembly += state.getWhitespace() + "TAX\n";								// Store in X
					tmpPair = sourceX.getLDA(state, offset);									// Load X-the-variable
					assembly += tmpPair.assembly;
					state = tmpPair.state;
					assembly += state.getWhitespace() + "STA\t" + SNESRegisters.WRMPYA + "\n";	// Place in reg
					tmpPair = sourceY.getLDA(state, offset + i);								// Load Y-the-variable
					assembly += tmpPair.assembly;
					state = tmpPair.state;
					assembly += state.getWhitespace() + "STA\t" + SNESRegisters.WRMPYB + "\n";	// Place in reg, begin 8-cycle calc
					assembly += state.getWhitespace() + "TXA\n";								// 2 cycles - 2
					assembly += state.getWhitespace() + "NOP\n";								// 2 cycles - 4
					assembly += state.getWhitespace() + "LDA\t" + SNESRegisters.RDMPYL + "\n";	// 5 cycles - 9, get result and add carryover
					tmpPair = destSource.getSTA(state, offset + i);								// Store result
					assembly += tmpPair.assembly;
					state = tmpPair.state;
				}
			}
			else
			{
				if (offset != 0)
				{
					assembly += state.getWhitespace() + "LDA\t" + SNESRegisters.RDMPYH + "\n";	// Load previous high byte as carryover
					tmpPair = sourceX.getLDA(state, offset);									// Load X-the-variable
					assembly += tmpPair.assembly;
					state = tmpPair.state;
					assembly += state.getWhitespace() + "STA\t" + SNESRegisters.WRMPYA + "\n";	// Place in reg
					tmpPair = sourceY.getLDA(state, offset + i);								// Load Y-the-variable
					assembly += tmpPair.assembly;
					state = tmpPair.state;
					assembly += state.getWhitespace() + "STA\t" + SNESRegisters.WRMPYB + "\n";	// Place in reg, begin 8-cycle calc
					assembly += state.getWhitespace() + "CLC\n";								// 2 cycles - 2
					tmpPair = destSource.getLDA(state, offset + i);								// >=5 cycles - 7, add previous value of result
					assembly += tmpPair.assembly;
					state = tmpPair.state;
					assembly += state.getWhitespace() + "ADC\t" + SNESRegisters.RDMPYL + "\n";	// 5 cycles - 12, get result and add carryover
					tmpPair = destSource.getSTA(state, offset + i); 							// Store result
					assembly += tmpPair.assembly;
					state = tmpPair.state;
				}
				else
				{
					assembly += state.getWhitespace() + "LDA\t" + SNESRegisters.RDMPYH + "\n";	// Load previous high byte as carryover
					tmpPair = sourceX.getLDA(state, offset);									// Load X-the-variable
					assembly += tmpPair.assembly;
					state = tmpPair.state;
					assembly += state.getWhitespace() + "STA\t" + SNESRegisters.WRMPYA + "\n";	// Place in reg
					tmpPair = sourceY.getLDA(state, offset + i);								// Load Y-the-variable
					assembly += tmpPair.assembly;
					state = tmpPair.state;
					assembly += state.getWhitespace() + "STA\t" + SNESRegisters.WRMPYB + "\n";	// Place in reg, begin 8-cycle calc
					assembly += state.getWhitespace() + "NOP\n";								// 2 cycles - 2
					assembly += state.getWhitespace() + "NOP\n";								// 2 cycles - 4
					assembly += state.getWhitespace() + "LDA\t" + SNESRegisters.RDMPYL + "\n";	// 5 cycles - 9, get result and add carryover
					tmpPair = destSource.getSTA(state, offset + i); 							// Store result
					assembly += tmpPair.assembly;
					state = tmpPair.state;
					assembly += state.getWhitespace() + "LDA\t" + SNESRegisters.RDMPYH + "\n";	// 5 cycles - 9, get result and add carryover
					tmpPair = destSource.getSTA(state, offset + i); 							// Store result
					assembly += tmpPair.assembly;
					state = tmpPair.state;
				}
			}
			return new AssemblyStatePair(assembly, state);
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
		for (int i = 0; i < sourceX.getSize(); ++i)
			new MultiplierOperator(i, destSource, sourceX, sourceY).apply(pair);
		return pair.getImmutable();
	}

}
