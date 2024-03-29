// Created by Iacon1 on 10/20/2023.
//
package C99Compiler.CompilerNodes.Declarations;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Definitions.Type;
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
		
		if (declarator != null)
			type = Type.manufacture(specifiers.getSpecifiers(), declarator, node.start);
		else
			type = new Type(specifiers.getSpecifiers(), this, node.start);
		return this;
	}

	public Type getType() {return type;}
}
