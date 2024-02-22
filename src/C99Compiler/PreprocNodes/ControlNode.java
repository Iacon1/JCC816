// Created by Iacon1 on 01/15/2024.
// Control-line node
package C99Compiler.PreprocNodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.tree.TerminalNode;

import C99Compiler.CompConfig;
import C99Compiler.PragmaProcessor;
import C99Compiler.Preprocessor;
import C99Compiler.Exceptions.ErrorException;
import Grammar.C99A3.C99A3Parser.Control_lineContext;
import Grammar.C99A3.C99A3Parser.Pp_tokenContext;
import C99Compiler.Utils.FileIO;

public class ControlNode extends InterpretingNode<ControlNode, Control_lineContext> implements GeneratingNode
{
	private String command;
	private GroupNode include;
	private String stdLib; // Only fill out if standard lib was included
	private String otherLib; // Only fill out if other lib was included
	private byte[] embedBytes;
	private String pragmaOutput; // Output of Pragma
	
	public ControlNode(PreProcComponentNode<?> parent)
	{
		super(parent);
		command = null;
		include = null;
		embedBytes = null;
		pragmaOutput = null;
	}
	public ControlNode()
	{
		super();
		command = null;
		include = null;
		embedBytes = null;
		pragmaOutput = null;
	}
	
	private List<String> getPPTokens(Control_lineContext node) throws Exception // LOL
	{
		List<String> tokens = new ArrayList<String>();
		if (node.pp_token().size() > 0) for (Pp_tokenContext token : node.pp_token()) tokens.add(token.getText());
		return resolveDefines(tokens.toArray(new String[] {}));
	}
	@Override
	public ControlNode interpret(Control_lineContext node) throws Exception
	{
		command = node.getChild(1).getText();
		
		String filename; // For include and embed
		switch (command)
		{
		case "include":
			filename = "";
			String file = "";
			if (node.pp_token(0).Header_name() == null)
			{
				for (String word : resolveDefines(getPPTokens(node).toArray(new String[] {})))
					filename += word + " ";
				filename = filename.stripTrailing();
			}
			else filename = node.pp_token(0).Header_name().getText();
			
			if (filename.contains("<")) // Include library
			{
				filename = filename.replaceAll("[<>\"\"]", "");
				stdLib = filename;
				try {file = FileIO.readResource("stdlib/" + filename);}
				catch (Exception e) {file = FileIO.readFile(CompConfig.rootFolder + "/" + filename);}
			}
			else if (filename.contains("\"")) // Include file
			{
				filename = filename.replaceAll("[<>\"\"]", "");
				otherLib = filename;
				try {file = FileIO.readFile(CompConfig.rootFolder + "/" + filename);}
				catch (Exception e) {file = FileIO.readResource("stdlib/" + filename);}
			}
			String oldFILE = PreProcComponentNode.file;
			int oldLINE = PreProcComponentNode.line;
			resetLineNo(filename, 1);
			include = new GroupNode(this).interpret(Preprocessor.parsePreprocess(file));
			resetLineNo(oldFILE, oldLINE);
			break;
		case "define": // Defines a macro
			String name = node.Identifier().getText();
			List<String> replacements = getPPTokens(node);
			if (replacements.isEmpty()) replacements.add(""); // If null replace with nothing

			charMappings.remove(name); // So as to avoid confusion
			if (node.identifier_list() != null)
			{
				List<String> parameters = new ArrayList<String>();
				for (TerminalNode identifier : node.identifier_list().Identifier()) parameters.add(identifier.getText());
				parameters = resolveDefines(parameters.toArray(new String[] {}));
				defines.put(name, new DefineNode(this, parameters.toArray(new String[] {}), replacements.toArray(new String[] {})));
			}
			else
				defines.put(name, new DefineNode(this, replacements.toArray(new String[] {})));
			break;
		case "undef":
			name = node.Identifier().getText();
			if (defines.containsKey(name)) defines.remove(name);
			else charMappings.remove(name);
			incrLineNo();
			break;
		case "line":
			List<String> tokens = getPPTokens(node);
			int newLINE = Integer.valueOf(tokens.get(0));
			if (tokens.size() == 2)
			{
				String newFILE = tokens.get(1);
				resetLineNo(newFILE, newLINE - 1); // -1 since we're about to increment
			}
			else resetLineNo(newLINE - 1);
			break;
		case "error":
			String error = "";
			for (String token : getPPTokens(node)) error += token + " ";
			error = error.stripTrailing();
			throw new ErrorException(error, PreProcComponentNode.file, PreProcComponentNode.line);
		case "pragma":
			pragmaOutput = PragmaProcessor.procPragma(getPPTokens(node), PreProcComponentNode.file, PreProcComponentNode.line);
			break;
		case "embed":
			filename = "";
			if (node.pp_token(0).Header_name() == null)
			{
				for (String word : resolveDefines(getPPTokens(node).toArray(new String[] {})))
					filename += word + " ";
				filename = filename.stripTrailing();
			}
			else filename = node.pp_token(0).Header_name().getText();
			embeds.add(filename);
			if (filename.contains("<")) // Include library
			{
				filename = filename.replaceAll("[<>\"\"]", "");
				embedBytes = FileIO.readResourceBytes("stdlib/" + filename);
			}
			else if (filename.contains("\"")) // Include file
			{
				filename = filename.replaceAll("[<>\"\"]", "");
				embedBytes = FileIO.readFileBytes(CompConfig.rootFolder + "/" + filename);
			}
			break;
		}
		incrLineNo();
		
		return this;
	}
	@Override
	public Set<String> getIncludedStdLibs()
	{
		Set<String> incl = super.getIncludedStdLibs();
		if (stdLib != null) incl.add(stdLib);
		return incl;
	}
	@Override
	public Set<String> getIncludedOtherLibs()
	{
		Set<String> incl = super.getIncludedOtherLibs();
		if (otherLib != null) incl.add(otherLib);
		return incl;
	}
	@Override
	public boolean hasText()
	{
		return command.equals("include") || command.equals("embed") || pragmaOutput != null;
	}
	
	@Override
	public String getText() throws Exception
	{
		if (command.equals("include"))
			return include.getText();
		else if (command.equals("embed"))
		{
			String text = "";
			for (int i = 0; i < embedBytes.length; ++i)
			{
				if (i != 0 && i % CompConfig.bytesPerDataLine == 0) text += "\n";
				text += String.format("0x%02x", embedBytes[i]) + ", ";
			}
			return text.substring(0, text.length() - 2) + "\n";
		}
		else if (pragmaOutput != null)
			return pragmaOutput;
		else return null;
	}
}
