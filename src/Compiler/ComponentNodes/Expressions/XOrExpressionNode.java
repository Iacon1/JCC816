// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.ConstantSource;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.And_expressionContext;
import Grammar.C99.C99Parser.Land_expressionContext;
import Grammar.C99.C99Parser.Lor_expressionContext;
import Grammar.C99.C99Parser.Or_expressionContext;
import Grammar.C99.C99Parser.Xor_expressionContext;

public class XOrExpressionNode extends BinaryExpressionNode
<And_expressionContext, Xor_expressionContext, And_expressionContext, Xor_expressionContext>
{

	public XOrExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<And_expressionContext> getC1Node(Xor_expressionContext node) throws Exception
	{return new AndExpressionNode(this).interpret(node.and_expression());}

	@Override
	protected BaseExpressionNode<Xor_expressionContext> getC2Node(Xor_expressionContext node) throws Exception
	{return new XOrExpressionNode(this).interpret(node.xor_expression());}

	@Override
	protected BaseExpressionNode<And_expressionContext> getPCNode(Xor_expressionContext node) throws Exception
	{return new AndExpressionNode(this).interpret(node.and_expression());}

	public static String getExclOr(String whitespace, OperandSource destSource, OperandSource sourceX, OperandSource sourceY)
	{
		String assembly = AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, Boolean is16Bit) ->
		{
			return new String[]
			{
				sourceX.prefaceAssembly(whitespace, i, is16Bit),
				"LDA\t" + sourceX.apply(i, is16Bit),
				sourceY.prefaceAssembly(whitespace, i, is16Bit),
				"EOR\t" + sourceY.apply(i, is16Bit),
				destSource.prefaceAssembly(whitespace, i, is16Bit),
				"STA\t" + destSource.apply(i, is16Bit),
			};
		});
		return assembly;
	}
	public static String getComplementer(String whitespace, OperandSource destSource, OperandSource sourceX)
	{
		OperandSource sourceY = new ConstantSource(Long.valueOf("FF".repeat(sourceX.getSize())), sourceX.getSize()); // 0xFF...FF
		String assembly = AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, Boolean is16Bit) ->
		{
			return new String[]
			{
				sourceX.prefaceAssembly(whitespace, i, is16Bit),
				"LDA\t" + sourceX.apply(i, is16Bit),
				sourceY.prefaceAssembly(whitespace, i, is16Bit),
				"EOR\t" + sourceY.apply(i, is16Bit),
				destSource.prefaceAssembly(whitespace, i, is16Bit),
				"STA\t" + destSource.apply(i, is16Bit),
			};
		});
		return assembly;
	}
	@Override
	public Object getPropValue()
	{
		Long a = x.getPropLong();
		Long b = y.getPropLong();
		return Long.valueOf(a ^ b);
	}
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		return getExclOr(whitespace, destSource, sourceX, sourceY);
	}
}
