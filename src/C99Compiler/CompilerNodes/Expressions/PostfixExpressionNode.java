// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.PointerType;
import C99Compiler.CompilerNodes.Definitions.FunctionType;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Interfaces.SequencePointNode;
import C99Compiler.CompilerNodes.LValues.IndirectLValueNode;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.Exceptions.ConstraintException;
import C99Compiler.Exceptions.ScratchOverflowException;
import C99Compiler.Exceptions.UnsupportedFeatureException;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.PropPointer;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import C99Compiler.Utils.ScratchManager.ScratchSource;
import Grammar.C99.C99Parser.Assignment_expressionContext;
import Grammar.C99.C99Parser.Postfix_expressionContext;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.Dummies.DummyLValueNode;
import C99Compiler.CompilerNodes.LValues.WrapperLValueNode;
import C99Compiler.CompilerNodes.Definitions.ArrayType;

public class PostfixExpressionNode extends BaseExpressionNode<Postfix_expressionContext> implements SequencePointNode
{
	public static enum PFType
	{
		incr, decr,
		arraySubscript,
		funcCall,
		structMember,
		structMemberP,
	}
	private PFType type;
	
	private BaseExpressionNode<?> expr, indexExpr;
	private List<String> sequenceQueue;
	
	private List<BaseExpressionNode<?>> params;
	
	private OperandSource destSource;
	
	private IndirectLValueNode pointerRef; // For arrays and pointers to structs
	String memberName;
	
	private FunctionDefinitionNode getReferencedFunction()
	{
		if (expr.hasPropValue())
		{
			Object obj = expr.getPropValue();
			if (FunctionDefinitionNode.class.equals(obj.getClass())) // Object is a function so this was a function reference or function pointer
				return (FunctionDefinitionNode) obj;
		} // Really hacky way to get the full name of the function
		return null;
	}
	public PostfixExpressionNode(ComponentNode<?> parent)
	{
		super(parent);
		params = new ArrayList<BaseExpressionNode<?>>();
		sequenceQueue = new LinkedList<String>();
		pointerRef = null;
	}

	@Override
	public BaseExpressionNode<Postfix_expressionContext> interpret(Postfix_expressionContext node) throws Exception
	{
		if (node.primary_expression() != null)
			return delegate(new PrimaryExpressionNode(parent).interpret(node.primary_expression()));
		expr = new PostfixExpressionNode(this).interpret(node.postfix_expression());
		switch (node.getChild(1).getText())
		{
		case "[": // Array subscript
			type = PFType.arraySubscript;
			indexExpr = new ExpressionNode(this).interpret(node.expression());
			break;
		case "(": // Function call
			type = PFType.funcCall;
			if (node.argument_expression_list() != null)
				for (Assignment_expressionContext expr : node.argument_expression_list().assignment_expression())
					params.add(new AssignmentExpressionNode(this).interpret(expr));
			if (params.size() != getReferencedFunction().getParameters().size())
				throw new ConstraintException("6.5.2.2", 2, node.start);
			if (getReferencedFunction() != null && getReferencedFunction().isSA1() && !getEnclosingFunction().isSA1())
				throw new UnsupportedFeatureException("Calling an SA1 function outside an SA1 context", true, node.start);
			else if (getReferencedFunction() != null && !getReferencedFunction().isSA1() && getEnclosingFunction().isSA1())
				throw new UnsupportedFeatureException("Calling a non-SA1 function inside an SA1 context", true, node.start);
			break;
		case ".":
			type = PFType.structMember;
			memberName = node.Identifier().getText();
			break;
		case "->": // Struct member
			type = PFType.structMemberP;
			memberName = node.Identifier().getText();
			break;
		case "++":
			type = PFType.incr;
		case "--":
			type = PFType.decr;
		}
		return this;
	}
	
	@Override public boolean isSequencePoint() {return type == PFType.funcCall;}
	@Override public void registerSequence(String assembly) {sequenceQueue.add(assembly);}
	@Override public void clearSequence() {sequenceQueue.clear();}
	@Override public String getAccumulatedSequences() {String assembly = ""; for (String queued : sequenceQueue) assembly += queued; return assembly;}
	
	@Override
	public Type getType()
	{
		switch (type)
		{
		case arraySubscript:
			return ((PointerType) expr.getType()).getType();
		case funcCall:
			return ((FunctionType) expr.getType()).getType();
		case structMember:
			return getTranslationUnit().resolveStructOrUnion(expr.getType().getSUEName()).getMember(memberName).getType();
		case structMemberP:
			return getTranslationUnit().resolveStructOrUnion(((PointerType) expr.getType()).getType().getSUEName()).getMember(memberName).getType();	
		case incr: case decr:
			return expr.getType();
		default:
			return null;
		}
	}

	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		if (type == PFType.funcCall)
		{
			if (getReferencedFunction() != null)
				return getReferencedFunction().getFullName().equals(function.getFullName());
			else return true;
		}
		else return expr.canCall(function);
	}
	@Override public boolean isIndirect() {return type == PFType.arraySubscript;}
	@Override
	public boolean hasPropValue()
	{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object getPropValue()
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override public boolean hasLValue()
	{
		switch (type)
		{
		case arraySubscript:
		case structMember:
		case structMemberP:
			return true;
		default:
			return false;
		}
	}
	@Override
	public LValueNode<?> getLValue() // Warning: Only returns meaningful result after getAssembly
	{
		switch (type)
		{
		case arraySubscript:
			if (indexExpr.hasPropValue() && expr.getType().isArray())
			{
				int offset = getType().getSize() * (int) indexExpr.getPropLong();
				return new WrapperLValueNode(this, ((ArrayType) expr.getType()).getType(), expr.getLValue(), offset);
			}
			return pointerRef;
		case structMember:
			return getTranslationUnit().resolveStructOrUnion(expr.getType().getSUEName()).getMember(memberName).getInstance(expr.getLValue());
		case structMemberP:
			return getTranslationUnit().resolveStructOrUnion(((PointerType) expr.getType()).getType().getSUEName()).getMember(memberName).getInstance(pointerRef);	
		default:
			return null;
		}
	}
	@Override
	public boolean hasAssembly()
	{
		switch (type)
		{
		case arraySubscript:
			return expr.hasAssembly() || indexExpr.hasAssembly() || expr.getLValue() == null || !expr.getType().isArray() || !indexExpr.hasPropValue();
		 case funcCall: return true;
		case structMember: return expr.hasAssembly();
		case structMemberP: return true;
		case incr: case decr: return true;
		default: return false; // TODO
		}
	}
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		clearSequence();
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
		switch (type)
		{
		case arraySubscript:
			if (destSource != null) this.destSource = destSource; // Initialize LValue
			
			OperandSource addrSource = null;
			if (expr.hasAssembly())
			{
				addrSource = scratchManager.reserveScratchBlock(CompConfig.pointerSize);
				assembly += expr.getAssembly(leadingWhitespace, addrSource, scratchManager, ticket);
			}
			else if (expr.getType().isArray() && !expr.hasAssembly())
				addrSource = new ConstantSource(new PropPointer<>(expr.getLValue(), 0), CompConfig.pointerSize);
			else if (expr.getType().isPointer())
				addrSource = expr.getLValue().getSource();
			
			if (expr.hasLValue())
			{
				if (indexExpr.hasPropValue() && expr.getType().isArray())
				{
					if (indexExpr.hasAssembly()) assembly += indexExpr.getAssembly(leadingWhitespace, scratchManager, ticket);
					int offset = getType().getSize() * (int) indexExpr.getPropLong();
					if (destSource != null)
						assembly += AssemblyUtils.byteCopier(whitespace, destSource.getSize(),
								destSource,
								addrSource.getShifted(offset));
				}
				else
				{
					ScratchSource sourceI;
					if (indexExpr.hasLValue() || !ScratchManager.hasPointer(expr.getLValue().getSource())) // Already had a pointer to this value
					{
						try
						{
							sourceI = ScratchManager.reservePointer(expr.getLValue().getSource());
						}
						catch (ScratchOverflowException e)
						{
							ScratchManager.popPointer();
							sourceI = ScratchManager.reservePointer(expr.getLValue().getSource());
						}
						if (getType().getSize() != 1)
						{
							DummyExpressionNode dM = new DummyExpressionNode(this, getType().getSize());
							assembly += new MultiplicativeExpressionNode(this, "*", indexExpr, dM).getAssembly(whitespace.length(), sourceI, ticket); // Multiply index by size of type
							DummyExpressionNode dX = new DummyExpressionNode(this, CompUtils.getPointerType(), addrSource);
							assembly += new AdditiveExpressionNode(this, "+", dX, indexExpr).getAssembly(leadingWhitespace, sourceI, ticket); // set pointer to pointer plus address
						}
						else if (indexExpr.hasAssembly())
						{
							assembly += indexExpr.getAssembly(leadingWhitespace, sourceI, scratchManager, ticket);
							DummyExpressionNode dX = new DummyExpressionNode(this, CompUtils.getPointerType(), addrSource);
							assembly += new AdditiveExpressionNode(this, "+", indexExpr, dX).getAssembly(leadingWhitespace, sourceI, ticket); // set pointer to pointer plus address
						}
						else
						{
							OperandSource indexSource = null;
							if (indexExpr.hasPropValue())
								indexSource = new ConstantSource(indexExpr.getPropValue(), CompConfig.pointerSize);
							else if (indexExpr.hasLValue())
								indexSource = indexExpr.getLValue().getSource().respec(Math.min(indexExpr.getSize(), CompConfig.pointerSize));
							DummyExpressionNode dX = new DummyExpressionNode(this, CompUtils.getPointerType(), addrSource);
							assembly += new AdditiveExpressionNode(this, "+", indexExpr, dX).getAssembly(leadingWhitespace, sourceI, ticket); // set pointer to pointer plus address
						}
					}
					else
						sourceI = ScratchManager.getPointer(expr.getLValue().getSource());
					
					Type type = ((PointerType) expr.getType()).getType();
					pointerRef = new IndirectLValueNode(this, new DummyLValueNode(this, type, sourceI), sourceI, type);
					if (destSource != null)
					{
						if (getType().isPointer())
							assembly += AssemblyUtils.byteCopier(whitespace, sourceI.getSize(), destSource, sourceI);
						else
							assembly += AssemblyUtils.byteCopier(whitespace, destSource.getSize(), destSource, pointerRef.getSource());
					}
				}
			}
			break;
		case funcCall:
			if (getReferencedFunction() != null && !getReferencedFunction().canCall(getEnclosingFunction())) // We can know the variables to copy parameters to
			{
				if (expr.hasAssembly()) expr.getAssembly(leadingWhitespace, scratchManager, ticket);
				FunctionDefinitionNode func = getReferencedFunction();
				
				if (func.canCall(getEnclosingFunction())) // Prepare for possible recursion
				{
					List<VariableNode> variables = new LinkedList<VariableNode>(getEnclosingFunction().getChildVariables().values());
					for (VariableNode parameter : variables)
						assembly += AssemblyUtils.stackLoader(whitespace, leadingWhitespace, parameter.getSource());
				}
				
				List<VariableNode> funcParams = new LinkedList<VariableNode>(func.getParameters().values());
				for (int i = 0; i < params.size(); ++i)
				{
					OperandSource sourceV = funcParams.get(i).getSource();
					if (params.get(i).hasAssembly()) assembly += params.get(i).getAssembly(leadingWhitespace, sourceV, scratchManager, ticket);
					else
					{
						OperandSource sourceP = null;
						if (params.get(i).hasPropValue()) sourceP = new ConstantSource(params.get(i).getPropValue(), params.get(i).getSize());
						else if (params.get(i).hasLValue()) sourceP = params.get(i).getLValue().castTo(funcParams.get(i).getType()).getSource();
						assembly += AssemblyUtils.byteCopier(whitespace, sourceV.getSize(), sourceV, sourceP);
						
						if (func.isInline())
							AssignmentExpressionNode.equateLValue(funcParams.get(i), params.get(i));
					}
				}
				assembly += getAccumulatedSequences();
				if (func.isInline())
				{
					String endLabel = "__inline_end_" + CompUtils.getSafeUUID();
					assembly += func.getCode().getAssembly(leadingWhitespace, endLabel);
					assembly += whitespace + endLabel + ":" + "\n";
				}
				else assembly += whitespace + "JSL\t" + func.getStartLabel() + "\n";
				
				if (func.canCall(getEnclosingFunction())) // Finish possible recursion
				{
					List<VariableNode> variables = new LinkedList<VariableNode>(getEnclosingFunction().getChildVariables().values());
					Collections.reverse(variables);
					for (VariableNode parameter : variables)
						assembly += AssemblyUtils.stackLoader(whitespace, leadingWhitespace, parameter.getSource());
				}
			}
			else // TODO Unpredictable function pointer or recursion, need to use the stack
			{
				// Copy pointer
				if (getReferencedFunction() == null) // Unpredictable function pointer
				{
					BaseExpressionNode<?> addrExpr = new UnaryExpressionNode(this, "&", expr);
					if (addrExpr.hasAssembly()) assembly += addrExpr.getAssembly(leadingWhitespace, CompConfig.funcPointerSource(), scratchManager, ticket);
					else if (addrExpr.hasPropValue())
						assembly += AssemblyUtils.byteCopier(whitespace, CompConfig.pointerSize, CompConfig.funcPointerSource(), new ConstantSource(addrExpr.getPropValue(), CompConfig.pointerSize));
					else if (addrExpr.hasLValue())
						assembly += AssemblyUtils.byteCopier(whitespace, CompConfig.pointerSize, CompConfig.funcPointerSource(), addrExpr.getLValue().getSource());
					assembly += whitespace + "PHK\n";
					assembly += whitespace + "PEA\t:+\n";
				}
				List<VariableNode> variables = new LinkedList<VariableNode>(getEnclosingFunction().getChildVariables().values()); // Prepare for possible recursion
				for (VariableNode parameter : variables)
					assembly += AssemblyUtils.stackPusher(whitespace, leadingWhitespace, parameter.getSource());

				for (BaseExpressionNode<?> param : params)
				{
					OperandSource sourceP = null;
					ScratchSource sourceV = null;
					if (param.hasPropValue()) sourceP = new ConstantSource(param.getPropValue(), param.getSize());
					else if (param.hasLValue()) sourceP = param.getLValue().getSource();
					if (param.hasAssembly())
					{
						sourceV = scratchManager.reserveScratchBlock(param.getSize());
						assembly += param.getAssembly(leadingWhitespace, sourceV, scratchManager, ticket);
						if (!param.hasLValue()) sourceP = sourceV;
					}
					assembly += AssemblyUtils.stackPusher(whitespace, leadingWhitespace, sourceP);
					if (sourceV != null) scratchManager.releaseScratchBlock(sourceV);
				}
				assembly += getAccumulatedSequences();
				if (getReferencedFunction() == null)
					assembly += whitespace + "JML\t[" + CompConfig.funcPointer + "]\n" + whitespace + ":\n";
				else assembly += whitespace + "JSL\t" + getReferencedFunction().getStartLabel() + "\n";
				
				Collections.reverse(variables);
				for (VariableNode parameter : variables)
					assembly += AssemblyUtils.stackLoader(whitespace, leadingWhitespace, parameter.getSource());
			}
			
			if (destSource != null) assembly += AssemblyUtils.byteCopier(whitespace, destSource.getSize(), destSource, CompConfig.callResultSource(destSource.getSize()));
			break;
		case structMember:
			if (expr.hasAssembly()) assembly += expr.getAssembly(leadingWhitespace, scratchManager, ticket);
			if (destSource != null) assembly += AssemblyUtils.byteCopier(whitespace, destSource.getSize(), destSource, getLValue().getSource());
			break;
		case structMemberP:
			if (expr.hasAssembly()) assembly += expr.getAssembly(leadingWhitespace, scratchManager, ticket);
			ScratchSource sourceP;
			if (!ScratchManager.hasPointer(expr.getLValue().getSource()))
			{
				try
				{
					sourceP = ScratchManager.reservePointer(expr.getLValue().getSource());
				}
				catch (ScratchOverflowException e)
				{
					ScratchManager.popPointer();
					sourceP = ScratchManager.reservePointer(expr.getLValue().getSource());
				}
				assembly += AssemblyUtils.byteCopier(whitespace, CompConfig.pointerSize, sourceP, expr.getLValue().getSource());
			}
			else sourceP = ScratchManager.getPointer(expr.getLValue().getSource());
			pointerRef = new IndirectLValueNode(this, expr.getLValue(), sourceP, ((PointerType) expr.getType()).getType());
			if (destSource != null) assembly += AssemblyUtils.byteCopier(whitespace, destSource.getSize(), destSource, getLValue().getSource());
			break;
		case incr: case decr:
			OperandSource sourceX;
			ScratchSource scratchX = null;
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
			
			if (destSource != null && !destSource.equals(sourceX)) assembly += AssemblyUtils.byteCopier(whitespace, expr.getSize(), destSource, sourceX);
			if (type == PFType.incr)
			{
				DummyExpressionNode dX = new DummyExpressionNode(this, CompUtils.getPointerType(), 1);
				getEnclosingSequencePoint().registerSequence(new AdditiveExpressionNode("+", expr, dX).getAssembly(leadingWhitespace, sourceX, ticket));
			}
			else if (type == PFType.decr)
			{
				DummyExpressionNode dX = new DummyExpressionNode(this, CompUtils.getPointerType(), 1);
				getEnclosingSequencePoint().registerSequence(new AdditiveExpressionNode("-", expr, dX).getAssembly(leadingWhitespace, sourceX, ticket));
			}
			if (scratchX != null) scratchManager.releaseScratchBlock(scratchX);
			break;
		default:
			break;
		}
		
		ScratchManager.releasePointer(destSource); // A copy of the destination, if it's a pointer, has gone stale
		return assembly;
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		if (type == PFType.incr || type == PFType.decr)
			return getAssembly(leadingWhitespace, expr.getLValue().getSource(), new ScratchManager(), new DetailsTicket());
		else return super.getAssembly(leadingWhitespace);
	}
	
	public PFType getPFType() {return type;}
}
