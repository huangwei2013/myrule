// Generated from D:/huangwei/code/myrule/flow3/src/main/java/flow3/dsl/conf/Topology\TopologyExpr.g4 by ANTLR 4.9.1
package flow3.dsl.gen.Topology;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TopologyExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TopologyExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TopologyExprParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(TopologyExprParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalOpsAndOr}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOpsAndOr(TopologyExprParser.LogicalOpsAndOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(TopologyExprParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code taskId}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTaskId(TopologyExprParser.TaskIdContext ctx);
}