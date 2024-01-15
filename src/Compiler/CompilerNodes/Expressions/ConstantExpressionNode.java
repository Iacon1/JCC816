// Created by Iacon1 on 10/22/2023.
//
package Compiler.CompilerNodes.Expressions;

import Compiler.CompilerNodes.ComponentNode;
import Compiler.CompilerNodes.FunctionDefinitionNode;
import Compiler.CompilerNodes.Definitions.Type;
import Compiler.Exceptions.ConstraintException;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Constant_expressionContext;

public class ConstantExpressionNode extends BaseExpressionNode<Constant_expressionContext>
{
	public ConstantExpressionNode(ComponentNode<?> parent) {super(parent);}
	
	public BaseExpressionNode<Constant_expressionContext> interpret(Constant_expressionContext node) throws Exception
	{
		BaseExpressionNode<?> expr = new ConditionalExpressionNode(this).interpret(node.conditional_expression());
		if (!expr.hasPropValue())
			throw new ConstraintException("6.6", 4, node.start);
		return (BaseExpressionNode) expr;
	}

	// These will all *never* be called, since we always delegate to a conditional expression
	@Override
	public boolean canCall(FunctionDefinitionNode function) {throw new UnsupportedOperationException();}
	@Override
	public Type getType() {throw new UnsupportedOperationException();}
	@Override
	public boolean hasPropValue() {throw new UnsupportedOperationException();}
	@Override
	public Object getPropValue() {throw new UnsupportedOperationException();}
	@Override
	public boolean hasAssembly() {throw new UnsupportedOperationException();}
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager, DetailsTicket ticket) throws Exception {throw new UnsupportedOperationException();}
}
