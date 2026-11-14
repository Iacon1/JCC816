// By Iacon1
// Created 10/27/2026
// List of initializers

package C99Compiler.CompilerNodes.Declarations;

import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedHashMap;
import java.util.Map;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Definitions.ArrayType;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Dummies.DummyLValueNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.UnaryExpressionNode;
import C99Compiler.CompilerNodes.Expressions.AssignmentExpressionNode;
import C99Compiler.CompilerNodes.Interfaces.AssemblableNode;
import C99Compiler.CompilerNodes.Interfaces.TypedNode;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.ProgramState.ProgramState;
import C99Compiler.Utils.OperandSources.ConstantSource.ConstList;
import C99Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Assignment_expressionContext;
import Grammar.C99.C99Parser.DesignationContext;
import Grammar.C99.C99Parser.InitializerContext;
import Grammar.C99.C99Parser.Initializer_listContext;

public class InitializerListNode extends InterpretingNode<InitializerListNode, Initializer_listContext> implements AssemblableNode, TypedNode
{
	private Type type;

	LinkedHashMap<DesignationNode, InitializerNode> initMap;
	
	public InitializerListNode(ComponentNode<?> parent, Type type)
	{
		super(parent);
		this.type = type;
		
		initMap = new LinkedHashMap<DesignationNode, InitializerNode>();
	}

	private int countElements(Initializer_listContext node) throws Exception
	{
		// Find highest index
		DesignationNode currDes;
		
		int maxIndex = 0;
		int currIndex = 0;
		
		for (int i = 0; i < node.getChildCount(); ++i)
		{
			Object child = node.getChild(i);
			if (DesignationContext.class.isAssignableFrom(child.getClass()))
			{
				currDes = new DesignationNode(this).interpret((DesignationContext) child);
				currIndex = currDes.getIndex();
				removeChild(currDes);
				
				maxIndex = (maxIndex < currIndex) ? currIndex : maxIndex;
				i += 1; // Skip over initializers that follow designations for this search
			}
			else if (InitializerContext.class.isAssignableFrom(child.getClass())) // Might be EMBED
			{
				// Is it an embed?
				Assignment_expressionContext grandchild = ((InitializerContext) child).assignment_expression();
				if (grandchild != null)
				{
					BaseExpressionNode<?> n = new AssignmentExpressionNode(this).interpret(grandchild);
					if (UnaryExpressionNode.class.isAssignableFrom(n.getClass()) && ((UnaryExpressionNode) n).isEMBED())
					{
						// EMBED
						int l = n.getSize();
						currIndex += l - 1;
					}
					removeChild(n);	
				}

				maxIndex = (maxIndex < currIndex) ? currIndex : maxIndex;
				currIndex += 1;
			}
		}
		
		return maxIndex + 1;				
	}
	
	@Override
	public InitializerListNode interpret(Initializer_listContext node) throws Exception
	{
		DesignationNode currDes;
		InitializerNode init;
		
		if (type.isArray() && type.isIncomplete()) // Must complete type
			((ArrayType) type).setLength(countElements(node));

		currDes = new DesignationNode(this, type);
		
		while (!currDes.atEnd(type))
		{
			initMap.put(currDes, new InitializerNode(this, currDes.resolve(type), 0));
			currDes = currDes.getIterated(type);
		}
		initMap.put(currDes, new InitializerNode(this, currDes.resolve(type), 0));
		
		currDes = new DesignationNode(this, type);
		
		for (int i = 0; i < node.getChildCount(); ++i)
		{
			Object child = node.getChild(i);
			if (DesignationContext.class.isAssignableFrom(child.getClass()))
				currDes = new DesignationNode(this).interpret((DesignationContext) child);
			else if (InitializerContext.class.isAssignableFrom(child.getClass())) // Initializer
			{
				init = new InitializerNode(this, currDes.resolve(type)).interpret((InitializerContext) child);
				
				// If init is an EMBED we have to split into different elements

				if (
						init.getExpr() != null &&
						UnaryExpressionNode.class.isAssignableFrom(init.getExpr().getClass()) &&
						((UnaryExpressionNode) init.getExpr()).isEMBED())
				{
					UnaryExpressionNode uno = (UnaryExpressionNode) init.getExpr();
					
					byte[] unoBytes = (byte[]) uno.getPropValue(new ProgramState());
					Type unoType = ((ArrayType) uno.getType()).getType();
					if (unoBytes.length > 0) // Insert first element
					{
						init = new InitializerNode(this, unoType, Long.valueOf(unoBytes[0]));
						if (initMap.get(currDes) != null)
							initMap.remove(currDes);
						initMap.put(currDes, init);
					}
					currDes = currDes.getIterated(type); // Always inc size by at least 1
					
					for (int j = 1; j < unoBytes.length; ++j)
					{
						init = new InitializerNode(this, unoType, Long.valueOf(unoBytes[j]));
						if (initMap.get(currDes) != null)
							initMap.remove(currDes);
						initMap.put(currDes, init);
						currDes = currDes.getIterated(type);
					}						
				}
				else
				{
					if (initMap.get(currDes) != null)
						initMap.remove(currDes);
					initMap.put(currDes, init);
					currDes = currDes.getIterated(type);
				}
			}
		}
		
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
			list.add(new SimpleEntry<Integer, Object>(init.getSize(), init.getPropValue(state)));
		
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
		for (Map.Entry<DesignationNode, InitializerNode> init : initMap.sequencedEntrySet())
		{
			OperandSource s = init.getKey().resolve(n).getSource();
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
