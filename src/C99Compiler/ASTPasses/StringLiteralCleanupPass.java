// Created by Iacon1 on 11/09/2026.
// Trims redundant string literal constants produced in case non-constant string pointers need them.
// They're redunant if said pointer *is* constant.

package C99Compiler.ASTPasses;

import C99Compiler.CompilerNodes.TranslationUnitNode;
import C99Compiler.CompilerNodes.Declarations.DeclarationNode.InitDeclaratorPair;
import C99Compiler.ProgramState.ProgramState;

public class StringLiteralCleanupPass implements ASTPass
{
	@Override
	public void apply(TranslationUnitNode unit) throws Exception
	{
		for (InitDeclaratorPair decl : unit.getGlobalInitDeclarators())
		{
			if (decl.isROM(new ProgramState()))
				decl.init.checkKillStringLiteral();
		}
	}
}
