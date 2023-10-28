// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.UtilNodes.TypeNameNode;
import Compiler.Utils.ScratchManager;
import Grammar.C99.C99Parser.Cast_expressionContext;

public class CastExpressionNode extends BaseExpressionNode<Cast_expressionContext>
{
	private Type type;
	private BaseExpressionNode<?> node;
	
	public CastExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	public BaseExpressionNode<Cast_expressionContext> interpret(Cast_expressionContext node) throws Exception
	{
		if (node.type_name() != null)
		{
			type = new TypeNameNode(this).interpret(node.type_name()).getType();
			this.node = new CastExpressionNode(this).interpret(node.cast_expression());
			return this;
		}
		else return (BaseExpressionNode) new UnaryExpressionNode(this).interpret(node.unary_expression());
	}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return node.canCall(function);
	}

	@Override
	public Type getType()
	{
		if (type == null) return node.getType();
		else return type;
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
	protected String getAssembly(int leadingWhitespace, String writeAddr, ScratchManager scratchManager) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
}
