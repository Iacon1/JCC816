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
		if ((flags & ProgramState.PreserveFlag.A) != 0 && state.testPreserveFlag(ProgramState.PreserveFlag.A))
			assembly = state.getWhitespace() + "PHA\n";
		if ((flags & ProgramState.PreserveFlag.X) != 0 && state.testPreserveFlag(ProgramState.PreserveFlag.X))
			assembly = state.getWhitespace() + "PHX\n";
		if ((flags & ProgramState.PreserveFlag.Y) != 0 && state.testPreserveFlag(ProgramState.PreserveFlag.Y))
			assembly = state.getWhitespace() + "PHY\n";
		if ((flags & ProgramState.PreserveFlag.M) != 0 && state.testPreserveFlag(ProgramState.PreserveFlag.M))
			assembly = state.getWhitespace() + "PHP\n";
		else if ((flags & ProgramState.PreserveFlag.I) != 0 && state.testPreserveFlag(ProgramState.PreserveFlag.I))
			assembly = state.getWhitespace() + "PHP\n";
		return assembly;
	}
	public static String restore(ProgramState state, byte flags)
	{
		String assembly = "";
		if ((flags & ProgramState.PreserveFlag.M) != 0 && state.testPreserveFlag(ProgramState.PreserveFlag.M))
			assembly = state.getWhitespace() + "PLP\n";
		else if ((flags & ProgramState.PreserveFlag.I) != 0 && state.testPreserveFlag(ProgramState.PreserveFlag.I))
			assembly = state.getWhitespace() + "PLP\n";
		if ((flags & ProgramState.PreserveFlag.Y) != 0 && state.testPreserveFlag(ProgramState.PreserveFlag.Y))
			assembly = state.getWhitespace() + "PLY\n";
		if ((flags & ProgramState.PreserveFlag.X) != 0 && state.testPreserveFlag(ProgramState.PreserveFlag.X))
			assembly = state.getWhitespace() + "PLX\n";
		if ((flags & ProgramState.PreserveFlag.A) != 0 && state.testPreserveFlag(ProgramState.PreserveFlag.A))
			assembly = state.getWhitespace() + "PLA\n";
		return assembly;
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
