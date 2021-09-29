package flow3.runtime.listener;

import flow3.dsl.gen.Calculator.CalculatorExprBaseListener;
import flow3.dsl.gen.Calculator.CalculatorExprParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.HashMap;
import java.util.Map;

public class TaskRuleListenerExecutor extends CalculatorExprBaseListener {

    Map<String, Object> memory = new HashMap<String, Object>();

    public Object get(String key){
        if(memory.containsKey(key)){
            memory.get(key);
        }
        return null;
    }
    public Map<String, Object> getMemory(){
        return this.memory;
    }

    public void addFacts(Map<String, Object> facts){
        for( Object varKey : facts.keySet()) {
            memory.put(varKey.toString(),  facts.get(varKey));
        }
    }

    public void reInitFacts(Map<String, Object> facts){
        memory.clear();
        for( Object varKey : facts.keySet()) {
            memory.put(varKey.toString(),  facts.get(varKey));
        }
    }


    ParseTreeProperty<Object> values  = new ParseTreeProperty<>();
    public void setValue(ParseTree node, Object value){
        values.put(node, value);
    }
    public Object getValue(ParseTree node){
        return values.get(node);
    }

    @Override
    public void exitProgram(CalculatorExprParser.ProgramContext ctx) {
        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());
        setValue(ctx, memory.get(ctx.getPayload().getText()));
    }

    @Override
    public void exitDefine(CalculatorExprParser.DefineContext ctx) {
        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());
        if ( (ctx.EQ() != null) &&  (ctx.EQ().getSymbol().getType() == CalculatorExprParser.EQ )){
            // ==
            if( memory.containsKey(ctx.VAR().toString()) ) {
                Float value = Float.valueOf(memory.get(ctx.VAR().toString()).toString());
                if (value.equals(Float.valueOf(ctx.expr().getText())) ){
                    memory.put(ctx.getPayload().getText(), 1);
                    setValue(ctx, 1);
                }
            }
        }else {
            memory.put(ctx.VAR().toString(), memory.get(ctx.expr().getText()));
            memory.put(ctx.getPayload().getText(), memory.get(ctx.expr().getText()));
            setValue(ctx, memory.get(ctx.expr().getText()));
        }
    }

    @Override
    public void exitNumber(CalculatorExprParser.NumberContext ctx) {
        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());
        memory.put(ctx.getRuleContext().getText(), Float.valueOf(ctx.getRuleContext().getText()));
    }

    @Override
    public void exitVar(CalculatorExprParser.VarContext ctx) {
        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());
        memory.put(ctx.VAR().getText(), Float.valueOf(ctx.getRuleContext().getText()));
    }

    @Override
    public void exitParens(CalculatorExprParser.ParensContext ctx) {
        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());

        String valueName = ctx.getRuleContext().getText().substring(1, ctx.getRuleContext().getText().length()-1);
        memory.put(ctx.getRuleContext().getText(), memory.get(valueName));
    }

    @Override
    public void exitMulDiv(CalculatorExprParser.MulDivContext ctx) {
        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());
        float left = Float.valueOf( memory.get(ctx.expr(0).getPayload().getText()).toString());
        float right = Float.valueOf( memory.get(ctx.expr(1).getPayload().getText()).toString());
        float ret = new Float(0);
        if (ctx.op.getType() == CalculatorExprParser.MUL){
            ret = left * right;
        }else{
            ret = left / right;
        }
        memory.put(ctx.getRuleContext().getText(), ret);
    }

    @Override
    public void exitAddSub(CalculatorExprParser.AddSubContext ctx) {
        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());
        float left = Float.valueOf( memory.get(ctx.expr(0).getPayload().getText()).toString());
        float right = Float.valueOf( memory.get(ctx.expr(1).getPayload().getText()).toString());
        float ret = new Float(0);
        if (ctx.op.getType() == CalculatorExprParser.ADD){
            ret = left + right;
        }else{
            ret = left - right;
        }
        memory.put(ctx.getRuleContext().getText(), ret);
    }

    @Override
    public void exitCompare(CalculatorExprParser.CompareContext ctx) {
       System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());
        float left = Float.valueOf( memory.get(ctx.expr(0).getPayload().getText()).toString());
        float right = Float.valueOf( memory.get(ctx.expr(1).getPayload().getText()).toString());
        Boolean ret = false;

        if (ctx.op.getType() == CalculatorExprParser.EQ)
            ret = (left == right);
        else if (ctx.op.getType() == CalculatorExprParser.NEQ)
            ret = (left != right);
        else if (ctx.op.getType() == CalculatorExprParser.GT)
            ret = (left > right);
        else if (ctx.op.getType() == CalculatorExprParser.GTE)
            ret = (left >= right);
        else if (ctx.op.getType() == CalculatorExprParser.LT)
            ret = (left < right);
        else if (ctx.op.getType() == CalculatorExprParser.LTE)
            ret = (left <= right);

        memory.put(ctx.getRuleContext().getText(), ret);
    }


}
