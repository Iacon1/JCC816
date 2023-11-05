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
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompUtils;
import Compiler.Utils.OperandSource;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.ScratchManager.ScratchSource;

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
		if (node == null) return null;
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
	
	protected String getAssembly(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY) throws Exception
	{return null;}
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		ScratchSource scratchX = null, scratchY = null;
		final OperandSource sourceX, sourceY;
		String assembly = "";

		if (y.hasAssembly())
		{
			scratchY = scratchManager.reserveScratchBlock(y.getType().getSize());
			assembly += y.getAssembly(leadingWhitespace, scratchY, scratchManager);
			sourceY = scratchY;
		}
		else if (y.hasPropValue())
			sourceY = AssemblyUtils.constantSource(y.getPropValue(), y.getType().getSize());
		else
			sourceY = y.getLValue().getSource();
		// Now we figure out X
		if (x.hasAssembly())
		{
			scratchX = scratchManager.reserveScratchBlock(y.getType().getSize());
			assembly += x.getAssembly(leadingWhitespace, scratchX, scratchManager);
			sourceX = scratchX;
		}
		else if (x.hasPropValue())
			sourceX = AssemblyUtils.constantSource(x.getPropValue(), x.getType().getSize());
		else
			sourceX = x.getLValue().getSource();
		
		assembly += getAssembly(whitespace, destSource, scratchManager, sourceX, sourceY);
		if (scratchX != null) scratchManager.releaseScratchBlock(scratchX);
		if (scratchY != null) scratchManager.releaseScratchBlock(scratchY);
		
		return assembly;
	}
}
