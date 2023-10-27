// Generated from D:/BBSnCC/src/Grammar/C99.g4 by ANTLR 4.13.1
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, T__74=75, T__75=76, T__76=77, T__77=78, T__78=79, T__79=80, 
		T__80=81, T__81=82, T__82=83, T__83=84, T__84=85, WS=86, Keyword=87, Identifier=88, 
		Constant=89, String_literal=90, Punctuator=91, Header_name=92, Pp_number=93, 
		Pp_token=94, Enumeration_constant=95;
	public static final int
		RULE_program = 0, RULE_primary_expression = 1, RULE_postfix_expression = 2, 
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
			"program", "primary_expression", "postfix_expression", "argument_expression_list", 
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
			null, "'('", "')'", "'['", "']'", "'.'", "'->'", "'++'", "'--'", "'{'", 
			"','", "'}'", "'&'", "'*'", "'+'", "'-'", "'~'", "'!'", "'sizeof'", "'/'", 
			"'%'", "'<<'", "'>>'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", 
			"'^'", "'|'", "'&&'", "'||'", "'?'", "':'", "'='", "'*='", "'/='", "'%='", 
			"'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "';'", "'typedef'", 
			"'extern'", "'static'", "'auto'", "'register'", "'inline'", "'void'", 
			"'char'", "'short'", "'int'", "'long'", "'float'", "'double'", "'signed'", 
			"'unsigned'", "'_Bool'", "'_Complex'", "'struct'", "'union'", "'enum'", 
			"'const'", "'restrict'", "'volatile'", "'...'", "'[['", "']]'", "'case'", 
			"'default'", "'if'", "'else'", "'switch'", "'while'", "'do'", "'for'", 
			"'goto'", "'continue'", "'break'", "'return'", "'asm'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "WS", "Keyword", "Identifier", "Constant", "String_literal", 
			"Punctuator", "Header_name", "Pp_number", "Pp_token", "Enumeration_constant"
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
	public static class ProgramContext extends ParserRuleContext {
		public Translation_unitContext translation_unit() {
			return getRuleContext(Translation_unitContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99Visitor ) return ((C99Visitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
			case T__0:
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				match(T__0);
				setState(144);
				expression();
				setState(145);
				match(T__1);
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
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public Initializer_listContext initializer_list() {
			return getRuleContext(Initializer_listContext.class,0);
		}
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Argument_expression_listContext argument_expression_list() {
			return getRuleContext(Argument_expression_listContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(C99Parser.Identifier, 0); }
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
				match(T__0);
				setState(152);
				type_name();
				setState(153);
				match(T__1);
				setState(154);
				match(T__8);
				setState(155);
				initializer_list();
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(156);
					match(T__9);
					}
				}

				setState(159);
				match(T__10);
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
						match(T__2);
						setState(165);
						expression();
						setState(166);
						match(T__3);
						}
						break;
					case 2:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(168);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(169);
						match(T__0);
						setState(171);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 520578L) != 0) || ((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & 7L) != 0)) {
							{
							setState(170);
							argument_expression_list();
							}
						}

						setState(173);
						match(T__1);
						}
						break;
					case 3:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(174);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(175);
						match(T__4);
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
						match(T__5);
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
						match(T__6);
						}
						break;
					case 6:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(182);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(183);
						match(T__7);
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
			while (_la==T__9) {
				{
				{
				setState(190);
				match(T__9);
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
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public Cast_expressionContext cast_expression() {
			return getRuleContext(Cast_expressionContext.class,0);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
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
			setState(211);
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
				match(T__6);
				setState(199);
				unary_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(200);
				match(T__7);
				setState(201);
				unary_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(202);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 258048L) != 0)) ) {
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
				match(T__17);
				setState(205);
				unary_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(206);
				match(T__17);
				setState(207);
				match(T__0);
				setState(208);
				type_name();
				setState(209);
				match(T__1);
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
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public Cast_expressionContext cast_expression() {
			return getRuleContext(Cast_expressionContext.class,0);
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
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				unary_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				match(T__0);
				setState(215);
				type_name();
				setState(216);
				match(T__1);
				setState(217);
				cast_expression();
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
			setState(222);
			cast_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(229);
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
					setState(224);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(225);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1581056L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(226);
					cast_expression();
					}
					} 
				}
				setState(231);
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
			setState(233);
			multiplicative_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(240);
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
					setState(235);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(236);
					_la = _input.LA(1);
					if ( !(_la==T__13 || _la==T__14) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(237);
					multiplicative_expression(0);
					}
					} 
				}
				setState(242);
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
			setState(244);
			additive_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(251);
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
					setState(246);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(247);
					_la = _input.LA(1);
					if ( !(_la==T__20 || _la==T__21) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(248);
					additive_expression(0);
					}
					} 
				}
				setState(253);
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
			setState(255);
			shift_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(262);
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
					setState(257);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(258);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 125829120L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(259);
					shift_expression(0);
					}
					} 
				}
				setState(264);
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
			setState(266);
			relational_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(273);
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
					setState(268);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(269);
					_la = _input.LA(1);
					if ( !(_la==T__26 || _la==T__27) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(270);
					relational_expression(0);
					}
					} 
				}
				setState(275);
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
			setState(277);
			equality_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(284);
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
					setState(279);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(280);
					match(T__11);
					setState(281);
					equality_expression(0);
					}
					} 
				}
				setState(286);
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
			setState(288);
			and_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(295);
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
					setState(290);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(291);
					match(T__28);
					setState(292);
					and_expression(0);
					}
					} 
				}
				setState(297);
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
			setState(299);
			xor_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(306);
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
					setState(301);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(302);
					match(T__29);
					setState(303);
					xor_expression(0);
					}
					} 
				}
				setState(308);
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
			setState(310);
			or_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(317);
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
					setState(312);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(313);
					match(T__30);
					setState(314);
					or_expression(0);
					}
					} 
				}
				setState(319);
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
			setState(321);
			land_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(328);
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
					setState(323);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(324);
					match(T__31);
					setState(325);
					land_expression(0);
					}
					} 
				}
				setState(330);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
			setState(338);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(331);
				lor_expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(332);
				lor_expression(0);
				setState(333);
				match(T__32);
				setState(334);
				expression();
				setState(335);
				match(T__33);
				setState(336);
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
			setState(345);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				conditional_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(341);
				unary_expression();
				setState(342);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 70334384439296L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(343);
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
			setState(347);
			assignment_expression();
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(348);
				match(T__9);
				setState(349);
				assignment_expression();
				}
				}
				setState(354);
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
			setState(355);
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
			setState(357);
			declaration_specifiers();
			setState(359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0 || _la==T__12 || _la==Identifier) {
				{
				setState(358);
				init_declarator_list();
				}
			}

			setState(361);
			match(T__45);
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
			setState(367); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					setState(367);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__46:
					case T__47:
					case T__48:
					case T__49:
					case T__50:
						{
						setState(363);
						storage_class_specifier();
						}
						break;
					case T__52:
					case T__53:
					case T__54:
					case T__55:
					case T__56:
					case T__57:
					case T__58:
					case T__59:
					case T__60:
					case T__61:
					case T__62:
					case T__63:
					case T__64:
					case T__65:
					case Identifier:
						{
						setState(364);
						type_specifier();
						}
						break;
					case T__66:
					case T__67:
					case T__68:
						{
						setState(365);
						type_qualifier();
						}
						break;
					case T__51:
						{
						setState(366);
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
				setState(369); 
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
			setState(371);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4362862139015168L) != 0)) ) {
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
			setState(373);
			match(T__51);
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
			setState(375);
			init_declarator();
			setState(380);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(376);
				match(T__9);
				setState(377);
				init_declarator();
				}
				}
				setState(382);
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
			setState(383);
			declarator();
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__34) {
				{
				setState(384);
				match(T__34);
				setState(385);
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
			setState(392);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__59:
			case T__60:
			case T__61:
			case T__62:
				enterOuterAlt(_localctx, 1);
				{
				setState(388);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -9007199254740992L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__63:
			case T__64:
				enterOuterAlt(_localctx, 2);
				{
				setState(389);
				struct_or_union_specifier();
				}
				break;
			case T__65:
				enterOuterAlt(_localctx, 3);
				{
				setState(390);
				enum_specifier();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 4);
				{
				setState(391);
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
		public Struct_declaration_listContext struct_declaration_list() {
			return getRuleContext(Struct_declaration_listContext.class,0);
		}
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
			setState(404);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(394);
				_la = _input.LA(1);
				if ( !(_la==T__63 || _la==T__64) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(395);
					match(Identifier);
					}
				}

				setState(398);
				match(T__8);
				setState(399);
				struct_declaration_list();
				setState(400);
				match(T__10);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(402);
				_la = _input.LA(1);
				if ( !(_la==T__63 || _la==T__64) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(403);
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
			setState(407); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(406);
				struct_declaration();
				}
				}
				setState(409); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 53)) & ~0x3f) == 0 && ((1L << (_la - 53)) & 34359869439L) != 0) );
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
			setState(411);
			specifier_qualifier_list();
			setState(412);
			struct_declarator_list();
			setState(413);
			match(T__45);
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
			setState(417);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__59:
			case T__60:
			case T__61:
			case T__62:
			case T__63:
			case T__64:
			case T__65:
			case Identifier:
				{
				setState(415);
				type_specifier();
				}
				break;
			case T__66:
			case T__67:
			case T__68:
				{
				setState(416);
				type_qualifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(420);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(419);
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
			setState(422);
			struct_declarator();
			setState(427);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(423);
				match(T__9);
				setState(424);
				struct_declarator();
				}
				}
				setState(429);
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
			setState(436);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(430);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(432);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0 || _la==T__12 || _la==Identifier) {
					{
					setState(431);
					declarator();
					}
				}

				setState(434);
				match(T__33);
				setState(435);
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
		public Enumerator_listContext enumerator_list() {
			return getRuleContext(Enumerator_listContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(C99Parser.Identifier, 0); }
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
			setState(451);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(438);
				match(T__65);
				setState(440);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(439);
					match(Identifier);
					}
				}

				setState(442);
				match(T__8);
				setState(443);
				enumerator_list();
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(444);
					match(T__9);
					}
				}

				setState(447);
				match(T__10);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(449);
				match(T__65);
				setState(450);
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
			setState(453);
			enumerator();
			setState(458);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(454);
					match(T__9);
					setState(455);
					enumerator();
					}
					} 
				}
				setState(460);
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
		public TerminalNode Enumeration_constant() { return getToken(C99Parser.Enumeration_constant, 0); }
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
			setState(461);
			match(Enumeration_constant);
			setState(464);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__34) {
				{
				setState(462);
				match(T__34);
				setState(463);
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
			setState(466);
			_la = _input.LA(1);
			if ( !(((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 7L) != 0)) ) {
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
			setState(469);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(468);
				pointer();
				}
			}

			setState(471);
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
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public Direct_declaratorContext direct_declarator() {
			return getRuleContext(Direct_declaratorContext.class,0);
		}
		public Type_qualifier_listContext type_qualifier_list() {
			return getRuleContext(Type_qualifier_listContext.class,0);
		}
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
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
			setState(479);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(474);
				match(Identifier);
				}
				break;
			case T__0:
				{
				setState(475);
				match(T__0);
				setState(476);
				declarator();
				setState(477);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(526);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(524);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
					case 1:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(481);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(482);
						match(T__2);
						setState(484);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 7L) != 0)) {
							{
							setState(483);
							type_qualifier_list();
							}
						}

						setState(487);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 520578L) != 0) || ((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & 7L) != 0)) {
							{
							setState(486);
							assignment_expression();
							}
						}

						setState(489);
						match(T__3);
						}
						break;
					case 2:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(490);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(491);
						match(T__2);
						setState(492);
						match(T__48);
						setState(494);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 7L) != 0)) {
							{
							setState(493);
							type_qualifier_list();
							}
						}

						setState(496);
						assignment_expression();
						setState(497);
						match(T__3);
						}
						break;
					case 3:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(499);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(500);
						match(T__2);
						setState(501);
						type_qualifier_list();
						setState(502);
						match(T__48);
						setState(503);
						assignment_expression();
						setState(504);
						match(T__3);
						}
						break;
					case 4:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(506);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(507);
						match(T__2);
						setState(509);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 7L) != 0)) {
							{
							setState(508);
							type_qualifier_list();
							}
						}

						setState(511);
						match(T__12);
						setState(512);
						match(T__3);
						}
						break;
					case 5:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(513);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(514);
						match(T__0);
						setState(515);
						parameter_type_list();
						setState(516);
						match(T__1);
						}
						break;
					case 6:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(518);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(519);
						match(T__0);
						setState(521);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==Identifier) {
							{
							setState(520);
							identifier_list();
							}
						}

						setState(523);
						match(T__1);
						}
						break;
					}
					} 
				}
				setState(528);
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
			setState(533); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(529);
				match(T__12);
				setState(531);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 7L) != 0)) {
					{
					setState(530);
					type_qualifier_list();
					}
				}

				}
				}
				setState(535); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__12 );
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
			setState(538); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(537);
				type_qualifier();
				}
				}
				setState(540); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 7L) != 0) );
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
			setState(542);
			parameter_list();
			setState(545);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(543);
				match(T__9);
				setState(544);
				match(T__69);
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
			setState(547);
			parameter_declaration();
			setState(552);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(548);
					match(T__9);
					setState(549);
					parameter_declaration();
					}
					} 
				}
				setState(554);
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
			setState(555);
			declaration_specifiers();
			setState(560);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(556);
				declarator();
				}
				break;
			case 2:
				{
				setState(558);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0 || _la==T__12) {
					{
					setState(557);
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
			setState(562);
			match(Identifier);
			setState(567);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(563);
				match(T__9);
				setState(564);
				match(Identifier);
				}
				}
				setState(569);
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
			setState(570);
			specifier_qualifier_list();
			setState(572);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0 || _la==T__12) {
				{
				setState(571);
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
			setState(579);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(574);
				pointer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(576);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(575);
					pointer();
					}
				}

				setState(578);
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
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public Direct_abstract_declaratorContext direct_abstract_declarator() {
			return getRuleContext(Direct_abstract_declaratorContext.class,0);
		}
		public Type_qualifier_listContext type_qualifier_list() {
			return getRuleContext(Type_qualifier_listContext.class,0);
		}
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
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
			setState(582);
			match(T__0);
			setState(583);
			declarator();
			setState(584);
			match(T__1);
			}
			_ctx.stop = _input.LT(-1);
			setState(631);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(629);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
					case 1:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(586);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(587);
						match(T__2);
						setState(589);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 7L) != 0)) {
							{
							setState(588);
							type_qualifier_list();
							}
						}

						setState(592);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 520578L) != 0) || ((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & 7L) != 0)) {
							{
							setState(591);
							assignment_expression();
							}
						}

						setState(594);
						match(T__3);
						}
						break;
					case 2:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(595);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(596);
						match(T__2);
						setState(597);
						match(T__48);
						setState(599);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 7L) != 0)) {
							{
							setState(598);
							type_qualifier_list();
							}
						}

						setState(601);
						assignment_expression();
						setState(602);
						match(T__3);
						}
						break;
					case 3:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(604);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(605);
						match(T__2);
						setState(606);
						type_qualifier_list();
						setState(607);
						match(T__48);
						setState(608);
						assignment_expression();
						setState(609);
						match(T__3);
						}
						break;
					case 4:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(611);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(612);
						match(T__2);
						setState(614);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 7L) != 0)) {
							{
							setState(613);
							type_qualifier_list();
							}
						}

						setState(616);
						match(T__12);
						setState(617);
						match(T__3);
						}
						break;
					case 5:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(618);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(619);
						match(T__0);
						setState(620);
						parameter_type_list();
						setState(621);
						match(T__1);
						}
						break;
					case 6:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(623);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(624);
						match(T__0);
						setState(626);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==Identifier) {
							{
							setState(625);
							identifier_list();
							}
						}

						setState(628);
						match(T__1);
						}
						break;
					}
					} 
				}
				setState(633);
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
			setState(634);
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
		public Initializer_listContext initializer_list() {
			return getRuleContext(Initializer_listContext.class,0);
		}
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
			setState(644);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__6:
			case T__7:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case Identifier:
			case Constant:
			case String_literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(636);
				assignment_expression();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(637);
				match(T__8);
				setState(638);
				initializer_list();
				setState(640);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(639);
					match(T__9);
					}
				}

				setState(642);
				match(T__10);
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
			setState(647);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2 || _la==T__4) {
				{
				setState(646);
				designation();
				}
			}

			setState(649);
			initializer();
			setState(655); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(650);
					match(T__9);
					setState(652);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2 || _la==T__4) {
						{
						setState(651);
						designation();
						}
					}

					setState(654);
					initializer();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(657); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
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
	public static class DesignationContext extends ParserRuleContext {
		public Designator_listContext designator_list() {
			return getRuleContext(Designator_listContext.class,0);
		}
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
			setState(659);
			designator_list();
			setState(660);
			match(T__34);
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
			setState(663); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(662);
				designator();
				}
				}
				setState(665); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==T__4 );
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
		public Constant_expressionContext constant_expression() {
			return getRuleContext(Constant_expressionContext.class,0);
		}
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
			setState(673);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(667);
				match(T__2);
				setState(668);
				constant_expression();
				setState(669);
				match(T__3);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(671);
				match(T__4);
				setState(672);
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
		public Identifier_listContext identifier_list() {
			return getRuleContext(Identifier_listContext.class,0);
		}
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
			setState(675);
			match(T__70);
			setState(676);
			identifier_list();
			setState(677);
			match(T__71);
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
		public Asm_statementContext asm_statement() {
			return getRuleContext(Asm_statementContext.class,0);
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
			setState(686);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(679);
				labeled_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(680);
				compound_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(681);
				expression_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(682);
				selection_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(683);
				iteration_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(684);
				jump_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(685);
				asm_statement();
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Constant_expressionContext constant_expression() {
			return getRuleContext(Constant_expressionContext.class,0);
		}
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
			setState(699);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(688);
				match(Identifier);
				setState(689);
				match(T__33);
				setState(690);
				statement();
				}
				break;
			case T__72:
				enterOuterAlt(_localctx, 2);
				{
				setState(691);
				match(T__72);
				setState(692);
				constant_expression();
				setState(693);
				match(T__33);
				setState(694);
				statement();
				}
				break;
			case T__73:
				enterOuterAlt(_localctx, 3);
				{
				setState(696);
				match(T__73);
				setState(697);
				match(T__33);
				setState(698);
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
			setState(701);
			match(T__8);
			setState(703);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -70368743656574L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 121630271L) != 0)) {
				{
				setState(702);
				block_item_list();
				}
			}

			setState(705);
			match(T__10);
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
			setState(708); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(707);
				block_item();
				}
				}
				setState(710); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -70368743656574L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 121630271L) != 0) );
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
			setState(714);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(712);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(713);
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
			setState(717);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 520578L) != 0) || ((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & 7L) != 0)) {
				{
				setState(716);
				expression();
				}
			}

			setState(719);
			match(T__45);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
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
			setState(741);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(721);
				match(T__74);
				setState(722);
				match(T__0);
				setState(723);
				expression();
				setState(724);
				match(T__1);
				setState(725);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(727);
				match(T__74);
				setState(728);
				match(T__0);
				setState(729);
				expression();
				setState(730);
				match(T__1);
				setState(731);
				statement();
				setState(732);
				match(T__75);
				setState(733);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(735);
				match(T__76);
				setState(736);
				match(T__0);
				setState(737);
				expression();
				setState(738);
				match(T__1);
				setState(739);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
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
			setState(785);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(743);
				match(T__77);
				setState(744);
				match(T__0);
				setState(745);
				expression();
				setState(746);
				match(T__1);
				setState(747);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(749);
				match(T__78);
				setState(750);
				statement();
				setState(751);
				match(T__77);
				setState(752);
				match(T__0);
				setState(753);
				expression();
				setState(754);
				match(T__1);
				setState(755);
				match(T__45);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(757);
				match(T__79);
				setState(758);
				match(T__0);
				setState(760);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 520578L) != 0) || ((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & 7L) != 0)) {
					{
					setState(759);
					expression();
					}
				}

				setState(762);
				match(T__45);
				setState(764);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 520578L) != 0) || ((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & 7L) != 0)) {
					{
					setState(763);
					expression();
					}
				}

				setState(766);
				match(T__45);
				setState(768);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 520578L) != 0) || ((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & 7L) != 0)) {
					{
					setState(767);
					expression();
					}
				}

				setState(770);
				match(T__1);
				setState(771);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(772);
				match(T__79);
				setState(773);
				match(T__0);
				setState(774);
				declaration();
				setState(776);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 520578L) != 0) || ((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & 7L) != 0)) {
					{
					setState(775);
					expression();
					}
				}

				setState(778);
				match(T__45);
				setState(780);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 520578L) != 0) || ((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & 7L) != 0)) {
					{
					setState(779);
					expression();
					}
				}

				setState(782);
				match(T__1);
				setState(783);
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
		public TerminalNode Identifier() { return getToken(C99Parser.Identifier, 0); }
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
			setState(799);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__80:
				enterOuterAlt(_localctx, 1);
				{
				setState(787);
				match(T__80);
				setState(788);
				match(Identifier);
				setState(789);
				match(T__45);
				}
				break;
			case T__81:
				enterOuterAlt(_localctx, 2);
				{
				setState(790);
				match(T__81);
				setState(791);
				match(T__45);
				}
				break;
			case T__82:
				enterOuterAlt(_localctx, 3);
				{
				setState(792);
				match(T__82);
				setState(793);
				match(T__45);
				}
				break;
			case T__83:
				enterOuterAlt(_localctx, 4);
				{
				setState(794);
				match(T__83);
				setState(796);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 520578L) != 0) || ((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & 7L) != 0)) {
					{
					setState(795);
					expression();
					}
				}

				setState(798);
				match(T__45);
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
		public TerminalNode String_literal() { return getToken(C99Parser.String_literal, 0); }
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
			setState(801);
			match(T__84);
			setState(802);
			match(T__0);
			setState(803);
			match(String_literal);
			setState(804);
			match(T__1);
			setState(805);
			match(T__45);
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
			setState(808); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(807);
				external_declaration();
				}
				}
				setState(810); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & 2199048421375L) != 0) );
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
			setState(814);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(812);
				function_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(813);
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
			setState(819);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__70) {
				{
				{
				setState(816);
				attributes_declaration();
				}
				}
				setState(821);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(822);
			declaration_specifiers();
			setState(823);
			declarator();
			setState(825);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & 2199031644159L) != 0)) {
				{
				setState(824);
				declaration_list();
				}
			}

			setState(827);
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
			setState(830); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(829);
				declaration();
				}
				}
				setState(832); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & 2199031644159L) != 0) );
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
		"\u0004\u0001_\u0343\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"\u00d4\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u00dc\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00e4\b\u0006\n\u0006"+
		"\f\u0006\u00e7\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u0007\u00ef\b\u0007\n\u0007\f\u0007\u00f2"+
		"\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00fa"+
		"\b\b\n\b\f\b\u00fd\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0005\t\u0105\b\t\n\t\f\t\u0108\t\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0005\n\u0110\b\n\n\n\f\n\u0113\t\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u011b\b\u000b"+
		"\n\u000b\f\u000b\u011e\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0005\f\u0126\b\f\n\f\f\f\u0129\t\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0005\r\u0131\b\r\n\r\f\r\u0134\t\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u013c"+
		"\b\u000e\n\u000e\f\u000e\u013f\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0147\b\u000f\n\u000f"+
		"\f\u000f\u014a\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0153\b\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u015a\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u015f\b\u0012\n\u0012"+
		"\f\u0012\u0162\t\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u0168\b\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0004\u0015\u0170\b\u0015\u000b\u0015\f\u0015"+
		"\u0171\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0005\u0018\u017b\b\u0018\n\u0018\f\u0018\u017e\t\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0183\b\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0189\b\u001a\u0001\u001b"+
		"\u0001\u001b\u0003\u001b\u018d\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0195\b\u001b\u0001\u001c"+
		"\u0004\u001c\u0198\b\u001c\u000b\u001c\f\u001c\u0199\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0003\u001e\u01a2"+
		"\b\u001e\u0001\u001e\u0003\u001e\u01a5\b\u001e\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0005\u001f\u01aa\b\u001f\n\u001f\f\u001f\u01ad\t\u001f\u0001"+
		" \u0001 \u0003 \u01b1\b \u0001 \u0001 \u0003 \u01b5\b \u0001!\u0001!\u0003"+
		"!\u01b9\b!\u0001!\u0001!\u0001!\u0003!\u01be\b!\u0001!\u0001!\u0001!\u0001"+
		"!\u0003!\u01c4\b!\u0001\"\u0001\"\u0001\"\u0005\"\u01c9\b\"\n\"\f\"\u01cc"+
		"\t\"\u0001#\u0001#\u0001#\u0003#\u01d1\b#\u0001$\u0001$\u0001%\u0003%"+
		"\u01d6\b%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0003"+
		"&\u01e0\b&\u0001&\u0001&\u0001&\u0003&\u01e5\b&\u0001&\u0003&\u01e8\b"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0003&\u01ef\b&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0003&\u01fe\b&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0003&\u020a\b&\u0001&\u0005&\u020d\b&\n&\f&\u0210\t&"+
		"\u0001\'\u0001\'\u0003\'\u0214\b\'\u0004\'\u0216\b\'\u000b\'\f\'\u0217"+
		"\u0001(\u0004(\u021b\b(\u000b(\f(\u021c\u0001)\u0001)\u0001)\u0003)\u0222"+
		"\b)\u0001*\u0001*\u0001*\u0005*\u0227\b*\n*\f*\u022a\t*\u0001+\u0001+"+
		"\u0001+\u0003+\u022f\b+\u0003+\u0231\b+\u0001,\u0001,\u0001,\u0005,\u0236"+
		"\b,\n,\f,\u0239\t,\u0001-\u0001-\u0003-\u023d\b-\u0001.\u0001.\u0003."+
		"\u0241\b.\u0001.\u0003.\u0244\b.\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0003/\u024e\b/\u0001/\u0003/\u0251\b/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0003/\u0258\b/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0003/\u0267\b/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0003"+
		"/\u0273\b/\u0001/\u0005/\u0276\b/\n/\f/\u0279\t/\u00010\u00010\u00011"+
		"\u00011\u00011\u00011\u00031\u0281\b1\u00011\u00011\u00031\u0285\b1\u0001"+
		"2\u00032\u0288\b2\u00012\u00012\u00012\u00032\u028d\b2\u00012\u00042\u0290"+
		"\b2\u000b2\f2\u0291\u00013\u00013\u00013\u00014\u00044\u0298\b4\u000b"+
		"4\f4\u0299\u00015\u00015\u00015\u00015\u00015\u00015\u00035\u02a2\b5\u0001"+
		"6\u00016\u00016\u00016\u00017\u00017\u00017\u00017\u00017\u00017\u0001"+
		"7\u00037\u02af\b7\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00038\u02bc\b8\u00019\u00019\u00039\u02c0\b9\u0001"+
		"9\u00019\u0001:\u0004:\u02c5\b:\u000b:\f:\u02c6\u0001;\u0001;\u0003;\u02cb"+
		"\b;\u0001<\u0003<\u02ce\b<\u0001<\u0001<\u0001=\u0001=\u0001=\u0001=\u0001"+
		"=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001"+
		"=\u0001=\u0001=\u0001=\u0001=\u0001=\u0003=\u02e6\b=\u0001>\u0001>\u0001"+
		">\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001"+
		">\u0001>\u0001>\u0001>\u0001>\u0003>\u02f9\b>\u0001>\u0001>\u0003>\u02fd"+
		"\b>\u0001>\u0001>\u0003>\u0301\b>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001"+
		">\u0003>\u0309\b>\u0001>\u0001>\u0003>\u030d\b>\u0001>\u0001>\u0001>\u0003"+
		">\u0312\b>\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001"+
		"?\u0003?\u031d\b?\u0001?\u0003?\u0320\b?\u0001@\u0001@\u0001@\u0001@\u0001"+
		"@\u0001@\u0001A\u0004A\u0329\bA\u000bA\fA\u032a\u0001B\u0001B\u0003B\u032f"+
		"\bB\u0001C\u0005C\u0332\bC\nC\fC\u0335\tC\u0001C\u0001C\u0001C\u0003C"+
		"\u033a\bC\u0001C\u0001C\u0001D\u0004D\u033f\bD\u000bD\fD\u0340\u0001D"+
		"\u0001\u0171\r\u0004\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001eL^E\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprt"+
		"vxz|~\u0080\u0082\u0084\u0086\u0088\u0000\u000b\u0001\u0000\f\u0011\u0002"+
		"\u0000\r\r\u0013\u0014\u0001\u0000\u000e\u000f\u0001\u0000\u0015\u0016"+
		"\u0001\u0000\u0017\u001a\u0001\u0000\u001b\u001c\u0001\u0000#-\u0001\u0000"+
		"/3\u0001\u00005?\u0001\u0000@A\u0001\u0000CE\u037d\u0000\u008a\u0001\u0000"+
		"\u0000\u0000\u0002\u0093\u0001\u0000\u0000\u0000\u0004\u00a1\u0001\u0000"+
		"\u0000\u0000\u0006\u00bd\u0001\u0000\u0000\u0000\b\u00d3\u0001\u0000\u0000"+
		"\u0000\n\u00db\u0001\u0000\u0000\u0000\f\u00dd\u0001\u0000\u0000\u0000"+
		"\u000e\u00e8\u0001\u0000\u0000\u0000\u0010\u00f3\u0001\u0000\u0000\u0000"+
		"\u0012\u00fe\u0001\u0000\u0000\u0000\u0014\u0109\u0001\u0000\u0000\u0000"+
		"\u0016\u0114\u0001\u0000\u0000\u0000\u0018\u011f\u0001\u0000\u0000\u0000"+
		"\u001a\u012a\u0001\u0000\u0000\u0000\u001c\u0135\u0001\u0000\u0000\u0000"+
		"\u001e\u0140\u0001\u0000\u0000\u0000 \u0152\u0001\u0000\u0000\u0000\""+
		"\u0159\u0001\u0000\u0000\u0000$\u015b\u0001\u0000\u0000\u0000&\u0163\u0001"+
		"\u0000\u0000\u0000(\u0165\u0001\u0000\u0000\u0000*\u016f\u0001\u0000\u0000"+
		"\u0000,\u0173\u0001\u0000\u0000\u0000.\u0175\u0001\u0000\u0000\u00000"+
		"\u0177\u0001\u0000\u0000\u00002\u017f\u0001\u0000\u0000\u00004\u0188\u0001"+
		"\u0000\u0000\u00006\u0194\u0001\u0000\u0000\u00008\u0197\u0001\u0000\u0000"+
		"\u0000:\u019b\u0001\u0000\u0000\u0000<\u01a1\u0001\u0000\u0000\u0000>"+
		"\u01a6\u0001\u0000\u0000\u0000@\u01b4\u0001\u0000\u0000\u0000B\u01c3\u0001"+
		"\u0000\u0000\u0000D\u01c5\u0001\u0000\u0000\u0000F\u01cd\u0001\u0000\u0000"+
		"\u0000H\u01d2\u0001\u0000\u0000\u0000J\u01d5\u0001\u0000\u0000\u0000L"+
		"\u01df\u0001\u0000\u0000\u0000N\u0215\u0001\u0000\u0000\u0000P\u021a\u0001"+
		"\u0000\u0000\u0000R\u021e\u0001\u0000\u0000\u0000T\u0223\u0001\u0000\u0000"+
		"\u0000V\u022b\u0001\u0000\u0000\u0000X\u0232\u0001\u0000\u0000\u0000Z"+
		"\u023a\u0001\u0000\u0000\u0000\\\u0243\u0001\u0000\u0000\u0000^\u0245"+
		"\u0001\u0000\u0000\u0000`\u027a\u0001\u0000\u0000\u0000b\u0284\u0001\u0000"+
		"\u0000\u0000d\u0287\u0001\u0000\u0000\u0000f\u0293\u0001\u0000\u0000\u0000"+
		"h\u0297\u0001\u0000\u0000\u0000j\u02a1\u0001\u0000\u0000\u0000l\u02a3"+
		"\u0001\u0000\u0000\u0000n\u02ae\u0001\u0000\u0000\u0000p\u02bb\u0001\u0000"+
		"\u0000\u0000r\u02bd\u0001\u0000\u0000\u0000t\u02c4\u0001\u0000\u0000\u0000"+
		"v\u02ca\u0001\u0000\u0000\u0000x\u02cd\u0001\u0000\u0000\u0000z\u02e5"+
		"\u0001\u0000\u0000\u0000|\u0311\u0001\u0000\u0000\u0000~\u031f\u0001\u0000"+
		"\u0000\u0000\u0080\u0321\u0001\u0000\u0000\u0000\u0082\u0328\u0001\u0000"+
		"\u0000\u0000\u0084\u032e\u0001\u0000\u0000\u0000\u0086\u0333\u0001\u0000"+
		"\u0000\u0000\u0088\u033e\u0001\u0000\u0000\u0000\u008a\u008b\u0003\u0082"+
		"A\u0000\u008b\u0001\u0001\u0000\u0000\u0000\u008c\u0094\u0005X\u0000\u0000"+
		"\u008d\u0094\u0005Y\u0000\u0000\u008e\u0094\u0005Z\u0000\u0000\u008f\u0090"+
		"\u0005\u0001\u0000\u0000\u0090\u0091\u0003$\u0012\u0000\u0091\u0092\u0005"+
		"\u0002\u0000\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093\u008c\u0001"+
		"\u0000\u0000\u0000\u0093\u008d\u0001\u0000\u0000\u0000\u0093\u008e\u0001"+
		"\u0000\u0000\u0000\u0093\u008f\u0001\u0000\u0000\u0000\u0094\u0003\u0001"+
		"\u0000\u0000\u0000\u0095\u0096\u0006\u0002\uffff\uffff\u0000\u0096\u00a2"+
		"\u0003\u0002\u0001\u0000\u0097\u0098\u0005\u0001\u0000\u0000\u0098\u0099"+
		"\u0003Z-\u0000\u0099\u009a\u0005\u0002\u0000\u0000\u009a\u009b\u0005\t"+
		"\u0000\u0000\u009b\u009d\u0003d2\u0000\u009c\u009e\u0005\n\u0000\u0000"+
		"\u009d\u009c\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u000b\u0000\u0000"+
		"\u00a0\u00a2\u0001\u0000\u0000\u0000\u00a1\u0095\u0001\u0000\u0000\u0000"+
		"\u00a1\u0097\u0001\u0000\u0000\u0000\u00a2\u00ba\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\n\u0007\u0000\u0000\u00a4\u00a5\u0005\u0003\u0000\u0000\u00a5"+
		"\u00a6\u0003$\u0012\u0000\u00a6\u00a7\u0005\u0004\u0000\u0000\u00a7\u00b9"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a9\n\u0006\u0000\u0000\u00a9\u00ab\u0005"+
		"\u0001\u0000\u0000\u00aa\u00ac\u0003\u0006\u0003\u0000\u00ab\u00aa\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001"+
		"\u0000\u0000\u0000\u00ad\u00b9\u0005\u0002\u0000\u0000\u00ae\u00af\n\u0005"+
		"\u0000\u0000\u00af\u00b0\u0005\u0005\u0000\u0000\u00b0\u00b9\u0005X\u0000"+
		"\u0000\u00b1\u00b2\n\u0004\u0000\u0000\u00b2\u00b3\u0005\u0006\u0000\u0000"+
		"\u00b3\u00b9\u0005X\u0000\u0000\u00b4\u00b5\n\u0003\u0000\u0000\u00b5"+
		"\u00b9\u0005\u0007\u0000\u0000\u00b6\u00b7\n\u0002\u0000\u0000\u00b7\u00b9"+
		"\u0005\b\u0000\u0000\u00b8\u00a3\u0001\u0000\u0000\u0000\u00b8\u00a8\u0001"+
		"\u0000\u0000\u0000\u00b8\u00ae\u0001\u0000\u0000\u0000\u00b8\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b4\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001"+
		"\u0000\u0000\u0000\u00b9\u00bc\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u0005\u0001"+
		"\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bd\u00c2\u0003"+
		"\"\u0011\u0000\u00be\u00bf\u0005\n\u0000\u0000\u00bf\u00c1\u0003\"\u0011"+
		"\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c1\u00c4\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000"+
		"\u0000\u00c3\u0007\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c5\u00d4\u0003\u0004\u0002\u0000\u00c6\u00c7\u0005\u0007\u0000"+
		"\u0000\u00c7\u00d4\u0003\b\u0004\u0000\u00c8\u00c9\u0005\b\u0000\u0000"+
		"\u00c9\u00d4\u0003\b\u0004\u0000\u00ca\u00cb\u0007\u0000\u0000\u0000\u00cb"+
		"\u00d4\u0003\n\u0005\u0000\u00cc\u00cd\u0005\u0012\u0000\u0000\u00cd\u00d4"+
		"\u0003\b\u0004\u0000\u00ce\u00cf\u0005\u0012\u0000\u0000\u00cf\u00d0\u0005"+
		"\u0001\u0000\u0000\u00d0\u00d1\u0003Z-\u0000\u00d1\u00d2\u0005\u0002\u0000"+
		"\u0000\u00d2\u00d4\u0001\u0000\u0000\u0000\u00d3\u00c5\u0001\u0000\u0000"+
		"\u0000\u00d3\u00c6\u0001\u0000\u0000\u0000\u00d3\u00c8\u0001\u0000\u0000"+
		"\u0000\u00d3\u00ca\u0001\u0000\u0000\u0000\u00d3\u00cc\u0001\u0000\u0000"+
		"\u0000\u00d3\u00ce\u0001\u0000\u0000\u0000\u00d4\t\u0001\u0000\u0000\u0000"+
		"\u00d5\u00dc\u0003\b\u0004\u0000\u00d6\u00d7\u0005\u0001\u0000\u0000\u00d7"+
		"\u00d8\u0003Z-\u0000\u00d8\u00d9\u0005\u0002\u0000\u0000\u00d9\u00da\u0003"+
		"\n\u0005\u0000\u00da\u00dc\u0001\u0000\u0000\u0000\u00db\u00d5\u0001\u0000"+
		"\u0000\u0000\u00db\u00d6\u0001\u0000\u0000\u0000\u00dc\u000b\u0001\u0000"+
		"\u0000\u0000\u00dd\u00de\u0006\u0006\uffff\uffff\u0000\u00de\u00df\u0003"+
		"\n\u0005\u0000\u00df\u00e5\u0001\u0000\u0000\u0000\u00e0\u00e1\n\u0001"+
		"\u0000\u0000\u00e1\u00e2\u0007\u0001\u0000\u0000\u00e2\u00e4\u0003\n\u0005"+
		"\u0000\u00e3\u00e0\u0001\u0000\u0000\u0000\u00e4\u00e7\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000"+
		"\u0000\u00e6\r\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e9\u0006\u0007\uffff\uffff\u0000\u00e9\u00ea\u0003\f\u0006\u0000"+
		"\u00ea\u00f0\u0001\u0000\u0000\u0000\u00eb\u00ec\n\u0001\u0000\u0000\u00ec"+
		"\u00ed\u0007\u0002\u0000\u0000\u00ed\u00ef\u0003\f\u0006\u0000\u00ee\u00eb"+
		"\u0001\u0000\u0000\u0000\u00ef\u00f2\u0001\u0000\u0000\u0000\u00f0\u00ee"+
		"\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u000f"+
		"\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f4"+
		"\u0006\b\uffff\uffff\u0000\u00f4\u00f5\u0003\u000e\u0007\u0000\u00f5\u00fb"+
		"\u0001\u0000\u0000\u0000\u00f6\u00f7\n\u0001\u0000\u0000\u00f7\u00f8\u0007"+
		"\u0003\u0000\u0000\u00f8\u00fa\u0003\u000e\u0007\u0000\u00f9\u00f6\u0001"+
		"\u0000\u0000\u0000\u00fa\u00fd\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001"+
		"\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u0011\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fe\u00ff\u0006"+
		"\t\uffff\uffff\u0000\u00ff\u0100\u0003\u0010\b\u0000\u0100\u0106\u0001"+
		"\u0000\u0000\u0000\u0101\u0102\n\u0001\u0000\u0000\u0102\u0103\u0007\u0004"+
		"\u0000\u0000\u0103\u0105\u0003\u0010\b\u0000\u0104\u0101\u0001\u0000\u0000"+
		"\u0000\u0105\u0108\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000"+
		"\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u0013\u0001\u0000\u0000"+
		"\u0000\u0108\u0106\u0001\u0000\u0000\u0000\u0109\u010a\u0006\n\uffff\uffff"+
		"\u0000\u010a\u010b\u0003\u0012\t\u0000\u010b\u0111\u0001\u0000\u0000\u0000"+
		"\u010c\u010d\n\u0001\u0000\u0000\u010d\u010e\u0007\u0005\u0000\u0000\u010e"+
		"\u0110\u0003\u0012\t\u0000\u010f\u010c\u0001\u0000\u0000\u0000\u0110\u0113"+
		"\u0001\u0000\u0000\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u0111\u0112"+
		"\u0001\u0000\u0000\u0000\u0112\u0015\u0001\u0000\u0000\u0000\u0113\u0111"+
		"\u0001\u0000\u0000\u0000\u0114\u0115\u0006\u000b\uffff\uffff\u0000\u0115"+
		"\u0116\u0003\u0014\n\u0000\u0116\u011c\u0001\u0000\u0000\u0000\u0117\u0118"+
		"\n\u0001\u0000\u0000\u0118\u0119\u0005\f\u0000\u0000\u0119\u011b\u0003"+
		"\u0014\n\u0000\u011a\u0117\u0001\u0000\u0000\u0000\u011b\u011e\u0001\u0000"+
		"\u0000\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000"+
		"\u0000\u0000\u011d\u0017\u0001\u0000\u0000\u0000\u011e\u011c\u0001\u0000"+
		"\u0000\u0000\u011f\u0120\u0006\f\uffff\uffff\u0000\u0120\u0121\u0003\u0016"+
		"\u000b\u0000\u0121\u0127\u0001\u0000\u0000\u0000\u0122\u0123\n\u0001\u0000"+
		"\u0000\u0123\u0124\u0005\u001d\u0000\u0000\u0124\u0126\u0003\u0016\u000b"+
		"\u0000\u0125\u0122\u0001\u0000\u0000\u0000\u0126\u0129\u0001\u0000\u0000"+
		"\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000"+
		"\u0000\u0128\u0019\u0001\u0000\u0000\u0000\u0129\u0127\u0001\u0000\u0000"+
		"\u0000\u012a\u012b\u0006\r\uffff\uffff\u0000\u012b\u012c\u0003\u0018\f"+
		"\u0000\u012c\u0132\u0001\u0000\u0000\u0000\u012d\u012e\n\u0001\u0000\u0000"+
		"\u012e\u012f\u0005\u001e\u0000\u0000\u012f\u0131\u0003\u0018\f\u0000\u0130"+
		"\u012d\u0001\u0000\u0000\u0000\u0131\u0134\u0001\u0000\u0000\u0000\u0132"+
		"\u0130\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000\u0000\u0000\u0133"+
		"\u001b\u0001\u0000\u0000\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0135"+
		"\u0136\u0006\u000e\uffff\uffff\u0000\u0136\u0137\u0003\u001a\r\u0000\u0137"+
		"\u013d\u0001\u0000\u0000\u0000\u0138\u0139\n\u0001\u0000\u0000\u0139\u013a"+
		"\u0005\u001f\u0000\u0000\u013a\u013c\u0003\u001a\r\u0000\u013b\u0138\u0001"+
		"\u0000\u0000\u0000\u013c\u013f\u0001\u0000\u0000\u0000\u013d\u013b\u0001"+
		"\u0000\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000\u013e\u001d\u0001"+
		"\u0000\u0000\u0000\u013f\u013d\u0001\u0000\u0000\u0000\u0140\u0141\u0006"+
		"\u000f\uffff\uffff\u0000\u0141\u0142\u0003\u001c\u000e\u0000\u0142\u0148"+
		"\u0001\u0000\u0000\u0000\u0143\u0144\n\u0001\u0000\u0000\u0144\u0145\u0005"+
		" \u0000\u0000\u0145\u0147\u0003\u001c\u000e\u0000\u0146\u0143\u0001\u0000"+
		"\u0000\u0000\u0147\u014a\u0001\u0000\u0000\u0000\u0148\u0146\u0001\u0000"+
		"\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u001f\u0001\u0000"+
		"\u0000\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014b\u0153\u0003\u001e"+
		"\u000f\u0000\u014c\u014d\u0003\u001e\u000f\u0000\u014d\u014e\u0005!\u0000"+
		"\u0000\u014e\u014f\u0003$\u0012\u0000\u014f\u0150\u0005\"\u0000\u0000"+
		"\u0150\u0151\u0003 \u0010\u0000\u0151\u0153\u0001\u0000\u0000\u0000\u0152"+
		"\u014b\u0001\u0000\u0000\u0000\u0152\u014c\u0001\u0000\u0000\u0000\u0153"+
		"!\u0001\u0000\u0000\u0000\u0154\u015a\u0003 \u0010\u0000\u0155\u0156\u0003"+
		"\b\u0004\u0000\u0156\u0157\u0007\u0006\u0000\u0000\u0157\u0158\u0003\""+
		"\u0011\u0000\u0158\u015a\u0001\u0000\u0000\u0000\u0159\u0154\u0001\u0000"+
		"\u0000\u0000\u0159\u0155\u0001\u0000\u0000\u0000\u015a#\u0001\u0000\u0000"+
		"\u0000\u015b\u0160\u0003\"\u0011\u0000\u015c\u015d\u0005\n\u0000\u0000"+
		"\u015d\u015f\u0003\"\u0011\u0000\u015e\u015c\u0001\u0000\u0000\u0000\u015f"+
		"\u0162\u0001\u0000\u0000\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0160"+
		"\u0161\u0001\u0000\u0000\u0000\u0161%\u0001\u0000\u0000\u0000\u0162\u0160"+
		"\u0001\u0000\u0000\u0000\u0163\u0164\u0003 \u0010\u0000\u0164\'\u0001"+
		"\u0000\u0000\u0000\u0165\u0167\u0003*\u0015\u0000\u0166\u0168\u00030\u0018"+
		"\u0000\u0167\u0166\u0001\u0000\u0000\u0000\u0167\u0168\u0001\u0000\u0000"+
		"\u0000\u0168\u0169\u0001\u0000\u0000\u0000\u0169\u016a\u0005.\u0000\u0000"+
		"\u016a)\u0001\u0000\u0000\u0000\u016b\u0170\u0003,\u0016\u0000\u016c\u0170"+
		"\u00034\u001a\u0000\u016d\u0170\u0003H$\u0000\u016e\u0170\u0003.\u0017"+
		"\u0000\u016f\u016b\u0001\u0000\u0000\u0000\u016f\u016c\u0001\u0000\u0000"+
		"\u0000\u016f\u016d\u0001\u0000\u0000\u0000\u016f\u016e\u0001\u0000\u0000"+
		"\u0000\u0170\u0171\u0001\u0000\u0000\u0000\u0171\u0172\u0001\u0000\u0000"+
		"\u0000\u0171\u016f\u0001\u0000\u0000\u0000\u0172+\u0001\u0000\u0000\u0000"+
		"\u0173\u0174\u0007\u0007\u0000\u0000\u0174-\u0001\u0000\u0000\u0000\u0175"+
		"\u0176\u00054\u0000\u0000\u0176/\u0001\u0000\u0000\u0000\u0177\u017c\u0003"+
		"2\u0019\u0000\u0178\u0179\u0005\n\u0000\u0000\u0179\u017b\u00032\u0019"+
		"\u0000\u017a\u0178\u0001\u0000\u0000\u0000\u017b\u017e\u0001\u0000\u0000"+
		"\u0000\u017c\u017a\u0001\u0000\u0000\u0000\u017c\u017d\u0001\u0000\u0000"+
		"\u0000\u017d1\u0001\u0000\u0000\u0000\u017e\u017c\u0001\u0000\u0000\u0000"+
		"\u017f\u0182\u0003J%\u0000\u0180\u0181\u0005#\u0000\u0000\u0181\u0183"+
		"\u0003b1\u0000\u0182\u0180\u0001\u0000\u0000\u0000\u0182\u0183\u0001\u0000"+
		"\u0000\u0000\u01833\u0001\u0000\u0000\u0000\u0184\u0189\u0007\b\u0000"+
		"\u0000\u0185\u0189\u00036\u001b\u0000\u0186\u0189\u0003B!\u0000\u0187"+
		"\u0189\u0003`0\u0000\u0188\u0184\u0001\u0000\u0000\u0000\u0188\u0185\u0001"+
		"\u0000\u0000\u0000\u0188\u0186\u0001\u0000\u0000\u0000\u0188\u0187\u0001"+
		"\u0000\u0000\u0000\u01895\u0001\u0000\u0000\u0000\u018a\u018c\u0007\t"+
		"\u0000\u0000\u018b\u018d\u0005X\u0000\u0000\u018c\u018b\u0001\u0000\u0000"+
		"\u0000\u018c\u018d\u0001\u0000\u0000\u0000\u018d\u018e\u0001\u0000\u0000"+
		"\u0000\u018e\u018f\u0005\t\u0000\u0000\u018f\u0190\u00038\u001c\u0000"+
		"\u0190\u0191\u0005\u000b\u0000\u0000\u0191\u0195\u0001\u0000\u0000\u0000"+
		"\u0192\u0193\u0007\t\u0000\u0000\u0193\u0195\u0005X\u0000\u0000\u0194"+
		"\u018a\u0001\u0000\u0000\u0000\u0194\u0192\u0001\u0000\u0000\u0000\u0195"+
		"7\u0001\u0000\u0000\u0000\u0196\u0198\u0003:\u001d\u0000\u0197\u0196\u0001"+
		"\u0000\u0000\u0000\u0198\u0199\u0001\u0000\u0000\u0000\u0199\u0197\u0001"+
		"\u0000\u0000\u0000\u0199\u019a\u0001\u0000\u0000\u0000\u019a9\u0001\u0000"+
		"\u0000\u0000\u019b\u019c\u0003<\u001e\u0000\u019c\u019d\u0003>\u001f\u0000"+
		"\u019d\u019e\u0005.\u0000\u0000\u019e;\u0001\u0000\u0000\u0000\u019f\u01a2"+
		"\u00034\u001a\u0000\u01a0\u01a2\u0003H$\u0000\u01a1\u019f\u0001\u0000"+
		"\u0000\u0000\u01a1\u01a0\u0001\u0000\u0000\u0000\u01a2\u01a4\u0001\u0000"+
		"\u0000\u0000\u01a3\u01a5\u0003<\u001e\u0000\u01a4\u01a3\u0001\u0000\u0000"+
		"\u0000\u01a4\u01a5\u0001\u0000\u0000\u0000\u01a5=\u0001\u0000\u0000\u0000"+
		"\u01a6\u01ab\u0003@ \u0000\u01a7\u01a8\u0005\n\u0000\u0000\u01a8\u01aa"+
		"\u0003@ \u0000\u01a9\u01a7\u0001\u0000\u0000\u0000\u01aa\u01ad\u0001\u0000"+
		"\u0000\u0000\u01ab\u01a9\u0001\u0000\u0000\u0000\u01ab\u01ac\u0001\u0000"+
		"\u0000\u0000\u01ac?\u0001\u0000\u0000\u0000\u01ad\u01ab\u0001\u0000\u0000"+
		"\u0000\u01ae\u01b5\u0003J%\u0000\u01af\u01b1\u0003J%\u0000\u01b0\u01af"+
		"\u0001\u0000\u0000\u0000\u01b0\u01b1\u0001\u0000\u0000\u0000\u01b1\u01b2"+
		"\u0001\u0000\u0000\u0000\u01b2\u01b3\u0005\"\u0000\u0000\u01b3\u01b5\u0003"+
		"&\u0013\u0000\u01b4\u01ae\u0001\u0000\u0000\u0000\u01b4\u01b0\u0001\u0000"+
		"\u0000\u0000\u01b5A\u0001\u0000\u0000\u0000\u01b6\u01b8\u0005B\u0000\u0000"+
		"\u01b7\u01b9\u0005X\u0000\u0000\u01b8\u01b7\u0001\u0000\u0000\u0000\u01b8"+
		"\u01b9\u0001\u0000\u0000\u0000\u01b9\u01ba\u0001\u0000\u0000\u0000\u01ba"+
		"\u01bb\u0005\t\u0000\u0000\u01bb\u01bd\u0003D\"\u0000\u01bc\u01be\u0005"+
		"\n\u0000\u0000\u01bd\u01bc\u0001\u0000\u0000\u0000\u01bd\u01be\u0001\u0000"+
		"\u0000\u0000\u01be\u01bf\u0001\u0000\u0000\u0000\u01bf\u01c0\u0005\u000b"+
		"\u0000\u0000\u01c0\u01c4\u0001\u0000\u0000\u0000\u01c1\u01c2\u0005B\u0000"+
		"\u0000\u01c2\u01c4\u0005X\u0000\u0000\u01c3\u01b6\u0001\u0000\u0000\u0000"+
		"\u01c3\u01c1\u0001\u0000\u0000\u0000\u01c4C\u0001\u0000\u0000\u0000\u01c5"+
		"\u01ca\u0003F#\u0000\u01c6\u01c7\u0005\n\u0000\u0000\u01c7\u01c9\u0003"+
		"F#\u0000\u01c8\u01c6\u0001\u0000\u0000\u0000\u01c9\u01cc\u0001\u0000\u0000"+
		"\u0000\u01ca\u01c8\u0001\u0000\u0000\u0000\u01ca\u01cb\u0001\u0000\u0000"+
		"\u0000\u01cbE\u0001\u0000\u0000\u0000\u01cc\u01ca\u0001\u0000\u0000\u0000"+
		"\u01cd\u01d0\u0005_\u0000\u0000\u01ce\u01cf\u0005#\u0000\u0000\u01cf\u01d1"+
		"\u0003&\u0013\u0000\u01d0\u01ce\u0001\u0000\u0000\u0000\u01d0\u01d1\u0001"+
		"\u0000\u0000\u0000\u01d1G\u0001\u0000\u0000\u0000\u01d2\u01d3\u0007\n"+
		"\u0000\u0000\u01d3I\u0001\u0000\u0000\u0000\u01d4\u01d6\u0003N\'\u0000"+
		"\u01d5\u01d4\u0001\u0000\u0000\u0000\u01d5\u01d6\u0001\u0000\u0000\u0000"+
		"\u01d6\u01d7\u0001\u0000\u0000\u0000\u01d7\u01d8\u0003L&\u0000\u01d8K"+
		"\u0001\u0000\u0000\u0000\u01d9\u01da\u0006&\uffff\uffff\u0000\u01da\u01e0"+
		"\u0005X\u0000\u0000\u01db\u01dc\u0005\u0001\u0000\u0000\u01dc\u01dd\u0003"+
		"J%\u0000\u01dd\u01de\u0005\u0002\u0000\u0000\u01de\u01e0\u0001\u0000\u0000"+
		"\u0000\u01df\u01d9\u0001\u0000\u0000\u0000\u01df\u01db\u0001\u0000\u0000"+
		"\u0000\u01e0\u020e\u0001\u0000\u0000\u0000\u01e1\u01e2\n\u0006\u0000\u0000"+
		"\u01e2\u01e4\u0005\u0003\u0000\u0000\u01e3\u01e5\u0003P(\u0000\u01e4\u01e3"+
		"\u0001\u0000\u0000\u0000\u01e4\u01e5\u0001\u0000\u0000\u0000\u01e5\u01e7"+
		"\u0001\u0000\u0000\u0000\u01e6\u01e8\u0003\"\u0011\u0000\u01e7\u01e6\u0001"+
		"\u0000\u0000\u0000\u01e7\u01e8\u0001\u0000\u0000\u0000\u01e8\u01e9\u0001"+
		"\u0000\u0000\u0000\u01e9\u020d\u0005\u0004\u0000\u0000\u01ea\u01eb\n\u0005"+
		"\u0000\u0000\u01eb\u01ec\u0005\u0003\u0000\u0000\u01ec\u01ee\u00051\u0000"+
		"\u0000\u01ed\u01ef\u0003P(\u0000\u01ee\u01ed\u0001\u0000\u0000\u0000\u01ee"+
		"\u01ef\u0001\u0000\u0000\u0000\u01ef\u01f0\u0001\u0000\u0000\u0000\u01f0"+
		"\u01f1\u0003\"\u0011\u0000\u01f1\u01f2\u0005\u0004\u0000\u0000\u01f2\u020d"+
		"\u0001\u0000\u0000\u0000\u01f3\u01f4\n\u0004\u0000\u0000\u01f4\u01f5\u0005"+
		"\u0003\u0000\u0000\u01f5\u01f6\u0003P(\u0000\u01f6\u01f7\u00051\u0000"+
		"\u0000\u01f7\u01f8\u0003\"\u0011\u0000\u01f8\u01f9\u0005\u0004\u0000\u0000"+
		"\u01f9\u020d\u0001\u0000\u0000\u0000\u01fa\u01fb\n\u0003\u0000\u0000\u01fb"+
		"\u01fd\u0005\u0003\u0000\u0000\u01fc\u01fe\u0003P(\u0000\u01fd\u01fc\u0001"+
		"\u0000\u0000\u0000\u01fd\u01fe\u0001\u0000\u0000\u0000\u01fe\u01ff\u0001"+
		"\u0000\u0000\u0000\u01ff\u0200\u0005\r\u0000\u0000\u0200\u020d\u0005\u0004"+
		"\u0000\u0000\u0201\u0202\n\u0002\u0000\u0000\u0202\u0203\u0005\u0001\u0000"+
		"\u0000\u0203\u0204\u0003R)\u0000\u0204\u0205\u0005\u0002\u0000\u0000\u0205"+
		"\u020d\u0001\u0000\u0000\u0000\u0206\u0207\n\u0001\u0000\u0000\u0207\u0209"+
		"\u0005\u0001\u0000\u0000\u0208\u020a\u0003X,\u0000\u0209\u0208\u0001\u0000"+
		"\u0000\u0000\u0209\u020a\u0001\u0000\u0000\u0000\u020a\u020b\u0001\u0000"+
		"\u0000\u0000\u020b\u020d\u0005\u0002\u0000\u0000\u020c\u01e1\u0001\u0000"+
		"\u0000\u0000\u020c\u01ea\u0001\u0000\u0000\u0000\u020c\u01f3\u0001\u0000"+
		"\u0000\u0000\u020c\u01fa\u0001\u0000\u0000\u0000\u020c\u0201\u0001\u0000"+
		"\u0000\u0000\u020c\u0206\u0001\u0000\u0000\u0000\u020d\u0210\u0001\u0000"+
		"\u0000\u0000\u020e\u020c\u0001\u0000\u0000\u0000\u020e\u020f\u0001\u0000"+
		"\u0000\u0000\u020fM\u0001\u0000\u0000\u0000\u0210\u020e\u0001\u0000\u0000"+
		"\u0000\u0211\u0213\u0005\r\u0000\u0000\u0212\u0214\u0003P(\u0000\u0213"+
		"\u0212\u0001\u0000\u0000\u0000\u0213\u0214\u0001\u0000\u0000\u0000\u0214"+
		"\u0216\u0001\u0000\u0000\u0000\u0215\u0211\u0001\u0000\u0000\u0000\u0216"+
		"\u0217\u0001\u0000\u0000\u0000\u0217\u0215\u0001\u0000\u0000\u0000\u0217"+
		"\u0218\u0001\u0000\u0000\u0000\u0218O\u0001\u0000\u0000\u0000\u0219\u021b"+
		"\u0003H$\u0000\u021a\u0219\u0001\u0000\u0000\u0000\u021b\u021c\u0001\u0000"+
		"\u0000\u0000\u021c\u021a\u0001\u0000\u0000\u0000\u021c\u021d\u0001\u0000"+
		"\u0000\u0000\u021dQ\u0001\u0000\u0000\u0000\u021e\u0221\u0003T*\u0000"+
		"\u021f\u0220\u0005\n\u0000\u0000\u0220\u0222\u0005F\u0000\u0000\u0221"+
		"\u021f\u0001\u0000\u0000\u0000\u0221\u0222\u0001\u0000\u0000\u0000\u0222"+
		"S\u0001\u0000\u0000\u0000\u0223\u0228\u0003V+\u0000\u0224\u0225\u0005"+
		"\n\u0000\u0000\u0225\u0227\u0003V+\u0000\u0226\u0224\u0001\u0000\u0000"+
		"\u0000\u0227\u022a\u0001\u0000\u0000\u0000\u0228\u0226\u0001\u0000\u0000"+
		"\u0000\u0228\u0229\u0001\u0000\u0000\u0000\u0229U\u0001\u0000\u0000\u0000"+
		"\u022a\u0228\u0001\u0000\u0000\u0000\u022b\u0230\u0003*\u0015\u0000\u022c"+
		"\u0231\u0003J%\u0000\u022d\u022f\u0003\\.\u0000\u022e\u022d\u0001\u0000"+
		"\u0000\u0000\u022e\u022f\u0001\u0000\u0000\u0000\u022f\u0231\u0001\u0000"+
		"\u0000\u0000\u0230\u022c\u0001\u0000\u0000\u0000\u0230\u022e\u0001\u0000"+
		"\u0000\u0000\u0231W\u0001\u0000\u0000\u0000\u0232\u0237\u0005X\u0000\u0000"+
		"\u0233\u0234\u0005\n\u0000\u0000\u0234\u0236\u0005X\u0000\u0000\u0235"+
		"\u0233\u0001\u0000\u0000\u0000\u0236\u0239\u0001\u0000\u0000\u0000\u0237"+
		"\u0235\u0001\u0000\u0000\u0000\u0237\u0238\u0001\u0000\u0000\u0000\u0238"+
		"Y\u0001\u0000\u0000\u0000\u0239\u0237\u0001\u0000\u0000\u0000\u023a\u023c"+
		"\u0003<\u001e\u0000\u023b\u023d\u0003\\.\u0000\u023c\u023b\u0001\u0000"+
		"\u0000\u0000\u023c\u023d\u0001\u0000\u0000\u0000\u023d[\u0001\u0000\u0000"+
		"\u0000\u023e\u0244\u0003N\'\u0000\u023f\u0241\u0003N\'\u0000\u0240\u023f"+
		"\u0001\u0000\u0000\u0000\u0240\u0241\u0001\u0000\u0000\u0000\u0241\u0242"+
		"\u0001\u0000\u0000\u0000\u0242\u0244\u0003^/\u0000\u0243\u023e\u0001\u0000"+
		"\u0000\u0000\u0243\u0240\u0001\u0000\u0000\u0000\u0244]\u0001\u0000\u0000"+
		"\u0000\u0245\u0246\u0006/\uffff\uffff\u0000\u0246\u0247\u0005\u0001\u0000"+
		"\u0000\u0247\u0248\u0003J%\u0000\u0248\u0249\u0005\u0002\u0000\u0000\u0249"+
		"\u0277\u0001\u0000\u0000\u0000\u024a\u024b\n\u0006\u0000\u0000\u024b\u024d"+
		"\u0005\u0003\u0000\u0000\u024c\u024e\u0003P(\u0000\u024d\u024c\u0001\u0000"+
		"\u0000\u0000\u024d\u024e\u0001\u0000\u0000\u0000\u024e\u0250\u0001\u0000"+
		"\u0000\u0000\u024f\u0251\u0003\"\u0011\u0000\u0250\u024f\u0001\u0000\u0000"+
		"\u0000\u0250\u0251\u0001\u0000\u0000\u0000\u0251\u0252\u0001\u0000\u0000"+
		"\u0000\u0252\u0276\u0005\u0004\u0000\u0000\u0253\u0254\n\u0005\u0000\u0000"+
		"\u0254\u0255\u0005\u0003\u0000\u0000\u0255\u0257\u00051\u0000\u0000\u0256"+
		"\u0258\u0003P(\u0000\u0257\u0256\u0001\u0000\u0000\u0000\u0257\u0258\u0001"+
		"\u0000\u0000\u0000\u0258\u0259\u0001\u0000\u0000\u0000\u0259\u025a\u0003"+
		"\"\u0011\u0000\u025a\u025b\u0005\u0004\u0000\u0000\u025b\u0276\u0001\u0000"+
		"\u0000\u0000\u025c\u025d\n\u0004\u0000\u0000\u025d\u025e\u0005\u0003\u0000"+
		"\u0000\u025e\u025f\u0003P(\u0000\u025f\u0260\u00051\u0000\u0000\u0260"+
		"\u0261\u0003\"\u0011\u0000\u0261\u0262\u0005\u0004\u0000\u0000\u0262\u0276"+
		"\u0001\u0000\u0000\u0000\u0263\u0264\n\u0003\u0000\u0000\u0264\u0266\u0005"+
		"\u0003\u0000\u0000\u0265\u0267\u0003P(\u0000\u0266\u0265\u0001\u0000\u0000"+
		"\u0000\u0266\u0267\u0001\u0000\u0000\u0000\u0267\u0268\u0001\u0000\u0000"+
		"\u0000\u0268\u0269\u0005\r\u0000\u0000\u0269\u0276\u0005\u0004\u0000\u0000"+
		"\u026a\u026b\n\u0002\u0000\u0000\u026b\u026c\u0005\u0001\u0000\u0000\u026c"+
		"\u026d\u0003R)\u0000\u026d\u026e\u0005\u0002\u0000\u0000\u026e\u0276\u0001"+
		"\u0000\u0000\u0000\u026f\u0270\n\u0001\u0000\u0000\u0270\u0272\u0005\u0001"+
		"\u0000\u0000\u0271\u0273\u0003X,\u0000\u0272\u0271\u0001\u0000\u0000\u0000"+
		"\u0272\u0273\u0001\u0000\u0000\u0000\u0273\u0274\u0001\u0000\u0000\u0000"+
		"\u0274\u0276\u0005\u0002\u0000\u0000\u0275\u024a\u0001\u0000\u0000\u0000"+
		"\u0275\u0253\u0001\u0000\u0000\u0000\u0275\u025c\u0001\u0000\u0000\u0000"+
		"\u0275\u0263\u0001\u0000\u0000\u0000\u0275\u026a\u0001\u0000\u0000\u0000"+
		"\u0275\u026f\u0001\u0000\u0000\u0000\u0276\u0279\u0001\u0000\u0000\u0000"+
		"\u0277\u0275\u0001\u0000\u0000\u0000\u0277\u0278\u0001\u0000\u0000\u0000"+
		"\u0278_\u0001\u0000\u0000\u0000\u0279\u0277\u0001\u0000\u0000\u0000\u027a"+
		"\u027b\u0005X\u0000\u0000\u027ba\u0001\u0000\u0000\u0000\u027c\u0285\u0003"+
		"\"\u0011\u0000\u027d\u027e\u0005\t\u0000\u0000\u027e\u0280\u0003d2\u0000"+
		"\u027f\u0281\u0005\n\u0000\u0000\u0280\u027f\u0001\u0000\u0000\u0000\u0280"+
		"\u0281\u0001\u0000\u0000\u0000\u0281\u0282\u0001\u0000\u0000\u0000\u0282"+
		"\u0283\u0005\u000b\u0000\u0000\u0283\u0285\u0001\u0000\u0000\u0000\u0284"+
		"\u027c\u0001\u0000\u0000\u0000\u0284\u027d\u0001\u0000\u0000\u0000\u0285"+
		"c\u0001\u0000\u0000\u0000\u0286\u0288\u0003f3\u0000\u0287\u0286\u0001"+
		"\u0000\u0000\u0000\u0287\u0288\u0001\u0000\u0000\u0000\u0288\u0289\u0001"+
		"\u0000\u0000\u0000\u0289\u028f\u0003b1\u0000\u028a\u028c\u0005\n\u0000"+
		"\u0000\u028b\u028d\u0003f3\u0000\u028c\u028b\u0001\u0000\u0000\u0000\u028c"+
		"\u028d\u0001\u0000\u0000\u0000\u028d\u028e\u0001\u0000\u0000\u0000\u028e"+
		"\u0290\u0003b1\u0000\u028f\u028a\u0001\u0000\u0000\u0000\u0290\u0291\u0001"+
		"\u0000\u0000\u0000\u0291\u028f\u0001\u0000\u0000\u0000\u0291\u0292\u0001"+
		"\u0000\u0000\u0000\u0292e\u0001\u0000\u0000\u0000\u0293\u0294\u0003h4"+
		"\u0000\u0294\u0295\u0005#\u0000\u0000\u0295g\u0001\u0000\u0000\u0000\u0296"+
		"\u0298\u0003j5\u0000\u0297\u0296\u0001\u0000\u0000\u0000\u0298\u0299\u0001"+
		"\u0000\u0000\u0000\u0299\u0297\u0001\u0000\u0000\u0000\u0299\u029a\u0001"+
		"\u0000\u0000\u0000\u029ai\u0001\u0000\u0000\u0000\u029b\u029c\u0005\u0003"+
		"\u0000\u0000\u029c\u029d\u0003&\u0013\u0000\u029d\u029e\u0005\u0004\u0000"+
		"\u0000\u029e\u02a2\u0001\u0000\u0000\u0000\u029f\u02a0\u0005\u0005\u0000"+
		"\u0000\u02a0\u02a2\u0005X\u0000\u0000\u02a1\u029b\u0001\u0000\u0000\u0000"+
		"\u02a1\u029f\u0001\u0000\u0000\u0000\u02a2k\u0001\u0000\u0000\u0000\u02a3"+
		"\u02a4\u0005G\u0000\u0000\u02a4\u02a5\u0003X,\u0000\u02a5\u02a6\u0005"+
		"H\u0000\u0000\u02a6m\u0001\u0000\u0000\u0000\u02a7\u02af\u0003p8\u0000"+
		"\u02a8\u02af\u0003r9\u0000\u02a9\u02af\u0003x<\u0000\u02aa\u02af\u0003"+
		"z=\u0000\u02ab\u02af\u0003|>\u0000\u02ac\u02af\u0003~?\u0000\u02ad\u02af"+
		"\u0003\u0080@\u0000\u02ae\u02a7\u0001\u0000\u0000\u0000\u02ae\u02a8\u0001"+
		"\u0000\u0000\u0000\u02ae\u02a9\u0001\u0000\u0000\u0000\u02ae\u02aa\u0001"+
		"\u0000\u0000\u0000\u02ae\u02ab\u0001\u0000\u0000\u0000\u02ae\u02ac\u0001"+
		"\u0000\u0000\u0000\u02ae\u02ad\u0001\u0000\u0000\u0000\u02afo\u0001\u0000"+
		"\u0000\u0000\u02b0\u02b1\u0005X\u0000\u0000\u02b1\u02b2\u0005\"\u0000"+
		"\u0000\u02b2\u02bc\u0003n7\u0000\u02b3\u02b4\u0005I\u0000\u0000\u02b4"+
		"\u02b5\u0003&\u0013\u0000\u02b5\u02b6\u0005\"\u0000\u0000\u02b6\u02b7"+
		"\u0003n7\u0000\u02b7\u02bc\u0001\u0000\u0000\u0000\u02b8\u02b9\u0005J"+
		"\u0000\u0000\u02b9\u02ba\u0005\"\u0000\u0000\u02ba\u02bc\u0003n7\u0000"+
		"\u02bb\u02b0\u0001\u0000\u0000\u0000\u02bb\u02b3\u0001\u0000\u0000\u0000"+
		"\u02bb\u02b8\u0001\u0000\u0000\u0000\u02bcq\u0001\u0000\u0000\u0000\u02bd"+
		"\u02bf\u0005\t\u0000\u0000\u02be\u02c0\u0003t:\u0000\u02bf\u02be\u0001"+
		"\u0000\u0000\u0000\u02bf\u02c0\u0001\u0000\u0000\u0000\u02c0\u02c1\u0001"+
		"\u0000\u0000\u0000\u02c1\u02c2\u0005\u000b\u0000\u0000\u02c2s\u0001\u0000"+
		"\u0000\u0000\u02c3\u02c5\u0003v;\u0000\u02c4\u02c3\u0001\u0000\u0000\u0000"+
		"\u02c5\u02c6\u0001\u0000\u0000\u0000\u02c6\u02c4\u0001\u0000\u0000\u0000"+
		"\u02c6\u02c7\u0001\u0000\u0000\u0000\u02c7u\u0001\u0000\u0000\u0000\u02c8"+
		"\u02cb\u0003n7\u0000\u02c9\u02cb\u0003(\u0014\u0000\u02ca\u02c8\u0001"+
		"\u0000\u0000\u0000\u02ca\u02c9\u0001\u0000\u0000\u0000\u02cbw\u0001\u0000"+
		"\u0000\u0000\u02cc\u02ce\u0003$\u0012\u0000\u02cd\u02cc\u0001\u0000\u0000"+
		"\u0000\u02cd\u02ce\u0001\u0000\u0000\u0000\u02ce\u02cf\u0001\u0000\u0000"+
		"\u0000\u02cf\u02d0\u0005.\u0000\u0000\u02d0y\u0001\u0000\u0000\u0000\u02d1"+
		"\u02d2\u0005K\u0000\u0000\u02d2\u02d3\u0005\u0001\u0000\u0000\u02d3\u02d4"+
		"\u0003$\u0012\u0000\u02d4\u02d5\u0005\u0002\u0000\u0000\u02d5\u02d6\u0003"+
		"n7\u0000\u02d6\u02e6\u0001\u0000\u0000\u0000\u02d7\u02d8\u0005K\u0000"+
		"\u0000\u02d8\u02d9\u0005\u0001\u0000\u0000\u02d9\u02da\u0003$\u0012\u0000"+
		"\u02da\u02db\u0005\u0002\u0000\u0000\u02db\u02dc\u0003n7\u0000\u02dc\u02dd"+
		"\u0005L\u0000\u0000\u02dd\u02de\u0003n7\u0000\u02de\u02e6\u0001\u0000"+
		"\u0000\u0000\u02df\u02e0\u0005M\u0000\u0000\u02e0\u02e1\u0005\u0001\u0000"+
		"\u0000\u02e1\u02e2\u0003$\u0012\u0000\u02e2\u02e3\u0005\u0002\u0000\u0000"+
		"\u02e3\u02e4\u0003n7\u0000\u02e4\u02e6\u0001\u0000\u0000\u0000\u02e5\u02d1"+
		"\u0001\u0000\u0000\u0000\u02e5\u02d7\u0001\u0000\u0000\u0000\u02e5\u02df"+
		"\u0001\u0000\u0000\u0000\u02e6{\u0001\u0000\u0000\u0000\u02e7\u02e8\u0005"+
		"N\u0000\u0000\u02e8\u02e9\u0005\u0001\u0000\u0000\u02e9\u02ea\u0003$\u0012"+
		"\u0000\u02ea\u02eb\u0005\u0002\u0000\u0000\u02eb\u02ec\u0003n7\u0000\u02ec"+
		"\u0312\u0001\u0000\u0000\u0000\u02ed\u02ee\u0005O\u0000\u0000\u02ee\u02ef"+
		"\u0003n7\u0000\u02ef\u02f0\u0005N\u0000\u0000\u02f0\u02f1\u0005\u0001"+
		"\u0000\u0000\u02f1\u02f2\u0003$\u0012\u0000\u02f2\u02f3\u0005\u0002\u0000"+
		"\u0000\u02f3\u02f4\u0005.\u0000\u0000\u02f4\u0312\u0001\u0000\u0000\u0000"+
		"\u02f5\u02f6\u0005P\u0000\u0000\u02f6\u02f8\u0005\u0001\u0000\u0000\u02f7"+
		"\u02f9\u0003$\u0012\u0000\u02f8\u02f7\u0001\u0000\u0000\u0000\u02f8\u02f9"+
		"\u0001\u0000\u0000\u0000\u02f9\u02fa\u0001\u0000\u0000\u0000\u02fa\u02fc"+
		"\u0005.\u0000\u0000\u02fb\u02fd\u0003$\u0012\u0000\u02fc\u02fb\u0001\u0000"+
		"\u0000\u0000\u02fc\u02fd\u0001\u0000\u0000\u0000\u02fd\u02fe\u0001\u0000"+
		"\u0000\u0000\u02fe\u0300\u0005.\u0000\u0000\u02ff\u0301\u0003$\u0012\u0000"+
		"\u0300\u02ff\u0001\u0000\u0000\u0000\u0300\u0301\u0001\u0000\u0000\u0000"+
		"\u0301\u0302\u0001\u0000\u0000\u0000\u0302\u0303\u0005\u0002\u0000\u0000"+
		"\u0303\u0312\u0003n7\u0000\u0304\u0305\u0005P\u0000\u0000\u0305\u0306"+
		"\u0005\u0001\u0000\u0000\u0306\u0308\u0003(\u0014\u0000\u0307\u0309\u0003"+
		"$\u0012\u0000\u0308\u0307\u0001\u0000\u0000\u0000\u0308\u0309\u0001\u0000"+
		"\u0000\u0000\u0309\u030a\u0001\u0000\u0000\u0000\u030a\u030c\u0005.\u0000"+
		"\u0000\u030b\u030d\u0003$\u0012\u0000\u030c\u030b\u0001\u0000\u0000\u0000"+
		"\u030c\u030d\u0001\u0000\u0000\u0000\u030d\u030e\u0001\u0000\u0000\u0000"+
		"\u030e\u030f\u0005\u0002\u0000\u0000\u030f\u0310\u0003n7\u0000\u0310\u0312"+
		"\u0001\u0000\u0000\u0000\u0311\u02e7\u0001\u0000\u0000\u0000\u0311\u02ed"+
		"\u0001\u0000\u0000\u0000\u0311\u02f5\u0001\u0000\u0000\u0000\u0311\u0304"+
		"\u0001\u0000\u0000\u0000\u0312}\u0001\u0000\u0000\u0000\u0313\u0314\u0005"+
		"Q\u0000\u0000\u0314\u0315\u0005X\u0000\u0000\u0315\u0320\u0005.\u0000"+
		"\u0000\u0316\u0317\u0005R\u0000\u0000\u0317\u0320\u0005.\u0000\u0000\u0318"+
		"\u0319\u0005S\u0000\u0000\u0319\u0320\u0005.\u0000\u0000\u031a\u031c\u0005"+
		"T\u0000\u0000\u031b\u031d\u0003$\u0012\u0000\u031c\u031b\u0001\u0000\u0000"+
		"\u0000\u031c\u031d\u0001\u0000\u0000\u0000\u031d\u031e\u0001\u0000\u0000"+
		"\u0000\u031e\u0320\u0005.\u0000\u0000\u031f\u0313\u0001\u0000\u0000\u0000"+
		"\u031f\u0316\u0001\u0000\u0000\u0000\u031f\u0318\u0001\u0000\u0000\u0000"+
		"\u031f\u031a\u0001\u0000\u0000\u0000\u0320\u007f\u0001\u0000\u0000\u0000"+
		"\u0321\u0322\u0005U\u0000\u0000\u0322\u0323\u0005\u0001\u0000\u0000\u0323"+
		"\u0324\u0005Z\u0000\u0000\u0324\u0325\u0005\u0002\u0000\u0000\u0325\u0326"+
		"\u0005.\u0000\u0000\u0326\u0081\u0001\u0000\u0000\u0000\u0327\u0329\u0003"+
		"\u0084B\u0000\u0328\u0327\u0001\u0000\u0000\u0000\u0329\u032a\u0001\u0000"+
		"\u0000\u0000\u032a\u0328\u0001\u0000\u0000\u0000\u032a\u032b\u0001\u0000"+
		"\u0000\u0000\u032b\u0083\u0001\u0000\u0000\u0000\u032c\u032f\u0003\u0086"+
		"C\u0000\u032d\u032f\u0003(\u0014\u0000\u032e\u032c\u0001\u0000\u0000\u0000"+
		"\u032e\u032d\u0001\u0000\u0000\u0000\u032f\u0085\u0001\u0000\u0000\u0000"+
		"\u0330\u0332\u0003l6\u0000\u0331\u0330\u0001\u0000\u0000\u0000\u0332\u0335"+
		"\u0001\u0000\u0000\u0000\u0333\u0331\u0001\u0000\u0000\u0000\u0333\u0334"+
		"\u0001\u0000\u0000\u0000\u0334\u0336\u0001\u0000\u0000\u0000\u0335\u0333"+
		"\u0001\u0000\u0000\u0000\u0336\u0337\u0003*\u0015\u0000\u0337\u0339\u0003"+
		"J%\u0000\u0338\u033a\u0003\u0088D\u0000\u0339\u0338\u0001\u0000\u0000"+
		"\u0000\u0339\u033a\u0001\u0000\u0000\u0000\u033a\u033b\u0001\u0000\u0000"+
		"\u0000\u033b\u033c\u0003r9\u0000\u033c\u0087\u0001\u0000\u0000\u0000\u033d"+
		"\u033f\u0003(\u0014\u0000\u033e\u033d\u0001\u0000\u0000\u0000\u033f\u0340"+
		"\u0001\u0000\u0000\u0000\u0340\u033e\u0001\u0000\u0000\u0000\u0340\u0341"+
		"\u0001\u0000\u0000\u0000\u0341\u0089\u0001\u0000\u0000\u0000_\u0093\u009d"+
		"\u00a1\u00ab\u00b8\u00ba\u00c2\u00d3\u00db\u00e5\u00f0\u00fb\u0106\u0111"+
		"\u011c\u0127\u0132\u013d\u0148\u0152\u0159\u0160\u0167\u016f\u0171\u017c"+
		"\u0182\u0188\u018c\u0194\u0199\u01a1\u01a4\u01ab\u01b0\u01b4\u01b8\u01bd"+
		"\u01c3\u01ca\u01d0\u01d5\u01df\u01e4\u01e7\u01ee\u01fd\u0209\u020c\u020e"+
		"\u0213\u0217\u021c\u0221\u0228\u022e\u0230\u0237\u023c\u0240\u0243\u024d"+
		"\u0250\u0257\u0266\u0272\u0275\u0277\u0280\u0284\u0287\u028c\u0291\u0299"+
		"\u02a1\u02ae\u02bb\u02bf\u02c6\u02ca\u02cd\u02e5\u02f8\u02fc\u0300\u0308"+
		"\u030c\u0311\u031c\u031f\u032a\u032e\u0333\u0339\u0340";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}