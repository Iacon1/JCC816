// By Iacon1
// Created 05/17/2023
// Stores data used by other parts of the compiler.
package Compiler;

import Compiler.ComponentNodes.TypeNode;
import Compiler.ComponentNodes.Dummies.DummyType;

public final class CompConfig
{
	public static final String version = "0.X";
	
	public static final String scopeDelimiter = "::";
	public static final int indentSize = 2;
	
	public static final String operandA = "__operandA";
	public static final String operandB = "__operandB";
	public static final String callResult = operandA;
	public static final int operandSize = 128;
	
	public static final class Keywords
	{
		public static final String ifKW = "if";
		public static final String elseKW = "else";
		public static final String returnKW = "return";
		public static final String attributeKW = "__attribute__";
	}
	private static String assembleTokenPattern()
	{
		String pattern = "";
		String[] keywords = {
				Keywords.returnKW,
				Keywords.attributeKW,
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
	
	public static final class Attributes
	{
		public static final String interrupt = "interrupt";
		public static final String noISR = "no_isr";
	}
	
	
	public enum Primitive
	{
		t_int("int", 4, true),
		t_short("short", 2, true),
		t_pointer("void*", 6, true),
		t_long("long", 8, true),
		t_char("char", 1, true),
		t_string("char*", 1, false),
		t_bool("bool", 1, false),
		t_void("void", 0, false);
		
		private final String name;
		private final int size;
		private final boolean isNumeric;
		
		private Primitive(String name, int size, boolean isNumeric)
		{
			this.name = name;
			this.size = size;
			this.isNumeric = isNumeric;
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
		public boolean isNumeric() {return isNumeric;}
		
		public static Primitive getType(String name)
		{
			for (Primitive basicType : values())
			{
				if (basicType.name.equals(name)) return basicType;
			}
			return null;
		}
		public static CompConfig.Primitive getType(Class<?> literalClass)
		{
			if (literalClass.equals(Integer.class)) return t_int;
			else if (literalClass.equals(Short.class)) return t_short;
			else if (literalClass.equals(Long.class)) return t_long;
			else if (literalClass.equals(String.class)) return t_string;
			else if (literalClass.equals(Byte.class)) return t_char;
			else if (literalClass.equals(Boolean.class)) return t_bool;
			else return null;
		}
		public static CompConfig.Primitive getType(TypeNode type)
		{
			return getType(type.getName());
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
	
	public static int stackSize = 0x2000;
	/** Maps a byte offset from the start of RAM to a memory address the CPU can understand.
	 *  @param offset The offset from the start of RAM.
	 */
	public static final String mapOffset(int offset)
	{
		if (offset / 0x10000 <= (0x7F - 0x7E))
		{
			String bank = String.format("%02x", 0x7E + offset / 0x10000);
			String addr = String.format("%04x", offset % 0x10000);
			return "$" + bank + addr;
		}
		else return null;
	}
}
