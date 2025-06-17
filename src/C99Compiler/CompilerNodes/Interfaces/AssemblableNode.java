// By Iacon1
// Created 09/30/2023
//
package C99Compiler.CompilerNodes.Interfaces;

import C99Compiler.CompConfig.VerbosityLevel;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.PropPointer;
import Shared.Assemblable;

public interface AssemblableNode extends Assemblable
{
	public boolean canCall(ProgramState state, FunctionDefinitionNode function);
	@Deprecated
	public default boolean canCall(FunctionDefinitionNode function) {return canCall(new ProgramState(), function);}
	
	public boolean hasPropValue(ProgramState state);
	@Deprecated
	public default boolean hasPropValue() {return hasPropValue(new ProgramState());}
	
	public Object getPropValue(ProgramState state);
	@Deprecated
	public default Object getPropValue() {return getPropValue(new ProgramState());}
	
	public default long getPropLong(ProgramState state)
	{
		try {return ((Number) getPropValue(state)).longValue();}
		catch (Exception e) {return 0;}
	}
	public default long getPropLong(ProgramState state, Type type)
	{
		try
		{
			int length = type.getSize();
			boolean signed = type.isSigned();
			long mask1 = (long) Math.pow(2, 8*length) - 1;
			long mask2 = (long) Math.pow(2, 8*length - 1);
			long n = ((Number) getPropValue(state)).longValue();
			n &= mask1;
			if ((n & mask2) != 0 && signed)
				n = -(mask1 & ~n) - 1;
			return n;
		}
		catch (Exception e) {return 0;}
	}
	@Deprecated
	public default long getPropLong()
	{
		return getPropLong(new ProgramState());
	}
	public default boolean getPropBool(ProgramState state)
	{
		try {return (Boolean) getPropValue(state);}
		catch (Exception e)
		{
			if (getPropLong(state) != 0)
				return true;
			return false;
		}
	}
	@Deprecated
	public default boolean getPropBool()
	{
		return getPropBool(new ProgramState());
	}
	public default PropPointer<?> getPropPointer(ProgramState state)
	{
		try {return (PropPointer<?>) getPropValue(state);}
		catch (Exception e) {return null;}
	}
	@Deprecated
	public default PropPointer<?> getPropPointer()
	{
		return getPropPointer(new ProgramState());
	}
	
	public boolean hasAssembly(ProgramState state);
	@Deprecated
	public default boolean hasAssembly() {return hasAssembly(new ProgramState());}
	
	public ProgramState getStateBefore(ProgramState state, ComponentNode<?> child) throws Exception;
}
