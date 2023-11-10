// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import org.antlr.v4.runtime.tree.TerminalNode;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.Declarations.TypeNameNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.Dummies.DummyType;
import Compiler.ComponentNodes.LValues.IndirectLValueNode;
import Compiler.ComponentNodes.LValues.LValueNode;
import Compiler.ComponentNodes.LValues.VariableNode;
import Compiler.ComponentNodes.Definitions.PointerType;
import Compiler.Exceptions.ConstraintException;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompConfig;
import Compiler.Utils.PropPointer;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.ScratchManager.ScratchSource;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Unary_expressionContext;

public class UnaryExpressionNode extends BaseExpressionNode<Unary_expressionContext>
{
	private BaseExpressionNode<?> expr;
	private Type type;
	private String operator;
	private LValueNode<?> pointerRef; // LValue if this is a pointer reference (*x)
	
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
			if (operator.equals("*") && expr.hasLValue())
				pointerRef = new IndirectLValueNode(this, expr.getLValue(), null, null); // For const prop purposes
		}
		return this;
	}

	@Override
	public Type getType()
	{
		if (type != null) return new PointerType(new DummyType("void")); // No object can have a greater size than a pointer
		else if (operator.equals("*"))
		{
			return ((PointerType) expr.getType()).getType(); 
		}
		else if (operator.equals("&"))
		{
			return new PointerType(expr.getType());
		}
		else return expr.getType();
	}
	
	@Override
	public boolean hasLValue() {return operator.equals("&") || operator.equals("*");}
	@Override
	public LValueNode<?> getLValue()
	{
		if (operator.equals("*"))
		{
			if (UnaryExpressionNode.class.isAssignableFrom(expr.getClass()) && ((UnaryExpressionNode) expr).operator.equals("*"))
				return ((UnaryExpressionNode) expr).expr.getLValue(); // These two cancel each other out
			else return pointerRef;
		}
		else if (operator.equals("&"))
		{
			if (UnaryExpressionNode.class.isAssignableFrom(expr.getClass()) && ((UnaryExpressionNode) expr).operator.equals("&"))
				return ((UnaryExpressionNode) expr).expr.getLValue(); // These two cancel each other out
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
		else if (operator.equals("*"))
			if (pointerRef != null && pointerRef.hasPossibleValues() && pointerRef.getPossibleValues().size() == 1)
			{
				// if expr can only point to one thing...
				VariableNode n = ((PropPointer) pointerRef.getPossibleValues().toArray()[0]).getNode();
				if (n.hasPossibleValues() && n.getPossibleValues().size() == 1) return true;
				else return false;
			}
			else return false;
		else if (operator.equals("&"))
		{
			return expr.hasLValue() && VariableNode.class.isAssignableFrom(expr.getLValue().getClass());
		}
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
		else if (operator.equals("*"))
			if (pointerRef != null && pointerRef.hasPossibleValues() && pointerRef.getPossibleValues().size() == 1)
			{
				// if expr can only point to one thing...
				VariableNode n = ((PropPointer) pointerRef.getPossibleValues().toArray()[0]).getNode();
				if (n.hasPossibleValues() && n.getPossibleValues().size() == 1)
				{
					// And that thing can only have one value...
					return n.getPossibleValues().toArray()[0]; // Then return that
				}
				else return null;
			}
			else return null;
		else if (operator.equals("&"))
		{
			if (expr.hasLValue() && VariableNode.class.isAssignableFrom(expr.getLValue().getClass()))
			{
				VariableNode var = (VariableNode) expr.getLValue();
				return new PropPointer(var, 0);
			}
			return null;
		}
		else return expr.getPropValue();
	}
	
	@Override
	public boolean hasAssembly()
	{
		if (!operator.equals("++") && !operator.equals("--"))
			return expr.hasAssembly() || !hasPropValue();
		else return true;
	}
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
		if (expr.hasAssembly()) assembly += expr.getAssembly();
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
		case "*":
			ScratchSource sourceI = scratchManager.reserveScratchBlock(CompConfig.pointerSize); // Never released, lasts until manager goes stale
			assembly += AssemblyUtils.byteCopier(whitespace, CompConfig.pointerSize, sourceI, sourceX);
			pointerRef = new IndirectLValueNode(this, expr.getLValue(), sourceI, ((PointerType) expr.getType()).getType());
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
