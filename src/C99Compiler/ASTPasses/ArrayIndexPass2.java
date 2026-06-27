// Created by Iacon1 on 11/23/2025.
// Converts *(x+i) to special intermediate
package C99Compiler.ASTPasses;

import java.util.ArrayDeque;
import java.util.Deque;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.PointerType;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.Expressions.AdditiveExpressionNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.CastExpressionNode;
import C99Compiler.CompilerNodes.Expressions.UnaryExpressionNode;
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
		
		
		// Separate base expression and all indices
		AdditiveExpressionNode additiveExpr = (AdditiveExpressionNode) expr;
		BaseExpressionNode<?> x;
		Deque<BaseExpressionNode<?>> addees = new ArrayDeque<BaseExpressionNode<?>>();
		do
		{
			x = additiveExpr.getX();
			addees.push(additiveExpr.getY());
			if (CastExpressionNode.class.isAssignableFrom(x.getClass()))
			{
				if ((AdditiveExpressionNode.class.isAssignableFrom(((CastExpressionNode) x).getCastee().getClass())))
					additiveExpr = (AdditiveExpressionNode) ((CastExpressionNode) x).getCastee();
				else
					additiveExpr = null;
			}
			else if (AdditiveExpressionNode.class.isAssignableFrom(x.getClass()))
				additiveExpr = (AdditiveExpressionNode) x;
			else
				additiveExpr = null;
		}
		while (additiveExpr != null);
		
		// Only run on dereferencings of additions or subtractions where x is a pointer to a known address
		if (!x.getType().isPointer() || !x.hasPropValue(state))
			return node;
		
		// Recombine indices
		BaseExpressionNode<?> y;
		if (addees.size() >= 2)
		{
			BaseExpressionNode<?> t1, t2;
			t1 = addees.pop();
			t2 = addees.pop();
			additiveExpr = new AdditiveExpressionNode(node, "+", t1, t2);
			t1.swapParent(additiveExpr);
			t2.swapParent(additiveExpr);
			while (!addees.isEmpty())
			{
				t1 = additiveExpr;
				t2 = addees.pop();
				additiveExpr = new AdditiveExpressionNode(node, "+", t1, t2);
				t1.swapParent(additiveExpr);
				t2.swapParent(additiveExpr);
			}
			y = additiveExpr;
		}
		else
			y = addees.pop();
		
		LValueNode<?> n = (LValueNode<?>) x.getPropPointer(state).getNode();
		if (x.getType() != n.getType()) // Sometimes happens when a cast from pointer to pointer occurs
			n = new WrapperLValueNode(n, x.getType(), n, 0);
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
