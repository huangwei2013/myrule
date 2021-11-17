// Generated from D:/huangwei/code/myrule/flow4/src/main/java/flow3/dsl/conf/Topology\TopologyExpr.g4 by ANTLR 4.9.1
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
public class TopologyExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, NUMBER=4, VAR=5, FLOAT=6, ASS=7, MUL=8, DIV=9, 
		ADD=10, SUB=11, WS=12, NEWLINE=13, GT=14, GTE=15, LT=16, LTE=17, EQ=18, 
		NEQ=19, AND=20, OR=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "NUMBER", "Char", "StartChar", "DIGIT", "INT", 
			"Identifier", "VAR", "FLOAT", "ASS", "MUL", "DIV", "ADD", "SUB", "WS", 
			"NEWLINE", "GT", "GTE", "LT", "LTE", "EQ", "NEQ", "AND", "OR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'('", "')'", null, null, null, "'='", "'*'", "'/'", "'+'", 
			"'-'", null, null, "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&&'", 
			"'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "NUMBER", "VAR", "FLOAT", "ASS", "MUL", "DIV", 
			"ADD", "SUB", "WS", "NEWLINE", "GT", "GTE", "LT", "LTE", "EQ", "NEQ", 
			"AND", "OR"
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


	public TopologyExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TopologyExpr.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u008a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\5\5@\n\5\3\6"+
		"\3\6\3\6\5\6E\n\6\3\7\3\7\3\b\3\b\3\t\6\tL\n\t\r\t\16\tM\3\n\3\n\7\nR"+
		"\n\n\f\n\16\nU\13\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3"+
		"\17\3\20\3\20\3\21\3\21\3\22\6\22h\n\22\r\22\16\22i\3\22\3\22\3\23\5\23"+
		"o\n\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\2\2"+
		"\34\3\3\5\4\7\5\t\6\13\2\r\2\17\2\21\2\23\2\25\7\27\b\31\t\33\n\35\13"+
		"\37\f!\r#\16%\17\'\20)\21+\22-\23/\24\61\25\63\26\65\27\3\2\5\4\2C\\c"+
		"|\3\2\62;\5\2\13\f\17\17\"\"\2\u008b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\3\67\3\2\2\2\59\3\2\2\2\7;\3\2\2\2\t?\3\2\2\2\13D\3\2\2\2"+
		"\rF\3\2\2\2\17H\3\2\2\2\21K\3\2\2\2\23O\3\2\2\2\25V\3\2\2\2\27X\3\2\2"+
		"\2\31\\\3\2\2\2\33^\3\2\2\2\35`\3\2\2\2\37b\3\2\2\2!d\3\2\2\2#g\3\2\2"+
		"\2%n\3\2\2\2\'t\3\2\2\2)v\3\2\2\2+y\3\2\2\2-{\3\2\2\2/~\3\2\2\2\61\u0081"+
		"\3\2\2\2\63\u0084\3\2\2\2\65\u0087\3\2\2\2\678\7=\2\28\4\3\2\2\29:\7*"+
		"\2\2:\6\3\2\2\2;<\7+\2\2<\b\3\2\2\2=@\5\21\t\2>@\5\27\f\2?=\3\2\2\2?>"+
		"\3\2\2\2@\n\3\2\2\2AE\5\r\7\2BE\7a\2\2CE\5\17\b\2DA\3\2\2\2DB\3\2\2\2"+
		"DC\3\2\2\2E\f\3\2\2\2FG\t\2\2\2G\16\3\2\2\2HI\t\3\2\2I\20\3\2\2\2JL\5"+
		"\17\b\2KJ\3\2\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\22\3\2\2\2OS\5\r\7\2"+
		"PR\5\13\6\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\24\3\2\2\2US\3\2"+
		"\2\2VW\5\23\n\2W\26\3\2\2\2XY\5\21\t\2YZ\7\60\2\2Z[\5\21\t\2[\30\3\2\2"+
		"\2\\]\7?\2\2]\32\3\2\2\2^_\7,\2\2_\34\3\2\2\2`a\7\61\2\2a\36\3\2\2\2b"+
		"c\7-\2\2c \3\2\2\2de\7/\2\2e\"\3\2\2\2fh\t\4\2\2gf\3\2\2\2hi\3\2\2\2i"+
		"g\3\2\2\2ij\3\2\2\2jk\3\2\2\2kl\b\22\2\2l$\3\2\2\2mo\7\17\2\2nm\3\2\2"+
		"\2no\3\2\2\2op\3\2\2\2pq\7\f\2\2qr\3\2\2\2rs\b\23\2\2s&\3\2\2\2tu\7@\2"+
		"\2u(\3\2\2\2vw\7@\2\2wx\7?\2\2x*\3\2\2\2yz\7>\2\2z,\3\2\2\2{|\7>\2\2|"+
		"}\7?\2\2}.\3\2\2\2~\177\7?\2\2\177\u0080\7?\2\2\u0080\60\3\2\2\2\u0081"+
		"\u0082\7#\2\2\u0082\u0083\7?\2\2\u0083\62\3\2\2\2\u0084\u0085\7(\2\2\u0085"+
		"\u0086\7(\2\2\u0086\64\3\2\2\2\u0087\u0088\7~\2\2\u0088\u0089\7~\2\2\u0089"+
		"\66\3\2\2\2\t\2?DMSin\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}