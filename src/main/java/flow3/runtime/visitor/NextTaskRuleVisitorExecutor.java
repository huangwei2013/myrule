package flow3.runtime.visitor;

import flow3.dsl.gen.Calculator.CalculatorExprBaseVisitor;
import flow3.dsl.gen.Calculator.CalculatorExprParser;

import java.util.HashMap;
import java.util.Map;

public class NextTaskRuleVisitorExecutor extends CalculatorExprBaseVisitor<Float> {
    // 声明一个 map，存放变量与值的键值对
    Map<String, Object> memory = new HashMap<String, Object>();

    public void reInitFacts(Map<String, Object> facts){
        memory.clear();
        for( Object varKey : facts.keySet()) {
            memory.put(varKey.toString(),  facts.get(varKey));
        }
    }

    public Map<String, Object> getMemory(){
        return this.memory;
    }

    /**
     * define: VAR '=' expr ';';
     */
    @Override
    public Float visitDefine(CalculatorExprParser.DefineContext ctx) {
        String var = ctx.VAR().getText();
        float value = visit(ctx.expr());
        if(memory.containsKey(var)){
            return memory.get(var).equals(value)?(float)1:(float)0;
        }else{
            return (float)0;
        }
    }

    /**
     * expr cop expr
     * @return
     */
    public Float visitCompare(CalculatorExprParser.CompareContext ctx) {
        float left = visit(ctx.expr(0));
        float right = visit(ctx.expr(1));
        if (ctx.op.getType() == CalculatorExprParser.EQ)
            return (left == right)?(float)1 : (float)0;
        else if (ctx.op.getType() == CalculatorExprParser.NEQ)
            return (left != right)?(float)1 : (float)0;
        else if (ctx.op.getType() == CalculatorExprParser.GT)
            return (left > right)?(float)1 : (float)0;
        else if (ctx.op.getType() == CalculatorExprParser.GTE)
            return (left >= right)?(float)1 : (float)0;
        else if (ctx.op.getType() == CalculatorExprParser.LT)
            return (left < right)?(float)1 : (float)0;
        else if (ctx.op.getType() == CalculatorExprParser.LTE)
            return (left <= right)?(float)1 : (float)0;
        return (float)0;
    }

    /**
     * NUMBER
     */
    @Override
    public Float visitNumber(CalculatorExprParser.NumberContext ctx) {
        return Float.valueOf(ctx.NUMBER().getText());
    }

    /**
     * VAR
     */
    @Override
    public Float visitVar(CalculatorExprParser.VarContext ctx) {
        String var = ctx.VAR().getText();
        if (memory.containsKey(var))
            return (Float) memory.get(var);
        return (float) 0;
    }

    /**
     * '('expr')'
     */
    @Override
    public Float visitParens(CalculatorExprParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    /**
     * print: ('print''('VAR')'';');
     */
    @Override
    public Float visitPrintVAR(CalculatorExprParser.PrintVARContext ctx) {
        String var = ctx.VAR().getText();
        if (memory.containsKey(var))
            System.out.println(memory.get(var));
        else
            System.err.println("undefined identifier");
        return visitChildren(ctx);
    }

    /**
     * print: ('print''('expr')'';');
     */
    @Override
    public Float visitPrintExpr(CalculatorExprParser.PrintExprContext ctx) {
        System.out.println(visit(ctx.expr()));
        return visitChildren(ctx);
    }
}