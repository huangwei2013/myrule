package flow3.model.entity;

import java.util.Date;

/**
 * 流程表
 */
public class TFlow {
	/** 流程ID */
	private Integer id;
	/** 流程名称 */
	private String name;
	/** 流程名称，显示用 */
	private String alias;
	/** 流程说明 */
	private String note;
	/** 资源，版本必须递增 */
	private Integer version;
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
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getNote() {
		return this.note;
	}
	
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public Integer getVersion() {
		return this.version;
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
        TFlow that = (TFlow) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "TFlow{" +
				"id=" + id +
						",name='" + name + "'" + 
						",alias='" + alias + "'" + 
						",note='" + note + "'" + 
						",version='" + version + "'" + 
						",status='" + status + "'" + 
						",createdAt='" + createdAt + "'" + 
						",updatedAt='" + updatedAt + "'" + 
		                '}';
    }
	
}