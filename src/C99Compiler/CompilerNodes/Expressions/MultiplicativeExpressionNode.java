// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.CompilerNodes.Expressions.Snippets.DivisionMultiplicationHeaderFooter;
import C99Compiler.CompilerNodes.Expressions.Snippets.LongDividerModulator;
import C99Compiler.CompilerNodes.Expressions.Snippets.Multiplier;
import C99Compiler.CompilerNodes.Expressions.Snippets.ShortDividerModulator;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import Grammar.C99.C99Parser.Cast_expressionContext;
import Grammar.C99.C99Parser.Multiplicative_expressionContext;

public class MultiplicativeExpressionNode extends CallingArithmeticBinaryExpressionNode
<Multiplicative_expressionContext, Cast_expressionContext, Cast_expressionContext, Multiplicative_expressionContext>
{
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

	public MultiplicativeExpressionNode(ComponentNode<?> parent, String operator, BaseExpressionNode<?> x, BaseExpressionNode<?> y)
	{
		super(parent);
		this.operator = operator;
		this.x = x;
		this.y = y;
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
}
