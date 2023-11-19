// Created by Iacon1 on 10/19/2023.
// Variable node
package Compiler.ComponentNodes.LValues;

import java.util.HashSet;
import java.util.Set;

import Compiler.CompConfig.OptimizationLevel;
import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.Definitions.Type;
import Compiler.ComponentNodes.Interfaces.TypedNode;
import Compiler.Utils.OperandSources.OperandSource;

public abstract class LValueNode<C extends LValueNode<C>> extends ComponentNode<C> implements TypedNode
{
	protected Type type;
	
	private boolean hasPossibleValues;
	private Set<Object> possibleValues;
	private Set<LValueNode<?>> influences;
	
	public LValueNode(ComponentNode<?> parent, Type type)
	{
		super(parent);
		this.type = type;
		
		hasPossibleValues = false;
		this.possibleValues = new HashSet<Object>();
		this.influences = new HashSet<LValueNode<?>>();
	}
	@Override
	public Type getType()
	{
		return type;
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
		return OptimizationLevel.isAtLeast(OptimizationLevel.medium) && hasPossibleValues;
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
	
	/** Returns the set of LValues that influence this one.
	 * 
	 * @return The set of LValues that influence this one.
	 */
	public Set<LValueNode<?>> getInfluences()
	{
		return influences;
	}
	public boolean isInfluencedBy(LValueNode<?> node)
	{
		if (influences.contains(node)) return true;
		for (LValueNode<?> influence : influences)
			if (influence.isInfluencedBy(node)) return true;
		return false;
	}
	
	public void clearInfluences()
	{
		influences.clear();
	}
	public void addInfluence(LValueNode<?> node)
	{
		influences.add(node);
	}
	public void setInfluences(Set<LValueNode<?>> influences)
	{
		clearInfluences();
		this.influences.addAll(influences);
	}
	public void setOnlyInfluence(LValueNode<?> node)
	{
		clearInfluences();
		addInfluence(node);
	}
}
