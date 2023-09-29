// Created by Iacon1 on 2/7/2022.
// A grammar whose rules aren't neccessarily entered in CNF form.
// Non-terminals are given integer names automatically, sorry.

package Grammar;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

@SuppressWarnings("serial")
public class GeneralGrammar<T1> extends CNFGrammar<T1, Integer>
{
	private Set<Integer> primaryNonterminals;
	
	private int nextRule()
	{
		return nonTerminalCount();
	}
	
	// Rule with metadata built-in for re-constructing the original grammar with.
	public static class TrackedRule<T1, T2> extends Rule<T1, T2>
	{
		public List<T2> unitChain; // If this rule was added to eliminate a unit rule
		public TrackedRule(T2 name, List<T2> unitChain, T1 terminalValue)
		{
			super(name, terminalValue);
			this.unitChain = unitChain;
		}
		
		public TrackedRule(T2 name, List<T2> unitChain, T2 nonTerminalA, T2 nonTerminalB)
		{
			super(name, nonTerminalA, nonTerminalB);
			this.unitChain = unitChain;
		}
		
		public TrackedRule(T2 name, List<T2> unitChain)
		{
			super(name);
			this.unitChain = unitChain;
		}
	}

	private void addRule(Integer name, List<Integer> unitChain, T1 terminalValue)
	{
		add(new TrackedRule<T1, Integer>(name, unitChain, terminalValue));
	}
	private void addRule(Integer name, List<Integer> unitChain, Integer nonTerminalA, Integer nonTerminalB)
	{
		add(new TrackedRule<T1, Integer>(name, unitChain, nonTerminalA, nonTerminalB));
	}
	@Override
	public void addRule(Integer name, T1 terminalValue)
	{
		addRule(name, null, terminalValue);
	}
	@Override
	public void addRule(Integer name, Integer nonTerminalA, Integer nonTerminalB)
	{
		addRule(name, null, nonTerminalA, nonTerminalB);
	}
	
	public List<Integer> getUnitChain(Integer ruleName, int subRule)
	{
		int subRulesToGo = subRule;
		for (int i = 0; i < size(); ++i)
		{
			if (get(i).name == ruleName)
				if (subRulesToGo == 0)
				{
					List<Integer> unitChain = ((TrackedRule<T1, Integer>) get(i)).unitChain;
					if (unitChain != null) return new ArrayList<Integer>(unitChain);
					else return null;
				}
				else subRulesToGo -= 1;
		}
		return null;
	}
	
	// Used to build a rule.
	public class RuleBuilder
	{
		private int id;
		
		private Queue<T1> terminals;
		private Queue<Integer> nonTerminals;
		private Queue<Boolean> order; // Used to assemble the CNF rules; 0 means a terminal and 1 means a terminal.
		
		public RuleBuilder(int id)
		{
			this.id = id;
			terminals = new ArrayDeque<T1>();
			nonTerminals = new ArrayDeque<Integer>();
			order = new ArrayDeque<Boolean>();
		}
		
		public RuleBuilder addTerminal(T1 terminal)
		{
			terminals.add(terminal);
			order.add(false);
			
			return this;
		}
		public RuleBuilder addT(T1 terminal) {return addTerminal(terminal);}
		
		public RuleBuilder addNonTerminal(Integer nonTerminal)
		{
			nonTerminals.add(nonTerminal);
			order.add(true);
			
			return this;
		}
		public RuleBuilder addNT(Integer nonTerminal) {return addNonTerminal(nonTerminal);}
		public int build() // Builds the rule and converts it to CNF, adding it to the grammar.
		{
			int a, b, rule, length, tempId;
			length = order.size();
			switch (length)
			{
			case 1:	// Only one token.
				if (id == -1) rule = nextRule();
				else rule = id;
				
				if (order.poll())
				// Nonterminal; Copy all of the nonterminal's productions as per https://en.wikipedia.org/wiki/Chomsky_normal_form#UNIT:_Eliminate_unit_rules.
				{
					a = nonTerminals.poll(); // A
					for (int i = 0; i < size(); ++i)
					{
						TrackedRule<T1, Integer> aRule = (TrackedRule<T1, Integer>) get(i);
						if (aRule.name.equals(a)) // Rule starts with A
						{
							List<Integer> unitChain = new ArrayList<Integer>();
							if (aRule.unitChain != null) unitChain.addAll(aRule.unitChain);
							unitChain.add(0, a);
							
							if (aRule.isUnit()) addRule(rule, unitChain, aRule.terminalValue);
							else addRule(rule, unitChain, aRule.nonTerminalB, aRule.nonTerminalC);
						}
					}
				}
				else addRule(rule, terminals.poll());
				break;
			case 2:  // Two tokens
				if (order.poll()) a = nonTerminals.poll();
				else {a = nextRule(); addRule(a, terminals.poll());}
				if (order.poll()) b = nonTerminals.poll();
				else {b = nextRule(); addRule(b, terminals.poll());}
				
				if (id == -1) rule = nextRule(); // id not set.
				else rule = id; // id set.
				addRule(rule, a, b);
				break;
			default: // Three or more tokens.
				if (length < 1) return -1; // If size unusable.
				
				if (order.poll()) a = nonTerminals.poll();
				else {a = nextRule(); addRule(a, terminals.poll());}
				if (order.poll()) b = nonTerminals.poll();
				else {b = nextRule(); addRule(b, terminals.poll());}
				
				rule = nextRule();
				addRule(rule, a, b);
				a = rule;
				tempId = id;
				id = -1;
				if (length > 3) b = build();
				else // Avoid creating a unit rule.
				{
					if (order.poll()) b = nonTerminals.poll();
					else {b = nextRule(); addRule(b, terminals.poll());}
				}
				id = tempId;
				if (id == -1) rule = nextRule(); // id not set.
				else rule = id; // id set.
				
				addRule(rule, a, b);
				break;
			}
			
			if (id != -1) primaryNonterminals.add(id);
			return rule;
		}
	}

	public GeneralGrammar() {primaryNonterminals = new HashSet<Integer>();}
	public RuleBuilder getBuilder(int id) {return new RuleBuilder(id);}
	public RuleBuilder getBuilder() {return getBuilder(-1);}

	public boolean isPrimary(Integer rule) {return primaryNonterminals.contains(rule);}
}
