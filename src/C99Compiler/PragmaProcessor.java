// Created by Iacon1 on 01/24/2024.
// Process pragma
package C99Compiler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import C99Compiler.PreprocNodes.PreProcComponentNode;
import C99Compiler.Utils.CompUtils;

public final class PragmaProcessor
{
	public static final String procPragma(List<String> parameters, String file, int line) throws Exception
	{
		if (parameters.size() == 0) return null; // Do nothing if no parameters
		
		if (parameters.get(0).equals("DEF_CMAP")) // Define character mapping
		{
			String name = parameters.get(1);
			Map<Character, Character> mapping = new HashMap<Character,Character>();
			for (int i = 2; i < parameters.size(); i += 4) // All subsequent arguments are expected to be char-byte pairs separated by commas
			{
				char a = (char) CompUtils.parseLiteral(parameters.get(i)).byteValue();
				char b = (char) CompUtils.parseLiteral(parameters.get(i + 2)).byteValue();
				mapping.put(a, b);
			}
			PreProcComponentNode.defines.remove(name); // So as to avoid confusion
			PreProcComponentNode.charMappings.put(name, mapping);
		}
		else if (parameters.get(0).equals("APPLY_CMAP")) // Use character mapping, like APPLY_CMAP [name] "[input]"
		{
			String name = parameters.get(1);
			Map<Character, Character> mapping = PreProcComponentNode.charMappings.get(name);
			String input = parameters.get(2);
			String output = "" + input.charAt(0); // Either char quote or string quote
			input = CompUtils.processEscapes(input.substring(1, input.length() - 1));
			for (int i = 0; i < input.length(); ++i) // Map all characters of input
				if (mapping.get(input.charAt(i)) != null)
						output += "\\x" + String.format("%02x", mapping.get(input.charAt(i)).charValue());
				else output += input.charAt(i);
			return output + output.charAt(0);
		}
		
		return null;
	}
}
