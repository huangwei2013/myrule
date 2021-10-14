package flow3.entity;

import java.util.HashMap;
import java.util.Map;

public class FlowTask {

    Integer flowId;
    Integer taskId;
    Integer taskType;
    Integer nextTaskId;
    String preCondition;

    Map<Rule, Integer> nextTasksByRule; //  when this task done, find nexts by Rule => TaskId

    public FlowTask(Integer flowId, Integer taskId, Integer taskType, String preCondition){
        this.flowId = flowId;
        this.taskId = taskId;
        this.taskType = taskType;
        this.preCondition = preCondition;
        this.nextTaskId = 0;

        this.nextTasksByRule = new HashMap<Rule, Integer>(); // db operation
    }


    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Integer getNextTaskId() {
        return nextTaskId;
    }

    public void setNextTaskId(Integer nextTaskId) {
        this.nextTaskId = nextTaskId;
    }

    public String getPreCondition() {
        return preCondition;
    }

    public void setPreCondition(String preCondition) {
        this.preCondition = preCondition;
    }

    public Map<Rule, Integer> getNextTasksByRule() {
        return nextTasksByRule;
    }

    public void setNextTasksByRule(Map<Rule, Integer> nextTasksByRule) {
        this.nextTasksByRule = nextTasksByRule;
    }

}
