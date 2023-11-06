// Created by Iacon1 on 11/05/2023.
// Source with adjustable size
package Compiler.Utils.OperandSources;

/**
 * 
 */
public class WrapperSource extends OperandSource
{
	private OperandSource source;
	
	public WrapperSource(OperandSource source, int size)
	{
		super(size, source.isLiteral());
		this.source = source;
	}

	@Override
	public String apply(Integer i, Boolean is16Bit)
	{
		return source.apply(i, is16Bit);
	}

}
