// By Iacon1
// Created 01/15/2024
// A component node for preprocessors

package C99Compiler.PreprocNodes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Assembler.Header;
import C99Compiler.CompConfig.DebugLevel;
import C99Compiler.PragmaProcessor;
import C99Compiler.Utils.LineInfo;

public abstract class PreProcComponentNode<T extends PreProcComponentNode<T>>
{
	protected PreProcComponentNode<?> parent;
	protected List<PreProcComponentNode<?>> children;
	
	protected static String file = "";
	protected static int line = 0;
	
	public static final Map<String, DefineNode> defines = new HashMap<String, DefineNode>();
	public static final Map<String, Map<Character, Character>> charMappings = new HashMap<String, Map<Character, Character>>();
	public static final Set<String> embeds = new HashSet<String>();
	
	public static void resetLineNo(String file, int line)
	{
		PreProcComponentNode.file = file.replace("/", "\\");
		PreProcComponentNode.line = line;
		defines.put("__FILE__", new DefineNode(file)); // Change each file
		defines.put("__LINE__", new DefineNode(String.valueOf(line))); // Change each newline
	}
	public static void resetLineNo(int line)
	{
		resetLineNo(file, line);
	}
	public static void incrLineNo()
	{
		line += 1;
		defines.put("__LINE__", new DefineNode(String.valueOf(line))); // Change each newline
	}
	public static void loadPredefs(Header header) // Predefined macros
	{
		defines.put("__DATE__", new DefineNode(LocalDate.now().format(DateTimeFormatter.ofPattern("LLL dd yyyy"))));
//		defines.put("__FILE__", new DefineNode(file)); // Change each file
//		defines.put("__LINE__", new DefineNode(String.valueOf(line))); // Change each newline
		defines.put("__STDC__", new DefineNode("1"));
		defines.put("__STDC_HOSTED__", new DefineNode("0"));
		defines.put("__STDC_MB_MIGHT_NEQ_WC__", new DefineNode("1"));
		defines.put("__STDC_VERSION__", new DefineNode("199901L"));
//		defines.put("__TIME__", new DefineNode(LocalDate.now().format(DateTimeFormatter.ofPattern("HH':mm':ss'\""))));
		
		defines.put("__STDC_IEC_559__", new DefineNode("0"));
		defines.put("__STDC_IEC_559_COMPLEX__", new DefineNode("0"));
		
		if (header != null)
		{
			DefineNode destCode = new DefineNode("0x" + String.format("%02x", header.getDestinationCode().getNumber()));
			defines.put("__SNES_REGION__", destCode);
			switch (header.getDestinationCode())
			{
			case japan: defines.put("__SNES_REGION_JPN__", destCode); break;
			case USA: defines.put("__SNES_REGION_USA__", destCode); break;
			case australia: defines.put("__SNES_REGION_AUS__", destCode); break;
			case brazil: defines.put("__SNES_REGION_BRA__", destCode); break;
			case canada: defines.put("__SNES_REGION_CAN__", destCode); break;
			case china: defines.put("__SNES_REGION_CHN__", destCode); break;
			case denmark: defines.put("__SNES_REGION_DEN__", destCode); break;
			case europe: defines.put("__SNES_REGION_EUR__", destCode); break;
			case finland: defines.put("__SNES_REGION_FIN__", destCode); break;
			case france: defines.put("__SNES_REGION_FRA__", destCode); break;
			case germany: defines.put("__SNES_REGION_GER__", destCode); break;
			case indonesia: defines.put("__SNES_REGION_IND__", destCode); break;
			case international: defines.put("__SNES_REGION_INT__", destCode); break;
			case italy: defines.put("__SNES_REGION_ITA__", destCode); break;
			case netherlands: defines.put("__SNES_REGION_NET__", destCode); break;
			case southKorea: defines.put("__SNES_REGION_KOR__", destCode); break;
			case spain: defines.put("__SNES_REGION_SPN__", destCode); break;
			case sweden: defines.put("__SNES_REGION_SWE__", destCode); break;
			}
				
			DefineNode revision = new DefineNode("0x" + String.format("%02x", header.getRevision()));
			defines.put("__SNES_REVISION__", revision);
			DefineNode specialVersion = new DefineNode("0x" + String.format("%02x", header.getSpecialVersion()));
			defines.put("__SNES_SPECIAL_VER__", specialVersion);
			
			if (DebugLevel.isAtLeast(DebugLevel.low))
			{
				DefineNode debugLevel = new DefineNode(String.format("%d", DebugLevel.getOrdinal()));
				defines.put("__DEBUG__", debugLevel);
				defines.put("__DEBUG_LOW__", debugLevel);

				if (DebugLevel.isAtLeast(DebugLevel.medium))
					defines.put("__DEBUG_MED__", debugLevel);
			}
		}
	}
	public static void loadPredefs()
	{
		loadPredefs(null);
	}
	public static void reset(Header header)
	{
		file = "";
		line = 0;
		
		defines.clear();
		charMappings.clear();
		embeds.clear();
		loadPredefs(header);
	}
	public static void reset()
	{
		reset(null);
	}
	public PreProcComponentNode(PreProcComponentNode<?> parent)
	{
		this.children = new LinkedList<PreProcComponentNode<?>>();
		this.parent = parent;
		this.parent.children.add(this);
	}
	public PreProcComponentNode()
	{
		this.children = new LinkedList<PreProcComponentNode<?>>();
		this.parent = null;
	}
	public void removeChild(PreProcComponentNode<?> child)
	{
		children.remove(child);
	}
	
	public Set<String> getIncludedStdLibs()
	{
		Set<String> incl = new HashSet<String>();
		for (PreProcComponentNode<?> child : children)
			incl.addAll(child.getIncludedStdLibs());
		return incl;
	}
	public Set<String> getIncludedOtherLibs()
	{
		Set<String> incl = new HashSet<String>();
		for (PreProcComponentNode<?> child : children)
			incl.addAll(child.getIncludedOtherLibs());
		return incl;
	}
	
	// Get the list of parameters for a macro
	private static List<String> collectParameters(List<String> wordList, int leftmost)
	{
		int rightmost = leftmost - 1;
		int parenDepth = 1; // When 0, good to leave
		while (parenDepth != 0)
		{
			rightmost += 1;
			
			if (rightmost >= wordList.size()) return null;
			if (wordList.get(rightmost + 1).equals("(")) parenDepth += 1;
			else if (wordList.get(rightmost + 1).equals(")")) parenDepth -= 1;
		}
		
		return new ArrayList<String>(wordList.subList(leftmost, rightmost + 1));
	}
	private static String[] removeCommas(List<String> wordList)
	{
		int i = wordList.size() - 1;
		while (i >= 0)
		{
			if (wordList.get(i).equals(",")) wordList.remove(i);
			i--;
		}
		return wordList.toArray(new String[] {});
	}
	public static List<String> resolveDefines(String... words) throws Exception
	{
		if (words.length == 0) return new ArrayList<String>();
		List<String> wordList = new ArrayList<String>(Arrays.asList(words));

		int i = 0;
		while (i != wordList.size())
		{
			String word = wordList.get(i);
			if (charMappings.containsKey(word) && wordList.get(i + 1).equals("("))
			{
				wordList.remove(i);
				List<String> parameters = collectParameters(wordList, i + 1);
				wordList.removeAll(parameters);
				wordList.remove(i + 1); // Remove parentheses
				wordList.remove(i); // Remove parentheses
				parameters.add(0, "APPLY_CMAP");
				parameters.add(1, word);
				wordList.add(i, PragmaProcessor.procPragma(parameters, file, line));
				--i;
			}
			if (defines.containsKey(word)) // Replace with filled macro
			{
				if (defines.get(word).hasParameters() && !wordList.get(i + 1).equals("(")) // Function-like but no function
					continue;
				wordList.remove(i);
				if (defines.get(word).hasParameters())
				{
					List<String> parameters = collectParameters(wordList, i + 1);
					wordList.removeAll(parameters);
					wordList.remove(i + 1); // Remove parentheses
					wordList.remove(i); // Remove parentheses
					wordList.addAll(i, Arrays.asList(defines.get(word).getText(removeCommas(parameters)).split(" ")));
				}
				else
					wordList.addAll(i, Arrays.asList(defines.get(word).getText().split(" ")));
				
				--i; // Moves back, in case the first word of the replacement is itself a macro
			}
			
			++i;
		}
		
		return wordList;
	}
	
	public List<LineInfo> getLineInfo()
	{
		List<LineInfo> lineInfo = new LinkedList<LineInfo>();
		for (PreProcComponentNode<?> child : children)
			lineInfo.addAll(child.getLineInfo());
		return lineInfo;
	}
}
