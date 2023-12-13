// Created by Iacon1 on 11/23/2023.
// An arithmetic binary expression node that calls a subroutine
package Compiler.ComponentNodes.Expressions;

import org.antlr.v4.runtime.ParserRuleContext;

import Compiler.CompConfig;
import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.CompUtils;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.OperandSources.OperandSource;

public abstract class CallingArithmeticBinaryExpressionNode<
C1 extends ParserRuleContext,
C2 extends ParserRuleContext,
PC extends ParserRuleContext,
CC extends ParserRuleContext
> extends ArithmeticBinaryExpressionNode<C1, C2, PC, CC>
{
	protected CallingArithmeticBinaryExpressionNode(ComponentNode<?> parent)
	{
		super(parent);
	}

	protected String getPreface() {throw new UnsupportedOperationException();}
	@Override
	protected String getInstruction() {throw new UnsupportedOperationException();}
	@Override
	protected boolean isReversed() {throw new UnsupportedOperationException();}
	@Override
	protected abstract int getRetSize(int sizeX, int sizeY);
	
	public abstract String getSubroutine(int sizeX, int sizeY) throws Exception;
	public abstract String getSubName(int sizeX, int sizeY);
	
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, OperandSource sourceX,
			OperandSource sourceY, DetailsTicket ticket) throws Exception
	{
		String assembly = "";
		assembly += ticket.save(whitespace, 0xFF);
		DetailsTicket innerTicket = new DetailsTicket(ticket, 0, 0xFF);
		assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), CompConfig.multDivSource(true, sourceX.getSize()), sourceX, innerTicket);
		assembly += AssemblyUtils.byteCopier(whitespace, sourceY.getSize(), CompConfig.multDivSource(true, sourceX.getSize()), sourceX, innerTicket);
		assembly += whitespace + "JSL\t" + getSubName(sourceX.getSize(), sourceY.getSize()) + "\n";
		int retSize = Math.min(destSource.getSize(), getRetSize(sourceX.getSize(), sourceY.getSize()));
		assembly += AssemblyUtils.byteCopier(whitespace, retSize, destSource, CompConfig.callResultSource(retSize), innerTicket);
		
		assembly += ticket.restore(whitespace, 0xFF);
		return assembly;
	}
}