// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import org.antlr.v4.runtime.tree.TerminalNode;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.VariableNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.UtilNodes.TypeNameNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.OperandSource;
import Compiler.Utils.ScratchManager;
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
				if (TerminalNode.class.isAssignableFrom(node.getChild(i).getClass()))
					operator += node.getChild(i).getText();
		}
		return this;
	}

	@Override
	public Type getType()
	{
		if (type != null) return type;
		else return expr.getType(); 
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
	public String getAssembly(int leadingWhitespace, String writeAddr, ScratchManager scratchManager) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
		switch (operator)
		{
		case "++":
			OperandSource exprSource = AssemblyUtils.addressSource(expr.getVariable().getFullName(), expr.getVariable().getSize());
			assembly += AdditiveExpressionNode.getIncrementer(whitespace, expr.getVariable().getFullName(), exprSource);
			if (!writeAddr.equals(expr.getVariable().getFullName()))
				assembly += AssemblyUtils.byteCopier(whitespace, expr.getVariable().getSize(), writeAddr, exprSource);
			return assembly;
		default: return "";
		}
	}
	
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		if (operator.equals("++") || operator.equals("--"))
			return getAssembly(leadingWhitespace, expr.getVariable().getFullName(), new ScratchManager());
		else return super.getAssembly(leadingWhitespace);
	}

	

}
