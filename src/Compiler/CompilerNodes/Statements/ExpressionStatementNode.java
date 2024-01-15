// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.CompilerNodes.Statements;

import Compiler.CompilerNodes.ComponentNode;
import Compiler.CompilerNodes.FunctionDefinitionNode;
import Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import Compiler.CompilerNodes.Expressions.ExpressionNode;
import Compiler.CompilerNodes.Interfaces.AssemblableNode;
import Grammar.C99.C99Parser.Expression_statementContext;

public class ExpressionStatementNode extends StatementNode<Expression_statementContext>
{
	private BaseExpressionNode<?> expression;
	public ExpressionStatementNode(ComponentNode<?> parent) {super(parent);}

	@Override
	public StatementNode<Expression_statementContext> interpret(Expression_statementContext node) throws Exception
	{
		expression = new ExpressionNode(this).interpret(node.expression());
		return this;
	}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return expression.canCall(function);
	}

	@Override
	public boolean hasAssembly()
	{
		return expression.hasAssembly();
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		return expression.getAssembly(leadingWhitespace);
	}
}
