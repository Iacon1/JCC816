// Created by Iacon1 on 10/20/2023.
// 
package Compiler.CompilerNodes.Expressions;

import Compiler.CompilerNodes.ComponentNode;
import Compiler.CompilerNodes.FunctionDefinitionNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.ScratchManager.ScratchSource;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Conditional_expressionContext;
import Grammar.C99.C99Parser.ExpressionContext;
import Grammar.C99.C99Parser.Lor_expressionContext;

// TODO conditional expression
public class ConditionalExpressionNode extends BinaryExpressionNode
<ExpressionContext, Conditional_expressionContext, Lor_expressionContext, Conditional_expressionContext>
{
	private BaseExpressionNode<?> z;
	@Override
	protected BaseExpressionNode<ExpressionContext> getC1Node(Conditional_expressionContext node) throws Exception
	{return new ExpressionNode(this).interpret(node.expression());}
	@Override
	protected BaseExpressionNode<Conditional_expressionContext> getC2Node(Conditional_expressionContext node) throws Exception
		{return new ConditionalExpressionNode(this).interpret(node.conditional_expression());}
	@Override
	protected BaseExpressionNode<Lor_expressionContext> getPCNode(Conditional_expressionContext node) throws Exception
		{return new LORExpressionNode(this).interpret(node.lor_expression());}
	
	@Override
	public BaseExpressionNode<Conditional_expressionContext> interpret(Conditional_expressionContext node) throws Exception
	{
		if (node.children.size() == 1) // Only one, just propagate it
			return (BaseExpressionNode) getPCNode(node);
		else // Two
		{
			z = (BaseExpressionNode) new LORExpressionNode(this).interpret(node.lor_expression());
			x = getC1Node(node);
			y = getC2Node(node);
			
			operator = "";
			for (int i = 0; i < node.getChildCount(); ++i)
				if (node.getTokens(i).size() == 1) operator += node.getToken(i, 0);
		}
		return this;
	}
	public ConditionalExpressionNode(ComponentNode<?> parent) {super(parent);}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return x.canCall(function) || y.canCall(function) || z.canCall(function);
	}
	public boolean hasPropValue()
	{
		return x.hasPropValue() && y.hasPropValue() && z.hasPropValue();
	}
	@Override
	public Object getPropValue()
	{
		if (z.getPropBool()) return x.getPropValue();
		else return y.getPropValue();
	}
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, OperandSource sourceX,
			OperandSource sourceY, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		String assembly = "";
		if (!z.hasPropValue())
		{
			if (z.hasAssembly())
			{
				OperandSource sourceZ;
				if (z.hasLValue())
				{
					sourceZ = z.getLValue().getSource();
					assembly += z.getAssembly(whitespace.length(), null, scratchManager, ticket);
					assembly += EqualityExpressionNode.getIsZero(whitespace, null, scratchManager, sourceZ, ticket);
				}
				else
				{
					sourceZ = scratchManager.reserveScratchBlock(z.getSize());
					assembly += z.getAssembly(whitespace.length(), sourceZ, scratchManager, ticket);
					if (z.getSize() > 1)
						assembly += EqualityExpressionNode.getIsZero(whitespace, null, scratchManager, sourceZ, ticket);
					scratchManager.releaseScratchBlock((ScratchSource) sourceZ);
				}		
			}
			else if (z.hasLValue())
			{
				OperandSource sourceZ = z.getLValue().getSource();
				assembly += EqualityExpressionNode.getIsZero(whitespace, null, scratchManager, sourceZ, ticket);
			}
			assembly += whitespace + "BEQ\t:+\n";
			assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), destSource, sourceX);
			assembly += whitespace + "BRA\t:+\n";
			assembly += AssemblyUtils.byteCopier(whitespace, sourceY.getSize(), destSource, sourceY);
			assembly += whitespace + ":\n";
		}
		else
		{
			if (z.getPropBool())
				assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), destSource, sourceX);
			else
				assembly += AssemblyUtils.byteCopier(whitespace, sourceY.getSize(), destSource, sourceY);
		}
		
		return assembly;
	}
	
}
