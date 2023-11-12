// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Or_expressionContext;
import Grammar.C99.C99Parser.Xor_expressionContext;

public class OrExpressionNode extends BinaryExpressionNode
<Xor_expressionContext, Or_expressionContext, Xor_expressionContext, Or_expressionContext>
{

	public OrExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Xor_expressionContext> getC1Node(Or_expressionContext node) throws Exception
	{return new XOrExpressionNode(this).interpret(node.xor_expression());}

	@Override
	protected BaseExpressionNode<Or_expressionContext> getC2Node(Or_expressionContext node) throws Exception
	{return new OrExpressionNode(this).interpret(node.or_expression());}

	@Override
	protected BaseExpressionNode<Xor_expressionContext> getPCNode(Or_expressionContext node) throws Exception
	{return new XOrExpressionNode(this).interpret(node.xor_expression());}

	@Override
	public Object getPropValue()
	{
		Long a = x.getPropLong();
		Long b = y.getPropLong();
		return Long.valueOf(a | b);
	}
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY, DetailsTicket ticket) throws Exception
	{
		
		String assembly = "";
		assembly += ticket.save(whitespace, DetailsTicket.saveA);
		DetailsTicket innerTicket = new DetailsTicket(ticket);
		AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, DetailsTicket ticket2) ->
		{
			return new String[]
			{
				sourceX.prefaceAssembly(whitespace, i, ticket2),
				"LDA\t" + sourceX.apply(i, ticket2),
				sourceY.prefaceAssembly(whitespace, i, ticket2),
				"ORA\t" + sourceY.apply(i, ticket2),
				destSource.prefaceAssembly(whitespace, i, ticket2),
				"STA\t" + destSource.apply(i, ticket2),
			};
		}, innerTicket);
		assembly += ticket.restore(whitespace, DetailsTicket.saveA);
		return assembly;
	}
}
