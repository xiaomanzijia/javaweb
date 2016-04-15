package com.lsgx.admin.model.vo;

import java.util.Date;

import com.lsgx.admin.model.LeaveWord;

public class LeaveWordVO extends LeaveWord
{
    /**
     * 
     */
    private static final long serialVersionUID = 8465106458383498893L;

    public final static int PAGE_SHOW_COUNT = 20;
    
    private int pageNum = 1;
    
    private int numPerPage = 0;
    
    private String orderField;
    
    private String orderDirection;
    
    private Date startDate;
    
    private Date endDate;
    
    public int getPageNum()
    {
        return pageNum;
    }
    
    public void setPageNum(int pageNum)
    {
        this.pageNum = pageNum;
    }
    
    public int getNumPerPage()
    {
        return numPerPage > 0 ? numPerPage : PAGE_SHOW_COUNT;
    }
    
    public void setNumPerPage(int numPerPage)
    {
        this.numPerPage = numPerPage;
    }
    
    public String getOrderField()
    {
        return orderField;
    }
    
    public void setOrderField(String orderField)
    {
        this.orderField = orderField;
    }
    
    public String getOrderDirection()
    {
        return orderDirection;
    }
    
    public void setOrderDirection(String orderDirection)
    {
        this.orderDirection = orderDirection;
    }
    
    public Date getStartDate()
    {
        return startDate;
    }
    
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }
    
    public Date getEndDate()
    {
        return endDate;
    }
    
    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }
}
