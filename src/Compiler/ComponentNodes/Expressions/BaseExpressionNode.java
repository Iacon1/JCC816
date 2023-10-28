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
import Compiler.Utils.ScratchManager;
import Compiler.Utils.ScratchManager.ScratchSource;

public abstract class BaseExpressionNode<C extends ParserRuleContext> extends InterpretingNode<BaseExpressionNode<C>, C> implements AssemblableNode, TypedNode
{

	public BaseExpressionNode(ComponentNode<?> parent) {super(parent);}

	protected abstract String getAssembly(int leadingWhitespace, String destAddr, ScratchManager scratchManager) throws Exception;

	public VariableNode getVariable() {return null;}
	@Override
	public abstract boolean hasPropValue();
	@Override
	public abstract Object getPropValue();
	public String getAssembly(int leadingWhitespace, String destAddr) throws Exception
	{
		return getAssembly(leadingWhitespace, destAddr, new ScratchManager());
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		ScratchManager scratchManager = new ScratchManager();
		ScratchSource source = scratchManager.reserveScratchBlock(getType().getSize());
		return getAssembly(leadingWhitespace, source.getAddress(), new ScratchManager());
	}
}
