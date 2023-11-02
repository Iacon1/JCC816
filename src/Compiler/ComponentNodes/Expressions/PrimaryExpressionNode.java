// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.VariableNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.Utils.CompUtils;
import Compiler.Utils.ScratchManager;
import Grammar.C99.C99Parser.Primary_expressionContext;

/**
 * 
 */
public class PrimaryExpressionNode extends BaseExpressionNode<Primary_expressionContext>
{
	private String identifier;
	private Object constant;
	private String stringLiteral;
	
	public PrimaryExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	public BaseExpressionNode<Primary_expressionContext> interpret(Primary_expressionContext node) throws Exception
	{
		if (node.expression() != null)
			return (BaseExpressionNode) new ExpressionNode(this).interpret(node.expression());
		else if (node.Identifier() != null)
			identifier = node.Identifier().getText();
		else if (node.Constant() != null)
			constant = CompUtils.parseLiteral(node.Constant().getText());
		else if (node.String_literal() != null)
			stringLiteral = node.String_literal().getText();
		
		return this;
	}
	
	@Override
	public Type getType()
	{
		if (identifier != null) return getVariable().getType();
		else if (constant != null) return CompUtils.getSmallestType((Number) constant);
		else return null;
	}

	@Override
	public VariableNode getVariable()
	{
		if (identifier != null) return ComponentNode.resolveVariable(getScope().getPrefix() + identifier);
		else return null;
	}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function) {return false;}
	@Override
	public boolean hasAssembly() {return false;}
	@Override
	public boolean hasPropValue() {return constant != null || stringLiteral != null;}
	@Override
	public Object getPropValue()
	{
		if (stringLiteral == null) return constant;
		else return stringLiteral;
	}

	@Override
	public String getAssembly(int leadingWhitespace, String writeAddr, ScratchManager scratchManager) throws Exception
	{
		return null;
	}
}
