// By Iacon1
// Created 05/06/2023
// Assign one variable to another, more or less.
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.Exceptions.ConstraintException;
import C99Compiler.Exceptions.TypeMismatchException;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Assignment_expressionContext;
import Grammar.C99.C99Parser.Conditional_expressionContext;
import Grammar.C99.C99Parser.Unary_expressionContext;

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
		
		if (!x.hasLValue()) throw new ConstraintException("6.5.16", 2, node.getStart());
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
	
	@Override public CastContext getCastContext() {return CastContext.assignment;}
	@Override public Type getType() {return x.getType();}
	@Override
	public Object getPropValue() {return null;} // Should never happen
	
	public static void equateLValue(LValueNode<?> x, BaseExpressionNode<?> y) // Binds tracking data from y to x for optimization purposes
	{
		if (x.getScope().isRoot()); // Don't do for globals
		else if (y.getEnclosingIteration() != null) // Skip if in a loop
			x.clearPossibleValues();
		else if (y.hasPropValue())
			x.setOnlyPossibleValue(y.getPropValue());
		else if (ConditionalExpressionNode.class.equals(y.getClass()))
		{
			ConditionalExpressionNode condExp = (ConditionalExpressionNode) y;
			if (condExp.x.hasPropValue() && condExp.y.hasPropValue())
			{
				x.setOnlyPossibleValue(condExp.x.getPropValue());
				x.addPossibleValue(condExp.y.getPropValue());
			}
		}
		else if (y.hasLValue() && y.getLValue().hasPossibleValues())
			x.setPossibleValues(y.getLValue().getPossibleValues());
		else // We simply can't know what y might be
			x.clearPossibleValues();
	}
	
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{throw new UnsupportedOperationException();} // This is never directly called.
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		final OperandSource sourceY;
		String assembly = "";
		
		if (x.hasAssembly()) assembly += x.getAssembly(leadingWhitespace, scratchManager, ticket);
		
//		if (!y.getType().canCastTo(x.getType()))
//			throw new TypeMismatchException(y.getType(), x.getType());
		if (y.hasAssembly())
		{
			assembly += y.getAssembly(leadingWhitespace, x.getLValue().getSource(), scratchManager, ticket);
			if (!y.hasLValue()) sourceY = x.getLValue().getSource();
			else sourceY = y.getLValue().castTo(x.getType()).getSource();
		}
		else
		{
			if (y.hasPropValue())
				sourceY = new ConstantSource(y.getPropValue(), y.getType().getSize());
			else if (y.hasLValue())
				sourceY = y.getLValue().castTo(x.getType()).getSource();
			else sourceY = null;
			assembly += AssemblyUtils.byteCopier(whitespace, x.getLValue().getSize(), x.getLValue().getSource(), sourceY, ticket);
		}
		
		if (destSource != null && !destSource.equals(x.getLValue().getSource()))
			assembly += AssemblyUtils.byteCopier(whitespace, x.getLValue().getSize(), destSource, sourceY, ticket);
		
		equateLValue(x.getLValue(), y);
		
		ScratchManager.releasePointer(destSource); // A copy of the destination, if it's a pointer, has gone stale
		return assembly;
	}
	@Override
	protected String getAssembly(int leadingWhitespace, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		return getAssembly(leadingWhitespace, null, scratchManager, ticket);
	}
	
}
