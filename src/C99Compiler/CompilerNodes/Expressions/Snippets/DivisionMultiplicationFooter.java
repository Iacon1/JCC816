// Created by Iacon1 on 12/12/2023.
//
package C99Compiler.CompilerNodes.Expressions.Snippets;

import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import C99Compiler.Utils.OperandSources.OperandSource;
import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.Expressions.UnaryExpressionNode;
import C99Compiler.CompilerNodes.Interfaces.Assemblable;
import C99Compiler.CompilerNodes.Interfaces.Assemblable.AssemblyStatePair;
import C99Compiler.CompilerNodes.Interfaces.Assemblable.MutableAssemblyStatePair;

//Uses hardware div registers, but only for 8-bit divisor
public class DivisionMultiplicationFooter implements Assemblable
{
	private OperandSource destSource, source;
	
	public DivisionMultiplicationFooter(OperandSource destSource, OperandSource source)
	{
		this.destSource = destSource;
		this.source = source;
	}
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
		Type sType = CompUtils.getTypeForSize(destSource.getSize(), true);
		String label1 = "__L1_" + destSource.getSize() + "_" + "_footer";
		// First, check flag from header
		pair.assembly += pair.state.getWhitespace() + "TYA\n";
		pair.assembly += pair.state.getWhitespace() + "BEQ\t" + label1 + "\n";
		// If it was positive then only one of the operands was negative so the result is negative too.
		pair.state = pair.state.setDestSource(destSource);
		new UnaryExpressionNode(null, "-", new DummyExpressionNode(null, sType, source)).apply(pair);
		pair.assembly += pair.state.getWhitespace() + label1 + ":\n";
		
		return pair.getImmutable();
	}
}
