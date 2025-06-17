// Created by Iacon1 on 10/17/2023.

package C99Compiler.Exceptions;

import org.antlr.v4.runtime.Token;

@SuppressWarnings("serial")
public class ConstraintException extends TokenException
{
	private static String getDesc(String section, int number)
	{
		switch (section + "." + number)
		{
		case "6.5.3.1.1": return
				"The operand of the prefix increment or decrement operator shall have qualified or " +
				"unqualified real or pointer type and shall be a modifiable lvalue";
		case "6.5.16.1.1": return
				"One of the following shall hold:\n" +
				"— the left operand has qualified or unqualified arithmetic type and the right has\n" +
				"arithmetic type;\n" +
				"— the left operand has a qualified or unqualified version of a structure or union type\n" +
				"compatible with the type of the right;\n" +
				"— both operands are pointers to qualified or unqualified versions of compatible types,\n" +
				"and the type pointed to by the left has all the qualifiers of the type pointed to by the\n" +
				"right;\n" +
				"— one operand is a pointer to an object or incomplete type and the other is a pointer to a\n" +
				"qualified or unqualified version of void, and the type pointed to by the left has all\n" +
				"the qualifiers of the type pointed to by the right;\n" +
				"— the left operand is a pointer and the right is a null pointer constant; or\n" +
				"— the left operand has type _Bool and the right is a pointer.";
		case "6.6.4": return
				"Each constant expression shall evaluate to a constant that is in the range of representable values for its type.";
		case "6.7.2": return
				"A declaration shall declare at least a declarator (other than the parameters of a function or the members of a " +
				"structure or union), a tag, or the members of an enumeration";
		case "6.7.1.2": return
				"At most, one storage-class specifier may be given in the declaration specifiers in a declaration.";
		case "6.7.2.2": return
				"[...] Each list of type specifiers shall be one of the [allowed] sets [...]; the type specifiers may occur in any" +
				"order, possibly intermixed with the other declaration specifiers.";
		case "6.7.2.3": return
				"The type specifier _Complex shall not be used if the implementation does not provide complex types.";
		default:
			return section + "." + number;
		}
	}
	
	public ConstraintException(String section, int constraintNumber, Token location)
	{
		super(getDesc(section, constraintNumber), location);
	}
}
