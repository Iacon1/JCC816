// Created by Iacon1 on 01/19/2024.
//
package C99Compiler.CompilerNodes.Dummies;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.ExpressionContext;

public class DummyExpressionNode extends BaseExpressionNode<ExpressionContext>
{
	private Type type;
	private Object value;
	private LValueNode<?> LValueNode;
	
	public DummyExpressionNode(ComponentNode<?> parent, Type type, Object value)
	{
		super(parent);
		this.type = type;
		this.value = value;
		this.LValueNode = null;
	}
	public DummyExpressionNode(ComponentNode<?> parent, Type type, OperandSource source)
	{
		super(parent);
		this.type = type;
		this.value = null;
		this.LValueNode = new DummyLValueNode(this, type, source);
	}
	public DummyExpressionNode(ComponentNode<?> parent, long value)
	{
		super(parent);
		this.type = CompUtils.getSmallestType(value);
		this.value = Long.valueOf(value);
		this.LValueNode = null;
	}
	public DummyExpressionNode(ComponentNode<?> parent, LValueNode<?> lValue)
	{
		super(parent);
		this.type = lValue.getType();
		this.value = null;
		this.LValueNode = lValue;
	}
	@Override public boolean hasAssembly(ProgramState state) {return false;}

	@Override
	public BaseExpressionNode<ExpressionContext> interpret(ExpressionContext node) throws Exception {return this;}
	
	@Override
	public Type getType() {return type;}

	@Override
	public boolean hasPropValue(ProgramState state)
	{
		if (LValueNode != null)
			return state.getOnlyValue(LValueNode) != null;
		else
			return value != null;
	}

	@Override
	public Object getPropValue(ProgramState state)
	{
		if (LValueNode != null)
			return state.getOnlyValue(LValueNode);
		else
			return value;
	}

	@Override
	public boolean hasLValue(ProgramState state) {return LValueNode != null;}
	
	@Override
	public LValueNode<?> getLValue(ProgramState state) {return LValueNode;}
	
	@Override 
	public boolean canCall(ProgramState state, FunctionDefinitionNode function) {return false;}

	@Override
	public ProgramState getStateBefore(ProgramState state, ComponentNode<?> child) {return state;}
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		return new AssemblyStatePair("", state);
	}
}
