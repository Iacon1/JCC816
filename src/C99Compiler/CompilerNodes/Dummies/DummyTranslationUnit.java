// Created by Iacon1 on 08/18/2024.
// Just to show up on the debug listing

package C99Compiler.CompilerNodes.Dummies;

import AsmBuilder.AssemblyUnit;
import C99Compiler.CompilerNodes.Interfaces.TranslationUnit;

public class DummyTranslationUnit extends AssemblyUnit implements TranslationUnit
{
	public DummyTranslationUnit(String filename)
	{
		super(filename, "");
	}

}
