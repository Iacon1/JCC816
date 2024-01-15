// Created by Iacon1 on 10/20/2023.
//
package Compiler.CompilerNodes.Declarations;

import Compiler.CompilerNodes.ComponentNode;
import Compiler.CompilerNodes.InterpretingNode;
import Compiler.CompilerNodes.Definitions.Type;
import Grammar.C99.C99Parser.Type_nameContext;

public class TypeNameNode extends InterpretingNode<TypeNameNode, Type_nameContext>
{
	private Type type;
	
	public TypeNameNode(ComponentNode<?> parent) {super(parent);}
	
	@Override
	public TypeNameNode interpret(Type_nameContext node) throws Exception
	{
		DeclarationSpecifiersNode specifiers = null;
		DeclaratorNode declarator = null;
		
		if (node.specifier_qualifier_list() != null)
			specifiers = new DeclarationSpecifiersNode(this).interpret(node.specifier_qualifier_list());
		if (node.abstract_declarator() != null)
			declarator = new DeclaratorNode(this).interpret(node.abstract_declarator());
		
		type = Type.manufacture(specifiers.getSpecifiers(), declarator, node.start);
		return this;
	}

	public Type getType() {return type;}
}