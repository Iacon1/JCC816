// Created by Iacon1 on 10/19/2023.
//

package C99Compiler.CompilerNodes.Definitions;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Dummies.EnumeratorNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.ConstantExpressionNode;
import C99Compiler.CompilerNodes.Interfaces.NamedNode;
import C99Compiler.Exceptions.ConstraintException;
import C99Compiler.Utils.CompUtils;
import C99Compiler.Utils.ProgramState;
import Grammar.C99.C99Parser.Enum_specifierContext;
import Grammar.C99.C99Parser.EnumeratorContext;

public class EnumDefinitionNode extends InterpretingNode<EnumDefinitionNode, Enum_specifierContext> implements NamedNode
{
	private String name;
	private Type type;
	
	public EnumDefinitionNode(ComponentNode<?> parent)
	{
		super(parent);
		name = null;
		type = null;
	}
	@Override
	public EnumDefinitionNode interpret(Enum_specifierContext node) throws Exception
	{
		if (node.identifier() != null) name = node.identifier().getText();
		else
			name = "__" + UUID.randomUUID() + "enum";
		int value = -1;
		int largestValue = 0;
		List<Integer> values = new LinkedList<Integer>();
		boolean isSigned = false;
		for (EnumeratorContext enumerator : node.enumerator_list().enumerator())
		{
			if (enumerator.constant_expression() != null) // Has constant expression
			{
				BaseExpressionNode<?> constant = new ConstantExpressionNode(this).interpret(enumerator.constant_expression());
				if (!constant.getType().isArithmetic())
					throw new ConstraintException("6.7.2.2", 2, enumerator.start);
				value = (int) constant.getPropLong(new ProgramState());
				if (value < 0)
					isSigned = true;
			}
			else value++; // If value not specified, use value of previous + 1
			if (Math.abs(largestValue) < Math.abs(value))
				largestValue = value;
			values.add(value);
		}
		int i = 0;
		if (isSigned)
			type = CompUtils.getSmallestSignedType(largestValue);
		else
			type = CompUtils.getSmallestType(largestValue);
		type.setContext(parent);
		for (EnumeratorContext enumerator : node.enumerator_list().enumerator())
			new EnumeratorNode(this, enumerator.identifier().getText(), values.get(i++));
		return this;
	}
	@Override
	public String getName()
	{
		return name;
	}
	public Type getType()
	{
		return type;
	}
}
