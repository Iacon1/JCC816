// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Statements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.Expressions.BaseExpressionNode;
import Compiler.ComponentNodes.Expressions.ExpressionNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompConfig;
import Compiler.Utils.CompUtils;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.ConstantSource;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Grammar.C99.C99Parser.Selection_statementContext;

public class SelectionStatementNode extends StatementNode<Selection_statementContext>
{
	private static int selCount = 0;
	private int selId;
	
	private BaseExpressionNode<?> expression;
	
	private StatementNode<?> switchStm, ifStm, elseStm;
	
	private Map<BaseExpressionNode<?>, String> cases;
	boolean isSwitch;
	
	
	public SelectionStatementNode(ComponentNode<?> parent)
	{
		super(parent);
		selId = selCount;
		selCount += 1;
	}
	@Override
	public void finalize() {selCount -= 1;}
	@Override
	public StatementNode<Selection_statementContext> interpret(Selection_statementContext node) throws Exception
	{
		expression = new ExpressionNode(this).interpret(node.expression());
		isSwitch = (node.getChild(0).getText().equals("switch"));
		if (!isSwitch)
		{
			ifStm = StatementNode.manufacture(this, node.statement(0));
			if (node.statement().size() == 2) elseStm = StatementNode.manufacture(this, node.statement().get(1));
		}
		else
		{
			switchStm = StatementNode.manufacture(this, node.statement(0));
			cases = new HashMap<BaseExpressionNode<?>, String>();
		}
		
		return this;
	}
	
	public boolean isSwitch() {return isSwitch;}
	public String getLabel(BaseExpressionNode<?> constExpr)
	{
		cases.put(constExpr, "__CASE_" + selId + "_" + cases.size());
		return cases.get(constExpr);
	}
	public String getDefaultLabel()
	{
		return "__CASE_" + selId + "_" + "DEF";
	}
	public String getEndLabel()
	{
		if (!isSwitch)
			if (elseStm != null)
				return "__IFNOTELSE_" + selId;
			else return "__IFNOT_" + selId;
		else return null; // TODO
	}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return expression.canCall(function) || (switchStm != null && switchStm.canCall(function)) || (ifStm != null && ifStm.canCall(function)) || (elseStm != null && elseStm.canCall(function));
	}
	
	@Override
	public boolean hasAssembly()
	{
		if (expression.hasAssembly()) return true;
		if (!isSwitch)
		{
			if (expression.hasPropValue() && expression.getPropBool()) return ifStm.hasAssembly();
			else if (expression.hasPropValue()) return elseStm.hasAssembly();
			else return ifStm.hasAssembly() || elseStm.hasAssembly();
		}
		else return switchStm.hasAssembly();
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
		
		if (!isSwitch)
		{
			if (expression.hasPropValue() && (((Number) expression.getPropValue()).longValue() != 0)) // Always true
				assembly += ifStm.getAssembly(leadingWhitespace);
			else if (expression.hasPropValue() && elseStm != null) // Always false
				assembly += elseStm.getAssembly(leadingWhitespace);
			else if (!expression.hasPropValue()) // Unknown
			{
				String skipName = "__IFNOT_" + selId;
				if (expression.hasAssembly())
					assembly += expression.getAssembly(leadingWhitespace);
				else if (expression.hasPropValue())
					assembly += AssemblyUtils.byteCopier(whitespace, expression.getSize(), CompConfig.callResultSource(expression.getSize()), new ConstantSource(expression.getPropValue(), expression.getSize()));
				else
					assembly += AssemblyUtils.byteCopier(whitespace, expression.getSize(), CompConfig.callResultSource(expression.getSize()), expression.getLValue().getSource());
				// Make sure variable loaded.
				assembly += whitespace + "BEQ\t" + skipName + "\n";
				assembly += ifStm.getAssembly(leadingWhitespace + CompConfig.indentSize);
				if (elseStm != null)
				{
					assembly += AssemblyUtils.getWhitespace(leadingWhitespace + CompConfig.indentSize) + "JML\t" + getEndLabel() + "\n";
					assembly += whitespace + skipName + ":\n";
					assembly += elseStm.getAssembly(leadingWhitespace + CompConfig.indentSize);
				}
				assembly += whitespace + getEndLabel() + ":\n";
			}
		}
		else
		{
			
			assembly += switchStm.getAssembly(leadingWhitespace + CompConfig.indentSize);
		}
		
		ScratchManager.clearPointers();
		return assembly;
	}	
}
