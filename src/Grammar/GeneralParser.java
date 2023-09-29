// Created by Iacon1 on 2/14/2022.
// Parser that can parse GeneralGrammars with respect to their intended structure.

package Grammar;

import java.util.ArrayList;
import java.util.List;

public class GeneralParser extends CYKParser
{
	public static class GeneralNode<T1>
	{
		public Integer ruleName;
		public List<Integer> ruleChain;
		public int subRule;
		public List<T1> childrenT;
		public List<GeneralNode<T1>> childrenNodes;
		
		public GeneralNode(Integer ruleName, List<Integer> ruleChain, int subRule)
		{
			this.ruleName = ruleName;
			this.ruleChain = ruleChain;
			this.subRule = subRule;
			
			this.childrenT = new ArrayList<T1>();
			this.childrenNodes = new ArrayList<GeneralNode<T1>>();
		}
		public GeneralNode(Integer ruleName, List<Integer> ruleChain, int subRule, T1 terminal)
		{
			this.ruleName = ruleName;
			this.ruleChain = ruleChain;
			this.subRule = subRule;
			
			this.childrenT = new ArrayList<T1>();
			this.childrenNodes = new ArrayList<GeneralNode<T1>>();
			
			addTerminal(terminal);
		}
		public GeneralNode() {this(null, null, 0);}
		
		
		public void addTerminal(T1 terminal) {childrenT.add(terminal);}
		public T1 getTerminal(int i) {return childrenT.get(i);}
		public T1 getT(int i) {return getTerminal(i);}
		
		public void addNode(GeneralNode<T1> nonterminal) {childrenNodes.add(nonterminal);}
		public GeneralNode<T1> getNode(int i) {return childrenNodes.get(i);}
		
		public void assimilate(GeneralNode<T1> node)
		{
			childrenT.addAll(node.childrenT);
			childrenNodes.addAll(node.childrenNodes);
		}
		
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
	}
	public static interface GeneralInterpreter<T1, T extends GeneralInterpreter<T1, ?>>
	{
		public T interpret(GeneralNode<T1> node);
	}
	protected static class GeneralSuite<T1> implements ParseSuite<T1, Integer, GeneralNode<T1>>
	{
		private GeneralGrammar<T1> grammar;
		
		public GeneralSuite(GeneralGrammar<T1> grammar) {this.grammar = grammar;}
		@Override
		public GeneralNode<T1>[][][] getBlankArray(int n, int r)
		{
			GeneralNode<T1>[][][] array =new GeneralNode[n][n][r];
			for (int i = 0; i < n; ++i)
				for (int j = 0; j < n; ++j)
					for (int k = 0; k < r; ++k)
						array[i][j][k] = null;
			return array;
		}
		@Override
		public GeneralNode<T1> getP(Integer ruleName, int subRule, T1 terminalValue)
		{return new GeneralNode<T1>(ruleName, grammar.getUnitChain(ruleName, subRule), subRule, terminalValue);}
		@Override
		public GeneralNode<T1> getP(Integer ruleName, int subRule, GeneralNode<T1> pA, GeneralNode<T1> pB)
		{
			GeneralNode<T1> node = new GeneralNode<T1>(ruleName, grammar.getUnitChain(ruleName, subRule), subRule);
			
			if (grammar.isPrimary(pA.ruleName)) node.addNode(pA);
			else node.assimilate(pA);
			if (grammar.isPrimary(pB.ruleName)) node.addNode(pB);
			else node.assimilate(pB);
			
			return node;
		}
		
		@Override
		public boolean matchTerminal(T1 listed, T1 given) {return listed.equals(given);}
		@Override
		public boolean doGetP(GeneralNode<T1> a, GeneralNode<T1> b) {return a != null && b != null;}
	}
	
	// Recursive cleaning functions
	private static <T1> GeneralNode<T1> stretchChains(GeneralNode<T1> node)
	{
		for (int i = 0; i < node.childrenNodes.size(); ++i)
			node.childrenNodes.set(i, stretchChains(node.getNode(i))); // Apply recursively
		if (node.ruleChain != null && !node.ruleChain.isEmpty()) // Then, if we ourselves have a chain
		{
			GeneralNode<T1> overNode = new GeneralNode<T1>(node.ruleName, null, node.subRule); // Make a new version of ourselves...
			node.ruleName = node.ruleChain.get(0); // And kick the can down the road!
			node.ruleChain.remove(0);
			overNode.addNode(stretchChains(node));
			
			return overNode;
		}
		else return node;
	}
	private static <T1> GeneralNode<T1> removeNonprimaries(GeneralGrammar<T1> grammar, GeneralNode<T1> node)
	{
		if (node.ruleName == 4)
		{
			node.ruleName = 4;
		}
		for (int i = 0; i < node.childrenNodes.size(); ++i)
			if (!grammar.isPrimary(node.getNode(i).ruleName))
			{	
				node.childrenNodes.addAll(node.getNode(i).childrenNodes);
				node.childrenT.addAll(node.getNode(i).childrenT);
			}
		for (int i = node.childrenNodes.size() - 1; i >= 0; --i)
			if (grammar.isPrimary(node.getNode(i).ruleName))
				node.childrenNodes.set(i, removeNonprimaries(grammar, node.getNode(i)));
			else
				node.childrenNodes.remove(i);
		return node;
	}
	
	protected static <T1> GeneralNode<T1> parseTree(List<T1> sequence, GeneralGrammar<T1> grammar, ParseSuite<T1, Integer, GeneralNode<T1>> suite, Integer startSymbol)
	{
		// Parses in CNF, need to fix
		GeneralNode<T1>[][][] parseTable = (GeneralNode<T1>[][][]) parse(sequence, grammar, suite);
		
		GeneralNode<T1> rootNode = parseTable[sequence.size() - 1][0][grammar.nonTerminals().indexOf(startSymbol)];
		
		// Reconstruction
		rootNode = stretchChains(rootNode);
		rootNode = removeNonprimaries(grammar, rootNode);
		return rootNode;
	}
	public static <T1> GeneralNode<T1> parseTree(List<T1> sequence, GeneralGrammar<T1> grammar, Integer startSymbol)
	{
		ParseSuite<T1, Integer, GeneralNode<T1>> suite = new GeneralSuite<T1>(grammar);
		return parseTree(sequence, grammar, suite, startSymbol);
	}
	

}
