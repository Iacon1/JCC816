// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Declarations.TypeNameNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyType;
import C99Compiler.CompilerNodes.LValues.IndirectLValueNode;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.CompilerNodes.Definitions.PointerType;
import C99Compiler.Exceptions.ConstraintException;
import C99Compiler.PreprocNodes.PreProcComponentNode;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.PropPointer;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.Utils.ScratchManager.ScratchSource;
import C99Compiler.Utils.OperandSources.AddressSource;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Unary_expressionContext;
import C99Compiler.CompilerNodes.Dummies.DummyLValueNode;

public class UnaryExpressionNode extends BaseExpressionNode<Unary_expressionContext>
{
	private BaseExpressionNode<?> expr;
	private Type type;
	private String operator;
	private String identifier, embName; // Only useful in preproc mode
	private IndirectLValueNode pointerRef; // LValue if this is a pointer reference (*x)
	
	public UnaryExpressionNode(ComponentNode<?> parent) {super(parent); pointerRef = null;}
	
	public UnaryExpressionNode(ComponentNode<?> parent, String operator, BaseExpressionNode<?> expr)
	{
		super(parent);
		this.operator = operator;
		this.expr = expr;
		pointerRef = null;
	}

	@Override
	public BaseExpressionNode<Unary_expressionContext> interpret(Unary_expressionContext node) throws Exception
	{
		if (node.postfix_expression() != null) // Propagate
			return (BaseExpressionNode) new PostfixExpressionNode(this).interpret(node.postfix_expression());
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
			
			if ((operator.equals("++") || operator.equals("--")) && !expr.hasLValue())
				throw new ConstraintException("6.5.3.1", 1, node.start);
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
	public boolean hasLValue()
	{
		if (operator.equals("*")) return true;
		else if (operator.equals("&"))
		{
			if (UnaryExpressionNode.class.isAssignableFrom(expr.getClass()) && ((UnaryExpressionNode) expr).operator.equals("*"))
				return ((UnaryExpressionNode) expr).expr.hasLValue();
			else return false;
		}
		else return expr.hasLValue();
	}

	@Override
	public LValueNode<?> getLValue()
	{
		if (operator.equals("*"))
		{
			if (UnaryExpressionNode.class.isAssignableFrom(expr.getClass()) && ((UnaryExpressionNode) expr).operator.equals("&"))
				return ((UnaryExpressionNode) expr).expr.getLValue(); // These two cancel each other out
			else return pointerRef;
		}
		else if (operator.equals("&"))
		{
			if (UnaryExpressionNode.class.isAssignableFrom(expr.getClass()) && ((UnaryExpressionNode) expr).operator.equals("*"))
				return ((UnaryExpressionNode) expr).expr.getLValue(); // These two cancel each other out
			else return null;
		}
		else return expr.getLValue();
	}

	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return expr.canCall(function);
	}
	@Override
	public boolean hasPropValue()
	{
		if (operator.equals("sizeof") || operator.equals("defined") || operator.equals("__has_embed") || operator.equals("__offset_of")) return true;
		else if (operator.equals("*"))
			if (pointerRef != null && pointerRef.hasPossibleValues() && pointerRef.getPossibleValues().size() == 1)
			{
				// if expr can only point to one thing...
				if (VariableNode.class.isAssignableFrom(((PropPointer<?>) pointerRef.getPossibleValues().toArray()[0]).getNode().getClass()))
				{
					VariableNode n = ((PropPointer<VariableNode>) pointerRef.getPossibleValues().toArray()[0]).getNode();
					if (n.hasPossibleValues() && n.getPossibleValues().size() == 1)
						return true;
					else return false;
				}
				else return false;
			}
			else return false;
		else if (operator.equals("&"))
		{
			return expr.hasPropValue() || (expr.hasLValue() && VariableNode.class.isAssignableFrom(expr.getLValue().getClass()));
		}
		else return expr.hasPropValue();
	}
	@Override
	public Object getPropValue()
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
		else if (operator.equals("-")) return Long.valueOf(-1 * expr.getPropLong());
		else if (operator.equals("~")) return Long.valueOf(~expr.getPropLong());
		else if (operator.equals("!")) return Boolean.valueOf(expr.getPropBool());
		else if (operator.equals("*"))
			if (pointerRef != null && pointerRef.hasPossibleValues() && pointerRef.getPossibleValues().size() == 1)
			{
				// if expr can only point to one thing...
				if (VariableNode.class.isAssignableFrom(((PropPointer<?>) pointerRef.getPossibleValues().toArray()[0]).getNode().getClass()))
				{
					VariableNode node = ((PropPointer<VariableNode>) pointerRef.getPossibleValues().toArray()[0]).getNode();
					if (node.hasPossibleValues() && node.getPossibleValues().size() == 1)
					{
						// And that thing can only have one value...
						return node.getPossibleValues().toArray()[0]; // Then return that
					}
					else return null;
				}
				else if (FunctionDefinitionNode.class.isAssignableFrom(((PropPointer<?>) pointerRef.getPossibleValues().toArray()[0]).getNode().getClass()))
				{
					FunctionDefinitionNode node = ((PropPointer<FunctionDefinitionNode>) pointerRef.getPossibleValues().toArray()[0]).getNode();
					return node;
				}
				
				else return null;
			}
			else return null;
		else if (operator.equals("&"))
		{
			if (expr.hasLValue() && VariableNode.class.isAssignableFrom(expr.getLValue().getClass()))
			{
				VariableNode var = (VariableNode) expr.getLValue();
				return new PropPointer<VariableNode>(var, 0);
			}
			else if (FunctionDefinitionNode.class.isAssignableFrom(expr.getPropValue().getClass())) // A function pointer
			{
				FunctionDefinitionNode func = (FunctionDefinitionNode) expr.getPropValue();
				func.requireStackLoader();
				return new PropPointer<FunctionDefinitionNode>(func, 0);
			}
			else
				return expr.getPropLong();
		}
		else return expr.getPropValue();
	}
	
	@Override
	public boolean hasAssembly()
	{
		if (operator.equals("*")) return true;
		else if (operator.equals("&")) return false;
		else if (!operator.equals("++") && !operator.equals("--"))
			return (expr == null ? false : expr.hasAssembly()) || !hasPropValue();
		else return true;
	}
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
		OperandSource sourceX;
		ScratchSource scratchX;
		if (expr.hasAssembly())
		{
			scratchX = scratchManager.reserveScratchBlock(expr.getSize());
			assembly += expr.getAssembly(leadingWhitespace, scratchX, scratchManager, ticket);
			if (expr.hasLValue())
				sourceX = expr.getLValue().getSource();
			else sourceX = scratchX;
		}
		else if (expr.hasPropValue())
			sourceX = new ConstantSource(expr.getPropValue(), expr.getType().getSize());
		else if (expr.hasLValue())
			sourceX = expr.getLValue().getSource();
		else sourceX = null;
		
		switch (operator)
		{
		case "++":
			assembly += AdditiveExpressionNode.getIncrementer(whitespace, sourceX, sourceX, ticket);
			if (destSource != null && !destSource.equals(sourceX))
				assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), destSource, sourceX);
			break;
		case "--":
			assembly += AdditiveExpressionNode.getDecrementer(whitespace, sourceX, ticket);
			if (destSource != null && !destSource.equals(sourceX))
				assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), destSource, sourceX);
			break;
		case "-": // -x = ~(x-1)
			if (destSource != null)
			{
				assembly += AdditiveExpressionNode.getSubtractor(whitespace, destSource, sourceX, new ConstantSource(1, sourceX.getSize()), ticket);
				sourceX = destSource;
			}
		case "~":
			if (destSource != null)
			{
				assembly += XOrExpressionNode.getComplementer(whitespace, destSource, sourceX, ticket);
				break;
			}
		case "!":
			if (destSource != null)
			{
				assembly += EqualityExpressionNode.getIsZero(whitespace, destSource, scratchManager, sourceX, ticket);
				break;
			}
		case "*":
			ScratchSource sourceI;
			if (!ScratchManager.hasPointer(sourceX))
			{
				sourceI = ScratchManager.reservePointer(sourceX);
				assembly += AssemblyUtils.byteCopier(whitespace, CompConfig.pointerSize, sourceI, sourceX, ticket);
			}
			else sourceI = ScratchManager.getPointer(sourceX);
		
			pointerRef = new IndirectLValueNode(this, expr.getLValue(), sourceI, ((PointerType) expr.getType()).getType());
			if (destSource != null)
				assembly += AssemblyUtils.byteCopier(whitespace, ((PointerType) expr.getType()).getType().getSize(), destSource, pointerRef.getSource(), ticket);
			break;
		default: return "";
		}

		ScratchManager.releasePointer(destSource); // A copy of the destination, if it's a pointer, has gone stale
		return assembly;
	}
	
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		if (operator.equals("++") || operator.equals("--"))
			return getAssembly(leadingWhitespace, expr.getLValue().getSource(), new ScratchManager(), new DetailsTicket());
		else return super.getAssembly(leadingWhitespace);
	}

	

}
