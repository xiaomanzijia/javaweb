package com.lsgx.admin.model.vo;

import com.lsgx.admin.model.Category;

public class CategoryVO extends Category{

	/**
	 * 
	 */
	private static final long serialVersionUID = 455191458528046112L;
	
	public final static int PAGE_SHOW_COUNT = 20;
    
    private int pageNum = 1;
    
    private int numPerPage = 0;
    
    private String configIds;
    

	public String getConfigIds() {
		return configIds;
	}

	public void setConfigIds(String configIds) {
		this.configIds = configIds;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
    
    

}
