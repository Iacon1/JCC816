// Created by Iacon1 on 10/21/2023.
//
package Compiler.ComponentNodes.Statements;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Grammar.C99.C99Parser.Iteration_statementContext;

public class IterationStatementNode extends StatementNode<Iteration_statementContext>
{
	private static int iterCount = 0;
	private int iterId;
	
	public IterationStatementNode(ComponentNode<?> parent)
	{
		super(parent);
		iterId = iterCount;
		iterCount += 1;
	}
	@Override
	public void finalize() {iterCount -= 1;}

	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StatementNode<Iteration_statementContext> interpret(Iteration_statementContext node) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	public String getStartLabel()
	{
		return "__ITER__START__" + iterId;
	}
	public String getEndLabel()
	{
		return "__ITER__END__" + iterId;
	}

	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
}
