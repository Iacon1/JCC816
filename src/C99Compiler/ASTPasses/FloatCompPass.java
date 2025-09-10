// Created by Iacon1 on 08/02/2025.
// Convert cast expressions involving floats into function calls
package C99Compiler.ASTPasses;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.Expressions.EqualityExpressionNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.CastExpressionNode;
import C99Compiler.CompilerNodes.Expressions.PostfixExpressionNode;
import C99Compiler.CompilerNodes.Expressions.RelationalExpressionNode;
import C99Compiler.Utils.ProgramState;

public class FloatCompPass implements PerNodeASTPass<RelationalExpressionNode>
{
	@Override public Class<RelationalExpressionNode> getNodeClass() {return RelationalExpressionNode.class;}
	
	@Override
	public ComponentNode<?> apply(RelationalExpressionNode node, ProgramState state)
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
			funcName = "__cmpsflt" + Integer.toString(typeX.getSizeBits());
			funcNode = new PostfixExpressionNode(node, funcName, node.getX(), node.getY());
			node.getX().swapParent(funcNode);
			node.getY().swapParent(funcNode);
			BaseExpressionNode<?> tmpNode = null;
			
			switch (node.getOperator())
			{
			case "<":
				tmpNode = new EqualityExpressionNode(funcNode, funcNode,
						new DummyExpressionNode(funcNode, funcNode.getType(), -1), "==");
				break;
			case ">":
				tmpNode = new EqualityExpressionNode(funcNode, funcNode,
						new DummyExpressionNode(funcNode, funcNode.getType(), 1), "==");
				break;
			case "<=":
				tmpNode = new EqualityExpressionNode(funcNode, funcNode,
						new DummyExpressionNode(funcNode, funcNode.getType(), 1), "!=");
				break;
			case ">=":
				tmpNode = new EqualityExpressionNode(funcNode, funcNode,
						new DummyExpressionNode(funcNode, funcNode.getType(), -1), "!=");
				break;
			}
			funcNode.swap(tmpNode);
			funcNode.swapParent(tmpNode);
			node.swap(tmpNode);
			return tmpNode;
		}
		else
			return node;
	}

}
