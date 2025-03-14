// Generated from I:/Coding Projects/JCC816/src/Grammar/C816.g4 by ANTLR 4.13.1
package Grammar.C816;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class C816Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, WS=19, Operation=20, Length=21, PpFunc=22, Symbol=23, Number=24, 
		Comment=25, Preproc=26;
	public static final int
		RULE_parameter = 0, RULE_value = 1, RULE_instruction = 2, RULE_preprocInstruction = 3, 
		RULE_macroInstruction = 4, RULE_label = 5, RULE_program = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"parameter", "value", "instruction", "preprocInstruction", "macroInstruction", 
			"label", "program"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "'x'", "'y'", "'X'", "'Y'", "'['", "']'", 
			"'s'", "'+'", "'|'", "'^'", "'<<'", "'#'", "':'", "'-'", "'\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "WS", "Operation", "Length", 
			"PpFunc", "Symbol", "Number", "Comment", "Preproc"
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
	public String getGrammarFileName() { return "C816.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public C816Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C816Visitor ) return ((C816Visitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parameter);
		int _la;
		try {
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				match(T__0);
				setState(15);
				value(0);
				setState(16);
				match(T__1);
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(17);
					match(T__2);
					setState(18);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 240L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				match(T__0);
				setState(22);
				value(0);
				setState(23);
				match(T__2);
				setState(24);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 240L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(25);
				match(T__1);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(27);
				match(T__7);
				setState(28);
				value(0);
				setState(29);
				match(T__8);
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(30);
					match(T__2);
					setState(31);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 240L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(34);
				match(T__0);
				setState(35);
				value(0);
				setState(36);
				match(T__2);
				setState(37);
				match(T__9);
				setState(38);
				match(T__1);
				{
				setState(39);
				match(T__2);
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 240L) != 0)) {
					{
					setState(40);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 240L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(43);
				value(0);
				setState(44);
				match(T__2);
				setState(45);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 240L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(47);
				value(0);
				setState(48);
				match(T__2);
				setState(49);
				value(0);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(51);
				value(0);
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
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode Symbol() { return getToken(C816Parser.Symbol, 0); }
		public TerminalNode Number() { return getToken(C816Parser.Number, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode Length() { return getToken(C816Parser.Length, 0); }
		public TerminalNode PpFunc() { return getToken(C816Parser.PpFunc, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C816Visitor ) return ((C816Visitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		return value(0);
	}

	private ValueContext value(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValueContext _localctx = new ValueContext(_ctx, _parentState);
		ValueContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_value, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(55);
				match(Symbol);
				}
				break;
			case 2:
				{
				setState(56);
				match(Number);
				}
				break;
			case 3:
				{
				setState(57);
				match(T__14);
				setState(58);
				value(6);
				}
				break;
			case 4:
				{
				setState(59);
				match(Length);
				setState(60);
				value(5);
				}
				break;
			case 5:
				{
				setState(61);
				match(PpFunc);
				setState(62);
				match(T__0);
				setState(63);
				value(0);
				setState(64);
				match(T__1);
				}
				break;
			case 6:
				{
				setState(66);
				match(T__0);
				setState(67);
				value(0);
				setState(68);
				match(T__1);
				}
				break;
			case 7:
				{
				setState(70);
				match(T__15);
				setState(72); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(71);
						match(T__10);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(74); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 8:
				{
				setState(76);
				match(T__15);
				setState(78); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(77);
						match(T__16);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(80); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(98);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(96);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ValueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(84);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(85);
						match(T__10);
						setState(86);
						value(11);
						}
						break;
					case 2:
						{
						_localctx = new ValueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(87);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(88);
						match(T__11);
						setState(89);
						value(10);
						}
						break;
					case 3:
						{
						_localctx = new ValueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(90);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(91);
						match(T__12);
						setState(92);
						value(9);
						}
						break;
					case 4:
						{
						_localctx = new ValueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(93);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(94);
						match(T__13);
						setState(95);
						value(8);
						}
						break;
					}
					} 
				}
				setState(100);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
	public static class InstructionContext extends ParserRuleContext {
		public TerminalNode Operation() { return getToken(C816Parser.Operation, 0); }
		public ParameterContext parameter() {
			return getRuleContext(ParameterContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C816Visitor ) return ((C816Visitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(Operation);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 31555842L) != 0)) {
				{
				setState(102);
				parameter();
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
	public static class PreprocInstructionContext extends ParserRuleContext {
		public TerminalNode Preproc() { return getToken(C816Parser.Preproc, 0); }
		public PreprocInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preprocInstruction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C816Visitor ) return ((C816Visitor<? extends T>)visitor).visitPreprocInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreprocInstructionContext preprocInstruction() throws RecognitionException {
		PreprocInstructionContext _localctx = new PreprocInstructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_preprocInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(Preproc);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MacroInstructionContext extends ParserRuleContext {
		public TerminalNode Symbol() { return getToken(C816Parser.Symbol, 0); }
		public MacroInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroInstruction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C816Visitor ) return ((C816Visitor<? extends T>)visitor).visitMacroInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MacroInstructionContext macroInstruction() throws RecognitionException {
		MacroInstructionContext _localctx = new MacroInstructionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_macroInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(Symbol);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LabelContext extends ParserRuleContext {
		public TerminalNode Symbol() { return getToken(C816Parser.Symbol, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C816Visitor ) return ((C816Visitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Symbol) {
				{
				setState(109);
				match(Symbol);
				}
			}

			setState(112);
			match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<PreprocInstructionContext> preprocInstruction() {
			return getRuleContexts(PreprocInstructionContext.class);
		}
		public PreprocInstructionContext preprocInstruction(int i) {
			return getRuleContext(PreprocInstructionContext.class,i);
		}
		public List<MacroInstructionContext> macroInstruction() {
			return getRuleContexts(MacroInstructionContext.class);
		}
		public MacroInstructionContext macroInstruction(int i) {
			return getRuleContext(MacroInstructionContext.class,i);
		}
		public List<TerminalNode> Comment() { return getTokens(C816Parser.Comment); }
		public TerminalNode Comment(int i) {
			return getToken(C816Parser.Comment, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof C816Visitor ) return ((C816Visitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(127);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(114);
					label();
					}
					break;
				case 2:
					{
					setState(116);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__15 || _la==Symbol) {
						{
						setState(115);
						label();
						}
					}

					setState(118);
					instruction();
					}
					break;
				case 3:
					{
					setState(120);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__15 || _la==Symbol) {
						{
						setState(119);
						label();
						}
					}

					setState(122);
					preprocInstruction();
					}
					break;
				case 4:
					{
					setState(124);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						setState(123);
						label();
						}
						break;
					}
					setState(126);
					macroInstruction();
					}
					break;
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comment) {
					{
					setState(129);
					match(Comment);
					}
				}

				setState(132);
				match(T__17);
				}
				}
				setState(135); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 110428160L) != 0) );
			}
		}
		catch (RecognitionException re) {
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
			return value_sempred((ValueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean value_sempred(ValueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001a\u008a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000\u0014\b\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000!\b\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0003\u0000*\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0003\u00005\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0004\u0001I\b\u0001\u000b\u0001\f\u0001J\u0001"+
		"\u0001\u0001\u0001\u0004\u0001O\b\u0001\u000b\u0001\f\u0001P\u0003\u0001"+
		"S\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001a\b\u0001\n\u0001\f\u0001d\t\u0001\u0001\u0002"+
		"\u0001\u0002\u0003\u0002h\b\u0002\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0003\u0005o\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0003\u0006u\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006y\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006}\b\u0006\u0001"+
		"\u0006\u0003\u0006\u0080\b\u0006\u0001\u0006\u0003\u0006\u0083\b\u0006"+
		"\u0001\u0006\u0004\u0006\u0086\b\u0006\u000b\u0006\f\u0006\u0087\u0001"+
		"\u0006\u0000\u0001\u0002\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000\u0001"+
		"\u0001\u0000\u0004\u0007\u00a3\u00004\u0001\u0000\u0000\u0000\u0002R\u0001"+
		"\u0000\u0000\u0000\u0004e\u0001\u0000\u0000\u0000\u0006i\u0001\u0000\u0000"+
		"\u0000\bk\u0001\u0000\u0000\u0000\nn\u0001\u0000\u0000\u0000\f\u0085\u0001"+
		"\u0000\u0000\u0000\u000e\u000f\u0005\u0001\u0000\u0000\u000f\u0010\u0003"+
		"\u0002\u0001\u0000\u0010\u0013\u0005\u0002\u0000\u0000\u0011\u0012\u0005"+
		"\u0003\u0000\u0000\u0012\u0014\u0007\u0000\u0000\u0000\u0013\u0011\u0001"+
		"\u0000\u0000\u0000\u0013\u0014\u0001\u0000\u0000\u0000\u00145\u0001\u0000"+
		"\u0000\u0000\u0015\u0016\u0005\u0001\u0000\u0000\u0016\u0017\u0003\u0002"+
		"\u0001\u0000\u0017\u0018\u0005\u0003\u0000\u0000\u0018\u0019\u0007\u0000"+
		"\u0000\u0000\u0019\u001a\u0005\u0002\u0000\u0000\u001a5\u0001\u0000\u0000"+
		"\u0000\u001b\u001c\u0005\b\u0000\u0000\u001c\u001d\u0003\u0002\u0001\u0000"+
		"\u001d \u0005\t\u0000\u0000\u001e\u001f\u0005\u0003\u0000\u0000\u001f"+
		"!\u0007\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000"+
		"\u0000\u0000!5\u0001\u0000\u0000\u0000\"#\u0005\u0001\u0000\u0000#$\u0003"+
		"\u0002\u0001\u0000$%\u0005\u0003\u0000\u0000%&\u0005\n\u0000\u0000&\'"+
		"\u0005\u0002\u0000\u0000\')\u0005\u0003\u0000\u0000(*\u0007\u0000\u0000"+
		"\u0000)(\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*5\u0001\u0000"+
		"\u0000\u0000+,\u0003\u0002\u0001\u0000,-\u0005\u0003\u0000\u0000-.\u0007"+
		"\u0000\u0000\u0000.5\u0001\u0000\u0000\u0000/0\u0003\u0002\u0001\u0000"+
		"01\u0005\u0003\u0000\u000012\u0003\u0002\u0001\u000025\u0001\u0000\u0000"+
		"\u000035\u0003\u0002\u0001\u00004\u000e\u0001\u0000\u0000\u00004\u0015"+
		"\u0001\u0000\u0000\u00004\u001b\u0001\u0000\u0000\u00004\"\u0001\u0000"+
		"\u0000\u00004+\u0001\u0000\u0000\u00004/\u0001\u0000\u0000\u000043\u0001"+
		"\u0000\u0000\u00005\u0001\u0001\u0000\u0000\u000067\u0006\u0001\uffff"+
		"\uffff\u00007S\u0005\u0017\u0000\u00008S\u0005\u0018\u0000\u00009:\u0005"+
		"\u000f\u0000\u0000:S\u0003\u0002\u0001\u0006;<\u0005\u0015\u0000\u0000"+
		"<S\u0003\u0002\u0001\u0005=>\u0005\u0016\u0000\u0000>?\u0005\u0001\u0000"+
		"\u0000?@\u0003\u0002\u0001\u0000@A\u0005\u0002\u0000\u0000AS\u0001\u0000"+
		"\u0000\u0000BC\u0005\u0001\u0000\u0000CD\u0003\u0002\u0001\u0000DE\u0005"+
		"\u0002\u0000\u0000ES\u0001\u0000\u0000\u0000FH\u0005\u0010\u0000\u0000"+
		"GI\u0005\u000b\u0000\u0000HG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000"+
		"\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KS\u0001\u0000"+
		"\u0000\u0000LN\u0005\u0010\u0000\u0000MO\u0005\u0011\u0000\u0000NM\u0001"+
		"\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000"+
		"PQ\u0001\u0000\u0000\u0000QS\u0001\u0000\u0000\u0000R6\u0001\u0000\u0000"+
		"\u0000R8\u0001\u0000\u0000\u0000R9\u0001\u0000\u0000\u0000R;\u0001\u0000"+
		"\u0000\u0000R=\u0001\u0000\u0000\u0000RB\u0001\u0000\u0000\u0000RF\u0001"+
		"\u0000\u0000\u0000RL\u0001\u0000\u0000\u0000Sb\u0001\u0000\u0000\u0000"+
		"TU\n\n\u0000\u0000UV\u0005\u000b\u0000\u0000Va\u0003\u0002\u0001\u000b"+
		"WX\n\t\u0000\u0000XY\u0005\f\u0000\u0000Ya\u0003\u0002\u0001\nZ[\n\b\u0000"+
		"\u0000[\\\u0005\r\u0000\u0000\\a\u0003\u0002\u0001\t]^\n\u0007\u0000\u0000"+
		"^_\u0005\u000e\u0000\u0000_a\u0003\u0002\u0001\b`T\u0001\u0000\u0000\u0000"+
		"`W\u0001\u0000\u0000\u0000`Z\u0001\u0000\u0000\u0000`]\u0001\u0000\u0000"+
		"\u0000ad\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000"+
		"\u0000\u0000c\u0003\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000"+
		"eg\u0005\u0014\u0000\u0000fh\u0003\u0000\u0000\u0000gf\u0001\u0000\u0000"+
		"\u0000gh\u0001\u0000\u0000\u0000h\u0005\u0001\u0000\u0000\u0000ij\u0005"+
		"\u001a\u0000\u0000j\u0007\u0001\u0000\u0000\u0000kl\u0005\u0017\u0000"+
		"\u0000l\t\u0001\u0000\u0000\u0000mo\u0005\u0017\u0000\u0000nm\u0001\u0000"+
		"\u0000\u0000no\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0005"+
		"\u0010\u0000\u0000q\u000b\u0001\u0000\u0000\u0000r\u0080\u0003\n\u0005"+
		"\u0000su\u0003\n\u0005\u0000ts\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000"+
		"\u0000uv\u0001\u0000\u0000\u0000v\u0080\u0003\u0004\u0002\u0000wy\u0003"+
		"\n\u0005\u0000xw\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0001"+
		"\u0000\u0000\u0000z\u0080\u0003\u0006\u0003\u0000{}\u0003\n\u0005\u0000"+
		"|{\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000"+
		"\u0000~\u0080\u0003\b\u0004\u0000\u007fr\u0001\u0000\u0000\u0000\u007f"+
		"t\u0001\u0000\u0000\u0000\u007fx\u0001\u0000\u0000\u0000\u007f|\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0082\u0001"+
		"\u0000\u0000\u0000\u0081\u0083\u0005\u0019\u0000\u0000\u0082\u0081\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0001"+
		"\u0000\u0000\u0000\u0084\u0086\u0005\u0012\u0000\u0000\u0085\u007f\u0001"+
		"\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0085\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\r\u0001\u0000"+
		"\u0000\u0000\u0011\u0013 )4JPR`bgntx|\u007f\u0082\u0087";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}