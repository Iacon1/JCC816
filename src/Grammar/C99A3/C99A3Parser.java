// Generated from D:/BBSnCC/src/Grammar/C99A3.g4 by ANTLR 4.13.1
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
		Asm=38, Define=39, Ifdef=40, Ifndef=41, Elif=42, Endif=43, Include=44, 
		Undef=45, Line=46, Error=47, Pragma=48, TwoMCo=49, ThreeP=50, Arrow=51, 
		Incrmn=52, Decrmn=53, LssLss=54, GrtGrt=55, LessTh=56, GretTh=57, LessEq=58, 
		GretEq=59, Equal=60, NotEql=61, AmpAmp=62, OrOr=63, MulAsg=64, DivAsg=65, 
		ModAsg=66, PluAsg=67, SubAsg=68, LShAsg=69, RShAsg=70, AndAsg=71, XorAsg=72, 
		OrAsg=73, TwoHsh=74, LessCo=75, GretCo=76, LessMd=77, GretMd=78, ModCol=79, 
		TwoLSB=80, TwoRSB=81, Amper=82, Star=83, Plus=84, Minus=85, Tilde=86, 
		Excla=87, BckSla=88, Percnt=89, Xor=90, Or=91, Colon=92, Semico=93, Period=94, 
		Questi=95, Assign=96, Comma=97, HashTg=98, LeSqBr=99, RiSqBr=100, LeRoBr=101, 
		RiRoBr=102, LeCuBr=103, RiCuBr=104, WS=105, NLS=106, NL=107, Pp_number=108, 
		Identifier=109, Constant=110, Character_constant=111, String_literal=112, 
		Header_name=113;
	public static final int
		RULE_preprocessing_file = 0, RULE_group = 1, RULE_group_part = 2, RULE_if_section = 3, 
		RULE_if_group = 4, RULE_elif_groups = 5, RULE_elif_group = 6, RULE_else_group = 7, 
		RULE_endif_line = 8, RULE_control_line = 9, RULE_text_line = 10, RULE_non_directive = 11, 
		RULE_pp_token = 12, RULE_keyword = 13, RULE_punctuator = 14, RULE_primary_expression = 15, 
		RULE_postfix_expression = 16, RULE_argument_expression_list = 17, RULE_unary_expression = 18, 
		RULE_cast_expression = 19, RULE_multiplicative_expression = 20, RULE_additive_expression = 21, 
		RULE_shift_expression = 22, RULE_relational_expression = 23, RULE_equality_expression = 24, 
		RULE_and_expression = 25, RULE_xor_expression = 26, RULE_or_expression = 27, 
		RULE_land_expression = 28, RULE_lor_expression = 29, RULE_conditional_expression = 30, 
		RULE_assignment_expression = 31, RULE_expression = 32, RULE_constant_expression = 33, 
		RULE_declaration = 34, RULE_declaration_specifiers = 35, RULE_storage_class_specifier = 36, 
		RULE_function_specifier = 37, RULE_init_declarator_list = 38, RULE_init_declarator = 39, 
		RULE_type_specifier = 40, RULE_struct_or_union_specifier = 41, RULE_struct_declaration_list = 42, 
		RULE_struct_declaration = 43, RULE_specifier_qualifier_list = 44, RULE_struct_declarator_list = 45, 
		RULE_struct_declarator = 46, RULE_enum_specifier = 47, RULE_enumerator_list = 48, 
		RULE_enumerator = 49, RULE_type_qualifier = 50, RULE_declarator = 51, 
		RULE_direct_declarator = 52, RULE_pointer = 53, RULE_type_qualifier_list = 54, 
		RULE_parameter_type_list = 55, RULE_parameter_list = 56, RULE_parameter_declaration = 57, 
		RULE_identifier_list = 58, RULE_type_name = 59, RULE_abstract_declarator = 60, 
		RULE_direct_abstract_declarator = 61, RULE_typedef_name = 62, RULE_initializer = 63, 
		RULE_initializer_list = 64, RULE_designation = 65, RULE_designator_list = 66, 
		RULE_designator = 67, RULE_attributes_declaration = 68, RULE_statement = 69, 
		RULE_labeled_statement = 70, RULE_compound_statement = 71, RULE_block_item_list = 72, 
		RULE_block_item = 73, RULE_expression_statement = 74, RULE_selection_statement = 75, 
		RULE_iteration_statement = 76, RULE_jump_statement = 77, RULE_asm_statement = 78, 
		RULE_translation_unit = 79, RULE_external_declaration = 80, RULE_function_definition = 81, 
		RULE_declaration_list = 82;
	private static String[] makeRuleNames() {
		return new String[] {
			"preprocessing_file", "group", "group_part", "if_section", "if_group", 
			"elif_groups", "elif_group", "else_group", "endif_line", "control_line", 
			"text_line", "non_directive", "pp_token", "keyword", "punctuator", "primary_expression", 
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
			"'define'", "'ifdef'", "'ifndef'", "'elif'", "'endif'", "'include'", 
			"'undef'", "'line'", "'error'", "'pragma'", "'%:%:'", "'...'", "'->'", 
			"'++'", "'--'", "'<<'", "'>>'", "'<'", "'>'", "'<='", "'>='", "'=='", 
			"'!='", "'&&'", "'||'", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", 
			"'>>='", "'&='", "'^='", "'|='", "'##'", "'<:'", "':>'", "'<%'", "'%>'", 
			"'%:'", "'[['", "']]'", "'&'", "'*'", "'+'", "'-'", "'~'", "'!'", "'/'", 
			"'%'", "'^'", "'|'", "':'", "';'", "'.'", "'?'", "'='", "','", "'#'", 
			"'['", "']'", "'('", "')'", "'{'", "'}'", null, null, "'\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Auto", "Break", "Case", "Char", "Const", "Continue", "Default", 
			"Do", "Double", "Else", "Enum", "Extern", "Float", "For", "Goto", "If", 
			"Inline", "Int", "Long", "Register", "Restrict", "Return", "Short", "Signed", 
			"Sizeof", "Static", "Struct", "Switch", "Typedef", "Union", "Unsigned", 
			"Void", "Volatile", "While", "Bool", "Complex", "Imaginary", "Asm", "Define", 
			"Ifdef", "Ifndef", "Elif", "Endif", "Include", "Undef", "Line", "Error", 
			"Pragma", "TwoMCo", "ThreeP", "Arrow", "Incrmn", "Decrmn", "LssLss", 
			"GrtGrt", "LessTh", "GretTh", "LessEq", "GretEq", "Equal", "NotEql", 
			"AmpAmp", "OrOr", "MulAsg", "DivAsg", "ModAsg", "PluAsg", "SubAsg", "LShAsg", 
			"RShAsg", "AndAsg", "XorAsg", "OrAsg", "TwoHsh", "LessCo", "GretCo", 
			"LessMd", "GretMd", "ModCol", "TwoLSB", "TwoRSB", "Amper", "Star", "Plus", 
			"Minus", "Tilde", "Excla", "BckSla", "Percnt", "Xor", "Or", "Colon", 
			"Semico", "Period", "Questi", "Assign", "Comma", "HashTg", "LeSqBr", 
			"RiSqBr", "LeRoBr", "RiRoBr", "LeCuBr", "RiCuBr", "WS", "NLS", "NL", 
			"Pp_number", "Identifier", "Constant", "Character_constant", "String_literal", 
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8657043458L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1048934092898303L) != 0)) {
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
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
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
	public static class Group_partContext extends ParserRuleContext {
		public If_sectionContext if_section() {
			return getRuleContext(If_sectionContext.class,0);
		}
		public Control_lineContext control_line() {
			return getRuleContext(Control_lineContext.class,0);
		}
		public Text_lineContext text_line() {
			return getRuleContext(Text_lineContext.class,0);
		}
		public TerminalNode HashTg() { return getToken(C99A3Parser.HashTg, 0); }
		public Non_directiveContext non_directive() {
			return getRuleContext(Non_directiveContext.class,0);
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
				text_line();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(177);
				match(HashTg);
				setState(178);
				non_directive();
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
		public Elif_groupsContext elif_groups() {
			return getRuleContext(Elif_groupsContext.class,0);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			if_group();
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(182);
				elif_groups();
				}
				break;
			}
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(185);
				else_group();
				}
				break;
			}
			setState(188);
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
		public Constant_expressionContext constant_expression() {
			return getRuleContext(Constant_expressionContext.class,0);
		}
		public TerminalNode NL() { return getToken(C99A3Parser.NL, 0); }
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
		try {
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				match(HashTg);
				setState(191);
				match(If);
				setState(192);
				constant_expression();
				setState(193);
				match(NL);
				setState(195);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(194);
					group();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				match(HashTg);
				setState(198);
				match(Ifdef);
				setState(199);
				match(Identifier);
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
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(204);
				match(HashTg);
				setState(205);
				match(Ifndef);
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
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Elif_groupsContext extends ParserRuleContext {
		public List<Elif_groupContext> elif_group() {
			return getRuleContexts(Elif_groupContext.class);
		}
		public Elif_groupContext elif_group(int i) {
			return getRuleContext(Elif_groupContext.class,i);
		}
		public Elif_groupsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elif_groups; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C99A3Visitor ) return ((C99A3Visitor<? extends T>)visitor).visitElif_groups(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Elif_groupsContext elif_groups() throws RecognitionException {
		Elif_groupsContext _localctx = new Elif_groupsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_elif_groups);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(214); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(213);
					elif_group();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(216); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
	public static class Elif_groupContext extends ParserRuleContext {
		public TerminalNode HashTg() { return getToken(C99A3Parser.HashTg, 0); }
		public TerminalNode Elif() { return getToken(C99A3Parser.Elif, 0); }
		public Constant_expressionContext constant_expression() {
			return getRuleContext(Constant_expressionContext.class,0);
		}
		public TerminalNode NL() { return getToken(C99A3Parser.NL, 0); }
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
		enterRule(_localctx, 12, RULE_elif_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(HashTg);
			setState(219);
			match(Elif);
			setState(220);
			constant_expression();
			setState(221);
			match(NL);
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(222);
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
		enterRule(_localctx, 14, RULE_else_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(HashTg);
			setState(226);
			match(Else);
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
		enterRule(_localctx, 16, RULE_endif_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(HashTg);
			setState(232);
			match(Endif);
			setState(233);
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
		public List<TerminalNode> NL() { return getTokens(C99A3Parser.NL); }
		public TerminalNode NL(int i) {
			return getToken(C99A3Parser.NL, i);
		}
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
		enterRule(_localctx, 18, RULE_control_line);
		int _la;
		try {
			setState(334);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				match(HashTg);
				setState(236);
				match(Include);
				setState(238); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(237);
					pp_token();
					}
					}
					setState(240); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -8657043458L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1040137999876095L) != 0) );
				setState(242);
				match(NL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				match(HashTg);
				setState(245);
				match(Define);
				setState(246);
				match(Identifier);
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8657043458L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1040137999876095L) != 0)) {
					{
					{
					setState(247);
					pp_token();
					}
					}
					setState(252);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(253);
				match(NL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(254);
				match(HashTg);
				setState(255);
				match(Define);
				setState(256);
				match(Identifier);
				setState(257);
				match(LeRoBr);
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(258);
					identifier_list();
					}
				}

				setState(261);
				match(RiRoBr);
				setState(262);
				match(NL);
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8657043458L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1040137999876095L) != 0)) {
					{
					{
					setState(263);
					pp_token();
					}
					}
					setState(268);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(269);
				match(NL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(270);
				match(HashTg);
				setState(271);
				match(Define);
				setState(272);
				match(Identifier);
				setState(273);
				match(LeRoBr);
				setState(274);
				match(ThreeP);
				setState(275);
				match(RiRoBr);
				setState(276);
				match(NL);
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8657043458L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1040137999876095L) != 0)) {
					{
					{
					setState(277);
					pp_token();
					}
					}
					setState(282);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(283);
				match(NL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(284);
				match(HashTg);
				setState(285);
				match(Define);
				setState(286);
				match(Identifier);
				setState(287);
				match(LeRoBr);
				setState(288);
				identifier_list();
				setState(289);
				match(Comma);
				setState(290);
				match(ThreeP);
				setState(291);
				match(RiRoBr);
				setState(292);
				match(NL);
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8657043458L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1040137999876095L) != 0)) {
					{
					{
					setState(293);
					pp_token();
					}
					}
					setState(298);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(299);
				match(NL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(301);
				match(HashTg);
				setState(302);
				match(Undef);
				setState(303);
				match(Identifier);
				setState(304);
				match(NL);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(305);
				match(HashTg);
				setState(306);
				match(Line);
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8657043458L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1040137999876095L) != 0)) {
					{
					{
					setState(307);
					pp_token();
					}
					}
					setState(312);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(313);
				match(NL);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(314);
				match(HashTg);
				setState(315);
				match(Error);
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8657043458L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1040137999876095L) != 0)) {
					{
					{
					setState(316);
					pp_token();
					}
					}
					setState(321);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(322);
				match(NL);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(323);
				match(HashTg);
				setState(324);
				match(Pragma);
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8657043458L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1040137999876095L) != 0)) {
					{
					{
					setState(325);
					pp_token();
					}
					}
					setState(330);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(331);
				match(NL);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(332);
				match(HashTg);
				setState(333);
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
		enterRule(_localctx, 20, RULE_text_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8657043458L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1040137999876095L) != 0)) {
				{
				{
				setState(336);
				pp_token();
				}
				}
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(342);
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
		enterRule(_localctx, 22, RULE_non_directive);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(344);
				pp_token();
				}
				}
				setState(347); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -8657043458L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1040137999876095L) != 0) );
			setState(349);
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
		public TerminalNode Pp_number() { return getToken(C99A3Parser.Pp_number, 0); }
		public TerminalNode Character_constant() { return getToken(C99A3Parser.Character_constant, 0); }
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
		enterRule(_localctx, 24, RULE_pp_token);
		try {
			setState(358);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Header_name:
				enterOuterAlt(_localctx, 1);
				{
				setState(351);
				match(Header_name);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(352);
				match(Identifier);
				}
				break;
			case Pp_number:
				enterOuterAlt(_localctx, 3);
				{
				setState(353);
				match(Pp_number);
				}
				break;
			case Character_constant:
				enterOuterAlt(_localctx, 4);
				{
				setState(354);
				match(Character_constant);
				}
				break;
			case String_literal:
				enterOuterAlt(_localctx, 5);
				{
				setState(355);
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
			case Struct:
			case Switch:
			case Typedef:
			case Union:
			case Unsigned:
			case Void:
			case While:
			case Bool:
			case Complex:
			case Imaginary:
			case Asm:
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
				enterOuterAlt(_localctx, 6);
				{
				setState(356);
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
				enterOuterAlt(_localctx, 7);
				{
				setState(357);
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
		public TerminalNode Struct() { return getToken(C99A3Parser.Struct, 0); }
		public TerminalNode Switch() { return getToken(C99A3Parser.Switch, 0); }
		public TerminalNode Typedef() { return getToken(C99A3Parser.Typedef, 0); }
		public TerminalNode Union() { return getToken(C99A3Parser.Union, 0); }
		public TerminalNode Unsigned() { return getToken(C99A3Parser.Unsigned, 0); }
		public TerminalNode Void() { return getToken(C99A3Parser.Void, 0); }
		public TerminalNode While() { return getToken(C99A3Parser.While, 0); }
		public TerminalNode Bool() { return getToken(C99A3Parser.Bool, 0); }
		public TerminalNode Complex() { return getToken(C99A3Parser.Complex, 0); }
		public TerminalNode Imaginary() { return getToken(C99A3Parser.Imaginary, 0); }
		public TerminalNode Asm() { return getToken(C99A3Parser.Asm, 0); }
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
		enterRule(_localctx, 26, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 562941296377854L) != 0)) ) {
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
		enterRule(_localctx, 28, RULE_punctuator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			_la = _input.LA(1);
			if ( !(((((_la - 49)) & ~0x3f) == 0 && ((1L << (_la - 49)) & 72057594037927935L) != 0)) ) {
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
		enterRule(_localctx, 30, RULE_primary_expression);
		try {
			setState(371);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(364);
				match(Identifier);
				}
				break;
			case Constant:
				enterOuterAlt(_localctx, 2);
				{
				setState(365);
				match(Constant);
				}
				break;
			case String_literal:
				enterOuterAlt(_localctx, 3);
				{
				setState(366);
				match(String_literal);
				}
				break;
			case LeRoBr:
				enterOuterAlt(_localctx, 4);
				{
				setState(367);
				match(LeRoBr);
				setState(368);
				expression();
				setState(369);
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_postfix_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(374);
				primary_expression();
				}
				break;
			case 2:
				{
				setState(375);
				match(LeRoBr);
				setState(376);
				type_name();
				setState(377);
				match(RiRoBr);
				setState(378);
				match(LeCuBr);
				setState(379);
				initializer_list();
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(380);
					match(Comma);
					}
				}

				setState(383);
				match(RiCuBr);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(410);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(408);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
					case 1:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(387);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(388);
						match(LeSqBr);
						setState(389);
						expression();
						setState(390);
						match(RiSqBr);
						}
						break;
					case 2:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(392);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(393);
						match(LeRoBr);
						setState(395);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 13510798915665920L) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & 1476919359L) != 0)) {
							{
							setState(394);
							argument_expression_list();
							}
						}

						setState(397);
						match(RiRoBr);
						}
						break;
					case 3:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(398);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(399);
						match(Period);
						setState(400);
						match(Identifier);
						}
						break;
					case 4:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(401);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(402);
						match(Arrow);
						setState(403);
						match(Identifier);
						}
						break;
					case 5:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(404);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(405);
						match(Incrmn);
						}
						break;
					case 6:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(406);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(407);
						match(Decrmn);
						}
						break;
					}
					} 
				}
				setState(412);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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
			setState(413);
			assignment_expression();
			setState(418);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(414);
				match(Comma);
				setState(415);
				assignment_expression();
				}
				}
				setState(420);
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
			setState(435);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(421);
				postfix_expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(422);
				match(Incrmn);
				setState(423);
				unary_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(424);
				match(Decrmn);
				setState(425);
				unary_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(426);
				_la = _input.LA(1);
				if ( !(((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & 63L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(427);
				cast_expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(428);
				match(Sizeof);
				setState(429);
				unary_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(430);
				match(Sizeof);
				setState(431);
				match(LeRoBr);
				setState(432);
				type_name();
				setState(433);
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
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TerminalNode LeRoBr() { return getToken(C99A3Parser.LeRoBr, 0); }
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public TerminalNode RiRoBr() { return getToken(C99A3Parser.RiRoBr, 0); }
		public Cast_expressionContext cast_expression() {
			return getRuleContext(Cast_expressionContext.class,0);
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
			setState(443);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(437);
				unary_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(438);
				match(LeRoBr);
				setState(439);
				type_name();
				setState(440);
				match(RiRoBr);
				setState(441);
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
			setState(446);
			cast_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(453);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Multiplicative_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_multiplicative_expression);
					setState(448);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(449);
					_la = _input.LA(1);
					if ( !(((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & 97L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(450);
					cast_expression();
					}
					} 
				}
				setState(455);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
			setState(457);
			multiplicative_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(464);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Additive_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_additive_expression);
					setState(459);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(460);
					_la = _input.LA(1);
					if ( !(_la==Plus || _la==Minus) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(461);
					multiplicative_expression(0);
					}
					} 
				}
				setState(466);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
			setState(468);
			additive_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(475);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Shift_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_shift_expression);
					setState(470);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(471);
					_la = _input.LA(1);
					if ( !(_la==LssLss || _la==GrtGrt) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(472);
					additive_expression(0);
					}
					} 
				}
				setState(477);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
			setState(479);
			shift_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(486);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Relational_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relational_expression);
					setState(481);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(482);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1080863910568919040L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(483);
					shift_expression(0);
					}
					} 
				}
				setState(488);
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
			setState(490);
			relational_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(497);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Equality_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_equality_expression);
					setState(492);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(493);
					_la = _input.LA(1);
					if ( !(_la==Equal || _la==NotEql) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(494);
					relational_expression(0);
					}
					} 
				}
				setState(499);
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
			setState(501);
			equality_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(508);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new And_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_and_expression);
					setState(503);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(504);
					match(Amper);
					setState(505);
					equality_expression(0);
					}
					} 
				}
				setState(510);
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
			setState(512);
			and_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(519);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Xor_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_xor_expression);
					setState(514);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(515);
					match(Xor);
					setState(516);
					and_expression(0);
					}
					} 
				}
				setState(521);
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
			setState(523);
			xor_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(530);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Or_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_or_expression);
					setState(525);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(526);
					match(Or);
					setState(527);
					xor_expression(0);
					}
					} 
				}
				setState(532);
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
			setState(534);
			or_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(541);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Land_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_land_expression);
					setState(536);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(537);
					match(AmpAmp);
					setState(538);
					or_expression(0);
					}
					} 
				}
				setState(543);
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
			setState(545);
			land_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(552);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Lor_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_lor_expression);
					setState(547);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(548);
					match(OrOr);
					setState(549);
					land_expression(0);
					}
					} 
				}
				setState(554);
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
			setState(562);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(555);
				lor_expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(556);
				lor_expression(0);
				setState(557);
				match(Questi);
				setState(558);
				expression();
				setState(559);
				match(Colon);
				setState(560);
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
			setState(569);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(564);
				conditional_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(565);
				unary_expression();
				setState(566);
				_la = _input.LA(1);
				if ( !(((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 4294968319L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(567);
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
			setState(571);
			assignment_expression();
			setState(576);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(572);
				match(Comma);
				setState(573);
				assignment_expression();
				}
				}
				setState(578);
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
			setState(579);
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
		enterRule(_localctx, 68, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(581);
			declaration_specifiers();
			setState(583);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & 67371009L) != 0)) {
				{
				setState(582);
				init_declarator_list();
				}
			}

			setState(585);
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
		enterRule(_localctx, 70, RULE_declaration_specifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(591); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					setState(591);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case Auto:
					case Extern:
					case Register:
					case Static:
					case Typedef:
						{
						setState(587);
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
						setState(588);
						type_specifier();
						}
						break;
					case Const:
					case Restrict:
					case Volatile:
						{
						setState(589);
						type_qualifier();
						}
						break;
					case Inline:
						{
						setState(590);
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
				setState(593); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
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
		enterRule(_localctx, 72, RULE_storage_class_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 605032450L) != 0)) ) {
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
		enterRule(_localctx, 74, RULE_function_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597);
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
		enterRule(_localctx, 76, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			init_declarator();
			setState(604);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(600);
				match(Comma);
				setState(601);
				init_declarator();
				}
				}
				setState(606);
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
		enterRule(_localctx, 78, RULE_init_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			declarator();
			setState(610);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(608);
				match(Assign);
				setState(609);
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
		enterRule(_localctx, 80, RULE_type_specifier);
		int _la;
		try {
			setState(616);
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
				setState(612);
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
				setState(613);
				struct_or_union_specifier();
				}
				break;
			case Enum:
				enterOuterAlt(_localctx, 3);
				{
				setState(614);
				enum_specifier();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 4);
				{
				setState(615);
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
		enterRule(_localctx, 82, RULE_struct_or_union_specifier);
		int _la;
		try {
			setState(628);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(618);
				_la = _input.LA(1);
				if ( !(_la==Struct || _la==Union) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(620);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(619);
					match(Identifier);
					}
				}

				setState(622);
				match(LeCuBr);
				setState(623);
				struct_declaration_list();
				setState(624);
				match(RiCuBr);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(626);
				_la = _input.LA(1);
				if ( !(_la==Struct || _la==Union) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(627);
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
		enterRule(_localctx, 84, RULE_struct_declaration_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(631); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(630);
				struct_declaration();
				}
				}
				setState(633); 
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
		enterRule(_localctx, 86, RULE_struct_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(635);
			specifier_qualifier_list();
			setState(636);
			struct_declarator_list();
			setState(637);
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
		enterRule(_localctx, 88, RULE_specifier_qualifier_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(641);
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
				setState(639);
				type_specifier();
				}
				break;
			case Const:
			case Restrict:
			case Volatile:
				{
				setState(640);
				type_qualifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(644);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(643);
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
		enterRule(_localctx, 90, RULE_struct_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(646);
			struct_declarator();
			setState(651);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(647);
				match(Comma);
				setState(648);
				struct_declarator();
				}
				}
				setState(653);
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
		enterRule(_localctx, 92, RULE_struct_declarator);
		int _la;
		try {
			setState(660);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(654);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(656);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & 67371009L) != 0)) {
					{
					setState(655);
					declarator();
					}
				}

				setState(658);
				match(Colon);
				setState(659);
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
		public TerminalNode LeSqBr() { return getToken(C99A3Parser.LeSqBr, 0); }
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
		enterRule(_localctx, 94, RULE_enum_specifier);
		int _la;
		try {
			setState(675);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(662);
				match(Enum);
				setState(664);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(663);
					match(Identifier);
					}
				}

				setState(666);
				match(LeSqBr);
				setState(667);
				enumerator_list();
				setState(669);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(668);
					match(Comma);
					}
				}

				setState(671);
				match(RiCuBr);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(673);
				match(Enum);
				setState(674);
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
		enterRule(_localctx, 96, RULE_enumerator_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(677);
			enumerator();
			setState(682);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(678);
					match(Comma);
					setState(679);
					enumerator();
					}
					} 
				}
				setState(684);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
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
		enterRule(_localctx, 98, RULE_enumerator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(685);
			match(Identifier);
			setState(688);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(686);
				match(Assign);
				setState(687);
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
		enterRule(_localctx, 100, RULE_type_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(690);
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
		enterRule(_localctx, 102, RULE_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(693);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Star) {
				{
				setState(692);
				pointer();
				}
			}

			setState(695);
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
		int _startState = 104;
		enterRecursionRule(_localctx, 104, RULE_direct_declarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(703);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(698);
				match(Identifier);
				}
				break;
			case LeRoBr:
				{
				setState(699);
				match(LeRoBr);
				setState(700);
				declarator();
				setState(701);
				match(RiRoBr);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(750);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(748);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
					case 1:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(705);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(706);
						match(LeSqBr);
						setState(708);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
							{
							setState(707);
							type_qualifier_list();
							}
						}

						setState(711);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 13510798915665920L) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & 1476919359L) != 0)) {
							{
							setState(710);
							assignment_expression();
							}
						}

						setState(713);
						match(RiSqBr);
						}
						break;
					case 2:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(714);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(715);
						match(LeSqBr);
						setState(716);
						match(Static);
						setState(718);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
							{
							setState(717);
							type_qualifier_list();
							}
						}

						setState(720);
						assignment_expression();
						setState(721);
						match(RiSqBr);
						}
						break;
					case 3:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(723);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(724);
						match(LeSqBr);
						setState(725);
						type_qualifier_list();
						setState(726);
						match(Static);
						setState(727);
						assignment_expression();
						setState(728);
						match(RiSqBr);
						}
						break;
					case 4:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(730);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(731);
						match(LeSqBr);
						setState(733);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
							{
							setState(732);
							type_qualifier_list();
							}
						}

						setState(735);
						match(Star);
						setState(736);
						match(RiSqBr);
						}
						break;
					case 5:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(737);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(738);
						match(LeRoBr);
						setState(739);
						parameter_type_list();
						setState(740);
						match(RiRoBr);
						}
						break;
					case 6:
						{
						_localctx = new Direct_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_declarator);
						setState(742);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(743);
						match(LeRoBr);
						setState(745);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==Identifier) {
							{
							setState(744);
							identifier_list();
							}
						}

						setState(747);
						match(RiRoBr);
						}
						break;
					}
					} 
				}
				setState(752);
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
		enterRule(_localctx, 106, RULE_pointer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(757); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(753);
				match(Star);
				setState(755);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
					{
					setState(754);
					type_qualifier_list();
					}
				}

				}
				}
				setState(759); 
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
		enterRule(_localctx, 108, RULE_type_qualifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(762); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(761);
				type_qualifier();
				}
				}
				setState(764); 
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
		enterRule(_localctx, 110, RULE_parameter_type_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(766);
			parameter_list();
			setState(769);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(767);
				match(Comma);
				setState(768);
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
		enterRule(_localctx, 112, RULE_parameter_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(771);
			parameter_declaration();
			setState(776);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(772);
					match(Comma);
					setState(773);
					parameter_declaration();
					}
					} 
				}
				setState(778);
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
		enterRule(_localctx, 114, RULE_parameter_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(779);
			declaration_specifiers();
			setState(784);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				{
				setState(780);
				declarator();
				}
				break;
			case 2:
				{
				setState(782);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Star || _la==LeRoBr) {
					{
					setState(781);
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
		enterRule(_localctx, 116, RULE_identifier_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(786);
			match(Identifier);
			setState(791);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(787);
					match(Comma);
					setState(788);
					match(Identifier);
					}
					} 
				}
				setState(793);
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
		enterRule(_localctx, 118, RULE_type_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(794);
			specifier_qualifier_list();
			setState(796);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Star || _la==LeRoBr) {
				{
				setState(795);
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
		enterRule(_localctx, 120, RULE_abstract_declarator);
		int _la;
		try {
			setState(803);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(798);
				pointer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(800);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Star) {
					{
					setState(799);
					pointer();
					}
				}

				setState(802);
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
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode RiRoBr() { return getToken(C99A3Parser.RiRoBr, 0); }
		public Direct_abstract_declaratorContext direct_abstract_declarator() {
			return getRuleContext(Direct_abstract_declaratorContext.class,0);
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
		int _startState = 122;
		enterRecursionRule(_localctx, 122, RULE_direct_abstract_declarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(806);
			match(LeRoBr);
			setState(807);
			declarator();
			setState(808);
			match(RiRoBr);
			}
			_ctx.stop = _input.LT(-1);
			setState(855);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(853);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
					case 1:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(810);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(811);
						match(LeSqBr);
						setState(813);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
							{
							setState(812);
							type_qualifier_list();
							}
						}

						setState(816);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 13510798915665920L) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & 1476919359L) != 0)) {
							{
							setState(815);
							assignment_expression();
							}
						}

						setState(818);
						match(RiSqBr);
						}
						break;
					case 2:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(819);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(820);
						match(LeSqBr);
						setState(821);
						match(Static);
						setState(823);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
							{
							setState(822);
							type_qualifier_list();
							}
						}

						setState(825);
						assignment_expression();
						setState(826);
						match(RiSqBr);
						}
						break;
					case 3:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(828);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(829);
						match(LeSqBr);
						setState(830);
						type_qualifier_list();
						setState(831);
						match(Static);
						setState(832);
						assignment_expression();
						setState(833);
						match(RiSqBr);
						}
						break;
					case 4:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(835);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(836);
						match(LeSqBr);
						setState(838);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8592031776L) != 0)) {
							{
							setState(837);
							type_qualifier_list();
							}
						}

						setState(840);
						match(Star);
						setState(841);
						match(RiSqBr);
						}
						break;
					case 5:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(842);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(843);
						match(LeRoBr);
						setState(844);
						parameter_type_list();
						setState(845);
						match(RiRoBr);
						}
						break;
					case 6:
						{
						_localctx = new Direct_abstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_direct_abstract_declarator);
						setState(847);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(848);
						match(LeRoBr);
						setState(850);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==Identifier) {
							{
							setState(849);
							identifier_list();
							}
						}

						setState(852);
						match(RiRoBr);
						}
						break;
					}
					} 
				}
				setState(857);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
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
		enterRule(_localctx, 124, RULE_typedef_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(858);
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
		enterRule(_localctx, 126, RULE_initializer);
		int _la;
		try {
			setState(868);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Sizeof:
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
				setState(860);
				assignment_expression();
				}
				break;
			case LeCuBr:
				enterOuterAlt(_localctx, 2);
				{
				setState(861);
				match(LeCuBr);
				setState(862);
				initializer_list();
				setState(864);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(863);
					match(Comma);
					}
				}

				setState(866);
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
		enterRule(_localctx, 128, RULE_initializer_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(871);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Period || _la==LeSqBr) {
				{
				setState(870);
				designation();
				}
			}

			setState(873);
			initializer();
			setState(879); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(874);
					match(Comma);
					setState(876);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Period || _la==LeSqBr) {
						{
						setState(875);
						designation();
						}
					}

					setState(878);
					initializer();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(881); 
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
		enterRule(_localctx, 130, RULE_designation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(883);
			designator_list();
			setState(884);
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
		enterRule(_localctx, 132, RULE_designator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(887); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(886);
				designator();
				}
				}
				setState(889); 
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
		enterRule(_localctx, 134, RULE_designator);
		try {
			setState(897);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeSqBr:
				enterOuterAlt(_localctx, 1);
				{
				setState(891);
				match(LeSqBr);
				setState(892);
				constant_expression();
				setState(893);
				match(RiSqBr);
				}
				break;
			case Period:
				enterOuterAlt(_localctx, 2);
				{
				setState(895);
				match(Period);
				setState(896);
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
		enterRule(_localctx, 136, RULE_attributes_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(899);
			match(TwoLSB);
			setState(900);
			identifier_list();
			setState(901);
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
		enterRule(_localctx, 138, RULE_statement);
		try {
			setState(910);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(903);
				asm_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(904);
				labeled_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(905);
				compound_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(906);
				expression_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(907);
				selection_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(908);
				iteration_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(909);
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
		enterRule(_localctx, 140, RULE_labeled_statement);
		try {
			setState(923);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(912);
				match(Identifier);
				setState(913);
				match(Colon);
				setState(914);
				statement();
				}
				break;
			case Case:
				enterOuterAlt(_localctx, 2);
				{
				setState(915);
				match(Case);
				setState(916);
				constant_expression();
				setState(917);
				match(Colon);
				setState(918);
				statement();
				}
				break;
			case Default:
				enterOuterAlt(_localctx, 3);
				{
				setState(920);
				match(Default);
				setState(921);
				match(Colon);
				setState(922);
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
		enterRule(_localctx, 142, RULE_compound_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(925);
			match(LeCuBr);
			setState(927);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 13511211198970878L) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & 1479018559L) != 0)) {
				{
				setState(926);
				block_item_list();
				}
			}

			setState(929);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(932); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(931);
				block_item();
				}
				}
				setState(934); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 13511211198970878L) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & 1479018559L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		enterRule(_localctx, 146, RULE_block_item);
		try {
			setState(938);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(936);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(937);
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
		enterRule(_localctx, 148, RULE_expression_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(941);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 13510798915665920L) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & 1476919359L) != 0)) {
				{
				setState(940);
				expression();
				}
			}

			setState(943);
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
			setState(965);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(945);
				match(If);
				setState(946);
				match(LeRoBr);
				setState(947);
				expression();
				setState(948);
				match(RiRoBr);
				setState(949);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(951);
				match(If);
				setState(952);
				match(LeRoBr);
				setState(953);
				expression();
				setState(954);
				match(RiRoBr);
				setState(955);
				statement();
				setState(956);
				match(Else);
				setState(957);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(959);
				match(Switch);
				setState(960);
				match(LeRoBr);
				setState(961);
				expression();
				setState(962);
				match(RiRoBr);
				setState(963);
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
		int _la;
		try {
			setState(1009);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(967);
				match(While);
				setState(968);
				match(LeRoBr);
				setState(969);
				expression();
				setState(970);
				match(RiRoBr);
				setState(971);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(973);
				match(Do);
				setState(974);
				statement();
				setState(975);
				match(While);
				setState(976);
				match(LeRoBr);
				setState(977);
				expression();
				setState(978);
				match(RiRoBr);
				setState(979);
				match(Semico);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(981);
				match(For);
				setState(982);
				match(LeRoBr);
				setState(984);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 13510798915665920L) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & 1476919359L) != 0)) {
					{
					setState(983);
					expression();
					}
				}

				setState(986);
				match(Semico);
				setState(988);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 13510798915665920L) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & 1476919359L) != 0)) {
					{
					setState(987);
					expression();
					}
				}

				setState(990);
				match(Semico);
				setState(992);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 13510798915665920L) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & 1476919359L) != 0)) {
					{
					setState(991);
					expression();
					}
				}

				setState(994);
				match(RiRoBr);
				setState(995);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(996);
				match(For);
				setState(997);
				match(LeRoBr);
				setState(998);
				declaration();
				setState(1000);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 13510798915665920L) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & 1476919359L) != 0)) {
					{
					setState(999);
					expression();
					}
				}

				setState(1002);
				match(Semico);
				setState(1004);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 13510798915665920L) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & 1476919359L) != 0)) {
					{
					setState(1003);
					expression();
					}
				}

				setState(1006);
				match(RiRoBr);
				setState(1007);
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
		enterRule(_localctx, 154, RULE_jump_statement);
		int _la;
		try {
			setState(1023);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Goto:
				enterOuterAlt(_localctx, 1);
				{
				setState(1011);
				match(Goto);
				setState(1012);
				match(Identifier);
				setState(1013);
				match(Semico);
				}
				break;
			case Continue:
				enterOuterAlt(_localctx, 2);
				{
				setState(1014);
				match(Continue);
				setState(1015);
				match(Semico);
				}
				break;
			case Break:
				enterOuterAlt(_localctx, 3);
				{
				setState(1016);
				match(Break);
				setState(1017);
				match(Semico);
				}
				break;
			case Return:
				enterOuterAlt(_localctx, 4);
				{
				setState(1018);
				match(Return);
				setState(1020);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 13510798915665920L) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & 1476919359L) != 0)) {
					{
					setState(1019);
					expression();
					}
				}

				setState(1022);
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
			setState(1025);
			match(Asm);
			setState(1026);
			match(LeRoBr);
			setState(1027);
			match(String_literal);
			setState(1028);
			match(RiRoBr);
			setState(1029);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1032); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1031);
				external_declaration();
				}
				}
				setState(1034); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 119952783922L) != 0) || _la==TwoLSB || _la==Identifier );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
			setState(1038);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1036);
				function_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1037);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1043);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TwoLSB) {
				{
				{
				setState(1040);
				attributes_declaration();
				}
				}
				setState(1045);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1046);
			declaration_specifiers();
			setState(1047);
			declarator();
			setState(1049);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 119952783922L) != 0) || _la==Identifier) {
				{
				setState(1048);
				declaration_list();
				}
			}

			setState(1051);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1054); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1053);
				declaration();
				}
				}
				setState(1056); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 119952783922L) != 0) || _la==Identifier );
			}
		}
		catch (RecognitionException re) {
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
		case 52:
			return direct_declarator_sempred((Direct_declaratorContext)_localctx, predIndex);
		case 61:
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
		"\u0004\u0001q\u0423\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"\b\u0002\u0001\u0003\u0001\u0003\u0003\u0003\u00b8\b\u0003\u0001\u0003"+
		"\u0003\u0003\u00bb\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00c4\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00cb\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"\u00d2\b\u0004\u0003\u0004\u00d4\b\u0004\u0001\u0005\u0004\u0005\u00d7"+
		"\b\u0005\u000b\u0005\f\u0005\u00d8\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u00e0\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007\u00e6\b\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0004\t\u00ef\b\t\u000b\t\f\t\u00f0"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00f9\b\t\n\t"+
		"\f\t\u00fc\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t"+
		"\u0104\b\t\u0001\t\u0001\t\u0001\t\u0005\t\u0109\b\t\n\t\f\t\u010c\t\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u0117\b\t\n\t\f\t\u011a\t\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0127"+
		"\b\t\n\t\f\t\u012a\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0005\t\u0135\b\t\n\t\f\t\u0138\t\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\t\u013e\b\t\n\t\f\t\u0141\t\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0005\t\u0147\b\t\n\t\f\t\u014a\t\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u014f\b\t\u0001\n\u0005\n\u0152\b\n\n\n\f\n\u0155\t\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0004\u000b\u015a\b\u000b\u000b\u000b\f\u000b\u015b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u0167\b\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u0174\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u017e"+
		"\b\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0182\b\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u018c\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u0199\b\u0010\n\u0010\f\u0010\u019c"+
		"\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u01a1\b\u0011"+
		"\n\u0011\f\u0011\u01a4\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u01b4"+
		"\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u01bc\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u01c4\b\u0014\n\u0014\f\u0014"+
		"\u01c7\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0005\u0015\u01cf\b\u0015\n\u0015\f\u0015\u01d2\t\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005"+
		"\u0016\u01da\b\u0016\n\u0016\f\u0016\u01dd\t\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u01e5\b\u0017"+
		"\n\u0017\f\u0017\u01e8\t\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u01f0\b\u0018\n\u0018\f\u0018"+
		"\u01f3\t\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0005\u0019\u01fb\b\u0019\n\u0019\f\u0019\u01fe\t\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005"+
		"\u001a\u0206\b\u001a\n\u001a\f\u001a\u0209\t\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u0211\b\u001b"+
		"\n\u001b\f\u001b\u0214\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u021c\b\u001c\n\u001c\f\u001c"+
		"\u021f\t\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0005\u001d\u0227\b\u001d\n\u001d\f\u001d\u022a\t\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0003\u001e\u0233\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0003\u001f\u023a\b\u001f\u0001 \u0001 \u0001 \u0005"+
		" \u023f\b \n \f \u0242\t \u0001!\u0001!\u0001\"\u0001\"\u0003\"\u0248"+
		"\b\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0004#\u0250\b#\u000b"+
		"#\f#\u0251\u0001$\u0001$\u0001%\u0001%\u0001&\u0001&\u0001&\u0005&\u025b"+
		"\b&\n&\f&\u025e\t&\u0001\'\u0001\'\u0001\'\u0003\'\u0263\b\'\u0001(\u0001"+
		"(\u0001(\u0001(\u0003(\u0269\b(\u0001)\u0001)\u0003)\u026d\b)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0003)\u0275\b)\u0001*\u0004*\u0278\b*\u000b"+
		"*\f*\u0279\u0001+\u0001+\u0001+\u0001+\u0001,\u0001,\u0003,\u0282\b,\u0001"+
		",\u0003,\u0285\b,\u0001-\u0001-\u0001-\u0005-\u028a\b-\n-\f-\u028d\t-"+
		"\u0001.\u0001.\u0003.\u0291\b.\u0001.\u0001.\u0003.\u0295\b.\u0001/\u0001"+
		"/\u0003/\u0299\b/\u0001/\u0001/\u0001/\u0003/\u029e\b/\u0001/\u0001/\u0001"+
		"/\u0001/\u0003/\u02a4\b/\u00010\u00010\u00010\u00050\u02a9\b0\n0\f0\u02ac"+
		"\t0\u00011\u00011\u00011\u00031\u02b1\b1\u00012\u00012\u00013\u00033\u02b6"+
		"\b3\u00013\u00013\u00014\u00014\u00014\u00014\u00014\u00014\u00034\u02c0"+
		"\b4\u00014\u00014\u00014\u00034\u02c5\b4\u00014\u00034\u02c8\b4\u0001"+
		"4\u00014\u00014\u00014\u00014\u00034\u02cf\b4\u00014\u00014\u00014\u0001"+
		"4\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u0003"+
		"4\u02de\b4\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u0001"+
		"4\u00014\u00034\u02ea\b4\u00014\u00054\u02ed\b4\n4\f4\u02f0\t4\u00015"+
		"\u00015\u00035\u02f4\b5\u00045\u02f6\b5\u000b5\f5\u02f7\u00016\u00046"+
		"\u02fb\b6\u000b6\f6\u02fc\u00017\u00017\u00017\u00037\u0302\b7\u00018"+
		"\u00018\u00018\u00058\u0307\b8\n8\f8\u030a\t8\u00019\u00019\u00019\u0003"+
		"9\u030f\b9\u00039\u0311\b9\u0001:\u0001:\u0001:\u0005:\u0316\b:\n:\f:"+
		"\u0319\t:\u0001;\u0001;\u0003;\u031d\b;\u0001<\u0001<\u0003<\u0321\b<"+
		"\u0001<\u0003<\u0324\b<\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001"+
		"=\u0001=\u0003=\u032e\b=\u0001=\u0003=\u0331\b=\u0001=\u0001=\u0001=\u0001"+
		"=\u0001=\u0003=\u0338\b=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001"+
		"=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0003=\u0347\b=\u0001=\u0001"+
		"=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0003=\u0353"+
		"\b=\u0001=\u0005=\u0356\b=\n=\f=\u0359\t=\u0001>\u0001>\u0001?\u0001?"+
		"\u0001?\u0001?\u0003?\u0361\b?\u0001?\u0001?\u0003?\u0365\b?\u0001@\u0003"+
		"@\u0368\b@\u0001@\u0001@\u0001@\u0003@\u036d\b@\u0001@\u0004@\u0370\b"+
		"@\u000b@\f@\u0371\u0001A\u0001A\u0001A\u0001B\u0004B\u0378\bB\u000bB\f"+
		"B\u0379\u0001C\u0001C\u0001C\u0001C\u0001C\u0001C\u0003C\u0382\bC\u0001"+
		"D\u0001D\u0001D\u0001D\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001"+
		"E\u0003E\u038f\bE\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001"+
		"F\u0001F\u0001F\u0001F\u0003F\u039c\bF\u0001G\u0001G\u0003G\u03a0\bG\u0001"+
		"G\u0001G\u0001H\u0004H\u03a5\bH\u000bH\fH\u03a6\u0001I\u0001I\u0003I\u03ab"+
		"\bI\u0001J\u0003J\u03ae\bJ\u0001J\u0001J\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0001K\u0003K\u03c6\bK\u0001L\u0001L\u0001"+
		"L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001"+
		"L\u0001L\u0001L\u0001L\u0001L\u0003L\u03d9\bL\u0001L\u0001L\u0003L\u03dd"+
		"\bL\u0001L\u0001L\u0003L\u03e1\bL\u0001L\u0001L\u0001L\u0001L\u0001L\u0001"+
		"L\u0003L\u03e9\bL\u0001L\u0001L\u0003L\u03ed\bL\u0001L\u0001L\u0001L\u0003"+
		"L\u03f2\bL\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001"+
		"M\u0003M\u03fd\bM\u0001M\u0003M\u0400\bM\u0001N\u0001N\u0001N\u0001N\u0001"+
		"N\u0001N\u0001O\u0004O\u0409\bO\u000bO\fO\u040a\u0001P\u0001P\u0003P\u040f"+
		"\bP\u0001Q\u0005Q\u0412\bQ\nQ\fQ\u0415\tQ\u0001Q\u0001Q\u0001Q\u0003Q"+
		"\u041a\bQ\u0001Q\u0001Q\u0001R\u0004R\u041f\bR\u000bR\fR\u0420\u0001R"+
		"\u0001\u0251\r (*,.02468:hzS\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPR"+
		"TVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e"+
		"\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u0000"+
		"\r\u0003\u0000\u0001\u0019\u001b \"0\u0001\u00001h\u0001\u0000RW\u0002"+
		"\u0000SSXY\u0001\u0000TU\u0001\u000067\u0001\u00008;\u0001\u0000<=\u0002"+
		"\u0000@I``\u0005\u0000\u0001\u0001\f\f\u0014\u0014\u001a\u001a\u001d\u001d"+
		"\u0007\u0000\u0004\u0004\t\t\r\r\u0012\u0013\u0017\u0018\u001f #$\u0002"+
		"\u0000\u001b\u001b\u001e\u001e\u0003\u0000\u0005\u0005\u0015\u0015!!\u0478"+
		"\u0000\u00a7\u0001\u0000\u0000\u0000\u0002\u00aa\u0001\u0000\u0000\u0000"+
		"\u0004\u00b3\u0001\u0000\u0000\u0000\u0006\u00b5\u0001\u0000\u0000\u0000"+
		"\b\u00d3\u0001\u0000\u0000\u0000\n\u00d6\u0001\u0000\u0000\u0000\f\u00da"+
		"\u0001\u0000\u0000\u0000\u000e\u00e1\u0001\u0000\u0000\u0000\u0010\u00e7"+
		"\u0001\u0000\u0000\u0000\u0012\u014e\u0001\u0000\u0000\u0000\u0014\u0153"+
		"\u0001\u0000\u0000\u0000\u0016\u0159\u0001\u0000\u0000\u0000\u0018\u0166"+
		"\u0001\u0000\u0000\u0000\u001a\u0168\u0001\u0000\u0000\u0000\u001c\u016a"+
		"\u0001\u0000\u0000\u0000\u001e\u0173\u0001\u0000\u0000\u0000 \u0181\u0001"+
		"\u0000\u0000\u0000\"\u019d\u0001\u0000\u0000\u0000$\u01b3\u0001\u0000"+
		"\u0000\u0000&\u01bb\u0001\u0000\u0000\u0000(\u01bd\u0001\u0000\u0000\u0000"+
		"*\u01c8\u0001\u0000\u0000\u0000,\u01d3\u0001\u0000\u0000\u0000.\u01de"+
		"\u0001\u0000\u0000\u00000\u01e9\u0001\u0000\u0000\u00002\u01f4\u0001\u0000"+
		"\u0000\u00004\u01ff\u0001\u0000\u0000\u00006\u020a\u0001\u0000\u0000\u0000"+
		"8\u0215\u0001\u0000\u0000\u0000:\u0220\u0001\u0000\u0000\u0000<\u0232"+
		"\u0001\u0000\u0000\u0000>\u0239\u0001\u0000\u0000\u0000@\u023b\u0001\u0000"+
		"\u0000\u0000B\u0243\u0001\u0000\u0000\u0000D\u0245\u0001\u0000\u0000\u0000"+
		"F\u024f\u0001\u0000\u0000\u0000H\u0253\u0001\u0000\u0000\u0000J\u0255"+
		"\u0001\u0000\u0000\u0000L\u0257\u0001\u0000\u0000\u0000N\u025f\u0001\u0000"+
		"\u0000\u0000P\u0268\u0001\u0000\u0000\u0000R\u0274\u0001\u0000\u0000\u0000"+
		"T\u0277\u0001\u0000\u0000\u0000V\u027b\u0001\u0000\u0000\u0000X\u0281"+
		"\u0001\u0000\u0000\u0000Z\u0286\u0001\u0000\u0000\u0000\\\u0294\u0001"+
		"\u0000\u0000\u0000^\u02a3\u0001\u0000\u0000\u0000`\u02a5\u0001\u0000\u0000"+
		"\u0000b\u02ad\u0001\u0000\u0000\u0000d\u02b2\u0001\u0000\u0000\u0000f"+
		"\u02b5\u0001\u0000\u0000\u0000h\u02bf\u0001\u0000\u0000\u0000j\u02f5\u0001"+
		"\u0000\u0000\u0000l\u02fa\u0001\u0000\u0000\u0000n\u02fe\u0001\u0000\u0000"+
		"\u0000p\u0303\u0001\u0000\u0000\u0000r\u030b\u0001\u0000\u0000\u0000t"+
		"\u0312\u0001\u0000\u0000\u0000v\u031a\u0001\u0000\u0000\u0000x\u0323\u0001"+
		"\u0000\u0000\u0000z\u0325\u0001\u0000\u0000\u0000|\u035a\u0001\u0000\u0000"+
		"\u0000~\u0364\u0001\u0000\u0000\u0000\u0080\u0367\u0001\u0000\u0000\u0000"+
		"\u0082\u0373\u0001\u0000\u0000\u0000\u0084\u0377\u0001\u0000\u0000\u0000"+
		"\u0086\u0381\u0001\u0000\u0000\u0000\u0088\u0383\u0001\u0000\u0000\u0000"+
		"\u008a\u038e\u0001\u0000\u0000\u0000\u008c\u039b\u0001\u0000\u0000\u0000"+
		"\u008e\u039d\u0001\u0000\u0000\u0000\u0090\u03a4\u0001\u0000\u0000\u0000"+
		"\u0092\u03aa\u0001\u0000\u0000\u0000\u0094\u03ad\u0001\u0000\u0000\u0000"+
		"\u0096\u03c5\u0001\u0000\u0000\u0000\u0098\u03f1\u0001\u0000\u0000\u0000"+
		"\u009a\u03ff\u0001\u0000\u0000\u0000\u009c\u0401\u0001\u0000\u0000\u0000"+
		"\u009e\u0408\u0001\u0000\u0000\u0000\u00a0\u040e\u0001\u0000\u0000\u0000"+
		"\u00a2\u0413\u0001\u0000\u0000\u0000\u00a4\u041e\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a8\u0003\u0002\u0001\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u0001\u0001\u0000\u0000\u0000"+
		"\u00a9\u00ab\u0003\u0004\u0002\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000"+
		"\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u0003\u0001\u0000\u0000\u0000"+
		"\u00ae\u00b4\u0003\u0006\u0003\u0000\u00af\u00b4\u0003\u0012\t\u0000\u00b0"+
		"\u00b4\u0003\u0014\n\u0000\u00b1\u00b2\u0005b\u0000\u0000\u00b2\u00b4"+
		"\u0003\u0016\u000b\u0000\u00b3\u00ae\u0001\u0000\u0000\u0000\u00b3\u00af"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b4\u0005\u0001\u0000\u0000\u0000\u00b5\u00b7"+
		"\u0003\b\u0004\u0000\u00b6\u00b8\u0003\n\u0005\u0000\u00b7\u00b6\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00ba\u0001"+
		"\u0000\u0000\u0000\u00b9\u00bb\u0003\u000e\u0007\u0000\u00ba\u00b9\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0003\u0010\b\u0000\u00bd\u0007\u0001\u0000"+
		"\u0000\u0000\u00be\u00bf\u0005b\u0000\u0000\u00bf\u00c0\u0005\u0010\u0000"+
		"\u0000\u00c0\u00c1\u0003B!\u0000\u00c1\u00c3\u0005k\u0000\u0000\u00c2"+
		"\u00c4\u0003\u0002\u0001\u0000\u00c3\u00c2\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c4\u00d4\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0005b\u0000\u0000\u00c6\u00c7\u0005(\u0000\u0000\u00c7\u00c8\u0005"+
		"m\u0000\u0000\u00c8\u00ca\u0005k\u0000\u0000\u00c9\u00cb\u0003\u0002\u0001"+
		"\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000"+
		"\u0000\u00cb\u00d4\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005b\u0000\u0000"+
		"\u00cd\u00ce\u0005)\u0000\u0000\u00ce\u00cf\u0005m\u0000\u0000\u00cf\u00d1"+
		"\u0005k\u0000\u0000\u00d0\u00d2\u0003\u0002\u0001\u0000\u00d1\u00d0\u0001"+
		"\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d3\u00be\u0001\u0000\u0000\u0000\u00d3\u00c5\u0001"+
		"\u0000\u0000\u0000\u00d3\u00cc\u0001\u0000\u0000\u0000\u00d4\t\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d7\u0003\f\u0006\u0000\u00d6\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u000b\u0001\u0000\u0000"+
		"\u0000\u00da\u00db\u0005b\u0000\u0000\u00db\u00dc\u0005*\u0000\u0000\u00dc"+
		"\u00dd\u0003B!\u0000\u00dd\u00df\u0005k\u0000\u0000\u00de\u00e0\u0003"+
		"\u0002\u0001\u0000\u00df\u00de\u0001\u0000\u0000\u0000\u00df\u00e0\u0001"+
		"\u0000\u0000\u0000\u00e0\r\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005b"+
		"\u0000\u0000\u00e2\u00e3\u0005\n\u0000\u0000\u00e3\u00e5\u0005k\u0000"+
		"\u0000\u00e4\u00e6\u0003\u0002\u0001\u0000\u00e5\u00e4\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u000f\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e8\u0005b\u0000\u0000\u00e8\u00e9\u0005+\u0000\u0000\u00e9"+
		"\u00ea\u0005k\u0000\u0000\u00ea\u0011\u0001\u0000\u0000\u0000\u00eb\u00ec"+
		"\u0005b\u0000\u0000\u00ec\u00ee\u0005,\u0000\u0000\u00ed\u00ef\u0003\u0018"+
		"\f\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000"+
		"\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000"+
		"\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005k\u0000\u0000"+
		"\u00f3\u014f\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005b\u0000\u0000\u00f5"+
		"\u00f6\u0005\'\u0000\u0000\u00f6\u00fa\u0005m\u0000\u0000\u00f7\u00f9"+
		"\u0003\u0018\f\u0000\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f9\u00fc\u0001"+
		"\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001"+
		"\u0000\u0000\u0000\u00fb\u00fd\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001"+
		"\u0000\u0000\u0000\u00fd\u014f\u0005k\u0000\u0000\u00fe\u00ff\u0005b\u0000"+
		"\u0000\u00ff\u0100\u0005\'\u0000\u0000\u0100\u0101\u0005m\u0000\u0000"+
		"\u0101\u0103\u0005e\u0000\u0000\u0102\u0104\u0003t:\u0000\u0103\u0102"+
		"\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0105"+
		"\u0001\u0000\u0000\u0000\u0105\u0106\u0005f\u0000\u0000\u0106\u010a\u0005"+
		"k\u0000\u0000\u0107\u0109\u0003\u0018\f\u0000\u0108\u0107\u0001\u0000"+
		"\u0000\u0000\u0109\u010c\u0001\u0000\u0000\u0000\u010a\u0108\u0001\u0000"+
		"\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u010d\u0001\u0000"+
		"\u0000\u0000\u010c\u010a\u0001\u0000\u0000\u0000\u010d\u014f\u0005k\u0000"+
		"\u0000\u010e\u010f\u0005b\u0000\u0000\u010f\u0110\u0005\'\u0000\u0000"+
		"\u0110\u0111\u0005m\u0000\u0000\u0111\u0112\u0005e\u0000\u0000\u0112\u0113"+
		"\u00052\u0000\u0000\u0113\u0114\u0005f\u0000\u0000\u0114\u0118\u0005k"+
		"\u0000\u0000\u0115\u0117\u0003\u0018\f\u0000\u0116\u0115\u0001\u0000\u0000"+
		"\u0000\u0117\u011a\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000\u0000"+
		"\u0000\u0118\u0119\u0001\u0000\u0000\u0000\u0119\u011b\u0001\u0000\u0000"+
		"\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011b\u014f\u0005k\u0000\u0000"+
		"\u011c\u011d\u0005b\u0000\u0000\u011d\u011e\u0005\'\u0000\u0000\u011e"+
		"\u011f\u0005m\u0000\u0000\u011f\u0120\u0005e\u0000\u0000\u0120\u0121\u0003"+
		"t:\u0000\u0121\u0122\u0005a\u0000\u0000\u0122\u0123\u00052\u0000\u0000"+
		"\u0123\u0124\u0005f\u0000\u0000\u0124\u0128\u0005k\u0000\u0000\u0125\u0127"+
		"\u0003\u0018\f\u0000\u0126\u0125\u0001\u0000\u0000\u0000\u0127\u012a\u0001"+
		"\u0000\u0000\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0128\u0129\u0001"+
		"\u0000\u0000\u0000\u0129\u012b\u0001\u0000\u0000\u0000\u012a\u0128\u0001"+
		"\u0000\u0000\u0000\u012b\u012c\u0005k\u0000\u0000\u012c\u014f\u0001\u0000"+
		"\u0000\u0000\u012d\u012e\u0005b\u0000\u0000\u012e\u012f\u0005-\u0000\u0000"+
		"\u012f\u0130\u0005m\u0000\u0000\u0130\u014f\u0005k\u0000\u0000\u0131\u0132"+
		"\u0005b\u0000\u0000\u0132\u0136\u0005.\u0000\u0000\u0133\u0135\u0003\u0018"+
		"\f\u0000\u0134\u0133\u0001\u0000\u0000\u0000\u0135\u0138\u0001\u0000\u0000"+
		"\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000"+
		"\u0000\u0137\u0139\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000"+
		"\u0000\u0139\u014f\u0005k\u0000\u0000\u013a\u013b\u0005b\u0000\u0000\u013b"+
		"\u013f\u0005/\u0000\u0000\u013c\u013e\u0003\u0018\f\u0000\u013d\u013c"+
		"\u0001\u0000\u0000\u0000\u013e\u0141\u0001\u0000\u0000\u0000\u013f\u013d"+
		"\u0001\u0000\u0000\u0000\u013f\u0140\u0001\u0000\u0000\u0000\u0140\u0142"+
		"\u0001\u0000\u0000\u0000\u0141\u013f\u0001\u0000\u0000\u0000\u0142\u014f"+
		"\u0005k\u0000\u0000\u0143\u0144\u0005b\u0000\u0000\u0144\u0148\u00050"+
		"\u0000\u0000\u0145\u0147\u0003\u0018\f\u0000\u0146\u0145\u0001\u0000\u0000"+
		"\u0000\u0147\u014a\u0001\u0000\u0000\u0000\u0148\u0146\u0001\u0000\u0000"+
		"\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u014b\u0001\u0000\u0000"+
		"\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014b\u014f\u0005k\u0000\u0000"+
		"\u014c\u014d\u0005b\u0000\u0000\u014d\u014f\u0005k\u0000\u0000\u014e\u00eb"+
		"\u0001\u0000\u0000\u0000\u014e\u00f4\u0001\u0000\u0000\u0000\u014e\u00fe"+
		"\u0001\u0000\u0000\u0000\u014e\u010e\u0001\u0000\u0000\u0000\u014e\u011c"+
		"\u0001\u0000\u0000\u0000\u014e\u012d\u0001\u0000\u0000\u0000\u014e\u0131"+
		"\u0001\u0000\u0000\u0000\u014e\u013a\u0001\u0000\u0000\u0000\u014e\u0143"+
		"\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000\u014f\u0013"+
		"\u0001\u0000\u0000\u0000\u0150\u0152\u0003\u0018\f\u0000\u0151\u0150\u0001"+
		"\u0000\u0000\u0000\u0152\u0155\u0001\u0000\u0000\u0000\u0153\u0151\u0001"+
		"\u0000\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000\u0154\u0156\u0001"+
		"\u0000\u0000\u0000\u0155\u0153\u0001\u0000\u0000\u0000\u0156\u0157\u0005"+
		"k\u0000\u0000\u0157\u0015\u0001\u0000\u0000\u0000\u0158\u015a\u0003\u0018"+
		"\f\u0000\u0159\u0158\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000\u0000"+
		"\u0000\u015b\u0159\u0001\u0000\u0000\u0000\u015b\u015c\u0001\u0000\u0000"+
		"\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d\u015e\u0005k\u0000\u0000"+
		"\u015e\u0017\u0001\u0000\u0000\u0000\u015f\u0167\u0005q\u0000\u0000\u0160"+
		"\u0167\u0005m\u0000\u0000\u0161\u0167\u0005l\u0000\u0000\u0162\u0167\u0005"+
		"o\u0000\u0000\u0163\u0167\u0005p\u0000\u0000\u0164\u0167\u0003\u001a\r"+
		"\u0000\u0165\u0167\u0003\u001c\u000e\u0000\u0166\u015f\u0001\u0000\u0000"+
		"\u0000\u0166\u0160\u0001\u0000\u0000\u0000\u0166\u0161\u0001\u0000\u0000"+
		"\u0000\u0166\u0162\u0001\u0000\u0000\u0000\u0166\u0163\u0001\u0000\u0000"+
		"\u0000\u0166\u0164\u0001\u0000\u0000\u0000\u0166\u0165\u0001\u0000\u0000"+
		"\u0000\u0167\u0019\u0001\u0000\u0000\u0000\u0168\u0169\u0007\u0000\u0000"+
		"\u0000\u0169\u001b\u0001\u0000\u0000\u0000\u016a\u016b\u0007\u0001\u0000"+
		"\u0000\u016b\u001d\u0001\u0000\u0000\u0000\u016c\u0174\u0005m\u0000\u0000"+
		"\u016d\u0174\u0005n\u0000\u0000\u016e\u0174\u0005p\u0000\u0000\u016f\u0170"+
		"\u0005e\u0000\u0000\u0170\u0171\u0003@ \u0000\u0171\u0172\u0005f\u0000"+
		"\u0000\u0172\u0174\u0001\u0000\u0000\u0000\u0173\u016c\u0001\u0000\u0000"+
		"\u0000\u0173\u016d\u0001\u0000\u0000\u0000\u0173\u016e\u0001\u0000\u0000"+
		"\u0000\u0173\u016f\u0001\u0000\u0000\u0000\u0174\u001f\u0001\u0000\u0000"+
		"\u0000\u0175\u0176\u0006\u0010\uffff\uffff\u0000\u0176\u0182\u0003\u001e"+
		"\u000f\u0000\u0177\u0178\u0005e\u0000\u0000\u0178\u0179\u0003v;\u0000"+
		"\u0179\u017a\u0005f\u0000\u0000\u017a\u017b\u0005g\u0000\u0000\u017b\u017d"+
		"\u0003\u0080@\u0000\u017c\u017e\u0005a\u0000\u0000\u017d\u017c\u0001\u0000"+
		"\u0000\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e\u017f\u0001\u0000"+
		"\u0000\u0000\u017f\u0180\u0005h\u0000\u0000\u0180\u0182\u0001\u0000\u0000"+
		"\u0000\u0181\u0175\u0001\u0000\u0000\u0000\u0181\u0177\u0001\u0000\u0000"+
		"\u0000\u0182\u019a\u0001\u0000\u0000\u0000\u0183\u0184\n\u0007\u0000\u0000"+
		"\u0184\u0185\u0005c\u0000\u0000\u0185\u0186\u0003@ \u0000\u0186\u0187"+
		"\u0005d\u0000\u0000\u0187\u0199\u0001\u0000\u0000\u0000\u0188\u0189\n"+
		"\u0006\u0000\u0000\u0189\u018b\u0005e\u0000\u0000\u018a\u018c\u0003\""+
		"\u0011\u0000\u018b\u018a\u0001\u0000\u0000\u0000\u018b\u018c\u0001\u0000"+
		"\u0000\u0000\u018c\u018d\u0001\u0000\u0000\u0000\u018d\u0199\u0005f\u0000"+
		"\u0000\u018e\u018f\n\u0005\u0000\u0000\u018f\u0190\u0005^\u0000\u0000"+
		"\u0190\u0199\u0005m\u0000\u0000\u0191\u0192\n\u0004\u0000\u0000\u0192"+
		"\u0193\u00053\u0000\u0000\u0193\u0199\u0005m\u0000\u0000\u0194\u0195\n"+
		"\u0003\u0000\u0000\u0195\u0199\u00054\u0000\u0000\u0196\u0197\n\u0002"+
		"\u0000\u0000\u0197\u0199\u00055\u0000\u0000\u0198\u0183\u0001\u0000\u0000"+
		"\u0000\u0198\u0188\u0001\u0000\u0000\u0000\u0198\u018e\u0001\u0000\u0000"+
		"\u0000\u0198\u0191\u0001\u0000\u0000\u0000\u0198\u0194\u0001\u0000\u0000"+
		"\u0000\u0198\u0196\u0001\u0000\u0000\u0000\u0199\u019c\u0001\u0000\u0000"+
		"\u0000\u019a\u0198\u0001\u0000\u0000\u0000\u019a\u019b\u0001\u0000\u0000"+
		"\u0000\u019b!\u0001\u0000\u0000\u0000\u019c\u019a\u0001\u0000\u0000\u0000"+
		"\u019d\u01a2\u0003>\u001f\u0000\u019e\u019f\u0005a\u0000\u0000\u019f\u01a1"+
		"\u0003>\u001f\u0000\u01a0\u019e\u0001\u0000\u0000\u0000\u01a1\u01a4\u0001"+
		"\u0000\u0000\u0000\u01a2\u01a0\u0001\u0000\u0000\u0000\u01a2\u01a3\u0001"+
		"\u0000\u0000\u0000\u01a3#\u0001\u0000\u0000\u0000\u01a4\u01a2\u0001\u0000"+
		"\u0000\u0000\u01a5\u01b4\u0003 \u0010\u0000\u01a6\u01a7\u00054\u0000\u0000"+
		"\u01a7\u01b4\u0003$\u0012\u0000\u01a8\u01a9\u00055\u0000\u0000\u01a9\u01b4"+
		"\u0003$\u0012\u0000\u01aa\u01ab\u0007\u0002\u0000\u0000\u01ab\u01b4\u0003"+
		"&\u0013\u0000\u01ac\u01ad\u0005\u0019\u0000\u0000\u01ad\u01b4\u0003$\u0012"+
		"\u0000\u01ae\u01af\u0005\u0019\u0000\u0000\u01af\u01b0\u0005e\u0000\u0000"+
		"\u01b0\u01b1\u0003v;\u0000\u01b1\u01b2\u0005f\u0000\u0000\u01b2\u01b4"+
		"\u0001\u0000\u0000\u0000\u01b3\u01a5\u0001\u0000\u0000\u0000\u01b3\u01a6"+
		"\u0001\u0000\u0000\u0000\u01b3\u01a8\u0001\u0000\u0000\u0000\u01b3\u01aa"+
		"\u0001\u0000\u0000\u0000\u01b3\u01ac\u0001\u0000\u0000\u0000\u01b3\u01ae"+
		"\u0001\u0000\u0000\u0000\u01b4%\u0001\u0000\u0000\u0000\u01b5\u01bc\u0003"+
		"$\u0012\u0000\u01b6\u01b7\u0005e\u0000\u0000\u01b7\u01b8\u0003v;\u0000"+
		"\u01b8\u01b9\u0005f\u0000\u0000\u01b9\u01ba\u0003&\u0013\u0000\u01ba\u01bc"+
		"\u0001\u0000\u0000\u0000\u01bb\u01b5\u0001\u0000\u0000\u0000\u01bb\u01b6"+
		"\u0001\u0000\u0000\u0000\u01bc\'\u0001\u0000\u0000\u0000\u01bd\u01be\u0006"+
		"\u0014\uffff\uffff\u0000\u01be\u01bf\u0003&\u0013\u0000\u01bf\u01c5\u0001"+
		"\u0000\u0000\u0000\u01c0\u01c1\n\u0001\u0000\u0000\u01c1\u01c2\u0007\u0003"+
		"\u0000\u0000\u01c2\u01c4\u0003&\u0013\u0000\u01c3\u01c0\u0001\u0000\u0000"+
		"\u0000\u01c4\u01c7\u0001\u0000\u0000\u0000\u01c5\u01c3\u0001\u0000\u0000"+
		"\u0000\u01c5\u01c6\u0001\u0000\u0000\u0000\u01c6)\u0001\u0000\u0000\u0000"+
		"\u01c7\u01c5\u0001\u0000\u0000\u0000\u01c8\u01c9\u0006\u0015\uffff\uffff"+
		"\u0000\u01c9\u01ca\u0003(\u0014\u0000\u01ca\u01d0\u0001\u0000\u0000\u0000"+
		"\u01cb\u01cc\n\u0001\u0000\u0000\u01cc\u01cd\u0007\u0004\u0000\u0000\u01cd"+
		"\u01cf\u0003(\u0014\u0000\u01ce\u01cb\u0001\u0000\u0000\u0000\u01cf\u01d2"+
		"\u0001\u0000\u0000\u0000\u01d0\u01ce\u0001\u0000\u0000\u0000\u01d0\u01d1"+
		"\u0001\u0000\u0000\u0000\u01d1+\u0001\u0000\u0000\u0000\u01d2\u01d0\u0001"+
		"\u0000\u0000\u0000\u01d3\u01d4\u0006\u0016\uffff\uffff\u0000\u01d4\u01d5"+
		"\u0003*\u0015\u0000\u01d5\u01db\u0001\u0000\u0000\u0000\u01d6\u01d7\n"+
		"\u0001\u0000\u0000\u01d7\u01d8\u0007\u0005\u0000\u0000\u01d8\u01da\u0003"+
		"*\u0015\u0000\u01d9\u01d6\u0001\u0000\u0000\u0000\u01da\u01dd\u0001\u0000"+
		"\u0000\u0000\u01db\u01d9\u0001\u0000\u0000\u0000\u01db\u01dc\u0001\u0000"+
		"\u0000\u0000\u01dc-\u0001\u0000\u0000\u0000\u01dd\u01db\u0001\u0000\u0000"+
		"\u0000\u01de\u01df\u0006\u0017\uffff\uffff\u0000\u01df\u01e0\u0003,\u0016"+
		"\u0000\u01e0\u01e6\u0001\u0000\u0000\u0000\u01e1\u01e2\n\u0001\u0000\u0000"+
		"\u01e2\u01e3\u0007\u0006\u0000\u0000\u01e3\u01e5\u0003,\u0016\u0000\u01e4"+
		"\u01e1\u0001\u0000\u0000\u0000\u01e5\u01e8\u0001\u0000\u0000\u0000\u01e6"+
		"\u01e4\u0001\u0000\u0000\u0000\u01e6\u01e7\u0001\u0000\u0000\u0000\u01e7"+
		"/\u0001\u0000\u0000\u0000\u01e8\u01e6\u0001\u0000\u0000\u0000\u01e9\u01ea"+
		"\u0006\u0018\uffff\uffff\u0000\u01ea\u01eb\u0003.\u0017\u0000\u01eb\u01f1"+
		"\u0001\u0000\u0000\u0000\u01ec\u01ed\n\u0001\u0000\u0000\u01ed\u01ee\u0007"+
		"\u0007\u0000\u0000\u01ee\u01f0\u0003.\u0017\u0000\u01ef\u01ec\u0001\u0000"+
		"\u0000\u0000\u01f0\u01f3\u0001\u0000\u0000\u0000\u01f1\u01ef\u0001\u0000"+
		"\u0000\u0000\u01f1\u01f2\u0001\u0000\u0000\u0000\u01f21\u0001\u0000\u0000"+
		"\u0000\u01f3\u01f1\u0001\u0000\u0000\u0000\u01f4\u01f5\u0006\u0019\uffff"+
		"\uffff\u0000\u01f5\u01f6\u00030\u0018\u0000\u01f6\u01fc\u0001\u0000\u0000"+
		"\u0000\u01f7\u01f8\n\u0001\u0000\u0000\u01f8\u01f9\u0005R\u0000\u0000"+
		"\u01f9\u01fb\u00030\u0018\u0000\u01fa\u01f7\u0001\u0000\u0000\u0000\u01fb"+
		"\u01fe\u0001\u0000\u0000\u0000\u01fc\u01fa\u0001\u0000\u0000\u0000\u01fc"+
		"\u01fd\u0001\u0000\u0000\u0000\u01fd3\u0001\u0000\u0000\u0000\u01fe\u01fc"+
		"\u0001\u0000\u0000\u0000\u01ff\u0200\u0006\u001a\uffff\uffff\u0000\u0200"+
		"\u0201\u00032\u0019\u0000\u0201\u0207\u0001\u0000\u0000\u0000\u0202\u0203"+
		"\n\u0001\u0000\u0000\u0203\u0204\u0005Z\u0000\u0000\u0204\u0206\u0003"+
		"2\u0019\u0000\u0205\u0202\u0001\u0000\u0000\u0000\u0206\u0209\u0001\u0000"+
		"\u0000\u0000\u0207\u0205\u0001\u0000\u0000\u0000\u0207\u0208\u0001\u0000"+
		"\u0000\u0000\u02085\u0001\u0000\u0000\u0000\u0209\u0207\u0001\u0000\u0000"+
		"\u0000\u020a\u020b\u0006\u001b\uffff\uffff\u0000\u020b\u020c\u00034\u001a"+
		"\u0000\u020c\u0212\u0001\u0000\u0000\u0000\u020d\u020e\n\u0001\u0000\u0000"+
		"\u020e\u020f\u0005[\u0000\u0000\u020f\u0211\u00034\u001a\u0000\u0210\u020d"+
		"\u0001\u0000\u0000\u0000\u0211\u0214\u0001\u0000\u0000\u0000\u0212\u0210"+
		"\u0001\u0000\u0000\u0000\u0212\u0213\u0001\u0000\u0000\u0000\u02137\u0001"+
		"\u0000\u0000\u0000\u0214\u0212\u0001\u0000\u0000\u0000\u0215\u0216\u0006"+
		"\u001c\uffff\uffff\u0000\u0216\u0217\u00036\u001b\u0000\u0217\u021d\u0001"+
		"\u0000\u0000\u0000\u0218\u0219\n\u0001\u0000\u0000\u0219\u021a\u0005>"+
		"\u0000\u0000\u021a\u021c\u00036\u001b\u0000\u021b\u0218\u0001\u0000\u0000"+
		"\u0000\u021c\u021f\u0001\u0000\u0000\u0000\u021d\u021b\u0001\u0000\u0000"+
		"\u0000\u021d\u021e\u0001\u0000\u0000\u0000\u021e9\u0001\u0000\u0000\u0000"+
		"\u021f\u021d\u0001\u0000\u0000\u0000\u0220\u0221\u0006\u001d\uffff\uffff"+
		"\u0000\u0221\u0222\u00038\u001c\u0000\u0222\u0228\u0001\u0000\u0000\u0000"+
		"\u0223\u0224\n\u0001\u0000\u0000\u0224\u0225\u0005?\u0000\u0000\u0225"+
		"\u0227\u00038\u001c\u0000\u0226\u0223\u0001\u0000\u0000\u0000\u0227\u022a"+
		"\u0001\u0000\u0000\u0000\u0228\u0226\u0001\u0000\u0000\u0000\u0228\u0229"+
		"\u0001\u0000\u0000\u0000\u0229;\u0001\u0000\u0000\u0000\u022a\u0228\u0001"+
		"\u0000\u0000\u0000\u022b\u0233\u0003:\u001d\u0000\u022c\u022d\u0003:\u001d"+
		"\u0000\u022d\u022e\u0005_\u0000\u0000\u022e\u022f\u0003@ \u0000\u022f"+
		"\u0230\u0005\\\u0000\u0000\u0230\u0231\u0003<\u001e\u0000\u0231\u0233"+
		"\u0001\u0000\u0000\u0000\u0232\u022b\u0001\u0000\u0000\u0000\u0232\u022c"+
		"\u0001\u0000\u0000\u0000\u0233=\u0001\u0000\u0000\u0000\u0234\u023a\u0003"+
		"<\u001e\u0000\u0235\u0236\u0003$\u0012\u0000\u0236\u0237\u0007\b\u0000"+
		"\u0000\u0237\u0238\u0003>\u001f\u0000\u0238\u023a\u0001\u0000\u0000\u0000"+
		"\u0239\u0234\u0001\u0000\u0000\u0000\u0239\u0235\u0001\u0000\u0000\u0000"+
		"\u023a?\u0001\u0000\u0000\u0000\u023b\u0240\u0003>\u001f\u0000\u023c\u023d"+
		"\u0005a\u0000\u0000\u023d\u023f\u0003>\u001f\u0000\u023e\u023c\u0001\u0000"+
		"\u0000\u0000\u023f\u0242\u0001\u0000\u0000\u0000\u0240\u023e\u0001\u0000"+
		"\u0000\u0000\u0240\u0241\u0001\u0000\u0000\u0000\u0241A\u0001\u0000\u0000"+
		"\u0000\u0242\u0240\u0001\u0000\u0000\u0000\u0243\u0244\u0003<\u001e\u0000"+
		"\u0244C\u0001\u0000\u0000\u0000\u0245\u0247\u0003F#\u0000\u0246\u0248"+
		"\u0003L&\u0000\u0247\u0246\u0001\u0000\u0000\u0000\u0247\u0248\u0001\u0000"+
		"\u0000\u0000\u0248\u0249\u0001\u0000\u0000\u0000\u0249\u024a\u0005]\u0000"+
		"\u0000\u024aE\u0001\u0000\u0000\u0000\u024b\u0250\u0003H$\u0000\u024c"+
		"\u0250\u0003P(\u0000\u024d\u0250\u0003d2\u0000\u024e\u0250\u0003J%\u0000"+
		"\u024f\u024b\u0001\u0000\u0000\u0000\u024f\u024c\u0001\u0000\u0000\u0000"+
		"\u024f\u024d\u0001\u0000\u0000\u0000\u024f\u024e\u0001\u0000\u0000\u0000"+
		"\u0250\u0251\u0001\u0000\u0000\u0000\u0251\u0252\u0001\u0000\u0000\u0000"+
		"\u0251\u024f\u0001\u0000\u0000\u0000\u0252G\u0001\u0000\u0000\u0000\u0253"+
		"\u0254\u0007\t\u0000\u0000\u0254I\u0001\u0000\u0000\u0000\u0255\u0256"+
		"\u0005\u0011\u0000\u0000\u0256K\u0001\u0000\u0000\u0000\u0257\u025c\u0003"+
		"N\'\u0000\u0258\u0259\u0005a\u0000\u0000\u0259\u025b\u0003N\'\u0000\u025a"+
		"\u0258\u0001\u0000\u0000\u0000\u025b\u025e\u0001\u0000\u0000\u0000\u025c"+
		"\u025a\u0001\u0000\u0000\u0000\u025c\u025d\u0001\u0000\u0000\u0000\u025d"+
		"M\u0001\u0000\u0000\u0000\u025e\u025c\u0001\u0000\u0000\u0000\u025f\u0262"+
		"\u0003f3\u0000\u0260\u0261\u0005`\u0000\u0000\u0261\u0263\u0003~?\u0000"+
		"\u0262\u0260\u0001\u0000\u0000\u0000\u0262\u0263\u0001\u0000\u0000\u0000"+
		"\u0263O\u0001\u0000\u0000\u0000\u0264\u0269\u0007\n\u0000\u0000\u0265"+
		"\u0269\u0003R)\u0000\u0266\u0269\u0003^/\u0000\u0267\u0269\u0003|>\u0000"+
		"\u0268\u0264\u0001\u0000\u0000\u0000\u0268\u0265\u0001\u0000\u0000\u0000"+
		"\u0268\u0266\u0001\u0000\u0000\u0000\u0268\u0267\u0001\u0000\u0000\u0000"+
		"\u0269Q\u0001\u0000\u0000\u0000\u026a\u026c\u0007\u000b\u0000\u0000\u026b"+
		"\u026d\u0005m\u0000\u0000\u026c\u026b\u0001\u0000\u0000\u0000\u026c\u026d"+
		"\u0001\u0000\u0000\u0000\u026d\u026e\u0001\u0000\u0000\u0000\u026e\u026f"+
		"\u0005g\u0000\u0000\u026f\u0270\u0003T*\u0000\u0270\u0271\u0005h\u0000"+
		"\u0000\u0271\u0275\u0001\u0000\u0000\u0000\u0272\u0273\u0007\u000b\u0000"+
		"\u0000\u0273\u0275\u0005m\u0000\u0000\u0274\u026a\u0001\u0000\u0000\u0000"+
		"\u0274\u0272\u0001\u0000\u0000\u0000\u0275S\u0001\u0000\u0000\u0000\u0276"+
		"\u0278\u0003V+\u0000\u0277\u0276\u0001\u0000\u0000\u0000\u0278\u0279\u0001"+
		"\u0000\u0000\u0000\u0279\u0277\u0001\u0000\u0000\u0000\u0279\u027a\u0001"+
		"\u0000\u0000\u0000\u027aU\u0001\u0000\u0000\u0000\u027b\u027c\u0003X,"+
		"\u0000\u027c\u027d\u0003Z-\u0000\u027d\u027e\u0005]\u0000\u0000\u027e"+
		"W\u0001\u0000\u0000\u0000\u027f\u0282\u0003P(\u0000\u0280\u0282\u0003"+
		"d2\u0000\u0281\u027f\u0001\u0000\u0000\u0000\u0281\u0280\u0001\u0000\u0000"+
		"\u0000\u0282\u0284\u0001\u0000\u0000\u0000\u0283\u0285\u0003X,\u0000\u0284"+
		"\u0283\u0001\u0000\u0000\u0000\u0284\u0285\u0001\u0000\u0000\u0000\u0285"+
		"Y\u0001\u0000\u0000\u0000\u0286\u028b\u0003\\.\u0000\u0287\u0288\u0005"+
		"a\u0000\u0000\u0288\u028a\u0003\\.\u0000\u0289\u0287\u0001\u0000\u0000"+
		"\u0000\u028a\u028d\u0001\u0000\u0000\u0000\u028b\u0289\u0001\u0000\u0000"+
		"\u0000\u028b\u028c\u0001\u0000\u0000\u0000\u028c[\u0001\u0000\u0000\u0000"+
		"\u028d\u028b\u0001\u0000\u0000\u0000\u028e\u0295\u0003f3\u0000\u028f\u0291"+
		"\u0003f3\u0000\u0290\u028f\u0001\u0000\u0000\u0000\u0290\u0291\u0001\u0000"+
		"\u0000\u0000\u0291\u0292\u0001\u0000\u0000\u0000\u0292\u0293\u0005\\\u0000"+
		"\u0000\u0293\u0295\u0003B!\u0000\u0294\u028e\u0001\u0000\u0000\u0000\u0294"+
		"\u0290\u0001\u0000\u0000\u0000\u0295]\u0001\u0000\u0000\u0000\u0296\u0298"+
		"\u0005\u000b\u0000\u0000\u0297\u0299\u0005m\u0000\u0000\u0298\u0297\u0001"+
		"\u0000\u0000\u0000\u0298\u0299\u0001\u0000\u0000\u0000\u0299\u029a\u0001"+
		"\u0000\u0000\u0000\u029a\u029b\u0005c\u0000\u0000\u029b\u029d\u0003`0"+
		"\u0000\u029c\u029e\u0005a\u0000\u0000\u029d\u029c\u0001\u0000\u0000\u0000"+
		"\u029d\u029e\u0001\u0000\u0000\u0000\u029e\u029f\u0001\u0000\u0000\u0000"+
		"\u029f\u02a0\u0005h\u0000\u0000\u02a0\u02a4\u0001\u0000\u0000\u0000\u02a1"+
		"\u02a2\u0005\u000b\u0000\u0000\u02a2\u02a4\u0005m\u0000\u0000\u02a3\u0296"+
		"\u0001\u0000\u0000\u0000\u02a3\u02a1\u0001\u0000\u0000\u0000\u02a4_\u0001"+
		"\u0000\u0000\u0000\u02a5\u02aa\u0003b1\u0000\u02a6\u02a7\u0005a\u0000"+
		"\u0000\u02a7\u02a9\u0003b1\u0000\u02a8\u02a6\u0001\u0000\u0000\u0000\u02a9"+
		"\u02ac\u0001\u0000\u0000\u0000\u02aa\u02a8\u0001\u0000\u0000\u0000\u02aa"+
		"\u02ab\u0001\u0000\u0000\u0000\u02aba\u0001\u0000\u0000\u0000\u02ac\u02aa"+
		"\u0001\u0000\u0000\u0000\u02ad\u02b0\u0005m\u0000\u0000\u02ae\u02af\u0005"+
		"`\u0000\u0000\u02af\u02b1\u0003B!\u0000\u02b0\u02ae\u0001\u0000\u0000"+
		"\u0000\u02b0\u02b1\u0001\u0000\u0000\u0000\u02b1c\u0001\u0000\u0000\u0000"+
		"\u02b2\u02b3\u0007\f\u0000\u0000\u02b3e\u0001\u0000\u0000\u0000\u02b4"+
		"\u02b6\u0003j5\u0000\u02b5\u02b4\u0001\u0000\u0000\u0000\u02b5\u02b6\u0001"+
		"\u0000\u0000\u0000\u02b6\u02b7\u0001\u0000\u0000\u0000\u02b7\u02b8\u0003"+
		"h4\u0000\u02b8g\u0001\u0000\u0000\u0000\u02b9\u02ba\u00064\uffff\uffff"+
		"\u0000\u02ba\u02c0\u0005m\u0000\u0000\u02bb\u02bc\u0005e\u0000\u0000\u02bc"+
		"\u02bd\u0003f3\u0000\u02bd\u02be\u0005f\u0000\u0000\u02be\u02c0\u0001"+
		"\u0000\u0000\u0000\u02bf\u02b9\u0001\u0000\u0000\u0000\u02bf\u02bb\u0001"+
		"\u0000\u0000\u0000\u02c0\u02ee\u0001\u0000\u0000\u0000\u02c1\u02c2\n\u0006"+
		"\u0000\u0000\u02c2\u02c4\u0005c\u0000\u0000\u02c3\u02c5\u0003l6\u0000"+
		"\u02c4\u02c3\u0001\u0000\u0000\u0000\u02c4\u02c5\u0001\u0000\u0000\u0000"+
		"\u02c5\u02c7\u0001\u0000\u0000\u0000\u02c6\u02c8\u0003>\u001f\u0000\u02c7"+
		"\u02c6\u0001\u0000\u0000\u0000\u02c7\u02c8\u0001\u0000\u0000\u0000\u02c8"+
		"\u02c9\u0001\u0000\u0000\u0000\u02c9\u02ed\u0005d\u0000\u0000\u02ca\u02cb"+
		"\n\u0005\u0000\u0000\u02cb\u02cc\u0005c\u0000\u0000\u02cc\u02ce\u0005"+
		"\u001a\u0000\u0000\u02cd\u02cf\u0003l6\u0000\u02ce\u02cd\u0001\u0000\u0000"+
		"\u0000\u02ce\u02cf\u0001\u0000\u0000\u0000\u02cf\u02d0\u0001\u0000\u0000"+
		"\u0000\u02d0\u02d1\u0003>\u001f\u0000\u02d1\u02d2\u0005d\u0000\u0000\u02d2"+
		"\u02ed\u0001\u0000\u0000\u0000\u02d3\u02d4\n\u0004\u0000\u0000\u02d4\u02d5"+
		"\u0005c\u0000\u0000\u02d5\u02d6\u0003l6\u0000\u02d6\u02d7\u0005\u001a"+
		"\u0000\u0000\u02d7\u02d8\u0003>\u001f\u0000\u02d8\u02d9\u0005d\u0000\u0000"+
		"\u02d9\u02ed\u0001\u0000\u0000\u0000\u02da\u02db\n\u0003\u0000\u0000\u02db"+
		"\u02dd\u0005c\u0000\u0000\u02dc\u02de\u0003l6\u0000\u02dd\u02dc\u0001"+
		"\u0000\u0000\u0000\u02dd\u02de\u0001\u0000\u0000\u0000\u02de\u02df\u0001"+
		"\u0000\u0000\u0000\u02df\u02e0\u0005S\u0000\u0000\u02e0\u02ed\u0005d\u0000"+
		"\u0000\u02e1\u02e2\n\u0002\u0000\u0000\u02e2\u02e3\u0005e\u0000\u0000"+
		"\u02e3\u02e4\u0003n7\u0000\u02e4\u02e5\u0005f\u0000\u0000\u02e5\u02ed"+
		"\u0001\u0000\u0000\u0000\u02e6\u02e7\n\u0001\u0000\u0000\u02e7\u02e9\u0005"+
		"e\u0000\u0000\u02e8\u02ea\u0003t:\u0000\u02e9\u02e8\u0001\u0000\u0000"+
		"\u0000\u02e9\u02ea\u0001\u0000\u0000\u0000\u02ea\u02eb\u0001\u0000\u0000"+
		"\u0000\u02eb\u02ed\u0005f\u0000\u0000\u02ec\u02c1\u0001\u0000\u0000\u0000"+
		"\u02ec\u02ca\u0001\u0000\u0000\u0000\u02ec\u02d3\u0001\u0000\u0000\u0000"+
		"\u02ec\u02da\u0001\u0000\u0000\u0000\u02ec\u02e1\u0001\u0000\u0000\u0000"+
		"\u02ec\u02e6\u0001\u0000\u0000\u0000\u02ed\u02f0\u0001\u0000\u0000\u0000"+
		"\u02ee\u02ec\u0001\u0000\u0000\u0000\u02ee\u02ef\u0001\u0000\u0000\u0000"+
		"\u02efi\u0001\u0000\u0000\u0000\u02f0\u02ee\u0001\u0000\u0000\u0000\u02f1"+
		"\u02f3\u0005S\u0000\u0000\u02f2\u02f4\u0003l6\u0000\u02f3\u02f2\u0001"+
		"\u0000\u0000\u0000\u02f3\u02f4\u0001\u0000\u0000\u0000\u02f4\u02f6\u0001"+
		"\u0000\u0000\u0000\u02f5\u02f1\u0001\u0000\u0000\u0000\u02f6\u02f7\u0001"+
		"\u0000\u0000\u0000\u02f7\u02f5\u0001\u0000\u0000\u0000\u02f7\u02f8\u0001"+
		"\u0000\u0000\u0000\u02f8k\u0001\u0000\u0000\u0000\u02f9\u02fb\u0003d2"+
		"\u0000\u02fa\u02f9\u0001\u0000\u0000\u0000\u02fb\u02fc\u0001\u0000\u0000"+
		"\u0000\u02fc\u02fa\u0001\u0000\u0000\u0000\u02fc\u02fd\u0001\u0000\u0000"+
		"\u0000\u02fdm\u0001\u0000\u0000\u0000\u02fe\u0301\u0003p8\u0000\u02ff"+
		"\u0300\u0005a\u0000\u0000\u0300\u0302\u00052\u0000\u0000\u0301\u02ff\u0001"+
		"\u0000\u0000\u0000\u0301\u0302\u0001\u0000\u0000\u0000\u0302o\u0001\u0000"+
		"\u0000\u0000\u0303\u0308\u0003r9\u0000\u0304\u0305\u0005a\u0000\u0000"+
		"\u0305\u0307\u0003r9\u0000\u0306\u0304\u0001\u0000\u0000\u0000\u0307\u030a"+
		"\u0001\u0000\u0000\u0000\u0308\u0306\u0001\u0000\u0000\u0000\u0308\u0309"+
		"\u0001\u0000\u0000\u0000\u0309q\u0001\u0000\u0000\u0000\u030a\u0308\u0001"+
		"\u0000\u0000\u0000\u030b\u0310\u0003F#\u0000\u030c\u0311\u0003f3\u0000"+
		"\u030d\u030f\u0003x<\u0000\u030e\u030d\u0001\u0000\u0000\u0000\u030e\u030f"+
		"\u0001\u0000\u0000\u0000\u030f\u0311\u0001\u0000\u0000\u0000\u0310\u030c"+
		"\u0001\u0000\u0000\u0000\u0310\u030e\u0001\u0000\u0000\u0000\u0311s\u0001"+
		"\u0000\u0000\u0000\u0312\u0317\u0005m\u0000\u0000\u0313\u0314\u0005a\u0000"+
		"\u0000\u0314\u0316\u0005m\u0000\u0000\u0315\u0313\u0001\u0000\u0000\u0000"+
		"\u0316\u0319\u0001\u0000\u0000\u0000\u0317\u0315\u0001\u0000\u0000\u0000"+
		"\u0317\u0318\u0001\u0000\u0000\u0000\u0318u\u0001\u0000\u0000\u0000\u0319"+
		"\u0317\u0001\u0000\u0000\u0000\u031a\u031c\u0003X,\u0000\u031b\u031d\u0003"+
		"x<\u0000\u031c\u031b\u0001\u0000\u0000\u0000\u031c\u031d\u0001\u0000\u0000"+
		"\u0000\u031dw\u0001\u0000\u0000\u0000\u031e\u0324\u0003j5\u0000\u031f"+
		"\u0321\u0003j5\u0000\u0320\u031f\u0001\u0000\u0000\u0000\u0320\u0321\u0001"+
		"\u0000\u0000\u0000\u0321\u0322\u0001\u0000\u0000\u0000\u0322\u0324\u0003"+
		"z=\u0000\u0323\u031e\u0001\u0000\u0000\u0000\u0323\u0320\u0001\u0000\u0000"+
		"\u0000\u0324y\u0001\u0000\u0000\u0000\u0325\u0326\u0006=\uffff\uffff\u0000"+
		"\u0326\u0327\u0005e\u0000\u0000\u0327\u0328\u0003f3\u0000\u0328\u0329"+
		"\u0005f\u0000\u0000\u0329\u0357\u0001\u0000\u0000\u0000\u032a\u032b\n"+
		"\u0006\u0000\u0000\u032b\u032d\u0005c\u0000\u0000\u032c\u032e\u0003l6"+
		"\u0000\u032d\u032c\u0001\u0000\u0000\u0000\u032d\u032e\u0001\u0000\u0000"+
		"\u0000\u032e\u0330\u0001\u0000\u0000\u0000\u032f\u0331\u0003>\u001f\u0000"+
		"\u0330\u032f\u0001\u0000\u0000\u0000\u0330\u0331\u0001\u0000\u0000\u0000"+
		"\u0331\u0332\u0001\u0000\u0000\u0000\u0332\u0356\u0005d\u0000\u0000\u0333"+
		"\u0334\n\u0005\u0000\u0000\u0334\u0335\u0005c\u0000\u0000\u0335\u0337"+
		"\u0005\u001a\u0000\u0000\u0336\u0338\u0003l6\u0000\u0337\u0336\u0001\u0000"+
		"\u0000\u0000\u0337\u0338\u0001\u0000\u0000\u0000\u0338\u0339\u0001\u0000"+
		"\u0000\u0000\u0339\u033a\u0003>\u001f\u0000\u033a\u033b\u0005d\u0000\u0000"+
		"\u033b\u0356\u0001\u0000\u0000\u0000\u033c\u033d\n\u0004\u0000\u0000\u033d"+
		"\u033e\u0005c\u0000\u0000\u033e\u033f\u0003l6\u0000\u033f\u0340\u0005"+
		"\u001a\u0000\u0000\u0340\u0341\u0003>\u001f\u0000\u0341\u0342\u0005d\u0000"+
		"\u0000\u0342\u0356\u0001\u0000\u0000\u0000\u0343\u0344\n\u0003\u0000\u0000"+
		"\u0344\u0346\u0005c\u0000\u0000\u0345\u0347\u0003l6\u0000\u0346\u0345"+
		"\u0001\u0000\u0000\u0000\u0346\u0347\u0001\u0000\u0000\u0000\u0347\u0348"+
		"\u0001\u0000\u0000\u0000\u0348\u0349\u0005S\u0000\u0000\u0349\u0356\u0005"+
		"d\u0000\u0000\u034a\u034b\n\u0002\u0000\u0000\u034b\u034c\u0005e\u0000"+
		"\u0000\u034c\u034d\u0003n7\u0000\u034d\u034e\u0005f\u0000\u0000\u034e"+
		"\u0356\u0001\u0000\u0000\u0000\u034f\u0350\n\u0001\u0000\u0000\u0350\u0352"+
		"\u0005e\u0000\u0000\u0351\u0353\u0003t:\u0000\u0352\u0351\u0001\u0000"+
		"\u0000\u0000\u0352\u0353\u0001\u0000\u0000\u0000\u0353\u0354\u0001\u0000"+
		"\u0000\u0000\u0354\u0356\u0005f\u0000\u0000\u0355\u032a\u0001\u0000\u0000"+
		"\u0000\u0355\u0333\u0001\u0000\u0000\u0000\u0355\u033c\u0001\u0000\u0000"+
		"\u0000\u0355\u0343\u0001\u0000\u0000\u0000\u0355\u034a\u0001\u0000\u0000"+
		"\u0000\u0355\u034f\u0001\u0000\u0000\u0000\u0356\u0359\u0001\u0000\u0000"+
		"\u0000\u0357\u0355\u0001\u0000\u0000\u0000\u0357\u0358\u0001\u0000\u0000"+
		"\u0000\u0358{\u0001\u0000\u0000\u0000\u0359\u0357\u0001\u0000\u0000\u0000"+
		"\u035a\u035b\u0005m\u0000\u0000\u035b}\u0001\u0000\u0000\u0000\u035c\u0365"+
		"\u0003>\u001f\u0000\u035d\u035e\u0005g\u0000\u0000\u035e\u0360\u0003\u0080"+
		"@\u0000\u035f\u0361\u0005a\u0000\u0000\u0360\u035f\u0001\u0000\u0000\u0000"+
		"\u0360\u0361\u0001\u0000\u0000\u0000\u0361\u0362\u0001\u0000\u0000\u0000"+
		"\u0362\u0363\u0005h\u0000\u0000\u0363\u0365\u0001\u0000\u0000\u0000\u0364"+
		"\u035c\u0001\u0000\u0000\u0000\u0364\u035d\u0001\u0000\u0000\u0000\u0365"+
		"\u007f\u0001\u0000\u0000\u0000\u0366\u0368\u0003\u0082A\u0000\u0367\u0366"+
		"\u0001\u0000\u0000\u0000\u0367\u0368\u0001\u0000\u0000\u0000\u0368\u0369"+
		"\u0001\u0000\u0000\u0000\u0369\u036f\u0003~?\u0000\u036a\u036c\u0005a"+
		"\u0000\u0000\u036b\u036d\u0003\u0082A\u0000\u036c\u036b\u0001\u0000\u0000"+
		"\u0000\u036c\u036d\u0001\u0000\u0000\u0000\u036d\u036e\u0001\u0000\u0000"+
		"\u0000\u036e\u0370\u0003~?\u0000\u036f\u036a\u0001\u0000\u0000\u0000\u0370"+
		"\u0371\u0001\u0000\u0000\u0000\u0371\u036f\u0001\u0000\u0000\u0000\u0371"+
		"\u0372\u0001\u0000\u0000\u0000\u0372\u0081\u0001\u0000\u0000\u0000\u0373"+
		"\u0374\u0003\u0084B\u0000\u0374\u0375\u0005`\u0000\u0000\u0375\u0083\u0001"+
		"\u0000\u0000\u0000\u0376\u0378\u0003\u0086C\u0000\u0377\u0376\u0001\u0000"+
		"\u0000\u0000\u0378\u0379\u0001\u0000\u0000\u0000\u0379\u0377\u0001\u0000"+
		"\u0000\u0000\u0379\u037a\u0001\u0000\u0000\u0000\u037a\u0085\u0001\u0000"+
		"\u0000\u0000\u037b\u037c\u0005c\u0000\u0000\u037c\u037d\u0003B!\u0000"+
		"\u037d\u037e\u0005d\u0000\u0000\u037e\u0382\u0001\u0000\u0000\u0000\u037f"+
		"\u0380\u0005^\u0000\u0000\u0380\u0382\u0005m\u0000\u0000\u0381\u037b\u0001"+
		"\u0000\u0000\u0000\u0381\u037f\u0001\u0000\u0000\u0000\u0382\u0087\u0001"+
		"\u0000\u0000\u0000\u0383\u0384\u0005P\u0000\u0000\u0384\u0385\u0003t:"+
		"\u0000\u0385\u0386\u0005Q\u0000\u0000\u0386\u0089\u0001\u0000\u0000\u0000"+
		"\u0387\u038f\u0003\u009cN\u0000\u0388\u038f\u0003\u008cF\u0000\u0389\u038f"+
		"\u0003\u008eG\u0000\u038a\u038f\u0003\u0094J\u0000\u038b\u038f\u0003\u0096"+
		"K\u0000\u038c\u038f\u0003\u0098L\u0000\u038d\u038f\u0003\u009aM\u0000"+
		"\u038e\u0387\u0001\u0000\u0000\u0000\u038e\u0388\u0001\u0000\u0000\u0000"+
		"\u038e\u0389\u0001\u0000\u0000\u0000\u038e\u038a\u0001\u0000\u0000\u0000"+
		"\u038e\u038b\u0001\u0000\u0000\u0000\u038e\u038c\u0001\u0000\u0000\u0000"+
		"\u038e\u038d\u0001\u0000\u0000\u0000\u038f\u008b\u0001\u0000\u0000\u0000"+
		"\u0390\u0391\u0005m\u0000\u0000\u0391\u0392\u0005\\\u0000\u0000\u0392"+
		"\u039c\u0003\u008aE\u0000\u0393\u0394\u0005\u0003\u0000\u0000\u0394\u0395"+
		"\u0003B!\u0000\u0395\u0396\u0005\\\u0000\u0000\u0396\u0397\u0003\u008a"+
		"E\u0000\u0397\u039c\u0001\u0000\u0000\u0000\u0398\u0399\u0005\u0007\u0000"+
		"\u0000\u0399\u039a\u0005\\\u0000\u0000\u039a\u039c\u0003\u008aE\u0000"+
		"\u039b\u0390\u0001\u0000\u0000\u0000\u039b\u0393\u0001\u0000\u0000\u0000"+
		"\u039b\u0398\u0001\u0000\u0000\u0000\u039c\u008d\u0001\u0000\u0000\u0000"+
		"\u039d\u039f\u0005g\u0000\u0000\u039e\u03a0\u0003\u0090H\u0000\u039f\u039e"+
		"\u0001\u0000\u0000\u0000\u039f\u03a0\u0001\u0000\u0000\u0000\u03a0\u03a1"+
		"\u0001\u0000\u0000\u0000\u03a1\u03a2\u0005h\u0000\u0000\u03a2\u008f\u0001"+
		"\u0000\u0000\u0000\u03a3\u03a5\u0003\u0092I\u0000\u03a4\u03a3\u0001\u0000"+
		"\u0000\u0000\u03a5\u03a6\u0001\u0000\u0000\u0000\u03a6\u03a4\u0001\u0000"+
		"\u0000\u0000\u03a6\u03a7\u0001\u0000\u0000\u0000\u03a7\u0091\u0001\u0000"+
		"\u0000\u0000\u03a8\u03ab\u0003\u008aE\u0000\u03a9\u03ab\u0003D\"\u0000"+
		"\u03aa\u03a8\u0001\u0000\u0000\u0000\u03aa\u03a9\u0001\u0000\u0000\u0000"+
		"\u03ab\u0093\u0001\u0000\u0000\u0000\u03ac\u03ae\u0003@ \u0000\u03ad\u03ac"+
		"\u0001\u0000\u0000\u0000\u03ad\u03ae\u0001\u0000\u0000\u0000\u03ae\u03af"+
		"\u0001\u0000\u0000\u0000\u03af\u03b0\u0005]\u0000\u0000\u03b0\u0095\u0001"+
		"\u0000\u0000\u0000\u03b1\u03b2\u0005\u0010\u0000\u0000\u03b2\u03b3\u0005"+
		"e\u0000\u0000\u03b3\u03b4\u0003@ \u0000\u03b4\u03b5\u0005f\u0000\u0000"+
		"\u03b5\u03b6\u0003\u008aE\u0000\u03b6\u03c6\u0001\u0000\u0000\u0000\u03b7"+
		"\u03b8\u0005\u0010\u0000\u0000\u03b8\u03b9\u0005e\u0000\u0000\u03b9\u03ba"+
		"\u0003@ \u0000\u03ba\u03bb\u0005f\u0000\u0000\u03bb\u03bc\u0003\u008a"+
		"E\u0000\u03bc\u03bd\u0005\n\u0000\u0000\u03bd\u03be\u0003\u008aE\u0000"+
		"\u03be\u03c6\u0001\u0000\u0000\u0000\u03bf\u03c0\u0005\u001c\u0000\u0000"+
		"\u03c0\u03c1\u0005e\u0000\u0000\u03c1\u03c2\u0003@ \u0000\u03c2\u03c3"+
		"\u0005f\u0000\u0000\u03c3\u03c4\u0003\u008aE\u0000\u03c4\u03c6\u0001\u0000"+
		"\u0000\u0000\u03c5\u03b1\u0001\u0000\u0000\u0000\u03c5\u03b7\u0001\u0000"+
		"\u0000\u0000\u03c5\u03bf\u0001\u0000\u0000\u0000\u03c6\u0097\u0001\u0000"+
		"\u0000\u0000\u03c7\u03c8\u0005\"\u0000\u0000\u03c8\u03c9\u0005e\u0000"+
		"\u0000\u03c9\u03ca\u0003@ \u0000\u03ca\u03cb\u0005f\u0000\u0000\u03cb"+
		"\u03cc\u0003\u008aE\u0000\u03cc\u03f2\u0001\u0000\u0000\u0000\u03cd\u03ce"+
		"\u0005\b\u0000\u0000\u03ce\u03cf\u0003\u008aE\u0000\u03cf\u03d0\u0005"+
		"\"\u0000\u0000\u03d0\u03d1\u0005e\u0000\u0000\u03d1\u03d2\u0003@ \u0000"+
		"\u03d2\u03d3\u0005f\u0000\u0000\u03d3\u03d4\u0005]\u0000\u0000\u03d4\u03f2"+
		"\u0001\u0000\u0000\u0000\u03d5\u03d6\u0005\u000e\u0000\u0000\u03d6\u03d8"+
		"\u0005e\u0000\u0000\u03d7\u03d9\u0003@ \u0000\u03d8\u03d7\u0001\u0000"+
		"\u0000\u0000\u03d8\u03d9\u0001\u0000\u0000\u0000\u03d9\u03da\u0001\u0000"+
		"\u0000\u0000\u03da\u03dc\u0005]\u0000\u0000\u03db\u03dd\u0003@ \u0000"+
		"\u03dc\u03db\u0001\u0000\u0000\u0000\u03dc\u03dd\u0001\u0000\u0000\u0000"+
		"\u03dd\u03de\u0001\u0000\u0000\u0000\u03de\u03e0\u0005]\u0000\u0000\u03df"+
		"\u03e1\u0003@ \u0000\u03e0\u03df\u0001\u0000\u0000\u0000\u03e0\u03e1\u0001"+
		"\u0000\u0000\u0000\u03e1\u03e2\u0001\u0000\u0000\u0000\u03e2\u03e3\u0005"+
		"f\u0000\u0000\u03e3\u03f2\u0003\u008aE\u0000\u03e4\u03e5\u0005\u000e\u0000"+
		"\u0000\u03e5\u03e6\u0005e\u0000\u0000\u03e6\u03e8\u0003D\"\u0000\u03e7"+
		"\u03e9\u0003@ \u0000\u03e8\u03e7\u0001\u0000\u0000\u0000\u03e8\u03e9\u0001"+
		"\u0000\u0000\u0000\u03e9\u03ea\u0001\u0000\u0000\u0000\u03ea\u03ec\u0005"+
		"]\u0000\u0000\u03eb\u03ed\u0003@ \u0000\u03ec\u03eb\u0001\u0000\u0000"+
		"\u0000\u03ec\u03ed\u0001\u0000\u0000\u0000\u03ed\u03ee\u0001\u0000\u0000"+
		"\u0000\u03ee\u03ef\u0005f\u0000\u0000\u03ef\u03f0\u0003\u008aE\u0000\u03f0"+
		"\u03f2\u0001\u0000\u0000\u0000\u03f1\u03c7\u0001\u0000\u0000\u0000\u03f1"+
		"\u03cd\u0001\u0000\u0000\u0000\u03f1\u03d5\u0001\u0000\u0000\u0000\u03f1"+
		"\u03e4\u0001\u0000\u0000\u0000\u03f2\u0099\u0001\u0000\u0000\u0000\u03f3"+
		"\u03f4\u0005\u000f\u0000\u0000\u03f4\u03f5\u0005m\u0000\u0000\u03f5\u0400"+
		"\u0005]\u0000\u0000\u03f6\u03f7\u0005\u0006\u0000\u0000\u03f7\u0400\u0005"+
		"]\u0000\u0000\u03f8\u03f9\u0005\u0002\u0000\u0000\u03f9\u0400\u0005]\u0000"+
		"\u0000\u03fa\u03fc\u0005\u0016\u0000\u0000\u03fb\u03fd\u0003@ \u0000\u03fc"+
		"\u03fb\u0001\u0000\u0000\u0000\u03fc\u03fd\u0001\u0000\u0000\u0000\u03fd"+
		"\u03fe\u0001\u0000\u0000\u0000\u03fe\u0400\u0005]\u0000\u0000\u03ff\u03f3"+
		"\u0001\u0000\u0000\u0000\u03ff\u03f6\u0001\u0000\u0000\u0000\u03ff\u03f8"+
		"\u0001\u0000\u0000\u0000\u03ff\u03fa\u0001\u0000\u0000\u0000\u0400\u009b"+
		"\u0001\u0000\u0000\u0000\u0401\u0402\u0005&\u0000\u0000\u0402\u0403\u0005"+
		"e\u0000\u0000\u0403\u0404\u0005p\u0000\u0000\u0404\u0405\u0005f\u0000"+
		"\u0000\u0405\u0406\u0005]\u0000\u0000\u0406\u009d\u0001\u0000\u0000\u0000"+
		"\u0407\u0409\u0003\u00a0P\u0000\u0408\u0407\u0001\u0000\u0000\u0000\u0409"+
		"\u040a\u0001\u0000\u0000\u0000\u040a\u0408\u0001\u0000\u0000\u0000\u040a"+
		"\u040b\u0001\u0000\u0000\u0000\u040b\u009f\u0001\u0000\u0000\u0000\u040c"+
		"\u040f\u0003\u00a2Q\u0000\u040d\u040f\u0003D\"\u0000\u040e\u040c\u0001"+
		"\u0000\u0000\u0000\u040e\u040d\u0001\u0000\u0000\u0000\u040f\u00a1\u0001"+
		"\u0000\u0000\u0000\u0410\u0412\u0003\u0088D\u0000\u0411\u0410\u0001\u0000"+
		"\u0000\u0000\u0412\u0415\u0001\u0000\u0000\u0000\u0413\u0411\u0001\u0000"+
		"\u0000\u0000\u0413\u0414\u0001\u0000\u0000\u0000\u0414\u0416\u0001\u0000"+
		"\u0000\u0000\u0415\u0413\u0001\u0000\u0000\u0000\u0416\u0417\u0003F#\u0000"+
		"\u0417\u0419\u0003f3\u0000\u0418\u041a\u0003\u00a4R\u0000\u0419\u0418"+
		"\u0001\u0000\u0000\u0000\u0419\u041a\u0001\u0000\u0000\u0000\u041a\u041b"+
		"\u0001\u0000\u0000\u0000\u041b\u041c\u0003\u008eG\u0000\u041c\u00a3\u0001"+
		"\u0000\u0000\u0000\u041d\u041f\u0003D\"\u0000\u041e\u041d\u0001\u0000"+
		"\u0000\u0000\u041f\u0420\u0001\u0000\u0000\u0000\u0420\u041e\u0001\u0000"+
		"\u0000\u0000\u0420\u0421\u0001\u0000\u0000\u0000\u0421\u00a5\u0001\u0000"+
		"\u0000\u0000x\u00a7\u00ac\u00b3\u00b7\u00ba\u00c3\u00ca\u00d1\u00d3\u00d8"+
		"\u00df\u00e5\u00f0\u00fa\u0103\u010a\u0118\u0128\u0136\u013f\u0148\u014e"+
		"\u0153\u015b\u0166\u0173\u017d\u0181\u018b\u0198\u019a\u01a2\u01b3\u01bb"+
		"\u01c5\u01d0\u01db\u01e6\u01f1\u01fc\u0207\u0212\u021d\u0228\u0232\u0239"+
		"\u0240\u0247\u024f\u0251\u025c\u0262\u0268\u026c\u0274\u0279\u0281\u0284"+
		"\u028b\u0290\u0294\u0298\u029d\u02a3\u02aa\u02b0\u02b5\u02bf\u02c4\u02c7"+
		"\u02ce\u02dd\u02e9\u02ec\u02ee\u02f3\u02f7\u02fc\u0301\u0308\u030e\u0310"+
		"\u0317\u031c\u0320\u0323\u032d\u0330\u0337\u0346\u0352\u0355\u0357\u0360"+
		"\u0364\u0367\u036c\u0371\u0379\u0381\u038e\u039b\u039f\u03a6\u03aa\u03ad"+
		"\u03c5\u03d8\u03dc\u03e0\u03e8\u03ec\u03f1\u03fc\u03ff\u040a\u040e\u0413"+
		"\u0419\u0420";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}