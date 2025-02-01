// Created by Iacon1 on 11/09/2024.
//
package C99Compiler.Utils.AssemblyUtils;

import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;

public class ZeroCopier extends ByteCopier
{
	public ZeroCopier(int n, OperandSource sourceTo, boolean reversed)
	{
		super(n, new ConstantSource(0, n), sourceTo, reversed);
	}
	public ZeroCopier(int n, OperandSource sourceTo)
	{
		super(n, new ConstantSource(0, n), sourceTo, false);
	}
}
