// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompUtils;
import Compiler.Utils.OperandSource;
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
		Boolean a = ((Boolean) x.getPropValue()).booleanValue();
		Boolean b = ((Boolean) y.getPropValue()).booleanValue();
		return a || b;
	}
	@Override
	protected String getAssembly(String whitespace, String destAddr, boolean useB, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		String assembly = whitespace + CompUtils.setXY8 + "\n";
		assembly += whitespace + "LDX\t#$01\n";
		assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i) ->
		{
			return new String[]
			{
				"LDA\t" + sourceX.apply(i),
				"BNE\t:+",
				"LDA\t" + sourceY.apply(i),
				"BNE\t:+",
			};
		});
		assembly += whitespace + "DEX\n";
		assembly += ":" + whitespace.substring(1) + "TXA\n";
		assembly += whitespace + "STA\t" + destAddr + " + 0\n";
		return assembly;
	}
}
