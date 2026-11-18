// By Iacon1
// Created 10/27/2026
// List of initializers

package C99Compiler.CompilerNodes.Declarations;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Definitions.ArrayType;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Definitions.Type.CastContext;
import C99Compiler.CompilerNodes.Dummies.DummyLValueNode;
import C99Compiler.CompilerNodes.Expressions.UnaryExpressionNode;
import C99Compiler.CompilerNodes.Interfaces.AssemblableNode;
import C99Compiler.CompilerNodes.Interfaces.TypedNode;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.ProgramState.ProgramState;
import C99Compiler.Utils.OperandSources.ConstantSource.ConstList;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.DesignationContext;
import Grammar.C99.C99Parser.InitializerContext;
import Grammar.C99.C99Parser.Initializer_listContext;

public class InitializerListNode extends InterpretingNode<InitializerListNode, Initializer_listContext> implements AssemblableNode, TypedNode
{
	private Type type;

	LinkedHashMap<Designation, InitializerNode> initMap;
	
	public InitializerListNode(ComponentNode<?> parent, Type type)
	{
		super(parent);
		this.type = type;
		
		initMap = new LinkedHashMap<Designation, InitializerNode>();
	}

	private int countElements(Initializer_listContext node) throws Exception
	{
		// Find highest index
		Designation currDes = new Designation().getChildren(type).getFirst();
		
		long maxIndex = 0;
		long currIndex = 0;
		InitializerNode init;
		
		for (int i = 0; i < node.getChildCount(); ++i)
		{
			Object child = node.getChild(i);
			if (DesignationContext.class.isAssignableFrom(child.getClass()))
				currDes = Designation.interpret(this, new ProgramState(), (DesignationContext) child);
			else if (InitializerContext.class.isAssignableFrom(child.getClass())) // Initializer
			{
				InitializerContext initChild = (InitializerContext) child;
				if (initChild.assignment_expression() != null)
					init = new InitializerNode(this).interpret(initChild);
				else
					init = new InitializerNode(this, currDes.resolve(type)).interpret(initChild);
				
				// Handle EMBEDs
				if (init.getExpr() != null &&
						UnaryExpressionNode.class.isAssignableFrom(init.getExpr().getClass()) &&
						((UnaryExpressionNode) init.getExpr()).isEMBED())
				{
					UnaryExpressionNode unoNode = (UnaryExpressionNode) init.getExpr();
					Type unoType = ((ArrayType) init.getType()).getType();
					while (!unoType.canCastTo(currDes.resolve(type), CastContext.assignment))
						currDes = currDes.getChildren(type).get(0);
					
					for (int j = 0; j < unoNode.getSize() - 1; ++j)
						currDes = currDes.getNext(type, false);
				}
				else
					while (!init.canCastTo(currDes.resolve(type), CastContext.assignment))
						currDes = currDes.getChildren(type).get(0);
				
				removeChild(init); // Save memory
			}
			else
				continue;
			
			currIndex = currDes.getIndex();
			maxIndex = (maxIndex < currIndex) ? currIndex : maxIndex;
			currDes = currDes.getNext(type, false);
		}
		
		return (int) maxIndex + 1;				
	}

	@Override
	public InitializerListNode interpret(Initializer_listContext node) throws Exception
	{
		// First, we complete the array.
		if (type.isArray() && type.isIncomplete())
			((ArrayType) type).setLength(countElements(node));
		
		// Next, we figure out all the designations we need.
		Set<Designation> neededDesigs = new HashSet<Designation>();
		neededDesigs.addAll(new Designation().getAllLeaves(type));
		
		// After that, we find all the ones we provide.
		Designation currDes = new Designation();
		if (!currDes.getChildren(type).isEmpty())
			currDes = currDes.getChildren(type).getFirst();
		InitializerNode init;
		
		for (int i = 0; i < node.getChildCount(); ++i)
		{
			Object child = node.getChild(i);
			if (DesignationContext.class.isAssignableFrom(child.getClass()))
				currDes = Designation.interpret(this, new ProgramState(), (DesignationContext) child);
			else if (InitializerContext.class.isAssignableFrom(child.getClass())) // Initializer
			{
				InitializerContext initChild = (InitializerContext) child;
				if (initChild.assignment_expression() != null)
					init = new InitializerNode(this).interpret(initChild);
				else
					init = new InitializerNode(this, currDes.resolve(type)).interpret(initChild);
				
				// Handle EMBEDs
				if (init.getExpr() != null &&
						UnaryExpressionNode.class.isAssignableFrom(init.getExpr().getClass()) &&
						((UnaryExpressionNode) init.getExpr()).isEMBED())
				{
					UnaryExpressionNode unoNode = (UnaryExpressionNode) init.getExpr();
					byte[] unoBytes = (byte[]) unoNode.getPropValue(new ProgramState());
					Type unoType = ((ArrayType) init.getType()).getType();
					while (!unoType.canCastTo(currDes.resolve(type), CastContext.assignment))
						currDes = currDes.getChildren(type).get(0);
					
					for (int j = 0; j < unoBytes.length; ++j)
					{
						neededDesigs.removeAll(currDes.getAllLeaves(type));
						initMap.put(currDes, new InitializerNode(this, unoType, unoBytes[j]));
						currDes = currDes.getNext(type);
					}
				}
				else
				{
					while (!init.canCastTo(currDes.resolve(type), CastContext.assignment))
						currDes = currDes.getChildren(type).get(0);
					
					init.setType(currDes.resolve(type)); // To get around certain constants
					neededDesigs.removeAll(currDes.getAllLeaves(type));
					initMap.put(currDes, init);
					
					currDes = currDes.getNext(type);
				}
			}
		}
		
		// Fill rest with 0s
		for (Designation des : neededDesigs)
			initMap.put(des, new InitializerNode(this, des.resolve(type), 0));
		
		return this;
	}

	@Override
	public Type getType()
	{
		return type;
	}

	@Override
	public boolean canCall(ProgramState state, FunctionDefinitionNode function)
	{
		for (InitializerNode init : initMap.values())
			if (init.canCall(state, function))
				return true;

		return false;
	}

	@Override
	public boolean hasPropValue(ProgramState state)
	{
		for (InitializerNode init : initMap.values())
			if (!init.hasPropValue(state))
				return false;

		return true;
	}

	@Override
	public Object getPropValue(ProgramState state)
	{
		ConstList list = new ConstList();
		for (InitializerNode init : initMap.values())
		{
			Object obj = init.getPropValue(state);
			if (ConstList.class.isAssignableFrom(obj.getClass()))
				list.addAll((ConstList) obj);
			else
				list.add(new SimpleEntry<Integer, Object>(init.getSize(), obj));
		}
		
		return list;
	}

	@Override
	public boolean hasAssembly(ProgramState state)
	{
		return true;
	}

	@Override
	public ProgramState getStateBefore(ProgramState state, ComponentNode<?> child) throws Exception {
		// TODO Auto-generated method stub
		return state;
	}
	
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		MutableAssemblyStatePair pair = new MutableAssemblyStatePair("", state);
		
		LValueNode<?> n = new DummyLValueNode(this, type, state.destSource());
		
		OperandSource s0 = pair.state.destSource();
		for (Map.Entry<Designation, InitializerNode> init : initMap.sequencedEntrySet())
		{
			OperandSource s = init.getKey().resolve(this, n).getSource();
			pair.state = pair.state.setDestSource(s);
			
			AssemblyStatePair p = init.getValue().getAssemblyAndState(pair.state);
			pair.assembly += p.assembly;
			pair.state = p.state;
		}
		
		pair.state = pair.state.setDestSource(s0);
		
		removeChild(n);
		
		return pair.getImmutable();
	}
}
