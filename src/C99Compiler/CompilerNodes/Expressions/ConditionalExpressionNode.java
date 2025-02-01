// Created by Iacon1 on 10/20/2023.
// 
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.ProgramState.ScratchSource;
import C99Compiler.Utils.AssemblyUtils.ByteCopier;
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
	protected AssemblyStatePair getAssemblyAndState(ProgramState state, OperandSource sourceX, OperandSource sourceY) {return null;}
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		OperandSource destSource = state.destSource();
		String whitespace = state.getWhitespace();
		ScratchSource scratchX = null, scratchY = null;
		final OperandSource sourceX, sourceY, sourceZ;
		AssemblyStatePair pair = new AssemblyStatePair("", state);
		// Figure out Z
		if (z.hasAssembly(state))
		{
			isSP = true;
			state = state.reserveScratchBlock(z.getSize());
			sourceZ = state.lastScratchSource();
			clearAssemblables();
			state = state.setDestSource(sourceZ);
			pair = z.apply(pair);
			//assembly += getAccumulatedSequences();
			clearAssemblables(); isSP = false;
		}
		else if (z.hasLValue())
			sourceZ = z.getLValue().getSource();
		else
			sourceZ = null;
		
		String noLabel = null, endLabel = null;
		if (!z.hasPropValue(state))
		{
			noLabel = "__condSkip" + CompUtils.getSafeUUID();
			state = state.setDestSource(sourceZ);
			EqualityExpressionNode n = new EqualityExpressionNode(this, z);
			pair = n.apply(pair);
			pair = pair.addAssembly(whitespace + "BNE\t:+\n");
			pair = pair.addAssembly(whitespace + "JMP\t" + noLabel + "\n");
			pair = pair.addAssembly(whitespace + ":\n");
		}
		if (!z.hasPropValue(state) || z.getPropBool(state) == true)
		{
			// figure out X
			if (x.hasAssembly(state))
			{
				state = state.reserveScratchBlock(x.getType().getSize());
				scratchX = state.lastScratchSource();
				state = state.setDestSource(scratchX);
				pair = x.apply(pair);
				if (x.hasLValue())
					sourceX = x.getLValue().getSource();
				else sourceX = scratchX;
			}
			else if (x.hasPropValue(state))
				sourceX = new ConstantSource(x.getPropValue(state), x.getType().getSize());
			else if (x.hasLValue())
				sourceX = x.getLValue().getSource();
			else sourceX = null;
			ByteCopier copier = new ByteCopier(sourceX.getSize(), destSource, sourceX);
			pair = copier.apply(pair);
		}
		if (!z.hasPropValue(state))
		{
			endLabel = "__condEnd" + CompUtils.getSafeUUID();
			pair = pair.addAssembly(whitespace + "JMP\t" + endLabel + "\n");
			pair = pair.addAssembly(whitespace + noLabel + ":\n");
		}
		if (!z.hasPropValue(state) || z.getPropBool(state) == false)
		{
			// figure out Y		
			if (y.hasAssembly(state))
			{
				state = state.reserveScratchBlock(y.getType().getSize());
				scratchY = state.lastScratchSource();
				state = state.setDestSource(scratchY);
				pair = y.apply(pair);
				if (y.hasLValue())
					sourceY = y.getLValue().getSource();
				else sourceY = scratchY;
			}
			else if (y.hasPropValue(state))
				sourceY = new ConstantSource(y.getPropValue(state), y.getType().getSize());
			else if (y.hasLValue())
				sourceY = y.getLValue().getSource();
			else sourceY = null;
			ByteCopier copier = new ByteCopier(sourceY.getSize(), destSource, sourceY);
			pair = copier.apply(pair);
		}
		if (!z.hasPropValue(state))
			pair = pair.addAssembly(whitespace + endLabel + ":\n");

		return pair;
	}
	
}
