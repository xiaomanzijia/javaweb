package com.lsgx.admin.model.vo;

import com.lsgx.admin.model.Config;

public class ConfigQueryVO extends Config{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
