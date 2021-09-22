// Generated from D:/huangwei/code/myrule/flow3/src/main/java/flow3/dsl/conf/Calculator\CalculatorExpr.g4 by ANTLR 4.9.1
package flow3.dsl.gen.Calculator;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorExprParser}.
 */
public interface CalculatorExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorExprParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CalculatorExprParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExprParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CalculatorExprParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code defineStat}
	 * labeled alternative in {@link CalculatorExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDefineStat(CalculatorExprParser.DefineStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code defineStat}
	 * labeled alternative in {@link CalculatorExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDefineStat(CalculatorExprParser.DefineStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link CalculatorExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(CalculatorExprParser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link CalculatorExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(CalculatorExprParser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link CalculatorExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlank(CalculatorExprParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link CalculatorExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlank(CalculatorExprParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExprParser#define}.
	 * @param ctx the parse tree
	 */
	void enterDefine(CalculatorExprParser.DefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExprParser#define}.
	 * @param ctx the parse tree
	 */
	void exitDefine(CalculatorExprParser.DefineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumber(CalculatorExprParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumber(CalculatorExprParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(CalculatorExprParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(CalculatorExprParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOps}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOps(CalculatorExprParser.LogicalOpsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOps}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOps(CalculatorExprParser.LogicalOpsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(CalculatorExprParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(CalculatorExprParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(CalculatorExprParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(CalculatorExprParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVar(CalculatorExprParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVar(CalculatorExprParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompare(CalculatorExprParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompare(CalculatorExprParser.CompareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printVAR}
	 * labeled alternative in {@link CalculatorExprParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrintVAR(CalculatorExprParser.PrintVARContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printVAR}
	 * labeled alternative in {@link CalculatorExprParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrintVAR(CalculatorExprParser.PrintVARContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link CalculatorExprParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(CalculatorExprParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link CalculatorExprParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(CalculatorExprParser.PrintExprContext ctx);
}