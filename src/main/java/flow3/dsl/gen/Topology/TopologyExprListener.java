// Generated from D:/huangwei/code/myrule/flow3/src/main/java/flow3/dsl/conf/Topology\TopologyExpr.g4 by ANTLR 4.9.1
package flow3.dsl.gen.Topology;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TopologyExprParser}.
 */
public interface TopologyExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TopologyExprParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TopologyExprParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TopologyExprParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TopologyExprParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOpsAndOr}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOpsAndOr(TopologyExprParser.LogicalOpsAndOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOpsAndOr}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOpsAndOr(TopologyExprParser.LogicalOpsAndOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(TopologyExprParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(TopologyExprParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code taskId}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTaskId(TopologyExprParser.TaskIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code taskId}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTaskId(TopologyExprParser.TaskIdContext ctx);
}