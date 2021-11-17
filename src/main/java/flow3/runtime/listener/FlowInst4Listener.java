package flow3.runtime.listener;

import flow3.dsl.gen.Rule.RuleExprLexer;
import flow3.dsl.gen.Rule.RuleExprParser;
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
import flow3.runtime.FlowInst;
import flow3.util.TaskStatus;
import flow3.util.TaskType;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.*;

public class FlowInst4Listener implements FlowInst {

    private TTaskInstService tTaskInstService;
    private TTaskRuleService tTaskRuleService;

    Integer flowInstId;
    Integer flowId;
    Map<Integer, FlowTask> taskSet;// backup tasks for this flow/flowInst, set when initial this FlowInst
    Queue<TaskInst4Listener> taskInstsWaitingQueue; // set startTask from beginning; once empty, flow ended
    Map<Integer, TTaskInst> taskInstsMap; // task instances map here
    Map<String, Object> facts;
    TaskRuleListenerExecutor taskRuleExecutor;
    TopologyListenerExecutor topologyExecutor;
    TopologyListenerExecutor nextTaskRuleExecutor;

    public static FlowInst builder(Integer flowInstId, Flow flow, Map<Integer, FlowTask> taskSet, Map<String, Object> facts,  List<TTaskInst> taskInsts, TTaskInstService tTaskInstService, TTaskRuleService tTaskRuleService){

        FlowInst4Listener inst = new FlowInst4Listener();
        inst.setFlowInstId(flowInstId);
        inst.setFlowId(flow.getFlowId());
        inst.taskSet = taskSet;
        inst.facts = facts;

        inst.tTaskInstService = tTaskInstService;
        inst.tTaskRuleService = tTaskRuleService;

        inst.topologyExecutor = new TopologyListenerExecutor();
        inst.nextTaskRuleExecutor = new TopologyListenerExecutor();
        inst.taskRuleExecutor = new TaskRuleListenerExecutor();
        inst.taskRuleExecutor.addFacts(facts);
        inst.taskInstsWaitingQueue =  new LinkedList<>();
        inst.taskInstsMap =  new HashMap<>();

        for( FlowTask flowTask : taskSet.values()){
            if(flowTask.getTaskType().equals(TaskType.StartNode)){
                inst.addTaskInst(flowTask);
                break;
            }
        }

        for(int i = 0 ; i < taskInsts.size(); i++) {
            TTaskInst ttaskInst = taskInsts.get(i);
            inst.taskInstsMap.put(ttaskInst.getId(), ttaskInst);
        }


        return inst;
    }

    private void addTaskInst(FlowTask flowTask){
        TTaskInst tTaskInst = new TTaskInst();
        tTaskInst.setFlowInstId(this.flowInstId);
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

        taskInstsWaitingQueue.add(new TaskInst4Listener(tTaskInst.getId(), this, task));
        taskInstsMap.put(tTaskInst.getId(), tTaskInst);
    }

    /**
     * 运行一个 Flow 的实例
     *
     * @return
     */
    @Override
    public Integer run(){
        while(!taskInstsWaitingQueue.isEmpty()){
            TaskInst4Listener curTaskInst = taskInstsWaitingQueue.poll();

            // run task
            facts = curTaskInst.run(taskRuleExecutor);

            // update status in db
            TTaskInst tTaskInst = tTaskInstService.getById(curTaskInst.taskInstId);
            tTaskInst.setRet(1);
            tTaskInstService.update(tTaskInst);

            // update status in memory
            taskInstsMap.put(tTaskInst.getId(), tTaskInst);

            // next task
            getNextTask(curTaskInst);
        }
        return 1;
    }

    /**
     * 除了节点执行，主要的控制逻辑就在这里
     *
     * @param curTaskInst
     */
    public void getNextTask(TaskInst4Listener curTaskInst){
        // FlowInst get next task by Flow-Task relations
        try {
            if (taskSet.containsKey(curTaskInst.taskId)) {// double check
                FlowTask flowTask = taskSet.get(curTaskInst.taskId);

                Integer nextToCheckTaskId = 0;
                if( flowTask.getNextTaskId() > 0) {
                    // 直接是taskId
                    JumpToTaskDirect(flowTask);
                } else if( flowTask.getNextTasksByRule().size() > 0 ){
                    // 是跳转条件规则
                    JumpToTaskByCond(flowTask, curTaskInst);
                }else {
                    //没有nextTtask，return
                }
            }
        }catch (Exception e){
            System.out.printf("getNextTask error: %s\n",e.getMessage());
        }
    }

    /**
     * 直接跳转task
     *
     * @param flowTask
     */
    private void JumpToTaskDirect(FlowTask flowTask){
        Integer nextToCheckTaskId = flowTask.getNextTaskId();
        FlowTask ft = taskSet.get(nextToCheckTaskId);
        if (ft.getTaskId().equals(nextToCheckTaskId)) {

            // NOTE：若设置了pre条件，将反向检查节点条件是否满足，满足则执行 addTaskInst
            System.out.printf("try to get PreCondition [taskId = %d], [PreCondition = %s] [task = %s] \n", ft.getTaskId(), ft.getPreCondition(), ft.toString());
            if(ft.getPreCondition() != null && !ft.getPreCondition().isEmpty()) {
                Boolean checkTaskRet = checkTask(ft.getPreCondition());
                if( checkTaskRet == true ) {
                    System.out.printf("more task will added on PreCondition [taskId = %d] \n", ft.getTaskId());
                    addTaskInst(ft);
                } else{
                    System.out.println("no task added");
                }
            } else { // 否则直接开启后续节点
                System.out.printf("more task will added without PreCondition [taskId = %d] \n", ft.getTaskId());
                addTaskInst(ft);
            }
        }
    }

    /**
     * 条件跳转task
     *
     * @param flowTask
     * @param curTaskInst
     */
    private void JumpToTaskByCond(FlowTask flowTask, TaskInst4Listener curTaskInst){
        Map<Rule, Integer> nextTasksByRule = flowTask.getNextTasksByRule();
        for (Rule rule : nextTasksByRule.keySet()) {
            System.out.printf("【nextTasksByRule】 Rule : %s, for task : %d, with Facts : %s\n", ((Rule) rule).getContent(), curTaskInst.taskId, taskRuleExecutor.getMemory().toString());

            Boolean retRunNextTask = runNextTaskRuleDSLVisitor(nextTaskRuleExecutor, rule.getContent(), facts);
            if(!retRunNextTask) continue;

            Integer nextToCheckTaskId = nextTasksByRule.get(rule).intValue();
            for (FlowTask ft : taskSet.values()) {
                if (ft.getTaskId().equals(nextToCheckTaskId)) {

                    // NOTE：若设置了pre条件，将反向检查节点条件是否满足，满足则执行 addTaskInst
                    System.out.printf("try to get PreCondition [taskId = %d], [PreCondition = %s] [task = %s] \n", ft.getTaskId(), ft.getPreCondition(), ft.toString());
                    if(ft.getPreCondition() != null && !ft.getPreCondition().isEmpty()) {
                        Boolean checkTaskRet = checkTask(ft.getPreCondition());
                        if( checkTaskRet == true ) {
                            System.out.printf("more task will added on PreCondition [taskId = %d] \n", ft.getTaskId());
                            addTaskInst(ft);
                        } else{
                            System.out.println("no task added");
                        }
                    } else { // 否则直接开启后续节点
                        System.out.printf("more task will added without PreCondition [taskId = %d] \n", ft.getTaskId());
                        addTaskInst(ft);
                    }
                }
            }
        }
    }

    /**
     * 使用 visitor 模式运行 DSL 实现的 rule
     * @param rule
     */
    private Boolean runNextTaskRuleDSLVisitor(TopologyListenerExecutor dslExecutor, String rule, Map<String, Object> facts){
        CharStream input = CharStreams.fromString(rule);
        TopologyExprLexer lexer = new TopologyExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TopologyExprParser parser = new TopologyExprParser(tokens);
        ParseTree tree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();
        dslExecutor.reInitFacts(facts);
        walker.walk(dslExecutor, tree);

        Boolean ret = (Boolean) dslExecutor.getRet();
        System.out.printf("【runNextTaskRuleDSLVisitor】 rule : %s, facts : %s, ret : %s\n", rule, dslExecutor.getMemory().toString(), ret==true?"true":"false");

        return ret;
    }

    /**
     * 由指定前述任务的结果，来判定是否满足开启条件
     *
     * @param preCondition
     * @return
     */
    private Boolean checkTask(String preCondition){
        if(preCondition.equals(null)) return true;

        String[] taskIdsList;
        taskIdsList = preCondition.split(",");
        for(int i =0; i < taskIdsList.length ; i++) {
            Integer taskId = Integer.valueOf(taskIdsList[i].trim());
            if(!taskInstsMap.containsKey(taskId) || (taskInstsMap.get(taskId).getRet() != TaskStatus.TaskSucc)){
                return false;
            }
        }
        
        return true;
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

    @Override
    public Map<String, Object> getFacts() {
        return facts;
    }

    public void setFacts(Map<String, Object> facts) {
        this.facts = facts;
    }
}
