// Created by Iacon1 on 11/30/2023.
// Node for a parameter

package C99Compiler.ASMGrapher.Nodes;

import C99Compiler.ASMGrapher.Value;
import C99Compiler.Utils.CompUtils;
import Grammar.C816.C816Parser.ParameterContext;
import Grammar.C816.C816Parser.ValueContext;
import Logging.Logging;

public class ParameterNode extends ASMNode<ParameterContext>
{
	private boolean referencesX, referencesY, referencesS;
	private boolean isImmediate;
	private Value value;
	private int immValue;
	private int size;
	
	public ParameterNode()
	{
		super(-1); // TODO
		value = null;
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

		if (node.value().size() > 0)
		{
			ValueNode v = (ValueNode) new ValueNode(lineNo()).interpret(node.value(0));
			value = v.getValue();
			size = v.getSize();
			if (isImmediate)
				immValue = v.getImmediate();
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
	public Value getValue()
	{
		return value;
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
