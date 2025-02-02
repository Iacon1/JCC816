// Created by Iacon1 on 12/10/2024.

package C99Compiler.CompilerNodes.Expressions;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Interfaces.SequencePointNode;
import C99Compiler.Utils.ProgramState;
import Shared.Assemblable;

public abstract class SPBaseExpressionNode<C extends ParserRuleContext> extends BaseExpressionNode<C> implements SequencePointNode
{
	private List<Assemblable> assemblableQueue;
	protected boolean isSP;
	
	public SPBaseExpressionNode(ComponentNode<?> parent)
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
}
