// By Iacon1
// Created 10/14/2023
// General expression node.

package C99Compiler.CompilerNodes.Expressions;

import org.antlr.v4.runtime.ParserRuleContext;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Interfaces.AssemblableNode;
import C99Compiler.CompilerNodes.Interfaces.TypedNode;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.PropPointer;

public abstract class BaseExpressionNode<C extends ParserRuleContext> extends InterpretingNode<BaseExpressionNode<C>, C> implements AssemblableNode, TypedNode
{

	protected BaseExpressionNode delegate(BaseExpressionNode<?> delegatee)
	{
		delegatee.parent = parent;
		swap(delegatee);
		return (BaseExpressionNode) delegatee;
	}
	public BaseExpressionNode(ComponentNode<?> parent) {super(parent);}
	public BaseExpressionNode() {super();}

	public boolean hasLValue() {return false;}
	public LValueNode<?> getLValue() {return null;}

	public long getPropLong(ProgramState state)
	{
		try {return ((Number) getPropValue(state)).longValue();}
		catch (Exception e) {return 0;}
	}
	@Deprecated
	public long getPropLong()
	{
		return getPropLong(new ProgramState());
	}
	public boolean getPropBool(ProgramState state)
	{
		try {return (Boolean) getPropValue(state);}
		catch (Exception e) {return false;}
	}
	@Deprecated
	public boolean getPropBool()
	{
		return getPropBool(new ProgramState());
	}
	public PropPointer getPropPointer(ProgramState state)
	{
		try {return (PropPointer) getPropValue(state);}
		catch (Exception e) {return null;}
	}
	@Deprecated
	public PropPointer getPropPointer()
	{
		return getPropPointer(new ProgramState());
	}
	public boolean isIndirect() {return false;} // Will this L-Value be indirect?

	
}
