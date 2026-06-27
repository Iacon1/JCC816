// Created by Iacon1 on 11/23/2025.
// LValue node with a source it uses to index the access
package C99Compiler.CompilerNodes.LValues;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.ValueNode;
import C99Compiler.CompilerNodes.Definitions.Type;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.Dummies.DummyValueNode;
import C99Compiler.Utils.PropPointer;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.IndexOperandSource;
import C99Compiler.Utils.OperandSources.OperandSource;

public class IndexLValueNode extends LValueNode<IndexLValueNode>
{
	private IndexOperandSource source;
	
	public IndexLValueNode(ComponentNode<?> parent, Type type, OperandSource source, OperandSource indexSource)
	{
		super(parent, type);
		this.source = new IndexOperandSource(getSize(), source, indexSource);
	}
	
	@Override
	public OperandSource getSource()
	{
		return source;
	}
	@Override
	public ValueNode<?> castTo(Type type)
	{
		if (this.type.isArray() && !type.isArray()) // Decay array into pointer
			return new DummyValueNode(this, type, new ConstantSource(new PropPointer<IndexLValueNode>(this, 0), CompConfig.pointerSize));
		else return new DummyValueNode(this, type, getSource()); // TODO
	}

	@Override
	public String getAddress(int offset)
	{
		return source.getBase();
	}	
	
}