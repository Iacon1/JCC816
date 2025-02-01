// Created by Iacon1 on 10/22/2023.
//
package C99Compiler.CompilerNodes.Expressions;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.Exceptions.ConstraintException;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Constant_expressionContext;

public class ConstantExpressionNode extends BaseExpressionNode<Constant_expressionContext>
{
	public ConstantExpressionNode(ComponentNode<?> parent) {super(parent);}
	
	public ConstantExpressionNode() {super();}

	public BaseExpressionNode<Constant_expressionContext> interpret(Constant_expressionContext node) throws Exception
	{
		BaseExpressionNode<?> expr = new ConditionalExpressionNode(this).interpret(node.conditional_expression());
		if (!expr.hasPropValue(new ProgramState()))
			throw new ConstraintException("6.6", 4, node.start);
		return delegate(expr);
	}

	// These will all *never* be called, since we always delegate to a conditional expression
	@Override
	public boolean canCall(ProgramState state, FunctionDefinitionNode function) {throw new UnsupportedOperationException();}
	@Override
	public Type getType() {throw new UnsupportedOperationException();}
	@Override
	public boolean hasPropValue(ProgramState state) {throw new UnsupportedOperationException();}
	@Override
	public Object getPropValue(ProgramState state) {throw new UnsupportedOperationException();}
	@Override
	public boolean hasAssembly(ProgramState state) {throw new UnsupportedOperationException();}
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception {throw new UnsupportedOperationException();}
}
