// Created by Iacon1 on 01/30/2025.
//
package C99Compiler.Utils.AssemblyUtils;

import C99Compiler.CompConfig;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.PreserveFlag;
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
		if (sourceX.getSize() < sourceY.getSize() && !sourceX.isLiteral()) // x will need the sign extension.
		{
			pair.assembly += pair.state.getWhitespace() + CompUtils.setA8 + "\n";
			if (!signedX)
			{
				pair.assembly += pair.state.getWhitespace() + "LDA\t#$00\n";
				state = pair.state.fixAReg(0);
				pair.assembly += pair.state.getWhitespace() + "STA\t" + CompConfig.signExtend + "\n";
				return pair.getImmutable();
			}
			sourceX.applyLDA(pair, sourceX.getSize() - 1);
		}
		else if (sourceX.getSize() < sourceY.getSize() && sourceX.isLiteral()) // Literals account for this, so not needed.
			return pair.getImmutable();
		else if (!sourceY.isLiteral()) // y will need the sign extension.
		{
			pair.assembly += pair.state.getWhitespace() + CompUtils.setA8 + "\n";
			if (!signedY)
			{
				pair.assembly += pair.state.getWhitespace() + "LDA\t#$00\n";
				state = pair.state.fixAReg(0);
				pair.assembly += pair.state.getWhitespace() + "STA\t" + CompConfig.signExtend + "\n";
				return pair.getImmutable();
			}
			sourceY.applyLDA(pair, sourceY.getSize() - 1);
		}
		else if (sourceY.isLiteral()) // Literals account for this, so not needed.
			return pair.getImmutable();
		
		pair.assembly += pair.state.getWhitespace() + "BPL\t:+\n";
		pair.assembly += pair.state.getWhitespace() + "LDA\t#$FF\n";
		pair.assembly += pair.state.getWhitespace() + "BRA\t:++\n";
		pair.assembly += pair.state.getWhitespace() + ":\n";
		pair.assembly += pair.state.getWhitespace() + "LDA\t#$00\n";
		pair.assembly += pair.state.getWhitespace() + ":\n";
		state = pair.state.clearKnownFlags(PreserveFlag.A);
		pair.assembly += pair.state.getWhitespace() + "STA\t" + CompConfig.signExtend + "\n";
		
		return pair.getImmutable();	
	}

}
