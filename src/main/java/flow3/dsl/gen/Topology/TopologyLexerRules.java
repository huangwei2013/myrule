// Generated from D:/huangwei/code/myrule/flow4/src/main/java/flow3/dsl/conf/Topology\TopologyLexerRules.g4 by ANTLR 4.9.1
package flow3.dsl.gen.Topology;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TopologyLexerRules extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBER=1, VAR=2, FLOAT=3, ASS=4, MUL=5, DIV=6, ADD=7, SUB=8, WS=9, NEWLINE=10, 
		GT=11, GTE=12, LT=13, LTE=14, EQ=15, NEQ=16, AND=17, OR=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NUMBER", "Char", "StartChar", "DIGIT", "INT", "Identifier", "VAR", "FLOAT", 
			"ASS", "MUL", "DIV", "ADD", "SUB", "WS", "NEWLINE", "GT", "GTE", "LT", 
			"LTE", "EQ", "NEQ", "AND", "OR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'='", "'*'", "'/'", "'+'", "'-'", null, null, 
			"'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NUMBER", "VAR", "FLOAT", "ASS", "MUL", "DIV", "ADD", "SUB", "WS", 
			"NEWLINE", "GT", "GTE", "LT", "LTE", "EQ", "NEQ", "AND", "OR"
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


	public TopologyLexerRules(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TopologyLexerRules.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24~\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\5"+
		"\2\64\n\2\3\3\3\3\3\3\5\39\n\3\3\4\3\4\3\5\3\5\3\6\6\6@\n\6\r\6\16\6A"+
		"\3\7\3\7\7\7F\n\7\f\7\16\7I\13\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\6\17\\\n\17\r\17\16\17]\3\17\3\17"+
		"\3\20\5\20c\n\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\2\2\31\3\3\5\2\7\2\t\2\13\2\r\2\17\4\21\5\23\6\25\7\27\b\31\t\33"+
		"\n\35\13\37\f!\r#\16%\17\'\20)\21+\22-\23/\24\3\2\5\4\2C\\c|\3\2\62;\5"+
		"\2\13\f\17\17\"\"\2\177\2\3\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\63\3\2\2\2\58\3\2\2\2\7:\3\2\2\2\t"+
		"<\3\2\2\2\13?\3\2\2\2\rC\3\2\2\2\17J\3\2\2\2\21L\3\2\2\2\23P\3\2\2\2\25"+
		"R\3\2\2\2\27T\3\2\2\2\31V\3\2\2\2\33X\3\2\2\2\35[\3\2\2\2\37b\3\2\2\2"+
		"!h\3\2\2\2#j\3\2\2\2%m\3\2\2\2\'o\3\2\2\2)r\3\2\2\2+u\3\2\2\2-x\3\2\2"+
		"\2/{\3\2\2\2\61\64\5\13\6\2\62\64\5\21\t\2\63\61\3\2\2\2\63\62\3\2\2\2"+
		"\64\4\3\2\2\2\659\5\7\4\2\669\7a\2\2\679\5\t\5\28\65\3\2\2\28\66\3\2\2"+
		"\28\67\3\2\2\29\6\3\2\2\2:;\t\2\2\2;\b\3\2\2\2<=\t\3\2\2=\n\3\2\2\2>@"+
		"\5\t\5\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\f\3\2\2\2CG\5\7\4\2"+
		"DF\5\5\3\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\16\3\2\2\2IG\3\2\2"+
		"\2JK\5\r\7\2K\20\3\2\2\2LM\5\13\6\2MN\7\60\2\2NO\5\13\6\2O\22\3\2\2\2"+
		"PQ\7?\2\2Q\24\3\2\2\2RS\7,\2\2S\26\3\2\2\2TU\7\61\2\2U\30\3\2\2\2VW\7"+
		"-\2\2W\32\3\2\2\2XY\7/\2\2Y\34\3\2\2\2Z\\\t\4\2\2[Z\3\2\2\2\\]\3\2\2\2"+
		"][\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\b\17\2\2`\36\3\2\2\2ac\7\17\2\2ba\3\2"+
		"\2\2bc\3\2\2\2cd\3\2\2\2de\7\f\2\2ef\3\2\2\2fg\b\20\2\2g \3\2\2\2hi\7"+
		"@\2\2i\"\3\2\2\2jk\7@\2\2kl\7?\2\2l$\3\2\2\2mn\7>\2\2n&\3\2\2\2op\7>\2"+
		"\2pq\7?\2\2q(\3\2\2\2rs\7?\2\2st\7?\2\2t*\3\2\2\2uv\7#\2\2vw\7?\2\2w,"+
		"\3\2\2\2xy\7(\2\2yz\7(\2\2z.\3\2\2\2{|\7~\2\2|}\7~\2\2}\60\3\2\2\2\t\2"+
		"\638AG]b\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}