// Generated from D:/huangwei/code/myrule/flow3/src/main/java/flow3/dsl/conf/Calculator\CalculatorExpr.g4 by ANTLR 4.9.1
package flow3.dsl.gen.Calculator;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculatorExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, NUMBER=6, VAR=7, INT=8, FLOAT=9, 
		NEWLINE=10, WS=11, MUL=12, DIV=13, ADD=14, SUB=15, GT=16, GTE=17, LT=18, 
		LTE=19, EQ=20, NEQ=21, AND=22, OR=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "NUMBER", "VAR", "INT", "FLOAT", 
			"NEWLINE", "WS", "MUL", "DIV", "ADD", "SUB", "GT", "GTE", "LT", "LTE", 
			"EQ", "NEQ", "AND", "OR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "';'", "'('", "')'", "'print'", null, null, null, null, 
			null, null, "'*'", "'/'", "'+'", "'-'", "'>'", "'>='", "'<'", "'<='", 
			"'=='", "'!='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "NUMBER", "VAR", "INT", "FLOAT", 
			"NEWLINE", "WS", "MUL", "DIV", "ADD", "SUB", "GT", "GTE", "LT", "LTE", 
			"EQ", "NEQ", "AND", "OR"
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


	public CalculatorExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CalculatorExpr.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u0085\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\5\7B\n\7"+
		"\3\b\3\b\7\bF\n\b\f\b\16\bI\13\b\3\t\6\tL\n\t\r\t\16\tM\3\n\6\nQ\n\n\r"+
		"\n\16\nR\3\n\3\n\6\nW\n\n\r\n\16\nX\3\13\5\13\\\n\13\3\13\5\13_\n\13\3"+
		"\f\6\fb\n\f\r\f\16\fc\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\3\2\6\4\2C\\c|\5\2\62;C\\c|\3\2\62;\4\2\13\13\"\"\2\u008c"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\3\61\3\2\2\2\5\63\3\2\2\2\7\65\3\2\2\2\t\67\3\2\2\2\139\3\2\2\2\rA"+
		"\3\2\2\2\17C\3\2\2\2\21K\3\2\2\2\23P\3\2\2\2\25[\3\2\2\2\27a\3\2\2\2\31"+
		"g\3\2\2\2\33i\3\2\2\2\35k\3\2\2\2\37m\3\2\2\2!o\3\2\2\2#q\3\2\2\2%t\3"+
		"\2\2\2\'v\3\2\2\2)y\3\2\2\2+|\3\2\2\2-\177\3\2\2\2/\u0082\3\2\2\2\61\62"+
		"\7?\2\2\62\4\3\2\2\2\63\64\7=\2\2\64\6\3\2\2\2\65\66\7*\2\2\66\b\3\2\2"+
		"\2\678\7+\2\28\n\3\2\2\29:\7r\2\2:;\7t\2\2;<\7k\2\2<=\7p\2\2=>\7v\2\2"+
		">\f\3\2\2\2?B\5\21\t\2@B\5\23\n\2A?\3\2\2\2A@\3\2\2\2B\16\3\2\2\2CG\t"+
		"\2\2\2DF\t\3\2\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\20\3\2\2\2I"+
		"G\3\2\2\2JL\t\4\2\2KJ\3\2\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\22\3\2\2"+
		"\2OQ\t\4\2\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2ST\3\2\2\2TV\7\60"+
		"\2\2UW\t\4\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\24\3\2\2\2Z\\"+
		"\7\17\2\2[Z\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2]_\7\f\2\2^]\3\2\2\2^_\3\2\2"+
		"\2_\26\3\2\2\2`b\t\5\2\2a`\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2de\3\2"+
		"\2\2ef\b\f\2\2f\30\3\2\2\2gh\7,\2\2h\32\3\2\2\2ij\7\61\2\2j\34\3\2\2\2"+
		"kl\7-\2\2l\36\3\2\2\2mn\7/\2\2n \3\2\2\2op\7@\2\2p\"\3\2\2\2qr\7@\2\2"+
		"rs\7?\2\2s$\3\2\2\2tu\7>\2\2u&\3\2\2\2vw\7>\2\2wx\7?\2\2x(\3\2\2\2yz\7"+
		"?\2\2z{\7?\2\2{*\3\2\2\2|}\7#\2\2}~\7?\2\2~,\3\2\2\2\177\u0080\7(\2\2"+
		"\u0080\u0081\7(\2\2\u0081.\3\2\2\2\u0082\u0083\7~\2\2\u0083\u0084\7~\2"+
		"\2\u0084\60\3\2\2\2\13\2AGMRX[^c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}