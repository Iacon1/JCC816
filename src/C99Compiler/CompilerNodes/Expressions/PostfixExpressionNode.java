// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import java.util.ArrayList;
import java.util.Arrays;
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
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.PreserveFlag;
import C99Compiler.Utils.ProgramState.ProcessorFlag;
import C99Compiler.Utils.ProgramState.ScratchSource;
import C99Compiler.Utils.PropPointer;
import C99Compiler.Utils.AssemblyUtils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.ByteCopier;
import C99Compiler.Utils.AssemblyUtils.SignExtender;
import C99Compiler.Utils.AssemblyUtils.StackLoader;
import C99Compiler.Utils.AssemblyUtils.StackPusher;
import C99Compiler.Utils.OperandSources.AddressSource;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Assignment_expressionContext;
import Grammar.C99.C99Parser.Postfix_expressionContext;
import Shared.Assemblable;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.Dummies.DummyLValueNode;
import C99Compiler.CompilerNodes.LValues.WrapperLValueNode;
import C99Compiler.CompilerNodes.Definitions.ArrayType;

public class PostfixExpressionNode extends SPBaseExpressionNode<Postfix_expressionContext>
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
	private AdditiveExpressionNode pAddExpr;
	private List<BaseExpressionNode<?>> params;
	private OperandSource dummySource;
	
	String memberName;
	
	private FunctionDefinitionNode getReferencedFunction(ProgramState state)
	{
		if (expr.hasPropValue(state))
		{
			Object obj = expr.getPropValue(state);
			if (FunctionDefinitionNode.class.equals(obj.getClass())) // Object is a function so this was a function reference or function pointer
				return (FunctionDefinitionNode) obj;
		} // Really hacky way to get the full name of the function
		return null;
	}
	public PostfixExpressionNode(ComponentNode<?> parent)
	{
		super(parent);
		expr = null;
		params = new ArrayList<BaseExpressionNode<?>>();
		dummySource = new AddressSource(CompUtils.getSafeUUID(), 0);
	}
	// Synthetic function call
	public PostfixExpressionNode(ComponentNode<?> parent, String functionName, BaseExpressionNode<?>... params)
	{
		super(parent);
		this.type = PFType.funcCall;
		this.expr = new PrimaryExpressionNode(this, functionName);
		this.params = Arrays.asList(params);
		dummySource = new AddressSource(CompUtils.getSafeUUID(), 0);
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
			pAddExpr = new AdditiveExpressionNode(this, "+", expr, indexExpr);
			break;
		case "(": // Function call
			type = PFType.funcCall;
			if (node.argument_expression_list() != null)
				for (Assignment_expressionContext expr : node.argument_expression_list().assignment_expression())
					params.add(new AssignmentExpressionNode(this).interpret(expr));
			ProgramState state = new ProgramState();
			if (getReferencedFunction(state) != null)
			{
				if (getReferencedFunction(state).canCall(state, getEnclosingFunction())) // This function will need parameters from the stack
					getReferencedFunction(state).requireStackLoader();
				
				if (params.size() != getReferencedFunction(new ProgramState()).getParameters().size())
					throw new ConstraintException("6.5.2.2", 2, node.start);
				if (getReferencedFunction(new ProgramState()).isSA1() && !getEnclosingFunction().isSA1())
					throw new UnsupportedFeatureException("Calling an SA1 function outside an SA1 context", true, node.start);
				else if (!getReferencedFunction(new ProgramState()).isSA1() && getEnclosingFunction().isSA1())
					throw new UnsupportedFeatureException("Calling a non-SA1 function inside an SA1 context", true, node.start);
			}
			break;
		case ".":
			type = PFType.structMember;
			memberName = node.identifier().getText();
			if (expr.getType().getStruct().getMember(memberName) == null)
				throw new ConstraintException("6.5.2.3", 1, node.start);
			break;
		case "->": // Struct member
			type = PFType.structMemberP;
			memberName = node.identifier().getText();
			if (((PointerType) expr.getType()).getType().getStruct().getMember(memberName) == null)
				throw new ConstraintException("6.5.2", 2, node.start);
			break;
		case "++":
			type = PFType.incr;
			break;
		case "--":
			type = PFType.decr;
			break;
		}
		dummySource.respec(getSize());
		return this;
	}

	@Override
	protected void onSwap(ComponentNode<?> from, ComponentNode<?> to)
	{
		if (expr == from)
			expr = (BaseExpressionNode<?>) to;
		else if (indexExpr == from)
			indexExpr = (BaseExpressionNode<?>) to;
	}
	
	@Override
	public Type getType()
	{
		switch (type)
		{
		case arraySubscript:
			return ((PointerType) expr.getType()).getType();
		case funcCall:
			if (expr.getType().isPointer())
				return ((FunctionType) ((PointerType) expr.getType()).getType()).getType();
			else
				return ((FunctionType) expr.getType()).getType();
		case structMember:
			return expr.getType().getStruct().getMember(memberName).getType();
		case structMemberP:
			return (((PointerType) expr.getType()).getType()).getStruct().getMember(memberName).getType();	
		case incr: case decr:
			return expr.getType();
		default:
			return null;
		}
	}

	@Override
	public boolean canCall(ProgramState state, FunctionDefinitionNode function)
	{
		if (type == PFType.funcCall)
		{
			if (getReferencedFunction(state) != null)
				return getReferencedFunction(state).getFullName().equals(function.getFullName()) || getReferencedFunction(state).canCall(state, function);
			else return true;
		}
		else return expr.canCall(state, function);
	}
	@Override public boolean isIndirect() {return type == PFType.arraySubscript;}
	@Override
	public boolean hasPropValue(ProgramState state)
	{
		if (type == PFType.structMember)
			if (getType().isArray())
				return true; // Arrays can degrade to pointers
		return false;
	}
	@Override
	public Object getPropValue(ProgramState state)
	{
		if (type == PFType.structMember)
			if (getType().isArray())
				return new PropPointer<LValueNode<?>>(getLValue(state), 0);
		return null;
	}
	@Override
	public boolean hasLValue(ProgramState state)
	{
		switch (type)
		{
		case arraySubscript:
			return !getType().isArray();
		case structMember:
		case structMemberP:
			return true;
		default:
			return false;
		}
	}
	@Override
	public LValueNode<?> getLValue(ProgramState state) // Warning: Only returns meaningful result after getAssembly
	{
		OperandSource addrSource;
		switch (type)
		{
		case arraySubscript:
			if (indexExpr.hasPropValue(new ProgramState()) && expr.getType().isArray())
			{
				int offset = getType().getSize() * (int) indexExpr.getPropLong(new ProgramState());
				return new WrapperLValueNode(this, ((ArrayType) expr.getType()).getType(), expr.getLValue(state), offset);
			}
			if (expr.hasLValue(state))
				addrSource = state.getPointer(expr.getLValue(state).getSource());
			else
				addrSource = state.getPointer(dummySource);
			return new IndirectLValueNode(this, new DummyLValueNode(this, getType(), addrSource), addrSource, getType());
		case structMember:
			return expr.getType().getStruct().getMember(memberName).getInstance(expr.getLValue(state));
		case structMemberP:
			addrSource = state.getPointer(expr.getLValue(state).getSource());
			return ((PointerType) expr.getType()).getType().getStruct()
					.getMember(memberName).getInstance(
							new IndirectLValueNode(this, expr.getLValue(state), addrSource, ((PointerType) expr.getType()).getType()));	
		default:
			return null;
		}
	}
	
	private boolean canUseIndexReg()
	{
		return expr.getType().isArray() && CompUtils.getSmallestType(expr.getSize()).getSize() <= 2;
	}
	
	@Override
	public boolean hasAssembly(ProgramState state)
	{
		switch (type)
		{
		case arraySubscript:
			return expr.hasAssembly(state) || indexExpr.hasAssembly(state) || expr.getLValue(state) == null || getType().isArray() || !expr.getType().isArray() || !indexExpr.hasPropValue(state);
		 case funcCall: return true;
		case structMember: return expr.hasAssembly(state);
		case structMemberP: return true;
		case incr: case decr: return true;
		default: return false; // TODO
		}
	}
	
	@Override
	public ProgramState getStateBefore(ProgramState state, ComponentNode<?> child) throws Exception
	{
		if (!children.contains(child))
			throw new IllegalArgumentException();
		
		switch (type)
		{
		case arraySubscript:
			if (child == expr)
				return state;
			if (expr.hasAssembly(state))
				state = expr.getStateAfter(state);
			
			if (child == indexExpr)
				return state;
			if (indexExpr.hasAssembly(state))
				state = indexExpr.getStateAfter(state);
			return state;
		case funcCall:
			if (child == expr)
				return state;
			if (expr.hasAssembly(state))
				state = expr.getStateAfter(state);
			
			for (BaseExpressionNode<?> param : params)
			{
				if (child == param)
					return state;
				if (param.hasAssembly(state))
					state = param.getStateAfter(state);
			}
			return state;
		case structMember: case structMemberP: case incr: case decr:
			if (child == expr)
				return state;
			if (expr.hasAssembly(state))
				state = expr.getStateAfter(state);
			return state;
		}
		return state;
	}
	
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		clearAssemblables();
		OperandSource destSource = state.destSource();
		AssemblyStatePair tmpPair;
		String assembly = "";
		switch (type)
		{
		case arraySubscript:
			if (!getType().isArray()) // return element of an array
			{
				ScratchSource addrSource = null;	
				state = state.reserveScratchBlock(CompConfig.pointerSize);
				addrSource = state.lastScratchSource();
				
				state = state.setDestSource(addrSource);
				tmpPair = pAddExpr.getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
				if (expr.hasLValue(state))
					state = state.markPointer(expr.getLValue(state).getSource(), addrSource);
				else
					state = state.markPointer(dummySource, addrSource);
				state = state.setDestSource(destSource);

				if (destSource != null)
				{
					tmpPair = new ByteCopier(destSource, getLValue(state).getSource()).getAssemblyAndState(state);
					assembly += tmpPair.assembly;
					state = tmpPair.state;
				}
			}
			else // Return head of an array
			{
				state = state.setDestSource(destSource);
				tmpPair = pAddExpr.getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			break;
		case funcCall:
			state = state.releasePointers(); // TODO only need to wipe pointers here
			if (getReferencedFunction(state) != null && !getReferencedFunction(state).canCall(state, getEnclosingFunction())) // We can know the variables to copy parameters to
			{
				if (expr.hasAssembly(state))
				{
					state = state.setDestSource(destSource);
					tmpPair = expr.getAssemblyAndState(state);
					assembly += tmpPair.assembly;
					state = tmpPair.state;
				}
				FunctionDefinitionNode func = getReferencedFunction(state);
				
				if (func.canCall(state, getEnclosingFunction())) // Prepare for possible recursion
				{
					List<VariableNode> variables = new LinkedList<VariableNode>(getEnclosingFunction().getChildVariables().values());
					tmpPair = new AssemblyStatePair("", state);
					for (VariableNode parameter : variables)
					{
						tmpPair = new StackLoader(parameter.getSource().getSize(), parameter.getSource()).apply(tmpPair);
					}
					assembly += tmpPair.assembly;
					state = tmpPair.state;
				}
				
				List<VariableNode> funcParams = new LinkedList<VariableNode>(func.getParameters().values());
				for (int i = 0; i < params.size(); ++i)
				{
					OperandSource sourceV = funcParams.get(i).getSource();
					if (params.get(i).hasAssembly(state))
					{
						state = state.setDestSource(sourceV);
						tmpPair = params.get(i).getAssemblyAndState(state);
						assembly += tmpPair.assembly;
						state = tmpPair.state;
						state = state.setDestSource(destSource);
					}
					else
					{
						OperandSource sourceP = null;
						if (params.get(i).hasPropValue(state) && !params.get(i).getType().isArray()) sourceP = new ConstantSource(params.get(i).getPropValue(state), params.get(i).getSize()); // Arrays aren't typically function parameters
						else if (params.get(i).hasLValue(state)) sourceP = params.get(i).getLValue(state).castTo(funcParams.get(i).getType()).getSource();
						
						tmpPair = new ByteCopier(sourceV, sourceP).getAssemblyAndState(state);
						assembly += tmpPair.assembly;
						state = tmpPair.state;
						
						if (func.isInline() && state.getOnlyValue(params.get(i).getLValue(state)) != null) // TODO
							state = state.setPossibleValue(funcParams.get(i), state.getOnlyValue(params.get(i).getLValue(state)));
					}
				}
				tmpPair = getRegisteredAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
				
				if (func.needsA8() && !(state.testKnownFlag(PreserveFlag.M) && !state.testProcessorFlag(ProcessorFlag.M)))
				{
					assembly += state.getWhitespace() + "SEP\t#$20\n";
					state = state.clearProcessorFlags(ProcessorFlag.M);
				}
				else if (func.needsA16() && !(state.testKnownFlag(PreserveFlag.M) && state.testProcessorFlag(ProcessorFlag.M)))
				{
					assembly += state.getWhitespace() + "REP\t#$20\n";
					state = state.setProcessorFlags(ProcessorFlag.M);
				}
				
				if (func.needsXY8() && !(state.testKnownFlag(PreserveFlag.I) && !state.testProcessorFlag(ProcessorFlag.I)))
				{
					assembly += state.getWhitespace() + "SEP\t#$10\n";
					state = state.clearProcessorFlags(ProcessorFlag.I);
				}
				else if (func.needsXY16() && !(state.testKnownFlag(PreserveFlag.I) && state.testProcessorFlag(ProcessorFlag.I)))
				{
					assembly += state.getWhitespace() + "REP\t#$10\n";
					state = state.setProcessorFlags(ProcessorFlag.I);
				}
				
				if (func.isInline())
				{
					String endLabel = "__inline_end_" + CompUtils.getSafeUUID();
					String e = state.exitFuncLabel();
					state = state.setExitFuncLabel(endLabel);
					tmpPair = func.getCode().getAssemblyAndState(state);
					assembly += tmpPair.assembly;
					state = tmpPair.state;
					assembly += state.getWhitespace() + endLabel + ":" + "\n";
					state = state.setExitFuncLabel(e);
				}
				else
				{
					assembly += state.getWhitespace() + "JSL\t" + func.getStartLabel() + "\n";
					state = state.releasePointers();
					state = state.clearKnownFlags();
				}
				
				if (func.canCall(state, getEnclosingFunction())) // Finish possible recursion
				{
					List<VariableNode> variables = new LinkedList<VariableNode>(getEnclosingFunction().getChildVariables().values());
					Collections.reverse(variables);
					tmpPair = new AssemblyStatePair("", state);
					for (VariableNode parameter : variables)
					{
						tmpPair = new StackLoader(parameter.getSize(), parameter.getSource()).apply(tmpPair);					
					}
					assembly += tmpPair.assembly;
					state = tmpPair.state;
				}
			}
			else // TODO Unpredictable function pointer or recursion, need to use the stack
			{
				// Copy pointer
				if (getReferencedFunction(state) == null) // Unpredictable function pointer
				{
					BaseExpressionNode<?> addrExpr = new UnaryExpressionNode(this, "&", expr);
					if (addrExpr.hasAssembly(state))
					{
						state = state.setDestSource(CompConfig.funcPointerSource());
						tmpPair = addrExpr.getAssemblyAndState(state);
						assembly += tmpPair.assembly;
						state = tmpPair.state.setDestSource(destSource);
					}
					else if (addrExpr.hasPropValue(state))
					{
						tmpPair = new ByteCopier(CompConfig.pointerSize, CompConfig.funcPointerSource(), new ConstantSource(addrExpr.getPropValue(state), CompConfig.pointerSize)).getAssemblyAndState(state);
						assembly += tmpPair.assembly;
						state = tmpPair.state;
					}
					else if (addrExpr.hasLValue(state))
					{
						tmpPair = new ByteCopier(CompConfig.pointerSize, CompConfig.funcPointerSource(), addrExpr.getLValue(state).getSource()).getAssemblyAndState(state);
						assembly += tmpPair.assembly;
						state = tmpPair.state;
					}
					assembly += state.getWhitespace() + "PHK\n";
					assembly += state.getWhitespace() + "PEA\t:+\n";
				}
				List<VariableNode> variables = new LinkedList<VariableNode>(getEnclosingFunction().getChildVariables().values()); // Prepare for possible recursion
				for (VariableNode parameter : variables)
				{
					tmpPair = new StackPusher(parameter.getSize(), parameter.getSource()).getAssemblyAndState(state);
					assembly += tmpPair.assembly;
					state = tmpPair.state;
				}
					
				for (BaseExpressionNode<?> param : params)
				{
					OperandSource sourceP = null;
					ScratchSource sourceV = null;
					if (param.hasPropValue(state)) sourceP = new ConstantSource(param.getPropValue(state), param.getSize());
					else if (param.hasLValue(state)) sourceP = param.getLValue(state).getSource();
					if (param.hasAssembly(state))
					{
						state = state.reserveScratchBlock(param.getSize());
						sourceV = state.lastScratchSource();
						state.setDestSource(sourceV);
						tmpPair = param.getAssemblyAndState(state);
						assembly += tmpPair.assembly;
						state = tmpPair.state.setDestSource(destSource);
						if (!param.hasLValue(state)) sourceP = sourceV;
					}
					tmpPair = new StackPusher(param.getSize(), sourceP).getAssemblyAndState(state);
					assembly += tmpPair.assembly;
					state = tmpPair.state;
					if (sourceV != null) state = state.releaseScratchBlock(sourceV);
				}
				tmpPair = getRegisteredAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
				
				if (getReferencedFunction(state) == null)
					assembly += state.getWhitespace() + "JML\t[" + CompConfig.funcPointer + "]\n" + state.getWhitespace() + ":\n";
				else assembly += state.getWhitespace() + "JSL\t" + getReferencedFunction(state).getLoaderLabel() + "\n";
				state = state.releasePointers();
				for (VariableNode parameter : variables)
				{
					tmpPair = new StackLoader(parameter.getSize(), parameter.getSource()).getAssemblyAndState(state);
					assembly += tmpPair.assembly;
					state = tmpPair.state;
				}

			}
			
			if (destSource != null)
			{
				tmpPair = new ByteCopier(destSource.getSize(), destSource, CompConfig.callResultSource(destSource.getSize())).getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			break;
		case structMember:
			if (expr.hasAssembly(state))
			{
				tmpPair = expr.getAssemblyAndState(state);
				if (destSource != null)
					tmpPair = new ByteCopier(destSource.getSize(), destSource, getLValue(tmpPair.state).getSource()).apply(tmpPair);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			break;
		case structMemberP:
			if (expr.hasAssembly(state))
			{
				state = state.setDestSource(null);
				tmpPair = expr.getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
				state = state.setDestSource(destSource);
			}
			ScratchSource sourceP;
			if (!state.hasPointer(expr.getLValue(state).getSource()))
			{
				try
				{
					state = state.reservePointer(expr.getLValue(state).getSource());
					sourceP = state.getPointer(expr.getLValue(state).getSource());
				}
				catch (ScratchOverflowException e)
				{
					state.releasePointers();
					state = state.reservePointer(expr.getLValue(state).getSource());
					sourceP = state.getPointer(expr.getLValue(state).getSource());
				}
				tmpPair = new ByteCopier(CompConfig.pointerSize, sourceP, expr.getLValue(state).getSource()).getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			else sourceP = state.getPointer(expr.getLValue(state).getSource());
			if (destSource != null)
			{
				tmpPair = new AssemblyStatePair("", state);
				if (!getType().isArray())
				{
					if (destSource.getSize() > getLValue(state).getSource().getSize())
						tmpPair = new SignExtender(destSource, getLValue(state).getSource(), getType().isSigned(), getLValue(state).getType().isSigned()).apply(tmpPair);
					tmpPair = new ByteCopier(destSource, getLValue(state).getSource()).apply(tmpPair);
				}
				else
					tmpPair = new ByteCopier(destSource, sourceP).apply(tmpPair);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			break;
		case incr: case decr:
			OperandSource sourceX;
			ScratchSource scratchX = null;
			if (expr.hasAssembly(state))
			{
				state = state.reserveScratchBlock(expr.getSize());
				scratchX = state.lastScratchSource();
				state = state.setDestSource(scratchX);
				tmpPair = expr.getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
				state = state.setDestSource(destSource);
				
				if (expr.hasLValue(state))
					sourceX = expr.getLValue(state).getSource();
				else sourceX = scratchX;
			}
			else if (expr.hasPropValue(state))
				sourceX = new ConstantSource(expr.getPropValue(state), expr.getType().getSize());
			else if (expr.hasLValue(state))
				sourceX = expr.getLValue(state).getSource();
			else sourceX = null;
			
			if (destSource != null && !destSource.equals(sourceX))
			{
				tmpPair = new ByteCopier(expr.getSize(), destSource, sourceX).getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
				state = state.releasePointer(sourceX);
			}
			BaseExpressionNode<?> dX = new DummyExpressionNode(this, expr.getType(), 1);
			state = state.releasePointer(sourceX);
			if (type == PFType.incr)
				dX = new AdditiveExpressionNode(this, "+", expr, dX);
			else if (type == PFType.decr)
				dX = new AdditiveExpressionNode(this, "-", expr, dX);
			dX = new AssignmentExpressionNode(this, expr, dX);
			getEnclosingSequencePoint().registerAssemblable(dX);
			
			if (scratchX != null) state = state.releaseScratchBlock(scratchX);
			break;
		default:
			break;
		}
		
		state = state.releasePointer(destSource); // A copy of the destination, if it's a pointer, has gone stale
		return new AssemblyStatePair(assembly, state);
	}

	public PFType getPFType() {return type;}
}
