// Created by Iacon1 on 10/23/2023.
//
package C99Compiler.CompilerNodes.Statements;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.AssemblyUtils.AssemblyUtils;
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
	public ProgramState getStateAfter(ProgramState state)
	{
		return state.wipe();
	}
	@Override
	public ProgramState getStateBefore(ProgramState state, ComponentNode<?> child) throws Exception {throw new UnsupportedOperationException();}
	
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		String whitespace = state.getWhitespace();
		String assembly = "";
		for (String line : assemblyLines) assembly += whitespace + line + "\n";
		state = state.wipe();
		return new AssemblyStatePair(assembly, state);
	}

	@Override
	public boolean canCall(ProgramState state, FunctionDefinitionNode function) {return false;}

	@Override
	public boolean hasAssembly(ProgramState state) {return true;}
}
