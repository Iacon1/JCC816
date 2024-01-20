// By Iacon1
// Created 01/18/2024
// Initializes a variable
package Compiler.CompilerNodes.Declarations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import Compiler.CompilerNodes.ComponentNode;
import Compiler.CompilerNodes.InterpretingNode;
import Compiler.CompilerNodes.Definitions.ArrayType;
import Compiler.CompilerNodes.Definitions.StructUnionDefinitionNode;
import Compiler.CompilerNodes.Definitions.Type;
import Compiler.CompilerNodes.Expressions.AssignmentExpressionNode;
import Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import Compiler.CompilerNodes.Expressions.ConstantExpressionNode;
import Compiler.CompilerNodes.Interfaces.AssemblableNode;
import Compiler.CompilerNodes.Interfaces.TypedNode;
import Compiler.CompilerNodes.LValues.LValueNode;
import Compiler.CompilerNodes.LValues.VariableNode;
import Compiler.Exceptions.ConstraintException;
import Compiler.Exceptions.TypeMismatchException;
import Compiler.Utils.AssemblyUtils;
import Compiler.Utils.AssemblyUtils.DetailsTicket;
import Compiler.Utils.ScratchManager;
import Compiler.Utils.OperandSources.ConstantSource;
import Compiler.Utils.OperandSources.OperandSource;
import Grammar.C99.C99Parser.Assignment_expressionContext;
import Grammar.C99.C99Parser.Conditional_expressionContext;
import Grammar.C99.C99Parser.DesignationContext;
import Grammar.C99.C99Parser.DesignatorContext;
import Grammar.C99.C99Parser.InitializerContext;
import Grammar.C99.C99Parser.Unary_expressionContext;

public class InitializerNode extends InterpretingNode<InitializerNode, InitializerContext> implements AssemblableNode, TypedNode
{
	private LValueNode<?> LValue;
	private Map<Integer, InitializerNode> arrayInitializers;
	private Map<String, InitializerNode> structInitializers;
	
	private BaseExpressionNode<?> expr;
	
	public InitializerNode(ComponentNode<?> parent, LValueNode<?> LValue)
	{
		super(parent);
		expr = null;
		if (LValue.getType().isArray())
		{
			arrayInitializers = new LinkedHashMap<Integer, InitializerNode>();
			ArrayType arrayType = (ArrayType) LValue.getType();
			if (!arrayType.isIncomplete()) // Length known
			{
				for (int i = 0; i < arrayType.getLength(); ++i) // Default initializers
					arrayInitializers.put(i, new InitializerNode(this, arrayType.getAtIndex(LValue, i)));
			}
		}
		else if (LValue.getType().isAggregate()) // Aggregate + not array = struct
		{
			structInitializers = new LinkedHashMap<String, InitializerNode>();
			StructUnionDefinitionNode structType = LValue.getType().getStruct();
			for (String memberName : structType.getMemberNames()) // Default initializers
				structInitializers.put(memberName, new InitializerNode(this,
						structType.getMember(memberName).getInstance(LValue)));
		}
		this.LValue = LValue;
	}
	
	private static InitializerNode resolveInitializer(InitializerNode startNode, DesignationContext designation) throws Exception
	{
		InitializerNode currNode = startNode;
		for (DesignatorContext designator : designation.designator_list().designator())
		{
			if (currNode.arrayInitializers != null) // Array
			{
				if (designator.Identifier() != null) // Must be struct to use struct references
					throw new ConstraintException("6.7.8", 7, designator.start);
				
				int index = (int) new ConstantExpressionNode(currNode).interpret(designator.constant_expression()).getPropLong();
				
				if (index > currNode.arrayInitializers.size() && !currNode.LValue.getType().isIncomplete())
					throw new ConstraintException("6.7.8", 6, designator.start); // Array's length is known and this exceeds it
				
				currNode = currNode.arrayInitializers.get(index);
			}
			else
			if (currNode.structInitializers != null) // Struct
			{
				if (designator.constant_expression() != null) // Must be array to use array references
					throw new ConstraintException("6.7.8", 6, designator.start);
				
				String memberName = designator.Identifier().getText();
				
				if (currNode.LValue.getType().getStruct().getMember(memberName) == null)
					throw new ConstraintException("6.7.8", 7, designator.start); // This is not a member of this struct
				
				currNode = currNode.structInitializers.get(memberName);
			}
		}
		
		return currNode;
	}
	@Override
	public InitializerNode interpret(InitializerContext node) throws Exception
	{
		if (node == null) return null;
		if (node.children.size() == 1) // Can't be an initializer, which would at least have brackets
			expr = new AssignmentExpressionNode(this).interpret(node.assignment_expression());
		else
		{
			int arrayIndex = 0;
			int j = 0, k = 0;
			for (int i = 0; i < node.initializer_list().getChildCount(); i += 2)
			{
				if (node.initializer_list().getChild(i) == node.initializer_list().initializer(k)) // Designator not present
				{
					if (arrayInitializers != null)
					{
						if (!LValue.getType().isIncomplete() && arrayIndex >= arrayInitializers.size()) // Too many array indices
							throw new ConstraintException("6.7.8", 6, node.initializer_list().initializer(k).start);
						arrayInitializers.get(arrayIndex++).interpret(node.initializer_list().initializer(k++));
					}
					else if (structInitializers != null)
					{
						if (arrayIndex >= structInitializers.size()) // No more struct members to populate
							throw new ConstraintException("6.7.8", 7, node.initializer_list().initializer(k).start);
						structInitializers.get(LValue.getType().getStruct().getMemberNames().get(arrayIndex++)).interpret(node.initializer_list().initializer(k++));
					}
				}
				else if (node.initializer_list().getChild(i) == node.initializer_list().designation(j)) // Designator present
				{
					DesignatorContext designator0 = node.initializer_list().designation(j).designator_list().designator(0);
					if (designator0.constant_expression() != null) // Skip forward in array list
						arrayIndex = (int) new ConstantExpressionNode(this).interpret(designator0.constant_expression()).getPropLong();
					else if (designator0.Identifier() != null)
						arrayIndex = LValue.getType().getStruct().getMemberNames().indexOf(designator0.Identifier().getText());
					InitializerNode initializer = resolveInitializer(this, node.initializer_list().designation(j++));
					initializer.interpret(node.initializer_list().initializer(k++));
					arrayIndex += 1;
					i += 1;
				}
			}
		}
		
		return this;
	}
	
	@Override
	public Type getType()
	{
		return LValue.getType();
	}
	
	@Override
	public boolean hasAssembly()
	{
		return !LValue.getType().isIncomplete();
	}

	@Override
	public boolean hasPropValue()
	{
		if (expr != null) return expr.hasPropValue();
		else if (LValue.getType().isIncomplete()) return false;
		else if (arrayInitializers != null) // Array
		{
			for (InitializerNode initializer : arrayInitializers.values())
				if (!initializer.hasPropValue()) return false;
			return true;
		}
		else if (structInitializers != null) // Struct
		{
			for (InitializerNode initializer : structInitializers.values())
				if (!initializer.hasPropValue()) return false;
			return true;
		}
		else return true;
	}

	@Override
	public Object getPropValue()
	{
		if (expr != null) return expr.getPropValue();
		else if (arrayInitializers != null) // Array
		{
			List<Object> propVals = new ArrayList<Object>();
			for (InitializerNode initializer : arrayInitializers.values())
				propVals.add(initializer.getPropValue());
			return propVals.toArray();
		}
		else if (structInitializers != null) // Struct
		{
			List<Object> propVals = new ArrayList<Object>();
			for (InitializerNode initializer : structInitializers.values())
				propVals.add(initializer.getPropValue());
			return propVals.toArray();
		}
		else return Long.valueOf(0);
	}

	@Override
	public String getAssembly(int leadingWhitespace) throws Exception
	{
		if (expr != null)
		{
			if (expr.hasAssembly())
				return expr.getAssembly(leadingWhitespace, LValue.getSource());
			else if (expr.hasPropValue())
				return AssemblyUtils.byteCopier(
						AssemblyUtils.getWhitespace(leadingWhitespace),
						LValue.getSize(),
						LValue.getSource(),
						new ConstantSource(expr.getPropValue(), LValue.getSize()));
			else if (expr.hasLValue())
				return AssemblyUtils.byteCopier(
						AssemblyUtils.getWhitespace(leadingWhitespace),
						LValue.getSize(),
						LValue.getSource(),
						expr.getLValue().getSource());
			else return "";
		}	
		else if (arrayInitializers != null) // Array
		{
			String assembly = "";
			for (InitializerNode initializer : arrayInitializers.values())
				assembly += initializer.getAssembly(leadingWhitespace);
			return assembly;
		}
		else if (structInitializers != null) // Struct
		{
			String assembly = "";
			for (InitializerNode initializer : structInitializers.values())
				assembly += initializer.getAssembly(leadingWhitespace);
			return assembly;
		}
		else return AssemblyUtils.byteCopier(
				AssemblyUtils.getWhitespace(leadingWhitespace),
				LValue.getSize(),
				LValue.getSource(),
				new ConstantSource(0, LValue.getSize()));
	}

}
