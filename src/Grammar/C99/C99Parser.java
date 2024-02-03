// Generated from I:/Coding Projects/BBSnCC/src/Grammar/C99.g4 by ANTLR 4.13.1
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
		SRAM=52, Offsetof=53, TwoMCo=54, ThreeP=55, Arrow=56, Incrmn=57, Decrmn=58, 
		LssLss=59, GrtGrt=60, LessTh=61, GretTh=62, LessEq=63, GretEq=64, Equal=65, 
		NotEql=66, AmpAmp=67, OrOr=68, MulAsg=69, DivAsg=70, ModAsg=71, PluAsg=72, 
		SubAsg=73, LShAsg=74, RShAsg=75, AndAsg=76, XorAsg=77, OrAsg=78, TwoHsh=79, 
		LessCo=80, GretCo=81, LessMd=82, GretMd=83, ModCol=84, TwoLSB=85, TwoRSB=86, 
		Amper=87, Star=88, Plus=89, Minus=90, Tilde=91, Excla=92, BckSla=93, Percnt=94, 
		Xor=95, Or=96, Colon=97, Semico=98, Period=99, Questi=100, Assign=101, 
		Comma=102, HashTg=103, LeSqBr=104, RiSqBr=105, LeRoBr=106, RiRoBr=107, 
		LeCuBr=108, RiCuBr=109, WS=110, NLS=111, NL=112, Identifier=113, Constant=114, 
		Character_constant=115, String_literal=116, Header_name=117;
	public static final int
		RULE_dummy = 0, RULE_primary_expression = 1, RULE_postfix_expression = 2, 
		RULE_argument_expression_list = 3, RULE_unary_expression = 4, RULE_cast_expression = 5, 
		RULE_multiplicative_expression = 6, RULE_additive_expression = 7, RULE_shift_expression = 8, 
		RULE_relational_expression = 9, RULE_equality_expression = 10, RULE_and_expression = 11, 
		RULE_xor_expression = 12, RULE_or_expression = 13, RULE_land_expression = 14, 
		RULE_lor_expression = 15, RULE_conditional_expression = 16, RULE_assignment_expression = 17, 
		RULE_expression = 18, RULE_constant_expression = 19, RULE_declaration = 20, 
		RULE_declaration_specifiers = 21, RULE_storage_class_specifier = 22, RULE_function_specifier = 23, 
		RULE_init_declarator_list = 24, RULE_init_declarator = 25, RULE_type_specifier = 26, 
		RULE_struct_or_union_specifier = 27, RULE_struct_declaration_list = 28, 
		RULE_struct_declaration = 29, RULE_specifier_qualifier_list = 30, RULE_struct_declarator_list = 31, 
		RULE_struct_declarator = 32, RULE_enum_specifier = 33, RULE_enumerator_list = 34, 
		RULE_enumerator = 35, RULE_type_qualifier = 36, RULE_declarator = 37, 
		RULE_direct_declarator = 38, RULE_pointer = 39, RULE_type_qualifier_list = 40, 
		RULE_parameter_type_list = 41, RULE_parameter_list = 42, RULE_parameter_declaration = 43, 
		RULE_identifier_list = 44, RULE_type_name = 45, RULE_abstract_declarator = 46, 
		RULE_direct_abstract_declarator = 47, RULE_typedef_name = 48, RULE_initializer = 49, 
		RULE_initializer_list = 50, RULE_designation = 51, RULE_designator_list = 52, 
		RULE_designator = 53, RULE_attributes_declaration = 54, RULE_statement = 55, 
		RULE_labeled_statement = 56, RULE_compound_statement = 57, RULE_block_item_list = 58, 
		RULE_block_item = 59, RULE_expression_statement = 60, RULE_selection_statement = 61, 
		RULE_iteration_statement = 62, RULE_jump_statement = 63, RULE_asm_statement = 64, 
		RULE_translation_unit = 65, RULE_external_declaration = 66, RULE_function_definition = 67, 
		RULE_declaration_list = 68;
	private static String[] makeRuleNames() {
		return new String[] {
			"dummy", "primary_expression", "postfix_expression", "argument_expression_list", 
			"unary_expression", "cast_expression", "multiplicative_expression", "additive_expression", 
			"shift_expression", "relational_expression", "equality_expression", "and_expression", 
			"xor_expression", "or_expression", "land_expression", "lor_expression", 
			"conditional_expression", "assignment_expression", "expression", "constant_expression", 
			"declaration", "declaration_specifiers", "storage_class_specifier", "function_specifier", 
			"init_declarator_list", "init_declarator", "type_specifier", "struct_or_union_specifier", 
			"struct_declaration_list", "struct_declaration", "specifier_qualifier_list", 
			"struct_declarator_list", "struct_declarator", "enum_specifier", "enumerator_list", 
			"enumerator", "type_qualifier", "declarator", "direct_declarator", "pointer", 
			"type_qualifier_list", "parameter_type_list", "parameter_list", "parameter_declaration", 
			"identifier_list", "type_name", "abstract_declarator", "direct_abstract_declarator", 
			"typedef_name", "initializer", "initializer_list", "designation", "designator_list", 
			"designator", "attributes_declaration", "statement", "labeled_statement", 
			"compound_statement", "block_item_list", "block_item", "expression_statement", 
			"selection_statement", "iteration_statement", "jump_statement", "asm_statement", 
			"translation_unit", "external_declaration", "function_definition", "declaration_list"
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
			"'embed'", "'__SRAM'", "'__offset_of'", "'%:%:'", "'...'", "'->'", "'++'", 
			"'--'", "'<<'", "'>>'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", 
			"'&&'", "'||'", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", 
			"'&='", "'^='", "'|='", "'##'", "'<:'", "':>'", "'<%'", "'%>'", "'%:'", 
			"'[['", "']]'", "'&'", "'*'", "'+'", "'-'", "'~'", "'!'", "'/'", "'%'", 
			"'^'", "'|'", "':'", "';'", "'.'", "'?'", "'='", "','", "'#'", "'['", 
			"']'", "'('", "')'", "'{'", "'}'", null, null, "'\\n'"
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
			"Error", "Pragma", "HasEmbed", "Embed", "SRAM", "Offsetof", "TwoMCo", 
			"ThreeP", "Arrow", "Incrmn", "Decrmn", "LssLss", "GrtGrt", "LessTh", 
			"GretTh", "LessEq", "GretEq", "Equal", "NotEql", "AmpAmp", "OrOr", "MulAsg", 
			"DivAsg", "ModAsg", "PluAsg", "SubAsg", "LShAsg", "RShAsg", "AndAsg", 
			"XorAsg", "OrAsg", "TwoHsh", "LessCo", "GretCo", "LessMd", "GretMd", 
			"ModCol", "TwoLSB", "TwoRSB", "Amper", "Star", "Plus", "Minus", "Tilde", 
			"Excla", "BckSla", "Percnt", "Xor", "Or", "Colon", "Semico", "Period", 
			"Questi", "Assign", "Comma", "HashTg", "LeSqBr", "RiSqBr", "LeRoBr", 
			"RiRoBr", "LeCuBr", "RiCuBr", "WS", "NLS", "NL", "Identifier", "Constant", 
			"Character_constant", "String_literal", "Header_name"
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
			setState(138);
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
	public static class Primary_expressionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(C99Parser.Identifier, 0); }
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
		enterRule(_localctx, 2, RULE_primary_expression);
		try {
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				match(Identifier);
				}
				break;
			case Constant:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				match(Constant);
				}
				break;
			case String_literal:
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				match(String_literal);
				}
				break;
			case LeRoBr:
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				match(LeRoBr);
				setState(144);
				expression();
				setState(145);
				match(RiRoBr);
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
		public TerminalNode Identifier() { return getToken(C99Parser.Identifier, 0); }
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_postfix_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(150);
				primary_expression();
				}
				break;
			case 2:
				{
				setState(151);
				match(LeRoBr);
				setState(152);
				type_name();
				setState(153);
				match(RiRoBr);
				setState(154);
				match(LeCuBr);
				setState(155);
				initializer_list();
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(156);
					match(Comma);
					}
				}

				setState(159);
				match(RiCuBr);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(184);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(163);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(164);
						match(LeSqBr);
						setState(165);
						expression();
						setState(166);
						match(RiSqBr);
						}
						break;
					case 2:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(168);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(169);
						match(LeRoBr);
						setState(171);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 442479213178519552L) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & 738721855L) != 0)) {
							{
							setState(170);
							argument_expression_list();
							}
						}

						setState(173);
						match(RiRoBr);
						}
						break;
					case 3:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(174);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(175);
						match(Period);
						setState(176);
						match(Identifier);
						}
						break;
					case 4:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(177);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(178);
						match(Arrow);
						setState(179);
						match(Identifier);
						}
						break;
					case 5:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(180);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(181);
						match(Incrmn);
						}
						break;
					case 6:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(182);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(183);
						match(Decrmn);
						}
						break;
					}
					} 
				}
				setState(188);
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
		enterRule(_localctx, 6, RULE_argument_expression_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			assignment_expression();
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(190);
				match(Comma);
				setState(191);
				assignment_expression();
				}
				}
				setState(196);
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
		public TerminalNode Identifier() { return getToken(C99Parser.Identifier, 0); }
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
		enterRule(_localctx, 8, RULE_unary_expression);
		int _la;
		try {
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				postfix_expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				match(Incrmn);
				setState(199);
				unary_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(200);
				match(Decrmn);
				setState(201);
				unary_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(202);
				_la = _input.LA(1);
				if ( !(((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & 63L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(203);
				cast_expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(204);
				match(Sizeof);
				setState(205);
				unary_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(206);
				match(Sizeof);
				setState(207);
				match(LeRoBr);
				setState(208);
				type_name();
				setState(209);
				match(RiRoBr);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(211);
				match(HasEmbed);
				setState(212);
				match(LeRoBr);
				setState(213);
				_la = _input.LA(1);
				if ( !(_la==String_literal || _la==Header_name) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(214);
				match(RiRoBr);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(215);
				match(Defined);
				setState(216);
				match(Identifier);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(217);
				match(Defined);
				setState(218);
				match(LeRoBr);
				setState(219);
				match(Identifier);
				setState(220);
				match(RiRoBr);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(221);
				match(Offsetof);
				setState(222);
				match(LeRoBr);
				setState(223);
				type_name();
				setState(224);
				match(Comma);
				setState(225);
				match(Identifier);
				setState(226);
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
		enterRule(_localctx, 10, RULE_cast_expression);
		try {
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				match(LeRoBr);
				setState(231);
				type_name();
				setState(232);
				match(RiRoBr);
				setState(233);
				cast_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_multiplicative_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(239);
			cast_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(246);
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
					setState(241);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(242);
					_la = _input.LA(1);
					if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & 97L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(243);
					cast_expression();
					}
					} 
				}
				setState(248);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_additive_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(250);
			multiplicative_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(257);
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
					setState(252);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(253);
					_la = _input.LA(1);
					if ( !(_la==Plus || _la==Minus) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(254);
					multiplicative_expression(0);
					}
					} 
				}
				setState(259);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_shift_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(261);
			additive_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(268);
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
					setState(263);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(264);
					_la = _input.LA(1);
					if ( !(_la==LssLss || _la==GrtGrt) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(265);
					additive_expression(0);
					}
					} 
				}
				setState(270);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_relational_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(272);
			shift_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(279);
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
					setState(274);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(275);
					_la = _input.LA(1);
					if ( !(((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & 15L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(276);
					shift_expression(0);
					}
					} 
				}
				setState(281);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_equality_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(283);
			relational_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(290);
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
					setState(285);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(286);
					_la = _input.LA(1);
					if ( !(_la==Equal || _la==NotEql) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(287);
					relational_expression(0);
					}
					} 
				}
				setState(292);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_and_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(294);
			equality_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(301);
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
					setState(296);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(297);
					match(Amper);
					setState(298);
					equality_expression(0);
					}
					} 
				}
				setState(303);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_xor_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(305);
			and_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(312);
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
					setState(307);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(308);
					match(Xor);
					setState(309);
					and_expression(0);
					}
					} 
				}
				setState(314);
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_or_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(316);
			xor_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(323);
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
					setState(318);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(319);
					match(Or);
					setState(320);
					xor_expression(0);
					}
					} 
				}
				setState(325);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_land_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(327);
			or_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(334);
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
					setState(329);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(330);
					match(AmpAmp);
					setState(331);
					or_expression(0);
					}
					} 
				}
				setState(336);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_lor_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(338);
			land_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(345);
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
					setState(340);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(341);
					match(OrOr);
					setState(342);
					land_expression(0);
					}
					} 
				}
				setState(347);
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
		enterRule(_localctx, 32, RULE_conditional_expression);
		try {
			setState(355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				lor_expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				lor_expression(0);
				setState(350);
				match(Questi);
				setState(351);
				expression();
				setState(352);
				match(Colon);
				setState(353);
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
		enterRule(_localctx, 34, RULE_assignment_expression);
		int _la;
		try {
			setState(362);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(357);
				conditional_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(358);
				unary_expression();
				setState(359);
				_la = _input.LA(1);
				if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 4294968319L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(360);
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
		enterRule(_localctx, 36, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			assignment_expression();
			setState(369);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(365);
				match(Comma);
				setState(366);
				assignment_expression();
				}
				}
				setState(371);
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
		enterRule(_localctx, 38, RULE_constant_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
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
	public static class DeclarationContext extends ParserRuleContext {
		public Declaration_specifiersContext declaration_specifiers() {
			return getRuleContext(Declaration_specifiersContext.class,0);
		}
		public TerminalNode Semico() { return getToken(C99Parser.Semico, 0); }
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
		enterRule(_localctx, 40, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			declaration_specifiers();
			setState(376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & 33816577L) != 0)) {
				{
				setState(375);
				init_declarator_list();
				}
			}

			setState(378);
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
		enterRule(_localctx, 42, RULE_declaration_specifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(384); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					setState(384);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case Auto:
					case Extern:
					case Register:
					case Static:
					case Typedef:
					case SRAM:
						{
						setState(380);
						storage_class_specifier();
						}
						break;
					case Char:
					case Double:
					case Enum:
					case Float:
					case Int:
					case Long:
					case Short:
					case Signed:
					case Struct:
					case Union:
					case Unsigned:
					case Void:
					case Bool:
					case Complex:
					case Identifier:
						{
						setState(381);
						type_specifier();
						}
						break;
					case Const:
					case Restrict:
					case Volatile:
						{
						setState(382);
						type_qualifier();
						}
						break;
					case Inline:
						{
						setState(383);
						function_specifier();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(386); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		enterRule(_localctx, 44, RULE_storage_class_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503600232402946L) != 0)) ) {
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
		enterRule(_localctx, 46, RULE_function_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
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
		enterRule(_localctx, 48, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			init_declarator();
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(393);
				match(Comma);
				setState(394);
				init_declarator();
				}
				}
				setState(399);
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
		enterRule(_localctx, 50, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			declarator();
			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(401);
				match(Assign);
				setState(402);
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
		enterRule(_localctx, 52, RULE_type_specifier);
		int _la;
		try {
			setState(409);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Char:
			case Double:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Unsigned:
			case Void:
			case Bool:
			case Complex:
				enterOuterAlt(_localctx, 1);
				{
				setState(405);
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
			case Struct:
			case Union:
				enterOuterAlt(_localctx, 2);
				{
				setState(406);
				struct_or_union_specifier();
				}
				break;
			case Enum:
				enterOuterAlt(_localctx, 3);
				{
				setState(407);
				enum_specifier();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 4);
				{
				setState(408);
				typedef_name();
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
	public static class Struct_or_union_specifierContext extends ParserRuleContext {
		public TerminalNode LeCuBr() { return getToken(C99Parser.LeCuBr, 0); }
		public Struct_declaration_listContext struct_declaration_list() {
			return getRuleContext(Struct_declaration_listContext.class,0);
		}
		public TerminalNode RiCuBr() { return getToken(C99Parser.RiCuBr, 0); }
		public TerminalNode Struct() { return getToken(C99Parser.Struct, 0); }
		public TerminalNode Union() { return getToken(C99Parser.Union, 0); }
		public TerminalNode Identifier() { return getToken(C99Parser.Identifier, 0); }
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
		enterRule(_localctx, 54, RULE_struct_or_union_specifier);
		int _la;
		try {
			setState(421);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(411);
				_la = _input.LA(1);
				if ( !(_la==Struct || _la==Union) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(413);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(412);
					match(Identifier);
					}
				}

				setState(415);
				match(LeCuBr);
				setState(416);
				struct_declaration_list();
				setState(417);
				match(RiCuBr);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(419);
				_la = _input.LA(1);
				if ( !(_la==Struct || _la==Union) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(420);
				match(Identifier);
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
		enterRule(_localctx, 56, RULE_struct_declaration_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(423);
				struct_declaration();
				}
				}
				setState(426); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 119347620400L) != 0) || _la==Identifier );
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
		enterRule(_localctx, 58, RULE_struct_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			specifier_qualifier_list();
			setState(429);
			struct_declarator_list();
			setState(430);
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
		enterRule(_localctx, 60, RULE_specifier_qualifier_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Char:
			case Double:
			case Enum:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Struct:
			case Union:
			case Unsigned:
			case Void:
			case Bool:
			case Complex:
			case Identifier:
				{
				setState(432);
				type_specifier();
				}
				break;
			case Const:
			case Restrict:
			case Volatile:
				{
				setState(433);
				type_qualifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(437);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(436);
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
		enterRule(_localctx, 62, RULE_struct_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			struct_declarator();
			setState(444);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(440);
				match(Comma);
				setState(441);
				struct_declarator();
				}
				}
				setState(446);
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
		enterRule(_localctx, 64, RULE_struct_declarator);
		int _la;
		try {
			setState(453);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(447);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(449);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & 33816577L) != 0)) {
					{
					setState(448);
					declarator();
					}
				}

				setState(451);
				match(Colon);
				setState(452);
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
		public TerminalNode Identifier() { return getToken(C99Parser.Identifier, 0); }
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
		enterRule(_localctx, 66, RULE_enum_specifier);
		int _la;
		try {
			setState(468);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(455);
				match(Enum);
				setState(457);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(456);
					match(Identifier);
					}
				}

				setState(459);
				match(LeCuBr);
				setState(460);
				enumerator_list();
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(461);
					match(Comma);
					}
				}

				setState(464);
				match(RiCuBr);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(466);
				match(Enum);
				setState(467);
				match(Identifier);
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
		enterRule(_localctx, 68, RULE_enumerator_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(470);
			enumerator();
			setState(475);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(471);
					match(Comma);
					setState(472);
					enumerator();
					}
					} 
				}
				setState(477);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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
		public TerminalNode Identifier() { return getToken(C99Parser.Identifier, 0); }
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
		enterRule(_localctx, 70, RULE_enumerator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			match(Identifier);
			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(479);
				match(Assign);
				setState(480);
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
		enterRule(_localctx, 72, RULE_type_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) ) {
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
		enterRule(_localctx, 74, RULE_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Star) {
				{
				setState(485);
				pointer();
				}
			}

			setState(488);
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
		public TerminalNode Identifier() { return getToken(C99Parser.Identifier, 0); }
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
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_direct_declarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(491);
				match(Identifier);
				}
				break;
			case LeRoBr:
				{
				setState(492);
				match(LeRoBr);
				setState(493);
				declarator();
				setState(494);
				match(RiRoBr);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(543);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(541);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
					case 1:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(498);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(499);
						match(LeSqBr);
						setState(501);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
							{
							setState(500);
							type_qualifier_list();
							}
						}

						setState(504);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 442479213178519552L) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & 738721855L) != 0)) {
							{
							setState(503);
							assignment_expression();
							}
						}

						setState(506);
						match(RiSqBr);
						}
						break;
					case 2:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(507);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(508);
						match(LeSqBr);
						setState(509);
						match(Static);
						setState(511);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
							{
							setState(510);
							type_qualifier_list();
							}
						}

						setState(513);
						assignment_expression();
						setState(514);
						match(RiSqBr);
						}
						break;
					case 3:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(516);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(517);
						match(LeSqBr);
						setState(518);
						type_qualifier_list();
						setState(519);
						match(Static);
						setState(520);
						assignment_expression();
						setState(521);
						match(RiSqBr);
						}
						break;
					case 4:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(523);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(524);
						match(LeSqBr);
						setState(526);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
							{
							setState(525);
							type_qualifier_list();
							}
						}

						setState(528);
						match(Star);
						setState(529);
						match(RiSqBr);
						}
						break;
					case 5:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(530);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(531);
						match(LeRoBr);
						setState(532);
						parameter_type_list();
						setState(533);
						match(RiRoBr);
						}
						break;
					case 6:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(535);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(536);
						match(LeRoBr);
						setState(538);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==Identifier) {
							{
							setState(537);
							identifier_list();
							}
						}

						setState(540);
						match(RiRoBr);
						}
						break;
					}
					} 
				}
				setState(545);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
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
		enterRule(_localctx, 78, RULE_pointer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(546);
				match(Star);
				setState(548);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
					{
					setState(547);
					type_qualifier_list();
					}
				}

				}
				}
				setState(552); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Star );
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
		enterRule(_localctx, 80, RULE_type_qualifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(555); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(554);
				type_qualifier();
				}
				}
				setState(557); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0) );
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
		enterRule(_localctx, 82, RULE_parameter_type_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			parameter_list();
			setState(562);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(560);
				match(Comma);
				setState(561);
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
		enterRule(_localctx, 84, RULE_parameter_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			parameter_declaration();
			setState(569);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(565);
					match(Comma);
					setState(566);
					parameter_declaration();
					}
					} 
				}
				setState(571);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
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
		enterRule(_localctx, 86, RULE_parameter_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			declaration_specifiers();
			setState(577);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(573);
				declarator();
				}
				break;
			case 2:
				{
				setState(575);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Star || _la==LeRoBr) {
					{
					setState(574);
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
		public List<TerminalNode> Identifier() { return getTokens(C99Parser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(C99Parser.Identifier, i);
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
		enterRule(_localctx, 88, RULE_identifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579);
			match(Identifier);
			setState(584);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(580);
				match(Comma);
				setState(581);
				match(Identifier);
				}
				}
				setState(586);
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
		enterRule(_localctx, 90, RULE_type_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(587);
			specifier_qualifier_list();
			setState(589);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Star || _la==LeRoBr) {
				{
				setState(588);
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
		enterRule(_localctx, 92, RULE_abstract_declarator);
		int _la;
		try {
			setState(596);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(591);
				pointer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(593);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Star) {
					{
					setState(592);
					pointer();
					}
				}

				setState(595);
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
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode RiRoBr() { return getToken(C99Parser.RiRoBr, 0); }
		public Direct_abstract_declaratorContext direct_abstract_declarator() {
			return getRuleContext(Direct_abstract_declaratorContext.class,0);
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
		int _startState = 94;
		enterRecursionRule(_localctx, 94, RULE_direct_abstract_declarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(599);
			match(LeRoBr);
			setState(600);
			declarator();
			setState(601);
			match(RiRoBr);
			}
			_ctx.stop = _input.LT(-1);
			setState(648);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(646);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
					case 1:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(603);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(604);
						match(LeSqBr);
						setState(606);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
							{
							setState(605);
							type_qualifier_list();
							}
						}

						setState(609);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 442479213178519552L) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & 738721855L) != 0)) {
							{
							setState(608);
							assignment_expression();
							}
						}

						setState(611);
						match(RiSqBr);
						}
						break;
					case 2:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(612);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(613);
						match(LeSqBr);
						setState(614);
						match(Static);
						setState(616);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
							{
							setState(615);
							type_qualifier_list();
							}
						}

						setState(618);
						assignment_expression();
						setState(619);
						match(RiSqBr);
						}
						break;
					case 3:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(621);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(622);
						match(LeSqBr);
						setState(623);
						type_qualifier_list();
						setState(624);
						match(Static);
						setState(625);
						assignment_expression();
						setState(626);
						match(RiSqBr);
						}
						break;
					case 4:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(628);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(629);
						match(LeSqBr);
						setState(631);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
							{
							setState(630);
							type_qualifier_list();
							}
						}

						setState(633);
						match(Star);
						setState(634);
						match(RiSqBr);
						}
						break;
					case 5:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(635);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(636);
						match(LeRoBr);
						setState(637);
						parameter_type_list();
						setState(638);
						match(RiRoBr);
						}
						break;
					case 6:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(640);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(641);
						match(LeRoBr);
						setState(643);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==Identifier) {
							{
							setState(642);
							identifier_list();
							}
						}

						setState(645);
						match(RiRoBr);
						}
						break;
					}
					} 
				}
				setState(650);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
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
		enterRule(_localctx, 96, RULE_typedef_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(651);
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
		enterRule(_localctx, 98, RULE_initializer);
		int _la;
		try {
			setState(661);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Sizeof:
			case Defined:
			case HasEmbed:
			case Offsetof:
			case Incrmn:
			case Decrmn:
			case Amper:
			case Star:
			case Plus:
			case Minus:
			case Tilde:
			case Excla:
			case LeRoBr:
			case Identifier:
			case Constant:
			case String_literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(653);
				assignment_expression();
				}
				break;
			case LeCuBr:
				enterOuterAlt(_localctx, 2);
				{
				setState(654);
				match(LeCuBr);
				setState(655);
				initializer_list();
				setState(657);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(656);
					match(Comma);
					}
				}

				setState(659);
				match(RiCuBr);
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
		enterRule(_localctx, 100, RULE_initializer_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(664);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Period || _la==LeSqBr) {
				{
				setState(663);
				designation();
				}
			}

			setState(666);
			initializer();
			setState(674);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(667);
					match(Comma);
					setState(669);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Period || _la==LeSqBr) {
						{
						setState(668);
						designation();
						}
					}

					setState(671);
					initializer();
					}
					} 
				}
				setState(676);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
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
		enterRule(_localctx, 102, RULE_designation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(677);
			designator_list();
			setState(678);
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
		enterRule(_localctx, 104, RULE_designator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(681); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(680);
				designator();
				}
				}
				setState(683); 
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
		public TerminalNode Identifier() { return getToken(C99Parser.Identifier, 0); }
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
		enterRule(_localctx, 106, RULE_designator);
		try {
			setState(691);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeSqBr:
				enterOuterAlt(_localctx, 1);
				{
				setState(685);
				match(LeSqBr);
				setState(686);
				constant_expression();
				setState(687);
				match(RiSqBr);
				}
				break;
			case Period:
				enterOuterAlt(_localctx, 2);
				{
				setState(689);
				match(Period);
				setState(690);
				match(Identifier);
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
		enterRule(_localctx, 108, RULE_attributes_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(693);
			match(TwoLSB);
			setState(694);
			identifier_list();
			setState(695);
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
		enterRule(_localctx, 110, RULE_statement);
		try {
			setState(704);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(697);
				asm_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(698);
				labeled_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(699);
				compound_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(700);
				expression_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(701);
				selection_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(702);
				iteration_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(703);
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
		public TerminalNode Identifier() { return getToken(C99Parser.Identifier, 0); }
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
		enterRule(_localctx, 112, RULE_labeled_statement);
		try {
			setState(717);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(706);
				match(Identifier);
				setState(707);
				match(Colon);
				setState(708);
				statement();
				}
				break;
			case Case:
				enterOuterAlt(_localctx, 2);
				{
				setState(709);
				match(Case);
				setState(710);
				constant_expression();
				setState(711);
				match(Colon);
				setState(712);
				statement();
				}
				break;
			case Default:
				enterOuterAlt(_localctx, 3);
				{
				setState(714);
				match(Default);
				setState(715);
				match(Colon);
				setState(716);
				statement();
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
		enterRule(_localctx, 114, RULE_compound_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(719);
			match(LeCuBr);
			setState(721);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 446983225089195006L) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & 740821055L) != 0)) {
				{
				setState(720);
				block_item_list();
				}
			}

			setState(723);
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
		enterRule(_localctx, 116, RULE_block_item_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(726); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(725);
				block_item();
				}
				}
				setState(728); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 446983225089195006L) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & 740821055L) != 0) );
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
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
		enterRule(_localctx, 118, RULE_block_item);
		try {
			setState(732);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(730);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(731);
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
		enterRule(_localctx, 120, RULE_expression_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(735);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 442479213178519552L) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & 738721855L) != 0)) {
				{
				setState(734);
				expression();
				}
			}

			setState(737);
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
		enterRule(_localctx, 122, RULE_selection_statement);
		try {
			setState(759);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(739);
				match(If);
				setState(740);
				match(LeRoBr);
				setState(741);
				expression();
				setState(742);
				match(RiRoBr);
				setState(743);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(745);
				match(If);
				setState(746);
				match(LeRoBr);
				setState(747);
				expression();
				setState(748);
				match(RiRoBr);
				setState(749);
				statement();
				setState(750);
				match(Else);
				setState(751);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(753);
				match(Switch);
				setState(754);
				match(LeRoBr);
				setState(755);
				expression();
				setState(756);
				match(RiRoBr);
				setState(757);
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
		enterRule(_localctx, 124, RULE_iteration_statement);
		int _la;
		try {
			setState(803);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(761);
				match(While);
				setState(762);
				match(LeRoBr);
				setState(763);
				expression();
				setState(764);
				match(RiRoBr);
				setState(765);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(767);
				match(Do);
				setState(768);
				statement();
				setState(769);
				match(While);
				setState(770);
				match(LeRoBr);
				setState(771);
				expression();
				setState(772);
				match(RiRoBr);
				setState(773);
				match(Semico);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(775);
				match(For);
				setState(776);
				match(LeRoBr);
				setState(778);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 442479213178519552L) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & 738721855L) != 0)) {
					{
					setState(777);
					expression();
					}
				}

				setState(780);
				match(Semico);
				setState(782);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 442479213178519552L) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & 738721855L) != 0)) {
					{
					setState(781);
					expression();
					}
				}

				setState(784);
				match(Semico);
				setState(786);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 442479213178519552L) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & 738721855L) != 0)) {
					{
					setState(785);
					expression();
					}
				}

				setState(788);
				match(RiRoBr);
				setState(789);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(790);
				match(For);
				setState(791);
				match(LeRoBr);
				setState(792);
				declaration();
				setState(794);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 442479213178519552L) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & 738721855L) != 0)) {
					{
					setState(793);
					expression();
					}
				}

				setState(796);
				match(Semico);
				setState(798);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 442479213178519552L) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & 738721855L) != 0)) {
					{
					setState(797);
					expression();
					}
				}

				setState(800);
				match(RiRoBr);
				setState(801);
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
		public TerminalNode Identifier() { return getToken(C99Parser.Identifier, 0); }
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
		enterRule(_localctx, 126, RULE_jump_statement);
		int _la;
		try {
			setState(817);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Goto:
				enterOuterAlt(_localctx, 1);
				{
				setState(805);
				match(Goto);
				setState(806);
				match(Identifier);
				setState(807);
				match(Semico);
				}
				break;
			case Continue:
				enterOuterAlt(_localctx, 2);
				{
				setState(808);
				match(Continue);
				setState(809);
				match(Semico);
				}
				break;
			case Break:
				enterOuterAlt(_localctx, 3);
				{
				setState(810);
				match(Break);
				setState(811);
				match(Semico);
				}
				break;
			case Return:
				enterOuterAlt(_localctx, 4);
				{
				setState(812);
				match(Return);
				setState(814);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 442479213178519552L) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & 738721855L) != 0)) {
					{
					setState(813);
					expression();
					}
				}

				setState(816);
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
		enterRule(_localctx, 128, RULE_asm_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(819);
			match(Asm);
			setState(820);
			match(LeRoBr);
			setState(821);
			match(String_literal);
			setState(822);
			match(RiRoBr);
			setState(823);
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
		enterRule(_localctx, 130, RULE_translation_unit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(826); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(825);
				external_declaration();
				}
				}
				setState(828); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4503719580154418L) != 0) || _la==TwoLSB || _la==Identifier );
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
		enterRule(_localctx, 132, RULE_external_declaration);
		try {
			setState(832);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(830);
				function_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(831);
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
		enterRule(_localctx, 134, RULE_function_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(837);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TwoLSB) {
				{
				{
				setState(834);
				attributes_declaration();
				}
				}
				setState(839);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(840);
			declaration_specifiers();
			setState(841);
			declarator();
			setState(843);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503719580154418L) != 0) || _la==Identifier) {
				{
				setState(842);
				declaration_list();
				}
			}

			setState(845);
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
		enterRule(_localctx, 136, RULE_declaration_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(848); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(847);
				declaration();
				}
				}
				setState(850); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4503719580154418L) != 0) || _la==Identifier );
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
		case 2:
			return postfix_expression_sempred((Postfix_expressionContext)_localctx, predIndex);
		case 6:
			return multiplicative_expression_sempred((Multiplicative_expressionContext)_localctx, predIndex);
		case 7:
			return additive_expression_sempred((Additive_expressionContext)_localctx, predIndex);
		case 8:
			return shift_expression_sempred((Shift_expressionContext)_localctx, predIndex);
		case 9:
			return relational_expression_sempred((Relational_expressionContext)_localctx, predIndex);
		case 10:
			return equality_expression_sempred((Equality_expressionContext)_localctx, predIndex);
		case 11:
			return and_expression_sempred((And_expressionContext)_localctx, predIndex);
		case 12:
			return xor_expression_sempred((Xor_expressionContext)_localctx, predIndex);
		case 13:
			return or_expression_sempred((Or_expressionContext)_localctx, predIndex);
		case 14:
			return land_expression_sempred((Land_expressionContext)_localctx, predIndex);
		case 15:
			return lor_expression_sempred((Lor_expressionContext)_localctx, predIndex);
		case 38:
			return direct_declarator_sempred((Direct_declaratorContext)_localctx, predIndex);
		case 47:
			return direct_abstract_declarator_sempred((Direct_abstract_declaratorContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean postfix_expression_sempred(Postfix_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multiplicative_expression_sempred(Multiplicative_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additive_expression_sempred(Additive_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean shift_expression_sempred(Shift_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relational_expression_sempred(Relational_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equality_expression_sempred(Equality_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean and_expression_sempred(And_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean xor_expression_sempred(Xor_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean or_expression_sempred(Or_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean land_expression_sempred(Land_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean lor_expression_sempred(Lor_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean direct_declarator_sempred(Direct_declaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 16:
			return precpred(_ctx, 6);
		case 17:
			return precpred(_ctx, 5);
		case 18:
			return precpred(_ctx, 4);
		case 19:
			return precpred(_ctx, 3);
		case 20:
			return precpred(_ctx, 2);
		case 21:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean direct_abstract_declarator_sempred(Direct_abstract_declaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 22:
			return precpred(_ctx, 6);
		case 23:
			return precpred(_ctx, 5);
		case 24:
			return precpred(_ctx, 4);
		case 25:
			return precpred(_ctx, 3);
		case 26:
			return precpred(_ctx, 2);
		case 27:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001u\u0355\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u0094\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"\u009e\b\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00a2\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002\u00ac\b\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u00b9\b\u0002\n\u0002\f\u0002"+
		"\u00bc\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u00c1\b"+
		"\u0003\n\u0003\f\u0003\u00c4\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00e5\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u00ed\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006\u00f5\b\u0006\n\u0006\f\u0006\u00f8"+
		"\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007\u0100\b\u0007\n\u0007\f\u0007\u0103\t\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u010b\b\b\n\b\f\b\u010e"+
		"\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0116\b\t"+
		"\n\t\f\t\u0119\t\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u0121\b\n\n\n\f\n\u0124\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u012c\b\u000b\n\u000b\f\u000b"+
		"\u012f\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f"+
		"\u0137\b\f\n\f\f\f\u013a\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u0142\b\r\n\r\f\r\u0145\t\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u014d\b\u000e\n\u000e"+
		"\f\u000e\u0150\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0005\u000f\u0158\b\u000f\n\u000f\f\u000f\u015b"+
		"\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u0164\b\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u016b\b\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0005\u0012\u0170\b\u0012\n\u0012\f\u0012\u0173\t\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0003\u0014\u0179\b\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0004\u0015\u0181\b\u0015\u000b\u0015\f\u0015\u0182\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0005"+
		"\u0018\u018c\b\u0018\n\u0018\f\u0018\u018f\t\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u0194\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0003\u001a\u019a\b\u001a\u0001\u001b\u0001\u001b\u0003\u001b"+
		"\u019e\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0003\u001b\u01a6\b\u001b\u0001\u001c\u0004\u001c\u01a9\b"+
		"\u001c\u000b\u001c\f\u001c\u01aa\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001e\u0001\u001e\u0003\u001e\u01b3\b\u001e\u0001\u001e\u0003"+
		"\u001e\u01b6\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u01bb"+
		"\b\u001f\n\u001f\f\u001f\u01be\t\u001f\u0001 \u0001 \u0003 \u01c2\b \u0001"+
		" \u0001 \u0003 \u01c6\b \u0001!\u0001!\u0003!\u01ca\b!\u0001!\u0001!\u0001"+
		"!\u0003!\u01cf\b!\u0001!\u0001!\u0001!\u0001!\u0003!\u01d5\b!\u0001\""+
		"\u0001\"\u0001\"\u0005\"\u01da\b\"\n\"\f\"\u01dd\t\"\u0001#\u0001#\u0001"+
		"#\u0003#\u01e2\b#\u0001$\u0001$\u0001%\u0003%\u01e7\b%\u0001%\u0001%\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0003&\u01f1\b&\u0001&\u0001&\u0001"+
		"&\u0003&\u01f6\b&\u0001&\u0003&\u01f9\b&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0003&\u0200\b&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0003&\u020f\b&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0003&\u021b\b&\u0001"+
		"&\u0005&\u021e\b&\n&\f&\u0221\t&\u0001\'\u0001\'\u0003\'\u0225\b\'\u0004"+
		"\'\u0227\b\'\u000b\'\f\'\u0228\u0001(\u0004(\u022c\b(\u000b(\f(\u022d"+
		"\u0001)\u0001)\u0001)\u0003)\u0233\b)\u0001*\u0001*\u0001*\u0005*\u0238"+
		"\b*\n*\f*\u023b\t*\u0001+\u0001+\u0001+\u0003+\u0240\b+\u0003+\u0242\b"+
		"+\u0001,\u0001,\u0001,\u0005,\u0247\b,\n,\f,\u024a\t,\u0001-\u0001-\u0003"+
		"-\u024e\b-\u0001.\u0001.\u0003.\u0252\b.\u0001.\u0003.\u0255\b.\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0003/\u025f\b/\u0001"+
		"/\u0003/\u0262\b/\u0001/\u0001/\u0001/\u0001/\u0001/\u0003/\u0269\b/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0003/\u0278\b/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0003/\u0284\b/\u0001/\u0005/\u0287\b/\n"+
		"/\f/\u028a\t/\u00010\u00010\u00011\u00011\u00011\u00011\u00031\u0292\b"+
		"1\u00011\u00011\u00031\u0296\b1\u00012\u00032\u0299\b2\u00012\u00012\u0001"+
		"2\u00032\u029e\b2\u00012\u00052\u02a1\b2\n2\f2\u02a4\t2\u00013\u00013"+
		"\u00013\u00014\u00044\u02aa\b4\u000b4\f4\u02ab\u00015\u00015\u00015\u0001"+
		"5\u00015\u00015\u00035\u02b4\b5\u00016\u00016\u00016\u00016\u00017\u0001"+
		"7\u00017\u00017\u00017\u00017\u00017\u00037\u02c1\b7\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00038\u02ce"+
		"\b8\u00019\u00019\u00039\u02d2\b9\u00019\u00019\u0001:\u0004:\u02d7\b"+
		":\u000b:\f:\u02d8\u0001;\u0001;\u0003;\u02dd\b;\u0001<\u0003<\u02e0\b"+
		"<\u0001<\u0001<\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001"+
		"=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001"+
		"=\u0001=\u0001=\u0003=\u02f8\b=\u0001>\u0001>\u0001>\u0001>\u0001>\u0001"+
		">\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001"+
		">\u0001>\u0003>\u030b\b>\u0001>\u0001>\u0003>\u030f\b>\u0001>\u0001>\u0003"+
		">\u0313\b>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0003>\u031b\b>\u0001"+
		">\u0001>\u0003>\u031f\b>\u0001>\u0001>\u0001>\u0003>\u0324\b>\u0001?\u0001"+
		"?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0003?\u032f\b?\u0001"+
		"?\u0003?\u0332\b?\u0001@\u0001@\u0001@\u0001@\u0001@\u0001@\u0001A\u0004"+
		"A\u033b\bA\u000bA\fA\u033c\u0001B\u0001B\u0003B\u0341\bB\u0001C\u0005"+
		"C\u0344\bC\nC\fC\u0347\tC\u0001C\u0001C\u0001C\u0003C\u034c\bC\u0001C"+
		"\u0001C\u0001D\u0004D\u0351\bD\u000bD\fD\u0352\u0001D\u0001\u0182\r\u0004"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001eL^E\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u0000\f\u0001\u0000W\\\u0001\u0000tu\u0002\u0000XX]^\u0001\u0000"+
		"YZ\u0001\u0000;<\u0001\u0000=@\u0001\u0000AB\u0002\u0000ENee\u0006\u0000"+
		"\u0001\u0001\f\f\u0014\u0014\u001a\u001a\u001d\u001d44\u0007\u0000\u0004"+
		"\u0004\t\t\r\r\u0012\u0013\u0017\u0018\u001f #$\u0002\u0000\u001b\u001b"+
		"\u001e\u001e\u0003\u0000\u0005\u0005\u0015\u0015!!\u0393\u0000\u008a\u0001"+
		"\u0000\u0000\u0000\u0002\u0093\u0001\u0000\u0000\u0000\u0004\u00a1\u0001"+
		"\u0000\u0000\u0000\u0006\u00bd\u0001\u0000\u0000\u0000\b\u00e4\u0001\u0000"+
		"\u0000\u0000\n\u00ec\u0001\u0000\u0000\u0000\f\u00ee\u0001\u0000\u0000"+
		"\u0000\u000e\u00f9\u0001\u0000\u0000\u0000\u0010\u0104\u0001\u0000\u0000"+
		"\u0000\u0012\u010f\u0001\u0000\u0000\u0000\u0014\u011a\u0001\u0000\u0000"+
		"\u0000\u0016\u0125\u0001\u0000\u0000\u0000\u0018\u0130\u0001\u0000\u0000"+
		"\u0000\u001a\u013b\u0001\u0000\u0000\u0000\u001c\u0146\u0001\u0000\u0000"+
		"\u0000\u001e\u0151\u0001\u0000\u0000\u0000 \u0163\u0001\u0000\u0000\u0000"+
		"\"\u016a\u0001\u0000\u0000\u0000$\u016c\u0001\u0000\u0000\u0000&\u0174"+
		"\u0001\u0000\u0000\u0000(\u0176\u0001\u0000\u0000\u0000*\u0180\u0001\u0000"+
		"\u0000\u0000,\u0184\u0001\u0000\u0000\u0000.\u0186\u0001\u0000\u0000\u0000"+
		"0\u0188\u0001\u0000\u0000\u00002\u0190\u0001\u0000\u0000\u00004\u0199"+
		"\u0001\u0000\u0000\u00006\u01a5\u0001\u0000\u0000\u00008\u01a8\u0001\u0000"+
		"\u0000\u0000:\u01ac\u0001\u0000\u0000\u0000<\u01b2\u0001\u0000\u0000\u0000"+
		">\u01b7\u0001\u0000\u0000\u0000@\u01c5\u0001\u0000\u0000\u0000B\u01d4"+
		"\u0001\u0000\u0000\u0000D\u01d6\u0001\u0000\u0000\u0000F\u01de\u0001\u0000"+
		"\u0000\u0000H\u01e3\u0001\u0000\u0000\u0000J\u01e6\u0001\u0000\u0000\u0000"+
		"L\u01f0\u0001\u0000\u0000\u0000N\u0226\u0001\u0000\u0000\u0000P\u022b"+
		"\u0001\u0000\u0000\u0000R\u022f\u0001\u0000\u0000\u0000T\u0234\u0001\u0000"+
		"\u0000\u0000V\u023c\u0001\u0000\u0000\u0000X\u0243\u0001\u0000\u0000\u0000"+
		"Z\u024b\u0001\u0000\u0000\u0000\\\u0254\u0001\u0000\u0000\u0000^\u0256"+
		"\u0001\u0000\u0000\u0000`\u028b\u0001\u0000\u0000\u0000b\u0295\u0001\u0000"+
		"\u0000\u0000d\u0298\u0001\u0000\u0000\u0000f\u02a5\u0001\u0000\u0000\u0000"+
		"h\u02a9\u0001\u0000\u0000\u0000j\u02b3\u0001\u0000\u0000\u0000l\u02b5"+
		"\u0001\u0000\u0000\u0000n\u02c0\u0001\u0000\u0000\u0000p\u02cd\u0001\u0000"+
		"\u0000\u0000r\u02cf\u0001\u0000\u0000\u0000t\u02d6\u0001\u0000\u0000\u0000"+
		"v\u02dc\u0001\u0000\u0000\u0000x\u02df\u0001\u0000\u0000\u0000z\u02f7"+
		"\u0001\u0000\u0000\u0000|\u0323\u0001\u0000\u0000\u0000~\u0331\u0001\u0000"+
		"\u0000\u0000\u0080\u0333\u0001\u0000\u0000\u0000\u0082\u033a\u0001\u0000"+
		"\u0000\u0000\u0084\u0340\u0001\u0000\u0000\u0000\u0086\u0345\u0001\u0000"+
		"\u0000\u0000\u0088\u0350\u0001\u0000\u0000\u0000\u008a\u008b\u0003\u0082"+
		"A\u0000\u008b\u0001\u0001\u0000\u0000\u0000\u008c\u0094\u0005q\u0000\u0000"+
		"\u008d\u0094\u0005r\u0000\u0000\u008e\u0094\u0005t\u0000\u0000\u008f\u0090"+
		"\u0005j\u0000\u0000\u0090\u0091\u0003$\u0012\u0000\u0091\u0092\u0005k"+
		"\u0000\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093\u008c\u0001\u0000"+
		"\u0000\u0000\u0093\u008d\u0001\u0000\u0000\u0000\u0093\u008e\u0001\u0000"+
		"\u0000\u0000\u0093\u008f\u0001\u0000\u0000\u0000\u0094\u0003\u0001\u0000"+
		"\u0000\u0000\u0095\u0096\u0006\u0002\uffff\uffff\u0000\u0096\u00a2\u0003"+
		"\u0002\u0001\u0000\u0097\u0098\u0005j\u0000\u0000\u0098\u0099\u0003Z-"+
		"\u0000\u0099\u009a\u0005k\u0000\u0000\u009a\u009b\u0005l\u0000\u0000\u009b"+
		"\u009d\u0003d2\u0000\u009c\u009e\u0005f\u0000\u0000\u009d\u009c\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009f\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0005m\u0000\u0000\u00a0\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a1\u0095\u0001\u0000\u0000\u0000\u00a1\u0097\u0001\u0000"+
		"\u0000\u0000\u00a2\u00ba\u0001\u0000\u0000\u0000\u00a3\u00a4\n\u0007\u0000"+
		"\u0000\u00a4\u00a5\u0005h\u0000\u0000\u00a5\u00a6\u0003$\u0012\u0000\u00a6"+
		"\u00a7\u0005i\u0000\u0000\u00a7\u00b9\u0001\u0000\u0000\u0000\u00a8\u00a9"+
		"\n\u0006\u0000\u0000\u00a9\u00ab\u0005j\u0000\u0000\u00aa\u00ac\u0003"+
		"\u0006\u0003\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00b9\u0005"+
		"k\u0000\u0000\u00ae\u00af\n\u0005\u0000\u0000\u00af\u00b0\u0005c\u0000"+
		"\u0000\u00b0\u00b9\u0005q\u0000\u0000\u00b1\u00b2\n\u0004\u0000\u0000"+
		"\u00b2\u00b3\u00058\u0000\u0000\u00b3\u00b9\u0005q\u0000\u0000\u00b4\u00b5"+
		"\n\u0003\u0000\u0000\u00b5\u00b9\u00059\u0000\u0000\u00b6\u00b7\n\u0002"+
		"\u0000\u0000\u00b7\u00b9\u0005:\u0000\u0000\u00b8\u00a3\u0001\u0000\u0000"+
		"\u0000\u00b8\u00a8\u0001\u0000\u0000\u0000\u00b8\u00ae\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b1\u0001\u0000\u0000\u0000\u00b8\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00bc\u0001\u0000\u0000"+
		"\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000"+
		"\u0000\u00bb\u0005\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000"+
		"\u0000\u00bd\u00c2\u0003\"\u0011\u0000\u00be\u00bf\u0005f\u0000\u0000"+
		"\u00bf\u00c1\u0003\"\u0011\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c3\u0007\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c5\u00e5\u0003\u0004\u0002\u0000\u00c6"+
		"\u00c7\u00059\u0000\u0000\u00c7\u00e5\u0003\b\u0004\u0000\u00c8\u00c9"+
		"\u0005:\u0000\u0000\u00c9\u00e5\u0003\b\u0004\u0000\u00ca\u00cb\u0007"+
		"\u0000\u0000\u0000\u00cb\u00e5\u0003\n\u0005\u0000\u00cc\u00cd\u0005\u0019"+
		"\u0000\u0000\u00cd\u00e5\u0003\b\u0004\u0000\u00ce\u00cf\u0005\u0019\u0000"+
		"\u0000\u00cf\u00d0\u0005j\u0000\u0000\u00d0\u00d1\u0003Z-\u0000\u00d1"+
		"\u00d2\u0005k\u0000\u0000\u00d2\u00e5\u0001\u0000\u0000\u0000\u00d3\u00d4"+
		"\u00052\u0000\u0000\u00d4\u00d5\u0005j\u0000\u0000\u00d5\u00d6\u0007\u0001"+
		"\u0000\u0000\u00d6\u00e5\u0005k\u0000\u0000\u00d7\u00d8\u0005\'\u0000"+
		"\u0000\u00d8\u00e5\u0005q\u0000\u0000\u00d9\u00da\u0005\'\u0000\u0000"+
		"\u00da\u00db\u0005j\u0000\u0000\u00db\u00dc\u0005q\u0000\u0000\u00dc\u00e5"+
		"\u0005k\u0000\u0000\u00dd\u00de\u00055\u0000\u0000\u00de\u00df\u0005j"+
		"\u0000\u0000\u00df\u00e0\u0003Z-\u0000\u00e0\u00e1\u0005f\u0000\u0000"+
		"\u00e1\u00e2\u0005q\u0000\u0000\u00e2\u00e3\u0005k\u0000\u0000\u00e3\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e4\u00c5\u0001\u0000\u0000\u0000\u00e4\u00c6"+
		"\u0001\u0000\u0000\u0000\u00e4\u00c8\u0001\u0000\u0000\u0000\u00e4\u00ca"+
		"\u0001\u0000\u0000\u0000\u00e4\u00cc\u0001\u0000\u0000\u0000\u00e4\u00ce"+
		"\u0001\u0000\u0000\u0000\u00e4\u00d3\u0001\u0000\u0000\u0000\u00e4\u00d7"+
		"\u0001\u0000\u0000\u0000\u00e4\u00d9\u0001\u0000\u0000\u0000\u00e4\u00dd"+
		"\u0001\u0000\u0000\u0000\u00e5\t\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005"+
		"j\u0000\u0000\u00e7\u00e8\u0003Z-\u0000\u00e8\u00e9\u0005k\u0000\u0000"+
		"\u00e9\u00ea\u0003\n\u0005\u0000\u00ea\u00ed\u0001\u0000\u0000\u0000\u00eb"+
		"\u00ed\u0003\b\u0004\u0000\u00ec\u00e6\u0001\u0000\u0000\u0000\u00ec\u00eb"+
		"\u0001\u0000\u0000\u0000\u00ed\u000b\u0001\u0000\u0000\u0000\u00ee\u00ef"+
		"\u0006\u0006\uffff\uffff\u0000\u00ef\u00f0\u0003\n\u0005\u0000\u00f0\u00f6"+
		"\u0001\u0000\u0000\u0000\u00f1\u00f2\n\u0001\u0000\u0000\u00f2\u00f3\u0007"+
		"\u0002\u0000\u0000\u00f3\u00f5\u0003\n\u0005\u0000\u00f4\u00f1\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f8\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000"+
		"\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\r\u0001\u0000\u0000"+
		"\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f9\u00fa\u0006\u0007\uffff"+
		"\uffff\u0000\u00fa\u00fb\u0003\f\u0006\u0000\u00fb\u0101\u0001\u0000\u0000"+
		"\u0000\u00fc\u00fd\n\u0001\u0000\u0000\u00fd\u00fe\u0007\u0003\u0000\u0000"+
		"\u00fe\u0100\u0003\f\u0006\u0000\u00ff\u00fc\u0001\u0000\u0000\u0000\u0100"+
		"\u0103\u0001\u0000\u0000\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0101"+
		"\u0102\u0001\u0000\u0000\u0000\u0102\u000f\u0001\u0000\u0000\u0000\u0103"+
		"\u0101\u0001\u0000\u0000\u0000\u0104\u0105\u0006\b\uffff\uffff\u0000\u0105"+
		"\u0106\u0003\u000e\u0007\u0000\u0106\u010c\u0001\u0000\u0000\u0000\u0107"+
		"\u0108\n\u0001\u0000\u0000\u0108\u0109\u0007\u0004\u0000\u0000\u0109\u010b"+
		"\u0003\u000e\u0007\u0000\u010a\u0107\u0001\u0000\u0000\u0000\u010b\u010e"+
		"\u0001\u0000\u0000\u0000\u010c\u010a\u0001\u0000\u0000\u0000\u010c\u010d"+
		"\u0001\u0000\u0000\u0000\u010d\u0011\u0001\u0000\u0000\u0000\u010e\u010c"+
		"\u0001\u0000\u0000\u0000\u010f\u0110\u0006\t\uffff\uffff\u0000\u0110\u0111"+
		"\u0003\u0010\b\u0000\u0111\u0117\u0001\u0000\u0000\u0000\u0112\u0113\n"+
		"\u0001\u0000\u0000\u0113\u0114\u0007\u0005\u0000\u0000\u0114\u0116\u0003"+
		"\u0010\b\u0000\u0115\u0112\u0001\u0000\u0000\u0000\u0116\u0119\u0001\u0000"+
		"\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0117\u0118\u0001\u0000"+
		"\u0000\u0000\u0118\u0013\u0001\u0000\u0000\u0000\u0119\u0117\u0001\u0000"+
		"\u0000\u0000\u011a\u011b\u0006\n\uffff\uffff\u0000\u011b\u011c\u0003\u0012"+
		"\t\u0000\u011c\u0122\u0001\u0000\u0000\u0000\u011d\u011e\n\u0001\u0000"+
		"\u0000\u011e\u011f\u0007\u0006\u0000\u0000\u011f\u0121\u0003\u0012\t\u0000"+
		"\u0120\u011d\u0001\u0000\u0000\u0000\u0121\u0124\u0001\u0000\u0000\u0000"+
		"\u0122\u0120\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000"+
		"\u0123\u0015\u0001\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000"+
		"\u0125\u0126\u0006\u000b\uffff\uffff\u0000\u0126\u0127\u0003\u0014\n\u0000"+
		"\u0127\u012d\u0001\u0000\u0000\u0000\u0128\u0129\n\u0001\u0000\u0000\u0129"+
		"\u012a\u0005W\u0000\u0000\u012a\u012c\u0003\u0014\n\u0000\u012b\u0128"+
		"\u0001\u0000\u0000\u0000\u012c\u012f\u0001\u0000\u0000\u0000\u012d\u012b"+
		"\u0001\u0000\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e\u0017"+
		"\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u0130\u0131"+
		"\u0006\f\uffff\uffff\u0000\u0131\u0132\u0003\u0016\u000b\u0000\u0132\u0138"+
		"\u0001\u0000\u0000\u0000\u0133\u0134\n\u0001\u0000\u0000\u0134\u0135\u0005"+
		"_\u0000\u0000\u0135\u0137\u0003\u0016\u000b\u0000\u0136\u0133\u0001\u0000"+
		"\u0000\u0000\u0137\u013a\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000"+
		"\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u0019\u0001\u0000"+
		"\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013b\u013c\u0006\r\uffff"+
		"\uffff\u0000\u013c\u013d\u0003\u0018\f\u0000\u013d\u0143\u0001\u0000\u0000"+
		"\u0000\u013e\u013f\n\u0001\u0000\u0000\u013f\u0140\u0005`\u0000\u0000"+
		"\u0140\u0142\u0003\u0018\f\u0000\u0141\u013e\u0001\u0000\u0000\u0000\u0142"+
		"\u0145\u0001\u0000\u0000\u0000\u0143\u0141\u0001\u0000\u0000\u0000\u0143"+
		"\u0144\u0001\u0000\u0000\u0000\u0144\u001b\u0001\u0000\u0000\u0000\u0145"+
		"\u0143\u0001\u0000\u0000\u0000\u0146\u0147\u0006\u000e\uffff\uffff\u0000"+
		"\u0147\u0148\u0003\u001a\r\u0000\u0148\u014e\u0001\u0000\u0000\u0000\u0149"+
		"\u014a\n\u0001\u0000\u0000\u014a\u014b\u0005C\u0000\u0000\u014b\u014d"+
		"\u0003\u001a\r\u0000\u014c\u0149\u0001\u0000\u0000\u0000\u014d\u0150\u0001"+
		"\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000\u014e\u014f\u0001"+
		"\u0000\u0000\u0000\u014f\u001d\u0001\u0000\u0000\u0000\u0150\u014e\u0001"+
		"\u0000\u0000\u0000\u0151\u0152\u0006\u000f\uffff\uffff\u0000\u0152\u0153"+
		"\u0003\u001c\u000e\u0000\u0153\u0159\u0001\u0000\u0000\u0000\u0154\u0155"+
		"\n\u0001\u0000\u0000\u0155\u0156\u0005D\u0000\u0000\u0156\u0158\u0003"+
		"\u001c\u000e\u0000\u0157\u0154\u0001\u0000\u0000\u0000\u0158\u015b\u0001"+
		"\u0000\u0000\u0000\u0159\u0157\u0001\u0000\u0000\u0000\u0159\u015a\u0001"+
		"\u0000\u0000\u0000\u015a\u001f\u0001\u0000\u0000\u0000\u015b\u0159\u0001"+
		"\u0000\u0000\u0000\u015c\u0164\u0003\u001e\u000f\u0000\u015d\u015e\u0003"+
		"\u001e\u000f\u0000\u015e\u015f\u0005d\u0000\u0000\u015f\u0160\u0003$\u0012"+
		"\u0000\u0160\u0161\u0005a\u0000\u0000\u0161\u0162\u0003 \u0010\u0000\u0162"+
		"\u0164\u0001\u0000\u0000\u0000\u0163\u015c\u0001\u0000\u0000\u0000\u0163"+
		"\u015d\u0001\u0000\u0000\u0000\u0164!\u0001\u0000\u0000\u0000\u0165\u016b"+
		"\u0003 \u0010\u0000\u0166\u0167\u0003\b\u0004\u0000\u0167\u0168\u0007"+
		"\u0007\u0000\u0000\u0168\u0169\u0003\"\u0011\u0000\u0169\u016b\u0001\u0000"+
		"\u0000\u0000\u016a\u0165\u0001\u0000\u0000\u0000\u016a\u0166\u0001\u0000"+
		"\u0000\u0000\u016b#\u0001\u0000\u0000\u0000\u016c\u0171\u0003\"\u0011"+
		"\u0000\u016d\u016e\u0005f\u0000\u0000\u016e\u0170\u0003\"\u0011\u0000"+
		"\u016f\u016d\u0001\u0000\u0000\u0000\u0170\u0173\u0001\u0000\u0000\u0000"+
		"\u0171\u016f\u0001\u0000\u0000\u0000\u0171\u0172\u0001\u0000\u0000\u0000"+
		"\u0172%\u0001\u0000\u0000\u0000\u0173\u0171\u0001\u0000\u0000\u0000\u0174"+
		"\u0175\u0003 \u0010\u0000\u0175\'\u0001\u0000\u0000\u0000\u0176\u0178"+
		"\u0003*\u0015\u0000\u0177\u0179\u00030\u0018\u0000\u0178\u0177\u0001\u0000"+
		"\u0000\u0000\u0178\u0179\u0001\u0000\u0000\u0000\u0179\u017a\u0001\u0000"+
		"\u0000\u0000\u017a\u017b\u0005b\u0000\u0000\u017b)\u0001\u0000\u0000\u0000"+
		"\u017c\u0181\u0003,\u0016\u0000\u017d\u0181\u00034\u001a\u0000\u017e\u0181"+
		"\u0003H$\u0000\u017f\u0181\u0003.\u0017\u0000\u0180\u017c\u0001\u0000"+
		"\u0000\u0000\u0180\u017d\u0001\u0000\u0000\u0000\u0180\u017e\u0001\u0000"+
		"\u0000\u0000\u0180\u017f\u0001\u0000\u0000\u0000\u0181\u0182\u0001\u0000"+
		"\u0000\u0000\u0182\u0183\u0001\u0000\u0000\u0000\u0182\u0180\u0001\u0000"+
		"\u0000\u0000\u0183+\u0001\u0000\u0000\u0000\u0184\u0185\u0007\b\u0000"+
		"\u0000\u0185-\u0001\u0000\u0000\u0000\u0186\u0187\u0005\u0011\u0000\u0000"+
		"\u0187/\u0001\u0000\u0000\u0000\u0188\u018d\u00032\u0019\u0000\u0189\u018a"+
		"\u0005f\u0000\u0000\u018a\u018c\u00032\u0019\u0000\u018b\u0189\u0001\u0000"+
		"\u0000\u0000\u018c\u018f\u0001\u0000\u0000\u0000\u018d\u018b\u0001\u0000"+
		"\u0000\u0000\u018d\u018e\u0001\u0000\u0000\u0000\u018e1\u0001\u0000\u0000"+
		"\u0000\u018f\u018d\u0001\u0000\u0000\u0000\u0190\u0193\u0003J%\u0000\u0191"+
		"\u0192\u0005e\u0000\u0000\u0192\u0194\u0003b1\u0000\u0193\u0191\u0001"+
		"\u0000\u0000\u0000\u0193\u0194\u0001\u0000\u0000\u0000\u01943\u0001\u0000"+
		"\u0000\u0000\u0195\u019a\u0007\t\u0000\u0000\u0196\u019a\u00036\u001b"+
		"\u0000\u0197\u019a\u0003B!\u0000\u0198\u019a\u0003`0\u0000\u0199\u0195"+
		"\u0001\u0000\u0000\u0000\u0199\u0196\u0001\u0000\u0000\u0000\u0199\u0197"+
		"\u0001\u0000\u0000\u0000\u0199\u0198\u0001\u0000\u0000\u0000\u019a5\u0001"+
		"\u0000\u0000\u0000\u019b\u019d\u0007\n\u0000\u0000\u019c\u019e\u0005q"+
		"\u0000\u0000\u019d\u019c\u0001\u0000\u0000\u0000\u019d\u019e\u0001\u0000"+
		"\u0000\u0000\u019e\u019f\u0001\u0000\u0000\u0000\u019f\u01a0\u0005l\u0000"+
		"\u0000\u01a0\u01a1\u00038\u001c\u0000\u01a1\u01a2\u0005m\u0000\u0000\u01a2"+
		"\u01a6\u0001\u0000\u0000\u0000\u01a3\u01a4\u0007\n\u0000\u0000\u01a4\u01a6"+
		"\u0005q\u0000\u0000\u01a5\u019b\u0001\u0000\u0000\u0000\u01a5\u01a3\u0001"+
		"\u0000\u0000\u0000\u01a67\u0001\u0000\u0000\u0000\u01a7\u01a9\u0003:\u001d"+
		"\u0000\u01a8\u01a7\u0001\u0000\u0000\u0000\u01a9\u01aa\u0001\u0000\u0000"+
		"\u0000\u01aa\u01a8\u0001\u0000\u0000\u0000\u01aa\u01ab\u0001\u0000\u0000"+
		"\u0000\u01ab9\u0001\u0000\u0000\u0000\u01ac\u01ad\u0003<\u001e\u0000\u01ad"+
		"\u01ae\u0003>\u001f\u0000\u01ae\u01af\u0005b\u0000\u0000\u01af;\u0001"+
		"\u0000\u0000\u0000\u01b0\u01b3\u00034\u001a\u0000\u01b1\u01b3\u0003H$"+
		"\u0000\u01b2\u01b0\u0001\u0000\u0000\u0000\u01b2\u01b1\u0001\u0000\u0000"+
		"\u0000\u01b3\u01b5\u0001\u0000\u0000\u0000\u01b4\u01b6\u0003<\u001e\u0000"+
		"\u01b5\u01b4\u0001\u0000\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000"+
		"\u01b6=\u0001\u0000\u0000\u0000\u01b7\u01bc\u0003@ \u0000\u01b8\u01b9"+
		"\u0005f\u0000\u0000\u01b9\u01bb\u0003@ \u0000\u01ba\u01b8\u0001\u0000"+
		"\u0000\u0000\u01bb\u01be\u0001\u0000\u0000\u0000\u01bc\u01ba\u0001\u0000"+
		"\u0000\u0000\u01bc\u01bd\u0001\u0000\u0000\u0000\u01bd?\u0001\u0000\u0000"+
		"\u0000\u01be\u01bc\u0001\u0000\u0000\u0000\u01bf\u01c6\u0003J%\u0000\u01c0"+
		"\u01c2\u0003J%\u0000\u01c1\u01c0\u0001\u0000\u0000\u0000\u01c1\u01c2\u0001"+
		"\u0000\u0000\u0000\u01c2\u01c3\u0001\u0000\u0000\u0000\u01c3\u01c4\u0005"+
		"a\u0000\u0000\u01c4\u01c6\u0003&\u0013\u0000\u01c5\u01bf\u0001\u0000\u0000"+
		"\u0000\u01c5\u01c1\u0001\u0000\u0000\u0000\u01c6A\u0001\u0000\u0000\u0000"+
		"\u01c7\u01c9\u0005\u000b\u0000\u0000\u01c8\u01ca\u0005q\u0000\u0000\u01c9"+
		"\u01c8\u0001\u0000\u0000\u0000\u01c9\u01ca\u0001\u0000\u0000\u0000\u01ca"+
		"\u01cb\u0001\u0000\u0000\u0000\u01cb\u01cc\u0005l\u0000\u0000\u01cc\u01ce"+
		"\u0003D\"\u0000\u01cd\u01cf\u0005f\u0000\u0000\u01ce\u01cd\u0001\u0000"+
		"\u0000\u0000\u01ce\u01cf\u0001\u0000\u0000\u0000\u01cf\u01d0\u0001\u0000"+
		"\u0000\u0000\u01d0\u01d1\u0005m\u0000\u0000\u01d1\u01d5\u0001\u0000\u0000"+
		"\u0000\u01d2\u01d3\u0005\u000b\u0000\u0000\u01d3\u01d5\u0005q\u0000\u0000"+
		"\u01d4\u01c7\u0001\u0000\u0000\u0000\u01d4\u01d2\u0001\u0000\u0000\u0000"+
		"\u01d5C\u0001\u0000\u0000\u0000\u01d6\u01db\u0003F#\u0000\u01d7\u01d8"+
		"\u0005f\u0000\u0000\u01d8\u01da\u0003F#\u0000\u01d9\u01d7\u0001\u0000"+
		"\u0000\u0000\u01da\u01dd\u0001\u0000\u0000\u0000\u01db\u01d9\u0001\u0000"+
		"\u0000\u0000\u01db\u01dc\u0001\u0000\u0000\u0000\u01dcE\u0001\u0000\u0000"+
		"\u0000\u01dd\u01db\u0001\u0000\u0000\u0000\u01de\u01e1\u0005q\u0000\u0000"+
		"\u01df\u01e0\u0005e\u0000\u0000\u01e0\u01e2\u0003&\u0013\u0000\u01e1\u01df"+
		"\u0001\u0000\u0000\u0000\u01e1\u01e2\u0001\u0000\u0000\u0000\u01e2G\u0001"+
		"\u0000\u0000\u0000\u01e3\u01e4\u0007\u000b\u0000\u0000\u01e4I\u0001\u0000"+
		"\u0000\u0000\u01e5\u01e7\u0003N\'\u0000\u01e6\u01e5\u0001\u0000\u0000"+
		"\u0000\u01e6\u01e7\u0001\u0000\u0000\u0000\u01e7\u01e8\u0001\u0000\u0000"+
		"\u0000\u01e8\u01e9\u0003L&\u0000\u01e9K\u0001\u0000\u0000\u0000\u01ea"+
		"\u01eb\u0006&\uffff\uffff\u0000\u01eb\u01f1\u0005q\u0000\u0000\u01ec\u01ed"+
		"\u0005j\u0000\u0000\u01ed\u01ee\u0003J%\u0000\u01ee\u01ef\u0005k\u0000"+
		"\u0000\u01ef\u01f1\u0001\u0000\u0000\u0000\u01f0\u01ea\u0001\u0000\u0000"+
		"\u0000\u01f0\u01ec\u0001\u0000\u0000\u0000\u01f1\u021f\u0001\u0000\u0000"+
		"\u0000\u01f2\u01f3\n\u0006\u0000\u0000\u01f3\u01f5\u0005h\u0000\u0000"+
		"\u01f4\u01f6\u0003P(\u0000\u01f5\u01f4\u0001\u0000\u0000\u0000\u01f5\u01f6"+
		"\u0001\u0000\u0000\u0000\u01f6\u01f8\u0001\u0000\u0000\u0000\u01f7\u01f9"+
		"\u0003\"\u0011\u0000\u01f8\u01f7\u0001\u0000\u0000\u0000\u01f8\u01f9\u0001"+
		"\u0000\u0000\u0000\u01f9\u01fa\u0001\u0000\u0000\u0000\u01fa\u021e\u0005"+
		"i\u0000\u0000\u01fb\u01fc\n\u0005\u0000\u0000\u01fc\u01fd\u0005h\u0000"+
		"\u0000\u01fd\u01ff\u0005\u001a\u0000\u0000\u01fe\u0200\u0003P(\u0000\u01ff"+
		"\u01fe\u0001\u0000\u0000\u0000\u01ff\u0200\u0001\u0000\u0000\u0000\u0200"+
		"\u0201\u0001\u0000\u0000\u0000\u0201\u0202\u0003\"\u0011\u0000\u0202\u0203"+
		"\u0005i\u0000\u0000\u0203\u021e\u0001\u0000\u0000\u0000\u0204\u0205\n"+
		"\u0004\u0000\u0000\u0205\u0206\u0005h\u0000\u0000\u0206\u0207\u0003P("+
		"\u0000\u0207\u0208\u0005\u001a\u0000\u0000\u0208\u0209\u0003\"\u0011\u0000"+
		"\u0209\u020a\u0005i\u0000\u0000\u020a\u021e\u0001\u0000\u0000\u0000\u020b"+
		"\u020c\n\u0003\u0000\u0000\u020c\u020e\u0005h\u0000\u0000\u020d\u020f"+
		"\u0003P(\u0000\u020e\u020d\u0001\u0000\u0000\u0000\u020e\u020f\u0001\u0000"+
		"\u0000\u0000\u020f\u0210\u0001\u0000\u0000\u0000\u0210\u0211\u0005X\u0000"+
		"\u0000\u0211\u021e\u0005i\u0000\u0000\u0212\u0213\n\u0002\u0000\u0000"+
		"\u0213\u0214\u0005j\u0000\u0000\u0214\u0215\u0003R)\u0000\u0215\u0216"+
		"\u0005k\u0000\u0000\u0216\u021e\u0001\u0000\u0000\u0000\u0217\u0218\n"+
		"\u0001\u0000\u0000\u0218\u021a\u0005j\u0000\u0000\u0219\u021b\u0003X,"+
		"\u0000\u021a\u0219\u0001\u0000\u0000\u0000\u021a\u021b\u0001\u0000\u0000"+
		"\u0000\u021b\u021c\u0001\u0000\u0000\u0000\u021c\u021e\u0005k\u0000\u0000"+
		"\u021d\u01f2\u0001\u0000\u0000\u0000\u021d\u01fb\u0001\u0000\u0000\u0000"+
		"\u021d\u0204\u0001\u0000\u0000\u0000\u021d\u020b\u0001\u0000\u0000\u0000"+
		"\u021d\u0212\u0001\u0000\u0000\u0000\u021d\u0217\u0001\u0000\u0000\u0000"+
		"\u021e\u0221\u0001\u0000\u0000\u0000\u021f\u021d\u0001\u0000\u0000\u0000"+
		"\u021f\u0220\u0001\u0000\u0000\u0000\u0220M\u0001\u0000\u0000\u0000\u0221"+
		"\u021f\u0001\u0000\u0000\u0000\u0222\u0224\u0005X\u0000\u0000\u0223\u0225"+
		"\u0003P(\u0000\u0224\u0223\u0001\u0000\u0000\u0000\u0224\u0225\u0001\u0000"+
		"\u0000\u0000\u0225\u0227\u0001\u0000\u0000\u0000\u0226\u0222\u0001\u0000"+
		"\u0000\u0000\u0227\u0228\u0001\u0000\u0000\u0000\u0228\u0226\u0001\u0000"+
		"\u0000\u0000\u0228\u0229\u0001\u0000\u0000\u0000\u0229O\u0001\u0000\u0000"+
		"\u0000\u022a\u022c\u0003H$\u0000\u022b\u022a\u0001\u0000\u0000\u0000\u022c"+
		"\u022d\u0001\u0000\u0000\u0000\u022d\u022b\u0001\u0000\u0000\u0000\u022d"+
		"\u022e\u0001\u0000\u0000\u0000\u022eQ\u0001\u0000\u0000\u0000\u022f\u0232"+
		"\u0003T*\u0000\u0230\u0231\u0005f\u0000\u0000\u0231\u0233\u00057\u0000"+
		"\u0000\u0232\u0230\u0001\u0000\u0000\u0000\u0232\u0233\u0001\u0000\u0000"+
		"\u0000\u0233S\u0001\u0000\u0000\u0000\u0234\u0239\u0003V+\u0000\u0235"+
		"\u0236\u0005f\u0000\u0000\u0236\u0238\u0003V+\u0000\u0237\u0235\u0001"+
		"\u0000\u0000\u0000\u0238\u023b\u0001\u0000\u0000\u0000\u0239\u0237\u0001"+
		"\u0000\u0000\u0000\u0239\u023a\u0001\u0000\u0000\u0000\u023aU\u0001\u0000"+
		"\u0000\u0000\u023b\u0239\u0001\u0000\u0000\u0000\u023c\u0241\u0003*\u0015"+
		"\u0000\u023d\u0242\u0003J%\u0000\u023e\u0240\u0003\\.\u0000\u023f\u023e"+
		"\u0001\u0000\u0000\u0000\u023f\u0240\u0001\u0000\u0000\u0000\u0240\u0242"+
		"\u0001\u0000\u0000\u0000\u0241\u023d\u0001\u0000\u0000\u0000\u0241\u023f"+
		"\u0001\u0000\u0000\u0000\u0242W\u0001\u0000\u0000\u0000\u0243\u0248\u0005"+
		"q\u0000\u0000\u0244\u0245\u0005f\u0000\u0000\u0245\u0247\u0005q\u0000"+
		"\u0000\u0246\u0244\u0001\u0000\u0000\u0000\u0247\u024a\u0001\u0000\u0000"+
		"\u0000\u0248\u0246\u0001\u0000\u0000\u0000\u0248\u0249\u0001\u0000\u0000"+
		"\u0000\u0249Y\u0001\u0000\u0000\u0000\u024a\u0248\u0001\u0000\u0000\u0000"+
		"\u024b\u024d\u0003<\u001e\u0000\u024c\u024e\u0003\\.\u0000\u024d\u024c"+
		"\u0001\u0000\u0000\u0000\u024d\u024e\u0001\u0000\u0000\u0000\u024e[\u0001"+
		"\u0000\u0000\u0000\u024f\u0255\u0003N\'\u0000\u0250\u0252\u0003N\'\u0000"+
		"\u0251\u0250\u0001\u0000\u0000\u0000\u0251\u0252\u0001\u0000\u0000\u0000"+
		"\u0252\u0253\u0001\u0000\u0000\u0000\u0253\u0255\u0003^/\u0000\u0254\u024f"+
		"\u0001\u0000\u0000\u0000\u0254\u0251\u0001\u0000\u0000\u0000\u0255]\u0001"+
		"\u0000\u0000\u0000\u0256\u0257\u0006/\uffff\uffff\u0000\u0257\u0258\u0005"+
		"j\u0000\u0000\u0258\u0259\u0003J%\u0000\u0259\u025a\u0005k\u0000\u0000"+
		"\u025a\u0288\u0001\u0000\u0000\u0000\u025b\u025c\n\u0006\u0000\u0000\u025c"+
		"\u025e\u0005h\u0000\u0000\u025d\u025f\u0003P(\u0000\u025e\u025d\u0001"+
		"\u0000\u0000\u0000\u025e\u025f\u0001\u0000\u0000\u0000\u025f\u0261\u0001"+
		"\u0000\u0000\u0000\u0260\u0262\u0003\"\u0011\u0000\u0261\u0260\u0001\u0000"+
		"\u0000\u0000\u0261\u0262\u0001\u0000\u0000\u0000\u0262\u0263\u0001\u0000"+
		"\u0000\u0000\u0263\u0287\u0005i\u0000\u0000\u0264\u0265\n\u0005\u0000"+
		"\u0000\u0265\u0266\u0005h\u0000\u0000\u0266\u0268\u0005\u001a\u0000\u0000"+
		"\u0267\u0269\u0003P(\u0000\u0268\u0267\u0001\u0000\u0000\u0000\u0268\u0269"+
		"\u0001\u0000\u0000\u0000\u0269\u026a\u0001\u0000\u0000\u0000\u026a\u026b"+
		"\u0003\"\u0011\u0000\u026b\u026c\u0005i\u0000\u0000\u026c\u0287\u0001"+
		"\u0000\u0000\u0000\u026d\u026e\n\u0004\u0000\u0000\u026e\u026f\u0005h"+
		"\u0000\u0000\u026f\u0270\u0003P(\u0000\u0270\u0271\u0005\u001a\u0000\u0000"+
		"\u0271\u0272\u0003\"\u0011\u0000\u0272\u0273\u0005i\u0000\u0000\u0273"+
		"\u0287\u0001\u0000\u0000\u0000\u0274\u0275\n\u0003\u0000\u0000\u0275\u0277"+
		"\u0005h\u0000\u0000\u0276\u0278\u0003P(\u0000\u0277\u0276\u0001\u0000"+
		"\u0000\u0000\u0277\u0278\u0001\u0000\u0000\u0000\u0278\u0279\u0001\u0000"+
		"\u0000\u0000\u0279\u027a\u0005X\u0000\u0000\u027a\u0287\u0005i\u0000\u0000"+
		"\u027b\u027c\n\u0002\u0000\u0000\u027c\u027d\u0005j\u0000\u0000\u027d"+
		"\u027e\u0003R)\u0000\u027e\u027f\u0005k\u0000\u0000\u027f\u0287\u0001"+
		"\u0000\u0000\u0000\u0280\u0281\n\u0001\u0000\u0000\u0281\u0283\u0005j"+
		"\u0000\u0000\u0282\u0284\u0003X,\u0000\u0283\u0282\u0001\u0000\u0000\u0000"+
		"\u0283\u0284\u0001\u0000\u0000\u0000\u0284\u0285\u0001\u0000\u0000\u0000"+
		"\u0285\u0287\u0005k\u0000\u0000\u0286\u025b\u0001\u0000\u0000\u0000\u0286"+
		"\u0264\u0001\u0000\u0000\u0000\u0286\u026d\u0001\u0000\u0000\u0000\u0286"+
		"\u0274\u0001\u0000\u0000\u0000\u0286\u027b\u0001\u0000\u0000\u0000\u0286"+
		"\u0280\u0001\u0000\u0000\u0000\u0287\u028a\u0001\u0000\u0000\u0000\u0288"+
		"\u0286\u0001\u0000\u0000\u0000\u0288\u0289\u0001\u0000\u0000\u0000\u0289"+
		"_\u0001\u0000\u0000\u0000\u028a\u0288\u0001\u0000\u0000\u0000\u028b\u028c"+
		"\u0005q\u0000\u0000\u028ca\u0001\u0000\u0000\u0000\u028d\u0296\u0003\""+
		"\u0011\u0000\u028e\u028f\u0005l\u0000\u0000\u028f\u0291\u0003d2\u0000"+
		"\u0290\u0292\u0005f\u0000\u0000\u0291\u0290\u0001\u0000\u0000\u0000\u0291"+
		"\u0292\u0001\u0000\u0000\u0000\u0292\u0293\u0001\u0000\u0000\u0000\u0293"+
		"\u0294\u0005m\u0000\u0000\u0294\u0296\u0001\u0000\u0000\u0000\u0295\u028d"+
		"\u0001\u0000\u0000\u0000\u0295\u028e\u0001\u0000\u0000\u0000\u0296c\u0001"+
		"\u0000\u0000\u0000\u0297\u0299\u0003f3\u0000\u0298\u0297\u0001\u0000\u0000"+
		"\u0000\u0298\u0299\u0001\u0000\u0000\u0000\u0299\u029a\u0001\u0000\u0000"+
		"\u0000\u029a\u02a2\u0003b1\u0000\u029b\u029d\u0005f\u0000\u0000\u029c"+
		"\u029e\u0003f3\u0000\u029d\u029c\u0001\u0000\u0000\u0000\u029d\u029e\u0001"+
		"\u0000\u0000\u0000\u029e\u029f\u0001\u0000\u0000\u0000\u029f\u02a1\u0003"+
		"b1\u0000\u02a0\u029b\u0001\u0000\u0000\u0000\u02a1\u02a4\u0001\u0000\u0000"+
		"\u0000\u02a2\u02a0\u0001\u0000\u0000\u0000\u02a2\u02a3\u0001\u0000\u0000"+
		"\u0000\u02a3e\u0001\u0000\u0000\u0000\u02a4\u02a2\u0001\u0000\u0000\u0000"+
		"\u02a5\u02a6\u0003h4\u0000\u02a6\u02a7\u0005e\u0000\u0000\u02a7g\u0001"+
		"\u0000\u0000\u0000\u02a8\u02aa\u0003j5\u0000\u02a9\u02a8\u0001\u0000\u0000"+
		"\u0000\u02aa\u02ab\u0001\u0000\u0000\u0000\u02ab\u02a9\u0001\u0000\u0000"+
		"\u0000\u02ab\u02ac\u0001\u0000\u0000\u0000\u02aci\u0001\u0000\u0000\u0000"+
		"\u02ad\u02ae\u0005h\u0000\u0000\u02ae\u02af\u0003&\u0013\u0000\u02af\u02b0"+
		"\u0005i\u0000\u0000\u02b0\u02b4\u0001\u0000\u0000\u0000\u02b1\u02b2\u0005"+
		"c\u0000\u0000\u02b2\u02b4\u0005q\u0000\u0000\u02b3\u02ad\u0001\u0000\u0000"+
		"\u0000\u02b3\u02b1\u0001\u0000\u0000\u0000\u02b4k\u0001\u0000\u0000\u0000"+
		"\u02b5\u02b6\u0005U\u0000\u0000\u02b6\u02b7\u0003X,\u0000\u02b7\u02b8"+
		"\u0005V\u0000\u0000\u02b8m\u0001\u0000\u0000\u0000\u02b9\u02c1\u0003\u0080"+
		"@\u0000\u02ba\u02c1\u0003p8\u0000\u02bb\u02c1\u0003r9\u0000\u02bc\u02c1"+
		"\u0003x<\u0000\u02bd\u02c1\u0003z=\u0000\u02be\u02c1\u0003|>\u0000\u02bf"+
		"\u02c1\u0003~?\u0000\u02c0\u02b9\u0001\u0000\u0000\u0000\u02c0\u02ba\u0001"+
		"\u0000\u0000\u0000\u02c0\u02bb\u0001\u0000\u0000\u0000\u02c0\u02bc\u0001"+
		"\u0000\u0000\u0000\u02c0\u02bd\u0001\u0000\u0000\u0000\u02c0\u02be\u0001"+
		"\u0000\u0000\u0000\u02c0\u02bf\u0001\u0000\u0000\u0000\u02c1o\u0001\u0000"+
		"\u0000\u0000\u02c2\u02c3\u0005q\u0000\u0000\u02c3\u02c4\u0005a\u0000\u0000"+
		"\u02c4\u02ce\u0003n7\u0000\u02c5\u02c6\u0005\u0003\u0000\u0000\u02c6\u02c7"+
		"\u0003&\u0013\u0000\u02c7\u02c8\u0005a\u0000\u0000\u02c8\u02c9\u0003n"+
		"7\u0000\u02c9\u02ce\u0001\u0000\u0000\u0000\u02ca\u02cb\u0005\u0007\u0000"+
		"\u0000\u02cb\u02cc\u0005a\u0000\u0000\u02cc\u02ce\u0003n7\u0000\u02cd"+
		"\u02c2\u0001\u0000\u0000\u0000\u02cd\u02c5\u0001\u0000\u0000\u0000\u02cd"+
		"\u02ca\u0001\u0000\u0000\u0000\u02ceq\u0001\u0000\u0000\u0000\u02cf\u02d1"+
		"\u0005l\u0000\u0000\u02d0\u02d2\u0003t:\u0000\u02d1\u02d0\u0001\u0000"+
		"\u0000\u0000\u02d1\u02d2\u0001\u0000\u0000\u0000\u02d2\u02d3\u0001\u0000"+
		"\u0000\u0000\u02d3\u02d4\u0005m\u0000\u0000\u02d4s\u0001\u0000\u0000\u0000"+
		"\u02d5\u02d7\u0003v;\u0000\u02d6\u02d5\u0001\u0000\u0000\u0000\u02d7\u02d8"+
		"\u0001\u0000\u0000\u0000\u02d8\u02d6\u0001\u0000\u0000\u0000\u02d8\u02d9"+
		"\u0001\u0000\u0000\u0000\u02d9u\u0001\u0000\u0000\u0000\u02da\u02dd\u0003"+
		"n7\u0000\u02db\u02dd\u0003(\u0014\u0000\u02dc\u02da\u0001\u0000\u0000"+
		"\u0000\u02dc\u02db\u0001\u0000\u0000\u0000\u02ddw\u0001\u0000\u0000\u0000"+
		"\u02de\u02e0\u0003$\u0012\u0000\u02df\u02de\u0001\u0000\u0000\u0000\u02df"+
		"\u02e0\u0001\u0000\u0000\u0000\u02e0\u02e1\u0001\u0000\u0000\u0000\u02e1"+
		"\u02e2\u0005b\u0000\u0000\u02e2y\u0001\u0000\u0000\u0000\u02e3\u02e4\u0005"+
		"\u0010\u0000\u0000\u02e4\u02e5\u0005j\u0000\u0000\u02e5\u02e6\u0003$\u0012"+
		"\u0000\u02e6\u02e7\u0005k\u0000\u0000\u02e7\u02e8\u0003n7\u0000\u02e8"+
		"\u02f8\u0001\u0000\u0000\u0000\u02e9\u02ea\u0005\u0010\u0000\u0000\u02ea"+
		"\u02eb\u0005j\u0000\u0000\u02eb\u02ec\u0003$\u0012\u0000\u02ec\u02ed\u0005"+
		"k\u0000\u0000\u02ed\u02ee\u0003n7\u0000\u02ee\u02ef\u0005\n\u0000\u0000"+
		"\u02ef\u02f0\u0003n7\u0000\u02f0\u02f8\u0001\u0000\u0000\u0000\u02f1\u02f2"+
		"\u0005\u001c\u0000\u0000\u02f2\u02f3\u0005j\u0000\u0000\u02f3\u02f4\u0003"+
		"$\u0012\u0000\u02f4\u02f5\u0005k\u0000\u0000\u02f5\u02f6\u0003n7\u0000"+
		"\u02f6\u02f8\u0001\u0000\u0000\u0000\u02f7\u02e3\u0001\u0000\u0000\u0000"+
		"\u02f7\u02e9\u0001\u0000\u0000\u0000\u02f7\u02f1\u0001\u0000\u0000\u0000"+
		"\u02f8{\u0001\u0000\u0000\u0000\u02f9\u02fa\u0005\"\u0000\u0000\u02fa"+
		"\u02fb\u0005j\u0000\u0000\u02fb\u02fc\u0003$\u0012\u0000\u02fc\u02fd\u0005"+
		"k\u0000\u0000\u02fd\u02fe\u0003n7\u0000\u02fe\u0324\u0001\u0000\u0000"+
		"\u0000\u02ff\u0300\u0005\b\u0000\u0000\u0300\u0301\u0003n7\u0000\u0301"+
		"\u0302\u0005\"\u0000\u0000\u0302\u0303\u0005j\u0000\u0000\u0303\u0304"+
		"\u0003$\u0012\u0000\u0304\u0305\u0005k\u0000\u0000\u0305\u0306\u0005b"+
		"\u0000\u0000\u0306\u0324\u0001\u0000\u0000\u0000\u0307\u0308\u0005\u000e"+
		"\u0000\u0000\u0308\u030a\u0005j\u0000\u0000\u0309\u030b\u0003$\u0012\u0000"+
		"\u030a\u0309\u0001\u0000\u0000\u0000\u030a\u030b\u0001\u0000\u0000\u0000"+
		"\u030b\u030c\u0001\u0000\u0000\u0000\u030c\u030e\u0005b\u0000\u0000\u030d"+
		"\u030f\u0003$\u0012\u0000\u030e\u030d\u0001\u0000\u0000\u0000\u030e\u030f"+
		"\u0001\u0000\u0000\u0000\u030f\u0310\u0001\u0000\u0000\u0000\u0310\u0312"+
		"\u0005b\u0000\u0000\u0311\u0313\u0003$\u0012\u0000\u0312\u0311\u0001\u0000"+
		"\u0000\u0000\u0312\u0313\u0001\u0000\u0000\u0000\u0313\u0314\u0001\u0000"+
		"\u0000\u0000\u0314\u0315\u0005k\u0000\u0000\u0315\u0324\u0003n7\u0000"+
		"\u0316\u0317\u0005\u000e\u0000\u0000\u0317\u0318\u0005j\u0000\u0000\u0318"+
		"\u031a\u0003(\u0014\u0000\u0319\u031b\u0003$\u0012\u0000\u031a\u0319\u0001"+
		"\u0000\u0000\u0000\u031a\u031b\u0001\u0000\u0000\u0000\u031b\u031c\u0001"+
		"\u0000\u0000\u0000\u031c\u031e\u0005b\u0000\u0000\u031d\u031f\u0003$\u0012"+
		"\u0000\u031e\u031d\u0001\u0000\u0000\u0000\u031e\u031f\u0001\u0000\u0000"+
		"\u0000\u031f\u0320\u0001\u0000\u0000\u0000\u0320\u0321\u0005k\u0000\u0000"+
		"\u0321\u0322\u0003n7\u0000\u0322\u0324\u0001\u0000\u0000\u0000\u0323\u02f9"+
		"\u0001\u0000\u0000\u0000\u0323\u02ff\u0001\u0000\u0000\u0000\u0323\u0307"+
		"\u0001\u0000\u0000\u0000\u0323\u0316\u0001\u0000\u0000\u0000\u0324}\u0001"+
		"\u0000\u0000\u0000\u0325\u0326\u0005\u000f\u0000\u0000\u0326\u0327\u0005"+
		"q\u0000\u0000\u0327\u0332\u0005b\u0000\u0000\u0328\u0329\u0005\u0006\u0000"+
		"\u0000\u0329\u0332\u0005b\u0000\u0000\u032a\u032b\u0005\u0002\u0000\u0000"+
		"\u032b\u0332\u0005b\u0000\u0000\u032c\u032e\u0005\u0016\u0000\u0000\u032d"+
		"\u032f\u0003$\u0012\u0000\u032e\u032d\u0001\u0000\u0000\u0000\u032e\u032f"+
		"\u0001\u0000\u0000\u0000\u032f\u0330\u0001\u0000\u0000\u0000\u0330\u0332"+
		"\u0005b\u0000\u0000\u0331\u0325\u0001\u0000\u0000\u0000\u0331\u0328\u0001"+
		"\u0000\u0000\u0000\u0331\u032a\u0001\u0000\u0000\u0000\u0331\u032c\u0001"+
		"\u0000\u0000\u0000\u0332\u007f\u0001\u0000\u0000\u0000\u0333\u0334\u0005"+
		"&\u0000\u0000\u0334\u0335\u0005j\u0000\u0000\u0335\u0336\u0005t\u0000"+
		"\u0000\u0336\u0337\u0005k\u0000\u0000\u0337\u0338\u0005b\u0000\u0000\u0338"+
		"\u0081\u0001\u0000\u0000\u0000\u0339\u033b\u0003\u0084B\u0000\u033a\u0339"+
		"\u0001\u0000\u0000\u0000\u033b\u033c\u0001\u0000\u0000\u0000\u033c\u033a"+
		"\u0001\u0000\u0000\u0000\u033c\u033d\u0001\u0000\u0000\u0000\u033d\u0083"+
		"\u0001\u0000\u0000\u0000\u033e\u0341\u0003\u0086C\u0000\u033f\u0341\u0003"+
		"(\u0014\u0000\u0340\u033e\u0001\u0000\u0000\u0000\u0340\u033f\u0001\u0000"+
		"\u0000\u0000\u0341\u0085\u0001\u0000\u0000\u0000\u0342\u0344\u0003l6\u0000"+
		"\u0343\u0342\u0001\u0000\u0000\u0000\u0344\u0347\u0001\u0000\u0000\u0000"+
		"\u0345\u0343\u0001\u0000\u0000\u0000\u0345\u0346\u0001\u0000\u0000\u0000"+
		"\u0346\u0348\u0001\u0000\u0000\u0000\u0347\u0345\u0001\u0000\u0000\u0000"+
		"\u0348\u0349\u0003*\u0015\u0000\u0349\u034b\u0003J%\u0000\u034a\u034c"+
		"\u0003\u0088D\u0000\u034b\u034a\u0001\u0000\u0000\u0000\u034b\u034c\u0001"+
		"\u0000\u0000\u0000\u034c\u034d\u0001\u0000\u0000\u0000\u034d\u034e\u0003"+
		"r9\u0000\u034e\u0087\u0001\u0000\u0000\u0000\u034f\u0351\u0003(\u0014"+
		"\u0000\u0350\u034f\u0001\u0000\u0000\u0000\u0351\u0352\u0001\u0000\u0000"+
		"\u0000\u0352\u0350\u0001\u0000\u0000\u0000\u0352\u0353\u0001\u0000\u0000"+
		"\u0000\u0353\u0089\u0001\u0000\u0000\u0000_\u0093\u009d\u00a1\u00ab\u00b8"+
		"\u00ba\u00c2\u00e4\u00ec\u00f6\u0101\u010c\u0117\u0122\u012d\u0138\u0143"+
		"\u014e\u0159\u0163\u016a\u0171\u0178\u0180\u0182\u018d\u0193\u0199\u019d"+
		"\u01a5\u01aa\u01b2\u01b5\u01bc\u01c1\u01c5\u01c9\u01ce\u01d4\u01db\u01e1"+
		"\u01e6\u01f0\u01f5\u01f8\u01ff\u020e\u021a\u021d\u021f\u0224\u0228\u022d"+
		"\u0232\u0239\u023f\u0241\u0248\u024d\u0251\u0254\u025e\u0261\u0268\u0277"+
		"\u0283\u0286\u0288\u0291\u0295\u0298\u029d\u02a2\u02ab\u02b3\u02c0\u02cd"+
		"\u02d1\u02d8\u02dc\u02df\u02f7\u030a\u030e\u0312\u031a\u031e\u0323\u032e"+
		"\u0331\u033c\u0340\u0345\u034b\u0352";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}