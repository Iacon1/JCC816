// Created by Iacon1 on 11/21/2023.
//
package Compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Compiler.ComponentNodes.LValues.VariableNode;

public final class SimOptimizer
{
	private static class Line
	{
		public enum LineType
		{
			label,
			jump,
			branch,
			store,
			load,
			math,
			flag,
			other,
			nonInst,
		}
		
		public boolean isNeeded;
		public String assembly;
		
		public Line(String assembly)
		{
			this.assembly = assembly;
		}
		
		public LineType getType()
		{
			if (this.assembly.endsWith(":")) return LineType.label;
			else switch (this.getInstruction())
			{
			case "RTS" : case "RTL" : return LineType.jump;
			case "LDA" : case "LDX" : case "LDY" : return LineType.load;
			case "STA" : case "STX" : case "STY" : case "STZ" : return LineType.store;
			case "JMP" : case "JSL" : case "JSR" : case "JML" : return LineType.jump;
			case "BRA" : case "BRL" : return LineType.jump;
			case "BNE" : case "BEQ" : return LineType.branch;
			case "ADC" : case "SBC" : case "AND" : case "ORA" : return LineType.math;
			case "XOR" : case "BIT" : return LineType.math;
			case "INX" : case "DEX" : case "INY" : case "DEY" : return LineType.math;
			case "REP" : case "SEP" : case "CLC" : case "SEC" : return LineType.flag;
			case "CLI" : case "SEI" : return LineType.flag;
			case ".word" : return LineType.nonInst;
			default: return LineType.other;
			}
		}
		public String getInstruction()
		{
			return assembly.strip().subSequence(0, 3).toString();
		}
		public char getRegister()
		{
			if (getType() == LineType.store || getType() == LineType.load)
				return getInstruction().charAt(2);
			else if (getType() == LineType.math)
				switch (getInstruction())
				{
				case "INX" : case "DEX" : return 'X';
				case "INY" : case "DEY" : return 'Y';
				default: return 'A';
				}
			return '\0';
		}
		public String getParameter()
		{
			return assembly.strip().substring(4);
		}
		public boolean isAddress()
		{
			return getParameter().charAt(0) != '#';
		}
		public String getLabel()
		{
			return getParameter().replace(':', '\0');
		}
		
		public byte getFlags()
		{
			return Byte.valueOf(getParameter().subSequence(2, 3).toString(), 16);
		}
	}
	private static class TraceInfo
	{
		Set<Character> importantRegs;
		byte importantFlags;
		boolean recentExport; // Have we seen an export since the last label we saw?
		
		public TraceInfo(Set<Character> importantRegs, byte importantFlags, boolean recentExport)
		{
			this.importantRegs = new HashSet<Character>();
			this.importantRegs.addAll(importantRegs);
			this.importantFlags = importantFlags;
			this.recentExport = recentExport;
		}
		public TraceInfo(TraceInfo traceInfo)
		{
			this.importantRegs = new HashSet<Character>();
			this.importantRegs.addAll(traceInfo.importantRegs);
			this.importantFlags = traceInfo.importantFlags;
			this.recentExport = traceInfo.recentExport;
		}
		public TraceInfo()
		{
			this.importantRegs = new HashSet<Character>();
			this.importantRegs.addAll(importantRegs);
			this.importantFlags = (byte) 0xFF;
			this.recentExport = false;
		}
	}
	
	private static List<Integer> getJumpsTo(List<Line> lines, String label)
	{
		List<Integer> jumpsTo = new LinkedList<Integer>();
		for (int i = 0; i < lines.size(); ++i)
			if (
					(
							lines.get(i).getType() == Line.LineType.jump ||
							lines.get(i).getType() == Line.LineType.branch
					) &&
					lines.get(i).getParameter().equals(label))
				jumpsTo.add(i);
		
		return jumpsTo;
	}
	private static void traceExports(int i, List<Line> lines, List<String> internalAddresses, TraceInfo traceInfo)
	{
		List<String> newInternalAddresses = new ArrayList<String>(); // Need this stuff by value, not by reference
		newInternalAddresses.addAll(internalAddresses);
		traceInfo = new TraceInfo(traceInfo);
		boolean firstIter = true;
		
		while (i >= 0)
		{
			Line line = lines.get(i);
			
			switch (line.getType())
			{
			case store:
				traceInfo.importantRegs.remove(line.getRegister());
				if (!internalAddresses.contains(line.getParameter())) // Storing to an export!
				{
					traceInfo.recentExport = true;
					line.isNeeded |= true; // Line is needed if we didn't already
					traceInfo.importantRegs.add(line.getRegister()); // We need to find what set this variable
					traceInfo.importantFlags = (byte) 0xFF; // We need to know the source of all the flags at this point
				}
				break;
			case load:
				if (traceInfo.importantRegs.contains(line.getRegister())) // Loads to a register we were looking for the source of
					{
					traceInfo.recentExport = true;
						line.isNeeded |= true;
						traceInfo.importantRegs.remove(line.getRegister()); // Value before this unneeded
						if (line.isAddress())
							internalAddresses.remove(line.getParameter()); // This address isn't just internal now
						traceInfo.importantFlags = (byte) 0xFF; // We need to know the source of all the flags at this point
					}
				break;
			case math:
				if (traceInfo.importantRegs.contains(line.getRegister())) // Modifies a register we were looking for the source of
				{
					traceInfo.recentExport = true;
					line.isNeeded |= true;
					if (line.isAddress())
						internalAddresses.remove(line.getParameter());
					traceInfo.importantFlags = (byte) 0xFF; // We need to know the source of all the flags at this point
				}
			break;
			case label:
				line.isNeeded |= true;
				if (traceInfo.recentExport) // This is a way to get to a write
				{
					traceInfo.recentExport = false;
					line.isNeeded |= true;
					for (int j : getJumpsTo(lines, line.getLabel()))
						traceExports(j, lines, internalAddresses, traceInfo);
				}
				break;
			case flag:
				if ((traceInfo.importantFlags & line.getFlags()) != 0)
				{
					traceInfo.recentExport = false;
					line.isNeeded |= true;
					traceInfo.importantFlags &= ~line.getFlags(); // Now we know where those flags came from
				}
			case branch:
				traceInfo.importantRegs.add('A');
				line.isNeeded |= true;
				break;
			default:
				break;	
			}
			
			firstIter = false;
			lines.set(i, line);
			i--;
		}
	}
	/** Creates an assembly-level call graph and uses it to remove dead code
	 * 
	 * @param functionAssembly The function's un-optimized (internal) assembly
	 * @param internalVariables All variables only accessible within the function
	 * @return The function's assembly, free of (at least most) dead code
	 */
	public static String clearDeadCode(String functionAssembly, List<VariableNode> internalVariables)
	{
		List<String> internalAddresses = new ArrayList<String>();

		// List internal addresses
		for (VariableNode internalVar : internalVariables)
			for (int i = 0; i < internalVar.getSize(); ++i)
				internalAddresses.add(internalVar.getFullName() + " + " + i);
				
		// Initialize list from assembly
		List<Line> lines = new ArrayList<Line>();
		for (String line : functionAssembly.split("\n"))
			lines.add(new Line(line));
		
		traceExports(lines.size() - 1, lines, internalAddresses, new TraceInfo());
		
		// Re-assembly assembly from list
		functionAssembly = "";
		for (Line line : lines)
			if (line.isNeeded) functionAssembly += line.assembly + "\n";
		
		return functionAssembly;
	}
}
