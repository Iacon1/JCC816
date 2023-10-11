// Created by Iacon1 on 2/14/2022.
// Parser that can parse GeneralGrammars with respect to their intended structure.

package Grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GeneralParser extends CYKParser
{
	public static class GeneralNode<T1, T2>
	{
		public T2 ruleName;
		public List<T2> ruleChain;
		public int subRule;
		public List<T1> childrenT;
		public List<GeneralNode<T1, T2>> childrenNodes;
		
		public GeneralNode(T2 ruleName, List<T2> ruleChain, int subRule)
		{
			this.ruleName = ruleName;
			this.ruleChain = ruleChain;
			this.subRule = subRule;
			
			this.childrenT = new ArrayList<T1>();
			this.childrenNodes = new ArrayList<GeneralNode<T1, T2>>();
		}
		public GeneralNode(T2 ruleName, List<T2> ruleChain, int subRule, T1 terminal)
		{
			this.ruleName = ruleName;
			this.ruleChain = ruleChain;
			this.subRule = subRule;
			
			this.childrenT = new ArrayList<T1>();
			this.childrenNodes = new ArrayList<GeneralNode<T1, T2>>();
			
			addTerminal(terminal);
		}
		public GeneralNode() {this(null, null, 0);}
		
		
		public void addTerminal(T1 terminal) {childrenT.add(terminal);}
		public T1 getTerminal(int i) {return childrenT.get(i);}
		public T1 getT(int i) {return getTerminal(i);}
		
		public void addNode(GeneralNode<T1, T2> nonterminal) {childrenNodes.add(nonterminal);}
		public GeneralNode<T1, T2> getNode(int i) {return childrenNodes.get(i);}
		
		public String dumpTree(int level)
		{
			String fullChain = "" + ruleName;
			if (ruleChain != null) for (int i = 0; i < ruleChain.size(); ++i) fullChain += " > " + ruleChain.get(i);
			String text = "-".repeat(2*level) + fullChain + ":\n";
			for (int i = 0; i < childrenT.size(); ++i)
				text += "-".repeat(2*level + 2) + getT(i) + "\n";
			for (int i = 0; i < childrenNodes.size(); ++i)
				text += getNode(i).dumpTree(level + 1);
			return text;
		}
		
		public String dumpTree(int level, Map<Integer, String> aliases)
		{
			String name = aliases.get(ruleName);
			String fullChain = "" + (name != null ? name : ruleName.toString());
			
			if (ruleChain != null) for (int i = 0; i < ruleChain.size(); ++i)
			{
				String linkName = aliases.get(ruleChain.get(i));
				fullChain += " > " + (linkName != null ? linkName : ruleChain.get(i).toString());
			}
			String text = "-".repeat(2*level) + fullChain + ":\n";
			for (int i = 0; i < childrenT.size(); ++i)
				text += "-".repeat(2*level + 2) + getT(i) + "\n";
			for (int i = 0; i < childrenNodes.size(); ++i)
				text += getNode(i).dumpTree(level + 1, aliases);
			return text;
		}
	}
	public static interface GeneralInterpreter<T1, T2, T3 extends GeneralInterpreter<T1, T2, ?>>
	{
		public T3 interpret(GeneralNode<T1, T2> node) throws Exception;
	}
	protected static class GeneralSuite<T1, T2> implements ParseSuite<T1, T2, GeneralNode<T1, T2>>
	{
		private GeneralGrammar<T1, T2> grammar;
		
		public GeneralSuite(GeneralGrammar<T1, T2> grammar) {this.grammar = grammar;}
		@Override
		public GeneralNode<T1, T2>[][][] getBlankArray(int n, int r)
		{
			GeneralNode<T1, T2>[][][] array =new GeneralNode[n][n][r];
			for (int i = 0; i < n; ++i)
				for (int j = 0; j < n; ++j)
					for (int k = 0; k < r; ++k)
						array[i][j][k] = null;
			return array;
		}
		@Override
		public GeneralNode<T1, T2> getP(T2 ruleName, int subRule, T1 terminalValue)
		{return new GeneralNode<T1, T2>(ruleName, grammar.getUnitChain(ruleName, subRule), subRule, terminalValue);}
		@Override
		public GeneralNode<T1, T2> getP(T2 ruleName, int subRule, GeneralNode<T1, T2> pA, GeneralNode<T1, T2> pB)
		{
			GeneralNode<T1, T2> node = new GeneralNode<T1, T2>(ruleName, grammar.getUnitChain(ruleName, subRule), subRule);
			
			node.addNode(pA);
			node.addNode(pB);

			return node;
		}
		
		@Override
		public boolean matchTerminal(T1 listed, T1 given) {return listed.equals(given);}
		@Override
		public boolean doGetP(GeneralNode<T1, T2> a, GeneralNode<T1, T2> b) {return a != null && b != null;}
	}
	
	// Recursive cleaning functions
	private static <T1, T2> GeneralNode<T1, T2> stretchChains(GeneralNode<T1, T2> node)
	{
		for (int i = 0; i < node.childrenNodes.size(); ++i)
			node.childrenNodes.set(i, stretchChains(node.getNode(i))); // Apply recursively
		if (node.ruleChain != null && !node.ruleChain.isEmpty()) // Then, if we ourselves have a chain
		{
			GeneralNode<T1, T2> overNode = new GeneralNode<T1, T2>(node.ruleName, null, node.subRule); // Make a new version of ourselves...
			node.ruleName = node.ruleChain.get(0); // And kick the can down the road!
			node.ruleChain.remove(0);
			overNode.addNode(stretchChains(node));
			
			return overNode;
		}
		else return node;
	}
	private static <T1, T2> GeneralNode<T1, T2> removeNonprimaries(GeneralGrammar<T1, T2> grammar, GeneralNode<T1, T2> node)
	{
		for (int i = 0; i < node.childrenNodes.size(); ++i)
				if (!grammar.isPrimary(node.getNode(i).ruleName))
				{	
					node.childrenNodes.set(i, removeNonprimaries(grammar, node.getNode(i)));
					node.childrenNodes.addAll(i + 1, node.getNode(i).childrenNodes);
					node.childrenT.addAll(node.getNode(i).childrenT);
				}
				else node.childrenNodes.set(i, removeNonprimaries(grammar, node.getNode(i)));
		for (int i = node.childrenNodes.size() - 1; i >= 0; --i)
			if (!grammar.isPrimary(node.getNode(i).ruleName)) node.childrenNodes.remove(i);
		return node;
	}
	
	protected static <T1, T2> GeneralNode<T1, T2> parseTree(List<T1> sequence, GeneralGrammar<T1, T2> grammar, ParseSuite<T1, T2, GeneralNode<T1, T2>> suite, T2 startSymbol)
	{
		// Parses in CNF, need to fix
		GeneralNode<T1, T2>[][][] parseTable = (GeneralNode<T1, T2>[][][]) parse(sequence, grammar, suite);
		
		GeneralNode<T1, T2> rootNode = parseTable[sequence.size() - 1][0][grammar.nonTerminals().indexOf(startSymbol)];
		
		// Reconstruction
		rootNode = stretchChains(rootNode);
		rootNode = removeNonprimaries(grammar, rootNode);
		return rootNode;
	}
	public static <T1, T2> GeneralNode<T1, T2> parseTree(List<T1> sequence, GeneralGrammar<T1, T2> grammar, T2 startSymbol)
	{
		ParseSuite<T1, T2, GeneralNode<T1, T2>> suite = new GeneralSuite<T1, T2>(grammar);
		return parseTree(sequence, grammar, suite, startSymbol);
	}
}
