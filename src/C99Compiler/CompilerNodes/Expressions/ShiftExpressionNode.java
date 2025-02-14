// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.ScratchSource;
import C99Compiler.Utils.AssemblyUtils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.ByteCopier;
import C99Compiler.Utils.AssemblyUtils.BytewiseOperator;
import C99Compiler.Utils.AssemblyUtils.SignExtender;
import C99Compiler.Utils.AssemblyUtils.ZeroCopier;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Additive_expressionContext;
import Grammar.C99.C99Parser.Shift_expressionContext;

public class ShiftExpressionNode extends BinaryExpressionNode
<Shift_expressionContext, Additive_expressionContext, Additive_expressionContext, Shift_expressionContext>
{
	private static class ShiftOperator extends BytewiseOperator
	{
		private OperandSource sourceTo, sourceFrom;
		private boolean left, one, signed;
		public ShiftOperator(boolean left, boolean one, boolean signed, OperandSource sourceTo, OperandSource sourceFrom)
		{
			super(sourceTo.getSize(), sourceTo.getSize(), !left);
			this.sourceTo = sourceTo;
			this.sourceFrom = sourceFrom;
			
			this.left = left;
			this.one = one;
			this.signed = signed;
		}

		@Override
		protected AssemblyStatePair getAssemblyAndState(ProgramState state, int i) throws Exception
		{
			MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
			if (left)
			{
				((one && sourceTo.getSize() <= sourceFrom.getSize()) ? sourceFrom : sourceTo).applyLDA(pair, i);
				pair.assembly += pair.state.getWhitespace() + ((i == 0) ? "ASL\n" : "ROL\n");
			}
			else if (signed)
			{
				(one ? sourceFrom : sourceTo).applyLDA(pair, i);
				pair.assembly += pair.state.getWhitespace() + (state.testProcessorFlag(ProgramState.ProcessorFlag.M) ? "CMP\t#$8000\n" : "CMP\t#$80\n");
				pair.assembly += pair.state.getWhitespace() + "ROR\n";
			}
			else
			{
				(one ? sourceFrom : sourceTo).applyLDA(pair, i);
				pair.assembly += pair.state.getWhitespace() + (i >= sourceFrom.getSize() - 2 ? "LSR\n" : "ROR\n");
			}
			pair.state = pair.state.clearKnownFlags(ProgramState.PreserveFlag.A);
			sourceTo.applySTA(pair, i);
			
			return pair.getImmutable();
		}
	}
	public ShiftExpressionNode(ComponentNode<?> parent) {super(parent);}
	public ShiftExpressionNode(ComponentNode<?> parent, String operator, BaseExpressionNode<?> x, BaseExpressionNode<?> y)
	{
		super(parent, operator, x, y);
	}
	@Override
	protected BaseExpressionNode<Shift_expressionContext> getC1Node(Shift_expressionContext node) throws Exception
	{return new ShiftExpressionNode(this).interpret(node.shift_expression());}

	@Override
	protected BaseExpressionNode<Additive_expressionContext> getC2Node(Shift_expressionContext node) throws Exception
	{return new AdditiveExpressionNode(this).interpret(node.additive_expression());}

	@Override
	protected BaseExpressionNode<Additive_expressionContext> getPCNode(Shift_expressionContext node) throws Exception
	{return new AdditiveExpressionNode(this).interpret(node.additive_expression());}

	@Override public CastContext getCastContext() {return CastContext.bitwise;}
	@Override public Type getType()
	{
		return x.getType().promote();
	}
	
	@Override
	public Object getPropValue(ProgramState state)
	{
		Long a = x.getPropLong(state);
		Long b = y.getPropLong(state);
		switch (operator)
		{
		case "<<": return Long.valueOf(a << b);
		case ">>": return Long.valueOf(a >> b);
		default: return null;
		}
	}
	@Override
	protected AssemblyStatePair getAssemblyAndState(ProgramState state, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		AssemblyStatePair tmpPair;
		String assembly = "";
		String whitespace = state.getWhitespace();
		OperandSource destSource = state.destSource();
		
		assembly += AssemblyUtils.store(state, (byte) (ProgramState.PreserveFlag.A | ProgramState.PreserveFlag.X));
		byte flags = state.getPreserveFlags();
		state = state.clearPreserveFlags((byte) (ProgramState.PreserveFlag.A | ProgramState.PreserveFlag.X));
		
		boolean isOne = y.hasPropValue(state) && (y.getPropLong(state) == 1); // No need for loop w/ only one iteration
		if (sourceX.getSize() < destSource.getSize())
		{
			SignExtender extender = new SignExtender(sourceX, sourceY, x.getType().isSigned(), y.getType().isSigned());
			tmpPair = extender.getAssemblyAndState(state);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
		}
		
		if (y.hasPropValue(state) && y.getPropLong(state) != 0 && ((y.getPropLong(state) % 8) == 0)) // Even better optimization LOL
		{
			int bytesShifted = (int) y.getPropLong(state) / 8;
			int bytesFilled = 0;
			ByteCopier copier1, copier2;
			switch (operator)
			{
			case "<<": // Fill bottom bytes of destSource w/ 0, then put x in
				bytesFilled = Math.max(0, destSource.getSize() - bytesShifted);
				copier1 = new ByteCopier(bytesShifted, destSource, new ConstantSource(0, bytesShifted));
				copier2 = new ByteCopier(bytesFilled, destSource.getShifted(bytesShifted), sourceX);
				tmpPair = copier1.getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
				tmpPair = copier2.getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
				state = state.addPreserveFlags(flags);
				assembly += AssemblyUtils.restore(state, (byte) (ProgramState.PreserveFlag.A | ProgramState.PreserveFlag.X));
				return new AssemblyStatePair(assembly, state);
			case ">>": // Fill bottom bytes of destSource with shifted x, then fill w/ zero
				bytesFilled = Math.min(destSource.getSize(), Math.max(0, sourceX.getSize() - bytesShifted));
				copier1 = new ByteCopier(bytesFilled, destSource, sourceX.getShifted(bytesShifted));
				tmpPair = copier1.getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
				if (bytesFilled < destSource.getSize())
				{
					copier2 = new ByteCopier(bytesShifted, destSource.getShifted(bytesFilled), new ConstantSource(0, bytesShifted));
					tmpPair = copier2.getAssemblyAndState(state);
					assembly += tmpPair.assembly;
					state = tmpPair.state;
				}
				state = state.addPreserveFlags(flags);
				assembly += AssemblyUtils.restore(state, (byte) (ProgramState.PreserveFlag.A | ProgramState.PreserveFlag.X));
				return new AssemblyStatePair(assembly, state);
			}
			
		}
		if (sourceY.getSize() >= 2)
		{
			assembly += whitespace + CompUtils.setA16 + "\n";
			state = state.setProcessorFlags((byte) (ProgramState.ProcessorFlag.M | ProgramState.ProcessorFlag.I));
		}
		else if (sourceY.getSize() == 1)
		{
			assembly += whitespace + CompUtils.setA8 + "\n";
			state = state.clearProcessorFlags((byte) (ProgramState.ProcessorFlag.M | ProgramState.ProcessorFlag.I));
		}
		
		// Use destination as buffer if able to
		OperandSource tempSource;
		if (destSource == null || destSource.getSize() < sourceX.getSize())
		{
			state = state.reserveScratchBlock(sourceX.getSize());
			tempSource = state.lastScratchSource();
		}
		else
			tempSource = destSource;

		if (!isOne || tempSource.getSize() > sourceX.getSize())
		{
			ByteCopier copier;
			if (tempSource.getSize() > sourceX.getSize()) // TODO account for sign
			{
				copier = new ZeroCopier(tempSource.getSize() - sourceX.getSize(), tempSource.getShifted(sourceX.getSize()));
				tmpPair = copier.getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			copier = new ByteCopier(sourceX.getSize(), tempSource, sourceX);
			tmpPair = copier.getAssemblyAndState(state);
			assembly += tmpPair.assembly;
			state = tmpPair.state;
		}
		if (!isOne)
		{
			tmpPair = sourceY.getLDA(state, 0);
			assembly += tmpPair.assembly + "\n";
			state = tmpPair.state;
			assembly += whitespace + "BEQ\t:++\n";
			assembly += whitespace + "TAX\t\n";
			assembly += whitespace + ":\n"; // A loop
			state = state.clearKnownFlags();
		}
		switch (operator)
		{
		case "<<":
			tmpPair = new ShiftOperator(true, isOne, getType().isSigned(), tempSource, sourceX).getAssemblyAndState(isOne ? state : state.indent());
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			break;
		case ">>":
			tmpPair = new ShiftOperator(false, isOne, getType().isSigned(), tempSource, sourceX).getAssemblyAndState(isOne ? state : state.indent());
			assembly += tmpPair.assembly;
			state = tmpPair.state;
			break;
		}
		
		if (!isOne)
		{
			assembly += whitespace + "DEX\n";
			assembly += whitespace + "BNE\t:-\n";
			whitespace = state.undent().getWhitespace();
			assembly += whitespace + ":\n"; // A loop
		}

		if (destSource != tempSource)
		{
			if (destSource != null)
			{
				ByteCopier copier = new ByteCopier(destSource.getSize(), destSource, tempSource);
				tmpPair = copier.getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			state = state.releaseScratchBlock((ScratchSource) tempSource);
		}

		state = state.addPreserveFlags(flags);
		assembly += AssemblyUtils.restore(state, (byte) (ProgramState.PreserveFlag.A | ProgramState.PreserveFlag.X));
		return new AssemblyStatePair(assembly, state);
	}
}
