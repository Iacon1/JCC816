// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes;

import Grammar.GeneralParser.GeneralNode;
import Compiler.CompConfig;
import Compiler.Compiler;
import Compiler.ComponentNodes.Exceptions.TypeMismatchException;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Compiler.ComponentNodes.Interfaces.TypedNode;

public class ReturnNode extends ComponentNode<ReturnNode> implements AssemblableNode
{
	private String returnVar;
	private Object returnLit; private Class<?> returnClass;
	private ExpressionNode returnExp;
	private FunctionCallNode returnCall;
	
	public ReturnNode(ComponentNode<?> parent) {super(parent);}

	@Override
	public ReturnNode interpret(GeneralNode<String, String> node) throws Exception
	{
		if (node.childrenNodes.size() == 0) // Variable or literal
		{
			String returnVal = node.getT(1);
			returnLit = ExpressionNode.determineLiteral(returnVal);
			if (returnLit != null)
			{
				returnVar = null;
				returnClass = returnLit.getClass();
			}
			else
			{
				returnVar = returnVal;
				returnClass = null;
			}
		}
		else // Expression or function call
		{
			returnVar = null;
			returnLit = null;
			returnClass = null;
			
			switch (Compiler.getType(node.getNode(0).ruleName))
			{
			case expression:
				returnExp = new ExpressionNode(this).interpret(node.getNode(0));
				returnCall = null;
				break;
			case functionCall:
				returnExp = null;
				returnCall = new FunctionCallNode(this).interpret(node.getNode(0));
				break;
			default:
				break;
			}
		}
		
		return this;
	}
	
	private FunctionNode getFunction()
	{
		return resolveFunction(getScope()[getScope().length - 1]);
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String whitespace = getWhitespace(leadingWhitespace);
		String assembly = "";
		
		if (returnVar != null)
			assembly += byteCopier(whitespace, resolveVariable(returnVar).size(), CompConfig.callResult, resolveVariable(returnVar).getFullName());
		else if (returnLit != null)
			switch (CompConfig.BasicType.getType(returnClass))
			{
			case t_int:
				assembly += byteCopier(whitespace, CompConfig.callResult, (Integer) returnLit);
				break;
			case t_string:
				assembly += byteCopier(whitespace, CompConfig.callResult, (String) returnLit);
				break;
			case t_char:
				assembly += byteCopier(whitespace, CompConfig.callResult, (Character) returnLit);
				break;
			case t_bool:
				assembly += byteCopier(whitespace, CompConfig.callResult, (Boolean) returnLit);
				break;
			default:
				break;
			}
		else if (returnExp != null)
			assembly += returnExp.getAssembly(leadingWhitespace, CompConfig.callResult);
		else if (returnCall != null)
			assembly += returnCall.getAssembly(leadingWhitespace);
		
		assembly += whitespace + "JML\t" + getFunction().getEndLabel() + "\n";
		
		return assembly;
		
	}
}
