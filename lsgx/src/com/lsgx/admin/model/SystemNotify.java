package com.lsgx.admin.model;

import java.io.Serializable;
import java.util.Date;

public class SystemNotify extends BaseBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7063403354292594556L;

	private Integer id;
	
	/**
	 * FrontUser中的用户id
	*/
	private Integer userid;
	/**
	 * 发件人
	*/
	private String sender;
	/**
	 * 主题
	*/
	private String subject;
	/**
	 * 内容
	*/
	private String content;
	/**
	 * 状态  0：未读 1：已读
	*/
	private Integer state;
	/**
	 * 是否在前台显示 0：不显示 1：显示
	*/
	private Integer isShow;
	
	/**
	 * 发件时间
	*/
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
