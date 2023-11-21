// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.ConstantSource;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Additive_expressionContext;
import Grammar.C99.C99Parser.Multiplicative_expressionContext;

public class AdditiveExpressionNode extends ArithmeticBinaryExpressionNode
<Additive_expressionContext, Multiplicative_expressionContext, Multiplicative_expressionContext, Additive_expressionContext>
{

	public AdditiveExpressionNode(ComponentNode<?> parent) {super(parent);}

	private AdditiveExpressionNode(String operator)
	{
		super(operator);
	}

	@Override
	protected BaseExpressionNode<Additive_expressionContext> getC1Node(Additive_expressionContext node) throws Exception
	{return new AdditiveExpressionNode(this).interpret(node.additive_expression());}

	@Override
	protected BaseExpressionNode<Multiplicative_expressionContext> getC2Node(Additive_expressionContext node) throws Exception
	{return new MultiplicativeExpressionNode(this).interpret(node.multiplicative_expression());}

	@Override
	protected BaseExpressionNode<Multiplicative_expressionContext> getPCNode(Additive_expressionContext node) throws Exception
	{return new MultiplicativeExpressionNode(this).interpret(node.multiplicative_expression());}

	@Override
	public Object getPropValue()
	{
		if (x.getPropPointer() != null)
		{
			Long b = y.getPropLong();
			switch (operator)
			{
			case "+": return x.getPropPointer().addOffset(b.intValue());
			case "-": return x.getPropPointer().addOffset(-b.intValue());
			default: return null;
			}
		}
		else if (y.getPropPointer() != null)
		{
			Long a = x.getPropLong();
			switch (operator)
			{
			case "+": return x.getPropPointer().addOffset(a.intValue());
			case "-": return x.getPropPointer().addOffset(-a.intValue());
			default: return null;
			}
		}
		else return super.getPropValue();
	}
	public static String getAdder(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, DetailsTicket ticket)
	{
		return new AdditiveExpressionNode("+").getAssembly(whitespace, destSource, sourceX, sourceY, ticket);
	}
	public static String getIncrementer(String whitespace, OperandSource destSource, OperandSource sourceX, DetailsTicket ticket)
	{
		OperandSource sourceY = new ConstantSource(1, sourceX.getSize());
		return getAdder(whitespace, destSource, sourceX, sourceY, ticket);
	}
	public static String getSubtractor(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, DetailsTicket ticket)
	{
		return new AdditiveExpressionNode("-").getAssembly(whitespace, destSource, sourceX, sourceY, ticket);
	}
	public static String getDecrementer(String whitespace, OperandSource source, DetailsTicket ticket)
	{
		String assembly = "";
		assembly += ticket.save(whitespace, DetailsTicket.saveA);
		DetailsTicket innerTicket = new DetailsTicket(ticket, DetailsTicket.saveA, 0);
		
		if (source.getSize() >= 2)
		{
			assembly += source.getInstruction(whitespace, "DEC", source.getSize() - 2, innerTicket);
			if (source.getSize() > 2)
			{
				assembly = whitespace + "SEC\n";
				assembly += whitespace + AssemblyUtils.bytewiseOperation(whitespace, source.getSize() - 2, (Integer i, DetailsTicket ticket2) -> 
				{return new String[]
					{
						source.getLDA(i + 1, ticket2),
						"SBC\t" + (ticket2.is16Bit() ? "#$0000" : "#$00"),
						source.getSTA(i + 1, ticket2),
					};
				}, true, true, innerTicket);
			}
		}
		else
			assembly += whitespace + source.getLDA(whitespace, source.getSize() - 1, ticket) + "\n";
		
		assembly += ticket.restore(whitespace, DetailsTicket.saveA);	
		return assembly;
	}

	@Override
	public long doOperation(long x, long y)
	{
		switch (operator)
		{
		case "+":
			return x + y;
		case "-":
			return x - y;
		default: return 0;
		}
	}

	@Override
	public String getPreface()
	{
		switch (operator)
		{
		case "+":
			return "CLC";
		case "-":
			return "SEC";
		default: return null;
		}
	}

	@Override
	public String getInstruction()
	{
		switch (operator)
		{
		case "+":
			return "ADC";
		case "-":
			return "SBC";
		default: return null;
		}
	}

	@Override
	public boolean isReversed()
	{
		switch (operator)
		{
		case "+":
			return false;
		case "-":
			return true;
		default: return false;
		}
	}
}
