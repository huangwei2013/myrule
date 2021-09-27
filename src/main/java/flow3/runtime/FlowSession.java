package flow3.runtime;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import flow3.entity.Flow;
import flow3.entity.FlowTask;
import flow3.entity.Rule;
import flow3.model.entity.TFlow;
import flow3.model.entity.TFlowInst;
import flow3.model.entity.TFlowTask;
import flow3.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public void run(){
        Integer flowId = 1;

        Flow flow = new Flow();
        TFlow tflow = tFlowService.getById(flowId);
        flow.setFlowId(tflow.getId());
        flow.setAlias(tflow.getAlias());
        flow.setNote(tflow.getNote());
        flow.setVersion(tflow.getVersion());

        Map<Integer, FlowTask> taskSet = new HashMap<Integer, FlowTask>();
        List<TFlowTask> tFlowTasks = tFlowTaskService.getByFlowId(flowId);
        for(int i = 0 ; i < tFlowTasks.size(); i++){
            TFlowTask tFlowTask = tFlowTasks.get(i);
            FlowTask flowTask = new FlowTask(tFlowTask.getFlowId(), tFlowTask.getTaskId(), tFlowTask.getType(), tFlowTask.getPre());

            if (tFlowTask.getNext() != null && !tFlowTask.getNext().isEmpty()) {
                String str = tFlowTask.getNext();
                //Map<String, Integer> tempMap  = new Gson().fromJson("{'s==11.0;':1}", Map.class);// 不能有转义符
                //Map<String, Integer> tempMap  = new Gson().fromJson(str, Map.class);// 不能有转义符
                Map<String, Integer> tempMap  = new Gson().fromJson(str, new TypeToken<HashMap<String, Integer>>(){}.getType());// 不能有转义符
                Map<Rule, Integer> nextTaskByRulesMap = new HashMap<>();
                for(String ruleStr : tempMap.keySet()){ // NOTE：有点曲折，定义的数据结构该改
                    Rule rule = new Rule();
                    rule.setContent(ruleStr);
                    nextTaskByRulesMap.put(rule, (Integer) tempMap.get(ruleStr));
                }
                flowTask.setNextTasksByRule(nextTaskByRulesMap);
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

        FlowInst flowInst = new FlowInst(tFlowInst.getId(), flow, taskSet, facts, tTaskInstService, tTaskRuleService);

        // Run
        Integer flowInstRet = flowInst.run();

        tFlowInst.setRet(flowInstRet);
        tFlowInst.setFacts(flowInst.getFacts().toString());
        tFlowInstService.updateIgnoreNull(tFlowInst);

    }

}
