// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompConfig;
import C99Compiler.CompConfig.OptimizationLevel;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.CompilerNodes.Expressions.Snippets.DivisionMultiplicationHeaderFooter;
import C99Compiler.CompilerNodes.Expressions.Snippets.LongDividerModulator;
import C99Compiler.CompilerNodes.Expressions.Snippets.Multiplier;
import C99Compiler.CompilerNodes.Expressions.Snippets.ShortDividerModulator;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.ScratchManager;
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
	
	private void optimizeMult() // Optimize constant mults
	{
		if (!operator.equals("*")) return; // Only do if multiplication
		if (x.hasPropValue())
		{
			BaseExpressionNode<?> t = y;
			y = x;
			x = t;
		}
		if (x.hasPropValue()) return; // Gonna get fully optimized anyway
		
		if (y.hasPropValue() && 1 < y.getPropLong() && optimizedComplexity(y.getPropLong()) <= CompConfig.maxOptimizedMultComplexity)
		{	
			long l = y.getPropLong();
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
		else if (y.hasPropValue() && 1 == y.getPropLong())
			optimized = x;	
	}
	
	public MultiplicativeExpressionNode(ComponentNode<?> parent, String operator, BaseExpressionNode<?> x, BaseExpressionNode<?> y)
	{
		super(parent, operator, x, y);
		x.swapParent(this);
		y.swapParent(this);
		if (OptimizationLevel.isAtLeast(OptimizationLevel.medium))
			optimizeMult();
	}
	@Override
	public BaseExpressionNode<Multiplicative_expressionContext> interpret(Multiplicative_expressionContext node) throws Exception
	{
		BaseExpressionNode<Multiplicative_expressionContext> result = super.interpret(node);
		if (result != this) return result;
		if (OptimizationLevel.isAtLeast(OptimizationLevel.medium))
			optimizeMult();
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
	public String getCall(String whitespace, int sizeR, int sizeX, int sizeY) throws Exception
	{
		switch (operator)
		{
		case "*":
		case "/":
		case "%":
		{
			if ((x.getType().isSigned() || y.getType().isSigned()))// &&
//					!(operator.equals("*") && x.getSize() == y.getSize() && x.getSize() <= 0)) TODO we shoudln't need sign checks for 1- or 2-byte mults
			{
				String assembly = "";
				String divMulHeader = "__divMulHeader@" + sizeX + "@" + sizeY;
				String headerASM = divMulHeader + ":\n";
				headerASM += DivisionMultiplicationHeaderFooter.divisionMultiplicationHeader(
						AssemblyUtils.getWhitespace(CompConfig.indentSize),
						CompConfig.specSubSource(true, sizeX),
						CompConfig.specSubSource(false, sizeY), 
						new DetailsTicket());
				headerASM += "RTL\n";
				
				String divMulFooter = "__divMulFooter@" + sizeR;
				String footerASM = divMulFooter + ":\n";
				footerASM += DivisionMultiplicationHeaderFooter.divisionMultiplicationFooter(
						AssemblyUtils.getWhitespace(CompConfig.indentSize),
						CompConfig.callResultSource(sizeR), 
						CompConfig.callResultSource(sizeR), 
						new DetailsTicket());
				footerASM += "RTL\n";
				
				getTranslationUnit().requireSub(divMulHeader, headerASM);
				getTranslationUnit().requireSub(divMulFooter, footerASM);
				
				assembly += whitespace + "JSL\t" + divMulHeader + "\n";
				assembly += whitespace + "JSL\t" + getSubName(sizeX, sizeY) + "\n";
				assembly += whitespace + "JSL\t" + divMulFooter + "\n";
				return assembly;
			}
			else return whitespace + "JSL\t" + getSubName(sizeX, sizeY) + "\n";
		}
		default: return null;
		}
	}
	@Override
	public String getSubAssembly(int sizeX, int sizeY) throws Exception
	{
		String assembly = "";
		
		assembly += getSubName(sizeX, sizeY) + ":\n";
		
		boolean isModulo = false;
		switch (operator)
		{
		case "*":
			assembly += Multiplier.generate(
					AssemblyUtils.getWhitespace(CompConfig.indentSize),
					CompConfig.callResultSource(getRetSize(sizeX, sizeY)),
					CompConfig.specSubSource(true, sizeX),
					CompConfig.specSubSource(false, sizeY), new DetailsTicket());
			break;
		case "%":
			isModulo = true;
		case "/":
			if (sizeY > 1)
				assembly += LongDividerModulator.generate(
					AssemblyUtils.getWhitespace(CompConfig.indentSize),
					CompConfig.callResultSource(getRetSize(sizeX, sizeY)),
					CompConfig.specSubSource(true, sizeX),
					CompConfig.specSubSource(false, sizeY), isModulo, new DetailsTicket());
			else
				assembly += ShortDividerModulator.generate(
						AssemblyUtils.getWhitespace(CompConfig.indentSize),
						CompConfig.callResultSource(getRetSize(sizeX, sizeY)),
						CompConfig.specSubSource(true, sizeX),
						CompConfig.specSubSource(false, sizeY), isModulo, new DetailsTicket());
				break;
		}		
		assembly += "RTL\n";
		
		return assembly;
	}
	@Override
	public boolean hasAssembly()
	{
		if (optimized != null) return optimized.hasAssembly();
		else return super.hasAssembly();
	}
	@Override
	public boolean hasPropValue()
	{
		if (optimized != null) return optimized.hasPropValue();
		else return super.hasPropValue();
	}
	@Override
	public Object getPropValue()
	{
		if (optimized != null) return optimized.getPropValue();
		else return super.getPropValue();
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
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		if (optimized != null)
			return optimized.getAssembly(leadingWhitespace, destSource, scratchManager, ticket);
		else 
			return super.getAssembly(leadingWhitespace, destSource, scratchManager, ticket);
	}
}
