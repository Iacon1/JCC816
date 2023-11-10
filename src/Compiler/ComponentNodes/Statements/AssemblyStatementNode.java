// Created by Iacon1 on 10/23/2023.
//
package Compiler.ComponentNodes.Statements;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Grammar.C99.C99Parser.Asm_statementContext;

public class AssemblyStatementNode extends StatementNode<Asm_statementContext>
{
	private String[] assemblyLines;

	public AssemblyStatementNode(ComponentNode<?> parent) {super(parent);}

	@Override
	public StatementNode<Asm_statementContext> interpret(Asm_statementContext node) throws Exception
	{
		this.assemblyLines = node.String_literal().getText().substring(1, node.String_literal().getText().length() - 1).split("\n");
		return this;
	}
	
	@Override
	public boolean hasAssembly()
	{
		return assemblyLines.length > 0;
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
		for (String line : assemblyLines) assembly += whitespace + line + "\n";
		return assembly;
	}
}
