package flow3.runtime.visitor;

import flow3.dsl.gen.Topology.TopologyExprBaseVisitor;
import flow3.dsl.gen.Topology.TopologyExprParser;

import java.util.HashMap;
import java.util.Map;

public class TopologyVisitorExecutor extends TopologyExprBaseVisitor<Object> {
    // 声明一个 map，存放变量与值的键值对
    Map<String, Boolean> memory = new HashMap<>();

    public void addFact(String key, Boolean value){
        memory.put(key, value);
    }

    public Map<String, Boolean> getMemory(){
        return this.memory;
    }


    /**
     * expr op=('&&'|'||') expr
     * @return
     */
    @Override
    public String visitLogicalOpsAndOr(TopologyExprParser.LogicalOpsAndOrContext ctx) {
        try {
            System.out.println("visitLogicalOpsAndOr");
            //String leftTaskId = visit(ctx.expr(0));
            String leftTaskId = ctx.expr(0).getText();

            //String rightTaskId = visit(ctx.expr(1));
            String rightTaskId = ctx.expr(1).getText();

            Boolean leftTaskRet = (memory.containsKey(leftTaskId))?memory.get(leftTaskId):false;
            Boolean rightTaskRet = (memory.containsKey(rightTaskId))?memory.get(rightTaskId):false;

            if (ctx.op.getType() == TopologyExprParser.AND) {
                return (leftTaskRet && rightTaskRet) ? "t" : "f";
            } if (ctx.op.getType() == TopologyExprParser.OR) {
                return (leftTaskRet || rightTaskRet)?"t":"f";
            } else {
                return "f";
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "f";
    }


    /**
     * '('expr')'
     */
    @Override
    public String visitParens(TopologyExprParser.ParensContext ctx) {
        return (String) visit(ctx.expr());
    }

}