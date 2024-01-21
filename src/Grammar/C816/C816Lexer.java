// Generated from I:/Coding Projects/BBSnCC/src/Grammar/C816.g4 by ANTLR 4.13.1
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
			"T__9", "T__10", "T__11", "T__12", "WS", "Operation", "Symbol", "Number", 
			"Comment", "Preproc"
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
		"\u0004\u0000\u0013\u0194\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0004\rC\b\r\u000b\r\f\rD\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0148\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u014c\b\u000f\n\u000f\f\u000f\u014f\t\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u016b\b\u000f\u0001\u0010\u0004\u0010\u016e\b"+
		"\u0010\u000b\u0010\f\u0010\u016f\u0001\u0010\u0001\u0010\u0004\u0010\u0174"+
		"\b\u0010\u000b\u0010\f\u0010\u0175\u0003\u0010\u0178\b\u0010\u0001\u0011"+
		"\u0001\u0011\u0005\u0011\u017c\b\u0011\n\u0011\f\u0011\u017f\t\u0011\u0001"+
		"\u0012\u0001\u0012\u0005\u0012\u0183\b\u0012\n\u0012\f\u0012\u0186\t\u0012"+
		"\u0001\u0012\u0004\u0012\u0189\b\u0012\u000b\u0012\f\u0012\u018a\u0001"+
		"\u0012\u0001\u0012\u0004\u0012\u018f\b\u0012\u000b\u0012\f\u0012\u0190"+
		"\u0003\u0012\u0193\b\u0012\u0000\u0000\u0013\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\u0001\u0000\u0007\u0003\u0000\t\t\r\r  \u0003\u0000AZ_"+
		"_az\u0004\u000009@Z__az\u0001\u000009\u0003\u000009AFaf\u0001\u0000\n"+
		"\n\u0002\u0000\n\n==\u01f3\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0001\'\u0001\u0000\u0000\u0000\u0003"+
		")\u0001\u0000\u0000\u0000\u0005+\u0001\u0000\u0000\u0000\u0007-\u0001"+
		"\u0000\u0000\u0000\t/\u0001\u0000\u0000\u0000\u000b1\u0001\u0000\u0000"+
		"\u0000\r3\u0001\u0000\u0000\u0000\u000f5\u0001\u0000\u0000\u0000\u0011"+
		"7\u0001\u0000\u0000\u0000\u00139\u0001\u0000\u0000\u0000\u0015;\u0001"+
		"\u0000\u0000\u0000\u0017=\u0001\u0000\u0000\u0000\u0019?\u0001\u0000\u0000"+
		"\u0000\u001bB\u0001\u0000\u0000\u0000\u001d\u0147\u0001\u0000\u0000\u0000"+
		"\u001f\u016a\u0001\u0000\u0000\u0000!\u0177\u0001\u0000\u0000\u0000#\u0179"+
		"\u0001\u0000\u0000\u0000%\u0192\u0001\u0000\u0000\u0000\'(\u0005(\u0000"+
		"\u0000(\u0002\u0001\u0000\u0000\u0000)*\u0005)\u0000\u0000*\u0004\u0001"+
		"\u0000\u0000\u0000+,\u0005,\u0000\u0000,\u0006\u0001\u0000\u0000\u0000"+
		"-.\u0005x\u0000\u0000.\b\u0001\u0000\u0000\u0000/0\u0005y\u0000\u0000"+
		"0\n\u0001\u0000\u0000\u000012\u0005[\u0000\u00002\f\u0001\u0000\u0000"+
		"\u000034\u0005]\u0000\u00004\u000e\u0001\u0000\u0000\u000056\u0005s\u0000"+
		"\u00006\u0010\u0001\u0000\u0000\u000078\u0005#\u0000\u00008\u0012\u0001"+
		"\u0000\u0000\u00009:\u0005+\u0000\u0000:\u0014\u0001\u0000\u0000\u0000"+
		";<\u0005:\u0000\u0000<\u0016\u0001\u0000\u0000\u0000=>\u0005-\u0000\u0000"+
		">\u0018\u0001\u0000\u0000\u0000?@\u0005\n\u0000\u0000@\u001a\u0001\u0000"+
		"\u0000\u0000AC\u0007\u0000\u0000\u0000BA\u0001\u0000\u0000\u0000CD\u0001"+
		"\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000"+
		"EF\u0001\u0000\u0000\u0000FG\u0006\r\u0000\u0000G\u001c\u0001\u0000\u0000"+
		"\u0000HI\u0005A\u0000\u0000IJ\u0005D\u0000\u0000J\u0148\u0005C\u0000\u0000"+
		"KL\u0005A\u0000\u0000LM\u0005N\u0000\u0000M\u0148\u0005D\u0000\u0000N"+
		"O\u0005A\u0000\u0000OP\u0005S\u0000\u0000P\u0148\u0005L\u0000\u0000QR"+
		"\u0005B\u0000\u0000RS\u0005C\u0000\u0000S\u0148\u0005C\u0000\u0000TU\u0005"+
		"B\u0000\u0000UV\u0005C\u0000\u0000V\u0148\u0005S\u0000\u0000WX\u0005B"+
		"\u0000\u0000XY\u0005E\u0000\u0000Y\u0148\u0005Q\u0000\u0000Z[\u0005B\u0000"+
		"\u0000[\\\u0005I\u0000\u0000\\\u0148\u0005T\u0000\u0000]^\u0005B\u0000"+
		"\u0000^_\u0005M\u0000\u0000_\u0148\u0005I\u0000\u0000`a\u0005B\u0000\u0000"+
		"ab\u0005N\u0000\u0000b\u0148\u0005E\u0000\u0000cd\u0005B\u0000\u0000d"+
		"e\u0005P\u0000\u0000e\u0148\u0005L\u0000\u0000fg\u0005B\u0000\u0000gh"+
		"\u0005R\u0000\u0000h\u0148\u0005A\u0000\u0000ij\u0005B\u0000\u0000jk\u0005"+
		"R\u0000\u0000k\u0148\u0005K\u0000\u0000lm\u0005B\u0000\u0000mn\u0005R"+
		"\u0000\u0000n\u0148\u0005L\u0000\u0000op\u0005B\u0000\u0000pq\u0005V\u0000"+
		"\u0000q\u0148\u0005C\u0000\u0000rs\u0005B\u0000\u0000st\u0005V\u0000\u0000"+
		"t\u0148\u0005S\u0000\u0000uv\u0005C\u0000\u0000vw\u0005L\u0000\u0000w"+
		"\u0148\u0005C\u0000\u0000xy\u0005C\u0000\u0000yz\u0005L\u0000\u0000z\u0148"+
		"\u0005D\u0000\u0000{|\u0005C\u0000\u0000|}\u0005L\u0000\u0000}\u0148\u0005"+
		"I\u0000\u0000~\u007f\u0005C\u0000\u0000\u007f\u0080\u0005L\u0000\u0000"+
		"\u0080\u0148\u0005V\u0000\u0000\u0081\u0082\u0005C\u0000\u0000\u0082\u0083"+
		"\u0005M\u0000\u0000\u0083\u0148\u0005P\u0000\u0000\u0084\u0085\u0005C"+
		"\u0000\u0000\u0085\u0086\u0005P\u0000\u0000\u0086\u0148\u0005X\u0000\u0000"+
		"\u0087\u0088\u0005C\u0000\u0000\u0088\u0089\u0005P\u0000\u0000\u0089\u0148"+
		"\u0005Y\u0000\u0000\u008a\u008b\u0005C\u0000\u0000\u008b\u008c\u0005O"+
		"\u0000\u0000\u008c\u0148\u0005P\u0000\u0000\u008d\u008e\u0005D\u0000\u0000"+
		"\u008e\u008f\u0005E\u0000\u0000\u008f\u0148\u0005C\u0000\u0000\u0090\u0091"+
		"\u0005D\u0000\u0000\u0091\u0092\u0005E\u0000\u0000\u0092\u0148\u0005X"+
		"\u0000\u0000\u0093\u0094\u0005D\u0000\u0000\u0094\u0095\u0005E\u0000\u0000"+
		"\u0095\u0148\u0005Y\u0000\u0000\u0096\u0097\u0005E\u0000\u0000\u0097\u0098"+
		"\u0005O\u0000\u0000\u0098\u0148\u0005R\u0000\u0000\u0099\u009a\u0005I"+
		"\u0000\u0000\u009a\u009b\u0005N\u0000\u0000\u009b\u0148\u0005C\u0000\u0000"+
		"\u009c\u009d\u0005I\u0000\u0000\u009d\u009e\u0005N\u0000\u0000\u009e\u0148"+
		"\u0005X\u0000\u0000\u009f\u00a0\u0005J\u0000\u0000\u00a0\u00a1\u0005M"+
		"\u0000\u0000\u00a1\u0148\u0005P\u0000\u0000\u00a2\u00a3\u0005J\u0000\u0000"+
		"\u00a3\u00a4\u0005M\u0000\u0000\u00a4\u0148\u0005L\u0000\u0000\u00a5\u00a6"+
		"\u0005J\u0000\u0000\u00a6\u00a7\u0005S\u0000\u0000\u00a7\u0148\u0005L"+
		"\u0000\u0000\u00a8\u00a9\u0005L\u0000\u0000\u00a9\u00aa\u0005D\u0000\u0000"+
		"\u00aa\u0148\u0005A\u0000\u0000\u00ab\u00ac\u0005L\u0000\u0000\u00ac\u00ad"+
		"\u0005D\u0000\u0000\u00ad\u0148\u0005X\u0000\u0000\u00ae\u00af\u0005L"+
		"\u0000\u0000\u00af\u00b0\u0005D\u0000\u0000\u00b0\u0148\u0005Y\u0000\u0000"+
		"\u00b1\u00b2\u0005L\u0000\u0000\u00b2\u00b3\u0005S\u0000\u0000\u00b3\u0148"+
		"\u0005R\u0000\u0000\u00b4\u00b5\u0005M\u0000\u0000\u00b5\u00b6\u0005V"+
		"\u0000\u0000\u00b6\u0148\u0005N\u0000\u0000\u00b7\u00b8\u0005M\u0000\u0000"+
		"\u00b8\u00b9\u0005V\u0000\u0000\u00b9\u0148\u0005P\u0000\u0000\u00ba\u00bb"+
		"\u0005N\u0000\u0000\u00bb\u00bc\u0005O\u0000\u0000\u00bc\u0148\u0005P"+
		"\u0000\u0000\u00bd\u00be\u0005O\u0000\u0000\u00be\u00bf\u0005R\u0000\u0000"+
		"\u00bf\u0148\u0005A\u0000\u0000\u00c0\u00c1\u0005P\u0000\u0000\u00c1\u00c2"+
		"\u0005E\u0000\u0000\u00c2\u0148\u0005A\u0000\u0000\u00c3\u00c4\u0005P"+
		"\u0000\u0000\u00c4\u00c5\u0005E\u0000\u0000\u00c5\u0148\u0005I\u0000\u0000"+
		"\u00c6\u00c7\u0005P\u0000\u0000\u00c7\u00c8\u0005E\u0000\u0000\u00c8\u0148"+
		"\u0005R\u0000\u0000\u00c9\u00ca\u0005P\u0000\u0000\u00ca\u00cb\u0005H"+
		"\u0000\u0000\u00cb\u0148\u0005A\u0000\u0000\u00cc\u00cd\u0005P\u0000\u0000"+
		"\u00cd\u00ce\u0005H\u0000\u0000\u00ce\u0148\u0005D\u0000\u0000\u00cf\u00d0"+
		"\u0005P\u0000\u0000\u00d0\u00d1\u0005H\u0000\u0000\u00d1\u0148\u0005K"+
		"\u0000\u0000\u00d2\u00d3\u0005P\u0000\u0000\u00d3\u00d4\u0005H\u0000\u0000"+
		"\u00d4\u0148\u0005X\u0000\u0000\u00d5\u00d6\u0005P\u0000\u0000\u00d6\u00d7"+
		"\u0005H\u0000\u0000\u00d7\u0148\u0005Y\u0000\u0000\u00d8\u00d9\u0005P"+
		"\u0000\u0000\u00d9\u00da\u0005L\u0000\u0000\u00da\u0148\u0005A\u0000\u0000"+
		"\u00db\u00dc\u0005P\u0000\u0000\u00dc\u00dd\u0005L\u0000\u0000\u00dd\u0148"+
		"\u0005D\u0000\u0000\u00de\u00df\u0005P\u0000\u0000\u00df\u00e0\u0005L"+
		"\u0000\u0000\u00e0\u0148\u0005P\u0000\u0000\u00e1\u00e2\u0005P\u0000\u0000"+
		"\u00e2\u00e3\u0005L\u0000\u0000\u00e3\u0148\u0005X\u0000\u0000\u00e4\u00e5"+
		"\u0005P\u0000\u0000\u00e5\u00e6\u0005L\u0000\u0000\u00e6\u0148\u0005Y"+
		"\u0000\u0000\u00e7\u00e8\u0005R\u0000\u0000\u00e8\u00e9\u0005E\u0000\u0000"+
		"\u00e9\u0148\u0005P\u0000\u0000\u00ea\u00eb\u0005R\u0000\u0000\u00eb\u00ec"+
		"\u0005O\u0000\u0000\u00ec\u0148\u0005L\u0000\u0000\u00ed\u00ee\u0005R"+
		"\u0000\u0000\u00ee\u00ef\u0005O\u0000\u0000\u00ef\u0148\u0005R\u0000\u0000"+
		"\u00f0\u00f1\u0005R\u0000\u0000\u00f1\u00f2\u0005T\u0000\u0000\u00f2\u0148"+
		"\u0005I\u0000\u0000\u00f3\u00f4\u0005R\u0000\u0000\u00f4\u00f5\u0005T"+
		"\u0000\u0000\u00f5\u0148\u0005S\u0000\u0000\u00f6\u00f7\u0005R\u0000\u0000"+
		"\u00f7\u00f8\u0005T\u0000\u0000\u00f8\u0148\u0005L\u0000\u0000\u00f9\u00fa"+
		"\u0005S\u0000\u0000\u00fa\u00fb\u0005B\u0000\u0000\u00fb\u0148\u0005C"+
		"\u0000\u0000\u00fc\u00fd\u0005S\u0000\u0000\u00fd\u00fe\u0005E\u0000\u0000"+
		"\u00fe\u0148\u0005C\u0000\u0000\u00ff\u0100\u0005S\u0000\u0000\u0100\u0101"+
		"\u0005E\u0000\u0000\u0101\u0148\u0005D\u0000\u0000\u0102\u0103\u0005S"+
		"\u0000\u0000\u0103\u0104\u0005E\u0000\u0000\u0104\u0148\u0005I\u0000\u0000"+
		"\u0105\u0106\u0005S\u0000\u0000\u0106\u0107\u0005E\u0000\u0000\u0107\u0148"+
		"\u0005P\u0000\u0000\u0108\u0109\u0005S\u0000\u0000\u0109\u010a\u0005T"+
		"\u0000\u0000\u010a\u0148\u0005A\u0000\u0000\u010b\u010c\u0005S\u0000\u0000"+
		"\u010c\u010d\u0005T\u0000\u0000\u010d\u0148\u0005X\u0000\u0000\u010e\u010f"+
		"\u0005S\u0000\u0000\u010f\u0110\u0005T\u0000\u0000\u0110\u0148\u0005Y"+
		"\u0000\u0000\u0111\u0112\u0005S\u0000\u0000\u0112\u0113\u0005T\u0000\u0000"+
		"\u0113\u0148\u0005P\u0000\u0000\u0114\u0115\u0005S\u0000\u0000\u0115\u0116"+
		"\u0005T\u0000\u0000\u0116\u0148\u0005Z\u0000\u0000\u0117\u0118\u0005T"+
		"\u0000\u0000\u0118\u0119\u0005A\u0000\u0000\u0119\u0148\u0005X\u0000\u0000"+
		"\u011a\u011b\u0005T\u0000\u0000\u011b\u011c\u0005A\u0000\u0000\u011c\u0148"+
		"\u0005Y\u0000\u0000\u011d\u011e\u0005T\u0000\u0000\u011e\u011f\u0005C"+
		"\u0000\u0000\u011f\u0148\u0005D\u0000\u0000\u0120\u0121\u0005T\u0000\u0000"+
		"\u0121\u0122\u0005C\u0000\u0000\u0122\u0148\u0005S\u0000\u0000\u0123\u0124"+
		"\u0005T\u0000\u0000\u0124\u0125\u0005D\u0000\u0000\u0125\u0148\u0005C"+
		"\u0000\u0000\u0126\u0127\u0005T\u0000\u0000\u0127\u0128\u0005S\u0000\u0000"+
		"\u0128\u0148\u0005C\u0000\u0000\u0129\u012a\u0005T\u0000\u0000\u012a\u012b"+
		"\u0005S\u0000\u0000\u012b\u0148\u0005X\u0000\u0000\u012c\u012d\u0005T"+
		"\u0000\u0000\u012d\u012e\u0005X\u0000\u0000\u012e\u0148\u0005A\u0000\u0000"+
		"\u012f\u0130\u0005T\u0000\u0000\u0130\u0131\u0005X\u0000\u0000\u0131\u0148"+
		"\u0005S\u0000\u0000\u0132\u0133\u0005T\u0000\u0000\u0133\u0134\u0005X"+
		"\u0000\u0000\u0134\u0148\u0005Y\u0000\u0000\u0135\u0136\u0005T\u0000\u0000"+
		"\u0136\u0137\u0005Y\u0000\u0000\u0137\u0148\u0005A\u0000\u0000\u0138\u0139"+
		"\u0005T\u0000\u0000\u0139\u013a\u0005Y\u0000\u0000\u013a\u0148\u0005X"+
		"\u0000\u0000\u013b\u013c\u0005T\u0000\u0000\u013c\u013d\u0005R\u0000\u0000"+
		"\u013d\u0148\u0005B\u0000\u0000\u013e\u013f\u0005T\u0000\u0000\u013f\u0140"+
		"\u0005S\u0000\u0000\u0140\u0148\u0005B\u0000\u0000\u0141\u0142\u0005W"+
		"\u0000\u0000\u0142\u0143\u0005A\u0000\u0000\u0143\u0148\u0005I\u0000\u0000"+
		"\u0144\u0145\u0005X\u0000\u0000\u0145\u0146\u0005C\u0000\u0000\u0146\u0148"+
		"\u0005E\u0000\u0000\u0147H\u0001\u0000\u0000\u0000\u0147K\u0001\u0000"+
		"\u0000\u0000\u0147N\u0001\u0000\u0000\u0000\u0147Q\u0001\u0000\u0000\u0000"+
		"\u0147T\u0001\u0000\u0000\u0000\u0147W\u0001\u0000\u0000\u0000\u0147Z"+
		"\u0001\u0000\u0000\u0000\u0147]\u0001\u0000\u0000\u0000\u0147`\u0001\u0000"+
		"\u0000\u0000\u0147c\u0001\u0000\u0000\u0000\u0147f\u0001\u0000\u0000\u0000"+
		"\u0147i\u0001\u0000\u0000\u0000\u0147l\u0001\u0000\u0000\u0000\u0147o"+
		"\u0001\u0000\u0000\u0000\u0147r\u0001\u0000\u0000\u0000\u0147u\u0001\u0000"+
		"\u0000\u0000\u0147x\u0001\u0000\u0000\u0000\u0147{\u0001\u0000\u0000\u0000"+
		"\u0147~\u0001\u0000\u0000\u0000\u0147\u0081\u0001\u0000\u0000\u0000\u0147"+
		"\u0084\u0001\u0000\u0000\u0000\u0147\u0087\u0001\u0000\u0000\u0000\u0147"+
		"\u008a\u0001\u0000\u0000\u0000\u0147\u008d\u0001\u0000\u0000\u0000\u0147"+
		"\u0090\u0001\u0000\u0000\u0000\u0147\u0093\u0001\u0000\u0000\u0000\u0147"+
		"\u0096\u0001\u0000\u0000\u0000\u0147\u0099\u0001\u0000\u0000\u0000\u0147"+
		"\u009c\u0001\u0000\u0000\u0000\u0147\u009f\u0001\u0000\u0000\u0000\u0147"+
		"\u00a2\u0001\u0000\u0000\u0000\u0147\u00a5\u0001\u0000\u0000\u0000\u0147"+
		"\u00a8\u0001\u0000\u0000\u0000\u0147\u00ab\u0001\u0000\u0000\u0000\u0147"+
		"\u00ae\u0001\u0000\u0000\u0000\u0147\u00b1\u0001\u0000\u0000\u0000\u0147"+
		"\u00b4\u0001\u0000\u0000\u0000\u0147\u00b7\u0001\u0000\u0000\u0000\u0147"+
		"\u00ba\u0001\u0000\u0000\u0000\u0147\u00bd\u0001\u0000\u0000\u0000\u0147"+
		"\u00c0\u0001\u0000\u0000\u0000\u0147\u00c3\u0001\u0000\u0000\u0000\u0147"+
		"\u00c6\u0001\u0000\u0000\u0000\u0147\u00c9\u0001\u0000\u0000\u0000\u0147"+
		"\u00cc\u0001\u0000\u0000\u0000\u0147\u00cf\u0001\u0000\u0000\u0000\u0147"+
		"\u00d2\u0001\u0000\u0000\u0000\u0147\u00d5\u0001\u0000\u0000\u0000\u0147"+
		"\u00d8\u0001\u0000\u0000\u0000\u0147\u00db\u0001\u0000\u0000\u0000\u0147"+
		"\u00de\u0001\u0000\u0000\u0000\u0147\u00e1\u0001\u0000\u0000\u0000\u0147"+
		"\u00e4\u0001\u0000\u0000\u0000\u0147\u00e7\u0001\u0000\u0000\u0000\u0147"+
		"\u00ea\u0001\u0000\u0000\u0000\u0147\u00ed\u0001\u0000\u0000\u0000\u0147"+
		"\u00f0\u0001\u0000\u0000\u0000\u0147\u00f3\u0001\u0000\u0000\u0000\u0147"+
		"\u00f6\u0001\u0000\u0000\u0000\u0147\u00f9\u0001\u0000\u0000\u0000\u0147"+
		"\u00fc\u0001\u0000\u0000\u0000\u0147\u00ff\u0001\u0000\u0000\u0000\u0147"+
		"\u0102\u0001\u0000\u0000\u0000\u0147\u0105\u0001\u0000\u0000\u0000\u0147"+
		"\u0108\u0001\u0000\u0000\u0000\u0147\u010b\u0001\u0000\u0000\u0000\u0147"+
		"\u010e\u0001\u0000\u0000\u0000\u0147\u0111\u0001\u0000\u0000\u0000\u0147"+
		"\u0114\u0001\u0000\u0000\u0000\u0147\u0117\u0001\u0000\u0000\u0000\u0147"+
		"\u011a\u0001\u0000\u0000\u0000\u0147\u011d\u0001\u0000\u0000\u0000\u0147"+
		"\u0120\u0001\u0000\u0000\u0000\u0147\u0123\u0001\u0000\u0000\u0000\u0147"+
		"\u0126\u0001\u0000\u0000\u0000\u0147\u0129\u0001\u0000\u0000\u0000\u0147"+
		"\u012c\u0001\u0000\u0000\u0000\u0147\u012f\u0001\u0000\u0000\u0000\u0147"+
		"\u0132\u0001\u0000\u0000\u0000\u0147\u0135\u0001\u0000\u0000\u0000\u0147"+
		"\u0138\u0001\u0000\u0000\u0000\u0147\u013b\u0001\u0000\u0000\u0000\u0147"+
		"\u013e\u0001\u0000\u0000\u0000\u0147\u0141\u0001\u0000\u0000\u0000\u0147"+
		"\u0144\u0001\u0000\u0000\u0000\u0148\u001e\u0001\u0000\u0000\u0000\u0149"+
		"\u014d\u0007\u0001\u0000\u0000\u014a\u014c\u0007\u0002\u0000\u0000\u014b"+
		"\u014a\u0001\u0000\u0000\u0000\u014c\u014f\u0001\u0000\u0000\u0000\u014d"+
		"\u014b\u0001\u0000\u0000\u0000\u014d\u014e\u0001\u0000\u0000\u0000\u014e"+
		"\u016b\u0001\u0000\u0000\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u0150"+
		"\u0151\u0005.\u0000\u0000\u0151\u0152\u0005l\u0000\u0000\u0152\u0153\u0005"+
		"o\u0000\u0000\u0153\u0154\u0005W\u0000\u0000\u0154\u0155\u0005o\u0000"+
		"\u0000\u0155\u0156\u0005r\u0000\u0000\u0156\u0157\u0005d\u0000\u0000\u0157"+
		"\u0158\u0005(\u0000\u0000\u0158\u0159\u0001\u0000\u0000\u0000\u0159\u015a"+
		"\u0003\u001f\u000f\u0000\u015a\u015b\u0005)\u0000\u0000\u015b\u016b\u0001"+
		"\u0000\u0000\u0000\u015c\u015d\u0005.\u0000\u0000\u015d\u015e\u0005b\u0000"+
		"\u0000\u015e\u015f\u0005a\u0000\u0000\u015f\u0160\u0005n\u0000\u0000\u0160"+
		"\u0161\u0005k\u0000\u0000\u0161\u0162\u0005B\u0000\u0000\u0162\u0163\u0005"+
		"y\u0000\u0000\u0163\u0164\u0005t\u0000\u0000\u0164\u0165\u0005e\u0000"+
		"\u0000\u0165\u0166\u0005(\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000"+
		"\u0167\u0168\u0003\u001f\u000f\u0000\u0168\u0169\u0005)\u0000\u0000\u0169"+
		"\u016b\u0001\u0000\u0000\u0000\u016a\u0149\u0001\u0000\u0000\u0000\u016a"+
		"\u0150\u0001\u0000\u0000\u0000\u016a\u015c\u0001\u0000\u0000\u0000\u016b"+
		" \u0001\u0000\u0000\u0000\u016c\u016e\u0007\u0003\u0000\u0000\u016d\u016c"+
		"\u0001\u0000\u0000\u0000\u016e\u016f\u0001\u0000\u0000\u0000\u016f\u016d"+
		"\u0001\u0000\u0000\u0000\u016f\u0170\u0001\u0000\u0000\u0000\u0170\u0178"+
		"\u0001\u0000\u0000\u0000\u0171\u0173\u0005$\u0000\u0000\u0172\u0174\u0007"+
		"\u0004\u0000\u0000\u0173\u0172\u0001\u0000\u0000\u0000\u0174\u0175\u0001"+
		"\u0000\u0000\u0000\u0175\u0173\u0001\u0000\u0000\u0000\u0175\u0176\u0001"+
		"\u0000\u0000\u0000\u0176\u0178\u0001\u0000\u0000\u0000\u0177\u016d\u0001"+
		"\u0000\u0000\u0000\u0177\u0171\u0001\u0000\u0000\u0000\u0178\"\u0001\u0000"+
		"\u0000\u0000\u0179\u017d\u0005;\u0000\u0000\u017a\u017c\b\u0005\u0000"+
		"\u0000\u017b\u017a\u0001\u0000\u0000\u0000\u017c\u017f\u0001\u0000\u0000"+
		"\u0000\u017d\u017b\u0001\u0000\u0000\u0000\u017d\u017e\u0001\u0000\u0000"+
		"\u0000\u017e$\u0001\u0000\u0000\u0000\u017f\u017d\u0001\u0000\u0000\u0000"+
		"\u0180\u0184\u0005.\u0000\u0000\u0181\u0183\b\u0005\u0000\u0000\u0182"+
		"\u0181\u0001\u0000\u0000\u0000\u0183\u0186\u0001\u0000\u0000\u0000\u0184"+
		"\u0182\u0001\u0000\u0000\u0000\u0184\u0185\u0001\u0000\u0000\u0000\u0185"+
		"\u0193\u0001\u0000\u0000\u0000\u0186\u0184\u0001\u0000\u0000\u0000\u0187"+
		"\u0189\b\u0006\u0000\u0000\u0188\u0187\u0001\u0000\u0000\u0000\u0189\u018a"+
		"\u0001\u0000\u0000\u0000\u018a\u0188\u0001\u0000\u0000\u0000\u018a\u018b"+
		"\u0001\u0000\u0000\u0000\u018b\u018c\u0001\u0000\u0000\u0000\u018c\u018e"+
		"\u0005=\u0000\u0000\u018d\u018f\b\u0005\u0000\u0000\u018e\u018d\u0001"+
		"\u0000\u0000\u0000\u018f\u0190\u0001\u0000\u0000\u0000\u0190\u018e\u0001"+
		"\u0000\u0000\u0000\u0190\u0191\u0001\u0000\u0000\u0000\u0191\u0193\u0001"+
		"\u0000\u0000\u0000\u0192\u0180\u0001\u0000\u0000\u0000\u0192\u0188\u0001"+
		"\u0000\u0000\u0000\u0193&\u0001\u0000\u0000\u0000\r\u0000D\u0147\u014d"+
		"\u016a\u016f\u0175\u0177\u017d\u0184\u018a\u0190\u0192\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}