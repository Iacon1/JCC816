// Created by Iacon1 on 02/02/2025.
// Applies to a single type of node

package C99Compiler.ASTPasses;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.TranslationUnitNode;
import C99Compiler.CompilerNodes.Interfaces.AssemblableNode;
import C99Compiler.Utils.ProgramState;

public interface PerNodeASTPass<C extends ComponentNode<?>> extends ASTPass
{
	public Class<C> getNodeClass();
	
	public ComponentNode<?> apply(C node, ProgramState state);
	private void applyRecursive(ComponentNode<?> node, ProgramState state) throws Exception
	{
		if (getNodeClass().isAssignableFrom(node.getClass()))
			node = apply((C) node, state);
		
		// We don't know how the list of children will be affected during this, so we have to be careful
		Queue<ComponentNode<?>> totalQueue, remainingQueue;
		totalQueue = new LinkedList<ComponentNode<?>>(node.getChildren());
		remainingQueue = new LinkedList<ComponentNode<?>>(totalQueue);
	
		ProgramState childState = state;
		while (!remainingQueue.isEmpty())
		{
			ComponentNode<?> child = remainingQueue.poll();
			if (AssemblableNode.class.isAssignableFrom(node.getClass()))
				childState = ((AssemblableNode) node).getStateBefore(state, child);
			applyRecursive(child, childState);
/*			
			if (!totalQueue.containsAll(node.getChildren()))
			{
				for (ComponentNode<?> newChild : node.getChildren())
				{
					if (!totalQueue.contains(newChild))
					{
						totalQueue.add(newChild);
						remainingQueue.add(newChild);
					}
				}
			}
*/
		}
	}
	default public void apply(TranslationUnitNode unit) throws Exception
	{
		for (FunctionDefinitionNode func : unit.getFunctions().values())
		{
			ProgramState state = new ProgramState();
			applyRecursive(func, state);
		}
	}
}
