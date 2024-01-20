// By Iacon1
// Created 10/14/2023
// General expression node.

package C99Compiler.CompilerNodes.Expressions;

import org.antlr.v4.runtime.ParserRuleContext;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Interfaces.AssemblableNode;
import C99Compiler.CompilerNodes.Interfaces.TypedNode;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.PropPointer;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.Utils.OperandSources.OperandSource;

public abstract class BaseExpressionNode<C extends ParserRuleContext> extends InterpretingNode<BaseExpressionNode<C>, C> implements AssemblableNode, TypedNode
{

	public BaseExpressionNode(ComponentNode<?> parent) {super(parent);}
	public BaseExpressionNode() {super();}

	public boolean hasLValue() {return false;}
	public LValueNode<?> getLValue() {return null;}
	@Override
	public abstract boolean hasPropValue();
	@Override
	public abstract Object getPropValue();
	public long getPropLong()
	{
		try {return ((Number) getPropValue()).longValue();}
		catch (Exception e) {return 0;}
	}
	public boolean getPropBool()
	{
		try {return (Boolean) getPropValue();}
		catch (Exception e) {return false;}
	}
	public PropPointer getPropPointer()
	{
		try {return (PropPointer) getPropValue();}
		catch (Exception e) {return null;}
	}
	public abstract String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager, DetailsTicket ticket) throws Exception;
	public String getAssembly(int leadingWhitespace, OperandSource destSource, DetailsTicket ticket) throws Exception
	{
		return getAssembly(leadingWhitespace, destSource, new ScratchManager(), ticket);
	}
	public String getAssembly(int leadingWhitespace, OperandSource destSource) throws Exception
	{
		return getAssembly(leadingWhitespace, destSource, new ScratchManager(), new DetailsTicket());
	}
	protected String getAssembly(int leadingWhitespace, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		return getAssembly(leadingWhitespace, CompConfig.callResultSource(getType().getSize()),  scratchManager, ticket);
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		ScratchManager scratchManager = new ScratchManager();
		return getAssembly(leadingWhitespace, scratchManager, new DetailsTicket());
	}

	
}
