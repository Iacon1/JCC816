// By Iacon1
// Created 01/18/2024
// Initializes a variable
package C99Compiler.CompilerNodes.Declarations;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.FunctionDefinitionNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Definitions.ArrayType;
import C99Compiler.CompilerNodes.Definitions.StructUnionDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.Type;
import C99Compiler.CompilerNodes.Expressions.AssignmentExpressionNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.ConstantExpressionNode;
import C99Compiler.CompilerNodes.Interfaces.AssemblableNode;
import C99Compiler.CompilerNodes.Interfaces.SequencePointNode;
import C99Compiler.CompilerNodes.Interfaces.TypedNode;
import C99Compiler.CompilerNodes.LValues.LValueNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.Exceptions.ConstraintException;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.AssemblyUtils.DetailsTicket;
import C99Compiler.Utils.OperandSources.ConstantSource;
import Grammar.C99.C99Parser.DesignationContext;
import Grammar.C99.C99Parser.DesignatorContext;
import Grammar.C99.C99Parser.InitializerContext;

public class InitializerNode extends InterpretingNode<InitializerNode, InitializerContext> implements AssemblableNode, TypedNode, SequencePointNode
{
	private LValueNode<?> LValue;
	private Map<Integer, InitializerNode> arrayInitializers;
	private Map<String, InitializerNode> structInitializers;
	
	private BaseExpressionNode<?> expr;
	private List<String> sequenceQueue;
	
	public InitializerNode(ComponentNode<?> parent, LValueNode<?> LValue)
	{
		super(parent);
		expr = null;
		sequenceQueue = new LinkedList<String>();
		if (LValue.getType().isArray())
		{
			arrayInitializers = new LinkedHashMap<Integer, InitializerNode>();
			ArrayType arrayType = (ArrayType) LValue.getType();
			if (!LValue.getType().isExtern() && !arrayType.isIncomplete()) // Length known, not extern
			{
				for (int i = 0; i < arrayType.getLength(); ++i) // Default initializers
					arrayInitializers.put(i, new InitializerNode(this, arrayType.getAtIndex(LValue, i)));
			}
		}
		else if (LValue.getType().isAggregate()) // Aggregate + not array = struct
		{
			structInitializers = new LinkedHashMap<String, InitializerNode>();
			StructUnionDefinitionNode structType = LValue.getType().getStruct();
			if (!LValue.getType().isExtern()) // Not extern
			{
				for (String memberName : structType.getMemberNames()) // Default initializers
					structInitializers.put(memberName, new InitializerNode(this,
							structType.getMember(memberName).getInstance(LValue)));
			}
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
	
	@Override public boolean isSequencePoint() {return true;}
	@Override public void registerSequence(String assembly) {sequenceQueue.add(assembly);}
	@Override public void clearSequence() {sequenceQueue.clear();}
	@Override public String getAccumulatedSequences() {String assembly = ""; for (String queued : sequenceQueue) assembly += queued; return assembly;}
	
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
				if (i == node.initializer_list().getChildCount() - 1 &&
						node.initializer_list().getChild(i).getText().equals(","))
					break; // Last child is comma
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
	public boolean canCall(FunctionDefinitionNode function)
	{
		return expr != null && expr.canCall(function);
	}
	
	@Override
	public Type getType()
	{
		return LValue.getType();
	}
	
	public boolean isROM()
	{
		return LValue.getType().isROM();
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
		clearSequence();
		if (!getScope().isRoot() || !isROM()) // Normal RAM one
		{
			if (expr != null)
			{
				if (expr.hasAssembly())
					return expr.getAssembly(leadingWhitespace, LValue.getSource()) + getAccumulatedSequences();
				else if (expr.hasPropValue())
					return AssemblyUtils.byteCopier(
							AssemblyUtils.getWhitespace(leadingWhitespace),
							LValue.getSize(),
							LValue.getSource(),
							new ConstantSource(expr.getPropValue(), LValue.getSize())) + getAccumulatedSequences();
				else if (expr.hasLValue())
					return AssemblyUtils.byteCopier(
							AssemblyUtils.getWhitespace(leadingWhitespace),
							LValue.getSize(),
							LValue.getSource(),
							expr.getLValue().castTo(getType()).getSource()) + getAccumulatedSequences();
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
			else if (LValue.getType().isStatic()) // Statics are initialized always
				return AssemblyUtils.byteCopier(
					AssemblyUtils.getWhitespace(leadingWhitespace),
					LValue.getSize(),
					LValue.getSource(),
					new ConstantSource(0, LValue.getSize())) + getAccumulatedSequences();
			else return "";
		}
		else // ROM one
		{
			String whitespace = AssemblyUtils.getWhitespace(leadingWhitespace);
			ConstantSource source = new ConstantSource(getPropValue(), LValue.getSize());
			String assembly = whitespace + ((VariableNode) LValue).getFullName() + ":";
			whitespace = AssemblyUtils.getWhitespace(leadingWhitespace + CompConfig.indentSize);
			for (int i = 0; i < source.getSize(); ++i)
			{
				if (i % CompConfig.bytesPerDataLine == 0) // New line needed
					assembly += "\n" + whitespace + ".byte\t";
				assembly += source.getBase(i, new DetailsTicket()).replace("#", "");
				if (i != source.getSize() - 1 && (i + 1) % CompConfig.bytesPerDataLine != 0)
					assembly += ", "; // There will be another and on the same line
			}
			assembly += "\n";
			return assembly;
		}
	}

}
