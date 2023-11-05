// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompUtils;
import Compiler.Utils.OperandSource;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.ScratchManager.ScratchSource;
import Grammar.C99.C99Parser.Additive_expressionContext;
import Grammar.C99.C99Parser.Or_expressionContext;
import Grammar.C99.C99Parser.Shift_expressionContext;
import Grammar.C99.C99Parser.Xor_expressionContext;

public class ShiftExpressionNode extends BinaryExpressionNode
<Shift_expressionContext, Additive_expressionContext, Additive_expressionContext, Shift_expressionContext>
{

	public ShiftExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Shift_expressionContext> getC1Node(Shift_expressionContext node) throws Exception
	{return new ShiftExpressionNode(this).interpret(node.shift_expression());}

	@Override
	protected BaseExpressionNode<Additive_expressionContext> getC2Node(Shift_expressionContext node) throws Exception
	{return new AdditiveExpressionNode(this).interpret(node.additive_expression());}

	@Override
	protected BaseExpressionNode<Additive_expressionContext> getPCNode(Shift_expressionContext node) throws Exception
	{return new AdditiveExpressionNode(this).interpret(node.additive_expression());}

	@Override
	public Object getPropValue()
	{
		Long a = ((Number) x.getPropValue()).longValue();
		Long b = ((Number) y.getPropValue()).longValue();
		switch (operator)
		{
		case "<<": return Long.valueOf(a << b);
		case ">>": return Long.valueOf(a >> b);
		default: return null;
		}
	}
	public static String getShift(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, String operator, OperandSource sourceY) throws Exception
	{
		String assembly = "";
		ScratchSource sourceI = null;
		if (!(sourceY.isLiteral() && sourceY.getSize() == 1 && sourceY.apply(0, true).equals("#$0001")))
		{
			sourceI = scratchManager.reserveScratchBlock(sourceY.getSize());
			assembly += AssemblyUtils.byteCopier(whitespace, sourceY.getSize(), sourceI.getAddress(), sourceY);
			assembly += ":\n"; // A loop
		}
		
		switch (operator)
		{
		case "<<":
			assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, Boolean is16Bit) ->
			{
				return new String[]
				{
					"LDA\t" + sourceX.apply(i, is16Bit),
					(i >= sourceX.getSize() - 2) ? "ASL" : "ROL",
					"STA\t" + destSource.apply(i, is16Bit),
				};
			});
			break;
		case ">>":
			assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, Boolean is16Bit) -> 
			{return new String[]
				{
					"LDA\t" + sourceX.apply(i, is16Bit),
					(i >= sourceX.getSize() - 2) ? "LSR" : "ROR",
					"STA\t" + destSource.apply(i, is16Bit),
				};
			}, true, true);
			break;
		}
		if (!(sourceY.isLiteral() && sourceY.getSize() == 1 && sourceY.apply(0, true).equals("#$0001")))
		{
			assembly += AdditiveExpressionNode.getDecrementer(whitespace, sourceI, sourceI);
			assembly += whitespace + "BNE\t:-\n";
			scratchManager.releaseScratchBlock(sourceI);
		}
		return assembly;
	}
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		return getShift(whitespace, destSource, scratchManager, sourceX, operator, sourceY);
	}
}
