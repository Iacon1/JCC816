// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.LValues.LValueNode;
import Compiler.ComponentNodes.LValues.VariableNode;
import Compiler.Exceptions.ConstraintException;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.ConstantSource;
import Compiler.Utils.OperandSources.OperandSource;
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
		
		if (x.getLValue() == null) throw new ConstraintException("6.5.16", 2, node.getStart());
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
		case "=": return this;
		}
		newY.interpret(null);
		y = newY;
		
		return this;
	}
	
	@Override
	public Object getPropValue() {return null;} // Should never happen
	
	public static void equateLValue(LValueNode<?> x, BaseExpressionNode<?> y) // Binds tracking data from y to x for optimization purposes
	{
		if (y.hasPropValue())
			x.setOnlyPossibleValue(y.getPropValue());
		else if (y.hasLValue() && y.getLValue().hasPossibleValues())
		{
			x.setPossibleValues(y.getLValue().getPossibleValues());
			x.setOnlyInfluence(y.getLValue());
		}
		else x.setInfluences(y.influences());
	}
	
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY, DetailsTicket ticket) throws Exception
	{throw new UnsupportedOperationException();} // This is never directly called.
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		final OperandSource sourceY;
		String assembly = "";
		
		if (y.hasAssembly())
		{
			assembly += y.getAssembly(leadingWhitespace, destSource, scratchManager, ticket);
			if (!y.hasLValue()) sourceY = destSource;
			else sourceY = y.getLValue().getSource();
		}
		else
		{
			if (y.hasPropValue())
				sourceY = new ConstantSource(y.getPropValue(), y.getType().getSize());
			else if (y.hasLValue())
				sourceY = y.getLValue().getSource();
			else sourceY = null;
		}
		if (x.hasAssembly()) assembly += x.getAssembly(leadingWhitespace, scratchManager, ticket);
		
		if (!y.hasAssembly() || !destSource.equals(x.getLValue().getSource()))
			assembly += AssemblyUtils.byteCopier(whitespace, x.getLValue().getSize(), x.getLValue().getSource(), sourceY, ticket);
		
		equateLValue(x.getLValue(), y);
		
		ScratchManager.demotePointer(destSource); // A copy of the destination, if it's a pointer, has gone stale
		return assembly;
	}
	@Override
	protected String getAssembly(int leadingWhitespace, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		return getAssembly(leadingWhitespace, x.getLValue().getSource(), scratchManager, ticket);
	}
	
	
}
