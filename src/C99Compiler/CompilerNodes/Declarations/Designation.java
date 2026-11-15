// By Iacon1
// Created 10/27/2026
// Initializer designator list

package C99Compiler.CompilerNodes.Declarations;

import java.util.List;
import java.util.LinkedList;

import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.ConstantExpressionNode;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.CompilerNodes.LValues.IndexLValueNode;
import C99Compiler.ProgramState.ProgramState;
import C99Compiler.Utils.OperandSources.ConstantSource;
import Grammar.C99.C99Parser.DesignationContext;
import Grammar.C99.C99Parser.DesignatorContext;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Definitions.ArrayType;

class Designation
{
	private List<Object> designators;
	
	public Designation()
	{
		this.designators = new LinkedList<Object>();
	}
	private Designation(Designation designation)
	{
		this.designators = new LinkedList<Object>(designation.designators);
	}
	public static Designation interpret(ComponentNode<?> parent, ProgramState state, DesignationContext node) throws Exception
	{
		Designation designation = new Designation();
		designation.designators = new LinkedList<Object>();
		for (int i = 0; i < node.designator_list().designator().size(); ++i)
		{
			DesignatorContext d = node.designator_list().designator(i);
			
			if (d.constant_expression() != null)
			{
				BaseExpressionNode<?> tmp = new ConstantExpressionNode(parent).interpret(d.constant_expression());
				designation.designators.add(tmp.getPropValue(state));
				parent.removeChild(tmp); // Save on memory
			}
			else if (d.identifier() != null)
				designation.designators.add(d.identifier().getText());
		}
		
		return designation;
	}
	
	/**
	 *  Get the type the designation points to.
	 * @param base The base type that an empty designation would point to.
	 * @return The type this designation points to.
	 */
	public Type resolve(Type base)
	{
		if (designators.size() > 0)
		{
			Designation child = new Designation(this);

			if (base.isArray()) // Array
				base = ((ArrayType) base).getType();
			else // Struct
				base = base.getStruct().getMember((String) child.designators.get(0)).getType();
			
			child.designators.removeFirst();
			
			return child.resolve(base);
		}
		else
			return base;
	}
	/**
	 *  Get an L-value type the designation points to.
	 * @param base The base LValue that an empty designation would point to.
	 * @return The LValue this designation points to.
	 */
	public LValueNode<?> resolve(ComponentNode<?> parent, LValueNode<?> base)
	{
		if (designators.size() > 0)
		{
			Designation child = new Designation(this);
			Object obj = child.designators.removeFirst();
			
			if (base.getType().isArray()) // Array
			{
				Type type = ((ArrayType) base.getType()).getType();
				
				long i = (Long) obj;
				return child.resolve(parent, new IndexLValueNode(parent, type, base.getSource(), new ConstantSource(i, 2)));
			}
			else // Struct
			{
				String name = (String) obj;
				return child.resolve(parent, base.getType().getStruct().getMember(name).getInstance(base));
			}
		}
		else
			return base;
	}
	
	/**
	 * Gets all the  designations immediately below this one.
	 * @param base The base type, i. e. what an empty designation would be.
	 * @return The designations that are immediately contained by this designation.
	 */
	public List<Designation> getChildren(Type base)
	{
		List<Designation> list = new LinkedList<Designation>();
		Designation tmp;
		Type type = resolve(base);
		
		if (type.isArray()) // Array
		{
			long n = type.getSize();
			for (long i = 0; i < n; ++i)
			{
				tmp = new Designation(this);
				tmp.designators.add(i);

				list.add(tmp);
			}
		}
		else if (type.isStructOrUnion())
		{
			for (int i = 0; i < type.getStruct().getMemberNames().size(); ++i)
			{
				String name = type.getStruct().getMemberNames().get(i);
			
				tmp = new Designation(this);
				tmp.designators.add(name);
				
				list.add(tmp);
			}
		}
		
		return list;
	}
	
	/**
	 * Gets all the "leaf" designations (ones that refer to primitives) that could be used to make up this one.
	 * @param base The base type, i. e. what an empty designation would be.
	 * @return The "leaf" designations that are contained by this designation.
	 */
	public List<Designation> getAllLeaves(Type base)
	{
		List<Designation> list = new LinkedList<Designation>();
		Designation tmp;
		Type type = resolve(base);
		
		if (type.isArray()) // Array
		{
			long n = ((ArrayType) type).getLength();
			for (long i = 0; i < n; ++i)
			{
				tmp = new Designation(this);
				tmp.designators.add(i);

				list.addAll(tmp.getAllLeaves(base));
			}
		}
		else if (type.isStructOrUnion())
		{
			for (int i = 0; i < type.getStruct().getMemberNames().size(); ++i)
			{
				String name = type.getStruct().getMemberNames().get(i);
			
				tmp = new Designation(this);
				tmp.designators.add(name);
				
				list.addAll(tmp.getAllLeaves(base));
			}
		}
		else // Primitive, i. e. leaf
			list.add(this);
		
		return list;
	}
	
	/**
	 * Gets the next designation possible.
	 * @param base The base type, i. e. what an empty designation would be.
	 * @param checkLimits Whether to check the limits of the array.
	 * @return The next designation, or null if there isn't one.
	 */
	public Designation getNext(Type base, boolean checkLimits)
	{	
		if (designators.size() == 0)
			return null;
	
		Designation tmp = new Designation(this);
		Object obj = tmp.designators.removeLast();
		Type type = tmp.resolve(base); // Type of parent
		
		if (type.isArray()) // Array
		{
			long n = (long) obj;
			n += 1;
			if (!checkLimits || n < ((ArrayType) type).getLength())
			{
				tmp.designators.add(n);
				return tmp;
			}
			else
				return tmp.getNext(base);
		}
		else if (type.isStructOrUnion())
		{
			String name = (String) obj;
			int n = type.getStruct().getMemberNames().size();

			for (int i = 0; i < n; ++i)
			{
				if (name.equals(type.getStruct().getMemberNames().get(i)) && i != n - 1)
				{
					tmp.designators.add(type.getStruct().getMemberNames().get(i + 1));
					return tmp;
				}
			}
			
			return tmp.getNext(base);
		}
		// If primitive we shouldn't have been here
		
		return null;
	}
	/**
	 * Gets the next designation possible.
	 * @param base The base type, i. e. what an empty designation would be.
	 * @return The next designation, or null if there isn't one.
	 */
	public Designation getNext(Type base)
	{	
		return getNext(base, true);
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
		if (!Designation.class.isAssignableFrom(other.getClass()))
			return false;
		Designation n = (Designation) other;
		
		if (designators.size() != n.designators.size())
			return false;
		
		for (int i = 0; i < designators.size(); ++i)
		{
			if (!designators.get(i).equals(n.designators.get(i)))
				return false;
		}
		
		return true;
	}
	
	public long getIndex()
	{
		return (Long) designators.get(0);
	}
}
