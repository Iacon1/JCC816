// Created by Iacon1 on 11/30/2023.
//
package C99Compiler.ASMGrapher.Nodes;

import C99Compiler.ASMGrapher.Value;
import Grammar.C816.C816Parser.InstructionContext;

public class InstructionNode extends ASMNode<InstructionContext>
{
	public static final byte registerA = 0x01,
			registerX = 0x02,
			registerY = 0x04,
			registerS = 0x08,
			registerB = 0x10,
			registerD = 0x20,
			registerK  =0x40,
			registerP = (byte) 0x80;
	public static final byte flagC = 0x01,
		flagZ = 0x02,
		flagI = 0x04,
		flagD = 0x08,
		flagX = 0x10,
		flagM = 0x20,
		flagV = 0x40,
		flagN = (byte) 0x80;
		
	private Operation operation;
	private ParameterNode parameter;

	public InstructionNode(int lineNumber)
	{
		super(lineNumber);
		operation = null;
	}

	@Override
	public InstructionNode interpret(InstructionContext node) throws Exception
	{
		operation = Operation.valueOf(node.Operation().getText());
		lineNo = node.start.getLine();
		if (node.parameter() != null) parameter = new ParameterNode().interpret(node.parameter());
		else parameter = null;
		return this;
	}

	@Override
	public byte affectingRegisters()
	{
		if (parameter != null)
			return (byte) (operation.affectingRegisters() | parameter.affectingRegisters());
		else return operation.affectingRegisters();
	}

	@Override
	public byte affectingFlags()
	{
		if (parameter != null)
			return (byte) (operation.affectingFlags() | parameter.affectingFlags());
		else return operation.affectingFlags();
	}

	@Override
	public boolean affectedByParameter()
	{
		if (parameter != null)
			return operation.affectedByParameter() && parameter.affectedByParameter(); // if immediate then not
		else
			return false; // Can't if no parameter present
	}

	@Override
	public byte affectedRegisters()
	{
		return operation.affectedRegisters();
	}

	@Override
	public byte affectedFlags()
	{
		if ((operation == Operation.REP || operation == Operation.SEP))
			return (byte) parameter.getImmediate();
		return operation.affectedFlags();
	}

	@Override
	public boolean affectsParameter()
	{
		return operation.affectsParameter();
	}

	@Override
	public Value getValue()
	{
		return parameter.getValue();
	}
	@Override
	public int getImmediate()
	{
		return parameter.getImmediate();
	}
	
	@Override
	public ASMType getType()
	{
		switch (operation)
		{
		case JMP: case BRA: case BRL: return ASMType.jump;
		case JML : case JSL: case JSR: return ASMType.jumpSub;
		case BEQ: case BNE: case BCC: case BCS: return ASMType.branch;
		case REP: case SEP: return ASMType.REPSEP;
		case LDA: case LDX: case LDY: return ASMType.load;
		case STA: case STX: case STY: return ASMType.store;
		default: return ASMType.other;
		}
	}

	@Override
	public int getSize()
	{
		if (parameter != null) return 1 + parameter.getSize();
		else return 1;
	}

}
