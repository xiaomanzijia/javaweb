package com.lsgx.admin.model.vo;

import java.io.Serializable;
import java.util.Date;

import com.lsgx.admin.model.SystemNotify;

public class SystemNotifyVO extends SystemNotify implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6070810829941028218L;
    public final static int PAGE_SHOW_COUNT = 20;
    
    private int pageNum = 1;
    
    private int numPerPage = 0;
    
    /**
     * 前台用户名
     * */
    private String userName;
    
    /**
     * 批量发送时的用户ids
     * */
    private String userIds;
    
    /**
     * 内容的一部分
     * */
    private String contentShort;
    
    /**
     * 开始时间 查询时用
     * */
    private Date startDate;
    
    /**
     * 截止时间  查询时用
     * */
    private Date endDate;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNumPerPage() {
		 return numPerPage > 0 ? numPerPage : PAGE_SHOW_COUNT;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	public String getContentShort() {
		return contentShort;
	}

	public void setContentShort(String contentShort) {
		this.contentShort = contentShort;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
    
    
    
    

}
