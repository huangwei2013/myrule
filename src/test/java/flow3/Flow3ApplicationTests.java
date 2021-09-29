package flow3;

import flow3.dsl.gen.Calculator.CalculatorExprLexer;
import flow3.dsl.gen.Calculator.CalculatorExprParser;
import flow3.runtime.TaskRuleListenerExecutor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

		ANTLRInputStream input = new ANTLRInputStream(rule);
		CalculatorExprLexer lexer = new CalculatorExprLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CalculatorExprParser parser = new CalculatorExprParser(tokens);
		ParseTree tree = parser.program();

		ParseTreeWalker walker = new ParseTreeWalker();
		TaskRuleListenerExecutor ruleExecutor = new TaskRuleListenerExecutor();
		walker.walk(ruleExecutor, tree);

//		System.out.println(tree.toStringTree(parser));
//		System.out.printf("ret = %s\n", ruleExecutor.get(rule));
		System.out.printf("value = %s\n", ruleExecutor.getValue(tree));

	}
}
