// Created by Iacon1 on 09/19/2025.
// An optimized node just for array indicing and dereferencing pointers to known values
package C99Compiler.CompilerNodes.Intermediates;

import java.util.HashSet;
import java.util.Set;

import javax.naming.OperationNotSupportedException;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.PointerType;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.ProgramState.ProgramState;
import C99Compiler.ProgramState.ProgramState.ScratchSource;
import C99Compiler.CompilerNodes.LValues.IndexLValueNode;
import C99Compiler.Utils.AssemblyUtils.ByteCopier;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.IndexOperandSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Postfix_expressionContext;

public class ArrayIndexExpressionNode extends BaseExpressionNode<Postfix_expressionContext>
{
	private LValueNode<?> n;
	private BaseExpressionNode<?> indexExpr;
	private OperandSource indexSource;
	
	public ArrayIndexExpressionNode(ComponentNode<?> parent, LValueNode<?> n, BaseExpressionNode<?> indexExpr)
	{
		super(parent);
		this.n = n;
		this.indexExpr = indexExpr;
		this.indexSource = null;
	}
	@Override
	public BaseExpressionNode<Postfix_expressionContext> interpret(Postfix_expressionContext node) throws Exception
	{
		throw new OperationNotSupportedException();
	}
	
	@Override
	protected void onSwap(ComponentNode<?> from, ComponentNode<?> to)
	{
		if (indexExpr == from)
			indexExpr = (BaseExpressionNode<?>) to;
	}
	@Override
	public boolean canCall(ProgramState state, FunctionDefinitionNode function)
	{
		return indexExpr.canCall(state, function);
	}

	@Override
	public boolean hasLValue(ProgramState state)
	{
		return true;
	}

	@Override
	public LValueNode<?> getLValue(ProgramState state)
	{
		return new IndexLValueNode(this, getType(), n.getSource(), indexSource);
	}
	
	@Override
	public boolean hasPropValue(ProgramState state)
	{
		return state.getOnlyValue((LValueNode<?>) n) != null;
	}

	@Override
	public Object getPropValue(ProgramState state)
	{
		return state.getOnlyValue((LValueNode<?>) n);
	}

	@Override
	public boolean hasAssembly(ProgramState state)
	{
		return true;
	}

	@Override
	public ProgramState getStateBefore(ProgramState state, ComponentNode<?> child) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
		boolean usedScratch = false;
		OperandSource destSource = pair.state.destSource();
		int size = Math.min(indexExpr.getSize(), 2);

		pair.state = pair.state.reverseReserveScratchBlock(size);
		indexSource = pair.state.lastScratchSource();
		pair.state = pair.state.setDestSource(indexSource);
		
		if (indexExpr.hasAssembly(pair.state))
		{
			indexExpr.apply(pair);
			usedScratch = true;
		}
		else if (indexExpr.hasPropValue(state))
		{
			indexSource = new ConstantSource(indexExpr.getPropValue(state), size);
			pair.state = pair.state.releaseScratchBlock((ScratchSource) indexSource).setDestSource(destSource);
		}
		else if (indexExpr.hasLValue(state))
		{
			new ByteCopier(indexSource, indexExpr.getLValue(state).getSource()).apply(pair);
			usedScratch = true;
		}
		pair.state = pair.state.setDestSource(destSource);
		if (destSource != null)
			new ByteCopier(destSource, new IndexOperandSource(getSize(), n.getSource(), indexSource)).apply(pair);

		return pair.getImmutable();
	}

	@Override
	public Type getType()
	{
		return ((PointerType) n.getType()).getType();
	}
	
	@Override
	public String getPointerName() {return "(" + n.getAddress() + ") + (" + indexExpr.getPointerName() + ")";}
	
	@Override
	public Set<String> getIdlePointerDisqualifiers() {return indexExpr.getIdlePointerDisqualifiers();}
	@Override
	public Set<String> getPointerDisqualifiers() {return indexExpr.getPointerDisqualifiers();}
}
