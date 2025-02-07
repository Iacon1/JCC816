// Created by Iacon1 on 11/23/2023.
// An arithmetic binary expression node that calls a subroutine
package C99Compiler.CompilerNodes.Expressions;

import org.antlr.v4.runtime.ParserRuleContext;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.AssemblyUtils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.ByteCopier;
import C99Compiler.Utils.AssemblyUtils.ZeroCopier;
import C99Compiler.Utils.OperandSources.OperandSource;

public abstract class CallingArithmeticBinaryExpressionNode<
C1 extends ParserRuleContext,
C2 extends ParserRuleContext,
PC extends ParserRuleContext,
CC extends ParserRuleContext
> extends ArithmeticBinaryExpressionNode<C1, C2, PC, CC>
{
	protected CallingArithmeticBinaryExpressionNode(ComponentNode<?> parent)
	{
		super(parent);
	}

	public CallingArithmeticBinaryExpressionNode(ComponentNode<?> parent, String operator, BaseExpressionNode<?> x, BaseExpressionNode<?> y)
	{
		super(parent, operator, x, y);
	}

	protected String getPreface() {throw new UnsupportedOperationException();}
	@Override
	protected String getInstruction() {throw new UnsupportedOperationException();}
	@Override
	protected boolean isReversed() {throw new UnsupportedOperationException();}
	@Override
	protected abstract int getRetSize(int sizeX, int sizeY);
	
	public abstract String getSub(int sizeX, int sizeY) throws Exception;
	public abstract String getSubName(int sizeX, int sizeY);
	public abstract AssemblyStatePair getCall(ProgramState state, int sizeR, int sizeX, int sizeY) throws Exception;
	@Override
	protected AssemblyStatePair getAssemblyAndState(ProgramState state, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		AssemblyStatePair callPair; 
		
		MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
		OperandSource destSource = pair.state.destSource();
		
		pair.assembly += AssemblyUtils.store(state, (byte) 0xFF);
		byte preserveFlags = pair.state.getPreserveFlags();
		pair.state = pair.state.clearPreserveFlags();
		
		ByteCopier xCopier, yCopier;
		xCopier = new ByteCopier(sourceX.getSize(), CompConfig.specSubSource(true, sourceX.getSize()), sourceX);
		yCopier = new ByteCopier(sourceY.getSize(), CompConfig.specSubSource(false, sourceY.getSize()), sourceY);
		
		xCopier.apply(pair);
		yCopier.apply(pair);

		
		int retSize = Math.min(destSource.getSize(), getRetSize(sourceX.getSize(), sourceY.getSize()));
		callPair = getCall(pair.state, retSize, sourceX.getSize(), sourceY.getSize());
		pair.assembly += callPair.assembly;
		pair.state = callPair.state;
		
		new ByteCopier(retSize, destSource, CompConfig.callResultSource(retSize)).apply(pair);

		if (retSize < destSource.getSize())
			new ZeroCopier(destSource.getSize() - retSize, destSource.getShifted(retSize)).apply(pair);

		getTranslationUnit().requireSub(getSubName(sourceX.getSize(), sourceY.getSize()), getSub(sourceX.getSize(), sourceY.getSize()));
		pair.assembly += AssemblyUtils.restore(state, preserveFlags);
		state = state.setPreserveFlags(preserveFlags);
		return pair.getImmutable();
	}
}