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
import C99Compiler.CompilerNodes.Dummies.DummyValueNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.BranchingExpressionNode;
import C99Compiler.CompilerNodes.Expressions.EqualityExpressionNode;
import C99Compiler.CompilerNodes.Expressions.ExpressionNode;
import C99Compiler.CompilerNodes.Expressions.RelationalExpressionNode;
import C99Compiler.CompilerNodes.Expressions.ShiftExpressionNode;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.ScratchSource;
import C99Compiler.Utils.AssemblyUtils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.ByteCopier;
import C99Compiler.Utils.AssemblyUtils.ComparitiveJump;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Selection_statementContext;

public class SelectionStatementNode extends SequencePointStatementNode<Selection_statementContext>
{	
	private String selId;
	private BaseExpressionNode<?> expression;
	
	private StatementNode<?> switchStm, ifStm, elseStm;
	private int ifLineNo, elseLineNo;
	
	private Map<BaseExpressionNode<?>, String> cases;
	private boolean isSwitch;
	private boolean hasDefault;
	
	
	public SelectionStatementNode(ComponentNode<?> parent)
	{
		super(parent);
		selId = CompUtils.getSafeUUID();
		cases = new HashMap<BaseExpressionNode<?>, String>();
	}
	@Override
	public StatementNode<Selection_statementContext> interpret(Selection_statementContext node) throws Exception
	{
		expression = new ExpressionNode(this).interpret(node.expression());
		isSwitch = (node.getChild(0).getText().equals("switch"));
		if (!isSwitch)
		{
			ifStm = StatementNode.manufacture(this, node.statement(0));
			ifLineNo = node.statement(0).start.getLine() - 1;
			if (node.statement().size() == 2)
			{
				elseStm = StatementNode.manufacture(this, node.statement().get(1));
				elseLineNo = node.statement(1).start.getLine() - 1;
			}
		}
		else
		{
			switchStm = StatementNode.manufacture(this, node.statement(0));
		}
		
		return this;
	}
	
	public boolean isSwitch() {return isSwitch;}
	private String getCaseLabel(long value)
	{
		if (value < 0)
			return "__CASE_" + selId + "_N" + -value;
		else
			return "__CASE_" + selId + "_" + value;
	}
	public String getCaseLabel(ProgramState state, BaseExpressionNode<?> constExpr)
	{
		cases.put(constExpr, getCaseLabel(constExpr.getPropLong(state)));
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
	public boolean canCall(ProgramState state, FunctionDefinitionNode function)
	{
		return expression.canCall(state, function) || (switchStm != null && switchStm.canCall(state, function)) || (ifStm != null && ifStm.canCall(state, function)) || (elseStm != null && elseStm.canCall(state, function));
	}
	
	@Override
	public boolean hasAssembly(ProgramState state)
	{
		if (expression.hasAssembly(state)) return true;
		if (!isSwitch)
		{
			if (expression.hasPropValue(state) && expression.getPropBool(state)) return ifStm.hasAssembly(state);
			else if (expression.hasPropValue(state) && elseStm != null) return elseStm.hasAssembly(state);
			else if (elseStm != null) return ifStm.hasAssembly(state) || elseStm.hasAssembly(state);
			else return ifStm.hasAssembly(state);
		}
		else return switchStm.hasAssembly(state);
	}
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		AssemblyStatePair pair = new AssemblyStatePair("", state);
		
		String whitespace = state.getWhitespace();

		if (!isSwitch) // If statement
		{
			if (expression.hasPropValue(pair.state) && (expression.getPropBool(pair.state) || expression.getPropLong(pair.state) != 0)) // It's always true
			{
				pair = pair.addAssembly(labelLine(state.indent(), ifLineNo));
				pair = ifStm.apply(pair);
			}
			else if (expression.hasPropValue(pair.state) && elseStm != null) // It's always false
			{
				pair = pair.addAssembly(labelLine(pair.state.indent(), elseLineNo));
				pair = elseStm.apply(pair);
			}
			else if (!expression.hasPropValue(pair.state)) // Unknown
			{
				String skipName = "__IFNOT_" + selId;
				ProgramState ifState, elseState;
				elseState = pair.state;
				
				if (expression.hasAssembly(pair.state))
				{
					pair = pair.replaceState(pair.state.reserveScratchBlock(expression.getSize()));
					ScratchSource exprSource = pair.state.lastScratchSource();
					pair = pair.replaceState(pair.state.setDestSource(exprSource));
					pair = new EqualityExpressionNode(this, expression).apply(pair);
					pair = applyWithRegistered(pair, expression);
					pair = new ByteCopier(exprSource.getSize(), exprSource, exprSource).apply(pair);
					
				}
				else
					pair = new EqualityExpressionNode(expression).apply(pair);
				
				ComparitiveJump cmpJump = new ComparitiveJump(ifStm, skipName, elseStm != null ? getEndLabel() : null, true, labelLine(pair.state, ifLineNo));
				pair = cmpJump.apply(pair);
				pair = pair.replaceState(ifStm.clearPossibleValues(pair.state));
				ifState = pair.state;
				
				if (elseStm != null)
				{
					pair = pair.replaceState(elseState.indent());
					pair.addAssembly(labelLine(pair.state, elseLineNo));
					pair = elseStm.apply(pair);
					pair = pair.replaceState(elseStm.clearPossibleValues(pair.state));
					pair = pair.addAssembly(whitespace + getEndLabel() + ":\n");
					pair = pair.replaceState(ifState.combine(elseState));
				}
			}
		}
		else
		{
			long smallestCase = 0, largestCase = 0;
			Set<Long> caseValues = new HashSet<Long>();
			BaseExpressionNode<?> largestExpr = null;
			for (BaseExpressionNode<?> node : cases.keySet()) // Determine case values
			{
				long l = node.getPropLong(pair.state);
				smallestCase = Math.min(smallestCase, l);
				largestCase = Math.max(largestCase, l);
				if (largestCase == l)
					largestExpr = node;
				caseValues.add(l);
			}
			if (largestExpr == null)
				return pair;
			pair = pair.replaceState(pair.state.reserveScratchBlock(expression.getSize()));
			ScratchSource exprSource = pair.state.lastScratchSource();
			// If greater than largest case, skip
			String miscLabel = CompUtils.getMiscLabel();
			if (expression.hasAssembly(pair.state))
				pair = applyWithRegistered(pair, expression);
			else if (expression.hasPropValue(pair.state))
				pair = new ByteCopier(exprSource.getSize(), exprSource, new ConstantSource(expression.getPropValue(state), exprSource.getSize())).apply(pair);
			else if (expression.hasLValue())
				pair = new ByteCopier(exprSource.getSize(), exprSource, expression.getLValue().getSource()).apply(pair);
			pair = new RelationalExpressionNode(this, "<=", 
					largestExpr, 
					new DummyExpressionNode(this, expression.getType(), exprSource),
					hasDefault? getDefaultLabel(false) : getEndLabel(), miscLabel, false).apply(pair);
			pair = pair.addAssembly(whitespace + miscLabel + ":\n");
			
			pair = pair.replaceState(pair.state.reserveScratchBlock(expression.getSize()));
			ScratchSource sourceS = pair.state.lastScratchSource();
			pair = pair.replaceState(pair.state.setDestSource(sourceS));
			pair = new ShiftExpressionNode(this, "<<", new DummyExpressionNode(this, expression.getType(), exprSource), new DummyExpressionNode(this, 1)).apply(pair);
			pair = pair.addAssembly(whitespace + "TAX\n");
			pair = pair.addAssembly(whitespace + "JMP\t(" + getTableLabel() + ",x)\n");
			pair = pair.replaceState(pair.state.releaseScratchBlock(sourceS));
			pair = pair.addAssembly(whitespace + getTableLabel() + ":\n");
			for (long i = smallestCase; i <= largestCase; ++i)
			{
				if (caseValues.contains(i))
					pair = pair.addAssembly(whitespace + whitespace + ".word\t.LoWord(" + getCaseLabel(i) + ")\n");
				else pair = pair.addAssembly(whitespace + whitespace + ".word\t.LoWord(" + getDefaultLabel(false) + ")\n");
			}
			pair = switchStm.apply(pair);
			pair = pair.replaceState(switchStm.clearPossibleValues(pair.state));
			if (!hasDefault) pair.addAssembly(whitespace + getDefaultLabel(false) + ":\n");
			pair = pair.addAssembly(whitespace + getEndLabel() + ":\n");
		}
		
		pair = pair.replaceState(pair.state.wipe());
		return pair;
	}	
}
