// Created by Iacon1 on 10/19/2023.
//
package C99Compiler.CompilerNodes.Statements;

import java.util.LinkedList;
import java.util.List;

import C99Compiler.CompConfig.DebugLevel;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Declarations.DeclarationNode;
import C99Compiler.CompilerNodes.Definitions.Scope;
import C99Compiler.CompilerNodes.Interfaces.AssemblableNode;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.LineInfo;
import Grammar.C99.C99Parser.Block_itemContext;
import Grammar.C99.C99Parser.Compound_statementContext;

public class CompoundStatementNode extends StatementNode<Compound_statementContext> implements AssemblableNode
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
	public String getAssembly(int leadingWhitespace, String returnAddr) throws Exception
	{
		String assembly = "";
		int i = 0;
		for (AssemblableNode assemblable : assemblables)
		{
			if (DebugLevel.isAtLeast(DebugLevel.low))
			{
				LineInfo info = getTranslationUnit().getInfo(lines.get(i++));
				assembly += AssemblyUtils.getWhitespace(leadingWhitespace) + ".dbg\tline, \"" + info.filename + "\", " + info.line + "\n";
			}
			if (StatementNode.class.isAssignableFrom(assemblable.getClass())) assembly += ((StatementNode) assemblable).getAssembly(leadingWhitespace, returnAddr);
			else
				assembly += assemblable.getAssembly(leadingWhitespace);
		}
		return assembly;
	}
}
