// Created by Iacon1 on 02/02/2025.
// Passes over AST tree for high-level optimizations

package C99Compiler.ASTPasses;

import C99Compiler.CompilerNodes.TranslationUnitNode;

public interface ASTPass
{
	public void apply(TranslationUnitNode unit) throws Exception;
}
