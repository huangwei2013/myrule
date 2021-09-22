package flow3.runtime;

import flow3.dsl.gen.Calculator.CalculatorExprLexer;
import flow3.dsl.gen.Calculator.CalculatorExprParser;
import flow3.entity.Action;
import flow3.entity.Node;
import flow3.entity.Rule;
import flow3.entity.Task;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TaskInst {
    Integer flowInstId;;
    Integer taskInstId;
    Integer taskId;
    Queue<Node> nodeInsts;


    public TaskInst(Integer taskInstId, FlowInst flowInst, Task task){
        nodeInsts = new LinkedList<Node>();

        this.flowInstId = flowInst.getFlowInstId();
        this.taskInstId = taskInstId;
        this.taskId = task.getTaskId();
        this.nodeInsts = task.getNodes();
    }

    public Map<String, Object> run(RuleVisitorExecutor ruleExecutor, Map<String, Object> facts){
        System.out.printf("Run Task : %d[%d-%d]", taskId, flowInstId, taskInstId);
        while(!nodeInsts.isEmpty()){
            Node curNode = nodeInsts.poll();
            if(curNode instanceof Rule){
                //do something， with DSL
                System.out.printf("Execute Rule : %s\n", ((Rule) curNode).getContent());

                Rule rule = (Rule)curNode;
                ANTLRInputStream input = new ANTLRInputStream(rule.getContent());
                CalculatorExprLexer lexer = new CalculatorExprLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                CalculatorExprParser parser = new CalculatorExprParser(tokens);
                ParseTree tree = parser.program();

                Float ruleRet = ruleExecutor.visit(tree);//执行结果汇入 memory

                System.out.printf("Execute Rule : %s, ret : %f\n", ((Rule) curNode).getContent(), ruleRet);

            }else if (curNode instanceof Action){
                //do something
                System.out.printf("Execute Action : %s\n", ((Rule) curNode).getContent());

            }else{
                System.out.printf("Unknown node type ");
            }
        }
        return ruleExecutor.getMemory();
    }
}
