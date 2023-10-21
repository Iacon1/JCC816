// By Iacon1
// Created 10/14/2023
// General expression node.

package Compiler.ComponentNodes.Expressions;

import org.antlr.v4.runtime.ParserRuleContext;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.InterpretingNode;
import Compiler.ComponentNodes.VariableNode;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Compiler.ComponentNodes.Interfaces.TypedNode;
import Compiler.Utils.CompUtils;

public abstract class BaseExpressionNode<C extends ParserRuleContext> extends InterpretingNode<BaseExpressionNode<C>, C> implements AssemblableNode, TypedNode
{

	public BaseExpressionNode(ComponentNode<?> parent) {super(parent);}
	
	

	protected abstract String getAssembly(int leadingWhitespace, String writeAddr, boolean useB) throws Exception;
	protected String getAssembly(int leadingWhitespace, boolean useB) throws Exception
	{
		if (!useB) return getAssembly(leadingWhitespace, CompUtils.operandA, useB);
		else return getAssembly(leadingWhitespace, CompUtils.operandB, useB);
	}
	public String getAssembly(int leadingWhitespace, String writeAddr) throws Exception
	{
		return getAssembly(leadingWhitespace, writeAddr, false);
	}
	
	public VariableNode getVariable() {return null;}
	@Override
	public abstract boolean hasPropValue();
	@Override
	public abstract Object getPropValue();
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		return getAssembly(leadingWhitespace, false);
	}
}
