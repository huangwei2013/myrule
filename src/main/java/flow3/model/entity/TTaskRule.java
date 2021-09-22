package flow3.model.entity;

import java.util.Date;

/**
 * 任务规则表
 */
public class TTaskRule {
	/** 规则ID */
	private Integer id;
	/** 任务ID */
	private Integer taskId;
	/** 规则内容 */
	private String content;
	/** 操作执行状态, 1-无效;2-有效 */
	private Byte status;
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
	
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	
	public Integer getTaskId() {
		return this.taskId;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setStatus(Byte status) {
		this.status = status;
	}
	
	public Byte getStatus() {
		return this.status;
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
        TTaskRule that = (TTaskRule) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "TTaskRule{" +
				"id=" + id +
						",taskId='" + taskId + "'" + 
						",content='" + content + "'" + 
						",status='" + status + "'" + 
						",createdAt='" + createdAt + "'" + 
						",updatedAt='" + updatedAt + "'" + 
		                '}';
    }
	
}