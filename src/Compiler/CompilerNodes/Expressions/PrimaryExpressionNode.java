// Created by Iacon1 on 10/20/2023.
//
package Compiler.CompilerNodes.Expressions;

import java.util.LinkedHashMap;
import java.util.List;

import Compiler.CompConfig.OptimizationLevel;
import Compiler.CompilerNodes.ComponentNode;
import Compiler.CompilerNodes.FunctionDefinitionNode;
import Compiler.CompilerNodes.Definitions.Type;
import Compiler.CompilerNodes.LValues.LValueNode;
import Compiler.CompilerNodes.LValues.VariableNode;
import Compiler.Exceptions.UndefinedVariableException;
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
		{
			identifier = node.Identifier().getText();
			// Valid uses of identifier
			if (resolveEnumeratorRelative(identifier) != null); // Enumerator
			else if (hasLValue()); // Variable
			else if (resolveFunctionRelative(identifier) != null); // Function
			else throw new UndefinedVariableException(identifier, node.start);
		}
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
			if (resolveEnumeratorRelative(identifier) != null)
				return resolveEnumeratorRelative(identifier).getType();
			else if (hasLValue()) return getLValue().getType();
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
	public LinkedHashMap<String, VariableNode> getReferencedVariables(boolean strict)
	{
		LinkedHashMap<String, VariableNode> referencedVariables = super.getReferencedVariables(strict);
		VariableNode v = resolveVariableRelative(identifier);
		if (identifier != null && v != null)
			referencedVariables.put(v.getFullName(), v);
		return referencedVariables;
	}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function) {return false;}
	@Override
	public boolean hasAssembly() {return false;}
	@Override
	public boolean hasPropValue()
	{
		if (identifier != null)
		{
			if (resolveEnumeratorRelative(identifier) != null)
				return true; // Enumerator
			else if (hasLValue() && getLValue().hasPossibleValues() && OptimizationLevel.isAtLeast(OptimizationLevel.medium))
				return getLValue().getPossibleValues().size() == 1;
			else if (resolveFunctionRelative(identifier) != null)
				return true;
			else
				return false;
		}
		else return constant != null || stringLiteral != null;
	}
	@Override
	public Object getPropValue()
	{
		if (identifier != null)
		{
			if (resolveEnumeratorRelative(identifier) != null)
				return resolveEnumeratorRelative(identifier).getValue();
			else if (getLValue() != null)
				return getLValue().getPossibleValues().toArray()[0];
			else if (resolveFunctionRelative(identifier) != null)
				return resolveFunctionRelative(identifier);
			else
				return null;
		}
		else if (stringLiteral == null) return constant;
		else return stringLiteral;
	}
	
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager, DetailsTicket ticket) throws Exception {return null;}
}
