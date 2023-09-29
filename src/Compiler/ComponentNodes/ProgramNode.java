// By Iacon1
// Created 05/06/2023
// The program itself.
package Compiler.ComponentNodes;

public class ProgramNode extends ComponentNode<ProgramNode>
{
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
			
			for (VarDeclarationNode member : typeNode.getMembers())
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
		
		for (VarDeclarationNode varDeclNode : variables().values())
		{
			String suffix = null;
			
			switch (varDeclNode.getTypeName())
			{
			case "int": suffix = "\t.res\t4, $00"; break;
			case "char": suffix = "\t.res\t1, $00"; break;
			default: 
				if (varDeclNode.getTypeName().endsWith("*")) suffix = "\t.res\t6, $00";
				else suffix = ".tag " + varDeclNode.getType().getFullName();
				break;
			}
			
			assembly += varDeclNode.getFullName() + ": " + suffix + "\n";
		}
		
		for (FunctionNode funcNode : functions().values())
		{
			assembly += funcNode.getFullName() + ": \n";
		}
		
		return assembly;
	}
	
}
