// Created by Iacon1 on 01/28/2024.
// Sequence point statement node
package C99Compiler.CompilerNodes.Statements;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Interfaces.SequencePointNode;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.Utils.OperandSources.OperandSource;

public abstract class SequencePointStatementNode<C extends ParserRuleContext> extends StatementNode<C> implements SequencePointNode
{
	private List<String> sequenceQueue;
	private boolean isSP;
	
	public SequencePointStatementNode(ComponentNode<?> parent)
	{
		super(parent);
		sequenceQueue = new LinkedList<String>();
		isSP = false;
	}

	@Override public boolean isSequencePoint() {return isSP;}
	@Override public void registerSequence(String assembly) {sequenceQueue.add(assembly);}
	@Override public void clearSequence() {sequenceQueue.clear();}
	@Override public String getAccumulatedSequences() {String assembly = ""; for (String queued : sequenceQueue) assembly += queued; return assembly;}

	public String getAssemblyWithSequence(BaseExpressionNode<?> expr, int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager) throws Exception
	{
		String assembly = "";
		isSP = true;
		clearSequence();
		if (expr.hasAssembly())
			assembly = expr.getAssembly(leadingWhitespace, destSource, scratchManager, new DetailsTicket());
		assembly += getAccumulatedSequences();
		clearSequence();
		isSP = false;
		return assembly;
	}
	
	public String getAssemblyWithSequence(BaseExpressionNode<?> expr, int leadingWhitespace) throws Exception
	{
		String assembly = "";
		isSP = true;
		clearSequence();
		assembly = expr.getAssembly(leadingWhitespace);
		assembly += getAccumulatedSequences();
		clearSequence();
		isSP = false;
		return assembly;
	}
}
