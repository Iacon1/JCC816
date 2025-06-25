// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Statements;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.Expressions.AdditiveExpressionNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.EqualityExpressionNode;
import C99Compiler.CompilerNodes.Expressions.ExpressionNode;
import C99Compiler.CompilerNodes.Expressions.RelationalExpressionNode;
import C99Compiler.CompilerNodes.Expressions.ShiftExpressionNode;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.ScratchSource;
import C99Compiler.Utils.AssemblyUtils.ByteCopier;
import C99Compiler.Utils.AssemblyUtils.ComparitiveJump;
import C99Compiler.Utils.OperandSources.ConstantSource;
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
	public ProgramState getStateBefore(ProgramState state, ComponentNode<?> child) throws Exception
	{
		if (!children.contains(child))
			throw new IllegalArgumentException();
		
		if (child == expression)
			return state;
		if (expression.hasAssembly(state))
			state = expression.getStateAfter(state);
		return state;
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
		String whitespace = state.getWhitespace();
		MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);

		if (!isSwitch) // If statement
		{
			if (expression.hasPropValue(pair.state) && (expression.getPropBool(pair.state) || expression.getPropLong(pair.state) != 0)) // It's always true
				ifStm.apply(pair);
			else if (expression.hasPropValue(pair.state) && elseStm != null) // It's always false
				elseStm.apply(pair);
			else if (!expression.hasPropValue(pair.state)) // Unknown
			{
				String skipName = "__IFNOT_" + selId;
				ProgramState ifState, elseState;
				elseState = pair.state;
				
				if (expression.hasAssembly(pair.state))
				{
					if (!expression.isLogical())
					{
						pair.state = pair.state.reserveScratchBlock(expression.getSize());
						ScratchSource exprSource = pair.state.lastScratchSource();
						pair.state = pair.state.setDestSource(exprSource);
						applyWithRegistered(pair, new EqualityExpressionNode(this, expression));
						new ByteCopier(exprSource.getSize(), exprSource, exprSource).apply(pair);
					}
					else
					{
						pair.state = pair.state.setDestSource(null);
						applyWithRegistered(pair, expression);
					}
				}
				else
					new EqualityExpressionNode(null, expression).apply(pair);
				
				ComparitiveJump cmpJump;
				if (elseStm != null)
					cmpJump = new ComparitiveJump(ifStm, elseStm, skipName, getEndLabel(), expression.isLogical(), labelLine(pair.state, ifLineNo));
				else
					cmpJump = new ComparitiveJump(ifStm, null, skipName, null, expression.isLogical(), labelLine(pair.state, ifLineNo));
				cmpJump.apply(pair);
			}
		}
		else // Switch
		{
			long smallestCase = 0, largestCase = 0;
			boolean first = true;
			Set<Long> caseValues = new HashSet<Long>();
			BaseExpressionNode<?> smallestExpr = null, largestExpr = null;
			for (BaseExpressionNode<?> node : cases.keySet()) // Determine case values
			{
				long l = node.getPropLong(pair.state);
				if (first)
				{
					smallestCase = l;
					largestCase = l;
					first = false;
				}
				else
				{
					smallestCase = Math.min(smallestCase, l);
					largestCase = Math.max(largestCase, l);
				}
				if (smallestCase == l)
					smallestExpr = node;
				if (largestCase == l)
					largestExpr = node;
				caseValues.add(l);
			}
			if (largestExpr == null)
				return pair.getImmutable();			
			pair.state = pair.state.reserveScratchBlock(expression.getSize());
			ScratchSource exprSource = pair.state.lastScratchSource();
			pair.state = pair.state.setDestSource(exprSource);
			// If greater than largest case, skip
			String miscLabel1 = CompUtils.getMiscLabel(), miscLabel2 = CompUtils.getMiscLabel();
			if (expression.hasAssembly(pair.state))
				applyWithRegistered(pair, expression);
			else if (expression.hasPropValue(pair.state))
				new ByteCopier(exprSource.getSize(), exprSource, new ConstantSource(expression.getPropValue(state), exprSource.getSize())).apply(pair);
			else if (expression.hasLValue(state))
				new ByteCopier(exprSource.getSize(), exprSource, expression.getLValue(state).getSource()).apply(pair);
			new RelationalExpressionNode(this, "<", 
					largestExpr, 
					new DummyExpressionNode(this, expression.getType(), exprSource),
					hasDefault? getDefaultLabel(false) : getEndLabel(), miscLabel1, false).apply(pair);
			pair.assembly += whitespace + miscLabel1 + ":\n";
			// If smaller than smallest case, skip
			new RelationalExpressionNode(this, ">", 
					smallestExpr, 
					new DummyExpressionNode(this, expression.getType(), exprSource),
					hasDefault? getDefaultLabel(false) : getEndLabel(), miscLabel2, false).apply(pair);
			pair.assembly += whitespace + miscLabel2 + ":\n";
			
			
			// Calculate jump table address
			pair.state = pair.state.reserveScratchBlock(expression.getSize());
			ScratchSource sourceS = pair.state.lastScratchSource();
			pair.state = pair.state.setDestSource(sourceS);
			if (smallestCase != 0)
			{
				new AdditiveExpressionNode(this, "-", 
						new DummyExpressionNode(this, expression.getType(), exprSource),
						new DummyExpressionNode(this, smallestCase)).apply(pair);
				new ShiftExpressionNode(this, "<<",
						new DummyExpressionNode(this, expression.getType(), sourceS),
						new DummyExpressionNode(this, 1)).apply(pair);
			}
			else
			{
				new ShiftExpressionNode(this, "<<",
						new DummyExpressionNode(this, expression.getType(), exprSource),
						new DummyExpressionNode(this, 1)).apply(pair);
			}
			pair.assembly += whitespace + "TAX\n";
			pair.assembly += whitespace + "JMP\t(" + getTableLabel() + ",x)\n";
			pair.state = pair.state.releaseScratchBlock(sourceS);
			pair.assembly += whitespace + getTableLabel() + ":\n";
			for (long i = smallestCase; i <= largestCase; ++i)
			{
				if (caseValues.contains(i))
					pair.assembly += whitespace + whitespace + ".word\t.LoWord(" + getCaseLabel(i) + ")\n";
				else pair.assembly += whitespace + whitespace + ".word\t.LoWord(" + getDefaultLabel(false) + ")\n";
			}
			switchStm.apply(pair);
			pair.state = pair.state.wipe();
			if (!hasDefault) pair.assembly += whitespace + getDefaultLabel(false) + ":\n";
			pair.assembly += whitespace + getEndLabel() + ":\n";
		}
		
		pair.state = pair.state.wipe();
		return pair.getImmutable();
	}	
}
