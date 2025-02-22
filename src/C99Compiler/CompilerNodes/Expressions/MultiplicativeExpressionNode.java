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
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.Exceptions.UnsupportedFeatureException;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.AssemblyUtils.ByteCopier;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Cast_expressionContext;
import Grammar.C99.C99Parser.Multiplicative_expressionContext;
import Shared.Assemblable;

public class MultiplicativeExpressionNode extends CallingArithmeticBinaryExpressionNode
<Multiplicative_expressionContext, Cast_expressionContext, Cast_expressionContext, Multiplicative_expressionContext>
{
	public MultiplicativeExpressionNode(ComponentNode<?> parent) {
		super(parent);}

	@Override
	protected BaseExpressionNode<Multiplicative_expressionContext> getC1Node(Multiplicative_expressionContext node) throws Exception
	{return new MultiplicativeExpressionNode(this).interpret(node.multiplicative_expression());}

	@Override
	protected BaseExpressionNode<Cast_expressionContext> getC2Node(Multiplicative_expressionContext node) throws Exception
	{return new CastExpressionNode(this).interpret(node.cast_expression());}

	@Override
	protected BaseExpressionNode<Cast_expressionContext> getPCNode(Multiplicative_expressionContext node) throws Exception
	{return new CastExpressionNode(this).interpret(node.cast_expression());}
	
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
}
