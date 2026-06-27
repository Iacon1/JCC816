// By Iacon1
// Created 10/14/2023
// General expression node.

package C99Compiler.CompilerNodes.Expressions;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Interfaces.AssemblableNode;
import C99Compiler.CompilerNodes.Interfaces.TypedNode;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.ProgramState.ProgramState;
import C99Compiler.Utils.PropPointer;

public abstract class BaseExpressionNode<C extends ParserRuleContext> extends InterpretingNode<BaseExpressionNode<C>, C> implements AssemblableNode, TypedNode
{

	protected BaseExpressionNode delegate(BaseExpressionNode<?> delegatee)
	{
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
	/** If an expression node is "logical" then when destSource is null the A register will be 1 if the expression is "true".
	 * 
	 * @return Whether this expression is logical.
	 */
	public boolean isLogical() {return false;}
	
	public abstract String getPointerName(); // If this expression is of pointer type this is the name the pointer would be reserved under in ProgramState
	public abstract Set<String> getIdlePointerDisqualifiers(); // If this expression is of pointer type and an expression containing it disqualifies pointers this is the list of disqualifiers this would add to the list being disqualified
	public abstract Set<String> getPointerDisqualifiers(); // If this expression is of pointer type this is the list of disqualifiers that'd apply to the pointer
}
