// By Iacon1
// Created 05/06/2023
// The program itself.
package C99Compiler.CompilerNodes.Statements;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.ExpressionNode;
import C99Compiler.CompilerNodes.Interfaces.AssemblableNode;
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
