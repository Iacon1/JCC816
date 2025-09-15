// Created by Iacon1 on 07/31/2025.
// Call graph
package Shared;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.Utils.ProgramState;
import Logging.Logging;

public class CallGraph
{
	private Map<String, Set<String>> map;
	private Map<String, Boolean> isFlattened;
	
	// Place all things the function can call into its set directly
	private void flatten(String funcName)
	{
		// So we don't do this forever
		if (isFlattened.get(funcName)) return;
		isFlattened.put(funcName, true);
		
		Set<String> set = map.get(funcName);
		List<String> setList = new LinkedList<String>(set);
		String callee;
	
		while (!setList.isEmpty())
		{
			callee = setList.removeFirst();
			// Flatten callee, then anything it can call must be something we can call
			flatten(callee);
			
			Set<String> disjunction = new HashSet<String>(map.get(callee));
			disjunction.removeAll(set);
			
			set.addAll(disjunction);
			setList.addAll(disjunction);
		}
	}
	
	public CallGraph(Collection<FunctionDefinitionNode> functions)
	{
		map = new HashMap<String, Set<String>>();
		isFlattened = new HashMap<String, Boolean>();
		// Pass 1 - direct calls
		for (FunctionDefinitionNode i : functions)
		{
			Set<String> set = new HashSet<String>();
			
			for (FunctionDefinitionNode j : functions)
				if (i.canCall(new ProgramState(), j))
					set.add(j.getFullName());
			
			map.put(i.getFullName(), set);
			isFlattened.put(i.getFullName(), false);
		}
		
		// Pass 2 - indirect calls
		for (String i : map.keySet())
			flatten(i);
	}
	
	public boolean canEverBeCalledBy(FunctionDefinitionNode caller, FunctionDefinitionNode callee)
	{
		return map.get(caller.getFullName()).contains(callee.getFullName());
	}

	public boolean canEverBeCalledByMain(FunctionDefinitionNode callee)
	{
		return map.get("main").contains(callee.getFullName());
	}
	
	public boolean canEverBeCalledBy(List<FunctionDefinitionNode> callers, FunctionDefinitionNode callee)
	{
		for (FunctionDefinitionNode caller : callers)
			if (canEverBeCalledBy(caller, callee)) return true;
		return false;
	}
	
	public void printCallGraph()
	{
		for (String i : map.keySet())
		{
			String list = "";
			
			for (String j : map.get(i))
				if (!i.equals(j))
					list = list + (list.isEmpty() ? "" : ", ") + j;
			if (list != "")
				Logging.logNotice("Function " + i + " can call: " + list);
			else
				Logging.logNotice("Function " + i + " can call nothing");
		}
	}
}
