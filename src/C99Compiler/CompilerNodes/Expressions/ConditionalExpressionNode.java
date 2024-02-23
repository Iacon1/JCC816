// Created by Iacon1 on 10/20/2023.
// 
package C99Compiler.CompilerNodes.Expressions;

import java.util.LinkedList;
import java.util.List;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.CompilerNodes.Interfaces.SequencePointNode;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.Utils.ScratchManager.ScratchSource;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Conditional_expressionContext;
import Grammar.C99.C99Parser.ExpressionContext;
import Grammar.C99.C99Parser.Lor_expressionContext;

// TODO conditional expression
public class ConditionalExpressionNode extends BinaryExpressionNode
<ExpressionContext, Conditional_expressionContext, Lor_expressionContext, Conditional_expressionContext> implements SequencePointNode
{
	private BaseExpressionNode<?> z;
	private List<String> sequenceQueue;
	private boolean isSP;
	
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
		sequenceQueue = new LinkedList<String>();
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
	@Override public boolean isSequencePoint() {return isSP;}
	@Override public void registerSequence(String assembly) {sequenceQueue.add(assembly);}
	@Override public void clearSequence() {sequenceQueue.clear();}
	@Override public String getAccumulatedSequences() {String assembly = ""; for (String queued : sequenceQueue) assembly += queued; return assembly;}

	@Override public CastContext getCastContext() {return CastContext.conditional;}
	@Override public Type getType() {return x.getType();}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return x.canCall(function) || y.canCall(function) || z.canCall(function);
	}
	public boolean hasPropValue()
	{
		return x.hasPropValue() && y.hasPropValue() && z.hasPropValue();
	}
	@Override
	public Object getPropValue()
	{
		if (z.getPropBool()) return x.getPropValue();
		else return y.getPropValue();
	}
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{return null;}
	
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		ScratchSource scratchX = null, scratchY = null, scratchZ = null;
		final OperandSource sourceX, sourceY, sourceZ;
		String assembly = "";
		// Figure out Z
		if (z.hasAssembly())
		{
			isSP = true;
			sourceZ = scratchZ = scratchManager.reserveScratchBlock(z.getSize());
			clearSequence();
			assembly += z.getAssembly(whitespace.length(), sourceZ, scratchManager, ticket);
			assembly += getAccumulatedSequences();
			clearSequence(); isSP = false;
		}
		else if (z.hasLValue())
			sourceZ = z.getLValue().getSource();
		else
			sourceZ = null;
		
		String noLabel = null, endLabel = null;
		if (!z.hasPropValue())
		{
			noLabel = "__condSkip" + CompUtils.getSafeUUID();
			assembly += EqualityExpressionNode.getIsZero(whitespace, null, scratchManager, sourceZ, ticket);
			assembly += whitespace + "BNE\t:+\n";
			assembly += whitespace + "JMP\t" + noLabel + "\n";
			assembly += whitespace + ":\n";
		}
		if (!z.hasPropValue() || z.getPropBool() == true)
		{
			// figure out X
			if (x.hasAssembly())
			{
				scratchX = scratchManager.reserveScratchBlock(y.getType().getSize());
				assembly += x.getAssembly(leadingWhitespace, scratchX, scratchManager, ticket);
				if (x.hasLValue())
					sourceX = x.getLValue().getSource();
				else sourceX = scratchX;
			}
			else if (x.hasPropValue())
				sourceX = new ConstantSource(x.getPropValue(), x.getType().getSize());
			else if (x.hasLValue())
				sourceX = x.getLValue().getSource();
			else sourceX = null;
			assembly += AssemblyUtils.byteCopier(whitespace, sourceX.getSize(), destSource, sourceX);
		}
		if (!z.hasPropValue())
		{
			endLabel = "__condEnd" + CompUtils.getSafeUUID();
			assembly += whitespace + "JMP\t" + endLabel + "\n";
			assembly += whitespace + noLabel + ":\n";
		}
		if (!z.hasPropValue() || z.getPropBool() == false)
		{
			// figure out Y		
			if (y.hasAssembly())
			{
				scratchY = scratchManager.reserveScratchBlock(y.getType().getSize());
				assembly += y.getAssembly(leadingWhitespace, scratchY, scratchManager, ticket);
				if (y.hasLValue())
					sourceY = y.getLValue().getSource();
				else sourceY = scratchY;
			}
			else if (y.hasPropValue())
				sourceY = new ConstantSource(y.getPropValue(), y.getType().getSize());
			else if (y.hasLValue())
				sourceY = y.getLValue().getSource();
			else sourceY = null;
			assembly += AssemblyUtils.byteCopier(whitespace, sourceY.getSize(), destSource, sourceY);
		}
		if (!z.hasPropValue())
			assembly += whitespace + endLabel + ":\n";
		
		if (scratchX != null) scratchManager.releaseScratchBlock(scratchX);
		if (scratchY != null) scratchManager.releaseScratchBlock(scratchY);
		if (scratchZ != null) scratchManager.releaseScratchBlock(scratchZ);
		
		ScratchManager.releasePointer(destSource); // A copy of the destination, if it's a pointer, has gone stale
		
		return assembly;
	}
	
}
