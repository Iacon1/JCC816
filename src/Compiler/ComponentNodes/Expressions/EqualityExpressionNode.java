// Created by Iacon1 on 10/20/2023.
//
package Compiler.ComponentNodes.Expressions;

import java.util.LinkedList;
import java.util.List;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.CompUtils;
import Compiler.Utils.OperandSource;
import Compiler.Utils.ScratchManager;
import Grammar.C99.C99Parser.Equality_expressionContext;
import Grammar.C99.C99Parser.Relational_expressionContext;

public class EqualityExpressionNode extends BinaryExpressionNode
<Equality_expressionContext, Relational_expressionContext, Relational_expressionContext, Equality_expressionContext>
{

	public EqualityExpressionNode(ComponentNode<?> parent) {super(parent);}

	@Override
	protected BaseExpressionNode<Equality_expressionContext> getC1Node(Equality_expressionContext node) throws Exception
	{return new EqualityExpressionNode(this).interpret(node.equality_expression());}

	@Override
	protected BaseExpressionNode<Relational_expressionContext> getC2Node(Equality_expressionContext node) throws Exception
	{return new RelationalExpressionNode(this).interpret(node.relational_expression());}

	@Override
	protected BaseExpressionNode<Relational_expressionContext> getPCNode(Equality_expressionContext node) throws Exception
	{return new RelationalExpressionNode(this).interpret(node.relational_expression());}

	@Override
	public Object getPropValue()
	{
		switch (operator)
		{
		case "==":
			return x.getPropValue().equals(y.getPropValue());
		case "!=":
			return x.getPropValue().equals(y.getPropValue());
		default: return null;
		}
	}
	
	public static String getIsZero(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource source)
	{
		String assembly = "";
		assembly += CompUtils.setA8 + "\n";
		assembly += whitespace + "LDA\t#$00\n";
		assembly += AssemblyUtils.bytewiseOperation(whitespace, source.getSize(), (Integer i, Boolean is16Bit) -> {return new String[]{"ORA\t" + source.apply(i, is16Bit)};}, false, false);
		assembly += whitespace + "STA\t" + destSource.apply(0, false) + "\n";
		return assembly;
	}
	
	@Override
	protected String getAssembly(String whitespace, OperandSource destSource, ScratchManager scratchManager, OperandSource sourceX, OperandSource sourceY) throws Exception
	{
		String assembly = "";

		assembly += whitespace + CompUtils.setXY8 + "\n";
		if (operator.equals("==")) assembly += whitespace + "LDX\t#$00\n";
		else if (operator.equals("!=")) assembly += whitespace + "LDX\t#$01\n";
		assembly += AssemblyUtils.bytewiseOperation(whitespace, sourceX.getSize(), (Integer i, Boolean is16Bit) -> 
		{	
			List<String> lines = new LinkedList<String>();
			
			lines.add("LDA\t" + sourceX.apply(i, is16Bit));	// Get X
			lines.add("CMP\t" + sourceY.apply(i, is16Bit));	// Cmp X & Y?
			lines.add("BNE\t:+");							// if [not op] then no
			// else maybe
			return lines.toArray(new String[] {});
		});
		if (operator.equals("==")) assembly += whitespace + "INX\n";
		else if (operator.equals("!=")) assembly += whitespace + "DEX\n";
		assembly += ":" + whitespace.substring(1) + "TXA\n";
		assembly += whitespace + CompUtils.setA8 + "\n";
		assembly += whitespace + "STA\t" + destSource + "\n";
		
		return assembly;
	}
}
