// By Iacon1
// Created 01/18/2024
// Initializes a variable
package C99Compiler.CompilerNodes.Declarations;

import java.util.LinkedHashMap;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Dummies.DummyExpressionNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Expressions.AssignmentExpressionNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.PrimaryExpressionNode;
import C99Compiler.CompilerNodes.Interfaces.AssemblableNode;
import C99Compiler.CompilerNodes.Interfaces.SequencePointNode;
import C99Compiler.CompilerNodes.Interfaces.TypedNode;
import C99Compiler.ProgramState.ProgramState;
import C99Compiler.Utils.AssemblyUtils.ByteCopier;
import C99Compiler.Utils.OperandSources.ConstantSource;
import Grammar.C99.C99Parser.InitializerContext;
import Shared.Assemblable;

public class InitializerNode extends InterpretingNode<InitializerNode, InitializerContext> implements AssemblableNode, TypedNode, SequencePointNode
{
	private Type type;
	private BaseExpressionNode<?> expr;
	private InitializerListNode list;
	
	private LinkedHashMap<ComponentNode<?>, Assemblable> assemblableQueue;

	@Override public boolean isSequencePoint() {return true;}
	@Override public void registerAssemblable(ComponentNode<?> owner, Assemblable assemblable)
	{
		assemblableQueue.put(owner, assemblable);
	}
	@Override public void clearAssemblables() {assemblableQueue.clear();}
	@Override public AssemblyStatePair getRegisteredAssemblyAndState(ProgramState state) throws Exception
	{
		String assembly = "";
		for (Assemblable queued : assemblableQueue.values())
		{
			AssemblyStatePair pair = queued.getAssemblyAndState(state);
			assembly += pair.assembly;
			state = pair.state;
		}
		
		return new AssemblyStatePair(assembly, state);
	}
	
	public InitializerNode(ComponentNode<?> parent, Type type, String literal)
	{
		super(parent);
		this.type = type;
		expr = new DummyExpressionNode(this, type, literal);
		list = null;
		
		assemblableQueue = new LinkedHashMap<ComponentNode<?>, Assemblable>();
	}
	
	public InitializerNode(ComponentNode<?> parent, Type type)
	{
		super(parent);
		this.type = type;
		expr = null;
		list = null;
		assemblableQueue = new LinkedHashMap<ComponentNode<?>, Assemblable>();
	}
	
	public InitializerNode(ComponentNode<?> parent, Type type, Object obj)
	{
		super(parent);
		this.type = type;
		expr = new DummyExpressionNode(this, type, obj);
		list = null;
		assemblableQueue = new LinkedHashMap<ComponentNode<?>, Assemblable>();
	}
	
	@Override
	public InitializerNode interpret(InitializerContext node) throws Exception
	{
		if (node == null)
			return null;
		if (node.assignment_expression() != null)
			expr = new AssignmentExpressionNode(this).interpret(node.assignment_expression());
		else if (node.initializer_list() != null)
			list = new InitializerListNode(this, type).interpret(node.initializer_list());
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
		if (expr != null)
			return expr.canCall(state, function);
		else
			return list.canCall(state, function);
	}
	@Override
	public boolean hasPropValue(ProgramState state)
	{
		if (expr != null)
			return expr.hasPropValue(state);
		else
			return list.hasPropValue(state);
	}
	@Override
	public Object getPropValue(ProgramState state)
	{
		if (expr != null)
			return expr.getPropValue(state);
		else
			return list.getPropValue(state);
	}
	@Override
	public boolean hasAssembly(ProgramState state)
	{
		return true;
	}
	@Override
	public ProgramState getStateBefore(ProgramState state, ComponentNode<?> child) throws Exception
	{
		if (expr != null)
			return expr.getStateBefore(state, child);
		else
			return list.getStateBefore(state, child);
	}
	
	// Check if string literal
	public boolean checkStringLiteral()
	{
		if (expr == null) return false;
		if (!PrimaryExpressionNode.class.isAssignableFrom(expr.getClass())) return false;
		PrimaryExpressionNode n = (PrimaryExpressionNode) expr;
		return n.isStringLiteral();
	}
	
	public int checkStringLiteralSize()
	{
		if (expr == null) return 0;
		if (!PrimaryExpressionNode.class.isAssignableFrom(expr.getClass())) return 0;
		PrimaryExpressionNode n = (PrimaryExpressionNode) expr;
		return n.getSize();
	}
	
	public void checkKillStringLiteral()
	{
		if (expr == null) return;
		if (!PrimaryExpressionNode.class.isAssignableFrom(expr.getClass())) return;
		PrimaryExpressionNode n = (PrimaryExpressionNode) expr;
		n.killStringLiteralNode();
	}
	
	BaseExpressionNode<?> getExpr() // For EMBED purposes in InitializerListNode
	{
		return expr;
	}
	
	@Override
	public AssemblyStatePair getAssemblyAndState(ProgramState state) throws Exception
	{
		clearAssemblables();
		AssemblyStatePair pair1 = new AssemblyStatePair("", state), pair2;
		if (expr != null)
		{
			if (expr.hasAssembly(state))
				pair1 = expr.getAssemblyAndState(state);
			else if (expr.hasPropValue(state))
			{
				ConstantSource source = new ConstantSource(expr.getPropValue(state), state.destSource().getSize());
				pair1 = new ByteCopier(
						state.destSource().getSize(),
						state.destSource(), 
						source).getAssemblyAndState(state);
			}
				
		}
		else if (list != null)
			pair1 = list.getAssemblyAndState(state);
		pair2 = getRegisteredAssemblyAndState(pair1.state);
		
		return new AssemblyStatePair(pair1.assembly + pair2.assembly, pair2.state);
	}
}
