// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes;

import Grammar.GeneralParser.GeneralNode;
import Compiler.Exceptions.TypeMismatchException;
import Compiler.ComponentNodes.Definitions.TypeNode;
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
	
	public FunctionDefinitionNode getFunction()
	{
		return resolveFunction(function);
	}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return function.equals(resolveFunction(this.function));
	}
	
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		String whitespace = getWhitespace(leadingWhitespace);
		String assembly = "";
		
		
		if (this.arguments != null) // Process parameters if present
			for (int i = 0; i < arguments.getArguments().size(); ++i)				
			{
				RValNode arg = arguments.getArguments().get(i);
				VarDeclarationNode paramSlot = getFunction().getParameters().get(i);
				
				if (arg.getType().equals(paramSlot.getType())) // Must agree with variable type
					{
						if (arg.hasAssembly()) assembly += arg.getAssembly(leadingWhitespace);
						assembly += byteCopier(whitespace, arg.getType().getSize(), paramSlot.getFullName(), 
							arg.getByteSource(paramSlot.getFullName(), arg.getType().getSize()));
					}
						
				else throw new TypeMismatchException(arg.getType(), paramSlot.getType());
			}
		
		if (resolveFunction(function).equals(getFunction())) // Recursive!
		{
			
		}
		assembly += whitespace + "JSL\t" + resolveFunction(function).getFullName() + "\n";
		
		return assembly;
		
	}


}
