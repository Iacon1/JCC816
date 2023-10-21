// By Iacon1
// Created 10/10/2023
// A convienent "wrapper" to make the grammar more readable
// Can be a variable, literal, expression, or function call

package Compiler.ComponentNodes;

import java.util.function.Function;

import Compiler.Compiler;
import Compiler.ComponentNodes.Definitions.TypeNode;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Compiler.ComponentNodes.Interfaces.TypedNode;
import Compiler.Utils.CompUtils;
import Grammar.GeneralParser.GeneralNode;

public class RValNode extends ComponentNode<RValNode> implements TypedNode, AssemblableNode
{
	public enum Type
	{
		variable,
		literal,
		expression,
		functionCall,
	}
	private Type type;
	
	private String varName;
	private Object litValue;
	private ExpressionNode expNode;
	private FunctionCallNode callNode;
	
	public static Object determineLiteral(String a)
	{
		if (a.matches("[0-9]+")) // Number
		{
			long value = Long.valueOf(a); // We must determine the smallest size we can use
			if (Math.abs(value) < Math.pow(2, 8 * CompConfig.CompUtils.t_char.getSize())) return Byte.valueOf(a); // Character
			else if (Math.abs(value) < Math.pow(2, 8 * CompConfig.CompUtils.t_short.getSize())) return Short.valueOf(a); // Short
			else if (Math.abs(value) < Math.pow(2, 8 * CompConfig.CompUtils.t_int.getSize())) return Integer.valueOf(a); // Int
			else if (Math.abs(value) < Math.pow(2, 8 * CompConfig.CompUtils.t_long.getSize())) return Long.valueOf(a); // Long
			else return null;
		}
		else if (a.endsWith("\"")) // Quote
			return a.substring(1, a.length() - 2);
		else if (a.endsWith("\'")) // Character
			return Byte.valueOf(a.getBytes()[0]);
		else if (a.equals("false")) // False boolean
			return Boolean.FALSE;
		else if (a.equals("true")) // False boolean
			return Boolean.TRUE;
		else return null;
	}
	
	public RValNode(ComponentNode<?> parent) {super(parent);}

	@Override
	public RValNode interpret(GeneralNode<String, String> node) throws Exception
	{
		switch (node.childrenNodes.size())
		{
		case 0: // Variable or literal
			String value = node.getT(0);
			if (determineLiteral(value) == null) // Literal
			{
				varName = value;
				type = Type.variable;
			}
			else
			{
				litValue = determineLiteral(value);
				type = Type.literal;
			}
			break;
		case 1: // Expression node or function call node
			if (Compiler.getType(node.getNode(0).ruleName) == Compiler.ComponentType.expression) 
			{
				expNode = new ExpressionNode(this).interpret(node.getNode(0));
				type = Type.expression;
			}
			else if (Compiler.getType(node.getNode(0).ruleName) == Compiler.ComponentType.functionCall) 
			{
				callNode = new FunctionCallNode(this).interpret(node.getNode(0));
				type = Type.functionCall;
			}
			break;
		}
		
		return this;
	}

	public Function<Integer, String> getByteSource(String expOperand, int size)
	{
		Function<Integer, String> source = null;
		if (hasPropValue())
		{
			if (CompUtils.Primitive.getType(getType()).isNumeric())
				source = numericSource(((Number) getPropValue()).longValue(), size);
			else if (getType().equals(CompConfig.CompUtils.t_string.getType()))
				source = stringSource((String) getPropValue());
			else if (getType().equals(CompConfig.CompUtils.t_bool.getType()))
				source = byteStreamSource(new byte[] {(byte) ((Boolean) getPropValue() ? 0xFF : 0x00)});
			return source;
		}
		else
		{
			switch (type)
			{
			case variable:
				source = addressSource(resolveVariable(varName).getFullName(), size);
				break;
			case expression:
				source = addressSource(expOperand, size);
				break;
			case functionCall:
				source = addressSource(CompUtils.callResult, size);
				break;
			default:
				source = null;
				break;
			}
			return source;
		}
	}
	public Function<Integer, String> getByteSource(int size)
	{
		return getByteSource(CompUtils.operandA, size);	
	}
	public Function<Integer, String> getByteSource()
	{
		return getByteSource(getType().getSize());
	}
	
	@Override
	public boolean hasPropValue()
	{
		return type == Type.literal || (type == Type.expression && expNode.hasPropValue()) || (type == Type.functionCall && callNode.hasPropValue());
	}
	public boolean hasAssembly()
	{
		return (type == Type.expression && !expNode.hasPropValue()) || (type == Type.functionCall && !callNode.hasPropValue());
	}
	@Override
	public Object getPropValue()
	{
		switch (type)
		{
		case literal:
			return litValue;
		case expression:
			return expNode.getPropValue();
		default:
			return null;
		}
	}
	public String getAssembly(int leadingWhitespace, String destAddr, boolean useOperandB) throws Exception
	{
		if (type == Type.expression) return expNode.getAssembly(leadingWhitespace, destAddr, useOperandB);
		else if (type == Type.functionCall) return callNode.getAssembly(leadingWhitespace);
		else return null;
	}
	public String getAssembly(int leadingWhitespace, String destAddr) throws Exception
	{
		return getAssembly(leadingWhitespace, destAddr, false);
	}

	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		if (type == Type.expression) return expNode.canCall(function);
		else if (type == Type.functionCall) return callNode.canCall(function);
		else return false;
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		return getAssembly(leadingWhitespace, CompUtils.operandA, false);
	}

	@Override
	public TypeNode getType()
	{
		switch (type)
		{
		case variable: return resolveVariable(varName).getType();
		case literal: return CompUtils.Primitive.getType(litValue.getClass()).getType();
		case expression: return expNode.getType();
		case functionCall: return callNode.getType();
		default: return null;
		}
	}
}
