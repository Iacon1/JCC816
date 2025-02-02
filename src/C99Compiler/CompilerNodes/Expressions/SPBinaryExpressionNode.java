// Created by Iacon1 on 01/28/2024.
// LOR and LAND
package C99Compiler.CompilerNodes.Expressions;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Interfaces.SequencePointNode;
import C99Compiler.Utils.ProgramState;
import Shared.Assemblable;

public abstract class SPBinaryExpressionNode<
C1 extends ParserRuleContext,
C2 extends ParserRuleContext,
PC extends ParserRuleContext,
CC extends ParserRuleContext
> extends BinaryExpressionNode<C1, C2, PC, CC> implements SequencePointNode
{
	private List<Assemblable> assemblableQueue;
	protected boolean isSP;
	
	public SPBinaryExpressionNode(ComponentNode<?> parent)
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
