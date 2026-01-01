// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.PreserveFlag;
import C99Compiler.Utils.ProgramState.ProcessorFlag;
import C99Compiler.Utils.ProgramState.ScratchSource;
import C99Compiler.Utils.AssemblyUtils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.ByteCopier;
import C99Compiler.Utils.AssemblyUtils.BytewiseOperator;
import C99Compiler.Utils.AssemblyUtils.SignExtender;
import C99Compiler.Utils.AssemblyUtils.ZeroCopier;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import C99Compiler.Utils.OperandSources.StationaryAddressSource;
import Grammar.C99.C99Parser.Additive_expressionContext;
import Grammar.C99.C99Parser.Shift_expressionContext;

public class ShiftExpressionNode extends BinaryExpressionNode
<Shift_expressionContext, Additive_expressionContext, Additive_expressionContext, Shift_expressionContext>
{
	private static class ShiftOperator extends BytewiseOperator
	{
		private OperandSource sourceTo, sourceFrom;
		private boolean left, unrolled, signed;
		private int nShift;
		public ShiftOperator(boolean left, boolean unrolled, int nShift, boolean signed, OperandSource sourceTo, OperandSource sourceFrom)
		{
			super(sourceTo.getSize(), (unrolled ? sourceFrom : sourceTo).getSize(), !left);
			this.sourceTo = sourceTo;
			if (!unrolled)
				sourceFrom = sourceTo;
			this.sourceFrom = sourceFrom;
		
			this.left = left;
			this.unrolled = unrolled;
			this.nShift = nShift;
			this.signed = signed;
		}

		@Override
		protected AssemblyStatePair getAssemblyAndState(ProgramState state, int i) throws Exception
		{
			MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
			sourceFrom.applyLDA(pair, i);
			if (left)
			{
				for (int j = 0; j < nShift; ++j)
					pair.assembly += pair.state.getWhitespace() + ((i == 0) ? "ASL\n" : "ROL\n");
			}
			else
			{
				for (int j = 0; j < nShift; ++j)
					pair.assembly += pair.state.getWhitespace() + ((i >= sourceTo.getSize() - 2) ? "LSR\n" : "ROR\n");
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
		MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
		OperandSource destSource = pair.state.destSource();
		
		boolean isLeft = operator.equals("<<");
		boolean isSigned = x.getType().isSigned();
		boolean canUnroll;
		
		pair.assembly += AssemblyUtils.store(pair.state, (byte) (ProgramState.PreserveFlag.A | ProgramState.PreserveFlag.X));
		byte flags = pair.state.getPreserveFlags();
		pair.state = pair.state.clearPreserveFlags((byte) (ProgramState.PreserveFlag.A | ProgramState.PreserveFlag.X));
		
		canUnroll = false;
		if (y.hasPropValue(pair.state))
		{
			int m, n = (int) y.getPropLong(pair.state);
			if (n % 8 == 0 || ((!isSigned || n == 1) && (n % 8 == 1 || destSource.getSize() <= 2)))
				canUnroll = true; // Can unroll in these circumstances
			m = n / 8;

			if (m > 0)
			{
				n %= 8;
				if (isLeft) // Permute left
				{
					// Fill first m bytes with zero
					new ZeroCopier(m, destSource).apply(pair);
					// Fill rest with x
					if (destSource.getSize() > m)
						new ByteCopier(destSource.getShifted(m).respec(destSource.getSize() - m), sourceX).apply(pair);
				}
				else // Permute right
				{
					// Fill first (size-of-x - m) bytes with x
					new ByteCopier(destSource.respec(sourceX.getSize() - m), sourceX.getShifted(m)).apply(pair);
					// Fill rest with zero
					if (destSource.getSize() > (sourceX.getSize() - m))
					{
						if (isSigned)
						{
							new SignExtender(sourceX.respec(sourceX.getSize() + 1), sourceX, true, true).apply(pair); // Force check
							OperandSource signSource = new StationaryAddressSource(CompConfig.signExtend, destSource.getSize() - (sourceX.getSize() - m));
							new ByteCopier(signSource.getSize(), destSource.getShifted(sourceX.getSize() - m), signSource).apply(pair);
						}
						else
						{
							new ZeroCopier(
								destSource.getSize() - (sourceX.getSize() - m),
								destSource.getShifted(sourceX.getSize() - m)).apply(pair);
						}
					}
				}
				sourceX = destSource;
				sourceY = new ConstantSource(n, sourceY.getSize());
			}
			
			if (canUnroll && n != 0)
			{
				new SignExtender(destSource, sourceX, isSigned, isSigned).apply(pair);
				new ShiftOperator(isLeft, true, n, isSigned, destSource, sourceX).apply(pair);
			}
		}
		
		if (!canUnroll)
		{
			// Can't unroll
			// Copy X to dest
			if (!sourceX.equals(destSource))
			{
				new ByteCopier(destSource.respec(sourceX.getSize()), sourceX).apply(pair);
				// Fill rest with zero
				if (destSource.getSize() > sourceX.getSize())
					new ZeroCopier(destSource.getSize() - sourceX.getSize(), destSource.getShifted(sourceX.getSize())).apply(pair);
			}
			// Set I flag properly
			if (sourceY.getSize() >= 2)
			{
				if (!pair.state.testKnownFlag((byte) (PreserveFlag.M | PreserveFlag.I)) || !pair.state.testProcessorFlag((byte) (ProcessorFlag.M | ProcessorFlag.I)))
				{
					pair.assembly += pair.state.getWhitespace() + "REP\t#$30\n";
					pair.state = pair.state.setProcessorFlags((byte) (ProcessorFlag.M | ProcessorFlag.I));
				}
				if (isSigned && !isLeft)
					sourceX.applyLDA(pair, sourceX.getSize() - 2);
			}
			else
			{
				if (!pair.state.testKnownFlag((byte) (PreserveFlag.M | PreserveFlag.I)) || pair.state.testProcessorFlag((byte) (ProcessorFlag.M | ProcessorFlag.I)))
				{
					pair.assembly += pair.state.getWhitespace() + "SEP\t#$30\n";
					pair.state = pair.state.clearProcessorFlags((byte) (ProcessorFlag.M | ProcessorFlag.I));
				}
				if (isSigned && !isLeft)
					sourceX.applyLDA(pair, sourceX.getSize() - 1);
			}
			// If signed rightshift we need to keep track of the original sign bit.
			if (isSigned && !isLeft)
			{
				// Need to get the sign bit into carry
				pair.assembly += pair.state.getWhitespace() + "ASL\n";
				// Store it in the stack for a cheap trick to retrieve it
				pair.assembly += pair.state.getWhitespace() + "PHP\n";
			}
			
			sourceY.applyLDA(pair, 0);
			pair.assembly += pair.state.getWhitespace() + "TAX\n";
			pair.assembly += pair.state.getWhitespace() + ":\n";
			pair.state = pair.state.indent();
			if (isSigned && !isLeft)
			{
				pair.assembly += pair.state.getWhitespace() + "PLP\n";
				pair.assembly += pair.state.getWhitespace() + "PHP\n";
			}
			else
			{
				pair.assembly += pair.state.getWhitespace() + "CLC\n";
				pair.state = pair.state.clearKnownFlags();
			}
			new ShiftOperator(isLeft, false, 1, isSigned, destSource, sourceX).apply(pair);

			pair.assembly += pair.state.getWhitespace() + "DEX\n";			
			pair.state = pair.state.undent();
			pair.assembly += pair.state.getWhitespace() + "BNE\t:-\n";
			
			if (isSigned && !isLeft) // Set sign bit to proper value
			{
				destSource.applyLDA(pair, destSource.getSize() - 1);
				pair.assembly += pair.state.getWhitespace() + "ASL\n"; // Move top bit out of the way
				
				pair.assembly += pair.state.getWhitespace() + "PLP\n"; // Cheap trick to recover previously-stored sign bit

				if (!pair.state.testKnownFlag(PreserveFlag.M) || pair.state.testProcessorFlag(ProcessorFlag.M))
				{
					pair.assembly += pair.state.getWhitespace() + "SEP\t#$20\n";
					pair.state = pair.state.clearProcessorFlags(ProcessorFlag.M);
				}
				pair.assembly += pair.state.getWhitespace() + "ROR\n"; // Insert into dest
				destSource.applySTA(pair, destSource.getSize() - 1);
			}
		}
		pair.state = pair.state.setPreserveFlags(flags);
		pair.assembly += AssemblyUtils.restore(pair.state, (byte) (ProgramState.PreserveFlag.A | ProgramState.PreserveFlag.X));
		return pair.getImmutable();
	}
}
