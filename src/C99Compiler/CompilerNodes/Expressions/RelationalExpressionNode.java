// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import C99Compiler.CompConfig.DebugLevel;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.FileIO;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.Utils.ScratchManager.ScratchSource;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.OperandSources.ConstantByteSource;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Relational_expressionContext;
import Grammar.C99.C99Parser.Shift_expressionContext;

public class RelationalExpressionNode extends BranchingExpressionNode
<Relational_expressionContext, Shift_expressionContext, Shift_expressionContext, Relational_expressionContext>
{

	public RelationalExpressionNode(ComponentNode<?> parent) {super(parent);}
	public RelationalExpressionNode(ComponentNode<?> parent, String operator, BaseExpressionNode<?> x, BaseExpressionNode<?> y)
	{
		super(parent, operator, x, y);
	}
	
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
		case "<=": return Boolean.valueOf(a <= b);
		case ">": return Boolean.valueOf(a > b);
		case ">=": return Boolean.valueOf(a >= b);
		default: return null;
		}
	}
	private static String getComparison(String whitespace, String yesLabel, String noLabel, OperandSource sourceX, String operator, OperandSource sourceY, boolean isSigned, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		if (sourceX.isLiteral() && !sourceY.isLiteral()) switch (operator)
		{
			case "<": return getComparison(whitespace, yesLabel, noLabel, sourceY, ">=", sourceX, isSigned, scratchManager, ticket);
			case "<=": return getComparison(whitespace, yesLabel, noLabel, sourceY, ">", sourceX, isSigned, scratchManager, ticket);
			case ">": return getComparison(whitespace, yesLabel, noLabel, sourceY, "<=", sourceX, isSigned, scratchManager, ticket);
			case ">=": return getComparison(whitespace, yesLabel, noLabel, sourceY, "<", sourceX, isSigned, scratchManager, ticket);
		}
		switch (operator) // Let's always do variants of <
		{
		case ">": return getComparison(whitespace, noLabel, yesLabel,sourceX, "<=", sourceY, isSigned, scratchManager, ticket);
		case ">=": return getComparison(whitespace, noLabel, yesLabel, sourceX, "<", sourceY, isSigned, scratchManager, ticket);
		}

		String assembly = "";

		assembly += ticket.save(whitespace, DetailsTicket.saveA);
		DetailsTicket innerTicket = new DetailsTicket(ticket, 0, DetailsTicket.saveA);
		assembly += AssemblyUtils.setSignExtend(whitespace, sourceX, sourceY, innerTicket);
		ScratchSource tempSource = scratchManager.reserveScratchBlock(2);
		assembly += whitespace + "CLC\n";
		assembly += AssemblyUtils.bytewiseOperation(whitespace, Math.max(sourceX.getSize(), sourceY.getSize()), (Integer i, DetailsTicket ticket2) -> 
		{	
			List<String> lines = new LinkedList<String>();
			if (isSigned && i >= Math.max(sourceX.getSize(), sourceY.getSize()) - 2) // Are we signed and at the last byte of an odd-size number, i. e. in 8-bit mode?
			{
				String toXOR = ticket2.is16Bit() ? "#$8000" : "#$80"; // If so we have to invert MSB to deal w/ 2's complement stuff
				// Start at MSB
				if (sourceY.isLiteral())
				{
					String oldY = ((ConstantByteSource) sourceY).getBase(i, ticket2).substring(2);
					int yVal = Integer.valueOf(oldY, 16);
					String newY = "#$" + String.format("%0" + (ticket2.is16Bit() ? 4 : 2) + "x", yVal ^ (ticket2.is16Bit() ? 0x8000 : 0x80));
					lines.add(sourceX.getLDA(i, ticket2));	// Get X
					lines.add("EOR\t" + toXOR);				// Flip sign
					lines.add("CMP\t" + newY);				// Cmp X & Y?
				}
				else
				{
					lines.add(sourceY.getLDA(i, ticket2));							// Get Y
					lines.add("EOR\t" + toXOR);										// Flip sign
					lines.add(tempSource.getSTA(0, ticket2));
					lines.add(sourceX.getLDA(i, ticket2));							// Get X
					lines.add("EOR\t" + toXOR);										// Flip sign
					lines.add(tempSource.getInstruction("CMP", 0, ticket2));		// Cmp Y & X?
				}
			}
			else
			{
				lines.add(sourceX.getLDA(i, ticket2)); 					// Get X
				lines.add(sourceY.getInstruction("CMP", i, ticket2));	// Cmp X & Y?
			}
			lines.add("BCC\t:+");									// Done this way to enable med-jumps
			lines.add("BRA:++");
			lines.add(":JMP\t" + yesLabel);								// If x < y then yes
			lines.add(":BEQ\t:+");
			lines.add("JMP\t" + noLabel);							// If x >= y then no
			lines.add(":");
			// else maybe
			return lines.toArray(new String[] {});
		}, true, true);
		// The above actually always checks for "<". This is due to the behavior of the carry flag, it being set when the two words are equal.
		switch (operator)
		{
		case "<":
			assembly += whitespace + "JMP\t" + noLabel + "\n"; // If equal, false
			break;
		case "<=":
			assembly += whitespace + "JMP\t" + yesLabel + "\n"; // If equal, true
			break;
		}
		ScratchManager.releasePointer(tempSource);
		
		assembly += ticket.restore(whitespace, DetailsTicket.saveA);
		
		return assembly;
	}
	@Override
	protected String getAssembly(String whitespace, String yesLabel, String noLabel, OperandSource sourceX, OperandSource sourceY, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		boolean isSigned = x.getType().isSigned() || y.getType().isSigned();
		return getComparison(whitespace, yesLabel, noLabel, sourceX, operator, sourceY, isSigned, scratchManager, ticket);
	}
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		String uuid = CompUtils.getSafeUUID();
		String yesLabel = "__CMP_YES_" + uuid, noLabel = "__CMP_NO_" + uuid, endLabel = "__CMP_END_" + uuid;
		String assembly = "";
		assembly += whitespace + getAssembly(whitespace, yesLabel, noLabel, sourceX, sourceY, scratchManager, ticket);
		
		assembly += whitespace + yesLabel + ":\n";
		assembly += AssemblyUtils.byteCopier(whitespace, destSource.getSize(), destSource, new ConstantSource(1, destSource.getSize()));
		assembly += whitespace + "BRA\t" + endLabel + "\n";
		
		assembly += whitespace + noLabel + ":\n";
		assembly += AssemblyUtils.byteCopier(whitespace, destSource.getSize(), destSource, new ConstantSource(0, destSource.getSize()));
		
		assembly += whitespace + endLabel + ":\n";
		return assembly;
	}

	
}