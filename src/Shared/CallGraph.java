// Created by Iacon1 on 07/31/2025.
// Call graph
package Shared;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
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
		
		for (String callee : set)
		{
			// Flatten callee, then anything it can call must be something we can call
			flatten(callee);
			set.addAll(map.get(callee));
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
	
	public boolean canEverCall(FunctionDefinitionNode a, FunctionDefinitionNode b)
	{
		return map.get(a.getFullName()).contains(b.getFullName());
	}

	public boolean canEverBeCalled(FunctionDefinitionNode a)
	{
		return map.get("main").contains(a.getFullName());
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
