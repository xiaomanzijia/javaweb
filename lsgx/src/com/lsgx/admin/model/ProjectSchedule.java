package com.lsgx.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目进度表
 * @author phx
 *
 */

public class ProjectSchedule implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7103279192947980526L;
	private Integer id;
	private Integer projectId;
	private Integer operator;
	private Integer state;
	private Date operatorTime;
	private String description;
    
    private String descriptionShort;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getOperator() {
		return operator;
	}
	public void setOperator(Integer operator) {
		this.operator = operator;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Date getOperatorTime() {
		return operatorTime;
	}
	public void setOperatorTime(Date operatorTime) {
		this.operatorTime = operatorTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ProjectSchedule [id=" + id + ", projectId=" + projectId
				+ ", operator=" + operator + ", state=" + state
				+ ", operatorTime=" + operatorTime + ", description="
				+ description + "]";
	}
    
    public String getDescriptionShort()
    {
        return descriptionShort;
    }
    
    public void setDescriptionShort(String descriptionShort)
    {
        this.descriptionShort = descriptionShort;
    }
	
	
}
