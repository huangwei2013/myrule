// Generated from D:/huangwei/code/myrule/flow4/src/main/java/flow3/dsl/conf/Topology\TopologyExpr.g4 by ANTLR 4.9.1
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
	 * Visit a parse tree produced by the {@code defineStat}
	 * labeled alternative in {@link TopologyExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineStat(TopologyExprParser.DefineStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link TopologyExprParser#define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine(TopologyExprParser.DefineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code number}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(TopologyExprParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(TopologyExprParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalOps}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOps(TopologyExprParser.LogicalOpsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(TopologyExprParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(TopologyExprParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(TopologyExprParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(TopologyExprParser.CompareContext ctx);
}