// Created by Iacon1 on 10/19/2023.
//
package Compiler.ComponentNodes.Statements;

import java.util.LinkedList;
import java.util.List;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.InterpretingNode;
import Compiler.ComponentNodes.Declarations.DeclarationNode;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Grammar.C99.C99Parser.Block_itemContext;
import Grammar.C99.C99Parser.Compound_statementContext;

public class CompoundStatementNode extends StatementNode<Compound_statementContext> implements AssemblableNode
{
	List<AssemblableNode> assemblables;
	
	public CompoundStatementNode(ComponentNode<?> parent)
	{
		super(parent);
		assemblables = new LinkedList<AssemblableNode>();
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
	public boolean canCall(FunctionDefinitionNode function)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String assembly = "";
		for (AssemblableNode assemblable : assemblables)
			assembly += assemblable.getAssembly(leadingWhitespace);
		return assembly;
	}
}
