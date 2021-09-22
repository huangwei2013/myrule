// Generated from D:/huangwei/code/myrule/flow3/src/main/java/flow3/dsl/conf/Calculator\CalculatorExpr.g4 by ANTLR 4.9.1
package flow3.dsl.gen.Calculator;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalculatorExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalculatorExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CalculatorExprParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CalculatorExprParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defineStat}
	 * labeled alternative in {@link CalculatorExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineStat(CalculatorExprParser.DefineStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link CalculatorExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStat(CalculatorExprParser.PrintStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link CalculatorExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlank(CalculatorExprParser.BlankContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExprParser#define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine(CalculatorExprParser.DefineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code number}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(CalculatorExprParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(CalculatorExprParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalOps}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOps(CalculatorExprParser.LogicalOpsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(CalculatorExprParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(CalculatorExprParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(CalculatorExprParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link CalculatorExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(CalculatorExprParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printVAR}
	 * labeled alternative in {@link CalculatorExprParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintVAR(CalculatorExprParser.PrintVARContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link CalculatorExprParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpr(CalculatorExprParser.PrintExprContext ctx);
}