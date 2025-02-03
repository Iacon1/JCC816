// Created by Iacon1 on 01/19/2025.
// Comparitive Jump
package C99Compiler.Utils.AssemblyUtils;

import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import Shared.Assemblable;

public class ComparitiveJump implements Assemblable
{
	private Assemblable assemblable1, assemblable2;
	private String jumpTo, jumpAfter, dbgLine;
	private boolean skipOnZero;
	public ComparitiveJump(Assemblable assemblable1, Assemblable assemblable2, String jumpTo, String jumpAfter, boolean skipOnZero, String dbgLine)
	{
		this.assemblable1 = assemblable1;
		this.assemblable2 = assemblable2;
		this.jumpTo = jumpTo;
		this.jumpAfter = jumpAfter;
		this.dbgLine = dbgLine;
		this.skipOnZero = skipOnZero;
	}
	public ComparitiveJump(Assemblable assemblable1, Assemblable assemblable2, String jumpTo, String jumpAfter, boolean skipOnZero)
	{
		this.assemblable1 = assemblable1;
		this.assemblable2 = assemblable2;
		this.jumpTo = jumpTo;
		this.jumpAfter = jumpAfter;
		this.dbgLine = null;
		this.skipOnZero = skipOnZero;
	}
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		ProgramState state1, state2;
		AssemblyStatePair tmpPair;
		String whitespace = state.getWhitespace();
		String assembly = "";
		if (CompUtils.estimateLength(assemblable1.getAssembly(state)) <= 127)
			assembly += whitespace + (skipOnZero ? "BEQ\t" : "BNE\t") + jumpTo + "\n";
		else
		{
			assembly += whitespace + (skipOnZero ? "BNE\t" : "BEQ\t") + ":+\n";
			assembly += whitespace + "JMP\t" + jumpTo + "\n";
			assembly += whitespace + ":\n";
		}
		if (dbgLine != null) assembly += dbgLine;
		state2 = state;
		
		tmpPair = assemblable1.getAssemblyAndState(state);
		assembly += tmpPair.assembly;
		state1 = tmpPair.state;
		
		if (jumpAfter != null)
			assembly += whitespace + "JMP\t" + jumpAfter + "\n";
		assembly += whitespace + jumpTo + ":\n";
		if (assemblable2 != null)
		{
			state = state2;
			tmpPair = assemblable2.getAssemblyAndState(state);
			assembly += tmpPair.assembly;
			state2 = tmpPair.state;
		}
		state = state1.combine(state2);
		if (jumpAfter != null)
			assembly += whitespace + jumpAfter + ":\n";
		
		return new AssemblyStatePair(assembly, state);
	}

}
