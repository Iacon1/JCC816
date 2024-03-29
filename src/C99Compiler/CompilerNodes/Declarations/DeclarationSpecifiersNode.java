// By Iacon1
// Created 05/11/2023
// Defines a set of variables or types.

package C99Compiler.CompilerNodes.Declarations;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;

import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Definitions.EnumDefinitionNode;
import C99Compiler.CompilerNodes.Definitions.StructUnionDefinitionNode;
import C99Compiler.Exceptions.CompilerMultipleDefinitionException;
import C99Compiler.Exceptions.ConstraintException;
import Grammar.C99.C99Parser.Declaration_specifiersContext;
import Grammar.C99.C99Parser.Function_specifierContext;
import Grammar.C99.C99Parser.Specifier_qualifier_listContext;
import Grammar.C99.C99Parser.Storage_class_specifierContext;
import Grammar.C99.C99Parser.Type_qualifierContext;
import Grammar.C99.C99Parser.Type_specifierContext;

public class DeclarationSpecifiersNode extends InterpretingNode<DeclarationSpecifiersNode, Declaration_specifiersContext>
{
	private List<String> storageClassSpecifiers = new ArrayList<String>();
	private List<String> typeSpecifiers = new ArrayList<String>();
	private List<String> typeQualifiers = new ArrayList<String>();
	private List<String> functionSpecifiers = new ArrayList<String>();
	
	public static class DeclSpecifiers implements Serializable
	{
		public String[] storageClassSpecifiers;
		public String[] typeSpecifiers;
		public String[] typeQualifiers;
		public String[] functionSpecifiers;
	}
	public DeclarationSpecifiersNode(ComponentNode<?> parent)
	{
		super(parent);
		storageClassSpecifiers = new ArrayList<String>();
		typeSpecifiers = new ArrayList<String>();
		typeQualifiers = new ArrayList<String>();
		functionSpecifiers = new ArrayList<String>();
	}
	public DeclarationSpecifiersNode()
	{
		super();
		storageClassSpecifiers = new ArrayList<String>();
		typeSpecifiers = new ArrayList<String>();
		typeQualifiers = new ArrayList<String>();
		functionSpecifiers = new ArrayList<String>();
	}

	public final DeclSpecifiers getSpecifiers()
	{
		DeclSpecifiers specifiers = new DeclSpecifiers();
		specifiers.storageClassSpecifiers = storageClassSpecifiers.toArray(new String[] {});
		specifiers.typeSpecifiers = typeSpecifiers.toArray(new String[] {});
		specifiers.typeQualifiers = typeQualifiers.toArray(new String[] {});
		specifiers.functionSpecifiers = functionSpecifiers.toArray(new String[] {});
		
		return specifiers;
	}
	
	@Override
	public DeclarationSpecifiersNode interpret(Declaration_specifiersContext node) throws Exception
	{
		for (int i = 0; i < node.getChildCount(); ++i)
		{
			ParseTree r = node.getChild(i);
			// Find type of r
			if (r.getClass().equals(Storage_class_specifierContext.class))
				storageClassSpecifiers.add(((Storage_class_specifierContext) r).getText());
			else if (r.getClass().equals(Type_specifierContext.class))
			{
				Type_specifierContext typeSpecifier = (Type_specifierContext) r;
				if (typeSpecifier.struct_or_union_specifier() != null && typeSpecifier.struct_or_union_specifier().struct_declaration_list() != null) // Struct declaration
				{
					StructUnionDefinitionNode definition = new StructUnionDefinitionNode(this).interpret(typeSpecifier.struct_or_union_specifier());
					if (definition.isUnion()) typeSpecifiers.add("union");
					else typeSpecifiers.add("struct");
					typeSpecifiers.add(definition.getName());
				}
				else if (typeSpecifier.enum_specifier() != null && typeSpecifier.enum_specifier().enumerator_list() != null) // Enum declaration
				{
					EnumDefinitionNode definition = new EnumDefinitionNode(this).interpret(typeSpecifier.enum_specifier());
					typeSpecifiers.add("enum");
					typeSpecifiers.add(definition.getName());
				}
				else if (typeSpecifier.struct_or_union_specifier() != null)
				{
					typeSpecifiers.add(typeSpecifier.struct_or_union_specifier().getChild(0).getText());
					typeSpecifiers.add(typeSpecifier.struct_or_union_specifier().getChild(1).getText());
				}
				else if (typeSpecifier.enum_specifier() != null)
				{
					typeSpecifiers.add(typeSpecifier.enum_specifier().getChild(0).getText());
					typeSpecifiers.add(typeSpecifier.enum_specifier().getChild(1).getText());
				}
				else typeSpecifiers.add(((Type_specifierContext) r).getText());
			}
			else if (r.getClass().equals(Type_qualifierContext.class))
				typeQualifiers.add(((Type_qualifierContext) r).getText());
			else if (r.getClass().equals(Function_specifierContext.class))
				functionSpecifiers.add(((Function_specifierContext) r).getText());
		}
		
		// Constraints
		if (storageClassSpecifiers.size() > 1)
			throw new ConstraintException("6.7.1", 2, node.start);
		
		return this;
	}
	public DeclarationSpecifiersNode interpret(Specifier_qualifier_listContext node) throws Exception
	{
		for (int i = 0; i < node.getChildCount(); ++i)
		{
			ParseTree r = node.getChild(i);
			// Find type of r
			if (r.getClass().equals(Storage_class_specifierContext.class))
				storageClassSpecifiers.add(((Storage_class_specifierContext) r).getText());
			else if (r.getClass().equals(Type_specifierContext.class))
			{
				if (((Type_specifierContext) r).struct_or_union_specifier() != null)
				{
					typeSpecifiers.add(((Type_specifierContext) r).struct_or_union_specifier().getChild(0).getText());
					typeSpecifiers.add(((Type_specifierContext) r).struct_or_union_specifier().getChild(1).getText());
				}
				else typeSpecifiers.add(((Type_specifierContext) r).getText());
			}
			else if (r.getClass().equals(Type_qualifierContext.class))
				typeQualifiers.add(((Type_qualifierContext) r).getText());
			else if (r.getClass().equals(Function_specifierContext.class))
				functionSpecifiers.add(((Function_specifierContext) r).getText());
		}
		
		// Constraints
		if (storageClassSpecifiers.size() > 1)
			throw new ConstraintException("6.7.1", 2, node.start);
		
		return this;
	}
	
	public boolean isTypedef()
	{
		return storageClassSpecifiers.contains("typedef");
	}
}
