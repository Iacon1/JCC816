// By Iacon1
// Created 05/06/2023
// The program itself.
package C99Compiler.CompilerNodes.Statements;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.ExpressionNode;
import C99Compiler.Utils.ProgramState;
import Grammar.C99.C99Parser.Expression_statementContext;

public class ExpressionStatementNode extends SequencePointStatementNode<Expression_statementContext>
{
	private BaseExpressionNode<?> expression;
	public ExpressionStatementNode(ComponentNode<?> parent) {super(parent); expression = null;}

	@Override
	public StatementNode<Expression_statementContext> interpret(Expression_statementContext node) throws Exception
	{
		if (node.expression() != null)
			expression = new ExpressionNode(this).interpret(node.expression());
		return this;
	}
	
	@Override
	public boolean canCall(ProgramState state, FunctionDefinitionNode function)
	{
		return expression != null && expression.canCall(state, function);
	}

	@Override
	public boolean hasAssembly(ProgramState state)
	{
		return expression != null && expression.hasAssembly(state);
	}
	
	@Override
	public ProgramState getStateAfter(ProgramState state) throws Exception
	{
		if (expression != null)
			return expression.getStateAfter(state);
		else
			return state;
	}
	
	@Override
	public ProgramState getStateBefore(ProgramState state, ComponentNode<?> child) throws Exception
	{
		if (!children.contains(child))
			throw new IllegalArgumentException();

		return state;
	}
	
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		return getAssemblyAndStateWithRegistered(state, expression);
	}
}
