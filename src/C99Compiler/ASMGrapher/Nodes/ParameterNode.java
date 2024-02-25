// Created by Iacon1 on 11/30/2023.
// Node for a parameter

package C99Compiler.ASMGrapher.Nodes;

import C99Compiler.ASMGrapher.Address;
import C99Compiler.Utils.CompUtils;
import Grammar.C816.C816Parser.AddressContext;
import Grammar.C816.C816Parser.ParameterContext;
import Logging.Logging;

public class ParameterNode extends ASMNode<ParameterContext>
{
	private boolean referencesX, referencesY, referencesS;
	private boolean isImmediate;
	private Address address;
	private int immValue;
	private int size;
	
	public ParameterNode()
	{
		super(-1); // TODO
		address = null;
	}

	@Override
	public ParameterNode interpret(ParameterContext node) throws Exception
	{
		lineNo = node.start.getLine();
		String upper = node.getText().toUpperCase();
		if (upper.contains(",X"))
			referencesX = true;
		if (upper.contains(",Y"))
			referencesY = true;
		if (upper.contains(",S"))
			referencesS = true;
		if (upper.contains(",#"))
			isImmediate = true;

		if (node.address().size() > 0)
		{
			AddressContext c = node.address().get(0);
			if (c.Symbol() != null)
			{
				String symbol = c.Symbol().getText();
				size = CompUtils.isInZeroPage(symbol) ? 1 : 3; // Todo 2-byte address?
				int offset = 0;
				if (c.Number() != null)
				{
					offset = procNumber(c.Number());
					size = Math.max(size, sizeOfNumber(c.Number()));
				}
				address = new Address(symbol, offset);
			}
			else if (c.Number() != null)
			{
				int addr = procNumber(c.Number());
				size = sizeOfNumber(c.Number());
				address = new Address(addr);
				if (isImmediate)
					immValue = addr;
			}
			else
			{
				address = new Address(c.getText());
				size = CompUtils.isInZeroPage(c.getText()) ? 1 : 3; // Todo 2-byte address?
			}
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

	@Override
	public int getSize()
	{
		return size;
	}
}
