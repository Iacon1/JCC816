// By Iacon1
// Created 10/14/2023
// General expression node.

package Compiler.ComponentNodes.Expressions;

import java.util.LinkedList;
import java.util.List;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.LValues.LValueNode;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Assignment_expressionContext;
import Grammar.C99.C99Parser.ExpressionContext;

public class ExpressionNode extends BaseExpressionNode<ExpressionContext>
{
	private List<BaseExpressionNode<?>> expressions;
	public ExpressionNode(ComponentNode<?> parent)
	{
		super(parent);
		expressions = new LinkedList<BaseExpressionNode<?>>();
	}

	@Override
	public ExpressionNode interpret(ExpressionContext node) throws Exception
	{
		for (Assignment_expressionContext assignment : node.assignment_expression())
			expressions.add((BaseExpressionNode<?>) new AssignmentExpressionNode(this).interpret(assignment));
		return this;
	}
	
	@Override
	public Type getType()
	{
		if (expressions.size() == 1) return expressions.get(0).getType();
		else return null; // TODO
	}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		for (BaseExpressionNode<?> expression : expressions)
			if (expression.canCall(function)) return true;
		return false;
	}
	
	@Override
	public boolean hasLValue()
	{
		if (expressions.size() == 1) return expressions.get(0).hasLValue();
		else return false;
	}
	@Override
	public LValueNode<?> getLValue()
	{
		if (expressions.size() == 1) return expressions.get(0).getLValue();
		else return null;
	}
	@Override
	public boolean hasPropValue()
	{
		if (expressions.size() == 1) return expressions.get(0).hasPropValue();
		else return false;
	}
	@Override
	public Object getPropValue()
	{
		if (expressions.size() == 1) return expressions.get(0).getPropValue();
		else return null;
	}
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
		for (BaseExpressionNode<?> expression : expressions.subList(1, expressions.size()))
			assembly += expression.getAssembly(leadingWhitespace,  scratchManager, ticket);
		assembly += expressions.get(0).getAssembly(leadingWhitespace, destSource, scratchManager, ticket);
		
		return assembly;
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String assembly = "";
		for (BaseExpressionNode<?> expression : expressions)
			assembly += expression.getAssembly(leadingWhitespace);
		return assembly;
	}	
}
