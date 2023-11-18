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
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.CompConfig;
import Compiler.Utils.PropPointer;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.ScratchManager.ScratchSource;
import Compiler.Utils.OperandSources.ConstantSource;
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
	public boolean hasLValue()
	{
		if (operator.equals("*")) return true;
		else if (operator.equals("&"))
		{
			if (UnaryExpressionNode.class.isAssignableFrom(expr.getClass()) && ((UnaryExpressionNode) expr).operator.equals("&"))
				return ((UnaryExpressionNode) expr).expr.hasLValue();
			else return false;
		}
		else return expr.hasLValue();
	}

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
			else return null;
		}
		else return expr.getLValue();
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
				if (VariableNode.class.isAssignableFrom(((PropPointer<?>) pointerRef.getPossibleValues().toArray()[0]).getNode().getClass()))
				{
					VariableNode n = ((PropPointer<VariableNode>) pointerRef.getPossibleValues().toArray()[0]).getNode();
					if (n.hasPossibleValues() && n.getPossibleValues().size() == 1)
						return true;
					else return false;
				}
				else return false;
			}
			else return false;
		else if (operator.equals("&"))
		{
			return expr.hasPropValue() || (expr.hasLValue() && VariableNode.class.isAssignableFrom(expr.getLValue().getClass()));
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
				if (VariableNode.class.isAssignableFrom(((PropPointer<?>) pointerRef.getPossibleValues().toArray()[0]).getNode().getClass()))
				{
					VariableNode node = ((PropPointer<VariableNode>) pointerRef.getPossibleValues().toArray()[0]).getNode();
					if (node.hasPossibleValues() && node.getPossibleValues().size() == 1)
					{
						// And that thing can only have one value...
						return node.getPossibleValues().toArray()[0]; // Then return that
					}
					else return null;
				}
				else if (FunctionDefinitionNode.class.isAssignableFrom(((PropPointer<?>) pointerRef.getPossibleValues().toArray()[0]).getNode().getClass()))
				{
					FunctionDefinitionNode node = ((PropPointer<FunctionDefinitionNode>) pointerRef.getPossibleValues().toArray()[0]).getNode();
					return node;
				}
				
				else return null;
			}
			else return null;
		else if (operator.equals("&"))
		{
			if (expr.hasLValue() && VariableNode.class.isAssignableFrom(expr.getLValue().getClass()))
			{
				VariableNode var = (VariableNode) expr.getLValue();
				return new PropPointer<VariableNode>(var, 0);
			}
			else // Probably function pointer
			{
				FunctionDefinitionNode func = (FunctionDefinitionNode) expr.getPropValue();
				return new PropPointer<FunctionDefinitionNode>(func, 0);
			}
		}
		else return expr.getPropValue();
	}
	
	@Override
	public boolean hasAssembly()
	{
		if (operator.equals("*")) return true;
		else if (operator.equals("&")) return false;
		else if (!operator.equals("++") && !operator.equals("--"))
			return expr.hasAssembly() || !hasPropValue();
		else return true;
	}
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
		OperandSource sourceX;
		ScratchSource scratchX;
		if (expr.hasAssembly())
		{
			scratchX = scratchManager.reserveScratchBlock(expr.getSize());
			assembly += expr.getAssembly(leadingWhitespace, scratchX, scratchManager, ticket);
			if (expr.hasLValue())
				sourceX = expr.getLValue().getSource();
			else sourceX = scratchX;
		}
		else if (expr.hasPropValue())
			sourceX = new ConstantSource(expr.getPropValue(), expr.getType().getSize());
		else if (expr.hasLValue())
			sourceX = expr.getLValue().getSource();
		else sourceX = null;
		
		switch (operator)
		{
		case "++":
			assembly += AdditiveExpressionNode.getIncrementer(whitespace, sourceX, sourceX, ticket);
			if (!destSource.equals(sourceX))
				assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), destSource, sourceX);
			break;
		case "--":
			assembly += AdditiveExpressionNode.getDecrementer(whitespace, sourceX, ticket);
			if (!destSource.equals(sourceX))
				assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), destSource, sourceX);
			break;
		case "-": // -x = ~(x-1)
			assembly += AdditiveExpressionNode.getSubtractor(whitespace, destSource, sourceX, new ConstantSource(1, sourceX.getSize()), ticket);
			sourceX = destSource;
		case "~":
			assembly += XOrExpressionNode.getComplementer(whitespace, destSource, sourceX, ticket);
			break;
		case "!":
			assembly += EqualityExpressionNode.getIsZero(whitespace, destSource, scratchManager, sourceX, ticket);
			break;
		case "*":
			ScratchSource sourceI;
			if (!ScratchManager.hasPointer(sourceX))
			{
				sourceI = scratchManager.reservePointer(sourceX);
				assembly += AssemblyUtils.byteCopier(whitespace, CompConfig.pointerSize, sourceI, sourceX, ticket);
			}
			else sourceI = scratchManager.getPointer(sourceX);
			
			pointerRef = new IndirectLValueNode(this, expr.getLValue(), sourceI, ((PointerType) expr.getType()).getType());
			if (destSource != null) // Was this just a calc or did we need to put this somewhere?
				assembly += AssemblyUtils.byteCopier(whitespace, ((PointerType) expr.getType()).getType().getSize(), destSource, pointerRef.getSource(), ticket);
			break;
		default: return "";
		}

		ScratchManager.demotePointer(destSource); // A copy of the destination, if it's a pointer, has gone stale
		return assembly;
	}
	
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		if (operator.equals("++") || operator.equals("--"))
			return getAssembly(leadingWhitespace, expr.getLValue().getSource(), new ScratchManager(), new DetailsTicket());
		else return super.getAssembly(leadingWhitespace);
	}

	

}
