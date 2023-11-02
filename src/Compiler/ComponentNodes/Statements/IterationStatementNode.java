// Created by Iacon1 on 10/21/2023.
//
package Compiler.ComponentNodes.Statements;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.Declarations.DeclarationNode;
import Compiler.ComponentNodes.Expressions.BaseExpressionNode;
import Compiler.ComponentNodes.Expressions.EqualityExpressionNode;
import Compiler.ComponentNodes.Expressions.ExpressionNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompConfig;
import Compiler.Utils.ScratchManager;
import Grammar.C99.C99Parser.Iteration_statementContext;

public class IterationStatementNode extends StatementNode<Iteration_statementContext>
{
	private enum IterType
	{
		while_,
		doWhile,
		for_,
	}
	private IterType iterType;
	
	private static int iterCount = 0;
	private int iterId;
	
	private StatementNode<?> stmNode;
	private BaseExpressionNode<?> condExpNode;
	private BaseExpressionNode<?> initExpNode, iterExpNode;
	private DeclarationNode declNode;
	
	public IterationStatementNode(ComponentNode<?> parent)
	{
		super(parent);
		iterId = iterCount;
		iterCount += 1;
		
		stmNode = null;
		condExpNode = null;
		initExpNode = null;
		iterExpNode = null;
		declNode = null;
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
		switch (node.getChild(0).getText())
		{
			case "while": iterType = IterType.while_; break;
			case "do": iterType = IterType.doWhile; break;
			case "for": iterType = IterType.for_; break;
		}
		stmNode = StatementNode.manufacture(this, node.statement());
		
		if (node.declaration() != null) // Must be a for loop
		{
			declNode = new DeclarationNode(this).interpret(node.declaration());
			switch (node.expression().size())
			{
			case 2:
				iterExpNode = new ExpressionNode(this).interpret(node.expression().get(1));
			case 1:
				condExpNode = new ExpressionNode(this).interpret(node.expression().get(0));
			}
		}
		else if (iterType == IterType.for_)
		{
			switch (node.expression().size())
			{
			case 3:
				iterExpNode = new ExpressionNode(this).interpret(node.expression().get(2));
			case 2:
				condExpNode = new ExpressionNode(this).interpret(node.expression().get(1));
			case 1:
				initExpNode = new ExpressionNode(this).interpret(node.expression().get(0));
			}
		}
		else 
			condExpNode = new ExpressionNode(this).interpret(node.expression().get(0));
		
		return this;
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
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
		
		switch (iterType)
		{
		case while_:
			assembly += whitespace + getStartLabel() + ":\n";
			assembly += condExpNode.getAssembly(leadingWhitespace, CompConfig.callResult);
			assembly += EqualityExpressionNode.getIsZero(whitespace, CompConfig.callResult, new ScratchManager(), CompConfig.callResultSource(condExpNode.getType().getSize()));
			assembly += whitespace + "BEQ\t" + getEndLabel() + "\n";
			assembly += stmNode.getAssembly(leadingWhitespace + CompConfig.indentSize);
			assembly += whitespace + "JMP\t" + getStartLabel() + "\n";
			assembly += whitespace + getEndLabel() + ":\n";
			break;
		case doWhile:
			assembly += whitespace + getStartLabel() + ":\n";
			assembly += stmNode.getAssembly(leadingWhitespace + CompConfig.indentSize);
			assembly += condExpNode.getAssembly(leadingWhitespace, CompConfig.callResult);
			assembly += EqualityExpressionNode.getIsZero(whitespace, CompConfig.callResult, new ScratchManager(), CompConfig.callResultSource(condExpNode.getType().getSize()));
			assembly += whitespace + "BNE\t" + getStartLabel() + "\n";
			assembly += whitespace + getEndLabel() + ":\n";
			break;
		case for_:
			if (declNode.hasAssembly()) assembly += declNode.getAssembly(leadingWhitespace);
			else if (initExpNode != null && initExpNode.hasAssembly()) assembly += initExpNode.getAssembly(leadingWhitespace);

			assembly += whitespace + getStartLabel() + ":\n";
			if (condExpNode != null) // Run forever if null
			{
				if (condExpNode.hasPropValue() && ((Number) condExpNode.getPropValue()).equals(0)) return ""; // Don't run if 0, otherwise run forever
				else if (!condExpNode.hasPropValue())
				{
					if (condExpNode.hasAssembly()) assembly += condExpNode.getAssembly(leadingWhitespace, CompConfig.callResult);
					else assembly += AssemblyUtils.byteCopier(whitespace, condExpNode.getType().getSize(), CompConfig.callResult, condExpNode.getVariable().getFullName());
					
					assembly += EqualityExpressionNode.getIsZero(whitespace, CompConfig.callResult, new ScratchManager(), CompConfig.callResultSource(condExpNode.getType().getSize()));
					assembly += whitespace + "BEQ\t" + getEndLabel() + "\n";
				}
			}
			assembly += stmNode.getAssembly(leadingWhitespace + CompConfig.indentSize);
			if (iterExpNode != null && iterExpNode.hasAssembly()) assembly += iterExpNode.getAssembly(leadingWhitespace + CompConfig.indentSize); 
			assembly += whitespace + "JMP\t" + getStartLabel() + "\n";
			assembly += whitespace + getEndLabel() + ":\n";
			break;
		}
		
		return assembly;
	}
}
