// Created by Iacon1 on 01/28/2024.
// LOR and LAND
package C99Compiler.CompilerNodes.Expressions;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Interfaces.SequencePointNode;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import C99Compiler.Utils.ScratchManager.ScratchSource;

public abstract class LogicalBinaryExpressionNode<
C1 extends ParserRuleContext,
C2 extends ParserRuleContext,
PC extends ParserRuleContext,
CC extends ParserRuleContext
> extends BinaryExpressionNode<C1, C2, PC, CC> implements SequencePointNode
{
	private List<String> sequenceQueue;
	private boolean isSP;
	
	public LogicalBinaryExpressionNode(ComponentNode<?> parent)
	{
		super(parent);
		sequenceQueue = new LinkedList<String>();
		isSP = false;
	}
	@Override public boolean isSequencePoint() {return isSP;}
	@Override public void registerSequence(String assembly) {sequenceQueue.add(assembly);}
	@Override public void clearSequence() {sequenceQueue.clear();}
	@Override public String getAccumulatedSequences() {String assembly = ""; for (String queued : sequenceQueue) assembly += queued; return assembly;}

	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		ScratchSource scratchX = null, scratchY = null;
		final OperandSource sourceX, sourceY;
		String assembly = "";

		// figure out X
		clearSequence();
		isSP = true;
		if (x.hasAssembly())
		{
			scratchX = scratchManager.reserveScratchBlock(y.getType().getSize());
			assembly += x.getAssembly(leadingWhitespace, scratchX, scratchManager, ticket);
			if (x.hasLValue())
				sourceX = x.getLValue().getSource();
			else sourceX = scratchX;
		}
		else if (x.hasPropValue())
			sourceX = new ConstantSource(x.getPropValue(), x.getType().getSize());
		else if (x.hasLValue())
			sourceX = x.getLValue().getSource();
		else sourceX = null;
		assembly += getAccumulatedSequences();
		clearSequence();
		isSP = false;
		
		// figure out Y		
		if (y.hasAssembly())
		{
			scratchY = scratchManager.reserveScratchBlock(y.getType().getSize());
			assembly += y.getAssembly(leadingWhitespace, scratchY, scratchManager, ticket);
			if (y.hasLValue())
				sourceY = y.getLValue().getSource();
			else sourceY = scratchY;
		}
		else if (y.hasPropValue())
			sourceY = new ConstantSource(y.getPropValue(), y.getType().getSize());
		else if (y.hasLValue())
			sourceY = y.getLValue().getSource();
		else sourceY = null;
		
		assembly += getAssembly(whitespace, destSource, sourceX, sourceY, scratchManager, ticket);
		if (scratchX != null) scratchManager.releaseScratchBlock(scratchX);
		if (scratchY != null) scratchManager.releaseScratchBlock(scratchY);
		
		ScratchManager.demotePointer(destSource); // A copy of the destination, if it's a pointer, has gone stale
		return assembly;
	}
}
