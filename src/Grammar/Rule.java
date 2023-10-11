package Grammar;

// Created by Iacon1 on 1/30/2022
// Context-free grammar in CNF.
// https://en.wikipedia.org/wiki/CYK_algorithm

public class Rule<T1, T2>
{	
	T2 name;
	
	T1 terminalValue;
	T2 nonTerminalB;
	T2 nonTerminalC;
	
	public T1 getUnitValue()
	{
		return terminalValue;
	}
	public T2[] getNonUnitValue()
	{
		return (T2[]) new Object[] {nonTerminalB, nonTerminalC};
	}
	
	public boolean isUnit()
	{
		return terminalValue != null;
	}
	public Rule()
	{
		name = null;
		
		terminalValue = null;
		nonTerminalB = null;
		nonTerminalC = null;
	}
	public Rule(T2 name, T1 terminalValue)
	{
		this.name = name;
		this.terminalValue = terminalValue;
	}
	
	public Rule(T2 name, T2 nonTerminalB, T2 nonTerminalC)
	{
		this.name = name;
		this.nonTerminalB = nonTerminalB;
		this.nonTerminalC = nonTerminalC;
	}
	
	public Rule(T2 name)
	{
		this.name = name;
		
	}

	@Override
	public String toString()
	{
		if (terminalValue != null) return name.toString() + ": " + terminalValue.toString();
		else return name.toString() + ": " + nonTerminalB.toString() + " " + nonTerminalC.toString();
	}
}