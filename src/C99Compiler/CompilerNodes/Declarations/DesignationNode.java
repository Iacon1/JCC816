// By Iacon1
// Created 10/27/2026
// Initializer designator list

package C99Compiler.CompilerNodes.Declarations;

import java.util.LinkedList;
import java.util.List;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Definitions.ArrayType;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Expressions.ConstantExpressionNode;
import C99Compiler.CompilerNodes.LValues.IndexLValueNode;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.ProgramState.ProgramState;
import C99Compiler.Utils.OperandSources.ConstantSource;
import Grammar.C99.C99Parser.DesignationContext;
import Grammar.C99.C99Parser.DesignatorContext;

class DesignationNode extends InterpretingNode<DesignationNode, DesignationContext>
{
	private List<Object> designators;
	
	// Return the type the given designators would point to given the base type
	private static Type resolve(Type base, List<Object> designators)
	{
		if (designators.size() > 0)
		{
			if (base.isArray()) // Array
				base = ((ArrayType) base).getType();
			else // Struct
				base = base.getStruct().getMember((String) designators.get(0)).getType();
			
			designators = new LinkedList<Object>(designators);
			designators.removeFirst();
			
			return resolve(base, designators);
		}
		else
			return base;
	}
	
	// Return the Lvalue the given designators would point to given the base Lvalue
	private LValueNode<?> resolve(LValueNode<?> lValue, List<Object> designators)
	{
		if (designators.size() > 0)
		{
			if (lValue.getType().isArray()) // Array
			{
				Type type = ((ArrayType) lValue.getType()).getType();
				
				Number i = (Number) designators.get(0);
				return new IndexLValueNode(this, type, lValue.getSource(), new ConstantSource(i, 2));
			}
			else // Struct
			{
				String i = (String) designators.get(0);
				lValue = lValue.getType().getStruct().getMember(i).getInstance(lValue);
			}
			
			designators = new LinkedList<Object>(designators);
			designators.removeFirst();
			
			return resolve(lValue, designators);
		}
		else
			return lValue;
	}
	
	// Set the designator list to match the first "leaf" of a struct or array that can be reached with the current designator list
	private void digDown(Type base)
	{
		Type type = resolve(base, designators);
		
		while (true)
		{
			if (type.isArray()) // Array
			{
				type = ((ArrayType) type).getType();
				designators.add(Long.valueOf(0));
			}
			else if (type.isStructOrUnion()) // Struct or union
			{
				String name0 = type.getStruct().getMemberNames().get(0);
				type = type.getStruct().getMember(name0).getType();
				designators.add(name0);
			}
			else
				return;
		}
	}
	
	// Return true if we're at the last "leaf" at the current level of the designation
	public boolean atEnd(Type base)
	{
		Object obj;
		Type upType = base;

		if (designators.size() > 1)
		{
			obj = designators.removeLast();
			upType = resolve(base, designators);
			designators.add(obj);
		}
		else if (designators.size() == 0)
			return true;
		else
			obj = designators.getLast();
		
		if (upType.isStructOrUnion())
		{
			List<String> names = upType.getStruct().getMemberNames();
			String str = (String) obj;
			for (int i = 0; i < names.size(); ++i)
			{
				if (names.get(i).equals(str))
					if (i == names.size() - 1)
						return true;
			}
			return false;
		}
		else if (upType.isArray())
			return ((ArrayType) upType).getLength() == 1 + ((Number) obj).longValue();
		else
			return false;
	}
	
	public DesignationNode(ComponentNode<?> parent)
	{
		super(parent);
		designators = new LinkedList<Object>();
	}
	
	public DesignationNode(ComponentNode<?> parent, Type base) // Return first designator possible
	{
		super(parent);
		designators = new LinkedList<Object>();
		digDown(base);
	}
	
	public DesignationNode(ComponentNode<?> parent, List<Object> designators)
	{
		super(parent);
		this.designators = new LinkedList<Object>(designators);
	}
	
	@Override
	public DesignationNode interpret(DesignationContext node) throws Exception
	{
		designators = new LinkedList<Object>();
		
		for (int i = 0; i < node.designator_list().designator().size(); ++i)
		{
			DesignatorContext childNode = node.designator_list().designator(i);
			if (childNode.constant_expression() != null)
				designators.add(new ConstantExpressionNode(this).interpret(childNode.constant_expression()).getPropValue(new ProgramState()));
			else
				designators.add(childNode.identifier().getText());
		}
		
		return this;
	}
	
	public Type resolve(Type base)
	{
		return resolve(base, this.designators);
	}
	public LValueNode<?> resolve(LValueNode<?> lValue)
	{
		return resolve(lValue, this.designators);
	}
	
	@Override
	public int hashCode()
	{
		String s = "";
		for (int i = 0; i < designators.size(); ++i)
			s += String.format("%d", designators.get(i).hashCode()) + ", ";
		
		return s.hashCode();
	}
	@Override
	public boolean equals(Object other)
	{
		if (!DesignationNode.class.isAssignableFrom(other.getClass()))
			return false;
		DesignationNode n = (DesignationNode) other;
		
		if (designators.size() != n.designators.size())
			return false;
		
		for (int i = 0; i < designators.size(); ++i)
		{
			if (!designators.get(i).equals(n.designators.get(i)))
				return false;
		}
		
		return true;
	}
	// Return a designation node pointing to the next element in this type
	// Returns itself if no iteration possible
	public DesignationNode getIterated(Type base)
	{
		DesignationNode n = new DesignationNode(parent, designators);
		
		while (true)
		{
			if (n.designators.isEmpty())
				return n;
			if (n.atEnd(base))
				n.designators.removeLast();
			else
				break;
		}
		Object obj = n.designators.removeLast();
		Type type = resolve(base, n.designators);
		
		if (type.isArray()) // Array
		{
			type = ((ArrayType) type).getType();
			obj = Long.valueOf(1 + ((Number) obj).longValue());
		}
		else if (type.isStructOrUnion()) // Struct or union
		{
			List<String> names = type.getStruct().getMemberNames();
			String str = (String) obj;
			for (int i = 0; i < names.size(); ++i)
			{
				if (names.get(i).equals(str))
					obj = names.get(i + 1);
			}
		}
		n.designators.add(obj);
		n.digDown(base);
		
		return n;
	}
	
	public boolean isEmpty()
	{
		return designators.isEmpty();
	}
	
	// If first designator is a number return it. Else return -1
	public int getIndex()
	{
		if (designators.isEmpty()) return -1;
		Object obj = designators.getFirst();
		if (Number.class.isAssignableFrom(obj.getClass()))
		{
			Number n = (Number) obj;
			return n.intValue();
		}
		
		return -1;
	}
}
