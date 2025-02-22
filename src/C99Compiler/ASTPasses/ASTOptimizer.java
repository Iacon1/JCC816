// Created by Iacon1 on 02/01/2025.
// AST Optimizer
package C99Compiler.ASTPasses;

import C99Compiler.CompilerNodes.TranslationUnitNode;

public class ASTOptimizer
{
	private ASTOptimizer() {} // Singleton
	
	public static void optimizeAST(TranslationUnitNode unit) throws Exception
	{
		// Call passes here
		new MultOptimizer().apply(unit);
	}
}
