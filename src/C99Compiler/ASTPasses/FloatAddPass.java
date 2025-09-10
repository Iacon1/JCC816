// Created by Iacon1 on 08/02/2025.
// Convert cast expressions involving floats into function calls
package C99Compiler.ASTPasses;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Expressions.AdditiveExpressionNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.CastExpressionNode;
import C99Compiler.CompilerNodes.Expressions.PostfixExpressionNode;
import C99Compiler.Utils.ProgramState;

public class FloatAddPass implements PerNodeASTPass<AdditiveExpressionNode>
{
	@Override public Class<AdditiveExpressionNode> getNodeClass() {return AdditiveExpressionNode.class;}
	
	@Override
	public ComponentNode<?> apply(AdditiveExpressionNode node, ProgramState state)
	{
		String funcName = null;
		PostfixExpressionNode funcNode = null;
		Type typeX = node.getX().getType();
		Type typeY = node.getY().getType();
		
		if (typeX.isFloat() && (!typeY.isFloat() || typeY.getSize() < typeX.getSize()))
		{
			CastExpressionNode castY = new CastExpressionNode(node, typeX, node.getY());
			BaseExpressionNode<?> tmpY = node.getY();
			node.getY().swap(castY);
			tmpY.swapParent(castY);
			typeY = typeX;
		}
		if (typeY.isFloat() && (!typeX.isFloat() || typeX.getSize() < typeY.getSize()))
		{
			CastExpressionNode castX = new CastExpressionNode(node, typeY, node.getX());
			BaseExpressionNode<?> tmpX = node.getX();
			node.getX().swap(castX);
			tmpX.swapParent(castX);
			typeX = typeY;
		}			
		
		if (typeX.isFloat())
		{
			funcName = node.getOperator().equals("+") ? "__add" : "__sub";
			funcName += "flt" + Integer.toString(typeX.getSizeBits());
			funcNode = new PostfixExpressionNode(node, funcName, node.getX(), node.getY());
			node.getX().swapParent(funcNode);
			node.getY().swapParent(funcNode);
			node.swap(funcNode);
			return funcNode;
		}
		else
			return node;
	}

}
