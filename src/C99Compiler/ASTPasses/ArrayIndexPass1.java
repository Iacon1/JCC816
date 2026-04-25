// Created by Iacon1 on 09/20/2025.
// Converts X[] to *(x+i)
package C99Compiler.ASTPasses;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Expressions.AdditiveExpressionNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.PostfixExpressionNode;
import C99Compiler.CompilerNodes.Expressions.PostfixExpressionNode.PFType;
import C99Compiler.ProgramState.ProgramState;
import C99Compiler.CompilerNodes.Expressions.UnaryExpressionNode;

public class ArrayIndexPass1 implements PerNodeASTPass<PostfixExpressionNode>
{
	@Override
	public Class<PostfixExpressionNode> getNodeClass()
	{
		return PostfixExpressionNode.class;
	}

	private ComponentNode<?> applyRecursive(PostfixExpressionNode node, ProgramState state)
	{
		if (node.getPFType() == PFType.arraySubscript)
		{
			BaseExpressionNode<?> expr = node.getExpr();
			if (expr.getType().isArray() &&
					PostfixExpressionNode.class.isAssignableFrom(expr.getClass()) &&
					((PostfixExpressionNode) expr).getPFType() == PFType.arraySubscript)
				expr = (BaseExpressionNode<?>) applyRecursive((PostfixExpressionNode) expr, state);
			
			AdditiveExpressionNode a = new AdditiveExpressionNode(node, "+", expr, node.getIndexExpr());
			expr.swapParent(a);
			node.getIndexExpr().swapParent(a);
			node.swap(a);
			
			return a;
		}
		return node;
	}
	
	@Override
	public ComponentNode<?> apply(PostfixExpressionNode node, ProgramState state)
	{
		ComponentNode<?> c = applyRecursive(node, state);
		if (c == node) return node;
		UnaryExpressionNode u = new UnaryExpressionNode(c, "*", (BaseExpressionNode<?>) c);
		c.swap(u);
		c.swapParent(u);
		return u;
	}
}
