// Created by Iacon1 on 08/02/2025.
// Convert cast expressions involving floats into function calls
package C99Compiler.ASTPasses;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Expressions.AdditiveExpressionNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.CastExpressionNode;
import C99Compiler.CompilerNodes.Expressions.PostfixExpressionNode;
import C99Compiler.CompilerNodes.Expressions.UnaryExpressionNode;
import C99Compiler.Utils.ProgramState;

public class FloatNegPass implements PerNodeASTPass<UnaryExpressionNode>
{
	@Override public Class<UnaryExpressionNode> getNodeClass() {return UnaryExpressionNode.class;}
	
	@Override
	public ComponentNode<?> apply(UnaryExpressionNode node, ProgramState state)
	{
		String funcName = null;
		PostfixExpressionNode funcNode = null;
		Type type = node.getExpression().getType();
		
		if (type.isFloat() && node.getOperator().equals("-"))
		{
			funcName = "__negflt" + Integer.toString(type.getSizeBits());
			funcNode = new PostfixExpressionNode(node, funcName, node.getExpression());
			node.getExpression().swapParent(funcNode);
			node.swap(funcNode);
			return funcNode;
		}
		else
			return node;
	}

}
