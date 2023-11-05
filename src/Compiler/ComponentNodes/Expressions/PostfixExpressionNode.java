// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import java.util.ArrayList;
import java.util.List;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.Utils.OperandSource;
import Compiler.Utils.ScratchManager;
import Grammar.C99.C99Parser.Assignment_expressionContext;
import Grammar.C99.C99Parser.Postfix_expressionContext;

public class PostfixExpressionNode extends BaseExpressionNode<Postfix_expressionContext>
{
	private enum PFType
	{
		arraySubscript,
		funcCall,
		structMember,
		structMemberP,
	}
	
	private BaseExpressionNode<?> expr;
	private FunctionDefinitionNode func; 
	private List<BaseExpressionNode<?>> params;
	
	public PostfixExpressionNode(ComponentNode<?> parent)
	{
		super(parent);
		params = new ArrayList<BaseExpressionNode<?>>();
		
	}

	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return func.canCall(function);
	}

	@Override
	public BaseExpressionNode<Postfix_expressionContext> interpret(Postfix_expressionContext node) throws Exception
	{
		if (node.primary_expression() != null)
			return (BaseExpressionNode) new PrimaryExpressionNode(this).interpret(node.primary_expression());
		
		expr = new PostfixExpressionNode(this).interpret(node.postfix_expression());
		switch (node.getChild(1).getText())
		{
		case "(": // Function call
			if (node.argument_expression_list() != null)
				for (Assignment_expressionContext expr : node.argument_expression_list().assignment_expression())
					params.add(new AssignmentExpressionNode(this).interpret(expr));
			
		}
		return this;
	}
	
	@Override
	public Type getType()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasPropValue()
	{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object getPropValue() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
}
