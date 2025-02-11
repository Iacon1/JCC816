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

	public abstract boolean hasLValue(ProgramState state);
	@Deprecated
	public boolean hasLValue() {return hasLValue(new ProgramState());}
	public abstract LValueNode<?> getLValue(ProgramState state);
	@Deprecated
	public LValueNode<?> getLValue() {return getLValue(new ProgramState());}

	public boolean isIndirect() {return false;} // Will this L-Value be indirect?

	
}
