// Created by Iacon1 on 2/7/2022.
// Compiler

package C99Compiler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import C99Compiler.CompConfig.VerbosityLevel;
import C99Compiler.ASTPasses.ASTOptimizer;
import C99Compiler.CompilerNodes.TranslationUnitNode;
import C99Compiler.CompilerNodes.Statements.CompoundStatementNode;
import C99Compiler.Utils.LineInfo;
import C99Compiler.Utils.ProgramState;
import Grammar.C99.C99Lexer;
import Grammar.C99.C99Parser;
import Grammar.C99.C99Parser.Compound_statementContext;
import Grammar.C99.C99Parser.DeclarationContext;
import Grammar.C99.C99Parser.Direct_declaratorContext;
import Grammar.C99.C99Parser.Init_declaratorContext;
import Grammar.C99.C99Parser.Init_declarator_listContext;
import Grammar.C99.C99Parser.Storage_class_specifierContext;
import Grammar.C99.C99Parser.Translation_unitContext;
import Logging.Logging;
import Shared.Header;

public class C99Compiler
{
	private static String currFilename;
	private static List<String> currTypedefs = new LinkedList<String>(); // Typedefs for this module
	
	public static void registerTypedef(String typedef)
	{
		currTypedefs.add(typedef);
	}
	public static void tryRegisterTypedef(ParserRuleContext context) // See if a context is a typedef declaration and, if so, add it to the list.
	{
		if (DeclarationContext.class.isAssignableFrom(context.getClass()))
		{
			DeclarationContext c = (DeclarationContext) context;
			if (c.declaration_specifiers() != null)
			{
				boolean isTypedef = false;
				// Does this declaration context the specifier "typedef"?
				for (Storage_class_specifierContext i : c.declaration_specifiers().storage_class_specifier())
				{
					if (i.getText().equals("typedef"))
					{
						isTypedef = true;
						break;
					}
				}
				// If so, for each declarator...
				if (isTypedef && c.init_declarator_list() != null)
				{
					// Each declarator is one typedef
					for (Init_declaratorContext i : c.init_declarator_list().init_declarator())
					{
						Direct_declaratorContext j = i.declarator().direct_declarator();
						do
						{
							if (j.identifier() != null)
								registerTypedef(j.identifier().getText());
							else if (j.direct_declarator() != null)
								j = j.direct_declarator();
							else
								j = null;
						}
						while (j != null && j.identifier() == null);
					}
				}
			}
		}
	}
	public static boolean hasTypedef(String typedef) 
	{
		return currTypedefs.contains(typedef);
	}
	
	private static void printInfo(Object... info)
	{
		for (int i = 0; i < info.length; ++i) Logging.logNotice(info[i].toString() + (i == info.length - 1 ? "" : ", ") + "\n");
	}
	
	private static CommonTokenStream lex(String source)
	{
		C99Lexer lexer = new C99Lexer(CharStreams.fromString(source));
		
		return new CommonTokenStream(lexer);
	}
	private static TranslationUnitNode parse(String filename, List<LineInfo> lineInfo, CommonTokenStream tokens) throws Exception
	{
		currTypedefs.clear();
		SyntaxErrorCollector collector = new SyntaxErrorCollector();
		C99Parser parser = new C99Parser(tokens);
		parser.removeErrorListeners(); // Removes default error listener
		parser.addErrorListener(collector);
		
		Translation_unitContext tree = parser.translation_unit();
		if (CompConfig.showParseTree)
			Logging.viewParseTree(parser, tree);
		if (collector.getException() != null) throw collector.getException();
		return new TranslationUnitNode(filename, lineInfo).interpret(tree);
	}
	private static CompoundStatementNode parseSnippet(CommonTokenStream tokens) throws Exception
	{
		SyntaxErrorCollector collector = new SyntaxErrorCollector();
		C99Parser parser = new C99Parser(tokens);
		parser.removeErrorListeners(); // Removes default error listener
		parser.addErrorListener(collector);
		
		Compound_statementContext tree = parser.compound_statement();
		if (CompConfig.showParseTree)
			Logging.viewParseTree(parser, tree);
		if (collector.getException() != null) throw collector.getException();
		return new CompoundStatementNode(new TranslationUnitNode("INTERNAL", null)).interpret(tree);
	}
		
	public static TranslationUnitNode compile(String filename, String file, Header header, boolean isStd) throws Exception
	{ 
		currFilename = filename;
		Set<String> includedStdLibs = new HashSet<String>();
		Set<String> includedOtherLibs = new HashSet<String>();
		List<LineInfo> lineInfo = new ArrayList<LineInfo>();
		long t = System.currentTimeMillis();

		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Compiling " + filename + "...");
		
		String source = Preprocessor.preprocess(includedStdLibs, includedOtherLibs, lineInfo, filename, file, header, isStd);
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Precompiled in " + (System.currentTimeMillis() - t) + " ms. Source length: " + source.length() + ".");
		t = System.currentTimeMillis();
		
		CommonTokenStream tokens = lex(source);
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Lexed in " + (System.currentTimeMillis() - t) + " ms. Tokens: " + tokens.getNumberOfOnChannelTokens() + ".");
		t = System.currentTimeMillis();

		TranslationUnitNode unit = parse(filename, lineInfo, tokens);
		unit.includeStdLibs(includedStdLibs);
		unit.includeOtherLibs(includedOtherLibs);
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Parsed in " + (System.currentTimeMillis() - t) + " ms.");
		
		t = System.currentTimeMillis();

		ASTOptimizer.optimizeAST(unit);
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Optimized in " + (System.currentTimeMillis() - t) + " ms.");
		
		if (VerbosityLevel.isAtLeast(VerbosityLevel.medium))
			printInfo("Compilation done.");

		return unit;
	}
	public static TranslationUnitNode compile(String filename, String file, boolean isStd) throws Exception
	{ 
		return compile(filename, file, null, isStd);
	}
	
	/** A scaled-down version of the compilation process, immediately returning the ASM instead of a translation unit node.
	 * 
	 * @param source The C code to read. Should be a self-contained Compound statement with no preprocessor directives.
	 * @param parameters Parameters injected into the C code via java format symbols (i. e. %1$s).
	 * @return The ASM equivalent of the C code provided.
	 * @throws Exception
	 */
	public static String compileSnippet(ProgramState startState, String source, Object... parameters) throws Exception
	{ 
		source = Preprocessor.removeComments(source);
		CommonTokenStream tokens = lex(source.formatted(parameters));
		CompoundStatementNode statement = parseSnippet(tokens);

		return statement.getAssembly(startState);
	}
	
	public static String getCurrFilename()
	{
		return currFilename;
	}
	
}
