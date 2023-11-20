// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import java.util.LinkedList;
import java.util.List;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompUtils;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Relational_expressionContext;
import Grammar.C99.C99Parser.Shift_expressionContext;

public class RelationalExpressionNode extends BinaryExpressionNode
<Relational_expressionContext, Shift_expressionContext, Shift_expressionContext, Relational_expressionContext>
{

	public RelationalExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Relational_expressionContext> getC1Node(Relational_expressionContext node) throws Exception
	{return new RelationalExpressionNode(this).interpret(node.relational_expression());}

	@Override
	protected BaseExpressionNode<Shift_expressionContext> getC2Node(Relational_expressionContext node) throws Exception
	{return new ShiftExpressionNode(this).interpret(node.shift_expression());}

	@Override
	protected BaseExpressionNode<Shift_expressionContext> getPCNode(Relational_expressionContext node) throws Exception
	{return new ShiftExpressionNode(this).interpret(node.shift_expression());}

	@Override
	public Object getPropValue()
	{
		Long a = x.getPropLong();
		Long b = y.getPropLong();
		switch (operator)
		{
		case "<": return Boolean.valueOf(a < b);
		case "<=": return Boolean.valueOf(a < b);
		case ">": return Boolean.valueOf(a < b);
		case ">=": return Boolean.valueOf(a < b);
		default: return null;
		}
	}
	public static String getComparison(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, String operator, OperandSource sourceY, DetailsTicket ticket)
	{
		if (sourceX.isLiteral() && !sourceY.isLiteral()) switch (operator)
		{
			case "<": return getComparison(whitespace, destSource, scratchManager, sourceY, ">=", sourceX, ticket);
			case "<=": return getComparison(whitespace, destSource, scratchManager, sourceY, ">", sourceX, ticket);
			case ">": return getComparison(whitespace, destSource, scratchManager, sourceY, "<=", sourceX, ticket);
			case ">=": return getComparison(whitespace, destSource, scratchManager, sourceY, "<", sourceX, ticket);
		}

		String assembly = "";

		assembly += ticket.save(whitespace, DetailsTicket.saveA | DetailsTicket.saveX);
		
		DetailsTicket innerTicket = new DetailsTicket(ticket, DetailsTicket.saveX, DetailsTicket.saveA);
		assembly += whitespace + CompUtils.setXY8 + "\n";
		assembly += whitespace + "LDX\t#$00\n";
		assembly += whitespace + "CLC\n";
		assembly += AssemblyUtils.bytewiseOperation(whitespace, Math.max(sourceX.getSize(), sourceY.getSize()), (Integer i, DetailsTicket ticket2) -> 
		{	
			List<String> lines = new LinkedList<String>();
			if (i >= Math.max(sourceX.getSize(), sourceY.getSize()) - 2)
			{
				// Are we at the last byte of an odd-size number, i. e. in 8-bit mode?
				String toXOR = (i < Math.max(sourceX.getSize(), sourceY.getSize()) - 1) ? "#$8000" : "#$80";
				// Start at MSB
				if (sourceY.isLiteral())
				{
					String oldY = sourceY.getBase().substring(2);
					int yVal = Integer.valueOf(oldY, 16);
					String newY = "#$" + String.format("%0" + (ticket2.is16Bit() ? 4 : 0) + "x", yVal ^ (ticket2.is16Bit() ? 0x8000 : 0x80));
					lines.add(sourceX.getLDA(i, ticket2));	// Get X
					lines.add("EOR\t" + toXOR);				// Flip sign
					lines.add("CMP\t" + newY);				// Cmp X & Y?
				}
				else
				{
					lines.add(sourceY.getLDA(i, ticket2));							// Get Y
					lines.add("EOR\t" + toXOR);										// Flip sign
					if (destSource != null)
						lines.add(destSource.getSTA(0, ticket2));
					lines.add(sourceX.getLDA(i, ticket2));							// Get X
					lines.add("EOR\t" + toXOR);										// Flip sign
					if (destSource != null)
						lines.add(destSource.getInstruction("CMP", 0, ticket2));	// Cmp Y & X?
				}
			}
			else
			{
				lines.add(sourceX.getLDA(i, ticket2)); 					// Get X
				lines.add(sourceY.getInstruction("CMP", i, ticket2));	// Cmp X & Y?
			}
			lines.add("BCC\t:+");													// If x < y then yes
			lines.add("BNE\t:++");													// If x >= y then no
			// else maybe
			return lines.toArray(new String[] {});
		}, true, true);
		// The above actually always checks for "<". This is due to the behavior of the carry flag, it being set when the two words are equal.
		switch (operator)
		{
		case "<":
			assembly += whitespace + "DEX\n"; // If equal, false
		case "<=":
			assembly += ":" + whitespace.substring(1) + "INX\n"; // True
			assembly += ":" + whitespace.substring(1) + "TXA\n"; // Default (false)
			break;
		case ">": // Opposite of <=
			assembly += whitespace + "DEX\n"; // If equal, false
		case ">=": // Opposite of <
			assembly += whitespace + "BRA\t:++\n";
			assembly += ":" + whitespace.substring(1) + "INX\n"; // True
			assembly += ":" + whitespace.substring(1) + "TXA\n"; // Default (false)
			assembly += whitespace + "EOR\t#1\n";				 // Reverse answer!
			break;
		}
		
		assembly += whitespace + CompUtils.setA8 + "\n";
		if (destSource != null) assembly += destSource.getSTA(whitespace, 0, innerTicket);
		
		assembly += ticket.restore(whitespace, DetailsTicket.saveA | DetailsTicket.saveX);
		
		return assembly;
	}
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY, DetailsTicket ticket) throws Exception
	{
		return getComparison(whitespace, destSource, scratchManager, sourceX, operator, sourceY, ticket);
	}
}