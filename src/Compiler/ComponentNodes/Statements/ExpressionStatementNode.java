// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes.Statements;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.Expressions.ExpressionNode;
import Grammar.C99.C99Parser.Expression_statementContext;

public class ExpressionStatementNode extends StatementNode<Expression_statementContext>
{
	private ExpressionNode expression;
	public ExpressionStatementNode(ComponentNode<?> parent) {super(parent);}

	@Override
	public StatementNode<Expression_statementContext> interpret(Expression_statementContext node) throws Exception
	{
		expression = new ExpressionNode(this).interpret(node.expression());
		return this;
	}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function) {
		return expression.canCall(function);
	}

	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		return expression.getAssembly(leadingWhitespace);
	}
}
