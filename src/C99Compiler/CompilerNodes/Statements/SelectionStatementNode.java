// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Statements;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.BranchingExpressionNode;
import C99Compiler.CompilerNodes.Expressions.EqualityExpressionNode;
import C99Compiler.CompilerNodes.Expressions.ExpressionNode;
import C99Compiler.CompilerNodes.Expressions.RelationalExpressionNode;
import C99Compiler.CompilerNodes.Expressions.ShiftExpressionNode;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.Utils.ScratchManager.ScratchSource;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Selection_statementContext;

public class SelectionStatementNode extends StatementNode<Selection_statementContext>
{
	private static int selCount = 0;
	private int selId;
	
	private BaseExpressionNode<?> expression;
	
	private StatementNode<?> switchStm, ifStm, elseStm;
	
	private Map<BaseExpressionNode<?>, String> cases;
	private boolean isSwitch;
	private boolean hasDefault;
	
	
	public SelectionStatementNode(ComponentNode<?> parent)
	{
		super(parent);
		selId = selCount;
		selCount += 1;
		cases = new HashMap<BaseExpressionNode<?>, String>();
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
		}
		
		return this;
	}
	
	public boolean isSwitch() {return isSwitch;}
	public String getCaseLabel(long value)
	{
		if (value < 0)
			return "__CASE_" + selId + "_N" + -value;
		else
			return "__CASE_" + selId + "_" + value;
	}
	public String getCaseLabel(BaseExpressionNode<?> constExpr)
	{
		cases.put(constExpr, getCaseLabel(constExpr.getPropLong()));
		return cases.get(constExpr);
	}
	public String getTableLabel()
	{
		return "__SWITCH_TABLE_" + selId;
	}
	public String getDefaultLabel(boolean register)
	{
		if (register) hasDefault = true;
		return "__CASE_" + selId + "_" + "DEF";
	}
	public String getEndLabel()
	{
		if (!isSwitch)
			if (elseStm != null)
				return "__IFNOTELSE_" + selId;
			else return "__IFNOT_" + selId;
		else return "__CASE_SKIP_" + selId;
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
			if (expression.hasPropValue() && expression.getPropBool() || expression.getPropLong() != 0) // Always true
				assembly += ifStm.getAssembly(leadingWhitespace);
			else if (expression.hasPropValue() && elseStm != null) // Always false
				assembly += elseStm.getAssembly(leadingWhitespace);
			else if (!expression.hasPropValue()) // Unknown
			{
				String skipName = "__IFNOT_" + selId;
				if (expression.hasAssembly())
				{
					if (BranchingExpressionNode.class.isAssignableFrom(expression.getClass())) // Branchable
						assembly += ((BranchingExpressionNode<?,?,?,?>) expression).getAssembly(leadingWhitespace, ":+", skipName, new ScratchManager(), new DetailsTicket());
					else
					{
						assembly += expression.getAssembly(leadingWhitespace);
						assembly += whitespace + "BEQ\t" + skipName + "\n";
						assembly += ifStm.getAssembly(leadingWhitespace + CompConfig.indentSize);
					}
				}
				else
				{
					if (expression.hasPropValue())
						assembly += AssemblyUtils.byteCopier(whitespace, expression.getSize(), CompConfig.callResultSource(expression.getSize()), new ConstantSource(expression.getPropValue(), expression.getSize()));
					else
						assembly += EqualityExpressionNode.getIsZero(whitespace, null, new ScratchManager(), expression.getLValue().getSource(), new DetailsTicket());
					assembly += whitespace + "BEQ\t" + skipName + "\n";
					assembly += ifStm.getAssembly(leadingWhitespace + CompConfig.indentSize);
				}
				ifStm.clearPossibleValues();
				if (elseStm != null)
				{
					assembly += AssemblyUtils.getWhitespace(leadingWhitespace + CompConfig.indentSize) + "JML\t" + getEndLabel() + "\n";
					assembly += whitespace + skipName + ":\n";
					assembly += elseStm.getAssembly(leadingWhitespace + CompConfig.indentSize);
					elseStm.clearPossibleValues();
				}
				assembly += whitespace + getEndLabel() + ":\n";
			}
		}
		else
		{
			switchStm.getAssembly(leadingWhitespace + CompConfig.indentSize);
			
			long smallestCase = 0, largestCase = 0;
			Set<Long> caseValues = new HashSet<Long>();
			for (BaseExpressionNode<?> node : cases.keySet())
			{
				long l = node.getPropLong();
				smallestCase = Math.min(smallestCase, l);
				largestCase = Math.max(largestCase, l);
				caseValues.add(l);
			}
			ScratchManager scratchManager = new ScratchManager();
			assembly += new RelationalExpressionNode(	// If largestCase < value of expr then go to default
					this, "<", 
					new DummyExpressionNode(this, CompUtils.getSmallestType(largestCase), Long.valueOf(largestCase)),
					expression).getAssembly(leadingWhitespace, hasDefault? getDefaultLabel(false) : getEndLabel(), ":+", scratchManager, new DetailsTicket());
			assembly += whitespace.substring(1) + ":\n";
			ScratchSource sourceS = scratchManager.reserveScratchBlock(1);
			assembly += whitespace + new ShiftExpressionNode(this, "<<", expression, new DummyExpressionNode(this, CompUtils.getSmallestType(largestCase), Long.valueOf(largestCase)))
					.getAssembly(leadingWhitespace, sourceS);
			assembly += whitespace + "TAX\n";
			assembly += whitespace + "JMP\t(" + getTableLabel() + ",X)\n";
			scratchManager.releaseScratchBlock(sourceS);
			assembly += whitespace + getTableLabel() + ":\n";
			for (long i = smallestCase; i <= largestCase; ++i)
			{
				if (caseValues.contains(i))
					assembly += whitespace + ".word\t" + getCaseLabel(i) + "\n";
				else assembly += whitespace + ".word\t" + getDefaultLabel(false) + "\n";
			}
			assembly += switchStm.getAssembly(leadingWhitespace + CompConfig.indentSize);
			switchStm.clearPossibleValues();
			if (!hasDefault) assembly += whitespace + getDefaultLabel(false) + ":\n";
			assembly += whitespace + getEndLabel() + ":\n";
		}
		
		ScratchManager.clearPointers();
		return assembly;
	}	
}
