// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.CompilerNodes.Dummies.DummyType;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.ScratchSource;
import C99Compiler.Utils.AssemblyUtils.BytewiseOperator;
import C99Compiler.Utils.AssemblyUtils.ByteCopier;
import C99Compiler.Utils.OperandSources.ConstantByteSource;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Relational_expressionContext;
import Grammar.C99.C99Parser.Shift_expressionContext;

public class RelationalExpressionNode extends BinaryExpressionNode
<Relational_expressionContext, Shift_expressionContext, Shift_expressionContext, Relational_expressionContext>
{
	private String yesLabel, noLabel;
	private String endLabel;
	private boolean shortJump, hasEnd;
	
	private class RelationalOperator extends BytewiseOperator
	{
		private OperandSource sourceX, sourceY, tempSource;

		private boolean isSigned, invert;
		boolean firstOp;
		public RelationalOperator(int n1, int n2, OperandSource sourceX, OperandSource sourceY, OperandSource tempSource, boolean invert)
		{
			super(n1, n2, true);
			this.sourceX = sourceX;
			this.sourceY = sourceY;
			this.tempSource = tempSource;
			this.isSigned = x.getType().isSigned() || y.getType().isSigned();
			this.invert = invert;
		}

		@Override
		public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
		{
			firstOp = true;
			return super.getAssemblyAndState(state);
		}
		@Override
		protected AssemblyStatePair getAssemblyAndState(ProgramState state, int i) throws Exception
		{
			AssemblyStatePair tmpPair;
			String assembly = "";
			
			if (isSigned && firstOp) // First comparison and signed, must EOR y by 0x80
			{
				firstOp = false;
				boolean optimized = false;
				String XOR = state.getWhitespace() + (state.testProcessorFlag(ProgramState.ProcessorFlag.M) ? "EOR\t#$8000\n" : "EOR\t#$80\n");
				if (sourceY.isLiteral())
				{
					String oldAssembly = assembly;
					ProgramState oldState = state;
					try // Optimizable for literals	
					{
						// Get X
						tmpPair = sourceX.getLDA(state, i);
						assembly += tmpPair.assembly;
						state = tmpPair.state;
						assembly += XOR;
						
						// Get Y
						String oldY = ((ConstantSource) sourceY).getBase(state, i).substring(2);
						int yVal = Integer.valueOf(oldY, 16);
						
						// Compare
						assembly += state.getWhitespace() + "CMP\t#$";
						if (state.testProcessorFlag(ProgramState.ProcessorFlag.M)) // 16-bit
							assembly += String.format("%04x", yVal ^ 0x8000);
						else
							assembly += String.format("%02x", yVal ^ 0x80);
						assembly += "\n";
						optimized = true;
					}
					catch (Exception e) // Bad literal
					{
						optimized = false;
						assembly = oldAssembly;
						state = oldState;
					}
				}
				if (!optimized)
				{
					// Get Y
					tmpPair = sourceY.getLDA(state, i);
					assembly += tmpPair.assembly;
					state = tmpPair.state;
					assembly += XOR;
					
					// Store result in buffer
					tmpPair = tempSource.getSTA(state, 0);
					assembly += tmpPair.assembly;
					state = tmpPair.state;
					
					// Get X
					tmpPair = sourceX.getLDA(state, i);
					assembly += tmpPair.assembly;
					state = tmpPair.state;
					assembly += XOR;
					
					// Compare
					tmpPair = tempSource.getInstruction(state, "CMP", 0);
					assembly += tmpPair.assembly;
					state = tmpPair.state;
				}
			}
			else // Don't need to XOR
			{
				firstOp = false;
				// Get X
				tmpPair = sourceX.getLDA(state, i);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
				
				// Compare
				tmpPair = sourceY.getInstruction(state, "CMP", i);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			
			// Jump appropriately
			if (!shortJump)
			{
				assembly += state.getWhitespace() + "BCC\t:+\n";  // Done this way to enable med-jumps
				assembly += state.getWhitespace() + "BRA\t:++\n";
				assembly += state.getWhitespace() + ":JMP\t" + (invert ? noLabel : yesLabel) + "\n"; // If x < y then yes
				assembly += state.getWhitespace() + ":BEQ\t:+\n";
				assembly += state.getWhitespace() + "JMP\t" + (invert ? yesLabel : noLabel) + "\n";	// If x >= y then no
				assembly += state.getWhitespace() + ":\n";
			}
			else
			{
				assembly += state.getWhitespace() + "BCC\t" + (invert ? noLabel : yesLabel) + "\n";  // If x < y then yes
				assembly += state.getWhitespace() + "BNE\t" + (invert ? yesLabel : noLabel) + "\n";  // If x >= y then no
			}
			
			return new AssemblyStatePair(assembly, state);
		}
	}
	public RelationalExpressionNode(ComponentNode<?> parent)
	{
		super(parent);
		String uuid = CompUtils.getSafeUUID();
		this.yesLabel = "__CMP_YES_" + uuid;
		this.noLabel = "__CMP_NO_" + uuid;
		this.endLabel = "__CMP_END_" + uuid;
		this.shortJump = true;
		this.hasEnd = true;
	}
	public RelationalExpressionNode(ComponentNode<?> parent, String operator, BaseExpressionNode<?> x, BaseExpressionNode<?> y, String yesLabel, String noLabel, Boolean shortJump)
	{
		super(parent, operator, x, y);
		this.yesLabel = yesLabel;
		this.noLabel = noLabel;
		this.shortJump = shortJump;
		this.hasEnd = false;
	}
	
	@Override
	protected BaseExpressionNode<Relational_expressionContext> getC1Node(Relational_expressionContext node) throws Exception
	{return new RelationalExpressionNode(this).interpret(node.relational_expression());}

	@Override
	protected BaseExpressionNode<Shift_expressionContext> getC2Node(Relational_expressionContext node) throws Exception
	{return new ShiftExpressionNode(this).interpret(node.shift_expression());}

	@Override
	protected BaseExpressionNode<Shift_expressionContext> getPCNode(Relational_expressionContext node) throws Exception
	{return new ShiftExpressionNode(this).interpret(node.shift_expression());}

	@Override public CastContext getCastContext() {return CastContext.relational;}
	
	@Override
	public Object getPropValue(ProgramState state)
	{
		Long a = x.getPropLong(state);
		Long b = y.getPropLong(state);
		switch (operator)
		{
		case "<": return Boolean.valueOf(a < b);
		case "<=": return Boolean.valueOf(a <= b);
		case ">": return Boolean.valueOf(a > b);
		case ">=": return Boolean.valueOf(a >= b);
		default: return null;
		}
	}
	
	@Override
	public Type getType()
	{
		return new DummyType("int");
	}
	
	@Override
	public boolean isLogical() {return true;}
	
	private AssemblyStatePair getAssemblyAndStateRec(ProgramState state, OperandSource sourceX, OperandSource sourceY, String operator, boolean invert) throws Exception
	{
		if (sourceX.isLiteral() && !sourceY.isLiteral())
			switch (operator) // Always put literal on RHS
			{
			case "<": return getAssemblyAndStateRec(state, sourceY, sourceX, ">", invert);
			case "<=": return getAssemblyAndStateRec(state, sourceY, sourceX, ">=", invert);
			case ">": return getAssemblyAndStateRec(state, sourceY,  sourceX, "<", invert);
			case ">=": return getAssemblyAndStateRec(state, sourceY, sourceX, "<=", invert);
			}
		switch (operator) // Let's always do variants of <
		{
		case ">": return getAssemblyAndStateRec(state, sourceX, sourceY, "<=", !invert);
		case ">=": return getAssemblyAndStateRec(state, sourceX, sourceY, "<", !invert);
		}
		
		String assembly = "";
		
		assert !state.testPreserveFlag(ProgramState.PreserveFlag.A); // Since we jump out of here we have no way to preserve this
		
		//assembly += AssemblyUtils.setSignExtend(state.getWhitespace(), sourceX, sourceY, isSignedX, isSignedY, null);
		
		state = state.reserveScratchBlock(2);
		ScratchSource tempSource = state.lastScratchSource();
		int max = Math.max(sourceX.getSize(), sourceY.getSize());
		int min = Math.min(sourceX.getSize(), sourceY.getSize());
		assembly += state.getWhitespace() + "CLC\n";
		BytewiseOperator o = new RelationalOperator(max, min, sourceX, sourceY, tempSource, invert);
		AssemblyStatePair tmpPair = o.getAssemblyAndState(state);
		assembly += tmpPair.assembly;
		state = tmpPair.state;
		
		// The above actually always checks for "<". This is due to the behavior of the carry flag, it being set when the two words are equal.
		switch (operator)
		{
		case "<":
			assembly += state.getWhitespace() + "JMP\t" + (invert ? yesLabel : noLabel) + "\n"; // If equal, false
			break;
		case "<=":
			assembly += state.getWhitespace() + "JMP\t" + (invert ? noLabel : yesLabel) + "\n"; // If equal, true
			break;
		}
		
		return new AssemblyStatePair(assembly, state);
	}
	@Override
	protected AssemblyStatePair getAssemblyAndState(ProgramState state, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		String assembly = "";
		String whitespace = state.getWhitespace();
		AssemblyStatePair tmpPair = getAssemblyAndStateRec(state, sourceX, sourceY, operator, false);
		assembly += tmpPair.assembly;
		state = tmpPair.state;
		state = state.wipe();
		state = state.clearKnownFlags();
		if (hasEnd)
		{
			assembly += state.getWhitespace() + yesLabel + ":\n";
			if (state.destSource() != null)
			{
				tmpPair = new ByteCopier(state.destSource().getSize(), state.destSource(), new ConstantSource(1, state.destSource().getSize())).getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			else
			{
				assembly += state.getWhitespace() + "SEP\t#$20\n";
				assembly += state.getWhitespace() + "LDA\t#$01\n";
			}
			assembly += whitespace + "BRA\t" + endLabel + "\n";	
			state = state.wipe();
			state = state.clearKnownFlags();
			
			assembly += whitespace + noLabel + ":\n";
			if (state.destSource() != null)
			{
				tmpPair = new ByteCopier(state.destSource().getSize(), state.destSource(), new ConstantSource(0, state.destSource().getSize())).getAssemblyAndState(state);
				assembly += tmpPair.assembly;
				state = tmpPair.state;
			}
			else
			{
				assembly += state.getWhitespace() + "SEP\t#$20\n";
				assembly += state.getWhitespace() + "LDA\t#$00\n";
			}
			assembly += whitespace + endLabel + ":\n";
		}
		return new AssemblyStatePair(assembly, state);
	}
}