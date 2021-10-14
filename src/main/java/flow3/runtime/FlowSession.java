package flow3.runtime;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import flow3.entity.Flow;
import flow3.entity.FlowTask;
import flow3.entity.Rule;
import flow3.model.entity.TFlow;
import flow3.model.entity.TFlowInst;
import flow3.model.entity.TFlowTask;
import flow3.model.entity.TTaskInst;
import flow3.model.service.*;
import flow3.runtime.listener.FlowInst4Listener;
import flow3.runtime.visitor.FlowInst4Visitor;
import flow3.util.DSLMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import flow3.util.StringUtil;


import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public  class FlowSession {

    // 普通类结合 @Autowired 的实现方式
    @Autowired
    TFlowTaskService tfts;
    @Autowired
    TFlowService tfs;
    @Autowired
    TFlowInstService tfis;
    @Autowired
    TTaskInstService ttis;
    @Autowired
    TTaskRuleService ttrs;

    private static TFlowTaskService tFlowTaskService;
    private static TFlowService tFlowService;
    private static TFlowInstService tFlowInstService;
    private static TTaskInstService tTaskInstService;
    private static TTaskRuleService tTaskRuleService;

    @PostConstruct
    public void init() {
        tFlowTaskService= tfts;
        tFlowService= tfs;
        tFlowInstService= tfis;
        tTaskInstService= ttis;
        tTaskRuleService= ttrs;
    }
    // end of 普通类结合 @Autowired 的实现方式

    public void run(Integer dslMode){

        // 构造的数据
        Integer flowId = 2;

        Flow flow = new Flow();
        TFlow tflow = tFlowService.getById(flowId);
        flow.setFlowId(tflow.getId());
        flow.setAlias(tflow.getAlias());
        flow.setNote(tflow.getNote());
        flow.setVersion(tflow.getVersion());

        Map<Integer, FlowTask> taskSet = new HashMap<Integer, FlowTask>();
        Map<Integer, Integer> taskInstMap = new HashMap<>();
        List<TFlowTask> tFlowTasks = tFlowTaskService.getByFlowId(flowId);
        for(int i = 0 ; i < tFlowTasks.size(); i++){
            TFlowTask tFlowTask = tFlowTasks.get(i);
            FlowTask flowTask = new FlowTask(tFlowTask.getFlowId(), tFlowTask.getTaskId(), tFlowTask.getType(), tFlowTask.getPre());

            if (tFlowTask.getNext() != null && !tFlowTask.getNext().isEmpty()) {
                String str = tFlowTask.getNext();

                // 直接跳转
                boolean isDigital = StringUtil.isNumeric(str);
                if(isDigital){
                    flowTask.setNextTaskId(Integer.valueOf(str));
                }else {

                    // 条件跳转
                    Map<String, Integer> tempMap = new Gson().fromJson(str, new TypeToken<HashMap<String, Integer>>() {
                    }.getType());// 不能有转义符
                    Map<Rule, Integer> nextTaskByRulesMap = new HashMap<>();
                    for (String ruleStr : tempMap.keySet()) { // NOTE：有点曲折，定义的数据结构该改
                        Rule rule = new Rule();
                        rule.setContent(ruleStr);
                        nextTaskByRulesMap.put(rule, (Integer) tempMap.get(ruleStr));
                    }
                    flowTask.setNextTasksByRule(nextTaskByRulesMap);
                }

            }

            taskSet.put(tFlowTask.getTaskId(), flowTask);
        }

        Map<String, Object> facts = new HashMap<String, Object>();
        facts.put("count", (float)10.0);
        facts.put("name", (float)1.0);

        TFlowInst tFlowInst = new TFlowInst();
        tFlowInst.setFlowId(flow.getFlowId());
        tFlowInst.setRet(0);
        tFlowInst.setFacts(facts.toString());
        tFlowInstService.insert(tFlowInst);

        List<TTaskInst> taskInsts = tTaskInstService.getByFlowInstId(tFlowInst.getId());
        // end of 构造数据

        FlowInst flowInst = null;
        if (dslMode.equals(DSLMode.VisitorNode)) {
            flowInst = FlowInst4Visitor.builder(tFlowInst.getId(), flow, taskSet, facts, tTaskInstService, tTaskRuleService);
        } else {
            flowInst = FlowInst4Listener.builder(tFlowInst.getId(), flow, taskSet, facts, taskInsts, tTaskInstService, tTaskRuleService);
        }

        // Run
        Integer flowInstRet = flowInst.run();

        tFlowInst.setRet(flowInstRet);
        tFlowInst.setFacts(flowInst.getFacts().toString());
        tFlowInstService.updateIgnoreNull(tFlowInst);
    }

}
