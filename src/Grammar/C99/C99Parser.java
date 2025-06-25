// Generated from I:/Coding Projects/JCC816/src/Grammar/C99.g4 by ANTLR 4.13.1
package Grammar.C99;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class C99Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Auto=1, Break=2, Case=3, Char=4, Const=5, Continue=6, Default=7, Do=8, 
		Double=9, Else=10, Enum=11, Extern=12, Float=13, For=14, Goto=15, If=16, 
		Inline=17, Int=18, Long=19, Register=20, Restrict=21, Return=22, Short=23, 
		Signed=24, Sizeof=25, Static=26, Struct=27, Switch=28, Typedef=29, Union=30, 
		Unsigned=31, Void=32, Volatile=33, While=34, Bool=35, Complex=36, Imaginary=37, 
		Asm=38, Defined=39, Define=40, Ifdef=41, Ifndef=42, Elif=43, Endif=44, 
		Include=45, Undef=46, Line=47, Error=48, Pragma=49, HasEmbed=50, Embed=51, 
		Offsetof=52, SRAM=53, RWTWICE=54, ROTWICE=55, WOTWICE=56, TwoMCo=57, ThreeP=58, 
		Arrow=59, Incrmn=60, Decrmn=61, LssLss=62, GrtGrt=63, LessTh=64, GretTh=65, 
		LessEq=66, GretEq=67, Equal=68, NotEql=69, AmpAmp=70, OrOr=71, MulAsg=72, 
		DivAsg=73, ModAsg=74, PluAsg=75, SubAsg=76, LShAsg=77, RShAsg=78, AndAsg=79, 
		XorAsg=80, OrAsg=81, TwoHsh=82, LessCo=83, GretCo=84, LessMd=85, GretMd=86, 
		ModCol=87, TwoLSB=88, TwoRSB=89, Amper=90, Star=91, Plus=92, Minus=93, 
		Tilde=94, Excla=95, BckSla=96, Percnt=97, Xor=98, Or=99, Colon=100, Semico=101, 
		Period=102, Questi=103, Assign=104, Comma=105, HashTg=106, LeSqBr=107, 
		RiSqBr=108, LeRoBr=109, RiRoBr=110, LeCuBr=111, RiCuBr=112, WS=113, NLS=114, 
		NL=115, Identifier=116, Constant=117, Character_constant=118, String_literal=119, 
		Header_name=120;
	public static final int
		RULE_dummy = 0, RULE_identifier = 1, RULE_primary_expression = 2, RULE_postfix_expression = 3, 
		RULE_argument_expression_list = 4, RULE_unary_expression = 5, RULE_cast_expression = 6, 
		RULE_multiplicative_expression = 7, RULE_additive_expression = 8, RULE_shift_expression = 9, 
		RULE_relational_expression = 10, RULE_equality_expression = 11, RULE_and_expression = 12, 
		RULE_xor_expression = 13, RULE_or_expression = 14, RULE_land_expression = 15, 
		RULE_lor_expression = 16, RULE_conditional_expression = 17, RULE_assignment_expression = 18, 
		RULE_expression = 19, RULE_constant_expression = 20, RULE_attributes_declaration = 21, 
		RULE_declaration = 22, RULE_declaration_specifiers = 23, RULE_storage_class_specifier = 24, 
		RULE_function_specifier = 25, RULE_init_declarator_list = 26, RULE_init_declarator = 27, 
		RULE_type_specifier = 28, RULE_struct_or_union_specifier = 29, RULE_struct_declaration_list = 30, 
		RULE_struct_declaration = 31, RULE_specifier_qualifier_list = 32, RULE_struct_declarator_list = 33, 
		RULE_struct_declarator = 34, RULE_enum_specifier = 35, RULE_enumerator_list = 36, 
		RULE_enumerator = 37, RULE_type_qualifier = 38, RULE_declarator = 39, 
		RULE_direct_declarator = 40, RULE_pointer = 41, RULE_type_qualifier_list = 42, 
		RULE_parameter_type_list = 43, RULE_parameter_list = 44, RULE_parameter_declaration = 45, 
		RULE_identifier_list = 46, RULE_type_name = 47, RULE_abstract_declarator = 48, 
		RULE_direct_abstract_declarator = 49, RULE_typedef_name = 50, RULE_initializer = 51, 
		RULE_initializer_list = 52, RULE_designation = 53, RULE_designator_list = 54, 
		RULE_designator = 55, RULE_statement = 56, RULE_labeled_statement = 57, 
		RULE_compound_statement = 58, RULE_block_item_list = 59, RULE_block_item = 60, 
		RULE_expression_statement = 61, RULE_selection_statement = 62, RULE_iteration_statement = 63, 
		RULE_jump_statement = 64, RULE_asm_statement = 65, RULE_translation_unit = 66, 
		RULE_external_declaration = 67, RULE_function_definition = 68, RULE_declaration_list = 69;
	private static String[] makeRuleNames() {
		return new String[] {
			"dummy", "identifier", "primary_expression", "postfix_expression", "argument_expression_list", 
			"unary_expression", "cast_expression", "multiplicative_expression", "additive_expression", 
			"shift_expression", "relational_expression", "equality_expression", "and_expression", 
			"xor_expression", "or_expression", "land_expression", "lor_expression", 
			"conditional_expression", "assignment_expression", "expression", "constant_expression", 
			"attributes_declaration", "declaration", "declaration_specifiers", "storage_class_specifier", 
			"function_specifier", "init_declarator_list", "init_declarator", "type_specifier", 
			"struct_or_union_specifier", "struct_declaration_list", "struct_declaration", 
			"specifier_qualifier_list", "struct_declarator_list", "struct_declarator", 
			"enum_specifier", "enumerator_list", "enumerator", "type_qualifier", 
			"declarator", "direct_declarator", "pointer", "type_qualifier_list", 
			"parameter_type_list", "parameter_list", "parameter_declaration", "identifier_list", 
			"type_name", "abstract_declarator", "direct_abstract_declarator", "typedef_name", 
			"initializer", "initializer_list", "designation", "designator_list", 
			"designator", "statement", "labeled_statement", "compound_statement", 
			"block_item_list", "block_item", "expression_statement", "selection_statement", 
			"iteration_statement", "jump_statement", "asm_statement", "translation_unit", 
			"external_declaration", "function_definition", "declaration_list"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'auto'", "'break'", "'case'", "'char'", "'const'", "'continue'", 
			"'default'", "'do'", "'double'", "'else'", "'enum'", "'extern'", "'float'", 
			"'for'", "'goto'", "'if'", "'inline'", "'int'", "'long'", "'register'", 
			"'restrict'", "'return'", "'short'", "'signed'", "'sizeof'", "'static'", 
			"'struct'", "'switch'", "'typedef'", "'union'", "'unsigned'", "'void'", 
			"'volatile'", "'while'", "'_Bool'", "'_Complex'", "'_Imaginary'", "'asm'", 
			"'defined'", "'define'", "'ifdef'", "'ifndef'", "'elif'", "'endif'", 
			"'include'", "'undef'", "'line'", "'error'", "'pragma'", "'__has_embed'", 
			"'embed'", "'__offset_of'", "'__SRAM'", "'__RWTWICE'", "'__ROTWICE'", 
			"'__WOTWICE'", "'%:%:'", "'...'", "'->'", "'++'", "'--'", "'<<'", "'>>'", 
			"'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", "'||'", "'*='", 
			"'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", 
			"'##'", "'<:'", "':>'", "'<%'", "'%>'", "'%:'", "'[['", "']]'", "'&'", 
			"'*'", "'+'", "'-'", "'~'", "'!'", "'/'", "'%'", "'^'", "'|'", "':'", 
			"';'", "'.'", "'?'", "'='", "','", "'#'", "'['", "']'", "'('", "')'", 
			"'{'", "'}'", null, null, "'\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Auto", "Break", "Case", "Char", "Const", "Continue", "Default", 
			"Do", "Double", "Else", "Enum", "Extern", "Float", "For", "Goto", "If", 
			"Inline", "Int", "Long", "Register", "Restrict", "Return", "Short", "Signed", 
			"Sizeof", "Static", "Struct", "Switch", "Typedef", "Union", "Unsigned", 
			"Void", "Volatile", "While", "Bool", "Complex", "Imaginary", "Asm", "Defined", 
			"Define", "Ifdef", "Ifndef", "Elif", "Endif", "Include", "Undef", "Line", 
			"Error", "Pragma", "HasEmbed", "Embed", "Offsetof", "SRAM", "RWTWICE", 
			"ROTWICE", "WOTWICE", "TwoMCo", "ThreeP", "Arrow", "Incrmn", "Decrmn", 
			"LssLss", "GrtGrt", "LessTh", "GretTh", "LessEq", "GretEq", "Equal", 
			"NotEql", "AmpAmp", "OrOr", "MulAsg", "DivAsg", "ModAsg", "PluAsg", "SubAsg", 
			"LShAsg", "RShAsg", "AndAsg", "XorAsg", "OrAsg", "TwoHsh", "LessCo", 
			"GretCo", "LessMd", "GretMd", "ModCol", "TwoLSB", "TwoRSB", "Amper", 
			"Star", "Plus", "Minus", "Tilde", "Excla", "BckSla", "Percnt", "Xor", 
			"Or", "Colon", "Semico", "Period", "Questi", "Assign", "Comma", "HashTg", 
			"LeSqBr", "RiSqBr", "LeRoBr", "RiRoBr", "LeCuBr", "RiCuBr", "WS", "NLS", 
			"NL", "Identifier", "Constant", "Character_constant", "String_literal", 
			"Header_name"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "C99.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public C99Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DummyContext extends ParserRuleContext {
		public Translation_unitContext translation_unit() {
			return getRuleContext(Translation_unitContext.class,0);
		}
		public DummyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dummy; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitDummy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DummyContext dummy() throws RecognitionException {
		DummyContext _localctx = new DummyContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_dummy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			translation_unit();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(C99Parser.Identifier, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			if (!(!C99Compiler.C99Compiler.hasTypedef(getCurrentToken().getText()))) throw new FailedPredicateException(this, "!C99Compiler.C99Compiler.hasTypedef(getCurrentToken().getText())");
			setState(143);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Primary_expressionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Constant() { return getToken(C99Parser.Constant, 0); }
		public TerminalNode String_literal() { return getToken(C99Parser.String_literal, 0); }
		public TerminalNode LeRoBr() { return getToken(C99Parser.LeRoBr, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RiRoBr() { return getToken(C99Parser.RiRoBr, 0); }
		public Primary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitPrimary_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_primary_expression);
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				match(Constant);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				match(String_literal);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(148);
				match(LeRoBr);
				setState(149);
				expression();
				setState(150);
				match(RiRoBr);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Postfix_expressionContext extends ParserRuleContext {
		public Primary_expressionContext primary_expression() {
			return getRuleContext(Primary_expressionContext.class,0);
		}
		public TerminalNode LeRoBr() { return getToken(C99Parser.LeRoBr, 0); }
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public TerminalNode RiRoBr() { return getToken(C99Parser.RiRoBr, 0); }
		public TerminalNode LeCuBr() { return getToken(C99Parser.LeCuBr, 0); }
		public Initializer_listContext initializer_list() {
			return getRuleContext(Initializer_listContext.class,0);
		}
		public TerminalNode RiCuBr() { return getToken(C99Parser.RiCuBr, 0); }
		public TerminalNode Comma() { return getToken(C99Parser.Comma, 0); }
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public TerminalNode LeSqBr() { return getToken(C99Parser.LeSqBr, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RiSqBr() { return getToken(C99Parser.RiSqBr, 0); }
		public Argument_expression_listContext argument_expression_list() {
			return getRuleContext(Argument_expression_listContext.class,0);
		}
		public TerminalNode Period() { return getToken(C99Parser.Period, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Arrow() { return getToken(C99Parser.Arrow, 0); }
		public TerminalNode Incrmn() { return getToken(C99Parser.Incrmn, 0); }
		public TerminalNode Decrmn() { return getToken(C99Parser.Decrmn, 0); }
		public Postfix_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitPostfix_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Postfix_expressionContext postfix_expression() throws RecognitionException {
		return postfix_expression(0);
	}

	private Postfix_expressionContext postfix_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, _parentState);
		Postfix_expressionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_postfix_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(155);
				primary_expression();
				}
				break;
			case 2:
				{
				setState(156);
				match(LeRoBr);
				setState(157);
				type_name();
				setState(158);
				match(RiRoBr);
				setState(159);
				match(LeCuBr);
				setState(160);
				initializer_list();
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(161);
					match(Comma);
					}
				}

				setState(164);
				match(RiCuBr);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(189);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(168);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(169);
						match(LeSqBr);
						setState(170);
						expression();
						setState(171);
						match(RiSqBr);
						}
						break;
					case 2:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(173);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(174);
						match(LeRoBr);
						setState(176);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
						case 1:
							{
							setState(175);
							argument_expression_list();
							}
							break;
						}
						setState(178);
						match(RiRoBr);
						}
						break;
					case 3:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(179);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(180);
						match(Period);
						setState(181);
						identifier();
						}
						break;
					case 4:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(182);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(183);
						match(Arrow);
						setState(184);
						identifier();
						}
						break;
					case 5:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(185);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(186);
						match(Incrmn);
						}
						break;
					case 6:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(187);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(188);
						match(Decrmn);
						}
						break;
					}
					} 
				}
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Argument_expression_listContext extends ParserRuleContext {
		public List<Assignment_expressionContext> assignment_expression() {
			return getRuleContexts(Assignment_expressionContext.class);
		}
		public Assignment_expressionContext assignment_expression(int i) {
			return getRuleContext(Assignment_expressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(C99Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C99Parser.Comma, i);
		}
		public Argument_expression_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_expression_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitArgument_expression_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Argument_expression_listContext argument_expression_list() throws RecognitionException {
		Argument_expression_listContext _localctx = new Argument_expression_listContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_argument_expression_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			assignment_expression();
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(195);
				match(Comma);
				setState(196);
				assignment_expression();
				}
				}
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unary_expressionContext extends ParserRuleContext {
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public TerminalNode Incrmn() { return getToken(C99Parser.Incrmn, 0); }
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TerminalNode Decrmn() { return getToken(C99Parser.Decrmn, 0); }
		public Cast_expressionContext cast_expression() {
			return getRuleContext(Cast_expressionContext.class,0);
		}
		public TerminalNode Amper() { return getToken(C99Parser.Amper, 0); }
		public TerminalNode Star() { return getToken(C99Parser.Star, 0); }
		public TerminalNode Plus() { return getToken(C99Parser.Plus, 0); }
		public TerminalNode Minus() { return getToken(C99Parser.Minus, 0); }
		public TerminalNode Tilde() { return getToken(C99Parser.Tilde, 0); }
		public TerminalNode Excla() { return getToken(C99Parser.Excla, 0); }
		public TerminalNode Sizeof() { return getToken(C99Parser.Sizeof, 0); }
		public TerminalNode LeRoBr() { return getToken(C99Parser.LeRoBr, 0); }
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public TerminalNode RiRoBr() { return getToken(C99Parser.RiRoBr, 0); }
		public TerminalNode HasEmbed() { return getToken(C99Parser.HasEmbed, 0); }
		public TerminalNode Header_name() { return getToken(C99Parser.Header_name, 0); }
		public TerminalNode String_literal() { return getToken(C99Parser.String_literal, 0); }
		public TerminalNode Defined() { return getToken(C99Parser.Defined, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Offsetof() { return getToken(C99Parser.Offsetof, 0); }
		public TerminalNode Comma() { return getToken(C99Parser.Comma, 0); }
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitUnary_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_unary_expression);
		int _la;
		try {
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				postfix_expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				match(Incrmn);
				setState(204);
				unary_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(205);
				match(Decrmn);
				setState(206);
				unary_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(207);
				_la = _input.LA(1);
				if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 63L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(208);
				cast_expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(209);
				match(Sizeof);
				setState(210);
				unary_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(211);
				match(Sizeof);
				setState(212);
				match(LeRoBr);
				setState(213);
				type_name();
				setState(214);
				match(RiRoBr);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(216);
				match(HasEmbed);
				setState(217);
				match(LeRoBr);
				setState(218);
				_la = _input.LA(1);
				if ( !(_la==String_literal || _la==Header_name) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(219);
				match(RiRoBr);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(220);
				match(Defined);
				setState(221);
				identifier();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(222);
				match(Defined);
				setState(223);
				match(LeRoBr);
				setState(224);
				identifier();
				setState(225);
				match(RiRoBr);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(227);
				match(Offsetof);
				setState(228);
				match(LeRoBr);
				setState(229);
				type_name();
				setState(230);
				match(Comma);
				setState(231);
				identifier();
				setState(232);
				match(RiRoBr);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Cast_expressionContext extends ParserRuleContext {
		public TerminalNode LeRoBr() { return getToken(C99Parser.LeRoBr, 0); }
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public TerminalNode RiRoBr() { return getToken(C99Parser.RiRoBr, 0); }
		public Cast_expressionContext cast_expression() {
			return getRuleContext(Cast_expressionContext.class,0);
		}
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public Cast_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitCast_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cast_expressionContext cast_expression() throws RecognitionException {
		Cast_expressionContext _localctx = new Cast_expressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cast_expression);
		try {
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				match(LeRoBr);
				setState(237);
				type_name();
				setState(238);
				match(RiRoBr);
				setState(239);
				cast_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				unary_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Multiplicative_expressionContext extends ParserRuleContext {
		public Cast_expressionContext cast_expression() {
			return getRuleContext(Cast_expressionContext.class,0);
		}
		public Multiplicative_expressionContext multiplicative_expression() {
			return getRuleContext(Multiplicative_expressionContext.class,0);
		}
		public TerminalNode Star() { return getToken(C99Parser.Star, 0); }
		public TerminalNode BckSla() { return getToken(C99Parser.BckSla, 0); }
		public TerminalNode Percnt() { return getToken(C99Parser.Percnt, 0); }
		public Multiplicative_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitMultiplicative_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiplicative_expressionContext multiplicative_expression() throws RecognitionException {
		return multiplicative_expression(0);
	}

	private Multiplicative_expressionContext multiplicative_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Multiplicative_expressionContext _localctx = new Multiplicative_expressionContext(_ctx, _parentState);
		Multiplicative_expressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_multiplicative_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(245);
			cast_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(252);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Multiplicative_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_multiplicative_expression);
					setState(247);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(248);
					_la = _input.LA(1);
					if ( !(((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 97L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(249);
					cast_expression();
					}
					} 
				}
				setState(254);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Additive_expressionContext extends ParserRuleContext {
		public Multiplicative_expressionContext multiplicative_expression() {
			return getRuleContext(Multiplicative_expressionContext.class,0);
		}
		public Additive_expressionContext additive_expression() {
			return getRuleContext(Additive_expressionContext.class,0);
		}
		public TerminalNode Plus() { return getToken(C99Parser.Plus, 0); }
		public TerminalNode Minus() { return getToken(C99Parser.Minus, 0); }
		public Additive_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitAdditive_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Additive_expressionContext additive_expression() throws RecognitionException {
		return additive_expression(0);
	}

	private Additive_expressionContext additive_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Additive_expressionContext _localctx = new Additive_expressionContext(_ctx, _parentState);
		Additive_expressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_additive_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(256);
			multiplicative_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(263);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Additive_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_additive_expression);
					setState(258);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(259);
					_la = _input.LA(1);
					if ( !(_la==Plus || _la==Minus) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(260);
					multiplicative_expression(0);
					}
					} 
				}
				setState(265);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Shift_expressionContext extends ParserRuleContext {
		public Additive_expressionContext additive_expression() {
			return getRuleContext(Additive_expressionContext.class,0);
		}
		public Shift_expressionContext shift_expression() {
			return getRuleContext(Shift_expressionContext.class,0);
		}
		public TerminalNode LssLss() { return getToken(C99Parser.LssLss, 0); }
		public TerminalNode GrtGrt() { return getToken(C99Parser.GrtGrt, 0); }
		public Shift_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitShift_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shift_expressionContext shift_expression() throws RecognitionException {
		return shift_expression(0);
	}

	private Shift_expressionContext shift_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Shift_expressionContext _localctx = new Shift_expressionContext(_ctx, _parentState);
		Shift_expressionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_shift_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(267);
			additive_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(274);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Shift_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_shift_expression);
					setState(269);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(270);
					_la = _input.LA(1);
					if ( !(_la==LssLss || _la==GrtGrt) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(271);
					additive_expression(0);
					}
					} 
				}
				setState(276);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Relational_expressionContext extends ParserRuleContext {
		public Shift_expressionContext shift_expression() {
			return getRuleContext(Shift_expressionContext.class,0);
		}
		public Relational_expressionContext relational_expression() {
			return getRuleContext(Relational_expressionContext.class,0);
		}
		public TerminalNode LessTh() { return getToken(C99Parser.LessTh, 0); }
		public TerminalNode GretTh() { return getToken(C99Parser.GretTh, 0); }
		public TerminalNode LessEq() { return getToken(C99Parser.LessEq, 0); }
		public TerminalNode GretEq() { return getToken(C99Parser.GretEq, 0); }
		public Relational_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitRelational_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relational_expressionContext relational_expression() throws RecognitionException {
		return relational_expression(0);
	}

	private Relational_expressionContext relational_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Relational_expressionContext _localctx = new Relational_expressionContext(_ctx, _parentState);
		Relational_expressionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_relational_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(278);
			shift_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(285);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Relational_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relational_expression);
					setState(280);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(281);
					_la = _input.LA(1);
					if ( !(((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 15L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(282);
					shift_expression(0);
					}
					} 
				}
				setState(287);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Equality_expressionContext extends ParserRuleContext {
		public Relational_expressionContext relational_expression() {
			return getRuleContext(Relational_expressionContext.class,0);
		}
		public Equality_expressionContext equality_expression() {
			return getRuleContext(Equality_expressionContext.class,0);
		}
		public TerminalNode Equal() { return getToken(C99Parser.Equal, 0); }
		public TerminalNode NotEql() { return getToken(C99Parser.NotEql, 0); }
		public Equality_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitEquality_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Equality_expressionContext equality_expression() throws RecognitionException {
		return equality_expression(0);
	}

	private Equality_expressionContext equality_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Equality_expressionContext _localctx = new Equality_expressionContext(_ctx, _parentState);
		Equality_expressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_equality_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(289);
			relational_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(296);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Equality_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_equality_expression);
					setState(291);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(292);
					_la = _input.LA(1);
					if ( !(_la==Equal || _la==NotEql) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(293);
					relational_expression(0);
					}
					} 
				}
				setState(298);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class And_expressionContext extends ParserRuleContext {
		public Equality_expressionContext equality_expression() {
			return getRuleContext(Equality_expressionContext.class,0);
		}
		public And_expressionContext and_expression() {
			return getRuleContext(And_expressionContext.class,0);
		}
		public TerminalNode Amper() { return getToken(C99Parser.Amper, 0); }
		public And_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitAnd_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final And_expressionContext and_expression() throws RecognitionException {
		return and_expression(0);
	}

	private And_expressionContext and_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		And_expressionContext _localctx = new And_expressionContext(_ctx, _parentState);
		And_expressionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_and_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(300);
			equality_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(307);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new And_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_and_expression);
					setState(302);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(303);
					match(Amper);
					setState(304);
					equality_expression(0);
					}
					} 
				}
				setState(309);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Xor_expressionContext extends ParserRuleContext {
		public And_expressionContext and_expression() {
			return getRuleContext(And_expressionContext.class,0);
		}
		public Xor_expressionContext xor_expression() {
			return getRuleContext(Xor_expressionContext.class,0);
		}
		public TerminalNode Xor() { return getToken(C99Parser.Xor, 0); }
		public Xor_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xor_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitXor_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Xor_expressionContext xor_expression() throws RecognitionException {
		return xor_expression(0);
	}

	private Xor_expressionContext xor_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Xor_expressionContext _localctx = new Xor_expressionContext(_ctx, _parentState);
		Xor_expressionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_xor_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(311);
			and_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(318);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Xor_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_xor_expression);
					setState(313);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(314);
					match(Xor);
					setState(315);
					and_expression(0);
					}
					} 
				}
				setState(320);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Or_expressionContext extends ParserRuleContext {
		public Xor_expressionContext xor_expression() {
			return getRuleContext(Xor_expressionContext.class,0);
		}
		public Or_expressionContext or_expression() {
			return getRuleContext(Or_expressionContext.class,0);
		}
		public TerminalNode Or() { return getToken(C99Parser.Or, 0); }
		public Or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitOr_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Or_expressionContext or_expression() throws RecognitionException {
		return or_expression(0);
	}

	private Or_expressionContext or_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Or_expressionContext _localctx = new Or_expressionContext(_ctx, _parentState);
		Or_expressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_or_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(322);
			xor_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(329);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Or_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_or_expression);
					setState(324);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(325);
					match(Or);
					setState(326);
					xor_expression(0);
					}
					} 
				}
				setState(331);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Land_expressionContext extends ParserRuleContext {
		public Or_expressionContext or_expression() {
			return getRuleContext(Or_expressionContext.class,0);
		}
		public Land_expressionContext land_expression() {
			return getRuleContext(Land_expressionContext.class,0);
		}
		public TerminalNode AmpAmp() { return getToken(C99Parser.AmpAmp, 0); }
		public Land_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_land_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitLand_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Land_expressionContext land_expression() throws RecognitionException {
		return land_expression(0);
	}

	private Land_expressionContext land_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Land_expressionContext _localctx = new Land_expressionContext(_ctx, _parentState);
		Land_expressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_land_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(333);
			or_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(340);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Land_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_land_expression);
					setState(335);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(336);
					match(AmpAmp);
					setState(337);
					or_expression(0);
					}
					} 
				}
				setState(342);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Lor_expressionContext extends ParserRuleContext {
		public Land_expressionContext land_expression() {
			return getRuleContext(Land_expressionContext.class,0);
		}
		public Lor_expressionContext lor_expression() {
			return getRuleContext(Lor_expressionContext.class,0);
		}
		public TerminalNode OrOr() { return getToken(C99Parser.OrOr, 0); }
		public Lor_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lor_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitLor_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lor_expressionContext lor_expression() throws RecognitionException {
		return lor_expression(0);
	}

	private Lor_expressionContext lor_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Lor_expressionContext _localctx = new Lor_expressionContext(_ctx, _parentState);
		Lor_expressionContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_lor_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(344);
			land_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(351);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Lor_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_lor_expression);
					setState(346);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(347);
					match(OrOr);
					setState(348);
					land_expression(0);
					}
					} 
				}
				setState(353);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Conditional_expressionContext extends ParserRuleContext {
		public Lor_expressionContext lor_expression() {
			return getRuleContext(Lor_expressionContext.class,0);
		}
		public TerminalNode Questi() { return getToken(C99Parser.Questi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Colon() { return getToken(C99Parser.Colon, 0); }
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public Conditional_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitConditional_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conditional_expressionContext conditional_expression() throws RecognitionException {
		Conditional_expressionContext _localctx = new Conditional_expressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_conditional_expression);
		try {
			setState(361);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(354);
				lor_expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(355);
				lor_expression(0);
				setState(356);
				match(Questi);
				setState(357);
				expression();
				setState(358);
				match(Colon);
				setState(359);
				conditional_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Assignment_expressionContext extends ParserRuleContext {
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public TerminalNode Assign() { return getToken(C99Parser.Assign, 0); }
		public TerminalNode MulAsg() { return getToken(C99Parser.MulAsg, 0); }
		public TerminalNode DivAsg() { return getToken(C99Parser.DivAsg, 0); }
		public TerminalNode ModAsg() { return getToken(C99Parser.ModAsg, 0); }
		public TerminalNode PluAsg() { return getToken(C99Parser.PluAsg, 0); }
		public TerminalNode SubAsg() { return getToken(C99Parser.SubAsg, 0); }
		public TerminalNode LShAsg() { return getToken(C99Parser.LShAsg, 0); }
		public TerminalNode RShAsg() { return getToken(C99Parser.RShAsg, 0); }
		public TerminalNode AndAsg() { return getToken(C99Parser.AndAsg, 0); }
		public TerminalNode XorAsg() { return getToken(C99Parser.XorAsg, 0); }
		public TerminalNode OrAsg() { return getToken(C99Parser.OrAsg, 0); }
		public Assignment_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitAssignment_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assignment_expressionContext assignment_expression() throws RecognitionException {
		Assignment_expressionContext _localctx = new Assignment_expressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assignment_expression);
		int _la;
		try {
			setState(368);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(363);
				conditional_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(364);
				unary_expression();
				setState(365);
				_la = _input.LA(1);
				if ( !(((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & 4294968319L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(366);
				assignment_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public List<Assignment_expressionContext> assignment_expression() {
			return getRuleContexts(Assignment_expressionContext.class);
		}
		public Assignment_expressionContext assignment_expression(int i) {
			return getRuleContext(Assignment_expressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(C99Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C99Parser.Comma, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			assignment_expression();
			setState(375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(371);
				match(Comma);
				setState(372);
				assignment_expression();
				}
				}
				setState(377);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Constant_expressionContext extends ParserRuleContext {
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public Constant_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitConstant_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constant_expressionContext constant_expression() throws RecognitionException {
		Constant_expressionContext _localctx = new Constant_expressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_constant_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			conditional_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Attributes_declarationContext extends ParserRuleContext {
		public TerminalNode TwoLSB() { return getToken(C99Parser.TwoLSB, 0); }
		public Identifier_listContext identifier_list() {
			return getRuleContext(Identifier_listContext.class,0);
		}
		public TerminalNode TwoRSB() { return getToken(C99Parser.TwoRSB, 0); }
		public Attributes_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributes_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitAttributes_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attributes_declarationContext attributes_declaration() throws RecognitionException {
		Attributes_declarationContext _localctx = new Attributes_declarationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_attributes_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(TwoLSB);
			setState(381);
			identifier_list();
			setState(382);
			match(TwoRSB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public Declaration_specifiersContext declaration_specifiers() {
			return getRuleContext(Declaration_specifiersContext.class,0);
		}
		public TerminalNode Semico() { return getToken(C99Parser.Semico, 0); }
		public List<Attributes_declarationContext> attributes_declaration() {
			return getRuleContexts(Attributes_declarationContext.class);
		}
		public Attributes_declarationContext attributes_declaration(int i) {
			return getRuleContext(Attributes_declarationContext.class,i);
		}
		public Init_declarator_listContext init_declarator_list() {
			return getRuleContext(Init_declarator_listContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_declaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(384);
					attributes_declaration();
					}
					} 
				}
				setState(389);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(390);
			declaration_specifiers();
			setState(392);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(391);
				init_declarator_list();
				}
				break;
			}
			setState(394);
			match(Semico);

					C99Compiler.C99Compiler.tryRegisterTypedef(_localctx);
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaration_specifiersContext extends ParserRuleContext {
		public List<Storage_class_specifierContext> storage_class_specifier() {
			return getRuleContexts(Storage_class_specifierContext.class);
		}
		public Storage_class_specifierContext storage_class_specifier(int i) {
			return getRuleContext(Storage_class_specifierContext.class,i);
		}
		public List<Type_specifierContext> type_specifier() {
			return getRuleContexts(Type_specifierContext.class);
		}
		public Type_specifierContext type_specifier(int i) {
			return getRuleContext(Type_specifierContext.class,i);
		}
		public List<Type_qualifierContext> type_qualifier() {
			return getRuleContexts(Type_qualifierContext.class);
		}
		public Type_qualifierContext type_qualifier(int i) {
			return getRuleContext(Type_qualifierContext.class,i);
		}
		public List<Function_specifierContext> function_specifier() {
			return getRuleContexts(Function_specifierContext.class);
		}
		public Function_specifierContext function_specifier(int i) {
			return getRuleContext(Function_specifierContext.class,i);
		}
		public Declaration_specifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_specifiers; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitDeclaration_specifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaration_specifiersContext declaration_specifiers() throws RecognitionException {
		Declaration_specifiersContext _localctx = new Declaration_specifiersContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_declaration_specifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(401); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					setState(401);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						setState(397);
						storage_class_specifier();
						}
						break;
					case 2:
						{
						setState(398);
						type_specifier();
						}
						break;
					case 3:
						{
						setState(399);
						type_qualifier();
						}
						break;
					case 4:
						{
						setState(400);
						function_specifier();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(403); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Storage_class_specifierContext extends ParserRuleContext {
		public TerminalNode Typedef() { return getToken(C99Parser.Typedef, 0); }
		public TerminalNode Extern() { return getToken(C99Parser.Extern, 0); }
		public TerminalNode Static() { return getToken(C99Parser.Static, 0); }
		public TerminalNode Auto() { return getToken(C99Parser.Auto, 0); }
		public TerminalNode Register() { return getToken(C99Parser.Register, 0); }
		public TerminalNode SRAM() { return getToken(C99Parser.SRAM, 0); }
		public Storage_class_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storage_class_specifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitStorage_class_specifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Storage_class_specifierContext storage_class_specifier() throws RecognitionException {
		Storage_class_specifierContext _localctx = new Storage_class_specifierContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_storage_class_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 9007199859773442L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_specifierContext extends ParserRuleContext {
		public TerminalNode Inline() { return getToken(C99Parser.Inline, 0); }
		public Function_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_specifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitFunction_specifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_specifierContext function_specifier() throws RecognitionException {
		Function_specifierContext _localctx = new Function_specifierContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_function_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			match(Inline);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Init_declarator_listContext extends ParserRuleContext {
		public List<Init_declaratorContext> init_declarator() {
			return getRuleContexts(Init_declaratorContext.class);
		}
		public Init_declaratorContext init_declarator(int i) {
			return getRuleContext(Init_declaratorContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(C99Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C99Parser.Comma, i);
		}
		public Init_declarator_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_declarator_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitInit_declarator_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Init_declarator_listContext init_declarator_list() throws RecognitionException {
		Init_declarator_listContext _localctx = new Init_declarator_listContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			init_declarator();
			setState(414);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(410);
				match(Comma);
				setState(411);
				init_declarator();
				}
				}
				setState(416);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Init_declaratorContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode Assign() { return getToken(C99Parser.Assign, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public Init_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_declarator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitInit_declarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Init_declaratorContext init_declarator() throws RecognitionException {
		Init_declaratorContext _localctx = new Init_declaratorContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			declarator();
			setState(420);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(418);
				match(Assign);
				setState(419);
				initializer();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_specifierContext extends ParserRuleContext {
		public TerminalNode Void() { return getToken(C99Parser.Void, 0); }
		public TerminalNode Char() { return getToken(C99Parser.Char, 0); }
		public TerminalNode Short() { return getToken(C99Parser.Short, 0); }
		public TerminalNode Int() { return getToken(C99Parser.Int, 0); }
		public TerminalNode Long() { return getToken(C99Parser.Long, 0); }
		public TerminalNode Float() { return getToken(C99Parser.Float, 0); }
		public TerminalNode Double() { return getToken(C99Parser.Double, 0); }
		public TerminalNode Signed() { return getToken(C99Parser.Signed, 0); }
		public TerminalNode Unsigned() { return getToken(C99Parser.Unsigned, 0); }
		public TerminalNode Bool() { return getToken(C99Parser.Bool, 0); }
		public TerminalNode Complex() { return getToken(C99Parser.Complex, 0); }
		public Struct_or_union_specifierContext struct_or_union_specifier() {
			return getRuleContext(Struct_or_union_specifierContext.class,0);
		}
		public Enum_specifierContext enum_specifier() {
			return getRuleContext(Enum_specifierContext.class,0);
		}
		public Typedef_nameContext typedef_name() {
			return getRuleContext(Typedef_nameContext.class,0);
		}
		public Type_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_specifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitType_specifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_specifierContext type_specifier() throws RecognitionException {
		Type_specifierContext _localctx = new Type_specifierContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_type_specifier);
		int _la;
		try {
			setState(426);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(422);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 109547627024L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(423);
				struct_or_union_specifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(424);
				enum_specifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(425);
				typedef_name();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_or_union_specifierContext extends ParserRuleContext {
		public TerminalNode LeCuBr() { return getToken(C99Parser.LeCuBr, 0); }
		public Struct_declaration_listContext struct_declaration_list() {
			return getRuleContext(Struct_declaration_listContext.class,0);
		}
		public TerminalNode RiCuBr() { return getToken(C99Parser.RiCuBr, 0); }
		public TerminalNode Struct() { return getToken(C99Parser.Struct, 0); }
		public TerminalNode Union() { return getToken(C99Parser.Union, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Struct_or_union_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_or_union_specifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitStruct_or_union_specifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_or_union_specifierContext struct_or_union_specifier() throws RecognitionException {
		Struct_or_union_specifierContext _localctx = new Struct_or_union_specifierContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_struct_or_union_specifier);
		int _la;
		try {
			setState(438);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(428);
				_la = _input.LA(1);
				if ( !(_la==Struct || _la==Union) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(430);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(429);
					identifier();
					}
					break;
				}
				setState(432);
				match(LeCuBr);
				setState(433);
				struct_declaration_list();
				setState(434);
				match(RiCuBr);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(436);
				_la = _input.LA(1);
				if ( !(_la==Struct || _la==Union) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(437);
				identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_declaration_listContext extends ParserRuleContext {
		public List<Struct_declarationContext> struct_declaration() {
			return getRuleContexts(Struct_declarationContext.class);
		}
		public Struct_declarationContext struct_declaration(int i) {
			return getRuleContext(Struct_declarationContext.class,i);
		}
		public Struct_declaration_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_declaration_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitStruct_declaration_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_declaration_listContext struct_declaration_list() throws RecognitionException {
		Struct_declaration_listContext _localctx = new Struct_declaration_listContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_struct_declaration_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(441); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(440);
					struct_declaration();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(443); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_declarationContext extends ParserRuleContext {
		public Specifier_qualifier_listContext specifier_qualifier_list() {
			return getRuleContext(Specifier_qualifier_listContext.class,0);
		}
		public Struct_declarator_listContext struct_declarator_list() {
			return getRuleContext(Struct_declarator_listContext.class,0);
		}
		public TerminalNode Semico() { return getToken(C99Parser.Semico, 0); }
		public Struct_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitStruct_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_declarationContext struct_declaration() throws RecognitionException {
		Struct_declarationContext _localctx = new Struct_declarationContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_struct_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			specifier_qualifier_list();
			setState(446);
			struct_declarator_list();
			setState(447);
			match(Semico);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Specifier_qualifier_listContext extends ParserRuleContext {
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Type_qualifierContext type_qualifier() {
			return getRuleContext(Type_qualifierContext.class,0);
		}
		public Specifier_qualifier_listContext specifier_qualifier_list() {
			return getRuleContext(Specifier_qualifier_listContext.class,0);
		}
		public Specifier_qualifier_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specifier_qualifier_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitSpecifier_qualifier_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Specifier_qualifier_listContext specifier_qualifier_list() throws RecognitionException {
		Specifier_qualifier_listContext _localctx = new Specifier_qualifier_listContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_specifier_qualifier_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(449);
				type_specifier();
				}
				break;
			case 2:
				{
				setState(450);
				type_qualifier();
				}
				break;
			}
			setState(454);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(453);
				specifier_qualifier_list();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_declarator_listContext extends ParserRuleContext {
		public List<Struct_declaratorContext> struct_declarator() {
			return getRuleContexts(Struct_declaratorContext.class);
		}
		public Struct_declaratorContext struct_declarator(int i) {
			return getRuleContext(Struct_declaratorContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(C99Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C99Parser.Comma, i);
		}
		public Struct_declarator_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_declarator_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitStruct_declarator_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_declarator_listContext struct_declarator_list() throws RecognitionException {
		Struct_declarator_listContext _localctx = new Struct_declarator_listContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_struct_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			struct_declarator();
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(457);
				match(Comma);
				setState(458);
				struct_declarator();
				}
				}
				setState(463);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_declaratorContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode Colon() { return getToken(C99Parser.Colon, 0); }
		public Constant_expressionContext constant_expression() {
			return getRuleContext(Constant_expressionContext.class,0);
		}
		public Struct_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_declarator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitStruct_declarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_declaratorContext struct_declarator() throws RecognitionException {
		Struct_declaratorContext _localctx = new Struct_declaratorContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_struct_declarator);
		try {
			setState(470);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(464);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(466);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
				case 1:
					{
					setState(465);
					declarator();
					}
					break;
				}
				setState(468);
				match(Colon);
				setState(469);
				constant_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Enum_specifierContext extends ParserRuleContext {
		public TerminalNode Enum() { return getToken(C99Parser.Enum, 0); }
		public TerminalNode LeCuBr() { return getToken(C99Parser.LeCuBr, 0); }
		public Enumerator_listContext enumerator_list() {
			return getRuleContext(Enumerator_listContext.class,0);
		}
		public TerminalNode RiCuBr() { return getToken(C99Parser.RiCuBr, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Comma() { return getToken(C99Parser.Comma, 0); }
		public Enum_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enum_specifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitEnum_specifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Enum_specifierContext enum_specifier() throws RecognitionException {
		Enum_specifierContext _localctx = new Enum_specifierContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_enum_specifier);
		int _la;
		try {
			setState(485);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(472);
				match(Enum);
				setState(474);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(473);
					identifier();
					}
					break;
				}
				setState(476);
				match(LeCuBr);
				setState(477);
				enumerator_list();
				setState(479);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(478);
					match(Comma);
					}
				}

				setState(481);
				match(RiCuBr);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(483);
				match(Enum);
				setState(484);
				identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Enumerator_listContext extends ParserRuleContext {
		public List<EnumeratorContext> enumerator() {
			return getRuleContexts(EnumeratorContext.class);
		}
		public EnumeratorContext enumerator(int i) {
			return getRuleContext(EnumeratorContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(C99Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C99Parser.Comma, i);
		}
		public Enumerator_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerator_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitEnumerator_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Enumerator_listContext enumerator_list() throws RecognitionException {
		Enumerator_listContext _localctx = new Enumerator_listContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_enumerator_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			enumerator();
			setState(492);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(488);
					match(Comma);
					setState(489);
					enumerator();
					}
					} 
				}
				setState(494);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumeratorContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Assign() { return getToken(C99Parser.Assign, 0); }
		public Constant_expressionContext constant_expression() {
			return getRuleContext(Constant_expressionContext.class,0);
		}
		public EnumeratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitEnumerator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumeratorContext enumerator() throws RecognitionException {
		EnumeratorContext _localctx = new EnumeratorContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_enumerator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			identifier();
			setState(498);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(496);
				match(Assign);
				setState(497);
				constant_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_qualifierContext extends ParserRuleContext {
		public TerminalNode Const() { return getToken(C99Parser.Const, 0); }
		public TerminalNode Restrict() { return getToken(C99Parser.Restrict, 0); }
		public TerminalNode Volatile() { return getToken(C99Parser.Volatile, 0); }
		public TerminalNode RWTWICE() { return getToken(C99Parser.RWTWICE, 0); }
		public TerminalNode ROTWICE() { return getToken(C99Parser.ROTWICE, 0); }
		public TerminalNode WOTWICE() { return getToken(C99Parser.WOTWICE, 0); }
		public Type_qualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_qualifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitType_qualifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_qualifierContext type_qualifier() throws RecognitionException {
		Type_qualifierContext _localctx = new Type_qualifierContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_type_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 126100798158405664L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaratorContext extends ParserRuleContext {
		public Direct_declaratorContext direct_declarator() {
			return getRuleContext(Direct_declaratorContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_declarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(502);
				pointer();
				}
				break;
			}
			setState(505);
			direct_declarator(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Direct_declaratorContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LeRoBr() { return getToken(C99Parser.LeRoBr, 0); }
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode RiRoBr() { return getToken(C99Parser.RiRoBr, 0); }
		public Direct_declaratorContext direct_declarator() {
			return getRuleContext(Direct_declaratorContext.class,0);
		}
		public TerminalNode LeSqBr() { return getToken(C99Parser.LeSqBr, 0); }
		public TerminalNode RiSqBr() { return getToken(C99Parser.RiSqBr, 0); }
		public Type_qualifier_listContext type_qualifier_list() {
			return getRuleContext(Type_qualifier_listContext.class,0);
		}
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public TerminalNode Static() { return getToken(C99Parser.Static, 0); }
		public TerminalNode Star() { return getToken(C99Parser.Star, 0); }
		public Parameter_type_listContext parameter_type_list() {
			return getRuleContext(Parameter_type_listContext.class,0);
		}
		public Identifier_listContext identifier_list() {
			return getRuleContext(Identifier_listContext.class,0);
		}
		public Direct_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_direct_declarator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitDirect_declarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Direct_declaratorContext direct_declarator() throws RecognitionException {
		return direct_declarator(0);
	}

	private Direct_declaratorContext direct_declarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Direct_declaratorContext _localctx = new Direct_declaratorContext(_ctx, _parentState);
		Direct_declaratorContext _prevctx = _localctx;
		int _startState = 80;
		enterRecursionRule(_localctx, 80, RULE_direct_declarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(508);
				identifier();
				}
				break;
			case 2:
				{
				setState(509);
				match(LeRoBr);
				setState(510);
				declarator();
				setState(511);
				match(RiRoBr);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(560);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(558);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
					case 1:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(515);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(516);
						match(LeSqBr);
						setState(518);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
						case 1:
							{
							setState(517);
							type_qualifier_list();
							}
							break;
						}
						setState(521);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
						case 1:
							{
							setState(520);
							assignment_expression();
							}
							break;
						}
						setState(523);
						match(RiSqBr);
						}
						break;
					case 2:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(524);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(525);
						match(LeSqBr);
						setState(526);
						match(Static);
						setState(528);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
						case 1:
							{
							setState(527);
							type_qualifier_list();
							}
							break;
						}
						setState(530);
						assignment_expression();
						setState(531);
						match(RiSqBr);
						}
						break;
					case 3:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(533);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(534);
						match(LeSqBr);
						setState(535);
						type_qualifier_list();
						setState(536);
						match(Static);
						setState(537);
						assignment_expression();
						setState(538);
						match(RiSqBr);
						}
						break;
					case 4:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(540);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(541);
						match(LeSqBr);
						setState(543);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 126100798158405664L) != 0)) {
							{
							setState(542);
							type_qualifier_list();
							}
						}

						setState(545);
						match(Star);
						setState(546);
						match(RiSqBr);
						}
						break;
					case 5:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(547);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(548);
						match(LeRoBr);
						setState(549);
						parameter_type_list();
						setState(550);
						match(RiRoBr);
						}
						break;
					case 6:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(552);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(553);
						match(LeRoBr);
						setState(555);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
						case 1:
							{
							setState(554);
							identifier_list();
							}
							break;
						}
						setState(557);
						match(RiRoBr);
						}
						break;
					}
					} 
				}
				setState(562);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PointerContext extends ParserRuleContext {
		public List<TerminalNode> Star() { return getTokens(C99Parser.Star); }
		public TerminalNode Star(int i) {
			return getToken(C99Parser.Star, i);
		}
		public List<Type_qualifier_listContext> type_qualifier_list() {
			return getRuleContexts(Type_qualifier_listContext.class);
		}
		public Type_qualifier_listContext type_qualifier_list(int i) {
			return getRuleContext(Type_qualifier_listContext.class,i);
		}
		public PointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitPointer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointerContext pointer() throws RecognitionException {
		PointerContext _localctx = new PointerContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_pointer);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(567); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(563);
					match(Star);
					setState(565);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
					case 1:
						{
						setState(564);
						type_qualifier_list();
						}
						break;
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(569); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_qualifier_listContext extends ParserRuleContext {
		public List<Type_qualifierContext> type_qualifier() {
			return getRuleContexts(Type_qualifierContext.class);
		}
		public Type_qualifierContext type_qualifier(int i) {
			return getRuleContext(Type_qualifierContext.class,i);
		}
		public Type_qualifier_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_qualifier_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitType_qualifier_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_qualifier_listContext type_qualifier_list() throws RecognitionException {
		Type_qualifier_listContext _localctx = new Type_qualifier_listContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_type_qualifier_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(572); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(571);
					type_qualifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(574); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parameter_type_listContext extends ParserRuleContext {
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public TerminalNode Comma() { return getToken(C99Parser.Comma, 0); }
		public TerminalNode ThreeP() { return getToken(C99Parser.ThreeP, 0); }
		public Parameter_type_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_type_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitParameter_type_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_type_listContext parameter_type_list() throws RecognitionException {
		Parameter_type_listContext _localctx = new Parameter_type_listContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_parameter_type_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
			parameter_list();
			setState(579);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(577);
				match(Comma);
				setState(578);
				match(ThreeP);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parameter_listContext extends ParserRuleContext {
		public List<Parameter_declarationContext> parameter_declaration() {
			return getRuleContexts(Parameter_declarationContext.class);
		}
		public Parameter_declarationContext parameter_declaration(int i) {
			return getRuleContext(Parameter_declarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(C99Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C99Parser.Comma, i);
		}
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitParameter_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_parameter_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(581);
			parameter_declaration();
			setState(586);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(582);
					match(Comma);
					setState(583);
					parameter_declaration();
					}
					} 
				}
				setState(588);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parameter_declarationContext extends ParserRuleContext {
		public Declaration_specifiersContext declaration_specifiers() {
			return getRuleContext(Declaration_specifiersContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public Abstract_declaratorContext abstract_declarator() {
			return getRuleContext(Abstract_declaratorContext.class,0);
		}
		public Parameter_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitParameter_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_declarationContext parameter_declaration() throws RecognitionException {
		Parameter_declarationContext _localctx = new Parameter_declarationContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_parameter_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			declaration_specifiers();
			setState(594);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(590);
				declarator();
				}
				break;
			case 2:
				{
				setState(592);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 327681L) != 0)) {
					{
					setState(591);
					abstract_declarator();
					}
				}

				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Identifier_listContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(C99Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C99Parser.Comma, i);
		}
		public Identifier_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitIdentifier_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Identifier_listContext identifier_list() throws RecognitionException {
		Identifier_listContext _localctx = new Identifier_listContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_identifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(596);
			identifier();
			setState(601);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(597);
				match(Comma);
				setState(598);
				identifier();
				}
				}
				setState(603);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_nameContext extends ParserRuleContext {
		public Specifier_qualifier_listContext specifier_qualifier_list() {
			return getRuleContext(Specifier_qualifier_listContext.class,0);
		}
		public Abstract_declaratorContext abstract_declarator() {
			return getRuleContext(Abstract_declaratorContext.class,0);
		}
		public Type_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitType_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_type_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(604);
			specifier_qualifier_list();
			setState(606);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 327681L) != 0)) {
				{
				setState(605);
				abstract_declarator();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Abstract_declaratorContext extends ParserRuleContext {
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public Direct_abstract_declaratorContext direct_abstract_declarator() {
			return getRuleContext(Direct_abstract_declaratorContext.class,0);
		}
		public Abstract_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstract_declarator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitAbstract_declarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Abstract_declaratorContext abstract_declarator() throws RecognitionException {
		Abstract_declaratorContext _localctx = new Abstract_declaratorContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_abstract_declarator);
		int _la;
		try {
			setState(613);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(608);
				pointer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(610);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Star) {
					{
					setState(609);
					pointer();
					}
				}

				setState(612);
				direct_abstract_declarator(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Direct_abstract_declaratorContext extends ParserRuleContext {
		public TerminalNode LeRoBr() { return getToken(C99Parser.LeRoBr, 0); }
		public Abstract_declaratorContext abstract_declarator() {
			return getRuleContext(Abstract_declaratorContext.class,0);
		}
		public TerminalNode RiRoBr() { return getToken(C99Parser.RiRoBr, 0); }
		public TerminalNode LeSqBr() { return getToken(C99Parser.LeSqBr, 0); }
		public TerminalNode RiSqBr() { return getToken(C99Parser.RiSqBr, 0); }
		public Type_qualifier_listContext type_qualifier_list() {
			return getRuleContext(Type_qualifier_listContext.class,0);
		}
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public TerminalNode Static() { return getToken(C99Parser.Static, 0); }
		public TerminalNode Star() { return getToken(C99Parser.Star, 0); }
		public Parameter_type_listContext parameter_type_list() {
			return getRuleContext(Parameter_type_listContext.class,0);
		}
		public Identifier_listContext identifier_list() {
			return getRuleContext(Identifier_listContext.class,0);
		}
		public Direct_abstract_declaratorContext direct_abstract_declarator() {
			return getRuleContext(Direct_abstract_declaratorContext.class,0);
		}
		public Direct_abstract_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_direct_abstract_declarator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitDirect_abstract_declarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Direct_abstract_declaratorContext direct_abstract_declarator() throws RecognitionException {
		return direct_abstract_declarator(0);
	}

	private Direct_abstract_declaratorContext direct_abstract_declarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Direct_abstract_declaratorContext _localctx = new Direct_abstract_declaratorContext(_ctx, _parentState);
		Direct_abstract_declaratorContext _prevctx = _localctx;
		int _startState = 98;
		enterRecursionRule(_localctx, 98, RULE_direct_abstract_declarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(657);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				{
				setState(616);
				match(LeRoBr);
				setState(617);
				abstract_declarator();
				setState(618);
				match(RiRoBr);
				}
				break;
			case 2:
				{
				setState(620);
				match(LeSqBr);
				setState(622);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
				case 1:
					{
					setState(621);
					type_qualifier_list();
					}
					break;
				}
				setState(625);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
				case 1:
					{
					setState(624);
					assignment_expression();
					}
					break;
				}
				setState(627);
				match(RiSqBr);
				}
				break;
			case 3:
				{
				setState(628);
				match(LeSqBr);
				setState(629);
				match(Static);
				setState(631);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
				case 1:
					{
					setState(630);
					type_qualifier_list();
					}
					break;
				}
				setState(633);
				assignment_expression();
				setState(634);
				match(RiSqBr);
				}
				break;
			case 4:
				{
				setState(636);
				match(LeSqBr);
				setState(637);
				type_qualifier_list();
				setState(638);
				match(Static);
				setState(639);
				assignment_expression();
				setState(640);
				match(RiSqBr);
				}
				break;
			case 5:
				{
				setState(642);
				match(LeSqBr);
				setState(644);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 126100798158405664L) != 0)) {
					{
					setState(643);
					type_qualifier_list();
					}
				}

				setState(646);
				match(Star);
				setState(647);
				match(RiSqBr);
				}
				break;
			case 6:
				{
				setState(648);
				match(LeRoBr);
				setState(649);
				parameter_type_list();
				setState(650);
				match(RiRoBr);
				}
				break;
			case 7:
				{
				setState(652);
				match(LeRoBr);
				setState(654);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
				case 1:
					{
					setState(653);
					identifier_list();
					}
					break;
				}
				setState(656);
				match(RiRoBr);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(704);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(702);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
					case 1:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(659);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(660);
						match(LeSqBr);
						setState(662);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
						case 1:
							{
							setState(661);
							type_qualifier_list();
							}
							break;
						}
						setState(665);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
						case 1:
							{
							setState(664);
							assignment_expression();
							}
							break;
						}
						setState(667);
						match(RiSqBr);
						}
						break;
					case 2:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(668);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(669);
						match(LeSqBr);
						setState(670);
						match(Static);
						setState(672);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
						case 1:
							{
							setState(671);
							type_qualifier_list();
							}
							break;
						}
						setState(674);
						assignment_expression();
						setState(675);
						match(RiSqBr);
						}
						break;
					case 3:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(677);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(678);
						match(LeSqBr);
						setState(679);
						type_qualifier_list();
						setState(680);
						match(Static);
						setState(681);
						assignment_expression();
						setState(682);
						match(RiSqBr);
						}
						break;
					case 4:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(684);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(685);
						match(LeSqBr);
						setState(687);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 126100798158405664L) != 0)) {
							{
							setState(686);
							type_qualifier_list();
							}
						}

						setState(689);
						match(Star);
						setState(690);
						match(RiSqBr);
						}
						break;
					case 5:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(691);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(692);
						match(LeRoBr);
						setState(693);
						parameter_type_list();
						setState(694);
						match(RiRoBr);
						}
						break;
					case 6:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(696);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(697);
						match(LeRoBr);
						setState(699);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
						case 1:
							{
							setState(698);
							identifier_list();
							}
							break;
						}
						setState(701);
						match(RiRoBr);
						}
						break;
					}
					} 
				}
				setState(706);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Typedef_nameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(C99Parser.Identifier, 0); }
		public Typedef_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedef_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitTypedef_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Typedef_nameContext typedef_name() throws RecognitionException {
		Typedef_nameContext _localctx = new Typedef_nameContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_typedef_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(707);
			if (!(C99Compiler.C99Compiler.hasTypedef(getCurrentToken().getText()))) throw new FailedPredicateException(this, "C99Compiler.C99Compiler.hasTypedef(getCurrentToken().getText())");
			setState(708);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitializerContext extends ParserRuleContext {
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public TerminalNode LeCuBr() { return getToken(C99Parser.LeCuBr, 0); }
		public Initializer_listContext initializer_list() {
			return getRuleContext(Initializer_listContext.class,0);
		}
		public TerminalNode RiCuBr() { return getToken(C99Parser.RiCuBr, 0); }
		public TerminalNode Comma() { return getToken(C99Parser.Comma, 0); }
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_initializer);
		int _la;
		try {
			setState(718);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(710);
				assignment_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(711);
				match(LeCuBr);
				setState(712);
				initializer_list();
				setState(714);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(713);
					match(Comma);
					}
				}

				setState(716);
				match(RiCuBr);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Initializer_listContext extends ParserRuleContext {
		public List<InitializerContext> initializer() {
			return getRuleContexts(InitializerContext.class);
		}
		public InitializerContext initializer(int i) {
			return getRuleContext(InitializerContext.class,i);
		}
		public List<DesignationContext> designation() {
			return getRuleContexts(DesignationContext.class);
		}
		public DesignationContext designation(int i) {
			return getRuleContext(DesignationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(C99Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C99Parser.Comma, i);
		}
		public Initializer_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitInitializer_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Initializer_listContext initializer_list() throws RecognitionException {
		Initializer_listContext _localctx = new Initializer_listContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_initializer_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(721);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				{
				setState(720);
				designation();
				}
				break;
			}
			setState(723);
			initializer();
			setState(731);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(724);
					match(Comma);
					setState(726);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
					case 1:
						{
						setState(725);
						designation();
						}
						break;
					}
					setState(728);
					initializer();
					}
					} 
				}
				setState(733);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DesignationContext extends ParserRuleContext {
		public Designator_listContext designator_list() {
			return getRuleContext(Designator_listContext.class,0);
		}
		public TerminalNode Assign() { return getToken(C99Parser.Assign, 0); }
		public DesignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitDesignation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignationContext designation() throws RecognitionException {
		DesignationContext _localctx = new DesignationContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_designation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(734);
			designator_list();
			setState(735);
			match(Assign);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Designator_listContext extends ParserRuleContext {
		public List<DesignatorContext> designator() {
			return getRuleContexts(DesignatorContext.class);
		}
		public DesignatorContext designator(int i) {
			return getRuleContext(DesignatorContext.class,i);
		}
		public Designator_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designator_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitDesignator_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Designator_listContext designator_list() throws RecognitionException {
		Designator_listContext _localctx = new Designator_listContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_designator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(738); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(737);
				designator();
				}
				}
				setState(740); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Period || _la==LeSqBr );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DesignatorContext extends ParserRuleContext {
		public TerminalNode LeSqBr() { return getToken(C99Parser.LeSqBr, 0); }
		public Constant_expressionContext constant_expression() {
			return getRuleContext(Constant_expressionContext.class,0);
		}
		public TerminalNode RiSqBr() { return getToken(C99Parser.RiSqBr, 0); }
		public TerminalNode Period() { return getToken(C99Parser.Period, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DesignatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitDesignator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignatorContext designator() throws RecognitionException {
		DesignatorContext _localctx = new DesignatorContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_designator);
		try {
			setState(748);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeSqBr:
				enterOuterAlt(_localctx, 1);
				{
				setState(742);
				match(LeSqBr);
				setState(743);
				constant_expression();
				setState(744);
				match(RiSqBr);
				}
				break;
			case Period:
				enterOuterAlt(_localctx, 2);
				{
				setState(746);
				match(Period);
				setState(747);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Asm_statementContext asm_statement() {
			return getRuleContext(Asm_statementContext.class,0);
		}
		public Labeled_statementContext labeled_statement() {
			return getRuleContext(Labeled_statementContext.class,0);
		}
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public Expression_statementContext expression_statement() {
			return getRuleContext(Expression_statementContext.class,0);
		}
		public Selection_statementContext selection_statement() {
			return getRuleContext(Selection_statementContext.class,0);
		}
		public Iteration_statementContext iteration_statement() {
			return getRuleContext(Iteration_statementContext.class,0);
		}
		public Jump_statementContext jump_statement() {
			return getRuleContext(Jump_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_statement);
		try {
			setState(757);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(750);
				asm_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(751);
				labeled_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(752);
				compound_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(753);
				expression_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(754);
				selection_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(755);
				iteration_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(756);
				jump_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Labeled_statementContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Colon() { return getToken(C99Parser.Colon, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Case() { return getToken(C99Parser.Case, 0); }
		public Constant_expressionContext constant_expression() {
			return getRuleContext(Constant_expressionContext.class,0);
		}
		public TerminalNode Default() { return getToken(C99Parser.Default, 0); }
		public Labeled_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeled_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitLabeled_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Labeled_statementContext labeled_statement() throws RecognitionException {
		Labeled_statementContext _localctx = new Labeled_statementContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_labeled_statement);
		try {
			setState(771);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(759);
				identifier();
				setState(760);
				match(Colon);
				setState(761);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(763);
				match(Case);
				setState(764);
				constant_expression();
				setState(765);
				match(Colon);
				setState(766);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(768);
				match(Default);
				setState(769);
				match(Colon);
				setState(770);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Compound_statementContext extends ParserRuleContext {
		public TerminalNode LeCuBr() { return getToken(C99Parser.LeCuBr, 0); }
		public TerminalNode RiCuBr() { return getToken(C99Parser.RiCuBr, 0); }
		public Block_item_listContext block_item_list() {
			return getRuleContext(Block_item_listContext.class,0);
		}
		public Compound_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitCompound_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_statementContext compound_statement() throws RecognitionException {
		Compound_statementContext _localctx = new Compound_statementContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_compound_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(773);
			match(LeCuBr);
			setState(775);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				{
				setState(774);
				block_item_list();
				}
				break;
			}
			setState(777);
			match(RiCuBr);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Block_item_listContext extends ParserRuleContext {
		public List<Block_itemContext> block_item() {
			return getRuleContexts(Block_itemContext.class);
		}
		public Block_itemContext block_item(int i) {
			return getRuleContext(Block_itemContext.class,i);
		}
		public Block_item_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_item_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitBlock_item_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_item_listContext block_item_list() throws RecognitionException {
		Block_item_listContext _localctx = new Block_item_listContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_block_item_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(780); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(779);
					block_item();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(782); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Block_itemContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Block_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_item; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitBlock_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_itemContext block_item() throws RecognitionException {
		Block_itemContext _localctx = new Block_itemContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_block_item);
		try {
			setState(786);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(784);
				declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(785);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expression_statementContext extends ParserRuleContext {
		public TerminalNode Semico() { return getToken(C99Parser.Semico, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expression_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitExpression_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression_statementContext expression_statement() throws RecognitionException {
		Expression_statementContext _localctx = new Expression_statementContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_expression_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(789);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				{
				setState(788);
				expression();
				}
				break;
			}
			setState(791);
			match(Semico);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Selection_statementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(C99Parser.If, 0); }
		public TerminalNode LeRoBr() { return getToken(C99Parser.LeRoBr, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RiRoBr() { return getToken(C99Parser.RiRoBr, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(C99Parser.Else, 0); }
		public TerminalNode Switch() { return getToken(C99Parser.Switch, 0); }
		public Selection_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitSelection_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Selection_statementContext selection_statement() throws RecognitionException {
		Selection_statementContext _localctx = new Selection_statementContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_selection_statement);
		try {
			setState(813);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(793);
				match(If);
				setState(794);
				match(LeRoBr);
				setState(795);
				expression();
				setState(796);
				match(RiRoBr);
				setState(797);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(799);
				match(If);
				setState(800);
				match(LeRoBr);
				setState(801);
				expression();
				setState(802);
				match(RiRoBr);
				setState(803);
				statement();
				setState(804);
				match(Else);
				setState(805);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(807);
				match(Switch);
				setState(808);
				match(LeRoBr);
				setState(809);
				expression();
				setState(810);
				match(RiRoBr);
				setState(811);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Iteration_statementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(C99Parser.While, 0); }
		public TerminalNode LeRoBr() { return getToken(C99Parser.LeRoBr, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RiRoBr() { return getToken(C99Parser.RiRoBr, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Do() { return getToken(C99Parser.Do, 0); }
		public List<TerminalNode> Semico() { return getTokens(C99Parser.Semico); }
		public TerminalNode Semico(int i) {
			return getToken(C99Parser.Semico, i);
		}
		public TerminalNode For() { return getToken(C99Parser.For, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public Iteration_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iteration_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitIteration_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Iteration_statementContext iteration_statement() throws RecognitionException {
		Iteration_statementContext _localctx = new Iteration_statementContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_iteration_statement);
		try {
			setState(857);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(815);
				match(While);
				setState(816);
				match(LeRoBr);
				setState(817);
				expression();
				setState(818);
				match(RiRoBr);
				setState(819);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(821);
				match(Do);
				setState(822);
				statement();
				setState(823);
				match(While);
				setState(824);
				match(LeRoBr);
				setState(825);
				expression();
				setState(826);
				match(RiRoBr);
				setState(827);
				match(Semico);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(829);
				match(For);
				setState(830);
				match(LeRoBr);
				setState(832);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
				case 1:
					{
					setState(831);
					expression();
					}
					break;
				}
				setState(834);
				match(Semico);
				setState(836);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
				case 1:
					{
					setState(835);
					expression();
					}
					break;
				}
				setState(838);
				match(Semico);
				setState(840);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
				case 1:
					{
					setState(839);
					expression();
					}
					break;
				}
				setState(842);
				match(RiRoBr);
				setState(843);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(844);
				match(For);
				setState(845);
				match(LeRoBr);
				setState(846);
				declaration();
				setState(848);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
				case 1:
					{
					setState(847);
					expression();
					}
					break;
				}
				setState(850);
				match(Semico);
				setState(852);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
				case 1:
					{
					setState(851);
					expression();
					}
					break;
				}
				setState(854);
				match(RiRoBr);
				setState(855);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Jump_statementContext extends ParserRuleContext {
		public TerminalNode Goto() { return getToken(C99Parser.Goto, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Semico() { return getToken(C99Parser.Semico, 0); }
		public TerminalNode Continue() { return getToken(C99Parser.Continue, 0); }
		public TerminalNode Break() { return getToken(C99Parser.Break, 0); }
		public TerminalNode Return() { return getToken(C99Parser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Jump_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jump_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitJump_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jump_statementContext jump_statement() throws RecognitionException {
		Jump_statementContext _localctx = new Jump_statementContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_jump_statement);
		try {
			setState(872);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Goto:
				enterOuterAlt(_localctx, 1);
				{
				setState(859);
				match(Goto);
				setState(860);
				identifier();
				setState(861);
				match(Semico);
				}
				break;
			case Continue:
				enterOuterAlt(_localctx, 2);
				{
				setState(863);
				match(Continue);
				setState(864);
				match(Semico);
				}
				break;
			case Break:
				enterOuterAlt(_localctx, 3);
				{
				setState(865);
				match(Break);
				setState(866);
				match(Semico);
				}
				break;
			case Return:
				enterOuterAlt(_localctx, 4);
				{
				setState(867);
				match(Return);
				setState(869);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
				case 1:
					{
					setState(868);
					expression();
					}
					break;
				}
				setState(871);
				match(Semico);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Asm_statementContext extends ParserRuleContext {
		public TerminalNode Asm() { return getToken(C99Parser.Asm, 0); }
		public TerminalNode LeRoBr() { return getToken(C99Parser.LeRoBr, 0); }
		public TerminalNode String_literal() { return getToken(C99Parser.String_literal, 0); }
		public TerminalNode RiRoBr() { return getToken(C99Parser.RiRoBr, 0); }
		public TerminalNode Semico() { return getToken(C99Parser.Semico, 0); }
		public Asm_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asm_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitAsm_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Asm_statementContext asm_statement() throws RecognitionException {
		Asm_statementContext _localctx = new Asm_statementContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_asm_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(874);
			match(Asm);
			setState(875);
			match(LeRoBr);
			setState(876);
			match(String_literal);
			setState(877);
			match(RiRoBr);
			setState(878);
			match(Semico);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Translation_unitContext extends ParserRuleContext {
		public List<External_declarationContext> external_declaration() {
			return getRuleContexts(External_declarationContext.class);
		}
		public External_declarationContext external_declaration(int i) {
			return getRuleContext(External_declarationContext.class,i);
		}
		public Translation_unitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translation_unit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitTranslation_unit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Translation_unitContext translation_unit() throws RecognitionException {
		Translation_unitContext _localctx = new Translation_unitContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_translation_unit);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(881); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(880);
					external_declaration();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(883); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class External_declarationContext extends ParserRuleContext {
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public External_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_external_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitExternal_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final External_declarationContext external_declaration() throws RecognitionException {
		External_declarationContext _localctx = new External_declarationContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_external_declaration);
		try {
			setState(887);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(885);
				function_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(886);
				declaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_definitionContext extends ParserRuleContext {
		public Declaration_specifiersContext declaration_specifiers() {
			return getRuleContext(Declaration_specifiersContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public List<Attributes_declarationContext> attributes_declaration() {
			return getRuleContexts(Attributes_declarationContext.class);
		}
		public Attributes_declarationContext attributes_declaration(int i) {
			return getRuleContext(Attributes_declarationContext.class,i);
		}
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitFunction_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_function_definition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(892);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,99,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(889);
					attributes_declaration();
					}
					} 
				}
				setState(894);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,99,_ctx);
			}
			setState(895);
			declaration_specifiers();
			setState(896);
			declarator();
			setState(898);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				{
				setState(897);
				declaration_list();
				}
				break;
			}
			setState(900);
			compound_statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaration_listContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public Declaration_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitDeclaration_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaration_listContext declaration_list() throws RecognitionException {
		Declaration_listContext _localctx = new Declaration_listContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_declaration_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(903); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(902);
					declaration();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(905); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return identifier_sempred((IdentifierContext)_localctx, predIndex);
		case 3:
			return postfix_expression_sempred((Postfix_expressionContext)_localctx, predIndex);
		case 7:
			return multiplicative_expression_sempred((Multiplicative_expressionContext)_localctx, predIndex);
		case 8:
			return additive_expression_sempred((Additive_expressionContext)_localctx, predIndex);
		case 9:
			return shift_expression_sempred((Shift_expressionContext)_localctx, predIndex);
		case 10:
			return relational_expression_sempred((Relational_expressionContext)_localctx, predIndex);
		case 11:
			return equality_expression_sempred((Equality_expressionContext)_localctx, predIndex);
		case 12:
			return and_expression_sempred((And_expressionContext)_localctx, predIndex);
		case 13:
			return xor_expression_sempred((Xor_expressionContext)_localctx, predIndex);
		case 14:
			return or_expression_sempred((Or_expressionContext)_localctx, predIndex);
		case 15:
			return land_expression_sempred((Land_expressionContext)_localctx, predIndex);
		case 16:
			return lor_expression_sempred((Lor_expressionContext)_localctx, predIndex);
		case 40:
			return direct_declarator_sempred((Direct_declaratorContext)_localctx, predIndex);
		case 49:
			return direct_abstract_declarator_sempred((Direct_abstract_declaratorContext)_localctx, predIndex);
		case 50:
			return typedef_name_sempred((Typedef_nameContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean identifier_sempred(IdentifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return !C99Compiler.C99Compiler.hasTypedef(getCurrentToken().getText());
		}
		return true;
	}
	private boolean postfix_expression_sempred(Postfix_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multiplicative_expression_sempred(Multiplicative_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additive_expression_sempred(Additive_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean shift_expression_sempred(Shift_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relational_expression_sempred(Relational_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equality_expression_sempred(Equality_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean and_expression_sempred(And_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean xor_expression_sempred(Xor_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean or_expression_sempred(Or_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean land_expression_sempred(Land_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean lor_expression_sempred(Lor_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 16:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean direct_declarator_sempred(Direct_declaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 17:
			return precpred(_ctx, 6);
		case 18:
			return precpred(_ctx, 5);
		case 19:
			return precpred(_ctx, 4);
		case 20:
			return precpred(_ctx, 3);
		case 21:
			return precpred(_ctx, 2);
		case 22:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean direct_abstract_declarator_sempred(Direct_abstract_declaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 23:
			return precpred(_ctx, 12);
		case 24:
			return precpred(_ctx, 10);
		case 25:
			return precpred(_ctx, 8);
		case 26:
			return precpred(_ctx, 6);
		case 27:
			return precpred(_ctx, 4);
		case 28:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean typedef_name_sempred(Typedef_nameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 29:
			return C99Compiler.C99Compiler.hasTypedef(getCurrentToken().getText());
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001x\u038c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"+
		"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002\u0099\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00a3\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003\u00a7\b\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003\u00b1\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u0003\u00be\b\u0003\n\u0003\f\u0003\u00c1\t\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004\u00c6\b\u0004\n\u0004\f\u0004\u00c9"+
		"\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00eb\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00f3"+
		"\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007\u00fb\b\u0007\n\u0007\f\u0007\u00fe\t\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0106\b\b\n\b\f\b\u0109"+
		"\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0111\b\t"+
		"\n\t\f\t\u0114\t\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u011c\b\n\n\n\f\n\u011f\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0127\b\u000b\n\u000b\f\u000b"+
		"\u012a\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f"+
		"\u0132\b\f\n\f\f\f\u0135\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u013d\b\r\n\r\f\r\u0140\t\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0148\b\u000e\n\u000e"+
		"\f\u000e\u014b\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0005\u000f\u0153\b\u000f\n\u000f\f\u000f\u0156"+
		"\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0005\u0010\u015e\b\u0010\n\u0010\f\u0010\u0161\t\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u016a\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u0171\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0005\u0013\u0176\b\u0013\n\u0013\f\u0013\u0179\t\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0005"+
		"\u0016\u0182\b\u0016\n\u0016\f\u0016\u0185\t\u0016\u0001\u0016\u0001\u0016"+
		"\u0003\u0016\u0189\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0004\u0017\u0192\b\u0017\u000b\u0017"+
		"\f\u0017\u0193\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0005\u001a\u019d\b\u001a\n\u001a\f\u001a\u01a0"+
		"\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u01a5\b\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u01ab\b\u001c"+
		"\u0001\u001d\u0001\u001d\u0003\u001d\u01af\b\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u01b7\b\u001d"+
		"\u0001\u001e\u0004\u001e\u01ba\b\u001e\u000b\u001e\f\u001e\u01bb\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0003 \u01c4"+
		"\b \u0001 \u0003 \u01c7\b \u0001!\u0001!\u0001!\u0005!\u01cc\b!\n!\f!"+
		"\u01cf\t!\u0001\"\u0001\"\u0003\"\u01d3\b\"\u0001\"\u0001\"\u0003\"\u01d7"+
		"\b\"\u0001#\u0001#\u0003#\u01db\b#\u0001#\u0001#\u0001#\u0003#\u01e0\b"+
		"#\u0001#\u0001#\u0001#\u0001#\u0003#\u01e6\b#\u0001$\u0001$\u0001$\u0005"+
		"$\u01eb\b$\n$\f$\u01ee\t$\u0001%\u0001%\u0001%\u0003%\u01f3\b%\u0001&"+
		"\u0001&\u0001\'\u0003\'\u01f8\b\'\u0001\'\u0001\'\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0001(\u0003(\u0202\b(\u0001(\u0001(\u0001(\u0003(\u0207"+
		"\b(\u0001(\u0003(\u020a\b(\u0001(\u0001(\u0001(\u0001(\u0001(\u0003(\u0211"+
		"\b(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0001(\u0003(\u0220\b(\u0001(\u0001(\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0001(\u0001(\u0001(\u0003(\u022c\b(\u0001(\u0005(\u022f"+
		"\b(\n(\f(\u0232\t(\u0001)\u0001)\u0003)\u0236\b)\u0004)\u0238\b)\u000b"+
		")\f)\u0239\u0001*\u0004*\u023d\b*\u000b*\f*\u023e\u0001+\u0001+\u0001"+
		"+\u0003+\u0244\b+\u0001,\u0001,\u0001,\u0005,\u0249\b,\n,\f,\u024c\t,"+
		"\u0001-\u0001-\u0001-\u0003-\u0251\b-\u0003-\u0253\b-\u0001.\u0001.\u0001"+
		".\u0005.\u0258\b.\n.\f.\u025b\t.\u0001/\u0001/\u0003/\u025f\b/\u00010"+
		"\u00010\u00030\u0263\b0\u00010\u00030\u0266\b0\u00011\u00011\u00011\u0001"+
		"1\u00011\u00011\u00011\u00031\u026f\b1\u00011\u00031\u0272\b1\u00011\u0001"+
		"1\u00011\u00011\u00031\u0278\b1\u00011\u00011\u00011\u00011\u00011\u0001"+
		"1\u00011\u00011\u00011\u00011\u00011\u00031\u0285\b1\u00011\u00011\u0001"+
		"1\u00011\u00011\u00011\u00011\u00011\u00031\u028f\b1\u00011\u00031\u0292"+
		"\b1\u00011\u00011\u00011\u00031\u0297\b1\u00011\u00031\u029a\b1\u0001"+
		"1\u00011\u00011\u00011\u00011\u00031\u02a1\b1\u00011\u00011\u00011\u0001"+
		"1\u00011\u00011\u00011\u00011\u00011\u00011\u00011\u00011\u00011\u0003"+
		"1\u02b0\b1\u00011\u00011\u00011\u00011\u00011\u00011\u00011\u00011\u0001"+
		"1\u00011\u00031\u02bc\b1\u00011\u00051\u02bf\b1\n1\f1\u02c2\t1\u00012"+
		"\u00012\u00012\u00013\u00013\u00013\u00013\u00033\u02cb\b3\u00013\u0001"+
		"3\u00033\u02cf\b3\u00014\u00034\u02d2\b4\u00014\u00014\u00014\u00034\u02d7"+
		"\b4\u00014\u00054\u02da\b4\n4\f4\u02dd\t4\u00015\u00015\u00015\u00016"+
		"\u00046\u02e3\b6\u000b6\f6\u02e4\u00017\u00017\u00017\u00017\u00017\u0001"+
		"7\u00037\u02ed\b7\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0003"+
		"8\u02f6\b8\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u0001"+
		"9\u00019\u00019\u00019\u00039\u0304\b9\u0001:\u0001:\u0003:\u0308\b:\u0001"+
		":\u0001:\u0001;\u0004;\u030d\b;\u000b;\f;\u030e\u0001<\u0001<\u0003<\u0313"+
		"\b<\u0001=\u0003=\u0316\b=\u0001=\u0001=\u0001>\u0001>\u0001>\u0001>\u0001"+
		">\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001"+
		">\u0001>\u0001>\u0001>\u0001>\u0001>\u0003>\u032e\b>\u0001?\u0001?\u0001"+
		"?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001"+
		"?\u0001?\u0001?\u0001?\u0001?\u0003?\u0341\b?\u0001?\u0001?\u0003?\u0345"+
		"\b?\u0001?\u0001?\u0003?\u0349\b?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001"+
		"?\u0003?\u0351\b?\u0001?\u0001?\u0003?\u0355\b?\u0001?\u0001?\u0001?\u0003"+
		"?\u035a\b?\u0001@\u0001@\u0001@\u0001@\u0001@\u0001@\u0001@\u0001@\u0001"+
		"@\u0001@\u0003@\u0366\b@\u0001@\u0003@\u0369\b@\u0001A\u0001A\u0001A\u0001"+
		"A\u0001A\u0001A\u0001B\u0004B\u0372\bB\u000bB\fB\u0373\u0001C\u0001C\u0003"+
		"C\u0378\bC\u0001D\u0005D\u037b\bD\nD\fD\u037e\tD\u0001D\u0001D\u0001D"+
		"\u0003D\u0383\bD\u0001D\u0001D\u0001E\u0004E\u0388\bE\u000bE\fE\u0389"+
		"\u0001E\u0001\u0193\r\u0006\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e PbF\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfh"+
		"jlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u0000\f\u0001\u0000Z_"+
		"\u0001\u0000wx\u0002\u0000[[`a\u0001\u0000\\]\u0001\u0000>?\u0001\u0000"+
		"@C\u0001\u0000DE\u0002\u0000HQhh\u0006\u0000\u0001\u0001\f\f\u0014\u0014"+
		"\u001a\u001a\u001d\u001d55\u0007\u0000\u0004\u0004\t\t\r\r\u0012\u0013"+
		"\u0017\u0018\u001f #$\u0002\u0000\u001b\u001b\u001e\u001e\u0004\u0000"+
		"\u0005\u0005\u0015\u0015!!68\u03d5\u0000\u008c\u0001\u0000\u0000\u0000"+
		"\u0002\u008e\u0001\u0000\u0000\u0000\u0004\u0098\u0001\u0000\u0000\u0000"+
		"\u0006\u00a6\u0001\u0000\u0000\u0000\b\u00c2\u0001\u0000\u0000\u0000\n"+
		"\u00ea\u0001\u0000\u0000\u0000\f\u00f2\u0001\u0000\u0000\u0000\u000e\u00f4"+
		"\u0001\u0000\u0000\u0000\u0010\u00ff\u0001\u0000\u0000\u0000\u0012\u010a"+
		"\u0001\u0000\u0000\u0000\u0014\u0115\u0001\u0000\u0000\u0000\u0016\u0120"+
		"\u0001\u0000\u0000\u0000\u0018\u012b\u0001\u0000\u0000\u0000\u001a\u0136"+
		"\u0001\u0000\u0000\u0000\u001c\u0141\u0001\u0000\u0000\u0000\u001e\u014c"+
		"\u0001\u0000\u0000\u0000 \u0157\u0001\u0000\u0000\u0000\"\u0169\u0001"+
		"\u0000\u0000\u0000$\u0170\u0001\u0000\u0000\u0000&\u0172\u0001\u0000\u0000"+
		"\u0000(\u017a\u0001\u0000\u0000\u0000*\u017c\u0001\u0000\u0000\u0000,"+
		"\u0183\u0001\u0000\u0000\u0000.\u0191\u0001\u0000\u0000\u00000\u0195\u0001"+
		"\u0000\u0000\u00002\u0197\u0001\u0000\u0000\u00004\u0199\u0001\u0000\u0000"+
		"\u00006\u01a1\u0001\u0000\u0000\u00008\u01aa\u0001\u0000\u0000\u0000:"+
		"\u01b6\u0001\u0000\u0000\u0000<\u01b9\u0001\u0000\u0000\u0000>\u01bd\u0001"+
		"\u0000\u0000\u0000@\u01c3\u0001\u0000\u0000\u0000B\u01c8\u0001\u0000\u0000"+
		"\u0000D\u01d6\u0001\u0000\u0000\u0000F\u01e5\u0001\u0000\u0000\u0000H"+
		"\u01e7\u0001\u0000\u0000\u0000J\u01ef\u0001\u0000\u0000\u0000L\u01f4\u0001"+
		"\u0000\u0000\u0000N\u01f7\u0001\u0000\u0000\u0000P\u0201\u0001\u0000\u0000"+
		"\u0000R\u0237\u0001\u0000\u0000\u0000T\u023c\u0001\u0000\u0000\u0000V"+
		"\u0240\u0001\u0000\u0000\u0000X\u0245\u0001\u0000\u0000\u0000Z\u024d\u0001"+
		"\u0000\u0000\u0000\\\u0254\u0001\u0000\u0000\u0000^\u025c\u0001\u0000"+
		"\u0000\u0000`\u0265\u0001\u0000\u0000\u0000b\u0291\u0001\u0000\u0000\u0000"+
		"d\u02c3\u0001\u0000\u0000\u0000f\u02ce\u0001\u0000\u0000\u0000h\u02d1"+
		"\u0001\u0000\u0000\u0000j\u02de\u0001\u0000\u0000\u0000l\u02e2\u0001\u0000"+
		"\u0000\u0000n\u02ec\u0001\u0000\u0000\u0000p\u02f5\u0001\u0000\u0000\u0000"+
		"r\u0303\u0001\u0000\u0000\u0000t\u0305\u0001\u0000\u0000\u0000v\u030c"+
		"\u0001\u0000\u0000\u0000x\u0312\u0001\u0000\u0000\u0000z\u0315\u0001\u0000"+
		"\u0000\u0000|\u032d\u0001\u0000\u0000\u0000~\u0359\u0001\u0000\u0000\u0000"+
		"\u0080\u0368\u0001\u0000\u0000\u0000\u0082\u036a\u0001\u0000\u0000\u0000"+
		"\u0084\u0371\u0001\u0000\u0000\u0000\u0086\u0377\u0001\u0000\u0000\u0000"+
		"\u0088\u037c\u0001\u0000\u0000\u0000\u008a\u0387\u0001\u0000\u0000\u0000"+
		"\u008c\u008d\u0003\u0084B\u0000\u008d\u0001\u0001\u0000\u0000\u0000\u008e"+
		"\u008f\u0004\u0001\u0000\u0000\u008f\u0090\u0005t\u0000\u0000\u0090\u0003"+
		"\u0001\u0000\u0000\u0000\u0091\u0099\u0003\u0002\u0001\u0000\u0092\u0099"+
		"\u0005u\u0000\u0000\u0093\u0099\u0005w\u0000\u0000\u0094\u0095\u0005m"+
		"\u0000\u0000\u0095\u0096\u0003&\u0013\u0000\u0096\u0097\u0005n\u0000\u0000"+
		"\u0097\u0099\u0001\u0000\u0000\u0000\u0098\u0091\u0001\u0000\u0000\u0000"+
		"\u0098\u0092\u0001\u0000\u0000\u0000\u0098\u0093\u0001\u0000\u0000\u0000"+
		"\u0098\u0094\u0001\u0000\u0000\u0000\u0099\u0005\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0006\u0003\uffff\uffff\u0000\u009b\u00a7\u0003\u0004\u0002"+
		"\u0000\u009c\u009d\u0005m\u0000\u0000\u009d\u009e\u0003^/\u0000\u009e"+
		"\u009f\u0005n\u0000\u0000\u009f\u00a0\u0005o\u0000\u0000\u00a0\u00a2\u0003"+
		"h4\u0000\u00a1\u00a3\u0005i\u0000\u0000\u00a2\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a5\u0005p\u0000\u0000\u00a5\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a6\u009a\u0001\u0000\u0000\u0000\u00a6\u009c\u0001\u0000\u0000\u0000"+
		"\u00a7\u00bf\u0001\u0000\u0000\u0000\u00a8\u00a9\n\u0007\u0000\u0000\u00a9"+
		"\u00aa\u0005k\u0000\u0000\u00aa\u00ab\u0003&\u0013\u0000\u00ab\u00ac\u0005"+
		"l\u0000\u0000\u00ac\u00be\u0001\u0000\u0000\u0000\u00ad\u00ae\n\u0006"+
		"\u0000\u0000\u00ae\u00b0\u0005m\u0000\u0000\u00af\u00b1\u0003\b\u0004"+
		"\u0000\u00b0\u00af\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00be\u0005n\u0000\u0000"+
		"\u00b3\u00b4\n\u0005\u0000\u0000\u00b4\u00b5\u0005f\u0000\u0000\u00b5"+
		"\u00be\u0003\u0002\u0001\u0000\u00b6\u00b7\n\u0004\u0000\u0000\u00b7\u00b8"+
		"\u0005;\u0000\u0000\u00b8\u00be\u0003\u0002\u0001\u0000\u00b9\u00ba\n"+
		"\u0003\u0000\u0000\u00ba\u00be\u0005<\u0000\u0000\u00bb\u00bc\n\u0002"+
		"\u0000\u0000\u00bc\u00be\u0005=\u0000\u0000\u00bd\u00a8\u0001\u0000\u0000"+
		"\u0000\u00bd\u00ad\u0001\u0000\u0000\u0000\u00bd\u00b3\u0001\u0000\u0000"+
		"\u0000\u00bd\u00b6\u0001\u0000\u0000\u0000\u00bd\u00b9\u0001\u0000\u0000"+
		"\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000\u0000"+
		"\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000"+
		"\u0000\u00c0\u0007\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c7\u0003$\u0012\u0000\u00c3\u00c4\u0005i\u0000\u0000\u00c4"+
		"\u00c6\u0003$\u0012\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c6\u00c9"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c8"+
		"\u0001\u0000\u0000\u0000\u00c8\t\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001"+
		"\u0000\u0000\u0000\u00ca\u00eb\u0003\u0006\u0003\u0000\u00cb\u00cc\u0005"+
		"<\u0000\u0000\u00cc\u00eb\u0003\n\u0005\u0000\u00cd\u00ce\u0005=\u0000"+
		"\u0000\u00ce\u00eb\u0003\n\u0005\u0000\u00cf\u00d0\u0007\u0000\u0000\u0000"+
		"\u00d0\u00eb\u0003\f\u0006\u0000\u00d1\u00d2\u0005\u0019\u0000\u0000\u00d2"+
		"\u00eb\u0003\n\u0005\u0000\u00d3\u00d4\u0005\u0019\u0000\u0000\u00d4\u00d5"+
		"\u0005m\u0000\u0000\u00d5\u00d6\u0003^/\u0000\u00d6\u00d7\u0005n\u0000"+
		"\u0000\u00d7\u00eb\u0001\u0000\u0000\u0000\u00d8\u00d9\u00052\u0000\u0000"+
		"\u00d9\u00da\u0005m\u0000\u0000\u00da\u00db\u0007\u0001\u0000\u0000\u00db"+
		"\u00eb\u0005n\u0000\u0000\u00dc\u00dd\u0005\'\u0000\u0000\u00dd\u00eb"+
		"\u0003\u0002\u0001\u0000\u00de\u00df\u0005\'\u0000\u0000\u00df\u00e0\u0005"+
		"m\u0000\u0000\u00e0\u00e1\u0003\u0002\u0001\u0000\u00e1\u00e2\u0005n\u0000"+
		"\u0000\u00e2\u00eb\u0001\u0000\u0000\u0000\u00e3\u00e4\u00054\u0000\u0000"+
		"\u00e4\u00e5\u0005m\u0000\u0000\u00e5\u00e6\u0003^/\u0000\u00e6\u00e7"+
		"\u0005i\u0000\u0000\u00e7\u00e8\u0003\u0002\u0001\u0000\u00e8\u00e9\u0005"+
		"n\u0000\u0000\u00e9\u00eb\u0001\u0000\u0000\u0000\u00ea\u00ca\u0001\u0000"+
		"\u0000\u0000\u00ea\u00cb\u0001\u0000\u0000\u0000\u00ea\u00cd\u0001\u0000"+
		"\u0000\u0000\u00ea\u00cf\u0001\u0000\u0000\u0000\u00ea\u00d1\u0001\u0000"+
		"\u0000\u0000\u00ea\u00d3\u0001\u0000\u0000\u0000\u00ea\u00d8\u0001\u0000"+
		"\u0000\u0000\u00ea\u00dc\u0001\u0000\u0000\u0000\u00ea\u00de\u0001\u0000"+
		"\u0000\u0000\u00ea\u00e3\u0001\u0000\u0000\u0000\u00eb\u000b\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ed\u0005m\u0000\u0000\u00ed\u00ee\u0003^/\u0000"+
		"\u00ee\u00ef\u0005n\u0000\u0000\u00ef\u00f0\u0003\f\u0006\u0000\u00f0"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f1\u00f3\u0003\n\u0005\u0000\u00f2\u00ec"+
		"\u0001\u0000\u0000\u0000\u00f2\u00f1\u0001\u0000\u0000\u0000\u00f3\r\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f5\u0006\u0007\uffff\uffff\u0000\u00f5\u00f6"+
		"\u0003\f\u0006\u0000\u00f6\u00fc\u0001\u0000\u0000\u0000\u00f7\u00f8\n"+
		"\u0001\u0000\u0000\u00f8\u00f9\u0007\u0002\u0000\u0000\u00f9\u00fb\u0003"+
		"\f\u0006\u0000\u00fa\u00f7\u0001\u0000\u0000\u0000\u00fb\u00fe\u0001\u0000"+
		"\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000"+
		"\u0000\u0000\u00fd\u000f\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000"+
		"\u0000\u0000\u00ff\u0100\u0006\b\uffff\uffff\u0000\u0100\u0101\u0003\u000e"+
		"\u0007\u0000\u0101\u0107\u0001\u0000\u0000\u0000\u0102\u0103\n\u0001\u0000"+
		"\u0000\u0103\u0104\u0007\u0003\u0000\u0000\u0104\u0106\u0003\u000e\u0007"+
		"\u0000\u0105\u0102\u0001\u0000\u0000\u0000\u0106\u0109\u0001\u0000\u0000"+
		"\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0107\u0108\u0001\u0000\u0000"+
		"\u0000\u0108\u0011\u0001\u0000\u0000\u0000\u0109\u0107\u0001\u0000\u0000"+
		"\u0000\u010a\u010b\u0006\t\uffff\uffff\u0000\u010b\u010c\u0003\u0010\b"+
		"\u0000\u010c\u0112\u0001\u0000\u0000\u0000\u010d\u010e\n\u0001\u0000\u0000"+
		"\u010e\u010f\u0007\u0004\u0000\u0000\u010f\u0111\u0003\u0010\b\u0000\u0110"+
		"\u010d\u0001\u0000\u0000\u0000\u0111\u0114\u0001\u0000\u0000\u0000\u0112"+
		"\u0110\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0113"+
		"\u0013\u0001\u0000\u0000\u0000\u0114\u0112\u0001\u0000\u0000\u0000\u0115"+
		"\u0116\u0006\n\uffff\uffff\u0000\u0116\u0117\u0003\u0012\t\u0000\u0117"+
		"\u011d\u0001\u0000\u0000\u0000\u0118\u0119\n\u0001\u0000\u0000\u0119\u011a"+
		"\u0007\u0005\u0000\u0000\u011a\u011c\u0003\u0012\t\u0000\u011b\u0118\u0001"+
		"\u0000\u0000\u0000\u011c\u011f\u0001\u0000\u0000\u0000\u011d\u011b\u0001"+
		"\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000\u0000\u011e\u0015\u0001"+
		"\u0000\u0000\u0000\u011f\u011d\u0001\u0000\u0000\u0000\u0120\u0121\u0006"+
		"\u000b\uffff\uffff\u0000\u0121\u0122\u0003\u0014\n\u0000\u0122\u0128\u0001"+
		"\u0000\u0000\u0000\u0123\u0124\n\u0001\u0000\u0000\u0124\u0125\u0007\u0006"+
		"\u0000\u0000\u0125\u0127\u0003\u0014\n\u0000\u0126\u0123\u0001\u0000\u0000"+
		"\u0000\u0127\u012a\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000\u0000"+
		"\u0000\u0128\u0129\u0001\u0000\u0000\u0000\u0129\u0017\u0001\u0000\u0000"+
		"\u0000\u012a\u0128\u0001\u0000\u0000\u0000\u012b\u012c\u0006\f\uffff\uffff"+
		"\u0000\u012c\u012d\u0003\u0016\u000b\u0000\u012d\u0133\u0001\u0000\u0000"+
		"\u0000\u012e\u012f\n\u0001\u0000\u0000\u012f\u0130\u0005Z\u0000\u0000"+
		"\u0130\u0132\u0003\u0016\u000b\u0000\u0131\u012e\u0001\u0000\u0000\u0000"+
		"\u0132\u0135\u0001\u0000\u0000\u0000\u0133\u0131\u0001\u0000\u0000\u0000"+
		"\u0133\u0134\u0001\u0000\u0000\u0000\u0134\u0019\u0001\u0000\u0000\u0000"+
		"\u0135\u0133\u0001\u0000\u0000\u0000\u0136\u0137\u0006\r\uffff\uffff\u0000"+
		"\u0137\u0138\u0003\u0018\f\u0000\u0138\u013e\u0001\u0000\u0000\u0000\u0139"+
		"\u013a\n\u0001\u0000\u0000\u013a\u013b\u0005b\u0000\u0000\u013b\u013d"+
		"\u0003\u0018\f\u0000\u013c\u0139\u0001\u0000\u0000\u0000\u013d\u0140\u0001"+
		"\u0000\u0000\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013e\u013f\u0001"+
		"\u0000\u0000\u0000\u013f\u001b\u0001\u0000\u0000\u0000\u0140\u013e\u0001"+
		"\u0000\u0000\u0000\u0141\u0142\u0006\u000e\uffff\uffff\u0000\u0142\u0143"+
		"\u0003\u001a\r\u0000\u0143\u0149\u0001\u0000\u0000\u0000\u0144\u0145\n"+
		"\u0001\u0000\u0000\u0145\u0146\u0005c\u0000\u0000\u0146\u0148\u0003\u001a"+
		"\r\u0000\u0147\u0144\u0001\u0000\u0000\u0000\u0148\u014b\u0001\u0000\u0000"+
		"\u0000\u0149\u0147\u0001\u0000\u0000\u0000\u0149\u014a\u0001\u0000\u0000"+
		"\u0000\u014a\u001d\u0001\u0000\u0000\u0000\u014b\u0149\u0001\u0000\u0000"+
		"\u0000\u014c\u014d\u0006\u000f\uffff\uffff\u0000\u014d\u014e\u0003\u001c"+
		"\u000e\u0000\u014e\u0154\u0001\u0000\u0000\u0000\u014f\u0150\n\u0001\u0000"+
		"\u0000\u0150\u0151\u0005F\u0000\u0000\u0151\u0153\u0003\u001c\u000e\u0000"+
		"\u0152\u014f\u0001\u0000\u0000\u0000\u0153\u0156\u0001\u0000\u0000\u0000"+
		"\u0154\u0152\u0001\u0000\u0000\u0000\u0154\u0155\u0001\u0000\u0000\u0000"+
		"\u0155\u001f\u0001\u0000\u0000\u0000\u0156\u0154\u0001\u0000\u0000\u0000"+
		"\u0157\u0158\u0006\u0010\uffff\uffff\u0000\u0158\u0159\u0003\u001e\u000f"+
		"\u0000\u0159\u015f\u0001\u0000\u0000\u0000\u015a\u015b\n\u0001\u0000\u0000"+
		"\u015b\u015c\u0005G\u0000\u0000\u015c\u015e\u0003\u001e\u000f\u0000\u015d"+
		"\u015a\u0001\u0000\u0000\u0000\u015e\u0161\u0001\u0000\u0000\u0000\u015f"+
		"\u015d\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000\u0000\u0000\u0160"+
		"!\u0001\u0000\u0000\u0000\u0161\u015f\u0001\u0000\u0000\u0000\u0162\u016a"+
		"\u0003 \u0010\u0000\u0163\u0164\u0003 \u0010\u0000\u0164\u0165\u0005g"+
		"\u0000\u0000\u0165\u0166\u0003&\u0013\u0000\u0166\u0167\u0005d\u0000\u0000"+
		"\u0167\u0168\u0003\"\u0011\u0000\u0168\u016a\u0001\u0000\u0000\u0000\u0169"+
		"\u0162\u0001\u0000\u0000\u0000\u0169\u0163\u0001\u0000\u0000\u0000\u016a"+
		"#\u0001\u0000\u0000\u0000\u016b\u0171\u0003\"\u0011\u0000\u016c\u016d"+
		"\u0003\n\u0005\u0000\u016d\u016e\u0007\u0007\u0000\u0000\u016e\u016f\u0003"+
		"$\u0012\u0000\u016f\u0171\u0001\u0000\u0000\u0000\u0170\u016b\u0001\u0000"+
		"\u0000\u0000\u0170\u016c\u0001\u0000\u0000\u0000\u0171%\u0001\u0000\u0000"+
		"\u0000\u0172\u0177\u0003$\u0012\u0000\u0173\u0174\u0005i\u0000\u0000\u0174"+
		"\u0176\u0003$\u0012\u0000\u0175\u0173\u0001\u0000\u0000\u0000\u0176\u0179"+
		"\u0001\u0000\u0000\u0000\u0177\u0175\u0001\u0000\u0000\u0000\u0177\u0178"+
		"\u0001\u0000\u0000\u0000\u0178\'\u0001\u0000\u0000\u0000\u0179\u0177\u0001"+
		"\u0000\u0000\u0000\u017a\u017b\u0003\"\u0011\u0000\u017b)\u0001\u0000"+
		"\u0000\u0000\u017c\u017d\u0005X\u0000\u0000\u017d\u017e\u0003\\.\u0000"+
		"\u017e\u017f\u0005Y\u0000\u0000\u017f+\u0001\u0000\u0000\u0000\u0180\u0182"+
		"\u0003*\u0015\u0000\u0181\u0180\u0001\u0000\u0000\u0000\u0182\u0185\u0001"+
		"\u0000\u0000\u0000\u0183\u0181\u0001\u0000\u0000\u0000\u0183\u0184\u0001"+
		"\u0000\u0000\u0000\u0184\u0186\u0001\u0000\u0000\u0000\u0185\u0183\u0001"+
		"\u0000\u0000\u0000\u0186\u0188\u0003.\u0017\u0000\u0187\u0189\u00034\u001a"+
		"\u0000\u0188\u0187\u0001\u0000\u0000\u0000\u0188\u0189\u0001\u0000\u0000"+
		"\u0000\u0189\u018a\u0001\u0000\u0000\u0000\u018a\u018b\u0005e\u0000\u0000"+
		"\u018b\u018c\u0006\u0016\uffff\uffff\u0000\u018c-\u0001\u0000\u0000\u0000"+
		"\u018d\u0192\u00030\u0018\u0000\u018e\u0192\u00038\u001c\u0000\u018f\u0192"+
		"\u0003L&\u0000\u0190\u0192\u00032\u0019\u0000\u0191\u018d\u0001\u0000"+
		"\u0000\u0000\u0191\u018e\u0001\u0000\u0000\u0000\u0191\u018f\u0001\u0000"+
		"\u0000\u0000\u0191\u0190\u0001\u0000\u0000\u0000\u0192\u0193\u0001\u0000"+
		"\u0000\u0000\u0193\u0194\u0001\u0000\u0000\u0000\u0193\u0191\u0001\u0000"+
		"\u0000\u0000\u0194/\u0001\u0000\u0000\u0000\u0195\u0196\u0007\b\u0000"+
		"\u0000\u01961\u0001\u0000\u0000\u0000\u0197\u0198\u0005\u0011\u0000\u0000"+
		"\u01983\u0001\u0000\u0000\u0000\u0199\u019e\u00036\u001b\u0000\u019a\u019b"+
		"\u0005i\u0000\u0000\u019b\u019d\u00036\u001b\u0000\u019c\u019a\u0001\u0000"+
		"\u0000\u0000\u019d\u01a0\u0001\u0000\u0000\u0000\u019e\u019c\u0001\u0000"+
		"\u0000\u0000\u019e\u019f\u0001\u0000\u0000\u0000\u019f5\u0001\u0000\u0000"+
		"\u0000\u01a0\u019e\u0001\u0000\u0000\u0000\u01a1\u01a4\u0003N\'\u0000"+
		"\u01a2\u01a3\u0005h\u0000\u0000\u01a3\u01a5\u0003f3\u0000\u01a4\u01a2"+
		"\u0001\u0000\u0000\u0000\u01a4\u01a5\u0001\u0000\u0000\u0000\u01a57\u0001"+
		"\u0000\u0000\u0000\u01a6\u01ab\u0007\t\u0000\u0000\u01a7\u01ab\u0003:"+
		"\u001d\u0000\u01a8\u01ab\u0003F#\u0000\u01a9\u01ab\u0003d2\u0000\u01aa"+
		"\u01a6\u0001\u0000\u0000\u0000\u01aa\u01a7\u0001\u0000\u0000\u0000\u01aa"+
		"\u01a8\u0001\u0000\u0000\u0000\u01aa\u01a9\u0001\u0000\u0000\u0000\u01ab"+
		"9\u0001\u0000\u0000\u0000\u01ac\u01ae\u0007\n\u0000\u0000\u01ad\u01af"+
		"\u0003\u0002\u0001\u0000\u01ae\u01ad\u0001\u0000\u0000\u0000\u01ae\u01af"+
		"\u0001\u0000\u0000\u0000\u01af\u01b0\u0001\u0000\u0000\u0000\u01b0\u01b1"+
		"\u0005o\u0000\u0000\u01b1\u01b2\u0003<\u001e\u0000\u01b2\u01b3\u0005p"+
		"\u0000\u0000\u01b3\u01b7\u0001\u0000\u0000\u0000\u01b4\u01b5\u0007\n\u0000"+
		"\u0000\u01b5\u01b7\u0003\u0002\u0001\u0000\u01b6\u01ac\u0001\u0000\u0000"+
		"\u0000\u01b6\u01b4\u0001\u0000\u0000\u0000\u01b7;\u0001\u0000\u0000\u0000"+
		"\u01b8\u01ba\u0003>\u001f\u0000\u01b9\u01b8\u0001\u0000\u0000\u0000\u01ba"+
		"\u01bb\u0001\u0000\u0000\u0000\u01bb\u01b9\u0001\u0000\u0000\u0000\u01bb"+
		"\u01bc\u0001\u0000\u0000\u0000\u01bc=\u0001\u0000\u0000\u0000\u01bd\u01be"+
		"\u0003@ \u0000\u01be\u01bf\u0003B!\u0000\u01bf\u01c0\u0005e\u0000\u0000"+
		"\u01c0?\u0001\u0000\u0000\u0000\u01c1\u01c4\u00038\u001c\u0000\u01c2\u01c4"+
		"\u0003L&\u0000\u01c3\u01c1\u0001\u0000\u0000\u0000\u01c3\u01c2\u0001\u0000"+
		"\u0000\u0000\u01c4\u01c6\u0001\u0000\u0000\u0000\u01c5\u01c7\u0003@ \u0000"+
		"\u01c6\u01c5\u0001\u0000\u0000\u0000\u01c6\u01c7\u0001\u0000\u0000\u0000"+
		"\u01c7A\u0001\u0000\u0000\u0000\u01c8\u01cd\u0003D\"\u0000\u01c9\u01ca"+
		"\u0005i\u0000\u0000\u01ca\u01cc\u0003D\"\u0000\u01cb\u01c9\u0001\u0000"+
		"\u0000\u0000\u01cc\u01cf\u0001\u0000\u0000\u0000\u01cd\u01cb\u0001\u0000"+
		"\u0000\u0000\u01cd\u01ce\u0001\u0000\u0000\u0000\u01ceC\u0001\u0000\u0000"+
		"\u0000\u01cf\u01cd\u0001\u0000\u0000\u0000\u01d0\u01d7\u0003N\'\u0000"+
		"\u01d1\u01d3\u0003N\'\u0000\u01d2\u01d1\u0001\u0000\u0000\u0000\u01d2"+
		"\u01d3\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000\u0000\u0000\u01d4"+
		"\u01d5\u0005d\u0000\u0000\u01d5\u01d7\u0003(\u0014\u0000\u01d6\u01d0\u0001"+
		"\u0000\u0000\u0000\u01d6\u01d2\u0001\u0000\u0000\u0000\u01d7E\u0001\u0000"+
		"\u0000\u0000\u01d8\u01da\u0005\u000b\u0000\u0000\u01d9\u01db\u0003\u0002"+
		"\u0001\u0000\u01da\u01d9\u0001\u0000\u0000\u0000\u01da\u01db\u0001\u0000"+
		"\u0000\u0000\u01db\u01dc\u0001\u0000\u0000\u0000\u01dc\u01dd\u0005o\u0000"+
		"\u0000\u01dd\u01df\u0003H$\u0000\u01de\u01e0\u0005i\u0000\u0000\u01df"+
		"\u01de\u0001\u0000\u0000\u0000\u01df\u01e0\u0001\u0000\u0000\u0000\u01e0"+
		"\u01e1\u0001\u0000\u0000\u0000\u01e1\u01e2\u0005p\u0000\u0000\u01e2\u01e6"+
		"\u0001\u0000\u0000\u0000\u01e3\u01e4\u0005\u000b\u0000\u0000\u01e4\u01e6"+
		"\u0003\u0002\u0001\u0000\u01e5\u01d8\u0001\u0000\u0000\u0000\u01e5\u01e3"+
		"\u0001\u0000\u0000\u0000\u01e6G\u0001\u0000\u0000\u0000\u01e7\u01ec\u0003"+
		"J%\u0000\u01e8\u01e9\u0005i\u0000\u0000\u01e9\u01eb\u0003J%\u0000\u01ea"+
		"\u01e8\u0001\u0000\u0000\u0000\u01eb\u01ee\u0001\u0000\u0000\u0000\u01ec"+
		"\u01ea\u0001\u0000\u0000\u0000\u01ec\u01ed\u0001\u0000\u0000\u0000\u01ed"+
		"I\u0001\u0000\u0000\u0000\u01ee\u01ec\u0001\u0000\u0000\u0000\u01ef\u01f2"+
		"\u0003\u0002\u0001\u0000\u01f0\u01f1\u0005h\u0000\u0000\u01f1\u01f3\u0003"+
		"(\u0014\u0000\u01f2\u01f0\u0001\u0000\u0000\u0000\u01f2\u01f3\u0001\u0000"+
		"\u0000\u0000\u01f3K\u0001\u0000\u0000\u0000\u01f4\u01f5\u0007\u000b\u0000"+
		"\u0000\u01f5M\u0001\u0000\u0000\u0000\u01f6\u01f8\u0003R)\u0000\u01f7"+
		"\u01f6\u0001\u0000\u0000\u0000\u01f7\u01f8\u0001\u0000\u0000\u0000\u01f8"+
		"\u01f9\u0001\u0000\u0000\u0000\u01f9\u01fa\u0003P(\u0000\u01faO\u0001"+
		"\u0000\u0000\u0000\u01fb\u01fc\u0006(\uffff\uffff\u0000\u01fc\u0202\u0003"+
		"\u0002\u0001\u0000\u01fd\u01fe\u0005m\u0000\u0000\u01fe\u01ff\u0003N\'"+
		"\u0000\u01ff\u0200\u0005n\u0000\u0000\u0200\u0202\u0001\u0000\u0000\u0000"+
		"\u0201\u01fb\u0001\u0000\u0000\u0000\u0201\u01fd\u0001\u0000\u0000\u0000"+
		"\u0202\u0230\u0001\u0000\u0000\u0000\u0203\u0204\n\u0006\u0000\u0000\u0204"+
		"\u0206\u0005k\u0000\u0000\u0205\u0207\u0003T*\u0000\u0206\u0205\u0001"+
		"\u0000\u0000\u0000\u0206\u0207\u0001\u0000\u0000\u0000\u0207\u0209\u0001"+
		"\u0000\u0000\u0000\u0208\u020a\u0003$\u0012\u0000\u0209\u0208\u0001\u0000"+
		"\u0000\u0000\u0209\u020a\u0001\u0000\u0000\u0000\u020a\u020b\u0001\u0000"+
		"\u0000\u0000\u020b\u022f\u0005l\u0000\u0000\u020c\u020d\n\u0005\u0000"+
		"\u0000\u020d\u020e\u0005k\u0000\u0000\u020e\u0210\u0005\u001a\u0000\u0000"+
		"\u020f\u0211\u0003T*\u0000\u0210\u020f\u0001\u0000\u0000\u0000\u0210\u0211"+
		"\u0001\u0000\u0000\u0000\u0211\u0212\u0001\u0000\u0000\u0000\u0212\u0213"+
		"\u0003$\u0012\u0000\u0213\u0214\u0005l\u0000\u0000\u0214\u022f\u0001\u0000"+
		"\u0000\u0000\u0215\u0216\n\u0004\u0000\u0000\u0216\u0217\u0005k\u0000"+
		"\u0000\u0217\u0218\u0003T*\u0000\u0218\u0219\u0005\u001a\u0000\u0000\u0219"+
		"\u021a\u0003$\u0012\u0000\u021a\u021b\u0005l\u0000\u0000\u021b\u022f\u0001"+
		"\u0000\u0000\u0000\u021c\u021d\n\u0003\u0000\u0000\u021d\u021f\u0005k"+
		"\u0000\u0000\u021e\u0220\u0003T*\u0000\u021f\u021e\u0001\u0000\u0000\u0000"+
		"\u021f\u0220\u0001\u0000\u0000\u0000\u0220\u0221\u0001\u0000\u0000\u0000"+
		"\u0221\u0222\u0005[\u0000\u0000\u0222\u022f\u0005l\u0000\u0000\u0223\u0224"+
		"\n\u0002\u0000\u0000\u0224\u0225\u0005m\u0000\u0000\u0225\u0226\u0003"+
		"V+\u0000\u0226\u0227\u0005n\u0000\u0000\u0227\u022f\u0001\u0000\u0000"+
		"\u0000\u0228\u0229\n\u0001\u0000\u0000\u0229\u022b\u0005m\u0000\u0000"+
		"\u022a\u022c\u0003\\.\u0000\u022b\u022a\u0001\u0000\u0000\u0000\u022b"+
		"\u022c\u0001\u0000\u0000\u0000\u022c\u022d\u0001\u0000\u0000\u0000\u022d"+
		"\u022f\u0005n\u0000\u0000\u022e\u0203\u0001\u0000\u0000\u0000\u022e\u020c"+
		"\u0001\u0000\u0000\u0000\u022e\u0215\u0001\u0000\u0000\u0000\u022e\u021c"+
		"\u0001\u0000\u0000\u0000\u022e\u0223\u0001\u0000\u0000\u0000\u022e\u0228"+
		"\u0001\u0000\u0000\u0000\u022f\u0232\u0001\u0000\u0000\u0000\u0230\u022e"+
		"\u0001\u0000\u0000\u0000\u0230\u0231\u0001\u0000\u0000\u0000\u0231Q\u0001"+
		"\u0000\u0000\u0000\u0232\u0230\u0001\u0000\u0000\u0000\u0233\u0235\u0005"+
		"[\u0000\u0000\u0234\u0236\u0003T*\u0000\u0235\u0234\u0001\u0000\u0000"+
		"\u0000\u0235\u0236\u0001\u0000\u0000\u0000\u0236\u0238\u0001\u0000\u0000"+
		"\u0000\u0237\u0233\u0001\u0000\u0000\u0000\u0238\u0239\u0001\u0000\u0000"+
		"\u0000\u0239\u0237\u0001\u0000\u0000\u0000\u0239\u023a\u0001\u0000\u0000"+
		"\u0000\u023aS\u0001\u0000\u0000\u0000\u023b\u023d\u0003L&\u0000\u023c"+
		"\u023b\u0001\u0000\u0000\u0000\u023d\u023e\u0001\u0000\u0000\u0000\u023e"+
		"\u023c\u0001\u0000\u0000\u0000\u023e\u023f\u0001\u0000\u0000\u0000\u023f"+
		"U\u0001\u0000\u0000\u0000\u0240\u0243\u0003X,\u0000\u0241\u0242\u0005"+
		"i\u0000\u0000\u0242\u0244\u0005:\u0000\u0000\u0243\u0241\u0001\u0000\u0000"+
		"\u0000\u0243\u0244\u0001\u0000\u0000\u0000\u0244W\u0001\u0000\u0000\u0000"+
		"\u0245\u024a\u0003Z-\u0000\u0246\u0247\u0005i\u0000\u0000\u0247\u0249"+
		"\u0003Z-\u0000\u0248\u0246\u0001\u0000\u0000\u0000\u0249\u024c\u0001\u0000"+
		"\u0000\u0000\u024a\u0248\u0001\u0000\u0000\u0000\u024a\u024b\u0001\u0000"+
		"\u0000\u0000\u024bY\u0001\u0000\u0000\u0000\u024c\u024a\u0001\u0000\u0000"+
		"\u0000\u024d\u0252\u0003.\u0017\u0000\u024e\u0253\u0003N\'\u0000\u024f"+
		"\u0251\u0003`0\u0000\u0250\u024f\u0001\u0000\u0000\u0000\u0250\u0251\u0001"+
		"\u0000\u0000\u0000\u0251\u0253\u0001\u0000\u0000\u0000\u0252\u024e\u0001"+
		"\u0000\u0000\u0000\u0252\u0250\u0001\u0000\u0000\u0000\u0253[\u0001\u0000"+
		"\u0000\u0000\u0254\u0259\u0003\u0002\u0001\u0000\u0255\u0256\u0005i\u0000"+
		"\u0000\u0256\u0258\u0003\u0002\u0001\u0000\u0257\u0255\u0001\u0000\u0000"+
		"\u0000\u0258\u025b\u0001\u0000\u0000\u0000\u0259\u0257\u0001\u0000\u0000"+
		"\u0000\u0259\u025a\u0001\u0000\u0000\u0000\u025a]\u0001\u0000\u0000\u0000"+
		"\u025b\u0259\u0001\u0000\u0000\u0000\u025c\u025e\u0003@ \u0000\u025d\u025f"+
		"\u0003`0\u0000\u025e\u025d\u0001\u0000\u0000\u0000\u025e\u025f\u0001\u0000"+
		"\u0000\u0000\u025f_\u0001\u0000\u0000\u0000\u0260\u0266\u0003R)\u0000"+
		"\u0261\u0263\u0003R)\u0000\u0262\u0261\u0001\u0000\u0000\u0000\u0262\u0263"+
		"\u0001\u0000\u0000\u0000\u0263\u0264\u0001\u0000\u0000\u0000\u0264\u0266"+
		"\u0003b1\u0000\u0265\u0260\u0001\u0000\u0000\u0000\u0265\u0262\u0001\u0000"+
		"\u0000\u0000\u0266a\u0001\u0000\u0000\u0000\u0267\u0268\u00061\uffff\uffff"+
		"\u0000\u0268\u0269\u0005m\u0000\u0000\u0269\u026a\u0003`0\u0000\u026a"+
		"\u026b\u0005n\u0000\u0000\u026b\u0292\u0001\u0000\u0000\u0000\u026c\u026e"+
		"\u0005k\u0000\u0000\u026d\u026f\u0003T*\u0000\u026e\u026d\u0001\u0000"+
		"\u0000\u0000\u026e\u026f\u0001\u0000\u0000\u0000\u026f\u0271\u0001\u0000"+
		"\u0000\u0000\u0270\u0272\u0003$\u0012\u0000\u0271\u0270\u0001\u0000\u0000"+
		"\u0000\u0271\u0272\u0001\u0000\u0000\u0000\u0272\u0273\u0001\u0000\u0000"+
		"\u0000\u0273\u0292\u0005l\u0000\u0000\u0274\u0275\u0005k\u0000\u0000\u0275"+
		"\u0277\u0005\u001a\u0000\u0000\u0276\u0278\u0003T*\u0000\u0277\u0276\u0001"+
		"\u0000\u0000\u0000\u0277\u0278\u0001\u0000\u0000\u0000\u0278\u0279\u0001"+
		"\u0000\u0000\u0000\u0279\u027a\u0003$\u0012\u0000\u027a\u027b\u0005l\u0000"+
		"\u0000\u027b\u0292\u0001\u0000\u0000\u0000\u027c\u027d\u0005k\u0000\u0000"+
		"\u027d\u027e\u0003T*\u0000\u027e\u027f\u0005\u001a\u0000\u0000\u027f\u0280"+
		"\u0003$\u0012\u0000\u0280\u0281\u0005l\u0000\u0000\u0281\u0292\u0001\u0000"+
		"\u0000\u0000\u0282\u0284\u0005k\u0000\u0000\u0283\u0285\u0003T*\u0000"+
		"\u0284\u0283\u0001\u0000\u0000\u0000\u0284\u0285\u0001\u0000\u0000\u0000"+
		"\u0285\u0286\u0001\u0000\u0000\u0000\u0286\u0287\u0005[\u0000\u0000\u0287"+
		"\u0292\u0005l\u0000\u0000\u0288\u0289\u0005m\u0000\u0000\u0289\u028a\u0003"+
		"V+\u0000\u028a\u028b\u0005n\u0000\u0000\u028b\u0292\u0001\u0000\u0000"+
		"\u0000\u028c\u028e\u0005m\u0000\u0000\u028d\u028f\u0003\\.\u0000\u028e"+
		"\u028d\u0001\u0000\u0000\u0000\u028e\u028f\u0001\u0000\u0000\u0000\u028f"+
		"\u0290\u0001\u0000\u0000\u0000\u0290\u0292\u0005n\u0000\u0000\u0291\u0267"+
		"\u0001\u0000\u0000\u0000\u0291\u026c\u0001\u0000\u0000\u0000\u0291\u0274"+
		"\u0001\u0000\u0000\u0000\u0291\u027c\u0001\u0000\u0000\u0000\u0291\u0282"+
		"\u0001\u0000\u0000\u0000\u0291\u0288\u0001\u0000\u0000\u0000\u0291\u028c"+
		"\u0001\u0000\u0000\u0000\u0292\u02c0\u0001\u0000\u0000\u0000\u0293\u0294"+
		"\n\f\u0000\u0000\u0294\u0296\u0005k\u0000\u0000\u0295\u0297\u0003T*\u0000"+
		"\u0296\u0295\u0001\u0000\u0000\u0000\u0296\u0297\u0001\u0000\u0000\u0000"+
		"\u0297\u0299\u0001\u0000\u0000\u0000\u0298\u029a\u0003$\u0012\u0000\u0299"+
		"\u0298\u0001\u0000\u0000\u0000\u0299\u029a\u0001\u0000\u0000\u0000\u029a"+
		"\u029b\u0001\u0000\u0000\u0000\u029b\u02bf\u0005l\u0000\u0000\u029c\u029d"+
		"\n\n\u0000\u0000\u029d\u029e\u0005k\u0000\u0000\u029e\u02a0\u0005\u001a"+
		"\u0000\u0000\u029f\u02a1\u0003T*\u0000\u02a0\u029f\u0001\u0000\u0000\u0000"+
		"\u02a0\u02a1\u0001\u0000\u0000\u0000\u02a1\u02a2\u0001\u0000\u0000\u0000"+
		"\u02a2\u02a3\u0003$\u0012\u0000\u02a3\u02a4\u0005l\u0000\u0000\u02a4\u02bf"+
		"\u0001\u0000\u0000\u0000\u02a5\u02a6\n\b\u0000\u0000\u02a6\u02a7\u0005"+
		"k\u0000\u0000\u02a7\u02a8\u0003T*\u0000\u02a8\u02a9\u0005\u001a\u0000"+
		"\u0000\u02a9\u02aa\u0003$\u0012\u0000\u02aa\u02ab\u0005l\u0000\u0000\u02ab"+
		"\u02bf\u0001\u0000\u0000\u0000\u02ac\u02ad\n\u0006\u0000\u0000\u02ad\u02af"+
		"\u0005k\u0000\u0000\u02ae\u02b0\u0003T*\u0000\u02af\u02ae\u0001\u0000"+
		"\u0000\u0000\u02af\u02b0\u0001\u0000\u0000\u0000\u02b0\u02b1\u0001\u0000"+
		"\u0000\u0000\u02b1\u02b2\u0005[\u0000\u0000\u02b2\u02bf\u0005l\u0000\u0000"+
		"\u02b3\u02b4\n\u0004\u0000\u0000\u02b4\u02b5\u0005m\u0000\u0000\u02b5"+
		"\u02b6\u0003V+\u0000\u02b6\u02b7\u0005n\u0000\u0000\u02b7\u02bf\u0001"+
		"\u0000\u0000\u0000\u02b8\u02b9\n\u0002\u0000\u0000\u02b9\u02bb\u0005m"+
		"\u0000\u0000\u02ba\u02bc\u0003\\.\u0000\u02bb\u02ba\u0001\u0000\u0000"+
		"\u0000\u02bb\u02bc\u0001\u0000\u0000\u0000\u02bc\u02bd\u0001\u0000\u0000"+
		"\u0000\u02bd\u02bf\u0005n\u0000\u0000\u02be\u0293\u0001\u0000\u0000\u0000"+
		"\u02be\u029c\u0001\u0000\u0000\u0000\u02be\u02a5\u0001\u0000\u0000\u0000"+
		"\u02be\u02ac\u0001\u0000\u0000\u0000\u02be\u02b3\u0001\u0000\u0000\u0000"+
		"\u02be\u02b8\u0001\u0000\u0000\u0000\u02bf\u02c2\u0001\u0000\u0000\u0000"+
		"\u02c0\u02be\u0001\u0000\u0000\u0000\u02c0\u02c1\u0001\u0000\u0000\u0000"+
		"\u02c1c\u0001\u0000\u0000\u0000\u02c2\u02c0\u0001\u0000\u0000\u0000\u02c3"+
		"\u02c4\u00042\u001d\u0000\u02c4\u02c5\u0005t\u0000\u0000\u02c5e\u0001"+
		"\u0000\u0000\u0000\u02c6\u02cf\u0003$\u0012\u0000\u02c7\u02c8\u0005o\u0000"+
		"\u0000\u02c8\u02ca\u0003h4\u0000\u02c9\u02cb\u0005i\u0000\u0000\u02ca"+
		"\u02c9\u0001\u0000\u0000\u0000\u02ca\u02cb\u0001\u0000\u0000\u0000\u02cb"+
		"\u02cc\u0001\u0000\u0000\u0000\u02cc\u02cd\u0005p\u0000\u0000\u02cd\u02cf"+
		"\u0001\u0000\u0000\u0000\u02ce\u02c6\u0001\u0000\u0000\u0000\u02ce\u02c7"+
		"\u0001\u0000\u0000\u0000\u02cfg\u0001\u0000\u0000\u0000\u02d0\u02d2\u0003"+
		"j5\u0000\u02d1\u02d0\u0001\u0000\u0000\u0000\u02d1\u02d2\u0001\u0000\u0000"+
		"\u0000\u02d2\u02d3\u0001\u0000\u0000\u0000\u02d3\u02db\u0003f3\u0000\u02d4"+
		"\u02d6\u0005i\u0000\u0000\u02d5\u02d7\u0003j5\u0000\u02d6\u02d5\u0001"+
		"\u0000\u0000\u0000\u02d6\u02d7\u0001\u0000\u0000\u0000\u02d7\u02d8\u0001"+
		"\u0000\u0000\u0000\u02d8\u02da\u0003f3\u0000\u02d9\u02d4\u0001\u0000\u0000"+
		"\u0000\u02da\u02dd\u0001\u0000\u0000\u0000\u02db\u02d9\u0001\u0000\u0000"+
		"\u0000\u02db\u02dc\u0001\u0000\u0000\u0000\u02dci\u0001\u0000\u0000\u0000"+
		"\u02dd\u02db\u0001\u0000\u0000\u0000\u02de\u02df\u0003l6\u0000\u02df\u02e0"+
		"\u0005h\u0000\u0000\u02e0k\u0001\u0000\u0000\u0000\u02e1\u02e3\u0003n"+
		"7\u0000\u02e2\u02e1\u0001\u0000\u0000\u0000\u02e3\u02e4\u0001\u0000\u0000"+
		"\u0000\u02e4\u02e2\u0001\u0000\u0000\u0000\u02e4\u02e5\u0001\u0000\u0000"+
		"\u0000\u02e5m\u0001\u0000\u0000\u0000\u02e6\u02e7\u0005k\u0000\u0000\u02e7"+
		"\u02e8\u0003(\u0014\u0000\u02e8\u02e9\u0005l\u0000\u0000\u02e9\u02ed\u0001"+
		"\u0000\u0000\u0000\u02ea\u02eb\u0005f\u0000\u0000\u02eb\u02ed\u0003\u0002"+
		"\u0001\u0000\u02ec\u02e6\u0001\u0000\u0000\u0000\u02ec\u02ea\u0001\u0000"+
		"\u0000\u0000\u02edo\u0001\u0000\u0000\u0000\u02ee\u02f6\u0003\u0082A\u0000"+
		"\u02ef\u02f6\u0003r9\u0000\u02f0\u02f6\u0003t:\u0000\u02f1\u02f6\u0003"+
		"z=\u0000\u02f2\u02f6\u0003|>\u0000\u02f3\u02f6\u0003~?\u0000\u02f4\u02f6"+
		"\u0003\u0080@\u0000\u02f5\u02ee\u0001\u0000\u0000\u0000\u02f5\u02ef\u0001"+
		"\u0000\u0000\u0000\u02f5\u02f0\u0001\u0000\u0000\u0000\u02f5\u02f1\u0001"+
		"\u0000\u0000\u0000\u02f5\u02f2\u0001\u0000\u0000\u0000\u02f5\u02f3\u0001"+
		"\u0000\u0000\u0000\u02f5\u02f4\u0001\u0000\u0000\u0000\u02f6q\u0001\u0000"+
		"\u0000\u0000\u02f7\u02f8\u0003\u0002\u0001\u0000\u02f8\u02f9\u0005d\u0000"+
		"\u0000\u02f9\u02fa\u0003p8\u0000\u02fa\u0304\u0001\u0000\u0000\u0000\u02fb"+
		"\u02fc\u0005\u0003\u0000\u0000\u02fc\u02fd\u0003(\u0014\u0000\u02fd\u02fe"+
		"\u0005d\u0000\u0000\u02fe\u02ff\u0003p8\u0000\u02ff\u0304\u0001\u0000"+
		"\u0000\u0000\u0300\u0301\u0005\u0007\u0000\u0000\u0301\u0302\u0005d\u0000"+
		"\u0000\u0302\u0304\u0003p8\u0000\u0303\u02f7\u0001\u0000\u0000\u0000\u0303"+
		"\u02fb\u0001\u0000\u0000\u0000\u0303\u0300\u0001\u0000\u0000\u0000\u0304"+
		"s\u0001\u0000\u0000\u0000\u0305\u0307\u0005o\u0000\u0000\u0306\u0308\u0003"+
		"v;\u0000\u0307\u0306\u0001\u0000\u0000\u0000\u0307\u0308\u0001\u0000\u0000"+
		"\u0000\u0308\u0309\u0001\u0000\u0000\u0000\u0309\u030a\u0005p\u0000\u0000"+
		"\u030au\u0001\u0000\u0000\u0000\u030b\u030d\u0003x<\u0000\u030c\u030b"+
		"\u0001\u0000\u0000\u0000\u030d\u030e\u0001\u0000\u0000\u0000\u030e\u030c"+
		"\u0001\u0000\u0000\u0000\u030e\u030f\u0001\u0000\u0000\u0000\u030fw\u0001"+
		"\u0000\u0000\u0000\u0310\u0313\u0003,\u0016\u0000\u0311\u0313\u0003p8"+
		"\u0000\u0312\u0310\u0001\u0000\u0000\u0000\u0312\u0311\u0001\u0000\u0000"+
		"\u0000\u0313y\u0001\u0000\u0000\u0000\u0314\u0316\u0003&\u0013\u0000\u0315"+
		"\u0314\u0001\u0000\u0000\u0000\u0315\u0316\u0001\u0000\u0000\u0000\u0316"+
		"\u0317\u0001\u0000\u0000\u0000\u0317\u0318\u0005e\u0000\u0000\u0318{\u0001"+
		"\u0000\u0000\u0000\u0319\u031a\u0005\u0010\u0000\u0000\u031a\u031b\u0005"+
		"m\u0000\u0000\u031b\u031c\u0003&\u0013\u0000\u031c\u031d\u0005n\u0000"+
		"\u0000\u031d\u031e\u0003p8\u0000\u031e\u032e\u0001\u0000\u0000\u0000\u031f"+
		"\u0320\u0005\u0010\u0000\u0000\u0320\u0321\u0005m\u0000\u0000\u0321\u0322"+
		"\u0003&\u0013\u0000\u0322\u0323\u0005n\u0000\u0000\u0323\u0324\u0003p"+
		"8\u0000\u0324\u0325\u0005\n\u0000\u0000\u0325\u0326\u0003p8\u0000\u0326"+
		"\u032e\u0001\u0000\u0000\u0000\u0327\u0328\u0005\u001c\u0000\u0000\u0328"+
		"\u0329\u0005m\u0000\u0000\u0329\u032a\u0003&\u0013\u0000\u032a\u032b\u0005"+
		"n\u0000\u0000\u032b\u032c\u0003p8\u0000\u032c\u032e\u0001\u0000\u0000"+
		"\u0000\u032d\u0319\u0001\u0000\u0000\u0000\u032d\u031f\u0001\u0000\u0000"+
		"\u0000\u032d\u0327\u0001\u0000\u0000\u0000\u032e}\u0001\u0000\u0000\u0000"+
		"\u032f\u0330\u0005\"\u0000\u0000\u0330\u0331\u0005m\u0000\u0000\u0331"+
		"\u0332\u0003&\u0013\u0000\u0332\u0333\u0005n\u0000\u0000\u0333\u0334\u0003"+
		"p8\u0000\u0334\u035a\u0001\u0000\u0000\u0000\u0335\u0336\u0005\b\u0000"+
		"\u0000\u0336\u0337\u0003p8\u0000\u0337\u0338\u0005\"\u0000\u0000\u0338"+
		"\u0339\u0005m\u0000\u0000\u0339\u033a\u0003&\u0013\u0000\u033a\u033b\u0005"+
		"n\u0000\u0000\u033b\u033c\u0005e\u0000\u0000\u033c\u035a\u0001\u0000\u0000"+
		"\u0000\u033d\u033e\u0005\u000e\u0000\u0000\u033e\u0340\u0005m\u0000\u0000"+
		"\u033f\u0341\u0003&\u0013\u0000\u0340\u033f\u0001\u0000\u0000\u0000\u0340"+
		"\u0341\u0001\u0000\u0000\u0000\u0341\u0342\u0001\u0000\u0000\u0000\u0342"+
		"\u0344\u0005e\u0000\u0000\u0343\u0345\u0003&\u0013\u0000\u0344\u0343\u0001"+
		"\u0000\u0000\u0000\u0344\u0345\u0001\u0000\u0000\u0000\u0345\u0346\u0001"+
		"\u0000\u0000\u0000\u0346\u0348\u0005e\u0000\u0000\u0347\u0349\u0003&\u0013"+
		"\u0000\u0348\u0347\u0001\u0000\u0000\u0000\u0348\u0349\u0001\u0000\u0000"+
		"\u0000\u0349\u034a\u0001\u0000\u0000\u0000\u034a\u034b\u0005n\u0000\u0000"+
		"\u034b\u035a\u0003p8\u0000\u034c\u034d\u0005\u000e\u0000\u0000\u034d\u034e"+
		"\u0005m\u0000\u0000\u034e\u0350\u0003,\u0016\u0000\u034f\u0351\u0003&"+
		"\u0013\u0000\u0350\u034f\u0001\u0000\u0000\u0000\u0350\u0351\u0001\u0000"+
		"\u0000\u0000\u0351\u0352\u0001\u0000\u0000\u0000\u0352\u0354\u0005e\u0000"+
		"\u0000\u0353\u0355\u0003&\u0013\u0000\u0354\u0353\u0001\u0000\u0000\u0000"+
		"\u0354\u0355\u0001\u0000\u0000\u0000\u0355\u0356\u0001\u0000\u0000\u0000"+
		"\u0356\u0357\u0005n\u0000\u0000\u0357\u0358\u0003p8\u0000\u0358\u035a"+
		"\u0001\u0000\u0000\u0000\u0359\u032f\u0001\u0000\u0000\u0000\u0359\u0335"+
		"\u0001\u0000\u0000\u0000\u0359\u033d\u0001\u0000\u0000\u0000\u0359\u034c"+
		"\u0001\u0000\u0000\u0000\u035a\u007f\u0001\u0000\u0000\u0000\u035b\u035c"+
		"\u0005\u000f\u0000\u0000\u035c\u035d\u0003\u0002\u0001\u0000\u035d\u035e"+
		"\u0005e\u0000\u0000\u035e\u0369\u0001\u0000\u0000\u0000\u035f\u0360\u0005"+
		"\u0006\u0000\u0000\u0360\u0369\u0005e\u0000\u0000\u0361\u0362\u0005\u0002"+
		"\u0000\u0000\u0362\u0369\u0005e\u0000\u0000\u0363\u0365\u0005\u0016\u0000"+
		"\u0000\u0364\u0366\u0003&\u0013\u0000\u0365\u0364\u0001\u0000\u0000\u0000"+
		"\u0365\u0366\u0001\u0000\u0000\u0000\u0366\u0367\u0001\u0000\u0000\u0000"+
		"\u0367\u0369\u0005e\u0000\u0000\u0368\u035b\u0001\u0000\u0000\u0000\u0368"+
		"\u035f\u0001\u0000\u0000\u0000\u0368\u0361\u0001\u0000\u0000\u0000\u0368"+
		"\u0363\u0001\u0000\u0000\u0000\u0369\u0081\u0001\u0000\u0000\u0000\u036a"+
		"\u036b\u0005&\u0000\u0000\u036b\u036c\u0005m\u0000\u0000\u036c\u036d\u0005"+
		"w\u0000\u0000\u036d\u036e\u0005n\u0000\u0000\u036e\u036f\u0005e\u0000"+
		"\u0000\u036f\u0083\u0001\u0000\u0000\u0000\u0370\u0372\u0003\u0086C\u0000"+
		"\u0371\u0370\u0001\u0000\u0000\u0000\u0372\u0373\u0001\u0000\u0000\u0000"+
		"\u0373\u0371\u0001\u0000\u0000\u0000\u0373\u0374\u0001\u0000\u0000\u0000"+
		"\u0374\u0085\u0001\u0000\u0000\u0000\u0375\u0378\u0003\u0088D\u0000\u0376"+
		"\u0378\u0003,\u0016\u0000\u0377\u0375\u0001\u0000\u0000\u0000\u0377\u0376"+
		"\u0001\u0000\u0000\u0000\u0378\u0087\u0001\u0000\u0000\u0000\u0379\u037b"+
		"\u0003*\u0015\u0000\u037a\u0379\u0001\u0000\u0000\u0000\u037b\u037e\u0001"+
		"\u0000\u0000\u0000\u037c\u037a\u0001\u0000\u0000\u0000\u037c\u037d\u0001"+
		"\u0000\u0000\u0000\u037d\u037f\u0001\u0000\u0000\u0000\u037e\u037c\u0001"+
		"\u0000\u0000\u0000\u037f\u0380\u0003.\u0017\u0000\u0380\u0382\u0003N\'"+
		"\u0000\u0381\u0383\u0003\u008aE\u0000\u0382\u0381\u0001\u0000\u0000\u0000"+
		"\u0382\u0383\u0001\u0000\u0000\u0000\u0383\u0384\u0001\u0000\u0000\u0000"+
		"\u0384\u0385\u0003t:\u0000\u0385\u0089\u0001\u0000\u0000\u0000\u0386\u0388"+
		"\u0003,\u0016\u0000\u0387\u0386\u0001\u0000\u0000\u0000\u0388\u0389\u0001"+
		"\u0000\u0000\u0000\u0389\u0387\u0001\u0000\u0000\u0000\u0389\u038a\u0001"+
		"\u0000\u0000\u0000\u038a\u008b\u0001\u0000\u0000\u0000f\u0098\u00a2\u00a6"+
		"\u00b0\u00bd\u00bf\u00c7\u00ea\u00f2\u00fc\u0107\u0112\u011d\u0128\u0133"+
		"\u013e\u0149\u0154\u015f\u0169\u0170\u0177\u0183\u0188\u0191\u0193\u019e"+
		"\u01a4\u01aa\u01ae\u01b6\u01bb\u01c3\u01c6\u01cd\u01d2\u01d6\u01da\u01df"+
		"\u01e5\u01ec\u01f2\u01f7\u0201\u0206\u0209\u0210\u021f\u022b\u022e\u0230"+
		"\u0235\u0239\u023e\u0243\u024a\u0250\u0252\u0259\u025e\u0262\u0265\u026e"+
		"\u0271\u0277\u0284\u028e\u0291\u0296\u0299\u02a0\u02af\u02bb\u02be\u02c0"+
		"\u02ca\u02ce\u02d1\u02d6\u02db\u02e4\u02ec\u02f5\u0303\u0307\u030e\u0312"+
		"\u0315\u032d\u0340\u0344\u0348\u0350\u0354\u0359\u0365\u0368\u0373\u0377"+
		"\u037c\u0382\u0389";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}