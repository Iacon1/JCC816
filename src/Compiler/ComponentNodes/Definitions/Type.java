// By Iacon1
// Created 05/11/2023
// A type
package Compiler.ComponentNodes.Definitions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.Token;

import Compiler.ComponentNodes.ComponentNode;
import Compiler.ComponentNodes.UtilNodes.DeclarationSpecifiersNode;
import Compiler.ComponentNodes.UtilNodes.DeclaratorNode;
import Compiler.ComponentNodes.UtilNodes.DirectDeclaratorNode;
import Compiler.Exceptions.ConstraintException;
import Compiler.Utils.CompUtils;

public class Type
{
	private String storageClassSpecifier;
	protected List<String> typeSpecifiers;
	private Set<String> typeQualifiers;
//	private Set<String> functionSpecifiers;
	private List<Integer> dimensions;
	
	private static List<String> toList(String... members)
	{
		List<String> list = new LinkedList<String>();
		for (String member : members) list.add(member);
		return list;
	}
	private static List<List<String>> allowedTypeSpecLists() // As per 6.7.2.2
	{
		List<List<String>> allowedLists = new ArrayList<List<String>>();
		allowedLists.add(toList("void"));
		
		allowedLists.add(toList("char"));
		allowedLists.add(toList("signed", "char"));
		allowedLists.add(toList("unsigned", "char"));
		
		allowedLists.add(toList("short"));
		allowedLists.add(toList("short", "int"));
		allowedLists.add(toList("signed", "short"));
		allowedLists.add(toList("signed", "short", "int"));
		allowedLists.add(toList("unsigned", "short"));
		allowedLists.add(toList("unsigned", "short", "int"));
		
		allowedLists.add(toList("int"));
		allowedLists.add(toList("signed"));
		allowedLists.add(toList("signed", "int"));
		allowedLists.add(toList("unsigned"));
		allowedLists.add(toList("unsigned", "int"));
		
		allowedLists.add(toList("long"));
		allowedLists.add(toList("long", "int"));
		allowedLists.add(toList("signed", "long"));
		allowedLists.add(toList("signed", "long", "int"));
		allowedLists.add(toList("unsigned", "long"));
		allowedLists.add(toList("unsigned", "long", "int"));
		
		allowedLists.add(toList("long", "long"));
		allowedLists.add(toList("long", "long", "int"));
		allowedLists.add(toList("signed", "long", "long"));
		allowedLists.add(toList("signed", "long", "long", "int"));
		allowedLists.add(toList("unsigned", "long", "long"));
		allowedLists.add(toList("unsigned", "long", "long", "int"));
		
		allowedLists.add(toList("float"));
		
		allowedLists.add(toList("double"));
		
		allowedLists.add(toList("long", "double"));
		
		allowedLists.add(toList("_Bool"));
		
		allowedLists.add(toList("float", "_Complex"));
		allowedLists.add(toList("double", "_Complex"));
		allowedLists.add(toList("long", "double", "_Complex"));
		
		return allowedLists;
	}
	
	private boolean isStruct()
	{
		return typeSpecifiers.get(0).equals("struct");
	}
	private boolean isUnion()
	{
		return typeSpecifiers.get(0).equals("union");
	}
	private boolean isEnum()
	{
		return typeSpecifiers.get(0).equals("enum");
	}
	private String getStructUnionEnumType()
	{
		return typeSpecifiers.get(1);
	}
	
	public Type()
	{
		typeSpecifiers = new LinkedList<String>();
		typeQualifiers = new HashSet<String>();
		dimensions = new LinkedList<Integer>();
	}
	public Type(DeclarationSpecifiersNode.DeclSpecifiers specifiers, DeclaratorNode declarator, Token start) throws Exception
	{
//		this.scope = declarator.getScope();
		typeSpecifiers = new LinkedList<String>();
		typeQualifiers = new HashSet<String>();
//		functionSpecifiers = new HashSet<String>();
		dimensions = new LinkedList<Integer>();
		
		if (specifiers.storageClassSpecifiers.length > 0)
			storageClassSpecifier = specifiers.storageClassSpecifiers[0];
		for (String specifier : specifiers.typeSpecifiers)
			typeSpecifiers.add(specifier);
		for (String qualifier : specifiers.typeQualifiers)
			typeQualifiers.add(qualifier);
//		for (String qualifier : specifiers.functionSpecifiers)
//			functionSpecifiers.add(qualifier);

		for (DirectDeclaratorNode.DirDeclaratorInfo info : declarator.getInfo())
		{
			if (info == null) continue;
			if (info.type != DirectDeclaratorNode.Type.array) continue;
			if (info.assignExpr != null && Number.class.isAssignableFrom(info.assignExpr.getPropValue().getClass()))
				dimensions.add(((Number) info.assignExpr.getPropValue()).intValue());
		}
		
		// Check constraints
		
		if (specifiers.storageClassSpecifiers.length > 1)
			throw new ConstraintException("6.7.1", 1, start);
			
		boolean isAllowed = false;
		for (List<String> allowedList : allowedTypeSpecLists())
			if (typeSpecifiers.containsAll(allowedList) && allowedList.containsAll(typeSpecifiers))
				isAllowed = true;
		if (!isAllowed)
			throw new ConstraintException("6.7.2", 2, start);
	}
	public Type(Type other)
	{
//		this.scope = declarator.getScope();
		typeSpecifiers = new LinkedList<String>();
		typeQualifiers = new HashSet<String>();
//		functionSpecifiers = new HashSet<String>();
		dimensions = new LinkedList<Integer>();
		
		storageClassSpecifier = other.storageClassSpecifier;
		typeSpecifiers.addAll(other.typeSpecifiers);
		typeQualifiers.addAll(other.typeQualifiers);
		dimensions.addAll(other.dimensions);
	}
	public int getBaseSize()
	{
		int baseSize;
		if (isStruct()) baseSize = ComponentNode.resolveStruct(getStructUnionEnumType()).getSize();
		else if (isUnion()) baseSize = ComponentNode.resolveUnion(getStructUnionEnumType()).getSize();
		else if (isEnum()) baseSize = CompUtils.sizeOf("int");
		else baseSize = CompUtils.sizeOf(typeSpecifiers);
		return baseSize;
	}
	public int getSize()
	{
		int size = getBaseSize();
		for (Integer d : dimensions) size *= d;
		return size;
	}
	
	public boolean isConstant()
	{
		return typeQualifiers.contains("const");
	}
	public boolean isArray()
	{
		return dimensions.size() != 0;
	}
	public boolean canCastTo(Type type)
	{
		return true; // TODO
	}
	public boolean canCastFrom(Type type)
	{
		return type.canCastTo(this);
	}
	public boolean canCastTo(String... specifiers)
	{
		return  false; // TODO
	}
	public boolean canCastFrom(String...specifiers)
	{
		return false; // TODO
	}
	
	public boolean allowsOperator(String operator, Type other)
	{
		switch (operator)
		{
		case "&&": case "||": case "?:": return canCastTo("_Bool");
		default: return canCastTo(other) || canCastFrom(this);
		}
	}
	public String getSignature()
	{
		String signature = "";
		if (storageClassSpecifier != null) signature += storageClassSpecifier + " ";
		for (String specifier : typeSpecifiers) signature += specifier + " ";
		for (String qualifier : typeQualifiers) signature += qualifier + " ";
		for (String specifier : typeSpecifiers) signature += specifier + " ";

		return signature.substring(0, signature.length());
	}
}
