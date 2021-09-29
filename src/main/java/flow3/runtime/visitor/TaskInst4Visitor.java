package flow3.runtime.visitor;

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

public class TaskInst4Visitor {
    Integer flowInstId;;
    Integer taskInstId;
    Integer taskId;
    Queue<Node> nodeInsts;


    public TaskInst4Visitor(Integer taskInstId, FlowInst4Visitor flowInst, Task task){
        nodeInsts = new LinkedList<Node>();

        this.flowInstId = flowInst.getFlowInstId();
        this.taskInstId = taskInstId;
        this.taskId = task.getTaskId();
        this.nodeInsts = task.getNodes();
    }

    public Map<String, Object> run(TaskRuleVisitorExecutor taskRuleExecutor){
        System.out.printf("Run Task : %d[%d-%d]\n", taskId, flowInstId, taskInstId);
        while(!nodeInsts.isEmpty()){
            Node curNode = nodeInsts.poll();
            if(curNode instanceof Rule){
                Rule rule = (Rule)curNode;
                //do something， with DSL
                System.out.printf("Execute Rule : %s\n", rule.getContent());
                taskRuleExecutor = runRuleDSLVisitor(taskRuleExecutor, rule.getContent());
                System.out.printf("Execute Rule : %s\n", ((Rule) curNode).getContent());

            }else if (curNode instanceof Action){
                //do something
                System.out.printf("Execute Action : %s\n", ((Rule) curNode).getContent());

            }else{
                System.out.printf("Unknown node type \n");
            }
        }
        return taskRuleExecutor.getMemory();
    }


    /**
     * 使用 visitor 模式运行 DSL 实现的 rule
     * @param taskRuleExecutor
     * @param rule
     * @return
     */
    private TaskRuleVisitorExecutor runRuleDSLVisitor(TaskRuleVisitorExecutor taskRuleExecutor, String rule){
        ANTLRInputStream input = new ANTLRInputStream(rule);
        CalculatorExprLexer lexer = new CalculatorExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorExprParser parser = new CalculatorExprParser(tokens);
        ParseTree tree = parser.program();

        taskRuleExecutor.visit(tree);//执行结果汇入 memory
        return taskRuleExecutor;
    }
}