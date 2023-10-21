// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Statements;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.Expressions.BaseExpressionNode;
import Compiler.ComponentNodes.Expressions.ExpressionNode;
import Compiler.Utils.CompUtils;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Grammar.C99.C99Parser.Selection_statementContext;

public class SelectionStatementNode extends StatementNode<Selection_statementContext>
{
	private static int ifCount = 0;
	private int ifId;
	
	private BaseExpressionNode<?> expression;
	
	private StatementNode<?> ifStm, elseStm;
	boolean isSwitch;
	
	public SelectionStatementNode(ComponentNode<?> parent) {super(parent);}
	@Override
	public void finalize() {if (!isSwitch) ifCount -= 1;}
	@Override
	public StatementNode<Selection_statementContext> interpret(Selection_statementContext node) throws Exception
	{
		expression = new ExpressionNode(this).interpret(node.expression());
		ifStm = StatementNode.manufacture(this, node.statement(0));
		if (node.statement().size() == 2) elseStm = StatementNode.manufacture(this, node.statement().get(1));
		isSwitch = (node.getChild(0).getText().equals("switch"));
		
		if (!isSwitch) {ifId = ifCount; ifCount += 1;}
		return this;
	}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return expression.canCall(function) || ifStm.canCall(function) || elseStm.canCall(function);
	}

	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String whitespace = getWhitespace(leadingWhitespace);
		String assembly = "";
		
		if (!isSwitch)
		{
			if (expression.hasPropValue() && (Boolean) expression.getPropValue()) // Always true
				assembly += ifStm.getAssembly(leadingWhitespace);
			else if (expression.hasPropValue() && elseStm != null) // Always false
				assembly += elseStm.getAssembly(leadingWhitespace);
			else if (!expression.hasPropValue()) // Unknown
			{
				String skipName = "__IFNOT_" + ifId;
				String skipElse = "__IFNOTELSE_" + ifId;
				if (expression.hasAssembly())
					assembly += expression.getAssembly(leadingWhitespace);
				else if (expression.hasPropValue())
					assembly += byteCopier(whitespace, expression.getType().getSize(), CompUtils.operandA, expression.getPropValue());
				else
					assembly += byteCopier(whitespace, expression.getType().getSize(), CompUtils.operandA, expression.getVariable().getFullName());
				// Make sure variable loaded.
				assembly += whitespace + "BEQ\t" + skipName + "\n";
				assembly += ifStm.getAssembly(leadingWhitespace + CompUtils.indentSize);
				if (elseStm != null)
				{
					assembly += getWhitespace(leadingWhitespace + CompUtils.indentSize) + "JML\t" + skipElse + "\n";
					assembly += whitespace + skipName + ":\n";
					assembly += elseStm.getAssembly(leadingWhitespace + CompUtils.indentSize);
					assembly += whitespace + skipElse + ":\n";
				}
				else assembly += whitespace + skipName + ":\n";
			}
		}
		
		return assembly;
	}
	
	
}
