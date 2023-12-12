// Created by Iacon1 on 10/26/2023.
// handles optimizing the ASM.

// TODO use ASM parser

package Compiler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AssemblyOptimizer
{
	private static List<String> verbosifyFlagToggles(List<String> lines)
	{
		Map<String, String> replacements = new HashMap<String, String>();
		replacements.put("CLC", "REP\t#$01");
		replacements.put("CLI", "REP\t#$04");
		replacements.put("CLD", "REP\t#$08");
		replacements.put("CLV", "REP\t#$40");
		replacements.put("SEC", "SEP\t#$01");
		replacements.put("SEI", "SEP\t#$04");
		replacements.put("SED", "SEP\t#$08");
		replacements.put("SEV", "SEP\t#$40");
		
		for (int i = 0; i < lines.size(); ++i)
		{
			String line = lines.get(i).trim();
			if (replacements.get(line) != null)
				lines.set(i, lines.get(i).replace(line, replacements.get(line)));
		}
		
		return lines;
	}
	private static List<String> deVerbosifyFlagToggles(List<String> lines)
	{
		Map<String, String> replacements = new HashMap<String, String>();
		replacements.put("REP\t#$01", "CLC");
		replacements.put("REP\t#$04", "CLI");
		replacements.put("REP\t#$08", "CLD");
		replacements.put("REP\t#$40", "CLV");
		replacements.put("SEP\t#$01", "SEC");
		replacements.put("SEP\t#$04", "SEI");
		replacements.put("SEP\t#$08", "SED");
		replacements.put("SEP\t#$40", "SEV");
		
		for (int i = 0; i < lines.size(); ++i)
		{
			String line = lines.get(i).trim();
			if (replacements.get(line) != null)
				lines.set(i, lines.get(i).replace(line, replacements.get(line)));
		}
		
		return lines;
	}
	
	private static List<String> combineFlagToggles(List<String> lines)
	{
		for (int i = 0; i < lines.size(); ++i)
		{
			String line = lines.get(i);
			String prevLine = (i == 0 ? "" : lines.get(i - 1));
			
			if (line.contains("REP\t#$") && prevLine.contains("REP\t#$"))
			{
				byte a = Byte.valueOf(line.replace("REP\t#$", "").trim(), 16);
				byte b = Byte.valueOf(prevLine.replace("REP\t#$", "").trim(), 16);
				{
					lines.set(i, line.replace(String.format("%02x", a), String.format("%02x", a | b)));
					lines.set(i - 1, "");
				}
			}
			else if (line.contains("SEP\t#$") && prevLine.contains("SEP\t#$"))
			{
				byte a = Byte.valueOf(line.replace("SEP\t#$", "").trim(), 16);
				byte b = Byte.valueOf(prevLine.replace("SEP\t#$", "").trim(), 16);
				{
					lines.set(i, line.replace(String.format("%02x", a), String.format("%02x", a | b)));
					lines.set(i - 1, "");
				}
			}
			else if (line.contains("SEP\t#$") && prevLine.contains("REP\t#$"))
			{
				byte a = Byte.valueOf(line.replace("SEP\t#$", "").trim(), 16);
				byte b = Byte.valueOf(prevLine.replace("REP\t#$", "").trim(), 16);
				{
					if ((a & ~b) != 0)
						lines.set(i, line.replace(String.format("%02x", a), String.format("%02x", a & ~b)));
					else lines.set(i, "");
					if ((b & ~a) != 0)
						lines.set(i - 1, prevLine.replace(String.format("%02x", a), String.format("%02x", b & ~a)));
					else lines.set(i - 1, "");
				}
			}
			else if (line.contains("REP\t#$") && prevLine.contains("SEP\t#$"))
			{
				byte a = Byte.valueOf(line.replace("REP\t#$", "").trim(), 16);
				byte b = Byte.valueOf(prevLine.replace("SEP\t#$", "").trim(), 16);
				{
					if ((a & ~b) != 0)
						lines.set(i, line.replace(String.format("%02x", a), String.format("%02x", a & ~b)));
					else lines.set(i, "");
					if ((b & ~a) != 0)
						lines.set(i - 1, prevLine.replace(String.format("%02x", a), String.format("%02x", b & ~a)));
					else lines.set(i - 1, "");
				}
			}
		}
		
		return lines;
	}
	
	private static List<String> deRedundateFlagToggles(List<String> lines)
	{
		byte currFlags = 0;
		byte prevFlags = 0;
		byte knownFlags = 0; // Whether we currently know each flag
		for (int i = 0; i < lines.size(); ++i)
		{
			String line = lines.get(i);
			String prevLine = (i == 0 ? "" : lines.get(i - 1));
			if (line.matches("[^:\s]*:.*") || prevLine.contains("JSL")) // At a label or a JSL return point lose all assumptions of mode
				knownFlags = 0;

			prevFlags = currFlags;
			
			if (line.contains("EP\t#$"))
			{
				byte newFlags = 0;
				if (line.contains("REP\t#$"))
				{
					newFlags = Byte.valueOf(line.replace("REP\t#$", "").trim(), 16);
					currFlags &= ~newFlags;
				}
				else if (line.contains("SEP\t#$"))
				{
					newFlags = Byte.valueOf(line.replace("SEP\t#$", "").trim(), 16);
					currFlags |= newFlags;
				}
				
				byte prevKnownFlags = knownFlags;
				knownFlags |= newFlags;
				
				byte delta = (byte) ((currFlags ^ prevFlags) | (knownFlags ^ prevKnownFlags));
				
				if (delta == 0)
					lines.set(i, "");
				else lines.set(i, line.replace(String.format("%02x", newFlags), String.format("%02x", delta)));
			}
		}
		
		return lines;
	}
	
	public static List<String> optimizeAssembly(List<String> lines)
	{
		
		lines = verbosifyFlagToggles(lines);
		lines = combineFlagToggles(lines);
		lines = deRedundateFlagToggles(lines);
		lines = deVerbosifyFlagToggles(lines);
		
		return lines;
	}
}
