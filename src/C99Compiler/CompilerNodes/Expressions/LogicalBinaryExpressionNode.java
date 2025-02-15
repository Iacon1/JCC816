// Created by Iacon1 on 01/28/2024.
// LOR and LAND
package C99Compiler.CompilerNodes.Expressions;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyType;
import C99Compiler.CompilerNodes.Interfaces.SequencePointNode;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.ScratchSource;
import C99Compiler.Utils.AssemblyUtils.AssemblyUtils;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;

public abstract class LogicalBinaryExpressionNode<
C1 extends ParserRuleContext,
C2 extends ParserRuleContext,
PC extends ParserRuleContext,
CC extends ParserRuleContext
> extends SPBinaryExpressionNode<C1, C2, PC, CC>
{
	
	public LogicalBinaryExpressionNode(ComponentNode<?> parent)
	{
		super(parent);
	}
	
	@Override public Type getType() {return new DummyType("int");}
	
	@Override
	public String getAssembly(ProgramState state) throws Exception
	{
		AssemblyStatePair queuedPair;
		ScratchSource scratchX = null, scratchY = null;
		final OperandSource sourceX, sourceY;
		OperandSource destSource = state.destSource();
		String assembly = "";

		// figure out X
		clearAssemblables();
		isSP = true;
		if (x.hasAssembly(state))
		{
			state = state.reserveScratchBlock(y.getType().getSize());
			scratchX = state.lastScratchSource();
			state = state.setDestSource(scratchX);
			assembly += x.getAssembly(state);
			if (x.hasLValue(state))
				sourceX = x.getLValue(state).getSource();
			else sourceX = scratchX;
		}
		else if (x.hasPropValue(state))
			sourceX = new ConstantSource(x.getPropValue(state), x.getType().getSize());
		else if (x.hasLValue(state))
			sourceX = x.getLValue(state).getSource();
		else sourceX = null;
		
		queuedPair = getRegisteredAssemblyAndState(state);
		assembly += queuedPair.assembly;
		state = queuedPair.state;
		
		clearAssemblables();
		isSP = false;
		
		// figure out Y		
		if (y.hasAssembly(state))
		{
			state = state.reserveScratchBlock(y.getType().getSize());
			scratchY = state.lastScratchSource();
			state = state.setDestSource(scratchY);
			assembly += y.getAssembly(state);
			if (y.hasLValue(state))
				sourceY = y.getLValue(state).getSource();
			else sourceY = scratchY;
		}
		else if (y.hasPropValue(state))
			sourceY = new ConstantSource(y.getPropValue(state), y.getType().getSize());
		else if (y.hasLValue(state))
			sourceY = y.getLValue(state).getSource();
		else sourceY = null;
		
		state = state.setDestSource(destSource);
		assembly += getAssemblyAndState(state, sourceX, sourceY);
		
		if (scratchX != null)
			state = state.releaseScratchBlock(scratchX);
		if (scratchY != null)
			state = state.releaseScratchBlock(scratchY);
		
		state = state.releasePointer(destSource); // A copy of the destination, if it's a pointer, has gone stale
		return assembly;
	}
	
	@Override
	public boolean isLogical() {return true;}
}
