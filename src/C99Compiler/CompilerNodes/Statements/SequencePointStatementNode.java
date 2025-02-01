// Created by Iacon1 on 01/28/2024.
// Sequence point statement node
package C99Compiler.CompilerNodes.Statements;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Interfaces.Assemblable;
import C99Compiler.CompilerNodes.Interfaces.SequencePointNode;
import C99Compiler.Utils.ProgramState;

public abstract class SequencePointStatementNode<C extends ParserRuleContext> extends StatementNode<C> implements SequencePointNode
{
	private List<Assemblable> assemblableQueue;
	private boolean isSP;
	
	public SequencePointStatementNode(ComponentNode<?> parent)
	{
		super(parent);
		assemblableQueue = new LinkedList<Assemblable>();
		isSP = false;
	}

	@Override public boolean isSequencePoint() {return isSP;}
	@Override public void registerAssemblable(Assemblable assemblable) {assemblableQueue.add(assemblable);}
	@Override public void clearAssemblables() {assemblableQueue.clear();}
	@Override public AssemblyStatePair getRegisteredAssemblyAndState(ProgramState state) throws Exception
	{
		String assembly = "";
		for (Assemblable queued : assemblableQueue)
		{
			AssemblyStatePair pair = queued.getAssemblyAndState(state);
			assembly += pair.assembly;
			state = pair.state;
		}
		
		return new AssemblyStatePair(assembly, state);
	}
	
	public AssemblyStatePair applyWithRegistered(AssemblyStatePair pair, BaseExpressionNode<?> expr) throws Exception
	{
		isSP = true;
		clearAssemblables();
		if (expr.hasAssembly(pair.state))
			pair = expr.apply(pair);

		AssemblyStatePair tmpPair = getRegisteredAssemblyAndState(pair.state);
		pair = new AssemblyStatePair(pair.assembly + tmpPair.assembly, tmpPair.state);
		
		clearAssemblables();
		isSP = false;
		return pair;
	}
	
	public AssemblyStatePair getAssemblyAndStateWithRegistered(ProgramState state, BaseExpressionNode<?> expr) throws Exception
	{
		return applyWithRegistered(new AssemblyStatePair("", state), expr);
	}
}
