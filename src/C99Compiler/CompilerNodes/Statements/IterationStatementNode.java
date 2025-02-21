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
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.AssemblyUtils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.ComparitiveJump;
import C99Compiler.Utils.OperandSources.OperandSource;
import C99Compiler.Utils.ProgramState.ScratchSource;
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
	public boolean canCall(ProgramState state, FunctionDefinitionNode function)
	{
		return (stmNode != null && stmNode.canCall(state, function)) ||
				(condExpNode != null && condExpNode.canCall(state, function)) ||
				(initExpNode != null && initExpNode.canCall(state, function)) ||
				(iterExpNode != null && iterExpNode.canCall(state, function)) ||
				(declNode != null && declNode.canCall(state, function));
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
	public String getIterLabel()
	{
		if (iterType == IterType.while_)
			return getStartLabel();
		else
			return "__ITER__ITER__" + iterId;
	}
	public String getEndLabel()
	{
		return "__ITER__END__" + iterId;
	}

	@Override
	public boolean hasAssembly(ProgramState state)
	{
		switch (iterType)
		{
		case while_:
			if (condExpNode.hasPropValue(state))
				return condExpNode.getPropBool(state) || condExpNode.hasAssembly(state);
				// Is this a forever loop or a never loop? Even if never, still need to run ASM for the check.
		case doWhile:
			return stmNode.hasAssembly(state) || condExpNode.hasAssembly(state); // Runs ASM for both at least once.
		case for_:
			if (initExpNode == null) return true; // Another forever-loop case
			else return stmNode.hasAssembly(state) || condExpNode.hasAssembly(state) || initExpNode.hasAssembly(state) || iterExpNode.hasAssembly(state);
		default: return false;
		}
	}
	
	@Override
	public ProgramState getStateBefore(ProgramState state, ComponentNode<?> child) throws Exception
	{
		if (!children.contains(child))
			throw new IllegalArgumentException();

		state = state.wipe();
		
		switch (iterType)
		{
		case while_:
			if (child == condExpNode)
				return state;
			if (condExpNode.hasAssembly(state))
				state = condExpNode.getStateAfter(state);
			return state;
		case doWhile:
			if (child == stmNode)
				return state;
			if (stmNode.hasAssembly(state))
				state = stmNode.getStateAfter(state);
			return state;
		case for_:
			if (declNode != null)
			{
				if (child == declNode)
					return state;
				if (declNode.hasAssembly(state))
					state = declNode.getStateAfter(state);
			}
			else if (initExpNode != null)
			{
				if (child == initExpNode)
					return state;
				if (initExpNode.hasAssembly(state))
					state = initExpNode.getStateAfter(state);
			}
			
			if (condExpNode != null)
			{
				if (child == condExpNode)
					return state;
				if (condExpNode.hasAssembly(state))
					state = condExpNode.getStateAfter(state);
			}
			
			if (child == stmNode)
				return state;
			if (stmNode.hasAssembly(state))
				state = stmNode.getStateAfter(state);
			
			if (iterExpNode != null)
			{
				if (child == iterExpNode)
					return state;
				if (iterExpNode.hasAssembly(state))
					state = iterExpNode.getStateAfter(state);
			}
			return state;
		}
		return state;
	}
	
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		AssemblyStatePair tmpPair;
		String whitespace = state.getWhitespace();
		String assembly = "";
		state = state.wipe();
		ProgramState oldState = state;
		
		switch (iterType)
		{
		case while_:
			assembly += whitespace + getStartLabel() + ":\n";
			state = stmNode.clearPossibleValues(state);
			state = state.clearKnownFlags();
			
			if (condExpNode.hasPropValue(state)); // We wouldn't be making this assembly if it was assumed to be 0.
			else
			{
				state = state.setDestSource(null);
				state = state.reserveScratchBlock(condExpNode.getSize());
				tmpPair = getAssemblyAndStateWithRegistered(state, new EqualityExpressionNode(this, condExpNode));
				assembly += tmpPair.assembly;
				state = tmpPair.state;
	
				assembly += whitespace + "BEQ\t:+\n";
				assembly += whitespace + "JMP\t" + getEndLabel() + "\n";
				assembly += whitespace + ":\n";
			}

			if (stmNode.hasAssembly(state))
			{
				tmpPair = stmNode.getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			assembly += whitespace + "JMP\t" + getStartLabel() + "\n";
			assembly += whitespace + getEndLabel() + ":\n";
			break;
		case doWhile:
			assembly += whitespace + getStartLabel() + ":\n";
			state = stmNode.clearPossibleValues(state);
			state = state.clearKnownFlags();
			if (stmNode.hasAssembly(state))
			{
				tmpPair = stmNode.getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			assembly += whitespace + getIterLabel() + ":\n";

			state = state.setDestSource(null);
			tmpPair = getAssemblyAndStateWithRegistered(state, new EqualityExpressionNode(this, condExpNode));
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			
			assembly += whitespace + "BEQ\t" + getEndLabel() + "\n";
			assembly += whitespace + "JMP\t" + getStartLabel() + "\n";
			assembly += whitespace + getEndLabel() + ":\n";
			break;
		case for_:
			// Declaration / initial node
			if (declNode != null && declNode.hasAssembly(state))
			{
				tmpPair = declNode.getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			else if (initExpNode != null && initExpNode.hasAssembly(state))
			{
				state = state.setDestSource(null);
				tmpPair = initExpNode.getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}

			assembly += whitespace + getStartLabel() + ":\n";
			state = stmNode.clearPossibleValues(state);
			state = state.clearKnownFlags();
			if (condExpNode != null)
			{
				if (iterExpNode != null) // Don't count on the value of anything in the iteration node
					state = iterExpNode.clearPossibleValues(state);

				if (condExpNode.hasPropValue(state) && condExpNode.getPropLong(state) == 0)
					return new AssemblyStatePair("", oldState); // Don't run if 0, otherwise run forever
				else if (!condExpNode.hasPropValue(state) || condExpNode.hasAssembly(state))
				{
					state = state.setDestSource(null);
					tmpPair = getAssemblyAndStateWithRegistered(state, new EqualityExpressionNode(this, condExpNode));
					// Jump to end if equality is 1, i. e. result is 0
					tmpPair = new ComparitiveJump(stmNode, null, getEndLabel(), null, false).apply(tmpPair);					
					assembly += tmpPair.assembly;
					assembly = assembly.substring(0, assembly.lastIndexOf('\n', assembly.length() - 2) + 1); // Remove last line
					state = tmpPair.state;
				}
			}
			else if (stmNode.hasAssembly(state)) // Go forever
			{
				tmpPair = stmNode.getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			assembly += whitespace + getIterLabel() + ":\n";
			
			if (iterExpNode != null && iterExpNode.hasAssembly(state))
			{
				state = state.setDestSource(null);
				tmpPair = getAssemblyAndStateWithRegistered(state, iterExpNode);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			assembly += whitespace + "JMP\t" + getStartLabel() + "\n";
			assembly += whitespace + getEndLabel() + ":\n";
			break;
		}
		
		return new AssemblyStatePair(assembly, state);
	}
}
