// Created by Iacon1 on 1/19/2024.
// Jumps to different labels depending on outcome.
package C99Compiler.CompilerNodes.Expressions;

import org.antlr.v4.runtime.ParserRuleContext;

import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import C99Compiler.Utils.ScratchManager.ScratchSource;

public abstract class BranchingExpressionNode<
C1 extends ParserRuleContext,
C2 extends ParserRuleContext,
PC extends ParserRuleContext,
CC extends ParserRuleContext
> extends BinaryExpressionNode<C1, C2, PC, CC>
{
	public BranchingExpressionNode(ComponentNode<?> parent) {super(parent);}
	public BranchingExpressionNode(ComponentNode<?> parent, String operator, BaseExpressionNode<?> x, BaseExpressionNode<?> y)
	{
		super(parent, operator, x, y);
	}
	
	protected abstract String getAssembly(String whitespace, String yesLabel, String noLabel, OperandSource sourceX, OperandSource sourceY, ScratchManager scratchManager, DetailsTicket ticket) throws Exception;
	
	public String getAssembly(int leadingWhitespace, String yesLabel, String noLabel, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		ScratchSource scratchX = null, scratchY = null;
		final OperandSource sourceX, sourceY;
		String assembly = "";

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
		// Now we figure out X
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
		
		assembly += getAssembly(whitespace, yesLabel, noLabel, sourceX, sourceY, scratchManager, ticket);
		
		return assembly;
	}
}