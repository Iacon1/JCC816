// Created by Iacon1 on 10/22/2023.
//
package C99Compiler.CompilerNodes.Statements;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.ConstantExpressionNode;
import C99Compiler.Exceptions.ConstraintException;
import C99Compiler.Utils.AssemblyUtils;
import Grammar.C99.C99Parser.Labeled_statementContext;

public class LabeledStatementNode extends StatementNode<Labeled_statementContext>
{
	private StatementNode<?> statement;
	
	private String label;
	
	public LabeledStatementNode(ComponentNode<?> parent) {super(parent);}

	@Override
	public StatementNode<Labeled_statementContext> interpret(Labeled_statementContext node) throws Exception
	{
		statement = StatementNode.manufacture(this, node.statement());
		if (node.constant_expression() != null || node.getChild(0).getText().equals("default")) // case
		{
			if (getEnclosingSelection() == null || !getEnclosingSelection().isSwitch())
				throw new ConstraintException("6.8.1", 2, node.start);
			if (node.constant_expression() != null)
			{
				BaseExpressionNode<?> constExpr = new ConstantExpressionNode(this).interpret(node.constant_expression());
				label = getEnclosingSelection().getCaseLabel(constExpr);
			}
			else label = getEnclosingSelection().getDefaultLabel(true);
		}
		else label = getEnclosingFunction().getScope().getPrefix() + node.Identifier().getText();
		
		return this;
	}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function) {return statement.canCall(function);}

	@Override
	public boolean hasAssembly()
	{
		return true; // Always there as a label
	}
	@Override
	public String getAssembly(int leadingWhitespace, String returnAddr) throws Exception
	{
		return AssemblyUtils.getWhitespace(leadingWhitespace) + label + ":\n" + (statement.hasAssembly()? statement.getAssembly(leadingWhitespace, returnAddr) : "");
	}
}
