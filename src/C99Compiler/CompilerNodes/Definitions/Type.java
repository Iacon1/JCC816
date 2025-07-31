// By Iacon1
// Created 05/11/2023
// A type
package C99Compiler.CompilerNodes.Definitions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.Token;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.Declarations.DeclarationSpecifiersNode;
import C99Compiler.CompilerNodes.Declarations.DeclaratorNode;
import C99Compiler.CompilerNodes.Declarations.DirectDeclaratorNode;
import C99Compiler.CompilerNodes.Dummies.DummyType;
import C99Compiler.CompilerNodes.Interfaces.TypedNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.Exceptions.ConstraintException;
import C99Compiler.Exceptions.UndefinedTypeException;
import C99Compiler.Exceptions.UnsupportedFeatureException;

public class Type implements Serializable
{
	private ComponentNode<?> context; // The node this was defined under
	
	private String storageClassSpecifier;
	protected List<String> typeSpecifiers;
	protected Set<String> typeQualifiers;
//	private Set<String> functionSpecifiers;
	
	private static List<String> toList(String... members)
	{
		List<String> list = new LinkedList<String>();
		for (String member : members) list.add(member);
		return list;
	}
	private static final List<String> recognizedStrings = toList("unsigned", "signed", "void", "char", "short", "int", "long", "float", "double", "_Bool", "struct", "union", "enum", "_Complex");
	private static List<List<String>> allowedLists = null;
	private static List<List<String>> allowedTypeSpecLists() // As per 6.7.2.2
	{
		if (allowedLists != null) return allowedLists;
		allowedLists = new ArrayList<List<String>>();
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
	private static boolean isAllowed(List<String> typeSpecifiers)
	{
		for (List<String> allowedList : allowedTypeSpecLists())
			if (typeSpecifiers.containsAll(allowedList) && allowedList.containsAll(typeSpecifiers))
				return true;
		if (typeSpecifiers.contains("struct") || typeSpecifiers.contains("union") || typeSpecifiers.contains("enum"))
			return true;
		return false;
	}
	public Type()
	{
		typeSpecifiers = new LinkedList<String>();
		typeQualifiers = new HashSet<String>();
	}
	public Type(DeclarationSpecifiersNode.DeclSpecifiers specifiers, ComponentNode<?> context, Token start) throws Exception
	{
//		this.scope = declarator.getScope();
		typeSpecifiers = new LinkedList<String>();
		typeQualifiers = new HashSet<String>();
//		functionSpecifiers = new HashSet<String>();

		if (specifiers.storageClassSpecifiers.length > 0)
			storageClassSpecifier = specifiers.storageClassSpecifiers[0];
		for (String specifier : specifiers.typeSpecifiers)
		{
			if (context.resolveTypedefRelative(specifier) != null)
			{
				Type t = context.resolveTypedefRelative(specifier);
				typeSpecifiers.addAll(t.typeSpecifiers);
				typeQualifiers.addAll(t.typeQualifiers);
			}
			else typeSpecifiers.add(specifier);
		}
		for (String qualifier : specifiers.typeQualifiers)
			typeQualifiers.add(qualifier);
//		for (String qualifier : specifiers.functionSpecifiers)
//			functionSpecifiers.add(qualifier);
		
		// Check constraints
		
		if (specifiers.storageClassSpecifiers.length > 1)
			throw new ConstraintException("6.7.1", 1, start);
		
		if (!isAllowed(typeSpecifiers))
		{
			for (String spec : typeSpecifiers)
				if (!recognizedStrings.contains(spec))
				{
					Exception e = new UndefinedTypeException(spec, start);
					e.addSuppressed(new ConstraintException("6.7.2", 2, start));
					throw e;
				}
			// Otherwise it's the right parts, just in the wrong order
			throw new ConstraintException("6.7.2", 2, start);
		}
		if ((isStructOrUnion() || isEnum()) && getSUEName() == null)
		{
			throw new UndefinedTypeException("", start);
		}
		
		if (typeSpecifiers.contains("double") || typeSpecifiers.contains("float")) // Floats not supported
		{
			Exception e = new UnsupportedFeatureException("Floating-point numbers", false, start);
			if (typeSpecifiers.contains("_Complex")) // Complex numbers not supported
			{
				e.addSuppressed(new UnsupportedFeatureException("Complex numbers", false, start));
				e.addSuppressed(new ConstraintException("6.7.2", 3, start));
			}
			throw e;
		}
		
		this.context = context;
	}
	public Type(Type other)
	{
//		this.scope = declarator.getScope();
		typeSpecifiers = new LinkedList<String>();
		typeQualifiers = new HashSet<String>();
//		functionSpecifiers = new HashSet<String>();

		context = other.context;
		storageClassSpecifier = other.storageClassSpecifier;
		typeSpecifiers.addAll(other.typeSpecifiers);
		typeQualifiers.addAll(other.typeQualifiers);
	}

	public static Type manufacture(DeclarationSpecifiersNode.DeclSpecifiers specifiers, DeclaratorNode declaratorNode, Token start) throws Exception
	{
		Type type = new Type(specifiers, declaratorNode, start);
		if (declaratorNode == null) return type;
		
		for (DeclaratorNode.DeclaratorInfo info : declaratorNode.getInfo()) // Array
		{
			if (info == null) continue;
			if (info.type == DeclaratorNode.DeclaratorType.pointer)
			{
				type = new PointerType(type, info.pointerQualifiers);
			}
			if (info.type == DeclaratorNode.DeclaratorType.array)
			{
				if (info.assignExpr != null && Number.class.isAssignableFrom(info.assignExpr.getPropValue().getClass()))
					type = new ArrayType(type, (int) info.assignExpr.getPropLong());
				else
					type = new ArrayType(type); // Incomplete array
			}
			else if (info.type == DeclaratorNode.DeclaratorType.funcParam) // Function
			{
				if (type.isFunction() || type.isArray())
					throw new ConstraintException("6.7.5.3", 1, start);
				List<Type> paramTypes = new ArrayList<Type>();
				for (int i = 0; i < info.paramDecls.length; ++i)
				{
					for (VariableNode variable : info.paramDecls[i].getChildVariables(false).values())
					{
						Type paramType = variable.getType();
						if (paramType.isExtern() | paramType.isAuto() | paramType.isStatic())
							throw new ConstraintException("6.7.5.3", 2, start);
						paramTypes.add(paramType);
					}
				}

				type = new FunctionType(paramTypes, type);
			}
		}
		
		return type;
	}
	
	public int getSize()
	{
		int baseSize;
		if (isStructOrUnion())
		{
			if (context.resolveStructOrUnionRelative(getSUEName()) == null)
				baseSize = 0;
			baseSize = context.resolveStructOrUnionRelative(getSUEName()).getSize();
		}
			
		else if (isEnum())
			baseSize = context.resolveEnumRelative(getSUEName()).getType().getSize();
		else baseSize = CompConfig.sizeOf(typeSpecifiers);
		return baseSize;
	}
	
	public int getSizeBits()
	{
		return getSize() * 8;
	}
	
	/** Gets the name of the type's parent struct / union / enum, if any.
	 * 
	 * @return The name of the type's parent struct / union / enum, or null if it doesn't have one.
	 */
	public String getSUEName()
	{
		if (isStructOrUnion() || isEnum())
			return typeSpecifiers.get(1);
		else return null;
	}
	
	public static enum CastContext
	{
		cast,
		multiplicative,
		modulative,
		additive,
		subtractive,
		bitwise,
		relational,
		equality,
		logical,
		conditional,
		assignment,
		add_assignment
	}
	public boolean canCastTo(Type type, CastContext context)
	{
		return type.canCastFrom(this, context);
	}
	public boolean canCastFrom(Type type, CastContext context)
	{
		switch (context)
		{
		case cast: // Defined by 6.5.4.2
			return
					isScalar() && type.isScalar() ||
					canCastFrom(context, "void");
		case multiplicative: // Defined by 6.5.5.2
			return isArithmetic() && type.isArithmetic();
		case modulative: // Defined by 6.5.5.2
			return isInteger() && type.isInteger();
		case additive: // Defined by 6.5.6.2
			return
					isArithmetic() && type.isArithmetic() ||
					isInteger() && type.isPointer() ||
					isPointer() && type.isInteger();
		case subtractive: // Defined by 6.5.6.3
			return
					isArithmetic() && type.isArithmetic() ||
					isPointer() && type.isPointer() && ((PointerType) this).getType().canCastFrom(((PointerType) type).getType(), CastContext.assignment) ||
					type.isInteger();
		case bitwise: // Defined by 6.5.7.2, 6.5.10.2, 6.5.11.2, and 6.5.12.2
			return isInteger() && type.isInteger();
		case relational: // Defined by 6.5.8.2
			return
					isReal() && type.isReal() ||
					isPointer() && type.isPointer() && ((PointerType) this).getType().canCastFrom(((PointerType) type).getType(), CastContext.assignment);
		case equality: // Defined by 6.5.9.2
			return
					isArithmetic() && type.isArithmetic() ||
					isPointer() && type.isPointer() && ((PointerType) this).getType().canCastFrom(((PointerType) type).getType(), CastContext.assignment) ||
					isPointer() && type.isPointer() && ((PointerType) this).getType().canCastFrom(context, "void") ||
					isPointer() && type.isPointer() && ((PointerType) type).getType().canCastFrom(context, "void") ||
					isPointer() && type.isConstant() && type.isInteger(); // Null pointer
		case logical: // Defined by 6.5.13.2 and 6.5.14.2
			return isScalar() && type.isScalar();
		case conditional: // Defined by 6.5.15.3
			return
					isArithmetic() && type.isArithmetic() ||
					isStructOrUnion() && type.isStructOrUnion() && getSUEName().equals(type.getSUEName()) ||
					canCastFrom(context, "void") && type.canCastFrom(context, "void") ||
					isPointer() && (type.canCastFrom(context, "void") || type.isConstant() && type.isInteger()) || // Null pointer
					type.isPointer() && (canCastFrom(context, "void") || isConstant() && isInteger()); // Null pointer
		case assignment: // Defined by 6.5.16.1
			return
				isArithmetic() && type.isArithmetic() ||
				isStructOrUnion() && type.isStructOrUnion() && getSUEName().equals(type.getSUEName()) ||
				isPointer() && type.isPointer() && ((PointerType) this).getType().canCastFrom(((PointerType) type).getType(), CastContext.assignment) ||
				isPointer() && type.isPointer() && ((PointerType) this).getType().isVoid() ||
				isPointer() && type.isPointer() && ((PointerType) type).getType().isVoid() ||
				isPointer() && type.isConstant() && type.isInteger() || // Null pointer
				typeSpecifiers.contains("_Bool") && type.isPointer();
		case add_assignment: // Defined by 6.5.16.1
			return
				isArithmetic() && type.isArithmetic() ||
				isPointer() && type.isInteger();
		default:
			return true;
		}
	}
	public boolean canCastTo(CastContext context, String... specifiers)
	{
		return canCastTo(new DummyType(specifiers), context);
	}
	public boolean canCastFrom(CastContext context, String...specifiers)
	{
		return canCastFrom(new DummyType(specifiers), context);
	}
	public int getRank()
	{
		if (!isInteger()) return 0;
		else return getSize();
	}
	public static Type convertArithmetic(Type a, Type b)
	{
		assert (a.isArithmetic() && b.isArithmetic());
		if (a.isInteger() && b.isInteger())
		{
			Type greater, lesser;
			if (a.getRank() >= b.getRank())
			{
				greater = a;
				lesser = b;
			}
			else
			{
				greater = b;
				lesser = a;
			}
			
			if (greater.isSigned() == lesser.isSigned())
				return greater;
			else if (!greater.isSigned())
				return greater;
			else if (greater.getRank() > b.getRank())
				return greater;
			else
			{
				Type greaterU = new Type(greater);
				greaterU.typeSpecifiers.add("unsigned");
				return greaterU;
			}
		}
		else return null;
	}
	public Type promote()
	{
		if (!isInteger()) return this;
		else if (isSigned())
		{
			if (getRank() >= new DummyType("int").getRank()) return this;
			else return new DummyType("int");
		}
		else if (!isSigned())
		{
			if (getRank() >= new DummyType("unsigned", "int").getRank()) return this;
			else return new DummyType("unsigned", "int");
		}
		else return null;
	}
	public boolean containsSpecifier(String specifier)
	{
		if (typeSpecifiers.size() == 0) return false;
		return typeSpecifiers.contains(specifier);
	}
	
	public boolean isExtern()
	{
		return storageClassSpecifier != null && storageClassSpecifier.equals("extern");
	}
	public boolean isStatic()
	{
		return storageClassSpecifier != null && storageClassSpecifier.equals("static");
	}
	public boolean isAuto()
	{
		return storageClassSpecifier != null && storageClassSpecifier.equals("auto");
	}
	public boolean isRegister()
	{
		return storageClassSpecifier != null && storageClassSpecifier.equals("register");
	}
	public boolean isSRAM()
	{
		return storageClassSpecifier != null && storageClassSpecifier.equals("__SRAM");
	}
	public boolean isROM()
	{
		return !isSRAM() && isConstant();
	}
	public boolean isWRAM()
	{
		return !isSRAM() && !isROM();
	}
	public boolean isTwice() // Is read-twice or write-twice?
	{
		return typeQualifiers.contains("__RWTWICE") ||
				typeQualifiers.contains("__ROTWICE") ||
				typeQualifiers.contains("__WOTWICE");
	}
	public boolean isSpecX()
	{
		return storageClassSpecifier != null && storageClassSpecifier.equals("__SPECX"); 
	}
	public boolean isSpecY()
	{
		return storageClassSpecifier != null && storageClassSpecifier.equals("__SPECY"); 
	}
	public boolean isConstant()
	{
		return typeQualifiers.contains("const") || typeQualifiers.contains("__ROTWICE");
	}
	public boolean isVolatile()
	{
		return typeQualifiers.contains("volatile");
	}
	public boolean isIncomplete() {return false;} // To be overriden
	public boolean isQualified()
	{
		return typeQualifiers.size() != 0;
	}
	public boolean isArray() {return false;} // To be overriden
	public boolean isFunction() {return false;} // To be overriden
	public boolean isStructOrUnion()
	{
		return containsSpecifier("struct") || containsSpecifier("union");
	}
	protected boolean isEnum()
	{
		return containsSpecifier("enum");
	}
	
	public boolean isSigned()
	{
		return !containsSpecifier("unsigned");
	}
	public boolean isCharacter()
	{
		return containsSpecifier("char");
	}
	public boolean isInteger()
	{
		return isCharacter() || isEnum() ||
				containsSpecifier("_Bool") ||
				containsSpecifier("short") ||
				containsSpecifier("long") ||
				containsSpecifier("int") ||
				containsSpecifier("unsigned") ||
				containsSpecifier("signed");
	}
	public boolean isArithmetic()
	{
		return isInteger();
	}
	public boolean isReal()
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
		return isArray() || isStructOrUnion();
	}
	public boolean isVoid()
	{
		return typeSpecifiers.contains("void") && !isPointer();
	}
	
	public String getSignature()
	{
		String signature = "";
		if (storageClassSpecifier != null) signature += storageClassSpecifier + " ";
		for (String specifier : typeSpecifiers) signature += specifier + " ";
		for (String qualifier : typeQualifiers) signature += qualifier + " ";
//		for (String specifier : typeSpecifiers) signature += specifier + " ";

		return signature.substring(0, signature.length() - 1);
	}
	
	public StructUnionDefinitionNode getStruct()
	{
		return context.resolveStructOrUnionRelative(getSUEName());
	}
	public EnumDefinitionNode getEnum()
	{
		return context.resolveEnumRelative(getSUEName());
	}
	public void setContext(ComponentNode<?> context) 
	{
		this.context = context;
	}
}
