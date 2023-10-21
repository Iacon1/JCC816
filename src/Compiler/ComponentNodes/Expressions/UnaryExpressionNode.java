// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.VariableNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.UtilNodes.TypeNameNode;
import Grammar.C99.C99Parser.Unary_expressionContext;

public class UnaryExpressionNode extends BaseExpressionNode<Unary_expressionContext>
{
	private BaseExpressionNode<?> expr;
	private Type type;
	private String operator;
	
	public UnaryExpressionNode(ComponentNode<?> parent) {super(parent);}
	
	@Override
	public BaseExpressionNode<Unary_expressionContext> interpret(Unary_expressionContext node) throws Exception
	{
		if (node.postfix_expression() != null) // Only one, just propagate it
			return (BaseExpressionNode) new PostfixExpressionNode(this).interpret(node.postfix_expression());
		else // Two
		{
			if (node.unary_expression() != null)
				this.expr = new UnaryExpressionNode(this).interpret(node.unary_expression());
			else if (node.cast_expression() != null)
				this.expr = new CastExpressionNode(this).interpret(node.cast_expression());
			else if (node.type_name() != null)
				type = new TypeNameNode(this).interpret(node.type_name()).getType();

			operator = "";
			for (int i = 0; i < node.getChildCount(); ++i)
				if (node.getTokens(i).size() == 1) operator += node.getToken(i, 0);
		}
		return this;
	}

	@Override
	public Type getType()
	{
		return type;
	}
	
	@Override
	public VariableNode getVariable()
	{
		return expr.getVariable();
	}

	@Override
	public boolean canCall(FunctionDefinitionNode function) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean hasPropValue()
	{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object getPropValue() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String getAssembly(int leadingWhitespace, String writeAddr, boolean useB) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
