// Created by Iacon1 on 01/30/2025.
//
package C99Compiler.Utils.AssemblyUtils;

import C99Compiler.CompConfig;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.PreserveFlag;
import C99Compiler.Utils.ProgramState.ProcessorFlag;
import Shared.Assemblable;
import C99Compiler.Utils.OperandSources.OperandSource;

/**
 * 
 */
public class SignExtender implements Assemblable
{
	private OperandSource sourceX, sourceY;
	private boolean signedX, signedY;
	
	public SignExtender(OperandSource sourceX, OperandSource sourceY, boolean signedX, boolean signedY)
	{
		this.sourceX = sourceX;
		this.sourceY = sourceY;
		
		this.signedX = signedX;
		this.signedY = signedY;
	}
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
		if (sourceX.getSize() == sourceY.getSize())
			return pair.getImmutable(); // Sign extension not needed.
		else if (sourceX.getSize() < sourceY.getSize()) // x is the smaller
		{
			if (sourceX.isLiteral())
				return pair.getImmutable(); // Literals account for this, so not needed.
			else
			{
				if (!signedX)
				{
					if (!pair.state.testKnownFlag(PreserveFlag.M) || !pair.state.testProcessorFlag(ProcessorFlag.M))
					{
						pair.assembly += pair.state.getWhitespace() + CompUtils.setA16 + "\n";
						pair.state = pair.state.setProcessorFlags(ProcessorFlag.M);
					}
					pair.assembly += pair.state.getWhitespace() + "LDA\t#$0000\n";
					pair.state = pair.state.fixAReg(0);
					pair.assembly += pair.state.getWhitespace() + "STA\t" + CompConfig.signExtend + "\n";
					return pair.getImmutable();
				}
				else
				{
					if (!pair.state.testKnownFlag(PreserveFlag.M) || pair.state.testProcessorFlag(ProcessorFlag.M))
					{
						pair.assembly += pair.state.getWhitespace() + CompUtils.setA8 + "\n";
						pair.state = pair.state.clearProcessorFlags(ProcessorFlag.M);
					}
					sourceX.applyLDA(pair, sourceX.getSize() - 1);
				}
			}
		}
		else if (sourceY.getSize() < sourceX.getSize()) // y is the smaller
		{
			if (sourceY.isLiteral())
				return pair.getImmutable(); // Literals account for this, so not needed.
			else
			{
				if (!signedY)
				{
					if (!pair.state.testKnownFlag(PreserveFlag.M) || !pair.state.testProcessorFlag(ProcessorFlag.M))
					{
						pair.assembly += pair.state.getWhitespace() + CompUtils.setA16 + "\n";
						pair.state = pair.state.setProcessorFlags(ProcessorFlag.M);
					}
					pair.assembly += pair.state.getWhitespace() + "LDA\t#$0000\n";
					pair.state = pair.state.fixAReg(0);
					pair.assembly += pair.state.getWhitespace() + "STA\t" + CompConfig.signExtend + "\n";
					return pair.getImmutable();
				}
				else
				{
					if (!pair.state.testKnownFlag(PreserveFlag.M) || pair.state.testProcessorFlag(ProcessorFlag.M))
					{
						pair.assembly += pair.state.getWhitespace() + CompUtils.setA8 + "\n";
						pair.state = pair.state.clearProcessorFlags(ProcessorFlag.M);
					}
					sourceY.applyLDA(pair, sourceY.getSize() - 1);
				}
			}
		}

		pair.assembly += pair.state.getWhitespace() + "BPL\t:+\n";
		pair.assembly += pair.state.getWhitespace() + "LDA\t#$FF\n";
		pair.assembly += pair.state.getWhitespace() + "BRA\t:++\n";
		pair.assembly += pair.state.getWhitespace() + ":\n";
		pair.assembly += pair.state.getWhitespace() + "LDA\t#$00\n";
		pair.assembly += pair.state.getWhitespace() + ":\n";
		state = pair.state.clearKnownFlags(PreserveFlag.A);
		pair.assembly += pair.state.getWhitespace() + "STA\t" + CompConfig.signExtend + "\n";
		pair.assembly += pair.state.getWhitespace() + "STA\t" + CompConfig.signExtend + " + 1\n";

		return pair.getImmutable();	
	}

}
