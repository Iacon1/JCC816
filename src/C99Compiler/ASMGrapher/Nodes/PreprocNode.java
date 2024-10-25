// Created by Iacon1 on 12/01/2023.
//
package C99Compiler.ASMGrapher.Nodes;

import C99Compiler.ASMGrapher.Address;
import Grammar.C816.C816Parser.LabelContext;
import Grammar.C816.C816Parser.PreprocInstructionContext;
public class PreprocNode extends ASMNode<PreprocInstructionContext>
{
	private String[] words;
	private String text;
	public PreprocNode(int lineNumber)
	{
		super(lineNumber);
	}

	@Override
	public ASMNode<PreprocInstructionContext> interpret(PreprocInstructionContext node) throws Exception
	{
		lineNo = node.start.getLine();
		text = node.Preproc().getText();
		words = text.split("[,\s\t]");
		
		return this;
	}

	@Override
	public byte affectingRegisters() {return 0;}

	@Override
	public byte affectingFlags() {return 0;}

	@Override
	public boolean affectedByParameter() {return false;}

	@Override
	public byte affectedRegisters() {return 0;}

	@Override
	public byte affectedFlags() {return 0;}

	@Override
	public boolean affectsParameter() {return false;}

	@Override
	public Address getAddress() {return null;}
	@Override
	public int getImmediate() {return 0;}
	
	@Override
	public ASMType getType() {return ASMType.preproc;}

	@Override
	public int getSize()
	{
		switch (words[0])
		{
		case ".res": return procNumber(words[1]);
		case ".word": return 2;
		case ".byte": return text.length() - text.replace("$", "").length();
		default: return 0;
		}
	}
}
