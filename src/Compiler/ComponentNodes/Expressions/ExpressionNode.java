// By Iacon1
// Created 10/14/2023
// General expression node.

package Compiler.ComponentNodes.Expressions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.LValues.LValueNode;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Assignment_expressionContext;
import Grammar.C99.C99Parser.Conditional_expressionContext;
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
	public BaseExpressionNode<ExpressionContext> interpret(ExpressionContext node) throws Exception
	{
		for (Assignment_expressionContext assignment : node.assignment_expression())
			expressions.add((BaseExpressionNode<?>) new AssignmentExpressionNode(this).interpret(assignment));
		if (expressions.size() == 1) return (BaseExpressionNode) expressions.get(0);
		return this;
	}
	
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
	
	@Override
	public Set<LValueNode<?>> influences()
	{
		Set<LValueNode<?>> influences = new HashSet<LValueNode<?>>();
		if (hasLValue()) influences.add(getLValue());
		return influences;
	}
}
