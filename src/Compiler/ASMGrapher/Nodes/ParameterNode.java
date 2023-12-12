// Created by Iacon1 on 11/30/2023.
// Node for a parameter

package Compiler.ASMGrapher.Nodes;

import Compiler.ASMGrapher.Address;
import Grammar.C816.C816Parser.AddressContext;
import Grammar.C816.C816Parser.ParameterContext;
import Logging.Logging;

public class ParameterNode extends ASMNode<ParameterContext>
{
	private boolean referencesX, referencesY, referencesS;
	private boolean isImmediate;
	private Address address;
	private int immValue;
	
	public ParameterNode()
	{
		super(-1); // TODO
		address = null;
	}

	@Override
	public ParameterNode interpret(ParameterContext node) throws Exception
	{
		if (node.getText().contains("X"))
			referencesX = true;
		if (node.getText().contains("Y"))
			referencesX = true;
		if (node.getText().contains("S"))
			referencesS = true;
		if (node.getText().contains("#"))
			isImmediate = true;

		if (node.address().size() > 0)
		{
			AddressContext c = node.address().get(0);
			if (c.Symbol() != null)
			{
				String symbol = c.Symbol().getText();
				int offset = 0;
				if (c.Number() != null)
					offset = procNumber(c.Number());
				address = new Address(symbol, offset);
			}
			else if (c.Number() != null)
			{
				int addr = procNumber(c.Number());
				
				address = new Address(addr);
				if (isImmediate)
					immValue = addr;
			}
			else
				address = new Address(c.getText());
		}
		return this;
	}

	@Override
	public byte affectingRegisters()
	{
		if (referencesX) return InstructionNode.registerX;
		if (referencesY) return InstructionNode.registerY;
		if (referencesS) return InstructionNode.registerS;
		return 0;
	}

	@Override
	public byte affectingFlags()
	{
		if (referencesX) return InstructionNode.flagX;
		if (referencesY) return InstructionNode.flagX;
		return 0;
	}

	@Override
	public boolean affectedByParameter()
	{
		return !isImmediate;
	}

	@Override
	public byte affectedRegisters() {return 0;}

	@Override
	public byte affectedFlags() {return 0;}

	@Override
	public boolean affectsParameter() {return false;}

	@Override
	public Address getAddress()
	{
		return address;
	}

	@Override
	public ASMType getType() {return null;}
	
	@Override
	public int getImmediate()
	{
		return immValue;
	}
	
	
}
