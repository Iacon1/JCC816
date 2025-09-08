// Created by Iacon1 on 01/28/2024.
// LOR and LAND
package C99Compiler.CompilerNodes.Expressions;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import C99Compiler.CompConfig;
import C99Compiler.ASMGrapher.ASMGraphBuilder;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyType;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.Interfaces.SequencePointNode;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.PreserveFlag;
import C99Compiler.Utils.ProgramState.ProcessorFlag;
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
	private final boolean skipOnTrue; // If false, skip second operation if first is false. If true, skip second operation if first is true.
	public LogicalBinaryExpressionNode(ComponentNode<?> parent, boolean skipOnTrue)
	{
		super(parent);
		this.skipOnTrue = skipOnTrue;
	}
	
	@Override public Type getType() {return new DummyType("int");}
	
	@Override
	public BaseExpressionNode<CC> interpret(CC node) throws Exception
	{
		BaseExpressionNode<CC> result = super.interpret(node);
		if (result != this) return result;
		
		if (!x.isLogical())
		{
			EqualityExpressionNode newX = new EqualityExpressionNode(this, x, "!=");
			x.swapParent(newX);
			x = newX;
		}
		
		if (!y.isLogical())
		{
			EqualityExpressionNode newY = new EqualityExpressionNode(this, y, "!=");
			y.swapParent(newY);
			y = newY;
		}
		
		return this;
	}
	
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
		AssemblyStatePair tmpPair, yPair;
		OperandSource destSource = pair.state.destSource();
		OperandSource sourceX, sourceY;

		
		byte flags = pair.state.getPreserveFlags();
		pair.assembly += AssemblyUtils.store(pair.state, PreserveFlag.A);
		pair.state = pair.state.clearPreserveFlags(PreserveFlag.A);
		
		// figure out X
		clearAssemblables();
		isSP = true;
		if (x.hasAssembly(pair.state))
		{
			pair.state = pair.state.reserveScratchBlock(1);
			sourceX = pair.state.lastScratchSource();
			
			pair.state = pair.state.setDestSource(null);
			x.apply(pair);
			if (!pair.state.testKnownFlag(PreserveFlag.M) || pair.state.testProcessorFlag(ProcessorFlag.M))
			{
				pair.assembly += pair.state.getWhitespace() + "SEP\t#$20\n";
				pair.state = pair.state.clearProcessorFlags(ProcessorFlag.M);
			}
			sourceX.applySTA(pair, 0);
		}
		else if (x.hasPropValue(pair.state))
			sourceX = new ConstantSource(x.getPropBool(pair.state) ? 1 : 0, 1);
		else sourceX = null;
		
		applyRegistered(pair);
		
		clearAssemblables();
		isSP = false;
		
		// figure out Y		
		if (y.hasAssembly(pair.state))
		{
			pair.state = pair.state.reserveScratchBlock(1);
			sourceY = pair.state.lastScratchSource();
			
			// Only need to skip second eval if second eval isn't done in compile-time, i. e. has assembly
			String skipLabel = "__SKIP" + CompUtils.getSafeUUID();
			
			pair.state = pair.state.setDestSource(null);
			yPair = y.getAssemblyAndState(pair.state);
			if (new ASMGraphBuilder(yPair.assembly).getSize() >= 128) // Need a long skip
			{
				pair.assembly += pair.state.getWhitespace() + (skipOnTrue ? "BEQ\t" : "BNE\t") + ":+\n";
				pair.assembly += pair.state.getWhitespace() + "JMP\t" + skipLabel + "\n";
				pair.assembly += pair.state.getWhitespace() + ":\n";
			}
			else // Short skip
				pair.assembly += pair.state.getWhitespace() + (skipOnTrue ? "BNE\t" : "BEQ\t") + skipLabel + "\n";
			
			pair.assembly += yPair.assembly;
			pair.state = yPair.state;
			
			if (!pair.state.testKnownFlag(PreserveFlag.M) || pair.state.testProcessorFlag(ProcessorFlag.M))
			{
				pair.assembly += pair.state.getWhitespace() + "SEP\t#$20\n";
				pair.state = pair.state.clearProcessorFlags(ProcessorFlag.M);
			}
			sourceY.applySTA(pair, 0);
			pair.assembly += pair.state.getWhitespace() + skipLabel + ":\n";
		}
		else if (y.hasPropValue(state))
			sourceY = new ConstantSource(y.getPropBool(state) ? 1 : 0, 1);
		else sourceY = null;
		
		pair.state = pair.state.setDestSource(destSource);
		tmpPair = getAssemblyAndState(pair.state, sourceX, sourceY);
		pair.assembly += tmpPair.assembly;
		pair.state = tmpPair.state;
		
		if (ScratchSource.class.isAssignableFrom(sourceX.getClass()))
			pair.state = pair.state.releaseScratchBlock((ScratchSource) sourceX);
		if (ScratchSource.class.isAssignableFrom(sourceY.getClass()))
			pair.state = pair.state.releaseScratchBlock((ScratchSource) sourceY);
		
		pair.state = pair.state.releasePointer(destSource); // A copy of the destination, if it's a pointer, has gone stale

		pair.state = pair.state.setPreserveFlags(flags);
		pair.assembly += AssemblyUtils.restore(pair.state, PreserveFlag.A);
		
		return pair.getImmutable();
	}
	
	@Override
	public boolean isLogical() {return true;}
}
