package flow3.model.entity;

import java.util.Date;

/**
 * 流程任务关系表
 */
public class TFlowTask {
	/** 流程ID */
	private Integer flowId;
	/** 任务ID */
	private Integer taskId;
	/** 任务类型，{startTask, commonTask} */
	private Integer type;
	/** 下一个task的跳转规则 */
	private String next;
	/** 本task开启的前提，为前置节点执行+结果之间逻辑表达式 */
	private String pre;
	/** 创建时间 */
	private Date createdAt;
	/** 最后更新时间 */
	private Date updatedAt;

	public void setFlowId(Integer flowId) {
		this.flowId = flowId;
	}
	
	public Integer getFlowId() {
		return this.flowId;
	}
	
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	
	public Integer getTaskId() {
		return this.taskId;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getType() {
		return this.type;
	}
	
	public void setNext(String next) {
		this.next = next;
	}
	
	public String getNext() {
		return this.next;
	}

	public String getPre() { return pre; }

	public void setPre(String pre) { this.pre = pre; }
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Date getCreatedAt() {
		return this.createdAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Date getUpdatedAt() {
		return this.updatedAt;
	}
	

	@Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) {return false;}
        TFlowTask that = (TFlowTask) o;
        return flowId.equals(that.flowId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(flowId);
    }
    
    @Override
    public String toString() {
        return "TFlowTask{" +
				"flowId=" + flowId +
						",taskId='" + taskId + "'" + 
						",type='" + type + "'" + 
						",next='" + next + "'" + 
						",createdAt='" + createdAt + "'" + 
						",updatedAt='" + updatedAt + "'" + 
		                '}';
    }
	
}