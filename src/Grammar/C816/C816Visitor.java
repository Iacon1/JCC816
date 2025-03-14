// Generated from I:/Coding Projects/JCC816/src/Grammar/C816.g4 by ANTLR 4.13.1
package Grammar.C816;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link C816Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface C816Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link C816Parser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(C816Parser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link C816Parser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(C816Parser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link C816Parser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(C816Parser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C816Parser#preprocInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreprocInstruction(C816Parser.PreprocInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C816Parser#macroInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacroInstruction(C816Parser.MacroInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C816Parser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(C816Parser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link C816Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(C816Parser.ProgramContext ctx);
}