// Created by Iacon1 on 01/15/2024.
// Control-line node
package Compiler.PreprocNodes;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import Grammar.C99A3.C99A3Parser.Control_lineContext;
import Grammar.C99A3.C99A3Parser.Pp_tokenContext;
import Compiler.Compiler;
import Compiler.Preprocessor;
import Compiler.Utils.FileIO;
import Logging.Logging;

public class ControlNode extends InterpretingNode<ControlNode, Control_lineContext> implements GeneratingNode
{
	private String command;
	private GroupNode include;
	
	public ControlNode(PreProcComponentNode<?> parent)
	{
		super(parent);
		command = null;
		include = null;
	}
	public ControlNode()
	{
		super();
		command = null;
		include = null;
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
		
		switch (command)
		{
		case "include":
			String filename = "";
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
				file = FileIO.readResource("stdlib/" + filename);
			}
			else if (filename.contains("\"")) // Include file
			{
				filename = filename.replaceAll("[<>\"\"]", "");
				file = FileIO.readFile(filename);
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
			defines.remove(node.Identifier().getText());
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
			Logging.logError(error);
			break;
		case "pragma":
			Compiler.procPragma(getPPTokens(node));
			break;
		}
		incrLineNo();
		
		return this;
	}
	
	@Override
	public boolean hasText()
	{
		return command.equals("include");
	}
	
	@Override
	public String getText() throws Exception
	{
		return include.getText();
	}
}
