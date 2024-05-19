// By Iacon1
// Created 05/06/2023
// The program itself.
package C99Compiler.CompilerNodes.Statements;

import org.antlr.v4.runtime.ParserRuleContext;

import C99Compiler.CompConfig;
import C99Compiler.CompConfig.DebugLevel;
import C99Compiler.CompilerNodes.ComponentNode;
import C99Compiler.CompilerNodes.InterpretingNode;
import C99Compiler.CompilerNodes.Interfaces.AssemblableNode;
import C99Compiler.CompilerNodes.LValues.VariableNode;
import C99Compiler.Utils.AssemblyUtils;
import C99Compiler.Utils.LineInfo;
import Grammar.C99.C99Parser.StatementContext;

public abstract class StatementNode<C extends ParserRuleContext> extends InterpretingNode<StatementNode<C>, C> implements AssemblableNode
{
	public StatementNode(ComponentNode<?> parent) {super(parent);}
	
	protected static StatementNode<?> manufacture(ComponentNode<?> parent, StatementContext node) throws Exception
	{
		if (node.labeled_statement() != null)
			return new LabeledStatementNode(parent).interpret(node.labeled_statement());
		else if (node.compound_statement() != null)
			return new CompoundStatementNode(parent).interpret(node.compound_statement());
		else if (node.expression_statement() != null)
			return new ExpressionStatementNode(parent).interpret(node.expression_statement());
		else if (node.selection_statement() != null)
			return new SelectionStatementNode(parent).interpret(node.selection_statement());
		else if (node.iteration_statement() != null)
			return new IterationStatementNode(parent).interpret(node.iteration_statement());
		else if (node.jump_statement() != null)
			return new JumpStatementNode(parent).interpret(node.jump_statement());
		else if (node.asm_statement() != null)
			return new AssemblyStatementNode(parent).interpret(node.asm_statement());
		else return null;
	}
	
	public void clearPossibleValues()
	{
		for (VariableNode var : getReferencedVariables().values())
			var.clearPossibleValues();
	}

	public abstract String getAssembly(int leadingWhitespace, String returnAddr) throws Exception;
	@Override public String getAssembly(int leadingWhitespace) throws Exception
	{
		if (getEnclosingFunction() != null)
			return getAssembly(leadingWhitespace, getEnclosingFunction().getEndLabel());
		else return getAssembly(leadingWhitespace, null);
	}
	
	public String labelLine(int leadingWhitespace, int lineNo)
	{
		if (DebugLevel.isAtLeast(DebugLevel.low))
		{
			LineInfo info = getTranslationUnit().getInfo(lineNo);
			return AssemblyUtils.getWhitespace(leadingWhitespace) + ".dbg\tline, \"" + CompConfig.rootFolder + "/" + info.filename + "\", " + info.line + "\n";
		}
		else return "";
	}
}
