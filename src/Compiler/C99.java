// By Iacon1
// Created 10/13/2023
// Initializes the grammar with C99 as per
// https://www.open-std.org/jtc1/sc22/wg14/www/docs/n1256.pdf, Annex A

package Compiler;

import java.util.Arrays;
import java.util.regex.Pattern;

import Grammar.GeneralGrammar;

public final class C99 {
	private static class EZRuleBuilderFactory {
		public class EZRuleBuilder {
			private GeneralGrammar<String, String>.RuleBuilder ruleBuilder;
			private boolean escapeRegex;

			public EZRuleBuilder() {
				ruleBuilder = grammar.getBuilder(name);
				escapeRegex = !defaultRegex;
			}

			public EZRuleBuilder addT(String terminal) {
				if (escapeRegex)
					terminal = Pattern.quote(terminal);
				ruleBuilder.addT(terminal);
				return this;
			}

			public EZRuleBuilder addTs(String... terminals) {
				if (terminals.length == 1)
					return addT(terminals[0]);
				else
					return addTs(Arrays.copyOf(terminals, terminals.length - 1)).addT(terminals[terminals.length - 1]);
			}

			public EZRuleBuilder addNT(String nonTerminal) {
				ruleBuilder.addNT(nonTerminal);
				return this;
			}

			public EZRuleBuilder addNTs(String... nonTerminals) {
				if (nonTerminals.length == 1)
					return addNT(nonTerminals[0]);
				else
					return addNTs(Arrays.copyOf(nonTerminals, nonTerminals.length - 1))
							.addT(nonTerminals[nonTerminals.length - 1]);
			}

			public EZRuleBuilder setRegex(boolean escapeRegex) {
				this.escapeRegex = escapeRegex;
				return this;
			}

			public EZRuleBuilder addBinary(String nt1, String nt2, String... Ts) {
				return addNT(nt1).addTs(Ts).addNT(nt2);
			}

			public EZRuleBuilder addBrackets(String t1, String t2, String... NTs) {
				return addT(t1).addNTs(NTs).addT(t2);
			}

			public void queue() {
				ruleBuilder.queue();
			}
		}

		private GeneralGrammar<String, String> grammar;
		private String name;
		private boolean defaultRegex;

		public EZRuleBuilderFactory(GeneralGrammar<String, String> grammar, String name, boolean isPrimary,
				boolean defaultRegex) {
			this.grammar = grammar;
			this.name = name;
			if (isPrimary)
				grammar.markPrimary(name);
			this.defaultRegex = defaultRegex;
		}

		public EZRuleBuilder getBuilder() {
			return new EZRuleBuilder();
		}
	}

	private static String[] keywords = { "auto", "break", "case", "char", "const", "continue", "default", "do",
			"double", "else", "enum", "extern", "float", "for", "goto", "if", "inline", "int", "long", "register",
			"restrict", "return", "short", "signed", "sizeof", "static", "struct", "switch", "typedef", "union",
			"unsigned", "void", "volatile", "while", "_Bool", "_Complex", "_Imaginary", "__attribute__", // NOT C99
																											// COMPLIANT
	};

	private static void initLexical(GeneralGrammar<String, String> grammar) {
		EZRuleBuilderFactory bFactory = new EZRuleBuilderFactory(grammar, "keyword", true, false);
		for (int i = 0; i < keywords.length; ++i)
			bFactory.getBuilder().addT(keywords[i]).queue();

		bFactory = new EZRuleBuilderFactory(grammar, "identifier", true, true);
		bFactory.getBuilder().addT("[a-zA-Z_][a-zA-Z0-9_]*").queue();
		
		bFactory = new EZRuleBuilderFactory(grammar, "constant", true, true);
		bFactory.getBuilder().addT("[0-9]+").queue();
		bFactory.getBuilder().addT("0[xX][0-9a-fA-F]+").queue();
		bFactory.getBuilder().addT("[0-9]+.[0-9]*").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "enumeration-constant", true, false);
		bFactory.getBuilder().addNT("identifier").queue();

		// [, (, ., +, -, ,, ,{, &, *, -, ~, !
	}

	private static void initPhrase(GeneralGrammar<String, String> grammar) {
		EZRuleBuilderFactory bFactory = new EZRuleBuilderFactory(grammar, "primary-expression", true, false);
		bFactory.getBuilder().addNT("identifier").queue();
		bFactory.getBuilder().addNT("constant").queue();
		bFactory.getBuilder().addNT("string-literal").queue();
		bFactory.getBuilder().addT("(").addNT("expression").addT(")").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "postfix-expression", true, false);
		bFactory.getBuilder().addNT("primary-expression").queue();
		bFactory.getBuilder().addNT("postfix-expression").addT("[").addNT("expression").addT("]").queue();
		bFactory.getBuilder().addNT("postfix-expression").addTs("(", ")").queue();
		bFactory.getBuilder().addNT("postfix-expression").addBrackets("(", ")", "argument-expression-list").queue();
		bFactory.getBuilder().addNT("postfix-expression").addT(".").addNT("identifier").queue();
		bFactory.getBuilder().addNT("postfix-expression").addTs("+", "+").queue();
		bFactory.getBuilder().addNT("postfix-expression").addTs("-", "-").queue();
		bFactory.getBuilder().addT("(").addNT("type-name").addT(")").addT("{").addNT("initializer-list").addT("}")
				.queue();
		bFactory.getBuilder().addT("(").addNT("type-name").addT(")").addT("{").addNT("initializer-list").addT(",")
				.addT("}").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "argument-expression-list", true, false);
		bFactory.getBuilder().addNT("assignment-expression").queue();
		bFactory.getBuilder().addNT("argument-expression-list").addT(",").addNT("assignment-expression").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "unary-expression", true, false);
		bFactory.getBuilder().addNT("postfix-expression").queue();
		bFactory.getBuilder().addTs("+", "+").addNT("unary-expression").queue();
		bFactory.getBuilder().addTs("-", "-").addNT("unary-expression").queue();
		bFactory.getBuilder().addT("&").addNT("cast-expression").queue();
		bFactory.getBuilder().addT("*").addNT("cast-expression").queue();
		bFactory.getBuilder().addT("+").addNT("cast-expression").queue();
		bFactory.getBuilder().addT("-").addNT("cast-expression").queue();
		bFactory.getBuilder().addT("~").addNT("cast-expression").queue();
		bFactory.getBuilder().addT("!").addNT("cast-expression").queue();
		bFactory.getBuilder().addT("sizeof").addNT("unary-expression").queue();
		bFactory.getBuilder().addT("sizeof").addT("(").addNT("type-name").addT(")").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "cast-expression", true, false);
		bFactory.getBuilder().addNT("unary-expression").queue();
		bFactory.getBuilder().addT("(").addNT("type-name").addT(")").addNT("cast-expression").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "multiplicative-expression", true, false);
		bFactory.getBuilder().addNT("cast-expression").queue();
		bFactory.getBuilder().addNT("multiplicative-expression").addT("*").addNT("cast-expression").queue();
		bFactory.getBuilder().addNT("multiplicative-expression").addT("/").addNT("cast-expression").queue();
		bFactory.getBuilder().addNT("multiplicative-expression").addT("%").addNT("cast-expression").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "additive-expression", true, false);
		bFactory.getBuilder().addNT("multiplicative-expression").queue();
		bFactory.getBuilder().addNT("additive-expression").addT("+").addNT("multiplicative-expression").queue();
		bFactory.getBuilder().addNT("additive-expression").addT("-").addNT("multiplicative-expression").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "shift-expression", true, false);
		bFactory.getBuilder().addNT("additive-expression").queue();
		bFactory.getBuilder().addNT("shift-expression").addTs("<", "<").addNT("additive-expression").queue();
		bFactory.getBuilder().addNT("shift-expression").addTs(">", ">").addNT("additive-expression").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "relational-expression", true, false);
		bFactory.getBuilder().addNT("shift-expression").queue();
		bFactory.getBuilder().addNT("relational-expression").addT("<").addNT("shift-expression").queue();
		bFactory.getBuilder().addNT("relational-expression").addT(">").addNT("shift-expression").queue();
		bFactory.getBuilder().addNT("relational-expression").addTs("<", "=").addNT("shift-expression").queue();
		bFactory.getBuilder().addNT("relational-expression").addTs(">", "=").addNT("shift-expression").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "equality-expression", true, false);
		bFactory.getBuilder().addNT("relational-expression").queue();
		bFactory.getBuilder().addNT("equality-expression").addTs("=", "=").addNT("relational-expression").queue();
		bFactory.getBuilder().addNT("equality-expression").addTs("!", "=").addNT("relational-expression").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "AND-expression", true, false);
		bFactory.getBuilder().addNT("equality-expression").queue();
		bFactory.getBuilder().addNT("AND-expression").addT("&").addNT("relational-expression").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "exclusive-OR-expression", true, false);
		bFactory.getBuilder().addNT("AND-expression").queue();
		bFactory.getBuilder().addNT("exclusive-OR-expression").addT("^").addNT("AND-expression").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "inclusive-OR-expression", true, false);
		bFactory.getBuilder().addNT("exclusive-OR-expression").queue();
		bFactory.getBuilder().addNT("inclusive-OR-expression").addT("|").addNT("exclusive-OR-expression").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "logical-AND-expression", true, false);
		bFactory.getBuilder().addNT("inclusive-OR-expression").queue();
		bFactory.getBuilder().addNT("logical-AND-expression").addTs("&", "&").addNT("inclusive-OR-expression").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "logical-OR-expression", true, false);
		bFactory.getBuilder().addNT("logical-AND-expression").queue();
		bFactory.getBuilder().addNT("logical-OR-expression").addTs("|", "|").addNT("logical-AND-expression").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "conditional-expression", true, false);
		bFactory.getBuilder().addNT("logical-OR-expression").queue();
		bFactory.getBuilder().addNT("logical-OR-expression").addT("?").addNT("expression").addT(":")
				.addNT("logical-OR-expression").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "assignment-expression", true, false);
		bFactory.getBuilder().addNT("conditional-expression").queue();
		bFactory.getBuilder().addNT("unary-expression").addT("=").addNT("assignment-expression").queue();
		bFactory.getBuilder().addNT("unary-expression").addTs("*", "=").addNT("assignment-expression").queue();
		bFactory.getBuilder().addNT("unary-expression").addTs("/", "=").addNT("assignment-expression").queue();
		bFactory.getBuilder().addNT("unary-expression").addTs("%", "=").addNT("assignment-expression").queue();
		bFactory.getBuilder().addNT("unary-expression").addTs("+", "=").addNT("assignment-expression").queue();
		bFactory.getBuilder().addNT("unary-expression").addTs("-", "=").addNT("assignment-expression").queue();
		bFactory.getBuilder().addNT("unary-expression").addTs("<", "<", "=").addNT("assignment-expression").queue();
		bFactory.getBuilder().addNT("unary-expression").addTs(">", ">", "=").addNT("assignment-expression").queue();
		bFactory.getBuilder().addNT("unary-expression").addTs("&", "=").addNT("assignment-expression").queue();
		bFactory.getBuilder().addNT("unary-expression").addTs("^", "=").addNT("assignment-expression").queue();
		bFactory.getBuilder().addNT("unary-expression").addTs("|", "=").addNT("assignment-expression").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "expression", true, false);
		bFactory.getBuilder().addNT("assignment-expression").queue();
		bFactory.getBuilder().addNT("expression").addT(",").addNT("conditional-expression").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "constant-expression", true, false);
		bFactory.getBuilder().addNT("conditional-expression").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "declaration", true, false);
		bFactory.getBuilder().addNT("declaration-specifiers").addT(";").queue();
		bFactory.getBuilder().addNT("declaration-specifiers").addNT("init-declarator-list").addT(";").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "declaration-specifiers", true, false);
		bFactory.getBuilder().addNT("storage-class-specifier").queue();
		bFactory.getBuilder().addNT("storage-class-specifier").addNT("declaration-specifiers").queue();
		bFactory.getBuilder().addNT("type-specifier").queue();
		bFactory.getBuilder().addNT("type-specifier").addNT("declaration-specifiers").queue();
		bFactory.getBuilder().addNT("function-specifier").queue();
		bFactory.getBuilder().addNT("function-specifier").addNT("declaration-specifiers").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "init-declarator-list", true, false);
		bFactory.getBuilder().addNT("init-declarator").queue();
		bFactory.getBuilder().addNT("init-declarator-list").addT(",").addNT("init-declarator").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "init-declarator", true, false);
		bFactory.getBuilder().addNT("declarator").queue();
		bFactory.getBuilder().addNT("declarator").addT("=").addNT("initializer").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "storage-class-specifier", true, false);
		bFactory.getBuilder().addT("typedef").queue();
		bFactory.getBuilder().addT("extern").queue();
		bFactory.getBuilder().addT("static").queue();
		bFactory.getBuilder().addT("auto").queue();
		bFactory.getBuilder().addT("register").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "type-specifier", true, false);
		bFactory.getBuilder().addT("void").queue();
		bFactory.getBuilder().addT("char").queue();
		bFactory.getBuilder().addT("short").queue();
		bFactory.getBuilder().addT("int").queue();
		bFactory.getBuilder().addT("long").queue();
		bFactory.getBuilder().addT("float").queue();
		bFactory.getBuilder().addT("double").queue();
		bFactory.getBuilder().addT("signed").queue();
		bFactory.getBuilder().addT("unsigned").queue();
		bFactory.getBuilder().addT("_Bool").queue();
		bFactory.getBuilder().addT("_Complex").queue();
		bFactory.getBuilder().addNT("struct-or-union-specifier").queue();
		bFactory.getBuilder().addNT("enum-specifier").queue();
		bFactory.getBuilder().addNT("typedef-name").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "struct-or-union-specifier", true, false);
		bFactory.getBuilder().addT("struct").addT("{").addNT("struct-declaration-list").addT("}").queue();
		bFactory.getBuilder().addT("union").addT("{").addNT("struct-declaration-list").addT("}").queue();
		bFactory.getBuilder().addT("struct").addNT("identifier").addT("{").addNT("struct-declaration-list").addT("}")
				.queue();
		bFactory.getBuilder().addT("union").addNT("identifier").addT("{").addNT("struct-declaration-list").addT("}")
				.queue();
		bFactory.getBuilder().addT("struct").addNT("identifier").queue();
		bFactory.getBuilder().addT("union").addNT("identifier").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "struct-declaration-list", true, false);
		bFactory.getBuilder().addNT("struct-declaration").queue();
		bFactory.getBuilder().addNT("struct-declaration-list").addNT("struct-declaration").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "struct-declaration", true, false);
		bFactory.getBuilder().addNT("specifier-qualifier-list").addNT("struct-declarator-list").addT(";").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "specifier-qualifier-list", true, false);
		bFactory.getBuilder().addNT("type-specifier").queue();
		bFactory.getBuilder().addNT("type-specifier").addNT("specifier-qualifier-list").queue();
		bFactory.getBuilder().addNT("type-qualifier").queue();
		bFactory.getBuilder().addNT("type-qualifier").addNT("specifier-qualifier-list").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "struct-declarator-list", true, false);
		bFactory.getBuilder().addNT("struct-declarator").queue();
		bFactory.getBuilder().addNT("struct-declarator-list").addT(",").addNT("struct-declarator").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "struct-declarator", true, false);
		bFactory.getBuilder().addNT("declarator").queue();
		bFactory.getBuilder().addT(":").addNT("constant-expression").queue();
		bFactory.getBuilder().addNT("declarator").addT(":").addNT("constant-expression").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "enum-specifier", true, false);
		bFactory.getBuilder().addT("enum").addT("{").addNT("enumerator-list").addT("}").queue();
		bFactory.getBuilder().addT("enum").addNT("identifier").addT("{").addNT("enumerator-list").addT("}").queue();
		bFactory.getBuilder().addT("enum").addT("{").addNT("enumerator-list").addT(",").addT("}").queue();
		bFactory.getBuilder().addT("enum").addNT("identifier").addT("{").addNT("enumerator-list").addT(",").addT("}")
				.queue();
		bFactory.getBuilder().addT("enum").addNT("identifier").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "enumerator-list", true, false);
		bFactory.getBuilder().addNT("enumerator").queue();
		bFactory.getBuilder().addNT("enumerator-list").addT(",").addNT("enumerator").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "enumerator", true, false);
		bFactory.getBuilder().addNT("enumeration-constant").queue();
		bFactory.getBuilder().addNT("enumeration-constant").addT("=").addNT("constant-expression").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "type-qualifier", false, false);
		bFactory.getBuilder().addT("const").queue();
		bFactory.getBuilder().addT("restrict").queue();
		bFactory.getBuilder().addT("volatile").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "function-specifier", false, false);
		bFactory.getBuilder().addT("inline").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "declarator", true, false);
		bFactory.getBuilder().addNT("direct-declarator").queue();
		bFactory.getBuilder().addNT("pointer").addNT("direct-declarator").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "direct-declarator", true, false);
		bFactory.getBuilder().addNT("identifier").queue();
		bFactory.getBuilder().addBrackets("(", ")", "declarator").queue();
		bFactory.getBuilder().addNT("direct-declarator").addTs("[", "]").queue();
		bFactory.getBuilder().addNT("direct-declarator").addBrackets("[", "]", "type-qualifier-list").queue();
		bFactory.getBuilder().addNT("direct-declarator").addBrackets("[", "]", "assignment-expression").queue();
		bFactory.getBuilder().addNT("direct-declarator")
				.addBrackets("[", "]", "type-qualifier-list", "assignment-expression").queue();
		bFactory.getBuilder().addNT("direct-declarator").addTs("[", "static").addNT("assignment-expression").addT("]")
				.queue();
		bFactory.getBuilder().addNT("direct-declarator").addTs("[", "static").addNT("type-qualifier-list")
				.addNT("assignment-expression").addT("]").queue();
		bFactory.getBuilder().addNT("direct-declarator").addT("[").addNT("type-qualifier-list").addT("static")
				.addNT("assignment-expression").addT("]").queue();
		bFactory.getBuilder().addNT("direct-declarator").addTs("[", "*", "]").queue();
		bFactory.getBuilder().addNT("direct-declarator").addT("[").addNT("type-qualifier-list").addTs("*", "]").queue();
		bFactory.getBuilder().addNT("direct-declarator").addBrackets("(", ")", "parameter-type-list").queue();
		bFactory.getBuilder().addNT("direct-declarator").addTs("(", ")").queue();
		bFactory.getBuilder().addNT("direct-declarator").addBrackets("(", ")", "identifier-list").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "pointer", true, false);
		bFactory.getBuilder().addT("*").queue();
		bFactory.getBuilder().addT("*").addNT("type-qualifier-list").queue();
		bFactory.getBuilder().addT("*").addNT("pointer").queue();
		bFactory.getBuilder().addT("*").addNT("type-qualifier-list").addNT("pointer").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "type-qualifier-list", true, false);
		bFactory.getBuilder().addNT("type-qualifier").queue();
		bFactory.getBuilder().addNT("type-qualifier-list").addNT("type-qualifier").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "parameter-type-list", true, false);
		bFactory.getBuilder().addNT("parameter-list").queue();
		bFactory.getBuilder().addNT("parameter-list").addTs(",", ".", ".", ".").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "parameter-list", true, false);
		bFactory.getBuilder().addNT("parameter-declaration").queue();
		bFactory.getBuilder().addBinary("parameter-list", "parameter-declaration", ",").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "parameter-declaration", true, false);
		bFactory.getBuilder().addNT("declaration-specifiers").addNT("declarator").queue();
		bFactory.getBuilder().addNT("declaration-specifiers").queue();
		bFactory.getBuilder().addNT("declaration-specifiers").addNT("abstract-declarator").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "identifier-list", true, false);
		bFactory.getBuilder().addNT("identifier").queue();
		bFactory.getBuilder().addBinary("identifier-list", "identifier", ",").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "type-name", true, false);
		bFactory.getBuilder().addNT("specifier-qualifier-list").queue();
		bFactory.getBuilder().addNT("specifier-qualifier-list").addNT("abstract-declarator").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "abstract-declarator", true, false);
		bFactory.getBuilder().addNT("pointer").queue();
		bFactory.getBuilder().addNT("direct-abstract-declarator").queue();
		bFactory.getBuilder().addNT("pointer").addNT("direct-abstract-declarator").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "direct-abstract-declarator", true, false);
		bFactory.getBuilder().addBrackets("(", ")", "abstract-declarator").queue();

		bFactory.getBuilder().addTs("[", "]").queue();
		bFactory.getBuilder().addBrackets("[", "]", "type-qualifier-list").queue();
		bFactory.getBuilder().addBrackets("[", "]", "assignment-expression").queue();
		bFactory.getBuilder().addBrackets("[", "]", "type-qualifier-list", "assignment-expression").queue();
		bFactory.getBuilder().addNT("direct-abstract-declarator").addTs("[", "]").queue();
		bFactory.getBuilder().addNT("direct-abstract-declarator").addBrackets("[", "]", "type-qualifier-list").queue();
		bFactory.getBuilder().addNT("direct-abstract-declarator").addBrackets("[", "]", "assignment-expression")
				.queue();
		bFactory.getBuilder().addNT("direct-abstract-declarator")
				.addBrackets("[", "]", "type-qualifier-list", "assignment-expression").queue();

		bFactory.getBuilder().addTs("[", "static").addNT("assignment-expression").addT("]").queue();
		bFactory.getBuilder().addTs("[", "static").addNT("type-qualifier-list").addNT("assignment-expression").addT("]")
				.queue();
		bFactory.getBuilder().addNT("direct-abstract-declarator").addTs("[", "static").addNT("assignment-expression")
				.addT("]").queue();
		bFactory.getBuilder().addNT("direct-abstract-declarator").addTs("[", "static").addNT("type-qualifier-list")
				.addNT("assignment-expression").addT("]").queue();

		bFactory.getBuilder().addT("[").addNT("type-qualifier-list").addT("static").addNT("assignment-expression")
				.addT("]").queue();
		bFactory.getBuilder().addNT("direct-abstract-declarator").addT("[").addNT("type-qualifier-list").addT("static")
				.addNT("assignment-expression").addT("]").queue();

		bFactory.getBuilder().addTs("[", "*", "]").queue();
		bFactory.getBuilder().addNT("direct-abstract-declarator").addTs("[", "*", "]").queue();

		bFactory.getBuilder().addTs("(", ")").queue();
		bFactory.getBuilder().addBrackets("(", ")", "parameter-type-list").queue();
		bFactory.getBuilder().addNT("direct-abstract-declarator").addTs("(", ")").queue();
		bFactory.getBuilder().addNT("direct-abstract-declarator").addBrackets("(", ")", "parameter-type-list").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "typedef-name", true, false);
		bFactory.getBuilder().addNT("identifier").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "initializer", true, false);
		bFactory.getBuilder().addNT("assignment-expression").queue();
		bFactory.getBuilder().addBrackets("(", ")", "assignment-expression").queue();
		bFactory.getBuilder().addT("(").addNT("assignment-expression").addTs(",", "}").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "initializer-list", true, false);
		bFactory.getBuilder().addNT("initializer").queue();
		bFactory.getBuilder().addNT("designation").addNT("initializer").queue();
		bFactory.getBuilder().addBinary("initializer-list", "initializer", ",").queue();
		bFactory.getBuilder().addBinary("initializer-list", "designation", ",").addNT("initializer").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "designation", true, false);
		bFactory.getBuilder().addNT("designator-list").addT("=").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "designator-list", true, false);
		bFactory.getBuilder().addNT("designation").queue();
		bFactory.getBuilder().addNT("designator-list").addNT("designation").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "designator", true, false);
		bFactory.getBuilder().addBrackets("[", "]", "constant-expression").queue();
		bFactory.getBuilder().addT(".").addNT("identifier").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "statement", true, false);
		bFactory.getBuilder().addNT("labeled-statement").queue();
		bFactory.getBuilder().addNT("compound-statement").queue();
		bFactory.getBuilder().addNT("expression-statement").queue();
		bFactory.getBuilder().addNT("selection-statement").queue();
		bFactory.getBuilder().addNT("iteration-statement").queue();
		bFactory.getBuilder().addNT("jump-statement").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "labeled-statement", true, false);
		bFactory.getBuilder().addNT("identifier").addT(":").addNT("statement").queue();
		bFactory.getBuilder().addT("case").addNT("constant-expression").addT(":").addNT("statement").queue();
		bFactory.getBuilder().addT("default").addT(":").addNT("statement").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "compound-statement", true, false);
		bFactory.getBuilder().addTs("{", "}").queue();
		bFactory.getBuilder().addBrackets("{", "}", "block-item-list").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "block-item-list", true, false);
		bFactory.getBuilder().addNT("block-item").queue();
		bFactory.getBuilder().addNT("block-item-list").addNT("block-item").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "block-item", true, false);
		bFactory.getBuilder().addNT("declaration").queue();
		bFactory.getBuilder().addNT("statement").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "expression-statement", true, false);
		bFactory.getBuilder().addNT("expression").addT(";").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "selection-statement", true, false);
		bFactory.getBuilder().addT("if").addBrackets("(", ")", "expression").addNT("statement").queue();
		bFactory.getBuilder().addT("if").addBrackets("(", ")", "expression").addT("else").addNT("statement").queue();
		bFactory.getBuilder().addT("switch").addBrackets("(", ")", "expression").addNT("statement").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "iteration-statement", true, false);
		bFactory.getBuilder().addT("while").addBrackets("(", ")", "expression").addNT("statement").queue();
		bFactory.getBuilder().addT("do").addNT("statement").addT("while").addBrackets("(", ")", "expression").addT(";")
				.queue();

		bFactory.getBuilder().addT("for").addTs("(", ";", ";", ")").addNT("statement").queue();
		bFactory.getBuilder().addT("for").addTs("(", ";", ";").addNT("expression").addT(")").addNT("statement").queue();
		bFactory.getBuilder().addT("for").addTs("(", ";").addNT("expression").addTs(";", ")").addNT("statement")
				.queue();
		bFactory.getBuilder().addT("for").addTs("(", ";").addNT("expression").addT(";").addNT("expression").addT(")")
				.addNT("statement").queue();
		bFactory.getBuilder().addT("for").addT("(").addNT("expression").addTs(";", ";", ")").addNT("statement").queue();
		bFactory.getBuilder().addT("for").addT("(").addNT("expression").addTs(";", ";").addNT("expression").addT(")")
				.addNT("statement").queue();
		bFactory.getBuilder().addT("for").addT("(").addNT("expression").addT(";").addNT("expression").addTs(";", ")")
				.addNT("statement").queue();
		bFactory.getBuilder().addT("for").addT("(").addNT("expression").addT(";").addNT("expression").addT(";")
				.addNT("expression").addT(")").addNT("statement").queue();

		bFactory.getBuilder().addT("for").addT("(").addNT("declaration").addTs(";", ")").addNT("statement").queue();
		bFactory.getBuilder().addT("for").addT("(").addNT("declaration").addT(";").addNT("expression").addT(")")
				.addNT("statement").queue();
		bFactory.getBuilder().addT("for").addT("(").addNT("declaration").addNT("expression").addTs(";", ")")
				.addNT("statement").queue();
		bFactory.getBuilder().addT("for").addT("(").addNT("declaration").addNT("expression").addT(";")
				.addNT("expression").addT(")").addNT("statement").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "jump-statement", true, false);
		bFactory.getBuilder().addT("goto").addNT("identifier").addT(";").queue();
		bFactory.getBuilder().addT("continue").addT(";").queue();
		bFactory.getBuilder().addT("break").addT(";").queue();
		bFactory.getBuilder().addT("return").addT(";").queue();
		bFactory.getBuilder().addT("return").addNT("expression").addT(";").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "translation-unit", true, false);
		bFactory.getBuilder().addNT("external-declaration").queue();
		bFactory.getBuilder().addNT("translation-unit").addNT("external-declaration").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "external-declaration", true, false);
		bFactory.getBuilder().addNT("function-definition").queue();
		bFactory.getBuilder().addNT("declaration").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "function-definition", true, false);
		bFactory.getBuilder().addNT("declaration-specifiers").addNT("declarator").addNT("compound-statement").queue();
		bFactory.getBuilder().addNT("declaration-specifiers").addNT("declarator").addNT("declaration-list")
				.addNT("compound-statement").queue();

		bFactory = new EZRuleBuilderFactory(grammar, "declaration-list", true, false);
		bFactory.getBuilder().addNT("declaration").queue();
		bFactory.getBuilder().addNT("declaration-list").addNT("declaration").queue();
	}

	public static void initGrammar(GeneralGrammar<String, String> grammar)
	{
		initLexical(grammar);
		initPhrase(grammar);
		grammar.updateCNF();
	}
}
