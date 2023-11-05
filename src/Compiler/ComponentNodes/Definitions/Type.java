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
import Compiler.ComponentNodes.Declarations.DeclarationSpecifiersNode;
import Compiler.ComponentNodes.Declarations.DeclaratorNode;
import Compiler.ComponentNodes.Declarations.DirectDeclaratorNode;
import Compiler.ComponentNodes.Dummies.DummyType;
import Compiler.Exceptions.ConstraintException;
import Compiler.Exceptions.UnsupportedFeatureException;
import Compiler.Utils.CompUtils;

public class Type
{
	private String storageClassSpecifier;
	protected List<String> typeSpecifiers;
	private Set<String> typeQualifiers;
//	private Set<String> functionSpecifiers;
	
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
	
	public Type()
	{
		typeSpecifiers = new LinkedList<String>();
		typeQualifiers = new HashSet<String>();
	}
	public Type(DeclarationSpecifiersNode.DeclSpecifiers specifiers, Token start) throws Exception
	{
//		this.scope = declarator.getScope();
		typeSpecifiers = new LinkedList<String>();
		typeQualifiers = new HashSet<String>();
//		functionSpecifiers = new HashSet<String>();
		
		if (specifiers.storageClassSpecifiers.length > 0)
			storageClassSpecifier = specifiers.storageClassSpecifiers[0];
		for (String specifier : specifiers.typeSpecifiers)
			typeSpecifiers.add(specifier);
		for (String qualifier : specifiers.typeQualifiers)
			typeQualifiers.add(qualifier);
//		for (String qualifier : specifiers.functionSpecifiers)
//			functionSpecifiers.add(qualifier);
		
		// Check constraints
		
		if (specifiers.storageClassSpecifiers.length > 1)
			throw new ConstraintException("6.7.1", 1, start);
			
		boolean isAllowed = false;
		for (List<String> allowedList : allowedTypeSpecLists())
			if (typeSpecifiers.containsAll(allowedList) && allowedList.containsAll(typeSpecifiers))
				isAllowed = true;
		if (!isAllowed)
			throw new ConstraintException("6.7.2", 2, start);
		if (typeSpecifiers.contains("double") || typeSpecifiers.contains("float")) // Floats not supported
			throw new UnsupportedFeatureException("Floating-point numbers", false, start);
		if (typeSpecifiers.contains("_Complex")) // Complex numbers not supported
			throw new UnsupportedFeatureException("Complex numbers", false, start);
	}
	public Type(Type other)
	{
//		this.scope = declarator.getScope();
		typeSpecifiers = new LinkedList<String>();
		typeQualifiers = new HashSet<String>();
//		functionSpecifiers = new HashSet<String>();

		storageClassSpecifier = other.storageClassSpecifier;
		typeSpecifiers.addAll(other.typeSpecifiers);
		typeQualifiers.addAll(other.typeQualifiers);
	}
	
	public static Type manufacture(DeclarationSpecifiersNode.DeclSpecifiers specifiers, DeclaratorNode declaratorNode, Token start) throws Exception
	{
		Type type = new Type(specifiers, start);
		
		if (declaratorNode.pointerQualifiers() != null) // Pointer
			for (int i = declaratorNode.pointerQualifiers().size() - 1; i >= 0; --i)
				type = new PointerType(type, declaratorNode.pointerQualifiers().get(i));
		
		for (DirectDeclaratorNode.DirDeclaratorInfo info : declaratorNode.getInfo()) // Array
		{
			if (info == null) continue;
			if (info.type != DirectDeclaratorNode.Type.array) continue;
			if (info.assignExpr != null && Number.class.isAssignableFrom(info.assignExpr.getPropValue().getClass()))
				type = new ArrayType(type, (int) info.assignExpr.getPropLong());
		}
		
		return type;
	}
	
	public int getSize()
	{
		int baseSize;
		if (isStruct()) baseSize = ComponentNode.resolveStruct(getStructUnionEnumType()).getSize();
		else if (isUnion()) baseSize = ComponentNode.resolveUnion(getStructUnionEnumType()).getSize();
		else if (isEnum()) baseSize = CompUtils.sizeOf("int");
		else baseSize = CompUtils.sizeOf(typeSpecifiers);
		return baseSize;
	}
	
	private String getStructUnionEnumType()
	{
		return typeSpecifiers.get(1);
	}
	
	public boolean canCastTo(Type type) // Defined by 6.5.16.1
	{
		return type.canCastFrom(this);
	}
	public boolean canCastFrom(Type type)
	{
		return
				isArithmetic() && type.isArithmetic() ||
				isStruct() && type.isStruct() || // TODO
				isUnion() && type.isUnion() || // TODO
				isPointer() && type.isPointer() && ((PointerType) this).getType().canCastTo(((PointerType) type).getType()) ||
				isPointer() && type.isPointer() && ((PointerType) this).getType().canCastTo("void") ||
				isPointer() && type.isPointer() && ((PointerType) type).getType().canCastTo("void") ||
				isPointer() && type.isConstant() && type.isInteger() ||
				typeSpecifiers.contains("_Bool") && type.isPointer();
	}
	public boolean canCastTo(String... specifiers)
	{
		return canCastTo(new DummyType(specifiers));
	}
	public boolean canCastFrom(String...specifiers)
	{
		return canCastFrom(new DummyType(specifiers));
	}
	
	public boolean isConstant()
	{
		return typeQualifiers.contains("const");
	}
	public boolean isQualified()
	{
		return typeQualifiers.size() != 0;
	}
	
	public boolean isArray() {return false;} // To be overriden
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
	
	public boolean isInteger()
	{
		return typeSpecifiers.contains("short") || typeSpecifiers.contains("long") || typeSpecifiers.contains("int");
	}
	public boolean isArithmetic()
	{
		return isInteger();
	}
	public boolean isPointer() {return false;} // To be overriden
	public boolean isScalar()
	{
		return isInteger() || isPointer();
	}
	public boolean isAggregate()
	{
		return isArray() || isStruct() || isUnion();
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
