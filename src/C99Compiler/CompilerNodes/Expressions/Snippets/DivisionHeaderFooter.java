// Created by Iacon1 on 12/12/2023.
//
package C99Compiler.CompilerNodes.Expressions.Snippets;

import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.SNESRegisters;
import C99Compiler.Utils.OperandSources.OperandSource;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.Expressions.UnaryExpressionNode;

//Uses hardware div registers, but only for 8-bit divisor
public class DivisionHeaderFooter
{
	private DivisionHeaderFooter() {}
	// Handles negative numbers for division, stores 0, 1, or 2 in Y-register
	public static String divisionHeader(String whitespace, OperandSource sourceX, OperandSource sourceY, DetailsTicket ticket) throws Exception
	{
		String assembly = "";
		Type xType = CompUtils.getTypeForSize(sourceX.getSize(), true);
		Type yType = CompUtils.getTypeForSize(sourceY.getSize(), true);
		// First, check negative for X
		assembly += whitespace + CompUtils.setAXY8 + "\n";
		assembly += whitespace + "LDY\t#$00\n";
		assembly += sourceX.getLDA(whitespace, sourceX.getSize() - 1, ticket);
		String label1 = "__L1" + sourceX.getSize() + "_" + sourceY.getSize() + "_header";
		assembly += whitespace + "BPL\t" + label1 + "\n";
		// If it was negative we add one to the flag and then make it positive.
		assembly += whitespace + "INY\n";
		assembly += new UnaryExpressionNode(null, "-", new DummyExpressionNode(null, xType, sourceX)).getAssembly(whitespace.length(), sourceX);
		assembly += whitespace + label1 + ":" + "\n";
		// Then for Y
		assembly += whitespace + CompUtils.setA8 + "\n";
		assembly += sourceY.getLDA(whitespace, sourceY.getSize() - 1, ticket);
		String label2 = "__L2" + sourceX.getSize() + "_" + sourceY.getSize() + "_header";
		assembly += whitespace + "BPL\t" + label2 + "\n";
		// If it was negative we subtract one from the previous flag (making it not zero if it was zero and making it zero if it wasn't)
		// and then make it positive.
		assembly += whitespace + "DEY\n";
		assembly += new UnaryExpressionNode(null, "-", new DummyExpressionNode(null, yType, sourceY)).getAssembly(whitespace.length(), sourceY);
		assembly += label2 + ":\n";
		
		return assembly;
	}
	public static String divisionFooter(String whitespace, OperandSource destSource, OperandSource source, DetailsTicket ticket) throws Exception
	{
		Type sType = CompUtils.getTypeForSize(destSource.getSize(), true);
		String assembly = "";
		String label1 = "__L1" + destSource.getSize() + "_" + "_footer";
		// First, check flag from header
		assembly += whitespace + "TYA\n";
		assembly += whitespace + "BEQ\t" + label1 + "\n";
		// If it was positive then only one of the operands was negative so the result is negative too.
		assembly += new UnaryExpressionNode(null, "-", new DummyExpressionNode(null, sType, source)).getAssembly(whitespace.length(), destSource);
		assembly += whitespace + label1 + ":\n";
		
		return assembly;
	}
}
