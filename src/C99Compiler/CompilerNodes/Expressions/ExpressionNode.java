// By Iacon1
// Created 10/14/2023
// General expression node.

package C99Compiler.CompilerNodes.Expressions;

import java.util.LinkedList;
import java.util.List;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Interfaces.SequencePointNode;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Assignment_expressionContext;
import Grammar.C99.C99Parser.ExpressionContext;
import Logging.Logging;

public class ExpressionNode extends BaseExpressionNode<ExpressionContext> implements SequencePointNode
{
	private List<BaseExpressionNode<?>> expressions;
	private List<String> sequenceQueue;
	private boolean isSP;
	
	public ExpressionNode(ComponentNode<?> parent)
	{
		super(parent);
		expressions = new LinkedList<BaseExpressionNode<?>>();
		sequenceQueue = new LinkedList<String>();
		isSP = false;
	}

	@Override
	public BaseExpressionNode<ExpressionContext> interpret(ExpressionContext node) throws Exception
	{
		for (Assignment_expressionContext assignment : node.assignment_expression())
			expressions.add((BaseExpressionNode<?>) new AssignmentExpressionNode(this).interpret(assignment));
		if (expressions.size() == 1) return delegate(expressions.get(0));
		return this;
	}
	
	@Override public void registerSequence(String assembly) {sequenceQueue.add(assembly);}
	@Override public void clearSequence() {sequenceQueue.clear();}
	@Override public String getAccumulatedSequences() {String assembly = ""; for (String queued : sequenceQueue) assembly += queued; return assembly;}

	@Override
	public Type getType() {return null;}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		for (BaseExpressionNode<?> expression : expressions)
			if (expression.canCall(function)) return true;
		return false;
	}
	
	@Override
	public boolean hasLValue() {return false;}
	@Override
	public LValueNode<?> getLValue() {return null;}
	@Override
	public boolean hasPropValue() {return false;}
	@Override
	public Object getPropValue() {return null;}
	@Override
	public boolean hasAssembly()
	{
		for (BaseExpressionNode<?> expression : expressions)
			if (expression.hasAssembly()) return true;
		return false;
	}
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		String assembly = "";
		clearSequence();
		assembly += expressions.get(0).getAssembly(leadingWhitespace,  scratchManager, ticket);
		assembly += getAccumulatedSequences();
		
		for (BaseExpressionNode<?> expression : expressions.subList(1, expressions.size()))
		{
			clearSequence();
			assembly += expression.getAssembly(leadingWhitespace, scratchManager, ticket);
			assembly += getAccumulatedSequences();
		}
		
		return assembly;
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String assembly = "";
		for (BaseExpressionNode<?> expression : expressions)
		{
			clearSequence();
			assembly += expression.getAssembly(leadingWhitespace);
			assembly += getAccumulatedSequences();
		}
		return assembly;
	}	
}
