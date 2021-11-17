package flow3.runtime.listener;

import flow3.dsl.gen.Rule.RuleExprBaseListener;
import flow3.dsl.gen.Rule.RuleExprParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.HashMap;
import java.util.Map;

public class TaskRuleListenerExecutor extends RuleExprBaseListener {

    private Map<String, Object> memory = new HashMap<String, Object>();
    private Object ret = new Object();

    public Object get(Object key){
        if(memory.containsKey(key)){
            return memory.get(key);
        }
        return null;
    }
    public Boolean containsKey(Object key){
        return memory.containsKey(key);
    }

    public Map<String, Object> getMemory(){
        return this.memory;
    }

    public Object getRet(){
        return this.ret;
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
    public void exitProgram(RuleExprParser.ProgramContext ctx) {
        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());
        setValue(ctx, memory.get(ctx.getPayload().getText()));
        this.ret = memory.get(ctx.getPayload().getText());
    }

    @Override
    public void exitDefine(RuleExprParser.DefineContext ctx) {
        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());

        String lhsName = ctx.VAR().toString();
        String lhsValueStr = ctx.expr().getText();
        String expr = ctx.getPayload().getText();

        if ( (ctx.EQ() != null) &&  (ctx.EQ().getSymbol().getType() == RuleExprParser.EQ )) { // ==

            //set default value
            memory.put(expr, false);
            setValue(ctx, false);

            Float rhsValue = memory.containsKey(lhsName) ? Float.valueOf(memory.get(lhsName).toString()) : null;
            if (memory.containsKey(lhsName)) {
                try {
                    if (Float.valueOf(lhsValueStr).equals(rhsValue)) {// var = number;
                        memory.put(expr, true);
                        setValue(ctx, true);
                    }
                } catch (Exception e) {
                    if (memory.containsKey(lhsValueStr)) {// number = number;
                        rhsValue = (Float) memory.get(lhsValueStr);
                        if (Float.valueOf(lhsValueStr).equals(rhsValue)) {
                            memory.put(expr, true);
                            setValue(ctx, true);
                        }
                    }
                }
            }
        } else { // =
            memory.put(lhsName, Float.valueOf(lhsValueStr));
        }
    }

    @Override
    public void exitNumber(RuleExprParser.NumberContext ctx) {
        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());
        memory.put(ctx.getRuleContext().getText(), Float.valueOf(ctx.getRuleContext().getText()));
    }

    @Override
    public void exitVar(RuleExprParser.VarContext ctx) {
        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());
        if(!memory.containsKey(ctx.VAR().getText())) {
            memory.put(ctx.VAR().getText(), Float.valueOf(ctx.getRuleContext().getText()));
        }
    }

    @Override
    public void exitParens(RuleExprParser.ParensContext ctx) {
        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());

        String valueName = ctx.getRuleContext().getText().substring(1, ctx.getRuleContext().getText().length()-1);
        memory.put(ctx.getRuleContext().getText(), memory.get(valueName));
    }

    @Override
    public void exitMulDiv(RuleExprParser.MulDivContext ctx) {
        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());
        float left = Float.valueOf( memory.get(ctx.expr(0).getPayload().getText()).toString());
        float right = Float.valueOf( memory.get(ctx.expr(1).getPayload().getText()).toString());
        float ret = new Float(0);
        if (ctx.op.getType() == RuleExprParser.MUL){
            ret = left * right;
        }else{
            ret = left / right;
        }
        memory.put(ctx.getRuleContext().getText(), ret);
    }

    @Override
    public void exitAddSub(RuleExprParser.AddSubContext ctx) {
        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());
        float left = Float.valueOf( memory.get(ctx.expr(0).getPayload().getText()).toString());
        float right = Float.valueOf( memory.get(ctx.expr(1).getPayload().getText()).toString());
        float ret = new Float(0);
        if (ctx.op.getType() == RuleExprParser.ADD){
            ret = left + right;
        }else{
            ret = left - right;
        }
        memory.put(ctx.getRuleContext().getText(), ret);
    }

    @Override
    public void exitCompare(RuleExprParser.CompareContext ctx) {
       System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());
        float left = Float.valueOf( memory.get(ctx.expr(0).getPayload().getText()).toString());
        float right = Float.valueOf( memory.get(ctx.expr(1).getPayload().getText()).toString());
        Boolean ret = false;

        if (ctx.op.getType() == RuleExprParser.EQ)
            ret = (left == right);
        else if (ctx.op.getType() == RuleExprParser.NEQ)
            ret = (left != right);
        else if (ctx.op.getType() == RuleExprParser.GT)
            ret = (left > right);
        else if (ctx.op.getType() == RuleExprParser.GTE)
            ret = (left >= right);
        else if (ctx.op.getType() == RuleExprParser.LT)
            ret = (left < right);
        else if (ctx.op.getType() == RuleExprParser.LTE)
            ret = (left <= right);

        memory.put(ctx.getRuleContext().getText(), ret);
    }


}
