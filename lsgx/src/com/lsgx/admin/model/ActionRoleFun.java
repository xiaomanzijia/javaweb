package com.lsgx.admin.model;

import java.io.Serializable;

public class ActionRoleFun implements Serializable{

	
	private static final long serialVersionUID = -8641093611141933890L;
	
	private Integer id;
	private Integer roleId;
	private Integer funId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getFunId() {
		return funId;
	}
	public void setFunId(Integer funId) {
		this.funId = funId;
	}
	
	@Override
	public String toString() {
		return "ActionRoleFun [id=" + id + ", roleId=" + roleId + ", funId="
				+ funId + "]";
	}
	
	
}
