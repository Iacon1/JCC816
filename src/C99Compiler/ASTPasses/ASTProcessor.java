// Created by Iacon1 on 02/01/2025.
// AST Optimizer
package C99Compiler.ASTPasses;

import C99Compiler.CompilerNodes.TranslationUnitNode;

public class ASTProcessor
{
	private ASTProcessor() {} // Singleton
	
	public static void processAST(TranslationUnitNode unit) throws Exception
	{
		new FloatAddPass().apply(unit);
		new FloatMultPass().apply(unit);
		new FloatCompPass().apply(unit);
		new FloatNegPass().apply(unit);
		new FloatCastPass().apply(unit);
		new MultOptimizer().apply(unit);
	}
}
