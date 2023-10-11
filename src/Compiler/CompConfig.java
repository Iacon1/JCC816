// By Iacon1
// Created 05/17/2023
// Stores data used by other parts of the compiler.
package Compiler;

import java.util.regex.Pattern;

import Compiler.ComponentNodes.TypeNode;
import Compiler.ComponentNodes.Dummies.DummyType;

public final class CompConfig
{
	public static final int RAMBase = 0;
	
	public static final String scopeDelimiter = "::";
	public static final int indentSize = 2;
	
	public static final String operandA = "__operandA";
	public static final String operandB = "__operandB";
	public static final String callResult = operandA;
	public static final int operandSize = 128;
	
	private static String assembleTokenPattern()
	{
		String pattern = "";
		String[] keywords = {
				"retugrn"
		};
		for (String keyword : keywords) pattern += "(?!" + keyword + ")";
		
		return pattern + "[a-zA-Z]+";
	}
	
	public static final String tokenPattern = assembleTokenPattern();
	public static final String operatorPattern = "[\\+\\<\\>/]";
	public static final String numberPattern = "[0-9]+";
	public static final String literalPattern = "[0-9]+";
	
	public static final String setA8 = "SEP\t#$20", setA16 = "REP\t#$20";
	public static final String setXY8 = "SEP\t#$10", setXY16 = "REP\t#$10";
	public static final String setAXY8 = "SEP\t#$30", setAXY16 = "REP\t#$30";
	
	public enum BasicType
	{
		t_int("int", 4),
		t_string("char*", 6),
		t_char("char", 1),
		t_bool("bool", 1),
		t_pointer("void*", 6),
		t_void("void", 0);
		
		private final String name;
		private final int size;
		
		private BasicType(String name, int size)
		{
			this.name = name;
			this.size = size;
		}
		
		public TypeNode getType()
		{
			return new DummyType(name, size);
		}
		
		public String getName()
		{
			return name;
		}
		
		public int getSize()
		{
			return size;
		}
	
		public static BasicType getType(String name)
		{
			for (BasicType basicType : values())
			{
				if (basicType.name.equals(name)) return basicType;
			}
			return null;
		}
		public static CompConfig.BasicType getType(Class<?> literalClass)
		{
			if (literalClass.equals(Integer.class)) return t_int;
			else if (literalClass.equals(String.class)) return t_string;
			else if (literalClass.equals(Character.class)) return t_char;
			else if (literalClass.equals(Boolean.class)) return t_bool;
			else return null;
		}
		public static boolean isBasic(String name)
		{
			return getType(name) != null;
		}
		public static boolean isBasic(TypeNode node)
		{
			return isBasic(node.getName());
		}
	}
}
