package com.lsgx.admin.model.vo;

import java.util.Date;

import com.lsgx.admin.model.News;

public class NewsVO extends News {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5202797713528275056L;
	
	public final static int PAGE_SHOW_COUNT = 20;
	
    private int pageNum = 1;
    
    private int numPerPage = 0;
    
    /**
     * 标题缩写
     * */
    private String titleShort;
    
    /**
     * 摘要缩写
     * */
    private String abstractsShort;
    
    /**
	 * 关键字缩写
	 */
	private String keywordsShort;
	
	/**
	 * 内容缩写
	 */
	private String contentShort;
    
    /**
     * 开始时间 查询时用
     * */
    private Date startDate;
    
    /**
     * 截止时间  查询时用
     * */
    
    private Date endDate;
    
    public String getTitleShort() {
		return titleShort;
	}


	public void setTitleShort(String titleShort) {
		this.titleShort = titleShort;
	}


	public String getAbstractsShort() {
		return abstractsShort;
	}


	public void setAbstractsShort(String abstractsShort) {
		this.abstractsShort = abstractsShort;
	}


	public String getKeywordsShort() {
		return keywordsShort;
	}


	public void setKeywordsShort(String keywordsShort) {
		this.keywordsShort = keywordsShort;
	}


	public String getContentShort() {
		return contentShort;
	}

	public void setContentShort(String contentShort) {
		this.contentShort = contentShort;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getStartDate(){
    	return startDate;
    }


		public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

    public int getNumPerPage()
    {
        return numPerPage > 0 ? numPerPage : PAGE_SHOW_COUNT;
    }

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

}
