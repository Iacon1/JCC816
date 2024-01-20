// Created by Iacon1 on 10/20/2023.
//
package Compiler.CompilerNodes.Expressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import Compiler.CompConfig;
import Compiler.CompilerNodes.ComponentNode;
import Compiler.CompilerNodes.FunctionDefinitionNode;
import Compiler.CompilerNodes.Definitions.PointerType;
import Compiler.CompilerNodes.Definitions.FunctionType;
import Compiler.CompilerNodes.Definitions.Type;
import Compiler.CompilerNodes.LValues.IndirectLValueNode;
import Compiler.CompilerNodes.LValues.LValueNode;
import Compiler.CompilerNodes.LValues.VariableNode;
import Compiler.Exceptions.UnsupportedFeatureException;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.ConstantSource;
import Compiler.Utils.OperandSources.OperandSource;
import Compiler.Utils.ScratchManager.ScratchSource;
import Grammar.C99.C99Parser.Assignment_expressionContext;
import Grammar.C99.C99Parser.Postfix_expressionContext;

public class PostfixExpressionNode extends BaseExpressionNode<Postfix_expressionContext>
{
	private enum PFType
	{
		incr, decr,
		arraySubscript,
		funcCall,
		structMember,
		structMemberP,
	}
	private PFType type;
	
	private BaseExpressionNode<?> expr, indexExpr;

	private List<BaseExpressionNode<?>> params;
	
	private OperandSource destSource;
	
	private LValueNode<?> pointerRef; // For arrays and pointers to structs
	String memberName;
	
	private FunctionDefinitionNode getReferencedFunction()
	{
		if (expr.getPropValue() != null)
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
		
	}

	@Override
	public BaseExpressionNode<Postfix_expressionContext> interpret(Postfix_expressionContext node) throws Exception
	{
		if (node.primary_expression() != null)
			return (BaseExpressionNode) new PrimaryExpressionNode(this).interpret(node.primary_expression());
		
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
			pointerRef = new IndirectLValueNode(this, expr.getLValue(), null, null); // For const prop purposes
			break;
		case "++":
			type = PFType.incr;
		case "--":
			type = PFType.decr;
		}
		return this;
	}
	
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
		default:
			return null;
		}
	}

	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return expr.canCall(function);
	}
	
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
	@Override
	public LValueNode<?> getLValue() // Warning: Only returns meaningful result after getAssembly
	{
		switch (type)
		{
		case arraySubscript:
			return new IndirectLValueNode(this, destSource, getType());
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
		case arraySubscript: case funcCall: return true;
		case structMember: return expr.hasAssembly();
		case structMemberP: return true;
		case incr: case decr: return true;
		default: return false; // TODO
		}
	}
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		String assembly = "";
		switch (type)
		{
		case arraySubscript:
			this.destSource = destSource; // Initialize LValue
			OperandSource sourceA = expr.getLValue().getSource().respec(CompConfig.pointerSize);
			// An array normal has a size representing its memory footprint, we just need the size of the actual address here
			ScratchSource sourceI = scratchManager.reserveScratchBlock(CompConfig.pointerSize);
			OperandSource sourceS = new ConstantSource(indexExpr.getType().getSize(), CompConfig.pointerSize);
			if (indexExpr.hasAssembly()) assembly += indexExpr.getAssembly(leadingWhitespace, sourceI, scratchManager, ticket);
			assembly += new MultiplicativeExpressionNode(null).getAssembly(whitespace, sourceI, sourceI, sourceS, ticket); // Multiply by size of type
			assembly += AdditiveExpressionNode.getAdder(whitespace, destSource, sourceA, sourceI, ticket);
			scratchManager.releaseScratchBlock(sourceI);
			break;
		case funcCall:
			if (expr.hasAssembly()) assembly += expr.getAssembly(leadingWhitespace, scratchManager, ticket);
			
			if (getReferencedFunction() != null && !getReferencedFunction().canCall(getEnclosingFunction())) // We can know the variables to copy parameters to
			{
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
						else if (params.get(i).hasLValue()) sourceP = params.get(i).getLValue().getSource();
						assembly += AssemblyUtils.byteCopier(whitespace, sourceV.getSize(), sourceV, sourceP);
					}
				}
				assembly += whitespace + "JSL\t" + func.getStartLabel() + "\n";
				
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
				List<VariableNode> variables = new LinkedList<VariableNode>(getEnclosingFunction().getChildVariables().values()); // Prepare for possible recursion
				for (VariableNode parameter : variables)
					assembly += AssemblyUtils.stackLoader(whitespace, leadingWhitespace, parameter.getSource());

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

				if (expr.hasPropValue()) assembly += new ConstantSource(expr.getPropValue(), CompConfig.pointerSize).getInstruction("JSL", 0, ticket);
				else if (expr.hasLValue()) assembly += expr.getLValue().getSource().getInstruction(whitespace, "JSL", 0, ticket);
				
				Collections.reverse(variables);
				for (VariableNode parameter : variables)
					assembly += AssemblyUtils.stackLoader(whitespace, leadingWhitespace, parameter.getSource());
			}
			
			if (destSource != null) assembly += AssemblyUtils.byteCopier(whitespace, destSource.getSize(), destSource, CompConfig.callResultSource(destSource.getSize()));
			break;
		case structMember:
			if (expr.hasAssembly()) assembly += expr.getAssembly(leadingWhitespace, scratchManager, ticket);
			break;
		case structMemberP:
			ScratchSource sourceP;
			if (!ScratchManager.hasPointer(expr.getLValue().getSource()))
			{
				sourceP = scratchManager.reservePointer(expr.getLValue().getSource());
				assembly += AssemblyUtils.byteCopier(whitespace, CompConfig.pointerSize, sourceP, expr.getLValue().getSource());
			}
			else sourceP = scratchManager.getPointer(expr.getLValue().getSource());
			pointerRef = new IndirectLValueNode(this, expr.getLValue(), sourceP, ((PointerType) expr.getType()).getType());
			break;
		default:
			break;
		}
		
		ScratchManager.demotePointer(destSource); // A copy of the destination, if it's a pointer, has gone stale
		return assembly;
	}
	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		if (type == PFType.incr || type == PFType.decr)
			return getAssembly(leadingWhitespace, expr.getLValue().getSource(), new ScratchManager(), new DetailsTicket());
		else return super.getAssembly(leadingWhitespace);
	}
}
