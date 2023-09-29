// Created by Iacon1 on 2/7/2022.
// A grammar whose rules aren't neccessarily entered in CNF form.
// Non-terminals are given integer names automatically, sorry.

package Grammar;

import java.util.ArrayDeque;
import java.util.HashSet;
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
			int a, b, rule, length;
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
						Rule<T1, Integer> aRule = get(i);
						if (aRule.name.equals(a)) // Rule starts with A
						{
							if (aRule.isUnit()) addRule(rule, aRule.terminalValue);
							else addRule(rule, aRule.nonTerminalB, aRule.nonTerminalC);
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
				if (length > 3) b = build();
				else // Avoid creating a unit rule.
				{
					if (order.poll()) b = nonTerminals.poll();
					else {b = nextRule(); addRule(b, terminals.poll());}
				}
				if (id == -1) rule = nextRule(); // id not set.
				else rule = id; // id set.
				
				addRule(rule, a, b);
				break;
			}
			
			primaryNonterminals.add(rule);
			return rule;
		}
	}

	public GeneralGrammar() {primaryNonterminals = new HashSet<Integer>();}
	public RuleBuilder getBuilder(int id) {return new RuleBuilder(id);}
	public RuleBuilder getBuilder() {return getBuilder(-1);}

	public boolean isPrimary(Integer rule) {return primaryNonterminals.contains(rule);}
}
