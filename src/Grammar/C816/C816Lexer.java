// Generated from I:/Coding Projects/JCC816/src/Grammar/C816.g4 by ANTLR 4.13.1
package Grammar.C816;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class C816Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, WS=14, Operation=15, Symbol=16, 
		Number=17, Comment=18, Preproc=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "WS", "Operation", "PpFunc", "Symbol", 
			"Number", "Comment", "Preproc"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "'x'", "'y'", "'['", "']'", "'s'", "'#'", 
			"'+'", "':'", "'-'", "'\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "WS", "Operation", "Symbol", "Number", "Comment", "Preproc"
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


	public C816Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "C816.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0013\u01ab\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0004\rE\b\r\u000b"+
		"\r\f\rF\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u014d\b\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u0174\b\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u0178\b\u0010\n\u0010"+
		"\f\u0010\u017b\t\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u0182\b\u0010\u0001\u0011\u0004\u0011\u0185\b"+
		"\u0011\u000b\u0011\f\u0011\u0186\u0001\u0011\u0001\u0011\u0004\u0011\u018b"+
		"\b\u0011\u000b\u0011\f\u0011\u018c\u0003\u0011\u018f\b\u0011\u0001\u0012"+
		"\u0001\u0012\u0005\u0012\u0193\b\u0012\n\u0012\f\u0012\u0196\t\u0012\u0001"+
		"\u0013\u0001\u0013\u0005\u0013\u019a\b\u0013\n\u0013\f\u0013\u019d\t\u0013"+
		"\u0001\u0013\u0004\u0013\u01a0\b\u0013\u000b\u0013\f\u0013\u01a1\u0001"+
		"\u0013\u0001\u0013\u0004\u0013\u01a6\b\u0013\u000b\u0013\f\u0013\u01a7"+
		"\u0003\u0013\u01aa\b\u0013\u0000\u0000\u0014\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0000!\u0010"+
		"#\u0011%\u0012\'\u0013\u0001\u0000\u0007\u0003\u0000\t\t\r\r  \u0003\u0000"+
		"AZ__az\u0004\u000009@Z__az\u0001\u000009\u0003\u000009AFaf\u0001\u0000"+
		"\n\n\u0002\u0000\n\n==\u020d\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000!\u0001\u0000"+
		"\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000"+
		"\u0000\'\u0001\u0000\u0000\u0000\u0001)\u0001\u0000\u0000\u0000\u0003"+
		"+\u0001\u0000\u0000\u0000\u0005-\u0001\u0000\u0000\u0000\u0007/\u0001"+
		"\u0000\u0000\u0000\t1\u0001\u0000\u0000\u0000\u000b3\u0001\u0000\u0000"+
		"\u0000\r5\u0001\u0000\u0000\u0000\u000f7\u0001\u0000\u0000\u0000\u0011"+
		"9\u0001\u0000\u0000\u0000\u0013;\u0001\u0000\u0000\u0000\u0015=\u0001"+
		"\u0000\u0000\u0000\u0017?\u0001\u0000\u0000\u0000\u0019A\u0001\u0000\u0000"+
		"\u0000\u001bD\u0001\u0000\u0000\u0000\u001d\u014c\u0001\u0000\u0000\u0000"+
		"\u001f\u0173\u0001\u0000\u0000\u0000!\u0181\u0001\u0000\u0000\u0000#\u018e"+
		"\u0001\u0000\u0000\u0000%\u0190\u0001\u0000\u0000\u0000\'\u01a9\u0001"+
		"\u0000\u0000\u0000)*\u0005(\u0000\u0000*\u0002\u0001\u0000\u0000\u0000"+
		"+,\u0005)\u0000\u0000,\u0004\u0001\u0000\u0000\u0000-.\u0005,\u0000\u0000"+
		".\u0006\u0001\u0000\u0000\u0000/0\u0005x\u0000\u00000\b\u0001\u0000\u0000"+
		"\u000012\u0005y\u0000\u00002\n\u0001\u0000\u0000\u000034\u0005[\u0000"+
		"\u00004\f\u0001\u0000\u0000\u000056\u0005]\u0000\u00006\u000e\u0001\u0000"+
		"\u0000\u000078\u0005s\u0000\u00008\u0010\u0001\u0000\u0000\u00009:\u0005"+
		"#\u0000\u0000:\u0012\u0001\u0000\u0000\u0000;<\u0005+\u0000\u0000<\u0014"+
		"\u0001\u0000\u0000\u0000=>\u0005:\u0000\u0000>\u0016\u0001\u0000\u0000"+
		"\u0000?@\u0005-\u0000\u0000@\u0018\u0001\u0000\u0000\u0000AB\u0005\n\u0000"+
		"\u0000B\u001a\u0001\u0000\u0000\u0000CE\u0007\u0000\u0000\u0000DC\u0001"+
		"\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000"+
		"FG\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HI\u0006\r\u0000\u0000"+
		"I\u001c\u0001\u0000\u0000\u0000JK\u0005A\u0000\u0000KL\u0005D\u0000\u0000"+
		"L\u014d\u0005C\u0000\u0000MN\u0005A\u0000\u0000NO\u0005N\u0000\u0000O"+
		"\u014d\u0005D\u0000\u0000PQ\u0005A\u0000\u0000QR\u0005S\u0000\u0000R\u014d"+
		"\u0005L\u0000\u0000ST\u0005B\u0000\u0000TU\u0005C\u0000\u0000U\u014d\u0005"+
		"C\u0000\u0000VW\u0005B\u0000\u0000WX\u0005C\u0000\u0000X\u014d\u0005S"+
		"\u0000\u0000YZ\u0005B\u0000\u0000Z[\u0005E\u0000\u0000[\u014d\u0005Q\u0000"+
		"\u0000\\]\u0005B\u0000\u0000]^\u0005I\u0000\u0000^\u014d\u0005T\u0000"+
		"\u0000_`\u0005B\u0000\u0000`a\u0005M\u0000\u0000a\u014d\u0005I\u0000\u0000"+
		"bc\u0005B\u0000\u0000cd\u0005N\u0000\u0000d\u014d\u0005E\u0000\u0000e"+
		"f\u0005B\u0000\u0000fg\u0005P\u0000\u0000g\u014d\u0005L\u0000\u0000hi"+
		"\u0005B\u0000\u0000ij\u0005R\u0000\u0000j\u014d\u0005A\u0000\u0000kl\u0005"+
		"B\u0000\u0000lm\u0005R\u0000\u0000m\u014d\u0005K\u0000\u0000no\u0005B"+
		"\u0000\u0000op\u0005R\u0000\u0000p\u014d\u0005L\u0000\u0000qr\u0005B\u0000"+
		"\u0000rs\u0005V\u0000\u0000s\u014d\u0005C\u0000\u0000tu\u0005B\u0000\u0000"+
		"uv\u0005V\u0000\u0000v\u014d\u0005S\u0000\u0000wx\u0005C\u0000\u0000x"+
		"y\u0005L\u0000\u0000y\u014d\u0005C\u0000\u0000z{\u0005C\u0000\u0000{|"+
		"\u0005L\u0000\u0000|\u014d\u0005D\u0000\u0000}~\u0005C\u0000\u0000~\u007f"+
		"\u0005L\u0000\u0000\u007f\u014d\u0005I\u0000\u0000\u0080\u0081\u0005C"+
		"\u0000\u0000\u0081\u0082\u0005L\u0000\u0000\u0082\u014d\u0005V\u0000\u0000"+
		"\u0083\u0084\u0005C\u0000\u0000\u0084\u0085\u0005M\u0000\u0000\u0085\u014d"+
		"\u0005P\u0000\u0000\u0086\u0087\u0005C\u0000\u0000\u0087\u0088\u0005P"+
		"\u0000\u0000\u0088\u014d\u0005X\u0000\u0000\u0089\u008a\u0005C\u0000\u0000"+
		"\u008a\u008b\u0005P\u0000\u0000\u008b\u014d\u0005Y\u0000\u0000\u008c\u008d"+
		"\u0005C\u0000\u0000\u008d\u008e\u0005O\u0000\u0000\u008e\u014d\u0005P"+
		"\u0000\u0000\u008f\u0090\u0005D\u0000\u0000\u0090\u0091\u0005E\u0000\u0000"+
		"\u0091\u014d\u0005C\u0000\u0000\u0092\u0093\u0005D\u0000\u0000\u0093\u0094"+
		"\u0005E\u0000\u0000\u0094\u014d\u0005X\u0000\u0000\u0095\u0096\u0005D"+
		"\u0000\u0000\u0096\u0097\u0005E\u0000\u0000\u0097\u014d\u0005Y\u0000\u0000"+
		"\u0098\u0099\u0005E\u0000\u0000\u0099\u009a\u0005O\u0000\u0000\u009a\u014d"+
		"\u0005R\u0000\u0000\u009b\u009c\u0005I\u0000\u0000\u009c\u009d\u0005N"+
		"\u0000\u0000\u009d\u014d\u0005C\u0000\u0000\u009e\u009f\u0005I\u0000\u0000"+
		"\u009f\u00a0\u0005N\u0000\u0000\u00a0\u014d\u0005X\u0000\u0000\u00a1\u00a2"+
		"\u0005I\u0000\u0000\u00a2\u00a3\u0005N\u0000\u0000\u00a3\u014d\u0005Y"+
		"\u0000\u0000\u00a4\u00a5\u0005J\u0000\u0000\u00a5\u00a6\u0005M\u0000\u0000"+
		"\u00a6\u014d\u0005P\u0000\u0000\u00a7\u00a8\u0005J\u0000\u0000\u00a8\u00a9"+
		"\u0005M\u0000\u0000\u00a9\u014d\u0005L\u0000\u0000\u00aa\u00ab\u0005J"+
		"\u0000\u0000\u00ab\u00ac\u0005S\u0000\u0000\u00ac\u014d\u0005L\u0000\u0000"+
		"\u00ad\u00ae\u0005L\u0000\u0000\u00ae\u00af\u0005D\u0000\u0000\u00af\u014d"+
		"\u0005A\u0000\u0000\u00b0\u00b1\u0005L\u0000\u0000\u00b1\u00b2\u0005D"+
		"\u0000\u0000\u00b2\u014d\u0005X\u0000\u0000\u00b3\u00b4\u0005L\u0000\u0000"+
		"\u00b4\u00b5\u0005D\u0000\u0000\u00b5\u014d\u0005Y\u0000\u0000\u00b6\u00b7"+
		"\u0005L\u0000\u0000\u00b7\u00b8\u0005S\u0000\u0000\u00b8\u014d\u0005R"+
		"\u0000\u0000\u00b9\u00ba\u0005M\u0000\u0000\u00ba\u00bb\u0005V\u0000\u0000"+
		"\u00bb\u014d\u0005N\u0000\u0000\u00bc\u00bd\u0005M\u0000\u0000\u00bd\u00be"+
		"\u0005V\u0000\u0000\u00be\u014d\u0005P\u0000\u0000\u00bf\u00c0\u0005N"+
		"\u0000\u0000\u00c0\u00c1\u0005O\u0000\u0000\u00c1\u014d\u0005P\u0000\u0000"+
		"\u00c2\u00c3\u0005O\u0000\u0000\u00c3\u00c4\u0005R\u0000\u0000\u00c4\u014d"+
		"\u0005A\u0000\u0000\u00c5\u00c6\u0005P\u0000\u0000\u00c6\u00c7\u0005E"+
		"\u0000\u0000\u00c7\u014d\u0005A\u0000\u0000\u00c8\u00c9\u0005P\u0000\u0000"+
		"\u00c9\u00ca\u0005E\u0000\u0000\u00ca\u014d\u0005I\u0000\u0000\u00cb\u00cc"+
		"\u0005P\u0000\u0000\u00cc\u00cd\u0005E\u0000\u0000\u00cd\u014d\u0005R"+
		"\u0000\u0000\u00ce\u00cf\u0005P\u0000\u0000\u00cf\u00d0\u0005H\u0000\u0000"+
		"\u00d0\u014d\u0005A\u0000\u0000\u00d1\u00d2\u0005P\u0000\u0000\u00d2\u00d3"+
		"\u0005H\u0000\u0000\u00d3\u014d\u0005D\u0000\u0000\u00d4\u00d5\u0005P"+
		"\u0000\u0000\u00d5\u00d6\u0005H\u0000\u0000\u00d6\u014d\u0005K\u0000\u0000"+
		"\u00d7\u00d8\u0005P\u0000\u0000\u00d8\u00d9\u0005H\u0000\u0000\u00d9\u014d"+
		"\u0005X\u0000\u0000\u00da\u00db\u0005P\u0000\u0000\u00db\u00dc\u0005H"+
		"\u0000\u0000\u00dc\u014d\u0005Y\u0000\u0000\u00dd\u00de\u0005P\u0000\u0000"+
		"\u00de\u00df\u0005L\u0000\u0000\u00df\u014d\u0005A\u0000\u0000\u00e0\u00e1"+
		"\u0005P\u0000\u0000\u00e1\u00e2\u0005L\u0000\u0000\u00e2\u014d\u0005D"+
		"\u0000\u0000\u00e3\u00e4\u0005P\u0000\u0000\u00e4\u00e5\u0005L\u0000\u0000"+
		"\u00e5\u014d\u0005P\u0000\u0000\u00e6\u00e7\u0005P\u0000\u0000\u00e7\u00e8"+
		"\u0005L\u0000\u0000\u00e8\u014d\u0005X\u0000\u0000\u00e9\u00ea\u0005P"+
		"\u0000\u0000\u00ea\u00eb\u0005L\u0000\u0000\u00eb\u014d\u0005Y\u0000\u0000"+
		"\u00ec\u00ed\u0005R\u0000\u0000\u00ed\u00ee\u0005E\u0000\u0000\u00ee\u014d"+
		"\u0005P\u0000\u0000\u00ef\u00f0\u0005R\u0000\u0000\u00f0\u00f1\u0005O"+
		"\u0000\u0000\u00f1\u014d\u0005L\u0000\u0000\u00f2\u00f3\u0005R\u0000\u0000"+
		"\u00f3\u00f4\u0005O\u0000\u0000\u00f4\u014d\u0005R\u0000\u0000\u00f5\u00f6"+
		"\u0005R\u0000\u0000\u00f6\u00f7\u0005T\u0000\u0000\u00f7\u014d\u0005I"+
		"\u0000\u0000\u00f8\u00f9\u0005R\u0000\u0000\u00f9\u00fa\u0005T\u0000\u0000"+
		"\u00fa\u014d\u0005S\u0000\u0000\u00fb\u00fc\u0005R\u0000\u0000\u00fc\u00fd"+
		"\u0005T\u0000\u0000\u00fd\u014d\u0005L\u0000\u0000\u00fe\u00ff\u0005S"+
		"\u0000\u0000\u00ff\u0100\u0005B\u0000\u0000\u0100\u014d\u0005C\u0000\u0000"+
		"\u0101\u0102\u0005S\u0000\u0000\u0102\u0103\u0005E\u0000\u0000\u0103\u014d"+
		"\u0005C\u0000\u0000\u0104\u0105\u0005S\u0000\u0000\u0105\u0106\u0005E"+
		"\u0000\u0000\u0106\u014d\u0005D\u0000\u0000\u0107\u0108\u0005S\u0000\u0000"+
		"\u0108\u0109\u0005E\u0000\u0000\u0109\u014d\u0005I\u0000\u0000\u010a\u010b"+
		"\u0005S\u0000\u0000\u010b\u010c\u0005E\u0000\u0000\u010c\u014d\u0005P"+
		"\u0000\u0000\u010d\u010e\u0005S\u0000\u0000\u010e\u010f\u0005T\u0000\u0000"+
		"\u010f\u014d\u0005A\u0000\u0000\u0110\u0111\u0005S\u0000\u0000\u0111\u0112"+
		"\u0005T\u0000\u0000\u0112\u014d\u0005X\u0000\u0000\u0113\u0114\u0005S"+
		"\u0000\u0000\u0114\u0115\u0005T\u0000\u0000\u0115\u014d\u0005Y\u0000\u0000"+
		"\u0116\u0117\u0005S\u0000\u0000\u0117\u0118\u0005T\u0000\u0000\u0118\u014d"+
		"\u0005P\u0000\u0000\u0119\u011a\u0005S\u0000\u0000\u011a\u011b\u0005T"+
		"\u0000\u0000\u011b\u014d\u0005Z\u0000\u0000\u011c\u011d\u0005T\u0000\u0000"+
		"\u011d\u011e\u0005A\u0000\u0000\u011e\u014d\u0005X\u0000\u0000\u011f\u0120"+
		"\u0005T\u0000\u0000\u0120\u0121\u0005A\u0000\u0000\u0121\u014d\u0005Y"+
		"\u0000\u0000\u0122\u0123\u0005T\u0000\u0000\u0123\u0124\u0005C\u0000\u0000"+
		"\u0124\u014d\u0005D\u0000\u0000\u0125\u0126\u0005T\u0000\u0000\u0126\u0127"+
		"\u0005C\u0000\u0000\u0127\u014d\u0005S\u0000\u0000\u0128\u0129\u0005T"+
		"\u0000\u0000\u0129\u012a\u0005D\u0000\u0000\u012a\u014d\u0005C\u0000\u0000"+
		"\u012b\u012c\u0005T\u0000\u0000\u012c\u012d\u0005S\u0000\u0000\u012d\u014d"+
		"\u0005C\u0000\u0000\u012e\u012f\u0005T\u0000\u0000\u012f\u0130\u0005S"+
		"\u0000\u0000\u0130\u014d\u0005X\u0000\u0000\u0131\u0132\u0005T\u0000\u0000"+
		"\u0132\u0133\u0005X\u0000\u0000\u0133\u014d\u0005A\u0000\u0000\u0134\u0135"+
		"\u0005T\u0000\u0000\u0135\u0136\u0005X\u0000\u0000\u0136\u014d\u0005S"+
		"\u0000\u0000\u0137\u0138\u0005T\u0000\u0000\u0138\u0139\u0005X\u0000\u0000"+
		"\u0139\u014d\u0005Y\u0000\u0000\u013a\u013b\u0005T\u0000\u0000\u013b\u013c"+
		"\u0005Y\u0000\u0000\u013c\u014d\u0005A\u0000\u0000\u013d\u013e\u0005T"+
		"\u0000\u0000\u013e\u013f\u0005Y\u0000\u0000\u013f\u014d\u0005X\u0000\u0000"+
		"\u0140\u0141\u0005T\u0000\u0000\u0141\u0142\u0005R\u0000\u0000\u0142\u014d"+
		"\u0005B\u0000\u0000\u0143\u0144\u0005T\u0000\u0000\u0144\u0145\u0005S"+
		"\u0000\u0000\u0145\u014d\u0005B\u0000\u0000\u0146\u0147\u0005W\u0000\u0000"+
		"\u0147\u0148\u0005A\u0000\u0000\u0148\u014d\u0005I\u0000\u0000\u0149\u014a"+
		"\u0005X\u0000\u0000\u014a\u014b\u0005C\u0000\u0000\u014b\u014d\u0005E"+
		"\u0000\u0000\u014cJ\u0001\u0000\u0000\u0000\u014cM\u0001\u0000\u0000\u0000"+
		"\u014cP\u0001\u0000\u0000\u0000\u014cS\u0001\u0000\u0000\u0000\u014cV"+
		"\u0001\u0000\u0000\u0000\u014cY\u0001\u0000\u0000\u0000\u014c\\\u0001"+
		"\u0000\u0000\u0000\u014c_\u0001\u0000\u0000\u0000\u014cb\u0001\u0000\u0000"+
		"\u0000\u014ce\u0001\u0000\u0000\u0000\u014ch\u0001\u0000\u0000\u0000\u014c"+
		"k\u0001\u0000\u0000\u0000\u014cn\u0001\u0000\u0000\u0000\u014cq\u0001"+
		"\u0000\u0000\u0000\u014ct\u0001\u0000\u0000\u0000\u014cw\u0001\u0000\u0000"+
		"\u0000\u014cz\u0001\u0000\u0000\u0000\u014c}\u0001\u0000\u0000\u0000\u014c"+
		"\u0080\u0001\u0000\u0000\u0000\u014c\u0083\u0001\u0000\u0000\u0000\u014c"+
		"\u0086\u0001\u0000\u0000\u0000\u014c\u0089\u0001\u0000\u0000\u0000\u014c"+
		"\u008c\u0001\u0000\u0000\u0000\u014c\u008f\u0001\u0000\u0000\u0000\u014c"+
		"\u0092\u0001\u0000\u0000\u0000\u014c\u0095\u0001\u0000\u0000\u0000\u014c"+
		"\u0098\u0001\u0000\u0000\u0000\u014c\u009b\u0001\u0000\u0000\u0000\u014c"+
		"\u009e\u0001\u0000\u0000\u0000\u014c\u00a1\u0001\u0000\u0000\u0000\u014c"+
		"\u00a4\u0001\u0000\u0000\u0000\u014c\u00a7\u0001\u0000\u0000\u0000\u014c"+
		"\u00aa\u0001\u0000\u0000\u0000\u014c\u00ad\u0001\u0000\u0000\u0000\u014c"+
		"\u00b0\u0001\u0000\u0000\u0000\u014c\u00b3\u0001\u0000\u0000\u0000\u014c"+
		"\u00b6\u0001\u0000\u0000\u0000\u014c\u00b9\u0001\u0000\u0000\u0000\u014c"+
		"\u00bc\u0001\u0000\u0000\u0000\u014c\u00bf\u0001\u0000\u0000\u0000\u014c"+
		"\u00c2\u0001\u0000\u0000\u0000\u014c\u00c5\u0001\u0000\u0000\u0000\u014c"+
		"\u00c8\u0001\u0000\u0000\u0000\u014c\u00cb\u0001\u0000\u0000\u0000\u014c"+
		"\u00ce\u0001\u0000\u0000\u0000\u014c\u00d1\u0001\u0000\u0000\u0000\u014c"+
		"\u00d4\u0001\u0000\u0000\u0000\u014c\u00d7\u0001\u0000\u0000\u0000\u014c"+
		"\u00da\u0001\u0000\u0000\u0000\u014c\u00dd\u0001\u0000\u0000\u0000\u014c"+
		"\u00e0\u0001\u0000\u0000\u0000\u014c\u00e3\u0001\u0000\u0000\u0000\u014c"+
		"\u00e6\u0001\u0000\u0000\u0000\u014c\u00e9\u0001\u0000\u0000\u0000\u014c"+
		"\u00ec\u0001\u0000\u0000\u0000\u014c\u00ef\u0001\u0000\u0000\u0000\u014c"+
		"\u00f2\u0001\u0000\u0000\u0000\u014c\u00f5\u0001\u0000\u0000\u0000\u014c"+
		"\u00f8\u0001\u0000\u0000\u0000\u014c\u00fb\u0001\u0000\u0000\u0000\u014c"+
		"\u00fe\u0001\u0000\u0000\u0000\u014c\u0101\u0001\u0000\u0000\u0000\u014c"+
		"\u0104\u0001\u0000\u0000\u0000\u014c\u0107\u0001\u0000\u0000\u0000\u014c"+
		"\u010a\u0001\u0000\u0000\u0000\u014c\u010d\u0001\u0000\u0000\u0000\u014c"+
		"\u0110\u0001\u0000\u0000\u0000\u014c\u0113\u0001\u0000\u0000\u0000\u014c"+
		"\u0116\u0001\u0000\u0000\u0000\u014c\u0119\u0001\u0000\u0000\u0000\u014c"+
		"\u011c\u0001\u0000\u0000\u0000\u014c\u011f\u0001\u0000\u0000\u0000\u014c"+
		"\u0122\u0001\u0000\u0000\u0000\u014c\u0125\u0001\u0000\u0000\u0000\u014c"+
		"\u0128\u0001\u0000\u0000\u0000\u014c\u012b\u0001\u0000\u0000\u0000\u014c"+
		"\u012e\u0001\u0000\u0000\u0000\u014c\u0131\u0001\u0000\u0000\u0000\u014c"+
		"\u0134\u0001\u0000\u0000\u0000\u014c\u0137\u0001\u0000\u0000\u0000\u014c"+
		"\u013a\u0001\u0000\u0000\u0000\u014c\u013d\u0001\u0000\u0000\u0000\u014c"+
		"\u0140\u0001\u0000\u0000\u0000\u014c\u0143\u0001\u0000\u0000\u0000\u014c"+
		"\u0146\u0001\u0000\u0000\u0000\u014c\u0149\u0001\u0000\u0000\u0000\u014d"+
		"\u001e\u0001\u0000\u0000\u0000\u014e\u014f\u0005.\u0000\u0000\u014f\u0150"+
		"\u0005l\u0000\u0000\u0150\u0151\u0005o\u0000\u0000\u0151\u0152\u0005W"+
		"\u0000\u0000\u0152\u0153\u0005o\u0000\u0000\u0153\u0154\u0005r\u0000\u0000"+
		"\u0154\u0174\u0005d\u0000\u0000\u0155\u0156\u0005.\u0000\u0000\u0156\u0157"+
		"\u0005l\u0000\u0000\u0157\u0158\u0005o\u0000\u0000\u0158\u0159\u0005B"+
		"\u0000\u0000\u0159\u015a\u0005y\u0000\u0000\u015a\u015b\u0005t\u0000\u0000"+
		"\u015b\u0174\u0005e\u0000\u0000\u015c\u015d\u0005.\u0000\u0000\u015d\u015e"+
		"\u0005h\u0000\u0000\u015e\u015f\u0005i\u0000\u0000\u015f\u0160\u0005W"+
		"\u0000\u0000\u0160\u0161\u0005o\u0000\u0000\u0161\u0162\u0005r\u0000\u0000"+
		"\u0162\u0174\u0005d\u0000\u0000\u0163\u0164\u0005.\u0000\u0000\u0164\u0165"+
		"\u0005h\u0000\u0000\u0165\u0166\u0005i\u0000\u0000\u0166\u0167\u0005B"+
		"\u0000\u0000\u0167\u0168\u0005y\u0000\u0000\u0168\u0169\u0005t\u0000\u0000"+
		"\u0169\u0174\u0005e\u0000\u0000\u016a\u016b\u0005.\u0000\u0000\u016b\u016c"+
		"\u0005b\u0000\u0000\u016c\u016d\u0005a\u0000\u0000\u016d\u016e\u0005n"+
		"\u0000\u0000\u016e\u016f\u0005k\u0000\u0000\u016f\u0170\u0005B\u0000\u0000"+
		"\u0170\u0171\u0005y\u0000\u0000\u0171\u0172\u0005t\u0000\u0000\u0172\u0174"+
		"\u0005e\u0000\u0000\u0173\u014e\u0001\u0000\u0000\u0000\u0173\u0155\u0001"+
		"\u0000\u0000\u0000\u0173\u015c\u0001\u0000\u0000\u0000\u0173\u0163\u0001"+
		"\u0000\u0000\u0000\u0173\u016a\u0001\u0000\u0000\u0000\u0174 \u0001\u0000"+
		"\u0000\u0000\u0175\u0179\u0007\u0001\u0000\u0000\u0176\u0178\u0007\u0002"+
		"\u0000\u0000\u0177\u0176\u0001\u0000\u0000\u0000\u0178\u017b\u0001\u0000"+
		"\u0000\u0000\u0179\u0177\u0001\u0000\u0000\u0000\u0179\u017a\u0001\u0000"+
		"\u0000\u0000\u017a\u0182\u0001\u0000\u0000\u0000\u017b\u0179\u0001\u0000"+
		"\u0000\u0000\u017c\u017d\u0003\u001f\u000f\u0000\u017d\u017e\u0005(\u0000"+
		"\u0000\u017e\u017f\u0003!\u0010\u0000\u017f\u0180\u0005)\u0000\u0000\u0180"+
		"\u0182\u0001\u0000\u0000\u0000\u0181\u0175\u0001\u0000\u0000\u0000\u0181"+
		"\u017c\u0001\u0000\u0000\u0000\u0182\"\u0001\u0000\u0000\u0000\u0183\u0185"+
		"\u0007\u0003\u0000\u0000\u0184\u0183\u0001\u0000\u0000\u0000\u0185\u0186"+
		"\u0001\u0000\u0000\u0000\u0186\u0184\u0001\u0000\u0000\u0000\u0186\u0187"+
		"\u0001\u0000\u0000\u0000\u0187\u018f\u0001\u0000\u0000\u0000\u0188\u018a"+
		"\u0005$\u0000\u0000\u0189\u018b\u0007\u0004\u0000\u0000\u018a\u0189\u0001"+
		"\u0000\u0000\u0000\u018b\u018c\u0001\u0000\u0000\u0000\u018c\u018a\u0001"+
		"\u0000\u0000\u0000\u018c\u018d\u0001\u0000\u0000\u0000\u018d\u018f\u0001"+
		"\u0000\u0000\u0000\u018e\u0184\u0001\u0000\u0000\u0000\u018e\u0188\u0001"+
		"\u0000\u0000\u0000\u018f$\u0001\u0000\u0000\u0000\u0190\u0194\u0005;\u0000"+
		"\u0000\u0191\u0193\b\u0005\u0000\u0000\u0192\u0191\u0001\u0000\u0000\u0000"+
		"\u0193\u0196\u0001\u0000\u0000\u0000\u0194\u0192\u0001\u0000\u0000\u0000"+
		"\u0194\u0195\u0001\u0000\u0000\u0000\u0195&\u0001\u0000\u0000\u0000\u0196"+
		"\u0194\u0001\u0000\u0000\u0000\u0197\u019b\u0005.\u0000\u0000\u0198\u019a"+
		"\b\u0005\u0000\u0000\u0199\u0198\u0001\u0000\u0000\u0000\u019a\u019d\u0001"+
		"\u0000\u0000\u0000\u019b\u0199\u0001\u0000\u0000\u0000\u019b\u019c\u0001"+
		"\u0000\u0000\u0000\u019c\u01aa\u0001\u0000\u0000\u0000\u019d\u019b\u0001"+
		"\u0000\u0000\u0000\u019e\u01a0\b\u0006\u0000\u0000\u019f\u019e\u0001\u0000"+
		"\u0000\u0000\u01a0\u01a1\u0001\u0000\u0000\u0000\u01a1\u019f\u0001\u0000"+
		"\u0000\u0000\u01a1\u01a2\u0001\u0000\u0000\u0000\u01a2\u01a3\u0001\u0000"+
		"\u0000\u0000\u01a3\u01a5\u0005=\u0000\u0000\u01a4\u01a6\b\u0005\u0000"+
		"\u0000\u01a5\u01a4\u0001\u0000\u0000\u0000\u01a6\u01a7\u0001\u0000\u0000"+
		"\u0000\u01a7\u01a5\u0001\u0000\u0000\u0000\u01a7\u01a8\u0001\u0000\u0000"+
		"\u0000\u01a8\u01aa\u0001\u0000\u0000\u0000\u01a9\u0197\u0001\u0000\u0000"+
		"\u0000\u01a9\u019f\u0001\u0000\u0000\u0000\u01aa(\u0001\u0000\u0000\u0000"+
		"\u000e\u0000F\u014c\u0173\u0179\u0181\u0186\u018c\u018e\u0194\u019b\u01a1"+
		"\u01a7\u01a9\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}