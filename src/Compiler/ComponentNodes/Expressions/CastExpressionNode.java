// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.Declarations.TypeNameNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.LVals.LValueNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.OperandSource;
import Compiler.Utils.ScratchManager;
import Grammar.C99.C99Parser.Cast_expressionContext;

public class CastExpressionNode extends BaseExpressionNode<Cast_expressionContext>
{
	private Type type;
	private BaseExpressionNode<?> expr;
	
	public CastExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	public BaseExpressionNode<Cast_expressionContext> interpret(Cast_expressionContext node) throws Exception
	{
		if (node.type_name() != null)
		{
			type = new TypeNameNode(this).interpret(node.type_name()).getType();
			this.expr = new CastExpressionNode(this).interpret(node.cast_expression());
			return this;
		}
		else return (BaseExpressionNode) new UnaryExpressionNode(this).interpret(node.unary_expression());
	}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return expr.canCall(function);
	}

	@Override
	public Type getType()
	{
		return type;
	}
	@Override
	public boolean hasLValue()
	{
		return expr.hasLValue();
	}
	public LValueNode<?> getLValue()
	{
		return expr.getLValue();
	}
	@Override
	public boolean hasPropValue()
	{
		return expr.hasPropValue();
	}
	@Override
	public Object getPropValue()
	{
		return expr.getPropValue();
	}
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
		if (getType().getSize() > expr.getType().getSize()) // Need to make space
			assembly += AssemblyUtils.byteCopier(whitespace, getType().getSize(), destSource, AssemblyUtils.constantSource(0, getType().getSize()));
		assembly += expr.getAssembly(leadingWhitespace, destSource, scratchManager);
		
		return assembly;
	}
}
