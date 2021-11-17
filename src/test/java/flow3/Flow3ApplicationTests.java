package flow3;


import flow3.dsl.gen.Rule.RuleExprLexer;
import flow3.dsl.gen.Rule.RuleExprParser;
import flow3.runtime.listener.TaskRuleListenerExecutor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Flow3ApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("Flow3ApplicationTests.contextLoads");
	}

	@Test
	void dslListener(){
		System.out.println("Flow3ApplicationTests.dslListener");

		String rule = " a = 11 + (22 + 33);";
		rule = " b = 2 * ( 1 + 3 );";
		rule = " c = 2 * ( 1 + (4+8-1)/5);";
		rule = " c = 2 * ( 1 + (4+8-1)/5);";
		rule = " s == 12;";
		rule = " s == (count + 2);";
		//rule = " b =  1 + 3 ;";

		ANTLRInputStream input = new ANTLRInputStream(rule);
		RuleExprLexer lexer = new RuleExprLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		RuleExprParser parser = new RuleExprParser(tokens);
		ParseTree tree = parser.program();

		ParseTreeWalker walker = new ParseTreeWalker();
		TaskRuleListenerExecutor ruleExecutor = new TaskRuleListenerExecutor();

		Map<String, Object> facts = new HashMap<String, Object>();
		facts.put("count", (float)10.0);
		facts.put("s", (float)12.0);
		ruleExecutor.addFacts(facts);

		walker.walk((ParseTreeListener) ruleExecutor, tree);

		System.out.println(tree.toStringTree(parser));
		System.out.printf("ret = %s\n", ruleExecutor.getRet().toString());
		System.out.printf("memory = %s\n", ruleExecutor.getMemory().toString());
		System.out.printf("value = %s\n", ruleExecutor.getValue(tree));

	}
}
