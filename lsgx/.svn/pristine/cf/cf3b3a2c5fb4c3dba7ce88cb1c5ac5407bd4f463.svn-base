package com.lsgx.admin.model;

import java.io.Serializable;
import java.util.List;

public class ActionFunction implements Serializable{

	private static final long serialVersionUID = 5072137330111125781L;
	
	private Integer id;
	private String funName;
	private String action;
	private Integer displayMode;
	private Integer parentFun;
	private String code;
	private String rel;
	private String target;
    
    private List<ActionFunction> actionFunctionlist;

    /** 父菜单,用于页面展示,不保存数据库*/
    private String parentName;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFunName() {
		return funName;
	}
	public void setFunName(String funName) {
		this.funName = funName;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Integer getDisplayMode() {
		return displayMode;
	}
	public void setDisplayMode(Integer displayMode) {
		this.displayMode = displayMode;
	}
	public Integer getParentFun() {
		return parentFun;
	}
	public void setParentFun(Integer parentFun) {
		this.parentFun = parentFun;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	
	@Override
	public String toString() {
		return "ActionFunction [id=" + id + ", funName=" + funName
				+ ", action=" + action + ", displayMode=" + displayMode
				+ ", parentFun=" + parentFun + ", code=" + code + ", rel="
				+ rel + ", target=" + target + "]";
	}
    public List<ActionFunction> getActionFunctionlist()
    {
        return actionFunctionlist;
    }
    public void setActionFunctionlist(List<ActionFunction> actionFunctionlist)
    {
        this.actionFunctionlist = actionFunctionlist;
    }
    
    public String getParentName()
    {
        return parentName;
    }
    
    public void setParentName(String parentName)
    {
        this.parentName = parentName;
    }
	
	
	
}
