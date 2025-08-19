// Created by Iacon1 on 10/22/2023.
//
package C99Compiler.Utils.AssemblyUtils;

import java.util.function.BiFunction;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.OperandSources.OperandSource;
import C99Compiler.Utils.OperandSources.StationaryAddressSource;
import C99Compiler.Utils.ProgramState.PreserveFlag;
import C99Compiler.Utils.ProgramState.ProcessorFlag;
import Shared.Assemblable.AssemblyStatePair;
import Shared.Assemblable.MutableAssemblyStatePair;

public final class AssemblyUtils
{
	public static String applyFiller(String string, int desiredLength)
	{
		String filler = new String(new char[desiredLength - string.length()]).replace('\0', ' ');
		
		return string + filler;
	}
	public static String store(ProgramState state, byte flags)
	{
		String assembly = "";
		if ((flags & ProgramState.PreserveFlag.A) == ProgramState.PreserveFlag.A && state.testPreserveFlag(ProgramState.PreserveFlag.A))
			assembly = state.getWhitespace() + "PHA\n";
		if ((flags & ProgramState.PreserveFlag.X) == ProgramState.PreserveFlag.X && state.testPreserveFlag(ProgramState.PreserveFlag.X))
			assembly = state.getWhitespace() + "PHX\n";
		if ((flags & ProgramState.PreserveFlag.Y) == ProgramState.PreserveFlag.Y && state.testPreserveFlag(ProgramState.PreserveFlag.Y))
			assembly = state.getWhitespace() + "PHY\n";
		if ((flags & ProgramState.PreserveFlag.M) == ProgramState.PreserveFlag.M && state.testPreserveFlag(ProgramState.PreserveFlag.M))
			assembly = state.getWhitespace() + "PHP\n";
		else if ((flags & ProgramState.PreserveFlag.I) == ProgramState.PreserveFlag.I && state.testPreserveFlag(ProgramState.PreserveFlag.I))
			assembly = state.getWhitespace() + "PHP\n";
		return assembly;
	}
	public static String restore(ProgramState state, byte flags)
	{
		String assembly = "";
		if ((flags & ProgramState.PreserveFlag.A) == ProgramState.PreserveFlag.A && state.testPreserveFlag(ProgramState.PreserveFlag.A))
			assembly = state.getWhitespace() + "PLA\n";
		if ((flags & ProgramState.PreserveFlag.X) == ProgramState.PreserveFlag.X && state.testPreserveFlag(ProgramState.PreserveFlag.X))
			assembly = state.getWhitespace() + "PLX\n";
		if ((flags & ProgramState.PreserveFlag.Y) == ProgramState.PreserveFlag.Y && state.testPreserveFlag(ProgramState.PreserveFlag.Y))
			assembly = state.getWhitespace() + "PLY\n";
		if ((flags & ProgramState.PreserveFlag.M) == ProgramState.PreserveFlag.M && state.testPreserveFlag(ProgramState.PreserveFlag.M))
			assembly = state.getWhitespace() + "PLP\n";
		else if ((flags & ProgramState.PreserveFlag.I) == ProgramState.PreserveFlag.I && state.testPreserveFlag(ProgramState.PreserveFlag.I))
			assembly = state.getWhitespace() + "PLP\n";
		return assembly;
	}

	public static MutableAssemblyStatePair forceFlags(MutableAssemblyStatePair pair, byte flags, boolean set)
	{
		byte procFlags = 0;
		if ((flags & PreserveFlag.M) != 0)
			procFlags |= ProcessorFlag.M;
		if ((flags & PreserveFlag.I) != 0)
			procFlags |= ProcessorFlag.I;
		
		String procString = String.format("%02x", procFlags);
		if (set)
		{
			if (!pair.state.testKnownFlag(flags) || !pair.state.testProcessorFlag(procFlags))
			{
				pair.assembly += pair.state.getWhitespace() + "REP\t#$" + procString + "\n";
				pair.state = pair.state.setProcessorFlags(ProcessorFlag.I);				
			}
		}
		else
		{
			if (!pair.state.testKnownFlag(flags) || pair.state.testProcessorFlag(procFlags))
			{
				pair.assembly += pair.state.getWhitespace() + "SEP\t#$" + procString + "\n";
				pair.state = pair.state.clearProcessorFlags(ProcessorFlag.I);				
			}
		}
		
		return pair;
	}
	
	public static AssemblyStatePair forceFlags(AssemblyStatePair pair, byte flags, boolean set)
	{
		MutableAssemblyStatePair tmpPair = new MutableAssemblyStatePair(pair.assembly, pair.state);
		return forceFlags(tmpPair, flags, set).getImmutable();
	}
	
	public static OperandSource getShrinkWrapped(ProgramState state, LValueNode<?> x)
	{
		if (state.getSmallestValue(x) != null && state.getLargestValue(x) != null)
		{
			Type fittedTypeX = CompUtils.getSmallestType(Math.max(-state.getSmallestValue(x), state.getLargestValue(x)));
			if (x.getSize() > fittedTypeX.getSize())
				return x.getSource().getShifted(0, fittedTypeX.getSize() - x.getSize());
		}
		return x.getSource();
	}
}
