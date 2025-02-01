// Created by Iacon1 on 12/12/2023.
//
package C99Compiler.CompilerNodes.Expressions.Snippets;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.Interfaces.Assemblable;
import C99Compiler.CompilerNodes.Interfaces.Assemblable.AssemblyStatePair;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.ProcessorFlag;
import C99Compiler.Utils.SNESRegisters;
import C99Compiler.Utils.AssemblyUtils.BytewiseOperator;
import C99Compiler.Utils.OperandSources.OperandSource;

//Uses hardware div registers, but only for 8-bit divisor
public class ShortDividerModulator implements Assemblable
{
	private static class ShortDividerModulatorOperator extends BytewiseOperator
	{
		private final OperandSource sourceX, sourceY, destSource;
		SNESRegisters RRegL;
		SNESRegisters RRegH;
		
		ShortDividerModulatorOperator(OperandSource destSource, OperandSource sourceX, OperandSource sourceY, boolean isModulo)
		{
			super(sourceX.getSize(), sourceX.getSize(), false);
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
			String assembly = "";
			
			if (i < sourceX.getSize() - 1 || sourceX.getSize() % 2 == 0) // We start in 16-bit mode
			{
				if (i == 0) // First iteration
				{
					sourceX.applyLDA(pair, i);																// Load X-the-variable
					pair.assembly += pair.state.getWhitespace() + "STA\t" + SNESRegisters.WRDIVL + "\n";	// Place in reg
					pair.assembly += pair.state.getWhitespace() + CompUtils.setA8 + "\n";
					pair.state = pair.state.clearProcessorFlags(ProcessorFlag.M);
					sourceY.applyLDA(pair, 0);																// Load Y-the-variable
					pair.assembly += "STA\t" + SNESRegisters.WRDIVB;									 	// Place in reg, begin 16-cycle calc
					pair.assembly += pair.state.getWhitespace() + CompUtils.setA16 + "\n";					// 3 cycles - 3
					pair.state = pair.state.setProcessorFlags(ProcessorFlag.M);
					sourceX.applyLDA(pair, i + 1);															// 4-6 cycles - 7-9 Load X-the-variable for next iteration
					pair.assembly += pair.state.getWhitespace() + "TAX\n";									// 2 cycles - 9-11
					pair.assembly += pair.state.getWhitespace() + "NOP\n";									// 2 cycles - 11-13
					pair.assembly += pair.state.getWhitespace() + "NOP\n";									// 2 cycles - 13-15
					pair.assembly += pair.state.getWhitespace() + "LDA\t" + RRegL + "\n";					// 4-6 cycles - 17-21, get result
					destSource.applySTA(pair, i);															// Store result
					pair.assembly += pair.state.getWhitespace() + "TXA\n";									// Swap X-the-variable back in
				}
				else if (i != sourceX.getSize() - 1) // Not the last iteration
				{
					pair.assembly += pair.state.getWhitespace() + "STA\t" + SNESRegisters.WRDIVL + "\n";	// Place in reg
					pair.assembly += pair.state.getWhitespace() + CompUtils.setA8 + "\n";
					pair.state = pair.state.clearProcessorFlags(ProcessorFlag.M);
					pair.assembly += pair.state.getWhitespace() + "CLC\n";									// For addition later
					sourceY.applyLDA(pair, 0);																// Load Y-the-variable
					pair.assembly += "STA\t" + SNESRegisters.WRDIVB;									 	// Place in reg, begin 16-cycle calc
					pair.assembly += pair.state.getWhitespace() + "LDA\t" + RRegH + "\n";					// 4-6 cycles - 4-6, get high byte of previous iteration
					pair.assembly += pair.state.getWhitespace() + CompUtils.setA16 + "\n";					// 3 cycles - 7-9
					pair.state = pair.state.setProcessorFlags(ProcessorFlag.M);
					pair.assembly += pair.state.getWhitespace() + "NOP\n";									// 2 cycles - 9-11
					pair.assembly += pair.state.getWhitespace() + "NOP\n";									// 2 cycles - 11-13
					pair.assembly += pair.state.getWhitespace() + "NOP\n";									// 2 cycles - 13-15
					pair.assembly += pair.state.getWhitespace() + "ADC\t" + RRegL + "\n";					// 4-6 cycles - 17-21, get result
					destSource.applySTA(pair, i);															// Store result
					sourceX.applyLDA(pair, i);																// 6 cycles - 8 Load X-the-variable for next iteration
				}
				else // Last iteration
				{
					pair.assembly += pair.state.getWhitespace() + "TXA\n";									// Recover X-the-variable from last iteration
					pair.assembly += pair.state.getWhitespace() + "STA\t" + SNESRegisters.WRDIVL + "\n";	// Place in reg
					pair.assembly += pair.state.getWhitespace() + CompUtils.setA8 + "\n";
					pair.state = pair.state.clearProcessorFlags(ProcessorFlag.M);
					pair.assembly += pair.state.getWhitespace() + "CLC\n";									// For addition later
					sourceY.applyLDA(pair, 0);																// Load Y-the-variable
					pair.assembly += "STA\t" + SNESRegisters.WRDIVB;									 	// Place in reg, begin 16-cycle calc
					pair.assembly += pair.state.getWhitespace() + "LDA\t" + RRegH + "\n";					// 4-6 cycles - 4-6, get high byte of previous iteration
					pair.assembly += pair.state.getWhitespace() + CompUtils.setA16 + "\n";					// 3 cycles - 7-9
					pair.state = pair.state.setProcessorFlags(ProcessorFlag.M);
					pair.assembly += pair.state.getWhitespace() + "NOP\n";									// 2 cycles - 9-11
					pair.assembly += pair.state.getWhitespace() + "NOP\n";									// 2 cycles - 11-13
					pair.assembly += pair.state.getWhitespace() + "NOP\n";									// 2 cycles - 13-15
					pair.assembly += pair.state.getWhitespace() + "ADC\t" + RRegL + "\n";					// 4-6 cycles - 17-21, get result
					destSource.applySTA(pair, i);															// Store result
				}
			}
			else // 8-bit mode
			{
				sourceX.applyLDA(pair, i);																// Load X-the-variable
				pair.assembly += pair.state.getWhitespace() + "STA\t" + SNESRegisters.WRDIVL + "\n";	// Place in reg
				sourceY.applyLDA(pair, i);																// Load Y-the-variable
				pair.assembly += pair.state.getWhitespace() + "STA\t" + SNESRegisters.WRDIVB + "\n";	// Place in reg, begin 16-cycle calc
				pair.assembly += pair.state.getWhitespace() + "NOP\n";									// 2 cycles - 2
				pair.assembly += pair.state.getWhitespace() + "NOP\n";									// 2 cycles - 4
				pair.assembly += pair.state.getWhitespace() + "NOP\n";									// 2 cycles - 6
				pair.assembly += pair.state.getWhitespace() + "NOP\n";									// 2 cycles - 8
				pair.assembly += pair.state.getWhitespace() + "NOP\n";									// 2 cycles - 10
				pair.assembly += pair.state.getWhitespace() + "NOP\n";									// 2 cycles - 12
				pair.assembly += pair.state.getWhitespace() + "NOP\n";									// 2 cycles - 14
				pair.assembly += pair.state.getWhitespace() + "STA\t" + RRegL + "\n";					// 5 cycles - 17, get result
				destSource.applyLDA(pair, i);
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
		return new ShortDividerModulatorOperator(destSource, sourceX, sourceY, isModulo).getAssemblyAndState(state);
	}

}
