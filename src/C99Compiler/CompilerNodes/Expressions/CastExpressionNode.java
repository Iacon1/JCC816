// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Declarations.TypeNameNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.AssemblyUtils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.ByteCopier;
import C99Compiler.Utils.AssemblyUtils.SignExtender;
import C99Compiler.Utils.OperandSources.ConstantSource;
import Grammar.C99.C99Parser.Cast_expressionContext;

public class CastExpressionNode extends BaseExpressionNode<Cast_expressionContext>
{
	private Type type;
	private BaseExpressionNode<?> expr;
	
	public CastExpressionNode(ComponentNode<?> parent) {super(parent);}

	public CastExpressionNode(BaseExpressionNode<?> parent, Type type, BaseExpressionNode<?> expr)
	{
		super(parent);
		this.type = type;
		this.expr = expr;
	}
	
	@Override
	public BaseExpressionNode<Cast_expressionContext> interpret(Cast_expressionContext node) throws Exception
	{
		if (node.type_name() != null)
		{
			type = new TypeNameNode(this).interpret(node.type_name()).getType();
			this.expr = new CastExpressionNode(this).interpret(node.cast_expression());
			return this;
		}
		else return delegate(new UnaryExpressionNode(this).interpret(node.unary_expression()));
	}
	
	@Override
	public boolean canCall(ProgramState state, FunctionDefinitionNode function)
	{
		return expr.canCall(state, function);
	}

	@Override
	public Type getType()
	{
		return type;
	}
	@Override
	public boolean hasPropValue(ProgramState state)
	{
		return expr.hasPropValue(state);
	}
	@Override
	public Object getPropValue(ProgramState state)
	{
		return expr.getPropValue(state);
	}
	@Override
	public boolean hasLValue(ProgramState state)
	{
		return expr.hasLValue(state);
	}
	public LValueNode<?> getLValue(ProgramState state)
	{
		return expr.getLValue(state);
	}
	@Override
	public boolean hasAssembly(ProgramState state)
	{
		return expr.hasAssembly(state) || (!hasPropValue(state) && getType().getSize() > expr.getType().getSize());
	}
	@Override
	public ProgramState getStateBefore(ProgramState state, ComponentNode<?> child) throws Exception
	{
		if (!children.contains(child))
			throw new IllegalArgumentException();
		
		if (getType().getSize() > expr.getType().getSize()) // Need to make space
			state = new ByteCopier(getType().getSize(), state.destSource(), new ConstantSource(0, getType().getSize())).getStateAfter(state);
		
		if (child != expr && expr.hasAssembly(state))
			state = expr.getStateAfter(state);
		return state;
	}
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		AssemblyStatePair pair = null;
		
		if (expr.hasAssembly(state))
		{
			pair = expr.getAssemblyAndState(state);
		}
		else if (expr.hasLValue(state))
		{
			pair = new SignExtender(state.destSource(), expr.getLValue(state).getSource(), getType().isSigned(), expr.getType().isSigned()).getAssemblyAndState(state);
			pair = new ByteCopier(state.destSource(), expr.getLValue(state).getSource()).apply(pair);
		}
		
		return pair;
	}
}
