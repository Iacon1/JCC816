// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Land_expressionContext;
import Grammar.C99.C99Parser.Or_expressionContext;

public class LANDExpressionNode extends LogicalBinaryExpressionNode
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

	@Override public CastContext getCastContext() {return CastContext.logical;}
	
	@Override
	public Object getPropValue()
	{
		boolean a = x.getPropBool();
		boolean b = y.getPropBool();
		return a && b;
	}
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		String assembly = "";
		assembly += ticket.save(whitespace, DetailsTicket.saveA | DetailsTicket.saveX);
		DetailsTicket innerTicket = new DetailsTicket(ticket, DetailsTicket.saveX, DetailsTicket.saveA); // All of our uses of A are LDA so it's fine
		assembly += whitespace + "LDX\t#$01\n";
		assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, DetailsTicket ticket2) ->
		{
			return new String[]
			{
				sourceX.getLDA(i, ticket2),
				sourceY.getInstruction("AND", i, ticket2),
				"BNE\t:+",
			};
		}, innerTicket);
		assembly += whitespace + "DEX\n";
		assembly += ":" + whitespace.substring(1) + "TXA\n";
		assembly += whitespace + CompUtils.setA8 + "\n";
		assembly += destSource.getSTA(whitespace, 0, innerTicket);
		assembly += whitespace + ticket.restore(whitespace, DetailsTicket.saveA | DetailsTicket.saveX);
		return assembly;
	}
}
