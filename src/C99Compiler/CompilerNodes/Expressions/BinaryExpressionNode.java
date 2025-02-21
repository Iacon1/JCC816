// By Iacon1
// Created 10/14/2023
// A general expression node.
package C99Compiler.CompilerNodes.Expressions;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.Exceptions.ScratchOverflowException;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.ScratchSource;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;

public abstract class BinaryExpressionNode<
	C1 extends ParserRuleContext,
	C2 extends ParserRuleContext,
	PC extends ParserRuleContext,
	CC extends ParserRuleContext
	> extends BaseExpressionNode<CC>
{
	protected abstract BaseExpressionNode<C1> getC1Node(CC node) throws Exception;
	protected abstract BaseExpressionNode<C2> getC2Node(CC node) throws Exception;
	protected abstract BaseExpressionNode<PC> getPCNode(CC node) throws Exception;
	protected BaseExpressionNode<?> x, y;
	
	protected String operator;
	protected boolean lockToDestSize = false;
	
	public BinaryExpressionNode(ComponentNode<?> parent) {super(parent);}
	public BinaryExpressionNode(ComponentNode<?> parent, String operator, BaseExpressionNode<?> x, BaseExpressionNode<?> y)
	{
		super(parent);
		this.operator = operator;
		this.x = x;
		this.y = y;
	}
	
	public BinaryExpressionNode()
	{
		super();
	}
	@Override
	public BaseExpressionNode<CC> interpret(CC node) throws Exception
	{
		if (node == null) return null;
		if (node.children.size() == 1) // Only one, just propagate it
			return delegate(getPCNode(node));
		else // Two
		{
			x = getC1Node(node);
			y = getC2Node(node);
			
			operator = "";
			for (int i = 0; i < node.getChildCount(); ++i)
				if (TerminalNode.class.isAssignableFrom(node.getChild(i).getClass()))
					operator += node.getChild(i).getText();
		}
		return this;
	}
	protected abstract CastContext getCastContext();
	
	@Override
	public boolean canCall(ProgramState state, FunctionDefinitionNode function)
	{
		return x.canCall(state, function) || y.canCall(state, function);
	}
	
	@Override
	public boolean hasPropValue(ProgramState state)
	{
		return x.hasPropValue(state) && y.hasPropValue(state);
	}
	@Override
	public boolean hasLValue(ProgramState state)
	{
		return false;
	}
	@Override
	public LValueNode<?> getLValue(ProgramState state)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean hasAssembly(ProgramState state) {return x.hasAssembly(state) || y.hasAssembly(state) || !hasPropValue(state);}
	
	protected abstract AssemblyStatePair getAssemblyAndState(ProgramState state, OperandSource sourceX, OperandSource sourceY) throws Exception;
	
	@Override
	public ProgramState getStateBefore(ProgramState state, ComponentNode<?> child) throws Exception
	{
		if (!children.contains(child))
			throw new IllegalArgumentException();
		if (child == x)
			return state;
		if (x.hasAssembly(state))
			state = x.getStateAfter(state);
		if (child == y)
			return state;
		if (y.hasAssembly(state))
			state = y.getStateAfter(state);
		return state;
	}
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		AssemblyStatePair tmpPair; // To store generated pairs
		String assembly = "";
		
		OperandSource destSource = state.destSource();
		
		ScratchSource scratchX = null, scratchY = null;
		final OperandSource sourceX, sourceY;
		
		// figure out X
		if (x.hasAssembly(state))
		{
			int xSize = Math.min(x.getSize(), lockToDestSize? destSource.getSize() : x.getSize());
			state = state.reserveScratchBlock(xSize);
			scratchX = state.lastScratchSource();
			state = state.setDestSource(scratchX);
			
			tmpPair = x.getAssemblyAndState(state);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			
			if (x.hasLValue(state))
				sourceX = x.getLValue(state).getSource();
			else sourceX = scratchX;
		}
		else if (x.hasPropValue(state))
			sourceX = new ConstantSource(x.getPropValue(state), x.getType().getSize());
		else if (x.hasLValue(state))
			sourceX = x.getLValue(state).getSource();
		else sourceX = null;
		
		// figure out Y		
		if (y.hasAssembly(state))
		{
			int ySize = Math.min(y.getSize(), lockToDestSize? destSource.getSize() : y.getSize());
			state = state.reserveScratchBlock(ySize);
			scratchY = state.lastScratchSource();
			state = state.setDestSource(scratchY);
			
			tmpPair = y.getAssemblyAndState(state);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			
			if (y.hasLValue(state))
				sourceY = y.getLValue(state).getSource();
			else sourceY = scratchY;
		}
		else if (y.hasPropValue(state))
			sourceY = new ConstantSource(y.getPropValue(state), y.getType().getSize());
		else if (y.hasLValue(state))
			sourceY = y.getLValue(state).getSource();
		else sourceY = null;

		state = state.setDestSource(destSource);
		tmpPair = getAssemblyAndState(state, sourceX, sourceY);
		assembly += tmpPair.assembly;
		state = tmpPair.state;
		
		if (scratchX != null)
			state = state.releaseScratchBlock(scratchX);
		if (scratchY != null)
			state = state.releaseScratchBlock(scratchY);
		
		return new AssemblyStatePair(assembly, state);
	}
}
