package flow3.runtime;

import flow3.dsl.gen.Calculator.CalculatorExprLexer;
import flow3.dsl.gen.Calculator.CalculatorExprParser;
import flow3.dsl.gen.Topology.TopologyExprLexer;
import flow3.dsl.gen.Topology.TopologyExprParser;
import flow3.entity.Flow;
import flow3.entity.FlowTask;
import flow3.entity.Rule;
import flow3.entity.Task;
import flow3.model.entity.TTaskInst;
import flow3.model.entity.TTaskRule;
import flow3.model.service.TTaskInstService;
import flow3.model.service.TTaskRuleService;
import flow3.uitl.TaskType;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FlowInst {

    private TTaskInstService tTaskInstService;
    private TTaskRuleService tTaskRuleService;

    Integer flowInstId;
    Integer flowId;
    Map<Integer, FlowTask> taskSet;// backup tasks for this flow/flowInst, set when initial this FlowInst
    Queue<TaskInst> taskInsts; // set startTask from beginning; once empty, flow ended
    Map<String, Object> facts;
    RuleVisitorExecutor ruleExecutor;
    TopologyVisitorExecutor topologyExecutor;

    public FlowInst(Integer flowInstId, Flow flow, Map<Integer, FlowTask> taskSet, Map<String, Object> facts, TTaskInstService tTaskInstService, TTaskRuleService tTaskRuleService){
        this.flowInstId = flowInstId;
        this.flowId = flow.getFlowId();
        this.taskSet = taskSet;
        this.facts = facts;
        this.tTaskInstService = tTaskInstService;
        this.tTaskRuleService = tTaskRuleService;

        this.topologyExecutor = new TopologyVisitorExecutor();
        this.ruleExecutor = new RuleVisitorExecutor();
        this.ruleExecutor.init(facts);
        taskInsts =  new LinkedList<TaskInst>();

        for( FlowTask flowTask : taskSet.values()){
            if(flowTask.getTaskType().equals(TaskType.StartNode)){
                addTaskInst(flowTask);
                break;
            }
        }
    }

    private void addTaskInst(FlowTask flowTask){
        TTaskInst tTaskInst = new TTaskInst();
        tTaskInst.setFlowId(flowTask.getFlowId());
        tTaskInst.setTaskId(flowTask.getTaskId());
        tTaskInst.setRet(0);
        tTaskInstService.insert(tTaskInst);

        Task task = new Task();
        task.setTaskId(flowTask.getTaskId());

        List<TTaskRule> taskRules = tTaskRuleService.getByTaskId(flowTask.getTaskId());
        for(int idx = 0 ; idx < taskRules.size(); idx++ ){
            TTaskRule taskRule = taskRules.get(idx);
            Rule rule = new Rule();
            rule.setContent(taskRule.getContent());
            task.addNodes(rule);
        }

        taskInsts.add(new TaskInst(tTaskInst.getId(), this, task));
    }

    public Integer run(){
            while(!taskInsts.isEmpty()){
                TaskInst curTaskInst = taskInsts.poll();

                // run task
                facts = curTaskInst.run(ruleExecutor, facts);

                TTaskInst tTaskInst = tTaskInstService.getById(curTaskInst.taskInstId);
                tTaskInst.setRet(1);
                tTaskInstService.update(tTaskInst);

                // next task
                getNextTask(curTaskInst);
            }
            facts = ruleExecutor.getMemory();
            return 1;
    }

    public void getNextTask(TaskInst taskInst){
        // FlowInst get next task by Flow-Task relations
        try {
            if (taskSet.containsKey(taskInst.taskId)) {
                FlowTask flowTask = taskSet.get(taskInst.taskId);
                Map<Rule, Integer> nextTaskByRule = flowTask.getNextTaskByRule();
                for (Rule rule : nextTaskByRule.keySet()) {
                    System.out.printf("【nextTaskByRule】 Rule : %s, for task : %d, with Facts : %s\n", ((Rule) rule).getContent(), taskInst.taskId, facts.toString());

                    ANTLRInputStream input = new ANTLRInputStream(rule.getContent());
                    CalculatorExprLexer lexer = new CalculatorExprLexer(input);
                    CommonTokenStream tokens = new CommonTokenStream(lexer);
                    CalculatorExprParser parser = new CalculatorExprParser(tokens);
                    ParseTree tree = parser.program();
                    ruleExecutor.visit(tree);

                    for (FlowTask ft : taskSet.values()) {
                        if (ft.getTaskId().equals(nextTaskByRule.get(rule).intValue())) {

                            // NOTE：反向检查节点条件是否满足，满足则执行 addTaskInst
                            if(ft.getPreCondition() != null && !ft.getPreCondition().isEmpty()) {
                                Boolean checkTaskRet = checkTask(ft.getPreCondition());
                                if( checkTaskRet == true ) {
                                    System.out.println("more task will added");
                                    addTaskInst(ft);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }catch (Exception e){
            System.out.printf("getNextTask :",e.getMessage());
        }
    }

    private Boolean checkTask(String preCondition){
        Boolean ret = false;
        try {
            ANTLRInputStream input = new ANTLRInputStream(preCondition);
            TopologyExprLexer lexer = new TopologyExprLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            TopologyExprParser parser = new TopologyExprParser(tokens);
            ParseTree tree = parser.program();
            ret = topologyExecutor.visit(tree) == "t" ? true : false;
        }catch (Exception e){
            System.out.printf("checkTask :",e.getMessage());
        }
        return (ret == null) ? false : ret;
    }

    public Integer getFlowInstId() {
        return flowInstId;
    }

    public void setFlowInstId(Integer flowInstId) {
        this.flowInstId = flowInstId;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public Map<String, Object> getFacts() {
        return facts;
    }

    public void setFacts(Map<String, Object> facts) {
        this.facts = facts;
    }
}
