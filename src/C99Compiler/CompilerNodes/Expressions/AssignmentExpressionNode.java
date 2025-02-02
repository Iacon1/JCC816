// By Iacon1
// Created 05/06/2023
// Assign one variable to another, more or less.
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.Exceptions.ConstraintException;
import C99Compiler.Exceptions.ScratchOverflowException;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.ScratchSource;
import C99Compiler.Utils.AssemblyUtils.ByteCopier;
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
	public Object getPropValue(ProgramState state) {return null;}
	
	@Override
	public boolean hasAssembly(ProgramState state)
	{
		if (x.hasPropValue(state) && y.hasPropValue(state))
		{
			if (x.getPropValue(state).equals(y.getPropValue(state)))
				return false;
		}
		return true;
	}
	
	@Override
	protected AssemblyStatePair getAssemblyAndState(ProgramState state, OperandSource sourceX, OperandSource sourceY) throws Exception {return null;}
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		AssemblyStatePair tmpPair;
		final OperandSource sourceY;
		String assembly = "";
		
		if (x.hasAssembly(state))
		{
			tmpPair = x.getAssemblyAndState(state);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
		}
		
//		if (!y.getType().canCastTo(x.getType()))
//			throw new TypeMismatchException(y.getType(), x.getType());
		if (y.hasAssembly(state) && !x.getType().isTwice())
		{
			sourceY = x.getLValue().getSource();
			state = state.setDestSource(sourceY);
			tmpPair = y.getAssemblyAndState(state);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
		}
		else if (y.hasAssembly(state))
		{
			state = state.reserveScratchBlock(x.getSize());
			ScratchSource scratchX = state.lastScratchSource();
			state = state.setDestSource(x.getLValue().getSource());
			tmpPair = y.getAssemblyAndState(state);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			if (!y.hasLValue()) sourceY = scratchX;
			else sourceY = y.getLValue().castTo(x.getType()).getSource();
			ByteCopier copier = new ByteCopier(x.getLValue().getSize(), x.getLValue().getSource(), sourceY);
			tmpPair = copier.getAssemblyAndState(state);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
		}
		else
		{
			if (y.hasPropValue(state))
				sourceY = new ConstantSource(y.getPropValue(state), x.getType().getSize());
			else if (y.hasLValue())
				sourceY = y.getLValue().castTo(x.getType()).getSource();
			else sourceY = null;
			state = y.getStateAfter(state);
			ByteCopier copier = new ByteCopier(x.getLValue().getSize(), x.getLValue().getSource(), sourceY);
			tmpPair = copier.getAssemblyAndState(state);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
		}
		
		if (y.hasPropValue(state))
			state = state.setPossibleValue(x.getLValue(), y.getPropValue(state));

		return new AssemblyStatePair(assembly, state);
	}
}
