// Created by Iacon1 on 10/26/2023.
// Constants for the compiler.
package C99Compiler;

import java.util.AbstractMap.SimpleEntry;

import C99Compiler.Utils.OperandSources.AddressSource;
import C99Compiler.Utils.OperandSources.OperandSource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class CompConfig
{
	public static final String version = "0.X";

	public static String rootFolder = "."; // Name of base folder to look for non-stdlib libraries in
	
	public static final String mainName = "main";
	public static final String scopeDelimiter = "@";
	public static final String scopeDelimiterPermissor = "at_in_identifiers";
	public static final int indentSize = 2;
	
	public static final int scratchBank = 0x7F;
	public static final int scratchPage = 0xFF;
	public static final int specSubSize = 16;
	public static final String specSubX = "__@specSubX";
	public static final String specSubY = "__@specSubY";
	public static final int scratchSize = 128;
	public static final String scratchBase = "__@scratchBase";
	public static final String pointerBase = "__@pointerBase";
	public static final int generalPointers = 11; // Number of general pointers
	public static final String funcPointer = "__@funcPointer";
	public static final String signExtend = "__@signExtend"; // 1 byte; Set to be 0x00 if the last byte of an operand was positive, 0xFF otherwise
	public static final int callResultSize = 64;
	public static final String callResult = "__@callResult";
	// 16 + 16 + 128 + 3*11 + 3 + 2 + 64 = 256 = Just large enough to be a ZP!
	public static final String bankRootName = "ROM";
	public static final String functionTag = "@func";
	public static final String registerTag = "__REG";
	
	public static final int bytesPerDataLine = 32; // Bytes per data line for ROM data
	
	public static final OperandSource callResultSource(int size)
	{
		if (size <= callResultSize) return new AddressSource(callResult, size);
		else return null;
	}
	public static final OperandSource specSubSource(boolean isX, int size)
	{
		if (size <= specSubSize) return new AddressSource((isX ? specSubX : specSubY), size);
		else return null;
	}
	public static final OperandSource callResultSource()
	{
		return callResultSource(callResultSize);
	}
	public static final OperandSource funcPointerSource()
	{
		return new AddressSource(funcPointer, pointerSize);
	}
	public static String codeBankName(int i) {return bankRootName + String.format("%03d",i);}
	public static List<SimpleEntry<String, Integer>> reservedRAM() 
	{
		List<SimpleEntry<String, Integer>> list = new LinkedList<SimpleEntry<String, Integer>>();
		list.add(new SimpleEntry<String, Integer>(callResult, callResultSize));
		list.add(new SimpleEntry<String, Integer>(specSubY, specSubSize));
		list.add(new SimpleEntry<String, Integer>(specSubX, specSubSize));
		list.add(new SimpleEntry<String, Integer>(funcPointer, pointerSize));
		list.add(new SimpleEntry<String, Integer>(signExtend, 2));
		list.add(new SimpleEntry<String, Integer>(pointerBase, generalPointers * pointerSize));
		list.add(new SimpleEntry<String, Integer>(scratchBase, scratchSize));
		return list;
	};
	
	private static final int charSize = 1;
	private static final int shortSize = 2;
	private static final int intSize = 3;
	private static final int longSize = 4;
	private static final int longLongSize = 8;
	public static final int pointerSize = 3;
	
	public static int sizeOf(List<String> typeSpecifiers)
	{
		if (typeSpecifiers.contains("char") || typeSpecifiers.contains("_Bool")) return charSize;
		else if (typeSpecifiers.contains("int") || typeSpecifiers.contains("short") || typeSpecifiers.contains("long"))
		{
			int shortCount = 0, longCount = 0;
			for (String specifier : typeSpecifiers) if (specifier.equals("short")) return shortSize;
			if (shortCount == 1) return shortSize;
			for (String specifier : typeSpecifiers) if (specifier.equals("long")) longCount += 1;
			if (longCount == 1) return longSize;
			else if (longCount == 2) return longLongSize;
			return intSize;
		}
		else return 0;
	}
	public static int sizeOf(String... typeSpecifiers)
	{
		return sizeOf(Arrays.asList(typeSpecifiers));
	}
	
	public static final int stackSize = 0x2000;
	public static final int maxOptimizedMultComplexity = 7; // Most complex chain allowed in constant-multiplier optimization
	
	public static enum DefinableInterrupt // Interrupts the user is allowed to assign functions to
	{
		COP("__longCOP"),
		BRK("__longBRK"),
		ABORT("__longABORT"),
		NMI("__longNMI"),
		RESET("RESET"),
		IRQ("__longIRQ");
		
		public final String longLabel;
		
		private DefinableInterrupt(String longLabel)
		{
			this.longLabel = longLabel;
		}
	}
	
	public static enum OptimizationLevel
	{
		min, 	// + Basic (intra-expression) constant propagation
		low, 	// + REP/SEP optimization
		medium, // + Aggressive (inter-line) constant propagation and shrinkwrapping
		all, 	// + Dependency graph optimization
		;
		public static boolean isAtLeast(OptimizationLevel level)
		{
			return CompConfig.optimizationLevel.compareTo(level) >= 0;
		}
	}
	public static OptimizationLevel optimizationLevel = OptimizationLevel.all;
	
	public static enum DebugLevel
	{
		none, 	// None
		low, 	// + Output symbols
		medium, // + Comments
		;
		public static boolean isAtLeast(DebugLevel level)
		{
			return CompConfig.debugLevel.compareTo(level) >= 0;
		}
	}
	public static DebugLevel debugLevel = DebugLevel.none;
	
	public static enum VerbosityLevel
	{
		none, 	// None
		low,	// + None
		medium, // + Timing data
		;
		public static boolean isAtLeast(VerbosityLevel level)
		{
			return CompConfig.verbosityLevel.compareTo(level) >= 0;
		}
	}
	public static VerbosityLevel verbosityLevel = VerbosityLevel.none;

	public static final class Attributes
	{
		public static final String interruptCOP = "interrupt_COP";
		public static final String interruptBRK = "interrupt_BRK";
		public static final String interruptABORT = "interrupt_ABORT";
		public static final String interruptNMI = "interrupt_NMI";
		public static final String interruptIRQ = "interrupt_IRQ";
		public static final String noISR1 = "no_ISR1"; // Level 1 noISR - removes normal stack pushers / loaders from interrupt handler
		public static final String noISR2 = "no_ISR2"; // Level 2 noISR - like level 1, but replaces RTI with RTL
		public static final String SA1 = "SA1";	// Specifies that a function can only be called on the SA1 coprocessor
		
		public static final boolean isInterrupt(Set<String> attributes)
		{
			return
					attributes.contains(interruptCOP)	||
					attributes.contains(interruptBRK)	||
					attributes.contains(interruptABORT)	||
					attributes.contains(interruptNMI)	||
					attributes.contains(interruptIRQ)	;
		}
	}
}
