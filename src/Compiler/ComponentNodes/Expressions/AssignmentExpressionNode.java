// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.FunctionDefinitionNode;
import Compiler.ComponentNodes.LVals.VariableNode;
import Compiler.Exceptions.ConstraintException;
import Compiler.Exceptions.TypeMismatchException;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompUtils;
import Compiler.Utils.OperandSource;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.ScratchManager.ScratchSource;
import Grammar.C99.C99Parser.Assignment_expressionContext;
import Grammar.C99.C99Parser.Conditional_expressionContext;
import Grammar.C99.C99Parser.Unary_expressionContext;

// TODO conditional expression
public class AssignmentExpressionNode extends BinaryExpressionNode
<Unary_expressionContext, Assignment_expressionContext, Conditional_expressionContext, Assignment_expressionContext>
{
	@Override
	protected BaseExpressionNode<Unary_expressionContext> getC1Node(Assignment_expressionContext node) throws Exception
	{return new UnaryExpressionNode(this).interpret(node.unary_expression());}
	@Override
	protected BaseExpressionNode<Assignment_expressionContext> getC2Node(Assignment_expressionContext node) throws Exception
	{return new AssignmentExpressionNode(this).interpret(node.assignment_expression());}
	@Override
	protected BaseExpressionNode<Conditional_expressionContext> getPCNode(Assignment_expressionContext node) throws Exception
	{return new ConditionalExpressionNode(this).interpret(node.conditional_expression());}
	
	public AssignmentExpressionNode(ComponentNode<?> parent) {super(parent);}
	
	@Override
	public BaseExpressionNode<Assignment_expressionContext> interpret(Assignment_expressionContext node) throws Exception
	{
		BaseExpressionNode sInt = super.interpret(node);
		if (sInt != this) return sInt;
		
		if (x.getLVal() == null) throw new ConstraintException("6.5.16", 2, node.getStart());
		BinaryExpressionNode<?,?,?,?> newY = null;
		switch (operator)
		{
		case "*=":
			newY = new MultiplicativeExpressionNode(this);
			newY.x = x;
			newY.operator = "*";
			newY.y = y;
			break;
		case "/=":
			newY = new MultiplicativeExpressionNode(this);
			newY.x = x;
			newY.operator = "/";
			newY.y = y;
			break;
		case "%=":
			newY = new MultiplicativeExpressionNode(this);
			newY.x = x;
			newY.operator = "%";
			newY.y = y;
			break;
		case "+=":
			newY = new AdditiveExpressionNode(this);
			newY.x = x;
			newY.operator = "+";
			newY.y = y;
			break;
		case "-=":
			newY = new AdditiveExpressionNode(this);
			newY.x = x;
			newY.operator = "-";
			newY.y = y;
			break;
		case "<<=":
			newY = new ShiftExpressionNode(this);
			newY.x = x;
			newY.operator = "<<";
			newY.y = y;
			break;
		case ">>=":
			newY = new ShiftExpressionNode(this);
			newY.x = x;
			newY.operator = ">>";
			newY.y = y;
			break;
		case "&=":
			newY = new AndExpressionNode(this);
			newY.x = x;
			newY.operator = "&";
			newY.y = y;
			break;
		case "^=":
			newY = new XOrExpressionNode(this);
			newY.x = x;
			newY.operator = "^";
			newY.y = y;
			break;
		case "|=":
			newY = new OrExpressionNode(this);
			newY.x = x;
			newY.operator = "|";
			newY.y = y;
			break;
		}
		newY.interpret(null);
		y = newY;
		
		return this;
	}
	
	@Override
	public Object getPropValue() {return null;} // Should never happen
	
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		final OperandSource sourceY;
		String assembly = "";
		
		if (y.hasAssembly())
		{
			assembly += y.getAssembly(leadingWhitespace, destSource, scratchManager);
			sourceY = destSource;
		}
		else if (y.hasPropValue())
			sourceY = AssemblyUtils.constantSource(y.getPropValue(), y.getType().getSize());
		else
			sourceY = y.getLVal().getSource();
		
		if (!destSource.equals(x.getLVal().getSource()))
			assembly += AssemblyUtils.byteCopier(whitespace, x.getLVal().getSize(), x.getLVal().getSource(), sourceY);
		
		return assembly;
	}
	@Override
	protected String getAssembly(int leadingWhitespace, ScratchManager scratchManager) throws Exception
	{
		return getAssembly(leadingWhitespace, x.getLVal().getSource(), scratchManager);
	}
	
	
}
