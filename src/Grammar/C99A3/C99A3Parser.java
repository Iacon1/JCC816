// Generated from I:/Coding Projects/JCC816/src/Grammar/C99A3.g4 by ANTLR 4.13.1
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
		RULE_keyword = 12, RULE_punctuator = 13, RULE_identifier = 14, RULE_primary_expression = 15, 
		RULE_postfix_expression = 16, RULE_argument_expression_list = 17, RULE_unary_expression = 18, 
		RULE_cast_expression = 19, RULE_multiplicative_expression = 20, RULE_additive_expression = 21, 
		RULE_shift_expression = 22, RULE_relational_expression = 23, RULE_equality_expression = 24, 
		RULE_and_expression = 25, RULE_xor_expression = 26, RULE_or_expression = 27, 
		RULE_land_expression = 28, RULE_lor_expression = 29, RULE_conditional_expression = 30, 
		RULE_assignment_expression = 31, RULE_expression = 32, RULE_constant_expression = 33, 
		RULE_attributes_declaration = 34, RULE_declaration = 35, RULE_declaration_specifiers = 36, 
		RULE_storage_class_specifier = 37, RULE_function_specifier = 38, RULE_init_declarator_list = 39, 
		RULE_init_declarator = 40, RULE_type_specifier = 41, RULE_struct_or_union_specifier = 42, 
		RULE_struct_declaration_list = 43, RULE_struct_declaration = 44, RULE_specifier_qualifier_list = 45, 
		RULE_struct_declarator_list = 46, RULE_struct_declarator = 47, RULE_enum_specifier = 48, 
		RULE_enumerator_list = 49, RULE_enumerator = 50, RULE_type_qualifier = 51, 
		RULE_declarator = 52, RULE_direct_declarator = 53, RULE_pointer = 54, 
		RULE_type_qualifier_list = 55, RULE_parameter_type_list = 56, RULE_parameter_list = 57, 
		RULE_parameter_declaration = 58, RULE_identifier_list = 59, RULE_type_name = 60, 
		RULE_abstract_declarator = 61, RULE_direct_abstract_declarator = 62, RULE_typedef_name = 63, 
		RULE_initializer = 64, RULE_initializer_list = 65, RULE_designation = 66, 
		RULE_designator_list = 67, RULE_designator = 68, RULE_statement = 69, 
		RULE_labeled_statement = 70, RULE_compound_statement = 71, RULE_block_item_list = 72, 
		RULE_block_item = 73, RULE_expression_statement = 74, RULE_selection_statement = 75, 
		RULE_iteration_statement = 76, RULE_jump_statement = 77, RULE_asm_statement = 78, 
		RULE_translation_unit = 79, RULE_external_declaration = 80, RULE_function_definition = 81, 
		RULE_declaration_list = 82;
	private static String[] makeRuleNames() {
		return new String[] {
			"preprocessing_file", "group", "group_part", "if_section", "if_group", 
			"elif_group", "else_group", "endif_line", "control_line", "text_line", 
			"non_directive", "pp_token", "keyword", "punctuator", "identifier", "primary_expression", 
			"postfix_expression", "argument_expression_list", "unary_expression", 
			"cast_expression", "multiplicative_expression", "additive_expression", 
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
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 124411939706109951L) != 0)) {
				{
				setState(166);
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
			setState(170); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(169);
					group_part();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(172); 
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
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				if_section();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				control_line();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
				match(HashTg);
				setState(177);
				non_directive();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(178);
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
			setState(181);
			if_group();
			setState(185);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(182);
					elif_group();
					}
					} 
				}
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(188);
				else_group();
				}
				break;
			}
			setState(191);
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
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				match(HashTg);
				setState(194);
				match(If);
				setState(196); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(195);
					pp_token();
					}
					}
					setState(198); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0) );
				setState(200);
				match(NL);
				setState(202);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(201);
					group();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				match(HashTg);
				setState(205);
				match(Ifdef);
				setState(206);
				match(Identifier);
				setState(207);
				match(NL);
				setState(209);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(208);
					group();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(211);
				match(HashTg);
				setState(212);
				match(Ifndef);
				setState(213);
				match(Identifier);
				setState(214);
				match(NL);
				setState(216);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(215);
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
			setState(220);
			match(HashTg);
			setState(221);
			match(Elif);
			setState(223); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(222);
				pp_token();
				}
				}
				setState(225); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0) );
			setState(227);
			match(NL);
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(228);
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
			setState(231);
			match(HashTg);
			setState(232);
			match(Else);
			setState(233);
			match(NL);
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(234);
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
			setState(237);
			match(HashTg);
			setState(238);
			match(Endif);
			setState(239);
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
			setState(346);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				match(HashTg);
				setState(242);
				match(Include);
				setState(244); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(243);
					pp_token();
					}
					}
					setState(246); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0) );
				setState(248);
				match(NL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				match(HashTg);
				setState(251);
				match(Define);
				setState(252);
				match(Identifier);
				setState(253);
				match(LeRoBr);
				setState(255);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(254);
					identifier_list();
					}
					break;
				}
				setState(257);
				match(RiRoBr);
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0)) {
					{
					{
					setState(258);
					pp_token();
					}
					}
					setState(263);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(264);
				match(NL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(265);
				match(HashTg);
				setState(266);
				match(Define);
				setState(267);
				match(Identifier);
				setState(268);
				match(LeRoBr);
				setState(269);
				match(ThreeP);
				setState(270);
				match(RiRoBr);
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0)) {
					{
					{
					setState(271);
					pp_token();
					}
					}
					setState(276);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(277);
				match(NL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(278);
				match(HashTg);
				setState(279);
				match(Define);
				setState(280);
				match(Identifier);
				setState(281);
				match(LeRoBr);
				setState(282);
				identifier_list();
				setState(283);
				match(Comma);
				setState(284);
				match(ThreeP);
				setState(285);
				match(RiRoBr);
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0)) {
					{
					{
					setState(286);
					pp_token();
					}
					}
					setState(291);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(292);
				match(NL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(294);
				match(HashTg);
				setState(295);
				match(Define);
				setState(296);
				match(Identifier);
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0)) {
					{
					{
					setState(297);
					pp_token();
					}
					}
					setState(302);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(303);
				match(NL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(304);
				match(HashTg);
				setState(305);
				match(Undef);
				setState(306);
				match(Identifier);
				setState(307);
				match(NL);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(308);
				match(HashTg);
				setState(309);
				match(Line);
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0)) {
					{
					{
					setState(310);
					pp_token();
					}
					}
					setState(315);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(316);
				match(NL);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(317);
				match(HashTg);
				setState(318);
				match(Error);
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0)) {
					{
					{
					setState(319);
					pp_token();
					}
					}
					setState(324);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(325);
				match(NL);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(326);
				match(HashTg);
				setState(327);
				match(Pragma);
				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0)) {
					{
					{
					setState(328);
					pp_token();
					}
					}
					setState(333);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(334);
				match(NL);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(335);
				match(HashTg);
				setState(336);
				match(Embed);
				setState(338); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(337);
					pp_token();
					}
					}
					setState(340); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0) );
				setState(342);
				match(NL);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(344);
				match(HashTg);
				setState(345);
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
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 122160139892424703L) != 0)) {
				{
				{
				setState(348);
				pp_token();
				}
				}
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(354);
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
			setState(357); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(356);
					pp_token();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(359); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(361);
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
			setState(369);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Header_name:
				enterOuterAlt(_localctx, 1);
				{
				setState(363);
				match(Header_name);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(364);
				match(Identifier);
				}
				break;
			case Constant:
				enterOuterAlt(_localctx, 3);
				{
				setState(365);
				match(Constant);
				}
				break;
			case String_literal:
				enterOuterAlt(_localctx, 4);
				{
				setState(366);
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
				setState(367);
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
				setState(368);
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
			setState(440);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Auto:
				enterOuterAlt(_localctx, 1);
				{
				setState(371);
				match(Auto);
				}
				break;
			case Break:
				enterOuterAlt(_localctx, 2);
				{
				setState(372);
				match(Break);
				}
				break;
			case Case:
				enterOuterAlt(_localctx, 3);
				{
				setState(373);
				match(Case);
				}
				break;
			case Char:
				enterOuterAlt(_localctx, 4);
				{
				setState(374);
				match(Char);
				}
				break;
			case Const:
				enterOuterAlt(_localctx, 5);
				{
				setState(375);
				match(Const);
				}
				break;
			case Continue:
				enterOuterAlt(_localctx, 6);
				{
				setState(376);
				match(Continue);
				}
				break;
			case Default:
				enterOuterAlt(_localctx, 7);
				{
				setState(377);
				match(Default);
				}
				break;
			case Do:
				enterOuterAlt(_localctx, 8);
				{
				setState(378);
				match(Do);
				}
				break;
			case Double:
				enterOuterAlt(_localctx, 9);
				{
				setState(379);
				match(Double);
				}
				break;
			case Else:
				enterOuterAlt(_localctx, 10);
				{
				setState(380);
				match(Else);
				}
				break;
			case Enum:
				enterOuterAlt(_localctx, 11);
				{
				setState(381);
				match(Enum);
				}
				break;
			case Extern:
				enterOuterAlt(_localctx, 12);
				{
				setState(382);
				match(Extern);
				}
				break;
			case Float:
				enterOuterAlt(_localctx, 13);
				{
				setState(383);
				match(Float);
				}
				break;
			case For:
				enterOuterAlt(_localctx, 14);
				{
				setState(384);
				match(For);
				}
				break;
			case Goto:
				enterOuterAlt(_localctx, 15);
				{
				setState(385);
				match(Goto);
				}
				break;
			case If:
				enterOuterAlt(_localctx, 16);
				{
				setState(386);
				match(If);
				}
				break;
			case Inline:
				enterOuterAlt(_localctx, 17);
				{
				setState(387);
				match(Inline);
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 18);
				{
				setState(388);
				match(Int);
				}
				break;
			case Long:
				enterOuterAlt(_localctx, 19);
				{
				setState(389);
				match(Long);
				}
				break;
			case Register:
				enterOuterAlt(_localctx, 20);
				{
				setState(390);
				match(Register);
				}
				break;
			case Restrict:
				enterOuterAlt(_localctx, 21);
				{
				setState(391);
				match(Restrict);
				}
				break;
			case Return:
				enterOuterAlt(_localctx, 22);
				{
				setState(392);
				match(Return);
				}
				break;
			case Short:
				enterOuterAlt(_localctx, 23);
				{
				setState(393);
				match(Short);
				}
				break;
			case Signed:
				enterOuterAlt(_localctx, 24);
				{
				setState(394);
				match(Signed);
				}
				break;
			case Sizeof:
				enterOuterAlt(_localctx, 25);
				{
				setState(395);
				match(Sizeof);
				}
				break;
			case Static:
				enterOuterAlt(_localctx, 26);
				{
				setState(396);
				match(Static);
				}
				break;
			case Struct:
				enterOuterAlt(_localctx, 27);
				{
				setState(397);
				match(Struct);
				}
				break;
			case Switch:
				enterOuterAlt(_localctx, 28);
				{
				setState(398);
				match(Switch);
				}
				break;
			case Typedef:
				enterOuterAlt(_localctx, 29);
				{
				setState(399);
				match(Typedef);
				}
				break;
			case Union:
				enterOuterAlt(_localctx, 30);
				{
				setState(400);
				match(Union);
				}
				break;
			case Unsigned:
				enterOuterAlt(_localctx, 31);
				{
				setState(401);
				match(Unsigned);
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 32);
				{
				setState(402);
				match(Void);
				}
				break;
			case Volatile:
				enterOuterAlt(_localctx, 33);
				{
				setState(403);
				match(Volatile);
				}
				break;
			case While:
				enterOuterAlt(_localctx, 34);
				{
				setState(404);
				match(While);
				}
				break;
			case Bool:
				enterOuterAlt(_localctx, 35);
				{
				setState(405);
				match(Bool);
				}
				break;
			case Complex:
				enterOuterAlt(_localctx, 36);
				{
				setState(406);
				match(Complex);
				}
				break;
			case Imaginary:
				enterOuterAlt(_localctx, 37);
				{
				setState(407);
				match(Imaginary);
				}
				break;
			case Asm:
				enterOuterAlt(_localctx, 38);
				{
				setState(408);
				match(Asm);
				}
				break;
			case Defined:
				enterOuterAlt(_localctx, 39);
				{
				setState(409);
				match(Defined);
				setState(410);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Define:
				enterOuterAlt(_localctx, 40);
				{
				setState(411);
				match(Define);
				setState(412);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Ifdef:
				enterOuterAlt(_localctx, 41);
				{
				setState(413);
				match(Ifdef);
				setState(414);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Ifndef:
				enterOuterAlt(_localctx, 42);
				{
				setState(415);
				match(Ifndef);
				setState(416);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Elif:
				enterOuterAlt(_localctx, 43);
				{
				setState(417);
				match(Elif);
				setState(418);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Endif:
				enterOuterAlt(_localctx, 44);
				{
				setState(419);
				match(Endif);
				setState(420);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Include:
				enterOuterAlt(_localctx, 45);
				{
				setState(421);
				match(Include);
				setState(422);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Undef:
				enterOuterAlt(_localctx, 46);
				{
				setState(423);
				match(Undef);
				setState(424);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Line:
				enterOuterAlt(_localctx, 47);
				{
				setState(425);
				match(Line);
				setState(426);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Error:
				enterOuterAlt(_localctx, 48);
				{
				setState(427);
				match(Error);
				setState(428);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Pragma:
				enterOuterAlt(_localctx, 49);
				{
				setState(429);
				match(Pragma);
				setState(430);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case HasEmbed:
				enterOuterAlt(_localctx, 50);
				{
				setState(431);
				match(HasEmbed);
				setState(432);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Embed:
				enterOuterAlt(_localctx, 51);
				{
				setState(433);
				match(Embed);
				setState(434);
				if (!(Grammar.GrammarFlags.isPreproc)) throw new FailedPredicateException(this, "Grammar.GrammarFlags.isPreproc");
				}
				break;
			case Offsetof:
				enterOuterAlt(_localctx, 52);
				{
				setState(435);
				match(Offsetof);
				}
				break;
			case SRAM:
				enterOuterAlt(_localctx, 53);
				{
				setState(436);
				match(SRAM);
				}
				break;
			case RWTWICE:
				enterOuterAlt(_localctx, 54);
				{
				setState(437);
				match(RWTWICE);
				}
				break;
			case ROTWICE:
				enterOuterAlt(_localctx, 55);
				{
				setState(438);
				match(ROTWICE);
				}
				break;
			case WOTWICE:
				enterOuterAlt(_localctx, 56);
				{
				setState(439);
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
			setState(442);
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
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(C99A3Parser.Identifier, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			if (!(!C99Compiler.C99Compiler.hasTypedef(getCurrentToken().getText()))) throw new FailedPredicateException(this, "!C99Compiler.C99Compiler.hasTypedef(getCurrentToken().getText())");
			setState(445);
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
		enterRule(_localctx, 30, RULE_primary_expression);
		try {
			setState(454);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(447);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(448);
				match(Constant);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(449);
				match(String_literal);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(450);
				match(LeRoBr);
				setState(451);
				expression();
				setState(452);
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_postfix_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(457);
				primary_expression();
				}
				break;
			case 2:
				{
				setState(458);
				match(LeRoBr);
				setState(459);
				type_name();
				setState(460);
				match(RiRoBr);
				setState(461);
				match(LeCuBr);
				setState(462);
				initializer_list();
				setState(464);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(463);
					match(Comma);
					}
				}

				setState(466);
				match(RiCuBr);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(493);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(491);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(470);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(471);
						match(LeSqBr);
						setState(472);
						expression();
						setState(473);
						match(RiSqBr);
						}
						break;
					case 2:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(475);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(476);
						match(LeRoBr);
						setState(478);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
						case 1:
							{
							setState(477);
							argument_expression_list();
							}
							break;
						}
						setState(480);
						match(RiRoBr);
						}
						break;
					case 3:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(481);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(482);
						match(Period);
						setState(483);
						identifier();
						}
						break;
					case 4:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(484);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(485);
						match(Arrow);
						setState(486);
						identifier();
						}
						break;
					case 5:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(487);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(488);
						match(Incrmn);
						}
						break;
					case 6:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(489);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(490);
						match(Decrmn);
						}
						break;
					}
					} 
				}
				setState(495);
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
		enterRule(_localctx, 34, RULE_argument_expression_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			assignment_expression();
			setState(501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(497);
				match(Comma);
				setState(498);
				assignment_expression();
				}
				}
				setState(503);
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
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
		enterRule(_localctx, 36, RULE_unary_expression);
		int _la;
		try {
			setState(536);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(504);
				postfix_expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(505);
				match(Incrmn);
				setState(506);
				unary_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(507);
				match(Decrmn);
				setState(508);
				unary_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(509);
				_la = _input.LA(1);
				if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 63L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(510);
				cast_expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(511);
				match(Sizeof);
				setState(512);
				unary_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(513);
				match(Sizeof);
				setState(514);
				match(LeRoBr);
				setState(515);
				type_name();
				setState(516);
				match(RiRoBr);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(518);
				match(HasEmbed);
				setState(519);
				match(LeRoBr);
				setState(520);
				_la = _input.LA(1);
				if ( !(_la==String_literal || _la==Header_name) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(521);
				match(RiRoBr);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(522);
				match(Defined);
				setState(523);
				identifier();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(524);
				match(Defined);
				setState(525);
				match(LeRoBr);
				setState(526);
				identifier();
				setState(527);
				match(RiRoBr);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(529);
				match(Offsetof);
				setState(530);
				match(LeRoBr);
				setState(531);
				type_name();
				setState(532);
				match(Comma);
				setState(533);
				identifier();
				setState(534);
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
		enterRule(_localctx, 38, RULE_cast_expression);
		try {
			setState(544);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(538);
				match(LeRoBr);
				setState(539);
				type_name();
				setState(540);
				match(RiRoBr);
				setState(541);
				cast_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(543);
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
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_multiplicative_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(547);
			cast_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(554);
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
					setState(549);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(550);
					_la = _input.LA(1);
					if ( !(((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 97L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(551);
					cast_expression();
					}
					} 
				}
				setState(556);
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_additive_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(558);
			multiplicative_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(565);
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
					setState(560);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(561);
					_la = _input.LA(1);
					if ( !(_la==Plus || _la==Minus) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(562);
					multiplicative_expression(0);
					}
					} 
				}
				setState(567);
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_shift_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(569);
			additive_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(576);
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
					setState(571);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(572);
					_la = _input.LA(1);
					if ( !(_la==LssLss || _la==GrtGrt) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(573);
					additive_expression(0);
					}
					} 
				}
				setState(578);
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_relational_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(580);
			shift_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(587);
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
					setState(582);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(583);
					_la = _input.LA(1);
					if ( !(((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 15L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(584);
					shift_expression(0);
					}
					} 
				}
				setState(589);
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_equality_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(591);
			relational_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(598);
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
					setState(593);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(594);
					_la = _input.LA(1);
					if ( !(_la==Equal || _la==NotEql) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(595);
					relational_expression(0);
					}
					} 
				}
				setState(600);
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
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_and_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(602);
			equality_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(609);
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
					setState(604);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(605);
					match(Amper);
					setState(606);
					equality_expression(0);
					}
					} 
				}
				setState(611);
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
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_xor_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(613);
			and_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(620);
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
					setState(615);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(616);
					match(Xor);
					setState(617);
					and_expression(0);
					}
					} 
				}
				setState(622);
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
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_or_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(624);
			xor_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(631);
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
					setState(626);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(627);
					match(Or);
					setState(628);
					xor_expression(0);
					}
					} 
				}
				setState(633);
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
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_land_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(635);
			or_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(642);
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
					setState(637);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(638);
					match(AmpAmp);
					setState(639);
					or_expression(0);
					}
					} 
				}
				setState(644);
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
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_lor_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(646);
			land_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(653);
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
					setState(648);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(649);
					match(OrOr);
					setState(650);
					land_expression(0);
					}
					} 
				}
				setState(655);
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
		enterRule(_localctx, 60, RULE_conditional_expression);
		try {
			setState(663);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(656);
				lor_expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(657);
				lor_expression(0);
				setState(658);
				match(Questi);
				setState(659);
				expression();
				setState(660);
				match(Colon);
				setState(661);
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
		enterRule(_localctx, 62, RULE_assignment_expression);
		int _la;
		try {
			setState(670);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(665);
				conditional_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(666);
				unary_expression();
				setState(667);
				_la = _input.LA(1);
				if ( !(((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & 4294968319L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(668);
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
		enterRule(_localctx, 64, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(672);
			assignment_expression();
			setState(677);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(673);
				match(Comma);
				setState(674);
				assignment_expression();
				}
				}
				setState(679);
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
		enterRule(_localctx, 66, RULE_constant_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(680);
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
		enterRule(_localctx, 68, RULE_attributes_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(682);
			match(TwoLSB);
			setState(683);
			identifier_list();
			setState(684);
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
		public TerminalNode Semico() { return getToken(C99A3Parser.Semico, 0); }
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_declaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(689);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(686);
					attributes_declaration();
					}
					} 
				}
				setState(691);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			}
			setState(692);
			declaration_specifiers();
			setState(694);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				{
				setState(693);
				init_declarator_list();
				}
				break;
			}
			setState(696);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitDeclaration_specifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaration_specifiersContext declaration_specifiers() throws RecognitionException {
		Declaration_specifiersContext _localctx = new Declaration_specifiersContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_declaration_specifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(703); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					setState(703);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
					case 1:
						{
						setState(699);
						storage_class_specifier();
						}
						break;
					case 2:
						{
						setState(700);
						type_specifier();
						}
						break;
					case 3:
						{
						setState(701);
						type_qualifier();
						}
						break;
					case 4:
						{
						setState(702);
						function_specifier();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(705); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
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
		enterRule(_localctx, 74, RULE_storage_class_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(707);
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
		enterRule(_localctx, 76, RULE_function_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(709);
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
		enterRule(_localctx, 78, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(711);
			init_declarator();
			setState(716);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(712);
				match(Comma);
				setState(713);
				init_declarator();
				}
				}
				setState(718);
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
		enterRule(_localctx, 80, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(719);
			declarator();
			setState(722);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(720);
				match(Assign);
				setState(721);
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
		enterRule(_localctx, 82, RULE_type_specifier);
		int _la;
		try {
			setState(728);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(724);
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
				setState(725);
				struct_or_union_specifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(726);
				enum_specifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(727);
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
		public TerminalNode LeCuBr() { return getToken(C99A3Parser.LeCuBr, 0); }
		public Struct_declaration_listContext struct_declaration_list() {
			return getRuleContext(Struct_declaration_listContext.class,0);
		}
		public TerminalNode RiCuBr() { return getToken(C99A3Parser.RiCuBr, 0); }
		public TerminalNode Struct() { return getToken(C99A3Parser.Struct, 0); }
		public TerminalNode Union() { return getToken(C99A3Parser.Union, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
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
		enterRule(_localctx, 84, RULE_struct_or_union_specifier);
		int _la;
		try {
			setState(740);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(730);
				_la = _input.LA(1);
				if ( !(_la==Struct || _la==Union) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(732);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
				case 1:
					{
					setState(731);
					identifier();
					}
					break;
				}
				setState(734);
				match(LeCuBr);
				setState(735);
				struct_declaration_list();
				setState(736);
				match(RiCuBr);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(738);
				_la = _input.LA(1);
				if ( !(_la==Struct || _la==Union) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(739);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitStruct_declaration_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_declaration_listContext struct_declaration_list() throws RecognitionException {
		Struct_declaration_listContext _localctx = new Struct_declaration_listContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_struct_declaration_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(743); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(742);
					struct_declaration();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(745); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
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
		enterRule(_localctx, 88, RULE_struct_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(747);
			specifier_qualifier_list();
			setState(748);
			struct_declarator_list();
			setState(749);
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
		enterRule(_localctx, 90, RULE_specifier_qualifier_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(753);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(751);
				type_specifier();
				}
				break;
			case 2:
				{
				setState(752);
				type_qualifier();
				}
				break;
			}
			setState(756);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				setState(755);
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
		enterRule(_localctx, 92, RULE_struct_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(758);
			struct_declarator();
			setState(763);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(759);
				match(Comma);
				setState(760);
				struct_declarator();
				}
				}
				setState(765);
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
		enterRule(_localctx, 94, RULE_struct_declarator);
		try {
			setState(772);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(766);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(768);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
				case 1:
					{
					setState(767);
					declarator();
					}
					break;
				}
				setState(770);
				match(Colon);
				setState(771);
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
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
		enterRule(_localctx, 96, RULE_enum_specifier);
		int _la;
		try {
			setState(787);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(774);
				match(Enum);
				setState(776);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(775);
					identifier();
					}
					break;
				}
				setState(778);
				match(LeCuBr);
				setState(779);
				enumerator_list();
				setState(781);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(780);
					match(Comma);
					}
				}

				setState(783);
				match(RiCuBr);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(785);
				match(Enum);
				setState(786);
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
		enterRule(_localctx, 98, RULE_enumerator_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(789);
			enumerator();
			setState(794);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(790);
					match(Comma);
					setState(791);
					enumerator();
					}
					} 
				}
				setState(796);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
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
		enterRule(_localctx, 100, RULE_enumerator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(797);
			identifier();
			setState(800);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(798);
				match(Assign);
				setState(799);
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
		public TerminalNode RWTWICE() { return getToken(C99A3Parser.RWTWICE, 0); }
		public TerminalNode ROTWICE() { return getToken(C99A3Parser.ROTWICE, 0); }
		public TerminalNode WOTWICE() { return getToken(C99A3Parser.WOTWICE, 0); }
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
		enterRule(_localctx, 102, RULE_type_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(802);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_declarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(805);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(804);
				pointer();
				}
				break;
			}
			setState(807);
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
		int _startState = 106;
		enterRecursionRule(_localctx, 106, RULE_direct_declarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(815);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(810);
				identifier();
				}
				break;
			case 2:
				{
				setState(811);
				match(LeRoBr);
				setState(812);
				declarator();
				setState(813);
				match(RiRoBr);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(862);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(860);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
					case 1:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(817);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(818);
						match(LeSqBr);
						setState(820);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
						case 1:
							{
							setState(819);
							type_qualifier_list();
							}
							break;
						}
						setState(823);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
						case 1:
							{
							setState(822);
							assignment_expression();
							}
							break;
						}
						setState(825);
						match(RiSqBr);
						}
						break;
					case 2:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(826);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(827);
						match(LeSqBr);
						setState(828);
						match(Static);
						setState(830);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
						case 1:
							{
							setState(829);
							type_qualifier_list();
							}
							break;
						}
						setState(832);
						assignment_expression();
						setState(833);
						match(RiSqBr);
						}
						break;
					case 3:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(835);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(836);
						match(LeSqBr);
						setState(837);
						type_qualifier_list();
						setState(838);
						match(Static);
						setState(839);
						assignment_expression();
						setState(840);
						match(RiSqBr);
						}
						break;
					case 4:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(842);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(843);
						match(LeSqBr);
						setState(845);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 126100798158405664L) != 0)) {
							{
							setState(844);
							type_qualifier_list();
							}
						}

						setState(847);
						match(Star);
						setState(848);
						match(RiSqBr);
						}
						break;
					case 5:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(849);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(850);
						match(LeRoBr);
						setState(851);
						parameter_type_list();
						setState(852);
						match(RiRoBr);
						}
						break;
					case 6:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(854);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(855);
						match(LeRoBr);
						setState(857);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
						case 1:
							{
							setState(856);
							identifier_list();
							}
							break;
						}
						setState(859);
						match(RiRoBr);
						}
						break;
					}
					} 
				}
				setState(864);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
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
		enterRule(_localctx, 108, RULE_pointer);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(869); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(865);
					match(Star);
					setState(867);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
					case 1:
						{
						setState(866);
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
				setState(871); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitType_qualifier_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_qualifier_listContext type_qualifier_list() throws RecognitionException {
		Type_qualifier_listContext _localctx = new Type_qualifier_listContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_type_qualifier_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(874); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(873);
					type_qualifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(876); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
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
		enterRule(_localctx, 112, RULE_parameter_type_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(878);
			parameter_list();
			setState(881);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(879);
				match(Comma);
				setState(880);
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
		enterRule(_localctx, 114, RULE_parameter_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(883);
			parameter_declaration();
			setState(888);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(884);
					match(Comma);
					setState(885);
					parameter_declaration();
					}
					} 
				}
				setState(890);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
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
		enterRule(_localctx, 116, RULE_parameter_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(891);
			declaration_specifiers();
			setState(896);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				{
				setState(892);
				declarator();
				}
				break;
			case 2:
				{
				setState(894);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 327681L) != 0)) {
					{
					setState(893);
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
		enterRule(_localctx, 118, RULE_identifier_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(898);
			identifier();
			setState(903);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(899);
					match(Comma);
					setState(900);
					identifier();
					}
					} 
				}
				setState(905);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
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
		enterRule(_localctx, 120, RULE_type_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(906);
			specifier_qualifier_list();
			setState(908);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 327681L) != 0)) {
				{
				setState(907);
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
		enterRule(_localctx, 122, RULE_abstract_declarator);
		int _la;
		try {
			setState(915);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(910);
				pointer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(912);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Star) {
					{
					setState(911);
					pointer();
					}
				}

				setState(914);
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
		int _startState = 124;
		enterRecursionRule(_localctx, 124, RULE_direct_abstract_declarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(959);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				{
				setState(918);
				match(LeRoBr);
				setState(919);
				abstract_declarator();
				setState(920);
				match(RiRoBr);
				}
				break;
			case 2:
				{
				setState(922);
				match(LeSqBr);
				setState(924);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
				case 1:
					{
					setState(923);
					type_qualifier_list();
					}
					break;
				}
				setState(927);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
				case 1:
					{
					setState(926);
					assignment_expression();
					}
					break;
				}
				setState(929);
				match(RiSqBr);
				}
				break;
			case 3:
				{
				setState(930);
				match(LeSqBr);
				setState(931);
				match(Static);
				setState(933);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
				case 1:
					{
					setState(932);
					type_qualifier_list();
					}
					break;
				}
				setState(935);
				assignment_expression();
				setState(936);
				match(RiSqBr);
				}
				break;
			case 4:
				{
				setState(938);
				match(LeSqBr);
				setState(939);
				type_qualifier_list();
				setState(940);
				match(Static);
				setState(941);
				assignment_expression();
				setState(942);
				match(RiSqBr);
				}
				break;
			case 5:
				{
				setState(944);
				match(LeSqBr);
				setState(946);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 126100798158405664L) != 0)) {
					{
					setState(945);
					type_qualifier_list();
					}
				}

				setState(948);
				match(Star);
				setState(949);
				match(RiSqBr);
				}
				break;
			case 6:
				{
				setState(950);
				match(LeRoBr);
				setState(951);
				parameter_type_list();
				setState(952);
				match(RiRoBr);
				}
				break;
			case 7:
				{
				setState(954);
				match(LeRoBr);
				setState(956);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
				case 1:
					{
					setState(955);
					identifier_list();
					}
					break;
				}
				setState(958);
				match(RiRoBr);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1006);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1004);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
					case 1:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(961);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(962);
						match(LeSqBr);
						setState(964);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
						case 1:
							{
							setState(963);
							type_qualifier_list();
							}
							break;
						}
						setState(967);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
						case 1:
							{
							setState(966);
							assignment_expression();
							}
							break;
						}
						setState(969);
						match(RiSqBr);
						}
						break;
					case 2:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(970);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(971);
						match(LeSqBr);
						setState(972);
						match(Static);
						setState(974);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
						case 1:
							{
							setState(973);
							type_qualifier_list();
							}
							break;
						}
						setState(976);
						assignment_expression();
						setState(977);
						match(RiSqBr);
						}
						break;
					case 3:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(979);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(980);
						match(LeSqBr);
						setState(981);
						type_qualifier_list();
						setState(982);
						match(Static);
						setState(983);
						assignment_expression();
						setState(984);
						match(RiSqBr);
						}
						break;
					case 4:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(986);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(987);
						match(LeSqBr);
						setState(989);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 126100798158405664L) != 0)) {
							{
							setState(988);
							type_qualifier_list();
							}
						}

						setState(991);
						match(Star);
						setState(992);
						match(RiSqBr);
						}
						break;
					case 5:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(993);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(994);
						match(LeRoBr);
						setState(995);
						parameter_type_list();
						setState(996);
						match(RiRoBr);
						}
						break;
					case 6:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(998);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(999);
						match(LeRoBr);
						setState(1001);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
						case 1:
							{
							setState(1000);
							identifier_list();
							}
							break;
						}
						setState(1003);
						match(RiRoBr);
						}
						break;
					}
					} 
				}
				setState(1008);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
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
		enterRule(_localctx, 126, RULE_typedef_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1009);
			if (!(C99Compiler.C99Compiler.hasTypedef(getCurrentToken().getText()))) throw new FailedPredicateException(this, "C99Compiler.C99Compiler.hasTypedef(getCurrentToken().getText())");
			setState(1010);
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
		enterRule(_localctx, 128, RULE_initializer);
		int _la;
		try {
			setState(1020);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1012);
				assignment_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1013);
				match(LeCuBr);
				setState(1014);
				initializer_list();
				setState(1016);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(1015);
					match(Comma);
					}
				}

				setState(1018);
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
		enterRule(_localctx, 130, RULE_initializer_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1023);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
			case 1:
				{
				setState(1022);
				designation();
				}
				break;
			}
			setState(1025);
			initializer();
			setState(1033);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1026);
					match(Comma);
					setState(1028);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
					case 1:
						{
						setState(1027);
						designation();
						}
						break;
					}
					setState(1030);
					initializer();
					}
					} 
				}
				setState(1035);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
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
		enterRule(_localctx, 132, RULE_designation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1036);
			designator_list();
			setState(1037);
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
		enterRule(_localctx, 134, RULE_designator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1040); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1039);
				designator();
				}
				}
				setState(1042); 
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
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
		enterRule(_localctx, 136, RULE_designator);
		try {
			setState(1050);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeSqBr:
				enterOuterAlt(_localctx, 1);
				{
				setState(1044);
				match(LeSqBr);
				setState(1045);
				constant_expression();
				setState(1046);
				match(RiSqBr);
				}
				break;
			case Period:
				enterOuterAlt(_localctx, 2);
				{
				setState(1048);
				match(Period);
				setState(1049);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_statement);
		try {
			setState(1059);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1052);
				asm_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1053);
				labeled_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1054);
				compound_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1055);
				expression_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1056);
				selection_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1057);
				iteration_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1058);
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
		enterRule(_localctx, 140, RULE_labeled_statement);
		try {
			setState(1073);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1061);
				identifier();
				setState(1062);
				match(Colon);
				setState(1063);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1065);
				match(Case);
				setState(1066);
				constant_expression();
				setState(1067);
				match(Colon);
				setState(1068);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1070);
				match(Default);
				setState(1071);
				match(Colon);
				setState(1072);
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
		enterRule(_localctx, 142, RULE_compound_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1075);
			match(LeCuBr);
			setState(1077);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				{
				setState(1076);
				block_item_list();
				}
				break;
			}
			setState(1079);
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
		enterRule(_localctx, 144, RULE_block_item_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1082); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1081);
					block_item();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1084); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitBlock_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_itemContext block_item() throws RecognitionException {
		Block_itemContext _localctx = new Block_itemContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_block_item);
		try {
			setState(1088);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1086);
				declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1087);
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
		enterRule(_localctx, 148, RULE_expression_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1091);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				{
				setState(1090);
				expression();
				}
				break;
			}
			setState(1093);
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
		enterRule(_localctx, 150, RULE_selection_statement);
		try {
			setState(1115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1095);
				match(If);
				setState(1096);
				match(LeRoBr);
				setState(1097);
				expression();
				setState(1098);
				match(RiRoBr);
				setState(1099);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1101);
				match(If);
				setState(1102);
				match(LeRoBr);
				setState(1103);
				expression();
				setState(1104);
				match(RiRoBr);
				setState(1105);
				statement();
				setState(1106);
				match(Else);
				setState(1107);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1109);
				match(Switch);
				setState(1110);
				match(LeRoBr);
				setState(1111);
				expression();
				setState(1112);
				match(RiRoBr);
				setState(1113);
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
		enterRule(_localctx, 152, RULE_iteration_statement);
		try {
			setState(1159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1117);
				match(While);
				setState(1118);
				match(LeRoBr);
				setState(1119);
				expression();
				setState(1120);
				match(RiRoBr);
				setState(1121);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1123);
				match(Do);
				setState(1124);
				statement();
				setState(1125);
				match(While);
				setState(1126);
				match(LeRoBr);
				setState(1127);
				expression();
				setState(1128);
				match(RiRoBr);
				setState(1129);
				match(Semico);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1131);
				match(For);
				setState(1132);
				match(LeRoBr);
				setState(1134);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
				case 1:
					{
					setState(1133);
					expression();
					}
					break;
				}
				setState(1136);
				match(Semico);
				setState(1138);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
				case 1:
					{
					setState(1137);
					expression();
					}
					break;
				}
				setState(1140);
				match(Semico);
				setState(1142);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
				case 1:
					{
					setState(1141);
					expression();
					}
					break;
				}
				setState(1144);
				match(RiRoBr);
				setState(1145);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1146);
				match(For);
				setState(1147);
				match(LeRoBr);
				setState(1148);
				declaration();
				setState(1150);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
				case 1:
					{
					setState(1149);
					expression();
					}
					break;
				}
				setState(1152);
				match(Semico);
				setState(1154);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
				case 1:
					{
					setState(1153);
					expression();
					}
					break;
				}
				setState(1156);
				match(RiRoBr);
				setState(1157);
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
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
		enterRule(_localctx, 154, RULE_jump_statement);
		try {
			setState(1174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Goto:
				enterOuterAlt(_localctx, 1);
				{
				setState(1161);
				match(Goto);
				setState(1162);
				identifier();
				setState(1163);
				match(Semico);
				}
				break;
			case Continue:
				enterOuterAlt(_localctx, 2);
				{
				setState(1165);
				match(Continue);
				setState(1166);
				match(Semico);
				}
				break;
			case Break:
				enterOuterAlt(_localctx, 3);
				{
				setState(1167);
				match(Break);
				setState(1168);
				match(Semico);
				}
				break;
			case Return:
				enterOuterAlt(_localctx, 4);
				{
				setState(1169);
				match(Return);
				setState(1171);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
				case 1:
					{
					setState(1170);
					expression();
					}
					break;
				}
				setState(1173);
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
		enterRule(_localctx, 156, RULE_asm_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1176);
			match(Asm);
			setState(1177);
			match(LeRoBr);
			setState(1178);
			match(String_literal);
			setState(1179);
			match(RiRoBr);
			setState(1180);
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
		enterRule(_localctx, 158, RULE_translation_unit);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1183); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1182);
					external_declaration();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1185); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
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
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitExternal_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final External_declarationContext external_declaration() throws RecognitionException {
		External_declarationContext _localctx = new External_declarationContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_external_declaration);
		try {
			setState(1189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1187);
				function_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1188);
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
		enterRule(_localctx, 162, RULE_function_definition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1194);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1191);
					attributes_declaration();
					}
					} 
				}
				setState(1196);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
			}
			setState(1197);
			declaration_specifiers();
			setState(1198);
			declarator();
			setState(1200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
			case 1:
				{
				setState(1199);
				declaration_list();
				}
				break;
			}
			setState(1202);
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
		enterRule(_localctx, 164, RULE_declaration_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1205); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1204);
					declaration();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1207); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,129,_ctx);
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
		case 12:
			return keyword_sempred((KeywordContext)_localctx, predIndex);
		case 14:
			return identifier_sempred((IdentifierContext)_localctx, predIndex);
		case 16:
			return postfix_expression_sempred((Postfix_expressionContext)_localctx, predIndex);
		case 20:
			return multiplicative_expression_sempred((Multiplicative_expressionContext)_localctx, predIndex);
		case 21:
			return additive_expression_sempred((Additive_expressionContext)_localctx, predIndex);
		case 22:
			return shift_expression_sempred((Shift_expressionContext)_localctx, predIndex);
		case 23:
			return relational_expression_sempred((Relational_expressionContext)_localctx, predIndex);
		case 24:
			return equality_expression_sempred((Equality_expressionContext)_localctx, predIndex);
		case 25:
			return and_expression_sempred((And_expressionContext)_localctx, predIndex);
		case 26:
			return xor_expression_sempred((Xor_expressionContext)_localctx, predIndex);
		case 27:
			return or_expression_sempred((Or_expressionContext)_localctx, predIndex);
		case 28:
			return land_expression_sempred((Land_expressionContext)_localctx, predIndex);
		case 29:
			return lor_expression_sempred((Lor_expressionContext)_localctx, predIndex);
		case 53:
			return direct_declarator_sempred((Direct_declaratorContext)_localctx, predIndex);
		case 62:
			return direct_abstract_declarator_sempred((Direct_abstract_declaratorContext)_localctx, predIndex);
		case 63:
			return typedef_name_sempred((Typedef_nameContext)_localctx, predIndex);
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
	private boolean identifier_sempred(IdentifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return !C99Compiler.C99Compiler.hasTypedef(getCurrentToken().getText());
		}
		return true;
	}
	private boolean postfix_expression_sempred(Postfix_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return precpred(_ctx, 7);
		case 15:
			return precpred(_ctx, 6);
		case 16:
			return precpred(_ctx, 5);
		case 17:
			return precpred(_ctx, 4);
		case 18:
			return precpred(_ctx, 3);
		case 19:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multiplicative_expression_sempred(Multiplicative_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 20:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additive_expression_sempred(Additive_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 21:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean shift_expression_sempred(Shift_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 22:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relational_expression_sempred(Relational_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 23:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equality_expression_sempred(Equality_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 24:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean and_expression_sempred(And_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 25:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean xor_expression_sempred(Xor_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 26:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean or_expression_sempred(Or_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 27:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean land_expression_sempred(Land_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 28:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean lor_expression_sempred(Lor_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 29:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean direct_declarator_sempred(Direct_declaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 30:
			return precpred(_ctx, 6);
		case 31:
			return precpred(_ctx, 5);
		case 32:
			return precpred(_ctx, 4);
		case 33:
			return precpred(_ctx, 3);
		case 34:
			return precpred(_ctx, 2);
		case 35:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean direct_abstract_declarator_sempred(Direct_abstract_declaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 36:
			return precpred(_ctx, 12);
		case 37:
			return precpred(_ctx, 10);
		case 38:
			return precpred(_ctx, 8);
		case 39:
			return precpred(_ctx, 6);
		case 40:
			return precpred(_ctx, 4);
		case 41:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean typedef_name_sempred(Typedef_nameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 42:
			return C99Compiler.C99Compiler.hasTypedef(getCurrentToken().getText());
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001x\u04ba\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0001\u0000\u0003\u0000\u00a8\b\u0000"+
		"\u0001\u0001\u0004\u0001\u00ab\b\u0001\u000b\u0001\f\u0001\u00ac\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00b4"+
		"\b\u0002\u0001\u0003\u0001\u0003\u0005\u0003\u00b8\b\u0003\n\u0003\f\u0003"+
		"\u00bb\t\u0003\u0001\u0003\u0003\u0003\u00be\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004\u00c5\b\u0004\u000b"+
		"\u0004\f\u0004\u00c6\u0001\u0004\u0001\u0004\u0003\u0004\u00cb\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"\u00d2\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u00d9\b\u0004\u0003\u0004\u00db\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0004\u0005\u00e0\b\u0005\u000b\u0005\f\u0005\u00e1"+
		"\u0001\u0005\u0001\u0005\u0003\u0005\u00e6\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u00ec\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0004\b\u00f5\b\b\u000b"+
		"\b\f\b\u00f6\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u0100\b\b\u0001\b\u0001\b\u0005\b\u0104\b\b\n\b\f\b\u0107\t\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0111"+
		"\b\b\n\b\f\b\u0114\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0120\b\b\n\b\f\b\u0123\t\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u012b\b\b\n\b\f\b\u012e"+
		"\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005"+
		"\b\u0138\b\b\n\b\f\b\u013b\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b"+
		"\u0141\b\b\n\b\f\b\u0144\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u014a"+
		"\b\b\n\b\f\b\u014d\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0004\b\u0153\b"+
		"\b\u000b\b\f\b\u0154\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u015b\b\b"+
		"\u0001\t\u0005\t\u015e\b\t\n\t\f\t\u0161\t\t\u0001\t\u0001\t\u0001\n\u0004"+
		"\n\u0166\b\n\u000b\n\f\n\u0167\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0172\b\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u01b9\b\f\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u01c7\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u01d1\b\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u01d5\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u01df\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u01ec\b\u0010\n\u0010\f\u0010\u01ef\t\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0005\u0011\u01f4\b\u0011\n\u0011\f\u0011\u01f7\t\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u0219\b\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0221\b\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0005\u0014\u0229\b\u0014\n\u0014\f\u0014\u022c\t\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0234"+
		"\b\u0015\n\u0015\f\u0015\u0237\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u023f\b\u0016\n\u0016"+
		"\f\u0016\u0242\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0005\u0017\u024a\b\u0017\n\u0017\f\u0017\u024d"+
		"\t\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0005\u0018\u0255\b\u0018\n\u0018\f\u0018\u0258\t\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019"+
		"\u0260\b\u0019\n\u0019\f\u0019\u0263\t\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u026b\b\u001a\n"+
		"\u001a\f\u001a\u026e\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u0276\b\u001b\n\u001b\f\u001b"+
		"\u0279\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0005\u001c\u0281\b\u001c\n\u001c\f\u001c\u0284\t\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005"+
		"\u001d\u028c\b\u001d\n\u001d\f\u001d\u028f\t\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e"+
		"\u0298\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0003\u001f\u029f\b\u001f\u0001 \u0001 \u0001 \u0005 \u02a4\b \n \f "+
		"\u02a7\t \u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001#\u0005#"+
		"\u02b0\b#\n#\f#\u02b3\t#\u0001#\u0001#\u0003#\u02b7\b#\u0001#\u0001#\u0001"+
		"#\u0001$\u0001$\u0001$\u0001$\u0004$\u02c0\b$\u000b$\f$\u02c1\u0001%\u0001"+
		"%\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0005\'\u02cb\b\'\n\'\f\'\u02ce"+
		"\t\'\u0001(\u0001(\u0001(\u0003(\u02d3\b(\u0001)\u0001)\u0001)\u0001)"+
		"\u0003)\u02d9\b)\u0001*\u0001*\u0003*\u02dd\b*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0003*\u02e5\b*\u0001+\u0004+\u02e8\b+\u000b+\f+\u02e9"+
		"\u0001,\u0001,\u0001,\u0001,\u0001-\u0001-\u0003-\u02f2\b-\u0001-\u0003"+
		"-\u02f5\b-\u0001.\u0001.\u0001.\u0005.\u02fa\b.\n.\f.\u02fd\t.\u0001/"+
		"\u0001/\u0003/\u0301\b/\u0001/\u0001/\u0003/\u0305\b/\u00010\u00010\u0003"+
		"0\u0309\b0\u00010\u00010\u00010\u00030\u030e\b0\u00010\u00010\u00010\u0001"+
		"0\u00030\u0314\b0\u00011\u00011\u00011\u00051\u0319\b1\n1\f1\u031c\t1"+
		"\u00012\u00012\u00012\u00032\u0321\b2\u00013\u00013\u00014\u00034\u0326"+
		"\b4\u00014\u00014\u00015\u00015\u00015\u00015\u00015\u00015\u00035\u0330"+
		"\b5\u00015\u00015\u00015\u00035\u0335\b5\u00015\u00035\u0338\b5\u0001"+
		"5\u00015\u00015\u00015\u00015\u00035\u033f\b5\u00015\u00015\u00015\u0001"+
		"5\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u0003"+
		"5\u034e\b5\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u0001"+
		"5\u00015\u00035\u035a\b5\u00015\u00055\u035d\b5\n5\f5\u0360\t5\u00016"+
		"\u00016\u00036\u0364\b6\u00046\u0366\b6\u000b6\f6\u0367\u00017\u00047"+
		"\u036b\b7\u000b7\f7\u036c\u00018\u00018\u00018\u00038\u0372\b8\u00019"+
		"\u00019\u00019\u00059\u0377\b9\n9\f9\u037a\t9\u0001:\u0001:\u0001:\u0003"+
		":\u037f\b:\u0003:\u0381\b:\u0001;\u0001;\u0001;\u0005;\u0386\b;\n;\f;"+
		"\u0389\t;\u0001<\u0001<\u0003<\u038d\b<\u0001=\u0001=\u0003=\u0391\b="+
		"\u0001=\u0003=\u0394\b=\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001"+
		">\u0003>\u039d\b>\u0001>\u0003>\u03a0\b>\u0001>\u0001>\u0001>\u0001>\u0003"+
		">\u03a6\b>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001"+
		">\u0001>\u0001>\u0003>\u03b3\b>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001"+
		">\u0001>\u0001>\u0003>\u03bd\b>\u0001>\u0003>\u03c0\b>\u0001>\u0001>\u0001"+
		">\u0003>\u03c5\b>\u0001>\u0003>\u03c8\b>\u0001>\u0001>\u0001>\u0001>\u0001"+
		">\u0003>\u03cf\b>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001"+
		">\u0001>\u0001>\u0001>\u0001>\u0001>\u0003>\u03de\b>\u0001>\u0001>\u0001"+
		">\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0003>\u03ea\b>\u0001"+
		">\u0005>\u03ed\b>\n>\f>\u03f0\t>\u0001?\u0001?\u0001?\u0001@\u0001@\u0001"+
		"@\u0001@\u0003@\u03f9\b@\u0001@\u0001@\u0003@\u03fd\b@\u0001A\u0003A\u0400"+
		"\bA\u0001A\u0001A\u0001A\u0003A\u0405\bA\u0001A\u0005A\u0408\bA\nA\fA"+
		"\u040b\tA\u0001B\u0001B\u0001B\u0001C\u0004C\u0411\bC\u000bC\fC\u0412"+
		"\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0003D\u041b\bD\u0001E\u0001"+
		"E\u0001E\u0001E\u0001E\u0001E\u0001E\u0003E\u0424\bE\u0001F\u0001F\u0001"+
		"F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0003"+
		"F\u0432\bF\u0001G\u0001G\u0003G\u0436\bG\u0001G\u0001G\u0001H\u0004H\u043b"+
		"\bH\u000bH\fH\u043c\u0001I\u0001I\u0003I\u0441\bI\u0001J\u0003J\u0444"+
		"\bJ\u0001J\u0001J\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0003K\u045c\bK\u0001L\u0001L\u0001L\u0001L\u0001L\u0001"+
		"L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001"+
		"L\u0001L\u0003L\u046f\bL\u0001L\u0001L\u0003L\u0473\bL\u0001L\u0001L\u0003"+
		"L\u0477\bL\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0003L\u047f\bL\u0001"+
		"L\u0001L\u0003L\u0483\bL\u0001L\u0001L\u0001L\u0003L\u0488\bL\u0001M\u0001"+
		"M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0003M\u0494"+
		"\bM\u0001M\u0003M\u0497\bM\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001"+
		"O\u0004O\u04a0\bO\u000bO\fO\u04a1\u0001P\u0001P\u0003P\u04a6\bP\u0001"+
		"Q\u0005Q\u04a9\bQ\nQ\fQ\u04ac\tQ\u0001Q\u0001Q\u0001Q\u0003Q\u04b1\bQ"+
		"\u0001Q\u0001Q\u0001R\u0004R\u04b6\bR\u000bR\fR\u04b7\u0001R\u0003\u00ac"+
		"\u0167\u02c1\r (*,.02468:j|S\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPR"+
		"TVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e"+
		"\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u0000"+
		"\r\u0001\u00009p\u0001\u0000Z_\u0001\u0000wx\u0002\u0000[[`a\u0001\u0000"+
		"\\]\u0001\u0000>?\u0001\u0000@C\u0001\u0000DE\u0002\u0000HQhh\u0006\u0000"+
		"\u0001\u0001\f\f\u0014\u0014\u001a\u001a\u001d\u001d55\u0007\u0000\u0004"+
		"\u0004\t\t\r\r\u0012\u0013\u0017\u0018\u001f #$\u0002\u0000\u001b\u001b"+
		"\u001e\u001e\u0004\u0000\u0005\u0005\u0015\u0015!!68\u0558\u0000\u00a7"+
		"\u0001\u0000\u0000\u0000\u0002\u00aa\u0001\u0000\u0000\u0000\u0004\u00b3"+
		"\u0001\u0000\u0000\u0000\u0006\u00b5\u0001\u0000\u0000\u0000\b\u00da\u0001"+
		"\u0000\u0000\u0000\n\u00dc\u0001\u0000\u0000\u0000\f\u00e7\u0001\u0000"+
		"\u0000\u0000\u000e\u00ed\u0001\u0000\u0000\u0000\u0010\u015a\u0001\u0000"+
		"\u0000\u0000\u0012\u015f\u0001\u0000\u0000\u0000\u0014\u0165\u0001\u0000"+
		"\u0000\u0000\u0016\u0171\u0001\u0000\u0000\u0000\u0018\u01b8\u0001\u0000"+
		"\u0000\u0000\u001a\u01ba\u0001\u0000\u0000\u0000\u001c\u01bc\u0001\u0000"+
		"\u0000\u0000\u001e\u01c6\u0001\u0000\u0000\u0000 \u01d4\u0001\u0000\u0000"+
		"\u0000\"\u01f0\u0001\u0000\u0000\u0000$\u0218\u0001\u0000\u0000\u0000"+
		"&\u0220\u0001\u0000\u0000\u0000(\u0222\u0001\u0000\u0000\u0000*\u022d"+
		"\u0001\u0000\u0000\u0000,\u0238\u0001\u0000\u0000\u0000.\u0243\u0001\u0000"+
		"\u0000\u00000\u024e\u0001\u0000\u0000\u00002\u0259\u0001\u0000\u0000\u0000"+
		"4\u0264\u0001\u0000\u0000\u00006\u026f\u0001\u0000\u0000\u00008\u027a"+
		"\u0001\u0000\u0000\u0000:\u0285\u0001\u0000\u0000\u0000<\u0297\u0001\u0000"+
		"\u0000\u0000>\u029e\u0001\u0000\u0000\u0000@\u02a0\u0001\u0000\u0000\u0000"+
		"B\u02a8\u0001\u0000\u0000\u0000D\u02aa\u0001\u0000\u0000\u0000F\u02b1"+
		"\u0001\u0000\u0000\u0000H\u02bf\u0001\u0000\u0000\u0000J\u02c3\u0001\u0000"+
		"\u0000\u0000L\u02c5\u0001\u0000\u0000\u0000N\u02c7\u0001\u0000\u0000\u0000"+
		"P\u02cf\u0001\u0000\u0000\u0000R\u02d8\u0001\u0000\u0000\u0000T\u02e4"+
		"\u0001\u0000\u0000\u0000V\u02e7\u0001\u0000\u0000\u0000X\u02eb\u0001\u0000"+
		"\u0000\u0000Z\u02f1\u0001\u0000\u0000\u0000\\\u02f6\u0001\u0000\u0000"+
		"\u0000^\u0304\u0001\u0000\u0000\u0000`\u0313\u0001\u0000\u0000\u0000b"+
		"\u0315\u0001\u0000\u0000\u0000d\u031d\u0001\u0000\u0000\u0000f\u0322\u0001"+
		"\u0000\u0000\u0000h\u0325\u0001\u0000\u0000\u0000j\u032f\u0001\u0000\u0000"+
		"\u0000l\u0365\u0001\u0000\u0000\u0000n\u036a\u0001\u0000\u0000\u0000p"+
		"\u036e\u0001\u0000\u0000\u0000r\u0373\u0001\u0000\u0000\u0000t\u037b\u0001"+
		"\u0000\u0000\u0000v\u0382\u0001\u0000\u0000\u0000x\u038a\u0001\u0000\u0000"+
		"\u0000z\u0393\u0001\u0000\u0000\u0000|\u03bf\u0001\u0000\u0000\u0000~"+
		"\u03f1\u0001\u0000\u0000\u0000\u0080\u03fc\u0001\u0000\u0000\u0000\u0082"+
		"\u03ff\u0001\u0000\u0000\u0000\u0084\u040c\u0001\u0000\u0000\u0000\u0086"+
		"\u0410\u0001\u0000\u0000\u0000\u0088\u041a\u0001\u0000\u0000\u0000\u008a"+
		"\u0423\u0001\u0000\u0000\u0000\u008c\u0431\u0001\u0000\u0000\u0000\u008e"+
		"\u0433\u0001\u0000\u0000\u0000\u0090\u043a\u0001\u0000\u0000\u0000\u0092"+
		"\u0440\u0001\u0000\u0000\u0000\u0094\u0443\u0001\u0000\u0000\u0000\u0096"+
		"\u045b\u0001\u0000\u0000\u0000\u0098\u0487\u0001\u0000\u0000\u0000\u009a"+
		"\u0496\u0001\u0000\u0000\u0000\u009c\u0498\u0001\u0000\u0000\u0000\u009e"+
		"\u049f\u0001\u0000\u0000\u0000\u00a0\u04a5\u0001\u0000\u0000\u0000\u00a2"+
		"\u04aa\u0001\u0000\u0000\u0000\u00a4\u04b5\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a8\u0003\u0002\u0001\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a8\u0001\u0000\u0000\u0000\u00a8\u0001\u0001\u0000\u0000\u0000\u00a9"+
		"\u00ab\u0003\u0004\u0002\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ac"+
		"\u00aa\u0001\u0000\u0000\u0000\u00ad\u0003\u0001\u0000\u0000\u0000\u00ae"+
		"\u00b4\u0003\u0006\u0003\u0000\u00af\u00b4\u0003\u0010\b\u0000\u00b0\u00b1"+
		"\u0005j\u0000\u0000\u00b1\u00b4\u0003\u0014\n\u0000\u00b2\u00b4\u0003"+
		"\u0012\t\u0000\u00b3\u00ae\u0001\u0000\u0000\u0000\u00b3\u00af\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b4\u0005\u0001\u0000\u0000\u0000\u00b5\u00b9\u0003\b\u0004"+
		"\u0000\u00b6\u00b8\u0003\n\u0005\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b8\u00bb\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bd\u0001\u0000\u0000\u0000"+
		"\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u00be\u0003\f\u0006\u0000\u00bd"+
		"\u00bc\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be"+
		"\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c0\u0003\u000e\u0007\u0000\u00c0"+
		"\u0007\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005j\u0000\u0000\u00c2\u00c4"+
		"\u0005\u0010\u0000\u0000\u00c3\u00c5\u0003\u0016\u000b\u0000\u00c4\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c8"+
		"\u0001\u0000\u0000\u0000\u00c8\u00ca\u0005s\u0000\u0000\u00c9\u00cb\u0003"+
		"\u0002\u0001\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001"+
		"\u0000\u0000\u0000\u00cb\u00db\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005"+
		"j\u0000\u0000\u00cd\u00ce\u0005)\u0000\u0000\u00ce\u00cf\u0005t\u0000"+
		"\u0000\u00cf\u00d1\u0005s\u0000\u0000\u00d0\u00d2\u0003\u0002\u0001\u0000"+
		"\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000"+
		"\u00d2\u00db\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005j\u0000\u0000\u00d4"+
		"\u00d5\u0005*\u0000\u0000\u00d5\u00d6\u0005t\u0000\u0000\u00d6\u00d8\u0005"+
		"s\u0000\u0000\u00d7\u00d9\u0003\u0002\u0001\u0000\u00d8\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00db\u0001\u0000"+
		"\u0000\u0000\u00da\u00c1\u0001\u0000\u0000\u0000\u00da\u00cc\u0001\u0000"+
		"\u0000\u0000\u00da\u00d3\u0001\u0000\u0000\u0000\u00db\t\u0001\u0000\u0000"+
		"\u0000\u00dc\u00dd\u0005j\u0000\u0000\u00dd\u00df\u0005+\u0000\u0000\u00de"+
		"\u00e0\u0003\u0016\u000b\u0000\u00df\u00de\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e1\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3"+
		"\u00e5\u0005s\u0000\u0000\u00e4\u00e6\u0003\u0002\u0001\u0000\u00e5\u00e4"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u000b"+
		"\u0001\u0000\u0000\u0000\u00e7\u00e8\u0005j\u0000\u0000\u00e8\u00e9\u0005"+
		"\n\u0000\u0000\u00e9\u00eb\u0005s\u0000\u0000\u00ea\u00ec\u0003\u0002"+
		"\u0001\u0000\u00eb\u00ea\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ec\r\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005j\u0000"+
		"\u0000\u00ee\u00ef\u0005,\u0000\u0000\u00ef\u00f0\u0005s\u0000\u0000\u00f0"+
		"\u000f\u0001\u0000\u0000\u0000\u00f1\u00f2\u0005j\u0000\u0000\u00f2\u00f4"+
		"\u0005-\u0000\u0000\u00f3\u00f5\u0003\u0016\u000b\u0000\u00f4\u00f3\u0001"+
		"\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f9\u0005s\u0000\u0000\u00f9\u015b\u0001\u0000"+
		"\u0000\u0000\u00fa\u00fb\u0005j\u0000\u0000\u00fb\u00fc\u0005(\u0000\u0000"+
		"\u00fc\u00fd\u0005t\u0000\u0000\u00fd\u00ff\u0005m\u0000\u0000\u00fe\u0100"+
		"\u0003v;\u0000\u00ff\u00fe\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000"+
		"\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101\u0105\u0005n\u0000"+
		"\u0000\u0102\u0104\u0003\u0016\u000b\u0000\u0103\u0102\u0001\u0000\u0000"+
		"\u0000\u0104\u0107\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000"+
		"\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u0108\u0001\u0000\u0000"+
		"\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0108\u015b\u0005s\u0000\u0000"+
		"\u0109\u010a\u0005j\u0000\u0000\u010a\u010b\u0005(\u0000\u0000\u010b\u010c"+
		"\u0005t\u0000\u0000\u010c\u010d\u0005m\u0000\u0000\u010d\u010e\u0005:"+
		"\u0000\u0000\u010e\u0112\u0005n\u0000\u0000\u010f\u0111\u0003\u0016\u000b"+
		"\u0000\u0110\u010f\u0001\u0000\u0000\u0000\u0111\u0114\u0001\u0000\u0000"+
		"\u0000\u0112\u0110\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000"+
		"\u0000\u0113\u0115\u0001\u0000\u0000\u0000\u0114\u0112\u0001\u0000\u0000"+
		"\u0000\u0115\u015b\u0005s\u0000\u0000\u0116\u0117\u0005j\u0000\u0000\u0117"+
		"\u0118\u0005(\u0000\u0000\u0118\u0119\u0005t\u0000\u0000\u0119\u011a\u0005"+
		"m\u0000\u0000\u011a\u011b\u0003v;\u0000\u011b\u011c\u0005i\u0000\u0000"+
		"\u011c\u011d\u0005:\u0000\u0000\u011d\u0121\u0005n\u0000\u0000\u011e\u0120"+
		"\u0003\u0016\u000b\u0000\u011f\u011e\u0001\u0000\u0000\u0000\u0120\u0123"+
		"\u0001\u0000\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0121\u0122"+
		"\u0001\u0000\u0000\u0000\u0122\u0124\u0001\u0000\u0000\u0000\u0123\u0121"+
		"\u0001\u0000\u0000\u0000\u0124\u0125\u0005s\u0000\u0000\u0125\u015b\u0001"+
		"\u0000\u0000\u0000\u0126\u0127\u0005j\u0000\u0000\u0127\u0128\u0005(\u0000"+
		"\u0000\u0128\u012c\u0005t\u0000\u0000\u0129\u012b\u0003\u0016\u000b\u0000"+
		"\u012a\u0129\u0001\u0000\u0000\u0000\u012b\u012e\u0001\u0000\u0000\u0000"+
		"\u012c\u012a\u0001\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000"+
		"\u012d\u012f\u0001\u0000\u0000\u0000\u012e\u012c\u0001\u0000\u0000\u0000"+
		"\u012f\u015b\u0005s\u0000\u0000\u0130\u0131\u0005j\u0000\u0000\u0131\u0132"+
		"\u0005.\u0000\u0000\u0132\u0133\u0005t\u0000\u0000\u0133\u015b\u0005s"+
		"\u0000\u0000\u0134\u0135\u0005j\u0000\u0000\u0135\u0139\u0005/\u0000\u0000"+
		"\u0136\u0138\u0003\u0016\u000b\u0000\u0137\u0136\u0001\u0000\u0000\u0000"+
		"\u0138\u013b\u0001\u0000\u0000\u0000\u0139\u0137\u0001\u0000\u0000\u0000"+
		"\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013c\u0001\u0000\u0000\u0000"+
		"\u013b\u0139\u0001\u0000\u0000\u0000\u013c\u015b\u0005s\u0000\u0000\u013d"+
		"\u013e\u0005j\u0000\u0000\u013e\u0142\u00050\u0000\u0000\u013f\u0141\u0003"+
		"\u0016\u000b\u0000\u0140\u013f\u0001\u0000\u0000\u0000\u0141\u0144\u0001"+
		"\u0000\u0000\u0000\u0142\u0140\u0001\u0000\u0000\u0000\u0142\u0143\u0001"+
		"\u0000\u0000\u0000\u0143\u0145\u0001\u0000\u0000\u0000\u0144\u0142\u0001"+
		"\u0000\u0000\u0000\u0145\u015b\u0005s\u0000\u0000\u0146\u0147\u0005j\u0000"+
		"\u0000\u0147\u014b\u00051\u0000\u0000\u0148\u014a\u0003\u0016\u000b\u0000"+
		"\u0149\u0148\u0001\u0000\u0000\u0000\u014a\u014d\u0001\u0000\u0000\u0000"+
		"\u014b\u0149\u0001\u0000\u0000\u0000\u014b\u014c\u0001\u0000\u0000\u0000"+
		"\u014c\u014e\u0001\u0000\u0000\u0000\u014d\u014b\u0001\u0000\u0000\u0000"+
		"\u014e\u015b\u0005s\u0000\u0000\u014f\u0150\u0005j\u0000\u0000\u0150\u0152"+
		"\u00053\u0000\u0000\u0151\u0153\u0003\u0016\u000b\u0000\u0152\u0151\u0001"+
		"\u0000\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000\u0154\u0152\u0001"+
		"\u0000\u0000\u0000\u0154\u0155\u0001\u0000\u0000\u0000\u0155\u0156\u0001"+
		"\u0000\u0000\u0000\u0156\u0157\u0005s\u0000\u0000\u0157\u015b\u0001\u0000"+
		"\u0000\u0000\u0158\u0159\u0005j\u0000\u0000\u0159\u015b\u0005s\u0000\u0000"+
		"\u015a\u00f1\u0001\u0000\u0000\u0000\u015a\u00fa\u0001\u0000\u0000\u0000"+
		"\u015a\u0109\u0001\u0000\u0000\u0000\u015a\u0116\u0001\u0000\u0000\u0000"+
		"\u015a\u0126\u0001\u0000\u0000\u0000\u015a\u0130\u0001\u0000\u0000\u0000"+
		"\u015a\u0134\u0001\u0000\u0000\u0000\u015a\u013d\u0001\u0000\u0000\u0000"+
		"\u015a\u0146\u0001\u0000\u0000\u0000\u015a\u014f\u0001\u0000\u0000\u0000"+
		"\u015a\u0158\u0001\u0000\u0000\u0000\u015b\u0011\u0001\u0000\u0000\u0000"+
		"\u015c\u015e\u0003\u0016\u000b\u0000\u015d\u015c\u0001\u0000\u0000\u0000"+
		"\u015e\u0161\u0001\u0000\u0000\u0000\u015f\u015d\u0001\u0000\u0000\u0000"+
		"\u015f\u0160\u0001\u0000\u0000\u0000\u0160\u0162\u0001\u0000\u0000\u0000"+
		"\u0161\u015f\u0001\u0000\u0000\u0000\u0162\u0163\u0005s\u0000\u0000\u0163"+
		"\u0013\u0001\u0000\u0000\u0000\u0164\u0166\u0003\u0016\u000b\u0000\u0165"+
		"\u0164\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167"+
		"\u0168\u0001\u0000\u0000\u0000\u0167\u0165\u0001\u0000\u0000\u0000\u0168"+
		"\u0169\u0001\u0000\u0000\u0000\u0169\u016a\u0005s\u0000\u0000\u016a\u0015"+
		"\u0001\u0000\u0000\u0000\u016b\u0172\u0005x\u0000\u0000\u016c\u0172\u0005"+
		"t\u0000\u0000\u016d\u0172\u0005u\u0000\u0000\u016e\u0172\u0005w\u0000"+
		"\u0000\u016f\u0172\u0003\u0018\f\u0000\u0170\u0172\u0003\u001a\r\u0000"+
		"\u0171\u016b\u0001\u0000\u0000\u0000\u0171\u016c\u0001\u0000\u0000\u0000"+
		"\u0171\u016d\u0001\u0000\u0000\u0000\u0171\u016e\u0001\u0000\u0000\u0000"+
		"\u0171\u016f\u0001\u0000\u0000\u0000\u0171\u0170\u0001\u0000\u0000\u0000"+
		"\u0172\u0017\u0001\u0000\u0000\u0000\u0173\u01b9\u0005\u0001\u0000\u0000"+
		"\u0174\u01b9\u0005\u0002\u0000\u0000\u0175\u01b9\u0005\u0003\u0000\u0000"+
		"\u0176\u01b9\u0005\u0004\u0000\u0000\u0177\u01b9\u0005\u0005\u0000\u0000"+
		"\u0178\u01b9\u0005\u0006\u0000\u0000\u0179\u01b9\u0005\u0007\u0000\u0000"+
		"\u017a\u01b9\u0005\b\u0000\u0000\u017b\u01b9\u0005\t\u0000\u0000\u017c"+
		"\u01b9\u0005\n\u0000\u0000\u017d\u01b9\u0005\u000b\u0000\u0000\u017e\u01b9"+
		"\u0005\f\u0000\u0000\u017f\u01b9\u0005\r\u0000\u0000\u0180\u01b9\u0005"+
		"\u000e\u0000\u0000\u0181\u01b9\u0005\u000f\u0000\u0000\u0182\u01b9\u0005"+
		"\u0010\u0000\u0000\u0183\u01b9\u0005\u0011\u0000\u0000\u0184\u01b9\u0005"+
		"\u0012\u0000\u0000\u0185\u01b9\u0005\u0013\u0000\u0000\u0186\u01b9\u0005"+
		"\u0014\u0000\u0000\u0187\u01b9\u0005\u0015\u0000\u0000\u0188\u01b9\u0005"+
		"\u0016\u0000\u0000\u0189\u01b9\u0005\u0017\u0000\u0000\u018a\u01b9\u0005"+
		"\u0018\u0000\u0000\u018b\u01b9\u0005\u0019\u0000\u0000\u018c\u01b9\u0005"+
		"\u001a\u0000\u0000\u018d\u01b9\u0005\u001b\u0000\u0000\u018e\u01b9\u0005"+
		"\u001c\u0000\u0000\u018f\u01b9\u0005\u001d\u0000\u0000\u0190\u01b9\u0005"+
		"\u001e\u0000\u0000\u0191\u01b9\u0005\u001f\u0000\u0000\u0192\u01b9\u0005"+
		" \u0000\u0000\u0193\u01b9\u0005!\u0000\u0000\u0194\u01b9\u0005\"\u0000"+
		"\u0000\u0195\u01b9\u0005#\u0000\u0000\u0196\u01b9\u0005$\u0000\u0000\u0197"+
		"\u01b9\u0005%\u0000\u0000\u0198\u01b9\u0005&\u0000\u0000\u0199\u019a\u0005"+
		"\'\u0000\u0000\u019a\u01b9\u0004\f\u0000\u0000\u019b\u019c\u0005(\u0000"+
		"\u0000\u019c\u01b9\u0004\f\u0001\u0000\u019d\u019e\u0005)\u0000\u0000"+
		"\u019e\u01b9\u0004\f\u0002\u0000\u019f\u01a0\u0005*\u0000\u0000\u01a0"+
		"\u01b9\u0004\f\u0003\u0000\u01a1\u01a2\u0005+\u0000\u0000\u01a2\u01b9"+
		"\u0004\f\u0004\u0000\u01a3\u01a4\u0005,\u0000\u0000\u01a4\u01b9\u0004"+
		"\f\u0005\u0000\u01a5\u01a6\u0005-\u0000\u0000\u01a6\u01b9\u0004\f\u0006"+
		"\u0000\u01a7\u01a8\u0005.\u0000\u0000\u01a8\u01b9\u0004\f\u0007\u0000"+
		"\u01a9\u01aa\u0005/\u0000\u0000\u01aa\u01b9\u0004\f\b\u0000\u01ab\u01ac"+
		"\u00050\u0000\u0000\u01ac\u01b9\u0004\f\t\u0000\u01ad\u01ae\u00051\u0000"+
		"\u0000\u01ae\u01b9\u0004\f\n\u0000\u01af\u01b0\u00052\u0000\u0000\u01b0"+
		"\u01b9\u0004\f\u000b\u0000\u01b1\u01b2\u00053\u0000\u0000\u01b2\u01b9"+
		"\u0004\f\f\u0000\u01b3\u01b9\u00054\u0000\u0000\u01b4\u01b9\u00055\u0000"+
		"\u0000\u01b5\u01b9\u00056\u0000\u0000\u01b6\u01b9\u00057\u0000\u0000\u01b7"+
		"\u01b9\u00058\u0000\u0000\u01b8\u0173\u0001\u0000\u0000\u0000\u01b8\u0174"+
		"\u0001\u0000\u0000\u0000\u01b8\u0175\u0001\u0000\u0000\u0000\u01b8\u0176"+
		"\u0001\u0000\u0000\u0000\u01b8\u0177\u0001\u0000\u0000\u0000\u01b8\u0178"+
		"\u0001\u0000\u0000\u0000\u01b8\u0179\u0001\u0000\u0000\u0000\u01b8\u017a"+
		"\u0001\u0000\u0000\u0000\u01b8\u017b\u0001\u0000\u0000\u0000\u01b8\u017c"+
		"\u0001\u0000\u0000\u0000\u01b8\u017d\u0001\u0000\u0000\u0000\u01b8\u017e"+
		"\u0001\u0000\u0000\u0000\u01b8\u017f\u0001\u0000\u0000\u0000\u01b8\u0180"+
		"\u0001\u0000\u0000\u0000\u01b8\u0181\u0001\u0000\u0000\u0000\u01b8\u0182"+
		"\u0001\u0000\u0000\u0000\u01b8\u0183\u0001\u0000\u0000\u0000\u01b8\u0184"+
		"\u0001\u0000\u0000\u0000\u01b8\u0185\u0001\u0000\u0000\u0000\u01b8\u0186"+
		"\u0001\u0000\u0000\u0000\u01b8\u0187\u0001\u0000\u0000\u0000\u01b8\u0188"+
		"\u0001\u0000\u0000\u0000\u01b8\u0189\u0001\u0000\u0000\u0000\u01b8\u018a"+
		"\u0001\u0000\u0000\u0000\u01b8\u018b\u0001\u0000\u0000\u0000\u01b8\u018c"+
		"\u0001\u0000\u0000\u0000\u01b8\u018d\u0001\u0000\u0000\u0000\u01b8\u018e"+
		"\u0001\u0000\u0000\u0000\u01b8\u018f\u0001\u0000\u0000\u0000\u01b8\u0190"+
		"\u0001\u0000\u0000\u0000\u01b8\u0191\u0001\u0000\u0000\u0000\u01b8\u0192"+
		"\u0001\u0000\u0000\u0000\u01b8\u0193\u0001\u0000\u0000\u0000\u01b8\u0194"+
		"\u0001\u0000\u0000\u0000\u01b8\u0195\u0001\u0000\u0000\u0000\u01b8\u0196"+
		"\u0001\u0000\u0000\u0000\u01b8\u0197\u0001\u0000\u0000\u0000\u01b8\u0198"+
		"\u0001\u0000\u0000\u0000\u01b8\u0199\u0001\u0000\u0000\u0000\u01b8\u019b"+
		"\u0001\u0000\u0000\u0000\u01b8\u019d\u0001\u0000\u0000\u0000\u01b8\u019f"+
		"\u0001\u0000\u0000\u0000\u01b8\u01a1\u0001\u0000\u0000\u0000\u01b8\u01a3"+
		"\u0001\u0000\u0000\u0000\u01b8\u01a5\u0001\u0000\u0000\u0000\u01b8\u01a7"+
		"\u0001\u0000\u0000\u0000\u01b8\u01a9\u0001\u0000\u0000\u0000\u01b8\u01ab"+
		"\u0001\u0000\u0000\u0000\u01b8\u01ad\u0001\u0000\u0000\u0000\u01b8\u01af"+
		"\u0001\u0000\u0000\u0000\u01b8\u01b1\u0001\u0000\u0000\u0000\u01b8\u01b3"+
		"\u0001\u0000\u0000\u0000\u01b8\u01b4\u0001\u0000\u0000\u0000\u01b8\u01b5"+
		"\u0001\u0000\u0000\u0000\u01b8\u01b6\u0001\u0000\u0000\u0000\u01b8\u01b7"+
		"\u0001\u0000\u0000\u0000\u01b9\u0019\u0001\u0000\u0000\u0000\u01ba\u01bb"+
		"\u0007\u0000\u0000\u0000\u01bb\u001b\u0001\u0000\u0000\u0000\u01bc\u01bd"+
		"\u0004\u000e\r\u0000\u01bd\u01be\u0005t\u0000\u0000\u01be\u001d\u0001"+
		"\u0000\u0000\u0000\u01bf\u01c7\u0003\u001c\u000e\u0000\u01c0\u01c7\u0005"+
		"u\u0000\u0000\u01c1\u01c7\u0005w\u0000\u0000\u01c2\u01c3\u0005m\u0000"+
		"\u0000\u01c3\u01c4\u0003@ \u0000\u01c4\u01c5\u0005n\u0000\u0000\u01c5"+
		"\u01c7\u0001\u0000\u0000\u0000\u01c6\u01bf\u0001\u0000\u0000\u0000\u01c6"+
		"\u01c0\u0001\u0000\u0000\u0000\u01c6\u01c1\u0001\u0000\u0000\u0000\u01c6"+
		"\u01c2\u0001\u0000\u0000\u0000\u01c7\u001f\u0001\u0000\u0000\u0000\u01c8"+
		"\u01c9\u0006\u0010\uffff\uffff\u0000\u01c9\u01d5\u0003\u001e\u000f\u0000"+
		"\u01ca\u01cb\u0005m\u0000\u0000\u01cb\u01cc\u0003x<\u0000\u01cc\u01cd"+
		"\u0005n\u0000\u0000\u01cd\u01ce\u0005o\u0000\u0000\u01ce\u01d0\u0003\u0082"+
		"A\u0000\u01cf\u01d1\u0005i\u0000\u0000\u01d0\u01cf\u0001\u0000\u0000\u0000"+
		"\u01d0\u01d1\u0001\u0000\u0000\u0000\u01d1\u01d2\u0001\u0000\u0000\u0000"+
		"\u01d2\u01d3\u0005p\u0000\u0000\u01d3\u01d5\u0001\u0000\u0000\u0000\u01d4"+
		"\u01c8\u0001\u0000\u0000\u0000\u01d4\u01ca\u0001\u0000\u0000\u0000\u01d5"+
		"\u01ed\u0001\u0000\u0000\u0000\u01d6\u01d7\n\u0007\u0000\u0000\u01d7\u01d8"+
		"\u0005k\u0000\u0000\u01d8\u01d9\u0003@ \u0000\u01d9\u01da\u0005l\u0000"+
		"\u0000\u01da\u01ec\u0001\u0000\u0000\u0000\u01db\u01dc\n\u0006\u0000\u0000"+
		"\u01dc\u01de\u0005m\u0000\u0000\u01dd\u01df\u0003\"\u0011\u0000\u01de"+
		"\u01dd\u0001\u0000\u0000\u0000\u01de\u01df\u0001\u0000\u0000\u0000\u01df"+
		"\u01e0\u0001\u0000\u0000\u0000\u01e0\u01ec\u0005n\u0000\u0000\u01e1\u01e2"+
		"\n\u0005\u0000\u0000\u01e2\u01e3\u0005f\u0000\u0000\u01e3\u01ec\u0003"+
		"\u001c\u000e\u0000\u01e4\u01e5\n\u0004\u0000\u0000\u01e5\u01e6\u0005;"+
		"\u0000\u0000\u01e6\u01ec\u0003\u001c\u000e\u0000\u01e7\u01e8\n\u0003\u0000"+
		"\u0000\u01e8\u01ec\u0005<\u0000\u0000\u01e9\u01ea\n\u0002\u0000\u0000"+
		"\u01ea\u01ec\u0005=\u0000\u0000\u01eb\u01d6\u0001\u0000\u0000\u0000\u01eb"+
		"\u01db\u0001\u0000\u0000\u0000\u01eb\u01e1\u0001\u0000\u0000\u0000\u01eb"+
		"\u01e4\u0001\u0000\u0000\u0000\u01eb\u01e7\u0001\u0000\u0000\u0000\u01eb"+
		"\u01e9\u0001\u0000\u0000\u0000\u01ec\u01ef\u0001\u0000\u0000\u0000\u01ed"+
		"\u01eb\u0001\u0000\u0000\u0000\u01ed\u01ee\u0001\u0000\u0000\u0000\u01ee"+
		"!\u0001\u0000\u0000\u0000\u01ef\u01ed\u0001\u0000\u0000\u0000\u01f0\u01f5"+
		"\u0003>\u001f\u0000\u01f1\u01f2\u0005i\u0000\u0000\u01f2\u01f4\u0003>"+
		"\u001f\u0000\u01f3\u01f1\u0001\u0000\u0000\u0000\u01f4\u01f7\u0001\u0000"+
		"\u0000\u0000\u01f5\u01f3\u0001\u0000\u0000\u0000\u01f5\u01f6\u0001\u0000"+
		"\u0000\u0000\u01f6#\u0001\u0000\u0000\u0000\u01f7\u01f5\u0001\u0000\u0000"+
		"\u0000\u01f8\u0219\u0003 \u0010\u0000\u01f9\u01fa\u0005<\u0000\u0000\u01fa"+
		"\u0219\u0003$\u0012\u0000\u01fb\u01fc\u0005=\u0000\u0000\u01fc\u0219\u0003"+
		"$\u0012\u0000\u01fd\u01fe\u0007\u0001\u0000\u0000\u01fe\u0219\u0003&\u0013"+
		"\u0000\u01ff\u0200\u0005\u0019\u0000\u0000\u0200\u0219\u0003$\u0012\u0000"+
		"\u0201\u0202\u0005\u0019\u0000\u0000\u0202\u0203\u0005m\u0000\u0000\u0203"+
		"\u0204\u0003x<\u0000\u0204\u0205\u0005n\u0000\u0000\u0205\u0219\u0001"+
		"\u0000\u0000\u0000\u0206\u0207\u00052\u0000\u0000\u0207\u0208\u0005m\u0000"+
		"\u0000\u0208\u0209\u0007\u0002\u0000\u0000\u0209\u0219\u0005n\u0000\u0000"+
		"\u020a\u020b\u0005\'\u0000\u0000\u020b\u0219\u0003\u001c\u000e\u0000\u020c"+
		"\u020d\u0005\'\u0000\u0000\u020d\u020e\u0005m\u0000\u0000\u020e\u020f"+
		"\u0003\u001c\u000e\u0000\u020f\u0210\u0005n\u0000\u0000\u0210\u0219\u0001"+
		"\u0000\u0000\u0000\u0211\u0212\u00054\u0000\u0000\u0212\u0213\u0005m\u0000"+
		"\u0000\u0213\u0214\u0003x<\u0000\u0214\u0215\u0005i\u0000\u0000\u0215"+
		"\u0216\u0003\u001c\u000e\u0000\u0216\u0217\u0005n\u0000\u0000\u0217\u0219"+
		"\u0001\u0000\u0000\u0000\u0218\u01f8\u0001\u0000\u0000\u0000\u0218\u01f9"+
		"\u0001\u0000\u0000\u0000\u0218\u01fb\u0001\u0000\u0000\u0000\u0218\u01fd"+
		"\u0001\u0000\u0000\u0000\u0218\u01ff\u0001\u0000\u0000\u0000\u0218\u0201"+
		"\u0001\u0000\u0000\u0000\u0218\u0206\u0001\u0000\u0000\u0000\u0218\u020a"+
		"\u0001\u0000\u0000\u0000\u0218\u020c\u0001\u0000\u0000\u0000\u0218\u0211"+
		"\u0001\u0000\u0000\u0000\u0219%\u0001\u0000\u0000\u0000\u021a\u021b\u0005"+
		"m\u0000\u0000\u021b\u021c\u0003x<\u0000\u021c\u021d\u0005n\u0000\u0000"+
		"\u021d\u021e\u0003&\u0013\u0000\u021e\u0221\u0001\u0000\u0000\u0000\u021f"+
		"\u0221\u0003$\u0012\u0000\u0220\u021a\u0001\u0000\u0000\u0000\u0220\u021f"+
		"\u0001\u0000\u0000\u0000\u0221\'\u0001\u0000\u0000\u0000\u0222\u0223\u0006"+
		"\u0014\uffff\uffff\u0000\u0223\u0224\u0003&\u0013\u0000\u0224\u022a\u0001"+
		"\u0000\u0000\u0000\u0225\u0226\n\u0001\u0000\u0000\u0226\u0227\u0007\u0003"+
		"\u0000\u0000\u0227\u0229\u0003&\u0013\u0000\u0228\u0225\u0001\u0000\u0000"+
		"\u0000\u0229\u022c\u0001\u0000\u0000\u0000\u022a\u0228\u0001\u0000\u0000"+
		"\u0000\u022a\u022b\u0001\u0000\u0000\u0000\u022b)\u0001\u0000\u0000\u0000"+
		"\u022c\u022a\u0001\u0000\u0000\u0000\u022d\u022e\u0006\u0015\uffff\uffff"+
		"\u0000\u022e\u022f\u0003(\u0014\u0000\u022f\u0235\u0001\u0000\u0000\u0000"+
		"\u0230\u0231\n\u0001\u0000\u0000\u0231\u0232\u0007\u0004\u0000\u0000\u0232"+
		"\u0234\u0003(\u0014\u0000\u0233\u0230\u0001\u0000\u0000\u0000\u0234\u0237"+
		"\u0001\u0000\u0000\u0000\u0235\u0233\u0001\u0000\u0000\u0000\u0235\u0236"+
		"\u0001\u0000\u0000\u0000\u0236+\u0001\u0000\u0000\u0000\u0237\u0235\u0001"+
		"\u0000\u0000\u0000\u0238\u0239\u0006\u0016\uffff\uffff\u0000\u0239\u023a"+
		"\u0003*\u0015\u0000\u023a\u0240\u0001\u0000\u0000\u0000\u023b\u023c\n"+
		"\u0001\u0000\u0000\u023c\u023d\u0007\u0005\u0000\u0000\u023d\u023f\u0003"+
		"*\u0015\u0000\u023e\u023b\u0001\u0000\u0000\u0000\u023f\u0242\u0001\u0000"+
		"\u0000\u0000\u0240\u023e\u0001\u0000\u0000\u0000\u0240\u0241\u0001\u0000"+
		"\u0000\u0000\u0241-\u0001\u0000\u0000\u0000\u0242\u0240\u0001\u0000\u0000"+
		"\u0000\u0243\u0244\u0006\u0017\uffff\uffff\u0000\u0244\u0245\u0003,\u0016"+
		"\u0000\u0245\u024b\u0001\u0000\u0000\u0000\u0246\u0247\n\u0001\u0000\u0000"+
		"\u0247\u0248\u0007\u0006\u0000\u0000\u0248\u024a\u0003,\u0016\u0000\u0249"+
		"\u0246\u0001\u0000\u0000\u0000\u024a\u024d\u0001\u0000\u0000\u0000\u024b"+
		"\u0249\u0001\u0000\u0000\u0000\u024b\u024c\u0001\u0000\u0000\u0000\u024c"+
		"/\u0001\u0000\u0000\u0000\u024d\u024b\u0001\u0000\u0000\u0000\u024e\u024f"+
		"\u0006\u0018\uffff\uffff\u0000\u024f\u0250\u0003.\u0017\u0000\u0250\u0256"+
		"\u0001\u0000\u0000\u0000\u0251\u0252\n\u0001\u0000\u0000\u0252\u0253\u0007"+
		"\u0007\u0000\u0000\u0253\u0255\u0003.\u0017\u0000\u0254\u0251\u0001\u0000"+
		"\u0000\u0000\u0255\u0258\u0001\u0000\u0000\u0000\u0256\u0254\u0001\u0000"+
		"\u0000\u0000\u0256\u0257\u0001\u0000\u0000\u0000\u02571\u0001\u0000\u0000"+
		"\u0000\u0258\u0256\u0001\u0000\u0000\u0000\u0259\u025a\u0006\u0019\uffff"+
		"\uffff\u0000\u025a\u025b\u00030\u0018\u0000\u025b\u0261\u0001\u0000\u0000"+
		"\u0000\u025c\u025d\n\u0001\u0000\u0000\u025d\u025e\u0005Z\u0000\u0000"+
		"\u025e\u0260\u00030\u0018\u0000\u025f\u025c\u0001\u0000\u0000\u0000\u0260"+
		"\u0263\u0001\u0000\u0000\u0000\u0261\u025f\u0001\u0000\u0000\u0000\u0261"+
		"\u0262\u0001\u0000\u0000\u0000\u02623\u0001\u0000\u0000\u0000\u0263\u0261"+
		"\u0001\u0000\u0000\u0000\u0264\u0265\u0006\u001a\uffff\uffff\u0000\u0265"+
		"\u0266\u00032\u0019\u0000\u0266\u026c\u0001\u0000\u0000\u0000\u0267\u0268"+
		"\n\u0001\u0000\u0000\u0268\u0269\u0005b\u0000\u0000\u0269\u026b\u0003"+
		"2\u0019\u0000\u026a\u0267\u0001\u0000\u0000\u0000\u026b\u026e\u0001\u0000"+
		"\u0000\u0000\u026c\u026a\u0001\u0000\u0000\u0000\u026c\u026d\u0001\u0000"+
		"\u0000\u0000\u026d5\u0001\u0000\u0000\u0000\u026e\u026c\u0001\u0000\u0000"+
		"\u0000\u026f\u0270\u0006\u001b\uffff\uffff\u0000\u0270\u0271\u00034\u001a"+
		"\u0000\u0271\u0277\u0001\u0000\u0000\u0000\u0272\u0273\n\u0001\u0000\u0000"+
		"\u0273\u0274\u0005c\u0000\u0000\u0274\u0276\u00034\u001a\u0000\u0275\u0272"+
		"\u0001\u0000\u0000\u0000\u0276\u0279\u0001\u0000\u0000\u0000\u0277\u0275"+
		"\u0001\u0000\u0000\u0000\u0277\u0278\u0001\u0000\u0000\u0000\u02787\u0001"+
		"\u0000\u0000\u0000\u0279\u0277\u0001\u0000\u0000\u0000\u027a\u027b\u0006"+
		"\u001c\uffff\uffff\u0000\u027b\u027c\u00036\u001b\u0000\u027c\u0282\u0001"+
		"\u0000\u0000\u0000\u027d\u027e\n\u0001\u0000\u0000\u027e\u027f\u0005F"+
		"\u0000\u0000\u027f\u0281\u00036\u001b\u0000\u0280\u027d\u0001\u0000\u0000"+
		"\u0000\u0281\u0284\u0001\u0000\u0000\u0000\u0282\u0280\u0001\u0000\u0000"+
		"\u0000\u0282\u0283\u0001\u0000\u0000\u0000\u02839\u0001\u0000\u0000\u0000"+
		"\u0284\u0282\u0001\u0000\u0000\u0000\u0285\u0286\u0006\u001d\uffff\uffff"+
		"\u0000\u0286\u0287\u00038\u001c\u0000\u0287\u028d\u0001\u0000\u0000\u0000"+
		"\u0288\u0289\n\u0001\u0000\u0000\u0289\u028a\u0005G\u0000\u0000\u028a"+
		"\u028c\u00038\u001c\u0000\u028b\u0288\u0001\u0000\u0000\u0000\u028c\u028f"+
		"\u0001\u0000\u0000\u0000\u028d\u028b\u0001\u0000\u0000\u0000\u028d\u028e"+
		"\u0001\u0000\u0000\u0000\u028e;\u0001\u0000\u0000\u0000\u028f\u028d\u0001"+
		"\u0000\u0000\u0000\u0290\u0298\u0003:\u001d\u0000\u0291\u0292\u0003:\u001d"+
		"\u0000\u0292\u0293\u0005g\u0000\u0000\u0293\u0294\u0003@ \u0000\u0294"+
		"\u0295\u0005d\u0000\u0000\u0295\u0296\u0003<\u001e\u0000\u0296\u0298\u0001"+
		"\u0000\u0000\u0000\u0297\u0290\u0001\u0000\u0000\u0000\u0297\u0291\u0001"+
		"\u0000\u0000\u0000\u0298=\u0001\u0000\u0000\u0000\u0299\u029f\u0003<\u001e"+
		"\u0000\u029a\u029b\u0003$\u0012\u0000\u029b\u029c\u0007\b\u0000\u0000"+
		"\u029c\u029d\u0003>\u001f\u0000\u029d\u029f\u0001\u0000\u0000\u0000\u029e"+
		"\u0299\u0001\u0000\u0000\u0000\u029e\u029a\u0001\u0000\u0000\u0000\u029f"+
		"?\u0001\u0000\u0000\u0000\u02a0\u02a5\u0003>\u001f\u0000\u02a1\u02a2\u0005"+
		"i\u0000\u0000\u02a2\u02a4\u0003>\u001f\u0000\u02a3\u02a1\u0001\u0000\u0000"+
		"\u0000\u02a4\u02a7\u0001\u0000\u0000\u0000\u02a5\u02a3\u0001\u0000\u0000"+
		"\u0000\u02a5\u02a6\u0001\u0000\u0000\u0000\u02a6A\u0001\u0000\u0000\u0000"+
		"\u02a7\u02a5\u0001\u0000\u0000\u0000\u02a8\u02a9\u0003<\u001e\u0000\u02a9"+
		"C\u0001\u0000\u0000\u0000\u02aa\u02ab\u0005X\u0000\u0000\u02ab\u02ac\u0003"+
		"v;\u0000\u02ac\u02ad\u0005Y\u0000\u0000\u02adE\u0001\u0000\u0000\u0000"+
		"\u02ae\u02b0\u0003D\"\u0000\u02af\u02ae\u0001\u0000\u0000\u0000\u02b0"+
		"\u02b3\u0001\u0000\u0000\u0000\u02b1\u02af\u0001\u0000\u0000\u0000\u02b1"+
		"\u02b2\u0001\u0000\u0000\u0000\u02b2\u02b4\u0001\u0000\u0000\u0000\u02b3"+
		"\u02b1\u0001\u0000\u0000\u0000\u02b4\u02b6\u0003H$\u0000\u02b5\u02b7\u0003"+
		"N\'\u0000\u02b6\u02b5\u0001\u0000\u0000\u0000\u02b6\u02b7\u0001\u0000"+
		"\u0000\u0000\u02b7\u02b8\u0001\u0000\u0000\u0000\u02b8\u02b9\u0005e\u0000"+
		"\u0000\u02b9\u02ba\u0006#\uffff\uffff\u0000\u02baG\u0001\u0000\u0000\u0000"+
		"\u02bb\u02c0\u0003J%\u0000\u02bc\u02c0\u0003R)\u0000\u02bd\u02c0\u0003"+
		"f3\u0000\u02be\u02c0\u0003L&\u0000\u02bf\u02bb\u0001\u0000\u0000\u0000"+
		"\u02bf\u02bc\u0001\u0000\u0000\u0000\u02bf\u02bd\u0001\u0000\u0000\u0000"+
		"\u02bf\u02be\u0001\u0000\u0000\u0000\u02c0\u02c1\u0001\u0000\u0000\u0000"+
		"\u02c1\u02c2\u0001\u0000\u0000\u0000\u02c1\u02bf\u0001\u0000\u0000\u0000"+
		"\u02c2I\u0001\u0000\u0000\u0000\u02c3\u02c4\u0007\t\u0000\u0000\u02c4"+
		"K\u0001\u0000\u0000\u0000\u02c5\u02c6\u0005\u0011\u0000\u0000\u02c6M\u0001"+
		"\u0000\u0000\u0000\u02c7\u02cc\u0003P(\u0000\u02c8\u02c9\u0005i\u0000"+
		"\u0000\u02c9\u02cb\u0003P(\u0000\u02ca\u02c8\u0001\u0000\u0000\u0000\u02cb"+
		"\u02ce\u0001\u0000\u0000\u0000\u02cc\u02ca\u0001\u0000\u0000\u0000\u02cc"+
		"\u02cd\u0001\u0000\u0000\u0000\u02cdO\u0001\u0000\u0000\u0000\u02ce\u02cc"+
		"\u0001\u0000\u0000\u0000\u02cf\u02d2\u0003h4\u0000\u02d0\u02d1\u0005h"+
		"\u0000\u0000\u02d1\u02d3\u0003\u0080@\u0000\u02d2\u02d0\u0001\u0000\u0000"+
		"\u0000\u02d2\u02d3\u0001\u0000\u0000\u0000\u02d3Q\u0001\u0000\u0000\u0000"+
		"\u02d4\u02d9\u0007\n\u0000\u0000\u02d5\u02d9\u0003T*\u0000\u02d6\u02d9"+
		"\u0003`0\u0000\u02d7\u02d9\u0003~?\u0000\u02d8\u02d4\u0001\u0000\u0000"+
		"\u0000\u02d8\u02d5\u0001\u0000\u0000\u0000\u02d8\u02d6\u0001\u0000\u0000"+
		"\u0000\u02d8\u02d7\u0001\u0000\u0000\u0000\u02d9S\u0001\u0000\u0000\u0000"+
		"\u02da\u02dc\u0007\u000b\u0000\u0000\u02db\u02dd\u0003\u001c\u000e\u0000"+
		"\u02dc\u02db\u0001\u0000\u0000\u0000\u02dc\u02dd\u0001\u0000\u0000\u0000"+
		"\u02dd\u02de\u0001\u0000\u0000\u0000\u02de\u02df\u0005o\u0000\u0000\u02df"+
		"\u02e0\u0003V+\u0000\u02e0\u02e1\u0005p\u0000\u0000\u02e1\u02e5\u0001"+
		"\u0000\u0000\u0000\u02e2\u02e3\u0007\u000b\u0000\u0000\u02e3\u02e5\u0003"+
		"\u001c\u000e\u0000\u02e4\u02da\u0001\u0000\u0000\u0000\u02e4\u02e2\u0001"+
		"\u0000\u0000\u0000\u02e5U\u0001\u0000\u0000\u0000\u02e6\u02e8\u0003X,"+
		"\u0000\u02e7\u02e6\u0001\u0000\u0000\u0000\u02e8\u02e9\u0001\u0000\u0000"+
		"\u0000\u02e9\u02e7\u0001\u0000\u0000\u0000\u02e9\u02ea\u0001\u0000\u0000"+
		"\u0000\u02eaW\u0001\u0000\u0000\u0000\u02eb\u02ec\u0003Z-\u0000\u02ec"+
		"\u02ed\u0003\\.\u0000\u02ed\u02ee\u0005e\u0000\u0000\u02eeY\u0001\u0000"+
		"\u0000\u0000\u02ef\u02f2\u0003R)\u0000\u02f0\u02f2\u0003f3\u0000\u02f1"+
		"\u02ef\u0001\u0000\u0000\u0000\u02f1\u02f0\u0001\u0000\u0000\u0000\u02f2"+
		"\u02f4\u0001\u0000\u0000\u0000\u02f3\u02f5\u0003Z-\u0000\u02f4\u02f3\u0001"+
		"\u0000\u0000\u0000\u02f4\u02f5\u0001\u0000\u0000\u0000\u02f5[\u0001\u0000"+
		"\u0000\u0000\u02f6\u02fb\u0003^/\u0000\u02f7\u02f8\u0005i\u0000\u0000"+
		"\u02f8\u02fa\u0003^/\u0000\u02f9\u02f7\u0001\u0000\u0000\u0000\u02fa\u02fd"+
		"\u0001\u0000\u0000\u0000\u02fb\u02f9\u0001\u0000\u0000\u0000\u02fb\u02fc"+
		"\u0001\u0000\u0000\u0000\u02fc]\u0001\u0000\u0000\u0000\u02fd\u02fb\u0001"+
		"\u0000\u0000\u0000\u02fe\u0305\u0003h4\u0000\u02ff\u0301\u0003h4\u0000"+
		"\u0300\u02ff\u0001\u0000\u0000\u0000\u0300\u0301\u0001\u0000\u0000\u0000"+
		"\u0301\u0302\u0001\u0000\u0000\u0000\u0302\u0303\u0005d\u0000\u0000\u0303"+
		"\u0305\u0003B!\u0000\u0304\u02fe\u0001\u0000\u0000\u0000\u0304\u0300\u0001"+
		"\u0000\u0000\u0000\u0305_\u0001\u0000\u0000\u0000\u0306\u0308\u0005\u000b"+
		"\u0000\u0000\u0307\u0309\u0003\u001c\u000e\u0000\u0308\u0307\u0001\u0000"+
		"\u0000\u0000\u0308\u0309\u0001\u0000\u0000\u0000\u0309\u030a\u0001\u0000"+
		"\u0000\u0000\u030a\u030b\u0005o\u0000\u0000\u030b\u030d\u0003b1\u0000"+
		"\u030c\u030e\u0005i\u0000\u0000\u030d\u030c\u0001\u0000\u0000\u0000\u030d"+
		"\u030e\u0001\u0000\u0000\u0000\u030e\u030f\u0001\u0000\u0000\u0000\u030f"+
		"\u0310\u0005p\u0000\u0000\u0310\u0314\u0001\u0000\u0000\u0000\u0311\u0312"+
		"\u0005\u000b\u0000\u0000\u0312\u0314\u0003\u001c\u000e\u0000\u0313\u0306"+
		"\u0001\u0000\u0000\u0000\u0313\u0311\u0001\u0000\u0000\u0000\u0314a\u0001"+
		"\u0000\u0000\u0000\u0315\u031a\u0003d2\u0000\u0316\u0317\u0005i\u0000"+
		"\u0000\u0317\u0319\u0003d2\u0000\u0318\u0316\u0001\u0000\u0000\u0000\u0319"+
		"\u031c\u0001\u0000\u0000\u0000\u031a\u0318\u0001\u0000\u0000\u0000\u031a"+
		"\u031b\u0001\u0000\u0000\u0000\u031bc\u0001\u0000\u0000\u0000\u031c\u031a"+
		"\u0001\u0000\u0000\u0000\u031d\u0320\u0003\u001c\u000e\u0000\u031e\u031f"+
		"\u0005h\u0000\u0000\u031f\u0321\u0003B!\u0000\u0320\u031e\u0001\u0000"+
		"\u0000\u0000\u0320\u0321\u0001\u0000\u0000\u0000\u0321e\u0001\u0000\u0000"+
		"\u0000\u0322\u0323\u0007\f\u0000\u0000\u0323g\u0001\u0000\u0000\u0000"+
		"\u0324\u0326\u0003l6\u0000\u0325\u0324\u0001\u0000\u0000\u0000\u0325\u0326"+
		"\u0001\u0000\u0000\u0000\u0326\u0327\u0001\u0000\u0000\u0000\u0327\u0328"+
		"\u0003j5\u0000\u0328i\u0001\u0000\u0000\u0000\u0329\u032a\u00065\uffff"+
		"\uffff\u0000\u032a\u0330\u0003\u001c\u000e\u0000\u032b\u032c\u0005m\u0000"+
		"\u0000\u032c\u032d\u0003h4\u0000\u032d\u032e\u0005n\u0000\u0000\u032e"+
		"\u0330\u0001\u0000\u0000\u0000\u032f\u0329\u0001\u0000\u0000\u0000\u032f"+
		"\u032b\u0001\u0000\u0000\u0000\u0330\u035e\u0001\u0000\u0000\u0000\u0331"+
		"\u0332\n\u0006\u0000\u0000\u0332\u0334\u0005k\u0000\u0000\u0333\u0335"+
		"\u0003n7\u0000\u0334\u0333\u0001\u0000\u0000\u0000\u0334\u0335\u0001\u0000"+
		"\u0000\u0000\u0335\u0337\u0001\u0000\u0000\u0000\u0336\u0338\u0003>\u001f"+
		"\u0000\u0337\u0336\u0001\u0000\u0000\u0000\u0337\u0338\u0001\u0000\u0000"+
		"\u0000\u0338\u0339\u0001\u0000\u0000\u0000\u0339\u035d\u0005l\u0000\u0000"+
		"\u033a\u033b\n\u0005\u0000\u0000\u033b\u033c\u0005k\u0000\u0000\u033c"+
		"\u033e\u0005\u001a\u0000\u0000\u033d\u033f\u0003n7\u0000\u033e\u033d\u0001"+
		"\u0000\u0000\u0000\u033e\u033f\u0001\u0000\u0000\u0000\u033f\u0340\u0001"+
		"\u0000\u0000\u0000\u0340\u0341\u0003>\u001f\u0000\u0341\u0342\u0005l\u0000"+
		"\u0000\u0342\u035d\u0001\u0000\u0000\u0000\u0343\u0344\n\u0004\u0000\u0000"+
		"\u0344\u0345\u0005k\u0000\u0000\u0345\u0346\u0003n7\u0000\u0346\u0347"+
		"\u0005\u001a\u0000\u0000\u0347\u0348\u0003>\u001f\u0000\u0348\u0349\u0005"+
		"l\u0000\u0000\u0349\u035d\u0001\u0000\u0000\u0000\u034a\u034b\n\u0003"+
		"\u0000\u0000\u034b\u034d\u0005k\u0000\u0000\u034c\u034e\u0003n7\u0000"+
		"\u034d\u034c\u0001\u0000\u0000\u0000\u034d\u034e\u0001\u0000\u0000\u0000"+
		"\u034e\u034f\u0001\u0000\u0000\u0000\u034f\u0350\u0005[\u0000\u0000\u0350"+
		"\u035d\u0005l\u0000\u0000\u0351\u0352\n\u0002\u0000\u0000\u0352\u0353"+
		"\u0005m\u0000\u0000\u0353\u0354\u0003p8\u0000\u0354\u0355\u0005n\u0000"+
		"\u0000\u0355\u035d\u0001\u0000\u0000\u0000\u0356\u0357\n\u0001\u0000\u0000"+
		"\u0357\u0359\u0005m\u0000\u0000\u0358\u035a\u0003v;\u0000\u0359\u0358"+
		"\u0001\u0000\u0000\u0000\u0359\u035a\u0001\u0000\u0000\u0000\u035a\u035b"+
		"\u0001\u0000\u0000\u0000\u035b\u035d\u0005n\u0000\u0000\u035c\u0331\u0001"+
		"\u0000\u0000\u0000\u035c\u033a\u0001\u0000\u0000\u0000\u035c\u0343\u0001"+
		"\u0000\u0000\u0000\u035c\u034a\u0001\u0000\u0000\u0000\u035c\u0351\u0001"+
		"\u0000\u0000\u0000\u035c\u0356\u0001\u0000\u0000\u0000\u035d\u0360\u0001"+
		"\u0000\u0000\u0000\u035e\u035c\u0001\u0000\u0000\u0000\u035e\u035f\u0001"+
		"\u0000\u0000\u0000\u035fk\u0001\u0000\u0000\u0000\u0360\u035e\u0001\u0000"+
		"\u0000\u0000\u0361\u0363\u0005[\u0000\u0000\u0362\u0364\u0003n7\u0000"+
		"\u0363\u0362\u0001\u0000\u0000\u0000\u0363\u0364\u0001\u0000\u0000\u0000"+
		"\u0364\u0366\u0001\u0000\u0000\u0000\u0365\u0361\u0001\u0000\u0000\u0000"+
		"\u0366\u0367\u0001\u0000\u0000\u0000\u0367\u0365\u0001\u0000\u0000\u0000"+
		"\u0367\u0368\u0001\u0000\u0000\u0000\u0368m\u0001\u0000\u0000\u0000\u0369"+
		"\u036b\u0003f3\u0000\u036a\u0369\u0001\u0000\u0000\u0000\u036b\u036c\u0001"+
		"\u0000\u0000\u0000\u036c\u036a\u0001\u0000\u0000\u0000\u036c\u036d\u0001"+
		"\u0000\u0000\u0000\u036do\u0001\u0000\u0000\u0000\u036e\u0371\u0003r9"+
		"\u0000\u036f\u0370\u0005i\u0000\u0000\u0370\u0372\u0005:\u0000\u0000\u0371"+
		"\u036f\u0001\u0000\u0000\u0000\u0371\u0372\u0001\u0000\u0000\u0000\u0372"+
		"q\u0001\u0000\u0000\u0000\u0373\u0378\u0003t:\u0000\u0374\u0375\u0005"+
		"i\u0000\u0000\u0375\u0377\u0003t:\u0000\u0376\u0374\u0001\u0000\u0000"+
		"\u0000\u0377\u037a\u0001\u0000\u0000\u0000\u0378\u0376\u0001\u0000\u0000"+
		"\u0000\u0378\u0379\u0001\u0000\u0000\u0000\u0379s\u0001\u0000\u0000\u0000"+
		"\u037a\u0378\u0001\u0000\u0000\u0000\u037b\u0380\u0003H$\u0000\u037c\u0381"+
		"\u0003h4\u0000\u037d\u037f\u0003z=\u0000\u037e\u037d\u0001\u0000\u0000"+
		"\u0000\u037e\u037f\u0001\u0000\u0000\u0000\u037f\u0381\u0001\u0000\u0000"+
		"\u0000\u0380\u037c\u0001\u0000\u0000\u0000\u0380\u037e\u0001\u0000\u0000"+
		"\u0000\u0381u\u0001\u0000\u0000\u0000\u0382\u0387\u0003\u001c\u000e\u0000"+
		"\u0383\u0384\u0005i\u0000\u0000\u0384\u0386\u0003\u001c\u000e\u0000\u0385"+
		"\u0383\u0001\u0000\u0000\u0000\u0386\u0389\u0001\u0000\u0000\u0000\u0387"+
		"\u0385\u0001\u0000\u0000\u0000\u0387\u0388\u0001\u0000\u0000\u0000\u0388"+
		"w\u0001\u0000\u0000\u0000\u0389\u0387\u0001\u0000\u0000\u0000\u038a\u038c"+
		"\u0003Z-\u0000\u038b\u038d\u0003z=\u0000\u038c\u038b\u0001\u0000\u0000"+
		"\u0000\u038c\u038d\u0001\u0000\u0000\u0000\u038dy\u0001\u0000\u0000\u0000"+
		"\u038e\u0394\u0003l6\u0000\u038f\u0391\u0003l6\u0000\u0390\u038f\u0001"+
		"\u0000\u0000\u0000\u0390\u0391\u0001\u0000\u0000\u0000\u0391\u0392\u0001"+
		"\u0000\u0000\u0000\u0392\u0394\u0003|>\u0000\u0393\u038e\u0001\u0000\u0000"+
		"\u0000\u0393\u0390\u0001\u0000\u0000\u0000\u0394{\u0001\u0000\u0000\u0000"+
		"\u0395\u0396\u0006>\uffff\uffff\u0000\u0396\u0397\u0005m\u0000\u0000\u0397"+
		"\u0398\u0003z=\u0000\u0398\u0399\u0005n\u0000\u0000\u0399\u03c0\u0001"+
		"\u0000\u0000\u0000\u039a\u039c\u0005k\u0000\u0000\u039b\u039d\u0003n7"+
		"\u0000\u039c\u039b\u0001\u0000\u0000\u0000\u039c\u039d\u0001\u0000\u0000"+
		"\u0000\u039d\u039f\u0001\u0000\u0000\u0000\u039e\u03a0\u0003>\u001f\u0000"+
		"\u039f\u039e\u0001\u0000\u0000\u0000\u039f\u03a0\u0001\u0000\u0000\u0000"+
		"\u03a0\u03a1\u0001\u0000\u0000\u0000\u03a1\u03c0\u0005l\u0000\u0000\u03a2"+
		"\u03a3\u0005k\u0000\u0000\u03a3\u03a5\u0005\u001a\u0000\u0000\u03a4\u03a6"+
		"\u0003n7\u0000\u03a5\u03a4\u0001\u0000\u0000\u0000\u03a5\u03a6\u0001\u0000"+
		"\u0000\u0000\u03a6\u03a7\u0001\u0000\u0000\u0000\u03a7\u03a8\u0003>\u001f"+
		"\u0000\u03a8\u03a9\u0005l\u0000\u0000\u03a9\u03c0\u0001\u0000\u0000\u0000"+
		"\u03aa\u03ab\u0005k\u0000\u0000\u03ab\u03ac\u0003n7\u0000\u03ac\u03ad"+
		"\u0005\u001a\u0000\u0000\u03ad\u03ae\u0003>\u001f\u0000\u03ae\u03af\u0005"+
		"l\u0000\u0000\u03af\u03c0\u0001\u0000\u0000\u0000\u03b0\u03b2\u0005k\u0000"+
		"\u0000\u03b1\u03b3\u0003n7\u0000\u03b2\u03b1\u0001\u0000\u0000\u0000\u03b2"+
		"\u03b3\u0001\u0000\u0000\u0000\u03b3\u03b4\u0001\u0000\u0000\u0000\u03b4"+
		"\u03b5\u0005[\u0000\u0000\u03b5\u03c0\u0005l\u0000\u0000\u03b6\u03b7\u0005"+
		"m\u0000\u0000\u03b7\u03b8\u0003p8\u0000\u03b8\u03b9\u0005n\u0000\u0000"+
		"\u03b9\u03c0\u0001\u0000\u0000\u0000\u03ba\u03bc\u0005m\u0000\u0000\u03bb"+
		"\u03bd\u0003v;\u0000\u03bc\u03bb\u0001\u0000\u0000\u0000\u03bc\u03bd\u0001"+
		"\u0000\u0000\u0000\u03bd\u03be\u0001\u0000\u0000\u0000\u03be\u03c0\u0005"+
		"n\u0000\u0000\u03bf\u0395\u0001\u0000\u0000\u0000\u03bf\u039a\u0001\u0000"+
		"\u0000\u0000\u03bf\u03a2\u0001\u0000\u0000\u0000\u03bf\u03aa\u0001\u0000"+
		"\u0000\u0000\u03bf\u03b0\u0001\u0000\u0000\u0000\u03bf\u03b6\u0001\u0000"+
		"\u0000\u0000\u03bf\u03ba\u0001\u0000\u0000\u0000\u03c0\u03ee\u0001\u0000"+
		"\u0000\u0000\u03c1\u03c2\n\f\u0000\u0000\u03c2\u03c4\u0005k\u0000\u0000"+
		"\u03c3\u03c5\u0003n7\u0000\u03c4\u03c3\u0001\u0000\u0000\u0000\u03c4\u03c5"+
		"\u0001\u0000\u0000\u0000\u03c5\u03c7\u0001\u0000\u0000\u0000\u03c6\u03c8"+
		"\u0003>\u001f\u0000\u03c7\u03c6\u0001\u0000\u0000\u0000\u03c7\u03c8\u0001"+
		"\u0000\u0000\u0000\u03c8\u03c9\u0001\u0000\u0000\u0000\u03c9\u03ed\u0005"+
		"l\u0000\u0000\u03ca\u03cb\n\n\u0000\u0000\u03cb\u03cc\u0005k\u0000\u0000"+
		"\u03cc\u03ce\u0005\u001a\u0000\u0000\u03cd\u03cf\u0003n7\u0000\u03ce\u03cd"+
		"\u0001\u0000\u0000\u0000\u03ce\u03cf\u0001\u0000\u0000\u0000\u03cf\u03d0"+
		"\u0001\u0000\u0000\u0000\u03d0\u03d1\u0003>\u001f\u0000\u03d1\u03d2\u0005"+
		"l\u0000\u0000\u03d2\u03ed\u0001\u0000\u0000\u0000\u03d3\u03d4\n\b\u0000"+
		"\u0000\u03d4\u03d5\u0005k\u0000\u0000\u03d5\u03d6\u0003n7\u0000\u03d6"+
		"\u03d7\u0005\u001a\u0000\u0000\u03d7\u03d8\u0003>\u001f\u0000\u03d8\u03d9"+
		"\u0005l\u0000\u0000\u03d9\u03ed\u0001\u0000\u0000\u0000\u03da\u03db\n"+
		"\u0006\u0000\u0000\u03db\u03dd\u0005k\u0000\u0000\u03dc\u03de\u0003n7"+
		"\u0000\u03dd\u03dc\u0001\u0000\u0000\u0000\u03dd\u03de\u0001\u0000\u0000"+
		"\u0000\u03de\u03df\u0001\u0000\u0000\u0000\u03df\u03e0\u0005[\u0000\u0000"+
		"\u03e0\u03ed\u0005l\u0000\u0000\u03e1\u03e2\n\u0004\u0000\u0000\u03e2"+
		"\u03e3\u0005m\u0000\u0000\u03e3\u03e4\u0003p8\u0000\u03e4\u03e5\u0005"+
		"n\u0000\u0000\u03e5\u03ed\u0001\u0000\u0000\u0000\u03e6\u03e7\n\u0002"+
		"\u0000\u0000\u03e7\u03e9\u0005m\u0000\u0000\u03e8\u03ea\u0003v;\u0000"+
		"\u03e9\u03e8\u0001\u0000\u0000\u0000\u03e9\u03ea\u0001\u0000\u0000\u0000"+
		"\u03ea\u03eb\u0001\u0000\u0000\u0000\u03eb\u03ed\u0005n\u0000\u0000\u03ec"+
		"\u03c1\u0001\u0000\u0000\u0000\u03ec\u03ca\u0001\u0000\u0000\u0000\u03ec"+
		"\u03d3\u0001\u0000\u0000\u0000\u03ec\u03da\u0001\u0000\u0000\u0000\u03ec"+
		"\u03e1\u0001\u0000\u0000\u0000\u03ec\u03e6\u0001\u0000\u0000\u0000\u03ed"+
		"\u03f0\u0001\u0000\u0000\u0000\u03ee\u03ec\u0001\u0000\u0000\u0000\u03ee"+
		"\u03ef\u0001\u0000\u0000\u0000\u03ef}\u0001\u0000\u0000\u0000\u03f0\u03ee"+
		"\u0001\u0000\u0000\u0000\u03f1\u03f2\u0004?*\u0000\u03f2\u03f3\u0005t"+
		"\u0000\u0000\u03f3\u007f\u0001\u0000\u0000\u0000\u03f4\u03fd\u0003>\u001f"+
		"\u0000\u03f5\u03f6\u0005o\u0000\u0000\u03f6\u03f8\u0003\u0082A\u0000\u03f7"+
		"\u03f9\u0005i\u0000\u0000\u03f8\u03f7\u0001\u0000\u0000\u0000\u03f8\u03f9"+
		"\u0001\u0000\u0000\u0000\u03f9\u03fa\u0001\u0000\u0000\u0000\u03fa\u03fb"+
		"\u0005p\u0000\u0000\u03fb\u03fd\u0001\u0000\u0000\u0000\u03fc\u03f4\u0001"+
		"\u0000\u0000\u0000\u03fc\u03f5\u0001\u0000\u0000\u0000\u03fd\u0081\u0001"+
		"\u0000\u0000\u0000\u03fe\u0400\u0003\u0084B\u0000\u03ff\u03fe\u0001\u0000"+
		"\u0000\u0000\u03ff\u0400\u0001\u0000\u0000\u0000\u0400\u0401\u0001\u0000"+
		"\u0000\u0000\u0401\u0409\u0003\u0080@\u0000\u0402\u0404\u0005i\u0000\u0000"+
		"\u0403\u0405\u0003\u0084B\u0000\u0404\u0403\u0001\u0000\u0000\u0000\u0404"+
		"\u0405\u0001\u0000\u0000\u0000\u0405\u0406\u0001\u0000\u0000\u0000\u0406"+
		"\u0408\u0003\u0080@\u0000\u0407\u0402\u0001\u0000\u0000\u0000\u0408\u040b"+
		"\u0001\u0000\u0000\u0000\u0409\u0407\u0001\u0000\u0000\u0000\u0409\u040a"+
		"\u0001\u0000\u0000\u0000\u040a\u0083\u0001\u0000\u0000\u0000\u040b\u0409"+
		"\u0001\u0000\u0000\u0000\u040c\u040d\u0003\u0086C\u0000\u040d\u040e\u0005"+
		"h\u0000\u0000\u040e\u0085\u0001\u0000\u0000\u0000\u040f\u0411\u0003\u0088"+
		"D\u0000\u0410\u040f\u0001\u0000\u0000\u0000\u0411\u0412\u0001\u0000\u0000"+
		"\u0000\u0412\u0410\u0001\u0000\u0000\u0000\u0412\u0413\u0001\u0000\u0000"+
		"\u0000\u0413\u0087\u0001\u0000\u0000\u0000\u0414\u0415\u0005k\u0000\u0000"+
		"\u0415\u0416\u0003B!\u0000\u0416\u0417\u0005l\u0000\u0000\u0417\u041b"+
		"\u0001\u0000\u0000\u0000\u0418\u0419\u0005f\u0000\u0000\u0419\u041b\u0003"+
		"\u001c\u000e\u0000\u041a\u0414\u0001\u0000\u0000\u0000\u041a\u0418\u0001"+
		"\u0000\u0000\u0000\u041b\u0089\u0001\u0000\u0000\u0000\u041c\u0424\u0003"+
		"\u009cN\u0000\u041d\u0424\u0003\u008cF\u0000\u041e\u0424\u0003\u008eG"+
		"\u0000\u041f\u0424\u0003\u0094J\u0000\u0420\u0424\u0003\u0096K\u0000\u0421"+
		"\u0424\u0003\u0098L\u0000\u0422\u0424\u0003\u009aM\u0000\u0423\u041c\u0001"+
		"\u0000\u0000\u0000\u0423\u041d\u0001\u0000\u0000\u0000\u0423\u041e\u0001"+
		"\u0000\u0000\u0000\u0423\u041f\u0001\u0000\u0000\u0000\u0423\u0420\u0001"+
		"\u0000\u0000\u0000\u0423\u0421\u0001\u0000\u0000\u0000\u0423\u0422\u0001"+
		"\u0000\u0000\u0000\u0424\u008b\u0001\u0000\u0000\u0000\u0425\u0426\u0003"+
		"\u001c\u000e\u0000\u0426\u0427\u0005d\u0000\u0000\u0427\u0428\u0003\u008a"+
		"E\u0000\u0428\u0432\u0001\u0000\u0000\u0000\u0429\u042a\u0005\u0003\u0000"+
		"\u0000\u042a\u042b\u0003B!\u0000\u042b\u042c\u0005d\u0000\u0000\u042c"+
		"\u042d\u0003\u008aE\u0000\u042d\u0432\u0001\u0000\u0000\u0000\u042e\u042f"+
		"\u0005\u0007\u0000\u0000\u042f\u0430\u0005d\u0000\u0000\u0430\u0432\u0003"+
		"\u008aE\u0000\u0431\u0425\u0001\u0000\u0000\u0000\u0431\u0429\u0001\u0000"+
		"\u0000\u0000\u0431\u042e\u0001\u0000\u0000\u0000\u0432\u008d\u0001\u0000"+
		"\u0000\u0000\u0433\u0435\u0005o\u0000\u0000\u0434\u0436\u0003\u0090H\u0000"+
		"\u0435\u0434\u0001\u0000\u0000\u0000\u0435\u0436\u0001\u0000\u0000\u0000"+
		"\u0436\u0437\u0001\u0000\u0000\u0000\u0437\u0438\u0005p\u0000\u0000\u0438"+
		"\u008f\u0001\u0000\u0000\u0000\u0439\u043b\u0003\u0092I\u0000\u043a\u0439"+
		"\u0001\u0000\u0000\u0000\u043b\u043c\u0001\u0000\u0000\u0000\u043c\u043a"+
		"\u0001\u0000\u0000\u0000\u043c\u043d\u0001\u0000\u0000\u0000\u043d\u0091"+
		"\u0001\u0000\u0000\u0000\u043e\u0441\u0003F#\u0000\u043f\u0441\u0003\u008a"+
		"E\u0000\u0440\u043e\u0001\u0000\u0000\u0000\u0440\u043f\u0001\u0000\u0000"+
		"\u0000\u0441\u0093\u0001\u0000\u0000\u0000\u0442\u0444\u0003@ \u0000\u0443"+
		"\u0442\u0001\u0000\u0000\u0000\u0443\u0444\u0001\u0000\u0000\u0000\u0444"+
		"\u0445\u0001\u0000\u0000\u0000\u0445\u0446\u0005e\u0000\u0000\u0446\u0095"+
		"\u0001\u0000\u0000\u0000\u0447\u0448\u0005\u0010\u0000\u0000\u0448\u0449"+
		"\u0005m\u0000\u0000\u0449\u044a\u0003@ \u0000\u044a\u044b\u0005n\u0000"+
		"\u0000\u044b\u044c\u0003\u008aE\u0000\u044c\u045c\u0001\u0000\u0000\u0000"+
		"\u044d\u044e\u0005\u0010\u0000\u0000\u044e\u044f\u0005m\u0000\u0000\u044f"+
		"\u0450\u0003@ \u0000\u0450\u0451\u0005n\u0000\u0000\u0451\u0452\u0003"+
		"\u008aE\u0000\u0452\u0453\u0005\n\u0000\u0000\u0453\u0454\u0003\u008a"+
		"E\u0000\u0454\u045c\u0001\u0000\u0000\u0000\u0455\u0456\u0005\u001c\u0000"+
		"\u0000\u0456\u0457\u0005m\u0000\u0000\u0457\u0458\u0003@ \u0000\u0458"+
		"\u0459\u0005n\u0000\u0000\u0459\u045a\u0003\u008aE\u0000\u045a\u045c\u0001"+
		"\u0000\u0000\u0000\u045b\u0447\u0001\u0000\u0000\u0000\u045b\u044d\u0001"+
		"\u0000\u0000\u0000\u045b\u0455\u0001\u0000\u0000\u0000\u045c\u0097\u0001"+
		"\u0000\u0000\u0000\u045d\u045e\u0005\"\u0000\u0000\u045e\u045f\u0005m"+
		"\u0000\u0000\u045f\u0460\u0003@ \u0000\u0460\u0461\u0005n\u0000\u0000"+
		"\u0461\u0462\u0003\u008aE\u0000\u0462\u0488\u0001\u0000\u0000\u0000\u0463"+
		"\u0464\u0005\b\u0000\u0000\u0464\u0465\u0003\u008aE\u0000\u0465\u0466"+
		"\u0005\"\u0000\u0000\u0466\u0467\u0005m\u0000\u0000\u0467\u0468\u0003"+
		"@ \u0000\u0468\u0469\u0005n\u0000\u0000\u0469\u046a\u0005e\u0000\u0000"+
		"\u046a\u0488\u0001\u0000\u0000\u0000\u046b\u046c\u0005\u000e\u0000\u0000"+
		"\u046c\u046e\u0005m\u0000\u0000\u046d\u046f\u0003@ \u0000\u046e\u046d"+
		"\u0001\u0000\u0000\u0000\u046e\u046f\u0001\u0000\u0000\u0000\u046f\u0470"+
		"\u0001\u0000\u0000\u0000\u0470\u0472\u0005e\u0000\u0000\u0471\u0473\u0003"+
		"@ \u0000\u0472\u0471\u0001\u0000\u0000\u0000\u0472\u0473\u0001\u0000\u0000"+
		"\u0000\u0473\u0474\u0001\u0000\u0000\u0000\u0474\u0476\u0005e\u0000\u0000"+
		"\u0475\u0477\u0003@ \u0000\u0476\u0475\u0001\u0000\u0000\u0000\u0476\u0477"+
		"\u0001\u0000\u0000\u0000\u0477\u0478\u0001\u0000\u0000\u0000\u0478\u0479"+
		"\u0005n\u0000\u0000\u0479\u0488\u0003\u008aE\u0000\u047a\u047b\u0005\u000e"+
		"\u0000\u0000\u047b\u047c\u0005m\u0000\u0000\u047c\u047e\u0003F#\u0000"+
		"\u047d\u047f\u0003@ \u0000\u047e\u047d\u0001\u0000\u0000\u0000\u047e\u047f"+
		"\u0001\u0000\u0000\u0000\u047f\u0480\u0001\u0000\u0000\u0000\u0480\u0482"+
		"\u0005e\u0000\u0000\u0481\u0483\u0003@ \u0000\u0482\u0481\u0001\u0000"+
		"\u0000\u0000\u0482\u0483\u0001\u0000\u0000\u0000\u0483\u0484\u0001\u0000"+
		"\u0000\u0000\u0484\u0485\u0005n\u0000\u0000\u0485\u0486\u0003\u008aE\u0000"+
		"\u0486\u0488\u0001\u0000\u0000\u0000\u0487\u045d\u0001\u0000\u0000\u0000"+
		"\u0487\u0463\u0001\u0000\u0000\u0000\u0487\u046b\u0001\u0000\u0000\u0000"+
		"\u0487\u047a\u0001\u0000\u0000\u0000\u0488\u0099\u0001\u0000\u0000\u0000"+
		"\u0489\u048a\u0005\u000f\u0000\u0000\u048a\u048b\u0003\u001c\u000e\u0000"+
		"\u048b\u048c\u0005e\u0000\u0000\u048c\u0497\u0001\u0000\u0000\u0000\u048d"+
		"\u048e\u0005\u0006\u0000\u0000\u048e\u0497\u0005e\u0000\u0000\u048f\u0490"+
		"\u0005\u0002\u0000\u0000\u0490\u0497\u0005e\u0000\u0000\u0491\u0493\u0005"+
		"\u0016\u0000\u0000\u0492\u0494\u0003@ \u0000\u0493\u0492\u0001\u0000\u0000"+
		"\u0000\u0493\u0494\u0001\u0000\u0000\u0000\u0494\u0495\u0001\u0000\u0000"+
		"\u0000\u0495\u0497\u0005e\u0000\u0000\u0496\u0489\u0001\u0000\u0000\u0000"+
		"\u0496\u048d\u0001\u0000\u0000\u0000\u0496\u048f\u0001\u0000\u0000\u0000"+
		"\u0496\u0491\u0001\u0000\u0000\u0000\u0497\u009b\u0001\u0000\u0000\u0000"+
		"\u0498\u0499\u0005&\u0000\u0000\u0499\u049a\u0005m\u0000\u0000\u049a\u049b"+
		"\u0005w\u0000\u0000\u049b\u049c\u0005n\u0000\u0000\u049c\u049d\u0005e"+
		"\u0000\u0000\u049d\u009d\u0001\u0000\u0000\u0000\u049e\u04a0\u0003\u00a0"+
		"P\u0000\u049f\u049e\u0001\u0000\u0000\u0000\u04a0\u04a1\u0001\u0000\u0000"+
		"\u0000\u04a1\u049f\u0001\u0000\u0000\u0000\u04a1\u04a2\u0001\u0000\u0000"+
		"\u0000\u04a2\u009f\u0001\u0000\u0000\u0000\u04a3\u04a6\u0003\u00a2Q\u0000"+
		"\u04a4\u04a6\u0003F#\u0000\u04a5\u04a3\u0001\u0000\u0000\u0000\u04a5\u04a4"+
		"\u0001\u0000\u0000\u0000\u04a6\u00a1\u0001\u0000\u0000\u0000\u04a7\u04a9"+
		"\u0003D\"\u0000\u04a8\u04a7\u0001\u0000\u0000\u0000\u04a9\u04ac\u0001"+
		"\u0000\u0000\u0000\u04aa\u04a8\u0001\u0000\u0000\u0000\u04aa\u04ab\u0001"+
		"\u0000\u0000\u0000\u04ab\u04ad\u0001\u0000\u0000\u0000\u04ac\u04aa\u0001"+
		"\u0000\u0000\u0000\u04ad\u04ae\u0003H$\u0000\u04ae\u04b0\u0003h4\u0000"+
		"\u04af\u04b1\u0003\u00a4R\u0000\u04b0\u04af\u0001\u0000\u0000\u0000\u04b0"+
		"\u04b1\u0001\u0000\u0000\u0000\u04b1\u04b2\u0001\u0000\u0000\u0000\u04b2"+
		"\u04b3\u0003\u008eG\u0000\u04b3\u00a3\u0001\u0000\u0000\u0000\u04b4\u04b6"+
		"\u0003F#\u0000\u04b5\u04b4\u0001\u0000\u0000\u0000\u04b6\u04b7\u0001\u0000"+
		"\u0000\u0000\u04b7\u04b5\u0001\u0000\u0000\u0000\u04b7\u04b8\u0001\u0000"+
		"\u0000\u0000\u04b8\u00a5\u0001\u0000\u0000\u0000\u0082\u00a7\u00ac\u00b3"+
		"\u00b9\u00bd\u00c6\u00ca\u00d1\u00d8\u00da\u00e1\u00e5\u00eb\u00f6\u00ff"+
		"\u0105\u0112\u0121\u012c\u0139\u0142\u014b\u0154\u015a\u015f\u0167\u0171"+
		"\u01b8\u01c6\u01d0\u01d4\u01de\u01eb\u01ed\u01f5\u0218\u0220\u022a\u0235"+
		"\u0240\u024b\u0256\u0261\u026c\u0277\u0282\u028d\u0297\u029e\u02a5\u02b1"+
		"\u02b6\u02bf\u02c1\u02cc\u02d2\u02d8\u02dc\u02e4\u02e9\u02f1\u02f4\u02fb"+
		"\u0300\u0304\u0308\u030d\u0313\u031a\u0320\u0325\u032f\u0334\u0337\u033e"+
		"\u034d\u0359\u035c\u035e\u0363\u0367\u036c\u0371\u0378\u037e\u0380\u0387"+
		"\u038c\u0390\u0393\u039c\u039f\u03a5\u03b2\u03bc\u03bf\u03c4\u03c7\u03ce"+
		"\u03dd\u03e9\u03ec\u03ee\u03f8\u03fc\u03ff\u0404\u0409\u0412\u041a\u0423"+
		"\u0431\u0435\u043c\u0440\u0443\u045b\u046e\u0472\u0476\u047e\u0482\u0487"+
		"\u0493\u0496\u04a1\u04a5\u04aa\u04b0\u04b7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}