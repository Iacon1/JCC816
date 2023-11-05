// By Iacon1
// Created 10/14/2023
// General expression node.

package Compiler.ComponentNodes.Expressions;

import org.antlr.v4.runtime.ParserRuleContext;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.InterpretingNode;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Compiler.ComponentNodes.Interfaces.TypedNode;
import Compiler.ComponentNodes.LVals.LValueNode;
import Compiler.Utils.CompConfig;
import Compiler.Utils.OperandSource;
import Compiler.Utils.ScratchManager;

public abstract class BaseExpressionNode<C extends ParserRuleContext> extends InterpretingNode<BaseExpressionNode<C>, C> implements AssemblableNode, TypedNode
{

	public BaseExpressionNode(ComponentNode<?> parent) {super(parent);}

	public boolean hasLValue() {return false;}
	public LValueNode<?> getLValue() {return null;}
	@Override
	public abstract boolean hasPropValue();
	@Override
	public abstract Object getPropValue();
	public long getPropLong() {return ((Number) getPropValue()).longValue();}
	public boolean getPropBool() {return ((Boolean) getPropValue());}
	public abstract String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager) throws Exception;
	public String getAssembly(int leadingWhitespace, OperandSource destSource) throws Exception
	{
		return getAssembly(leadingWhitespace, destSource, new ScratchManager());
	}
	protected String getAssembly(int leadingWhitespace, ScratchManager scratchManager) throws Exception
	{
		return getAssembly(leadingWhitespace, CompConfig.callResultSource(getType().getSize()),  scratchManager);
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		ScratchManager scratchManager = new ScratchManager();
		return getAssembly(leadingWhitespace, scratchManager);
	}

	
}
