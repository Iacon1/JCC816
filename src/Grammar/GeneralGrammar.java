// Created by Iacon1 on 2/7/2022.
// A grammar whose rules aren't neccessarily entered in CNF form.
// Non-terminals are given integer names automatically, sorry.

package Grammar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.function.Supplier;

import Logging.Logging;

@SuppressWarnings("serial")
public class GeneralGrammar<T1, T2> extends CNFGrammar<T1, T2>
{
	private Supplier<T2> nameSupplier;
	private Set<T2> primaryNonterminals;
	
	// CNF Rule with metadata built-in for re-constructing the original grammar with.
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
	
	private class RuleElement
	{
		private T2 nonTerminal;
		private T1 terminal;
		
		public RuleElement(T1 terminal, T2 nonTerminal)
		{
			this.terminal = terminal;
			this.nonTerminal = nonTerminal;
		}
		
		boolean isTerminal()
		{
			return terminal != null;
		}
	}
	// Used to build a rule.
	public class RuleBuilder
	{
		private T2 id;
		private List<T2> unitChain;
		
		private List<RuleElement> elements;
		
		public RuleBuilder(T2 id)
		{
			this.id = id;
			elements = new ArrayList<RuleElement>();
		}
		
		public RuleBuilder addTerminal(T1 terminal)
		{
			elements.add(new RuleElement(terminal, null));

			return this;
		}
		public RuleBuilder addT(T1 terminal) {return addTerminal(terminal);}
		
		public RuleBuilder addNonTerminal(T2 nonTerminal)
		{
			elements.add(new RuleElement(null, nonTerminal));
			
			return this;
		}
		public RuleBuilder addNT(T2 nonTerminal) {return addNonTerminal(nonTerminal);}
		public void queue() // Adds the builder to the general buffer.
		{
			buildBuffer.add(this);
		}
	}

	private List<RuleBuilder> buildBuffer;
	
	public GeneralGrammar(Supplier<T2> nameSupplier) {this.nameSupplier = nameSupplier; primaryNonterminals = new HashSet<T2>(); buildBuffer = new ArrayList<RuleBuilder>();}
	public RuleBuilder getBuilder(T2 id) {return new RuleBuilder(id);}

	private void applyTERM() // Remove nonsolitary terminals
	{
		int i = 0;
		while (i < buildBuffer.size())
		{
			RuleBuilder builder = buildBuffer.get(i);
			if (builder.id.equals("compound-statement"))
			{
				int k = 0;
			}
			if (builder.elements.size() == 1) {i += 1; continue;}
			for (int j = 0; j < builder.elements.size(); ++j)
			{
				if (builder.elements.get(j).isTerminal())
				{
					
					RuleElement e = builder.elements.get(j);
					T2 newRule = nameSupplier.get();
					getBuilder(newRule).addT(e.terminal).queue();
					e.terminal = null;
					e.nonTerminal = newRule;
				}
			}
			i += 1;
		}
	}
	private void applyBIN() // Remove oversized (i. e. more than 2) nonterminals
	{
		int i = 0;
		while (i < buildBuffer.size())
		{
			RuleBuilder builder = buildBuffer.get(i);
			if (builder.elements.size() >= 2)
			{
				T2 newRule = nameSupplier.get();
				RuleBuilder r = new RuleBuilder(newRule);
				r.elements = new ArrayList<RuleElement>(builder.elements);
				T2 start = builder.elements.get(0).nonTerminal;
				r.elements.remove(0);
				builder.elements = new ArrayList<RuleElement>();
				builder.addNT(start).addNT(newRule);
				r.queue();
			}
			i += 1;
		}
	}
	private void applyUNIT() // Remove unit nonterminals
	{
		int i = 0;
		while (i < buildBuffer.size())
		{
			RuleBuilder builder = buildBuffer.get(i); // Get a general-structure rule
			if (builder.elements.size() == 1 && !builder.elements.get(0).isTerminal()) // If it *is* a unit nonterminal
			{
				int j = 0;
				while (j < buildBuffer.size())
				{
					RuleBuilder builder2 = buildBuffer.get(j);
					if (builder2.id.equals(builder.elements.get(0).nonTerminal)) // Find all the rules it points to
					{
						RuleBuilder r = getBuilder(builder.id); // Make a new rule with the same name
						if (builder.unitChain == null) r.unitChain = new ArrayList<T2>(); // And update its chain by starting with ours
						else r.unitChain = new ArrayList<T2>(builder.unitChain);
						r.unitChain.add(0, builder2.id); // adding their name
						if (builder2.unitChain != null) r.unitChain.addAll(builder2.unitChain); // and then adding their chain
						r.elements = new ArrayList<RuleElement>(builder2.elements);
						r.queue();
					}
					j += 1;
				}
				buildBuffer.remove(i);
				i -= 1;
			}
			i += 1;
		}
	}
	public void updateCNF()
	{
		Logging.logNotice("General Grammar Size:" + buildBuffer.size());
		List<RuleBuilder> tempBuffer = new ArrayList<RuleBuilder>(buildBuffer);
		this.clear();
		// applySTART();
		applyTERM();
		applyBIN();
		// applyDEL();
		applyUNIT();
		
		for (RuleBuilder builder : buildBuffer)
		{
			if (builder.elements.get(0).isTerminal())
				addRule(builder.id, builder.unitChain, builder.elements.get(0).terminal);
			else
				addRule(builder.id, builder.unitChain, builder.elements.get(0).nonTerminal, builder.elements.get(1).nonTerminal);
		}
		buildBuffer = tempBuffer;
	}
	public void markPrimary(T2 rule) {primaryNonterminals.add(rule);}
	public boolean isPrimary(T2 rule) {return primaryNonterminals.contains(rule);}
}
