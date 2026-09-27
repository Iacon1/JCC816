// By Iacon1
// Created 10/01/2023
// An exception denoting a feature that is included in C99 but for whatever reason does not compile here.

package C99Compiler.Exceptions;

import org.antlr.v4.runtime.Token;

import C99Compiler.CompConfig;
import C99Compiler.CompilerNodes.ComponentNode;

public class UnsupportedFeatureException extends TokenException
{
	/***
	 * An exception denoting a feature that is included in C99 but for whatever reason does not compile here.
	 * @param feature The feature that is not supported.
	 * @param useIs Whether it'd be grammatically correct to say "[feature] is" or "[feature] are".
	 * @param location Where in the code the unsupported feature was found.
	 * @param context The node of the AST throwing this.
	 */
	public UnsupportedFeatureException(String feature, boolean useIs, Token location, ComponentNode<?> context)
	{
		super(feature + " " + (useIs ? "is" : "are") + " not supported on version " + CompConfig.version + ".", location, context);
	}
	/***
	 * An exception denoting a feature that is included in C99 but for whatever reason does not compile here.
	 * @param feature The feature that is not supported.
	 * @param useIs Whether it'd be grammatically correct to say "[feature] is" or "[feature] are".
	 * @param int line Which line in the code the unsupported feature was found.
	 * @param int charPositionInLine Which position in the line the unsupported feature was found.
	 * @param context The node of the AST throwing this.
	 */
	public UnsupportedFeatureException(String feature, boolean useIs, int line, int charPositionInLine, ComponentNode<?> context)
	{
		super(feature + " " + (useIs ? "is" : "are") + " not supported on version " + CompConfig.version + ".", line, charPositionInLine, "", context);
	}
}
