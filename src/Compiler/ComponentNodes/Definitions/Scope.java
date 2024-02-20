// Created by Iacon1 on 10/19/2023.
//
package Compiler.ComponentNodes.Definitions;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import Compiler.CompConfig;

public class Scope
{
	private List<String> levels; 
	
	public Scope()
	{
		levels = new LinkedList<String>();
	}
	public Scope(Scope scope)
	{
		levels = new LinkedList<String>();
		Collections.copy(levels, scope.levels);
	}
	public String getPrefix()
	{
		String prefix = "";
		for (int i = 0; i < levels.size(); ++i)
			prefix += levels.get(i) + CompConfig.scopeDelimiter;
		return prefix;
	}
	
	public Scope append(String level)
	{
		Scope scope = new Scope(this);
		scope.levels.add(level);
		return scope;
	}
}
