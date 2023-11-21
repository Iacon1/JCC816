// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.And_expressionContext;
import Grammar.C99.C99Parser.Equality_expressionContext;

public class AndExpressionNode extends BinaryExpressionNode
<Equality_expressionContext, And_expressionContext, Equality_expressionContext, And_expressionContext>
{

	public AndExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Equality_expressionContext> getC1Node(And_expressionContext node) throws Exception
	{return new EqualityExpressionNode(this).interpret(node.equality_expression());}

	@Override
	protected BaseExpressionNode<And_expressionContext> getC2Node(And_expressionContext node) throws Exception
	{return new AndExpressionNode(this).interpret(node.and_expression());}

	@Override
	protected BaseExpressionNode<Equality_expressionContext> getPCNode(And_expressionContext node) throws Exception
	{return new EqualityExpressionNode(this).interpret(node.equality_expression());}

	@Override
	public Object getPropValue()
	{
		Long a = x.getPropLong();
		Long b = y.getPropLong();
		return Long.valueOf(a & b);
	}
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		String assembly = "";
		assembly += ticket.save(whitespace, DetailsTicket.saveA);
		DetailsTicket innerTicket = new DetailsTicket(ticket, DetailsTicket.saveA, 0);
		
		assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, DetailsTicket ticket2) ->
		{
			return new String[]
			{
				sourceX.getLDA(i, ticket2),
				sourceY.getInstruction("AND", i, ticket2),
				destSource.getSTA(i, ticket2),
			};
		}, innerTicket);
		
		assembly += ticket.restore(whitespace, DetailsTicket.saveA);
		return assembly;
	}
}
