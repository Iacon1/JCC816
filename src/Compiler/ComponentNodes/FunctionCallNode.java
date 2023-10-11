// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes;

import Grammar.GeneralParser.GeneralNode;
import Compiler.CompConfig;
import Compiler.ComponentNodes.Exceptions.TypeMismatchException;
import Compiler.ComponentNodes.Interfaces.AssemblableNode;
import Compiler.ComponentNodes.Interfaces.TypedNode;

public class FunctionCallNode extends ComponentNode<FunctionCallNode> implements TypedNode, AssemblableNode
{
	private String function;
	private ArgListNode arguments;
	
	public FunctionCallNode(ComponentNode<?> parent) {super(parent);}

	@Override
	public FunctionCallNode interpret(GeneralNode<String, String> node) throws Exception
	{
		this.function = node.getT(0);
		if (node.childrenNodes.size() > 0)
			this.arguments = new ArgListNode(this).interpret(node.getNode(0));
		else
			this.arguments = null; // No parameters
		
		return this;
	}
	
	@Override
	public TypeNode getType()
	{
		return resolveFunction(function).getType();
	}
	
	public FunctionNode getFunction()
	{
		return resolveFunction(function);
	}
	
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String whitespace = getWhitespace(leadingWhitespace);
		String assembly = "";
		
		
		if (this.arguments != null) // Process parameters if present
			for (int i = 0; i < arguments.getArguments().size(); ++i)				
			{
				Object arg = arguments.getArguments().get(i);
				TypeNode argType = null;
				VarDeclarationNode paramSlot = getFunction().getParameters().get(i);
				
				if (arg.getClass().equals(String.class)) // Variable or Literal
				{
					String x = (String) arg;
					Object literalX = ExpressionNode.determineLiteral(x);
					if (literalX != null)
					{
						CompConfig.BasicType literalXType = CompConfig.BasicType.getType(literalX.getClass());
						if (literalXType.getType().equals(paramSlot.getType()))
						{
							switch (CompConfig.BasicType.getType(literalX.getClass()))
							{
							case t_int:
								assembly += byteCopier(whitespace, paramSlot.getFullName(), (Integer) literalX);
								break;
							case t_string:
								assembly += byteCopier(whitespace, paramSlot.getFullName(), (String) literalX);
								break;
							case t_char:
								assembly += byteCopier(whitespace, paramSlot.getFullName(), (Character) literalX);
								break;
							case t_bool:
								assembly += byteCopier(whitespace, paramSlot.getFullName(), (Boolean) literalX);
								break;
							default:
								break;
							}
						}
						else throw new TypeMismatchException(literalXType.getType(), paramSlot.getType()); // Must agree with variable type
					}
					else // Variable
					{
						VarDeclarationNode argVar = resolveVariable((String) arg);
						if (argVar.getType().equals(paramSlot.getType()))
						{
							assembly += byteCopier(whitespace, argVar.getType().getSize(), paramSlot.getFullName(), argVar.getFullName());
							break;
						}
						else throw new TypeMismatchException(argVar.getType(), paramSlot.getType()); // Must agree with variable type
					}
				}
				else if (arg.getClass().equals(ExpressionNode.class)) // Expression
				{
					ExpressionNode nodeX = (ExpressionNode) arg;
					assembly += nodeX.getAssembly(leadingWhitespace);
					if (nodeX.getType().equals(paramSlot.getType()))
					{
						assembly += byteCopier(whitespace, nodeX.getType().getSize(), paramSlot.getFullName(), CompConfig.operandA);
						break;
					}
					else throw new TypeMismatchException(nodeX.getType(), paramSlot.getType()); // Must agree with variable type
				}
				else if (arg.getClass().equals(ExpressionNode.class)) // Function call
				{
					FunctionCallNode nodeX = (FunctionCallNode) arg;
					assembly += nodeX.getAssembly(leadingWhitespace);
					if (nodeX.getType().equals(paramSlot.getType()))
					{
						assembly += byteCopier(whitespace, nodeX.getType().getSize(), paramSlot.getFullName(), CompConfig.callResult);
						break;
					}
					else throw new TypeMismatchException(nodeX.getType(), paramSlot.getType()); // Must agree with variable type
				}
			}
		
		assembly += whitespace + "JSL\t" + resolveFunction(function).getFullName() + "\n";
		
		return assembly;
		
	}
}
