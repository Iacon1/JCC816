// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import java.util.LinkedList;
import java.util.List;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.CompilerNodes.Dummies.DummyType;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
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
	
	@Override public CastContext getCastContext() {return CastContext.equality;}
	
	/** Gets whether the input source is zero.
	 * If destSource is null the result is placed in the CPU's zero flag, otherwise it's placed in destSource.
	 * Note that this means the result of bne or beq will depend on whether destSource is null!
	 * @param whitespace
	 * @param destSource
	 * @param scratchManager
	 * @param source
	 * @param ticket
	 * @return
	 */
	public static String getIsZero(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource source, DetailsTicket ticket)
	{
		String assembly = "";
		int offset = 0;
		
		if (source.getSize() == 1)
		{
			DetailsTicket ticket2 = new DetailsTicket(ticket, 0, DetailsTicket.isA16Bit);
			assembly += whitespace + CompUtils.setA8 + "\n";
			assembly += source.getLDA(whitespace, 0, ticket2);
		}
		else
		{
			DetailsTicket ticket2 = new DetailsTicket(ticket, DetailsTicket.isA16Bit, 0);
			assembly += whitespace + CompUtils.setA16 + "\n";
			assembly += source.getLDA(whitespace, 0, ticket2);
			if (source.getSize() > 2)
				assembly += AssemblyUtils.bytewiseOperation(whitespace, source.getSize() - 2, (Integer i, DetailsTicket ticket3) -> {return new String[]{source.getInstruction("ORA", i + 2, ticket3)};});
		}
		if (destSource != null)
		{
			assembly += whitespace + "BEQ\t:+\n";
			assembly += AssemblyUtils.byteCopier(whitespace, destSource.getSize(), destSource, new ConstantSource(0, destSource.getSize()));
			assembly += whitespace + "BRA\t:++\n";
			assembly += whitespace + ":\n";
			assembly += AssemblyUtils.byteCopier(whitespace, destSource.getSize(), destSource, new ConstantSource(1, destSource.getSize()));
			assembly += whitespace + ":\n";
		}
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
