// Generated from I:/Coding Projects/BBSnCC/src/Grammar/C99A3.g4 by ANTLR 4.13.1
package Grammar.C99A3;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class C99A3Parser extends Parser {
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
		RULE_preprocessing_file = 0, RULE_group = 1, RULE_group_part = 2, RULE_if_section = 3, 
		RULE_if_group = 4, RULE_elif_group = 5, RULE_else_group = 6, RULE_endif_line = 7, 
		RULE_control_line = 8, RULE_text_line = 9, RULE_non_directive = 10, RULE_pp_token = 11, 
		RULE_keyword = 12, RULE_punctuator = 13, RULE_primary_expression = 14, 
		RULE_postfix_expression = 15, RULE_argument_expression_list = 16, RULE_unary_expression = 17, 
		RULE_cast_expression = 18, RULE_multiplicative_expression = 19, RULE_additive_expression = 20, 
		RULE_shift_expression = 21, RULE_relational_expression = 22, RULE_equality_expression = 23, 
		RULE_and_expression = 24, RULE_xor_expression = 25, RULE_or_expression = 26, 
		RULE_land_expression = 27, RULE_lor_expression = 28, RULE_conditional_expression = 29, 
		RULE_assignment_expression = 30, RULE_expression = 31, RULE_constant_expression = 32, 
		RULE_declaration = 33, RULE_declaration_specifiers = 34, RULE_storage_class_specifier = 35, 
		RULE_function_specifier = 36, RULE_init_declarator_list = 37, RULE_init_declarator = 38, 
		RULE_type_specifier = 39, RULE_struct_or_union_specifier = 40, RULE_struct_declaration_list = 41, 
		RULE_struct_declaration = 42, RULE_specifier_qualifier_list = 43, RULE_struct_declarator_list = 44, 
		RULE_struct_declarator = 45, RULE_enum_specifier = 46, RULE_enumerator_list = 47, 
		RULE_enumerator = 48, RULE_type_qualifier = 49, RULE_declarator = 50, 
		RULE_direct_declarator = 51, RULE_pointer = 52, RULE_type_qualifier_list = 53, 
		RULE_parameter_type_list = 54, RULE_parameter_list = 55, RULE_parameter_declaration = 56, 
		RULE_identifier_list = 57, RULE_type_name = 58, RULE_abstract_declarator = 59, 
		RULE_direct_abstract_declarator = 60, RULE_typedef_name = 61, RULE_initializer = 62, 
		RULE_initializer_list = 63, RULE_designation = 64, RULE_designator_list = 65, 
		RULE_designator = 66, RULE_attributes_declaration = 67, RULE_statement = 68, 
		RULE_labeled_statement = 69, RULE_compound_statement = 70, RULE_block_item_list = 71, 
		RULE_block_item = 72, RULE_expression_statement = 73, RULE_selection_statement = 74, 
		RULE_iteration_statement = 75, RULE_jump_statement = 76, RULE_asm_statement = 77, 
		RULE_translation_unit = 78, RULE_external_declaration = 79, RULE_function_definition = 80, 
		RULE_declaration_list = 81;
	private static String[] makeRuleNames() {
		return new String[] {
			"preprocessing_file", "group", "group_part", "if_section", "if_group", 
			"elif_group", "else_group", "endif_line", "control_line", "text_line", 
			"non_directive", "pp_token", "keyword", "punctuator", "primary_expression", 
			"postfix_expression", "argument_expression_list", "unary_expression", 
			"cast_expression", "multiplicative_expression", "additive_expression", 
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
	public String getGrammarFileName() { return "C99A3.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public C99A3Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Preprocessing_fileContext extends ParserRuleContext {
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public Preprocessing_fileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preprocessing_file; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitPreprocessing_file(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Preprocessing_fileContext preprocessing_file() throws RecognitionException {
		Preprocessing_fileContext _localctx = new Preprocessing_fileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_preprocessing_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 124411939706109951L) != 0)) {
				{
				setState(164);
				group();
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
	public static class GroupContext extends ParserRuleContext {
		public List<Group_partContext> group_part() {
			return getRuleContexts(Group_partContext.class);
		}
		public Group_partContext group_part(int i) {
			return getRuleContext(Group_partContext.class,i);
		}
		public GroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_group);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(168); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(167);
					group_part();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(170); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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
	public static class Group_partContext extends ParserRuleContext {
		public If_sectionContext if_section() {
			return getRuleContext(If_sectionContext.class,0);
		}
		public Control_lineContext control_line() {
			return getRuleContext(Control_lineContext.class,0);
		}
		public TerminalNode HashTg() { return getToken(C99A3Parser.HashTg, 0); }
		public Non_directiveContext non_directive() {
			return getRuleContext(Non_directiveContext.class,0);
		}
		public Text_lineContext text_line() {
			return getRuleContext(Text_lineContext.class,0);
		}
		public Group_partContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group_part; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitGroup_part(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Group_partContext group_part() throws RecognitionException {
		Group_partContext _localctx = new Group_partContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_group_part);
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				if_section();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				control_line();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				match(HashTg);
				setState(175);
				non_directive();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(176);
				text_line();
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
	public static class If_sectionContext extends ParserRuleContext {
		public If_groupContext if_group() {
			return getRuleContext(If_groupContext.class,0);
		}
		public Endif_lineContext endif_line() {
			return getRuleContext(Endif_lineContext.class,0);
		}
		public List<Elif_groupContext> elif_group() {
			return getRuleContexts(Elif_groupContext.class);
		}
		public Elif_groupContext elif_group(int i) {
			return getRuleContext(Elif_groupContext.class,i);
		}
		public Else_groupContext else_group() {
			return getRuleContext(Else_groupContext.class,0);
		}
		public If_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_section; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitIf_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_sectionContext if_section() throws RecognitionException {
		If_sectionContext _localctx = new If_sectionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_if_section);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			if_group();
			setState(183);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(180);
					elif_group();
					}
					} 
				}
				setState(185);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(186);
				else_group();
				}
				break;
			}
			setState(189);
			endif_line();
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
	public static class If_groupContext extends ParserRuleContext {
		public TerminalNode HashTg() { return getToken(C99A3Parser.HashTg, 0); }
		public TerminalNode If() { return getToken(C99A3Parser.If, 0); }
		public TerminalNode NL() { return getToken(C99A3Parser.NL, 0); }
		public List<Pp_tokenContext> pp_token() {
			return getRuleContexts(Pp_tokenContext.class);
		}
		public Pp_tokenContext pp_token(int i) {
			return getRuleContext(Pp_tokenContext.class,i);
		}
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public TerminalNode Ifdef() { return getToken(C99A3Parser.Ifdef, 0); }
		public TerminalNode Identifier() { return getToken(C99A3Parser.Identifier, 0); }
		public TerminalNode Ifndef() { return getToken(C99A3Parser.Ifndef, 0); }
		public If_groupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_group; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitIf_group(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_groupContext if_group() throws RecognitionException {
		If_groupContext _localctx = new If_groupContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_if_group);
		int _la;
		try {
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(HashTg);
				setState(192);
				match(If);
				setState(194); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(193);
					pp_token();
					}
					}
					setState(196); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0) );
				setState(198);
				match(NL);
				setState(200);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(199);
					group();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				match(HashTg);
				setState(203);
				match(Ifdef);
				setState(204);
				match(Identifier);
				setState(205);
				match(NL);
				setState(207);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(206);
					group();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(209);
				match(HashTg);
				setState(210);
				match(Ifndef);
				setState(211);
				match(Identifier);
				setState(212);
				match(NL);
				setState(214);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(213);
					group();
					}
					break;
				}
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
	public static class Elif_groupContext extends ParserRuleContext {
		public TerminalNode HashTg() { return getToken(C99A3Parser.HashTg, 0); }
		public TerminalNode Elif() { return getToken(C99A3Parser.Elif, 0); }
		public TerminalNode NL() { return getToken(C99A3Parser.NL, 0); }
		public List<Pp_tokenContext> pp_token() {
			return getRuleContexts(Pp_tokenContext.class);
		}
		public Pp_tokenContext pp_token(int i) {
			return getRuleContext(Pp_tokenContext.class,i);
		}
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public Elif_groupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elif_group; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitElif_group(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Elif_groupContext elif_group() throws RecognitionException {
		Elif_groupContext _localctx = new Elif_groupContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_elif_group);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(HashTg);
			setState(219);
			match(Elif);
			setState(221); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(220);
				pp_token();
				}
				}
				setState(223); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0) );
			setState(225);
			match(NL);
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(226);
				group();
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
	public static class Else_groupContext extends ParserRuleContext {
		public TerminalNode HashTg() { return getToken(C99A3Parser.HashTg, 0); }
		public TerminalNode Else() { return getToken(C99A3Parser.Else, 0); }
		public TerminalNode NL() { return getToken(C99A3Parser.NL, 0); }
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public Else_groupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_group; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitElse_group(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_groupContext else_group() throws RecognitionException {
		Else_groupContext _localctx = new Else_groupContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_else_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(HashTg);
			setState(230);
			match(Else);
			setState(231);
			match(NL);
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(232);
				group();
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
	public static class Endif_lineContext extends ParserRuleContext {
		public TerminalNode HashTg() { return getToken(C99A3Parser.HashTg, 0); }
		public TerminalNode Endif() { return getToken(C99A3Parser.Endif, 0); }
		public TerminalNode NL() { return getToken(C99A3Parser.NL, 0); }
		public Endif_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endif_line; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitEndif_line(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Endif_lineContext endif_line() throws RecognitionException {
		Endif_lineContext _localctx = new Endif_lineContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_endif_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(HashTg);
			setState(236);
			match(Endif);
			setState(237);
			match(NL);
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
	public static class Control_lineContext extends ParserRuleContext {
		public TerminalNode HashTg() { return getToken(C99A3Parser.HashTg, 0); }
		public TerminalNode Include() { return getToken(C99A3Parser.Include, 0); }
		public TerminalNode NL() { return getToken(C99A3Parser.NL, 0); }
		public List<Pp_tokenContext> pp_token() {
			return getRuleContexts(Pp_tokenContext.class);
		}
		public Pp_tokenContext pp_token(int i) {
			return getRuleContext(Pp_tokenContext.class,i);
		}
		public TerminalNode Define() { return getToken(C99A3Parser.Define, 0); }
		public TerminalNode Identifier() { return getToken(C99A3Parser.Identifier, 0); }
		public TerminalNode LeRoBr() { return getToken(C99A3Parser.LeRoBr, 0); }
		public TerminalNode RiRoBr() { return getToken(C99A3Parser.RiRoBr, 0); }
		public Identifier_listContext identifier_list() {
			return getRuleContext(Identifier_listContext.class,0);
		}
		public TerminalNode ThreeP() { return getToken(C99A3Parser.ThreeP, 0); }
		public TerminalNode Comma() { return getToken(C99A3Parser.Comma, 0); }
		public TerminalNode Undef() { return getToken(C99A3Parser.Undef, 0); }
		public TerminalNode Line() { return getToken(C99A3Parser.Line, 0); }
		public TerminalNode Error() { return getToken(C99A3Parser.Error, 0); }
		public TerminalNode Pragma() { return getToken(C99A3Parser.Pragma, 0); }
		public TerminalNode Embed() { return getToken(C99A3Parser.Embed, 0); }
		public Control_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_control_line; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitControl_line(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Control_lineContext control_line() throws RecognitionException {
		Control_lineContext _localctx = new Control_lineContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_control_line);
		int _la;
		try {
			setState(344);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				match(HashTg);
				setState(240);
				match(Include);
				setState(242); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(241);
					pp_token();
					}
					}
					setState(244); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0) );
				setState(246);
				match(NL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				match(HashTg);
				setState(249);
				match(Define);
				setState(250);
				match(Identifier);
				setState(251);
				match(LeRoBr);
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(252);
					identifier_list();
					}
				}

				setState(255);
				match(RiRoBr);
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0)) {
					{
					{
					setState(256);
					pp_token();
					}
					}
					setState(261);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(262);
				match(NL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(263);
				match(HashTg);
				setState(264);
				match(Define);
				setState(265);
				match(Identifier);
				setState(266);
				match(LeRoBr);
				setState(267);
				match(ThreeP);
				setState(268);
				match(RiRoBr);
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0)) {
					{
					{
					setState(269);
					pp_token();
					}
					}
					setState(274);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(275);
				match(NL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(276);
				match(HashTg);
				setState(277);
				match(Define);
				setState(278);
				match(Identifier);
				setState(279);
				match(LeRoBr);
				setState(280);
				identifier_list();
				setState(281);
				match(Comma);
				setState(282);
				match(ThreeP);
				setState(283);
				match(RiRoBr);
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0)) {
					{
					{
					setState(284);
					pp_token();
					}
					}
					setState(289);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(290);
				match(NL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(292);
				match(HashTg);
				setState(293);
				match(Define);
				setState(294);
				match(Identifier);
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0)) {
					{
					{
					setState(295);
					pp_token();
					}
					}
					setState(300);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(301);
				match(NL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(302);
				match(HashTg);
				setState(303);
				match(Undef);
				setState(304);
				match(Identifier);
				setState(305);
				match(NL);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(306);
				match(HashTg);
				setState(307);
				match(Line);
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0)) {
					{
					{
					setState(308);
					pp_token();
					}
					}
					setState(313);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(314);
				match(NL);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(315);
				match(HashTg);
				setState(316);
				match(Error);
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0)) {
					{
					{
					setState(317);
					pp_token();
					}
					}
					setState(322);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(323);
				match(NL);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(324);
				match(HashTg);
				setState(325);
				match(Pragma);
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0)) {
					{
					{
					setState(326);
					pp_token();
					}
					}
					setState(331);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(332);
				match(NL);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(333);
				match(HashTg);
				setState(334);
				match(Embed);
				setState(336); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(335);
					pp_token();
					}
					}
					setState(338); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0) );
				setState(340);
				match(NL);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(342);
				match(HashTg);
				setState(343);
				match(NL);
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
	public static class Text_lineContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(C99A3Parser.NL, 0); }
		public List<Pp_tokenContext> pp_token() {
			return getRuleContexts(Pp_tokenContext.class);
		}
		public Pp_tokenContext pp_token(int i) {
			return getRuleContext(Pp_tokenContext.class,i);
		}
		public Text_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text_line; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitText_line(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Text_lineContext text_line() throws RecognitionException {
		Text_lineContext _localctx = new Text_lineContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_text_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0)) {
				{
				{
				setState(346);
				pp_token();
				}
				}
				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(352);
			match(NL);
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
	public static class Non_directiveContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(C99A3Parser.NL, 0); }
		public List<Pp_tokenContext> pp_token() {
			return getRuleContexts(Pp_tokenContext.class);
		}
		public Pp_tokenContext pp_token(int i) {
			return getRuleContext(Pp_tokenContext.class,i);
		}
		public Non_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_directive; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitNon_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Non_directiveContext non_directive() throws RecognitionException {
		Non_directiveContext _localctx = new Non_directiveContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_non_directive);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(355); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(354);
					pp_token();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(357); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(359);
			match(NL);
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
	public static class Pp_tokenContext extends ParserRuleContext {
		public TerminalNode Header_name() { return getToken(C99A3Parser.Header_name, 0); }
		public TerminalNode Identifier() { return getToken(C99A3Parser.Identifier, 0); }
		public TerminalNode Constant() { return getToken(C99A3Parser.Constant, 0); }
		public TerminalNode String_literal() { return getToken(C99A3Parser.String_literal, 0); }
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public PunctuatorContext punctuator() {
			return getRuleContext(PunctuatorContext.class,0);
		}
		public Pp_tokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pp_token; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitPp_token(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pp_tokenContext pp_token() throws RecognitionException {
		Pp_tokenContext _localctx = new Pp_tokenContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pp_token);
		try {
			setState(367);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Header_name:
				enterOuterAlt(_localctx, 1);
				{
				setState(361);
				match(Header_name);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				match(Identifier);
				}
				break;
			case Constant:
				enterOuterAlt(_localctx, 3);
				{
				setState(363);
				match(Constant);
				}
				break;
			case String_literal:
				enterOuterAlt(_localctx, 4);
				{
				setState(364);
				match(String_literal);
				}
				break;
			case Auto:
			case Break:
			case Case:
			case Char:
			case Const:
			case Continue:
			case Default:
			case Do:
			case Double:
			case Else:
			case Enum:
			case Extern:
			case Float:
			case For:
			case Goto:
			case If:
			case Inline:
			case Int:
			case Long:
			case Register:
			case Restrict:
			case Return:
			case Short:
			case Signed:
			case Sizeof:
			case Static:
			case Struct:
			case Switch:
			case Typedef:
			case Union:
			case Unsigned:
			case Void:
			case Volatile:
			case While:
			case Bool:
			case Complex:
			case Imaginary:
			case Asm:
			case Defined:
			case Define:
			case Ifdef:
			case Ifndef:
			case Elif:
			case Endif:
			case Include:
			case Undef:
			case Line:
			case Error:
			case Pragma:
			case HasEmbed:
			case Embed:
			case Offsetof:
			case SRAM:
			case RWTWICE:
			case ROTWICE:
			case WOTWICE:
				enterOuterAlt(_localctx, 5);
				{
				setState(365);
				keyword();
				}
				break;
			case TwoMCo:
			case ThreeP:
			case Arrow:
			case Incrmn:
			case Decrmn:
			case LssLss:
			case GrtGrt:
			case LessTh:
			case GretTh:
			case LessEq:
			case GretEq:
			case Equal:
			case NotEql:
			case AmpAmp:
			case OrOr:
			case MulAsg:
			case DivAsg:
			case ModAsg:
			case PluAsg:
			case SubAsg:
			case LShAsg:
			case RShAsg:
			case AndAsg:
			case XorAsg:
			case OrAsg:
			case TwoHsh:
			case LessCo:
			case GretCo:
			case LessMd:
			case GretMd:
			case ModCol:
			case TwoLSB:
			case TwoRSB:
			case Amper:
			case Star:
			case Plus:
			case Minus:
			case Tilde:
			case Excla:
			case BckSla:
			case Percnt:
			case Xor:
			case Or:
			case Colon:
			case Semico:
			case Period:
			case Questi:
			case Assign:
			case Comma:
			case HashTg:
			case LeSqBr:
			case RiSqBr:
			case LeRoBr:
			case RiRoBr:
			case LeCuBr:
			case RiCuBr:
				enterOuterAlt(_localctx, 6);
				{
				setState(366);
				punctuator();
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
	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode Auto() { return getToken(C99A3Parser.Auto, 0); }
		public TerminalNode Break() { return getToken(C99A3Parser.Break, 0); }
		public TerminalNode Case() { return getToken(C99A3Parser.Case, 0); }
		public TerminalNode Char() { return getToken(C99A3Parser.Char, 0); }
		public TerminalNode Const() { return getToken(C99A3Parser.Const, 0); }
		public TerminalNode Continue() { return getToken(C99A3Parser.Continue, 0); }
		public TerminalNode Default() { return getToken(C99A3Parser.Default, 0); }
		public TerminalNode Do() { return getToken(C99A3Parser.Do, 0); }
		public TerminalNode Double() { return getToken(C99A3Parser.Double, 0); }
		public TerminalNode Else() { return getToken(C99A3Parser.Else, 0); }
		public TerminalNode Enum() { return getToken(C99A3Parser.Enum, 0); }
		public TerminalNode Extern() { return getToken(C99A3Parser.Extern, 0); }
		public TerminalNode Float() { return getToken(C99A3Parser.Float, 0); }
		public TerminalNode For() { return getToken(C99A3Parser.For, 0); }
		public TerminalNode Goto() { return getToken(C99A3Parser.Goto, 0); }
		public TerminalNode If() { return getToken(C99A3Parser.If, 0); }
		public TerminalNode Inline() { return getToken(C99A3Parser.Inline, 0); }
		public TerminalNode Int() { return getToken(C99A3Parser.Int, 0); }
		public TerminalNode Long() { return getToken(C99A3Parser.Long, 0); }
		public TerminalNode Register() { return getToken(C99A3Parser.Register, 0); }
		public TerminalNode Restrict() { return getToken(C99A3Parser.Restrict, 0); }
		public TerminalNode Return() { return getToken(C99A3Parser.Return, 0); }
		public TerminalNode Short() { return getToken(C99A3Parser.Short, 0); }
		public TerminalNode Signed() { return getToken(C99A3Parser.Signed, 0); }
		public TerminalNode Sizeof() { return getToken(C99A3Parser.Sizeof, 0); }
		public TerminalNode Static() { return getToken(C99A3Parser.Static, 0); }
		public TerminalNode Struct() { return getToken(C99A3Parser.Struct, 0); }
		public TerminalNode Switch() { return getToken(C99A3Parser.Switch, 0); }
		public TerminalNode Typedef() { return getToken(C99A3Parser.Typedef, 0); }
		public TerminalNode Union() { return getToken(C99A3Parser.Union, 0); }
		public TerminalNode Unsigned() { return getToken(C99A3Parser.Unsigned, 0); }
		public TerminalNode Void() { return getToken(C99A3Parser.Void, 0); }
		public TerminalNode Volatile() { return getToken(C99A3Parser.Volatile, 0); }
		public TerminalNode While() { return getToken(C99A3Parser.While, 0); }
		public TerminalNode Bool() { return getToken(C99A3Parser.Bool, 0); }
		public TerminalNode Complex() { return getToken(C99A3Parser.Complex, 0); }
		public TerminalNode Imaginary() { return getToken(C99A3Parser.Imaginary, 0); }
		public TerminalNode Asm() { return getToken(C99A3Parser.Asm, 0); }
		public TerminalNode Defined() { return getToken(C99A3Parser.Defined, 0); }
		public TerminalNode Define() { return getToken(C99A3Parser.Define, 0); }
		public TerminalNode Ifdef() { return getToken(C99A3Parser.Ifdef, 0); }
		public TerminalNode Ifndef() { return getToken(C99A3Parser.Ifndef, 0); }
		public TerminalNode Elif() { return getToken(C99A3Parser.Elif, 0); }
		public TerminalNode Endif() { return getToken(C99A3Parser.Endif, 0); }
		public TerminalNode Include() { return getToken(C99A3Parser.Include, 0); }
		public TerminalNode Undef() { return getToken(C99A3Parser.Undef, 0); }
		public TerminalNode Line() { return getToken(C99A3Parser.Line, 0); }
		public TerminalNode Error() { return getToken(C99A3Parser.Error, 0); }
		public TerminalNode Pragma() { return getToken(C99A3Parser.Pragma, 0); }
		public TerminalNode HasEmbed() { return getToken(C99A3Parser.HasEmbed, 0); }
		public TerminalNode Embed() { return getToken(C99A3Parser.Embed, 0); }
		public TerminalNode Offsetof() { return getToken(C99A3Parser.Offsetof, 0); }
		public TerminalNode SRAM() { return getToken(C99A3Parser.SRAM, 0); }
		public TerminalNode RWTWICE() { return getToken(C99A3Parser.RWTWICE, 0); }
		public TerminalNode ROTWICE() { return getToken(C99A3Parser.ROTWICE, 0); }
		public TerminalNode WOTWICE() { return getToken(C99A3Parser.WOTWICE, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_keyword);
		try {
			setState(438);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Auto:
				enterOuterAlt(_localctx, 1);
				{
				setState(369);
				match(Auto);
				}
				break;
			case Break:
				enterOuterAlt(_localctx, 2);
				{
				setState(370);
				match(Break);
				}
				break;
			case Case:
				enterOuterAlt(_localctx, 3);
				{
				setState(371);
				match(Case);
				}
				break;
			case Char:
				enterOuterAlt(_localctx, 4);
				{
				setState(372);
				match(Char);
				}
				break;
			case Const:
				enterOuterAlt(_localctx, 5);
				{
				setState(373);
				match(Const);
				}
				break;
			case Continue:
				enterOuterAlt(_localctx, 6);
				{
				setState(374);
				match(Continue);
				}
				break;
			case Default:
				enterOuterAlt(_localctx, 7);
				{
				setState(375);
				match(Default);
				}
				break;
			case Do:
				enterOuterAlt(_localctx, 8);
				{
				setState(376);
				match(Do);
				}
				break;
			case Double:
				enterOuterAlt(_localctx, 9);
				{
				setState(377);
				match(Double);
				}
				break;
			case Else:
				enterOuterAlt(_localctx, 10);
				{
				setState(378);
				match(Else);
				}
				break;
			case Enum:
				enterOuterAlt(_localctx, 11);
				{
				setState(379);
				match(Enum);
				}
				break;
			case Extern:
				enterOuterAlt(_localctx, 12);
				{
				setState(380);
				match(Extern);
				}
				break;
			case Float:
				enterOuterAlt(_localctx, 13);
				{
				setState(381);
				match(Float);
				}
				break;
			case For:
				enterOuterAlt(_localctx, 14);
				{
				setState(382);
				match(For);
				}
				break;
			case Goto:
				enterOuterAlt(_localctx, 15);
				{
				setState(383);
				match(Goto);
				}
				break;
			case If:
				enterOuterAlt(_localctx, 16);
				{
				setState(384);
				match(If);
				}
				break;
			case Inline:
				enterOuterAlt(_localctx, 17);
				{
				setState(385);
				match(Inline);
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 18);
				{
				setState(386);
				match(Int);
				}
				break;
			case Long:
				enterOuterAlt(_localctx, 19);
				{
				setState(387);
				match(Long);
				}
				break;
			case Register:
				enterOuterAlt(_localctx, 20);
				{
				setState(388);
				match(Register);
				}
				break;
			case Restrict:
				enterOuterAlt(_localctx, 21);
				{
				setState(389);
				match(Restrict);
				}
				break;
			case Return:
				enterOuterAlt(_localctx, 22);
				{
				setState(390);
				match(Return);
				}
				break;
			case Short:
				enterOuterAlt(_localctx, 23);
				{
				setState(391);
				match(Short);
				}
				break;
			case Signed:
				enterOuterAlt(_localctx, 24);
				{
				setState(392);
				match(Signed);
				}
				break;
			case Sizeof:
				enterOuterAlt(_localctx, 25);
				{
				setState(393);
				match(Sizeof);
				}
				break;
			case Static:
				enterOuterAlt(_localctx, 26);
				{
				setState(394);
				match(Static);
				}
				break;
			case Struct:
				enterOuterAlt(_localctx, 27);
				{
				setState(395);
				match(Struct);
				}
				break;
			case Switch:
				enterOuterAlt(_localctx, 28);
				{
				setState(396);
				match(Switch);
				}
				break;
			case Typedef:
				enterOuterAlt(_localctx, 29);
				{
				setState(397);
				match(Typedef);
				}
				break;
			case Union:
				enterOuterAlt(_localctx, 30);
				{
				setState(398);
				match(Union);
				}
				break;
			case Unsigned:
				enterOuterAlt(_localctx, 31);
				{
				setState(399);
				match(Unsigned);
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 32);
				{
				setState(400);
				match(Void);
				}
				break;
			case Volatile:
				enterOuterAlt(_localctx, 33);
				{
				setState(401);
				match(Volatile);
				}
				break;
			case While:
				enterOuterAlt(_localctx, 34);
				{
				setState(402);
				match(While);
				}
				break;
			case Bool:
				enterOuterAlt(_localctx, 35);
				{
				setState(403);
				match(Bool);
				}
				break;
			case Complex:
				enterOuterAlt(_localctx, 36);
				{
				setState(404);
				match(Complex);
				}
				break;
			case Imaginary:
				enterOuterAlt(_localctx, 37);
				{
				setState(405);
				match(Imaginary);
				}
				break;
			case Asm:
				enterOuterAlt(_localctx, 38);
				{
				setState(406);
				match(Asm);
				}
				break;
			case Defined:
				enterOuterAlt(_localctx, 39);
				{
				setState(407);
				match(Defined);
				setState(408);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Define:
				enterOuterAlt(_localctx, 40);
				{
				setState(409);
				match(Define);
				setState(410);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Ifdef:
				enterOuterAlt(_localctx, 41);
				{
				setState(411);
				match(Ifdef);
				setState(412);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Ifndef:
				enterOuterAlt(_localctx, 42);
				{
				setState(413);
				match(Ifndef);
				setState(414);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Elif:
				enterOuterAlt(_localctx, 43);
				{
				setState(415);
				match(Elif);
				setState(416);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Endif:
				enterOuterAlt(_localctx, 44);
				{
				setState(417);
				match(Endif);
				setState(418);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Include:
				enterOuterAlt(_localctx, 45);
				{
				setState(419);
				match(Include);
				setState(420);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Undef:
				enterOuterAlt(_localctx, 46);
				{
				setState(421);
				match(Undef);
				setState(422);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Line:
				enterOuterAlt(_localctx, 47);
				{
				setState(423);
				match(Line);
				setState(424);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Error:
				enterOuterAlt(_localctx, 48);
				{
				setState(425);
				match(Error);
				setState(426);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Pragma:
				enterOuterAlt(_localctx, 49);
				{
				setState(427);
				match(Pragma);
				setState(428);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case HasEmbed:
				enterOuterAlt(_localctx, 50);
				{
				setState(429);
				match(HasEmbed);
				setState(430);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Embed:
				enterOuterAlt(_localctx, 51);
				{
				setState(431);
				match(Embed);
				setState(432);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Offsetof:
				enterOuterAlt(_localctx, 52);
				{
				setState(433);
				match(Offsetof);
				}
				break;
			case SRAM:
				enterOuterAlt(_localctx, 53);
				{
				setState(434);
				match(SRAM);
				}
				break;
			case RWTWICE:
				enterOuterAlt(_localctx, 54);
				{
				setState(435);
				match(RWTWICE);
				}
				break;
			case ROTWICE:
				enterOuterAlt(_localctx, 55);
				{
				setState(436);
				match(ROTWICE);
				}
				break;
			case WOTWICE:
				enterOuterAlt(_localctx, 56);
				{
				setState(437);
				match(WOTWICE);
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
	public static class PunctuatorContext extends ParserRuleContext {
		public TerminalNode TwoMCo() { return getToken(C99A3Parser.TwoMCo, 0); }
		public TerminalNode ThreeP() { return getToken(C99A3Parser.ThreeP, 0); }
		public TerminalNode Arrow() { return getToken(C99A3Parser.Arrow, 0); }
		public TerminalNode Incrmn() { return getToken(C99A3Parser.Incrmn, 0); }
		public TerminalNode Decrmn() { return getToken(C99A3Parser.Decrmn, 0); }
		public TerminalNode LssLss() { return getToken(C99A3Parser.LssLss, 0); }
		public TerminalNode GrtGrt() { return getToken(C99A3Parser.GrtGrt, 0); }
		public TerminalNode LessTh() { return getToken(C99A3Parser.LessTh, 0); }
		public TerminalNode GretTh() { return getToken(C99A3Parser.GretTh, 0); }
		public TerminalNode LessEq() { return getToken(C99A3Parser.LessEq, 0); }
		public TerminalNode GretEq() { return getToken(C99A3Parser.GretEq, 0); }
		public TerminalNode Equal() { return getToken(C99A3Parser.Equal, 0); }
		public TerminalNode NotEql() { return getToken(C99A3Parser.NotEql, 0); }
		public TerminalNode AmpAmp() { return getToken(C99A3Parser.AmpAmp, 0); }
		public TerminalNode OrOr() { return getToken(C99A3Parser.OrOr, 0); }
		public TerminalNode MulAsg() { return getToken(C99A3Parser.MulAsg, 0); }
		public TerminalNode DivAsg() { return getToken(C99A3Parser.DivAsg, 0); }
		public TerminalNode ModAsg() { return getToken(C99A3Parser.ModAsg, 0); }
		public TerminalNode PluAsg() { return getToken(C99A3Parser.PluAsg, 0); }
		public TerminalNode SubAsg() { return getToken(C99A3Parser.SubAsg, 0); }
		public TerminalNode LShAsg() { return getToken(C99A3Parser.LShAsg, 0); }
		public TerminalNode RShAsg() { return getToken(C99A3Parser.RShAsg, 0); }
		public TerminalNode AndAsg() { return getToken(C99A3Parser.AndAsg, 0); }
		public TerminalNode XorAsg() { return getToken(C99A3Parser.XorAsg, 0); }
		public TerminalNode OrAsg() { return getToken(C99A3Parser.OrAsg, 0); }
		public TerminalNode TwoHsh() { return getToken(C99A3Parser.TwoHsh, 0); }
		public TerminalNode LessCo() { return getToken(C99A3Parser.LessCo, 0); }
		public TerminalNode GretCo() { return getToken(C99A3Parser.GretCo, 0); }
		public TerminalNode LessMd() { return getToken(C99A3Parser.LessMd, 0); }
		public TerminalNode GretMd() { return getToken(C99A3Parser.GretMd, 0); }
		public TerminalNode ModCol() { return getToken(C99A3Parser.ModCol, 0); }
		public TerminalNode TwoLSB() { return getToken(C99A3Parser.TwoLSB, 0); }
		public TerminalNode TwoRSB() { return getToken(C99A3Parser.TwoRSB, 0); }
		public TerminalNode Amper() { return getToken(C99A3Parser.Amper, 0); }
		public TerminalNode Star() { return getToken(C99A3Parser.Star, 0); }
		public TerminalNode Plus() { return getToken(C99A3Parser.Plus, 0); }
		public TerminalNode Minus() { return getToken(C99A3Parser.Minus, 0); }
		public TerminalNode Tilde() { return getToken(C99A3Parser.Tilde, 0); }
		public TerminalNode Excla() { return getToken(C99A3Parser.Excla, 0); }
		public TerminalNode BckSla() { return getToken(C99A3Parser.BckSla, 0); }
		public TerminalNode Percnt() { return getToken(C99A3Parser.Percnt, 0); }
		public TerminalNode Xor() { return getToken(C99A3Parser.Xor, 0); }
		public TerminalNode Or() { return getToken(C99A3Parser.Or, 0); }
		public TerminalNode Colon() { return getToken(C99A3Parser.Colon, 0); }
		public TerminalNode Semico() { return getToken(C99A3Parser.Semico, 0); }
		public TerminalNode Period() { return getToken(C99A3Parser.Period, 0); }
		public TerminalNode Questi() { return getToken(C99A3Parser.Questi, 0); }
		public TerminalNode Assign() { return getToken(C99A3Parser.Assign, 0); }
		public TerminalNode Comma() { return getToken(C99A3Parser.Comma, 0); }
		public TerminalNode HashTg() { return getToken(C99A3Parser.HashTg, 0); }
		public TerminalNode LeSqBr() { return getToken(C99A3Parser.LeSqBr, 0); }
		public TerminalNode RiSqBr() { return getToken(C99A3Parser.RiSqBr, 0); }
		public TerminalNode LeRoBr() { return getToken(C99A3Parser.LeRoBr, 0); }
		public TerminalNode RiRoBr() { return getToken(C99A3Parser.RiRoBr, 0); }
		public TerminalNode LeCuBr() { return getToken(C99A3Parser.LeCuBr, 0); }
		public TerminalNode RiCuBr() { return getToken(C99A3Parser.RiCuBr, 0); }
		public PunctuatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_punctuator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitPunctuator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PunctuatorContext punctuator() throws RecognitionException {
		PunctuatorContext _localctx = new PunctuatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_punctuator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			_la = _input.LA(1);
			if ( !(((((_la - 57)) & ~0x3f) == 0 && ((1L << (_la - 57)) & 72057594037927935L) != 0)) ) {
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
	public static class Primary_expressionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(C99A3Parser.Identifier, 0); }
		public TerminalNode Constant() { return getToken(C99A3Parser.Constant, 0); }
		public TerminalNode String_literal() { return getToken(C99A3Parser.String_literal, 0); }
		public TerminalNode LeRoBr() { return getToken(C99A3Parser.LeRoBr, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RiRoBr() { return getToken(C99A3Parser.RiRoBr, 0); }
		public Primary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitPrimary_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_primary_expression);
		try {
			setState(449);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(442);
				match(Identifier);
				}
				break;
			case Constant:
				enterOuterAlt(_localctx, 2);
				{
				setState(443);
				match(Constant);
				}
				break;
			case String_literal:
				enterOuterAlt(_localctx, 3);
				{
				setState(444);
				match(String_literal);
				}
				break;
			case LeRoBr:
				enterOuterAlt(_localctx, 4);
				{
				setState(445);
				match(LeRoBr);
				setState(446);
				expression();
				setState(447);
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
		public TerminalNode LeRoBr() { return getToken(C99A3Parser.LeRoBr, 0); }
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public TerminalNode RiRoBr() { return getToken(C99A3Parser.RiRoBr, 0); }
		public TerminalNode LeCuBr() { return getToken(C99A3Parser.LeCuBr, 0); }
		public Initializer_listContext initializer_list() {
			return getRuleContext(Initializer_listContext.class,0);
		}
		public TerminalNode RiCuBr() { return getToken(C99A3Parser.RiCuBr, 0); }
		public TerminalNode Comma() { return getToken(C99A3Parser.Comma, 0); }
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public TerminalNode LeSqBr() { return getToken(C99A3Parser.LeSqBr, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RiSqBr() { return getToken(C99A3Parser.RiSqBr, 0); }
		public Argument_expression_listContext argument_expression_list() {
			return getRuleContext(Argument_expression_listContext.class,0);
		}
		public TerminalNode Period() { return getToken(C99A3Parser.Period, 0); }
		public TerminalNode Identifier() { return getToken(C99A3Parser.Identifier, 0); }
		public TerminalNode Arrow() { return getToken(C99A3Parser.Arrow, 0); }
		public TerminalNode Incrmn() { return getToken(C99A3Parser.Incrmn, 0); }
		public TerminalNode Decrmn() { return getToken(C99A3Parser.Decrmn, 0); }
		public Postfix_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitPostfix_expression(this);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_postfix_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(452);
				primary_expression();
				}
				break;
			case 2:
				{
				setState(453);
				match(LeRoBr);
				setState(454);
				type_name();
				setState(455);
				match(RiRoBr);
				setState(456);
				match(LeCuBr);
				setState(457);
				initializer_list();
				setState(459);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(458);
					match(Comma);
					}
				}

				setState(461);
				match(RiCuBr);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(488);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(486);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(465);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(466);
						match(LeSqBr);
						setState(467);
						expression();
						setState(468);
						match(RiSqBr);
						}
						break;
					case 2:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(470);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(471);
						match(LeRoBr);
						setState(473);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3464394563144122368L) != 0) || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 738721855L) != 0)) {
							{
							setState(472);
							argument_expression_list();
							}
						}

						setState(475);
						match(RiRoBr);
						}
						break;
					case 3:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(476);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(477);
						match(Period);
						setState(478);
						match(Identifier);
						}
						break;
					case 4:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(479);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(480);
						match(Arrow);
						setState(481);
						match(Identifier);
						}
						break;
					case 5:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(482);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(483);
						match(Incrmn);
						}
						break;
					case 6:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(484);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(485);
						match(Decrmn);
						}
						break;
					}
					} 
				}
				setState(490);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
		public List<TerminalNode> Comma() { return getTokens(C99A3Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C99A3Parser.Comma, i);
		}
		public Argument_expression_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_expression_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitArgument_expression_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Argument_expression_listContext argument_expression_list() throws RecognitionException {
		Argument_expression_listContext _localctx = new Argument_expression_listContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_argument_expression_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			assignment_expression();
			setState(496);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(492);
				match(Comma);
				setState(493);
				assignment_expression();
				}
				}
				setState(498);
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
		public TerminalNode Incrmn() { return getToken(C99A3Parser.Incrmn, 0); }
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TerminalNode Decrmn() { return getToken(C99A3Parser.Decrmn, 0); }
		public Cast_expressionContext cast_expression() {
			return getRuleContext(Cast_expressionContext.class,0);
		}
		public TerminalNode Amper() { return getToken(C99A3Parser.Amper, 0); }
		public TerminalNode Star() { return getToken(C99A3Parser.Star, 0); }
		public TerminalNode Plus() { return getToken(C99A3Parser.Plus, 0); }
		public TerminalNode Minus() { return getToken(C99A3Parser.Minus, 0); }
		public TerminalNode Tilde() { return getToken(C99A3Parser.Tilde, 0); }
		public TerminalNode Excla() { return getToken(C99A3Parser.Excla, 0); }
		public TerminalNode Sizeof() { return getToken(C99A3Parser.Sizeof, 0); }
		public TerminalNode LeRoBr() { return getToken(C99A3Parser.LeRoBr, 0); }
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public TerminalNode RiRoBr() { return getToken(C99A3Parser.RiRoBr, 0); }
		public TerminalNode HasEmbed() { return getToken(C99A3Parser.HasEmbed, 0); }
		public TerminalNode Header_name() { return getToken(C99A3Parser.Header_name, 0); }
		public TerminalNode String_literal() { return getToken(C99A3Parser.String_literal, 0); }
		public TerminalNode Defined() { return getToken(C99A3Parser.Defined, 0); }
		public TerminalNode Identifier() { return getToken(C99A3Parser.Identifier, 0); }
		public TerminalNode Offsetof() { return getToken(C99A3Parser.Offsetof, 0); }
		public TerminalNode Comma() { return getToken(C99A3Parser.Comma, 0); }
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitUnary_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_unary_expression);
		int _la;
		try {
			setState(530);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(499);
				postfix_expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(500);
				match(Incrmn);
				setState(501);
				unary_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(502);
				match(Decrmn);
				setState(503);
				unary_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(504);
				_la = _input.LA(1);
				if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 63L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(505);
				cast_expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(506);
				match(Sizeof);
				setState(507);
				unary_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(508);
				match(Sizeof);
				setState(509);
				match(LeRoBr);
				setState(510);
				type_name();
				setState(511);
				match(RiRoBr);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(513);
				match(HasEmbed);
				setState(514);
				match(LeRoBr);
				setState(515);
				_la = _input.LA(1);
				if ( !(_la==String_literal || _la==Header_name) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(516);
				match(RiRoBr);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(517);
				match(Defined);
				setState(518);
				match(Identifier);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(519);
				match(Defined);
				setState(520);
				match(LeRoBr);
				setState(521);
				match(Identifier);
				setState(522);
				match(RiRoBr);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(523);
				match(Offsetof);
				setState(524);
				match(LeRoBr);
				setState(525);
				type_name();
				setState(526);
				match(Comma);
				setState(527);
				match(Identifier);
				setState(528);
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
		public TerminalNode LeRoBr() { return getToken(C99A3Parser.LeRoBr, 0); }
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public TerminalNode RiRoBr() { return getToken(C99A3Parser.RiRoBr, 0); }
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitCast_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cast_expressionContext cast_expression() throws RecognitionException {
		Cast_expressionContext _localctx = new Cast_expressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_cast_expression);
		try {
			setState(538);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(532);
				match(LeRoBr);
				setState(533);
				type_name();
				setState(534);
				match(RiRoBr);
				setState(535);
				cast_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(537);
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
		public TerminalNode Star() { return getToken(C99A3Parser.Star, 0); }
		public TerminalNode BckSla() { return getToken(C99A3Parser.BckSla, 0); }
		public TerminalNode Percnt() { return getToken(C99A3Parser.Percnt, 0); }
		public Multiplicative_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitMultiplicative_expression(this);
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
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_multiplicative_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(541);
			cast_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(548);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Multiplicative_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_multiplicative_expression);
					setState(543);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(544);
					_la = _input.LA(1);
					if ( !(((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 97L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(545);
					cast_expression();
					}
					} 
				}
				setState(550);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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
		public TerminalNode Plus() { return getToken(C99A3Parser.Plus, 0); }
		public TerminalNode Minus() { return getToken(C99A3Parser.Minus, 0); }
		public Additive_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitAdditive_expression(this);
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
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_additive_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(552);
			multiplicative_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(559);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Additive_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_additive_expression);
					setState(554);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(555);
					_la = _input.LA(1);
					if ( !(_la==Plus || _la==Minus) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(556);
					multiplicative_expression(0);
					}
					} 
				}
				setState(561);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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
		public TerminalNode LssLss() { return getToken(C99A3Parser.LssLss, 0); }
		public TerminalNode GrtGrt() { return getToken(C99A3Parser.GrtGrt, 0); }
		public Shift_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitShift_expression(this);
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_shift_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(563);
			additive_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(570);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Shift_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_shift_expression);
					setState(565);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(566);
					_la = _input.LA(1);
					if ( !(_la==LssLss || _la==GrtGrt) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(567);
					additive_expression(0);
					}
					} 
				}
				setState(572);
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
		public TerminalNode LessTh() { return getToken(C99A3Parser.LessTh, 0); }
		public TerminalNode GretTh() { return getToken(C99A3Parser.GretTh, 0); }
		public TerminalNode LessEq() { return getToken(C99A3Parser.LessEq, 0); }
		public TerminalNode GretEq() { return getToken(C99A3Parser.GretEq, 0); }
		public Relational_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitRelational_expression(this);
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_relational_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(574);
			shift_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(581);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Relational_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relational_expression);
					setState(576);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(577);
					_la = _input.LA(1);
					if ( !(((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 15L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(578);
					shift_expression(0);
					}
					} 
				}
				setState(583);
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
		public TerminalNode Equal() { return getToken(C99A3Parser.Equal, 0); }
		public TerminalNode NotEql() { return getToken(C99A3Parser.NotEql, 0); }
		public Equality_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitEquality_expression(this);
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_equality_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(585);
			relational_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(592);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Equality_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_equality_expression);
					setState(587);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(588);
					_la = _input.LA(1);
					if ( !(_la==Equal || _la==NotEql) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(589);
					relational_expression(0);
					}
					} 
				}
				setState(594);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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
		public TerminalNode Amper() { return getToken(C99A3Parser.Amper, 0); }
		public And_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitAnd_expression(this);
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_and_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(596);
			equality_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(603);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new And_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_and_expression);
					setState(598);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(599);
					match(Amper);
					setState(600);
					equality_expression(0);
					}
					} 
				}
				setState(605);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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
		public TerminalNode Xor() { return getToken(C99A3Parser.Xor, 0); }
		public Xor_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xor_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitXor_expression(this);
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
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_xor_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(607);
			and_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(614);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Xor_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_xor_expression);
					setState(609);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(610);
					match(Xor);
					setState(611);
					and_expression(0);
					}
					} 
				}
				setState(616);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
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
		public TerminalNode Or() { return getToken(C99A3Parser.Or, 0); }
		public Or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitOr_expression(this);
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
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_or_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(618);
			xor_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(625);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Or_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_or_expression);
					setState(620);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(621);
					match(Or);
					setState(622);
					xor_expression(0);
					}
					} 
				}
				setState(627);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
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
		public TerminalNode AmpAmp() { return getToken(C99A3Parser.AmpAmp, 0); }
		public Land_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_land_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitLand_expression(this);
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
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_land_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(629);
			or_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(636);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Land_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_land_expression);
					setState(631);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(632);
					match(AmpAmp);
					setState(633);
					or_expression(0);
					}
					} 
				}
				setState(638);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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
		public TerminalNode OrOr() { return getToken(C99A3Parser.OrOr, 0); }
		public Lor_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lor_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitLor_expression(this);
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
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_lor_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(640);
			land_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(647);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Lor_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_lor_expression);
					setState(642);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(643);
					match(OrOr);
					setState(644);
					land_expression(0);
					}
					} 
				}
				setState(649);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
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
		public TerminalNode Questi() { return getToken(C99A3Parser.Questi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Colon() { return getToken(C99A3Parser.Colon, 0); }
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public Conditional_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitConditional_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conditional_expressionContext conditional_expression() throws RecognitionException {
		Conditional_expressionContext _localctx = new Conditional_expressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_conditional_expression);
		try {
			setState(657);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(650);
				lor_expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(651);
				lor_expression(0);
				setState(652);
				match(Questi);
				setState(653);
				expression();
				setState(654);
				match(Colon);
				setState(655);
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
		public TerminalNode Assign() { return getToken(C99A3Parser.Assign, 0); }
		public TerminalNode MulAsg() { return getToken(C99A3Parser.MulAsg, 0); }
		public TerminalNode DivAsg() { return getToken(C99A3Parser.DivAsg, 0); }
		public TerminalNode ModAsg() { return getToken(C99A3Parser.ModAsg, 0); }
		public TerminalNode PluAsg() { return getToken(C99A3Parser.PluAsg, 0); }
		public TerminalNode SubAsg() { return getToken(C99A3Parser.SubAsg, 0); }
		public TerminalNode LShAsg() { return getToken(C99A3Parser.LShAsg, 0); }
		public TerminalNode RShAsg() { return getToken(C99A3Parser.RShAsg, 0); }
		public TerminalNode AndAsg() { return getToken(C99A3Parser.AndAsg, 0); }
		public TerminalNode XorAsg() { return getToken(C99A3Parser.XorAsg, 0); }
		public TerminalNode OrAsg() { return getToken(C99A3Parser.OrAsg, 0); }
		public Assignment_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitAssignment_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assignment_expressionContext assignment_expression() throws RecognitionException {
		Assignment_expressionContext _localctx = new Assignment_expressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_assignment_expression);
		int _la;
		try {
			setState(664);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(659);
				conditional_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(660);
				unary_expression();
				setState(661);
				_la = _input.LA(1);
				if ( !(((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & 4294968319L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(662);
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
		public List<TerminalNode> Comma() { return getTokens(C99A3Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C99A3Parser.Comma, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(666);
			assignment_expression();
			setState(671);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(667);
				match(Comma);
				setState(668);
				assignment_expression();
				}
				}
				setState(673);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitConstant_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constant_expressionContext constant_expression() throws RecognitionException {
		Constant_expressionContext _localctx = new Constant_expressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_constant_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(674);
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
		public TerminalNode Semico() { return getToken(C99A3Parser.Semico, 0); }
		public Init_declarator_listContext init_declarator_list() {
			return getRuleContext(Init_declarator_listContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(676);
			declaration_specifiers();
			setState(678);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 33816577L) != 0)) {
				{
				setState(677);
				init_declarator_list();
				}
			}

			setState(680);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitDeclaration_specifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaration_specifiersContext declaration_specifiers() throws RecognitionException {
		Declaration_specifiersContext _localctx = new Declaration_specifiersContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_declaration_specifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(686); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					setState(686);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case Auto:
					case Extern:
					case Register:
					case Static:
					case Typedef:
					case SRAM:
					case RWTWICE:
					case ROTWICE:
					case WOTWICE:
						{
						setState(682);
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
						setState(683);
						type_specifier();
						}
						break;
					case Const:
					case Restrict:
					case Volatile:
						{
						setState(684);
						type_qualifier();
						}
						break;
					case Inline:
						{
						setState(685);
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
				setState(688); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
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
		public TerminalNode Typedef() { return getToken(C99A3Parser.Typedef, 0); }
		public TerminalNode Extern() { return getToken(C99A3Parser.Extern, 0); }
		public TerminalNode Static() { return getToken(C99A3Parser.Static, 0); }
		public TerminalNode Auto() { return getToken(C99A3Parser.Auto, 0); }
		public TerminalNode Register() { return getToken(C99A3Parser.Register, 0); }
		public TerminalNode SRAM() { return getToken(C99A3Parser.SRAM, 0); }
		public TerminalNode RWTWICE() { return getToken(C99A3Parser.RWTWICE, 0); }
		public TerminalNode ROTWICE() { return getToken(C99A3Parser.ROTWICE, 0); }
		public TerminalNode WOTWICE() { return getToken(C99A3Parser.WOTWICE, 0); }
		public Storage_class_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storage_class_specifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitStorage_class_specifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Storage_class_specifierContext storage_class_specifier() throws RecognitionException {
		Storage_class_specifierContext _localctx = new Storage_class_specifierContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_storage_class_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(690);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 135107989426147330L) != 0)) ) {
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
		public TerminalNode Inline() { return getToken(C99A3Parser.Inline, 0); }
		public Function_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_specifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitFunction_specifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_specifierContext function_specifier() throws RecognitionException {
		Function_specifierContext _localctx = new Function_specifierContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_function_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(692);
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
		public List<TerminalNode> Comma() { return getTokens(C99A3Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C99A3Parser.Comma, i);
		}
		public Init_declarator_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_declarator_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitInit_declarator_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Init_declarator_listContext init_declarator_list() throws RecognitionException {
		Init_declarator_listContext _localctx = new Init_declarator_listContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(694);
			init_declarator();
			setState(699);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(695);
				match(Comma);
				setState(696);
				init_declarator();
				}
				}
				setState(701);
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
		public TerminalNode Assign() { return getToken(C99A3Parser.Assign, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public Init_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_declarator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitInit_declarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Init_declaratorContext init_declarator() throws RecognitionException {
		Init_declaratorContext _localctx = new Init_declaratorContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(702);
			declarator();
			setState(705);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(703);
				match(Assign);
				setState(704);
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
		public TerminalNode Void() { return getToken(C99A3Parser.Void, 0); }
		public TerminalNode Char() { return getToken(C99A3Parser.Char, 0); }
		public TerminalNode Short() { return getToken(C99A3Parser.Short, 0); }
		public TerminalNode Int() { return getToken(C99A3Parser.Int, 0); }
		public TerminalNode Long() { return getToken(C99A3Parser.Long, 0); }
		public TerminalNode Float() { return getToken(C99A3Parser.Float, 0); }
		public TerminalNode Double() { return getToken(C99A3Parser.Double, 0); }
		public TerminalNode Signed() { return getToken(C99A3Parser.Signed, 0); }
		public TerminalNode Unsigned() { return getToken(C99A3Parser.Unsigned, 0); }
		public TerminalNode Bool() { return getToken(C99A3Parser.Bool, 0); }
		public TerminalNode Complex() { return getToken(C99A3Parser.Complex, 0); }
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitType_specifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_specifierContext type_specifier() throws RecognitionException {
		Type_specifierContext _localctx = new Type_specifierContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_type_specifier);
		int _la;
		try {
			setState(711);
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
				setState(707);
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
				setState(708);
				struct_or_union_specifier();
				}
				break;
			case Enum:
				enterOuterAlt(_localctx, 3);
				{
				setState(709);
				enum_specifier();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 4);
				{
				setState(710);
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
		public TerminalNode LeCuBr() { return getToken(C99A3Parser.LeCuBr, 0); }
		public Struct_declaration_listContext struct_declaration_list() {
			return getRuleContext(Struct_declaration_listContext.class,0);
		}
		public TerminalNode RiCuBr() { return getToken(C99A3Parser.RiCuBr, 0); }
		public TerminalNode Struct() { return getToken(C99A3Parser.Struct, 0); }
		public TerminalNode Union() { return getToken(C99A3Parser.Union, 0); }
		public TerminalNode Identifier() { return getToken(C99A3Parser.Identifier, 0); }
		public Struct_or_union_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_or_union_specifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitStruct_or_union_specifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_or_union_specifierContext struct_or_union_specifier() throws RecognitionException {
		Struct_or_union_specifierContext _localctx = new Struct_or_union_specifierContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_struct_or_union_specifier);
		int _la;
		try {
			setState(723);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(713);
				_la = _input.LA(1);
				if ( !(_la==Struct || _la==Union) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(715);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(714);
					match(Identifier);
					}
				}

				setState(717);
				match(LeCuBr);
				setState(718);
				struct_declaration_list();
				setState(719);
				match(RiCuBr);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(721);
				_la = _input.LA(1);
				if ( !(_la==Struct || _la==Union) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(722);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitStruct_declaration_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_declaration_listContext struct_declaration_list() throws RecognitionException {
		Struct_declaration_listContext _localctx = new Struct_declaration_listContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_struct_declaration_list);
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
				struct_declaration();
				}
				}
				setState(728); 
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
		public TerminalNode Semico() { return getToken(C99A3Parser.Semico, 0); }
		public Struct_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitStruct_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_declarationContext struct_declaration() throws RecognitionException {
		Struct_declarationContext _localctx = new Struct_declarationContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_struct_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			specifier_qualifier_list();
			setState(731);
			struct_declarator_list();
			setState(732);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitSpecifier_qualifier_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Specifier_qualifier_listContext specifier_qualifier_list() throws RecognitionException {
		Specifier_qualifier_listContext _localctx = new Specifier_qualifier_listContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_specifier_qualifier_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(736);
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
				setState(734);
				type_specifier();
				}
				break;
			case Const:
			case Restrict:
			case Volatile:
				{
				setState(735);
				type_qualifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(739);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(738);
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
		public List<TerminalNode> Comma() { return getTokens(C99A3Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C99A3Parser.Comma, i);
		}
		public Struct_declarator_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_declarator_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitStruct_declarator_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_declarator_listContext struct_declarator_list() throws RecognitionException {
		Struct_declarator_listContext _localctx = new Struct_declarator_listContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_struct_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(741);
			struct_declarator();
			setState(746);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(742);
				match(Comma);
				setState(743);
				struct_declarator();
				}
				}
				setState(748);
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
		public TerminalNode Colon() { return getToken(C99A3Parser.Colon, 0); }
		public Constant_expressionContext constant_expression() {
			return getRuleContext(Constant_expressionContext.class,0);
		}
		public Struct_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_declarator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitStruct_declarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_declaratorContext struct_declarator() throws RecognitionException {
		Struct_declaratorContext _localctx = new Struct_declaratorContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_struct_declarator);
		int _la;
		try {
			setState(755);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(749);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(751);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 33816577L) != 0)) {
					{
					setState(750);
					declarator();
					}
				}

				setState(753);
				match(Colon);
				setState(754);
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
		public TerminalNode Enum() { return getToken(C99A3Parser.Enum, 0); }
		public TerminalNode LeCuBr() { return getToken(C99A3Parser.LeCuBr, 0); }
		public Enumerator_listContext enumerator_list() {
			return getRuleContext(Enumerator_listContext.class,0);
		}
		public TerminalNode RiCuBr() { return getToken(C99A3Parser.RiCuBr, 0); }
		public TerminalNode Identifier() { return getToken(C99A3Parser.Identifier, 0); }
		public TerminalNode Comma() { return getToken(C99A3Parser.Comma, 0); }
		public Enum_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enum_specifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitEnum_specifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Enum_specifierContext enum_specifier() throws RecognitionException {
		Enum_specifierContext _localctx = new Enum_specifierContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_enum_specifier);
		int _la;
		try {
			setState(770);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(757);
				match(Enum);
				setState(759);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(758);
					match(Identifier);
					}
				}

				setState(761);
				match(LeCuBr);
				setState(762);
				enumerator_list();
				setState(764);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(763);
					match(Comma);
					}
				}

				setState(766);
				match(RiCuBr);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(768);
				match(Enum);
				setState(769);
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
		public List<TerminalNode> Comma() { return getTokens(C99A3Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C99A3Parser.Comma, i);
		}
		public Enumerator_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerator_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitEnumerator_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Enumerator_listContext enumerator_list() throws RecognitionException {
		Enumerator_listContext _localctx = new Enumerator_listContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_enumerator_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(772);
			enumerator();
			setState(777);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(773);
					match(Comma);
					setState(774);
					enumerator();
					}
					} 
				}
				setState(779);
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
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumeratorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(C99A3Parser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(C99A3Parser.Assign, 0); }
		public Constant_expressionContext constant_expression() {
			return getRuleContext(Constant_expressionContext.class,0);
		}
		public EnumeratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitEnumerator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumeratorContext enumerator() throws RecognitionException {
		EnumeratorContext _localctx = new EnumeratorContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_enumerator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(780);
			match(Identifier);
			setState(783);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(781);
				match(Assign);
				setState(782);
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
		public TerminalNode Const() { return getToken(C99A3Parser.Const, 0); }
		public TerminalNode Restrict() { return getToken(C99A3Parser.Restrict, 0); }
		public TerminalNode Volatile() { return getToken(C99A3Parser.Volatile, 0); }
		public Type_qualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_qualifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitType_qualifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_qualifierContext type_qualifier() throws RecognitionException {
		Type_qualifierContext _localctx = new Type_qualifierContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_type_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(785);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(788);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Star) {
				{
				setState(787);
				pointer();
				}
			}

			setState(790);
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
		public TerminalNode Identifier() { return getToken(C99A3Parser.Identifier, 0); }
		public TerminalNode LeRoBr() { return getToken(C99A3Parser.LeRoBr, 0); }
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode RiRoBr() { return getToken(C99A3Parser.RiRoBr, 0); }
		public Direct_declaratorContext direct_declarator() {
			return getRuleContext(Direct_declaratorContext.class,0);
		}
		public TerminalNode LeSqBr() { return getToken(C99A3Parser.LeSqBr, 0); }
		public TerminalNode RiSqBr() { return getToken(C99A3Parser.RiSqBr, 0); }
		public Type_qualifier_listContext type_qualifier_list() {
			return getRuleContext(Type_qualifier_listContext.class,0);
		}
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public TerminalNode Static() { return getToken(C99A3Parser.Static, 0); }
		public TerminalNode Star() { return getToken(C99A3Parser.Star, 0); }
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitDirect_declarator(this);
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
		int _startState = 102;
		enterRecursionRule(_localctx, 102, RULE_direct_declarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(798);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(793);
				match(Identifier);
				}
				break;
			case LeRoBr:
				{
				setState(794);
				match(LeRoBr);
				setState(795);
				declarator();
				setState(796);
				match(RiRoBr);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(845);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(843);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
					case 1:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(800);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(801);
						match(LeSqBr);
						setState(803);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
							{
							setState(802);
							type_qualifier_list();
							}
						}

						setState(806);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3464394563144122368L) != 0) || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 738721855L) != 0)) {
							{
							setState(805);
							assignment_expression();
							}
						}

						setState(808);
						match(RiSqBr);
						}
						break;
					case 2:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(809);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(810);
						match(LeSqBr);
						setState(811);
						match(Static);
						setState(813);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
							{
							setState(812);
							type_qualifier_list();
							}
						}

						setState(815);
						assignment_expression();
						setState(816);
						match(RiSqBr);
						}
						break;
					case 3:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(818);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(819);
						match(LeSqBr);
						setState(820);
						type_qualifier_list();
						setState(821);
						match(Static);
						setState(822);
						assignment_expression();
						setState(823);
						match(RiSqBr);
						}
						break;
					case 4:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(825);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(826);
						match(LeSqBr);
						setState(828);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
							{
							setState(827);
							type_qualifier_list();
							}
						}

						setState(830);
						match(Star);
						setState(831);
						match(RiSqBr);
						}
						break;
					case 5:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(832);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(833);
						match(LeRoBr);
						setState(834);
						parameter_type_list();
						setState(835);
						match(RiRoBr);
						}
						break;
					case 6:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(837);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(838);
						match(LeRoBr);
						setState(840);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==Identifier) {
							{
							setState(839);
							identifier_list();
							}
						}

						setState(842);
						match(RiRoBr);
						}
						break;
					}
					} 
				}
				setState(847);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
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
		public List<TerminalNode> Star() { return getTokens(C99A3Parser.Star); }
		public TerminalNode Star(int i) {
			return getToken(C99A3Parser.Star, i);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitPointer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointerContext pointer() throws RecognitionException {
		PointerContext _localctx = new PointerContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_pointer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(852); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(848);
				match(Star);
				setState(850);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
					{
					setState(849);
					type_qualifier_list();
					}
				}

				}
				}
				setState(854); 
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitType_qualifier_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_qualifier_listContext type_qualifier_list() throws RecognitionException {
		Type_qualifier_listContext _localctx = new Type_qualifier_listContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_type_qualifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(857); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(856);
				type_qualifier();
				}
				}
				setState(859); 
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
		public TerminalNode Comma() { return getToken(C99A3Parser.Comma, 0); }
		public TerminalNode ThreeP() { return getToken(C99A3Parser.ThreeP, 0); }
		public Parameter_type_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_type_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitParameter_type_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_type_listContext parameter_type_list() throws RecognitionException {
		Parameter_type_listContext _localctx = new Parameter_type_listContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_parameter_type_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(861);
			parameter_list();
			setState(864);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(862);
				match(Comma);
				setState(863);
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
		public List<TerminalNode> Comma() { return getTokens(C99A3Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C99A3Parser.Comma, i);
		}
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitParameter_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_parameter_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(866);
			parameter_declaration();
			setState(871);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(867);
					match(Comma);
					setState(868);
					parameter_declaration();
					}
					} 
				}
				setState(873);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitParameter_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_declarationContext parameter_declaration() throws RecognitionException {
		Parameter_declarationContext _localctx = new Parameter_declarationContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_parameter_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(874);
			declaration_specifiers();
			setState(879);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				{
				setState(875);
				declarator();
				}
				break;
			case 2:
				{
				setState(877);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 327681L) != 0)) {
					{
					setState(876);
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
		public List<TerminalNode> Identifier() { return getTokens(C99A3Parser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(C99A3Parser.Identifier, i);
		}
		public List<TerminalNode> Comma() { return getTokens(C99A3Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C99A3Parser.Comma, i);
		}
		public Identifier_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitIdentifier_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Identifier_listContext identifier_list() throws RecognitionException {
		Identifier_listContext _localctx = new Identifier_listContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_identifier_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(881);
			match(Identifier);
			setState(886);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(882);
					match(Comma);
					setState(883);
					match(Identifier);
					}
					} 
				}
				setState(888);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitType_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_type_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(889);
			specifier_qualifier_list();
			setState(891);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 327681L) != 0)) {
				{
				setState(890);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitAbstract_declarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Abstract_declaratorContext abstract_declarator() throws RecognitionException {
		Abstract_declaratorContext _localctx = new Abstract_declaratorContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_abstract_declarator);
		int _la;
		try {
			setState(898);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(893);
				pointer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(895);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Star) {
					{
					setState(894);
					pointer();
					}
				}

				setState(897);
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
		public TerminalNode LeRoBr() { return getToken(C99A3Parser.LeRoBr, 0); }
		public Abstract_declaratorContext abstract_declarator() {
			return getRuleContext(Abstract_declaratorContext.class,0);
		}
		public TerminalNode RiRoBr() { return getToken(C99A3Parser.RiRoBr, 0); }
		public TerminalNode LeSqBr() { return getToken(C99A3Parser.LeSqBr, 0); }
		public TerminalNode RiSqBr() { return getToken(C99A3Parser.RiSqBr, 0); }
		public Type_qualifier_listContext type_qualifier_list() {
			return getRuleContext(Type_qualifier_listContext.class,0);
		}
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public TerminalNode Static() { return getToken(C99A3Parser.Static, 0); }
		public TerminalNode Star() { return getToken(C99A3Parser.Star, 0); }
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitDirect_abstract_declarator(this);
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
		int _startState = 120;
		enterRecursionRule(_localctx, 120, RULE_direct_abstract_declarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(942);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				{
				setState(901);
				match(LeRoBr);
				setState(902);
				abstract_declarator();
				setState(903);
				match(RiRoBr);
				}
				break;
			case 2:
				{
				setState(905);
				match(LeSqBr);
				setState(907);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
					{
					setState(906);
					type_qualifier_list();
					}
				}

				setState(910);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3464394563144122368L) != 0) || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 738721855L) != 0)) {
					{
					setState(909);
					assignment_expression();
					}
				}

				setState(912);
				match(RiSqBr);
				}
				break;
			case 3:
				{
				setState(913);
				match(LeSqBr);
				setState(914);
				match(Static);
				setState(916);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
					{
					setState(915);
					type_qualifier_list();
					}
				}

				setState(918);
				assignment_expression();
				setState(919);
				match(RiSqBr);
				}
				break;
			case 4:
				{
				setState(921);
				match(LeSqBr);
				setState(922);
				type_qualifier_list();
				setState(923);
				match(Static);
				setState(924);
				assignment_expression();
				setState(925);
				match(RiSqBr);
				}
				break;
			case 5:
				{
				setState(927);
				match(LeSqBr);
				setState(929);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
					{
					setState(928);
					type_qualifier_list();
					}
				}

				setState(931);
				match(Star);
				setState(932);
				match(RiSqBr);
				}
				break;
			case 6:
				{
				setState(933);
				match(LeRoBr);
				setState(934);
				parameter_type_list();
				setState(935);
				match(RiRoBr);
				}
				break;
			case 7:
				{
				setState(937);
				match(LeRoBr);
				setState(939);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(938);
					identifier_list();
					}
				}

				setState(941);
				match(RiRoBr);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(989);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(987);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
					case 1:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(944);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(945);
						match(LeSqBr);
						setState(947);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
							{
							setState(946);
							type_qualifier_list();
							}
						}

						setState(950);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3464394563144122368L) != 0) || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 738721855L) != 0)) {
							{
							setState(949);
							assignment_expression();
							}
						}

						setState(952);
						match(RiSqBr);
						}
						break;
					case 2:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(953);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(954);
						match(LeSqBr);
						setState(955);
						match(Static);
						setState(957);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
							{
							setState(956);
							type_qualifier_list();
							}
						}

						setState(959);
						assignment_expression();
						setState(960);
						match(RiSqBr);
						}
						break;
					case 3:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(962);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(963);
						match(LeSqBr);
						setState(964);
						type_qualifier_list();
						setState(965);
						match(Static);
						setState(966);
						assignment_expression();
						setState(967);
						match(RiSqBr);
						}
						break;
					case 4:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(969);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(970);
						match(LeSqBr);
						setState(972);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
							{
							setState(971);
							type_qualifier_list();
							}
						}

						setState(974);
						match(Star);
						setState(975);
						match(RiSqBr);
						}
						break;
					case 5:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(976);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(977);
						match(LeRoBr);
						setState(978);
						parameter_type_list();
						setState(979);
						match(RiRoBr);
						}
						break;
					case 6:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(981);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(982);
						match(LeRoBr);
						setState(984);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==Identifier) {
							{
							setState(983);
							identifier_list();
							}
						}

						setState(986);
						match(RiRoBr);
						}
						break;
					}
					} 
				}
				setState(991);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
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
		public TerminalNode Identifier() { return getToken(C99A3Parser.Identifier, 0); }
		public Typedef_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedef_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitTypedef_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Typedef_nameContext typedef_name() throws RecognitionException {
		Typedef_nameContext _localctx = new Typedef_nameContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_typedef_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(992);
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
		public TerminalNode LeCuBr() { return getToken(C99A3Parser.LeCuBr, 0); }
		public Initializer_listContext initializer_list() {
			return getRuleContext(Initializer_listContext.class,0);
		}
		public TerminalNode RiCuBr() { return getToken(C99A3Parser.RiCuBr, 0); }
		public TerminalNode Comma() { return getToken(C99A3Parser.Comma, 0); }
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_initializer);
		int _la;
		try {
			setState(1002);
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
				setState(994);
				assignment_expression();
				}
				break;
			case LeCuBr:
				enterOuterAlt(_localctx, 2);
				{
				setState(995);
				match(LeCuBr);
				setState(996);
				initializer_list();
				setState(998);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(997);
					match(Comma);
					}
				}

				setState(1000);
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
		public List<TerminalNode> Comma() { return getTokens(C99A3Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C99A3Parser.Comma, i);
		}
		public Initializer_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitInitializer_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Initializer_listContext initializer_list() throws RecognitionException {
		Initializer_listContext _localctx = new Initializer_listContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_initializer_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1005);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Period || _la==LeSqBr) {
				{
				setState(1004);
				designation();
				}
			}

			setState(1007);
			initializer();
			setState(1015);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1008);
					match(Comma);
					setState(1010);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Period || _la==LeSqBr) {
						{
						setState(1009);
						designation();
						}
					}

					setState(1012);
					initializer();
					}
					} 
				}
				setState(1017);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
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
		public TerminalNode Assign() { return getToken(C99A3Parser.Assign, 0); }
		public DesignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitDesignation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignationContext designation() throws RecognitionException {
		DesignationContext _localctx = new DesignationContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_designation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1018);
			designator_list();
			setState(1019);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitDesignator_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Designator_listContext designator_list() throws RecognitionException {
		Designator_listContext _localctx = new Designator_listContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_designator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1022); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1021);
				designator();
				}
				}
				setState(1024); 
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
		public TerminalNode LeSqBr() { return getToken(C99A3Parser.LeSqBr, 0); }
		public Constant_expressionContext constant_expression() {
			return getRuleContext(Constant_expressionContext.class,0);
		}
		public TerminalNode RiSqBr() { return getToken(C99A3Parser.RiSqBr, 0); }
		public TerminalNode Period() { return getToken(C99A3Parser.Period, 0); }
		public TerminalNode Identifier() { return getToken(C99A3Parser.Identifier, 0); }
		public DesignatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitDesignator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignatorContext designator() throws RecognitionException {
		DesignatorContext _localctx = new DesignatorContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_designator);
		try {
			setState(1032);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeSqBr:
				enterOuterAlt(_localctx, 1);
				{
				setState(1026);
				match(LeSqBr);
				setState(1027);
				constant_expression();
				setState(1028);
				match(RiSqBr);
				}
				break;
			case Period:
				enterOuterAlt(_localctx, 2);
				{
				setState(1030);
				match(Period);
				setState(1031);
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
		public TerminalNode TwoLSB() { return getToken(C99A3Parser.TwoLSB, 0); }
		public Identifier_listContext identifier_list() {
			return getRuleContext(Identifier_listContext.class,0);
		}
		public TerminalNode TwoRSB() { return getToken(C99A3Parser.TwoRSB, 0); }
		public Attributes_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributes_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitAttributes_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attributes_declarationContext attributes_declaration() throws RecognitionException {
		Attributes_declarationContext _localctx = new Attributes_declarationContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_attributes_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1034);
			match(TwoLSB);
			setState(1035);
			identifier_list();
			setState(1036);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_statement);
		try {
			setState(1045);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1038);
				asm_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1039);
				labeled_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1040);
				compound_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1041);
				expression_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1042);
				selection_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1043);
				iteration_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1044);
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
		public TerminalNode Identifier() { return getToken(C99A3Parser.Identifier, 0); }
		public TerminalNode Colon() { return getToken(C99A3Parser.Colon, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Case() { return getToken(C99A3Parser.Case, 0); }
		public Constant_expressionContext constant_expression() {
			return getRuleContext(Constant_expressionContext.class,0);
		}
		public TerminalNode Default() { return getToken(C99A3Parser.Default, 0); }
		public Labeled_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeled_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitLabeled_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Labeled_statementContext labeled_statement() throws RecognitionException {
		Labeled_statementContext _localctx = new Labeled_statementContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_labeled_statement);
		try {
			setState(1058);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1047);
				match(Identifier);
				setState(1048);
				match(Colon);
				setState(1049);
				statement();
				}
				break;
			case Case:
				enterOuterAlt(_localctx, 2);
				{
				setState(1050);
				match(Case);
				setState(1051);
				constant_expression();
				setState(1052);
				match(Colon);
				setState(1053);
				statement();
				}
				break;
			case Default:
				enterOuterAlt(_localctx, 3);
				{
				setState(1055);
				match(Default);
				setState(1056);
				match(Colon);
				setState(1057);
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
		public TerminalNode LeCuBr() { return getToken(C99A3Parser.LeCuBr, 0); }
		public TerminalNode RiCuBr() { return getToken(C99A3Parser.RiCuBr, 0); }
		public Block_item_listContext block_item_list() {
			return getRuleContext(Block_item_listContext.class,0);
		}
		public Compound_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitCompound_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_statementContext compound_statement() throws RecognitionException {
		Compound_statementContext _localctx = new Compound_statementContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_compound_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1060);
			match(LeCuBr);
			setState(1062);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3599502964248542206L) != 0) || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 740821055L) != 0)) {
				{
				setState(1061);
				block_item_list();
				}
			}

			setState(1064);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitBlock_item_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_item_listContext block_item_list() throws RecognitionException {
		Block_item_listContext _localctx = new Block_item_listContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_block_item_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1067); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1066);
				block_item();
				}
				}
				setState(1069); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 3599502964248542206L) != 0) || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 740821055L) != 0) );
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitBlock_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_itemContext block_item() throws RecognitionException {
		Block_itemContext _localctx = new Block_itemContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_block_item);
		try {
			setState(1073);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1071);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1072);
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
		public TerminalNode Semico() { return getToken(C99A3Parser.Semico, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expression_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitExpression_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression_statementContext expression_statement() throws RecognitionException {
		Expression_statementContext _localctx = new Expression_statementContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_expression_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1076);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3464394563144122368L) != 0) || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 738721855L) != 0)) {
				{
				setState(1075);
				expression();
				}
			}

			setState(1078);
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
		public TerminalNode If() { return getToken(C99A3Parser.If, 0); }
		public TerminalNode LeRoBr() { return getToken(C99A3Parser.LeRoBr, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RiRoBr() { return getToken(C99A3Parser.RiRoBr, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(C99A3Parser.Else, 0); }
		public TerminalNode Switch() { return getToken(C99A3Parser.Switch, 0); }
		public Selection_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitSelection_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Selection_statementContext selection_statement() throws RecognitionException {
		Selection_statementContext _localctx = new Selection_statementContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_selection_statement);
		try {
			setState(1100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1080);
				match(If);
				setState(1081);
				match(LeRoBr);
				setState(1082);
				expression();
				setState(1083);
				match(RiRoBr);
				setState(1084);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1086);
				match(If);
				setState(1087);
				match(LeRoBr);
				setState(1088);
				expression();
				setState(1089);
				match(RiRoBr);
				setState(1090);
				statement();
				setState(1091);
				match(Else);
				setState(1092);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1094);
				match(Switch);
				setState(1095);
				match(LeRoBr);
				setState(1096);
				expression();
				setState(1097);
				match(RiRoBr);
				setState(1098);
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
		public TerminalNode While() { return getToken(C99A3Parser.While, 0); }
		public TerminalNode LeRoBr() { return getToken(C99A3Parser.LeRoBr, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RiRoBr() { return getToken(C99A3Parser.RiRoBr, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Do() { return getToken(C99A3Parser.Do, 0); }
		public List<TerminalNode> Semico() { return getTokens(C99A3Parser.Semico); }
		public TerminalNode Semico(int i) {
			return getToken(C99A3Parser.Semico, i);
		}
		public TerminalNode For() { return getToken(C99A3Parser.For, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public Iteration_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iteration_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitIteration_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Iteration_statementContext iteration_statement() throws RecognitionException {
		Iteration_statementContext _localctx = new Iteration_statementContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_iteration_statement);
		int _la;
		try {
			setState(1144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1102);
				match(While);
				setState(1103);
				match(LeRoBr);
				setState(1104);
				expression();
				setState(1105);
				match(RiRoBr);
				setState(1106);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1108);
				match(Do);
				setState(1109);
				statement();
				setState(1110);
				match(While);
				setState(1111);
				match(LeRoBr);
				setState(1112);
				expression();
				setState(1113);
				match(RiRoBr);
				setState(1114);
				match(Semico);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1116);
				match(For);
				setState(1117);
				match(LeRoBr);
				setState(1119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3464394563144122368L) != 0) || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 738721855L) != 0)) {
					{
					setState(1118);
					expression();
					}
				}

				setState(1121);
				match(Semico);
				setState(1123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3464394563144122368L) != 0) || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 738721855L) != 0)) {
					{
					setState(1122);
					expression();
					}
				}

				setState(1125);
				match(Semico);
				setState(1127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3464394563144122368L) != 0) || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 738721855L) != 0)) {
					{
					setState(1126);
					expression();
					}
				}

				setState(1129);
				match(RiRoBr);
				setState(1130);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1131);
				match(For);
				setState(1132);
				match(LeRoBr);
				setState(1133);
				declaration();
				setState(1135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3464394563144122368L) != 0) || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 738721855L) != 0)) {
					{
					setState(1134);
					expression();
					}
				}

				setState(1137);
				match(Semico);
				setState(1139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3464394563144122368L) != 0) || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 738721855L) != 0)) {
					{
					setState(1138);
					expression();
					}
				}

				setState(1141);
				match(RiRoBr);
				setState(1142);
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
		public TerminalNode Goto() { return getToken(C99A3Parser.Goto, 0); }
		public TerminalNode Identifier() { return getToken(C99A3Parser.Identifier, 0); }
		public TerminalNode Semico() { return getToken(C99A3Parser.Semico, 0); }
		public TerminalNode Continue() { return getToken(C99A3Parser.Continue, 0); }
		public TerminalNode Break() { return getToken(C99A3Parser.Break, 0); }
		public TerminalNode Return() { return getToken(C99A3Parser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Jump_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jump_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitJump_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jump_statementContext jump_statement() throws RecognitionException {
		Jump_statementContext _localctx = new Jump_statementContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_jump_statement);
		int _la;
		try {
			setState(1158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Goto:
				enterOuterAlt(_localctx, 1);
				{
				setState(1146);
				match(Goto);
				setState(1147);
				match(Identifier);
				setState(1148);
				match(Semico);
				}
				break;
			case Continue:
				enterOuterAlt(_localctx, 2);
				{
				setState(1149);
				match(Continue);
				setState(1150);
				match(Semico);
				}
				break;
			case Break:
				enterOuterAlt(_localctx, 3);
				{
				setState(1151);
				match(Break);
				setState(1152);
				match(Semico);
				}
				break;
			case Return:
				enterOuterAlt(_localctx, 4);
				{
				setState(1153);
				match(Return);
				setState(1155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3464394563144122368L) != 0) || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 738721855L) != 0)) {
					{
					setState(1154);
					expression();
					}
				}

				setState(1157);
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
		public TerminalNode Asm() { return getToken(C99A3Parser.Asm, 0); }
		public TerminalNode LeRoBr() { return getToken(C99A3Parser.LeRoBr, 0); }
		public TerminalNode String_literal() { return getToken(C99A3Parser.String_literal, 0); }
		public TerminalNode RiRoBr() { return getToken(C99A3Parser.RiRoBr, 0); }
		public TerminalNode Semico() { return getToken(C99A3Parser.Semico, 0); }
		public Asm_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asm_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitAsm_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Asm_statementContext asm_statement() throws RecognitionException {
		Asm_statementContext _localctx = new Asm_statementContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_asm_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1160);
			match(Asm);
			setState(1161);
			match(LeRoBr);
			setState(1162);
			match(String_literal);
			setState(1163);
			match(RiRoBr);
			setState(1164);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitTranslation_unit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Translation_unitContext translation_unit() throws RecognitionException {
		Translation_unitContext _localctx = new Translation_unitContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_translation_unit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1167); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1166);
				external_declaration();
				}
				}
				setState(1169); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 135108108773898802L) != 0) || _la==TwoLSB || _la==Identifier );
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitExternal_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final External_declarationContext external_declaration() throws RecognitionException {
		External_declarationContext _localctx = new External_declarationContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_external_declaration);
		try {
			setState(1173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1171);
				function_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1172);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitFunction_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_function_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TwoLSB) {
				{
				{
				setState(1175);
				attributes_declaration();
				}
				}
				setState(1180);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1181);
			declaration_specifiers();
			setState(1182);
			declarator();
			setState(1184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 135108108773898802L) != 0) || _la==Identifier) {
				{
				setState(1183);
				declaration_list();
				}
			}

			setState(1186);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitDeclaration_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaration_listContext declaration_list() throws RecognitionException {
		Declaration_listContext _localctx = new Declaration_listContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_declaration_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1189); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1188);
				declaration();
				}
				}
				setState(1191); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 135108108773898802L) != 0) || _la==Identifier );
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
		case 12:
			return keyword_sempred((KeywordContext)_localctx, predIndex);
		case 15:
			return postfix_expression_sempred((Postfix_expressionContext)_localctx, predIndex);
		case 19:
			return multiplicative_expression_sempred((Multiplicative_expressionContext)_localctx, predIndex);
		case 20:
			return additive_expression_sempred((Additive_expressionContext)_localctx, predIndex);
		case 21:
			return shift_expression_sempred((Shift_expressionContext)_localctx, predIndex);
		case 22:
			return relational_expression_sempred((Relational_expressionContext)_localctx, predIndex);
		case 23:
			return equality_expression_sempred((Equality_expressionContext)_localctx, predIndex);
		case 24:
			return and_expression_sempred((And_expressionContext)_localctx, predIndex);
		case 25:
			return xor_expression_sempred((Xor_expressionContext)_localctx, predIndex);
		case 26:
			return or_expression_sempred((Or_expressionContext)_localctx, predIndex);
		case 27:
			return land_expression_sempred((Land_expressionContext)_localctx, predIndex);
		case 28:
			return lor_expression_sempred((Lor_expressionContext)_localctx, predIndex);
		case 51:
			return direct_declarator_sempred((Direct_declaratorContext)_localctx, predIndex);
		case 60:
			return direct_abstract_declarator_sempred((Direct_abstract_declaratorContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean keyword_sempred(KeywordContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return Grammar.GrammarFlags.isPreproc;
		case 1:
			return Grammar.GrammarFlags.isPreproc;
		case 2:
			return Grammar.GrammarFlags.isPreproc;
		case 3:
			return Grammar.GrammarFlags.isPreproc;
		case 4:
			return Grammar.GrammarFlags.isPreproc;
		case 5:
			return Grammar.GrammarFlags.isPreproc;
		case 6:
			return Grammar.GrammarFlags.isPreproc;
		case 7:
			return Grammar.GrammarFlags.isPreproc;
		case 8:
			return Grammar.GrammarFlags.isPreproc;
		case 9:
			return Grammar.GrammarFlags.isPreproc;
		case 10:
			return Grammar.GrammarFlags.isPreproc;
		case 11:
			return Grammar.GrammarFlags.isPreproc;
		case 12:
			return Grammar.GrammarFlags.isPreproc;
		}
		return true;
	}
	private boolean postfix_expression_sempred(Postfix_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 7);
		case 14:
			return precpred(_ctx, 6);
		case 15:
			return precpred(_ctx, 5);
		case 16:
			return precpred(_ctx, 4);
		case 17:
			return precpred(_ctx, 3);
		case 18:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multiplicative_expression_sempred(Multiplicative_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 19:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additive_expression_sempred(Additive_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 20:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean shift_expression_sempred(Shift_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 21:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relational_expression_sempred(Relational_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 22:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equality_expression_sempred(Equality_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 23:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean and_expression_sempred(And_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 24:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean xor_expression_sempred(Xor_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 25:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean or_expression_sempred(Or_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 26:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean land_expression_sempred(Land_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 27:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean lor_expression_sempred(Lor_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 28:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean direct_declarator_sempred(Direct_declaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 29:
			return precpred(_ctx, 6);
		case 30:
			return precpred(_ctx, 5);
		case 31:
			return precpred(_ctx, 4);
		case 32:
			return precpred(_ctx, 3);
		case 33:
			return precpred(_ctx, 2);
		case 34:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean direct_abstract_declarator_sempred(Direct_abstract_declaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 35:
			return precpred(_ctx, 12);
		case 36:
			return precpred(_ctx, 10);
		case 37:
			return precpred(_ctx, 8);
		case 38:
			return precpred(_ctx, 6);
		case 39:
			return precpred(_ctx, 4);
		case 40:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001x\u04aa\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0002"+
		"F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007J\u0002"+
		"K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007O\u0002"+
		"P\u0007P\u0002Q\u0007Q\u0001\u0000\u0003\u0000\u00a6\b\u0000\u0001\u0001"+
		"\u0004\u0001\u00a9\b\u0001\u000b\u0001\f\u0001\u00aa\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00b2\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0005\u0003\u00b6\b\u0003\n\u0003\f\u0003\u00b9\t\u0003"+
		"\u0001\u0003\u0003\u0003\u00bc\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0004\u0004\u00c3\b\u0004\u000b\u0004\f\u0004"+
		"\u00c4\u0001\u0004\u0001\u0004\u0003\u0004\u00c9\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00d0\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00d7"+
		"\b\u0004\u0003\u0004\u00d9\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0004\u0005\u00de\b\u0005\u000b\u0005\f\u0005\u00df\u0001\u0005\u0001"+
		"\u0005\u0003\u0005\u00e4\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u00ea\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0004\b\u00f3\b\b\u000b\b\f\b\u00f4\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00fe\b\b\u0001"+
		"\b\u0001\b\u0005\b\u0102\b\b\n\b\f\b\u0105\t\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u010f\b\b\n\b\f\b\u0112"+
		"\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0005\b\u011e\b\b\n\b\f\b\u0121\t\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0005\b\u0129\b\b\n\b\f\b\u012c\t\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0136\b\b\n"+
		"\b\f\b\u0139\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u013f\b\b\n\b"+
		"\f\b\u0142\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0148\b\b\n\b\f"+
		"\b\u014b\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0004\b\u0151\b\b\u000b\b"+
		"\f\b\u0152\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0159\b\b\u0001\t\u0005"+
		"\t\u015c\b\t\n\t\f\t\u015f\t\t\u0001\t\u0001\t\u0001\n\u0004\n\u0164\b"+
		"\n\u000b\n\f\n\u0165\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0170\b\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u01b7\b\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u01c2\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u01cc\b\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u01d0\b\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u01da\b\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u01e7\b\u000f\n\u000f\f\u000f"+
		"\u01ea\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u01ef\b"+
		"\u0010\n\u0010\f\u0010\u01f2\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0213\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u021b\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0005\u0013\u0223\b\u0013\n\u0013\f\u0013\u0226"+
		"\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0005\u0014\u022e\b\u0014\n\u0014\f\u0014\u0231\t\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015"+
		"\u0239\b\u0015\n\u0015\f\u0015\u023c\t\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u0244\b\u0016\n"+
		"\u0016\f\u0016\u0247\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u024f\b\u0017\n\u0017\f\u0017"+
		"\u0252\t\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0005\u0018\u025a\b\u0018\n\u0018\f\u0018\u025d\t\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005"+
		"\u0019\u0265\b\u0019\n\u0019\f\u0019\u0268\t\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u0270\b\u001a"+
		"\n\u001a\f\u001a\u0273\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u027b\b\u001b\n\u001b\f\u001b"+
		"\u027e\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0005\u001c\u0286\b\u001c\n\u001c\f\u001c\u0289\t\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0003\u001d\u0292\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0003\u001e\u0299\b\u001e\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0005\u001f\u029e\b\u001f\n\u001f\f\u001f\u02a1\t\u001f\u0001 "+
		"\u0001 \u0001!\u0001!\u0003!\u02a7\b!\u0001!\u0001!\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0004\"\u02af\b\"\u000b\"\f\"\u02b0\u0001#\u0001#\u0001$\u0001"+
		"$\u0001%\u0001%\u0001%\u0005%\u02ba\b%\n%\f%\u02bd\t%\u0001&\u0001&\u0001"+
		"&\u0003&\u02c2\b&\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u02c8\b\'\u0001"+
		"(\u0001(\u0003(\u02cc\b(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0003"+
		"(\u02d4\b(\u0001)\u0004)\u02d7\b)\u000b)\f)\u02d8\u0001*\u0001*\u0001"+
		"*\u0001*\u0001+\u0001+\u0003+\u02e1\b+\u0001+\u0003+\u02e4\b+\u0001,\u0001"+
		",\u0001,\u0005,\u02e9\b,\n,\f,\u02ec\t,\u0001-\u0001-\u0003-\u02f0\b-"+
		"\u0001-\u0001-\u0003-\u02f4\b-\u0001.\u0001.\u0003.\u02f8\b.\u0001.\u0001"+
		".\u0001.\u0003.\u02fd\b.\u0001.\u0001.\u0001.\u0001.\u0003.\u0303\b.\u0001"+
		"/\u0001/\u0001/\u0005/\u0308\b/\n/\f/\u030b\t/\u00010\u00010\u00010\u0003"+
		"0\u0310\b0\u00011\u00011\u00012\u00032\u0315\b2\u00012\u00012\u00013\u0001"+
		"3\u00013\u00013\u00013\u00013\u00033\u031f\b3\u00013\u00013\u00013\u0003"+
		"3\u0324\b3\u00013\u00033\u0327\b3\u00013\u00013\u00013\u00013\u00013\u0003"+
		"3\u032e\b3\u00013\u00013\u00013\u00013\u00013\u00013\u00013\u00013\u0001"+
		"3\u00013\u00013\u00013\u00013\u00033\u033d\b3\u00013\u00013\u00013\u0001"+
		"3\u00013\u00013\u00013\u00013\u00013\u00013\u00033\u0349\b3\u00013\u0005"+
		"3\u034c\b3\n3\f3\u034f\t3\u00014\u00014\u00034\u0353\b4\u00044\u0355\b"+
		"4\u000b4\f4\u0356\u00015\u00045\u035a\b5\u000b5\f5\u035b\u00016\u0001"+
		"6\u00016\u00036\u0361\b6\u00017\u00017\u00017\u00057\u0366\b7\n7\f7\u0369"+
		"\t7\u00018\u00018\u00018\u00038\u036e\b8\u00038\u0370\b8\u00019\u0001"+
		"9\u00019\u00059\u0375\b9\n9\f9\u0378\t9\u0001:\u0001:\u0003:\u037c\b:"+
		"\u0001;\u0001;\u0003;\u0380\b;\u0001;\u0003;\u0383\b;\u0001<\u0001<\u0001"+
		"<\u0001<\u0001<\u0001<\u0001<\u0003<\u038c\b<\u0001<\u0003<\u038f\b<\u0001"+
		"<\u0001<\u0001<\u0001<\u0003<\u0395\b<\u0001<\u0001<\u0001<\u0001<\u0001"+
		"<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0003<\u03a2\b<\u0001<\u0001"+
		"<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0003<\u03ac\b<\u0001<\u0003"+
		"<\u03af\b<\u0001<\u0001<\u0001<\u0003<\u03b4\b<\u0001<\u0003<\u03b7\b"+
		"<\u0001<\u0001<\u0001<\u0001<\u0001<\u0003<\u03be\b<\u0001<\u0001<\u0001"+
		"<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001"+
		"<\u0003<\u03cd\b<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001"+
		"<\u0001<\u0001<\u0003<\u03d9\b<\u0001<\u0005<\u03dc\b<\n<\f<\u03df\t<"+
		"\u0001=\u0001=\u0001>\u0001>\u0001>\u0001>\u0003>\u03e7\b>\u0001>\u0001"+
		">\u0003>\u03eb\b>\u0001?\u0003?\u03ee\b?\u0001?\u0001?\u0001?\u0003?\u03f3"+
		"\b?\u0001?\u0005?\u03f6\b?\n?\f?\u03f9\t?\u0001@\u0001@\u0001@\u0001A"+
		"\u0004A\u03ff\bA\u000bA\fA\u0400\u0001B\u0001B\u0001B\u0001B\u0001B\u0001"+
		"B\u0003B\u0409\bB\u0001C\u0001C\u0001C\u0001C\u0001D\u0001D\u0001D\u0001"+
		"D\u0001D\u0001D\u0001D\u0003D\u0416\bD\u0001E\u0001E\u0001E\u0001E\u0001"+
		"E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0003E\u0423\bE\u0001F\u0001"+
		"F\u0003F\u0427\bF\u0001F\u0001F\u0001G\u0004G\u042c\bG\u000bG\fG\u042d"+
		"\u0001H\u0001H\u0003H\u0432\bH\u0001I\u0003I\u0435\bI\u0001I\u0001I\u0001"+
		"J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001"+
		"J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0003"+
		"J\u044d\bJ\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0003K\u0460"+
		"\bK\u0001K\u0001K\u0003K\u0464\bK\u0001K\u0001K\u0003K\u0468\bK\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0001K\u0003K\u0470\bK\u0001K\u0001K\u0003"+
		"K\u0474\bK\u0001K\u0001K\u0001K\u0003K\u0479\bK\u0001L\u0001L\u0001L\u0001"+
		"L\u0001L\u0001L\u0001L\u0001L\u0001L\u0003L\u0484\bL\u0001L\u0003L\u0487"+
		"\bL\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001N\u0004N\u0490\bN\u000b"+
		"N\fN\u0491\u0001O\u0001O\u0003O\u0496\bO\u0001P\u0005P\u0499\bP\nP\fP"+
		"\u049c\tP\u0001P\u0001P\u0001P\u0003P\u04a1\bP\u0001P\u0001P\u0001Q\u0004"+
		"Q\u04a6\bQ\u000bQ\fQ\u04a7\u0001Q\u0003\u00aa\u0165\u02b0\r\u001e&(*,"+
		".02468fxR\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprt"+
		"vxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094"+
		"\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u0000\r\u0001\u00009p\u0001"+
		"\u0000Z_\u0001\u0000wx\u0002\u0000[[`a\u0001\u0000\\]\u0001\u0000>?\u0001"+
		"\u0000@C\u0001\u0000DE\u0002\u0000HQhh\u0006\u0000\u0001\u0001\f\f\u0014"+
		"\u0014\u001a\u001a\u001d\u001d58\u0007\u0000\u0004\u0004\t\t\r\r\u0012"+
		"\u0013\u0017\u0018\u001f #$\u0002\u0000\u001b\u001b\u001e\u001e\u0003"+
		"\u0000\u0005\u0005\u0015\u0015!!\u0548\u0000\u00a5\u0001\u0000\u0000\u0000"+
		"\u0002\u00a8\u0001\u0000\u0000\u0000\u0004\u00b1\u0001\u0000\u0000\u0000"+
		"\u0006\u00b3\u0001\u0000\u0000\u0000\b\u00d8\u0001\u0000\u0000\u0000\n"+
		"\u00da\u0001\u0000\u0000\u0000\f\u00e5\u0001\u0000\u0000\u0000\u000e\u00eb"+
		"\u0001\u0000\u0000\u0000\u0010\u0158\u0001\u0000\u0000\u0000\u0012\u015d"+
		"\u0001\u0000\u0000\u0000\u0014\u0163\u0001\u0000\u0000\u0000\u0016\u016f"+
		"\u0001\u0000\u0000\u0000\u0018\u01b6\u0001\u0000\u0000\u0000\u001a\u01b8"+
		"\u0001\u0000\u0000\u0000\u001c\u01c1\u0001\u0000\u0000\u0000\u001e\u01cf"+
		"\u0001\u0000\u0000\u0000 \u01eb\u0001\u0000\u0000\u0000\"\u0212\u0001"+
		"\u0000\u0000\u0000$\u021a\u0001\u0000\u0000\u0000&\u021c\u0001\u0000\u0000"+
		"\u0000(\u0227\u0001\u0000\u0000\u0000*\u0232\u0001\u0000\u0000\u0000,"+
		"\u023d\u0001\u0000\u0000\u0000.\u0248\u0001\u0000\u0000\u00000\u0253\u0001"+
		"\u0000\u0000\u00002\u025e\u0001\u0000\u0000\u00004\u0269\u0001\u0000\u0000"+
		"\u00006\u0274\u0001\u0000\u0000\u00008\u027f\u0001\u0000\u0000\u0000:"+
		"\u0291\u0001\u0000\u0000\u0000<\u0298\u0001\u0000\u0000\u0000>\u029a\u0001"+
		"\u0000\u0000\u0000@\u02a2\u0001\u0000\u0000\u0000B\u02a4\u0001\u0000\u0000"+
		"\u0000D\u02ae\u0001\u0000\u0000\u0000F\u02b2\u0001\u0000\u0000\u0000H"+
		"\u02b4\u0001\u0000\u0000\u0000J\u02b6\u0001\u0000\u0000\u0000L\u02be\u0001"+
		"\u0000\u0000\u0000N\u02c7\u0001\u0000\u0000\u0000P\u02d3\u0001\u0000\u0000"+
		"\u0000R\u02d6\u0001\u0000\u0000\u0000T\u02da\u0001\u0000\u0000\u0000V"+
		"\u02e0\u0001\u0000\u0000\u0000X\u02e5\u0001\u0000\u0000\u0000Z\u02f3\u0001"+
		"\u0000\u0000\u0000\\\u0302\u0001\u0000\u0000\u0000^\u0304\u0001\u0000"+
		"\u0000\u0000`\u030c\u0001\u0000\u0000\u0000b\u0311\u0001\u0000\u0000\u0000"+
		"d\u0314\u0001\u0000\u0000\u0000f\u031e\u0001\u0000\u0000\u0000h\u0354"+
		"\u0001\u0000\u0000\u0000j\u0359\u0001\u0000\u0000\u0000l\u035d\u0001\u0000"+
		"\u0000\u0000n\u0362\u0001\u0000\u0000\u0000p\u036a\u0001\u0000\u0000\u0000"+
		"r\u0371\u0001\u0000\u0000\u0000t\u0379\u0001\u0000\u0000\u0000v\u0382"+
		"\u0001\u0000\u0000\u0000x\u03ae\u0001\u0000\u0000\u0000z\u03e0\u0001\u0000"+
		"\u0000\u0000|\u03ea\u0001\u0000\u0000\u0000~\u03ed\u0001\u0000\u0000\u0000"+
		"\u0080\u03fa\u0001\u0000\u0000\u0000\u0082\u03fe\u0001\u0000\u0000\u0000"+
		"\u0084\u0408\u0001\u0000\u0000\u0000\u0086\u040a\u0001\u0000\u0000\u0000"+
		"\u0088\u0415\u0001\u0000\u0000\u0000\u008a\u0422\u0001\u0000\u0000\u0000"+
		"\u008c\u0424\u0001\u0000\u0000\u0000\u008e\u042b\u0001\u0000\u0000\u0000"+
		"\u0090\u0431\u0001\u0000\u0000\u0000\u0092\u0434\u0001\u0000\u0000\u0000"+
		"\u0094\u044c\u0001\u0000\u0000\u0000\u0096\u0478\u0001\u0000\u0000\u0000"+
		"\u0098\u0486\u0001\u0000\u0000\u0000\u009a\u0488\u0001\u0000\u0000\u0000"+
		"\u009c\u048f\u0001\u0000\u0000\u0000\u009e\u0495\u0001\u0000\u0000\u0000"+
		"\u00a0\u049a\u0001\u0000\u0000\u0000\u00a2\u04a5\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a6\u0003\u0002\u0001\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u0001\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a9\u0003\u0004\u0002\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000"+
		"\u00aa\u00a8\u0001\u0000\u0000\u0000\u00ab\u0003\u0001\u0000\u0000\u0000"+
		"\u00ac\u00b2\u0003\u0006\u0003\u0000\u00ad\u00b2\u0003\u0010\b\u0000\u00ae"+
		"\u00af\u0005j\u0000\u0000\u00af\u00b2\u0003\u0014\n\u0000\u00b0\u00b2"+
		"\u0003\u0012\t\u0000\u00b1\u00ac\u0001\u0000\u0000\u0000\u00b1\u00ad\u0001"+
		"\u0000\u0000\u0000\u00b1\u00ae\u0001\u0000\u0000\u0000\u00b1\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b2\u0005\u0001\u0000\u0000\u0000\u00b3\u00b7\u0003"+
		"\b\u0004\u0000\u00b4\u00b6\u0003\n\u0005\u0000\u00b5\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00bb\u0001\u0000"+
		"\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00bc\u0003\f\u0006"+
		"\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00be\u0003\u000e\u0007"+
		"\u0000\u00be\u0007\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005j\u0000\u0000"+
		"\u00c0\u00c2\u0005\u0010\u0000\u0000\u00c1\u00c3\u0003\u0016\u000b\u0000"+
		"\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c8\u0005s\u0000\u0000\u00c7"+
		"\u00c9\u0003\u0002\u0001\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c9\u0001\u0000\u0000\u0000\u00c9\u00d9\u0001\u0000\u0000\u0000\u00ca"+
		"\u00cb\u0005j\u0000\u0000\u00cb\u00cc\u0005)\u0000\u0000\u00cc\u00cd\u0005"+
		"t\u0000\u0000\u00cd\u00cf\u0005s\u0000\u0000\u00ce\u00d0\u0003\u0002\u0001"+
		"\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000"+
		"\u0000\u00d0\u00d9\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005j\u0000\u0000"+
		"\u00d2\u00d3\u0005*\u0000\u0000\u00d3\u00d4\u0005t\u0000\u0000\u00d4\u00d6"+
		"\u0005s\u0000\u0000\u00d5\u00d7\u0003\u0002\u0001\u0000\u00d6\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d9\u0001"+
		"\u0000\u0000\u0000\u00d8\u00bf\u0001\u0000\u0000\u0000\u00d8\u00ca\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d1\u0001\u0000\u0000\u0000\u00d9\t\u0001\u0000"+
		"\u0000\u0000\u00da\u00db\u0005j\u0000\u0000\u00db\u00dd\u0005+\u0000\u0000"+
		"\u00dc\u00de\u0003\u0016\u000b\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000"+
		"\u00de\u00df\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000"+
		"\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e3\u0005s\u0000\u0000\u00e2\u00e4\u0003\u0002\u0001\u0000\u00e3"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4"+
		"\u000b\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005j\u0000\u0000\u00e6\u00e7"+
		"\u0005\n\u0000\u0000\u00e7\u00e9\u0005s\u0000\u0000\u00e8\u00ea\u0003"+
		"\u0002\u0001\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001"+
		"\u0000\u0000\u0000\u00ea\r\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005j"+
		"\u0000\u0000\u00ec\u00ed\u0005,\u0000\u0000\u00ed\u00ee\u0005s\u0000\u0000"+
		"\u00ee\u000f\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005j\u0000\u0000\u00f0"+
		"\u00f2\u0005-\u0000\u0000\u00f1\u00f3\u0003\u0016\u000b\u0000\u00f2\u00f1"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f2"+
		"\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f6"+
		"\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005s\u0000\u0000\u00f7\u0159\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f9\u0005j\u0000\u0000\u00f9\u00fa\u0005(\u0000"+
		"\u0000\u00fa\u00fb\u0005t\u0000\u0000\u00fb\u00fd\u0005m\u0000\u0000\u00fc"+
		"\u00fe\u0003r9\u0000\u00fd\u00fc\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001"+
		"\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u0103\u0005"+
		"n\u0000\u0000\u0100\u0102\u0003\u0016\u000b\u0000\u0101\u0100\u0001\u0000"+
		"\u0000\u0000\u0102\u0105\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000"+
		"\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0106\u0001\u0000"+
		"\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000\u0106\u0159\u0005s\u0000"+
		"\u0000\u0107\u0108\u0005j\u0000\u0000\u0108\u0109\u0005(\u0000\u0000\u0109"+
		"\u010a\u0005t\u0000\u0000\u010a\u010b\u0005m\u0000\u0000\u010b\u010c\u0005"+
		":\u0000\u0000\u010c\u0110\u0005n\u0000\u0000\u010d\u010f\u0003\u0016\u000b"+
		"\u0000\u010e\u010d\u0001\u0000\u0000\u0000\u010f\u0112\u0001\u0000\u0000"+
		"\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000"+
		"\u0000\u0111\u0113\u0001\u0000\u0000\u0000\u0112\u0110\u0001\u0000\u0000"+
		"\u0000\u0113\u0159\u0005s\u0000\u0000\u0114\u0115\u0005j\u0000\u0000\u0115"+
		"\u0116\u0005(\u0000\u0000\u0116\u0117\u0005t\u0000\u0000\u0117\u0118\u0005"+
		"m\u0000\u0000\u0118\u0119\u0003r9\u0000\u0119\u011a\u0005i\u0000\u0000"+
		"\u011a\u011b\u0005:\u0000\u0000\u011b\u011f\u0005n\u0000\u0000\u011c\u011e"+
		"\u0003\u0016\u000b\u0000\u011d\u011c\u0001\u0000\u0000\u0000\u011e\u0121"+
		"\u0001\u0000\u0000\u0000\u011f\u011d\u0001\u0000\u0000\u0000\u011f\u0120"+
		"\u0001\u0000\u0000\u0000\u0120\u0122\u0001\u0000\u0000\u0000\u0121\u011f"+
		"\u0001\u0000\u0000\u0000\u0122\u0123\u0005s\u0000\u0000\u0123\u0159\u0001"+
		"\u0000\u0000\u0000\u0124\u0125\u0005j\u0000\u0000\u0125\u0126\u0005(\u0000"+
		"\u0000\u0126\u012a\u0005t\u0000\u0000\u0127\u0129\u0003\u0016\u000b\u0000"+
		"\u0128\u0127\u0001\u0000\u0000\u0000\u0129\u012c\u0001\u0000\u0000\u0000"+
		"\u012a\u0128\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000"+
		"\u012b\u012d\u0001\u0000\u0000\u0000\u012c\u012a\u0001\u0000\u0000\u0000"+
		"\u012d\u0159\u0005s\u0000\u0000\u012e\u012f\u0005j\u0000\u0000\u012f\u0130"+
		"\u0005.\u0000\u0000\u0130\u0131\u0005t\u0000\u0000\u0131\u0159\u0005s"+
		"\u0000\u0000\u0132\u0133\u0005j\u0000\u0000\u0133\u0137\u0005/\u0000\u0000"+
		"\u0134\u0136\u0003\u0016\u000b\u0000\u0135\u0134\u0001\u0000\u0000\u0000"+
		"\u0136\u0139\u0001\u0000\u0000\u0000\u0137\u0135\u0001\u0000\u0000\u0000"+
		"\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u013a\u0001\u0000\u0000\u0000"+
		"\u0139\u0137\u0001\u0000\u0000\u0000\u013a\u0159\u0005s\u0000\u0000\u013b"+
		"\u013c\u0005j\u0000\u0000\u013c\u0140\u00050\u0000\u0000\u013d\u013f\u0003"+
		"\u0016\u000b\u0000\u013e\u013d\u0001\u0000\u0000\u0000\u013f\u0142\u0001"+
		"\u0000\u0000\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0140\u0141\u0001"+
		"\u0000\u0000\u0000\u0141\u0143\u0001\u0000\u0000\u0000\u0142\u0140\u0001"+
		"\u0000\u0000\u0000\u0143\u0159\u0005s\u0000\u0000\u0144\u0145\u0005j\u0000"+
		"\u0000\u0145\u0149\u00051\u0000\u0000\u0146\u0148\u0003\u0016\u000b\u0000"+
		"\u0147\u0146\u0001\u0000\u0000\u0000\u0148\u014b\u0001\u0000\u0000\u0000"+
		"\u0149\u0147\u0001\u0000\u0000\u0000\u0149\u014a\u0001\u0000\u0000\u0000"+
		"\u014a\u014c\u0001\u0000\u0000\u0000\u014b\u0149\u0001\u0000\u0000\u0000"+
		"\u014c\u0159\u0005s\u0000\u0000\u014d\u014e\u0005j\u0000\u0000\u014e\u0150"+
		"\u00053\u0000\u0000\u014f\u0151\u0003\u0016\u000b\u0000\u0150\u014f\u0001"+
		"\u0000\u0000\u0000\u0151\u0152\u0001\u0000\u0000\u0000\u0152\u0150\u0001"+
		"\u0000\u0000\u0000\u0152\u0153\u0001\u0000\u0000\u0000\u0153\u0154\u0001"+
		"\u0000\u0000\u0000\u0154\u0155\u0005s\u0000\u0000\u0155\u0159\u0001\u0000"+
		"\u0000\u0000\u0156\u0157\u0005j\u0000\u0000\u0157\u0159\u0005s\u0000\u0000"+
		"\u0158\u00ef\u0001\u0000\u0000\u0000\u0158\u00f8\u0001\u0000\u0000\u0000"+
		"\u0158\u0107\u0001\u0000\u0000\u0000\u0158\u0114\u0001\u0000\u0000\u0000"+
		"\u0158\u0124\u0001\u0000\u0000\u0000\u0158\u012e\u0001\u0000\u0000\u0000"+
		"\u0158\u0132\u0001\u0000\u0000\u0000\u0158\u013b\u0001\u0000\u0000\u0000"+
		"\u0158\u0144\u0001\u0000\u0000\u0000\u0158\u014d\u0001\u0000\u0000\u0000"+
		"\u0158\u0156\u0001\u0000\u0000\u0000\u0159\u0011\u0001\u0000\u0000\u0000"+
		"\u015a\u015c\u0003\u0016\u000b\u0000\u015b\u015a\u0001\u0000\u0000\u0000"+
		"\u015c\u015f\u0001\u0000\u0000\u0000\u015d\u015b\u0001\u0000\u0000\u0000"+
		"\u015d\u015e\u0001\u0000\u0000\u0000\u015e\u0160\u0001\u0000\u0000\u0000"+
		"\u015f\u015d\u0001\u0000\u0000\u0000\u0160\u0161\u0005s\u0000\u0000\u0161"+
		"\u0013\u0001\u0000\u0000\u0000\u0162\u0164\u0003\u0016\u000b\u0000\u0163"+
		"\u0162\u0001\u0000\u0000\u0000\u0164\u0165\u0001\u0000\u0000\u0000\u0165"+
		"\u0166\u0001\u0000\u0000\u0000\u0165\u0163\u0001\u0000\u0000\u0000\u0166"+
		"\u0167\u0001\u0000\u0000\u0000\u0167\u0168\u0005s\u0000\u0000\u0168\u0015"+
		"\u0001\u0000\u0000\u0000\u0169\u0170\u0005x\u0000\u0000\u016a\u0170\u0005"+
		"t\u0000\u0000\u016b\u0170\u0005u\u0000\u0000\u016c\u0170\u0005w\u0000"+
		"\u0000\u016d\u0170\u0003\u0018\f\u0000\u016e\u0170\u0003\u001a\r\u0000"+
		"\u016f\u0169\u0001\u0000\u0000\u0000\u016f\u016a\u0001\u0000\u0000\u0000"+
		"\u016f\u016b\u0001\u0000\u0000\u0000\u016f\u016c\u0001\u0000\u0000\u0000"+
		"\u016f\u016d\u0001\u0000\u0000\u0000\u016f\u016e\u0001\u0000\u0000\u0000"+
		"\u0170\u0017\u0001\u0000\u0000\u0000\u0171\u01b7\u0005\u0001\u0000\u0000"+
		"\u0172\u01b7\u0005\u0002\u0000\u0000\u0173\u01b7\u0005\u0003\u0000\u0000"+
		"\u0174\u01b7\u0005\u0004\u0000\u0000\u0175\u01b7\u0005\u0005\u0000\u0000"+
		"\u0176\u01b7\u0005\u0006\u0000\u0000\u0177\u01b7\u0005\u0007\u0000\u0000"+
		"\u0178\u01b7\u0005\b\u0000\u0000\u0179\u01b7\u0005\t\u0000\u0000\u017a"+
		"\u01b7\u0005\n\u0000\u0000\u017b\u01b7\u0005\u000b\u0000\u0000\u017c\u01b7"+
		"\u0005\f\u0000\u0000\u017d\u01b7\u0005\r\u0000\u0000\u017e\u01b7\u0005"+
		"\u000e\u0000\u0000\u017f\u01b7\u0005\u000f\u0000\u0000\u0180\u01b7\u0005"+
		"\u0010\u0000\u0000\u0181\u01b7\u0005\u0011\u0000\u0000\u0182\u01b7\u0005"+
		"\u0012\u0000\u0000\u0183\u01b7\u0005\u0013\u0000\u0000\u0184\u01b7\u0005"+
		"\u0014\u0000\u0000\u0185\u01b7\u0005\u0015\u0000\u0000\u0186\u01b7\u0005"+
		"\u0016\u0000\u0000\u0187\u01b7\u0005\u0017\u0000\u0000\u0188\u01b7\u0005"+
		"\u0018\u0000\u0000\u0189\u01b7\u0005\u0019\u0000\u0000\u018a\u01b7\u0005"+
		"\u001a\u0000\u0000\u018b\u01b7\u0005\u001b\u0000\u0000\u018c\u01b7\u0005"+
		"\u001c\u0000\u0000\u018d\u01b7\u0005\u001d\u0000\u0000\u018e\u01b7\u0005"+
		"\u001e\u0000\u0000\u018f\u01b7\u0005\u001f\u0000\u0000\u0190\u01b7\u0005"+
		" \u0000\u0000\u0191\u01b7\u0005!\u0000\u0000\u0192\u01b7\u0005\"\u0000"+
		"\u0000\u0193\u01b7\u0005#\u0000\u0000\u0194\u01b7\u0005$\u0000\u0000\u0195"+
		"\u01b7\u0005%\u0000\u0000\u0196\u01b7\u0005&\u0000\u0000\u0197\u0198\u0005"+
		"\'\u0000\u0000\u0198\u01b7\u0004\f\u0000\u0000\u0199\u019a\u0005(\u0000"+
		"\u0000\u019a\u01b7\u0004\f\u0001\u0000\u019b\u019c\u0005)\u0000\u0000"+
		"\u019c\u01b7\u0004\f\u0002\u0000\u019d\u019e\u0005*\u0000\u0000\u019e"+
		"\u01b7\u0004\f\u0003\u0000\u019f\u01a0\u0005+\u0000\u0000\u01a0\u01b7"+
		"\u0004\f\u0004\u0000\u01a1\u01a2\u0005,\u0000\u0000\u01a2\u01b7\u0004"+
		"\f\u0005\u0000\u01a3\u01a4\u0005-\u0000\u0000\u01a4\u01b7\u0004\f\u0006"+
		"\u0000\u01a5\u01a6\u0005.\u0000\u0000\u01a6\u01b7\u0004\f\u0007\u0000"+
		"\u01a7\u01a8\u0005/\u0000\u0000\u01a8\u01b7\u0004\f\b\u0000\u01a9\u01aa"+
		"\u00050\u0000\u0000\u01aa\u01b7\u0004\f\t\u0000\u01ab\u01ac\u00051\u0000"+
		"\u0000\u01ac\u01b7\u0004\f\n\u0000\u01ad\u01ae\u00052\u0000\u0000\u01ae"+
		"\u01b7\u0004\f\u000b\u0000\u01af\u01b0\u00053\u0000\u0000\u01b0\u01b7"+
		"\u0004\f\f\u0000\u01b1\u01b7\u00054\u0000\u0000\u01b2\u01b7\u00055\u0000"+
		"\u0000\u01b3\u01b7\u00056\u0000\u0000\u01b4\u01b7\u00057\u0000\u0000\u01b5"+
		"\u01b7\u00058\u0000\u0000\u01b6\u0171\u0001\u0000\u0000\u0000\u01b6\u0172"+
		"\u0001\u0000\u0000\u0000\u01b6\u0173\u0001\u0000\u0000\u0000\u01b6\u0174"+
		"\u0001\u0000\u0000\u0000\u01b6\u0175\u0001\u0000\u0000\u0000\u01b6\u0176"+
		"\u0001\u0000\u0000\u0000\u01b6\u0177\u0001\u0000\u0000\u0000\u01b6\u0178"+
		"\u0001\u0000\u0000\u0000\u01b6\u0179\u0001\u0000\u0000\u0000\u01b6\u017a"+
		"\u0001\u0000\u0000\u0000\u01b6\u017b\u0001\u0000\u0000\u0000\u01b6\u017c"+
		"\u0001\u0000\u0000\u0000\u01b6\u017d\u0001\u0000\u0000\u0000\u01b6\u017e"+
		"\u0001\u0000\u0000\u0000\u01b6\u017f\u0001\u0000\u0000\u0000\u01b6\u0180"+
		"\u0001\u0000\u0000\u0000\u01b6\u0181\u0001\u0000\u0000\u0000\u01b6\u0182"+
		"\u0001\u0000\u0000\u0000\u01b6\u0183\u0001\u0000\u0000\u0000\u01b6\u0184"+
		"\u0001\u0000\u0000\u0000\u01b6\u0185\u0001\u0000\u0000\u0000\u01b6\u0186"+
		"\u0001\u0000\u0000\u0000\u01b6\u0187\u0001\u0000\u0000\u0000\u01b6\u0188"+
		"\u0001\u0000\u0000\u0000\u01b6\u0189\u0001\u0000\u0000\u0000\u01b6\u018a"+
		"\u0001\u0000\u0000\u0000\u01b6\u018b\u0001\u0000\u0000\u0000\u01b6\u018c"+
		"\u0001\u0000\u0000\u0000\u01b6\u018d\u0001\u0000\u0000\u0000\u01b6\u018e"+
		"\u0001\u0000\u0000\u0000\u01b6\u018f\u0001\u0000\u0000\u0000\u01b6\u0190"+
		"\u0001\u0000\u0000\u0000\u01b6\u0191\u0001\u0000\u0000\u0000\u01b6\u0192"+
		"\u0001\u0000\u0000\u0000\u01b6\u0193\u0001\u0000\u0000\u0000\u01b6\u0194"+
		"\u0001\u0000\u0000\u0000\u01b6\u0195\u0001\u0000\u0000\u0000\u01b6\u0196"+
		"\u0001\u0000\u0000\u0000\u01b6\u0197\u0001\u0000\u0000\u0000\u01b6\u0199"+
		"\u0001\u0000\u0000\u0000\u01b6\u019b\u0001\u0000\u0000\u0000\u01b6\u019d"+
		"\u0001\u0000\u0000\u0000\u01b6\u019f\u0001\u0000\u0000\u0000\u01b6\u01a1"+
		"\u0001\u0000\u0000\u0000\u01b6\u01a3\u0001\u0000\u0000\u0000\u01b6\u01a5"+
		"\u0001\u0000\u0000\u0000\u01b6\u01a7\u0001\u0000\u0000\u0000\u01b6\u01a9"+
		"\u0001\u0000\u0000\u0000\u01b6\u01ab\u0001\u0000\u0000\u0000\u01b6\u01ad"+
		"\u0001\u0000\u0000\u0000\u01b6\u01af\u0001\u0000\u0000\u0000\u01b6\u01b1"+
		"\u0001\u0000\u0000\u0000\u01b6\u01b2\u0001\u0000\u0000\u0000\u01b6\u01b3"+
		"\u0001\u0000\u0000\u0000\u01b6\u01b4\u0001\u0000\u0000\u0000\u01b6\u01b5"+
		"\u0001\u0000\u0000\u0000\u01b7\u0019\u0001\u0000\u0000\u0000\u01b8\u01b9"+
		"\u0007\u0000\u0000\u0000\u01b9\u001b\u0001\u0000\u0000\u0000\u01ba\u01c2"+
		"\u0005t\u0000\u0000\u01bb\u01c2\u0005u\u0000\u0000\u01bc\u01c2\u0005w"+
		"\u0000\u0000\u01bd\u01be\u0005m\u0000\u0000\u01be\u01bf\u0003>\u001f\u0000"+
		"\u01bf\u01c0\u0005n\u0000\u0000\u01c0\u01c2\u0001\u0000\u0000\u0000\u01c1"+
		"\u01ba\u0001\u0000\u0000\u0000\u01c1\u01bb\u0001\u0000\u0000\u0000\u01c1"+
		"\u01bc\u0001\u0000\u0000\u0000\u01c1\u01bd\u0001\u0000\u0000\u0000\u01c2"+
		"\u001d\u0001\u0000\u0000\u0000\u01c3\u01c4\u0006\u000f\uffff\uffff\u0000"+
		"\u01c4\u01d0\u0003\u001c\u000e\u0000\u01c5\u01c6\u0005m\u0000\u0000\u01c6"+
		"\u01c7\u0003t:\u0000\u01c7\u01c8\u0005n\u0000\u0000\u01c8\u01c9\u0005"+
		"o\u0000\u0000\u01c9\u01cb\u0003~?\u0000\u01ca\u01cc\u0005i\u0000\u0000"+
		"\u01cb\u01ca\u0001\u0000\u0000\u0000\u01cb\u01cc\u0001\u0000\u0000\u0000"+
		"\u01cc\u01cd\u0001\u0000\u0000\u0000\u01cd\u01ce\u0005p\u0000\u0000\u01ce"+
		"\u01d0\u0001\u0000\u0000\u0000\u01cf\u01c3\u0001\u0000\u0000\u0000\u01cf"+
		"\u01c5\u0001\u0000\u0000\u0000\u01d0\u01e8\u0001\u0000\u0000\u0000\u01d1"+
		"\u01d2\n\u0007\u0000\u0000\u01d2\u01d3\u0005k\u0000\u0000\u01d3\u01d4"+
		"\u0003>\u001f\u0000\u01d4\u01d5\u0005l\u0000\u0000\u01d5\u01e7\u0001\u0000"+
		"\u0000\u0000\u01d6\u01d7\n\u0006\u0000\u0000\u01d7\u01d9\u0005m\u0000"+
		"\u0000\u01d8\u01da\u0003 \u0010\u0000\u01d9\u01d8\u0001\u0000\u0000\u0000"+
		"\u01d9\u01da\u0001\u0000\u0000\u0000\u01da\u01db\u0001\u0000\u0000\u0000"+
		"\u01db\u01e7\u0005n\u0000\u0000\u01dc\u01dd\n\u0005\u0000\u0000\u01dd"+
		"\u01de\u0005f\u0000\u0000\u01de\u01e7\u0005t\u0000\u0000\u01df\u01e0\n"+
		"\u0004\u0000\u0000\u01e0\u01e1\u0005;\u0000\u0000\u01e1\u01e7\u0005t\u0000"+
		"\u0000\u01e2\u01e3\n\u0003\u0000\u0000\u01e3\u01e7\u0005<\u0000\u0000"+
		"\u01e4\u01e5\n\u0002\u0000\u0000\u01e5\u01e7\u0005=\u0000\u0000\u01e6"+
		"\u01d1\u0001\u0000\u0000\u0000\u01e6\u01d6\u0001\u0000\u0000\u0000\u01e6"+
		"\u01dc\u0001\u0000\u0000\u0000\u01e6\u01df\u0001\u0000\u0000\u0000\u01e6"+
		"\u01e2\u0001\u0000\u0000\u0000\u01e6\u01e4\u0001\u0000\u0000\u0000\u01e7"+
		"\u01ea\u0001\u0000\u0000\u0000\u01e8\u01e6\u0001\u0000\u0000\u0000\u01e8"+
		"\u01e9\u0001\u0000\u0000\u0000\u01e9\u001f\u0001\u0000\u0000\u0000\u01ea"+
		"\u01e8\u0001\u0000\u0000\u0000\u01eb\u01f0\u0003<\u001e\u0000\u01ec\u01ed"+
		"\u0005i\u0000\u0000\u01ed\u01ef\u0003<\u001e\u0000\u01ee\u01ec\u0001\u0000"+
		"\u0000\u0000\u01ef\u01f2\u0001\u0000\u0000\u0000\u01f0\u01ee\u0001\u0000"+
		"\u0000\u0000\u01f0\u01f1\u0001\u0000\u0000\u0000\u01f1!\u0001\u0000\u0000"+
		"\u0000\u01f2\u01f0\u0001\u0000\u0000\u0000\u01f3\u0213\u0003\u001e\u000f"+
		"\u0000\u01f4\u01f5\u0005<\u0000\u0000\u01f5\u0213\u0003\"\u0011\u0000"+
		"\u01f6\u01f7\u0005=\u0000\u0000\u01f7\u0213\u0003\"\u0011\u0000\u01f8"+
		"\u01f9\u0007\u0001\u0000\u0000\u01f9\u0213\u0003$\u0012\u0000\u01fa\u01fb"+
		"\u0005\u0019\u0000\u0000\u01fb\u0213\u0003\"\u0011\u0000\u01fc\u01fd\u0005"+
		"\u0019\u0000\u0000\u01fd\u01fe\u0005m\u0000\u0000\u01fe\u01ff\u0003t:"+
		"\u0000\u01ff\u0200\u0005n\u0000\u0000\u0200\u0213\u0001\u0000\u0000\u0000"+
		"\u0201\u0202\u00052\u0000\u0000\u0202\u0203\u0005m\u0000\u0000\u0203\u0204"+
		"\u0007\u0002\u0000\u0000\u0204\u0213\u0005n\u0000\u0000\u0205\u0206\u0005"+
		"\'\u0000\u0000\u0206\u0213\u0005t\u0000\u0000\u0207\u0208\u0005\'\u0000"+
		"\u0000\u0208\u0209\u0005m\u0000\u0000\u0209\u020a\u0005t\u0000\u0000\u020a"+
		"\u0213\u0005n\u0000\u0000\u020b\u020c\u00054\u0000\u0000\u020c\u020d\u0005"+
		"m\u0000\u0000\u020d\u020e\u0003t:\u0000\u020e\u020f\u0005i\u0000\u0000"+
		"\u020f\u0210\u0005t\u0000\u0000\u0210\u0211\u0005n\u0000\u0000\u0211\u0213"+
		"\u0001\u0000\u0000\u0000\u0212\u01f3\u0001\u0000\u0000\u0000\u0212\u01f4"+
		"\u0001\u0000\u0000\u0000\u0212\u01f6\u0001\u0000\u0000\u0000\u0212\u01f8"+
		"\u0001\u0000\u0000\u0000\u0212\u01fa\u0001\u0000\u0000\u0000\u0212\u01fc"+
		"\u0001\u0000\u0000\u0000\u0212\u0201\u0001\u0000\u0000\u0000\u0212\u0205"+
		"\u0001\u0000\u0000\u0000\u0212\u0207\u0001\u0000\u0000\u0000\u0212\u020b"+
		"\u0001\u0000\u0000\u0000\u0213#\u0001\u0000\u0000\u0000\u0214\u0215\u0005"+
		"m\u0000\u0000\u0215\u0216\u0003t:\u0000\u0216\u0217\u0005n\u0000\u0000"+
		"\u0217\u0218\u0003$\u0012\u0000\u0218\u021b\u0001\u0000\u0000\u0000\u0219"+
		"\u021b\u0003\"\u0011\u0000\u021a\u0214\u0001\u0000\u0000\u0000\u021a\u0219"+
		"\u0001\u0000\u0000\u0000\u021b%\u0001\u0000\u0000\u0000\u021c\u021d\u0006"+
		"\u0013\uffff\uffff\u0000\u021d\u021e\u0003$\u0012\u0000\u021e\u0224\u0001"+
		"\u0000\u0000\u0000\u021f\u0220\n\u0001\u0000\u0000\u0220\u0221\u0007\u0003"+
		"\u0000\u0000\u0221\u0223\u0003$\u0012\u0000\u0222\u021f\u0001\u0000\u0000"+
		"\u0000\u0223\u0226\u0001\u0000\u0000\u0000\u0224\u0222\u0001\u0000\u0000"+
		"\u0000\u0224\u0225\u0001\u0000\u0000\u0000\u0225\'\u0001\u0000\u0000\u0000"+
		"\u0226\u0224\u0001\u0000\u0000\u0000\u0227\u0228\u0006\u0014\uffff\uffff"+
		"\u0000\u0228\u0229\u0003&\u0013\u0000\u0229\u022f\u0001\u0000\u0000\u0000"+
		"\u022a\u022b\n\u0001\u0000\u0000\u022b\u022c\u0007\u0004\u0000\u0000\u022c"+
		"\u022e\u0003&\u0013\u0000\u022d\u022a\u0001\u0000\u0000\u0000\u022e\u0231"+
		"\u0001\u0000\u0000\u0000\u022f\u022d\u0001\u0000\u0000\u0000\u022f\u0230"+
		"\u0001\u0000\u0000\u0000\u0230)\u0001\u0000\u0000\u0000\u0231\u022f\u0001"+
		"\u0000\u0000\u0000\u0232\u0233\u0006\u0015\uffff\uffff\u0000\u0233\u0234"+
		"\u0003(\u0014\u0000\u0234\u023a\u0001\u0000\u0000\u0000\u0235\u0236\n"+
		"\u0001\u0000\u0000\u0236\u0237\u0007\u0005\u0000\u0000\u0237\u0239\u0003"+
		"(\u0014\u0000\u0238\u0235\u0001\u0000\u0000\u0000\u0239\u023c\u0001\u0000"+
		"\u0000\u0000\u023a\u0238\u0001\u0000\u0000\u0000\u023a\u023b\u0001\u0000"+
		"\u0000\u0000\u023b+\u0001\u0000\u0000\u0000\u023c\u023a\u0001\u0000\u0000"+
		"\u0000\u023d\u023e\u0006\u0016\uffff\uffff\u0000\u023e\u023f\u0003*\u0015"+
		"\u0000\u023f\u0245\u0001\u0000\u0000\u0000\u0240\u0241\n\u0001\u0000\u0000"+
		"\u0241\u0242\u0007\u0006\u0000\u0000\u0242\u0244\u0003*\u0015\u0000\u0243"+
		"\u0240\u0001\u0000\u0000\u0000\u0244\u0247\u0001\u0000\u0000\u0000\u0245"+
		"\u0243\u0001\u0000\u0000\u0000\u0245\u0246\u0001\u0000\u0000\u0000\u0246"+
		"-\u0001\u0000\u0000\u0000\u0247\u0245\u0001\u0000\u0000\u0000\u0248\u0249"+
		"\u0006\u0017\uffff\uffff\u0000\u0249\u024a\u0003,\u0016\u0000\u024a\u0250"+
		"\u0001\u0000\u0000\u0000\u024b\u024c\n\u0001\u0000\u0000\u024c\u024d\u0007"+
		"\u0007\u0000\u0000\u024d\u024f\u0003,\u0016\u0000\u024e\u024b\u0001\u0000"+
		"\u0000\u0000\u024f\u0252\u0001\u0000\u0000\u0000\u0250\u024e\u0001\u0000"+
		"\u0000\u0000\u0250\u0251\u0001\u0000\u0000\u0000\u0251/\u0001\u0000\u0000"+
		"\u0000\u0252\u0250\u0001\u0000\u0000\u0000\u0253\u0254\u0006\u0018\uffff"+
		"\uffff\u0000\u0254\u0255\u0003.\u0017\u0000\u0255\u025b\u0001\u0000\u0000"+
		"\u0000\u0256\u0257\n\u0001\u0000\u0000\u0257\u0258\u0005Z\u0000\u0000"+
		"\u0258\u025a\u0003.\u0017\u0000\u0259\u0256\u0001\u0000\u0000\u0000\u025a"+
		"\u025d\u0001\u0000\u0000\u0000\u025b\u0259\u0001\u0000\u0000\u0000\u025b"+
		"\u025c\u0001\u0000\u0000\u0000\u025c1\u0001\u0000\u0000\u0000\u025d\u025b"+
		"\u0001\u0000\u0000\u0000\u025e\u025f\u0006\u0019\uffff\uffff\u0000\u025f"+
		"\u0260\u00030\u0018\u0000\u0260\u0266\u0001\u0000\u0000\u0000\u0261\u0262"+
		"\n\u0001\u0000\u0000\u0262\u0263\u0005b\u0000\u0000\u0263\u0265\u0003"+
		"0\u0018\u0000\u0264\u0261\u0001\u0000\u0000\u0000\u0265\u0268\u0001\u0000"+
		"\u0000\u0000\u0266\u0264\u0001\u0000\u0000\u0000\u0266\u0267\u0001\u0000"+
		"\u0000\u0000\u02673\u0001\u0000\u0000\u0000\u0268\u0266\u0001\u0000\u0000"+
		"\u0000\u0269\u026a\u0006\u001a\uffff\uffff\u0000\u026a\u026b\u00032\u0019"+
		"\u0000\u026b\u0271\u0001\u0000\u0000\u0000\u026c\u026d\n\u0001\u0000\u0000"+
		"\u026d\u026e\u0005c\u0000\u0000\u026e\u0270\u00032\u0019\u0000\u026f\u026c"+
		"\u0001\u0000\u0000\u0000\u0270\u0273\u0001\u0000\u0000\u0000\u0271\u026f"+
		"\u0001\u0000\u0000\u0000\u0271\u0272\u0001\u0000\u0000\u0000\u02725\u0001"+
		"\u0000\u0000\u0000\u0273\u0271\u0001\u0000\u0000\u0000\u0274\u0275\u0006"+
		"\u001b\uffff\uffff\u0000\u0275\u0276\u00034\u001a\u0000\u0276\u027c\u0001"+
		"\u0000\u0000\u0000\u0277\u0278\n\u0001\u0000\u0000\u0278\u0279\u0005F"+
		"\u0000\u0000\u0279\u027b\u00034\u001a\u0000\u027a\u0277\u0001\u0000\u0000"+
		"\u0000\u027b\u027e\u0001\u0000\u0000\u0000\u027c\u027a\u0001\u0000\u0000"+
		"\u0000\u027c\u027d\u0001\u0000\u0000\u0000\u027d7\u0001\u0000\u0000\u0000"+
		"\u027e\u027c\u0001\u0000\u0000\u0000\u027f\u0280\u0006\u001c\uffff\uffff"+
		"\u0000\u0280\u0281\u00036\u001b\u0000\u0281\u0287\u0001\u0000\u0000\u0000"+
		"\u0282\u0283\n\u0001\u0000\u0000\u0283\u0284\u0005G\u0000\u0000\u0284"+
		"\u0286\u00036\u001b\u0000\u0285\u0282\u0001\u0000\u0000\u0000\u0286\u0289"+
		"\u0001\u0000\u0000\u0000\u0287\u0285\u0001\u0000\u0000\u0000\u0287\u0288"+
		"\u0001\u0000\u0000\u0000\u02889\u0001\u0000\u0000\u0000\u0289\u0287\u0001"+
		"\u0000\u0000\u0000\u028a\u0292\u00038\u001c\u0000\u028b\u028c\u00038\u001c"+
		"\u0000\u028c\u028d\u0005g\u0000\u0000\u028d\u028e\u0003>\u001f\u0000\u028e"+
		"\u028f\u0005d\u0000\u0000\u028f\u0290\u0003:\u001d\u0000\u0290\u0292\u0001"+
		"\u0000\u0000\u0000\u0291\u028a\u0001\u0000\u0000\u0000\u0291\u028b\u0001"+
		"\u0000\u0000\u0000\u0292;\u0001\u0000\u0000\u0000\u0293\u0299\u0003:\u001d"+
		"\u0000\u0294\u0295\u0003\"\u0011\u0000\u0295\u0296\u0007\b\u0000\u0000"+
		"\u0296\u0297\u0003<\u001e\u0000\u0297\u0299\u0001\u0000\u0000\u0000\u0298"+
		"\u0293\u0001\u0000\u0000\u0000\u0298\u0294\u0001\u0000\u0000\u0000\u0299"+
		"=\u0001\u0000\u0000\u0000\u029a\u029f\u0003<\u001e\u0000\u029b\u029c\u0005"+
		"i\u0000\u0000\u029c\u029e\u0003<\u001e\u0000\u029d\u029b\u0001\u0000\u0000"+
		"\u0000\u029e\u02a1\u0001\u0000\u0000\u0000\u029f\u029d\u0001\u0000\u0000"+
		"\u0000\u029f\u02a0\u0001\u0000\u0000\u0000\u02a0?\u0001\u0000\u0000\u0000"+
		"\u02a1\u029f\u0001\u0000\u0000\u0000\u02a2\u02a3\u0003:\u001d\u0000\u02a3"+
		"A\u0001\u0000\u0000\u0000\u02a4\u02a6\u0003D\"\u0000\u02a5\u02a7\u0003"+
		"J%\u0000\u02a6\u02a5\u0001\u0000\u0000\u0000\u02a6\u02a7\u0001\u0000\u0000"+
		"\u0000\u02a7\u02a8\u0001\u0000\u0000\u0000\u02a8\u02a9\u0005e\u0000\u0000"+
		"\u02a9C\u0001\u0000\u0000\u0000\u02aa\u02af\u0003F#\u0000\u02ab\u02af"+
		"\u0003N\'\u0000\u02ac\u02af\u0003b1\u0000\u02ad\u02af\u0003H$\u0000\u02ae"+
		"\u02aa\u0001\u0000\u0000\u0000\u02ae\u02ab\u0001\u0000\u0000\u0000\u02ae"+
		"\u02ac\u0001\u0000\u0000\u0000\u02ae\u02ad\u0001\u0000\u0000\u0000\u02af"+
		"\u02b0\u0001\u0000\u0000\u0000\u02b0\u02b1\u0001\u0000\u0000\u0000\u02b0"+
		"\u02ae\u0001\u0000\u0000\u0000\u02b1E\u0001\u0000\u0000\u0000\u02b2\u02b3"+
		"\u0007\t\u0000\u0000\u02b3G\u0001\u0000\u0000\u0000\u02b4\u02b5\u0005"+
		"\u0011\u0000\u0000\u02b5I\u0001\u0000\u0000\u0000\u02b6\u02bb\u0003L&"+
		"\u0000\u02b7\u02b8\u0005i\u0000\u0000\u02b8\u02ba\u0003L&\u0000\u02b9"+
		"\u02b7\u0001\u0000\u0000\u0000\u02ba\u02bd\u0001\u0000\u0000\u0000\u02bb"+
		"\u02b9\u0001\u0000\u0000\u0000\u02bb\u02bc\u0001\u0000\u0000\u0000\u02bc"+
		"K\u0001\u0000\u0000\u0000\u02bd\u02bb\u0001\u0000\u0000\u0000\u02be\u02c1"+
		"\u0003d2\u0000\u02bf\u02c0\u0005h\u0000\u0000\u02c0\u02c2\u0003|>\u0000"+
		"\u02c1\u02bf\u0001\u0000\u0000\u0000\u02c1\u02c2\u0001\u0000\u0000\u0000"+
		"\u02c2M\u0001\u0000\u0000\u0000\u02c3\u02c8\u0007\n\u0000\u0000\u02c4"+
		"\u02c8\u0003P(\u0000\u02c5\u02c8\u0003\\.\u0000\u02c6\u02c8\u0003z=\u0000"+
		"\u02c7\u02c3\u0001\u0000\u0000\u0000\u02c7\u02c4\u0001\u0000\u0000\u0000"+
		"\u02c7\u02c5\u0001\u0000\u0000\u0000\u02c7\u02c6\u0001\u0000\u0000\u0000"+
		"\u02c8O\u0001\u0000\u0000\u0000\u02c9\u02cb\u0007\u000b\u0000\u0000\u02ca"+
		"\u02cc\u0005t\u0000\u0000\u02cb\u02ca\u0001\u0000\u0000\u0000\u02cb\u02cc"+
		"\u0001\u0000\u0000\u0000\u02cc\u02cd\u0001\u0000\u0000\u0000\u02cd\u02ce"+
		"\u0005o\u0000\u0000\u02ce\u02cf\u0003R)\u0000\u02cf\u02d0\u0005p\u0000"+
		"\u0000\u02d0\u02d4\u0001\u0000\u0000\u0000\u02d1\u02d2\u0007\u000b\u0000"+
		"\u0000\u02d2\u02d4\u0005t\u0000\u0000\u02d3\u02c9\u0001\u0000\u0000\u0000"+
		"\u02d3\u02d1\u0001\u0000\u0000\u0000\u02d4Q\u0001\u0000\u0000\u0000\u02d5"+
		"\u02d7\u0003T*\u0000\u02d6\u02d5\u0001\u0000\u0000\u0000\u02d7\u02d8\u0001"+
		"\u0000\u0000\u0000\u02d8\u02d6\u0001\u0000\u0000\u0000\u02d8\u02d9\u0001"+
		"\u0000\u0000\u0000\u02d9S\u0001\u0000\u0000\u0000\u02da\u02db\u0003V+"+
		"\u0000\u02db\u02dc\u0003X,\u0000\u02dc\u02dd\u0005e\u0000\u0000\u02dd"+
		"U\u0001\u0000\u0000\u0000\u02de\u02e1\u0003N\'\u0000\u02df\u02e1\u0003"+
		"b1\u0000\u02e0\u02de\u0001\u0000\u0000\u0000\u02e0\u02df\u0001\u0000\u0000"+
		"\u0000\u02e1\u02e3\u0001\u0000\u0000\u0000\u02e2\u02e4\u0003V+\u0000\u02e3"+
		"\u02e2\u0001\u0000\u0000\u0000\u02e3\u02e4\u0001\u0000\u0000\u0000\u02e4"+
		"W\u0001\u0000\u0000\u0000\u02e5\u02ea\u0003Z-\u0000\u02e6\u02e7\u0005"+
		"i\u0000\u0000\u02e7\u02e9\u0003Z-\u0000\u02e8\u02e6\u0001\u0000\u0000"+
		"\u0000\u02e9\u02ec\u0001\u0000\u0000\u0000\u02ea\u02e8\u0001\u0000\u0000"+
		"\u0000\u02ea\u02eb\u0001\u0000\u0000\u0000\u02ebY\u0001\u0000\u0000\u0000"+
		"\u02ec\u02ea\u0001\u0000\u0000\u0000\u02ed\u02f4\u0003d2\u0000\u02ee\u02f0"+
		"\u0003d2\u0000\u02ef\u02ee\u0001\u0000\u0000\u0000\u02ef\u02f0\u0001\u0000"+
		"\u0000\u0000\u02f0\u02f1\u0001\u0000\u0000\u0000\u02f1\u02f2\u0005d\u0000"+
		"\u0000\u02f2\u02f4\u0003@ \u0000\u02f3\u02ed\u0001\u0000\u0000\u0000\u02f3"+
		"\u02ef\u0001\u0000\u0000\u0000\u02f4[\u0001\u0000\u0000\u0000\u02f5\u02f7"+
		"\u0005\u000b\u0000\u0000\u02f6\u02f8\u0005t\u0000\u0000\u02f7\u02f6\u0001"+
		"\u0000\u0000\u0000\u02f7\u02f8\u0001\u0000\u0000\u0000\u02f8\u02f9\u0001"+
		"\u0000\u0000\u0000\u02f9\u02fa\u0005o\u0000\u0000\u02fa\u02fc\u0003^/"+
		"\u0000\u02fb\u02fd\u0005i\u0000\u0000\u02fc\u02fb\u0001\u0000\u0000\u0000"+
		"\u02fc\u02fd\u0001\u0000\u0000\u0000\u02fd\u02fe\u0001\u0000\u0000\u0000"+
		"\u02fe\u02ff\u0005p\u0000\u0000\u02ff\u0303\u0001\u0000\u0000\u0000\u0300"+
		"\u0301\u0005\u000b\u0000\u0000\u0301\u0303\u0005t\u0000\u0000\u0302\u02f5"+
		"\u0001\u0000\u0000\u0000\u0302\u0300\u0001\u0000\u0000\u0000\u0303]\u0001"+
		"\u0000\u0000\u0000\u0304\u0309\u0003`0\u0000\u0305\u0306\u0005i\u0000"+
		"\u0000\u0306\u0308\u0003`0\u0000\u0307\u0305\u0001\u0000\u0000\u0000\u0308"+
		"\u030b\u0001\u0000\u0000\u0000\u0309\u0307\u0001\u0000\u0000\u0000\u0309"+
		"\u030a\u0001\u0000\u0000\u0000\u030a_\u0001\u0000\u0000\u0000\u030b\u0309"+
		"\u0001\u0000\u0000\u0000\u030c\u030f\u0005t\u0000\u0000\u030d\u030e\u0005"+
		"h\u0000\u0000\u030e\u0310\u0003@ \u0000\u030f\u030d\u0001\u0000\u0000"+
		"\u0000\u030f\u0310\u0001\u0000\u0000\u0000\u0310a\u0001\u0000\u0000\u0000"+
		"\u0311\u0312\u0007\f\u0000\u0000\u0312c\u0001\u0000\u0000\u0000\u0313"+
		"\u0315\u0003h4\u0000\u0314\u0313\u0001\u0000\u0000\u0000\u0314\u0315\u0001"+
		"\u0000\u0000\u0000\u0315\u0316\u0001\u0000\u0000\u0000\u0316\u0317\u0003"+
		"f3\u0000\u0317e\u0001\u0000\u0000\u0000\u0318\u0319\u00063\uffff\uffff"+
		"\u0000\u0319\u031f\u0005t\u0000\u0000\u031a\u031b\u0005m\u0000\u0000\u031b"+
		"\u031c\u0003d2\u0000\u031c\u031d\u0005n\u0000\u0000\u031d\u031f\u0001"+
		"\u0000\u0000\u0000\u031e\u0318\u0001\u0000\u0000\u0000\u031e\u031a\u0001"+
		"\u0000\u0000\u0000\u031f\u034d\u0001\u0000\u0000\u0000\u0320\u0321\n\u0006"+
		"\u0000\u0000\u0321\u0323\u0005k\u0000\u0000\u0322\u0324\u0003j5\u0000"+
		"\u0323\u0322\u0001\u0000\u0000\u0000\u0323\u0324\u0001\u0000\u0000\u0000"+
		"\u0324\u0326\u0001\u0000\u0000\u0000\u0325\u0327\u0003<\u001e\u0000\u0326"+
		"\u0325\u0001\u0000\u0000\u0000\u0326\u0327\u0001\u0000\u0000\u0000\u0327"+
		"\u0328\u0001\u0000\u0000\u0000\u0328\u034c\u0005l\u0000\u0000\u0329\u032a"+
		"\n\u0005\u0000\u0000\u032a\u032b\u0005k\u0000\u0000\u032b\u032d\u0005"+
		"\u001a\u0000\u0000\u032c\u032e\u0003j5\u0000\u032d\u032c\u0001\u0000\u0000"+
		"\u0000\u032d\u032e\u0001\u0000\u0000\u0000\u032e\u032f\u0001\u0000\u0000"+
		"\u0000\u032f\u0330\u0003<\u001e\u0000\u0330\u0331\u0005l\u0000\u0000\u0331"+
		"\u034c\u0001\u0000\u0000\u0000\u0332\u0333\n\u0004\u0000\u0000\u0333\u0334"+
		"\u0005k\u0000\u0000\u0334\u0335\u0003j5\u0000\u0335\u0336\u0005\u001a"+
		"\u0000\u0000\u0336\u0337\u0003<\u001e\u0000\u0337\u0338\u0005l\u0000\u0000"+
		"\u0338\u034c\u0001\u0000\u0000\u0000\u0339\u033a\n\u0003\u0000\u0000\u033a"+
		"\u033c\u0005k\u0000\u0000\u033b\u033d\u0003j5\u0000\u033c\u033b\u0001"+
		"\u0000\u0000\u0000\u033c\u033d\u0001\u0000\u0000\u0000\u033d\u033e\u0001"+
		"\u0000\u0000\u0000\u033e\u033f\u0005[\u0000\u0000\u033f\u034c\u0005l\u0000"+
		"\u0000\u0340\u0341\n\u0002\u0000\u0000\u0341\u0342\u0005m\u0000\u0000"+
		"\u0342\u0343\u0003l6\u0000\u0343\u0344\u0005n\u0000\u0000\u0344\u034c"+
		"\u0001\u0000\u0000\u0000\u0345\u0346\n\u0001\u0000\u0000\u0346\u0348\u0005"+
		"m\u0000\u0000\u0347\u0349\u0003r9\u0000\u0348\u0347\u0001\u0000\u0000"+
		"\u0000\u0348\u0349\u0001\u0000\u0000\u0000\u0349\u034a\u0001\u0000\u0000"+
		"\u0000\u034a\u034c\u0005n\u0000\u0000\u034b\u0320\u0001\u0000\u0000\u0000"+
		"\u034b\u0329\u0001\u0000\u0000\u0000\u034b\u0332\u0001\u0000\u0000\u0000"+
		"\u034b\u0339\u0001\u0000\u0000\u0000\u034b\u0340\u0001\u0000\u0000\u0000"+
		"\u034b\u0345\u0001\u0000\u0000\u0000\u034c\u034f\u0001\u0000\u0000\u0000"+
		"\u034d\u034b\u0001\u0000\u0000\u0000\u034d\u034e\u0001\u0000\u0000\u0000"+
		"\u034eg\u0001\u0000\u0000\u0000\u034f\u034d\u0001\u0000\u0000\u0000\u0350"+
		"\u0352\u0005[\u0000\u0000\u0351\u0353\u0003j5\u0000\u0352\u0351\u0001"+
		"\u0000\u0000\u0000\u0352\u0353\u0001\u0000\u0000\u0000\u0353\u0355\u0001"+
		"\u0000\u0000\u0000\u0354\u0350\u0001\u0000\u0000\u0000\u0355\u0356\u0001"+
		"\u0000\u0000\u0000\u0356\u0354\u0001\u0000\u0000\u0000\u0356\u0357\u0001"+
		"\u0000\u0000\u0000\u0357i\u0001\u0000\u0000\u0000\u0358\u035a\u0003b1"+
		"\u0000\u0359\u0358\u0001\u0000\u0000\u0000\u035a\u035b\u0001\u0000\u0000"+
		"\u0000\u035b\u0359\u0001\u0000\u0000\u0000\u035b\u035c\u0001\u0000\u0000"+
		"\u0000\u035ck\u0001\u0000\u0000\u0000\u035d\u0360\u0003n7\u0000\u035e"+
		"\u035f\u0005i\u0000\u0000\u035f\u0361\u0005:\u0000\u0000\u0360\u035e\u0001"+
		"\u0000\u0000\u0000\u0360\u0361\u0001\u0000\u0000\u0000\u0361m\u0001\u0000"+
		"\u0000\u0000\u0362\u0367\u0003p8\u0000\u0363\u0364\u0005i\u0000\u0000"+
		"\u0364\u0366\u0003p8\u0000\u0365\u0363\u0001\u0000\u0000\u0000\u0366\u0369"+
		"\u0001\u0000\u0000\u0000\u0367\u0365\u0001\u0000\u0000\u0000\u0367\u0368"+
		"\u0001\u0000\u0000\u0000\u0368o\u0001\u0000\u0000\u0000\u0369\u0367\u0001"+
		"\u0000\u0000\u0000\u036a\u036f\u0003D\"\u0000\u036b\u0370\u0003d2\u0000"+
		"\u036c\u036e\u0003v;\u0000\u036d\u036c\u0001\u0000\u0000\u0000\u036d\u036e"+
		"\u0001\u0000\u0000\u0000\u036e\u0370\u0001\u0000\u0000\u0000\u036f\u036b"+
		"\u0001\u0000\u0000\u0000\u036f\u036d\u0001\u0000\u0000\u0000\u0370q\u0001"+
		"\u0000\u0000\u0000\u0371\u0376\u0005t\u0000\u0000\u0372\u0373\u0005i\u0000"+
		"\u0000\u0373\u0375\u0005t\u0000\u0000\u0374\u0372\u0001\u0000\u0000\u0000"+
		"\u0375\u0378\u0001\u0000\u0000\u0000\u0376\u0374\u0001\u0000\u0000\u0000"+
		"\u0376\u0377\u0001\u0000\u0000\u0000\u0377s\u0001\u0000\u0000\u0000\u0378"+
		"\u0376\u0001\u0000\u0000\u0000\u0379\u037b\u0003V+\u0000\u037a\u037c\u0003"+
		"v;\u0000\u037b\u037a\u0001\u0000\u0000\u0000\u037b\u037c\u0001\u0000\u0000"+
		"\u0000\u037cu\u0001\u0000\u0000\u0000\u037d\u0383\u0003h4\u0000\u037e"+
		"\u0380\u0003h4\u0000\u037f\u037e\u0001\u0000\u0000\u0000\u037f\u0380\u0001"+
		"\u0000\u0000\u0000\u0380\u0381\u0001\u0000\u0000\u0000\u0381\u0383\u0003"+
		"x<\u0000\u0382\u037d\u0001\u0000\u0000\u0000\u0382\u037f\u0001\u0000\u0000"+
		"\u0000\u0383w\u0001\u0000\u0000\u0000\u0384\u0385\u0006<\uffff\uffff\u0000"+
		"\u0385\u0386\u0005m\u0000\u0000\u0386\u0387\u0003v;\u0000\u0387\u0388"+
		"\u0005n\u0000\u0000\u0388\u03af\u0001\u0000\u0000\u0000\u0389\u038b\u0005"+
		"k\u0000\u0000\u038a\u038c\u0003j5\u0000\u038b\u038a\u0001\u0000\u0000"+
		"\u0000\u038b\u038c\u0001\u0000\u0000\u0000\u038c\u038e\u0001\u0000\u0000"+
		"\u0000\u038d\u038f\u0003<\u001e\u0000\u038e\u038d\u0001\u0000\u0000\u0000"+
		"\u038e\u038f\u0001\u0000\u0000\u0000\u038f\u0390\u0001\u0000\u0000\u0000"+
		"\u0390\u03af\u0005l\u0000\u0000\u0391\u0392\u0005k\u0000\u0000\u0392\u0394"+
		"\u0005\u001a\u0000\u0000\u0393\u0395\u0003j5\u0000\u0394\u0393\u0001\u0000"+
		"\u0000\u0000\u0394\u0395\u0001\u0000\u0000\u0000\u0395\u0396\u0001\u0000"+
		"\u0000\u0000\u0396\u0397\u0003<\u001e\u0000\u0397\u0398\u0005l\u0000\u0000"+
		"\u0398\u03af\u0001\u0000\u0000\u0000\u0399\u039a\u0005k\u0000\u0000\u039a"+
		"\u039b\u0003j5\u0000\u039b\u039c\u0005\u001a\u0000\u0000\u039c\u039d\u0003"+
		"<\u001e\u0000\u039d\u039e\u0005l\u0000\u0000\u039e\u03af\u0001\u0000\u0000"+
		"\u0000\u039f\u03a1\u0005k\u0000\u0000\u03a0\u03a2\u0003j5\u0000\u03a1"+
		"\u03a0\u0001\u0000\u0000\u0000\u03a1\u03a2\u0001\u0000\u0000\u0000\u03a2"+
		"\u03a3\u0001\u0000\u0000\u0000\u03a3\u03a4\u0005[\u0000\u0000\u03a4\u03af"+
		"\u0005l\u0000\u0000\u03a5\u03a6\u0005m\u0000\u0000\u03a6\u03a7\u0003l"+
		"6\u0000\u03a7\u03a8\u0005n\u0000\u0000\u03a8\u03af\u0001\u0000\u0000\u0000"+
		"\u03a9\u03ab\u0005m\u0000\u0000\u03aa\u03ac\u0003r9\u0000\u03ab\u03aa"+
		"\u0001\u0000\u0000\u0000\u03ab\u03ac\u0001\u0000\u0000\u0000\u03ac\u03ad"+
		"\u0001\u0000\u0000\u0000\u03ad\u03af\u0005n\u0000\u0000\u03ae\u0384\u0001"+
		"\u0000\u0000\u0000\u03ae\u0389\u0001\u0000\u0000\u0000\u03ae\u0391\u0001"+
		"\u0000\u0000\u0000\u03ae\u0399\u0001\u0000\u0000\u0000\u03ae\u039f\u0001"+
		"\u0000\u0000\u0000\u03ae\u03a5\u0001\u0000\u0000\u0000\u03ae\u03a9\u0001"+
		"\u0000\u0000\u0000\u03af\u03dd\u0001\u0000\u0000\u0000\u03b0\u03b1\n\f"+
		"\u0000\u0000\u03b1\u03b3\u0005k\u0000\u0000\u03b2\u03b4\u0003j5\u0000"+
		"\u03b3\u03b2\u0001\u0000\u0000\u0000\u03b3\u03b4\u0001\u0000\u0000\u0000"+
		"\u03b4\u03b6\u0001\u0000\u0000\u0000\u03b5\u03b7\u0003<\u001e\u0000\u03b6"+
		"\u03b5\u0001\u0000\u0000\u0000\u03b6\u03b7\u0001\u0000\u0000\u0000\u03b7"+
		"\u03b8\u0001\u0000\u0000\u0000\u03b8\u03dc\u0005l\u0000\u0000\u03b9\u03ba"+
		"\n\n\u0000\u0000\u03ba\u03bb\u0005k\u0000\u0000\u03bb\u03bd\u0005\u001a"+
		"\u0000\u0000\u03bc\u03be\u0003j5\u0000\u03bd\u03bc\u0001\u0000\u0000\u0000"+
		"\u03bd\u03be\u0001\u0000\u0000\u0000\u03be\u03bf\u0001\u0000\u0000\u0000"+
		"\u03bf\u03c0\u0003<\u001e\u0000\u03c0\u03c1\u0005l\u0000\u0000\u03c1\u03dc"+
		"\u0001\u0000\u0000\u0000\u03c2\u03c3\n\b\u0000\u0000\u03c3\u03c4\u0005"+
		"k\u0000\u0000\u03c4\u03c5\u0003j5\u0000\u03c5\u03c6\u0005\u001a\u0000"+
		"\u0000\u03c6\u03c7\u0003<\u001e\u0000\u03c7\u03c8\u0005l\u0000\u0000\u03c8"+
		"\u03dc\u0001\u0000\u0000\u0000\u03c9\u03ca\n\u0006\u0000\u0000\u03ca\u03cc"+
		"\u0005k\u0000\u0000\u03cb\u03cd\u0003j5\u0000\u03cc\u03cb\u0001\u0000"+
		"\u0000\u0000\u03cc\u03cd\u0001\u0000\u0000\u0000\u03cd\u03ce\u0001\u0000"+
		"\u0000\u0000\u03ce\u03cf\u0005[\u0000\u0000\u03cf\u03dc\u0005l\u0000\u0000"+
		"\u03d0\u03d1\n\u0004\u0000\u0000\u03d1\u03d2\u0005m\u0000\u0000\u03d2"+
		"\u03d3\u0003l6\u0000\u03d3\u03d4\u0005n\u0000\u0000\u03d4\u03dc\u0001"+
		"\u0000\u0000\u0000\u03d5\u03d6\n\u0002\u0000\u0000\u03d6\u03d8\u0005m"+
		"\u0000\u0000\u03d7\u03d9\u0003r9\u0000\u03d8\u03d7\u0001\u0000\u0000\u0000"+
		"\u03d8\u03d9\u0001\u0000\u0000\u0000\u03d9\u03da\u0001\u0000\u0000\u0000"+
		"\u03da\u03dc\u0005n\u0000\u0000\u03db\u03b0\u0001\u0000\u0000\u0000\u03db"+
		"\u03b9\u0001\u0000\u0000\u0000\u03db\u03c2\u0001\u0000\u0000\u0000\u03db"+
		"\u03c9\u0001\u0000\u0000\u0000\u03db\u03d0\u0001\u0000\u0000\u0000\u03db"+
		"\u03d5\u0001\u0000\u0000\u0000\u03dc\u03df\u0001\u0000\u0000\u0000\u03dd"+
		"\u03db\u0001\u0000\u0000\u0000\u03dd\u03de\u0001\u0000\u0000\u0000\u03de"+
		"y\u0001\u0000\u0000\u0000\u03df\u03dd\u0001\u0000\u0000\u0000\u03e0\u03e1"+
		"\u0005t\u0000\u0000\u03e1{\u0001\u0000\u0000\u0000\u03e2\u03eb\u0003<"+
		"\u001e\u0000\u03e3\u03e4\u0005o\u0000\u0000\u03e4\u03e6\u0003~?\u0000"+
		"\u03e5\u03e7\u0005i\u0000\u0000\u03e6\u03e5\u0001\u0000\u0000\u0000\u03e6"+
		"\u03e7\u0001\u0000\u0000\u0000\u03e7\u03e8\u0001\u0000\u0000\u0000\u03e8"+
		"\u03e9\u0005p\u0000\u0000\u03e9\u03eb\u0001\u0000\u0000\u0000\u03ea\u03e2"+
		"\u0001\u0000\u0000\u0000\u03ea\u03e3\u0001\u0000\u0000\u0000\u03eb}\u0001"+
		"\u0000\u0000\u0000\u03ec\u03ee\u0003\u0080@\u0000\u03ed\u03ec\u0001\u0000"+
		"\u0000\u0000\u03ed\u03ee\u0001\u0000\u0000\u0000\u03ee\u03ef\u0001\u0000"+
		"\u0000\u0000\u03ef\u03f7\u0003|>\u0000\u03f0\u03f2\u0005i\u0000\u0000"+
		"\u03f1\u03f3\u0003\u0080@\u0000\u03f2\u03f1\u0001\u0000\u0000\u0000\u03f2"+
		"\u03f3\u0001\u0000\u0000\u0000\u03f3\u03f4\u0001\u0000\u0000\u0000\u03f4"+
		"\u03f6\u0003|>\u0000\u03f5\u03f0\u0001\u0000\u0000\u0000\u03f6\u03f9\u0001"+
		"\u0000\u0000\u0000\u03f7\u03f5\u0001\u0000\u0000\u0000\u03f7\u03f8\u0001"+
		"\u0000\u0000\u0000\u03f8\u007f\u0001\u0000\u0000\u0000\u03f9\u03f7\u0001"+
		"\u0000\u0000\u0000\u03fa\u03fb\u0003\u0082A\u0000\u03fb\u03fc\u0005h\u0000"+
		"\u0000\u03fc\u0081\u0001\u0000\u0000\u0000\u03fd\u03ff\u0003\u0084B\u0000"+
		"\u03fe\u03fd\u0001\u0000\u0000\u0000\u03ff\u0400\u0001\u0000\u0000\u0000"+
		"\u0400\u03fe\u0001\u0000\u0000\u0000\u0400\u0401\u0001\u0000\u0000\u0000"+
		"\u0401\u0083\u0001\u0000\u0000\u0000\u0402\u0403\u0005k\u0000\u0000\u0403"+
		"\u0404\u0003@ \u0000\u0404\u0405\u0005l\u0000\u0000\u0405\u0409\u0001"+
		"\u0000\u0000\u0000\u0406\u0407\u0005f\u0000\u0000\u0407\u0409\u0005t\u0000"+
		"\u0000\u0408\u0402\u0001\u0000\u0000\u0000\u0408\u0406\u0001\u0000\u0000"+
		"\u0000\u0409\u0085\u0001\u0000\u0000\u0000\u040a\u040b\u0005X\u0000\u0000"+
		"\u040b\u040c\u0003r9\u0000\u040c\u040d\u0005Y\u0000\u0000\u040d\u0087"+
		"\u0001\u0000\u0000\u0000\u040e\u0416\u0003\u009aM\u0000\u040f\u0416\u0003"+
		"\u008aE\u0000\u0410\u0416\u0003\u008cF\u0000\u0411\u0416\u0003\u0092I"+
		"\u0000\u0412\u0416\u0003\u0094J\u0000\u0413\u0416\u0003\u0096K\u0000\u0414"+
		"\u0416\u0003\u0098L\u0000\u0415\u040e\u0001\u0000\u0000\u0000\u0415\u040f"+
		"\u0001\u0000\u0000\u0000\u0415\u0410\u0001\u0000\u0000\u0000\u0415\u0411"+
		"\u0001\u0000\u0000\u0000\u0415\u0412\u0001\u0000\u0000\u0000\u0415\u0413"+
		"\u0001\u0000\u0000\u0000\u0415\u0414\u0001\u0000\u0000\u0000\u0416\u0089"+
		"\u0001\u0000\u0000\u0000\u0417\u0418\u0005t\u0000\u0000\u0418\u0419\u0005"+
		"d\u0000\u0000\u0419\u0423\u0003\u0088D\u0000\u041a\u041b\u0005\u0003\u0000"+
		"\u0000\u041b\u041c\u0003@ \u0000\u041c\u041d\u0005d\u0000\u0000\u041d"+
		"\u041e\u0003\u0088D\u0000\u041e\u0423\u0001\u0000\u0000\u0000\u041f\u0420"+
		"\u0005\u0007\u0000\u0000\u0420\u0421\u0005d\u0000\u0000\u0421\u0423\u0003"+
		"\u0088D\u0000\u0422\u0417\u0001\u0000\u0000\u0000\u0422\u041a\u0001\u0000"+
		"\u0000\u0000\u0422\u041f\u0001\u0000\u0000\u0000\u0423\u008b\u0001\u0000"+
		"\u0000\u0000\u0424\u0426\u0005o\u0000\u0000\u0425\u0427\u0003\u008eG\u0000"+
		"\u0426\u0425\u0001\u0000\u0000\u0000\u0426\u0427\u0001\u0000\u0000\u0000"+
		"\u0427\u0428\u0001\u0000\u0000\u0000\u0428\u0429\u0005p\u0000\u0000\u0429"+
		"\u008d\u0001\u0000\u0000\u0000\u042a\u042c\u0003\u0090H\u0000\u042b\u042a"+
		"\u0001\u0000\u0000\u0000\u042c\u042d\u0001\u0000\u0000\u0000\u042d\u042b"+
		"\u0001\u0000\u0000\u0000\u042d\u042e\u0001\u0000\u0000\u0000\u042e\u008f"+
		"\u0001\u0000\u0000\u0000\u042f\u0432\u0003\u0088D\u0000\u0430\u0432\u0003"+
		"B!\u0000\u0431\u042f\u0001\u0000\u0000\u0000\u0431\u0430\u0001\u0000\u0000"+
		"\u0000\u0432\u0091\u0001\u0000\u0000\u0000\u0433\u0435\u0003>\u001f\u0000"+
		"\u0434\u0433\u0001\u0000\u0000\u0000\u0434\u0435\u0001\u0000\u0000\u0000"+
		"\u0435\u0436\u0001\u0000\u0000\u0000\u0436\u0437\u0005e\u0000\u0000\u0437"+
		"\u0093\u0001\u0000\u0000\u0000\u0438\u0439\u0005\u0010\u0000\u0000\u0439"+
		"\u043a\u0005m\u0000\u0000\u043a\u043b\u0003>\u001f\u0000\u043b\u043c\u0005"+
		"n\u0000\u0000\u043c\u043d\u0003\u0088D\u0000\u043d\u044d\u0001\u0000\u0000"+
		"\u0000\u043e\u043f\u0005\u0010\u0000\u0000\u043f\u0440\u0005m\u0000\u0000"+
		"\u0440\u0441\u0003>\u001f\u0000\u0441\u0442\u0005n\u0000\u0000\u0442\u0443"+
		"\u0003\u0088D\u0000\u0443\u0444\u0005\n\u0000\u0000\u0444\u0445\u0003"+
		"\u0088D\u0000\u0445\u044d\u0001\u0000\u0000\u0000\u0446\u0447\u0005\u001c"+
		"\u0000\u0000\u0447\u0448\u0005m\u0000\u0000\u0448\u0449\u0003>\u001f\u0000"+
		"\u0449\u044a\u0005n\u0000\u0000\u044a\u044b\u0003\u0088D\u0000\u044b\u044d"+
		"\u0001\u0000\u0000\u0000\u044c\u0438\u0001\u0000\u0000\u0000\u044c\u043e"+
		"\u0001\u0000\u0000\u0000\u044c\u0446\u0001\u0000\u0000\u0000\u044d\u0095"+
		"\u0001\u0000\u0000\u0000\u044e\u044f\u0005\"\u0000\u0000\u044f\u0450\u0005"+
		"m\u0000\u0000\u0450\u0451\u0003>\u001f\u0000\u0451\u0452\u0005n\u0000"+
		"\u0000\u0452\u0453\u0003\u0088D\u0000\u0453\u0479\u0001\u0000\u0000\u0000"+
		"\u0454\u0455\u0005\b\u0000\u0000\u0455\u0456\u0003\u0088D\u0000\u0456"+
		"\u0457\u0005\"\u0000\u0000\u0457\u0458\u0005m\u0000\u0000\u0458\u0459"+
		"\u0003>\u001f\u0000\u0459\u045a\u0005n\u0000\u0000\u045a\u045b\u0005e"+
		"\u0000\u0000\u045b\u0479\u0001\u0000\u0000\u0000\u045c\u045d\u0005\u000e"+
		"\u0000\u0000\u045d\u045f\u0005m\u0000\u0000\u045e\u0460\u0003>\u001f\u0000"+
		"\u045f\u045e\u0001\u0000\u0000\u0000\u045f\u0460\u0001\u0000\u0000\u0000"+
		"\u0460\u0461\u0001\u0000\u0000\u0000\u0461\u0463\u0005e\u0000\u0000\u0462"+
		"\u0464\u0003>\u001f\u0000\u0463\u0462\u0001\u0000\u0000\u0000\u0463\u0464"+
		"\u0001\u0000\u0000\u0000\u0464\u0465\u0001\u0000\u0000\u0000\u0465\u0467"+
		"\u0005e\u0000\u0000\u0466\u0468\u0003>\u001f\u0000\u0467\u0466\u0001\u0000"+
		"\u0000\u0000\u0467\u0468\u0001\u0000\u0000\u0000\u0468\u0469\u0001\u0000"+
		"\u0000\u0000\u0469\u046a\u0005n\u0000\u0000\u046a\u0479\u0003\u0088D\u0000"+
		"\u046b\u046c\u0005\u000e\u0000\u0000\u046c\u046d\u0005m\u0000\u0000\u046d"+
		"\u046f\u0003B!\u0000\u046e\u0470\u0003>\u001f\u0000\u046f\u046e\u0001"+
		"\u0000\u0000\u0000\u046f\u0470\u0001\u0000\u0000\u0000\u0470\u0471\u0001"+
		"\u0000\u0000\u0000\u0471\u0473\u0005e\u0000\u0000\u0472\u0474\u0003>\u001f"+
		"\u0000\u0473\u0472\u0001\u0000\u0000\u0000\u0473\u0474\u0001\u0000\u0000"+
		"\u0000\u0474\u0475\u0001\u0000\u0000\u0000\u0475\u0476\u0005n\u0000\u0000"+
		"\u0476\u0477\u0003\u0088D\u0000\u0477\u0479\u0001\u0000\u0000\u0000\u0478"+
		"\u044e\u0001\u0000\u0000\u0000\u0478\u0454\u0001\u0000\u0000\u0000\u0478"+
		"\u045c\u0001\u0000\u0000\u0000\u0478\u046b\u0001\u0000\u0000\u0000\u0479"+
		"\u0097\u0001\u0000\u0000\u0000\u047a\u047b\u0005\u000f\u0000\u0000\u047b"+
		"\u047c\u0005t\u0000\u0000\u047c\u0487\u0005e\u0000\u0000\u047d\u047e\u0005"+
		"\u0006\u0000\u0000\u047e\u0487\u0005e\u0000\u0000\u047f\u0480\u0005\u0002"+
		"\u0000\u0000\u0480\u0487\u0005e\u0000\u0000\u0481\u0483\u0005\u0016\u0000"+
		"\u0000\u0482\u0484\u0003>\u001f\u0000\u0483\u0482\u0001\u0000\u0000\u0000"+
		"\u0483\u0484\u0001\u0000\u0000\u0000\u0484\u0485\u0001\u0000\u0000\u0000"+
		"\u0485\u0487\u0005e\u0000\u0000\u0486\u047a\u0001\u0000\u0000\u0000\u0486"+
		"\u047d\u0001\u0000\u0000\u0000\u0486\u047f\u0001\u0000\u0000\u0000\u0486"+
		"\u0481\u0001\u0000\u0000\u0000\u0487\u0099\u0001\u0000\u0000\u0000\u0488"+
		"\u0489\u0005&\u0000\u0000\u0489\u048a\u0005m\u0000\u0000\u048a\u048b\u0005"+
		"w\u0000\u0000\u048b\u048c\u0005n\u0000\u0000\u048c\u048d\u0005e\u0000"+
		"\u0000\u048d\u009b\u0001\u0000\u0000\u0000\u048e\u0490\u0003\u009eO\u0000"+
		"\u048f\u048e\u0001\u0000\u0000\u0000\u0490\u0491\u0001\u0000\u0000\u0000"+
		"\u0491\u048f\u0001\u0000\u0000\u0000\u0491\u0492\u0001\u0000\u0000\u0000"+
		"\u0492\u009d\u0001\u0000\u0000\u0000\u0493\u0496\u0003\u00a0P\u0000\u0494"+
		"\u0496\u0003B!\u0000\u0495\u0493\u0001\u0000\u0000\u0000\u0495\u0494\u0001"+
		"\u0000\u0000\u0000\u0496\u009f\u0001\u0000\u0000\u0000\u0497\u0499\u0003"+
		"\u0086C\u0000\u0498\u0497\u0001\u0000\u0000\u0000\u0499\u049c\u0001\u0000"+
		"\u0000\u0000\u049a\u0498\u0001\u0000\u0000\u0000\u049a\u049b\u0001\u0000"+
		"\u0000\u0000\u049b\u049d\u0001\u0000\u0000\u0000\u049c\u049a\u0001\u0000"+
		"\u0000\u0000\u049d\u049e\u0003D\"\u0000\u049e\u04a0\u0003d2\u0000\u049f"+
		"\u04a1\u0003\u00a2Q\u0000\u04a0\u049f\u0001\u0000\u0000\u0000\u04a0\u04a1"+
		"\u0001\u0000\u0000\u0000\u04a1\u04a2\u0001\u0000\u0000\u0000\u04a2\u04a3"+
		"\u0003\u008cF\u0000\u04a3\u00a1\u0001\u0000\u0000\u0000\u04a4\u04a6\u0003"+
		"B!\u0000\u04a5\u04a4\u0001\u0000\u0000\u0000\u04a6\u04a7\u0001\u0000\u0000"+
		"\u0000\u04a7\u04a5\u0001\u0000\u0000\u0000\u04a7\u04a8\u0001\u0000\u0000"+
		"\u0000\u04a8\u00a3\u0001\u0000\u0000\u0000\u0081\u00a5\u00aa\u00b1\u00b7"+
		"\u00bb\u00c4\u00c8\u00cf\u00d6\u00d8\u00df\u00e3\u00e9\u00f4\u00fd\u0103"+
		"\u0110\u011f\u012a\u0137\u0140\u0149\u0152\u0158\u015d\u0165\u016f\u01b6"+
		"\u01c1\u01cb\u01cf\u01d9\u01e6\u01e8\u01f0\u0212\u021a\u0224\u022f\u023a"+
		"\u0245\u0250\u025b\u0266\u0271\u027c\u0287\u0291\u0298\u029f\u02a6\u02ae"+
		"\u02b0\u02bb\u02c1\u02c7\u02cb\u02d3\u02d8\u02e0\u02e3\u02ea\u02ef\u02f3"+
		"\u02f7\u02fc\u0302\u0309\u030f\u0314\u031e\u0323\u0326\u032d\u033c\u0348"+
		"\u034b\u034d\u0352\u0356\u035b\u0360\u0367\u036d\u036f\u0376\u037b\u037f"+
		"\u0382\u038b\u038e\u0394\u03a1\u03ab\u03ae\u03b3\u03b6\u03bd\u03cc\u03d8"+
		"\u03db\u03dd\u03e6\u03ea\u03ed\u03f2\u03f7\u0400\u0408\u0415\u0422\u0426"+
		"\u042d\u0431\u0434\u044c\u045f\u0463\u0467\u046f\u0473\u0478\u0483\u0486"+
		"\u0491\u0495\u049a\u04a0\u04a7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}