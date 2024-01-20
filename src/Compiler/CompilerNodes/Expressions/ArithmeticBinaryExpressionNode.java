// Created by Iacon1 on 11/19/2023.
//
package Compiler.CompilerNodes.Expressions;

import org.antlr.v4.runtime.ParserRuleContext;

import Compiler.CompConfig.OptimizationLevel;
import Compiler.CompilerNodes.ComponentNode;
import Compiler.CompilerNodes.Definitions.Type;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.CompUtils;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.ConstantSource;
import Compiler.Utils.OperandSources.OperandSource;
import Compiler.Utils.ScratchManager.ScratchSource;

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
		assembly += AssemblyUtils.bytewiseOperation(whitespace, size, (Integer i, DetailsTicket ticket2) -> 
		{return new String[]
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
