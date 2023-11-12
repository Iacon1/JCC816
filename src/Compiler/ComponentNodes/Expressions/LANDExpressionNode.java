// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.CompUtils;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Land_expressionContext;
import Grammar.C99.C99Parser.Or_expressionContext;

public class LANDExpressionNode extends BinaryExpressionNode
<Or_expressionContext, Land_expressionContext, Or_expressionContext, Land_expressionContext>
{

	public LANDExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Or_expressionContext> getC1Node(Land_expressionContext node) throws Exception
	{return new OrExpressionNode(this).interpret(node.or_expression());}

	@Override
	protected BaseExpressionNode<Land_expressionContext> getC2Node(Land_expressionContext node) throws Exception
	{return new LANDExpressionNode(this).interpret(node.land_expression());}

	@Override
	protected BaseExpressionNode<Or_expressionContext> getPCNode(Land_expressionContext node) throws Exception
	{return new OrExpressionNode(this).interpret(node.or_expression());}

	@Override
	public Object getPropValue()
	{
		boolean a = x.getPropBool();
		boolean b = y.getPropBool();
		return a && b;
	}
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY, DetailsTicket ticket) throws Exception
	{
		String assembly = "";
		assembly += ticket.save(whitespace, DetailsTicket.saveA | DetailsTicket.saveX);
		DetailsTicket innerTicket = new DetailsTicket(ticket, DetailsTicket.saveX, DetailsTicket.saveA); // All of our uses of A are LDA so it's fine
		assembly += whitespace + "LDX\t#$01\n";
		assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, DetailsTicket ticket2) ->
		{
			return new String[]
			{
				sourceX.prefaceAssembly(whitespace, i, ticket2),
				"LDA\t" + sourceX.apply(i, ticket2),
				sourceY.prefaceAssembly(whitespace, i, ticket2),
				"BIT\t" + sourceY.apply(i, ticket2),
				"BNE\t:+",
			};
		}, innerTicket);
		assembly += whitespace + "DEX\n";
		assembly += ":" + whitespace.substring(1) + "TXA\n";
		assembly += whitespace + CompUtils.setA8 + "\n";
		assembly += whitespace + destSource.prefaceAssembly(whitespace, 0, innerTicket);
		assembly += whitespace + "STA\t" + destSource.apply(0, innerTicket);
		assembly += whitespace + ticket.restore(whitespace, DetailsTicket.saveA | DetailsTicket.saveX);
		return assembly;
	}
}
