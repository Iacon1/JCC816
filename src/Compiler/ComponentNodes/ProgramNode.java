// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes;

import Grammar.GeneralParser;
import Grammar.GeneralParser.GeneralNode;

public class ProgramNode extends ComponentNode<ProgramNode>
{
	@Override
	public <P extends GeneralParser> ProgramNode interpret(GeneralNode<String> node)
	{
		switch (node.subRule)
		{
		case 0, 1:	// Statement
			new StatementNode(this).interpret(node);
			break;
		}
		
		return this;
	}
	
	public String getAssembly()
	{
		String assembly = "";
	
		// Generate list of types
		/* Generated as a set of .structs.
		 * 
		 */
		
		for (TypeNode typeNode : types().values())
		{
			assembly += ".struct " + typeNode.getFullName() + "\n";
			
			for (VariableNode member : typeNode.getMembers())
			{
				String suffix = null;
				
				switch (member.getType().getName())
				{
				case "int": suffix = ".res\t4, $00"; break;
				case "char": suffix = ".res\t1, $00"; break;
				default: 
					if (member.getType().getName().endsWith("*")) suffix = ".res\t6, $00";
					else suffix = ".tag " + member.getType().getFullName();
					break;
				}
				assembly += "\t" + member.getName() + " " + suffix + "\n";
			}
			
			assembly += ".endstruct\n";
		}
		
		for (VariableNode variableNode : variables().values())
		{
			String suffix = null;
			
			switch (variableNode.getTypeName())
			{
			case "int": suffix = "\t.res\t4, $00"; break;
			case "char": suffix = "\t.res\t1, $00"; break;
			default: 
				if (variableNode.getTypeName().endsWith("*")) suffix = ".res\t6, $00";
				else suffix = ".tag " + variableNode.getType().getFullName();
				break;
			}
			
			assembly += variableNode.getFullName() + ": " + suffix + "\n";
		}
		return assembly;
	}
	
}
