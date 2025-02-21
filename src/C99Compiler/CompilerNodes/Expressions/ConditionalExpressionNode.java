// Created by Iacon1 on 10/20/2023.
// 
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.ScratchSource;
import C99Compiler.Utils.AssemblyUtils.ByteCopier;
import C99Compiler.Utils.AssemblyUtils.ComparitiveJump;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Conditional_expressionContext;
import Grammar.C99.C99Parser.ExpressionContext;
import Grammar.C99.C99Parser.Lor_expressionContext;

// TODO conditional expression
public class ConditionalExpressionNode extends SPBinaryExpressionNode
<ExpressionContext, Conditional_expressionContext, Lor_expressionContext, Conditional_expressionContext>
{
	private BaseExpressionNode<?> z;
	private String condId;
	
	@Override
	protected BaseExpressionNode<ExpressionContext> getC1Node(Conditional_expressionContext node) throws Exception
	{return new ExpressionNode(this).interpret(node.expression());}
	@Override
	protected BaseExpressionNode<Conditional_expressionContext> getC2Node(Conditional_expressionContext node) throws Exception
		{return new ConditionalExpressionNode(this).interpret(node.conditional_expression());}
	@Override
	protected BaseExpressionNode<Lor_expressionContext> getPCNode(Conditional_expressionContext node) throws Exception
		{return new LORExpressionNode(this).interpret(node.lor_expression());}
	
	public ConditionalExpressionNode(ComponentNode<?> parent)
	{
		super(parent);
		isSP = false;
		condId = CompUtils.getSafeUUID();
	}
	
	@Override
	public BaseExpressionNode<Conditional_expressionContext> interpret(Conditional_expressionContext node) throws Exception
	{
		if (node.children.size() == 1) // Only one, just propagate it
			return delegate(getPCNode(node));
		else // Two
		{
			z = (BaseExpressionNode) new LORExpressionNode(this).interpret(node.lor_expression());
			x = getC1Node(node);
			y = getC2Node(node);
			
			operator = "";
			for (int i = 0; i < node.getChildCount(); ++i)
				if (node.getTokens(i).size() == 1) operator += node.getToken(i, 0);
		}
		return this;
	}

	@Override public CastContext getCastContext() {return CastContext.conditional;}
	@Override public Type getType() {return x.getType();}
	
	@Override
	public boolean canCall(ProgramState state, FunctionDefinitionNode function)
	{
		return x.canCall(state, function) || y.canCall(state, function) || z.canCall(state, function);
	}
	public boolean hasPropValue(ProgramState state)
	{
		return x.hasPropValue(state) && y.hasPropValue(state) && z.hasPropValue(state);
	}
	@Override
	public Object getPropValue(ProgramState state)
	{
		if (z.getPropBool(state)) return x.getPropValue(state);
		else return y.getPropValue(state);
	}
	@Override
	public ProgramState getStateBefore(ProgramState state, ComponentNode<?> child) throws Exception
	{
		if (!children.contains(child))
			throw new IllegalArgumentException();
		if (child == z)
			return state;
		if (z.hasAssembly(state))
			state = z.getStateAfter(state);
		
		return state;
	}
	
	@Override
	protected AssemblyStatePair getAssemblyAndState(ProgramState state, OperandSource sourceX, OperandSource sourceY) {return null;}
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
		OperandSource destSource = pair.state.destSource();
		
		// Figure out Z and put whether it's zero or not in the A register
		pair.state = pair.state.setDestSource(null);
		EqualityExpressionNode equ = new EqualityExpressionNode(this, z);
		if (equ.hasAssembly(state))
		{
			isSP = true;
			clearAssemblables();
			pair = equ.apply(pair);
			applyRegistered(pair);
			clearAssemblables(); isSP = false;
		}

		if (z.hasPropValue(pair.state) && (z.getPropBool(pair.state) == true || z.getPropLong(state) != 0)) // Always true
			new ByteCopier(destSource.getSize(), destSource, x.getPropValue(pair.state)).apply(pair);
		else if (z.hasPropValue(pair.state)) // Always false
			new ByteCopier(destSource.getSize(), destSource, y.getPropValue(pair.state)).apply(pair);		
		else
		{
			String noLabel = "__condSkip" + condId;
			String endLabel = "__condEnd" + condId;
			new ComparitiveJump(
					new AssignmentExpressionNode(this,
							new DummyExpressionNode(this, getType(), destSource),
							x),
					new AssignmentExpressionNode(this,
							new DummyExpressionNode(this, getType(), destSource),
							y),
					noLabel,
					endLabel, false).apply(pair);

		}
		return pair.getImmutable();
	}

}
