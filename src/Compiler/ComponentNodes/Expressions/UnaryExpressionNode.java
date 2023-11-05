// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import org.antlr.v4.runtime.tree.TerminalNode;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.Declarations.TypeNameNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.Dummies.DummyType;
import Compiler.ComponentNodes.Definitions.PointerType;
import Compiler.ComponentNodes.LVals.ImmediateLValNode;
import Compiler.ComponentNodes.LVals.IndirectLValNode;
import Compiler.ComponentNodes.LVals.LValueNode;
import Compiler.Exceptions.ConstraintException;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompConfig;
import Compiler.Utils.CompUtils;
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
		if (node.postfix_expression() != null) // Propagate
			return (BaseExpressionNode) new PostfixExpressionNode(this).interpret(node.postfix_expression());
		else
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
			
			if (operator.equals("++") || operator.equals("--") && !expr.hasLValue())
				throw new ConstraintException("6.5.3", 1, node.start);
		}
		return this;
	}

	@Override
	public Type getType()
	{
		if (type != null) return new PointerType(new DummyType("void")); // No object can have a greater size than a pointer
		else return expr.getType(); 
	}
	
	@Override
	public LValueNode<?> getLValue()
	{
		if (operator.equals("&"))
		{
			if (UnaryExpressionNode.class.isAssignableFrom(expr.getClass()) && ((UnaryExpressionNode) expr).operator.equals("*"))
				return ((UnaryExpressionNode) expr).expr.getLValue(); // These two cancel each other out
			else return new IndirectLValNode(expr);
		}
		else if (operator.equals("*"))
		{
			if (UnaryExpressionNode.class.isAssignableFrom(expr.getClass()) && ((UnaryExpressionNode) expr).operator.equals("&"))
				return ((UnaryExpressionNode) expr).expr.getLValue(); // These two cancel each other out
			else return new ImmediateLValNode(expr.getLValue());
		}
		return expr.getLValue();
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
		if (operator.equals("sizeof"))
		{
			if (type != null) return type.getSize();
			else return expr.getType().getSize();
		}
		else if (operator.equals("-")) return Long.valueOf(-1 * expr.getPropLong());
		else if (operator.equals("~")) return Long.valueOf(~expr.getPropLong());
		else if (operator.equals("!")) return Boolean.valueOf(expr.getPropBool());
		else return expr.getPropValue();
	}
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
		OperandSource sourceX = expr.getLValue().getSource();
		switch (operator)
		{
		case "++":
			assembly += AdditiveExpressionNode.getIncrementer(whitespace, sourceX, sourceX);
			if (!destSource.equals(sourceX))
				assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), destSource, sourceX);
			break;
		case "--":
			assembly += AdditiveExpressionNode.getDecrementer(whitespace, sourceX, sourceX);
			if (!destSource.equals(sourceX))
				assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), destSource, sourceX);
			break;
		case "-": // -x = ~(x-1)
			assembly += AdditiveExpressionNode.getDecrementer(whitespace, destSource, sourceX);
			sourceX = destSource;
		case "~":
			assembly += XOrExpressionNode.getComplementer(whitespace, destSource, sourceX);
			break;
		case "!":
			assembly += EqualityExpressionNode.getIsZero(whitespace, destSource, scratchManager, sourceX);
			break;
		default: return "";
		}
		
		return assembly;
	}
	
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		if (operator.equals("++") || operator.equals("--"))
			return getAssembly(leadingWhitespace, expr.getLValue().getSource(), new ScratchManager());
		else return super.getAssembly(leadingWhitespace);
	}

	

}
