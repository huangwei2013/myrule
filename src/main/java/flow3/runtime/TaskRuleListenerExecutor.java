package flow3.runtime;

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

    ParseTreeProperty<Object> values  = new ParseTreeProperty<>();
    public void setValue(ParseTree node, Object value){
        values.put(node, value);
    }
    public Object getValue(ParseTree node){
        return values.get(node);
    }

    @Override
    public void exitProgram(CalculatorExprParser.ProgramContext ctx) {
//        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());
        setValue(ctx, memory.get(ctx.getPayload().getText()));
    }

    @Override public void exitDefine(CalculatorExprParser.DefineContext ctx) {
//        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());
        memory.put(ctx.getPayload().getText(), memory.get(ctx.expr().getText()));
        setValue(ctx, memory.get(ctx.expr().getText()));
    }

    @Override public void exitNumber(CalculatorExprParser.NumberContext ctx) {
//        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());
        memory.put(ctx.getRuleContext().getText(), Integer.valueOf(ctx.getRuleContext().getText()));
    }

    @Override public void exitVar(CalculatorExprParser.VarContext ctx) {
//        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());
        memory.put(ctx.VAR().getText(), Integer.valueOf(ctx.getRuleContext().getText()));
    }

    @Override public void exitParens(CalculatorExprParser.ParensContext ctx) {
//        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());

        String valueName = ctx.getRuleContext().getText().substring(1, ctx.getRuleContext().getText().length()-1);
        memory.put(ctx.getRuleContext().getText(), memory.get(valueName));
    }

    @Override public void exitMulDiv(CalculatorExprParser.MulDivContext ctx) {
//        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());
        String leftName = ctx.expr(0).getPayload().getText();
        String rightName = ctx.expr(1).getPayload().getText();

        Integer left = (Integer) memory.get(leftName);
        Integer right = (Integer) memory.get(rightName);
        Integer ret = 0;
        if (ctx.op.getType() == CalculatorExprParser.MUL){
            ret = left * right;
        }else{
            ret = left / right;
        }
        memory.put(ctx.getRuleContext().getText(), ret);
    }


    @Override public void exitAddSub(CalculatorExprParser.AddSubContext ctx) {
//        System.out.printf(" [%s.%s] %s \n", this.getClass().getName(), Thread.currentThread() .getStackTrace()[1].getMethodName(), ctx.getRuleContext().getText());
        String leftName = ctx.expr(0).getPayload().getText();
        String rightName = ctx.expr(1).getPayload().getText();

        Integer left = (Integer) memory.get(leftName);
        Integer right = (Integer) memory.get(rightName);
        Integer ret = 0;
        if (ctx.op.getType() == CalculatorExprParser.ADD){
            ret = left + right;
        }else{
            ret = left - right;
        }
        memory.put(ctx.getRuleContext().getText(), ret);
    }

}
