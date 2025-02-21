// Created by Iacon1 on 10/19/2023.
//
package C99Compiler.CompilerNodes.Statements;

import java.util.LinkedList;
import java.util.List;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Declarations.DeclarationNode;
import C99Compiler.CompilerNodes.Definitions.Scope;
import C99Compiler.CompilerNodes.Interfaces.AssemblableNode;
import C99Compiler.CompilerNodes.Interfaces.UnvaluedAssemblableNode;
import C99Compiler.Utils.ProgramState;
import Grammar.C99.C99Parser.Block_itemContext;
import Grammar.C99.C99Parser.Compound_statementContext;

public class CompoundStatementNode extends StatementNode<Compound_statementContext> implements UnvaluedAssemblableNode
{
	private List<AssemblableNode> assemblables;
	private List<Integer> lines; // Line number for each assemblable
	private String scope;
	
	public CompoundStatementNode(ComponentNode<?> parent, String scope)
	{
		super(parent);
		assemblables = new LinkedList<AssemblableNode>();
		lines = new LinkedList<Integer>();
		this.scope = scope;
	}
	public CompoundStatementNode(ComponentNode<?> parent)
	{
		super(parent);
		assemblables = new LinkedList<AssemblableNode>();
		lines = new LinkedList<Integer>();
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
			else continue;
			
			lines.add(blockItem.start.getLine() - 1);
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
	public boolean canCall(ProgramState state, FunctionDefinitionNode function)
	{
		for (AssemblableNode assemblable : assemblables)
			if (assemblable.canCall(state, function)) return true;
		return false;
	}

	@Override
	public boolean hasAssembly(ProgramState state)
	{
		for (AssemblableNode assemblable : assemblables)
			if (assemblable.hasAssembly(state)) return true;
		return false;
	}
	
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		String assembly = "";
		int i = 0;
		for (AssemblableNode assemblable : assemblables)
		{
			if (!assemblable.hasAssembly(state)) continue;
			assembly += labelLine(state, lines.get(i++));
			state = state.setDestSource(null);
			AssemblyStatePair pair = assemblable.getAssemblyAndState(state);
			assembly += pair.assembly;
			state = pair.state;
		}
		return new AssemblyStatePair(assembly, state);
	}
}
