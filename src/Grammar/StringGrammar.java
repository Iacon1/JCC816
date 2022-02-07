// Created by Iacon1 on 2/7/2022.
// A grammar whose rules aren't neccessarily entered in CNF form.
// Only usable with String terminals *and* non-terminals.

package Grammar;

public class StringGrammar extends CNFGrammar<String, String>
{
	private static final String autoGenSuffix = "_AG%03d";
	
	private void addRule(int AGCount, String name, boolean startTerminal, String... values)
	{

	}
	public void addRule(String name, boolean startTerminal, String... values)
	{
		addRule(0, name, startTerminal, values);
	}
}
