// Created by Iacon1 on 11/19/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import org.antlr.v4.runtime.ParserRuleContext;

import C99Compiler.CompConfig.OptimizationLevel;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import C99Compiler.Utils.ScratchManager.ScratchSource;

public abstract class ArithmeticBinaryExpressionNode<
C1 extends ParserRuleContext,
C2 extends ParserRuleContext,
PC extends ParserRuleContext,
CC extends ParserRuleContext
> extends BinaryExpressionNode<C1, C2, PC, CC>
{
	protected ArithmeticBinaryExpressionNode(ComponentNode<?> parent)
	{
		super(parent);
	}
	protected ArithmeticBinaryExpressionNode(String operator)
	{
		super();
		this.operator = operator;
	}

	@Override public Type getType()
	{
		return Type.convertArithmetic(x.getType(), y.getType());
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
	public Object getPropValue()
	{
		Long a = x.getPropLong();
		Long b = y.getPropLong();
		if (a == null || b == null) return null;
		else return Long.valueOf(doOperation(a, b));
	}	
	
	protected String getAssembly(String whitespace, OperandSource destSource, OperandSource sourceX,
			OperandSource sourceY, DetailsTicket ticket) throws Exception
	{
		String assembly = "";
		assembly += ticket.save(whitespace, DetailsTicket.saveA);
		DetailsTicket innerTicket = new DetailsTicket(ticket, DetailsTicket.saveA, 0);

		assembly += whitespace + getPreface() + "\n";
		int size = Math.min(destSource.getSize(), getRetSize(sourceX.getSize(), sourceY.getSize()));
		assembly += AssemblyUtils.setSignExtend(whitespace, sourceX, sourceY, x == null ? true : x.getType().isSigned(), y == null ? true : y.getType().isSigned(), innerTicket);
		assembly += AssemblyUtils.bytewiseOperation(whitespace, size, (Integer i, DetailsTicket ticket2) -> 
		{
			if ((i >= sourceX.getSize() - 1) ^ (i >= sourceY.getSize() - 1)) // Reached the last byte of only one of these
			{
				DetailsTicket ticket3 = new DetailsTicket(ticket2, 0, DetailsTicket.isA16Bit);
				return new String[]
				{
					CompUtils.setA8,
					sourceX.getLDA(i, ticket3),
					sourceY.getInstruction(getInstruction(), i, ticket3),
					(destSource == null) ? "" : destSource.getSTA(i, ticket3),
					sourceX.getLDA(i + 1, ticket3),
					sourceY.getInstruction(getInstruction(), i + 1, ticket3),
					(destSource == null) ? "" : destSource.getSTA(i + 1, ticket3),
					CompUtils.setA16
				};
			}
			else
				return new String[]
				{
					sourceX.getLDA(i, ticket2),
					sourceY.getInstruction(getInstruction(), i, ticket2),
					(destSource == null) ? "" : destSource.getSTA(i, ticket2)
				};
		}, true, isReversed(), innerTicket);
		
		assembly += ticket.restore(whitespace, DetailsTicket.saveA);
		return assembly;
	}
	
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, OperandSource sourceX,
			OperandSource sourceY, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		if (y.hasLValue() && OptimizationLevel.isAtLeast(OptimizationLevel.medium)) sourceY = AssemblyUtils.getShrinkWrapped(y.getLValue());
		if (x.hasLValue() && OptimizationLevel.isAtLeast(OptimizationLevel.medium)) sourceX = AssemblyUtils.getShrinkWrapped(x.getLValue());

		return getAssembly(whitespace, destSource, sourceX, sourceY, ticket);
	}
}
