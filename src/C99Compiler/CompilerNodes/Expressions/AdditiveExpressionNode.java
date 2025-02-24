// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import Grammar.C99.C99Parser.Additive_expressionContext;
import Grammar.C99.C99Parser.Multiplicative_expressionContext;
import C99Compiler.CompilerNodes.Definitions.ArrayType;
import C99Compiler.CompilerNodes.Definitions.PointerType;

public class AdditiveExpressionNode extends ArithmeticBinaryExpressionNode
<Additive_expressionContext, Multiplicative_expressionContext, Multiplicative_expressionContext, Additive_expressionContext>
{	
	public AdditiveExpressionNode(ComponentNode<?> parent)
	{
		super(parent);
		lockToDestSize = true;
	}
	public AdditiveExpressionNode(ComponentNode<?> parent, String operator, BaseExpressionNode<?> x, BaseExpressionNode<?> y)
	{
		super(parent, operator, x, y);
		if (x.getType().isPointer()) // RHS must be multiplied by size of pointer base type
		{
			int size = ((PointerType) x.getType()).getType().getSize();
			if (x.getType().isArray())
				this.x = new CastExpressionNode(this, new PointerType(((ArrayType) x.getType()).getType()), x);
			if (size != 1)
			{
				Type t = CompUtils.getSmallestType(size);
				if (y.getSize() + t.getSize() < CompConfig.pointerSize)
					y = new CastExpressionNode(this, CompUtils.getTypeForSize(CompConfig.pointerSize - t.getSize(), y.getType().isSigned()), y);
				this.y = new MultiplicativeExpressionNode(this, "*", y, new DummyExpressionNode(this, t, size));
			}
		}
		
		lockToDestSize = true;
	}

	public AdditiveExpressionNode(String operator, BaseExpressionNode<?> x, BaseExpressionNode<?> y)
	{
		super(null, operator, x, y);
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
			if (x.getType().isArray())
				x = new CastExpressionNode(this, new PointerType(((ArrayType) x.getType()).getType()), x);
			int size = ((PointerType) x.getType()).getType().getSize();
			if (size != 1)
				y = new MultiplicativeExpressionNode(this, "*", y, new DummyExpressionNode(this, CompUtils.getSmallestType(size), size));
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
	public Object getPropValue(ProgramState state)
	{
		if (x.getPropPointer(state) != null)
		{
			int offset = (int) y.getPropLong(state);
			
			switch (operator)
			{
			case "+": return x.getPropPointer(state).addOffset(offset);
			case "-": return x.getPropPointer(state).addOffset(-offset);
			default: return null;
			}
		}
		else if (y.getPropPointer(state) != null)
		{
			int offset = (int) x.getPropLong(state);
			
			switch (operator)
			{
			case "+": return y.getPropPointer(state).addOffset(offset);
			case "-": return y.getPropPointer(state).addOffset(-offset);
			default: return null;
			}
		}
		else return super.getPropValue(state);
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
