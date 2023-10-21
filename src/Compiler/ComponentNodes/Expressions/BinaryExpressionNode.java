// By Iacon1
// Created 10/14/2023
// A general expression node.
package Compiler.ComponentNodes.Expressions;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.Exceptions.UndefinedOpException;
import Compiler.Utils.CompUtils;

public abstract class BinaryExpressionNode<
	C1 extends ParserRuleContext,
	C2 extends ParserRuleContext,
	PC extends ParserRuleContext,
	CC extends ParserRuleContext
	> extends BaseExpressionNode<CC>
{
	protected abstract BaseExpressionNode<C1> getC1Node(CC node) throws Exception;
	protected abstract BaseExpressionNode<C2> getC2Node(CC node) throws Exception;
	protected abstract BaseExpressionNode<PC> getPCNode(CC node) throws Exception;
	protected BaseExpressionNode<?> x, y;
	
	protected String operator;
	
	public BinaryExpressionNode(ComponentNode<?> parent) {super(parent);}
	
	@Override
	public BaseExpressionNode<CC> interpret(CC node) throws Exception
	{
		if (node.children.size() == 1) // Only one, just propagate it
			return (BaseExpressionNode) getPCNode(node);
		else // Two
		{
			x = getC1Node(node);
			y = getC2Node(node);
			
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
		if (x.canCastFrom(y)) return x.getType();
		else if (y.canCastFrom(x)) return y.getType();
		else return null;
	}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return x.canCall(function) || y.canCall(function);
	}
	
	@Override
	public boolean hasPropValue()
	{
		return x.hasPropValue() && y.hasPropValue();
	}
	
	protected String getAssembly(String whitespace, String destAddr, boolean useB, Function<Integer, String> sourceX, Function<Integer, String> sourceY, int xSize) throws Exception
	{
		return "";
	}
	
	@Override
	protected String getAssembly(int leadingWhitespace, String destAddr, boolean useB) throws Exception
	{
		String whitespace = getWhitespace(leadingWhitespace);
		final String destOperand = useB ? CompUtils.operandB : CompUtils.operandA;
		final String otherOperand = useB ? CompUtils.operandA : CompUtils.operandB;
		final Function<Integer, String> sourceX, sourceY;
		String assembly = "";
		
		final int xSize = x.getType().getSize();
		
		
		if (y.hasAssembly())
		{
			assembly += y.getAssembly(leadingWhitespace, otherOperand, useB);
			sourceY = addressSource(otherOperand, xSize);
		}
		else if (y.hasPropValue())
			sourceY = constantSource(y.getPropValue(), xSize);
		else
			sourceY = addressSource(y.getVariable().getFullName(), xSize);
		// Now we figure out X
		if (x.hasAssembly())
		{
			assembly += x.getAssembly(leadingWhitespace, otherOperand, useB);
			sourceX = addressSource(otherOperand, xSize);
		}
		else if (x.hasPropValue())
			sourceX = constantSource(x.getPropValue(), xSize);
		else
			sourceX = addressSource(x.getVariable().getFullName(), xSize);
		
		assembly += getAssembly(whitespace, destAddr, useB, sourceX, sourceY, xSize);
		
		return assembly;
	}
}
