// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Declarations.TypeNameNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.Dummies.DummyType;
import C99Compiler.CompilerNodes.LValues.IndirectLValueNode;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.CompilerNodes.Definitions.PointerType;
import C99Compiler.Exceptions.ConstraintException;
import C99Compiler.Exceptions.ScratchOverflowException;
import C99Compiler.PreprocNodes.PreProcComponentNode;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.ScratchSource;
import C99Compiler.Utils.PropPointer;
import C99Compiler.Utils.AssemblyUtils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.ByteCopier;
import C99Compiler.Utils.OperandSources.AddressSource;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.NumericAddressSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Unary_expressionContext;
import C99Compiler.CompilerNodes.Dummies.DummyValueNode;
import C99Compiler.CompilerNodes.Dummies.DummyVariableNode;
import C99Compiler.CompilerNodes.Expressions.PostfixExpressionNode.PFType;
import C99Compiler.CompilerNodes.Interfaces.AddressableNode;

public class UnaryExpressionNode extends BaseExpressionNode<Unary_expressionContext>
{
	private BaseExpressionNode<?> expr;
	private Type type;
	private String operator;
	private String identifier, embName; // Only useful in preproc mode
	IndirectLValueNode indirect;
	
	public UnaryExpressionNode(ComponentNode<?> parent) {super(parent); indirect = null;}
	
	public UnaryExpressionNode(ComponentNode<?> parent, String operator, BaseExpressionNode<?> expr)
	{
		super(parent);
		this.operator = operator;
		this.expr = expr;
		this.indirect = null;
	}

	@Override
	public BaseExpressionNode<Unary_expressionContext> interpret(Unary_expressionContext node) throws Exception
	{
		if (node.postfix_expression() != null) // Propagate
			return delegate(new PostfixExpressionNode(this).interpret(node.postfix_expression()));
		else
		{
			if (node.unary_expression() != null)
				this.expr = new UnaryExpressionNode(this).interpret(node.unary_expression());
			else if (node.cast_expression() != null)
				this.expr = new CastExpressionNode(this).interpret(node.cast_expression());
			else if (node.type_name() != null)
				type = new TypeNameNode(this).interpret(node.type_name()).getType();
			else if (node.Header_name() != null)
				this.embName = node.Header_name().getText();
			else if (node.String_literal() != null)
				this.embName = node.String_literal().getText();
			if (node.Identifier() != null)
				this.identifier = node.Identifier().getText();
			operator = node.getChild(0).getText();
			
			if ((operator.equals("++") || operator.equals("--")) && !expr.hasLValue(new ProgramState()))
				throw new ConstraintException("6.5.3.1", 1, node.start);
			if (operator.equals("&") && PostfixExpressionNode.class.isAssignableFrom(expr.getClass()))
			{
				if (((PostfixExpressionNode) expr).getPFType() == PFType.funcCall || !expr.hasLValue(new ProgramState()))
					throw new ConstraintException("6.5.3.2", 1, node.start);
			}
		}
		return this;
	}

	@Override
	public Type getType()
	{
		if (type != null) return new PointerType(new DummyType("void")); // No object can have a greater size than a pointer
		else if (operator.equals("*"))
		{
			return ((PointerType) expr.getType()).getType(); 
		}
		else if (operator.equals("&"))
		{
			return new PointerType(expr.getType());
		}
		else return expr.getType();
	}
	@Override public boolean isIndirect()
	{
		if (operator.equals("*"))
		{
			if (UnaryExpressionNode.class.isAssignableFrom(expr.getClass()) && ((UnaryExpressionNode) expr).operator.equals("&"))
				return false; // These two cancel each other out
			else return true;
		}
		return false;
	}
	@Override
	public boolean hasLValue(ProgramState state)
	{
		if (operator.equals("*")) return true;
		else if (operator.equals("&"))
		{
			if (UnaryExpressionNode.class.isAssignableFrom(expr.getClass()) && ((UnaryExpressionNode) expr).operator.equals("*"))
				return ((UnaryExpressionNode) expr).expr.hasLValue(state);
			else return false;
		}
		else return expr.hasLValue(state);
	}

	@Override
	public LValueNode<?> getLValue(ProgramState state)
	{
		if (operator.equals("*"))
		{
			if (UnaryExpressionNode.class.isAssignableFrom(expr.getClass()) && ((UnaryExpressionNode) expr).operator.equals("&"))
				return ((UnaryExpressionNode) expr).expr.getLValue(state); // These two cancel each other out
			else if (expr.hasPropValue(new ProgramState()))
			{
				if (expr.getPropPointer(new ProgramState()) != null) // Pointer
					return new DummyVariableNode(this, getType(), new ConstantSource(expr.getPropPointer(new ProgramState()), getSize()));
				else if (expr.getPropLong(new ProgramState()) != 0) // Numeric
					return new DummyVariableNode(this, getType(), new NumericAddressSource((int) expr.getPropLong(new ProgramState()), getSize()));
				else return null;
			}
			else
				return indirect;
				
		}
		else if (operator.equals("&"))
		{
			if (UnaryExpressionNode.class.isAssignableFrom(expr.getClass()) && ((UnaryExpressionNode) expr).operator.equals("*"))
				return ((UnaryExpressionNode) expr).expr.getLValue(state); // These two cancel each other out
			else return null;
		}
		else return expr.getLValue(state);
	}

	@Override
	public boolean canCall(ProgramState state, FunctionDefinitionNode function)
	{
		return expr.canCall(state, function);
	}
	@Override
	public boolean hasPropValue(ProgramState state)
	{
		if (operator.equals("sizeof") || operator.equals("defined") || operator.equals("__has_embed") || operator.equals("__offset_of")) return true;
		else if (operator.equals("*"))
			if (expr.hasPropValue(state)) // if expr can only point to one thing...
			{
				VariableNode n = ((PropPointer<VariableNode>) expr.getPropValue(state)).getNode();
				if (state.getOnlyValue(n) != null)
					return true;
				else return false;
			}
			else return false;
		else if (operator.equals("&"))
		{
			return expr.hasPropValue(state) || (expr.hasLValue(state) && VariableNode.class.isAssignableFrom(expr.getLValue(state).getClass()) && !expr.hasAssembly(state) && !PostfixExpressionNode.class.isAssignableFrom(expr.getClass()));
		}
		else return expr.hasPropValue(state);
	}
	@Override
	public Object getPropValue(ProgramState state)
	{
		if (operator.equals("sizeof"))
		{
			if (type != null) return type.getSize();
			else return expr.getType().getSize();
		}
		else if (operator.equals("defined")) // Only useful in preproc mode
		{
			return PreProcComponentNode.defines.containsKey(identifier) ? Long.valueOf(1) : Long.valueOf(0);
		}
		else if (operator.equals("__has_embed")) // Only useful in preproc mode
		{
			return PreProcComponentNode.embeds.contains(embName) ? Long.valueOf(1) : Long.valueOf(0);
		}
		else if (operator.equals("__offset_of")) // Only useful in preproc mode
		{
			return type.getStruct().getOffset(identifier);
		}
		else if (operator.equals("-")) return Long.valueOf(-1 * expr.getPropLong(state));
		else if (operator.equals("~")) return Long.valueOf(~expr.getPropLong(state));
		else if (operator.equals("!")) return Boolean.valueOf(expr.getPropBool(state));
		else if (operator.equals("*"))
		{
			VariableNode n = ((PropPointer<VariableNode>) state.getOnlyValue(expr.getLValue(state))).getNode();
			return state.getOnlyValue(n);
		}
		else if (operator.equals("&"))
		{
			if (expr.hasLValue(state) && VariableNode.class.isAssignableFrom(expr.getLValue(state).getClass()))
			{
				VariableNode var = (VariableNode) expr.getLValue(state);
				return new PropPointer<VariableNode>(var, 0);
			}
			else if (FunctionDefinitionNode.class.isAssignableFrom(expr.getPropValue(state).getClass())) // A function pointer
			{
				FunctionDefinitionNode func = (FunctionDefinitionNode) expr.getPropValue(state);
				func.requireStackLoader();
				return new PropPointer<FunctionDefinitionNode>(func, 0);
			}
			else
				return expr.getPropLong(state);
		}
		else return expr.getPropValue(state);
	}
	
	@Override
	public boolean hasAssembly(ProgramState state)
	{
		if (operator.equals("*")) return expr.hasAssembly(state) || !expr.hasPropValue(state);
		else if (operator.equals("&"))
			return expr.hasAssembly(state) || PostfixExpressionNode.class.isAssignableFrom(expr.getClass());
		else if (!operator.equals("++") && !operator.equals("--"))
			return (expr == null ? false : expr.hasAssembly(state)) || !hasPropValue(state);
		else return true;
	}

	@Override
	public ProgramState getStateBefore(ProgramState state, ComponentNode<?> child) throws Exception
	{
		if (!children.contains(child))
			throw new IllegalArgumentException();
		
		if (child != expr)
			state = getStateAfter(state);
		return state;
	}
	
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		ProgramState oState = state;
		AdditiveExpressionNode tmpNode;
		AssemblyStatePair tmpPair;
		ByteCopier copier;
		OperandSource destSource = state.destSource();
		String whitespace = state.getWhitespace();
		String assembly = "";
		OperandSource sourceX;
		ScratchSource scratchX;
		if (expr.hasAssembly(state))
		{
			state = state.reserveScratchBlock(expr.getSize());
			scratchX = state.lastScratchSource();
			state = state.setDestSource(scratchX);
			tmpPair = expr.getAssemblyAndState(state);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			
			if (expr.hasLValue(state))
				sourceX = expr.getLValue(state).getSource();
			else sourceX = scratchX;
		}
		else if (expr.hasPropValue(state) && !(operator.equals("++") || operator.equals("--"))) // These two need LValue
			sourceX = new ConstantSource(expr.getPropValue(state), expr.getType().getSize());
		else if (expr.hasLValue(state))
			sourceX = expr.getLValue(state).getSource();
		else sourceX = null;

		
		DummyExpressionNode dX = new DummyExpressionNode(this, expr.getType(), 1);
		switch (operator)
		{
		case "++": case "--":
			tmpNode = new AdditiveExpressionNode(this, (operator.equals("++") ? "+" : "-"), expr, dX);
			if (tmpNode.hasPropValue(state))
			{
				tmpPair = new ByteCopier(sourceX.getSize(), sourceX, new ConstantSource(tmpNode.getPropValue(state), sourceX.getSize())).getAssemblyAndState(state);
				state = state.setPossibleValue(expr.getLValue(state), tmpNode.getPropValue(state));
			}
			else
			{
				state = state.setDestSource(sourceX);
				tmpPair = tmpNode.getAssemblyAndState(state);
				state = state.setDestSource(destSource);
			}
				
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			
			if (destSource != null && !destSource.equals(sourceX))
			{
				if (tmpNode.hasPropValue(state))
					copier = new ByteCopier(sourceX.getSize(), destSource, tmpNode.getPropValue(state));
				else
					copier = new ByteCopier(sourceX.getSize(), destSource, sourceX);
				tmpPair = copier.getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			break;
		case "-": // -x = ~(x-1)
			if (destSource != null)
			{
				dX = new DummyExpressionNode(this, expr.getType(), 0);
				tmpPair = new AdditiveExpressionNode(this, "-", dX, expr).getAssemblyAndState(state);
				sourceX = destSource;
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			break;
		case "~":
			if (destSource != null)
			{
				dX = new DummyExpressionNode(this, expr.getType(), Long.valueOf("FF".repeat(expr.getSize()), 16));
				tmpPair = new XOrExpressionNode(this, expr, dX).getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			break;
		case "!":
			if (destSource != null)
			{
				// TODO
				tmpPair = new EqualityExpressionNode(this, expr).getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			break;
		case "*":
			ScratchSource sourceI;
			if (!state.hasPointer(sourceX))
			{
				state = state.reservePointer(sourceX);
				sourceI = state.lastScratchSource();
				copier = new ByteCopier(CompConfig.pointerSize, sourceI, sourceX);
				tmpPair = copier.getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			else sourceI = state.getPointer(sourceX);
			indirect = new IndirectLValueNode(this, sourceX, getType());
			if (destSource != null)
			{
				copier = new ByteCopier(((PointerType) expr.getType()).getType().getSize(), destSource, indirect.getSource());
				tmpPair = copier.getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			break;
		case "&":
			if (destSource != null)
				if (expr.hasLValue(state))
				{
					PropPointer<LValueNode<?>> p = new PropPointer<LValueNode<?>>(expr.getLValue(state), 0);
					copier = new ByteCopier(CompConfig.pointerSize, destSource, new ConstantSource(p, CompConfig.pointerSize));
					tmpPair = copier.getAssemblyAndState(state);
					assembly += tmpPair.assembly;
					state = tmpPair.state;
				}
			break;
		default: return new AssemblyStatePair("", oState);
		}
		state = state.setDestSource(destSource);
		return new AssemblyStatePair(assembly, state);
	}
}
