// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Additive_expressionContext;
import Grammar.C99.C99Parser.Multiplicative_expressionContext;
import C99Compiler.CompilerNodes.Definitions.PointerType;

public class AdditiveExpressionNode extends ArithmeticBinaryExpressionNode
<Additive_expressionContext, Multiplicative_expressionContext, Multiplicative_expressionContext, Additive_expressionContext>
{

	public AdditiveExpressionNode(ComponentNode<?> parent)
	{
		super(parent);
		lockToDestSize = true;
	}

	private AdditiveExpressionNode(String operator)
	{
		super(operator);
		lockToDestSize = true;
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
	public BaseExpressionNode<Additive_expressionContext> interpret(Additive_expressionContext node) throws Exception
	{
		BaseExpressionNode<Additive_expressionContext> n = super.interpret(node);
		if (n != this) return n;
		
		if (x.getType().isPointer()) // RHS must be multiplied by size of pointer base type
		{
			int size = ((PointerType) x.getType()).getType().getSize();
			if (size != 1)
			{
				int shiftAmount = (int) Math.floor(Math.log(size) / Math.log(2));
				if (shiftAmount % 1 == 0) // Is power of two
					y = new ShiftExpressionNode(this, "<<", y, new DummyExpressionNode(this, CompUtils.getSmallestType(shiftAmount), shiftAmount));
				else
					y = new MultiplicativeExpressionNode(this, "*", y, new DummyExpressionNode(this, CompUtils.getSmallestType(size), size));
			}
		}
		
		return this;
	}
	@Override public Type getType()
	{
		if (x.getType().isPointer()) return x.getType();
		else return super.getType();
	}
	
	@Override
	public CastContext getCastContext()
	{
		switch (operator)
		{
		case "+": return CastContext.additive;
		case "-": return CastContext.subtractive;
		default: return CastContext.additive;
		}
	}	
	
	@Override
	public Object getPropValue()
	{
		if (x.getPropPointer() != null)
		{
			int offset = (int) y.getPropLong();
			
			switch (operator)
			{
			case "+": return x.getPropPointer().addOffset(offset);
			case "-": return x.getPropPointer().addOffset(-offset);
			default: return null;
			}
		}
		else if (y.getPropPointer() != null)
		{
			int offset = (int) x.getPropLong();
			
			switch (operator)
			{
			case "+": return y.getPropPointer().addOffset(offset);
			case "-": return y.getPropPointer().addOffset(-offset);
			default: return null;
			}
		}
		else return super.getPropValue();
	}
	public static String getAdder(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, DetailsTicket ticket) throws Exception
	{
		return new AdditiveExpressionNode("+").getAssembly(whitespace, destSource, sourceX, sourceY, ticket);
	}
	public static String getIncrementer(String whitespace, OperandSource destSource, OperandSource sourceX, DetailsTicket ticket) throws Exception
	{
		OperandSource sourceY = new ConstantSource(1, sourceX.getSize());
		return getAdder(whitespace, destSource, sourceX, sourceY, ticket);
	}
	public static String getSubtractor(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, DetailsTicket ticket) throws Exception
	{
		return new AdditiveExpressionNode("-").getAssembly(whitespace, destSource, sourceX, sourceY, ticket);
	}
	public static String getDecrementer(String whitespace, OperandSource sourceX, DetailsTicket ticket) throws Exception
	{
		OperandSource sourceY = new ConstantSource(1, sourceX.getSize());
		return getSubtractor(whitespace, sourceX, sourceX, sourceY, ticket);
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
