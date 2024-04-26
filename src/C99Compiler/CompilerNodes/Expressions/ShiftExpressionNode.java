// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import C99Compiler.Utils.ScratchManager.ScratchSource;
import Grammar.C99.C99Parser.Additive_expressionContext;
import Grammar.C99.C99Parser.Or_expressionContext;
import Grammar.C99.C99Parser.Shift_expressionContext;
import Grammar.C99.C99Parser.Xor_expressionContext;

public class ShiftExpressionNode extends BinaryExpressionNode
<Shift_expressionContext, Additive_expressionContext, Additive_expressionContext, Shift_expressionContext>
{

	public ShiftExpressionNode(ComponentNode<?> parent) {super(parent);}
	public ShiftExpressionNode(ComponentNode<?> parent, String operator, BaseExpressionNode<?> x, BaseExpressionNode<?> y)
	{
		super(parent, operator, x, y);
	}
	@Override
	protected BaseExpressionNode<Shift_expressionContext> getC1Node(Shift_expressionContext node) throws Exception
	{return new ShiftExpressionNode(this).interpret(node.shift_expression());}

	@Override
	protected BaseExpressionNode<Additive_expressionContext> getC2Node(Shift_expressionContext node) throws Exception
	{return new AdditiveExpressionNode(this).interpret(node.additive_expression());}

	@Override
	protected BaseExpressionNode<Additive_expressionContext> getPCNode(Shift_expressionContext node) throws Exception
	{return new AdditiveExpressionNode(this).interpret(node.additive_expression());}

	@Override public CastContext getCastContext() {return CastContext.bitwise;}
	@Override public Type getType()
	{
		return x.getType().promote();
	}
	
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
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		String assembly = "";
		assembly += ticket.save(whitespace, DetailsTicket.saveA | DetailsTicket.saveX);
		DetailsTicket innerTicket = new DetailsTicket(ticket, DetailsTicket.saveA | DetailsTicket.saveX, 0);
		boolean isOne = y.hasPropValue() && (y.getPropLong() == 1); // No need for loop w/ only one iteration
		if (sourceX.getSize() < destSource.getSize() && x.getType().isSigned())
		{
			assembly += AssemblyUtils.setSignExtend(whitespace, destSource, sourceX, true, true, innerTicket);
		}
		
		if (y.hasPropValue() && y.getPropLong() != 0 && ((y.getPropLong() % 8) == 0)) // Even better optimization LOL
		{
			int bytesShifted = (int) y.getPropLong() / 8;
			int bytesFilled = 0;
			switch (operator)
			{
			case "<<": // Fill bottom bytes of destSource w/ 0, then put x in
				bytesFilled = Math.max(0, destSource.getSize() - bytesShifted);
				assembly += AssemblyUtils.byteCopier(whitespace, bytesShifted, destSource, new ConstantSource(0, bytesShifted));
				assembly += AssemblyUtils.byteCopier(whitespace, bytesFilled, destSource.getShifted(bytesShifted), sourceX);
				assembly += ticket.restore(whitespace, DetailsTicket.saveA | DetailsTicket.saveX);
				return assembly;
			case ">>": // Fill bottom bytes of destSource with shifted x, then fill w/ zero
				bytesFilled = Math.min(destSource.getSize(), Math.max(0, sourceX.getSize() - bytesShifted));
				assembly += AssemblyUtils.byteCopier(whitespace, bytesFilled, destSource, sourceX.getShifted(bytesShifted));
				if (bytesFilled < destSource.getSize())
					assembly += AssemblyUtils.byteCopier(whitespace, bytesShifted, destSource.getShifted(bytesFilled), new ConstantSource(0, bytesShifted));
				assembly += ticket.restore(whitespace, DetailsTicket.saveA | DetailsTicket.saveX);
				return assembly;
			}
			
		}
		if (sourceY.getSize() >= 2)
		{
			assembly += whitespace + CompUtils.setA16 + "\n";
			innerTicket.flags |= DetailsTicket.isA16Bit | DetailsTicket.isXY16Bit;
		}
		else if (sourceY.getSize() == 1)
		{
			assembly += whitespace + CompUtils.setA8 + "\n";
			innerTicket.flags &= ~(DetailsTicket.isA16Bit | DetailsTicket.isXY16Bit);
		}
		
		// Use destination as buffer if able to
		OperandSource tempSource = (destSource != null && destSource.getSize() >= sourceX.getSize()) ? destSource : scratchManager.reserveScratchBlock(sourceX.getSize());
		assembly += AssemblyUtils.byteCopier(whitespace, tempSource.getSize(), tempSource, sourceX);
		
		if (!isOne)
		{
			assembly += sourceY.getLDA(whitespace, 0, innerTicket) + "\n";
			assembly += whitespace + "BEQ\t:++\n";
			assembly += whitespace + "TAX\t\n";
			assembly += whitespace.substring(1) + ":\n"; // A loop
			switch (operator)
			{
			case "<<":
				assembly += AssemblyUtils.bytewiseOperation(whitespace + AssemblyUtils.getWhitespace(CompConfig.indentSize), tempSource.getSize(), (Integer i, DetailsTicket ticket2) ->
				{
					return new String[]
					{
							tempSource.getLDA(i, ticket2),
							(tempSource.getSize() > 2 && i >= tempSource.getSize() - 2) ? "ROL" :"ASL",
							tempSource.getSTA(i, ticket2),
					};
				});
				break;
			case ">>":
				if (getType().isSigned())
					assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, DetailsTicket ticket2) -> 
					{
						return new String[]
						{
							tempSource.getLDA(i, ticket2),
							(ticket2.is16Bit()) ? "CMP\t#$8000" : "CMP\t#$80",
							"ROR",
							tempSource.getSTA(i, ticket2),
						};					
					}, true, true);
				else
					assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, DetailsTicket ticket2) -> 
					{
						return new String[]
						{
							tempSource.getLDA(i, ticket2),
							(i >= sourceX.getSize() - 2) ? "LSR" : "ROR",
							tempSource.getSTA(i, ticket2),
						};					
					}, true, true);
				break;
			}
			assembly += whitespace + AssemblyUtils.getWhitespace(CompConfig.indentSize) + "DEX\n";
			assembly += whitespace + AssemblyUtils.getWhitespace(CompConfig.indentSize) + "BNE\t:-\n";
			assembly += whitespace.substring(1) + ":\n"; // A loop
		}
		else // Only a shift by one
		{				
			switch (operator)
			{
			case "<<":
				assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, DetailsTicket ticket2) ->
				{
					return new String[]
					{
							sourceX.getLDA(i, ticket2),
							(tempSource.getSize() > 2 &&  i >= sourceX.getSize() - 2) ? "ROL" : "ASL",
							tempSource.getSTA(i, ticket2),
					};
				});
				break;
			case ">>":
				if (getType().isSigned())
					assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, DetailsTicket ticket2) -> 
					{
						return new String[]
						{
							sourceX.getLDA(i, ticket2),
							(ticket2.is16Bit()) ? "CMP\t#$8000" : "CMP\t#$80",
							"ROR",
							tempSource.getSTA(i, ticket2),
						};					
					}, true, true);
				else
					assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, DetailsTicket ticket2) -> 
					{
						return new String[]
						{
							sourceX.getLDA(i, ticket2),
							(i >= sourceX.getSize() - 2) ? "LSR" : "ROR",
							tempSource.getSTA(i, ticket2),
						};					
					}, true, true);
				break;
			}
		}
		if (destSource != null && destSource != tempSource)
		{
			assembly += AssemblyUtils.byteCopier(whitespace, destSource.getSize(), destSource, tempSource);
			scratchManager.releaseScratchBlock((ScratchSource) tempSource);
		}
		assembly += ticket.restore(whitespace, DetailsTicket.saveA | DetailsTicket.saveX);
		
		return assembly;
	}
}
