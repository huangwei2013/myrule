// Generated from D:/huangwei/code/myrule/flow4/src/main/java/flow3/dsl/conf/Topology\TopologyExpr.g4 by ANTLR 4.9.1
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
	 * Enter a parse tree produced by the {@code defineStat}
	 * labeled alternative in {@link TopologyExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDefineStat(TopologyExprParser.DefineStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code defineStat}
	 * labeled alternative in {@link TopologyExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDefineStat(TopologyExprParser.DefineStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link TopologyExprParser#define}.
	 * @param ctx the parse tree
	 */
	void enterDefine(TopologyExprParser.DefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link TopologyExprParser#define}.
	 * @param ctx the parse tree
	 */
	void exitDefine(TopologyExprParser.DefineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumber(TopologyExprParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumber(TopologyExprParser.NumberContext ctx);
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
	 * Enter a parse tree produced by the {@code LogicalOps}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOps(TopologyExprParser.LogicalOpsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOps}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOps(TopologyExprParser.LogicalOpsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(TopologyExprParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(TopologyExprParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(TopologyExprParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(TopologyExprParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVar(TopologyExprParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVar(TopologyExprParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompare(TopologyExprParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link TopologyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompare(TopologyExprParser.CompareContext ctx);
}