// By Iacon1
// Created 10/14/2023
// General expression node.

package C99Compiler.CompilerNodes.Expressions;

import java.util.LinkedList;
import java.util.List;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.Utils.ProgramState;
import Grammar.C99.C99Parser.Assignment_expressionContext;
import Grammar.C99.C99Parser.ExpressionContext;

public class ExpressionNode extends SPBaseExpressionNode<ExpressionContext>
{
	private List<BaseExpressionNode<?>> expressions;

	public ExpressionNode(ComponentNode<?> parent)
	{
		super(parent);
		expressions = new LinkedList<BaseExpressionNode<?>>();
		isSP = false;
	}

	@Override
	public BaseExpressionNode<ExpressionContext> interpret(ExpressionContext node) throws Exception
	{
		for (Assignment_expressionContext assignment : node.assignment_expression())
			expressions.add((BaseExpressionNode<?>) new AssignmentExpressionNode(this).interpret(assignment));
		if (expressions.size() == 1) return delegate(expressions.get(0));
		return this;
	}
	
	@Override
	public Type getType() {return null;}
	
	@Override
	public boolean canCall(ProgramState state, FunctionDefinitionNode function)
	{
		for (BaseExpressionNode<?> expression : expressions)
			if (expression.canCall(state, function)) return true;
		return false;
	}
	
	@Override
	public boolean hasLValue() {return false;}
	@Override
	public LValueNode<?> getLValue() {return null;}
	@Override
	public boolean hasPropValue(ProgramState state) {return false;}
	@Override
	public Object getPropValue(ProgramState state) {return null;}
	@Override
	public boolean hasAssembly(ProgramState state)
	{
		for (BaseExpressionNode<?> expression : expressions)
			if (expression.hasAssembly(state)) return true;
		return false;
	}
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		AssemblyStatePair pair = new AssemblyStatePair("", state);

		for (BaseExpressionNode<?> expression : expressions.subList(0, expressions.size()))
		{
			clearAssemblables();
			pair = expression.apply(pair);
			pair = applyRegistered(pair);
		}
		
		return pair;
	}
}
