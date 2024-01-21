// Created by Iacon1 on 01/19/2024.
//
package C99Compiler.CompilerNodes.Dummies;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ScratchManager;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.ExpressionContext;

/**
 * 
 */
public class DummyExpressionNode extends BaseExpressionNode<ExpressionContext>
{
	private Type type;
	private Object value;
	
	public DummyExpressionNode(ComponentNode<?> parent, Type type, Object value)
	{
		super(parent);
		this.type = type;
		this.value = value;
	}
	public DummyExpressionNode(ComponentNode<?> parent, long value)
	{
		super(parent);
		this.type = CompUtils.getSmallestType(value);
		this.value = Long.valueOf(value);
	}
	@Override public boolean hasAssembly() {return false;}

	@Override
	public BaseExpressionNode<ExpressionContext> interpret(ExpressionContext node) throws Exception {return this;}
	
	@Override
	public Type getType() {return type;}

	@Override
	public boolean hasPropValue() {return true;}

	@Override
	public Object getPropValue() {return value;}

	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager, DetailsTicket ticket) throws Exception {return "";}
}
