// Created by Iacon1 on 10/20/2023.
// 
package Compiler.ComponentNodes.Expressions;

import java.util.function.Function;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Conditional_expressionContext;
import Grammar.C99.C99Parser.Lor_expressionContext;

// TODO conditional expression
public class ConditionalExpressionNode extends BinaryExpressionNode
<Lor_expressionContext, Conditional_expressionContext, Lor_expressionContext, Conditional_expressionContext>
{
	private BaseExpressionNode<?> z;
	@Override
	protected BaseExpressionNode<Lor_expressionContext> getC1Node(Conditional_expressionContext node) throws Exception
	{return new LORExpressionNode(this).interpret(node.lor_expression());}
	@Override
	protected BaseExpressionNode<Conditional_expressionContext> getC2Node(Conditional_expressionContext node) throws Exception
		{return new ConditionalExpressionNode(this).interpret(node.conditional_expression());}
	@Override
	protected BaseExpressionNode<Lor_expressionContext> getPCNode(Conditional_expressionContext node) throws Exception
		{return new LORExpressionNode(this).interpret(node.lor_expression());}
	
	@Override
	public BaseExpressionNode<Conditional_expressionContext> interpret(Conditional_expressionContext node) throws Exception
	{
		if (node.children.size() == 1) // Only one, just propagate it
			return (BaseExpressionNode) getPCNode(node);
		else // Two
		{
			z = (BaseExpressionNode) new ExpressionNode(this).interpret(node.expression());
			x = getC1Node(node);
			y = getC2Node(node);
			
			operator = "";
			for (int i = 0; i < node.getChildCount(); ++i)
				if (node.getTokens(i).size() == 1) operator += node.getToken(i, 0);
		}
		return this;
	}
	public ConditionalExpressionNode(ComponentNode<?> parent) {super(parent);}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return x.canCall(function) || y.canCall(function) || z.canCall(function);
	}
	public boolean hasPropValue()
	{
		return x.hasPropValue() && y.hasPropValue() && z.hasPropValue();
	}
	@Override
	public Object getPropValue()
	{
		if ((Boolean) z.getPropValue()) return x.getPropValue();
		else return y.getPropValue();
	}
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource writeAddr, ScratchManager scratchManager) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
}
