// Created by Iacon1 on 2/7/2022.
// A grammar whose rules aren't neccessarily entered in CNF form.
// Non-terminals are given integer names automatically, sorry.

package Grammar;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.function.Supplier;

@SuppressWarnings("serial")
public class GeneralGrammar<T1, T2> extends CNFGrammar<T1, T2>
{
	private Supplier<T2> nameSupplier;
	private Set<T2> primaryNonterminals;
	
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

		@Override
		public String toString()
		{
			String chain = name.toString();
			if (unitChain != null) for (T2 link : unitChain) chain += " > " + link.toString();
			if (terminalValue != null) return chain + ": " + terminalValue.toString();
			else return chain + ": " + nonTerminalB.toString() + " " + nonTerminalC.toString();
		}

		public boolean equals(Object obj)
		{
			if (obj.getClass().equals(this.getClass()))
			{
				TrackedRule<T1, T2> other = (TrackedRule<T1, T2>) obj;
				if (
						(other.name == null && name != null) ||
						(other.nonTerminalB == null && nonTerminalB != null) ||
						(other.nonTerminalC == null && nonTerminalC != null) ||
						(other.terminalValue == null && terminalValue != null) ||
						(other.unitChain == null && unitChain != null))
					return false;
				if (
						(other.name != null && name == null) ||
						(other.nonTerminalB != null && nonTerminalB == null) ||
						(other.nonTerminalC != null && nonTerminalC == null) ||
						(other.terminalValue != null && terminalValue == null) ||
						(other.unitChain != null && unitChain == null))
					return false;
				if (
						(other.name == null || other.name.equals(name)) &&
						(other.nonTerminalB == null || other.nonTerminalB.equals(nonTerminalB)) &&
						(other.nonTerminalC == null || other.nonTerminalC.equals(nonTerminalC)) &&
						(other.terminalValue == null || other.terminalValue.equals(terminalValue)) &&
						(other.unitChain == null || other.unitChain.equals(unitChain)))
					return true;
				else return false;
			}
			else return false;
		}
	}

	private void addRule(T2 name, List<T2> unitChain, T1 terminalValue)
	{
		TrackedRule<T1, T2> rule = new TrackedRule<T1, T2>(name, unitChain, terminalValue);
		for (Rule<T1, T2> other : this) if (rule.equals(other)) return;
		add(rule);
	}
	private void addRule(T2 name, List<T2> unitChain, T2 nonTerminalA, T2 nonTerminalB)
	{
		TrackedRule<T1, T2> rule = new TrackedRule<T1, T2>(name, unitChain, nonTerminalA, nonTerminalB);
		for (Rule<T1, T2> other : this) if (rule.equals(other)) return;
		add(rule);
	}
	@Override
	public void addRule(T2 name, T1 terminalValue)
	{
		addRule(name, null, terminalValue);
	}
	@Override
	public void addRule(T2 name, T2 nonTerminalA, T2 nonTerminalB)
	{
		addRule(name, null, nonTerminalA, nonTerminalB);
	}
	
	public List<T2> getUnitChain(T2 ruleName, int subRule)
	{
		int subRulesToGo = subRule;
		for (int i = 0; i < size(); ++i)
		{
			if (get(i).name == ruleName)
				if (subRulesToGo == 0)
				{
					List<T2> unitChain = ((TrackedRule<T1, T2>) get(i)).unitChain;
					if (unitChain != null) return new ArrayList<T2>(unitChain);
					else return null;
				}
				else subRulesToGo -= 1;
		}
		return null;
	}
	
	// Used to build a rule.
	public class RuleBuilder
	{
		private T2 id;
		
		private Queue<T1> terminals;
		private Queue<T2> nonTerminals;
		private Queue<Boolean> order; // Used to assemble the CNF rules; 0 means a terminal and 1 means a terminal.
		
		public RuleBuilder(T2 id)
		{
			this.id = id;
			terminals = new ArrayDeque<T1>();
			nonTerminals = new ArrayDeque<T2>();
			order = new ArrayDeque<Boolean>();
		}
		
		public RuleBuilder addTerminal(T1 terminal)
		{
			terminals.add(terminal);
			order.add(false);
			
			return this;
		}
		public RuleBuilder addT(T1 terminal) {return addTerminal(terminal);}
		
		public RuleBuilder addNonTerminal(T2 nonTerminal)
		{
			nonTerminals.add(nonTerminal);
			order.add(true);
			
			return this;
		}
		public RuleBuilder addNT(T2 nonTerminal) {return addNonTerminal(nonTerminal);}
		public T2 build() // Builds the rule and converts it to CNF, adding it to the grammar.
		{
			T2 a, b, rule, tempId;
			int length;
			length = order.size();
			switch (length)
			{
			case 1:	// Only one token.
				if (id == null) rule = nameSupplier.get();
				
				else rule = id;
				
				if (order.poll())
				// Nonterminal; Copy all of the nonterminal's productions as per https://en.wikipedia.org/wiki/Chomsky_normal_form#UNIT:_Eliminate_unit_rules.
				{
					a = nonTerminals.poll(); // A
					for (int i = 0; i < size(); ++i)
					{
						TrackedRule<T1, T2> aRule = (TrackedRule<T1, T2>) get(i);
						if (aRule.name.equals(a)) // Rule starts with A
						{
							List<T2> unitChain = new ArrayList<T2>();
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
				else {a = nameSupplier.get(); addRule(a, terminals.poll());}
				if (order.poll()) b = nonTerminals.poll();
				else {b = nameSupplier.get(); addRule(b, terminals.poll());}
				
				if (id == null) rule = nameSupplier.get(); // id not set.
				else rule = id; // id set.
				addRule(rule, a, b);
				break;
			default: // Three or more tokens.
				if (length < 1) return null; // If size unusable.
				
				if (order.poll()) a = nonTerminals.poll();
				else {a = nameSupplier.get(); addRule(a, terminals.poll());}
				if (order.poll()) b = nonTerminals.poll();
				else {b = nameSupplier.get(); addRule(b, terminals.poll());}
				
				rule = nameSupplier.get();
				addRule(rule, a, b);
				a = rule;
				tempId = id;
				id = null;
				if (length > 3) b = build();
				else // Avoid creating a unit rule.
				{
					if (order.poll()) b = nonTerminals.poll();
					else {b = nameSupplier.get(); addRule(b, terminals.poll());}
				}
				id = tempId;
				if (id == null) rule = nameSupplier.get(); // id not set.
				else rule = id; // id set.
				
				addRule(rule, a, b);
				break;
			}
			
			if (id != null) primaryNonterminals.add(id);
			return rule;
		}
	}

	public GeneralGrammar(Supplier<T2> nameSupplier) {this.nameSupplier = nameSupplier; primaryNonterminals = new HashSet<T2>();}
	public RuleBuilder getBuilder(T2 id) {return new RuleBuilder(id);}
	public RuleBuilder getBuilder() {return getBuilder(null);}

	public void markPrimary(T2 rule) {primaryNonterminals.add(rule);}
	public boolean isPrimary(T2 rule) {return primaryNonterminals.contains(rule);}
}
