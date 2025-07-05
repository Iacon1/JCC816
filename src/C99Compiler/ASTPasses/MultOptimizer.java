// Created by Iacon1 on 02/21/2025.
// Optimize mult-by-constants
package C99Compiler.ASTPasses;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.Expressions.AdditiveExpressionNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.MultiplicativeExpressionNode;
import C99Compiler.CompilerNodes.Expressions.ShiftExpressionNode;
import C99Compiler.Utils.ProgramState;

public class MultOptimizer implements PerNodeASTPass<MultiplicativeExpressionNode>
{
	@Override public Class<MultiplicativeExpressionNode> getNodeClass() {return MultiplicativeExpressionNode.class;}
	
	private static int optimizedComplexity(long l) // Simulates below const-mult optimization to see if it's worth the trouble
	{
		if (l <= 1)
			return 1;
		
		boolean startOdd = (l % 2 == 1);
		
		do l /= 2;
		while (l % 2 == 0 && 1 < l); // How many times can we divide by zero?

		return (startOdd ? 2 : 1) +  optimizedComplexity(l);
	}
	
	@Override
	public ComponentNode<?> apply(MultiplicativeExpressionNode node, ProgramState state)
	{
		String operator = node.getOperator();
		BaseExpressionNode<?> x = node.getX();
		BaseExpressionNode<?> y = node.getY();
		BaseExpressionNode<?> optNode = null;
		
		if (operator.equals("%")) return node; // Don't do for modulo
		if (x.hasPropValue(state) && operator.equals("*")) // We need x to be the variable one
		{
			BaseExpressionNode<?> t = y;
			y = x;
			x = t;
		}
		else if (x.hasPropValue(state)) // There's no way to fix this in division
			return node;
		
		if (x.hasPropValue(state)) return node; // Gonna get fully optimized anyway
		if (!y.hasPropValue(state)) return node; // Can't optimize this
		if (operator.equals("*"))
		{
			if (y.hasPropValue(state) && 1 < y.getPropLong(state) && optimizedComplexity(y.getPropLong(state)) <= CompConfig.maxOptimizedMultComplexity)
			{	
				long l = y.getPropLong(state);
				int i = 0;
				boolean startOdd = (l % 2 == 1);
				do
				{
					l /= 2;
					i += 1;
				}
				while (l % 2 == 0 && 1 < l); // How many times can we divide by two?
				DummyExpressionNode d1, d2;
				d1 = new DummyExpressionNode(node, y.getType(), l);
				d2 = new DummyExpressionNode(node, y.getType(), i);
				BaseExpressionNode<?> m1 = new MultiplicativeExpressionNode(node, "*", x, d1);
				d1.swapParent(m1);
				m1 = (BaseExpressionNode<?>) apply((MultiplicativeExpressionNode) m1, state);
				ShiftExpressionNode s1 = new ShiftExpressionNode(node, "<<", m1, d2);
				m1.swapParent(s1);
				d2.swapParent(s1);
				
				optNode = s1;
				if (startOdd)
				{
					optNode = new AdditiveExpressionNode(node, "+", s1, x);
					s1.swapParent(optNode);
				}
			}
			else if (y.hasPropValue(state) && 1 == y.getPropLong(state))
				optNode = x;	
		}
		else if (operator.equals("/") && (y.getPropLong(state) & (y.getPropLong(state) - 1)) == 0) // y is power of 2
		{
			assert y.getPropLong(state) != 0; // Should be caught by parsing
			DummyExpressionNode d1;
			d1 = new DummyExpressionNode(node, y.getType(), (int) (Math.log(y.getPropLong(state)) / Math.log(2)));
			ShiftExpressionNode s1 = new ShiftExpressionNode(node, ">>", x, d1);
			optNode = s1;
		}
		
		if (optNode == null)
			return node;
		node.swap(optNode);
		return optNode;
	}

}
