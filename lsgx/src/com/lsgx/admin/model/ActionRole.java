package com.lsgx.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色
 * @author phx
 *
 */
public class ActionRole implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7411066584683946958L;
	
	private Integer id;
	private String roleName;
	private Integer isAdmin;
	private Date createTime;
	private String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ActionRole [id=" + id + ", roleName=" + roleName + ", isAdmin="
				+ isAdmin + ", createTime=" + createTime + ", description="
				+ description + "]";
	}
	
	
}
