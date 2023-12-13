// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.CompConfig;
import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.Expressions.Snippets.LongDividerModulator;
import Compiler.ComponentNodes.Expressions.Snippets.Multiplier;
import Compiler.ComponentNodes.Expressions.Snippets.ShortDividerModulator;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.CompUtils;
import Compiler.Utils.SNESRegisters;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.ConstantSource;
import Compiler.Utils.OperandSources.OperandSource;
import Compiler.Utils.ScratchManager.ScratchSource;
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
		case "/": return sizeX - sizeY;
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
	public String getSubroutine(int sizeX, int sizeY) throws Exception
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
					CompConfig.multDivSource(true, sizeX),
					CompConfig.multDivSource(false, sizeY), new DetailsTicket());
		case "%":
			isModulo = true;
		case "/":
			if (sizeY > 1)
				assembly += LongDividerModulator.generate(
					AssemblyUtils.getWhitespace(CompConfig.indentSize),
					CompConfig.callResultSource(getRetSize(sizeX, sizeY)),
					CompConfig.multDivSource(true, sizeX),
					CompConfig.multDivSource(false, sizeY), isModulo, new DetailsTicket());
			else
				assembly += ShortDividerModulator.generate(
						AssemblyUtils.getWhitespace(CompConfig.indentSize),
						CompConfig.callResultSource(getRetSize(sizeX, sizeY)),
						CompConfig.multDivSource(true, sizeX),
						CompConfig.multDivSource(false, sizeY), isModulo, new DetailsTicket());
				break;
		}		
		assembly += "RTL\n";
		
		return assembly;
	}
}
