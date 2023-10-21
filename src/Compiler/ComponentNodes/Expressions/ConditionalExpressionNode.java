// Created by Iacon1 on 10/20/2023.
// 
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.InterpretingNode;
import Compiler.ComponentNodes.RValNode;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Grammar.C99.C99Parser.Assignment_expressionContext;
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
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String whitespace = getWhitespace(leadingWhitespace);
		String assembly = "";
		VarDeclarationNode xNode;
		
		xNode = resolveVariable(x);	
		if (!xNode.canCastFrom(y.getType()))
		{
			//throw TypeMismatchException();
		}
		if (y.hasAssembly())
			assembly += y.getAssembly(leadingWhitespace, xNode.getFullName(), null);
		else assembly += byteCopier(whitespace, xNode.getType().getSize(), xNode.getFullName(), y.getByteSource(xNode.getType().getSize()));
		
		return assembly;
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
	protected String getAssembly(int leadingWhitespace, String writeAddr, boolean useB) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
