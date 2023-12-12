// Created by Iacon1 on 12/01/2023.
//
package Compiler.ASMGrapher.Nodes;

import Compiler.ASMGrapher.Address;
import Grammar.C816.C816Parser.LabelContext;
public class LabelNode extends ASMNode<LabelContext>
{
	private String name;
	public LabelNode(int lineNumber)
	{
		super(lineNumber);
	}

	@Override
	public ASMNode<LabelContext> interpret(LabelContext node) throws Exception
	{
		if (node.Symbol() != null)
			name = node.Symbol().getText();
		else name = ":";
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
	public Address getAddress() {return new Address(name, 0);}
	@Override
	public int getImmediate() {return 0;}
	
	@Override
	public ASMType getType() {return ASMType.label;}
}
