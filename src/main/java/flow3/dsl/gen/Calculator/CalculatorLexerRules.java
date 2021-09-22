// Generated from D:/huangwei/code/myrule/flow3/src/main/java/flow3/dsl/conf/Calculator\CalculatorLexerRules.g4 by ANTLR 4.9.1
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
public class CalculatorLexerRules extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBER=1, VAR=2, INT=3, FLOAT=4, NEWLINE=5, WS=6, MUL=7, DIV=8, ADD=9, 
		SUB=10, GT=11, GTE=12, LT=13, LTE=14, EQ=15, NEQ=16, AND=17, OR=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NUMBER", "VAR", "INT", "FLOAT", "NEWLINE", "WS", "MUL", "DIV", "ADD", 
			"SUB", "GT", "GTE", "LT", "LTE", "EQ", "NEQ", "AND", "OR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, "'*'", "'/'", "'+'", "'-'", 
			"'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NUMBER", "VAR", "INT", "FLOAT", "NEWLINE", "WS", "MUL", "DIV", 
			"ADD", "SUB", "GT", "GTE", "LT", "LTE", "EQ", "NEQ", "AND", "OR"
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


	public CalculatorLexerRules(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CalculatorLexerRules.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24m\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\5\2*\n\2\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\4\6\4"+
		"\64\n\4\r\4\16\4\65\3\5\6\59\n\5\r\5\16\5:\3\5\3\5\6\5?\n\5\r\5\16\5@"+
		"\3\6\5\6D\n\6\3\6\5\6G\n\6\3\7\6\7J\n\7\r\7\16\7K\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\2\2\24\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\3\2\6\4\2C\\c|\5\2\62;C\\c|\3\2\62;\4\2\13\13\"\"\2t\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\3)\3\2\2\2\5+\3\2\2\2\7\63\3\2\2\2\t8\3\2\2\2\13C\3\2\2\2"+
		"\rI\3\2\2\2\17O\3\2\2\2\21Q\3\2\2\2\23S\3\2\2\2\25U\3\2\2\2\27W\3\2\2"+
		"\2\31Y\3\2\2\2\33\\\3\2\2\2\35^\3\2\2\2\37a\3\2\2\2!d\3\2\2\2#g\3\2\2"+
		"\2%j\3\2\2\2\'*\5\7\4\2(*\5\t\5\2)\'\3\2\2\2)(\3\2\2\2*\4\3\2\2\2+/\t"+
		"\2\2\2,.\t\3\2\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\6\3\2"+
		"\2\2\61/\3\2\2\2\62\64\t\4\2\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2"+
		"\2\65\66\3\2\2\2\66\b\3\2\2\2\679\t\4\2\28\67\3\2\2\29:\3\2\2\2:8\3\2"+
		"\2\2:;\3\2\2\2;<\3\2\2\2<>\7\60\2\2=?\t\4\2\2>=\3\2\2\2?@\3\2\2\2@>\3"+
		"\2\2\2@A\3\2\2\2A\n\3\2\2\2BD\7\17\2\2CB\3\2\2\2CD\3\2\2\2DF\3\2\2\2E"+
		"G\7\f\2\2FE\3\2\2\2FG\3\2\2\2G\f\3\2\2\2HJ\t\5\2\2IH\3\2\2\2JK\3\2\2\2"+
		"KI\3\2\2\2KL\3\2\2\2LM\3\2\2\2MN\b\7\2\2N\16\3\2\2\2OP\7,\2\2P\20\3\2"+
		"\2\2QR\7\61\2\2R\22\3\2\2\2ST\7-\2\2T\24\3\2\2\2UV\7/\2\2V\26\3\2\2\2"+
		"WX\7@\2\2X\30\3\2\2\2YZ\7@\2\2Z[\7?\2\2[\32\3\2\2\2\\]\7>\2\2]\34\3\2"+
		"\2\2^_\7>\2\2_`\7?\2\2`\36\3\2\2\2ab\7?\2\2bc\7?\2\2c \3\2\2\2de\7#\2"+
		"\2ef\7?\2\2f\"\3\2\2\2gh\7(\2\2hi\7(\2\2i$\3\2\2\2jk\7~\2\2kl\7~\2\2l"+
		"&\3\2\2\2\13\2)/\65:@CFK\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}