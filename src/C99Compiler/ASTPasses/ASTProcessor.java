// Created by Iacon1 on 02/01/2025.
// AST Optimizer
package C99Compiler.ASTPasses;

import C99Compiler.CompilerNodes.TranslationUnitNode;

public class ASTProcessor
{
	private ASTProcessor() {} // Singleton
	
	public static void processAST(TranslationUnitNode unit) throws Exception
	{
		new MultOptimizer().apply(unit);
	}
}
