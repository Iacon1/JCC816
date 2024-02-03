// Created by Iacon1 on 10/21/2023.
//
package C99Compiler.CompilerNodes.Statements;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Declarations.DeclarationNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.BranchingExpressionNode;
import C99Compiler.CompilerNodes.Expressions.EqualityExpressionNode;
import C99Compiler.CompilerNodes.Expressions.ExpressionNode;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.Utils.ScratchManager.ScratchSource;
import Grammar.C99.C99Parser.Iteration_statementContext;

public class IterationStatementNode extends SequencePointStatementNode<Iteration_statementContext>
{
	private enum IterType
	{
		while_,
		doWhile,
		for_,
	}
	private IterType iterType;
	private String iterId;
	
	private StatementNode<?> stmNode;
	private BaseExpressionNode<?> condExpNode;
	private BaseExpressionNode<?> initExpNode, iterExpNode;
	private DeclarationNode declNode;
	
	public IterationStatementNode(ComponentNode<?> parent)
	{
		super(parent);
		iterId = CompUtils.getSafeUUID();
		
		stmNode = null;
		condExpNode = null;
		initExpNode = null;
		iterExpNode = null;
		declNode = null;
	}

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
		
		stmNode = StatementNode.manufacture(this, node.statement());
		
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
	public boolean hasAssembly()
	{
		switch (iterType)
		{
		case while_:
			if (condExpNode.hasPropValue())
				return condExpNode.getPropBool() || condExpNode.hasAssembly();
				// Is this a forever loop or a never loop? Even if never, still need to run ASM for the check.
		case doWhile:
			return stmNode.hasAssembly() || condExpNode.hasAssembly(); // Runs ASM for both at least once.
		case for_:
			if (initExpNode == null) return true; // Another forever-loop case
			else return stmNode.hasAssembly() || condExpNode.hasAssembly() || initExpNode.hasAssembly() || iterExpNode.hasAssembly();
		default: return false;
		}
	}
	
	@Override
	public String getAssembly(int leadingWhitespace, String returnAddr) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
		ScratchManager scratchManager = new ScratchManager();
		ScratchSource exprSource = scratchManager.reserveScratchBlock(condExpNode.getSize());
		
		ScratchManager.releasePointers();
		
		switch (iterType)
		{
		case while_:
			assembly += whitespace + getStartLabel() + ":\n";
			
			if (condExpNode.hasPropValue()); // We wouldn't be making this assembly if it was assumed to be 0.
			else
			{
				if (condExpNode.hasAssembly())
				{
					assembly += getAssemblyWithSequence(condExpNode, leadingWhitespace, exprSource, scratchManager);
					assembly += EqualityExpressionNode.getIsZero(whitespace, exprSource, new ScratchManager(), exprSource, new DetailsTicket());
				}
				else assembly += EqualityExpressionNode.getIsZero(whitespace, CompConfig.callResultSource(condExpNode.getSize()), new ScratchManager(), condExpNode.getLValue().getSource(), new DetailsTicket());
				assembly += whitespace + "BNE\t:+\n";
				assembly += whitespace + "JMP\t" + getEndLabel() + "\n";
				assembly += whitespace + ":\n";
			}
			if (stmNode.hasAssembly()) assembly += stmNode.getAssembly(leadingWhitespace + CompConfig.indentSize, returnAddr);
			assembly += whitespace + "JMP\t" + getStartLabel() + "\n";
			assembly += whitespace + getEndLabel() + ":\n";
			break;
		case doWhile:
			assembly += whitespace + getStartLabel() + ":\n";
			if (stmNode.hasAssembly()) assembly += stmNode.getAssembly(leadingWhitespace + CompConfig.indentSize, returnAddr);
			assembly += getAssemblyWithSequence(condExpNode, leadingWhitespace, exprSource, scratchManager);
			assembly += EqualityExpressionNode.getIsZero(whitespace, exprSource, new ScratchManager(), exprSource, new DetailsTicket());
			assembly += whitespace + "BEQ\t" + getEndLabel() + "\n";
			assembly += whitespace + "JMP\t" + getStartLabel() + "\n";
			assembly += whitespace + getEndLabel() + ":\n";
			break;
		case for_:
			// Declaration / initial node
			if (declNode != null && declNode.hasAssembly()) assembly += declNode.getAssembly(leadingWhitespace);
			else if (initExpNode != null && initExpNode.hasAssembly()) assembly += getAssemblyWithSequence(initExpNode, leadingWhitespace);

			assembly += whitespace + getStartLabel() + ":\n";
			if (condExpNode != null) // Run forever if condition not provided
			{
				if (condExpNode.hasPropValue() && condExpNode.getPropLong() == 0) return ""; // Don't run if 0, otherwise run forever
				else if (!condExpNode.hasPropValue())
				{
					if (condExpNode.hasAssembly())
					{
						assembly += getAssemblyWithSequence(condExpNode, leadingWhitespace, exprSource, scratchManager);
						assembly += EqualityExpressionNode.getIsZero(whitespace, exprSource, new ScratchManager(), exprSource, new DetailsTicket());
						assembly += whitespace + "BNE\t:+\n";
						assembly += whitespace + "JMP\t" + getEndLabel() + "\n";
						assembly += whitespace + ":\n";
					}
					else
					{
						assembly += AssemblyUtils.byteCopier(whitespace, condExpNode.getSize(), exprSource, condExpNode.getLValue().getSource());
						assembly += EqualityExpressionNode.getIsZero(whitespace, CompConfig.callResultSource(2), new ScratchManager(), CompConfig.callResultSource(condExpNode.getSize()), new DetailsTicket());
						assembly += whitespace + "BNE\t:+\n";
						assembly += whitespace + "JMP\t" + getEndLabel() + "\n";
						assembly += whitespace + ":\n";
					}
				}
			}
			if (stmNode.hasAssembly()) assembly += stmNode.getAssembly(leadingWhitespace + CompConfig.indentSize, returnAddr);
			if (iterExpNode != null && iterExpNode.hasAssembly()) assembly += getAssemblyWithSequence(iterExpNode, leadingWhitespace); 
			assembly += whitespace + "JMP\t" + getStartLabel() + "\n";
			assembly += whitespace + getEndLabel() + ":\n";
			break;
		}
		
		return assembly;
	}
}
