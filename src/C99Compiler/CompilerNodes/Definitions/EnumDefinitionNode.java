// Created by Iacon1 on 10/19/2023.
//

package C99Compiler.CompilerNodes.Definitions;

import java.util.UUID;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Dummies.EnumeratorNode;
import C99Compiler.CompilerNodes.Expressions.BaseExpressionNode;
import C99Compiler.CompilerNodes.Expressions.ConstantExpressionNode;
import C99Compiler.CompilerNodes.Interfaces.NamedNode;
import C99Compiler.Exceptions.ConstraintException;
import Grammar.C99.C99Parser.Enum_specifierContext;
import Grammar.C99.C99Parser.EnumeratorContext;

public class EnumDefinitionNode extends InterpretingNode<EnumDefinitionNode, Enum_specifierContext> implements NamedNode
{
	private String name;
	
	public EnumDefinitionNode(ComponentNode<?> parent)
	{
		super(parent);
		name = null;
	}
	@Override
	public EnumDefinitionNode interpret(Enum_specifierContext node) throws Exception
	{
		if (node.Identifier() != null) name = node.Identifier().getText();
		else
			name = "__" + UUID.randomUUID() + "enum";
		int value = -1;
		for (EnumeratorContext enumerator : node.enumerator_list().enumerator())
		{
			if (enumerator.constant_expression() != null) // Has constant expression
			{
				BaseExpressionNode<?> constant = new ConstantExpressionNode(this).interpret(enumerator.constant_expression());
				if (!constant.getType().isArithmetic() || constant.getSize() > CompConfig.sizeOf("char")) // Must be char
					throw new ConstraintException("6.7.2.2", 2, enumerator.start);
				value = (int) constant.getPropLong();
			}
			else value++; // If value not specified, use value of previous + 1
			
			new EnumeratorNode(this, enumerator.Identifier().getText(), value);
		}
		
		return this;
	}
	@Override
	public String getName()
	{
		return name;
	}
}
