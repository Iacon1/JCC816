// Created by Iacon1 on 10/19/2023.
//

package Compiler.ComponentNodes.Definitions;

import Compiler.CompConfig;
import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.Globals;
import Compiler.ComponentNodes.InterpretingNode;
import Compiler.ComponentNodes.Dummies.EnumeratorNode;
import Compiler.ComponentNodes.Expressions.BaseExpressionNode;
import Compiler.ComponentNodes.Expressions.ConstantExpressionNode;
import Compiler.ComponentNodes.Interfaces.NamedNode;
import Compiler.Exceptions.ConstraintException;
import Grammar.C99.C99Parser.Enum_specifierContext;
import Grammar.C99.C99Parser.EnumeratorContext;

public class EnumDefinitionNode extends InterpretingNode<EnumDefinitionNode, Enum_specifierContext> implements NamedNode
{
	private String name;
	
	static int unnamedEnums = 0;
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
		{
			name = "__" + unnamedEnums + "enum";
			unnamedEnums += 1;
		}
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
			
			Globals.registerEnumerator(new EnumeratorNode(this, enumerator.Identifier().getText(), value));
		}
		
		Globals.registerEnum(this);
		return this;
	}
	@Override
	public String getName()
	{
		return name;
	}
}
