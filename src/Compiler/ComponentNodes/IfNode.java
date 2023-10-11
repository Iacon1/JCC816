// By Iacon1
// Created 10/07/2023
// If statement

package Compiler.ComponentNodes;

import Compiler.CompConfig;
import Compiler.Compiler;
import Compiler.ComponentNodes.Exceptions.TypeMismatchException;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Grammar.GeneralParser.GeneralNode;

public class IfNode extends ComponentNode<IfNode> implements AssemblableNode
{
	private String x;
	private Object literal;
	private Class<?> literalClass;
	
	private ExpressionNode expNode;
	private FunctionCallNode callNode;
	private StatementNode stmNode;
	
	public IfNode(ComponentNode<?> parent) {super(parent);}
	
	@Override
	public IfNode interpret(GeneralNode<String, String> node) throws Exception
	{
		switch (node.childrenNodes.size()) // How many non-terminals?
		{
		case 1: // Possible forms: [var], [literal]
			x = node.getT(2);
			
			literal = ExpressionNode.determineLiteral(x);
			if (literal != null)
				literalClass = literal.getClass();
			
			stmNode = new StatementNode(this).interpret(node.getNode(0));
			break;
		case 2: // Possible forms: [expression], [function call]
			if (Compiler.getType(node.getNode(0).ruleName).equals(Compiler.ComponentType.expression))
				expNode = new ExpressionNode(this).interpret(node.getNode(0));
			else if (Compiler.getType(node.getNode(0).ruleName).equals(Compiler.ComponentType.functionCall))
				callNode = new FunctionCallNode(this).interpret(node.getNode(0));
			
			stmNode = new StatementNode(this).interpret(node.getNode(1));
			break;
		default:
			break;
		}
		
		
		return this;
	}
	
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String whitespace = getWhitespace(leadingWhitespace);
		String assembly = "";
		String skipName = "__IFNOT_" + "1"; // TODO uniquely identify if statements
		if (literal != null) // Literal
		{
			if (CompConfig.BasicType.getType(literalClass).equals(CompConfig.BasicType.t_bool)) // Boolean
				if (!(Boolean) literal) assembly += ""; // Just optimize by skipping this entirely if this is empty.
				else assembly += stmNode.getAssembly(leadingWhitespace);
			else throw new TypeMismatchException(CompConfig.BasicType.getType(literalClass).getName(), CompConfig.BasicType.t_bool.getName());
		}
		else if (expNode != null) // Expression
		{
			if (expNode.getType().equals(CompConfig.BasicType.t_bool.getType()))
			{
				assembly += expNode.getAssembly(leadingWhitespace);
				assembly += whitespace + "BEQ\t" + skipName + "\n";
				assembly += stmNode.getAssembly(leadingWhitespace + CompConfig.indentSize);
				assembly += whitespace + skipName + ":\n";
			}
			else throw new TypeMismatchException(expNode.getType().getName(), CompConfig.BasicType.t_bool.getName());
		}
		else if (callNode != null) // Function Call
		{
			if (callNode.getType().equals(CompConfig.BasicType.t_bool.getType()))
			{
				assembly += callNode.getAssembly(leadingWhitespace);
				assembly += whitespace + "BEQ\t" + skipName + "\n";
				assembly += stmNode.getAssembly(leadingWhitespace + CompConfig.indentSize);
				assembly += whitespace + skipName + ":\n";
			}
			else throw new TypeMismatchException(callNode.getType().getName(), CompConfig.BasicType.t_bool.getName());
		}
		else // Variable
		{
			if (resolveVariable(x).getType().equals(CompConfig.BasicType.t_bool.getType()))
			{
				assembly += whitespace + "LDA\t" + x + "\n"; 
				assembly += whitespace + "BEQ\t" + skipName + "\n";
				assembly += stmNode.getAssembly(leadingWhitespace + CompConfig.indentSize);
				assembly += whitespace + skipName + ":\n";
			}
			else throw new TypeMismatchException(resolveVariable(x).getType().getName(), CompConfig.BasicType.t_bool.getName());
		}
		
		return assembly;
	}

}
