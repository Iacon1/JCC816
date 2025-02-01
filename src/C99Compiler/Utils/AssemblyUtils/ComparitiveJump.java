// Created by Iacon1 on 01/19/2025.
// Comparitive Jump
package C99Compiler.Utils.AssemblyUtils;

import C99Compiler.CompilerNodes.Interfaces.Assemblable;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;

public class ComparitiveJump implements Assemblable
{
	private Assemblable assemblable;
	private String jumpTo, jumpAfter, dbgLine;
	private boolean skipOnZero;
	public ComparitiveJump(Assemblable assemblable, String jumpTo, String jumpAfter, boolean skipOnZero, String dbgLine)
	{
		this.assemblable = assemblable;
		this.jumpTo = jumpTo;
		this.jumpAfter = jumpAfter;
		this.dbgLine = dbgLine;
		this.skipOnZero = skipOnZero;
	}
	public ComparitiveJump(Assemblable assemblable, String jumpTo, String jumpAfter, boolean skipOnZero)
	{
		this.assemblable = assemblable;
		this.jumpTo = jumpTo;
		this.jumpAfter = jumpAfter;
		this.dbgLine = null;
		this.skipOnZero = skipOnZero;
	}
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		String whitespace = state.getWhitespace();
		String assembly = "";
		if (CompUtils.estimateLength(assemblable.getAssembly(state)) <= 127)
			assembly += whitespace + (skipOnZero ? "BEQ\t" : "BNE\t") + jumpTo + "\n";
		else
		{
			assembly += whitespace + (skipOnZero ? "BNE\t" : "BEQ\t") + ":+\n";
			assembly += whitespace + "JMP\t" + jumpTo + "\n";
			assembly += whitespace + ":\n";
		}
		if (dbgLine != null) assembly += dbgLine;
		
		AssemblyStatePair tmpPair = assemblable.getAssemblyAndState(state);
		assembly += tmpPair.assembly;
		state = tmpPair.state;
		
		if (jumpAfter != null)
			assembly += whitespace + "JMP\t" + jumpAfter + "\n";
		assembly += whitespace + jumpTo + ":\n";
		return new AssemblyStatePair(assembly, state);
	}

}
