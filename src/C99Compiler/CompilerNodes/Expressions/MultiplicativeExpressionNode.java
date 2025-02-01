// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompConfig;
import C99Compiler.CompConfig.OptimizationLevel;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.CompilerNodes.Expressions.Snippets.DivisionMultiplicationFooter;
import C99Compiler.CompilerNodes.Expressions.Snippets.DivisionMultiplicationHeader;
import C99Compiler.CompilerNodes.Expressions.Snippets.LongDividerModulator;
import C99Compiler.CompilerNodes.Expressions.Snippets.Multiplier;
import C99Compiler.CompilerNodes.Expressions.Snippets.ShortDividerModulator;
import C99Compiler.CompilerNodes.Interfaces.Assemblable;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.Exceptions.UnsupportedFeatureException;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Cast_expressionContext;
import Grammar.C99.C99Parser.Multiplicative_expressionContext;

public class MultiplicativeExpressionNode extends CallingArithmeticBinaryExpressionNode
<Multiplicative_expressionContext, Cast_expressionContext, Cast_expressionContext, Multiplicative_expressionContext>
{
	private BaseExpressionNode<?> optimized = null;
	
	public MultiplicativeExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Multiplicative_expressionContext> getC1Node(Multiplicative_expressionContext node) throws Exception
	{return new MultiplicativeExpressionNode(this).interpret(node.multiplicative_expression());}

	@Override
	protected BaseExpressionNode<Cast_expressionContext> getC2Node(Multiplicative_expressionContext node) throws Exception
	{return new CastExpressionNode(this).interpret(node.cast_expression());}

	@Override
	protected BaseExpressionNode<Cast_expressionContext> getPCNode(Multiplicative_expressionContext node) throws Exception
	{return new CastExpressionNode(this).interpret(node.cast_expression());}

	private static int optimizedComplexity(long l) // Simualates below const-mult optimization to see if it's worth the trouble
	{
		if (l <= 1)
			return 1;
		
		boolean startOdd = (l % 2 == 1);
		
		do l /= 2;
		while (l % 2 == 0 && 1 < l); // How many times can we divide by zero?

		return (startOdd ? 2 : 1) +  optimizedComplexity(l);
	}
	
	private void optimizeMult(ProgramState state) // Optimize constant mults
	{
		if (operator.equals("%")) return; // Don't do for modulo
		if (x.hasPropValue(state) && operator.equals("*")) // We need x to be the variable one
		{
			BaseExpressionNode<?> t = y;
			y = x;
			x = t;
		}
		else if (x.hasPropValue(state)) // There's no way to fix this in division
			return;
		
		if (x.hasPropValue(state)) return; // Gonna get fully optimized anyway
		
		if (operator.equals("*"))
		{
			if (y.hasPropValue(state) && 1 < y.getPropLong(state) && optimizedComplexity(y.getPropLong(state)) <= CompConfig.maxOptimizedMultComplexity)
			{	
				long l = y.getPropLong(state);
				int i = 0;
				boolean startOdd = (l % 2 == 1);
				do
				{
					l /= 2;
					i += 1;
				}
				while (l % 2 == 0 && 1 < l); // How many times can we divide by two?
				DummyExpressionNode d1, d2;
				d1 = new DummyExpressionNode(this, y.getType(), l);
				d2 = new DummyExpressionNode(this, y.getType(), i);
				MultiplicativeExpressionNode m1 = new MultiplicativeExpressionNode(this, "*", x, d1);
				
				ShiftExpressionNode s1 = new ShiftExpressionNode(this, "<<", m1, d2);
				m1.swapParent(s1);
				d2.swapParent(d2);
				
				optimized = s1;
				if (startOdd)
				{
					optimized = new AdditiveExpressionNode(this, "+", s1, x);
					s1.swapParent(optimized);
				}
			}
			else if (y.hasPropValue(state) && 1 == y.getPropLong(state))
				optimized = x;	
		}
		else if (operator.equals("/") && ((y.getPropLong(state) & (y.getPropLong(state) - 1)) == 0)) // y is power of 2
		{
			assert y.getPropLong(state) != 0; // Should be caught by parsing
			DummyExpressionNode d1;
			d1 = new DummyExpressionNode(this, y.getType(), (int) (Math.log(y.getPropLong(state)) / Math.log(2)));
			ShiftExpressionNode s1 = new ShiftExpressionNode(this, ">>", x, d1);
			optimized = s1;
		}
	}
	
	public MultiplicativeExpressionNode(ComponentNode<?> parent, String operator, BaseExpressionNode<?> x, BaseExpressionNode<?> y)
	{
		super(parent, operator, x, y);
		x.swapParent(this);
		y.swapParent(this);
	}
	@Override
	public BaseExpressionNode<Multiplicative_expressionContext> interpret(Multiplicative_expressionContext node) throws Exception
	{
		BaseExpressionNode<Multiplicative_expressionContext> result = super.interpret(node);
		if (result != this) return result;
		if (operator.equals("/") && y.hasPropValue(new ProgramState()) && y.getPropLong(new ProgramState()) == 0) // Divide by zero
			throw new UnsupportedFeatureException("Division by zero", true, node.start);
		return result;
	}
	@Override
	public CastContext getCastContext()
	{
		switch (operator)
		{
		case "*": case "/": return CastContext.multiplicative;
		case "%": return CastContext.modulative;
		default: return CastContext.multiplicative;
		}
	}
	
	@Override
	protected long doOperation(long x, long y)
	{
		switch (operator)
		{
		case "*": return x * y;
		case "/": return x / y;
		case "%": return x % y;
		default: return 0;
		}
	}
	@Override
	protected int getRetSize(int sizeX, int sizeY)
	{
		switch (operator)
		{
		case "*": return sizeX + sizeY;
		case "/": return sizeX;
		case "%": return sizeY;
		default: return 0;
		}
	}

	@Override
	public String getSubName(int sizeX, int sizeY)
	{
		switch (operator)
		{
		case "*": return "__multiplier@" + sizeX + "@" + sizeY;
		case "/": return "__divider@" + sizeX + "@" + sizeY;
		case "%": return "__modulator@" + sizeX + "@" + sizeY;
		default: return null;
		}
	}
	@Override
	public AssemblyStatePair getCall(ProgramState state, int sizeR, int sizeX, int sizeY) throws Exception
	{
		MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
		switch (operator)
		{
		case "*":
		case "/":
		case "%":
			if ((x.getType().isSigned() || y.getType().isSigned()))// &&
//					!(operator.equals("*") && x.getSize() == y.getSize() && x.getSize() <= 0)) TODO we shouldn't need sign checks for 1- or 2-byte mults
			{
				String divMulHeader = "__divMulHeader@" + sizeX + "@" + sizeY;
				AssemblyStatePair headerPair = new AssemblyStatePair(divMulHeader + ":\n", new ProgramState().indent());
				headerPair = new DivisionMultiplicationHeader(
						CompConfig.specSubSource(true, sizeX),
						CompConfig.specSubSource(true, sizeY)).apply(headerPair);
				headerPair = headerPair.addAssembly("RTL\n");
				
				String divMulFooter = "__divMulFooter@" + sizeR;
				AssemblyStatePair footerPair = new AssemblyStatePair(divMulFooter + ":\n", new ProgramState().indent());
				footerPair = new DivisionMultiplicationFooter(
						CompConfig.callResultSource(sizeR), 
						CompConfig.callResultSource(sizeR)).apply(footerPair); 
				footerPair = footerPair.addAssembly("RTL\n");
				
				getTranslationUnit().requireSub(divMulHeader, headerPair.assembly);
				getTranslationUnit().requireSub(divMulFooter, footerPair.assembly);
				
				pair.assembly += pair.state.getWhitespace() + "JSL\t" + divMulHeader + "\n";
				pair.assembly += pair.state.getWhitespace() + "JSL\t" + getSubName(sizeX, sizeY) + "\n";
				pair.assembly += pair.state.getWhitespace() + "JSL\t" + divMulFooter + "\n";
				return pair.getImmutable();
			}
			else
			{
				pair.assembly += pair.state.getWhitespace() + "JSL\t" + getSubName(sizeX, sizeY) + "\n";
				return pair.getImmutable();
			}
		default: return null;
		}
	}
	@Override
	public String getSub(int sizeX, int sizeY) throws Exception
	{
		String assembly = "";
		
		assembly += getSubName(sizeX, sizeY) + ":\n";
		ProgramState state = new ProgramState().indent();
		OperandSource destSource, sourceX, sourceY;
		
		destSource = CompConfig.callResultSource(getRetSize(sizeX, sizeY));
		sourceX = CompConfig.specSubSource(true, sizeX);
		sourceY = CompConfig.specSubSource(false, sizeY);

		Assemblable assemblable;
		
		boolean isModulo = false;
		switch (operator)
		{
		case "*":
			assemblable = new Multiplier(sourceX, sourceY);
			break;
		case "%":
			isModulo = true;
		case "/":
			if (sizeY > 1)
				assemblable = new LongDividerModulator(sourceX, sourceY, isModulo);
			else
				assemblable = new ShortDividerModulator(sourceX, sourceY, isModulo);
				break;
		default:
			assemblable = null;
		}		
		state = state.setDestSource(destSource);
		assembly += assemblable.getAssembly(state);
		assembly += "RTL\n";
		
		return assembly;
	}
	@Override
	public boolean hasAssembly(ProgramState state)
	{
		if (optimized != null) return optimized.hasAssembly(state);
		else return super.hasAssembly(state);
	}
	@Override
	public boolean hasPropValue(ProgramState state)
	{
		if (optimized != null) return optimized.hasPropValue(state);
		else return super.hasPropValue(state);
	}
	@Override
	public Object getPropValue(ProgramState state)
	{
		if (optimized != null) return optimized.getPropValue(state);
		else return super.getPropValue(state);
	}
	@Override
	public boolean hasLValue()
	{
		if (optimized != null) return optimized.hasLValue();
		else return super.hasLValue();
	}
	@Override
	public LValueNode<?> getLValue()
	{
		if (optimized != null) return optimized.getLValue();
		else return super.getLValue();
	}
	@Override
	public String getAssembly(ProgramState state) throws Exception
	{
		if (OptimizationLevel.isAtLeast(OptimizationLevel.medium))
			optimizeMult(state);
		
		if (optimized != null)
			return optimized.getAssembly(state);
		else 
			return super.getAssembly(state);
	}
}
