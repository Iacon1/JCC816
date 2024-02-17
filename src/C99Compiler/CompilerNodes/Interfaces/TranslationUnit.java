// Created by Iacon1 on 02/14/2024.
// Generalized Translation Unit
package C99Compiler.CompilerNodes.Interfaces;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import C99Compiler.CompilerNodes.Declarations.InitializerNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;

public interface TranslationUnit extends Catalogger
{

	public LinkedHashMap<String, VariableNode> getGlobalVariables();
	public List<InitializerNode> getGlobalInitializers();
	public String getFilename();
	public Set<String> getIncludedStdLibs();
}
