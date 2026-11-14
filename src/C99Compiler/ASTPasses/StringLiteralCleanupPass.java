// Created by Iacon1 on 11/09/2026.
// Trims redundant string literal constants produced in case non-constant string pointers need them.
// They're redunant if said pointer *is* constant.

package C99Compiler.ASTPasses;

import java.util.LinkedList;
import java.util.List;

import C99Compiler.CompilerNodes.TranslationUnitNode;
import C99Compiler.CompilerNodes.Declarations.DeclarationNode.InitDeclaratorPair;
import C99Compiler.CompilerNodes.Declarations.InitializerNode;
import C99Compiler.ProgramState.ProgramState;

public class StringLiteralCleanupPass implements ASTPass
{
	@Override
	public void apply(TranslationUnitNode unit) throws Exception
	{
		List<InitializerNode> subList = new LinkedList<InitializerNode>(); // Avoid concurrent modification
		
		for (InitDeclaratorPair decl : unit.getGlobalInitDeclarators())
			if (decl.isROM(new ProgramState()))
				subList.add(decl.init);
		
		for (InitializerNode init : subList)
			init.checkKillStringLiteral();
	}
}
