// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import java.util.LinkedHashMap;
import java.util.List;

import C99Compiler.CompConfig;
import C99Compiler.CompConfig.OptimizationLevel;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.ArrayType;
import C99Compiler.CompilerNodes.Definitions.PointerType;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyType;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.Exceptions.UndefinedVariableException;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.PropPointer;
import C99Compiler.Utils.OperandSources.OperandSource;
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
			return delegate(new ExpressionNode(this).interpret(node.expression()));
		else if (node.Identifier() != null)
		{
			identifier = node.Identifier().getText();
			// Valid uses of identifier
			if (resolveEnumeratorRelative(identifier) != null); // Enumerator
			else if (hasLValue(new ProgramState())); // Variable
			else if (resolveFunctionRelative(identifier) != null); // Function
			else throw new UndefinedVariableException(identifier, node.start);
		}
		else if (node.Constant() != null)
			constant = CompUtils.parseLiteral(node.Constant().getText());
		else if (node.String_literal() != null)
		{
			stringLiteral = node.String_literal().getText();
			stringLiteral = stringLiteral.substring(1, stringLiteral.length() - 1);
		}
		
		return this;
	}
	
	@Override
	public Type getType()
	{
		if (identifier != null)
			if (resolveEnumeratorRelative(identifier) != null)
				return resolveEnumeratorRelative(identifier).getType();
			else if (hasLValue(new ProgramState())) return getLValue(new ProgramState()).getType();
			else // Probably function pointer
				return resolveFunctionRelative(identifier).getType();
		else if (constant != null) return CompUtils.getSmallestType((Number) constant);
		else if (stringLiteral != null)
		{
			ArrayType t = new ArrayType(new DummyType("char"));
			t.setLength(stringLiteral.length() + 1);
			return t;
		}
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
	public boolean canCall(ProgramState state, FunctionDefinitionNode function) {return false;}
	@Override
	public boolean hasAssembly(ProgramState state) {return false;}
	@Override
	public boolean hasPropValue(ProgramState state)
	{
		if (identifier != null)
		{
			if (resolveVariableRelative(identifier) != null &&
					resolveVariableRelative(identifier).getType().isArray())
				return true; // Arrays can degrade to pointers
			if (resolveEnumeratorRelative(identifier) != null)
				return true; // Enumerator
			else if (hasLValue(new ProgramState()) && state.getOnlyValue(getLValue(new ProgramState())) != null && OptimizationLevel.isAtLeast(OptimizationLevel.medium))
				return true;
			else if (resolveFunctionRelative(identifier) != null)
				return true;
			else
				return false;
		}
		else return constant != null || stringLiteral != null;
	}
	@Override
	public Object getPropValue(ProgramState state)
	{
		if (identifier != null)
		{
			if (resolveVariableRelative(identifier) != null &&
					resolveVariableRelative(identifier).getType().isArray())
				return new PropPointer<VariableNode>(resolveVariableRelative(identifier), 0);
			if (resolveEnumeratorRelative(identifier) != null)
				return resolveEnumeratorRelative(identifier).getValue();
			else if (getLValue(state) != null)
				return state.getOnlyValue(getLValue(state));
			else if (resolveFunctionRelative(identifier) != null)
				return resolveFunctionRelative(identifier);
			else
				return null;
		}
		else if (stringLiteral == null) return constant;
		else return stringLiteral;
	}
	
	@Override
	public boolean hasLValue(ProgramState state) 
	{
		return identifier != null && resolveVariableRelative(identifier) != null;
	}
	@Override
	public LValueNode<?> getLValue(ProgramState state)
	{
		if (identifier != null) return resolveVariableRelative(identifier);
		else return null;
	}
	
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception {throw new UnsupportedOperationException();}
}
