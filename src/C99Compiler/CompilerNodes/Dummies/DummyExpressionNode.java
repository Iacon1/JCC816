// Created by Iacon1 on 01/19/2024.
//
package C99Compiler.CompilerNodes.Dummies;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.LValues.LValueNode;
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
	private OperandSource source;
	
	public DummyExpressionNode(ComponentNode<?> parent, Type type, Object value)
	{
		super(parent);
		this.type = type;
		this.value = value;
		source = null;
	}
	public DummyExpressionNode(ComponentNode<?> parent, Type type, OperandSource source)
	{
		super(parent);
		this.type = type;
		value = null;
		this.source = source;
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
	public boolean hasPropValue() {return value != null;}

	@Override
	public Object getPropValue() {return value;}

	@Override
	public boolean hasLValue() {return source != null;}
	
	@Override
	public LValueNode<?> getLValue() {return new DummyLValueNode(this, type, source);}
	@Override
	public String getAssembly(int leadingWhitespace, OperandSource destSource, ScratchManager scratchManager, DetailsTicket ticket) throws Exception {return "";}
}
