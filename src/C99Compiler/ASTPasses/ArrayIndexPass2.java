// Created by Iacon1 on 11/23/2025.
// Converts *(x+i) to special intermediate
package C99Compiler.ASTPasses;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.PointerType;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.Expressions.AdditiveExpressionNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.PostfixExpressionNode;
import C99Compiler.CompilerNodes.Expressions.PostfixExpressionNode.PFType;
import C99Compiler.CompilerNodes.Expressions.UnaryExpressionNode;
import C99Compiler.CompilerNodes.Interfaces.AddressableNode;
import C99Compiler.CompilerNodes.Intermediates.ArrayIndexExpressionNode;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.CompilerNodes.LValues.WrapperLValueNode;
import C99Compiler.ProgramState.ProgramState;

public class ArrayIndexPass2 implements PerNodeASTPass<UnaryExpressionNode>
{
	@Override
	public Class<UnaryExpressionNode> getNodeClass()
	{
		return UnaryExpressionNode.class;
	}

	@Override
	public ComponentNode<?> apply(UnaryExpressionNode node, ProgramState state)
	{
		BaseExpressionNode<?> expr = node.getExpression();
		
		// Only run on dereferencings
		if (!node.getOperator().equals("*"))
			return node;
		// Only run on dereferencings of additions or subtractions
		if (!AdditiveExpressionNode.class.isAssignableFrom(expr.getClass()))
			return node;
		AdditiveExpressionNode additiveExpr = (AdditiveExpressionNode) expr;
		BaseExpressionNode<?> x, y;
		x = additiveExpr.getX();
		y = additiveExpr.getY();
		// Only run on dereferencings of additions or subtractions where x is a pointer to a known address
		if (!x.getType().isPointer() || !additiveExpr.getX().hasPropValue(state))
			return node;
		
		LValueNode<?> n = (LValueNode<?>) x.getPropPointer(state).getNode();
		if (y.hasPropValue(state))
		{
			Type type = ((PointerType) n.getType()).getType();
			DummyExpressionNode d = new DummyExpressionNode(node, new WrapperLValueNode(node, type, n, (int) y.getPropLong(state)));
			node.swap(d);
			return d;
		}
		else
		{
			ArrayIndexExpressionNode u = new ArrayIndexExpressionNode(node, n, y);
			x.swapParent(u);
			y.swapParent(u);
			node.swap(u);
			return u;
		}
	}
}
