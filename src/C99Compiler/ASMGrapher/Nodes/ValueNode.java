// Created by Iacon1 on 03/13/2025.
//
package C99Compiler.ASMGrapher.Nodes;

import C99Compiler.ASMGrapher.Value;
import C99Compiler.Utils.CompUtils;
import Grammar.C816.C816Parser.ValueContext;

public class ValueNode extends ASMNode<ValueContext>
{
	Value value;
	int size;

	public ValueNode(int lineNumber)
	{
		super(lineNumber);
		value = null;
		size = 0;
	}

	@Override
	public ASMNode<ValueContext> interpret(ValueContext node) throws Exception
	{
		if (node.Symbol() != null)
		{
			value = new Value(node.Symbol().getText());
			size = CompUtils.isInZeroPage(node.Symbol().getText()) ? 1 : 3;
		}
		else if (node.Number() != null)
		{
			int n = procNumber(node.Number().getText());
			value = new Value(n);
			size = sizeOfNumber(node.Number());
		}
		else if (node.Length() != null)
		{
			value = new ValueNode(lineNo()).interpret(node.value(0)).getValue();
			switch (node.Length().getText())
			{
			case "f:":
				size = 3;
				break;
			case "a:":
				value = value.mask(0x00FFFF);
				size = 2;
				break;
			case "z:":
				value = value.mask(0x0000FF);
				size = 1;
				break;
			}
		}
		else if (node.PpFunc() != null)
		{
			value = new ValueNode(lineNo()).interpret(node.value(0)).getValue();
			switch (node.PpFunc().getText().toUpperCase())
			{
			case ".LOBYTE":
				value = value.mask(0x000000FF);
				size = 1;
				break;
			case ".LOWORD":
				value = value.mask(0x0000FFFF);
				size = 2;
				break;
			case ".HIBYTE":
				value = value.mask(0x0000FF00);
				size = 1;
				break;
			case ".HIWORD":
				value = value.mask(0xFFFF0000);
				size = 2;
				break;
			case ".BANKBYTE":
				value = value.mask(0x00FF0000);
				size = 1;
				break;
			}
		}	
		else if (node.getChild(0).getText() == ":")
		{
			value = new Value(node.getText());
			size = 1;
		}
		else if (node.getChild(0).getText() == "#")
		{
			ValueNode v = (ValueNode) new ValueNode(lineNo()).interpret(node.value(0));
			value = v.getValue();
			size = v.getSize();
			// TODO
		}
		else if (node.getChild(0).getText() == "(")
			return new ValueNode(lineNo()).interpret(node.value(0));
		else if (node.value().size() == 2)
		{
			ValueNode v1, v2;
			v1 = (ValueNode) new ValueNode(lineNo()).interpret(node.value(0));
			v2 = (ValueNode) new ValueNode(lineNo()).interpret(node.value(1));
			Value value1, value2;
			value1 = v1.getValue();
			value2 = v2.getValue();
			switch (node.getChild(1).getText())
			{
			case "+":
				value = value1.add(value2);
				break;
			case "-":
				value = value1.sub(value2);
				break;
			case "&":
				value = value1.sub(value2);
				break;
			case "<<":
				value = value1.lshift(value2);
				break;
			}
			size = Math.max(v1.getSize(), v2.getSize());
		}
		return this;
	}

	@Override
	public byte affectingRegisters() {throw new UnsupportedOperationException();}

	@Override public byte affectingFlags() {throw new UnsupportedOperationException();}

	@Override public boolean affectedByParameter() {throw new UnsupportedOperationException();}

	@Override public byte affectedRegisters() {throw new UnsupportedOperationException();}

	@Override public byte affectedFlags() {throw new UnsupportedOperationException();}

	@Override public boolean affectsParameter() {throw new UnsupportedOperationException();}

	@Override public Value getValue() {return value;}

	@Override public int getImmediate() {return value.getImmediate();}

	@Override public ASMType getType() {throw new UnsupportedOperationException();}

	@Override public int getSize() {return size;}

}
