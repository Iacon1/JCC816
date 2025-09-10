// Created by Iacon1 on 08/02/2025.
// Convert cast expressions involving floats into function calls
package C99Compiler.ASTPasses;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Expressions.CastExpressionNode;
import C99Compiler.CompilerNodes.Expressions.PostfixExpressionNode;
import C99Compiler.Utils.ProgramState;

public class FloatCastPass implements PerNodeASTPass<CastExpressionNode>
{
	@Override public Class<CastExpressionNode> getNodeClass() {return CastExpressionNode.class;}
	
	@Override
	public ComponentNode<?> apply(CastExpressionNode node, ProgramState state)
	{
		String funcName = null;
		PostfixExpressionNode funcNode = null;
		Type typeTo = node.getType();
		Type typeFrom = node.getCastee().getType();
		
		if (typeTo.isFloat()) // Cast to float
		{
			if (typeFrom.isInteger()) // Cast from integer to float
			{
				funcName =
						(typeFrom.isSigned() ? "__sint" : "__uint") +
						(8 * typeFrom.getSize()) +
						"toflt" +
						(8 * typeTo.getSize());
			}
			else if (typeTo.getSize() != typeFrom.getSize()) // Cast between float types
			{
				funcName =
						"__flt" +
						(8 * typeFrom.getSize()) +
						"toflt" +
						(8 * typeTo.getSize());	
			}
		}
		else if (typeTo.isInteger() && typeFrom.isFloat()) // Cast to integer from float
		{
			funcName =
					"__flt" +
					(8 * typeFrom.getSize()) +
					(typeFrom.isSigned() ? "tosint" : "touint") +
					(8 * typeTo.getSize());
		}
		
		if (funcName != null)
		{
			funcNode = new PostfixExpressionNode(node, funcName, node.getCastee());
			node.getCastee().swapParent(funcNode);
			node.swap(funcNode);
			return funcNode;
		}
		else
			return node;
	}

}
