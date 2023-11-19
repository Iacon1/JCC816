// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.CompConfig;
import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompUtils;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.OperandSources.OperandSource;
import Compiler.Utils.ScratchManager.ScratchSource;
import Grammar.C99.C99Parser.Additive_expressionContext;
import Grammar.C99.C99Parser.Or_expressionContext;
import Grammar.C99.C99Parser.Shift_expressionContext;
import Grammar.C99.C99Parser.Xor_expressionContext;

public class ShiftExpressionNode extends BinaryExpressionNode
<Shift_expressionContext, Additive_expressionContext, Additive_expressionContext, Shift_expressionContext>
{

	public ShiftExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Shift_expressionContext> getC1Node(Shift_expressionContext node) throws Exception
	{return new ShiftExpressionNode(this).interpret(node.shift_expression());}

	@Override
	protected BaseExpressionNode<Additive_expressionContext> getC2Node(Shift_expressionContext node) throws Exception
	{return new AdditiveExpressionNode(this).interpret(node.additive_expression());}

	@Override
	protected BaseExpressionNode<Additive_expressionContext> getPCNode(Shift_expressionContext node) throws Exception
	{return new AdditiveExpressionNode(this).interpret(node.additive_expression());}

	@Override
	public Object getPropValue()
	{
		Long a = x.getPropLong();
		Long b = y.getPropLong();
		switch (operator)
		{
		case "<<": return Long.valueOf(a << b);
		case ">>": return Long.valueOf(a >> b);
		default: return null;
		}
	}
	public static String getShift(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, String operator, OperandSource sourceY, DetailsTicket ticket) throws Exception
	{
		String assembly = "";
		assembly += ticket.save(whitespace, DetailsTicket.saveA | DetailsTicket.saveX);
		DetailsTicket innerTicket = new DetailsTicket(ticket, DetailsTicket.saveA | DetailsTicket.saveX, 0);
		
		if (sourceY.getSize() >= 2)
		{
			assembly += whitespace + CompUtils.setA16;
			innerTicket.flags |= DetailsTicket.isA16Bit | DetailsTicket.isXY16Bit;
			assembly += whitespace + sourceY.prefaceAssembly(whitespace, 0, innerTicket) + "\n";
			assembly += whitespace + "LDA\t" + sourceY.apply(0, innerTicket) + "\n";
			assembly += whitespace + "BEQ\t:++\n";
			assembly += whitespace + "TAX\t\n";
		}
		else if (sourceY.getSize() == 1)
		{
			assembly += whitespace + CompUtils.setA8;
			innerTicket.flags &= ~(DetailsTicket.isA16Bit | DetailsTicket.isXY16Bit);
			assembly += whitespace + sourceY.prefaceAssembly(whitespace, 0, innerTicket) + "\n";
			assembly += whitespace + "LDA\t" + sourceY.apply(0, innerTicket) + "\n";
			assembly += whitespace + "BEQ\t:++\n";
			assembly += whitespace + "TAX\t\n";
		}
		
		assembly += whitespace.substring(1) + ":\n"; // A loop
		
		switch (operator)
		{
		case "<<":
			assembly += AssemblyUtils.bytewiseOperation(whitespace + AssemblyUtils.getWhitespace(CompConfig.indentSize), sourceX.getSize(), (Integer i, DetailsTicket ticket2) ->
			{
				return new String[]
				{
					sourceX.prefaceAssembly(whitespace, i, ticket2),
					"LDA\t" + sourceX.apply(i, ticket2),
					(i >= sourceX.getSize() - 2) ? "ASL" : "ROL",
					destSource.prefaceAssembly(whitespace, i, ticket2),
					"STA\t" + destSource.apply(i, ticket2),
				};
			});
			break;
		case ">>":
			assembly += AssemblyUtils.bytewiseOperation(whitespace + AssemblyUtils.getWhitespace(CompConfig.indentSize), sourceX.getSize(), (Integer i, DetailsTicket ticket2) -> 
			{return new String[]
				{
					sourceX.prefaceAssembly(whitespace, i, ticket2),
					"LDA\t" + sourceX.apply(i, ticket2),
					(i >= sourceX.getSize() - 2) ? "LSR" : "ROR",
					destSource.prefaceAssembly(whitespace, i, ticket2),
					"STA\t" + destSource.apply(i, ticket2),
				};
			}, true, true);
			break;
		}
		assembly += whitespace + AssemblyUtils.getWhitespace(CompConfig.indentSize) + "DEX\n";
		assembly += whitespace + AssemblyUtils.getWhitespace(CompConfig.indentSize) + "BNE\t:-\n";
		assembly += whitespace.substring(1) + ":\n"; // A loop
		
		assembly += ticket.restore(whitespace, DetailsTicket.saveA | DetailsTicket.saveX);
		return assembly;
	}
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY, DetailsTicket ticket) throws Exception
	{
		return getShift(whitespace, destSource, scratchManager, sourceX, operator, sourceY, ticket);
	}
}
