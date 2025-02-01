// Created by Iacon1 on 11/19/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import org.antlr.v4.runtime.ParserRuleContext;

import C99Compiler.CompConfig.OptimizationLevel;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.AssemblyUtils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.BytewiseOperator;
import C99Compiler.Utils.AssemblyUtils.ZeroCopier;
import C99Compiler.Utils.OperandSources.OperandSource;

public abstract class ArithmeticBinaryExpressionNode<
C1 extends ParserRuleContext,
C2 extends ParserRuleContext,
PC extends ParserRuleContext,
CC extends ParserRuleContext
> extends BinaryExpressionNode<C1, C2, PC, CC>
{
	private class ArithmeticOperator extends BytewiseOperator
	{
		private OperandSource destSource, sourceX, sourceY;
		
		protected ArithmeticOperator(int size, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, boolean reversed)
		{
			super(Math.max(sourceX.getSize(), sourceY.getSize()), Math.min(sourceX.getSize(), sourceY.getSize()), reversed);
			this.destSource = destSource;
			this.sourceX = sourceX;
			this.sourceY = sourceY;
		}

		@Override
		protected AssemblyStatePair getAssemblyAndState(ProgramState state, int i) throws Exception
		{
			AssemblyStatePair tmpPair;
			String assembly = "";
			
			tmpPair = sourceX.getLDA(state, i);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			
			tmpPair = sourceY.getInstruction(state, getInstruction(), i);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			
			tmpPair = destSource.getSTA(state, i);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
				
			return new AssemblyStatePair(assembly, state);
		}
	}
	
	protected ArithmeticBinaryExpressionNode(ComponentNode<?> parent)
	{
		super(parent);
	}
	protected ArithmeticBinaryExpressionNode(String operator)
	{
		super();
		this.operator = operator;
	}

	public ArithmeticBinaryExpressionNode(ComponentNode<?> parent, String operator, BaseExpressionNode<?> x,
			BaseExpressionNode<?> y)
	{
		super(parent);
		this.operator = operator;
		this.x = x;
		this.y = y;
	}
	@Override public Type getType()
	{/*
		if (hasPropValue() && !hasAssembly())
			return CompUtils.getSmallestSignedType(getPropLong());
		else
	*/		return Type.convertArithmetic(x.getType(), y.getType());
	}
	
	protected abstract long doOperation(long x, long y);
	protected abstract String getPreface();
	protected abstract String getInstruction();
	protected abstract boolean isReversed();
	protected int getRetSize(int sizeX, int sizeY)
	{
		return Math.max(sizeX, sizeY);
	}
	
	@Override
	public Object getPropValue(ProgramState state)
	{
		Long a = x.getPropLong(state);
		Long b = y.getPropLong(state);
		if (a == null || b == null) return null;
		else return Long.valueOf(doOperation(a, b));
	}	
	
	@Override
	protected AssemblyStatePair getAssemblyAndState(ProgramState state, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		if (!sourceY.isLiteral() && y.hasLValue() && OptimizationLevel.isAtLeast(OptimizationLevel.medium)) sourceY = AssemblyUtils.getShrinkWrapped(state, y.getLValue());
		if (!sourceX.isLiteral() && x.hasLValue() && OptimizationLevel.isAtLeast(OptimizationLevel.medium)) sourceX = AssemblyUtils.getShrinkWrapped(state, x.getLValue());

		String assembly = "";
		OperandSource destSource = state.destSource();
		
		byte pFlags = state.getPreserveFlags();
		assembly += AssemblyUtils.store(state, ProgramState.PreserveFlag.A);
		state = state.clearPreserveFlags(ProgramState.PreserveFlag.A);
		
		assembly += state.getWhitespace() + getPreface() + "\n";
		int size;
		if (destSource != null)
			size = Math.min(destSource.getSize(), getRetSize(sourceX.getSize(), sourceY.getSize()));
		else
			size = getRetSize(sourceX.getSize(), sourceY.getSize());
		ArithmeticOperator operator = new ArithmeticOperator(size, destSource, sourceX, sourceY, isReversed());
		
		assembly += operator.getAssembly(state);
		state = operator.getStateAfter(state);
		if (size < destSource.getSize())
		{
			ZeroCopier zeroCopier = new ZeroCopier(destSource.getSize(), destSource.getShifted(size), false);
			assembly += zeroCopier.getAssembly(state);
			state = zeroCopier.getStateAfter(state);
		}
		state.setPreserveFlags(pFlags);
		assembly += AssemblyUtils.restore(state, ProgramState.PreserveFlag.A);
		return new AssemblyStatePair(assembly, state);
	}
}
