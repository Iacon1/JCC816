// By Iacon1
// Created 10/14/2023
// A general expression node.
package C99Compiler.CompilerNodes.Expressions;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;
import C99Compiler.Utils.ScratchManager.ScratchSource;

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
			return (BaseExpressionNode) getPCNode(node);
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
	public Type getType()
	{
		if (x.getType().isArithmetic() && y.getType().isArithmetic())
		{
			if (x.getSize() < y.getSize()) return y.getType();
			else return x.getType();
		}
		else if (x.canCastFrom(y, getCastContext())) return x.getType();
		else if (y.canCastFrom(x, getCastContext())) return y.getType();
		else return null;
	}
	
	@Override
	public boolean canCall(FunctionDefinitionNode function)
	{
		return x.canCall(function) || y.canCall(function);
	}
	
	@Override
	public boolean hasPropValue()
	{
		return x.hasPropValue() && y.hasPropValue();
	}
	
	@Override
	public boolean hasAssembly() {return x.hasAssembly() || y.hasAssembly() || !hasPropValue();}
	protected abstract String getAssembly(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY, ScratchManager scratchManager, DetailsTicket ticket) throws Exception;
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager, DetailsTicket ticket) throws Exception
	{
		String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
		ScratchSource scratchX = null, scratchY = null;
		final OperandSource sourceX, sourceY;
		String assembly = "";

		// figure out X
		if (x.hasAssembly())
		{
			scratchX = scratchManager.reserveScratchBlock(x.getType().getSize());
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
		
		
		assembly += getAssembly(whitespace, destSource, sourceX, sourceY, scratchManager, ticket);
		if (scratchX != null) scratchManager.releaseScratchBlock(scratchX);
		if (scratchY != null) scratchManager.releaseScratchBlock(scratchY);
		
		ScratchManager.releasePointer(destSource); // A copy of the destination, if it's a pointer, has gone stale
		return assembly;
	}
}
