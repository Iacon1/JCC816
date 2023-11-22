// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import java.util.ArrayList;
import java.util.List;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.LValues.LValueNode;
import Compiler.ComponentNodes.LValues.VariableNode;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.CompUtils;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Primary_expressionContext;

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
		if (identifier != null)
			if (hasLValue()) return getLValue().getType();
			else // Probably function pointer
				return resolveFunctionRelative(identifier).getType();
		else if (constant != null) return CompUtils.getSmallestType((Number) constant);
		else return null;
	}

	@Override
	public boolean hasLValue() {return identifier != null && resolveVariableRelative(identifier) != null;}
	@Override
	public LValueNode<?> getLValue()
	{
		if (identifier != null) return resolveVariableRelative(identifier);
		else return null;
	}
	
	@Override
	public List<VariableNode> getReferencedVariables(boolean strict)
	{
		List<VariableNode> referencedVariables = super.getReferencedVariables();
		if (identifier != null && resolveVariableRelative(identifier) != null)
			referencedVariables.add(resolveVariableRelative(identifier));
		return referencedVariables;
	}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function) {return false;}
	@Override
	public boolean hasAssembly() {return false;}
	@Override
	public boolean hasPropValue()
	{
		if (hasLValue() && getLValue().hasPossibleValues()) return getLValue().getPossibleValues().size() == 1;
		else if (identifier != null && resolveFunctionRelative(identifier) != null) return true;
		else return constant != null || stringLiteral != null;
	}
	@Override
	public Object getPropValue()
	{
		if (getLValue() != null) return getLValue().getPossibleValues().toArray()[0];
		else if (identifier != null && resolveFunctionRelative(identifier) != null) return resolveFunctionRelative(identifier);
		else if (stringLiteral == null) return constant;
		else return stringLiteral;
	}
	
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager, DetailsTicket ticket) throws Exception {return null;}
}
