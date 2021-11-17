package flow3.runtime.listener;

import flow3.dsl.gen.Rule.RuleExprLexer;
import flow3.dsl.gen.Rule.RuleExprParser;
import flow3.entity.Action;
import flow3.entity.Node;
import flow3.entity.Rule;
import flow3.entity.Task;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TaskInst4Listener {
    Integer flowInstId;;
    Integer taskInstId;
    Integer taskId;
    Queue<Node> nodeInsts;


    public TaskInst4Listener(Integer taskInstId, FlowInst4Listener flowInst, Task task){
        nodeInsts = new LinkedList<Node>();

        this.flowInstId = flowInst.getFlowInstId();
        this.taskInstId = taskInstId;
        this.taskId = task.getTaskId();
        this.nodeInsts = task.getNodes();
    }

    public Map<String, Object> run(TaskRuleListenerExecutor taskRuleExecutor){
        System.out.printf("Run Task : %d[%d-%d]\n", taskId, flowInstId, taskInstId);
        while(!nodeInsts.isEmpty()){
            Node curNode = nodeInsts.poll();
            if(curNode instanceof Rule){
                Rule rule = (Rule)curNode;
                //do something， with DSL
                System.out.printf("Execute Rule : %s\n", rule.getContent());
                taskRuleExecutor = runRuleDSL(taskRuleExecutor, rule.getContent());
                System.out.printf("Executed Rule : %s\n", ((Rule) curNode).getContent());

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
     * 使用 Listener 模式运行 DSL 实现的 rule
     * @param taskRuleExecutor
     * @param rule
     * @return
     */
    private TaskRuleListenerExecutor runRuleDSL(TaskRuleListenerExecutor taskRuleExecutor, String rule){
        CharStream input = CharStreams.fromString(rule);
        RuleExprLexer lexer = new RuleExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RuleExprParser parser = new RuleExprParser(tokens);
        ParseTree tree = parser.program();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk((ParseTreeListener) taskRuleExecutor, tree);
        return taskRuleExecutor;
    }
}
