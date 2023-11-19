// Created by Iacon1 on 10/19/2023.
//
package Compiler.ComponentNodes.Statements;

import java.util.LinkedList;
import java.util.List;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.Declarations.DeclarationNode;
import Compiler.ComponentNodes.Definitions.Scope;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Grammar.C99.C99Parser.Block_itemContext;
import Grammar.C99.C99Parser.Compound_statementContext;

public class CompoundStatementNode extends StatementNode<Compound_statementContext> implements AssemblableNode
{
	List<AssemblableNode> assemblables;
	private String scope;
	
	public CompoundStatementNode(ComponentNode<?> parent, String scope)
	{
		super(parent);
		assemblables = new LinkedList<AssemblableNode>();
		this.scope = scope;
	}
	public CompoundStatementNode(ComponentNode<?> parent)
	{
		super(parent);
		assemblables = new LinkedList<AssemblableNode>();
		scope = null;
	}
	@Override
	public CompoundStatementNode interpret(Compound_statementContext node) throws Exception
	{
		if (node.block_item_list() == null) return this;
		for (Block_itemContext blockItem : node.block_item_list().block_item())
		{
			if (blockItem.declaration() != null) assemblables.add(new DeclarationNode(this).interpret(blockItem.declaration()));
			else if (blockItem.statement() != null) assemblables.add(StatementNode.manufacture(this, blockItem.statement()));
		}
		return this;
	}
	
	@Override
	public Scope getScope()
	{
		if (scope != null && parent != null) return parent.getScope().append(scope);
		else if (scope != null) return new Scope().append(scope);
		else return super.getScope();
	}
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		for (AssemblableNode assemblable : assemblables)
			if (assemblable.canCall(function)) return true;
		return false;
	}

	@Override
	public boolean hasAssembly()
	{
		for (AssemblableNode assemblable : assemblables)
			if (assemblable.hasAssembly()) return true;
		return false;
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String assembly = "";
		for (AssemblableNode assemblable : assemblables)
		{
			if (																	 // assemble if and only if
					!ComponentNode.class.isAssignableFrom(assemblable.getClass()) || // assemblable's somehow not actually a componentnode
					getEnclosingFunction() == null ||								 // OR it's not in a function 
					getEnclosingFunction().requires((ComponentNode<?>) assemblable)	 // OR it's required by the function
				)
				assembly += assemblable.getAssembly(leadingWhitespace);
		}
		return assembly;
	}
}
