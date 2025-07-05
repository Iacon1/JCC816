// Created by Iacon1 on 02/02/2025.
// Applies to a single type of node

package C99Compiler.ASTPasses;

import java.util.List;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.TranslationUnitNode;
import C99Compiler.Utils.ProgramState;

public interface PerNodeASTPass<C extends ComponentNode<?>> extends ASTPass
{
	public ComponentNode<?> apply(C node, ProgramState state);
	public Class<C> getNodeClass();
	@Override
	default public void apply(TranslationUnitNode unit) throws Exception
	{
		List<ComponentNode<?>> descendents = unit.getDescendents();
		for (ComponentNode<?> descendent : descendents)
		{
			if (!descendent.isValid()) continue; // Already erased
			if (!getNodeClass().isAssignableFrom(descendent.getClass())) // Not applicable
				continue;
			apply((C) descendent, new ProgramState()); // TODO state tracking here
		}
	}
}
