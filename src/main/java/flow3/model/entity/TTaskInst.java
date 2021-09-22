package flow3.model.entity;

import java.util.Date;

/**
 * 任务实例表
 */
public class TTaskInst {
	/** 规则ID */
	private Integer id;
	/** 流程ID */
	private Integer flowId;
	/** 任务ID */
	private Integer taskId;
	/** 执行结果：0-未执行完;1-成功; >1-错误(码) */
	private Integer ret;
	/** 创建时间 */
	private Date createdAt;
	/** 最后更新时间 */
	private Date updatedAt;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
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
	
	public void setRet(Integer ret) {
		this.ret = ret;
	}
	
	public Integer getRet() {
		return this.ret;
	}
	
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
        TTaskInst that = (TTaskInst) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "TTaskInst{" +
				"id=" + id +
						",flowId='" + flowId + "'" + 
						",taskId='" + taskId + "'" + 
						",ret='" + ret + "'" + 
						",createdAt='" + createdAt + "'" + 
						",updatedAt='" + updatedAt + "'" + 
		                '}';
    }
	
}