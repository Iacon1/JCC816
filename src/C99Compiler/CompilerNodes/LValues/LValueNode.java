// Created by Iacon1 on 10/19/2023.
// Variable node
package C99Compiler.CompilerNodes.LValues;

import java.util.HashSet;
import java.util.Set;

import C99Compiler.CompConfig;
import C99Compiler.CompConfig.OptimizationLevel;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyLValueNode;
import C99Compiler.CompilerNodes.Interfaces.AddressableNode;
import C99Compiler.CompilerNodes.Interfaces.NamedNode;
import C99Compiler.CompilerNodes.Interfaces.TypedNode;
import C99Compiler.Utils.PropPointer;
import C99Compiler.Utils.OperandSources.ConstantSource;
import C99Compiler.Utils.OperandSources.OperandSource;

public abstract class LValueNode<C extends LValueNode<C>> extends ComponentNode<C> implements AddressableNode, TypedNode
{
	protected Type type;
	
	private boolean hasPossibleValues;
	private Set<Object> possibleValues;
	
	public LValueNode(ComponentNode<?> parent, Type type)
	{
		super(parent);
		this.type = type;
		
		hasPossibleValues = false;
		this.possibleValues = new HashSet<Object>();
	}
	@Override
	public Type getType()
	{
		return type;
	}

	
	public LValueNode<?> castTo(Type type)
	{
		if (this.type.isArray() && type.isPointer() && !type.isArray()) // Decay array into pointer
			return new DummyLValueNode(this, type, new ConstantSource(new PropPointer<C>((C) this, 0), CompConfig.pointerSize));
		else return new DummyLValueNode(this, type, getSource()); // TODO
	}	
	
	public int getSize()
	{
		return type.getSize();
	}
	
	public abstract OperandSource getSource();
	
	/** Returns whether it's known what RValues this could equate to.
	 * 
	 * @return Whether it's known what RValues this could equate to.
	 */
	public boolean hasPossibleValues()
	{
		return hasPossibleValues;
	}
	/** Returns the set of RValues this could be equivalent to, or null if that's unknown.
	 * 
	 * @return The set of RValues this could be equivalent to, or null.
	 */
	public Set<Object> getPossibleValues()
	{
		if (hasPossibleValues) return possibleValues;
		else return null;
	}

	public void clearPossibleValues()
	{
		hasPossibleValues = false;
		possibleValues.clear();
	}
	public void setPossibleValues(Set<Object> possibleValues)
	{
		hasPossibleValues = true;
		this.possibleValues.add(possibleValues);
	}
	public void addPossibleValue(Object value)
	{
		hasPossibleValues = true;
		possibleValues.add(value);
	}
	public void setOnlyPossibleValue(Object value)
	{
		clearPossibleValues();
		addPossibleValue(value);
	}
	
	public long getSmallestPossibleLong()
	{
		long l = Long.MAX_VALUE;
		for (Object obj : possibleValues)
		{
			if (Number.class.isAssignableFrom(obj.getClass()))
				l = Math.min(l, ((Number) obj).longValue());
		}
		
		return l;
	}
	
	public long getLargestPossibleLong()
	{
		long l = Long.MIN_VALUE;
		for (Object obj : possibleValues)
		{
			if (Number.class.isAssignableFrom(obj.getClass()))
				l = Math.max(l, ((Number) obj).longValue());
		}
		
		return l;
	}
}
