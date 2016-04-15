package com.lsgx.admin.model.vo;

import com.lsgx.admin.model.ProjectUserInfo;

public class ProjectUserInfoVO extends ProjectUserInfo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6013017731427642447L;
	
	public final static int PAGE_SHOW_COUNT = 20;
	private int pageNum = 1;
	private int numPerPage = 0;
	
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
	
}
