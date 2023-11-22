// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import java.util.LinkedList;
import java.util.List;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.Dummies.DummyType;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.CompUtils;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Equality_expressionContext;
import Grammar.C99.C99Parser.Relational_expressionContext;

public class EqualityExpressionNode extends BinaryExpressionNode
<Equality_expressionContext, Relational_expressionContext, Relational_expressionContext, Equality_expressionContext>
{

	public EqualityExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Equality_expressionContext> getC1Node(Equality_expressionContext node) throws Exception
	{return new EqualityExpressionNode(this).interpret(node.equality_expression());}

	@Override
	protected BaseExpressionNode<Relational_expressionContext> getC2Node(Equality_expressionContext node) throws Exception
	{return new RelationalExpressionNode(this).interpret(node.relational_expression());}

	@Override
	protected BaseExpressionNode<Relational_expressionContext> getPCNode(Equality_expressionContext node) throws Exception
	{return new RelationalExpressionNode(this).interpret(node.relational_expression());}

	@Override
	public Type getType()
	{
		return new DummyType("char");
	}
	@Override
	public Object getPropValue()
	{
		switch (operator)
		{
		case "==":
			return x.getPropValue().equals(y.getPropValue());
		case "!=":
			return x.getPropValue().equals(y.getPropValue());
		default: return null;
		}
	}
	
	public static String getIsZero(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource source, DetailsTicket ticket)
	{
		String assembly = "";
		assembly += whitespace + "LDA\t" + ((ticket.flags & DetailsTicket.isA16Bit) != 0 ? "#$00" : "#$00") + "\n";
		assembly += AssemblyUtils.bytewiseOperation(whitespace, source.getSize(), (Integer i, DetailsTicket ticket2) -> {return new String[]{source.getInstruction("ORA", i, ticket2)};});
		if (destSource != null) assembly += destSource.getSTA(whitespace, 0, ticket);
		return assembly;
	}
	
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		String assembly = "";

		assembly += whitespace + CompUtils.setXY8 + "\n";
		assembly += ticket.save(whitespace, DetailsTicket.saveA | DetailsTicket.saveX);
		if (operator.equals("==")) assembly += whitespace + "LDX\t#$00\n";
		else if (operator.equals("!=")) assembly += whitespace + "LDX\t#$01\n";
		DetailsTicket innerTicket = new DetailsTicket(ticket, DetailsTicket.saveX, DetailsTicket.saveA);
		assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, DetailsTicket ticket2) -> 
		{	
			List<String> lines = new LinkedList<String>();
			lines.add(sourceX.getLDA(i, ticket2));	// Get X
			lines.add(sourceY.getInstruction("CMP", i, ticket2)); // Cmp X & Y?
			lines.add("BNE\t:+");							// if [not op] then no
			// else maybe
			return lines.toArray(new String[] {});
		}, innerTicket);
		if (operator.equals("==")) assembly += whitespace + "INX\n";
		else if (operator.equals("!=")) assembly += whitespace + "DEX\n";
		assembly += ":" + whitespace.substring(1) + "TXA\n";
		assembly += whitespace + CompUtils.setA8 + "\n";
		if (destSource != null) assembly += destSource.getSTA(whitespace, 0, ticket);
		assembly += ticket.restore(whitespace, DetailsTicket.saveA | DetailsTicket.saveX);
		
		return assembly;
	}
}
