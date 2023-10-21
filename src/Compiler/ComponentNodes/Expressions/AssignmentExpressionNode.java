// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.InterpretingNode;
import Compiler.ComponentNodes.RValNode;
import Compiler.ComponentNodes.VariableNode;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Compiler.Exceptions.TypeMismatchException;
import Grammar.C99.C99Parser.Assignment_expressionContext;
import Grammar.C99.C99Parser.Conditional_expressionContext;
import Grammar.C99.C99Parser.Unary_expressionContext;

// TODO conditional expression
public class AssignmentExpressionNode extends BinaryExpressionNode
<Unary_expressionContext, Assignment_expressionContext, Conditional_expressionContext, Assignment_expressionContext>
{
	@Override
	protected BaseExpressionNode<Unary_expressionContext> getC1Node(Assignment_expressionContext node) throws Exception
	{return new UnaryExpressionNode(this).interpret(node.unary_expression());}
	@Override
	protected BaseExpressionNode<Assignment_expressionContext> getC2Node(Assignment_expressionContext node) throws Exception
	{return new AssignmentExpressionNode(this).interpret(node.assignment_expression());}
	@Override
	protected BaseExpressionNode<Conditional_expressionContext> getPCNode(Assignment_expressionContext node) throws Exception
	{return new ConditionalExpressionNode(this).interpret(node.conditional_expression());}
	
	public AssignmentExpressionNode(ComponentNode<?> parent) {super(parent);}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return y.canCall(function);
	}
	@Override
	public Object getPropValue() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String getAssembly(int leadingWhitespace, String writeAddr, boolean useB) throws Exception
	{
		String whitespace = getWhitespace(leadingWhitespace);
		String assembly = "";
		VariableNode xVar;
		
		if (x.hasAssembly()) assembly += x.getAssembly(leadingWhitespace, useB);
		xVar = x.getVariable();
		if (xVar == null) return assembly;
		if (!xVar.canCastFrom(y.getType()))
			throw new TypeMismatchException(x.getType(), y.getType());
		if (y.hasAssembly())
			assembly += y.getAssembly(leadingWhitespace, xVar.getFullName(), useB);
		else if (y.hasPropValue())
			assembly += byteCopier(whitespace, xVar.getType().getSize(), xVar.getFullName(), y.getPropValue());
		else
			assembly += byteCopierAddr(whitespace, xVar.getType().getSize(), xVar.getFullName(), y.getVariable().getFullName());
		
		return assembly;
	}
}
