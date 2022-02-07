// Created by Iacon1 on 2/7/2022.
// CFG parser.
// https://en.wikipedia.org/wiki/CYK_algorithm

package Grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CYKParser
{
	private static interface ParseSuite<T1, T2, T3>
	{
		public T3[][][] getBlankArray(int n, int r);
		public T3 getP(T2 ruleName, T1 terminalValue);
		public boolean doGetP(T3 a, T3 b);
		public T3 getP(T2 ruleName, T3 pA, T3 pB);
	}
	private static <T1, T2, T3> T3[][][] parse(List<T1> sequenceList, CNFGrammar<T1, T2> grammar, ParseSuite<T1, T2, T3> suite)
	{
		List<T2> nonTerminals = grammar.nonTerminals();
		
		int m = grammar.size();
		int n = sequenceList.size();
		int r = nonTerminals.size();
		
		T3[][][] P = suite.getBlankArray(n, r);
		for (int s = 0; s < n; ++s)
			for (int i = 0; i < m; ++i)
			{
				Rule<T1, T2> rule = grammar.get(i);
				if (rule.isUnit() && rule.getUnitValue().equals(sequenceList.get(s))) // Rv = As?
				{
					int v = nonTerminals.indexOf(rule.name);
					P[0][s][v] = suite.getP(rule.name, sequenceList.get(s));
				}
			}
		
		for (int l = 2; l <= n; ++l)
			for (int s = 1; s <= n - l + 1; ++s)
				for (int p = 1; p <= l - 1; ++p)
					for (int i = 0; i < m; ++i)
					{
						Rule<T1, T2> rule = grammar.get(i);
						if (!rule.isUnit()) // Ra = Rb Rc?
						{
							T2 bV = rule.getNonUnitValue()[0];
							T2 cV = rule.getNonUnitValue()[1];
							
							int a = nonTerminals.indexOf(rule.name);
							int b = nonTerminals.indexOf(bV);
							int c = nonTerminals.indexOf(cV);
							
							T3 pA = P[p - 1][s - 1][b];
							T3 pB =	P[l - p - 1][s + p - 1][c];
							if (suite.doGetP(pA, pB)) P[l - 1][s - 1][a] = suite.getP(rule.name, pA, pB);
						}
					}
		
		return P;
	}
	
	public static <T1, T2> boolean isInLanguage(List<T1> sequenceList, CNFGrammar<T1, T2> grammar)
	{
		ParseSuite<T1, T2, Boolean> suite = new ParseSuite<T1, T2, Boolean>()
		{
			@Override
			public Boolean[][][] getBlankArray(int n, int r)
			{
				Boolean[][][] array = new Boolean[n][n][r];
				for (int i = 0; i < n; ++i)
					for (int j = 0; j < n; ++j)
						for (int k = 0; k < r; ++k)
							array[i][j][k] = false;
				return array;
			}
			@Override
			public Boolean getP(T2 ruleName, T1 terminalValue) {return true;}
			@Override
			public Boolean getP(T2 ruleName, Boolean pA, Boolean pB) {return true;}
			
			@Override
			public boolean doGetP(Boolean a, Boolean b) {return a && b;}	
		};
		
		Boolean[][][] parseTable = (Boolean[][][]) parse(sequenceList, grammar, suite);
		
		return parseTable[sequenceList.size() - 1][0][0];
	}
	
	public static class Node<T1, T2>
	{
		public T1 terminalValue;
		public T2 ruleName;
		public Node<T1, T2> childA;
		public Node<T1, T2> childB;
		
		public Node()
		{
			this.terminalValue = null;
			this.ruleName = null;
			
			this.childA = null;
			this.childB = null;
		}
		public Node(T2 ruleName, T1 terminalValue)
		{
			this.terminalValue = terminalValue;
			this.ruleName = ruleName;
			
			this.childA = null;
			this.childB = null;
		}
		public Node(T2 ruleName, Node<T1, T2> childA, Node<T1, T2> childB)
		{
			this.terminalValue = null;
			this.ruleName = ruleName;
			
			this.childA = childA;
			this.childB = childB;
		}
		
		public String dumpTree(int level)
		{
			String text = "-".repeat(2*level) + ruleName + ":\n";
			if (childA != null) text += childA.dumpTree(level + 1);
			if (childB != null) text += childB.dumpTree(level + 1);
			return text;
		
		}
	}
	public static <T1, T2> Node<T1, T2> parseTree(List<T1> sequence, CNFGrammar<T1, T2> grammar)
	{
		ParseSuite<T1, T2, Node<T1, T2>> suite = new ParseSuite<T1, T2, Node<T1, T2>>()
		{
			@Override
			public Node<T1, T2>[][][] getBlankArray(int n, int r)
			{
				Node<T1, T2>[][][] array =new Node[n][n][r];
				for (int i = 0; i < n; ++i)
					for (int j = 0; j < n; ++j)
						for (int k = 0; k < r; ++k)
							array[i][j][k] = null;
				return array;
			}
			@Override
			public Node<T1, T2> getP(T2 ruleName, T1 terminalValue)
			{return new Node<T1, T2>(ruleName, terminalValue);}
			@Override
			public Node<T1, T2> getP(T2 ruleName, Node<T1, T2> pA, Node<T1, T2> pB)
			{return new Node<T1, T2>(ruleName, pA, pB);}
			
			@Override
			public boolean doGetP(Node<T1, T2> a, Node<T1, T2> b) {return a != null && b != null;}
		};
		
		Node<T1, T2>[][][] parseTable = (Node<T1, T2>[][][]) parse(sequence, grammar, suite);
		
		return parseTable[sequence.size() - 1][0][0];
	}
	
}
