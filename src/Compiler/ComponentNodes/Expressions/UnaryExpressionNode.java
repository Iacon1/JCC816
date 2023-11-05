// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import org.antlr.v4.runtime.tree.TerminalNode;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.LVals.ImmediateLValNode;
import Compiler.ComponentNodes.LVals.IndirectLValNode;
import Compiler.ComponentNodes.LVals.LValNode;
import Compiler.ComponentNodes.UtilNodes.TypeNameNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.OperandSource;
import Compiler.Utils.ScratchManager;

import Grammar.C99.C99Parser.Unary_expressionContext;

public class UnaryExpressionNode extends BaseExpressionNode<Unary_expressionContext>
{
	private BaseExpressionNode<?> expr;
	private Type type;
	private String operator;
	
	public UnaryExpressionNode(ComponentNode<?> parent) {super(parent);}
	
	@Override
	public BaseExpressionNode<Unary_expressionContext> interpret(Unary_expressionContext node) throws Exception
	{
		if (node.postfix_expression() != null) // Only one, just propagate it
			return (BaseExpressionNode) new PostfixExpressionNode(this).interpret(node.postfix_expression());
		else // Two
		{
			if (node.unary_expression() != null)
				this.expr = new UnaryExpressionNode(this).interpret(node.unary_expression());
			else if (node.cast_expression() != null)
				this.expr = new CastExpressionNode(this).interpret(node.cast_expression());
			else if (node.type_name() != null)
				type = new TypeNameNode(this).interpret(node.type_name()).getType();

			operator = "";
			for (int i = 0; i < node.getChildCount(); ++i)
				if (TerminalNode.class.isAssignableFrom(node.getChild(i).getClass()))
					operator += node.getChild(i).getText();
		}
		return this;
	}

	@Override
	public Type getType()
	{
		if (type != null) return type;
		else return expr.getType(); 
	}
	
	@Override
	public LValNode<?> getLVal()
	{
		if (operator.equals("&"))
		{
			if (UnaryExpressionNode.class.isAssignableFrom(expr.getClass()) && ((UnaryExpressionNode) expr).operator.equals("*"))
				return ((UnaryExpressionNode) expr).expr.getLVal(); // These two cancel each other out
			else return new IndirectLValNode(expr);
		}
		else if (operator.equals("*"))
		{
			if (UnaryExpressionNode.class.isAssignableFrom(expr.getClass()) && ((UnaryExpressionNode) expr).operator.equals("&"))
				return ((UnaryExpressionNode) expr).expr.getLVal(); // These two cancel each other out
			else return new ImmediateLValNode(expr.getLVal());
		}
		return expr.getLVal();
	}

	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return expr.canCall(function);
	}
	@Override
	public boolean hasPropValue()
	{
		if (operator.equals("sizeof")) return true;
		else return expr.hasPropValue();
	}
	@Override
	public Object getPropValue()
	{
		if (operator.equals("sizeof")) return expr.getType().getSize();
		else return expr.getPropValue();
	}
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource writeAddr, ScratchManager scratchManager) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
		switch (operator)
		{
		case "++":
			assembly += AdditiveExpressionNode.getIncrementer(whitespace, expr.getLVal().getSource(), expr.getLVal().getSource());
			if (!writeAddr.equals(expr.getLVal().getSource()))
				assembly += AssemblyUtils.byteCopier(whitespace, expr.getLVal().getSize(), writeAddr, expr.getLVal().getSource());
			return assembly;
		default: return "";
		}
	}
	
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		if (operator.equals("++") || operator.equals("--"))
			return getAssembly(leadingWhitespace, expr.getLVal().getSource(), new ScratchManager());
		else return super.getAssembly(leadingWhitespace);
	}

	

}
