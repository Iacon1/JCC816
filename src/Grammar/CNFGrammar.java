// Created by Iacon1 on 2/7/2022.
// A CFG in CNF form.

package Grammar;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class CNFGrammar<T1, T2> extends ArrayList<Rule<T1, T2>>
{
	public void addRule(T2 name, T1 terminalValue)
	{
		add(new Rule<T1, T2>(name, terminalValue));
	}
	public void addRule(T2 name, T2 nonTerminalA, T2 nonTerminalB)
	{
		add(new Rule<T1, T2>(name, nonTerminalA, nonTerminalB));
	}
	
	public List<T2> nonTerminals()
	{
		List<T2> list = new ArrayList<T2>();
		for (int i = 0; i < size(); ++i)
		{
			if (!list.contains(get(i).name))
				list.add(get(i).name);
		}
		
		return list;
	}
}
