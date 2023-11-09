// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompUtils;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Land_expressionContext;
import Grammar.C99.C99Parser.Lor_expressionContext;

public class LORExpressionNode extends BinaryExpressionNode
<Lor_expressionContext, Land_expressionContext, Land_expressionContext, Lor_expressionContext>
{

	public LORExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Lor_expressionContext> getC1Node(Lor_expressionContext node) throws Exception
	{return new LORExpressionNode(this).interpret(node.lor_expression());}
	
	@Override
	protected BaseExpressionNode<Land_expressionContext> getC2Node(Lor_expressionContext node) throws Exception
	{return new LANDExpressionNode(this).interpret(node.land_expression());}

	@Override
	protected BaseExpressionNode<Land_expressionContext> getPCNode(Lor_expressionContext node) throws Exception
	{return new LANDExpressionNode(this).interpret(node.land_expression());}

	@Override
	public Object getPropValue()
	{
		boolean a = x.getPropBool();
		boolean b = y.getPropBool();
		return a || b;
	}
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		String assembly = whitespace + CompUtils.setXY8 + "\n";
		assembly += whitespace + "LDX\t#$01\n";
		assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, Boolean is16Bit) ->
		{
			return new String[]
			{
				sourceX.prefaceAssembly(whitespace, i, is16Bit),
				"LDA\t" + sourceX.apply(i, is16Bit),
				"BNE\t:+",
				sourceY.prefaceAssembly(whitespace, i, is16Bit),
				"LDA\t" + sourceY.apply(i, is16Bit),
				"BNE\t:+",
			};
		});
		assembly += whitespace + "DEX\n";
		assembly += ":" + whitespace.substring(1) + "TXA\n";
		assembly += whitespace + CompUtils.setA8 + "\n";
		assembly += whitespace + destSource.prefaceAssembly(whitespace, 0, false);
		assembly += whitespace + "STA\t" + destSource.apply(0, false);
		return assembly;
	}
}