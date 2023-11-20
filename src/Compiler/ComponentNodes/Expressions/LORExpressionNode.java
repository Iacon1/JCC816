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
import Grammar.C99.C99Parser.Lor_expressionContext;

public class LORExpressionNode extends BinaryExpressionNode
<Lor_expressionContext, Land_expressionContext, Land_expressionContext, Lor_expressionContext>
{

	public LORExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Lor_expressionContext> getC1Node(Lor_expressionContext node) throws Exception
	{return new LORExpressionNode(this).interpret(node.lor_expression());}
	
	@Override
	protected BaseExpressionNode<Land_expressionContext> getC2Node(Lor_expressionContext node) throws Exception
	{return new LANDExpressionNode(this).interpret(node.land_expression());}

	@Override
	protected BaseExpressionNode<Land_expressionContext> getPCNode(Lor_expressionContext node) throws Exception
	{return new LANDExpressionNode(this).interpret(node.land_expression());}

	@Override
	public Object getPropValue()
	{
		boolean a = x.getPropBool();
		boolean b = y.getPropBool();
		return a || b;
	}
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY, DetailsTicket ticket) throws Exception
	{
		String assembly = "";
		assembly += ticket.save(whitespace, DetailsTicket.saveA | DetailsTicket.saveX);
		assembly += whitespace + CompUtils.setXY8 + "\n";
		if (operator.equals("==")) assembly += whitespace + "LDX\t#$00\n";
		else if (operator.equals("!=")) assembly += whitespace + "LDX\t#$01\n";
		DetailsTicket innerTicket = new DetailsTicket(ticket, DetailsTicket.saveX, DetailsTicket.saveA); // All of our uses of A are LDA so it's fine
		assembly += whitespace + "LDX\t#$01\n";
		assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, DetailsTicket ticket2) ->
		{
			return new String[]
			{
				sourceX.getLDA(i, ticket2),
				sourceY.getInstruction("ORA", i, ticket2),
				"BNE\t:+",
			};
		}, ticket);
		assembly += whitespace + "DEX\n";
		assembly += ":" + whitespace.substring(1) + "TXA\n";
		assembly += whitespace + CompUtils.setA8 + "\n";
		assembly += destSource.getSTA(whitespace, 0, innerTicket);
		assembly += ticket.restore(whitespace, DetailsTicket.saveA | DetailsTicket.saveX);
		return assembly;
	}
}
